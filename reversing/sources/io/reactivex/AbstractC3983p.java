package io.reactivex;

import io.reactivex.annotations.NonNull;
import io.reactivex.annotations.Nullable;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.disposables.SequentialDisposable;
import io.reactivex.internal.schedulers.NewThreadWorker;
import io.reactivex.internal.util.ExceptionHelper;
import io.reactivex.p098d.RxJavaPlugins;
import java.util.concurrent.TimeUnit;

/* compiled from: Scheduler.java */
/* renamed from: io.reactivex.p */
/* loaded from: classes2.dex */
public abstract class AbstractC2901p {

    /* renamed from: a */
    static final long f9876a = TimeUnit.MINUTES.toNanos(Long.getLong("rx2.scheduler.drift-tolerance", 15).longValue());

    @NonNull
    /* renamed from: a */
    public abstract AbstractC2904c mo3063a();

    /* renamed from: b */
    public void mo3059b() {
    }

    @NonNull
    /* renamed from: a */
    public Disposable mo3062a(@NonNull Runnable runnable) {
        return mo3060a(runnable, 0L, TimeUnit.NANOSECONDS);
    }

    @NonNull
    /* renamed from: a */
    public Disposable mo3060a(@NonNull Runnable runnable, long j, @NonNull TimeUnit timeUnit) {
        AbstractC2904c mo3063a = mo3063a();
        RunnableC2902a runnableC2902a = new RunnableC2902a(RxJavaPlugins.m3234a(runnable), mo3063a);
        mo3063a.mo3056a(runnableC2902a, j, timeUnit);
        return runnableC2902a;
    }

    @NonNull
    /* renamed from: a */
    public Disposable mo3061a(@NonNull Runnable runnable, long j, long j2, @NonNull TimeUnit timeUnit) {
        AbstractC2904c mo3063a = mo3063a();
        RunnableC2903b runnableC2903b = new RunnableC2903b(RxJavaPlugins.m3234a(runnable), mo3063a);
        Disposable m3057a = mo3063a.m3057a(runnableC2903b, j, j2, timeUnit);
        return m3057a == EmptyDisposable.INSTANCE ? m3057a : runnableC2903b;
    }

    /* compiled from: Scheduler.java */
    /* renamed from: io.reactivex.p$c */
    /* loaded from: classes2.dex */
    public static abstract class AbstractC2904c implements Disposable {
        @NonNull
        /* renamed from: a */
        public abstract Disposable mo3056a(@NonNull Runnable runnable, long j, @NonNull TimeUnit timeUnit);

        @NonNull
        /* renamed from: a */
        public Disposable mo3058a(@NonNull Runnable runnable) {
            return mo3056a(runnable, 0L, TimeUnit.NANOSECONDS);
        }

        @NonNull
        /* renamed from: a */
        public Disposable m3057a(@NonNull Runnable runnable, long j, long j2, @NonNull TimeUnit timeUnit) {
            SequentialDisposable sequentialDisposable = new SequentialDisposable();
            SequentialDisposable sequentialDisposable2 = new SequentialDisposable(sequentialDisposable);
            Runnable m3234a = RxJavaPlugins.m3234a(runnable);
            long nanos = timeUnit.toNanos(j2);
            long m3055a = m3055a(TimeUnit.NANOSECONDS);
            Disposable mo3056a = mo3056a(new RunnableC2905a(m3055a + timeUnit.toNanos(j), m3234a, m3055a, sequentialDisposable2, nanos), j, timeUnit);
            if (mo3056a == EmptyDisposable.INSTANCE) {
                return mo3056a;
            }
            sequentialDisposable.replace(mo3056a);
            return sequentialDisposable2;
        }

        /* renamed from: a */
        public long m3055a(@NonNull TimeUnit timeUnit) {
            return timeUnit.convert(System.currentTimeMillis(), TimeUnit.MILLISECONDS);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: Scheduler.java */
        /* renamed from: io.reactivex.p$c$a */
        /* loaded from: classes2.dex */
        public final class RunnableC2905a implements Runnable {
            @NonNull

            /* renamed from: a */
            final Runnable f9883a;
            @NonNull

            /* renamed from: b */
            final SequentialDisposable f9884b;

            /* renamed from: c */
            final long f9885c;

            /* renamed from: d */
            long f9886d;

            /* renamed from: e */
            long f9887e;

            /* renamed from: f */
            long f9888f;

            RunnableC2905a(long j, Runnable runnable, @NonNull long j2, SequentialDisposable sequentialDisposable, @NonNull long j3) {
                this.f9883a = runnable;
                this.f9884b = sequentialDisposable;
                this.f9885c = j3;
                this.f9887e = j2;
                this.f9888f = j;
            }

            @Override // java.lang.Runnable
            public void run() {
                long j;
                this.f9883a.run();
                if (this.f9884b.isDisposed()) {
                    return;
                }
                long m3055a = AbstractC2904c.this.m3055a(TimeUnit.NANOSECONDS);
                long j2 = this.f9887e;
                if (AbstractC2901p.f9876a + m3055a < j2 || m3055a >= j2 + this.f9885c + AbstractC2901p.f9876a) {
                    long j3 = this.f9885c;
                    long j4 = m3055a + j3;
                    long j5 = this.f9886d + 1;
                    this.f9886d = j5;
                    this.f9888f = j4 - (j3 * j5);
                    j = j4;
                } else {
                    long j6 = this.f9888f;
                    long j7 = this.f9886d + 1;
                    this.f9886d = j7;
                    j = j6 + (j7 * this.f9885c);
                }
                this.f9887e = m3055a;
                this.f9884b.replace(AbstractC2904c.this.mo3056a(this, j - m3055a, TimeUnit.NANOSECONDS));
            }
        }
    }

    /* compiled from: Scheduler.java */
    /* renamed from: io.reactivex.p$b */
    /* loaded from: classes2.dex */
    static final class RunnableC2903b implements Disposable, Runnable {
        @NonNull

        /* renamed from: a */
        final Runnable f9880a;
        @NonNull

        /* renamed from: b */
        final AbstractC2904c f9881b;

        /* renamed from: c */
        volatile boolean f9882c;

        RunnableC2903b(@NonNull Runnable runnable, @NonNull AbstractC2904c abstractC2904c) {
            this.f9880a = runnable;
            this.f9881b = abstractC2904c;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.f9882c) {
                return;
            }
            try {
                this.f9880a.run();
            } catch (Throwable th) {
                Exceptions.m3207b(th);
                this.f9881b.dispose();
                throw ExceptionHelper.m3131a(th);
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            this.f9882c = true;
            this.f9881b.dispose();
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.f9882c;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Scheduler.java */
    /* renamed from: io.reactivex.p$a */
    /* loaded from: classes2.dex */
    public static final class RunnableC2902a implements Disposable, Runnable {
        @NonNull

        /* renamed from: a */
        final Runnable f9877a;
        @NonNull

        /* renamed from: b */
        final AbstractC2904c f9878b;
        @Nullable

        /* renamed from: c */
        Thread f9879c;

        RunnableC2902a(@NonNull Runnable runnable, @NonNull AbstractC2904c abstractC2904c) {
            this.f9877a = runnable;
            this.f9878b = abstractC2904c;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f9879c = Thread.currentThread();
            try {
                this.f9877a.run();
            } finally {
                dispose();
                this.f9879c = null;
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            if (this.f9879c == Thread.currentThread()) {
                AbstractC2904c abstractC2904c = this.f9878b;
                if (abstractC2904c instanceof NewThreadWorker) {
                    ((NewThreadWorker) abstractC2904c).m3143b();
                    return;
                }
            }
            this.f9878b.dispose();
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.f9878b.isDisposed();
        }
    }
}
