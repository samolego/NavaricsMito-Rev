package io.reactivex;

import io.reactivex.annotations.BackpressureSupport;
import io.reactivex.annotations.CheckReturnValue;
import io.reactivex.annotations.SchedulerSupport;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.observers.LambdaObserver;
import io.reactivex.internal.operators.observable.ObservableBuffer;
import io.reactivex.internal.operators.observable.ObservableCombineLatest;
import io.reactivex.internal.operators.observable.ObservableConcatMap;
import io.reactivex.internal.operators.observable.ObservableCreate;
import io.reactivex.internal.operators.observable.ObservableDoOnEach;
import io.reactivex.internal.operators.observable.ObservableEmpty;
import io.reactivex.internal.operators.observable.ObservableError;
import io.reactivex.internal.operators.observable.ObservableFlatMap;
import io.reactivex.internal.operators.observable.ObservableFromArray;
import io.reactivex.internal.operators.observable.ObservableFromIterable;
import io.reactivex.internal.operators.observable.ObservableFromUnsafeSource;
import io.reactivex.internal.operators.observable.ObservableIgnoreElementsCompletable;
import io.reactivex.internal.operators.observable.ObservableInterval;
import io.reactivex.internal.operators.observable.ObservableJust;
import io.reactivex.internal.operators.observable.ObservableMap;
import io.reactivex.internal.operators.observable.ObservableObserveOn;
import io.reactivex.internal.operators.observable.ObservableOnErrorNext;
import io.reactivex.internal.operators.observable.ObservableSampleTimed;
import io.reactivex.internal.operators.observable.ObservableScalarXMap;
import io.reactivex.internal.operators.observable.ObservableSingleMaybe;
import io.reactivex.internal.operators.observable.ObservableSingleSingle;
import io.reactivex.internal.operators.observable.ObservableSubscribeOn;
import io.reactivex.internal.operators.observable.ObservableTake;
import io.reactivex.internal.operators.observable.ObservableThrottleFirstTimed;
import io.reactivex.internal.operators.observable.ObservableTimer;
import io.reactivex.internal.operators.p102a.FlowableFromObservable;
import io.reactivex.internal.operators.p102a.FlowableOnBackpressureError;
import io.reactivex.internal.p100a.Functions;
import io.reactivex.internal.p100a.ObjectHelper;
import io.reactivex.internal.p101b.ScalarCallable;
import io.reactivex.internal.util.ArrayListSupplier;
import io.reactivex.internal.util.ErrorMode;
import io.reactivex.p096b.BiFunction;
import io.reactivex.p096b.Consumer;
import io.reactivex.p096b.Function;
import io.reactivex.p096b.InterfaceC2848a;
import io.reactivex.p098d.RxJavaPlugins;
import io.reactivex.p099e.Schedulers;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

/* renamed from: io.reactivex.j */
/* loaded from: classes2.dex */
public abstract class Observable<T> implements ObservableSource<T> {
    /* renamed from: a */
    protected abstract void mo158a(InterfaceC2900o<? super T> interfaceC2900o);

    /* renamed from: a */
    public static int m3118a() {
        return Flowable.m3206a();
    }

    @SchedulerSupport
    @CheckReturnValue
    /* renamed from: a */
    public static <T, R> Observable<R> m3101a(Function<? super Object[], ? extends R> function, int i, ObservableSource<? extends T>... observableSourceArr) {
        return m3084a(observableSourceArr, function, i);
    }

    @SchedulerSupport
    @CheckReturnValue
    /* renamed from: a */
    public static <T, R> Observable<R> m3084a(ObservableSource<? extends T>[] observableSourceArr, Function<? super Object[], ? extends R> function, int i) {
        ObjectHelper.m3188a(observableSourceArr, "sources is null");
        if (observableSourceArr.length == 0) {
            return m3082b();
        }
        ObjectHelper.m3188a(function, "combiner is null");
        ObjectHelper.m3191a(i, "bufferSize");
        return RxJavaPlugins.m3238a(new ObservableCombineLatest(observableSourceArr, null, function, i << 1, false));
    }

    @SchedulerSupport
    @CheckReturnValue
    /* renamed from: a */
    public static <T1, T2, R> Observable<R> m3093a(ObservableSource<? extends T1> observableSource, ObservableSource<? extends T2> observableSource2, BiFunction<? super T1, ? super T2, ? extends R> biFunction) {
        ObjectHelper.m3188a(observableSource, "source1 is null");
        ObjectHelper.m3188a(observableSource2, "source2 is null");
        return m3101a(Functions.m3200a((BiFunction) biFunction), m3118a(), observableSource, observableSource2);
    }

    @SchedulerSupport
    @CheckReturnValue
    /* renamed from: a */
    public static <T> Observable<T> m3096a(ObservableSource<? extends ObservableSource<? extends T>> observableSource) {
        return m3095a(observableSource, m3118a());
    }

    @SchedulerSupport
    @CheckReturnValue
    /* renamed from: a */
    public static <T> Observable<T> m3095a(ObservableSource<? extends ObservableSource<? extends T>> observableSource, int i) {
        ObjectHelper.m3188a(observableSource, "sources is null");
        ObjectHelper.m3191a(i, "prefetch");
        return RxJavaPlugins.m3238a(new ObservableConcatMap(observableSource, Functions.m3201a(), i, ErrorMode.IMMEDIATE));
    }

    @SchedulerSupport
    @CheckReturnValue
    /* renamed from: a */
    public static <T> Observable<T> m3094a(ObservableSource<? extends T> observableSource, ObservableSource<? extends T> observableSource2) {
        ObjectHelper.m3188a(observableSource, "source1 is null");
        ObjectHelper.m3188a(observableSource2, "source2 is null");
        return m3085a(observableSource, observableSource2);
    }

    @SchedulerSupport
    @CheckReturnValue
    /* renamed from: a */
    public static <T> Observable<T> m3085a(ObservableSource<? extends T>... observableSourceArr) {
        if (observableSourceArr.length == 0) {
            return m3082b();
        }
        if (observableSourceArr.length == 1) {
            return m3077b(observableSourceArr[0]);
        }
        return RxJavaPlugins.m3238a(new ObservableConcatMap(m3083a((Object[]) observableSourceArr), Functions.m3201a(), m3118a(), ErrorMode.BOUNDARY));
    }

    @SchedulerSupport
    @CheckReturnValue
    /* renamed from: a */
    public static <T> Observable<T> m3097a(ObservableOnSubscribe<T> observableOnSubscribe) {
        ObjectHelper.m3188a(observableOnSubscribe, "source is null");
        return RxJavaPlugins.m3238a(new ObservableCreate(observableOnSubscribe));
    }

    @SchedulerSupport
    @CheckReturnValue
    /* renamed from: b */
    public static <T> Observable<T> m3082b() {
        return RxJavaPlugins.m3238a(ObservableEmpty.f9743a);
    }

    @SchedulerSupport
    @CheckReturnValue
    /* renamed from: a */
    public static <T> Observable<T> m3086a(Callable<? extends Throwable> callable) {
        ObjectHelper.m3188a(callable, "errorSupplier is null");
        return RxJavaPlugins.m3238a(new ObservableError(callable));
    }

    @SchedulerSupport
    @CheckReturnValue
    /* renamed from: a */
    public static <T> Observable<T> m3087a(Throwable th) {
        ObjectHelper.m3188a(th, "e is null");
        return m3086a((Callable<? extends Throwable>) Functions.m3199a(th));
    }

    @SchedulerSupport
    @CheckReturnValue
    /* renamed from: a */
    public static <T> Observable<T> m3083a(T... tArr) {
        ObjectHelper.m3188a(tArr, "items is null");
        if (tArr.length == 0) {
            return m3082b();
        }
        if (tArr.length == 1) {
            return m3088a(tArr[0]);
        }
        return RxJavaPlugins.m3238a(new ObservableFromArray(tArr));
    }

    @SchedulerSupport
    @CheckReturnValue
    /* renamed from: a */
    public static <T> Observable<T> m3089a(Iterable<? extends T> iterable) {
        ObjectHelper.m3188a(iterable, "source is null");
        return RxJavaPlugins.m3238a(new ObservableFromIterable(iterable));
    }

    @SchedulerSupport
    @CheckReturnValue
    /* renamed from: a */
    public static Observable<Long> m3113a(long j, long j2, TimeUnit timeUnit) {
        return m3112a(j, j2, timeUnit, Schedulers.m3218a());
    }

    @SchedulerSupport
    @CheckReturnValue
    /* renamed from: a */
    public static Observable<Long> m3112a(long j, long j2, TimeUnit timeUnit, AbstractC2901p abstractC2901p) {
        ObjectHelper.m3188a(timeUnit, "unit is null");
        ObjectHelper.m3188a(abstractC2901p, "scheduler is null");
        return RxJavaPlugins.m3238a(new ObservableInterval(Math.max(0L, j), Math.max(0L, j2), timeUnit, abstractC2901p));
    }

    @SchedulerSupport
    @CheckReturnValue
    /* renamed from: a */
    public static Observable<Long> m3111a(long j, TimeUnit timeUnit) {
        return m3112a(j, j, timeUnit, Schedulers.m3218a());
    }

    @SchedulerSupport
    @CheckReturnValue
    /* renamed from: a */
    public static <T> Observable<T> m3088a(T t) {
        ObjectHelper.m3188a((Object) t, "The item is null");
        return RxJavaPlugins.m3238a((Observable) new ObservableJust(t));
    }

    @SchedulerSupport
    @CheckReturnValue
    /* renamed from: b */
    public static <T> Observable<T> m3076b(ObservableSource<? extends T> observableSource, ObservableSource<? extends T> observableSource2) {
        ObjectHelper.m3188a(observableSource, "source1 is null");
        ObjectHelper.m3188a(observableSource2, "source2 is null");
        return m3083a((Object[]) new ObservableSource[]{observableSource, observableSource2}).m3099a(Functions.m3201a(), false, 2);
    }

    @SchedulerSupport
    @CheckReturnValue
    /* renamed from: b */
    public static Observable<Long> m3081b(long j, TimeUnit timeUnit) {
        return m3110a(j, timeUnit, Schedulers.m3218a());
    }

    @SchedulerSupport
    @CheckReturnValue
    /* renamed from: a */
    public static Observable<Long> m3110a(long j, TimeUnit timeUnit, AbstractC2901p abstractC2901p) {
        ObjectHelper.m3188a(timeUnit, "unit is null");
        ObjectHelper.m3188a(abstractC2901p, "scheduler is null");
        return RxJavaPlugins.m3238a(new ObservableTimer(Math.max(j, 0L), timeUnit, abstractC2901p));
    }

    @SchedulerSupport
    @CheckReturnValue
    /* renamed from: b */
    public static <T> Observable<T> m3077b(ObservableSource<T> observableSource) {
        ObjectHelper.m3188a(observableSource, "source is null");
        if (observableSource instanceof Observable) {
            return RxJavaPlugins.m3238a((Observable) observableSource);
        }
        return RxJavaPlugins.m3238a(new ObservableFromUnsafeSource(observableSource));
    }

    @SchedulerSupport
    @CheckReturnValue
    /* renamed from: a */
    public final Observable<List<T>> m3117a(int i) {
        return m3116a(i, i);
    }

    @SchedulerSupport
    @CheckReturnValue
    /* renamed from: a */
    public final Observable<List<T>> m3116a(int i, int i2) {
        return (Observable<List<T>>) m3115a(i, i2, ArrayListSupplier.asCallable());
    }

    @SchedulerSupport
    @CheckReturnValue
    /* renamed from: a */
    public final <U extends Collection<? super T>> Observable<U> m3115a(int i, int i2, Callable<U> callable) {
        ObjectHelper.m3191a(i, "count");
        ObjectHelper.m3191a(i2, "skip");
        ObjectHelper.m3188a(callable, "bufferSupplier is null");
        return RxJavaPlugins.m3238a(new ObservableBuffer(this, i, i2, callable));
    }

    @SchedulerSupport
    @CheckReturnValue
    /* renamed from: a */
    public final <R> Observable<R> m3092a(ObservableTransformer<? super T, ? extends R> observableTransformer) {
        return m3077b(((ObservableTransformer) ObjectHelper.m3188a(observableTransformer, "composer is null")).apply(this));
    }

    @SchedulerSupport
    @CheckReturnValue
    /* renamed from: a */
    public final <R> Observable<R> m3103a(Function<? super T, ? extends ObservableSource<? extends R>> function) {
        return m3102a(function, 2);
    }

    @SchedulerSupport
    @CheckReturnValue
    /* renamed from: a */
    public final <R> Observable<R> m3102a(Function<? super T, ? extends ObservableSource<? extends R>> function, int i) {
        ObjectHelper.m3188a(function, "mapper is null");
        ObjectHelper.m3191a(i, "prefetch");
        if (this instanceof ScalarCallable) {
            Object call = ((ScalarCallable) this).call();
            if (call == null) {
                return m3082b();
            }
            return ObservableScalarXMap.m3177a(call, function);
        }
        return RxJavaPlugins.m3238a(new ObservableConcatMap(this, function, i, ErrorMode.IMMEDIATE));
    }

    @SchedulerSupport
    @CheckReturnValue
    /* renamed from: a */
    private Observable<T> m3105a(Consumer<? super T> consumer, Consumer<? super Throwable> consumer2, InterfaceC2848a interfaceC2848a, InterfaceC2848a interfaceC2848a2) {
        ObjectHelper.m3188a(consumer, "onNext is null");
        ObjectHelper.m3188a(consumer2, "onError is null");
        ObjectHelper.m3188a(interfaceC2848a, "onComplete is null");
        ObjectHelper.m3188a(interfaceC2848a2, "onAfterTerminate is null");
        return RxJavaPlugins.m3238a(new ObservableDoOnEach(this, consumer, consumer2, interfaceC2848a, interfaceC2848a2));
    }

    @SchedulerSupport
    @CheckReturnValue
    /* renamed from: a */
    public final Observable<T> m3108a(Consumer<? super Throwable> consumer) {
        return m3105a(Functions.m3198b(), consumer, Functions.f9650c, Functions.f9650c);
    }

    @SchedulerSupport
    @CheckReturnValue
    /* renamed from: b */
    public final Observable<T> m3079b(Consumer<? super T> consumer) {
        return m3105a(consumer, Functions.m3198b(), Functions.f9650c, Functions.f9650c);
    }

    @SchedulerSupport
    @CheckReturnValue
    /* renamed from: b */
    public final <R> Observable<R> m3078b(Function<? super T, ? extends ObservableSource<? extends R>> function) {
        return m3100a((Function) function, false);
    }

    @SchedulerSupport
    @CheckReturnValue
    /* renamed from: a */
    public final <R> Observable<R> m3100a(Function<? super T, ? extends ObservableSource<? extends R>> function, boolean z) {
        return m3099a(function, z, Integer.MAX_VALUE);
    }

    @SchedulerSupport
    @CheckReturnValue
    /* renamed from: a */
    public final <R> Observable<R> m3099a(Function<? super T, ? extends ObservableSource<? extends R>> function, boolean z, int i) {
        return m3098a(function, z, i, m3118a());
    }

    @SchedulerSupport
    @CheckReturnValue
    /* renamed from: a */
    public final <R> Observable<R> m3098a(Function<? super T, ? extends ObservableSource<? extends R>> function, boolean z, int i, int i2) {
        ObjectHelper.m3188a(function, "mapper is null");
        ObjectHelper.m3191a(i, "maxConcurrency");
        ObjectHelper.m3191a(i2, "bufferSize");
        if (this instanceof ScalarCallable) {
            Object call = ((ScalarCallable) this).call();
            if (call == null) {
                return m3082b();
            }
            return ObservableScalarXMap.m3177a(call, function);
        }
        return RxJavaPlugins.m3238a(new ObservableFlatMap(this, function, z, i, i2));
    }

    @SchedulerSupport
    @CheckReturnValue
    /* renamed from: c */
    public final Completable m3074c() {
        return RxJavaPlugins.m3246a(new ObservableIgnoreElementsCompletable(this));
    }

    @SchedulerSupport
    @CheckReturnValue
    /* renamed from: c */
    public final <R> Observable<R> m3070c(Function<? super T, ? extends R> function) {
        ObjectHelper.m3188a(function, "mapper is null");
        return RxJavaPlugins.m3238a(new ObservableMap(this, function));
    }

    @SchedulerSupport
    @CheckReturnValue
    /* renamed from: a */
    public final Observable<T> m3091a(AbstractC2901p abstractC2901p) {
        return m3090a(abstractC2901p, false, m3118a());
    }

    @SchedulerSupport
    @CheckReturnValue
    /* renamed from: a */
    public final Observable<T> m3090a(AbstractC2901p abstractC2901p, boolean z, int i) {
        ObjectHelper.m3188a(abstractC2901p, "scheduler is null");
        ObjectHelper.m3191a(i, "bufferSize");
        return RxJavaPlugins.m3238a(new ObservableObserveOn(this, abstractC2901p, z, i));
    }

    @SchedulerSupport
    @CheckReturnValue
    /* renamed from: d */
    public final Observable<T> m3066d(Function<? super Throwable, ? extends ObservableSource<? extends T>> function) {
        ObjectHelper.m3188a(function, "resumeFunction is null");
        return RxJavaPlugins.m3238a(new ObservableOnErrorNext(this, function, false));
    }

    @SchedulerSupport
    @CheckReturnValue
    /* renamed from: c */
    public final Observable<T> m3069c(ObservableSource<? extends T> observableSource) {
        ObjectHelper.m3188a(observableSource, "next is null");
        return m3066d(Functions.m3197b(observableSource));
    }

    @SchedulerSupport
    @CheckReturnValue
    /* renamed from: c */
    public final Observable<T> m3073c(long j, TimeUnit timeUnit) {
        return m3080b(j, timeUnit, Schedulers.m3218a());
    }

    @SchedulerSupport
    @CheckReturnValue
    /* renamed from: b */
    public final Observable<T> m3080b(long j, TimeUnit timeUnit, AbstractC2901p abstractC2901p) {
        ObjectHelper.m3188a(timeUnit, "unit is null");
        ObjectHelper.m3188a(abstractC2901p, "scheduler is null");
        return RxJavaPlugins.m3238a(new ObservableSampleTimed(this, j, timeUnit, abstractC2901p, false));
    }

    @SchedulerSupport
    @CheckReturnValue
    /* renamed from: d */
    public final Maybe<T> m3068d() {
        return RxJavaPlugins.m3239a(new ObservableSingleMaybe(this));
    }

    @SchedulerSupport
    @CheckReturnValue
    /* renamed from: e */
    public final Single<T> m3065e() {
        return RxJavaPlugins.m3235a(new ObservableSingleSingle(this, null));
    }

    @SchedulerSupport
    @CheckReturnValue
    /* renamed from: c */
    public final Disposable m3071c(Consumer<? super T> consumer) {
        return m3104a(consumer, Functions.f9653f, Functions.f9650c, Functions.m3198b());
    }

    @SchedulerSupport
    @CheckReturnValue
    /* renamed from: a */
    public final Disposable m3107a(Consumer<? super T> consumer, Consumer<? super Throwable> consumer2) {
        return m3104a(consumer, consumer2, Functions.f9650c, Functions.m3198b());
    }

    @SchedulerSupport
    @CheckReturnValue
    /* renamed from: a */
    public final Disposable m3106a(Consumer<? super T> consumer, Consumer<? super Throwable> consumer2, InterfaceC2848a interfaceC2848a) {
        return m3104a(consumer, consumer2, interfaceC2848a, Functions.m3198b());
    }

    @SchedulerSupport
    @CheckReturnValue
    /* renamed from: a */
    public final Disposable m3104a(Consumer<? super T> consumer, Consumer<? super Throwable> consumer2, InterfaceC2848a interfaceC2848a, Consumer<? super Disposable> consumer3) {
        ObjectHelper.m3188a(consumer, "onNext is null");
        ObjectHelper.m3188a(consumer2, "onError is null");
        ObjectHelper.m3188a(interfaceC2848a, "onComplete is null");
        ObjectHelper.m3188a(consumer3, "onSubscribe is null");
        LambdaObserver lambdaObserver = new LambdaObserver(consumer, consumer2, interfaceC2848a, consumer3);
        subscribe(lambdaObserver);
        return lambdaObserver;
    }

    @Override // io.reactivex.ObservableSource
    @SchedulerSupport
    public final void subscribe(InterfaceC2900o<? super T> interfaceC2900o) {
        ObjectHelper.m3188a(interfaceC2900o, "observer is null");
        try {
            InterfaceC2900o<? super T> m3237a = RxJavaPlugins.m3237a(this, interfaceC2900o);
            ObjectHelper.m3188a(m3237a, "The RxJavaPlugins.onSubscribe hook returned a null Observer. Please change the handler provided to RxJavaPlugins.setOnObservableSubscribe for invalid null returns. Further reading: https://github.com/ReactiveX/RxJava/wiki/Plugins");
            mo158a((InterfaceC2900o) m3237a);
        } catch (NullPointerException e) {
            throw e;
        } catch (Throwable th) {
            Exceptions.m3207b(th);
            RxJavaPlugins.m3233a(th);
            NullPointerException nullPointerException = new NullPointerException("Actually not, but can't throw other exceptions due to RS");
            nullPointerException.initCause(th);
            throw nullPointerException;
        }
    }

    @SchedulerSupport
    @CheckReturnValue
    /* renamed from: b */
    public final Observable<T> m3075b(AbstractC2901p abstractC2901p) {
        ObjectHelper.m3188a(abstractC2901p, "scheduler is null");
        return RxJavaPlugins.m3238a(new ObservableSubscribeOn(this, abstractC2901p));
    }

    @SchedulerSupport
    @CheckReturnValue
    /* renamed from: a */
    public final Observable<T> m3114a(long j) {
        if (j < 0) {
            throw new IllegalArgumentException("count >= 0 required but it was " + j);
        }
        return RxJavaPlugins.m3238a(new ObservableTake(this, j));
    }

    @SchedulerSupport
    @CheckReturnValue
    /* renamed from: d */
    public final Observable<T> m3067d(long j, TimeUnit timeUnit) {
        return m3072c(j, timeUnit, Schedulers.m3218a());
    }

    @SchedulerSupport
    @CheckReturnValue
    /* renamed from: c */
    public final Observable<T> m3072c(long j, TimeUnit timeUnit, AbstractC2901p abstractC2901p) {
        ObjectHelper.m3188a(timeUnit, "unit is null");
        ObjectHelper.m3188a(abstractC2901p, "scheduler is null");
        return RxJavaPlugins.m3238a(new ObservableThrottleFirstTimed(this, j, timeUnit, abstractC2901p));
    }

    @SchedulerSupport
    @CheckReturnValue
    /* renamed from: e */
    public final Observable<T> m3064e(long j, TimeUnit timeUnit) {
        return m3073c(j, timeUnit);
    }

    @SchedulerSupport
    @BackpressureSupport
    @CheckReturnValue
    /* renamed from: a */
    public final Flowable<T> m3109a(BackpressureStrategy backpressureStrategy) {
        FlowableFromObservable flowableFromObservable = new FlowableFromObservable(this);
        switch (backpressureStrategy) {
            case DROP:
                return flowableFromObservable.m3203c();
            case LATEST:
                return flowableFromObservable.m3202d();
            case MISSING:
                return flowableFromObservable;
            case ERROR:
                return RxJavaPlugins.m3240a(new FlowableOnBackpressureError(flowableFromObservable));
            default:
                return flowableFromObservable.m3204b();
        }
    }
}
