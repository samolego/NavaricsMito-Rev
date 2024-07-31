package com.navatics.app.framework.firmware;

/* renamed from: com.navatics.app.framework.firmware.l */
/* loaded from: classes.dex */
public class TimeoutTracker {

    /* renamed from: a */
    private long f4645a;

    /* renamed from: b */
    private long f4646b;

    /* renamed from: c */
    private boolean f4647c;

    /* renamed from: d */
    private boolean f4648d;

    public TimeoutTracker(long j) {
        if (j == -1) {
            this.f4647c = true;
        }
        this.f4645a = j;
    }

    /* renamed from: a */
    public void m8161a() {
        if (this.f4648d) {
            throw new IllegalStateException("This TimeoutTracker already started");
        }
        this.f4648d = true;
        this.f4646b = System.currentTimeMillis();
    }

    /* renamed from: b */
    public boolean m8160b() {
        if (this.f4648d) {
            return !this.f4647c && System.currentTimeMillis() - this.f4646b > this.f4645a;
        }
        throw new IllegalStateException("This TimeoutTracker haven't started yet");
    }

    /* renamed from: c */
    public void m8159c() {
        if (!this.f4648d) {
            throw new IllegalStateException("This TimeoutTracker haven't started yet");
        }
        this.f4646b = 0L;
        this.f4648d = false;
    }
}
