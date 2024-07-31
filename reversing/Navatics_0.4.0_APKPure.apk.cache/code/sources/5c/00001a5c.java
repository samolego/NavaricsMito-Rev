package com.navatics.app.widget;

import android.graphics.Bitmap;

/* compiled from: IndicatorInfo.java */
/* renamed from: com.navatics.app.widget.b, reason: use source file name */
/* loaded from: classes.dex */
public class IndicatorInfo extends DrawElemInfo {

    /* renamed from: c */
    private static final Object f5600c = new Object();

    /* renamed from: d */
    private static int f5601d;

    /* renamed from: e */
    private static IndicatorInfo f5602e;

    /* renamed from: f */
    private IndicatorInfo f5603f;

    /* renamed from: g */
    private float f5604g;

    /* renamed from: h */
    private float f5605h;

    /* renamed from: i */
    private Bitmap f5606i;

    private IndicatorInfo() {
    }

    /* renamed from: c */
    public float m5839c() {
        return this.f5604g;
    }

    /* renamed from: d */
    public float m5840d() {
        return this.f5605h;
    }

    /* renamed from: e */
    public Bitmap m5841e() {
        return this.f5606i;
    }

    /* renamed from: a */
    public static IndicatorInfo m5835a(Bitmap bitmap) {
        IndicatorInfo m5836f = m5836f();
        m5836f.m5838b(bitmap);
        return m5836f;
    }

    /* renamed from: f */
    private static IndicatorInfo m5836f() {
        synchronized (f5600c) {
            IndicatorInfo indicatorInfo = f5602e;
            if (indicatorInfo == null) {
                return new IndicatorInfo();
            }
            f5602e = indicatorInfo.f5603f;
            f5601d--;
            indicatorInfo.f5603f = null;
            indicatorInfo.m5805a();
            return indicatorInfo;
        }
    }

    /* renamed from: a */
    public void m5837a(float f, float f2) {
        this.f5604g = f;
        this.f5605h = f2;
    }

    /* renamed from: b */
    public void m5838b(Bitmap bitmap) {
        this.f5606i = bitmap;
    }

    @Override // com.navatics.app.widget.DrawElemInfo
    /* renamed from: b */
    public final void mo5806b() {
        super.mo5806b();
        synchronized (f5600c) {
            if (f5601d < 20) {
                f5601d++;
                this.f5603f = f5602e;
                f5602e = this;
            }
        }
    }
}