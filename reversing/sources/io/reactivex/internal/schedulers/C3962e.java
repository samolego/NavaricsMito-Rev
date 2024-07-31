package io.reactivex.internal.schedulers;

import io.reactivex.AbstractC2901p;
import io.reactivex.annotations.NonNull;
import io.reactivex.annotations.Nullable;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableContainer;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.p098d.RxJavaPlugins;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;

/* renamed from: io.reactivex.internal.schedulers.e */
/* loaded from: classes2.dex */
public class NewThreadWorker extends AbstractC2901p.AbstractC2904c implements Disposable {

    /* renamed from: a */
    volatile boolean f9832a;

    /* renamed from: b */
    private final ScheduledExecutorService f9833b;

    public NewThreadWorker(ThreadFactory threadFactory) {
        this.f9833b = SchedulerPoolFactory.m3139a(threadFactory);
    }

    @Override // io.reactivex.AbstractC2901p.AbstractC2904c
    @NonNull
    /* renamed from: a */
    public Disposable mo3058a(@NonNull Runnable runnable) {
        return mo3056a(runnable, 0L, null);
    }

    @Override // io.reactivex.AbstractC2901p.AbstractC2904c
    @NonNull
    /* renamed from: a */
    public Disposable mo3056a(@NonNull Runnable runnable, long j, @NonNull TimeUnit timeUnit) {
        if (this.f9832a) {
            return EmptyDisposable.INSTANCE;
        }
        return m3144a(runnable, j, timeUnit, (DisposableContainer) null);
    }

    /* renamed from: b */
    public Disposable m3141b(Runnable runnable, long j, TimeUnit timeUnit) {
        Future<?> schedule;
        ScheduledDirectTask scheduledDirectTask = new ScheduledDirectTask(RxJavaPlugins.m3234a(runnable));
        try {
            if (j <= 0) {
                schedule = this.f9833b.submit(scheduledDirectTask);
            } else {
                schedule = this.f9833b.schedule(scheduledDirectTask, j, timeUnit);
            }
            scheduledDirectTask.setFuture(schedule);
            return scheduledDirectTask;
        } catch (RejectedExecutionException e) {
            RxJavaPlugins.m3233a(e);
            return EmptyDisposable.INSTANCE;
        }
    }

    /* renamed from: b */
    public Disposable m3142b(Runnable runnable, long j, long j2, TimeUnit timeUnit) {
        Future<?> schedule;
        Runnable m3234a = RxJavaPlugins.m3234a(runnable);
        if (j2 <= 0) {
            InstantPeriodicTask instantPeriodicTask = new InstantPeriodicTask(m3234a, this.f9833b);
            try {
                if (j <= 0) {
                    schedule = this.f9833b.submit(instantPeriodicTask);
                } else {
                    schedule = this.f9833b.schedule(instantPeriodicTask, j, timeUnit);
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
            scheduledDirectPeriodicTask.setFuture(this.f9833b.scheduleAtFixedRate(scheduledDirectPeriodicTask, j, j2, timeUnit));
            return scheduledDirectPeriodicTask;
        } catch (RejectedExecutionException e2) {
            RxJavaPlugins.m3233a(e2);
            return EmptyDisposable.INSTANCE;
        }
    }

    @NonNull
    /* renamed from: a */
    public ScheduledRunnable m3144a(Runnable runnable, long j, @NonNull TimeUnit timeUnit, @Nullable DisposableContainer disposableContainer) {
        Future<?> schedule;
        ScheduledRunnable scheduledRunnable = new ScheduledRunnable(RxJavaPlugins.m3234a(runnable), disposableContainer);
        if (disposableContainer == null || disposableContainer.mo3187a(scheduledRunnable)) {
            try {
                if (j <= 0) {
                    schedule = this.f9833b.submit((Callable) scheduledRunnable);
                } else {
                    schedule = this.f9833b.schedule((Callable) scheduledRunnable, j, timeUnit);
                }
                scheduledRunnable.setFuture(schedule);
            } catch (RejectedExecutionException e) {
                if (disposableContainer != null) {
                    disposableContainer.mo3185b(scheduledRunnable);
                }
                RxJavaPlugins.m3233a(e);
            }
            return scheduledRunnable;
        }
        return scheduledRunnable;
    }

    @Override // io.reactivex.disposables.Disposable
    public void dispose() {
        if (this.f9832a) {
            return;
        }
        this.f9832a = true;
        this.f9833b.shutdownNow();
    }

    /* renamed from: b */
    public void m3143b() {
        if (this.f9832a) {
            return;
        }
        this.f9832a = true;
        this.f9833b.shutdown();
    }

    @Override // io.reactivex.disposables.Disposable
    public boolean isDisposed() {
        return this.f9832a;
    }
}
