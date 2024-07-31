package io.reactivex.internal.schedulers;

import io.reactivex.AbstractC2901p;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.disposables.ListCompositeDisposable;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/* renamed from: io.reactivex.internal.schedulers.a */
/* loaded from: classes2.dex */
public final class ComputationScheduler extends AbstractC2901p {

    /* renamed from: b */
    static final C2887b f9792b;

    /* renamed from: c */
    static final RxThreadFactory f9793c;

    /* renamed from: d */
    static final int f9794d = m3157a(Runtime.getRuntime().availableProcessors(), Integer.getInteger("rx2.computation-threads", 0).intValue());

    /* renamed from: e */
    static final C2888c f9795e = new C2888c(new RxThreadFactory("RxComputationShutdown"));

    /* renamed from: f */
    final ThreadFactory f9796f;

    /* renamed from: g */
    final AtomicReference<C2887b> f9797g;

    /* renamed from: a */
    static int m3157a(int i, int i2) {
        return (i2 <= 0 || i2 > i) ? i : i2;
    }

    static {
        f9795e.dispose();
        f9793c = new RxThreadFactory("RxComputationThreadPool", Math.max(1, Math.min(10, Integer.getInteger("rx2.computation-priority", 5).intValue())), true);
        f9792b = new C2887b(0, f9793c);
        f9792b.m3155b();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ComputationScheduler.java */
    /* renamed from: io.reactivex.internal.schedulers.a$b */
    /* loaded from: classes2.dex */
    public static final class C2887b {

        /* renamed from: a */
        final int f9803a;

        /* renamed from: b */
        final C2888c[] f9804b;

        /* renamed from: c */
        long f9805c;

        C2887b(int i, ThreadFactory threadFactory) {
            this.f9803a = i;
            this.f9804b = new C2888c[i];
            for (int i2 = 0; i2 < i; i2++) {
                this.f9804b[i2] = new C2888c(threadFactory);
            }
        }

        /* renamed from: a */
        public C2888c m3156a() {
            int i = this.f9803a;
            if (i == 0) {
                return ComputationScheduler.f9795e;
            }
            C2888c[] c2888cArr = this.f9804b;
            long j = this.f9805c;
            this.f9805c = 1 + j;
            return c2888cArr[(int) (j % i)];
        }

        /* renamed from: b */
        public void m3155b() {
            for (C2888c c2888c : this.f9804b) {
                c2888c.dispose();
            }
        }
    }

    public ComputationScheduler() {
        this(f9793c);
    }

    public ComputationScheduler(ThreadFactory threadFactory) {
        this.f9796f = threadFactory;
        this.f9797g = new AtomicReference<>(f9792b);
        mo3059b();
    }

    @Override // io.reactivex.AbstractC2901p
    @NonNull
    /* renamed from: a */
    public AbstractC2901p.AbstractC2904c mo3063a() {
        return new C2886a(this.f9797g.get().m3156a());
    }

    @Override // io.reactivex.AbstractC2901p
    @NonNull
    /* renamed from: a */
    public Disposable mo3060a(@NonNull Runnable runnable, long j, TimeUnit timeUnit) {
        return this.f9797g.get().m3156a().m3141b(runnable, j, timeUnit);
    }

    @Override // io.reactivex.AbstractC2901p
    @NonNull
    /* renamed from: a */
    public Disposable mo3061a(@NonNull Runnable runnable, long j, long j2, TimeUnit timeUnit) {
        return this.f9797g.get().m3156a().m3142b(runnable, j, j2, timeUnit);
    }

    @Override // io.reactivex.AbstractC2901p
    /* renamed from: b */
    public void mo3059b() {
        C2887b c2887b = new C2887b(f9794d, this.f9796f);
        if (this.f9797g.compareAndSet(f9792b, c2887b)) {
            return;
        }
        c2887b.m3155b();
    }

    /* compiled from: ComputationScheduler.java */
    /* renamed from: io.reactivex.internal.schedulers.a$a */
    /* loaded from: classes2.dex */
    static final class C2886a extends AbstractC2901p.AbstractC2904c {

        /* renamed from: a */
        volatile boolean f9798a;

        /* renamed from: b */
        private final ListCompositeDisposable f9799b = new ListCompositeDisposable();

        /* renamed from: c */
        private final CompositeDisposable f9800c = new CompositeDisposable();

        /* renamed from: d */
        private final ListCompositeDisposable f9801d = new ListCompositeDisposable();

        /* renamed from: e */
        private final C2888c f9802e;

        C2886a(C2888c c2888c) {
            this.f9802e = c2888c;
            this.f9801d.mo3187a(this.f9799b);
            this.f9801d.mo3187a(this.f9800c);
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            if (this.f9798a) {
                return;
            }
            this.f9798a = true;
            this.f9801d.dispose();
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.f9798a;
        }

        @Override // io.reactivex.AbstractC2901p.AbstractC2904c
        @NonNull
        /* renamed from: a */
        public Disposable mo3058a(@NonNull Runnable runnable) {
            if (this.f9798a) {
                return EmptyDisposable.INSTANCE;
            }
            return this.f9802e.m3144a(runnable, 0L, TimeUnit.MILLISECONDS, this.f9799b);
        }

        @Override // io.reactivex.AbstractC2901p.AbstractC2904c
        @NonNull
        /* renamed from: a */
        public Disposable mo3056a(@NonNull Runnable runnable, long j, @NonNull TimeUnit timeUnit) {
            if (this.f9798a) {
                return EmptyDisposable.INSTANCE;
            }
            return this.f9802e.m3144a(runnable, j, timeUnit, this.f9800c);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ComputationScheduler.java */
    /* renamed from: io.reactivex.internal.schedulers.a$c */
    /* loaded from: classes2.dex */
    public static final class C2888c extends NewThreadWorker {
        C2888c(ThreadFactory threadFactory) {
            super(threadFactory);
        }
    }
}
