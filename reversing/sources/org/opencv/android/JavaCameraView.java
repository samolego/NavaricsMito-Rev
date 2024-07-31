package org.opencv.android;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.hardware.Camera;
import android.util.AttributeSet;
import android.util.Log;
import org.opencv.android.CameraBridgeViewBase;
import org.opencv.core.Mat;
import org.opencv.imgproc.Imgproc;

/* loaded from: classes2.dex */
public class JavaCameraView extends CameraBridgeViewBase implements Camera.PreviewCallback {

    /* renamed from: j */
    protected Camera f12420j;

    /* renamed from: k */
    protected C3148b[] f12421k;

    /* renamed from: l */
    private byte[] f12422l;

    /* renamed from: m */
    private Mat[] f12423m;

    /* renamed from: n */
    private int f12424n;

    /* renamed from: o */
    private Thread f12425o;

    /* renamed from: p */
    private boolean f12426p;

    /* renamed from: q */
    private SurfaceTexture f12427q;

    /* renamed from: r */
    private int f12428r;

    /* renamed from: s */
    private boolean f12429s;

    /* renamed from: org.opencv.android.JavaCameraView$c */
    /* loaded from: classes2.dex */
    public static class C3149c implements CameraBridgeViewBase.InterfaceC3144e {
        @Override // org.opencv.android.CameraBridgeViewBase.InterfaceC3144e
        /* renamed from: a */
        public int mo350a(Object obj) {
            return ((Camera.Size) obj).width;
        }

        @Override // org.opencv.android.CameraBridgeViewBase.InterfaceC3144e
        /* renamed from: b */
        public int mo349b(Object obj) {
            return ((Camera.Size) obj).height;
        }
    }

    public JavaCameraView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f12424n = 0;
        this.f12428r = 17;
        this.f12429s = false;
    }

    /* JADX WARN: Removed duplicated region for block: B:101:0x0278 A[Catch: Exception -> 0x0321, all -> 0x0327, TryCatch #4 {Exception -> 0x0321, blocks: (B:60:0x0151, B:62:0x0164, B:64:0x0177, B:66:0x0181, B:68:0x018b, B:70:0x0195, B:72:0x019f, B:74:0x01a9, B:76:0x01b3, B:78:0x01bd, B:81:0x01c8, B:83:0x01d4, B:85:0x0215, B:87:0x021f, B:88:0x0222, B:90:0x0228, B:92:0x0230, B:93:0x0235, B:95:0x0258, B:97:0x0260, B:99:0x0274, B:101:0x0278, B:102:0x0281, B:104:0x02fd, B:106:0x0313, B:105:0x030e, B:98:0x0271, B:82:0x01ce), top: B:122:0x0151, outer: #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:104:0x02fd A[Catch: Exception -> 0x0321, all -> 0x0327, TryCatch #4 {Exception -> 0x0321, blocks: (B:60:0x0151, B:62:0x0164, B:64:0x0177, B:66:0x0181, B:68:0x018b, B:70:0x0195, B:72:0x019f, B:74:0x01a9, B:76:0x01b3, B:78:0x01bd, B:81:0x01c8, B:83:0x01d4, B:85:0x0215, B:87:0x021f, B:88:0x0222, B:90:0x0228, B:92:0x0230, B:93:0x0235, B:95:0x0258, B:97:0x0260, B:99:0x0274, B:101:0x0278, B:102:0x0281, B:104:0x02fd, B:106:0x0313, B:105:0x030e, B:98:0x0271, B:82:0x01ce), top: B:122:0x0151, outer: #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:105:0x030e A[Catch: Exception -> 0x0321, all -> 0x0327, TryCatch #4 {Exception -> 0x0321, blocks: (B:60:0x0151, B:62:0x0164, B:64:0x0177, B:66:0x0181, B:68:0x018b, B:70:0x0195, B:72:0x019f, B:74:0x01a9, B:76:0x01b3, B:78:0x01bd, B:81:0x01c8, B:83:0x01d4, B:85:0x0215, B:87:0x021f, B:88:0x0222, B:90:0x0228, B:92:0x0230, B:93:0x0235, B:95:0x0258, B:97:0x0260, B:99:0x0274, B:101:0x0278, B:102:0x0281, B:104:0x02fd, B:106:0x0313, B:105:0x030e, B:98:0x0271, B:82:0x01ce), top: B:122:0x0151, outer: #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:122:0x0151 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:58:0x014f A[Catch: all -> 0x0327, DONT_GENERATE, TRY_LEAVE, TryCatch #2 {, blocks: (B:5:0x0009, B:7:0x0014, B:8:0x001b, B:12:0x003d, B:14:0x0041, B:17:0x0047, B:19:0x004d, B:20:0x006c, B:26:0x009b, B:23:0x0075, B:56:0x014b, B:58:0x014f, B:60:0x0151, B:62:0x0164, B:64:0x0177, B:66:0x0181, B:68:0x018b, B:70:0x0195, B:72:0x019f, B:74:0x01a9, B:76:0x01b3, B:78:0x01bd, B:81:0x01c8, B:83:0x01d4, B:85:0x0215, B:87:0x021f, B:88:0x0222, B:90:0x0228, B:92:0x0230, B:93:0x0235, B:95:0x0258, B:97:0x0260, B:99:0x0274, B:101:0x0278, B:102:0x0281, B:104:0x02fd, B:106:0x0313, B:105:0x030e, B:98:0x0271, B:82:0x01ce, B:110:0x0325, B:109:0x0322, B:11:0x0023, B:27:0x009e, B:29:0x00a2, B:31:0x00ac, B:32:0x00b9, B:34:0x00bf, B:37:0x00c8, B:48:0x00f0, B:50:0x00fa, B:51:0x0102, B:52:0x0121, B:55:0x0129, B:38:0x00cb, B:40:0x00cf, B:41:0x00dc, B:43:0x00e2, B:46:0x00eb), top: B:119:0x0009, inners: #0, #1, #3, #4 }] */
    /* renamed from: b */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected boolean m359b(int r11, int r12) {
        /*
            Method dump skipped, instructions count: 810
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: org.opencv.android.JavaCameraView.m359b(int, int):boolean");
    }

    /* renamed from: d */
    protected void m356d() {
        synchronized (this) {
            if (this.f12420j != null) {
                this.f12420j.stopPreview();
                this.f12420j.setPreviewCallback(null);
                this.f12420j.release();
            }
            this.f12420j = null;
            if (this.f12423m != null) {
                this.f12423m[0].m283g();
                this.f12423m[1].m283g();
            }
            if (this.f12421k != null) {
                this.f12421k[0].m351c();
                this.f12421k[1].m351c();
            }
        }
    }

    @Override // org.opencv.android.CameraBridgeViewBase
    /* renamed from: a */
    protected boolean mo364a(int i, int i2) {
        Log.d("JavaCameraView", "Connecting to camera");
        if (m359b(i, i2)) {
            this.f12429s = false;
            Log.d("JavaCameraView", "Starting processing thread");
            this.f12426p = false;
            this.f12425o = new Thread(new RunnableC3147a());
            this.f12425o.start();
            return true;
        }
        return false;
    }

    @Override // org.opencv.android.CameraBridgeViewBase
    /* renamed from: b */
    protected void mo360b() {
        Log.d("JavaCameraView", "Disconnecting from camera");
        try {
            try {
                this.f12426p = true;
                Log.d("JavaCameraView", "Notify thread");
                synchronized (this) {
                    notify();
                }
                Log.d("JavaCameraView", "Waiting for thread");
                if (this.f12425o != null) {
                    this.f12425o.join();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            this.f12425o = null;
            m356d();
            this.f12429s = false;
        } catch (Throwable th) {
            this.f12425o = null;
            throw th;
        }
    }

    @Override // android.hardware.Camera.PreviewCallback
    public void onPreviewFrame(byte[] bArr, Camera camera) {
        synchronized (this) {
            this.f12423m[this.f12424n].m289a(0, 0, bArr);
            this.f12429s = true;
            notify();
        }
        Camera camera2 = this.f12420j;
        if (camera2 != null) {
            camera2.addCallbackBuffer(this.f12422l);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: org.opencv.android.JavaCameraView$b */
    /* loaded from: classes2.dex */
    public class C3148b implements CameraBridgeViewBase.InterfaceC3140a {

        /* renamed from: b */
        private Mat f12432b;

        /* renamed from: c */
        private Mat f12433c = new Mat();

        /* renamed from: d */
        private int f12434d;

        /* renamed from: e */
        private int f12435e;

        @Override // org.opencv.android.CameraBridgeViewBase.InterfaceC3140a
        /* renamed from: b */
        public Mat mo352b() {
            return this.f12432b.m290a(0, this.f12435e, 0, this.f12434d);
        }

        @Override // org.opencv.android.CameraBridgeViewBase.InterfaceC3140a
        /* renamed from: a */
        public Mat mo353a() {
            if (JavaCameraView.this.f12428r != 17) {
                if (JavaCameraView.this.f12428r == 842094169) {
                    Imgproc.m265a(this.f12432b, this.f12433c, 100, 4);
                } else {
                    throw new IllegalArgumentException("Preview Format can be NV21 or YV12");
                }
            } else {
                Imgproc.m265a(this.f12432b, this.f12433c, 96, 4);
            }
            return this.f12433c;
        }

        public C3148b(Mat mat, int i, int i2) {
            this.f12434d = i;
            this.f12435e = i2;
            this.f12432b = mat;
        }

        /* renamed from: c */
        public void m351c() {
            this.f12433c.m283g();
        }
    }

    /* renamed from: org.opencv.android.JavaCameraView$a */
    /* loaded from: classes2.dex */
    private class RunnableC3147a implements Runnable {
        private RunnableC3147a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            boolean z;
            do {
                synchronized (JavaCameraView.this) {
                    while (!JavaCameraView.this.f12429s && !JavaCameraView.this.f12426p) {
                        try {
                            JavaCameraView.this.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    z = false;
                    if (JavaCameraView.this.f12429s) {
                        JavaCameraView.this.f12424n = 1 - JavaCameraView.this.f12424n;
                        JavaCameraView.this.f12429s = false;
                        z = true;
                    }
                }
                if (!JavaCameraView.this.f12426p && z && !JavaCameraView.this.f12423m[1 - JavaCameraView.this.f12424n].m286d()) {
                    JavaCameraView javaCameraView = JavaCameraView.this;
                    javaCameraView.m382a(javaCameraView.f12421k[1 - JavaCameraView.this.f12424n]);
                }
            } while (!JavaCameraView.this.f12426p);
            Log.d("JavaCameraView", "Finish processing thread");
        }
    }
}
