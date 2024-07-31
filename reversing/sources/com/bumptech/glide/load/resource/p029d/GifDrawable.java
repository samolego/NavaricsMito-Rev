package com.bumptech.glide.load.resource.p029d;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.annotation.VisibleForTesting;
import android.view.Gravity;
import com.bumptech.glide.Glide;
import com.bumptech.glide.gifdecoder.GifDecoder;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.load.resource.p029d.GifFrameLoader;
import com.bumptech.glide.util.Preconditions;
import java.nio.ByteBuffer;

/* renamed from: com.bumptech.glide.load.resource.d.c */
/* loaded from: classes.dex */
public class GifDrawable extends Drawable implements Animatable, GifFrameLoader.InterfaceC0764b {

    /* renamed from: a */
    private final C0762a f1100a;

    /* renamed from: b */
    private boolean f1101b;

    /* renamed from: c */
    private boolean f1102c;

    /* renamed from: d */
    private boolean f1103d;

    /* renamed from: e */
    private boolean f1104e;

    /* renamed from: f */
    private int f1105f;

    /* renamed from: g */
    private int f1106g;

    /* renamed from: h */
    private boolean f1107h;

    /* renamed from: i */
    private Paint f1108i;

    /* renamed from: j */
    private Rect f1109j;

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -2;
    }

    public GifDrawable(Context context, GifDecoder gifDecoder, Transformation<Bitmap> transformation, int i, int i2, Bitmap bitmap) {
        this(new C0762a(new GifFrameLoader(Glide.m12523a(context), gifDecoder, i, i2, transformation, bitmap)));
    }

    GifDrawable(C0762a c0762a) {
        this.f1104e = true;
        this.f1106g = -1;
        this.f1100a = (C0762a) Preconditions.m11580a(c0762a);
    }

    /* renamed from: a */
    public int m11870a() {
        return this.f1100a.f1110a.m11841d();
    }

    /* renamed from: b */
    public Bitmap m11868b() {
        return this.f1100a.f1110a.m11849a();
    }

    /* renamed from: a */
    public void m11869a(Transformation<Bitmap> transformation, Bitmap bitmap) {
        this.f1100a.f1110a.m11847a(transformation, bitmap);
    }

    /* renamed from: c */
    public ByteBuffer m11867c() {
        return this.f1100a.f1110a.m11839f();
    }

    /* renamed from: d */
    public int m11866d() {
        return this.f1100a.f1110a.m11838g();
    }

    /* renamed from: e */
    public int m11865e() {
        return this.f1100a.f1110a.m11840e();
    }

    /* renamed from: h */
    private void m11863h() {
        this.f1105f = 0;
    }

    @Override // android.graphics.drawable.Animatable
    public void start() {
        this.f1102c = true;
        m11863h();
        if (this.f1104e) {
            m11862i();
        }
    }

    @Override // android.graphics.drawable.Animatable
    public void stop() {
        this.f1102c = false;
        m11861j();
    }

    /* renamed from: i */
    private void m11862i() {
        Preconditions.m11576a(!this.f1103d, "You cannot start a recycled Drawable. Ensure thatyou clear any references to the Drawable when clearing the corresponding request.");
        if (this.f1100a.f1110a.m11838g() == 1) {
            invalidateSelf();
        } else if (this.f1101b) {
        } else {
            this.f1101b = true;
            this.f1100a.f1110a.m11845a(this);
            invalidateSelf();
        }
    }

    /* renamed from: j */
    private void m11861j() {
        this.f1101b = false;
        this.f1100a.f1110a.m11843b(this);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setVisible(boolean z, boolean z2) {
        Preconditions.m11576a(!this.f1103d, "Cannot change the visibility of a recycled resource. Ensure that you unset the Drawable from your View before changing the View's visibility.");
        this.f1104e = z;
        if (!z) {
            m11861j();
        } else if (this.f1102c) {
            m11862i();
        }
        return super.setVisible(z, z2);
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.f1100a.f1110a.m11844b();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.f1100a.f1110a.m11842c();
    }

    @Override // android.graphics.drawable.Animatable
    public boolean isRunning() {
        return this.f1101b;
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        this.f1107h = true;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(@NonNull Canvas canvas) {
        if (this.f1103d) {
            return;
        }
        if (this.f1107h) {
            Gravity.apply(119, getIntrinsicWidth(), getIntrinsicHeight(), getBounds(), m11860k());
            this.f1107h = false;
        }
        canvas.drawBitmap(this.f1100a.f1110a.m11836i(), (Rect) null, m11860k(), m11859l());
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        m11859l().setAlpha(i);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        m11859l().setColorFilter(colorFilter);
    }

    /* renamed from: k */
    private Rect m11860k() {
        if (this.f1109j == null) {
            this.f1109j = new Rect();
        }
        return this.f1109j;
    }

    /* renamed from: l */
    private Paint m11859l() {
        if (this.f1108i == null) {
            this.f1108i = new Paint(2);
        }
        return this.f1108i;
    }

    /* renamed from: m */
    private Drawable.Callback m11858m() {
        Drawable.Callback callback = getCallback();
        while (callback instanceof Drawable) {
            callback = ((Drawable) callback).getCallback();
        }
        return callback;
    }

    @Override // com.bumptech.glide.load.resource.p029d.GifFrameLoader.InterfaceC0764b
    /* renamed from: f */
    public void mo11827f() {
        if (m11858m() == null) {
            stop();
            invalidateSelf();
            return;
        }
        invalidateSelf();
        if (m11865e() == m11866d() - 1) {
            this.f1105f++;
        }
        int i = this.f1106g;
        if (i == -1 || this.f1105f < i) {
            return;
        }
        stop();
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable.ConstantState getConstantState() {
        return this.f1100a;
    }

    /* renamed from: g */
    public void m11864g() {
        this.f1103d = true;
        this.f1100a.f1110a.m11837h();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: GifDrawable.java */
    /* renamed from: com.bumptech.glide.load.resource.d.c$a */
    /* loaded from: classes.dex */
    public static final class C0762a extends Drawable.ConstantState {
        @VisibleForTesting

        /* renamed from: a */
        final GifFrameLoader f1110a;

        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            return 0;
        }

        C0762a(GifFrameLoader gifFrameLoader) {
            this.f1110a = gifFrameLoader;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        @NonNull
        public Drawable newDrawable(Resources resources) {
            return newDrawable();
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        @NonNull
        public Drawable newDrawable() {
            return new GifDrawable(this);
        }
    }
}
