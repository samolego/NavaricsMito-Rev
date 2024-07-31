package io.reactivex.internal.operators.observable;

import io.reactivex.InterfaceC2900o;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.annotations.Nullable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.p100a.ObjectHelper;
import io.reactivex.internal.p101b.QueueDisposable;
import io.reactivex.p096b.Function;
import io.reactivex.p098d.RxJavaPlugins;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes2.dex */
public final class ObservableScalarXMap {
    /* renamed from: a */
    public static <T, R> boolean m3178a(ObservableSource<T> observableSource, InterfaceC2900o<? super R> interfaceC2900o, Function<? super T, ? extends ObservableSource<? extends R>> function) {
        if (observableSource instanceof Callable) {
            try {
                Object obj = (Object) ((Callable) observableSource).call();
                if (obj == 0) {
                    EmptyDisposable.complete(interfaceC2900o);
                    return true;
                }
                try {
                    ObservableSource observableSource2 = (ObservableSource) ObjectHelper.m3188a(function.apply(obj), "The mapper returned a null ObservableSource");
                    if (observableSource2 instanceof Callable) {
                        try {
                            Object call = ((Callable) observableSource2).call();
                            if (call == null) {
                                EmptyDisposable.complete(interfaceC2900o);
                                return true;
                            }
                            ScalarDisposable scalarDisposable = new ScalarDisposable(interfaceC2900o, call);
                            interfaceC2900o.onSubscribe(scalarDisposable);
                            scalarDisposable.run();
                        } catch (Throwable th) {
                            Exceptions.m3207b(th);
                            EmptyDisposable.error(th, interfaceC2900o);
                            return true;
                        }
                    } else {
                        observableSource2.subscribe(interfaceC2900o);
                    }
                    return true;
                } catch (Throwable th2) {
                    Exceptions.m3207b(th2);
                    EmptyDisposable.error(th2, interfaceC2900o);
                    return true;
                }
            } catch (Throwable th3) {
                Exceptions.m3207b(th3);
                EmptyDisposable.error(th3, interfaceC2900o);
                return true;
            }
        }
        return false;
    }

    /* renamed from: a */
    public static <T, U> Observable<U> m3177a(T t, Function<? super T, ? extends ObservableSource<? extends U>> function) {
        return RxJavaPlugins.m3238a(new C2876a(t, function));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: io.reactivex.internal.operators.observable.ObservableScalarXMap$a */
    /* loaded from: classes2.dex */
    public static final class C2876a<T, R> extends Observable<R> {

        /* renamed from: a */
        final T f9720a;

        /* renamed from: b */
        final Function<? super T, ? extends ObservableSource<? extends R>> f9721b;

        C2876a(T t, Function<? super T, ? extends ObservableSource<? extends R>> function) {
            this.f9720a = t;
            this.f9721b = function;
        }

        @Override // io.reactivex.Observable
        /* renamed from: a */
        public void mo158a(InterfaceC2900o<? super R> interfaceC2900o) {
            try {
                ObservableSource observableSource = (ObservableSource) ObjectHelper.m3188a(this.f9721b.apply((T) this.f9720a), "The mapper returned a null ObservableSource");
                if (observableSource instanceof Callable) {
                    try {
                        Object call = ((Callable) observableSource).call();
                        if (call == null) {
                            EmptyDisposable.complete(interfaceC2900o);
                            return;
                        }
                        ScalarDisposable scalarDisposable = new ScalarDisposable(interfaceC2900o, call);
                        interfaceC2900o.onSubscribe(scalarDisposable);
                        scalarDisposable.run();
                        return;
                    } catch (Throwable th) {
                        Exceptions.m3207b(th);
                        EmptyDisposable.error(th, interfaceC2900o);
                        return;
                    }
                }
                observableSource.subscribe(interfaceC2900o);
            } catch (Throwable th2) {
                EmptyDisposable.error(th2, interfaceC2900o);
            }
        }
    }

    /* loaded from: classes2.dex */
    public static final class ScalarDisposable<T> extends AtomicInteger implements QueueDisposable<T>, Runnable {
        static final int FUSED = 1;
        static final int ON_COMPLETE = 3;
        static final int ON_NEXT = 2;
        static final int START = 0;
        private static final long serialVersionUID = 3880992722410194083L;
        final InterfaceC2900o<? super T> observer;
        final T value;

        public ScalarDisposable(InterfaceC2900o<? super T> interfaceC2900o, T t) {
            this.observer = interfaceC2900o;
            this.value = t;
        }

        @Override // io.reactivex.internal.p101b.SimpleQueue
        public boolean offer(T t) {
            throw new UnsupportedOperationException("Should not be called!");
        }

        public boolean offer(T t, T t2) {
            throw new UnsupportedOperationException("Should not be called!");
        }

        @Override // io.reactivex.internal.p101b.SimpleQueue
        @Nullable
        public T poll() throws Exception {
            if (get() == 1) {
                lazySet(3);
                return this.value;
            }
            return null;
        }

        @Override // io.reactivex.internal.p101b.SimpleQueue
        public boolean isEmpty() {
            return get() != 1;
        }

        @Override // io.reactivex.internal.p101b.SimpleQueue
        public void clear() {
            lazySet(3);
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            set(3);
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return get() == 3;
        }

        @Override // io.reactivex.internal.p101b.QueueFuseable
        public int requestFusion(int i) {
            if ((i & 1) != 0) {
                lazySet(1);
                return 1;
            }
            return 0;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (get() == 0 && compareAndSet(0, 2)) {
                this.observer.onNext((T) this.value);
                if (get() == 2) {
                    lazySet(3);
                    this.observer.onComplete();
                }
            }
        }
    }
}
