package com.navatics.app.widget;

/* renamed from: com.navatics.app.widget.i */
/* loaded from: classes.dex */
public class TickInfo extends DrawElemInfo {

    /* renamed from: c */
    private static final Object f5739c = new Object();

    /* renamed from: d */
    private static int f5740d;

    /* renamed from: e */
    private static TickInfo f5741e;

    /* renamed from: f */
    private TickInfo f5742f;

    /* renamed from: g */
    private float f5743g;

    /* renamed from: h */
    private float f5744h;

    /* renamed from: i */
    private float f5745i;

    /* renamed from: j */
    private float f5746j;

    /* renamed from: k */
    private boolean f5747k;

    /* renamed from: l */
    private double f5748l;

    private TickInfo() {
    }

    /* renamed from: c */
    public float m6918c() {
        return this.f5743g;
    }

    /* renamed from: d */
    public float m6917d() {
        return this.f5744h;
    }

    /* renamed from: e */
    public float m6916e() {
        return this.f5745i;
    }

    /* renamed from: f */
    public float m6915f() {
        return this.f5746j;
    }

    /* renamed from: g */
    public double m6914g() {
        return this.f5748l;
    }

    /* renamed from: a */
    public static TickInfo m6920a(float f, float f2, float f3, float f4, boolean z, double d) {
        TickInfo m6913h = m6913h();
        m6913h.f5743g = f;
        m6913h.f5744h = f2;
        m6913h.f5745i = f3;
        m6913h.f5746j = f4;
        m6913h.f5747k = z;
        m6913h.f5748l = d;
        return m6913h;
    }

    /* renamed from: h */
    private static TickInfo m6913h() {
        synchronized (f5739c) {
            TickInfo tickInfo = f5741e;
            if (tickInfo == null) {
                return new TickInfo();
            }
            f5741e = tickInfo.f5742f;
            f5740d--;
            tickInfo.f5742f = null;
            tickInfo.m7059a();
            return tickInfo;
        }
    }

    @Override // com.navatics.app.widget.DrawElemInfo
    /* renamed from: b */
    public final void mo6919b() {
        super.mo6919b();
        synchronized (f5739c) {
            if (f5740d < 20) {
                f5740d++;
                this.f5742f = f5741e;
                f5741e = this;
            }
        }
    }
}
