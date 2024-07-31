package io.reactivex.internal.schedulers;

import io.reactivex.AbstractC2901p;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.EmptyDisposable;
import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

/* renamed from: io.reactivex.internal.schedulers.c */
/* loaded from: classes2.dex */
public final class IoScheduler extends AbstractC2901p {

    /* renamed from: b */
    static final RxThreadFactory f9812b;

    /* renamed from: c */
    static final RxThreadFactory f9813c;

    /* renamed from: g */
    static final RunnableC2889a f9815g;

    /* renamed from: e */
    final ThreadFactory f9817e;

    /* renamed from: f */
    final AtomicReference<RunnableC2889a> f9818f;

    /* renamed from: h */
    private static final TimeUnit f9816h = TimeUnit.SECONDS;

    /* renamed from: d */
    static final C2891c f9814d = new C2891c(new RxThreadFactory("RxCachedThreadSchedulerShutdown"));

    static {
        f9814d.dispose();
        int max = Math.max(1, Math.min(10, Integer.getInteger("rx2.io-priority", 5).intValue()));
        f9812b = new RxThreadFactory("RxCachedThreadScheduler", max);
        f9813c = new RxThreadFactory("RxCachedWorkerPoolEvictor", max);
        f9815g = new RunnableC2889a(0L, null, f9812b);
        f9815g.m3147d();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: IoScheduler.java */
    /* renamed from: io.reactivex.internal.schedulers.c$a */
    /* loaded from: classes2.dex */
    public static final class RunnableC2889a implements Runnable {

        /* renamed from: a */
        final CompositeDisposable f9819a;

        /* renamed from: b */
        private final long f9820b;

        /* renamed from: c */
        private final ConcurrentLinkedQueue<C2891c> f9821c;

        /* renamed from: d */
        private final ScheduledExecutorService f9822d;

        /* renamed from: e */
        private final Future<?> f9823e;

        /* renamed from: f */
        private final ThreadFactory f9824f;

        RunnableC2889a(long j, TimeUnit timeUnit, ThreadFactory threadFactory) {
            ScheduledFuture<?> scheduledFuture;
            this.f9820b = timeUnit != null ? timeUnit.toNanos(j) : 0L;
            this.f9821c = new ConcurrentLinkedQueue<>();
            this.f9819a = new CompositeDisposable();
            this.f9824f = threadFactory;
            ScheduledExecutorService scheduledExecutorService = null;
            if (timeUnit != null) {
                scheduledExecutorService = Executors.newScheduledThreadPool(1, IoScheduler.f9813c);
                long j2 = this.f9820b;
                scheduledFuture = scheduledExecutorService.scheduleWithFixedDelay(this, j2, j2, TimeUnit.NANOSECONDS);
            } else {
                scheduledFuture = null;
            }
            this.f9822d = scheduledExecutorService;
            this.f9823e = scheduledFuture;
        }

        @Override // java.lang.Runnable
        public void run() {
            m3149b();
        }

        /* renamed from: a */
        C2891c m3151a() {
            if (this.f9819a.isDisposed()) {
                return IoScheduler.f9814d;
            }
            while (!this.f9821c.isEmpty()) {
                C2891c poll = this.f9821c.poll();
                if (poll != null) {
                    return poll;
                }
            }
            C2891c c2891c = new C2891c(this.f9824f);
            this.f9819a.mo3187a(c2891c);
            return c2891c;
        }

        /* renamed from: a */
        void m3150a(C2891c c2891c) {
            c2891c.m3145a(m3148c() + this.f9820b);
            this.f9821c.offer(c2891c);
        }

        /* renamed from: b */
        void m3149b() {
            if (this.f9821c.isEmpty()) {
                return;
            }
            long m3148c = m3148c();
            Iterator<C2891c> it = this.f9821c.iterator();
            while (it.hasNext()) {
                C2891c next = it.next();
                if (next.m3146a() > m3148c) {
                    return;
                }
                if (this.f9821c.remove(next)) {
                    this.f9819a.mo3185b(next);
                }
            }
        }

        /* renamed from: c */
        long m3148c() {
            return System.nanoTime();
        }

        /* renamed from: d */
        void m3147d() {
            this.f9819a.dispose();
            Future<?> future = this.f9823e;
            if (future != null) {
                future.cancel(true);
            }
            ScheduledExecutorService scheduledExecutorService = this.f9822d;
            if (scheduledExecutorService != null) {
                scheduledExecutorService.shutdownNow();
            }
        }
    }

    public IoScheduler() {
        this(f9812b);
    }

    public IoScheduler(ThreadFactory threadFactory) {
        this.f9817e = threadFactory;
        this.f9818f = new AtomicReference<>(f9815g);
        mo3059b();
    }

    @Override // io.reactivex.AbstractC2901p
    /* renamed from: b */
    public void mo3059b() {
        RunnableC2889a runnableC2889a = new RunnableC2889a(60L, f9816h, this.f9817e);
        if (this.f9818f.compareAndSet(f9815g, runnableC2889a)) {
            return;
        }
        runnableC2889a.m3147d();
    }

    @Override // io.reactivex.AbstractC2901p
    @NonNull
    /* renamed from: a */
    public AbstractC2901p.AbstractC2904c mo3063a() {
        return new C2890b(this.f9818f.get());
    }

    /* compiled from: IoScheduler.java */
    /* renamed from: io.reactivex.internal.schedulers.c$b */
    /* loaded from: classes2.dex */
    static final class C2890b extends AbstractC2901p.AbstractC2904c {

        /* renamed from: a */
        final AtomicBoolean f9825a = new AtomicBoolean();

        /* renamed from: b */
        private final CompositeDisposable f9826b = new CompositeDisposable();

        /* renamed from: c */
        private final RunnableC2889a f9827c;

        /* renamed from: d */
        private final C2891c f9828d;

        C2890b(RunnableC2889a runnableC2889a) {
            this.f9827c = runnableC2889a;
            this.f9828d = runnableC2889a.m3151a();
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            if (this.f9825a.compareAndSet(false, true)) {
                this.f9826b.dispose();
                this.f9827c.m3150a(this.f9828d);
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.f9825a.get();
        }

        @Override // io.reactivex.AbstractC2901p.AbstractC2904c
        @NonNull
        /* renamed from: a */
        public Disposable mo3056a(@NonNull Runnable runnable, long j, @NonNull TimeUnit timeUnit) {
            if (this.f9826b.isDisposed()) {
                return EmptyDisposable.INSTANCE;
            }
            return this.f9828d.m3144a(runnable, j, timeUnit, this.f9826b);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: IoScheduler.java */
    /* renamed from: io.reactivex.internal.schedulers.c$c */
    /* loaded from: classes2.dex */
    public static final class C2891c extends NewThreadWorker {

        /* renamed from: b */
        private long f9829b;

        C2891c(ThreadFactory threadFactory) {
            super(threadFactory);
            this.f9829b = 0L;
        }

        /* renamed from: a */
        public long m3146a() {
            return this.f9829b;
        }

        /* renamed from: a */
        public void m3145a(long j) {
            this.f9829b = j;
        }
    }
}
