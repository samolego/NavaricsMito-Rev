package com.navatics.app.framework;

import com.navatics.app.framework.p049g.MiddleIntValueFilter;
import com.senseplay.sdk.config.CacheConfig;

/* compiled from: BuoyStatus.java */
/* renamed from: com.navatics.app.framework.f, reason: use source file name */
/* loaded from: classes.dex */
public class BuoyStatus {

    /* renamed from: a */
    private long f4485a;

    /* renamed from: b */
    private float f4486b;

    /* renamed from: c */
    private float f4487c;

    /* renamed from: d */
    private int f4488d;

    /* renamed from: e */
    private MiddleIntValueFilter f4489e = new MiddleIntValueFilter(CacheConfig.Post_Delayed);

    /* renamed from: a */
    public void m4572a(long j) {
        this.f4485a = j;
    }

    /* renamed from: a */
    public float m4569a() {
        return this.f4486b;
    }

    /* renamed from: a */
    public void m4570a(float f) {
        this.f4486b = f;
    }

    /* renamed from: b */
    public float m4573b() {
        return this.f4487c;
    }

    /* renamed from: b */
    public void m4574b(float f) {
        this.f4487c = f;
    }

    /* renamed from: c */
    public int m4575c() {
        int i = this.f4488d;
        return ((i / 5) * 5) + (i % 5 == 0 ? 0 : 5);
    }

    /* renamed from: a */
    public void m4571a(int i) {
        this.f4488d = this.f4489e.mo4898b(Integer.valueOf(i)).intValue();
    }
}