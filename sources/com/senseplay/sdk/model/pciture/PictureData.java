package com.senseplay.sdk.model.pciture;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.provider.MediaStore;
import com.senseplay.sdk.log.SPDebug;
import com.senseplay.sdk.model.pciture.PictureDialog;
import com.senseplay.sdk.view.SPWebView;
import java.io.File;

/* loaded from: classes2.dex */
public class PictureData {
    public static final int PHOTO_REQUEST_CUT = 3;
    public static final int REQUEST_CHOOSE_PICTURE = 2;
    public static final int REQUEST_CODE_PERMISSION = 10;
    public static final int REQUEST_TAKE_PHOTO = 1;
    private Activity activity;
    Uri cropUri = null;
    private File tempFile;
    private SPWebView.UploadListener uploadListener;

    public PictureData(Activity activity) {
        this.activity = activity;
    }

    public void setUploadListener(SPWebView.UploadListener uploadListener) {
        this.uploadListener = uploadListener;
    }

    public void showDialog() {
        PictureDialog pictureDialog = new PictureDialog(this.activity);
        pictureDialog.setPictureListener(new PictureDialog.PictureListener() { // from class: com.senseplay.sdk.model.pciture.PictureData.1
            @Override // com.senseplay.sdk.model.pciture.PictureDialog.PictureListener
            public void takePicture() {
                Intent intent = new Intent("android.intent.action.PICK");
                intent.setDataAndType(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, "image/*");
                PictureData.this.activity.startActivityForResult(intent, 2);
            }

            @Override // com.senseplay.sdk.model.pciture.PictureDialog.PictureListener
            public void takePhoto() {
                Intent intent = new Intent();
                if (Build.VERSION.SDK_INT >= 24) {
                    intent.addFlags(1);
                }
                intent.setAction("android.media.action.IMAGE_CAPTURE");
                PictureData pictureData = PictureData.this;
                pictureData.cropUri = pictureData.getUri(pictureData.getFile());
                intent.putExtra("output", PictureData.this.cropUri);
                SPDebug.m5816d("uri: " + PictureData.this.cropUri);
                intent.putExtra("output", PictureData.this.cropUri);
                PictureData.this.activity.startActivityForResult(intent, 1);
            }

            @Override // com.senseplay.sdk.model.pciture.PictureDialog.PictureListener
            public void clear() {
                if (PictureData.this.uploadListener != null) {
                    PictureData.this.uploadListener.clear();
                }
            }
        });
        pictureDialog.show();
    }

    private void startPhotoZoom(Uri uri) {
        SPDebug.m5816d("uri: " + uri);
        Intent intent = new Intent();
        intent.setAction("com.android.camera.action.CROP");
        intent.setDataAndType(uri, "image/*");
        if (Build.VERSION.SDK_INT >= 24) {
            intent.putExtra("noFaceDetection", false);
            intent.addFlags(1);
            intent.addFlags(2);
        }
        intent.putExtra("crop", "true");
        intent.putExtra("aspectX", 1);
        intent.putExtra("aspectY", 1);
        intent.putExtra("outputX", 100);
        intent.putExtra("outputY", 100);
        intent.putExtra("return-data", false);
        intent.putExtra("circleCrop", false);
        this.cropUri = getCropUri();
        intent.putExtra("output", this.cropUri);
        intent.putExtra("outputFormat", Bitmap.CompressFormat.JPEG.toString());
        this.activity.startActivityForResult(intent, 3);
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        switch (i) {
            case 1:
                startPhotoZoom(getCropUri());
                return;
            case 2:
                if (intent != null) {
                    startPhotoZoom(intent.getData());
                    return;
                }
                return;
            default:
                return;
        }
    }

    public Uri getCropUri() {
        if (this.cropUri == null) {
            this.cropUri = getUri(getCropFile());
        }
        return this.cropUri;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Uri getUri(File file) {
        return Uri.fromFile(file);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public File getFile() {
        return new File(Environment.getExternalStorageDirectory().getAbsolutePath() + "/tempcrop.png");
    }

    private File getCropFile() {
        File file = new File(Environment.getExternalStorageDirectory().getAbsolutePath() + "/tempcrop.png");
        if (file.isFile() && file.exists()) {
            file.delete();
        }
        return file;
    }
}
