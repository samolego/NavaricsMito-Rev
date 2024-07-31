package cn.bingoogolapple.qrcode.core;

import android.content.Context;
import android.graphics.Point;
import android.graphics.Rect;
import android.hardware.Camera;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import java.util.Collections;

/* loaded from: classes.dex */
public class CameraPreview extends SurfaceView implements SurfaceHolder.Callback {

    /* renamed from: a */
    private Camera f153a;

    /* renamed from: b */
    private boolean f154b;

    /* renamed from: c */
    private boolean f155c;

    /* renamed from: d */
    private boolean f156d;

    /* renamed from: e */
    private float f157e;

    /* renamed from: f */
    private CameraConfigurationManager f158f;

    public CameraPreview(Context context) {
        super(context);
        this.f154b = true;
        this.f155c = false;
        this.f156d = false;
        this.f157e = 1.0f;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setCamera(Camera camera) {
        this.f153a = camera;
        if (this.f153a != null) {
            this.f158f = new CameraConfigurationManager(getContext());
            this.f158f.m12711a(this.f153a);
            getHolder().addCallback(this);
            if (this.f154b) {
                requestLayout();
            } else {
                m12777e();
            }
        }
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        this.f155c = true;
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
        if (surfaceHolder.getSurface() == null) {
            return;
        }
        m12788a();
        m12777e();
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        this.f155c = false;
        m12788a();
    }

    /* renamed from: e */
    private void m12777e() {
        post(new Runnable() { // from class: cn.bingoogolapple.qrcode.core.CameraPreview.1
            @Override // java.lang.Runnable
            public void run() {
                if (CameraPreview.this.f153a != null) {
                    try {
                        CameraPreview.this.f154b = true;
                        SurfaceHolder holder = CameraPreview.this.getHolder();
                        holder.setKeepScreenOn(true);
                        CameraPreview.this.f153a.setPreviewDisplay(holder);
                        CameraPreview.this.f158f.m12704b(CameraPreview.this.f153a);
                        CameraPreview.this.f153a.startPreview();
                        CameraPreview.this.m12775g();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public void m12788a() {
        Camera camera = this.f153a;
        if (camera != null) {
            try {
                this.f154b = false;
                camera.cancelAutoFocus();
                this.f153a.setOneShotPreviewCallback(null);
                this.f153a.stopPreview();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: b */
    public void m12782b() {
        if (m12776f()) {
            this.f158f.m12703c(this.f153a);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: c */
    public void m12780c() {
        if (m12776f()) {
            this.f158f.m12702d(this.f153a);
        }
    }

    /* renamed from: f */
    private boolean m12776f() {
        return m12778d() && getContext().getPackageManager().hasSystemFeature("android.hardware.camera.flash");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public void m12786a(Rect rect) {
        if (this.f153a == null || rect == null || rect.left <= 0 || rect.top <= 0) {
            return;
        }
        int centerX = rect.centerX();
        int centerY = rect.centerY();
        int width = rect.width() / 2;
        int height = rect.height() / 2;
        BGAQRCodeUtil.m12722a("转换前", rect);
        if (BGAQRCodeUtil.m12727a(getContext())) {
            centerY = centerX;
            centerX = centerY;
            height = width;
            width = height;
        }
        Rect rect2 = new Rect(centerX - width, centerY - height, centerX + width, centerY + height);
        BGAQRCodeUtil.m12722a("转换后", rect2);
        BGAQRCodeUtil.m12723a("扫码框发生变化触发对焦测光");
        m12787a(rect2.centerX(), rect2.centerY(), rect2.width(), rect2.height());
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!m12778d()) {
            return super.onTouchEvent(motionEvent);
        }
        if (motionEvent.getPointerCount() == 1 && (motionEvent.getAction() & 255) == 1) {
            if (this.f156d) {
                return true;
            }
            this.f156d = true;
            BGAQRCodeUtil.m12723a("手指触摸触发对焦测光");
            float x = motionEvent.getX();
            float y = motionEvent.getY();
            if (BGAQRCodeUtil.m12727a(getContext())) {
                y = x;
                x = y;
            }
            int m12726a = BGAQRCodeUtil.m12726a(getContext(), 120.0f);
            m12787a(x, y, m12726a, m12726a);
        }
        if (motionEvent.getPointerCount() == 2) {
            int action = motionEvent.getAction() & 255;
            if (action == 2) {
                float m12724a = BGAQRCodeUtil.m12724a(motionEvent);
                float f = this.f157e;
                if (m12724a > f) {
                    m12783a(true, this.f153a);
                } else if (m12724a < f) {
                    m12783a(false, this.f153a);
                }
            } else if (action == 5) {
                this.f157e = BGAQRCodeUtil.m12724a(motionEvent);
            }
        }
        return true;
    }

    /* renamed from: a */
    private static void m12783a(boolean z, Camera camera) {
        Camera.Parameters parameters = camera.getParameters();
        if (parameters.isZoomSupported()) {
            int zoom = parameters.getZoom();
            if (z && zoom < parameters.getMaxZoom()) {
                BGAQRCodeUtil.m12723a("放大");
                zoom++;
            } else if (!z && zoom > 0) {
                BGAQRCodeUtil.m12723a("缩小");
                zoom--;
            } else {
                BGAQRCodeUtil.m12723a("既不放大也不缩小");
            }
            parameters.setZoom(zoom);
            camera.setParameters(parameters);
            return;
        }
        BGAQRCodeUtil.m12723a("不支持缩放");
    }

    /* renamed from: a */
    private void m12787a(float f, float f2, int i, int i2) {
        boolean z;
        try {
            Camera.Parameters parameters = this.f153a.getParameters();
            Camera.Size previewSize = parameters.getPreviewSize();
            if (parameters.getMaxNumFocusAreas() > 0) {
                BGAQRCodeUtil.m12723a("支持设置对焦区域");
                Rect m12729a = BGAQRCodeUtil.m12729a(1.0f, f, f2, i, i2, previewSize.width, previewSize.height);
                BGAQRCodeUtil.m12722a("对焦区域", m12729a);
                parameters.setFocusAreas(Collections.singletonList(new Camera.Area(m12729a, 1000)));
                parameters.setFocusMode("macro");
                z = true;
            } else {
                BGAQRCodeUtil.m12723a("不支持设置对焦区域");
                z = false;
            }
            if (parameters.getMaxNumMeteringAreas() > 0) {
                BGAQRCodeUtil.m12723a("支持设置测光区域");
                Rect m12729a2 = BGAQRCodeUtil.m12729a(1.5f, f, f2, i, i2, previewSize.width, previewSize.height);
                BGAQRCodeUtil.m12722a("测光区域", m12729a2);
                parameters.setMeteringAreas(Collections.singletonList(new Camera.Area(m12729a2, 1000)));
                z = true;
            } else {
                BGAQRCodeUtil.m12723a("不支持设置测光区域");
            }
            if (z) {
                this.f153a.cancelAutoFocus();
                this.f153a.setParameters(parameters);
                this.f153a.autoFocus(new Camera.AutoFocusCallback() { // from class: cn.bingoogolapple.qrcode.core.CameraPreview.2
                    @Override // android.hardware.Camera.AutoFocusCallback
                    public void onAutoFocus(boolean z2, Camera camera) {
                        if (z2) {
                            BGAQRCodeUtil.m12723a("对焦测光成功");
                        } else {
                            BGAQRCodeUtil.m12717b("对焦测光失败");
                        }
                        CameraPreview.this.m12775g();
                    }
                });
                return;
            }
            this.f156d = false;
        } catch (Exception e) {
            e.printStackTrace();
            BGAQRCodeUtil.m12717b("对焦测光失败：" + e.getMessage());
            m12775g();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: g */
    public void m12775g() {
        this.f156d = false;
        Camera camera = this.f153a;
        if (camera == null) {
            return;
        }
        try {
            Camera.Parameters parameters = camera.getParameters();
            parameters.setFocusMode("continuous-picture");
            this.f153a.setParameters(parameters);
            this.f153a.cancelAutoFocus();
        } catch (Exception unused) {
            BGAQRCodeUtil.m12717b("连续对焦失败");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: d */
    public boolean m12778d() {
        return this.f153a != null && this.f154b && this.f155c;
    }

    @Override // android.view.SurfaceView, android.view.View
    public void onMeasure(int i, int i2) {
        int defaultSize = getDefaultSize(getSuggestedMinimumWidth(), i);
        int defaultSize2 = getDefaultSize(getSuggestedMinimumHeight(), i2);
        CameraConfigurationManager cameraConfigurationManager = this.f158f;
        if (cameraConfigurationManager != null && cameraConfigurationManager.m12714a() != null) {
            Point m12714a = this.f158f.m12714a();
            float f = defaultSize;
            float f2 = defaultSize2;
            float f3 = m12714a.x;
            float f4 = m12714a.y;
            float f5 = (f3 * 1.0f) / f4;
            if ((f * 1.0f) / f2 < f5) {
                defaultSize = (int) ((f2 / ((f4 * 1.0f) / f3)) + 0.5f);
            } else {
                defaultSize2 = (int) ((f / f5) + 0.5f);
            }
        }
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(defaultSize, 1073741824), View.MeasureSpec.makeMeasureSpec(defaultSize2, 1073741824));
    }
}
