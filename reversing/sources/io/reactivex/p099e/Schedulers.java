package io.reactivex.p099e;

import io.reactivex.AbstractC2901p;
import io.reactivex.annotations.NonNull;
import io.reactivex.internal.schedulers.ComputationScheduler;
import io.reactivex.internal.schedulers.IoScheduler;
import io.reactivex.internal.schedulers.NewThreadScheduler;
import io.reactivex.internal.schedulers.SingleScheduler;
import io.reactivex.internal.schedulers.TrampolineScheduler;
import io.reactivex.p098d.RxJavaPlugins;
import java.util.concurrent.Callable;

/* renamed from: io.reactivex.e.a */
/* loaded from: classes2.dex */
public final class Schedulers {
    @NonNull

    /* renamed from: a */
    static final AbstractC2901p f9636a = RxJavaPlugins.m3226d(new CallableC2856h());
    @NonNull

    /* renamed from: b */
    static final AbstractC2901p f9637b = RxJavaPlugins.m3232a(new CallableC2850b());
    @NonNull

    /* renamed from: c */
    static final AbstractC2901p f9638c = RxJavaPlugins.m3229b(new CallableC2851c());
    @NonNull

    /* renamed from: d */
    static final AbstractC2901p f9639d = TrampolineScheduler.m3134c();
    @NonNull

    /* renamed from: e */
    static final AbstractC2901p f9640e = RxJavaPlugins.m3227c(new CallableC2854f());

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Schedulers.java */
    /* renamed from: io.reactivex.e.a$a */
    /* loaded from: classes2.dex */
    public static final class C2849a {

        /* renamed from: a */
        static final AbstractC2901p f9641a = new ComputationScheduler();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Schedulers.java */
    /* renamed from: io.reactivex.e.a$d */
    /* loaded from: classes2.dex */
    public static final class C2852d {

        /* renamed from: a */
        static final AbstractC2901p f9642a = new IoScheduler();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Schedulers.java */
    /* renamed from: io.reactivex.e.a$e */
    /* loaded from: classes2.dex */
    public static final class C2853e {

        /* renamed from: a */
        static final AbstractC2901p f9643a = new NewThreadScheduler();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Schedulers.java */
    /* renamed from: io.reactivex.e.a$g */
    /* loaded from: classes2.dex */
    public static final class C2855g {

        /* renamed from: a */
        static final AbstractC2901p f9644a = new SingleScheduler();
    }

    @NonNull
    /* renamed from: a */
    public static AbstractC2901p m3218a() {
        return RxJavaPlugins.m3236a(f9637b);
    }

    @NonNull
    /* renamed from: b */
    public static AbstractC2901p m3217b() {
        return RxJavaPlugins.m3231b(f9638c);
    }

    /* compiled from: Schedulers.java */
    /* renamed from: io.reactivex.e.a$c */
    /* loaded from: classes2.dex */
    static final class CallableC2851c implements Callable<AbstractC2901p> {
        CallableC2851c() {
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: a */
        public AbstractC2901p call() throws Exception {
            return C2852d.f9642a;
        }
    }

    /* compiled from: Schedulers.java */
    /* renamed from: io.reactivex.e.a$f */
    /* loaded from: classes2.dex */
    static final class CallableC2854f implements Callable<AbstractC2901p> {
        CallableC2854f() {
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: a */
        public AbstractC2901p call() throws Exception {
            return C2853e.f9643a;
        }
    }

    /* compiled from: Schedulers.java */
    /* renamed from: io.reactivex.e.a$h */
    /* loaded from: classes2.dex */
    static final class CallableC2856h implements Callable<AbstractC2901p> {
        CallableC2856h() {
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: a */
        public AbstractC2901p call() throws Exception {
            return C2855g.f9644a;
        }
    }

    /* compiled from: Schedulers.java */
    /* renamed from: io.reactivex.e.a$b */
    /* loaded from: classes2.dex */
    static final class CallableC2850b implements Callable<AbstractC2901p> {
        CallableC2850b() {
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: a */
        public AbstractC2901p call() throws Exception {
            return C2849a.f9641a;
        }
    }
}
