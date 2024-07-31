package io.objectbox.internal;

import io.objectbox.BoxStore;
import io.objectbox.annotation.apihint.Internal;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

@Internal
/* renamed from: io.objectbox.internal.d */
/* loaded from: classes2.dex */
public class ObjectBoxThreadPool extends ThreadPoolExecutor {

    /* renamed from: a */
    private final BoxStore f9537a;

    public ObjectBoxThreadPool(BoxStore boxStore) {
        super(0, Integer.MAX_VALUE, 20L, TimeUnit.SECONDS, new SynchronousQueue(), new ThreadFactoryC2833a());
        this.f9537a = boxStore;
    }

    @Override // java.util.concurrent.ThreadPoolExecutor
    protected void afterExecute(Runnable runnable, Throwable th) {
        super.afterExecute(runnable, th);
        this.f9537a.m3469h();
    }

    /* compiled from: ObjectBoxThreadPool.java */
    /* renamed from: io.objectbox.internal.d$a */
    /* loaded from: classes2.dex */
    static class ThreadFactoryC2833a implements ThreadFactory {

        /* renamed from: a */
        private static final AtomicInteger f9538a = new AtomicInteger();

        /* renamed from: b */
        private final ThreadGroup f9539b;

        /* renamed from: c */
        private final String f9540c = "ObjectBox-" + f9538a.incrementAndGet() + "-Thread-";

        /* renamed from: d */
        private final AtomicInteger f9541d = new AtomicInteger();

        ThreadFactoryC2833a() {
            ThreadGroup threadGroup;
            SecurityManager securityManager = System.getSecurityManager();
            if (securityManager != null) {
                threadGroup = securityManager.getThreadGroup();
            } else {
                threadGroup = Thread.currentThread().getThreadGroup();
            }
            this.f9539b = threadGroup;
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            Thread thread = new Thread(this.f9539b, runnable, this.f9540c + this.f9541d.incrementAndGet());
            if (thread.getPriority() != 5) {
                thread.setPriority(5);
            }
            if (thread.isDaemon()) {
                thread.setDaemon(false);
            }
            return thread;
        }
    }
}
