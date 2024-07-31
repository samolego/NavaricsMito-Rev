package cn.bingoogolapple.qrcode.core;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PointF;
import android.graphics.Rect;
import android.hardware.Camera;
import android.os.AsyncTask;
import android.os.Handler;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.RelativeLayout;

/* loaded from: classes.dex */
public abstract class QRCodeView extends RelativeLayout implements Camera.PreviewCallback {

    /* renamed from: q */
    private static final long[] f161q = {255, 255, 255, 255};

    /* renamed from: a */
    protected Camera f162a;

    /* renamed from: b */
    protected CameraPreview f163b;

    /* renamed from: c */
    protected ScanBoxView f164c;

    /* renamed from: d */
    protected InterfaceC0577a f165d;

    /* renamed from: e */
    protected Handler f166e;

    /* renamed from: f */
    protected boolean f167f;

    /* renamed from: g */
    protected ProcessDataTask f168g;

    /* renamed from: h */
    protected int f169h;

    /* renamed from: i */
    protected BarcodeType f170i;

    /* renamed from: j */
    private PointF[] f171j;

    /* renamed from: k */
    private Paint f172k;

    /* renamed from: l */
    private long f173l;

    /* renamed from: m */
    private ValueAnimator f174m;

    /* renamed from: n */
    private long f175n;

    /* renamed from: o */
    private long f176o;

    /* renamed from: p */
    private int f177p;

    /* renamed from: r */
    private Runnable f178r;

    /* renamed from: cn.bingoogolapple.qrcode.core.QRCodeView$a */
    /* loaded from: classes.dex */
    public interface InterfaceC0577a {
        /* renamed from: a */
        void mo9024a();

        /* renamed from: a */
        void mo9023a(String str);

        /* renamed from: a */
        void mo9022a(boolean z);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: a */
    public abstract ScanResult mo12695a(Bitmap bitmap);

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: a */
    public abstract ScanResult mo12692a(byte[] bArr, int i, int i2, boolean z);

    /* renamed from: a */
    protected abstract void mo12696a();

    public QRCodeView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public QRCodeView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f167f = false;
        this.f169h = 0;
        this.f170i = BarcodeType.HIGH_FREQUENCY;
        this.f173l = 0L;
        this.f175n = 0L;
        this.f176o = System.currentTimeMillis();
        this.f177p = 0;
        this.f178r = new Runnable() { // from class: cn.bingoogolapple.qrcode.core.QRCodeView.2
            @Override // java.lang.Runnable
            public void run() {
                if (QRCodeView.this.f162a == null || !QRCodeView.this.f167f) {
                    return;
                }
                try {
                    QRCodeView.this.f162a.setOneShotPreviewCallback(QRCodeView.this);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };
        this.f166e = new Handler();
        m12771a(context, attributeSet);
        mo12696a();
    }

    /* renamed from: a */
    private void m12771a(Context context, AttributeSet attributeSet) {
        this.f163b = new CameraPreview(context);
        this.f164c = new ScanBoxView(context);
        this.f164c.m12741a(this, attributeSet);
        this.f163b.setId(R.id.bgaqrcode_camera_preview);
        addView(this.f163b);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(context, attributeSet);
        layoutParams.addRule(6, this.f163b.getId());
        layoutParams.addRule(8, this.f163b.getId());
        addView(this.f164c, layoutParams);
        this.f172k = new Paint();
        this.f172k.setColor(getScanBoxView().getCornerColor());
        this.f172k.setStyle(Paint.Style.FILL);
    }

    public void setDelegate(InterfaceC0577a interfaceC0577a) {
        this.f165d = interfaceC0577a;
    }

    public CameraPreview getCameraPreview() {
        return this.f163b;
    }

    public ScanBoxView getScanBoxView() {
        return this.f164c;
    }

    /* renamed from: b */
    public void m12764b() {
        ScanBoxView scanBoxView = this.f164c;
        if (scanBoxView != null) {
            scanBoxView.setVisibility(0);
        }
    }

    /* renamed from: c */
    public void m12761c() {
        ScanBoxView scanBoxView = this.f164c;
        if (scanBoxView != null) {
            scanBoxView.setVisibility(8);
        }
    }

    /* renamed from: d */
    public void m12759d() {
        m12773a(this.f169h);
    }

    /* renamed from: a */
    public void m12773a(int i) {
        if (this.f162a != null || Camera.getNumberOfCameras() == 0) {
            return;
        }
        int m12760c = m12760c(i);
        if (m12760c != -1) {
            m12758d(m12760c);
            return;
        }
        if (i == 0) {
            m12760c = m12760c(1);
        } else if (i == 1) {
            m12760c = m12760c(0);
        }
        if (m12760c != -1) {
            m12758d(m12760c);
        }
    }

    /* renamed from: c */
    private int m12760c(int i) {
        Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
        for (int i2 = 0; i2 < Camera.getNumberOfCameras(); i2++) {
            try {
                Camera.getCameraInfo(i2, cameraInfo);
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (cameraInfo.facing == i) {
                return i2;
            }
        }
        return -1;
    }

    /* renamed from: d */
    private void m12758d(int i) {
        try {
            this.f169h = i;
            this.f162a = Camera.open(i);
            this.f163b.setCamera(this.f162a);
        } catch (Exception e) {
            e.printStackTrace();
            InterfaceC0577a interfaceC0577a = this.f165d;
            if (interfaceC0577a != null) {
                interfaceC0577a.mo9024a();
            }
        }
    }

    /* renamed from: e */
    public void m12757e() {
        try {
            m12754h();
            if (this.f162a != null) {
                this.f163b.m12788a();
                this.f163b.setCamera(null);
                this.f162a.release();
                this.f162a = null;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* renamed from: f */
    public void m12756f() {
        m12763b(100);
    }

    /* renamed from: b */
    public void m12763b(int i) {
        int max = Math.max(i, 100);
        this.f167f = true;
        m12759d();
        Handler handler = this.f166e;
        if (handler != null) {
            handler.removeCallbacks(this.f178r);
            this.f166e.postDelayed(this.f178r, max);
        }
    }

    /* renamed from: g */
    public void m12755g() {
        this.f167f = false;
        ProcessDataTask processDataTask = this.f168g;
        if (processDataTask != null) {
            processDataTask.m12697b();
            this.f168g = null;
        }
        Camera camera = this.f162a;
        if (camera != null) {
            try {
                camera.setOneShotPreviewCallback(null);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        Handler handler = this.f166e;
        if (handler != null) {
            handler.removeCallbacks(this.f178r);
        }
    }

    /* renamed from: h */
    public void m12754h() {
        m12755g();
        m12761c();
    }

    /* renamed from: i */
    public void m12753i() {
        m12756f();
        m12764b();
    }

    /* renamed from: j */
    public void m12752j() {
        this.f166e.postDelayed(new Runnable() { // from class: cn.bingoogolapple.qrcode.core.QRCodeView.1
            @Override // java.lang.Runnable
            public void run() {
                QRCodeView.this.f163b.m12782b();
            }
        }, this.f163b.m12778d() ? 0L : 500L);
    }

    /* renamed from: k */
    public void m12751k() {
        this.f163b.m12780c();
    }

    /* renamed from: l */
    public void m12750l() {
        m12757e();
        this.f166e = null;
        this.f165d = null;
        this.f178r = null;
    }

    /* renamed from: m */
    public void m12749m() {
        if (this.f164c.getIsBarcode()) {
            return;
        }
        this.f164c.setIsBarcode(true);
    }

    /* renamed from: n */
    public void m12748n() {
        if (this.f164c.getIsBarcode()) {
            this.f164c.setIsBarcode(false);
        }
    }

    public boolean getIsScanBarcodeStyle() {
        return this.f164c.getIsBarcode();
    }

    @Override // android.hardware.Camera.PreviewCallback
    public void onPreviewFrame(byte[] bArr, Camera camera) {
        if (BGAQRCodeUtil.m12730a()) {
            BGAQRCodeUtil.m12723a("两次 onPreviewFrame 时间间隔：" + (System.currentTimeMillis() - this.f173l));
            this.f173l = System.currentTimeMillis();
        }
        CameraPreview cameraPreview = this.f163b;
        if (cameraPreview != null && cameraPreview.m12778d()) {
            m12767a(bArr, camera);
        }
        if (this.f167f) {
            ProcessDataTask processDataTask = this.f168g;
            if (processDataTask == null || !(processDataTask.getStatus() == AsyncTask.Status.PENDING || this.f168g.getStatus() == AsyncTask.Status.RUNNING)) {
                this.f168g = new ProcessDataTask(camera, bArr, this, BGAQRCodeUtil.m12727a(getContext())).m12701a();
            }
        }
    }

    /* renamed from: a */
    private void m12767a(byte[] bArr, Camera camera) {
        CameraPreview cameraPreview = this.f163b;
        if (cameraPreview == null || !cameraPreview.m12778d()) {
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.f176o < 150) {
            return;
        }
        this.f176o = currentTimeMillis;
        long j = camera.getParameters().getPreviewSize().width * camera.getParameters().getPreviewSize().height;
        if (Math.abs(bArr.length - (((float) j) * 1.5f)) < 1.0E-5f) {
            boolean z = false;
            long j2 = 0;
            for (int i = 0; i < j; i += 10) {
                j2 += bArr[i] & 255;
            }
            long j3 = j2 / (j / 10);
            long[] jArr = f161q;
            int length = this.f177p % jArr.length;
            this.f177p = length;
            jArr[length] = j3;
            this.f177p++;
            int length2 = jArr.length;
            int i2 = 0;
            while (true) {
                if (i2 >= length2) {
                    z = true;
                    break;
                } else if (jArr[i2] > 60) {
                    break;
                } else {
                    i2++;
                }
            }
            BGAQRCodeUtil.m12723a("摄像头环境亮度为：" + j3);
            InterfaceC0577a interfaceC0577a = this.f165d;
            if (interfaceC0577a != null) {
                interfaceC0577a.mo9022a(z);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public void m12768a(ScanResult scanResult) {
        if (this.f167f) {
            String str = scanResult == null ? null : scanResult.f256a;
            if (TextUtils.isEmpty(str)) {
                try {
                    if (this.f162a != null) {
                        this.f162a.setOneShotPreviewCallback(this);
                        return;
                    }
                    return;
                } catch (Exception e) {
                    e.printStackTrace();
                    return;
                }
            }
            this.f167f = false;
            try {
                if (this.f165d != null) {
                    this.f165d.mo9023a(str);
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: b */
    public void m12762b(ScanResult scanResult) {
        if (this.f165d != null) {
            this.f165d.mo9023a(scanResult == null ? null : scanResult.f256a);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public void m12770a(Rect rect) {
        this.f163b.m12786a(rect);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        PointF[] pointFArr;
        super.dispatchDraw(canvas);
        if (!m12747o() || (pointFArr = this.f171j) == null) {
            return;
        }
        for (PointF pointF : pointFArr) {
            canvas.drawCircle(pointF.x, pointF.y, 10.0f, this.f172k);
        }
        this.f171j = null;
        postInvalidateDelayed(2000L);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: o */
    public boolean m12747o() {
        ScanBoxView scanBoxView = this.f164c;
        return scanBoxView != null && scanBoxView.m12740b();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: p */
    public boolean m12746p() {
        ScanBoxView scanBoxView = this.f164c;
        return scanBoxView != null && scanBoxView.m12738c();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: a */
    public boolean m12766a(PointF[] pointFArr, Rect rect, boolean z, String str) {
        if (pointFArr == null || pointFArr.length == 0) {
            return false;
        }
        try {
            Camera.Size previewSize = this.f162a.getParameters().getPreviewSize();
            boolean z2 = this.f169h == 1;
            int m12716c = BGAQRCodeUtil.m12716c(getContext());
            PointF[] pointFArr2 = new PointF[pointFArr.length];
            int i = 0;
            for (PointF pointF : pointFArr) {
                pointFArr2[i] = m12774a(pointF.x, pointF.y, previewSize.width, previewSize.height, z2, m12716c, rect);
                i++;
            }
            this.f171j = pointFArr2;
            postInvalidate();
            if (z) {
                return m12765a(pointFArr2, str);
            }
            return false;
        } catch (Exception e) {
            this.f171j = null;
            e.printStackTrace();
            return false;
        }
    }

    /* renamed from: a */
    private boolean m12765a(PointF[] pointFArr, final String str) {
        if (this.f162a == null || this.f164c == null || pointFArr == null || pointFArr.length < 1) {
            return false;
        }
        ValueAnimator valueAnimator = this.f174m;
        if ((valueAnimator == null || !valueAnimator.isRunning()) && System.currentTimeMillis() - this.f175n >= 1200) {
            Camera.Parameters parameters = this.f162a.getParameters();
            if (parameters.isZoomSupported()) {
                float f = pointFArr[0].x;
                float f2 = pointFArr[0].y;
                float f3 = pointFArr[1].x;
                float f4 = pointFArr[1].y;
                float abs = Math.abs(f - f3);
                float abs2 = Math.abs(f2 - f4);
                if (((int) Math.sqrt((abs * abs) + (abs2 * abs2))) > this.f164c.getRectWidth() / 4) {
                    return false;
                }
                final int maxZoom = parameters.getMaxZoom();
                final int i = maxZoom / 4;
                final int zoom = parameters.getZoom();
                post(new Runnable() { // from class: cn.bingoogolapple.qrcode.core.QRCodeView.3
                    @Override // java.lang.Runnable
                    public void run() {
                        QRCodeView qRCodeView = QRCodeView.this;
                        int i2 = zoom;
                        qRCodeView.m12772a(i2, Math.min(i + i2, maxZoom), str);
                    }
                });
                return true;
            }
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m12772a(int i, int i2, final String str) {
        this.f174m = ValueAnimator.ofInt(i, i2);
        this.f174m.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: cn.bingoogolapple.qrcode.core.QRCodeView.4
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (QRCodeView.this.f163b == null || !QRCodeView.this.f163b.m12778d()) {
                    return;
                }
                int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                Camera.Parameters parameters = QRCodeView.this.f162a.getParameters();
                parameters.setZoom(intValue);
                QRCodeView.this.f162a.setParameters(parameters);
            }
        });
        this.f174m.addListener(new AnimatorListenerAdapter() { // from class: cn.bingoogolapple.qrcode.core.QRCodeView.5
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                QRCodeView.this.m12768a(new ScanResult(str));
            }
        });
        this.f174m.setDuration(600L);
        this.f174m.setRepeatCount(0);
        this.f174m.start();
        this.f175n = System.currentTimeMillis();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ValueAnimator valueAnimator = this.f174m;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
    }

    /* renamed from: a */
    private PointF m12774a(float f, float f2, float f3, float f4, boolean z, int i, Rect rect) {
        PointF pointF;
        int width = getWidth();
        int height = getHeight();
        if (BGAQRCodeUtil.m12727a(getContext())) {
            float f5 = width;
            float f6 = height;
            pointF = new PointF((f4 - f) * (f5 / f4), (f3 - f2) * (f6 / f3));
            pointF.y = f6 - pointF.y;
            pointF.x = f5 - pointF.x;
            if (rect == null) {
                pointF.y += i;
            }
        } else {
            float f7 = width;
            pointF = new PointF(f * (f7 / f3), f2 * (height / f4));
            if (z) {
                pointF.x = f7 - pointF.x;
            }
        }
        if (rect != null) {
            pointF.y += rect.top;
            pointF.x += rect.left;
        }
        return pointF;
    }
}
