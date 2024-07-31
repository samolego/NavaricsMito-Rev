package com.senseplay.sdk.video;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

/* loaded from: classes2.dex */
public class VideoSurface extends SurfaceView implements SurfaceHolder.Callback {
    private SurfaceHolder holder;

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
    }

    public VideoSurface(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.holder = getHolder();
        this.holder.addCallback(this);
        this.holder.setType(3);
        this.holder.setFormat(-3);
        Log.e("App", "Video0 Surface");
    }
}