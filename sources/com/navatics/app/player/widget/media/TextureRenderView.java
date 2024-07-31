package com.navatics.app.player.widget.media;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.SurfaceTexture;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.Surface;
import android.view.TextureView;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import com.navatics.app.player.widget.media.IRenderView;
import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import tv.danmaku.ijk.media.player.IMediaPlayer;
import tv.danmaku.ijk.media.player.ISurfaceTextureHolder;
import tv.danmaku.ijk.media.player.ISurfaceTextureHost;

@TargetApi(14)
/* loaded from: classes.dex */
public class TextureRenderView extends TextureView implements IRenderView {

    /* renamed from: a */
    private MeasureHelper f4970a;

    /* renamed from: b */
    private int f4971b;

    /* renamed from: c */
    private TextureView$SurfaceTextureListenerC1880b f4972c;

    @Override // com.navatics.app.player.widget.media.IRenderView
    /* renamed from: a */
    public boolean mo7565a() {
        return false;
    }

    @Override // com.navatics.app.player.widget.media.IRenderView
    public View getView() {
        return this;
    }

    public TextureRenderView(Context context) {
        super(context);
        this.f4971b = 17;
        m7574a(context);
    }

    public TextureRenderView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f4971b = 17;
        m7574a(context);
    }

    public TextureRenderView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f4971b = 17;
        m7574a(context);
    }

    /* renamed from: a */
    private void m7574a(Context context) {
        this.f4970a = new MeasureHelper(this);
        this.f4972c = new TextureView$SurfaceTextureListenerC1880b(this);
        setSurfaceTextureListener(this.f4972c);
    }

    @Override // com.navatics.app.player.widget.media.IRenderView
    public Bitmap getFrameBitmap() {
        return getBitmap();
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        this.f4972c.m7571a();
        super.onDetachedFromWindow();
        this.f4972c.m7567b();
    }

    @Override // com.navatics.app.player.widget.media.IRenderView
    /* renamed from: a */
    public void mo7564a(int i, int i2) {
        if (i <= 0 || i2 <= 0) {
            return;
        }
        this.f4970a.m7538a(i, i2);
        requestLayout();
    }

    @Override // com.navatics.app.player.widget.media.IRenderView
    /* renamed from: b */
    public void mo7562b(int i, int i2) {
        if (i <= 0 || i2 <= 0) {
            return;
        }
        this.f4970a.m7535b(i, i2);
        requestLayout();
    }

    @Override // com.navatics.app.player.widget.media.IRenderView
    public void setVideoRotation(int i) {
        this.f4970a.m7539a(i);
        setRotation(i);
    }

    @Override // com.navatics.app.player.widget.media.IRenderView
    public void setAspectRatio(int i) {
        this.f4970a.m7536b(i);
        requestLayout();
    }

    @Override // com.navatics.app.player.widget.media.IRenderView
    public void setVideoPosition(int i) {
        this.f4971b = i;
    }

    @Override // com.navatics.app.player.widget.media.IRenderView
    public int getVideoPosition() {
        return this.f4971b;
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        this.f4970a.m7534c(i, i2);
        Log.i("", "TextureRenderView : , MeasuredWidth=" + this.f4970a.m7540a() + ", MeasuredHeight=" + this.f4970a.m7537b());
        setMeasuredDimension(this.f4970a.m7540a(), this.f4970a.m7537b());
    }

    @Override // android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
    }

    public IRenderView.InterfaceC1882b getSurfaceHolder() {
        return new C1879a(this, this.f4972c.f4976a, this.f4972c);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.navatics.app.player.widget.media.TextureRenderView$a */
    /* loaded from: classes.dex */
    public static final class C1879a implements IRenderView.InterfaceC1882b {

        /* renamed from: a */
        private TextureRenderView f4973a;

        /* renamed from: b */
        private SurfaceTexture f4974b;

        /* renamed from: c */
        private ISurfaceTextureHost f4975c;

        public C1879a(@NonNull TextureRenderView textureRenderView, @Nullable SurfaceTexture surfaceTexture, @NonNull ISurfaceTextureHost iSurfaceTextureHost) {
            this.f4973a = textureRenderView;
            this.f4974b = surfaceTexture;
            this.f4975c = iSurfaceTextureHost;
        }

        @Override // com.navatics.app.player.widget.media.IRenderView.InterfaceC1882b
        @TargetApi(16)
        /* renamed from: a */
        public void mo7556a(IMediaPlayer iMediaPlayer) {
            if (iMediaPlayer == null) {
                return;
            }
            if (Build.VERSION.SDK_INT >= 16 && (iMediaPlayer instanceof ISurfaceTextureHolder)) {
                ISurfaceTextureHolder iSurfaceTextureHolder = (ISurfaceTextureHolder) iMediaPlayer;
                this.f4973a.f4972c.m7568a(false);
                SurfaceTexture surfaceTexture = iSurfaceTextureHolder.getSurfaceTexture();
                if (surfaceTexture != null) {
                    this.f4973a.setSurfaceTexture(surfaceTexture);
                    return;
                }
                iSurfaceTextureHolder.setSurfaceTexture(this.f4974b);
                iSurfaceTextureHolder.setSurfaceTextureHost(this.f4973a.f4972c);
                return;
            }
            iMediaPlayer.setSurface(m7572b());
        }

        @Override // com.navatics.app.player.widget.media.IRenderView.InterfaceC1882b
        @NonNull
        /* renamed from: a */
        public IRenderView mo7557a() {
            return this.f4973a;
        }

        @Nullable
        /* renamed from: b */
        public Surface m7572b() {
            SurfaceTexture surfaceTexture = this.f4974b;
            if (surfaceTexture == null) {
                return null;
            }
            return new Surface(surfaceTexture);
        }
    }

    @Override // com.navatics.app.player.widget.media.IRenderView
    /* renamed from: a */
    public void mo7563a(IRenderView.InterfaceC1881a interfaceC1881a) {
        this.f4972c.m7569a(interfaceC1881a);
    }

    @Override // com.navatics.app.player.widget.media.IRenderView
    /* renamed from: b */
    public void mo7561b(IRenderView.InterfaceC1881a interfaceC1881a) {
        this.f4972c.m7566b(interfaceC1881a);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.navatics.app.player.widget.media.TextureRenderView$b */
    /* loaded from: classes.dex */
    public static final class TextureView$SurfaceTextureListenerC1880b implements TextureView.SurfaceTextureListener, ISurfaceTextureHost {

        /* renamed from: a */
        private SurfaceTexture f4976a;

        /* renamed from: b */
        private boolean f4977b;

        /* renamed from: c */
        private int f4978c;

        /* renamed from: d */
        private int f4979d;

        /* renamed from: h */
        private WeakReference<TextureRenderView> f4983h;

        /* renamed from: e */
        private boolean f4980e = true;

        /* renamed from: f */
        private boolean f4981f = false;

        /* renamed from: g */
        private boolean f4982g = false;

        /* renamed from: i */
        private Map<IRenderView.InterfaceC1881a, Object> f4984i = new ConcurrentHashMap();

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
        }

        public TextureView$SurfaceTextureListenerC1880b(@NonNull TextureRenderView textureRenderView) {
            this.f4983h = new WeakReference<>(textureRenderView);
        }

        /* renamed from: a */
        public void m7568a(boolean z) {
            this.f4980e = z;
        }

        /* renamed from: a */
        public void m7569a(@NonNull IRenderView.InterfaceC1881a interfaceC1881a) {
            C1879a c1879a;
            this.f4984i.put(interfaceC1881a, interfaceC1881a);
            if (this.f4976a != null) {
                c1879a = new C1879a(this.f4983h.get(), this.f4976a, this);
                interfaceC1881a.mo7559a(c1879a, this.f4978c, this.f4979d);
            } else {
                c1879a = null;
            }
            if (this.f4977b) {
                if (c1879a == null) {
                    c1879a = new C1879a(this.f4983h.get(), this.f4976a, this);
                }
                interfaceC1881a.mo7558a(c1879a, 0, this.f4978c, this.f4979d);
            }
        }

        /* renamed from: b */
        public void m7566b(@NonNull IRenderView.InterfaceC1881a interfaceC1881a) {
            this.f4984i.remove(interfaceC1881a);
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
            this.f4976a = surfaceTexture;
            this.f4977b = false;
            this.f4978c = 0;
            this.f4979d = 0;
            C1879a c1879a = new C1879a(this.f4983h.get(), surfaceTexture, this);
            for (IRenderView.InterfaceC1881a interfaceC1881a : this.f4984i.keySet()) {
                interfaceC1881a.mo7559a(c1879a, 0, 0);
            }
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
            this.f4976a = surfaceTexture;
            this.f4977b = true;
            this.f4978c = i;
            this.f4979d = i2;
            C1879a c1879a = new C1879a(this.f4983h.get(), surfaceTexture, this);
            for (IRenderView.InterfaceC1881a interfaceC1881a : this.f4984i.keySet()) {
                interfaceC1881a.mo7558a(c1879a, 0, i, i2);
            }
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
            this.f4976a = surfaceTexture;
            this.f4977b = false;
            this.f4978c = 0;
            this.f4979d = 0;
            C1879a c1879a = new C1879a(this.f4983h.get(), surfaceTexture, this);
            for (IRenderView.InterfaceC1881a interfaceC1881a : this.f4984i.keySet()) {
                interfaceC1881a.mo7560a(c1879a);
            }
            Log.d("TextureRenderView", "onSurfaceTextureDestroyed: destroy: " + this.f4980e);
            return this.f4980e;
        }

        @Override // tv.danmaku.ijk.media.player.ISurfaceTextureHost
        public void releaseSurfaceTexture(SurfaceTexture surfaceTexture) {
            if (surfaceTexture == null) {
                Log.d("TextureRenderView", "releaseSurfaceTexture: null");
            } else if (this.f4982g) {
                if (surfaceTexture != this.f4976a) {
                    Log.d("TextureRenderView", "releaseSurfaceTexture: didDetachFromWindow(): release different SurfaceTexture");
                    surfaceTexture.release();
                } else if (!this.f4980e) {
                    Log.d("TextureRenderView", "releaseSurfaceTexture: didDetachFromWindow(): release detached SurfaceTexture");
                    surfaceTexture.release();
                } else {
                    Log.d("TextureRenderView", "releaseSurfaceTexture: didDetachFromWindow(): already released by TextureView");
                }
            } else if (this.f4981f) {
                if (surfaceTexture != this.f4976a) {
                    Log.d("TextureRenderView", "releaseSurfaceTexture: willDetachFromWindow(): release different SurfaceTexture");
                    surfaceTexture.release();
                } else if (!this.f4980e) {
                    Log.d("TextureRenderView", "releaseSurfaceTexture: willDetachFromWindow(): re-attach SurfaceTexture to TextureView");
                    m7568a(true);
                } else {
                    Log.d("TextureRenderView", "releaseSurfaceTexture: willDetachFromWindow(): will released by TextureView");
                }
            } else if (surfaceTexture != this.f4976a) {
                Log.d("TextureRenderView", "releaseSurfaceTexture: alive: release different SurfaceTexture");
                surfaceTexture.release();
            } else if (!this.f4980e) {
                Log.d("TextureRenderView", "releaseSurfaceTexture: alive: re-attach SurfaceTexture to TextureView");
                m7568a(true);
            } else {
                Log.d("TextureRenderView", "releaseSurfaceTexture: alive: will released by TextureView");
            }
        }

        /* renamed from: a */
        public void m7571a() {
            Log.d("TextureRenderView", "willDetachFromWindow()");
            this.f4981f = true;
        }

        /* renamed from: b */
        public void m7567b() {
            Log.d("TextureRenderView", "didDetachFromWindow()");
            this.f4982g = true;
        }
    }

    @Override // android.view.View
    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName(TextureRenderView.class.getName());
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(TextureRenderView.class.getName());
    }
}
