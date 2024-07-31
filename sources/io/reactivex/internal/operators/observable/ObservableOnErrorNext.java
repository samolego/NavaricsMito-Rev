package io.reactivex.internal.operators.observable;

import io.reactivex.InterfaceC2900o;
import io.reactivex.ObservableSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.disposables.SequentialDisposable;
import io.reactivex.p096b.Function;
import io.reactivex.p098d.RxJavaPlugins;

/* renamed from: io.reactivex.internal.operators.observable.k */
/* loaded from: classes2.dex */
public final class ObservableOnErrorNext<T> extends AbstractObservableWithUpstream<T, T> {

    /* renamed from: b */
    final Function<? super Throwable, ? extends ObservableSource<? extends T>> f9765b;

    /* renamed from: c */
    final boolean f9766c;

    public ObservableOnErrorNext(ObservableSource<T> observableSource, Function<? super Throwable, ? extends ObservableSource<? extends T>> function, boolean z) {
        super(observableSource);
        this.f9765b = function;
        this.f9766c = z;
    }

    @Override // io.reactivex.Observable
    /* renamed from: a */
    public void mo158a(InterfaceC2900o<? super T> interfaceC2900o) {
        C2883a c2883a = new C2883a(interfaceC2900o, this.f9765b, this.f9766c);
        interfaceC2900o.onSubscribe(c2883a.f9770d);
        this.f9731a.subscribe(c2883a);
    }

    /* compiled from: ObservableOnErrorNext.java */
    /* renamed from: io.reactivex.internal.operators.observable.k$a */
    /* loaded from: classes2.dex */
    static final class C2883a<T> implements InterfaceC2900o<T> {

        /* renamed from: a */
        final InterfaceC2900o<? super T> f9767a;

        /* renamed from: b */
        final Function<? super Throwable, ? extends ObservableSource<? extends T>> f9768b;

        /* renamed from: c */
        final boolean f9769c;

        /* renamed from: d */
        final SequentialDisposable f9770d = new SequentialDisposable();

        /* renamed from: e */
        boolean f9771e;

        /* renamed from: f */
        boolean f9772f;

        C2883a(InterfaceC2900o<? super T> interfaceC2900o, Function<? super Throwable, ? extends ObservableSource<? extends T>> function, boolean z) {
            this.f9767a = interfaceC2900o;
            this.f9768b = function;
            this.f9769c = z;
        }

        @Override // io.reactivex.InterfaceC2900o
        public void onSubscribe(Disposable disposable) {
            this.f9770d.replace(disposable);
        }

        @Override // io.reactivex.InterfaceC2900o
        public void onNext(T t) {
            if (this.f9772f) {
                return;
            }
            this.f9767a.onNext(t);
        }

        @Override // io.reactivex.InterfaceC2900o
        public void onError(Throwable th) {
            if (this.f9771e) {
                if (this.f9772f) {
                    RxJavaPlugins.m3233a(th);
                    return;
                } else {
                    this.f9767a.onError(th);
                    return;
                }
            }
            this.f9771e = true;
            if (this.f9769c && !(th instanceof Exception)) {
                this.f9767a.onError(th);
                return;
            }
            try {
                ObservableSource<? extends T> apply = this.f9768b.apply(th);
                if (apply == null) {
                    NullPointerException nullPointerException = new NullPointerException("Observable is null");
                    nullPointerException.initCause(th);
                    this.f9767a.onError(nullPointerException);
                    return;
                }
                apply.subscribe(this);
            } catch (Throwable th2) {
                Exceptions.m3207b(th2);
                this.f9767a.onError(new CompositeException(th, th2));
            }
        }

        @Override // io.reactivex.InterfaceC2900o
        public void onComplete() {
            if (this.f9772f) {
                return;
            }
            this.f9772f = true;
            this.f9771e = true;
            this.f9767a.onComplete();
        }
    }
}
