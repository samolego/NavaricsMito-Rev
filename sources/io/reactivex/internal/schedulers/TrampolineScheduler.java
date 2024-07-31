package io.reactivex.internal.schedulers;

import io.reactivex.AbstractC2901p;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.disposables.Disposables;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.p100a.ObjectHelper;
import io.reactivex.p098d.RxJavaPlugins;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* renamed from: io.reactivex.internal.schedulers.h */
/* loaded from: classes2.dex */
public final class TrampolineScheduler extends AbstractC2901p {

    /* renamed from: b */
    private static final TrampolineScheduler f9847b = new TrampolineScheduler();

    /* renamed from: c */
    public static TrampolineScheduler m3134c() {
        return f9847b;
    }

    @Override // io.reactivex.AbstractC2901p
    @NonNull
    /* renamed from: a */
    public AbstractC2901p.AbstractC2904c mo3063a() {
        return new C2897c();
    }

    TrampolineScheduler() {
    }

    @Override // io.reactivex.AbstractC2901p
    @NonNull
    /* renamed from: a */
    public Disposable mo3062a(@NonNull Runnable runnable) {
        RxJavaPlugins.m3234a(runnable).run();
        return EmptyDisposable.INSTANCE;
    }

    @Override // io.reactivex.AbstractC2901p
    @NonNull
    /* renamed from: a */
    public Disposable mo3060a(@NonNull Runnable runnable, long j, TimeUnit timeUnit) {
        try {
            timeUnit.sleep(j);
            RxJavaPlugins.m3234a(runnable).run();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            RxJavaPlugins.m3233a(e);
        }
        return EmptyDisposable.INSTANCE;
    }

    /* compiled from: TrampolineScheduler.java */
    /* renamed from: io.reactivex.internal.schedulers.h$c */
    /* loaded from: classes2.dex */
    static final class C2897c extends AbstractC2901p.AbstractC2904c implements Disposable {

        /* renamed from: c */
        volatile boolean f9857c;

        /* renamed from: a */
        final PriorityBlockingQueue<C2896b> f9855a = new PriorityBlockingQueue<>();

        /* renamed from: d */
        private final AtomicInteger f9858d = new AtomicInteger();

        /* renamed from: b */
        final AtomicInteger f9856b = new AtomicInteger();

        C2897c() {
        }

        @Override // io.reactivex.AbstractC2901p.AbstractC2904c
        @NonNull
        /* renamed from: a */
        public Disposable mo3058a(@NonNull Runnable runnable) {
            return m3132a(runnable, m3055a(TimeUnit.MILLISECONDS));
        }

        @Override // io.reactivex.AbstractC2901p.AbstractC2904c
        @NonNull
        /* renamed from: a */
        public Disposable mo3056a(@NonNull Runnable runnable, long j, @NonNull TimeUnit timeUnit) {
            long a = m3055a(TimeUnit.MILLISECONDS) + timeUnit.toMillis(j);
            return m3132a(new RunnableC2895a(runnable, this, a), a);
        }

        /* renamed from: a */
        Disposable m3132a(Runnable runnable, long j) {
            if (this.f9857c) {
                return EmptyDisposable.INSTANCE;
            }
            C2896b c2896b = new C2896b(runnable, Long.valueOf(j), this.f9856b.incrementAndGet());
            this.f9855a.add(c2896b);
            if (this.f9858d.getAndIncrement() == 0) {
                int i = 1;
                while (!this.f9857c) {
                    C2896b poll = this.f9855a.poll();
                    if (poll != null) {
                        if (!poll.f9854d) {
                            poll.f9851a.run();
                        }
                    } else {
                        i = this.f9858d.addAndGet(-i);
                        if (i == 0) {
                            return EmptyDisposable.INSTANCE;
                        }
                    }
                }
                this.f9855a.clear();
                return EmptyDisposable.INSTANCE;
            }
            return Disposables.m3220a(new RunnableC2898a(c2896b));
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            this.f9857c = true;
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.f9857c;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: TrampolineScheduler.java */
        /* renamed from: io.reactivex.internal.schedulers.h$c$a */
        /* loaded from: classes2.dex */
        public final class RunnableC2898a implements Runnable {

            /* renamed from: a */
            final C2896b f9859a;

            RunnableC2898a(C2896b c2896b) {
                this.f9859a = c2896b;
            }

            @Override // java.lang.Runnable
            public void run() {
                this.f9859a.f9854d = true;
                C2897c.this.f9855a.remove(this.f9859a);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: TrampolineScheduler.java */
    /* renamed from: io.reactivex.internal.schedulers.h$b */
    /* loaded from: classes2.dex */
    public static final class C2896b implements Comparable<C2896b> {

        /* renamed from: a */
        final Runnable f9851a;

        /* renamed from: b */
        final long f9852b;

        /* renamed from: c */
        final int f9853c;

        /* renamed from: d */
        volatile boolean f9854d;

        C2896b(Runnable runnable, Long l, int i) {
            this.f9851a = runnable;
            this.f9852b = l.longValue();
            this.f9853c = i;
        }

        @Override // java.lang.Comparable
        /* renamed from: a */
        public int compareTo(C2896b c2896b) {
            int m3190a = ObjectHelper.m3190a(this.f9852b, c2896b.f9852b);
            return m3190a == 0 ? ObjectHelper.m3192a(this.f9853c, c2896b.f9853c) : m3190a;
        }
    }

    /* compiled from: TrampolineScheduler.java */
    /* renamed from: io.reactivex.internal.schedulers.h$a */
    /* loaded from: classes2.dex */
    static final class RunnableC2895a implements Runnable {

        /* renamed from: a */
        private final Runnable f9848a;

        /* renamed from: b */
        private final C2897c f9849b;

        /* renamed from: c */
        private final long f9850c;

        RunnableC2895a(Runnable runnable, C2897c c2897c, long j) {
            this.f9848a = runnable;
            this.f9849b = c2897c;
            this.f9850c = j;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.f9849b.f9857c) {
                return;
            }
            long a = this.f9849b.m3055a(TimeUnit.MILLISECONDS);
            long j = this.f9850c;
            if (j > a) {
                try {
                    Thread.sleep(j - a);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    RxJavaPlugins.m3233a(e);
                    return;
                }
            }
            if (this.f9849b.f9857c) {
                return;
            }
            this.f9848a.run();
        }
    }
}
