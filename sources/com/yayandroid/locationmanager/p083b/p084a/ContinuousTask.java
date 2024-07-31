package com.yayandroid.locationmanager.p083b.p084a;

import android.os.Handler;
import android.support.annotation.NonNull;

/* renamed from: com.yayandroid.locationmanager.b.a.a */
/* loaded from: classes2.dex */
public class ContinuousTask extends Handler implements Runnable {

    /* renamed from: a */
    private final String f9356a;

    /* renamed from: b */
    private final ContinuousTaskScheduler f9357b = new ContinuousTaskScheduler(this);

    /* renamed from: c */
    private final InterfaceC2817a f9358c;

    /* compiled from: ContinuousTask.java */
    /* renamed from: com.yayandroid.locationmanager.b.a.a$a */
    /* loaded from: classes2.dex */
    public interface InterfaceC2817a {
        /* renamed from: a */
        void mo3575a(@NonNull String str);
    }

    public ContinuousTask(@NonNull String str, @NonNull InterfaceC2817a interfaceC2817a) {
        this.f9356a = str;
        this.f9358c = interfaceC2817a;
    }

    /* renamed from: a */
    public void m3636a(long j) {
        this.f9357b.m3629a(j);
    }

    /* renamed from: a */
    public void m3637a() {
        this.f9357b.m3630a();
    }

    /* renamed from: b */
    public void m3635b() {
        this.f9357b.m3628b();
    }

    /* renamed from: c */
    public void m3633c() {
        this.f9357b.m3626c();
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f9358c.mo3575a(this.f9356a);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: b */
    public void m3634b(long j) {
        postDelayed(this, j);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: d */
    public void m3632d() {
        removeCallbacks(this);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: e */
    public long m3631e() {
        return System.currentTimeMillis();
    }
}
