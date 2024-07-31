package org.opencv.android;

import android.content.Context;
import android.content.res.TypedArray;
import android.opengl.GLSurfaceView;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.view.SurfaceHolder;
import org.opencv.R;

/* loaded from: classes2.dex */
public class CameraGLSurfaceView extends GLSurfaceView {

    /* renamed from: a */
    private InterfaceC3145a f12418a;

    /* renamed from: b */
    private CameraGLRendererBase f12419b;

    /* renamed from: org.opencv.android.CameraGLSurfaceView$a */
    /* loaded from: classes2.dex */
    public interface InterfaceC3145a {
        /* renamed from: a */
        void m367a();

        /* renamed from: a */
        void m366a(int i, int i2);

        /* renamed from: a */
        boolean m365a(int i, int i2, int i3, int i4);
    }

    public CameraGLSurfaceView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.CameraBridgeViewBase);
        int i = obtainStyledAttributes.getInt(R.styleable.CameraBridgeViewBase_camera_id, -1);
        obtainStyledAttributes.recycle();
        if (Build.VERSION.SDK_INT >= 21) {
            this.f12419b = new Camera2Renderer(this);
        } else {
            this.f12419b = new CameraRenderer(this);
        }
        setCameraIndex(i);
        setEGLContextClientVersion(2);
        setRenderer(this.f12419b);
        setRenderMode(0);
    }

    public void setCameraTextureListener(InterfaceC3145a interfaceC3145a) {
        this.f12418a = interfaceC3145a;
    }

    public InterfaceC3145a getCameraTextureListener() {
        return this.f12418a;
    }

    public void setCameraIndex(int i) {
        this.f12419b.m322b(i);
    }

    @Override // android.opengl.GLSurfaceView, android.view.SurfaceHolder.Callback
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        super.surfaceCreated(surfaceHolder);
    }

    @Override // android.opengl.GLSurfaceView, android.view.SurfaceHolder.Callback
    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        this.f12419b.f12466k = false;
        super.surfaceDestroyed(surfaceHolder);
    }

    @Override // android.opengl.GLSurfaceView, android.view.SurfaceHolder.Callback
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
        super.surfaceChanged(surfaceHolder, i, i2, i3);
    }

    @Override // android.opengl.GLSurfaceView
    public void onResume() {
        Log.i("CameraGLSurfaceView", "onResume");
        super.onResume();
        this.f12419b.m316g();
    }

    @Override // android.opengl.GLSurfaceView
    public void onPause() {
        Log.i("CameraGLSurfaceView", "onPause");
        this.f12419b.m315h();
        super.onPause();
    }
}
