package com.yayandroid.locationmanager.p083b.p084a;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.yayandroid.locationmanager.b.a.b */
/* loaded from: classes2.dex */
public class ContinuousTaskScheduler {

    /* renamed from: a */
    private final ContinuousTask f9359a;

    /* renamed from: b */
    private long f9360b = Long.MIN_VALUE;

    /* renamed from: c */
    private long f9361c = Long.MIN_VALUE;

    /* renamed from: d */
    private long f9362d = Long.MIN_VALUE;

    /* renamed from: e */
    private boolean f9363e = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ContinuousTaskScheduler(ContinuousTask continuousTask) {
        this.f9359a = continuousTask;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public void m3629a(long j) {
        this.f9360b = j;
        this.f9362d = this.f9360b;
        this.f9361c = this.f9359a.m3631e();
        m3627b(j);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public void m3630a() {
        if (this.f9360b != Long.MIN_VALUE) {
            m3625d();
            this.f9362d = this.f9360b - (this.f9359a.m3631e() - this.f9361c);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: b */
    public void m3628b() {
        long j = this.f9362d;
        if (j != Long.MIN_VALUE) {
            m3627b(j);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: c */
    public void m3626c() {
        m3625d();
        m3624e();
    }

    /* renamed from: b */
    void m3627b(long j) {
        if (this.f9363e) {
            return;
        }
        this.f9359a.m3634b(j);
        this.f9363e = true;
    }

    /* renamed from: d */
    void m3625d() {
        this.f9359a.m3632d();
        this.f9363e = false;
    }

    /* renamed from: e */
    void m3624e() {
        this.f9360b = Long.MIN_VALUE;
        this.f9361c = Long.MIN_VALUE;
        this.f9362d = Long.MIN_VALUE;
        this.f9363e = false;
    }
}
