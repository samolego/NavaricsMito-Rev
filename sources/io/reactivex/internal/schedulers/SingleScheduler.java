package io.reactivex.internal.schedulers;

import io.reactivex.AbstractC2901p;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.p098d.RxJavaPlugins;
import java.util.concurrent.Callable;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/* renamed from: io.reactivex.internal.schedulers.g */
/* loaded from: classes2.dex */
public final class SingleScheduler extends AbstractC2901p {

    /* renamed from: d */
    static final RxThreadFactory f9840d;

    /* renamed from: e */
    static final ScheduledExecutorService f9841e = Executors.newScheduledThreadPool(0);

    /* renamed from: b */
    final ThreadFactory f9842b;

    /* renamed from: c */
    final AtomicReference<ScheduledExecutorService> f9843c;

    static {
        f9841e.shutdown();
        f9840d = new RxThreadFactory("RxSingleScheduler", Math.max(1, Math.min(10, Integer.getInteger("rx2.single-priority", 5).intValue())), true);
    }

    public SingleScheduler() {
        this(f9840d);
    }

    public SingleScheduler(ThreadFactory threadFactory) {
        this.f9843c = new AtomicReference<>();
        this.f9842b = threadFactory;
        this.f9843c.lazySet(m3135a(threadFactory));
    }

    /* renamed from: a */
    static ScheduledExecutorService m3135a(ThreadFactory threadFactory) {
        return SchedulerPoolFactory.m3139a(threadFactory);
    }

    @Override // io.reactivex.AbstractC2901p
    /* renamed from: b */
    public void mo3059b() {
        ScheduledExecutorService scheduledExecutorService;
        ScheduledExecutorService scheduledExecutorService2 = null;
        do {
            scheduledExecutorService = this.f9843c.get();
            if (scheduledExecutorService != f9841e) {
                if (scheduledExecutorService2 != null) {
                    scheduledExecutorService2.shutdown();
                    return;
                }
                return;
            } else if (scheduledExecutorService2 == null) {
                scheduledExecutorService2 = m3135a(this.f9842b);
            }
        } while (!this.f9843c.compareAndSet(scheduledExecutorService, scheduledExecutorService2));
    }

    @Override // io.reactivex.AbstractC2901p
    @NonNull
    /* renamed from: a */
    public AbstractC2901p.AbstractC2904c mo3063a() {
        return new C2894a(this.f9843c.get());
    }

    @Override // io.reactivex.AbstractC2901p
    @NonNull
    /* renamed from: a */
    public Disposable mo3060a(@NonNull Runnable runnable, long j, TimeUnit timeUnit) {
        Future<?> schedule;
        ScheduledDirectTask scheduledDirectTask = new ScheduledDirectTask(RxJavaPlugins.m3234a(runnable));
        try {
            if (j <= 0) {
                schedule = this.f9843c.get().submit(scheduledDirectTask);
            } else {
                schedule = this.f9843c.get().schedule(scheduledDirectTask, j, timeUnit);
            }
            scheduledDirectTask.setFuture(schedule);
            return scheduledDirectTask;
        } catch (RejectedExecutionException e) {
            RxJavaPlugins.m3233a(e);
            return EmptyDisposable.INSTANCE;
        }
    }

    @Override // io.reactivex.AbstractC2901p
    @NonNull
    /* renamed from: a */
    public Disposable mo3061a(@NonNull Runnable runnable, long j, long j2, TimeUnit timeUnit) {
        Future<?> schedule;
        Runnable m3234a = RxJavaPlugins.m3234a(runnable);
        if (j2 <= 0) {
            ScheduledExecutorService scheduledExecutorService = this.f9843c.get();
            InstantPeriodicTask instantPeriodicTask = new InstantPeriodicTask(m3234a, scheduledExecutorService);
            try {
                if (j <= 0) {
                    schedule = scheduledExecutorService.submit(instantPeriodicTask);
                } else {
                    schedule = scheduledExecutorService.schedule(instantPeriodicTask, j, timeUnit);
                }
                instantPeriodicTask.m3153a(schedule);
                return instantPeriodicTask;
            } catch (RejectedExecutionException e) {
                RxJavaPlugins.m3233a(e);
                return EmptyDisposable.INSTANCE;
            }
        }
        ScheduledDirectPeriodicTask scheduledDirectPeriodicTask = new ScheduledDirectPeriodicTask(m3234a);
        try {
            scheduledDirectPeriodicTask.setFuture(this.f9843c.get().scheduleAtFixedRate(scheduledDirectPeriodicTask, j, j2, timeUnit));
            return scheduledDirectPeriodicTask;
        } catch (RejectedExecutionException e2) {
            RxJavaPlugins.m3233a(e2);
            return EmptyDisposable.INSTANCE;
        }
    }

    /* compiled from: SingleScheduler.java */
    /* renamed from: io.reactivex.internal.schedulers.g$a */
    /* loaded from: classes2.dex */
    static final class C2894a extends AbstractC2901p.AbstractC2904c {

        /* renamed from: a */
        final ScheduledExecutorService f9844a;

        /* renamed from: b */
        final CompositeDisposable f9845b = new CompositeDisposable();

        /* renamed from: c */
        volatile boolean f9846c;

        C2894a(ScheduledExecutorService scheduledExecutorService) {
            this.f9844a = scheduledExecutorService;
        }

        @Override // io.reactivex.AbstractC2901p.AbstractC2904c
        @NonNull
        /* renamed from: a */
        public Disposable mo3056a(@NonNull Runnable runnable, long j, @NonNull TimeUnit timeUnit) {
            Future<?> schedule;
            if (this.f9846c) {
                return EmptyDisposable.INSTANCE;
            }
            ScheduledRunnable scheduledRunnable = new ScheduledRunnable(RxJavaPlugins.m3234a(runnable), this.f9845b);
            this.f9845b.mo3187a(scheduledRunnable);
            try {
                if (j <= 0) {
                    schedule = this.f9844a.submit((Callable) scheduledRunnable);
                } else {
                    schedule = this.f9844a.schedule((Callable) scheduledRunnable, j, timeUnit);
                }
                scheduledRunnable.setFuture(schedule);
                return scheduledRunnable;
            } catch (RejectedExecutionException e) {
                dispose();
                RxJavaPlugins.m3233a(e);
                return EmptyDisposable.INSTANCE;
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            if (this.f9846c) {
                return;
            }
            this.f9846c = true;
            this.f9845b.dispose();
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.f9846c;
        }
    }
}
