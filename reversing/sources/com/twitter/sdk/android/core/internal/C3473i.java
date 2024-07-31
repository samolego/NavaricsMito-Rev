package com.twitter.sdk.android.core.internal;

import com.twitter.sdk.android.core.InterfaceC2645h;
import com.twitter.sdk.android.core.Twitter;
import java.util.Locale;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

/* renamed from: com.twitter.sdk.android.core.internal.i */
/* loaded from: classes2.dex */
public final class ExecutorUtils {

    /* renamed from: a */
    private static final int f8510a = Runtime.getRuntime().availableProcessors();

    /* renamed from: b */
    private static final int f8511b;

    /* renamed from: c */
    private static final int f8512c;

    static {
        int i = f8510a;
        f8511b = i + 1;
        f8512c = (i * 2) + 1;
    }

    /* renamed from: a */
    public static ExecutorService m4444a(String str) {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(f8511b, f8512c, 1L, TimeUnit.SECONDS, new LinkedBlockingQueue(), m4440c(str));
        m4443a(str, threadPoolExecutor);
        return threadPoolExecutor;
    }

    /* renamed from: b */
    public static ScheduledExecutorService m4441b(String str) {
        ScheduledExecutorService newSingleThreadScheduledExecutor = Executors.newSingleThreadScheduledExecutor(m4440c(str));
        m4443a(str, newSingleThreadScheduledExecutor);
        return newSingleThreadScheduledExecutor;
    }

    /* renamed from: c */
    static ThreadFactory m4440c(final String str) {
        final AtomicLong atomicLong = new AtomicLong(1L);
        return new ThreadFactory() { // from class: com.twitter.sdk.android.core.internal.i.1
            @Override // java.util.concurrent.ThreadFactory
            public Thread newThread(Runnable runnable) {
                Thread newThread = Executors.defaultThreadFactory().newThread(runnable);
                newThread.setName(str + atomicLong.getAndIncrement());
                return newThread;
            }
        };
    }

    /* renamed from: a */
    static void m4443a(String str, ExecutorService executorService) {
        m4442a(str, executorService, 1L, TimeUnit.SECONDS);
    }

    /* renamed from: a */
    static void m4442a(final String str, final ExecutorService executorService, final long j, final TimeUnit timeUnit) {
        Runtime runtime = Runtime.getRuntime();
        Runnable runnable = new Runnable() { // from class: com.twitter.sdk.android.core.internal.i.2
            @Override // java.lang.Runnable
            public void run() {
                try {
                    executorService.shutdown();
                    if (executorService.awaitTermination(j, timeUnit)) {
                        return;
                    }
                    InterfaceC2645h m4253h = Twitter.m4253h();
                    m4253h.mo4561a("Twitter", str + " did not shutdown in the allocated time. Requesting immediate shutdown.");
                    executorService.shutdownNow();
                } catch (InterruptedException unused) {
                    Twitter.m4253h().mo4561a("Twitter", String.format(Locale.US, "Interrupted while waiting for %s to shut down. Requesting immediate shutdown.", str));
                    executorService.shutdownNow();
                }
            }
        };
        runtime.addShutdownHook(new Thread(runnable, "Twitter Shutdown Hook for " + str));
    }
}
