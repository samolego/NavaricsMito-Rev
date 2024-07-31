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

/* compiled from: SchedulerPoolFactory.java */
/* renamed from: io.reactivex.internal.schedulers.f, reason: use source file name */
/* loaded from: classes2.dex */
public final class SchedulerPoolFactory {

    /* renamed from: a */
    public static final boolean f9875a;

    /* renamed from: b */
    public static final int f9876b;

    /* renamed from: c */
    static final AtomicReference<ScheduledExecutorService> f9877c = new AtomicReference<>();

    /* renamed from: d */
    static final Map<ScheduledThreadPoolExecutor, Object> f9878d = new ConcurrentHashMap();

    static {
        Properties properties = System.getProperties();
        a aVar = new a();
        aVar.m9700a(properties);
        f9875a = aVar.f9879a;
        f9876b = aVar.f9880b;
        m9697a();
    }

    /* renamed from: a */
    public static void m9697a() {
        m9698a(f9875a);
    }

    /* renamed from: a */
    static void m9698a(boolean z) {
        if (!z) {
            return;
        }
        while (true) {
            ScheduledExecutorService scheduledExecutorService = f9877c.get();
            if (scheduledExecutorService != null) {
                return;
            }
            ScheduledExecutorService newScheduledThreadPool = Executors.newScheduledThreadPool(1, new RxThreadFactory("RxSchedulerPurge"));
            if (f9877c.compareAndSet(scheduledExecutorService, newScheduledThreadPool)) {
                b bVar = new b();
                int i = f9876b;
                newScheduledThreadPool.scheduleAtFixedRate(bVar, i, i, TimeUnit.SECONDS);
                return;
            }
            newScheduledThreadPool.shutdownNow();
        }
    }

    /* compiled from: SchedulerPoolFactory.java */
    /* renamed from: io.reactivex.internal.schedulers.f$a */
    /* loaded from: classes2.dex */
    static final class a {

        /* renamed from: a */
        boolean f9879a;

        /* renamed from: b */
        int f9880b;

        a() {
        }

        /* renamed from: a */
        void m9700a(Properties properties) {
            if (properties.containsKey("rx2.purge-enabled")) {
                this.f9879a = Boolean.parseBoolean(properties.getProperty("rx2.purge-enabled"));
            } else {
                this.f9879a = true;
            }
            if (this.f9879a && properties.containsKey("rx2.purge-period-seconds")) {
                try {
                    this.f9880b = Integer.parseInt(properties.getProperty("rx2.purge-period-seconds"));
                    return;
                } catch (NumberFormatException unused) {
                    this.f9880b = 1;
                    return;
                }
            }
            this.f9880b = 1;
        }
    }

    /* renamed from: a */
    public static ScheduledExecutorService m9696a(ThreadFactory threadFactory) {
        ScheduledExecutorService newScheduledThreadPool = Executors.newScheduledThreadPool(1, threadFactory);
        m9699a(f9875a, newScheduledThreadPool);
        return newScheduledThreadPool;
    }

    /* renamed from: a */
    static void m9699a(boolean z, ScheduledExecutorService scheduledExecutorService) {
        if (z && (scheduledExecutorService instanceof ScheduledThreadPoolExecutor)) {
            f9878d.put((ScheduledThreadPoolExecutor) scheduledExecutorService, scheduledExecutorService);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: SchedulerPoolFactory.java */
    /* renamed from: io.reactivex.internal.schedulers.f$b */
    /* loaded from: classes2.dex */
    public static final class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            Iterator it = new ArrayList(SchedulerPoolFactory.f9878d.keySet()).iterator();
            while (it.hasNext()) {
                ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = (ScheduledThreadPoolExecutor) it.next();
                if (scheduledThreadPoolExecutor.isShutdown()) {
                    SchedulerPoolFactory.f9878d.remove(scheduledThreadPoolExecutor);
                } else {
                    scheduledThreadPoolExecutor.purge();
                }
            }
        }
    }
}