package com.bumptech.glide.load.engine.p020c;

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

/* compiled from: GlideExecutor.java */
/* renamed from: com.bumptech.glide.load.engine.c.a */
/* loaded from: classes.dex */
public final class ExecutorServiceC0649a implements ExecutorService {

    /* renamed from: a */
    private static final long f856a = TimeUnit.SECONDS.toMillis(10);

    /* renamed from: b */
    private static volatile int f857b;

    /* renamed from: c */
    private final ExecutorService f858c;

    /* compiled from: GlideExecutor.java */
    /* renamed from: com.bumptech.glide.load.engine.c.a$b */
    /* loaded from: classes.dex */
    public interface b {

        /* renamed from: a */
        public static final b f864a = new b() { // from class: com.bumptech.glide.load.engine.c.a.b.1
            @Override // com.bumptech.glide.load.engine.p020c.ExecutorServiceC0649a.b
            /* renamed from: a */
            public void mo872a(Throwable th) {
            }
        };

        /* renamed from: b */
        public static final b f865b = new b() { // from class: com.bumptech.glide.load.engine.c.a.b.2
            @Override // com.bumptech.glide.load.engine.p020c.ExecutorServiceC0649a.b
            /* renamed from: a */
            public void mo872a(Throwable th) {
                if (th == null || !Log.isLoggable("GlideExecutor", 6)) {
                    return;
                }
                Log.e("GlideExecutor", "Request threw uncaught throwable", th);
            }
        };

        /* renamed from: c */
        public static final b f866c = new b() { // from class: com.bumptech.glide.load.engine.c.a.b.3
            @Override // com.bumptech.glide.load.engine.p020c.ExecutorServiceC0649a.b
            /* renamed from: a */
            public void mo872a(Throwable th) {
                if (th != null) {
                    throw new RuntimeException("Request threw uncaught throwable", th);
                }
            }
        };

        /* renamed from: d */
        public static final b f867d = f865b;

        /* renamed from: a */
        void mo872a(Throwable th);
    }

    /* renamed from: a */
    public static ExecutorServiceC0649a m864a() {
        return m866a(1, "disk-cache", b.f867d);
    }

    /* renamed from: a */
    public static ExecutorServiceC0649a m866a(int i, String str, b bVar) {
        return new ExecutorServiceC0649a(new ThreadPoolExecutor(i, i, 0L, TimeUnit.MILLISECONDS, new PriorityBlockingQueue(), new a(str, bVar, true)));
    }

    /* renamed from: b */
    public static ExecutorServiceC0649a m867b() {
        return m868b(m871e(), "source", b.f867d);
    }

    /* renamed from: b */
    public static ExecutorServiceC0649a m868b(int i, String str, b bVar) {
        return new ExecutorServiceC0649a(new ThreadPoolExecutor(i, i, 0L, TimeUnit.MILLISECONDS, new PriorityBlockingQueue(), new a(str, bVar, false)));
    }

    /* renamed from: c */
    public static ExecutorServiceC0649a m869c() {
        return new ExecutorServiceC0649a(new ThreadPoolExecutor(0, Integer.MAX_VALUE, f856a, TimeUnit.MILLISECONDS, new SynchronousQueue(), new a("source-unlimited", b.f867d, false)));
    }

    /* renamed from: d */
    public static ExecutorServiceC0649a m870d() {
        return m865a(m871e() >= 4 ? 2 : 1, b.f867d);
    }

    /* renamed from: a */
    public static ExecutorServiceC0649a m865a(int i, b bVar) {
        return new ExecutorServiceC0649a(new ThreadPoolExecutor(0, i, f856a, TimeUnit.MILLISECONDS, new PriorityBlockingQueue(), new a("animation", bVar, true)));
    }

    @VisibleForTesting
    ExecutorServiceC0649a(ExecutorService executorService) {
        this.f858c = executorService;
    }

    @Override // java.util.concurrent.Executor
    public void execute(@NonNull Runnable runnable) {
        this.f858c.execute(runnable);
    }

    @Override // java.util.concurrent.ExecutorService
    @NonNull
    public Future<?> submit(@NonNull Runnable runnable) {
        return this.f858c.submit(runnable);
    }

    @Override // java.util.concurrent.ExecutorService
    @NonNull
    public <T> List<Future<T>> invokeAll(@NonNull Collection<? extends Callable<T>> collection) throws InterruptedException {
        return this.f858c.invokeAll(collection);
    }

    @Override // java.util.concurrent.ExecutorService
    @NonNull
    public <T> List<Future<T>> invokeAll(@NonNull Collection<? extends Callable<T>> collection, long j, @NonNull TimeUnit timeUnit) throws InterruptedException {
        return this.f858c.invokeAll(collection, j, timeUnit);
    }

    @Override // java.util.concurrent.ExecutorService
    @NonNull
    public <T> T invokeAny(@NonNull Collection<? extends Callable<T>> collection) throws InterruptedException, ExecutionException {
        return (T) this.f858c.invokeAny(collection);
    }

    @Override // java.util.concurrent.ExecutorService
    public <T> T invokeAny(@NonNull Collection<? extends Callable<T>> collection, long j, @NonNull TimeUnit timeUnit) throws InterruptedException, ExecutionException, TimeoutException {
        return (T) this.f858c.invokeAny(collection, j, timeUnit);
    }

    @Override // java.util.concurrent.ExecutorService
    @NonNull
    public <T> Future<T> submit(@NonNull Runnable runnable, T t) {
        return this.f858c.submit(runnable, t);
    }

    @Override // java.util.concurrent.ExecutorService
    public <T> Future<T> submit(@NonNull Callable<T> callable) {
        return this.f858c.submit(callable);
    }

    @Override // java.util.concurrent.ExecutorService
    public void shutdown() {
        this.f858c.shutdown();
    }

    @Override // java.util.concurrent.ExecutorService
    @NonNull
    public List<Runnable> shutdownNow() {
        return this.f858c.shutdownNow();
    }

    @Override // java.util.concurrent.ExecutorService
    public boolean isShutdown() {
        return this.f858c.isShutdown();
    }

    @Override // java.util.concurrent.ExecutorService
    public boolean isTerminated() {
        return this.f858c.isTerminated();
    }

    @Override // java.util.concurrent.ExecutorService
    public boolean awaitTermination(long j, @NonNull TimeUnit timeUnit) throws InterruptedException {
        return this.f858c.awaitTermination(j, timeUnit);
    }

    public String toString() {
        return this.f858c.toString();
    }

    /* renamed from: e */
    public static int m871e() {
        if (f857b == 0) {
            f857b = Math.min(4, RuntimeCompat.m873a());
        }
        return f857b;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: GlideExecutor.java */
    /* renamed from: com.bumptech.glide.load.engine.c.a$a */
    /* loaded from: classes.dex */
    public static final class a implements ThreadFactory {

        /* renamed from: a */
        final b f859a;

        /* renamed from: b */
        final boolean f860b;

        /* renamed from: c */
        private final String f861c;

        /* renamed from: d */
        private int f862d;

        a(String str, b bVar, boolean z) {
            this.f861c = str;
            this.f859a = bVar;
            this.f860b = z;
        }

        @Override // java.util.concurrent.ThreadFactory
        public synchronized Thread newThread(@NonNull Runnable runnable) {
            Thread thread;
            thread = new Thread(runnable, "glide-" + this.f861c + "-thread-" + this.f862d) { // from class: com.bumptech.glide.load.engine.c.a.a.1
                @Override // java.lang.Thread, java.lang.Runnable
                public void run() {
                    Process.setThreadPriority(9);
                    if (a.this.f860b) {
                        StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder().detectNetwork().penaltyDeath().build());
                    }
                    try {
                        super.run();
                    } catch (Throwable th) {
                        a.this.f859a.mo872a(th);
                    }
                }
            };
            this.f862d = this.f862d + 1;
            return thread;
        }
    }
}