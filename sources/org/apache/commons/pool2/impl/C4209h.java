package org.apache.commons.pool2.impl;

/* renamed from: org.apache.commons.pool2.impl.h */
/* loaded from: classes2.dex */
public class EvictionConfig {

    /* renamed from: a */
    private final long f10816a;

    /* renamed from: b */
    private final long f10817b;

    /* renamed from: c */
    private final int f10818c;

    public EvictionConfig(long j, long j2, int i) {
        if (j > 0) {
            this.f10816a = j;
        } else {
            this.f10816a = Long.MAX_VALUE;
        }
        if (j2 > 0) {
            this.f10817b = j2;
        } else {
            this.f10817b = Long.MAX_VALUE;
        }
        this.f10818c = i;
    }

    /* renamed from: a */
    public long m2080a() {
        return this.f10816a;
    }

    /* renamed from: b */
    public long m2079b() {
        return this.f10817b;
    }

    /* renamed from: c */
    public int m2078c() {
        return this.f10818c;
    }

    public String toString() {
        return "EvictionConfig [idleEvictTime=" + this.f10816a + ", idleSoftEvictTime=" + this.f10817b + ", minIdle=" + this.f10818c + "]";
    }
}
