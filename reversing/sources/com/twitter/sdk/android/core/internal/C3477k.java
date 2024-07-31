package com.twitter.sdk.android.core.internal;

import android.app.Activity;
import com.twitter.sdk.android.core.Session;
import com.twitter.sdk.android.core.SessionManager;
import com.twitter.sdk.android.core.internal.ActivityLifecycleManager;
import java.util.Calendar;
import java.util.TimeZone;
import java.util.concurrent.ExecutorService;

/* renamed from: com.twitter.sdk.android.core.internal.k */
/* loaded from: classes2.dex */
public class SessionMonitor<T extends Session> {

    /* renamed from: a */
    protected final C2666a f8528a;

    /* renamed from: b */
    private final SystemCurrentTimeProvider f8529b;

    /* renamed from: c */
    private final SessionManager<T> f8530c;

    /* renamed from: d */
    private final ExecutorService f8531d;

    /* renamed from: e */
    private final SessionVerifier f8532e;

    public SessionMonitor(SessionManager<T> sessionManager, ExecutorService executorService, SessionVerifier<T> sessionVerifier) {
        this(sessionManager, new SystemCurrentTimeProvider(), executorService, new C2666a(), sessionVerifier);
    }

    SessionMonitor(SessionManager<T> sessionManager, SystemCurrentTimeProvider systemCurrentTimeProvider, ExecutorService executorService, C2666a c2666a, SessionVerifier sessionVerifier) {
        this.f8529b = systemCurrentTimeProvider;
        this.f8530c = sessionManager;
        this.f8531d = executorService;
        this.f8528a = c2666a;
        this.f8532e = sessionVerifier;
    }

    /* renamed from: a */
    public void m4433a(ActivityLifecycleManager activityLifecycleManager) {
        activityLifecycleManager.m4510a(new ActivityLifecycleManager.AbstractC2657b() { // from class: com.twitter.sdk.android.core.internal.k.1
            @Override // com.twitter.sdk.android.core.internal.ActivityLifecycleManager.AbstractC2657b
            /* renamed from: a */
            public void mo4431a(Activity activity) {
                SessionMonitor.this.m4434a();
            }
        });
    }

    /* renamed from: a */
    public void m4434a() {
        if (this.f8530c.mo4266b() != null && this.f8528a.m4430a(this.f8529b.mo4427a())) {
            this.f8531d.submit(new Runnable() { // from class: com.twitter.sdk.android.core.internal.k.2
                @Override // java.lang.Runnable
                public void run() {
                    SessionMonitor.this.m4432b();
                }
            });
        }
    }

    /* renamed from: b */
    protected void m4432b() {
        for (T t : this.f8530c.mo4265c().values()) {
            this.f8532e.mo4420a(t);
        }
        this.f8528a.m4428b(this.f8529b.mo4427a());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* compiled from: SessionMonitor.java */
    /* renamed from: com.twitter.sdk.android.core.internal.k$a */
    /* loaded from: classes2.dex */
    public static class C2666a {

        /* renamed from: a */
        public boolean f8535a;

        /* renamed from: b */
        public long f8536b;

        /* renamed from: c */
        private final Calendar f8537c = Calendar.getInstance(TimeZone.getTimeZone("UTC"));

        /* renamed from: a */
        public synchronized boolean m4430a(long j) {
            boolean z = j - this.f8536b > 21600000;
            boolean z2 = !m4429a(j, this.f8536b);
            if (this.f8535a || !(z || z2)) {
                return false;
            }
            this.f8535a = true;
            return true;
        }

        /* renamed from: b */
        public synchronized void m4428b(long j) {
            this.f8535a = false;
            this.f8536b = j;
        }

        /* renamed from: a */
        private boolean m4429a(long j, long j2) {
            this.f8537c.setTimeInMillis(j);
            int i = this.f8537c.get(6);
            int i2 = this.f8537c.get(1);
            this.f8537c.setTimeInMillis(j2);
            return i == this.f8537c.get(6) && i2 == this.f8537c.get(1);
        }
    }
}
