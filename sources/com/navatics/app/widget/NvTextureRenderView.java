package com.navatics.app.widget;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.TextureView;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import com.navatics.app.widget.NvRenderView;
import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes.dex */
public class NvTextureRenderView extends TextureView implements NvRenderView {

    /* renamed from: a */
    private int f5416a;

    /* renamed from: b */
    private int f5417b;

    /* renamed from: c */
    private int f5418c;

    /* renamed from: d */
    private int f5419d;

    /* renamed from: e */
    private int f5420e;

    /* renamed from: f */
    private TextureView$SurfaceTextureListenerC1941b f5421f;

    public View getView() {
        return this;
    }

    public void setVideoRotation(int i) {
    }

    public NvTextureRenderView(Context context) {
        super(context);
        this.f5420e = 0;
        m7167a(context);
    }

    public NvTextureRenderView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f5420e = 0;
        m7167a(context);
    }

    public NvTextureRenderView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f5420e = 0;
        m7167a(context);
    }

    /* renamed from: a */
    private void m7167a(Context context) {
        this.f5421f = new TextureView$SurfaceTextureListenerC1941b(this);
        setSurfaceTextureListener(this.f5421f);
    }

    public void setAspectRatio(int i) {
        this.f5420e = i;
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        float f;
        int i3;
        int defaultSize = View.getDefaultSize(this.f5416a, i);
        int defaultSize2 = View.getDefaultSize(this.f5417b, i2);
        if (defaultSize < defaultSize2) {
            Log.e("NvTextureRenderView", "wtf ??? width < height detected.");
        }
        Log.d("NvTextureRenderView", "width " + defaultSize + ", height " + defaultSize2);
        if (this.f5420e != 3) {
            if (this.f5416a > 0 && this.f5417b > 0) {
                View.MeasureSpec.getMode(i);
                i = View.MeasureSpec.getSize(i);
                View.MeasureSpec.getMode(i2);
                i2 = View.MeasureSpec.getSize(i2);
                float f2 = i;
                float f3 = i2;
                float f4 = f2 / f3;
                switch (this.f5420e) {
                    case 4:
                        f = 1.7777778f;
                        break;
                    case 5:
                        f = 1.3333334f;
                        break;
                    default:
                        f = this.f5416a / this.f5417b;
                        int i4 = this.f5418c;
                        if (i4 > 0 && (i3 = this.f5419d) > 0) {
                            f = (f * i4) / i3;
                            break;
                        }
                        break;
                }
                boolean z = f > f4;
                switch (this.f5420e) {
                    case 0:
                    case 4:
                    case 5:
                        if (!z) {
                            i = (int) (f3 * f);
                            break;
                        } else {
                            i2 = (int) (f2 / f);
                            break;
                        }
                    case 1:
                        if (!z) {
                            i2 = (int) (f2 / f);
                            break;
                        } else {
                            i = (int) (f3 * f);
                            break;
                        }
                    case 2:
                    case 3:
                    default:
                        if (z) {
                            i = Math.min(this.f5416a, i);
                            i2 = (int) (i / f);
                            break;
                        } else {
                            i2 = Math.min(this.f5417b, i2);
                            i = (int) (i2 * f);
                            break;
                        }
                }
            } else {
                i = defaultSize;
                i2 = defaultSize2;
            }
        }
        Log.d("NvTextureRenderView", "setMeasuredDimension, width " + i + ", height " + i2);
        setMeasuredDimension(i, i2);
    }

    public NvRenderView.InterfaceC1968b getSurfaceHolder() {
        return new C1940a(this, this.f5421f.f5424a);
    }

    /* renamed from: com.navatics.app.widget.NvTextureRenderView$a */
    /* loaded from: classes.dex */
    private static final class C1940a implements NvRenderView.InterfaceC1968b {

        /* renamed from: a */
        private NvTextureRenderView f5422a;

        /* renamed from: b */
        private SurfaceTexture f5423b;

        public C1940a(@NonNull NvTextureRenderView nvTextureRenderView, @Nullable SurfaceTexture surfaceTexture) {
            this.f5422a = nvTextureRenderView;
            this.f5423b = surfaceTexture;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.navatics.app.widget.NvTextureRenderView$b */
    /* loaded from: classes.dex */
    public static final class TextureView$SurfaceTextureListenerC1941b implements TextureView.SurfaceTextureListener {

        /* renamed from: a */
        private SurfaceTexture f5424a;

        /* renamed from: b */
        private boolean f5425b;

        /* renamed from: c */
        private int f5426c;

        /* renamed from: d */
        private int f5427d;

        /* renamed from: e */
        private WeakReference<NvTextureRenderView> f5428e;

        /* renamed from: f */
        private Map<NvRenderView.InterfaceC1967a, Object> f5429f = new ConcurrentHashMap();

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
        }

        public TextureView$SurfaceTextureListenerC1941b(@NonNull NvTextureRenderView nvTextureRenderView) {
            this.f5428e = new WeakReference<>(nvTextureRenderView);
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
            this.f5424a = surfaceTexture;
            this.f5425b = false;
            this.f5426c = 0;
            this.f5427d = 0;
            C1940a c1940a = new C1940a(this.f5428e.get(), surfaceTexture);
            for (NvRenderView.InterfaceC1967a interfaceC1967a : this.f5429f.keySet()) {
                interfaceC1967a.m6984a(c1940a, 0, 0);
            }
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
            this.f5424a = surfaceTexture;
            this.f5425b = true;
            this.f5426c = i;
            this.f5427d = i2;
            C1940a c1940a = new C1940a(this.f5428e.get(), surfaceTexture);
            for (NvRenderView.InterfaceC1967a interfaceC1967a : this.f5429f.keySet()) {
                interfaceC1967a.m6983a(c1940a, 0, i, i2);
            }
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
            this.f5424a = surfaceTexture;
            this.f5425b = false;
            this.f5426c = 0;
            this.f5427d = 0;
            C1940a c1940a = new C1940a(this.f5428e.get(), surfaceTexture);
            for (NvRenderView.InterfaceC1967a interfaceC1967a : this.f5429f.keySet()) {
                interfaceC1967a.m6985a(c1940a);
            }
            return true;
        }
    }

    @Override // android.view.View
    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName(NvTextureRenderView.class.getName());
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(NvTextureRenderView.class.getName());
    }
}
