package org.apache.commons.pool2.impl;

import java.security.AccessController;
import java.security.PrivilegedAction;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;

/* renamed from: org.apache.commons.pool2.impl.j */
/* loaded from: classes2.dex */
class EvictionTimer {

    /* renamed from: a */
    private static ScheduledThreadPoolExecutor f10819a;

    public String toString() {
        return "EvictionTimer []";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public static synchronized void m2076a(BaseGenericObjectPool<?>.RunnableC3014b runnableC3014b, long j, long j2) {
        synchronized (EvictionTimer.class) {
            if (f10819a == null) {
                f10819a = new ScheduledThreadPoolExecutor(1, new ThreadFactoryC3018a());
                f10819a.setRemoveOnCancelPolicy(true);
            }
            runnableC3014b.m2120a(f10819a.scheduleWithFixedDelay(runnableC3014b, j, j2, TimeUnit.MILLISECONDS));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public static synchronized void m2075a(BaseGenericObjectPool<?>.RunnableC3014b runnableC3014b, long j, TimeUnit timeUnit) {
        synchronized (EvictionTimer.class) {
            runnableC3014b.m2121a();
            if (f10819a.getQueue().size() == 0) {
                f10819a.shutdown();
                try {
                    f10819a.awaitTermination(j, timeUnit);
                } catch (InterruptedException unused) {
                }
                f10819a.setCorePoolSize(0);
                f10819a = null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: EvictionTimer.java */
    /* renamed from: org.apache.commons.pool2.impl.j$a */
    /* loaded from: classes2.dex */
    public static class ThreadFactoryC3018a implements ThreadFactory {
        private ThreadFactoryC3018a() {
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            final Thread thread = new Thread(null, runnable, "commons-pool-evictor-thread");
            AccessController.doPrivileged(new PrivilegedAction<Void>() { // from class: org.apache.commons.pool2.impl.j.a.1
                @Override // java.security.PrivilegedAction
                /* renamed from: a */
                public Void run() {
                    thread.setContextClassLoader(ThreadFactoryC3018a.class.getClassLoader());
                    return null;
                }
            });
            return thread;
        }
    }
}
