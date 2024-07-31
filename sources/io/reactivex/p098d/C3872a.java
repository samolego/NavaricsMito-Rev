package io.reactivex.p098d;

import io.reactivex.AbstractC2901p;
import io.reactivex.Completable;
import io.reactivex.CompletableObserver;
import io.reactivex.Flowable;
import io.reactivex.InterfaceC2900o;
import io.reactivex.Maybe;
import io.reactivex.Observable;
import io.reactivex.Single;
import io.reactivex.annotations.NonNull;
import io.reactivex.annotations.Nullable;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.exceptions.OnErrorNotImplementedException;
import io.reactivex.exceptions.UndeliverableException;
import io.reactivex.internal.p100a.ObjectHelper;
import io.reactivex.internal.util.ExceptionHelper;
import io.reactivex.p096b.BiFunction;
import io.reactivex.p096b.Consumer;
import io.reactivex.p096b.Function;
import java.util.concurrent.Callable;

/* renamed from: io.reactivex.d.a */
/* loaded from: classes2.dex */
public final class RxJavaPlugins {
    @Nullable

    /* renamed from: a */
    static volatile Consumer<? super Throwable> f9618a;
    @Nullable

    /* renamed from: b */
    static volatile Function<? super Runnable, ? extends Runnable> f9619b;
    @Nullable

    /* renamed from: c */
    static volatile Function<? super Callable<AbstractC2901p>, ? extends AbstractC2901p> f9620c;
    @Nullable

    /* renamed from: d */
    static volatile Function<? super Callable<AbstractC2901p>, ? extends AbstractC2901p> f9621d;
    @Nullable

    /* renamed from: e */
    static volatile Function<? super Callable<AbstractC2901p>, ? extends AbstractC2901p> f9622e;
    @Nullable

    /* renamed from: f */
    static volatile Function<? super Callable<AbstractC2901p>, ? extends AbstractC2901p> f9623f;
    @Nullable

    /* renamed from: g */
    static volatile Function<? super AbstractC2901p, ? extends AbstractC2901p> f9624g;
    @Nullable

    /* renamed from: h */
    static volatile Function<? super AbstractC2901p, ? extends AbstractC2901p> f9625h;
    @Nullable

    /* renamed from: i */
    static volatile Function<? super Flowable, ? extends Flowable> f9626i;
    @Nullable

    /* renamed from: j */
    static volatile Function<? super Observable, ? extends Observable> f9627j;
    @Nullable

    /* renamed from: k */
    static volatile Function<? super Maybe, ? extends Maybe> f9628k;
    @Nullable

    /* renamed from: l */
    static volatile Function<? super Single, ? extends Single> f9629l;
    @Nullable

    /* renamed from: m */
    static volatile Function<? super Completable, ? extends Completable> f9630m;
    @Nullable

    /* renamed from: n */
    static volatile BiFunction<? super Observable, ? super InterfaceC2900o, ? extends InterfaceC2900o> f9631n;
    @Nullable

    /* renamed from: o */
    static volatile BiFunction<? super Completable, ? super CompletableObserver, ? extends CompletableObserver> f9632o;

    /* renamed from: p */
    static volatile boolean f9633p;

    @NonNull
    /* renamed from: a */
    public static AbstractC2901p m3232a(@NonNull Callable<AbstractC2901p> callable) {
        ObjectHelper.m3188a(callable, "Scheduler Callable can't be null");
        Function<? super Callable<AbstractC2901p>, ? extends AbstractC2901p> function = f9620c;
        if (function == null) {
            return m3225e(callable);
        }
        return m3241a(function, callable);
    }

    @NonNull
    /* renamed from: b */
    public static AbstractC2901p m3229b(@NonNull Callable<AbstractC2901p> callable) {
        ObjectHelper.m3188a(callable, "Scheduler Callable can't be null");
        Function<? super Callable<AbstractC2901p>, ? extends AbstractC2901p> function = f9622e;
        if (function == null) {
            return m3225e(callable);
        }
        return m3241a(function, callable);
    }

    @NonNull
    /* renamed from: c */
    public static AbstractC2901p m3227c(@NonNull Callable<AbstractC2901p> callable) {
        ObjectHelper.m3188a(callable, "Scheduler Callable can't be null");
        Function<? super Callable<AbstractC2901p>, ? extends AbstractC2901p> function = f9623f;
        if (function == null) {
            return m3225e(callable);
        }
        return m3241a(function, callable);
    }

    @NonNull
    /* renamed from: d */
    public static AbstractC2901p m3226d(@NonNull Callable<AbstractC2901p> callable) {
        ObjectHelper.m3188a(callable, "Scheduler Callable can't be null");
        Function<? super Callable<AbstractC2901p>, ? extends AbstractC2901p> function = f9621d;
        if (function == null) {
            return m3225e(callable);
        }
        return m3241a(function, callable);
    }

    @NonNull
    /* renamed from: a */
    public static AbstractC2901p m3236a(@NonNull AbstractC2901p abstractC2901p) {
        Function<? super AbstractC2901p, ? extends AbstractC2901p> function = f9624g;
        return function == null ? abstractC2901p : (AbstractC2901p) m3242a((Function<AbstractC2901p, Object>) function, abstractC2901p);
    }

    /* renamed from: a */
    public static void m3233a(@NonNull Throwable th) {
        Consumer<? super Throwable> consumer = f9618a;
        if (th == null) {
            th = new NullPointerException("onError called with null. Null values are generally not allowed in 2.x operators and sources.");
        } else if (!m3230b(th)) {
            th = new UndeliverableException(th);
        }
        if (consumer != null) {
            try {
                consumer.accept(th);
                return;
            } catch (Throwable th2) {
                th2.printStackTrace();
                m3228c(th2);
            }
        }
        th.printStackTrace();
        m3228c(th);
    }

    /* renamed from: b */
    static boolean m3230b(Throwable th) {
        return (th instanceof OnErrorNotImplementedException) || (th instanceof MissingBackpressureException) || (th instanceof IllegalStateException) || (th instanceof NullPointerException) || (th instanceof IllegalArgumentException) || (th instanceof CompositeException);
    }

    /* renamed from: c */
    static void m3228c(@NonNull Throwable th) {
        Thread currentThread = Thread.currentThread();
        currentThread.getUncaughtExceptionHandler().uncaughtException(currentThread, th);
    }

    @NonNull
    /* renamed from: b */
    public static AbstractC2901p m3231b(@NonNull AbstractC2901p abstractC2901p) {
        Function<? super AbstractC2901p, ? extends AbstractC2901p> function = f9625h;
        return function == null ? abstractC2901p : (AbstractC2901p) m3242a((Function<AbstractC2901p, Object>) function, abstractC2901p);
    }

    @NonNull
    /* renamed from: a */
    public static Runnable m3234a(@NonNull Runnable runnable) {
        ObjectHelper.m3188a(runnable, "run is null");
        Function<? super Runnable, ? extends Runnable> function = f9619b;
        return function == null ? runnable : (Runnable) m3242a((Function<Runnable, Object>) function, runnable);
    }

    /* renamed from: a */
    public static void m3243a(@Nullable Consumer<? super Throwable> consumer) {
        if (f9633p) {
            throw new IllegalStateException("Plugins can't be changed anymore");
        }
        f9618a = consumer;
    }

    @NonNull
    /* renamed from: a */
    public static <T> InterfaceC2900o<? super T> m3237a(@NonNull Observable<T> observable, @NonNull InterfaceC2900o<? super T> interfaceC2900o) {
        BiFunction<? super Observable, ? super InterfaceC2900o, ? extends InterfaceC2900o> biFunction = f9631n;
        return biFunction != null ? (InterfaceC2900o) m3244a(biFunction, observable, interfaceC2900o) : interfaceC2900o;
    }

    @NonNull
    /* renamed from: a */
    public static CompletableObserver m3245a(@NonNull Completable completable, @NonNull CompletableObserver completableObserver) {
        BiFunction<? super Completable, ? super CompletableObserver, ? extends CompletableObserver> biFunction = f9632o;
        return biFunction != null ? (CompletableObserver) m3244a(biFunction, completable, completableObserver) : completableObserver;
    }

    @NonNull
    /* renamed from: a */
    public static <T> Maybe<T> m3239a(@NonNull Maybe<T> maybe) {
        Function<? super Maybe, ? extends Maybe> function = f9628k;
        return function != null ? (Maybe) m3242a((Function<Maybe<T>, Object>) function, maybe) : maybe;
    }

    @NonNull
    /* renamed from: a */
    public static <T> Flowable<T> m3240a(@NonNull Flowable<T> flowable) {
        Function<? super Flowable, ? extends Flowable> function = f9626i;
        return function != null ? (Flowable) m3242a((Function<Flowable<T>, Object>) function, flowable) : flowable;
    }

    @NonNull
    /* renamed from: a */
    public static <T> Observable<T> m3238a(@NonNull Observable<T> observable) {
        Function<? super Observable, ? extends Observable> function = f9627j;
        return function != null ? (Observable) m3242a((Function<Observable<T>, Object>) function, observable) : observable;
    }

    @NonNull
    /* renamed from: a */
    public static <T> Single<T> m3235a(@NonNull Single<T> single) {
        Function<? super Single, ? extends Single> function = f9629l;
        return function != null ? (Single) m3242a((Function<Single<T>, Object>) function, single) : single;
    }

    @NonNull
    /* renamed from: a */
    public static Completable m3246a(@NonNull Completable completable) {
        Function<? super Completable, ? extends Completable> function = f9630m;
        return function != null ? (Completable) m3242a((Function<Completable, Object>) function, completable) : completable;
    }

    @NonNull
    /* renamed from: a */
    static <T, R> R m3242a(@NonNull Function<T, R> function, @NonNull T t) {
        try {
            return function.apply(t);
        } catch (Throwable th) {
            throw ExceptionHelper.m3131a(th);
        }
    }

    @NonNull
    /* renamed from: a */
    static <T, U, R> R m3244a(@NonNull BiFunction<T, U, R> biFunction, @NonNull T t, @NonNull U u) {
        try {
            return biFunction.mo3248a(t, u);
        } catch (Throwable th) {
            throw ExceptionHelper.m3131a(th);
        }
    }

    @NonNull
    /* renamed from: e */
    static AbstractC2901p m3225e(@NonNull Callable<AbstractC2901p> callable) {
        try {
            return (AbstractC2901p) ObjectHelper.m3188a(callable.call(), "Scheduler Callable result can't be null");
        } catch (Throwable th) {
            throw ExceptionHelper.m3131a(th);
        }
    }

    @NonNull
    /* renamed from: a */
    static AbstractC2901p m3241a(@NonNull Function<? super Callable<AbstractC2901p>, ? extends AbstractC2901p> function, Callable<AbstractC2901p> callable) {
        return (AbstractC2901p) ObjectHelper.m3188a(m3242a((Function<Callable<AbstractC2901p>, Object>) function, callable), "Scheduler Callable result can't be null");
    }
}
