package com.navatics.app.widget;

import android.content.Context;
import android.view.ViewConfiguration;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;

/* renamed from: com.navatics.app.widget.e */
/* loaded from: classes.dex */
public class Scroller {

    /* renamed from: B */
    private static float f5662B;

    /* renamed from: C */
    private static float f5663C;

    /* renamed from: u */
    private static float f5664u = (float) (Math.log(0.75d) / Math.log(0.9d));

    /* renamed from: v */
    private static float f5665v = 800.0f;

    /* renamed from: w */
    private static float f5666w = 0.4f;

    /* renamed from: x */
    private static float f5667x = 1.0f - f5666w;

    /* renamed from: y */
    private static final float[] f5668y = new float[101];

    /* renamed from: A */
    private final float f5669A;

    /* renamed from: a */
    private int f5670a;

    /* renamed from: b */
    private int f5671b;

    /* renamed from: c */
    private int f5672c;

    /* renamed from: d */
    private int f5673d;

    /* renamed from: e */
    private int f5674e;

    /* renamed from: f */
    private int f5675f;

    /* renamed from: g */
    private int f5676g;

    /* renamed from: h */
    private int f5677h;

    /* renamed from: i */
    private int f5678i;

    /* renamed from: j */
    private int f5679j;

    /* renamed from: k */
    private int f5680k;

    /* renamed from: l */
    private long f5681l;

    /* renamed from: m */
    private int f5682m;

    /* renamed from: n */
    private float f5683n;

    /* renamed from: o */
    private float f5684o;

    /* renamed from: p */
    private float f5685p;

    /* renamed from: q */
    private boolean f5686q;

    /* renamed from: r */
    private Interpolator f5687r;

    /* renamed from: s */
    private boolean f5688s;

    /* renamed from: t */
    private float f5689t;

    /* renamed from: z */
    private float f5690z;

    static {
        float f;
        float f2;
        float f3 = 0.0f;
        for (int i = 0; i <= 100; i++) {
            float f4 = i / 100.0f;
            float f5 = 1.0f;
            while (true) {
                float f6 = ((f5 - f3) / 2.0f) + f3;
                float f7 = 1.0f - f6;
                f = 3.0f * f6 * f7;
                f2 = f6 * f6 * f6;
                float f8 = (((f7 * f5666w) + (f5667x * f6)) * f) + f2;
                if (Math.abs(f8 - f4) < 1.0E-5d) {
                    break;
                } else if (f8 > f4) {
                    f5 = f6;
                } else {
                    f3 = f6;
                }
            }
            f5668y[i] = f + f2;
        }
        f5668y[100] = 1.0f;
        f5662B = 8.0f;
        f5663C = 1.0f;
        f5663C = 1.0f / m6969a(1.0f);
    }

    public Scroller(Context context, Interpolator interpolator) {
        this(context, interpolator, true);
    }

    public Scroller(Context context, Interpolator interpolator, boolean z) {
        this.f5686q = true;
        this.f5687r = interpolator;
        this.f5669A = context.getResources().getDisplayMetrics().density * 160.0f;
        this.f5690z = m6964b(ViewConfiguration.getScrollFriction());
        this.f5688s = z;
    }

    /* renamed from: b */
    private float m6964b(float f) {
        return this.f5669A * 386.0878f * f;
    }

    /* renamed from: a */
    public final boolean m6970a() {
        return this.f5686q;
    }

    /* renamed from: a */
    public final void m6966a(boolean z) {
        this.f5686q = z;
    }

    /* renamed from: b */
    public final int m6965b() {
        return this.f5679j;
    }

    /* renamed from: c */
    public final int m6963c() {
        return this.f5680k;
    }

    /* renamed from: d */
    public float m6962d() {
        return this.f5689t - ((this.f5690z * m6956j()) / 2000.0f);
    }

    /* renamed from: e */
    public final int m6961e() {
        return this.f5671b;
    }

    /* renamed from: f */
    public final int m6960f() {
        return this.f5672c;
    }

    /* renamed from: g */
    public final int m6959g() {
        return this.f5673d;
    }

    /* renamed from: h */
    public final int m6958h() {
        return this.f5674e;
    }

    /* renamed from: i */
    public boolean m6957i() {
        float interpolation;
        if (this.f5686q) {
            return false;
        }
        int currentAnimationTimeMillis = (int) (AnimationUtils.currentAnimationTimeMillis() - this.f5681l);
        int i = this.f5682m;
        if (currentAnimationTimeMillis < i) {
            switch (this.f5670a) {
                case 0:
                    float f = currentAnimationTimeMillis * this.f5683n;
                    Interpolator interpolator = this.f5687r;
                    if (interpolator == null) {
                        interpolation = m6969a(f);
                    } else {
                        interpolation = interpolator.getInterpolation(f);
                    }
                    this.f5679j = this.f5671b + Math.round(this.f5684o * interpolation);
                    this.f5680k = this.f5672c + Math.round(interpolation * this.f5685p);
                    break;
                case 1:
                    float f2 = currentAnimationTimeMillis / i;
                    int i2 = (int) (f2 * 100.0f);
                    float f3 = i2 / 100.0f;
                    int i3 = i2 + 1;
                    float[] fArr = f5668y;
                    float f4 = fArr[i2];
                    float f5 = f4 + (((f2 - f3) / ((i3 / 100.0f) - f3)) * (fArr[i3] - f4));
                    int i4 = this.f5671b;
                    this.f5679j = i4 + Math.round((this.f5673d - i4) * f5);
                    this.f5679j = Math.min(this.f5679j, this.f5676g);
                    this.f5679j = Math.max(this.f5679j, this.f5675f);
                    int i5 = this.f5672c;
                    this.f5680k = i5 + Math.round(f5 * (this.f5674e - i5));
                    this.f5680k = Math.min(this.f5680k, this.f5678i);
                    this.f5680k = Math.max(this.f5680k, this.f5677h);
                    if (this.f5679j == this.f5673d && this.f5680k == this.f5674e) {
                        this.f5686q = true;
                        break;
                    }
                    break;
            }
        } else {
            this.f5679j = this.f5673d;
            this.f5680k = this.f5674e;
            this.f5686q = true;
        }
        return true;
    }

    /* renamed from: a */
    public void m6968a(int i, int i2, int i3, int i4, int i5) {
        this.f5670a = 0;
        this.f5686q = false;
        this.f5682m = i5;
        this.f5681l = AnimationUtils.currentAnimationTimeMillis();
        this.f5671b = i;
        this.f5672c = i2;
        this.f5673d = i + i3;
        this.f5674e = i2 + i4;
        this.f5684o = i3;
        this.f5685p = i4;
        this.f5683n = 1.0f / this.f5682m;
    }

    /* renamed from: a */
    public void m6967a(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        int i9;
        int i10;
        if (!this.f5688s || this.f5686q) {
            i9 = i3;
            i10 = i4;
        } else {
            float m6962d = m6962d();
            float f = this.f5673d - this.f5671b;
            float f2 = this.f5674e - this.f5672c;
            float sqrt = (float) Math.sqrt((f * f) + (f2 * f2));
            float f3 = (f / sqrt) * m6962d;
            float f4 = (f2 / sqrt) * m6962d;
            i9 = i3;
            float f5 = i9;
            if (Math.signum(f5) == Math.signum(f3)) {
                i10 = i4;
                float f6 = i10;
                if (Math.signum(f6) == Math.signum(f4)) {
                    i9 = (int) (f5 + f3);
                    i10 = (int) (f6 + f4);
                }
            } else {
                i10 = i4;
            }
        }
        this.f5670a = 1;
        this.f5686q = false;
        float sqrt2 = (float) Math.sqrt((i9 * i9) + (i10 * i10));
        this.f5689t = sqrt2;
        double log = Math.log((f5666w * sqrt2) / f5665v);
        this.f5682m = (int) (Math.exp(log / (f5664u - 1.0d)) * 1000.0d);
        this.f5681l = AnimationUtils.currentAnimationTimeMillis();
        this.f5671b = i;
        this.f5672c = i2;
        int i11 = (sqrt2 > 0.0f ? 1 : (sqrt2 == 0.0f ? 0 : -1));
        float f7 = i11 == 0 ? 1.0f : i9 / sqrt2;
        float f8 = i11 != 0 ? i10 / sqrt2 : 1.0f;
        double d = f5665v;
        float f9 = f5664u;
        this.f5675f = i5;
        this.f5676g = i6;
        this.f5677h = i7;
        this.f5678i = i8;
        float exp = (int) (d * Math.exp((f9 / (f9 - 1.0d)) * log));
        this.f5673d = i + Math.round(f7 * exp);
        this.f5673d = Math.min(this.f5673d, this.f5676g);
        this.f5673d = Math.max(this.f5673d, this.f5675f);
        this.f5674e = Math.round(exp * f8) + i2;
        this.f5674e = Math.min(this.f5674e, this.f5678i);
        this.f5674e = Math.max(this.f5674e, this.f5677h);
    }

    /* renamed from: a */
    static float m6969a(float f) {
        float exp;
        float f2 = f * f5662B;
        if (f2 < 1.0f) {
            exp = f2 - (1.0f - ((float) Math.exp(-f2)));
        } else {
            exp = ((1.0f - ((float) Math.exp(1.0f - f2))) * 0.63212055f) + 0.36787945f;
        }
        return exp * f5663C;
    }

    /* renamed from: j */
    public int m6956j() {
        return (int) (AnimationUtils.currentAnimationTimeMillis() - this.f5681l);
    }
}
