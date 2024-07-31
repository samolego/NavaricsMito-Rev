package com.navatics.app.framework.firmware;

/* compiled from: TimeoutTracker.java */
/* renamed from: com.navatics.app.framework.firmware.l, reason: use source file name */
/* loaded from: classes.dex */
public class TimeoutTracker {

    /* renamed from: a */
    private long f4667a;

    /* renamed from: b */
    private long f4668b;

    /* renamed from: c */
    private boolean f4669c;

    /* renamed from: d */
    private boolean f4670d;

    public TimeoutTracker(long j) {
        if (j == -1) {
            this.f4669c = true;
        }
        this.f4667a = j;
    }

    /* renamed from: a */
    public void m4822a() {
        if (this.f4670d) {
            throw new IllegalStateException("This TimeoutTracker already started");
        }
        this.f4670d = true;
        this.f4668b = System.currentTimeMillis();
    }

    /* renamed from: b */
    public boolean m4823b() {
        if (this.f4670d) {
            return !this.f4669c && System.currentTimeMillis() - this.f4668b > this.f4667a;
        }
        throw new IllegalStateException("This TimeoutTracker haven't started yet");
    }

    /* renamed from: c */
    public void m4824c() {
        if (!this.f4670d) {
            throw new IllegalStateException("This TimeoutTracker haven't started yet");
        }
        this.f4668b = 0L;
        this.f4670d = false;
    }
}