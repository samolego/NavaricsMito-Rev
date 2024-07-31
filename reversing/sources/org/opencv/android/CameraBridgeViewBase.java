package org.opencv.android;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.Log;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import java.util.List;
import org.opencv.R;
import org.opencv.core.Mat;
import org.opencv.core.Size;
import org.slf4j.Marker;

/* loaded from: classes2.dex */
public abstract class CameraBridgeViewBase extends SurfaceView implements SurfaceHolder.Callback {

    /* renamed from: a */
    protected int f12400a;

    /* renamed from: b */
    protected int f12401b;

    /* renamed from: c */
    protected int f12402c;

    /* renamed from: d */
    protected int f12403d;

    /* renamed from: e */
    protected float f12404e;

    /* renamed from: f */
    protected int f12405f;

    /* renamed from: g */
    protected int f12406g;

    /* renamed from: h */
    protected boolean f12407h;

    /* renamed from: i */
    protected FpsMeter f12408i;

    /* renamed from: j */
    private int f12409j;

    /* renamed from: k */
    private Bitmap f12410k;

    /* renamed from: l */
    private InterfaceC3142c f12411l;

    /* renamed from: m */
    private boolean f12412m;

    /* renamed from: n */
    private final Object f12413n;

    /* renamed from: org.opencv.android.CameraBridgeViewBase$a */
    /* loaded from: classes2.dex */
    public interface InterfaceC3140a {
        /* renamed from: a */
        Mat mo353a();

        /* renamed from: b */
        Mat mo352b();
    }

    /* renamed from: org.opencv.android.CameraBridgeViewBase$b */
    /* loaded from: classes2.dex */
    public interface InterfaceC3141b {
        /* renamed from: a */
        Mat m372a(Mat mat);

        /* renamed from: a */
        void m374a();

        /* renamed from: a */
        void m373a(int i, int i2);
    }

    /* renamed from: org.opencv.android.CameraBridgeViewBase$c */
    /* loaded from: classes2.dex */
    public interface InterfaceC3142c {
        /* renamed from: a */
        Mat mo368a(InterfaceC3140a interfaceC3140a);

        /* renamed from: a */
        void mo371a();

        /* renamed from: a */
        void mo369a(int i, int i2);
    }

    /* renamed from: org.opencv.android.CameraBridgeViewBase$e */
    /* loaded from: classes2.dex */
    public interface InterfaceC3144e {
        /* renamed from: a */
        int mo350a(Object obj);

        /* renamed from: b */
        int mo349b(Object obj);
    }

    /* renamed from: e */
    private void m378e() {
    }

    /* renamed from: f */
    private void m377f() {
    }

    /* renamed from: a */
    protected abstract boolean mo364a(int i, int i2);

    /* renamed from: b */
    protected abstract void mo360b();

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
    }

    public CameraBridgeViewBase(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f12409j = 0;
        this.f12413n = new Object();
        this.f12404e = 0.0f;
        this.f12405f = 1;
        this.f12406g = -1;
        this.f12408i = null;
        int attributeCount = attributeSet.getAttributeCount();
        Log.d("CameraBridge", "Attr count: " + Integer.valueOf(attributeCount));
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.CameraBridgeViewBase);
        if (obtainStyledAttributes.getBoolean(R.styleable.CameraBridgeViewBase_show_fps, false)) {
            m385a();
        }
        this.f12406g = obtainStyledAttributes.getInt(R.styleable.CameraBridgeViewBase_camera_id, -1);
        getHolder().addCallback(this);
        this.f12403d = -1;
        this.f12402c = -1;
        obtainStyledAttributes.recycle();
    }

    public void setCameraIndex(int i) {
        this.f12406g = i;
    }

    /* renamed from: org.opencv.android.CameraBridgeViewBase$d */
    /* loaded from: classes2.dex */
    protected class C3143d implements InterfaceC3142c {

        /* renamed from: b */
        private int f12416b = 1;

        /* renamed from: c */
        private InterfaceC3141b f12417c;

        public C3143d(InterfaceC3141b interfaceC3141b) {
            this.f12417c = interfaceC3141b;
        }

        @Override // org.opencv.android.CameraBridgeViewBase.InterfaceC3142c
        /* renamed from: a */
        public void mo369a(int i, int i2) {
            this.f12417c.m373a(i, i2);
        }

        @Override // org.opencv.android.CameraBridgeViewBase.InterfaceC3142c
        /* renamed from: a */
        public void mo371a() {
            this.f12417c.m374a();
        }

        @Override // org.opencv.android.CameraBridgeViewBase.InterfaceC3142c
        /* renamed from: a */
        public Mat mo368a(InterfaceC3140a interfaceC3140a) {
            switch (this.f12416b) {
                case 1:
                    return this.f12417c.m372a(interfaceC3140a.mo353a());
                case 2:
                    return this.f12417c.m372a(interfaceC3140a.mo352b());
                default:
                    Log.e("CameraBridge", "Invalid frame format! Only RGBA and Gray Scale are supported!");
                    return null;
            }
        }

        /* renamed from: a */
        public void m370a(int i) {
            this.f12416b = i;
        }
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
        Log.d("CameraBridge", "call surfaceChanged event");
        synchronized (this.f12413n) {
            if (!this.f12412m) {
                this.f12412m = true;
                m379d();
            } else {
                this.f12412m = false;
                m379d();
                this.f12412m = true;
                m379d();
            }
        }
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        synchronized (this.f12413n) {
            this.f12412m = false;
            m379d();
        }
    }

    /* renamed from: a */
    public void m385a() {
        if (this.f12408i == null) {
            this.f12408i = new FpsMeter();
            this.f12408i.m306a(this.f12400a, this.f12401b);
        }
    }

    public void setCvCameraViewListener(InterfaceC3142c interfaceC3142c) {
        this.f12411l = interfaceC3142c;
    }

    public void setCvCameraViewListener(InterfaceC3141b interfaceC3141b) {
        C3143d c3143d = new C3143d(interfaceC3141b);
        c3143d.m370a(this.f12405f);
        this.f12411l = c3143d;
    }

    /* renamed from: d */
    private void m379d() {
        Log.d("CameraBridge", "call checkCurrentState");
        int i = (this.f12407h && this.f12412m && getVisibility() == 0) ? 1 : 0;
        int i2 = this.f12409j;
        if (i != i2) {
            m381b(i2);
            this.f12409j = i;
            m384a(this.f12409j);
        }
    }

    /* renamed from: a */
    private void m384a(int i) {
        Log.d("CameraBridge", "call processEnterState: " + i);
        switch (i) {
            case 0:
                m378e();
                InterfaceC3142c interfaceC3142c = this.f12411l;
                if (interfaceC3142c != null) {
                    interfaceC3142c.mo371a();
                    return;
                }
                return;
            case 1:
                m376g();
                InterfaceC3142c interfaceC3142c2 = this.f12411l;
                if (interfaceC3142c2 != null) {
                    interfaceC3142c2.mo369a(this.f12400a, this.f12401b);
                    return;
                }
                return;
            default:
                return;
        }
    }

    /* renamed from: b */
    private void m381b(int i) {
        Log.d("CameraBridge", "call processExitState: " + i);
        switch (i) {
            case 0:
                m377f();
                return;
            case 1:
                m375h();
                return;
            default:
                return;
        }
    }

    /* renamed from: g */
    private void m376g() {
        Log.d("CameraBridge", "call onEnterStartedState");
        if (mo364a(getWidth(), getHeight())) {
            return;
        }
        AlertDialog create = new AlertDialog.Builder(getContext()).create();
        create.setCancelable(false);
        create.setMessage("It seems that you device does not support camera (or it is locked). Application will be closed.");
        create.setButton(-3, "OK", new DialogInterface.OnClickListener() { // from class: org.opencv.android.CameraBridgeViewBase.1
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
                ((Activity) CameraBridgeViewBase.this.getContext()).finish();
            }
        });
        create.show();
    }

    /* renamed from: h */
    private void m375h() {
        mo360b();
        Bitmap bitmap = this.f12410k;
        if (bitmap != null) {
            bitmap.recycle();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: a */
    public void m382a(InterfaceC3140a interfaceC3140a) {
        Mat mo353a;
        Canvas lockCanvas;
        InterfaceC3142c interfaceC3142c = this.f12411l;
        if (interfaceC3142c != null) {
            mo353a = interfaceC3142c.mo368a(interfaceC3140a);
        } else {
            mo353a = interfaceC3140a.mo353a();
        }
        boolean z = true;
        if (mo353a != null) {
            try {
                Utils.m341a(mo353a, this.f12410k);
            } catch (Exception e) {
                Log.e("CameraBridge", "Mat type: " + mo353a);
                Log.e("CameraBridge", "Bitmap type: " + this.f12410k.getWidth() + Marker.ANY_MARKER + this.f12410k.getHeight());
                StringBuilder sb = new StringBuilder();
                sb.append("Utils.matToBitmap() throws an exception: ");
                sb.append(e.getMessage());
                Log.e("CameraBridge", sb.toString());
                z = false;
            }
        }
        if (!z || this.f12410k == null || (lockCanvas = getHolder().lockCanvas()) == null) {
            return;
        }
        lockCanvas.drawColor(0, PorterDuff.Mode.CLEAR);
        if (this.f12404e != 0.0f) {
            Bitmap bitmap = this.f12410k;
            lockCanvas.drawBitmap(bitmap, new Rect(0, 0, bitmap.getWidth(), this.f12410k.getHeight()), new Rect((int) ((lockCanvas.getWidth() - (this.f12404e * this.f12410k.getWidth())) / 2.0f), (int) ((lockCanvas.getHeight() - (this.f12404e * this.f12410k.getHeight())) / 2.0f), (int) (((lockCanvas.getWidth() - (this.f12404e * this.f12410k.getWidth())) / 2.0f) + (this.f12404e * this.f12410k.getWidth())), (int) (((lockCanvas.getHeight() - (this.f12404e * this.f12410k.getHeight())) / 2.0f) + (this.f12404e * this.f12410k.getHeight()))), (Paint) null);
        } else {
            Bitmap bitmap2 = this.f12410k;
            lockCanvas.drawBitmap(bitmap2, new Rect(0, 0, bitmap2.getWidth(), this.f12410k.getHeight()), new Rect((lockCanvas.getWidth() - this.f12410k.getWidth()) / 2, (lockCanvas.getHeight() - this.f12410k.getHeight()) / 2, ((lockCanvas.getWidth() - this.f12410k.getWidth()) / 2) + this.f12410k.getWidth(), ((lockCanvas.getHeight() - this.f12410k.getHeight()) / 2) + this.f12410k.getHeight()), (Paint) null);
        }
        FpsMeter fpsMeter = this.f12408i;
        if (fpsMeter != null) {
            fpsMeter.m304b();
            this.f12408i.m305a(lockCanvas, 20.0f, 30.0f);
        }
        getHolder().unlockCanvasAndPost(lockCanvas);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: c */
    public void m380c() {
        this.f12410k = Bitmap.createBitmap(this.f12400a, this.f12401b, Bitmap.Config.ARGB_8888);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: a */
    public Size m383a(List<?> list, InterfaceC3144e interfaceC3144e, int i, int i2) {
        int i3 = this.f12403d;
        if (i3 != -1 && i3 < i) {
            i = i3;
        }
        int i4 = this.f12402c;
        if (i4 != -1 && i4 < i2) {
            i2 = i4;
        }
        int i5 = 0;
        int i6 = 0;
        for (Object obj : list) {
            int mo350a = interfaceC3144e.mo350a(obj);
            int mo349b = interfaceC3144e.mo349b(obj);
            if (mo350a <= i && mo349b <= i2 && mo350a >= i5 && mo349b >= i6) {
                i6 = mo349b;
                i5 = mo350a;
            }
        }
        return new Size(i5, i6);
    }
}
