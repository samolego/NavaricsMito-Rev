package com.navatics.app.widget;

/* compiled from: TickInfo.java */
/* renamed from: com.navatics.app.widget.i, reason: use source file name */
/* loaded from: classes.dex */
public class TickInfo extends DrawElemInfo {

    /* renamed from: c */
    private static final Object f5761c = new Object();

    /* renamed from: d */
    private static int f5762d;

    /* renamed from: e */
    private static TickInfo f5763e;

    /* renamed from: f */
    private TickInfo f5764f;

    /* renamed from: g */
    private float f5765g;

    /* renamed from: h */
    private float f5766h;

    /* renamed from: i */
    private float f5767i;

    /* renamed from: j */
    private float f5768j;

    /* renamed from: k */
    private boolean f5769k;

    /* renamed from: l */
    private double f5770l;

    private TickInfo() {
    }

    /* renamed from: c */
    public float m5947c() {
        return this.f5765g;
    }

    /* renamed from: d */
    public float m5948d() {
        return this.f5766h;
    }

    /* renamed from: e */
    public float m5949e() {
        return this.f5767i;
    }

    /* renamed from: f */
    public float m5950f() {
        return this.f5768j;
    }

    /* renamed from: g */
    public double m5951g() {
        return this.f5770l;
    }

    /* renamed from: a */
    public static TickInfo m5945a(float f, float f2, float f3, float f4, boolean z, double d) {
        TickInfo m5946h = m5946h();
        m5946h.f5765g = f;
        m5946h.f5766h = f2;
        m5946h.f5767i = f3;
        m5946h.f5768j = f4;
        m5946h.f5769k = z;
        m5946h.f5770l = d;
        return m5946h;
    }

    /* renamed from: h */
    private static TickInfo m5946h() {
        synchronized (f5761c) {
            TickInfo tickInfo = f5763e;
            if (tickInfo == null) {
                return new TickInfo();
            }
            f5763e = tickInfo.f5764f;
            f5762d--;
            tickInfo.f5764f = null;
            tickInfo.m5805a();
            return tickInfo;
        }
    }

    @Override // com.navatics.app.widget.DrawElemInfo
    /* renamed from: b */
    public final void mo5806b() {
        super.mo5806b();
        synchronized (f5761c) {
            if (f5762d < 20) {
                f5762d++;
                this.f5764f = f5763e;
                f5763e = this;
            }
        }
    }
}