package com.navatics.app.widget;

import android.content.Context;
import android.view.ViewConfiguration;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;

/* compiled from: Scroller.java */
/* renamed from: com.navatics.app.widget.e, reason: use source file name */
/* loaded from: classes.dex */
public class Scroller {

    /* renamed from: B */
    private static float f5684B;

    /* renamed from: C */
    private static float f5685C;

    /* renamed from: u */
    private static float f5686u = (float) (Math.log(0.75d) / Math.log(0.9d));

    /* renamed from: v */
    private static float f5687v = 800.0f;

    /* renamed from: w */
    private static float f5688w = 0.4f;

    /* renamed from: x */
    private static float f5689x = 1.0f - f5688w;

    /* renamed from: y */
    private static final float[] f5690y = new float[101];

    /* renamed from: A */
    private final float f5691A;

    /* renamed from: a */
    private int f5692a;

    /* renamed from: b */
    private int f5693b;

    /* renamed from: c */
    private int f5694c;

    /* renamed from: d */
    private int f5695d;

    /* renamed from: e */
    private int f5696e;

    /* renamed from: f */
    private int f5697f;

    /* renamed from: g */
    private int f5698g;

    /* renamed from: h */
    private int f5699h;

    /* renamed from: i */
    private int f5700i;

    /* renamed from: j */
    private int f5701j;

    /* renamed from: k */
    private int f5702k;

    /* renamed from: l */
    private long f5703l;

    /* renamed from: m */
    private int f5704m;

    /* renamed from: n */
    private float f5705n;

    /* renamed from: o */
    private float f5706o;

    /* renamed from: p */
    private float f5707p;

    /* renamed from: q */
    private boolean f5708q;

    /* renamed from: r */
    private Interpolator f5709r;

    /* renamed from: s */
    private boolean f5710s;

    /* renamed from: t */
    private float f5711t;

    /* renamed from: z */
    private float f5712z;

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
                float f8 = (((f7 * f5688w) + (f5689x * f6)) * f) + f2;
                if (Math.abs(f8 - f4) < 1.0E-5d) {
                    break;
                } else if (f8 > f4) {
                    f5 = f6;
                } else {
                    f3 = f6;
                }
            }
            f5690y[i] = f + f2;
        }
        f5690y[100] = 1.0f;
        f5684B = 8.0f;
        f5685C = 1.0f;
        f5685C = 1.0f / m5895a(1.0f);
    }

    public Scroller(Context context, Interpolator interpolator) {
        this(context, interpolator, true);
    }

    public Scroller(Context context, Interpolator interpolator, boolean z) {
        this.f5708q = true;
        this.f5709r = interpolator;
        this.f5691A = context.getResources().getDisplayMetrics().density * 160.0f;
        this.f5712z = m5896b(ViewConfiguration.getScrollFriction());
        this.f5710s = z;
    }

    /* renamed from: b */
    private float m5896b(float f) {
        return this.f5691A * 386.0878f * f;
    }

    /* renamed from: a */
    public final boolean m5900a() {
        return this.f5708q;
    }

    /* renamed from: a */
    public final void m5899a(boolean z) {
        this.f5708q = z;
    }

    /* renamed from: b */
    public final int m5901b() {
        return this.f5701j;
    }

    /* renamed from: c */
    public final int m5902c() {
        return this.f5702k;
    }

    /* renamed from: d */
    public float m5903d() {
        return this.f5711t - ((this.f5712z * m5909j()) / 2000.0f);
    }

    /* renamed from: e */
    public final int m5904e() {
        return this.f5693b;
    }

    /* renamed from: f */
    public final int m5905f() {
        return this.f5694c;
    }

    /* renamed from: g */
    public final int m5906g() {
        return this.f5695d;
    }

    /* renamed from: h */
    public final int m5907h() {
        return this.f5696e;
    }

    /* renamed from: i */
    public boolean m5908i() {
        float interpolation;
        if (this.f5708q) {
            return false;
        }
        int currentAnimationTimeMillis = (int) (AnimationUtils.currentAnimationTimeMillis() - this.f5703l);
        int i = this.f5704m;
        if (currentAnimationTimeMillis < i) {
            switch (this.f5692a) {
                case 0:
                    float f = currentAnimationTimeMillis * this.f5705n;
                    Interpolator interpolator = this.f5709r;
                    if (interpolator == null) {
                        interpolation = m5895a(f);
                    } else {
                        interpolation = interpolator.getInterpolation(f);
                    }
                    this.f5701j = this.f5693b + Math.round(this.f5706o * interpolation);
                    this.f5702k = this.f5694c + Math.round(interpolation * this.f5707p);
                    break;
                case 1:
                    float f2 = currentAnimationTimeMillis / i;
                    int i2 = (int) (f2 * 100.0f);
                    float f3 = i2 / 100.0f;
                    int i3 = i2 + 1;
                    float[] fArr = f5690y;
                    float f4 = fArr[i2];
                    float f5 = f4 + (((f2 - f3) / ((i3 / 100.0f) - f3)) * (fArr[i3] - f4));
                    this.f5701j = this.f5693b + Math.round((this.f5695d - r0) * f5);
                    this.f5701j = Math.min(this.f5701j, this.f5698g);
                    this.f5701j = Math.max(this.f5701j, this.f5697f);
                    this.f5702k = this.f5694c + Math.round(f5 * (this.f5696e - r0));
                    this.f5702k = Math.min(this.f5702k, this.f5700i);
                    this.f5702k = Math.max(this.f5702k, this.f5699h);
                    if (this.f5701j == this.f5695d && this.f5702k == this.f5696e) {
                        this.f5708q = true;
                        break;
                    }
                    break;
            }
        } else {
            this.f5701j = this.f5695d;
            this.f5702k = this.f5696e;
            this.f5708q = true;
        }
        return true;
    }

    /* renamed from: a */
    public void m5897a(int i, int i2, int i3, int i4, int i5) {
        this.f5692a = 0;
        this.f5708q = false;
        this.f5704m = i5;
        this.f5703l = AnimationUtils.currentAnimationTimeMillis();
        this.f5693b = i;
        this.f5694c = i2;
        this.f5695d = i + i3;
        this.f5696e = i2 + i4;
        this.f5706o = i3;
        this.f5707p = i4;
        this.f5705n = 1.0f / this.f5704m;
    }

    /* renamed from: a */
    public void m5898a(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        int i9;
        int i10;
        if (!this.f5710s || this.f5708q) {
            i9 = i3;
            i10 = i4;
        } else {
            float m5903d = m5903d();
            float f = this.f5695d - this.f5693b;
            float f2 = this.f5696e - this.f5694c;
            float sqrt = (float) Math.sqrt((f * f) + (f2 * f2));
            float f3 = (f / sqrt) * m5903d;
            float f4 = (f2 / sqrt) * m5903d;
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
        this.f5692a = 1;
        this.f5708q = false;
        float sqrt2 = (float) Math.sqrt((i9 * i9) + (i10 * i10));
        this.f5711t = sqrt2;
        double log = Math.log((f5688w * sqrt2) / f5687v);
        this.f5704m = (int) (Math.exp(log / (f5686u - 1.0d)) * 1000.0d);
        this.f5703l = AnimationUtils.currentAnimationTimeMillis();
        this.f5693b = i;
        this.f5694c = i2;
        float f7 = sqrt2 == 0.0f ? 1.0f : i9 / sqrt2;
        float f8 = sqrt2 != 0.0f ? i10 / sqrt2 : 1.0f;
        double d = f5687v;
        float f9 = f5686u;
        int exp = (int) (d * Math.exp((f9 / (f9 - 1.0d)) * log));
        this.f5697f = i5;
        this.f5698g = i6;
        this.f5699h = i7;
        this.f5700i = i8;
        float f10 = exp;
        this.f5695d = i + Math.round(f7 * f10);
        this.f5695d = Math.min(this.f5695d, this.f5698g);
        this.f5695d = Math.max(this.f5695d, this.f5697f);
        this.f5696e = Math.round(f10 * f8) + i2;
        this.f5696e = Math.min(this.f5696e, this.f5700i);
        this.f5696e = Math.max(this.f5696e, this.f5699h);
    }

    /* renamed from: a */
    static float m5895a(float f) {
        float exp;
        float f2 = f * f5684B;
        if (f2 < 1.0f) {
            exp = f2 - (1.0f - ((float) Math.exp(-f2)));
        } else {
            exp = ((1.0f - ((float) Math.exp(1.0f - f2))) * 0.63212055f) + 0.36787945f;
        }
        return exp * f5685C;
    }

    /* renamed from: j */
    public int m5909j() {
        return (int) (AnimationUtils.currentAnimationTimeMillis() - this.f5703l);
    }
}