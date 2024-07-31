package com.navatics.app.widget;

/* compiled from: TextInfo.java */
/* renamed from: com.navatics.app.widget.h, reason: use source file name */
/* loaded from: classes.dex */
public class TextInfo extends DrawElemInfo {

    /* renamed from: c */
    private static final Object f5754c = new Object();

    /* renamed from: d */
    private static int f5755d;

    /* renamed from: e */
    private static TextInfo f5756e;

    /* renamed from: f */
    private TextInfo f5757f;

    /* renamed from: g */
    private float f5758g;

    /* renamed from: h */
    private float f5759h;

    /* renamed from: i */
    private double f5760i;

    private TextInfo() {
    }

    /* renamed from: c */
    public float m5942c() {
        return this.f5758g;
    }

    /* renamed from: d */
    public float m5943d() {
        return this.f5759h;
    }

    /* renamed from: e */
    public double m5944e() {
        return this.f5760i;
    }

    /* renamed from: a */
    public static TextInfo m5940a(float f, float f2, double d) {
        TextInfo m5941f = m5941f();
        m5941f.f5758g = f;
        m5941f.f5759h = f2;
        m5941f.f5760i = d;
        return m5941f;
    }

    /* renamed from: f */
    private static TextInfo m5941f() {
        synchronized (f5754c) {
            TextInfo textInfo = f5756e;
            if (textInfo == null) {
                return new TextInfo();
            }
            f5756e = textInfo.f5757f;
            f5755d--;
            textInfo.f5757f = null;
            textInfo.m5805a();
            return textInfo;
        }
    }

    @Override // com.navatics.app.widget.DrawElemInfo
    /* renamed from: b */
    public final void mo5806b() {
        super.mo5806b();
        synchronized (f5754c) {
            if (f5755d < 20) {
                f5755d++;
                this.f5757f = f5756e;
                f5756e = this;
            }
        }
    }
}