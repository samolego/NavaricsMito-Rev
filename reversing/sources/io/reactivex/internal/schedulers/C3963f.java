package io.reactivex.internal.schedulers;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/* renamed from: io.reactivex.internal.schedulers.f */
/* loaded from: classes2.dex */
public final class SchedulerPoolFactory {

    /* renamed from: a */
    public static final boolean f9834a;

    /* renamed from: b */
    public static final int f9835b;

    /* renamed from: c */
    static final AtomicReference<ScheduledExecutorService> f9836c = new AtomicReference<>();

    /* renamed from: d */
    static final Map<ScheduledThreadPoolExecutor, Object> f9837d = new ConcurrentHashMap();

    static {
        Properties properties = System.getProperties();
        C2892a c2892a = new C2892a();
        c2892a.m3136a(properties);
        f9834a = c2892a.f9838a;
        f9835b = c2892a.f9839b;
        m3140a();
    }

    /* renamed from: a */
    public static void m3140a() {
        m3138a(f9834a);
    }

    /* renamed from: a */
    static void m3138a(boolean z) {
        if (!z) {
            return;
        }
        while (true) {
            ScheduledExecutorService scheduledExecutorService = f9836c.get();
            if (scheduledExecutorService != null) {
                return;
            }
            ScheduledExecutorService newScheduledThreadPool = Executors.newScheduledThreadPool(1, new RxThreadFactory("RxSchedulerPurge"));
            if (f9836c.compareAndSet(scheduledExecutorService, newScheduledThreadPool)) {
                RunnableC2893b runnableC2893b = new RunnableC2893b();
                int i = f9835b;
                newScheduledThreadPool.scheduleAtFixedRate(runnableC2893b, i, i, TimeUnit.SECONDS);
                return;
            }
            newScheduledThreadPool.shutdownNow();
        }
    }

    /* compiled from: SchedulerPoolFactory.java */
    /* renamed from: io.reactivex.internal.schedulers.f$a */
    /* loaded from: classes2.dex */
    static final class C2892a {

        /* renamed from: a */
        boolean f9838a;

        /* renamed from: b */
        int f9839b;

        C2892a() {
        }

        /* renamed from: a */
        void m3136a(Properties properties) {
            if (properties.containsKey("rx2.purge-enabled")) {
                this.f9838a = Boolean.parseBoolean(properties.getProperty("rx2.purge-enabled"));
            } else {
                this.f9838a = true;
            }
            if (this.f9838a && properties.containsKey("rx2.purge-period-seconds")) {
                try {
                    this.f9839b = Integer.parseInt(properties.getProperty("rx2.purge-period-seconds"));
                    return;
                } catch (NumberFormatException unused) {
                    this.f9839b = 1;
                    return;
                }
            }
            this.f9839b = 1;
        }
    }

    /* renamed from: a */
    public static ScheduledExecutorService m3139a(ThreadFactory threadFactory) {
        ScheduledExecutorService newScheduledThreadPool = Executors.newScheduledThreadPool(1, threadFactory);
        m3137a(f9834a, newScheduledThreadPool);
        return newScheduledThreadPool;
    }

    /* renamed from: a */
    static void m3137a(boolean z, ScheduledExecutorService scheduledExecutorService) {
        if (z && (scheduledExecutorService instanceof ScheduledThreadPoolExecutor)) {
            f9837d.put((ScheduledThreadPoolExecutor) scheduledExecutorService, scheduledExecutorService);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: SchedulerPoolFactory.java */
    /* renamed from: io.reactivex.internal.schedulers.f$b */
    /* loaded from: classes2.dex */
    public static final class RunnableC2893b implements Runnable {
        RunnableC2893b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            Iterator it = new ArrayList(SchedulerPoolFactory.f9837d.keySet()).iterator();
            while (it.hasNext()) {
                ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = (ScheduledThreadPoolExecutor) it.next();
                if (scheduledThreadPoolExecutor.isShutdown()) {
                    SchedulerPoolFactory.f9837d.remove(scheduledThreadPoolExecutor);
                } else {
                    scheduledThreadPoolExecutor.purge();
                }
            }
        }
    }
}
