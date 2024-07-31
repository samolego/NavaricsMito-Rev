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
import com.navatics.app.widget.InterfaceC1889d;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes.dex */
public class NvTextureRenderView extends TextureView implements InterfaceC1889d {

    /* renamed from: a */
    private int f5438a;

    /* renamed from: b */
    private int f5439b;

    /* renamed from: c */
    private int f5440c;

    /* renamed from: d */
    private int f5441d;

    /* renamed from: e */
    private int f5442e;

    /* renamed from: f */
    private TextureViewSurfaceTextureListenerC1862b f5443f;

    public View getView() {
        return this;
    }

    public void setVideoRotation(int i) {
    }

    public NvTextureRenderView(Context context) {
        super(context);
        this.f5442e = 0;
        m5705a(context);
    }

    public NvTextureRenderView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f5442e = 0;
        m5705a(context);
    }

    public NvTextureRenderView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f5442e = 0;
        m5705a(context);
    }

    /* renamed from: a */
    private void m5705a(Context context) {
        this.f5443f = new TextureViewSurfaceTextureListenerC1862b(this);
        setSurfaceTextureListener(this.f5443f);
    }

    public void setAspectRatio(int i) {
        this.f5442e = i;
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        float f;
        int i3;
        int defaultSize = View.getDefaultSize(this.f5438a, i);
        int defaultSize2 = View.getDefaultSize(this.f5439b, i2);
        if (defaultSize < defaultSize2) {
            Log.e("NvTextureRenderView", "wtf ??? width < height detected.");
        }
        Log.d("NvTextureRenderView", "width " + defaultSize + ", height " + defaultSize2);
        if (this.f5442e != 3) {
            if (this.f5438a > 0 && this.f5439b > 0) {
                View.MeasureSpec.getMode(i);
                i = View.MeasureSpec.getSize(i);
                View.MeasureSpec.getMode(i2);
                i2 = View.MeasureSpec.getSize(i2);
                float f2 = i;
                float f3 = i2;
                float f4 = f2 / f3;
                switch (this.f5442e) {
                    case 4:
                        f = 1.7777778f;
                        break;
                    case 5:
                        f = 1.3333334f;
                        break;
                    default:
                        f = this.f5438a / this.f5439b;
                        int i4 = this.f5440c;
                        if (i4 > 0 && (i3 = this.f5441d) > 0) {
                            f = (f * i4) / i3;
                            break;
                        }
                        break;
                }
                boolean z = f > f4;
                switch (this.f5442e) {
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
                            i = Math.min(this.f5438a, i);
                            i2 = (int) (i / f);
                            break;
                        } else {
                            i2 = Math.min(this.f5439b, i2);
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

    public InterfaceC1889d.b getSurfaceHolder() {
        return new C1861a(this, this.f5443f.f5446a);
    }

    /* renamed from: com.navatics.app.widget.NvTextureRenderView$a */
    /* loaded from: classes.dex */
    private static final class C1861a implements InterfaceC1889d.b {

        /* renamed from: a */
        private NvTextureRenderView f5444a;

        /* renamed from: b */
        private SurfaceTexture f5445b;

        public C1861a(@NonNull NvTextureRenderView nvTextureRenderView, @Nullable SurfaceTexture surfaceTexture) {
            this.f5444a = nvTextureRenderView;
            this.f5445b = surfaceTexture;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.navatics.app.widget.NvTextureRenderView$b */
    /* loaded from: classes.dex */
    public static final class TextureViewSurfaceTextureListenerC1862b implements TextureView.SurfaceTextureListener {

        /* renamed from: a */
        private SurfaceTexture f5446a;

        /* renamed from: b */
        private boolean f5447b;

        /* renamed from: c */
        private int f5448c;

        /* renamed from: d */
        private int f5449d;

        /* renamed from: e */
        private WeakReference<NvTextureRenderView> f5450e;

        /* renamed from: f */
        private Map<InterfaceC1889d.a, Object> f5451f = new ConcurrentHashMap();

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
        }

        public TextureViewSurfaceTextureListenerC1862b(@NonNull NvTextureRenderView nvTextureRenderView) {
            this.f5450e = new WeakReference<>(nvTextureRenderView);
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
            this.f5446a = surfaceTexture;
            this.f5447b = false;
            this.f5448c = 0;
            this.f5449d = 0;
            C1861a c1861a = new C1861a(this.f5450e.get(), surfaceTexture);
            Iterator<InterfaceC1889d.a> it = this.f5451f.keySet().iterator();
            while (it.hasNext()) {
                it.next().m5881a(c1861a, 0, 0);
            }
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
            this.f5446a = surfaceTexture;
            this.f5447b = true;
            this.f5448c = i;
            this.f5449d = i2;
            C1861a c1861a = new C1861a(this.f5450e.get(), surfaceTexture);
            Iterator<InterfaceC1889d.a> it = this.f5451f.keySet().iterator();
            while (it.hasNext()) {
                it.next().m5882a(c1861a, 0, i, i2);
            }
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
            this.f5446a = surfaceTexture;
            this.f5447b = false;
            this.f5448c = 0;
            this.f5449d = 0;
            C1861a c1861a = new C1861a(this.f5450e.get(), surfaceTexture);
            Iterator<InterfaceC1889d.a> it = this.f5451f.keySet().iterator();
            while (it.hasNext()) {
                it.next().m5880a(c1861a);
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