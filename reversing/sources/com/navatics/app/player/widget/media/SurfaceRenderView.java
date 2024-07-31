package com.navatics.app.player.widget.media;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import com.navatics.app.player.widget.media.IRenderView;
import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import tv.danmaku.ijk.media.player.IMediaPlayer;
import tv.danmaku.ijk.media.player.ISurfaceTextureHolder;

/* loaded from: classes.dex */
public class SurfaceRenderView extends SurfaceView implements IRenderView {

    /* renamed from: a */
    private MeasureHelper f4958a;

    /* renamed from: b */
    private int f4959b;

    /* renamed from: c */
    private SurfaceHolder$CallbackC1878b f4960c;

    @Override // com.navatics.app.player.widget.media.IRenderView
    /* renamed from: a */
    public boolean mo7565a() {
        return true;
    }

    @Override // com.navatics.app.player.widget.media.IRenderView
    public Bitmap getFrameBitmap() {
        return null;
    }

    @Override // com.navatics.app.player.widget.media.IRenderView
    public View getView() {
        return this;
    }

    public SurfaceRenderView(Context context) {
        super(context);
        this.f4959b = 17;
        m7577a(context);
    }

    public SurfaceRenderView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f4959b = 17;
        m7577a(context);
    }

    public SurfaceRenderView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f4959b = 17;
        m7577a(context);
    }

    /* renamed from: a */
    private void m7577a(Context context) {
        this.f4958a = new MeasureHelper(this);
        this.f4960c = new SurfaceHolder$CallbackC1878b(this);
        getHolder().addCallback(this.f4960c);
        getHolder().setType(0);
    }

    @Override // com.navatics.app.player.widget.media.IRenderView
    /* renamed from: a */
    public void mo7564a(int i, int i2) {
        if (i <= 0 || i2 <= 0) {
            return;
        }
        this.f4958a.m7538a(i, i2);
        getHolder().setFixedSize(i, i2);
        requestLayout();
    }

    @Override // com.navatics.app.player.widget.media.IRenderView
    /* renamed from: b */
    public void mo7562b(int i, int i2) {
        if (i <= 0 || i2 <= 0) {
            return;
        }
        this.f4958a.m7535b(i, i2);
        requestLayout();
    }

    @Override // com.navatics.app.player.widget.media.IRenderView
    public void setVideoPosition(int i) {
        this.f4959b = i;
    }

    @Override // com.navatics.app.player.widget.media.IRenderView
    public int getVideoPosition() {
        return this.f4959b;
    }

    @Override // com.navatics.app.player.widget.media.IRenderView
    public void setVideoRotation(int i) {
        Log.e("", "SurfaceView doesn't support rotation (" + i + ")!\n");
    }

    @Override // com.navatics.app.player.widget.media.IRenderView
    public void setAspectRatio(int i) {
        this.f4958a.m7536b(i);
        requestLayout();
    }

    @Override // android.view.SurfaceView, android.view.View
    protected void onMeasure(int i, int i2) {
        this.f4958a.m7534c(i, i2);
        setMeasuredDimension(this.f4958a.m7540a(), this.f4958a.m7537b());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.navatics.app.player.widget.media.SurfaceRenderView$a */
    /* loaded from: classes.dex */
    public static final class C1877a implements IRenderView.InterfaceC1882b {

        /* renamed from: a */
        private SurfaceRenderView f4961a;

        /* renamed from: b */
        private SurfaceHolder f4962b;

        public C1877a(@NonNull SurfaceRenderView surfaceRenderView, @Nullable SurfaceHolder surfaceHolder) {
            this.f4961a = surfaceRenderView;
            this.f4962b = surfaceHolder;
        }

        @Override // com.navatics.app.player.widget.media.IRenderView.InterfaceC1882b
        /* renamed from: a */
        public void mo7556a(IMediaPlayer iMediaPlayer) {
            if (iMediaPlayer != null) {
                if (Build.VERSION.SDK_INT >= 16 && (iMediaPlayer instanceof ISurfaceTextureHolder)) {
                    ((ISurfaceTextureHolder) iMediaPlayer).setSurfaceTexture(null);
                }
                iMediaPlayer.setDisplay(this.f4962b);
            }
        }

        @Override // com.navatics.app.player.widget.media.IRenderView.InterfaceC1882b
        @NonNull
        /* renamed from: a */
        public IRenderView mo7557a() {
            return this.f4961a;
        }
    }

    @Override // com.navatics.app.player.widget.media.IRenderView
    /* renamed from: a */
    public void mo7563a(IRenderView.InterfaceC1881a interfaceC1881a) {
        this.f4960c.m7576a(interfaceC1881a);
    }

    @Override // com.navatics.app.player.widget.media.IRenderView
    /* renamed from: b */
    public void mo7561b(IRenderView.InterfaceC1881a interfaceC1881a) {
        this.f4960c.m7575b(interfaceC1881a);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.navatics.app.player.widget.media.SurfaceRenderView$b */
    /* loaded from: classes.dex */
    public static final class SurfaceHolder$CallbackC1878b implements SurfaceHolder.Callback {

        /* renamed from: a */
        private SurfaceHolder f4963a;

        /* renamed from: b */
        private boolean f4964b;

        /* renamed from: c */
        private int f4965c;

        /* renamed from: d */
        private int f4966d;

        /* renamed from: e */
        private int f4967e;

        /* renamed from: f */
        private WeakReference<SurfaceRenderView> f4968f;

        /* renamed from: g */
        private Map<IRenderView.InterfaceC1881a, Object> f4969g = new ConcurrentHashMap();

        public SurfaceHolder$CallbackC1878b(@NonNull SurfaceRenderView surfaceRenderView) {
            this.f4968f = new WeakReference<>(surfaceRenderView);
        }

        /* renamed from: a */
        public void m7576a(@NonNull IRenderView.InterfaceC1881a interfaceC1881a) {
            C1877a c1877a;
            this.f4969g.put(interfaceC1881a, interfaceC1881a);
            if (this.f4963a != null) {
                c1877a = new C1877a(this.f4968f.get(), this.f4963a);
                interfaceC1881a.mo7559a(c1877a, this.f4966d, this.f4967e);
            } else {
                c1877a = null;
            }
            if (this.f4964b) {
                if (c1877a == null) {
                    c1877a = new C1877a(this.f4968f.get(), this.f4963a);
                }
                interfaceC1881a.mo7558a(c1877a, this.f4965c, this.f4966d, this.f4967e);
            }
        }

        /* renamed from: b */
        public void m7575b(@NonNull IRenderView.InterfaceC1881a interfaceC1881a) {
            this.f4969g.remove(interfaceC1881a);
        }

        @Override // android.view.SurfaceHolder.Callback
        public void surfaceCreated(SurfaceHolder surfaceHolder) {
            this.f4963a = surfaceHolder;
            this.f4964b = false;
            this.f4965c = 0;
            this.f4966d = 0;
            this.f4967e = 0;
            C1877a c1877a = new C1877a(this.f4968f.get(), this.f4963a);
            for (IRenderView.InterfaceC1881a interfaceC1881a : this.f4969g.keySet()) {
                interfaceC1881a.mo7559a(c1877a, 0, 0);
            }
        }

        @Override // android.view.SurfaceHolder.Callback
        public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
            this.f4963a = null;
            this.f4964b = false;
            this.f4965c = 0;
            this.f4966d = 0;
            this.f4967e = 0;
            C1877a c1877a = new C1877a(this.f4968f.get(), this.f4963a);
            for (IRenderView.InterfaceC1881a interfaceC1881a : this.f4969g.keySet()) {
                interfaceC1881a.mo7560a(c1877a);
            }
        }

        @Override // android.view.SurfaceHolder.Callback
        public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
            this.f4963a = surfaceHolder;
            this.f4964b = true;
            this.f4965c = i;
            this.f4966d = i2;
            this.f4967e = i3;
            C1877a c1877a = new C1877a(this.f4968f.get(), this.f4963a);
            for (IRenderView.InterfaceC1881a interfaceC1881a : this.f4969g.keySet()) {
                interfaceC1881a.mo7558a(c1877a, i, i2, i3);
            }
        }
    }

    @Override // android.view.View
    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName(SurfaceRenderView.class.getName());
    }

    @Override // android.view.View
    @TargetApi(14)
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        if (Build.VERSION.SDK_INT >= 14) {
            accessibilityNodeInfo.setClassName(SurfaceRenderView.class.getName());
        }
    }
}
