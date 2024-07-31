package com.navatics.app.framework;

import com.navatics.app.framework.p055g.MiddleIntValueFilter;
import com.senseplay.sdk.config.CacheConfig;

/* renamed from: com.navatics.app.framework.f */
/* loaded from: classes.dex */
public class BuoyStatus {

    /* renamed from: a */
    private long f4463a;

    /* renamed from: b */
    private float f4464b;

    /* renamed from: c */
    private float f4465c;

    /* renamed from: d */
    private int f4466d;

    /* renamed from: e */
    private MiddleIntValueFilter f4467e = new MiddleIntValueFilter(CacheConfig.Post_Delayed);

    /* renamed from: a */
    public void m8413a(long j) {
        this.f4463a = j;
    }

    /* renamed from: a */
    public float m8416a() {
        return this.f4464b;
    }

    /* renamed from: a */
    public void m8415a(float f) {
        this.f4464b = f;
    }

    /* renamed from: b */
    public float m8412b() {
        return this.f4465c;
    }

    /* renamed from: b */
    public void m8411b(float f) {
        this.f4465c = f;
    }

    /* renamed from: c */
    public int m8410c() {
        int i = this.f4466d;
        return ((i / 5) * 5) + (i % 5 == 0 ? 0 : 5);
    }

    /* renamed from: a */
    public void m8414a(int i) {
        this.f4466d = this.f4467e.mo8068b(Integer.valueOf(i)).intValue();
    }
}
