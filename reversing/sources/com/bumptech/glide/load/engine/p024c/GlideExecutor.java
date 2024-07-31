package com.bumptech.glide.load.engine.p024c;

import android.os.Process;
import android.os.StrictMode;
import android.support.annotation.NonNull;
import android.support.annotation.VisibleForTesting;
import android.util.Log;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* renamed from: com.bumptech.glide.load.engine.c.a */
/* loaded from: classes.dex */
public final class GlideExecutor implements ExecutorService {

    /* renamed from: a */
    private static final long f852a = TimeUnit.SECONDS.toMillis(10);

    /* renamed from: b */
    private static volatile int f853b;

    /* renamed from: c */
    private final ExecutorService f854c;

    /* compiled from: GlideExecutor.java */
    /* renamed from: com.bumptech.glide.load.engine.c.a$b */
    /* loaded from: classes.dex */
    public interface InterfaceC0714b {

        /* renamed from: a */
        public static final InterfaceC0714b f860a = new InterfaceC0714b() { // from class: com.bumptech.glide.load.engine.c.a.b.1
            @Override // com.bumptech.glide.load.engine.p024c.GlideExecutor.InterfaceC0714b
            /* renamed from: a */
            public void mo12111a(Throwable th) {
            }
        };

        /* renamed from: b */
        public static final InterfaceC0714b f861b = new InterfaceC0714b() { // from class: com.bumptech.glide.load.engine.c.a.b.2
            @Override // com.bumptech.glide.load.engine.p024c.GlideExecutor.InterfaceC0714b
            /* renamed from: a */
            public void mo12111a(Throwable th) {
                if (th == null || !Log.isLoggable("GlideExecutor", 6)) {
                    return;
                }
                Log.e("GlideExecutor", "Request threw uncaught throwable", th);
            }
        };

        /* renamed from: c */
        public static final InterfaceC0714b f862c = new InterfaceC0714b() { // from class: com.bumptech.glide.load.engine.c.a.b.3
            @Override // com.bumptech.glide.load.engine.p024c.GlideExecutor.InterfaceC0714b
            /* renamed from: a */
            public void mo12111a(Throwable th) {
                if (th != null) {
                    throw new RuntimeException("Request threw uncaught throwable", th);
                }
            }
        };

        /* renamed from: d */
        public static final InterfaceC0714b f863d = f861b;

        /* renamed from: a */
        void mo12111a(Throwable th);
    }

    /* renamed from: a */
    public static GlideExecutor m12119a() {
        return m12117a(1, "disk-cache", InterfaceC0714b.f863d);
    }

    /* renamed from: a */
    public static GlideExecutor m12117a(int i, String str, InterfaceC0714b interfaceC0714b) {
        return new GlideExecutor(new ThreadPoolExecutor(i, i, 0L, TimeUnit.MILLISECONDS, new PriorityBlockingQueue(), new ThreadFactoryC0712a(str, interfaceC0714b, true)));
    }

    /* renamed from: b */
    public static GlideExecutor m12116b() {
        return m12115b(m12112e(), "source", InterfaceC0714b.f863d);
    }

    /* renamed from: b */
    public static GlideExecutor m12115b(int i, String str, InterfaceC0714b interfaceC0714b) {
        return new GlideExecutor(new ThreadPoolExecutor(i, i, 0L, TimeUnit.MILLISECONDS, new PriorityBlockingQueue(), new ThreadFactoryC0712a(str, interfaceC0714b, false)));
    }

    /* renamed from: c */
    public static GlideExecutor m12114c() {
        return new GlideExecutor(new ThreadPoolExecutor(0, Integer.MAX_VALUE, f852a, TimeUnit.MILLISECONDS, new SynchronousQueue(), new ThreadFactoryC0712a("source-unlimited", InterfaceC0714b.f863d, false)));
    }

    /* renamed from: d */
    public static GlideExecutor m12113d() {
        return m12118a(m12112e() >= 4 ? 2 : 1, InterfaceC0714b.f863d);
    }

    /* renamed from: a */
    public static GlideExecutor m12118a(int i, InterfaceC0714b interfaceC0714b) {
        return new GlideExecutor(new ThreadPoolExecutor(0, i, f852a, TimeUnit.MILLISECONDS, new PriorityBlockingQueue(), new ThreadFactoryC0712a("animation", interfaceC0714b, true)));
    }

    @VisibleForTesting
    GlideExecutor(ExecutorService executorService) {
        this.f854c = executorService;
    }

    @Override // java.util.concurrent.Executor
    public void execute(@NonNull Runnable runnable) {
        this.f854c.execute(runnable);
    }

    @Override // java.util.concurrent.ExecutorService
    @NonNull
    public Future<?> submit(@NonNull Runnable runnable) {
        return this.f854c.submit(runnable);
    }

    @Override // java.util.concurrent.ExecutorService
    @NonNull
    public <T> List<Future<T>> invokeAll(@NonNull Collection<? extends Callable<T>> collection) throws InterruptedException {
        return this.f854c.invokeAll(collection);
    }

    @Override // java.util.concurrent.ExecutorService
    @NonNull
    public <T> List<Future<T>> invokeAll(@NonNull Collection<? extends Callable<T>> collection, long j, @NonNull TimeUnit timeUnit) throws InterruptedException {
        return this.f854c.invokeAll(collection, j, timeUnit);
    }

    @Override // java.util.concurrent.ExecutorService
    @NonNull
    public <T> T invokeAny(@NonNull Collection<? extends Callable<T>> collection) throws InterruptedException, ExecutionException {
        return (T) this.f854c.invokeAny(collection);
    }

    @Override // java.util.concurrent.ExecutorService
    public <T> T invokeAny(@NonNull Collection<? extends Callable<T>> collection, long j, @NonNull TimeUnit timeUnit) throws InterruptedException, ExecutionException, TimeoutException {
        return (T) this.f854c.invokeAny(collection, j, timeUnit);
    }

    @Override // java.util.concurrent.ExecutorService
    @NonNull
    public <T> Future<T> submit(@NonNull Runnable runnable, T t) {
        return this.f854c.submit(runnable, t);
    }

    @Override // java.util.concurrent.ExecutorService
    public <T> Future<T> submit(@NonNull Callable<T> callable) {
        return this.f854c.submit(callable);
    }

    @Override // java.util.concurrent.ExecutorService
    public void shutdown() {
        this.f854c.shutdown();
    }

    @Override // java.util.concurrent.ExecutorService
    @NonNull
    public List<Runnable> shutdownNow() {
        return this.f854c.shutdownNow();
    }

    @Override // java.util.concurrent.ExecutorService
    public boolean isShutdown() {
        return this.f854c.isShutdown();
    }

    @Override // java.util.concurrent.ExecutorService
    public boolean isTerminated() {
        return this.f854c.isTerminated();
    }

    @Override // java.util.concurrent.ExecutorService
    public boolean awaitTermination(long j, @NonNull TimeUnit timeUnit) throws InterruptedException {
        return this.f854c.awaitTermination(j, timeUnit);
    }

    public String toString() {
        return this.f854c.toString();
    }

    /* renamed from: e */
    public static int m12112e() {
        if (f853b == 0) {
            f853b = Math.min(4, RuntimeCompat.m12110a());
        }
        return f853b;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: GlideExecutor.java */
    /* renamed from: com.bumptech.glide.load.engine.c.a$a */
    /* loaded from: classes.dex */
    public static final class ThreadFactoryC0712a implements ThreadFactory {

        /* renamed from: a */
        final InterfaceC0714b f855a;

        /* renamed from: b */
        final boolean f856b;

        /* renamed from: c */
        private final String f857c;

        /* renamed from: d */
        private int f858d;

        ThreadFactoryC0712a(String str, InterfaceC0714b interfaceC0714b, boolean z) {
            this.f857c = str;
            this.f855a = interfaceC0714b;
            this.f856b = z;
        }

        @Override // java.util.concurrent.ThreadFactory
        public synchronized Thread newThread(@NonNull Runnable runnable) {
            Thread thread;
            thread = new Thread(runnable, "glide-" + this.f857c + "-thread-" + this.f858d) { // from class: com.bumptech.glide.load.engine.c.a.a.1
                @Override // java.lang.Thread, java.lang.Runnable
                public void run() {
                    Process.setThreadPriority(9);
                    if (ThreadFactoryC0712a.this.f856b) {
                        StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder().detectNetwork().penaltyDeath().build());
                    }
                    try {
                        super.run();
                    } catch (Throwable th) {
                        ThreadFactoryC0712a.this.f855a.mo12111a(th);
                    }
                }
            };
            this.f858d = this.f858d + 1;
            return thread;
        }
    }
}
