package org.apache.commons.pool2.impl;

/* compiled from: EvictionConfig.java */
/* renamed from: org.apache.commons.pool2.impl.h, reason: use source file name */
/* loaded from: classes2.dex */
public class EvictionConfig {

    /* renamed from: a */
    private final long f10857a;

    /* renamed from: b */
    private final long f10858b;

    /* renamed from: c */
    private final int f10859c;

    public EvictionConfig(long j, long j2, int i) {
        if (j > 0) {
            this.f10857a = j;
        } else {
            this.f10857a = Long.MAX_VALUE;
        }
        if (j2 > 0) {
            this.f10858b = j2;
        } else {
            this.f10858b = Long.MAX_VALUE;
        }
        this.f10859c = i;
    }

    /* renamed from: a */
    public long m10760a() {
        return this.f10857a;
    }

    /* renamed from: b */
    public long m10761b() {
        return this.f10858b;
    }

    /* renamed from: c */
    public int m10762c() {
        return this.f10859c;
    }

    public String toString() {
        return "EvictionConfig [idleEvictTime=" + this.f10857a + ", idleSoftEvictTime=" + this.f10858b + ", minIdle=" + this.f10859c + "]";
    }
}