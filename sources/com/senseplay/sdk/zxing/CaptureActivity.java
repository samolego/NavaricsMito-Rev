package com.senseplay.sdk.zxing;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Handler;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.Log;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.BinaryBitmap;
import com.google.zxing.ChecksumException;
import com.google.zxing.DecodeHintType;
import com.google.zxing.FormatException;
import com.google.zxing.NotFoundException;
import com.google.zxing.RGBLuminanceSource;
import com.google.zxing.Result;
import com.google.zxing.common.HybridBinarizer;
import com.google.zxing.qrcode.QRCodeReader;
import com.senseplay.sdk.C2189R;
import com.senseplay.sdk.zxing.camera.CameraManager;
import com.senseplay.sdk.zxing.decode.CaptureActivityHandler;
import com.senseplay.sdk.zxing.decode.DecodeFormatManager;
import com.senseplay.sdk.zxing.utils.BeepManager;
import com.senseplay.sdk.zxing.utils.InactivityTimer;
import com.senseplay.sdk.zxing.utils.PermissionsUtil;
import java.io.IOException;
import java.util.Collection;
import java.util.EnumSet;
import java.util.Hashtable;

/* loaded from: classes2.dex */
public final class CaptureActivity extends Activity implements SurfaceHolder.Callback {
    private static final String TAG = "CaptureActivity";
    private BeepManager beepManager;
    private CameraManager cameraManager;
    private String characterSet;
    private Collection<BarcodeFormat> decodeFormats;
    private CaptureActivityHandler handler;
    private InactivityTimer inactivityTimer;
    private boolean isOpenTorch;
    private TextView mScanLocalPic;
    private TextView mSetTorch;
    private RelativeLayout scanContainer;
    private RelativeLayout scanCropView;
    private ImageView scanLine;
    private String[] permissionArr = {"android.permission.CAMERA"};
    private boolean hasSurface = false;
    private SurfaceView scanPreview = null;
    private Rect mCropRect = null;

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
    }

    public Handler getHandler() {
        return this.handler;
    }

    public CameraManager getCameraManager() {
        return this.cameraManager;
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        PermissionsUtil.getInstance().init(this, this.permissionArr);
        init();
    }

    private void init() {
        initView();
        setClick();
        initData();
    }

    private void initView() {
        getWindow().addFlags(128);
        setContentView(C2189R.layout.activity_capture);
        this.scanPreview = (SurfaceView) findViewById(C2189R.C2191id.capture_preview);
        this.scanContainer = (RelativeLayout) findViewById(C2189R.C2191id.capture_container);
        this.scanCropView = (RelativeLayout) findViewById(C2189R.C2191id.capture_crop_view);
        this.scanLine = (ImageView) findViewById(C2189R.C2191id.capture_scan_line);
        this.mSetTorch = (TextView) findViewById(C2189R.C2191id.btn_open_flashlight);
        this.mScanLocalPic = (TextView) findViewById(C2189R.C2191id.btn_scan_local_pic);
    }

    private void setClick() {
        this.mScanLocalPic.setOnClickListener(new View.OnClickListener() { // from class: com.senseplay.sdk.zxing.CaptureActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                CaptureActivity.this.pickPictureFromAblum(view);
            }
        });
        this.mSetTorch.setOnClickListener(new View.OnClickListener() { // from class: com.senseplay.sdk.zxing.CaptureActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (CaptureActivity.this.isOpenTorch) {
                    CaptureActivity.this.isOpenTorch = false;
                    CaptureActivity.this.mSetTorch.setText("打开手电筒");
                } else {
                    CaptureActivity.this.isOpenTorch = true;
                    CaptureActivity.this.mSetTorch.setText("关闭手电筒");
                }
                CaptureActivity.this.cameraManager.setTorch(CaptureActivity.this.isOpenTorch);
            }
        });
    }

    private void initData() {
        this.inactivityTimer = new InactivityTimer(this);
        this.beepManager = new BeepManager(this);
        TranslateAnimation translateAnimation = new TranslateAnimation(2, 0.0f, 2, 0.0f, 2, 0.0f, 2, 0.9f);
        translateAnimation.setDuration(2000L);
        translateAnimation.setRepeatCount(-1);
        translateAnimation.setRepeatMode(1);
        this.scanLine.startAnimation(translateAnimation);
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        PermissionsUtil.getInstance().onResume(this, this.permissionArr);
        this.cameraManager = new CameraManager(getApplication());
        this.handler = null;
        this.beepManager.updatePrefs();
        this.inactivityTimer.onResume();
        this.decodeFormats = null;
        this.characterSet = null;
        SurfaceHolder holder = this.scanPreview.getHolder();
        if (this.hasSurface) {
            initCamera(holder);
        } else {
            holder.addCallback(this);
        }
    }

    private int getCurrentOrientation() {
        int rotation = getWindowManager().getDefaultDisplay().getRotation();
        if (getResources().getConfiguration().orientation == 2) {
            if (rotation != 0) {
                return rotation == 1 ? 0 : 8;
            }
        } else if (rotation != 0) {
            return rotation == 3 ? 1 : 9;
        }
        return rotation;
    }

    @Override // android.app.Activity
    protected void onPause() {
        CaptureActivityHandler captureActivityHandler = this.handler;
        if (captureActivityHandler != null) {
            captureActivityHandler.quitSynchronously();
            this.handler = null;
        }
        this.inactivityTimer.onPause();
        this.beepManager.close();
        this.cameraManager.closeDriver();
        if (!this.hasSurface) {
            this.scanPreview.getHolder().removeCallback(this);
        }
        super.onPause();
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        this.inactivityTimer.shutdown();
        super.onDestroy();
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        if (surfaceHolder == null) {
            Log.e(TAG, "*** WARNING *** surfaceCreated() gave us a null surface!");
        }
        if (this.hasSurface) {
            return;
        }
        this.hasSurface = true;
        initCamera(surfaceHolder);
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        this.hasSurface = false;
    }

    private void initCamera(SurfaceHolder surfaceHolder) {
        if (surfaceHolder == null) {
            throw new IllegalStateException("No SurfaceHolder provided");
        }
        if (this.cameraManager.isOpen()) {
            Log.w(TAG, "initCamera() while already open -- late SurfaceView callback?");
            return;
        }
        try {
            this.cameraManager.openDriver(surfaceHolder);
            if (this.handler == null) {
                this.handler = new CaptureActivityHandler(this, this.decodeFormats, this.characterSet, this.cameraManager);
            }
            initCrop();
        } catch (IOException e) {
            Log.w(TAG, e);
        } catch (RuntimeException e2) {
            Log.w(TAG, "Unexpected error initializing camera", e2);
        }
    }

    private void initCrop() {
        int i = this.cameraManager.getBestPreviewSize().y;
        int i2 = this.cameraManager.getBestPreviewSize().x;
        int[] iArr = new int[2];
        this.scanCropView.getLocationInWindow(iArr);
        int i3 = iArr[0];
        int statusBarHeight = iArr[1] - getStatusBarHeight();
        int width = this.scanCropView.getWidth();
        int height = this.scanCropView.getHeight();
        int width2 = this.scanContainer.getWidth();
        int height2 = this.scanContainer.getHeight();
        int i4 = (i3 * i) / width2;
        int i5 = (statusBarHeight * i2) / height2;
        this.mCropRect = new Rect(i4, i5, ((width * i) / width2) + i4, ((height * i2) / height2) + i5);
    }

    public Rect getCropRect() {
        return this.mCropRect;
    }

    private int getStatusBarHeight() {
        try {
            Rect rect = new Rect();
            getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
            return rect.top;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    public void pickPictureFromAblum(View view) {
        startActivityForResult(new Intent("android.intent.action.PICK", MediaStore.Images.Media.EXTERNAL_CONTENT_URI), 1);
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        if (i2 == -1 && i == 1) {
            String[] strArr = {"_data"};
            Cursor query = getContentResolver().query(intent.getData(), strArr, null, null, null);
            query.moveToFirst();
            String string = query.getString(query.getColumnIndex(strArr[0]));
            query.close();
            Result scanImageQR = scanImageQR(string);
            if (scanImageQR == null) {
                Toast.makeText(getApplicationContext(), "扫描失败!", 1).show();
            } else {
                handleDecode(scanImageQR);
            }
        }
        super.onActivityResult(i, i2, intent);
    }

    private Result scanImageQR(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        EnumSet noneOf = EnumSet.noneOf(BarcodeFormat.class);
        noneOf.addAll(DecodeFormatManager.PRODUCT_FORMATS);
        noneOf.addAll(DecodeFormatManager.INDUSTRIAL_FORMATS);
        noneOf.addAll(DecodeFormatManager.QR_CODE_FORMATS);
        noneOf.addAll(DecodeFormatManager.DATA_MATRIX_FORMATS);
        noneOf.addAll(DecodeFormatManager.AZTEC_FORMATS);
        noneOf.addAll(DecodeFormatManager.PDF417_FORMATS);
        Hashtable hashtable = new Hashtable();
        hashtable.put(DecodeHintType.CHARACTER_SET, "utf-8");
        hashtable.put(DecodeHintType.POSSIBLE_FORMATS, noneOf);
        Bitmap decodeFile = BitmapFactory.decodeFile(str);
        int width = decodeFile.getWidth();
        int height = decodeFile.getHeight();
        int[] iArr = new int[width * height];
        decodeFile.getPixels(iArr, 0, width, 0, 0, width, height);
        try {
            return new QRCodeReader().decode(new BinaryBitmap(new HybridBinarizer(new RGBLuminanceSource(width, height, iArr))), hashtable);
        } catch (ChecksumException e) {
            Toast.makeText(this, "扫描失败 , " + e.getMessage(), 1).show();
            e.printStackTrace();
            return null;
        } catch (FormatException e2) {
            Toast.makeText(this, "扫描失败 , " + e2.getMessage(), 1).show();
            e2.printStackTrace();
            return null;
        } catch (NotFoundException e3) {
            Toast.makeText(this, "扫描失败 , " + e3.getMessage(), 1).show();
            e3.printStackTrace();
            return null;
        }
    }

    public void handleDecode(Result result) {
        this.inactivityTimer.onActivity();
        this.beepManager.playBeepSoundAndVibrate();
        this.inactivityTimer.onActivity();
        this.beepManager.playBeepSoundAndVibrate();
        if (SPZxing.callBack != null) {
            SPZxing.callBack.onZxingResult(result.getText());
        }
        finish();
    }

    private void displayFrameworkBugMessageAndExit() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(getString(C2189R.string.app_name));
        builder.setMessage("Camera error,请确认是否开启相机权限");
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() { // from class: com.senseplay.sdk.zxing.CaptureActivity.3
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                CaptureActivity.this.finish();
            }
        });
        builder.setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: com.senseplay.sdk.zxing.CaptureActivity.4
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                CaptureActivity.this.finish();
            }
        });
        builder.show();
    }

    @Override // android.app.Activity
    public void onRequestPermissionsResult(int i, @NonNull String[] strArr, @NonNull int[] iArr) {
        super.onRequestPermissionsResult(i, strArr, iArr);
        PermissionsUtil.getInstance().onRequestPermissionResult(this, i, strArr, iArr);
    }
}
