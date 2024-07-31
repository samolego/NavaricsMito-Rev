package com.yayandroid.locationmanager.p072b.p073a;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ContinuousTaskScheduler.java */
/* renamed from: com.yayandroid.locationmanager.b.a.b, reason: use source file name */
/* loaded from: classes2.dex */
public class ContinuousTaskScheduler {

    /* renamed from: a */
    private final HandlerC2753a f9400a;

    /* renamed from: b */
    private long f9401b = Long.MIN_VALUE;

    /* renamed from: c */
    private long f9402c = Long.MIN_VALUE;

    /* renamed from: d */
    private long f9403d = Long.MIN_VALUE;

    /* renamed from: e */
    private boolean f9404e = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ContinuousTaskScheduler(HandlerC2753a handlerC2753a) {
        this.f9400a = handlerC2753a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public void m9216a(long j) {
        this.f9401b = j;
        this.f9403d = this.f9401b;
        this.f9402c = this.f9400a.m9213e();
        m9218b(j);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public void m9215a() {
        if (this.f9401b != Long.MIN_VALUE) {
            m9220d();
            this.f9403d = this.f9401b - (this.f9400a.m9213e() - this.f9402c);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: b */
    public void m9217b() {
        long j = this.f9403d;
        if (j != Long.MIN_VALUE) {
            m9218b(j);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: c */
    public void m9219c() {
        m9220d();
        m9221e();
    }

    /* renamed from: b */
    void m9218b(long j) {
        if (this.f9404e) {
            return;
        }
        this.f9400a.m9210b(j);
        this.f9404e = true;
    }

    /* renamed from: d */
    void m9220d() {
        this.f9400a.m9212d();
        this.f9404e = false;
    }

    /* renamed from: e */
    void m9221e() {
        this.f9401b = Long.MIN_VALUE;
        this.f9402c = Long.MIN_VALUE;
        this.f9403d = Long.MIN_VALUE;
        this.f9404e = false;
    }
}