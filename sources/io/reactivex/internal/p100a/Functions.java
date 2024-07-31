package io.reactivex.internal.p100a;

import io.reactivex.exceptions.OnErrorNotImplementedException;
import io.reactivex.p096b.BiFunction;
import io.reactivex.p096b.Consumer;
import io.reactivex.p096b.Function;
import io.reactivex.p096b.InterfaceC2848a;
import io.reactivex.p096b.LongConsumer;
import io.reactivex.p096b.Predicate;
import io.reactivex.p098d.RxJavaPlugins;
import java.util.Comparator;
import java.util.concurrent.Callable;
import org.p109a.Subscription;

/* renamed from: io.reactivex.internal.a.a */
/* loaded from: classes2.dex */
public final class Functions {

    /* renamed from: a */
    static final Function<Object, Object> f9648a = new C2867h();

    /* renamed from: b */
    public static final Runnable f9649b = new RunnableC2864e();

    /* renamed from: c */
    public static final InterfaceC2848a f9650c = new C2861b();

    /* renamed from: d */
    static final Consumer<Object> f9651d = new C2862c();

    /* renamed from: e */
    public static final Consumer<Throwable> f9652e = new C2865f();

    /* renamed from: f */
    public static final Consumer<Throwable> f9653f = new C2872m();

    /* renamed from: g */
    public static final LongConsumer f9654g = new C2863d();

    /* renamed from: h */
    static final Predicate<Object> f9655h = new C2873n();

    /* renamed from: i */
    static final Predicate<Object> f9656i = new C2866g();

    /* renamed from: j */
    static final Callable<Object> f9657j = new CallableC2871l();

    /* renamed from: k */
    static final Comparator<Object> f9658k = new C2870k();

    /* renamed from: l */
    public static final Consumer<Subscription> f9659l = new C2869j();

    /* renamed from: a */
    public static <T1, T2, R> Function<Object[], R> m3200a(BiFunction<? super T1, ? super T2, ? extends R> biFunction) {
        ObjectHelper.m3188a(biFunction, "f is null");
        return new C2860a(biFunction);
    }

    /* renamed from: a */
    public static <T> Function<T, T> m3201a() {
        return (Function<T, T>) f9648a;
    }

    /* renamed from: b */
    public static <T> Consumer<T> m3198b() {
        return (Consumer<T>) f9651d;
    }

    /* compiled from: Functions.java */
    /* renamed from: io.reactivex.internal.a.a$i */
    /* loaded from: classes2.dex */
    static final class CallableC2868i<T, U> implements Function<T, U>, Callable<U> {

        /* renamed from: a */
        final U f9661a;

        CallableC2868i(U u) {
            this.f9661a = u;
        }

        @Override // java.util.concurrent.Callable
        public U call() throws Exception {
            return this.f9661a;
        }

        @Override // io.reactivex.p096b.Function
        public U apply(T t) throws Exception {
            return this.f9661a;
        }
    }

    /* renamed from: a */
    public static <T> Callable<T> m3199a(T t) {
        return new CallableC2868i(t);
    }

    /* renamed from: b */
    public static <T, U> Function<T, U> m3197b(U u) {
        return new CallableC2868i(u);
    }

    /* compiled from: Functions.java */
    /* renamed from: io.reactivex.internal.a.a$a */
    /* loaded from: classes2.dex */
    static final class C2860a<T1, T2, R> implements Function<Object[], R> {

        /* renamed from: a */
        final BiFunction<? super T1, ? super T2, ? extends R> f9660a;

        C2860a(BiFunction<? super T1, ? super T2, ? extends R> biFunction) {
            this.f9660a = biFunction;
        }

        @Override // io.reactivex.p096b.Function
        /* renamed from: a */
        public R apply(Object[] objArr) throws Exception {
            if (objArr.length != 2) {
                throw new IllegalArgumentException("Array of size 2 expected but got " + objArr.length);
            }
            return this.f9660a.mo3248a(objArr[0], objArr[1]);
        }
    }

    /* compiled from: Functions.java */
    /* renamed from: io.reactivex.internal.a.a$h */
    /* loaded from: classes2.dex */
    static final class C2867h implements Function<Object, Object> {
        @Override // io.reactivex.p096b.Function
        public Object apply(Object obj) {
            return obj;
        }

        public String toString() {
            return "IdentityFunction";
        }

        C2867h() {
        }
    }

    /* compiled from: Functions.java */
    /* renamed from: io.reactivex.internal.a.a$e */
    /* loaded from: classes2.dex */
    static final class RunnableC2864e implements Runnable {
        @Override // java.lang.Runnable
        public void run() {
        }

        public String toString() {
            return "EmptyRunnable";
        }

        RunnableC2864e() {
        }
    }

    /* compiled from: Functions.java */
    /* renamed from: io.reactivex.internal.a.a$b */
    /* loaded from: classes2.dex */
    static final class C2861b implements InterfaceC2848a {
        @Override // io.reactivex.p096b.InterfaceC2848a
        public void run() {
        }

        public String toString() {
            return "EmptyAction";
        }

        C2861b() {
        }
    }

    /* compiled from: Functions.java */
    /* renamed from: io.reactivex.internal.a.a$c */
    /* loaded from: classes2.dex */
    static final class C2862c implements Consumer<Object> {
        @Override // io.reactivex.p096b.Consumer
        public void accept(Object obj) {
        }

        public String toString() {
            return "EmptyConsumer";
        }

        C2862c() {
        }
    }

    /* compiled from: Functions.java */
    /* renamed from: io.reactivex.internal.a.a$f */
    /* loaded from: classes2.dex */
    static final class C2865f implements Consumer<Throwable> {
        C2865f() {
        }

        @Override // io.reactivex.p096b.Consumer
        /* renamed from: a */
        public void accept(Throwable th) {
            RxJavaPlugins.m3233a(th);
        }
    }

    /* compiled from: Functions.java */
    /* renamed from: io.reactivex.internal.a.a$m */
    /* loaded from: classes2.dex */
    static final class C2872m implements Consumer<Throwable> {
        C2872m() {
        }

        @Override // io.reactivex.p096b.Consumer
        /* renamed from: a */
        public void accept(Throwable th) {
            RxJavaPlugins.m3233a(new OnErrorNotImplementedException(th));
        }
    }

    /* compiled from: Functions.java */
    /* renamed from: io.reactivex.internal.a.a$d */
    /* loaded from: classes2.dex */
    static final class C2863d implements LongConsumer {
        C2863d() {
        }
    }

    /* compiled from: Functions.java */
    /* renamed from: io.reactivex.internal.a.a$n */
    /* loaded from: classes2.dex */
    static final class C2873n implements Predicate<Object> {
        C2873n() {
        }
    }

    /* compiled from: Functions.java */
    /* renamed from: io.reactivex.internal.a.a$g */
    /* loaded from: classes2.dex */
    static final class C2866g implements Predicate<Object> {
        C2866g() {
        }
    }

    /* compiled from: Functions.java */
    /* renamed from: io.reactivex.internal.a.a$l */
    /* loaded from: classes2.dex */
    static final class CallableC2871l implements Callable<Object> {
        @Override // java.util.concurrent.Callable
        public Object call() {
            return null;
        }

        CallableC2871l() {
        }
    }

    /* compiled from: Functions.java */
    /* renamed from: io.reactivex.internal.a.a$k */
    /* loaded from: classes2.dex */
    static final class C2870k implements Comparator<Object> {
        C2870k() {
        }

        @Override // java.util.Comparator
        public int compare(Object obj, Object obj2) {
            return ((Comparable) obj).compareTo(obj2);
        }
    }

    /* compiled from: Functions.java */
    /* renamed from: io.reactivex.internal.a.a$j */
    /* loaded from: classes2.dex */
    static final class C2869j implements Consumer<Subscription> {
        C2869j() {
        }

        @Override // io.reactivex.p096b.Consumer
        /* renamed from: a */
        public void accept(Subscription subscription) throws Exception {
            subscription.m2195a(Long.MAX_VALUE);
        }
    }
}
