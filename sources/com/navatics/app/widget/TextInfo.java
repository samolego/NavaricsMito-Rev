package com.navatics.app.widget;

/* renamed from: com.navatics.app.widget.h */
/* loaded from: classes.dex */
public class TextInfo extends DrawElemInfo {

    /* renamed from: c */
    private static final Object f5732c = new Object();

    /* renamed from: d */
    private static int f5733d;

    /* renamed from: e */
    private static TextInfo f5734e;

    /* renamed from: f */
    private TextInfo f5735f;

    /* renamed from: g */
    private float f5736g;

    /* renamed from: h */
    private float f5737h;

    /* renamed from: i */
    private double f5738i;

    private TextInfo() {
    }

    /* renamed from: c */
    public float m6924c() {
        return this.f5736g;
    }

    /* renamed from: d */
    public float m6923d() {
        return this.f5737h;
    }

    /* renamed from: e */
    public double m6922e() {
        return this.f5738i;
    }

    /* renamed from: a */
    public static TextInfo m6925a(float f, float f2, double d) {
        TextInfo m6921f = m6921f();
        m6921f.f5736g = f;
        m6921f.f5737h = f2;
        m6921f.f5738i = d;
        return m6921f;
    }

    /* renamed from: f */
    private static TextInfo m6921f() {
        synchronized (f5732c) {
            TextInfo textInfo = f5734e;
            if (textInfo == null) {
                return new TextInfo();
            }
            f5734e = textInfo.f5735f;
            f5733d--;
            textInfo.f5735f = null;
            textInfo.m7059a();
            return textInfo;
        }
    }

    @Override // com.navatics.app.widget.DrawElemInfo
    /* renamed from: b */
    public final void mo6919b() {
        super.mo6919b();
        synchronized (f5732c) {
            if (f5733d < 20) {
                f5733d++;
                this.f5735f = f5734e;
                f5734e = this;
            }
        }
    }
}
