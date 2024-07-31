package com.tencent.bugly.proguard;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: BUGLY */
/* renamed from: com.tencent.bugly.proguard.w */
/* loaded from: classes2.dex */
public final class C2497w {

    /* renamed from: a */
    private static final AtomicInteger f7760a = new AtomicInteger(1);

    /* renamed from: b */
    private static C2497w f7761b;

    /* renamed from: c */
    private ScheduledExecutorService f7762c;

    protected C2497w() {
        this.f7762c = null;
        this.f7762c = Executors.newScheduledThreadPool(3, new ThreadFactory(this) { // from class: com.tencent.bugly.proguard.w.1
            @Override // java.util.concurrent.ThreadFactory
            public final Thread newThread(Runnable runnable) {
                Thread thread = new Thread(runnable);
                thread.setName("BuglyThread-" + C2497w.f7760a.getAndIncrement());
                return thread;
            }
        });
        ScheduledExecutorService scheduledExecutorService = this.f7762c;
        if (scheduledExecutorService == null || scheduledExecutorService.isShutdown()) {
            C2499x.m5084d("[AsyncTaskHandler] ScheduledExecutorService is not valiable!", new Object[0]);
        }
    }

    /* renamed from: a */
    public static synchronized C2497w m5098a() {
        C2497w c2497w;
        synchronized (C2497w.class) {
            if (f7761b == null) {
                f7761b = new C2497w();
            }
            c2497w = f7761b;
        }
        return c2497w;
    }

    /* renamed from: a */
    public final synchronized boolean m5096a(Runnable runnable, long j) {
        if (!m5094c()) {
            C2499x.m5084d("[AsyncTaskHandler] Async handler was closed, should not post task.", new Object[0]);
            return false;
        } else if (runnable == null) {
            C2499x.m5084d("[AsyncTaskHandler] Task input is null.", new Object[0]);
            return false;
        } else {
            if (j <= 0) {
                j = 0;
            }
            C2499x.m5085c("[AsyncTaskHandler] Post a delay(time: %dms) task: %s", Long.valueOf(j), runnable.getClass().getName());
            this.f7762c.schedule(runnable, j, TimeUnit.MILLISECONDS);
            return true;
        }
    }

    /* renamed from: a */
    public final synchronized boolean m5097a(Runnable runnable) {
        if (!m5094c()) {
            C2499x.m5084d("[AsyncTaskHandler] Async handler was closed, should not post task.", new Object[0]);
            return false;
        } else if (runnable == null) {
            C2499x.m5084d("[AsyncTaskHandler] Task input is null.", new Object[0]);
            return false;
        } else {
            C2499x.m5085c("[AsyncTaskHandler] Post a normal task: %s", runnable.getClass().getName());
            this.f7762c.execute(runnable);
            return true;
        }
    }

    /* renamed from: b */
    public final synchronized void m5095b() {
        if (this.f7762c != null && !this.f7762c.isShutdown()) {
            C2499x.m5085c("[AsyncTaskHandler] Close async handler.", new Object[0]);
            this.f7762c.shutdownNow();
        }
    }

    /* renamed from: c */
    public final synchronized boolean m5094c() {
        boolean z;
        if (this.f7762c != null) {
            z = this.f7762c.isShutdown() ? false : true;
        }
        return z;
    }
}
