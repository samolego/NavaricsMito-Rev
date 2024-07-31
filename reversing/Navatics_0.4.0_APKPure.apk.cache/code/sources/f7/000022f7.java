package com.yayandroid.locationmanager.p072b.p073a;

import android.os.Handler;
import android.support.annotation.NonNull;

/* compiled from: ContinuousTask.java */
/* renamed from: com.yayandroid.locationmanager.b.a.a */
/* loaded from: classes2.dex */
public class HandlerC2753a extends Handler implements Runnable {

    /* renamed from: a */
    private final String f9397a;

    /* renamed from: b */
    private final ContinuousTaskScheduler f9398b = new ContinuousTaskScheduler(this);

    /* renamed from: c */
    private final a f9399c;

    /* compiled from: ContinuousTask.java */
    /* renamed from: com.yayandroid.locationmanager.b.a.a$a */
    /* loaded from: classes2.dex */
    public interface a {
        /* renamed from: a */
        void mo9214a(@NonNull String str);
    }

    public HandlerC2753a(@NonNull String str, @NonNull a aVar) {
        this.f9397a = str;
        this.f9399c = aVar;
    }

    /* renamed from: a */
    public void m9208a(long j) {
        this.f9398b.m9216a(j);
    }

    /* renamed from: a */
    public void m9207a() {
        this.f9398b.m9215a();
    }

    /* renamed from: b */
    public void m9209b() {
        this.f9398b.m9217b();
    }

    /* renamed from: c */
    public void m9211c() {
        this.f9398b.m9219c();
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f9399c.mo9214a(this.f9397a);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: b */
    public void m9210b(long j) {
        postDelayed(this, j);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: d */
    public void m9212d() {
        removeCallbacks(this);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: e */
    public long m9213e() {
        return System.currentTimeMillis();
    }
}