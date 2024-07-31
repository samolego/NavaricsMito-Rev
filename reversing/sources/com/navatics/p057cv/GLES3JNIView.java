package com.navatics.p057cv;

import android.content.Context;
import android.opengl.GLSurfaceView;
import android.util.AttributeSet;
import android.util.Log;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;
import org.opencv.core.Core;
import org.opencv.core.Mat;

/* renamed from: com.navatics.cv.GLES3JNIView */
/* loaded from: classes.dex */
public class GLES3JNIView extends GLSurfaceView {

    /* renamed from: a */
    private Mat f5785a;

    /* renamed from: b */
    private Mat f5786b;

    /* renamed from: c */
    private boolean f5787c;

    /* renamed from: d */
    private final Object f5788d;

    public GLES3JNIView(Context context) {
        super(context);
        this.f5787c = false;
        this.f5788d = new Object();
        m6869a();
    }

    public GLES3JNIView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f5787c = false;
        this.f5788d = new Object();
        m6869a();
    }

    /* renamed from: a */
    private void m6869a() {
        setEGLContextClientVersion(3);
        setRenderer(new C1986a(this));
        setRenderMode(0);
    }

    public void setImageMat(Mat mat) {
        this.f5785a = mat;
    }

    /* renamed from: a */
    public Mat m6866a(Mat mat, long j) throws InterruptedException {
        if (this.f5787c) {
            return null;
        }
        synchronized (this.f5788d) {
            if (this.f5787c) {
                return null;
            }
            this.f5785a = mat;
            this.f5787c = true;
            requestRender();
            this.f5788d.wait(j);
            this.f5787c = false;
            return this.f5786b;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.navatics.cv.GLES3JNIView$a */
    /* loaded from: classes.dex */
    public static class C1986a implements GLSurfaceView.Renderer {

        /* renamed from: a */
        GLES3JNIView f5789a;

        public C1986a(GLES3JNIView gLES3JNIView) {
            this.f5789a = gLES3JNIView;
        }

        @Override // android.opengl.GLSurfaceView.Renderer
        public void onDrawFrame(GL10 gl10) {
            if (this.f5789a.f5785a != null) {
                synchronized (this.f5789a.f5788d) {
                    if (this.f5789a.f5787c) {
                        long currentTimeMillis = System.currentTimeMillis();
                        GLES3JNILib.stepOnce(this.f5789a.f5785a.m280j());
                        Log.d("GLES3JNIView", "Time cost : " + (System.currentTimeMillis() - currentTimeMillis));
                        if (this.f5789a.f5786b != null) {
                            this.f5789a.f5786b.m283g();
                            this.f5789a.f5786b = null;
                        }
                        this.f5789a.f5786b = NavaticsCV.m6862a();
                        Core.m301a(this.f5789a.f5786b, this.f5789a.f5786b, 0);
                        this.f5789a.f5788d.notifyAll();
                    } else {
                        Log.i("GLES3JNIView", "No one waiting us.");
                    }
                }
                return;
            }
            Log.e("GLES3JNIView", "imageMat haven't been set yet.");
        }

        @Override // android.opengl.GLSurfaceView.Renderer
        public void onSurfaceChanged(GL10 gl10, int i, int i2) {
            GLES3JNILib.resize(i, i2);
        }

        @Override // android.opengl.GLSurfaceView.Renderer
        public void onSurfaceCreated(GL10 gl10, EGLConfig eGLConfig) {
            GLES3JNILib.init();
        }
    }
}
