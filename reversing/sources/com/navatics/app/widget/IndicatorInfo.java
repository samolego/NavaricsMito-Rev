package com.navatics.app.widget;

import android.graphics.Bitmap;

/* renamed from: com.navatics.app.widget.b */
/* loaded from: classes.dex */
public class IndicatorInfo extends DrawElemInfo {

    /* renamed from: c */
    private static final Object f5578c = new Object();

    /* renamed from: d */
    private static int f5579d;

    /* renamed from: e */
    private static IndicatorInfo f5580e;

    /* renamed from: f */
    private IndicatorInfo f5581f;

    /* renamed from: g */
    private float f5582g;

    /* renamed from: h */
    private float f5583h;

    /* renamed from: i */
    private Bitmap f5584i;

    private IndicatorInfo() {
    }

    /* renamed from: c */
    public float m7027c() {
        return this.f5582g;
    }

    /* renamed from: d */
    public float m7026d() {
        return this.f5583h;
    }

    /* renamed from: e */
    public Bitmap m7025e() {
        return this.f5584i;
    }

    /* renamed from: a */
    public static IndicatorInfo m7029a(Bitmap bitmap) {
        IndicatorInfo m7024f = m7024f();
        m7024f.m7028b(bitmap);
        return m7024f;
    }

    /* renamed from: f */
    private static IndicatorInfo m7024f() {
        synchronized (f5578c) {
            IndicatorInfo indicatorInfo = f5580e;
            if (indicatorInfo == null) {
                return new IndicatorInfo();
            }
            f5580e = indicatorInfo.f5581f;
            f5579d--;
            indicatorInfo.f5581f = null;
            indicatorInfo.m7059a();
            return indicatorInfo;
        }
    }

    /* renamed from: a */
    public void m7030a(float f, float f2) {
        this.f5582g = f;
        this.f5583h = f2;
    }

    /* renamed from: b */
    public void m7028b(Bitmap bitmap) {
        this.f5584i = bitmap;
    }

    @Override // com.navatics.app.widget.DrawElemInfo
    /* renamed from: b */
    public final void mo6919b() {
        super.mo6919b();
        synchronized (f5578c) {
            if (f5579d < 20) {
                f5579d++;
                this.f5581f = f5580e;
                f5580e = this;
            }
        }
    }
}
