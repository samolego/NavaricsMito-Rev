package com.navatics.app.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.SurfaceTexture;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.Surface;
import android.view.TextureView;
import android.widget.FrameLayout;
import com.navatics.app.framework.NvRobot;
import java.lang.ref.WeakReference;
import org.apache.log4j.C3044k;

/* loaded from: classes.dex */
public class NvSurfacePreview extends FrameLayout {

    /* renamed from: a */
    private static C3044k f5405a = C3044k.m1564a(NvSurfacePreview.class);

    /* renamed from: b */
    private TextureView f5406b;

    /* renamed from: c */
    private TextureView$SurfaceTextureListenerC1939a f5407c;

    /* renamed from: a */
    private void m7171a() {
    }

    public NvSurfacePreview(@NonNull Context context) {
        super(context);
    }

    public NvSurfacePreview(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        m7171a();
    }

    public NvSurfacePreview(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m7171a();
    }

    /* renamed from: a */
    public void m7170a(NvRobot nvRobot) {
        if (nvRobot == null) {
            f5405a.mo1504b((Object) "reset : robot is null");
            return;
        }
        m7169b(nvRobot);
        forceLayout();
    }

    /* renamed from: b */
    private void m7169b(NvRobot nvRobot) {
        if (nvRobot == null) {
            return;
        }
        TextureView textureView = this.f5406b;
        if (textureView != null) {
            removeView(textureView);
            this.f5406b = null;
        }
        this.f5407c = new TextureView$SurfaceTextureListenerC1939a(this, nvRobot);
        this.f5406b = new TextureView(getContext());
        this.f5406b.setSurfaceTextureListener(this.f5407c);
        this.f5406b.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        addView(this.f5406b);
    }

    public Bitmap getFrameBitmap() {
        TextureView textureView = this.f5406b;
        if (textureView != null) {
            return textureView.getBitmap();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.navatics.app.widget.NvSurfacePreview$a */
    /* loaded from: classes.dex */
    public static final class TextureView$SurfaceTextureListenerC1939a implements TextureView.SurfaceTextureListener {

        /* renamed from: a */
        private WeakReference<NvSurfacePreview> f5408a;

        /* renamed from: b */
        private SurfaceTexture f5409b;

        /* renamed from: c */
        private NvRobot f5410c;

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
        }

        TextureView$SurfaceTextureListenerC1939a(@NonNull NvSurfacePreview nvSurfacePreview, NvRobot nvRobot) {
            this.f5408a = new WeakReference<>(nvSurfacePreview);
            this.f5410c = nvRobot;
        }

        /* renamed from: a */
        private void m7168a(SurfaceTexture surfaceTexture) {
            if (this.f5408a.get() == null) {
                return;
            }
            this.f5409b = surfaceTexture;
            NvRobot nvRobot = this.f5410c;
            if (nvRobot != null) {
                nvRobot.m7710a(new Surface(surfaceTexture));
                return;
            }
            throw new RuntimeException("robot is null");
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
            m7168a(surfaceTexture);
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
            m7168a(surfaceTexture);
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
            NvRobot nvRobot = this.f5410c;
            if (nvRobot != null) {
                nvRobot.m7685j();
            }
            this.f5409b = null;
            return this.f5408a.get() == null ? true : true;
        }
    }
}
