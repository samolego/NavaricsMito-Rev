package io.reactivex.internal.operators.observable;

import io.reactivex.InterfaceC2900o;
import io.reactivex.ObservableSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.p096b.Consumer;
import io.reactivex.p096b.InterfaceC2848a;
import io.reactivex.p098d.RxJavaPlugins;

/* renamed from: io.reactivex.internal.operators.observable.b */
/* loaded from: classes2.dex */
public final class ObservableDoOnEach<T> extends AbstractObservableWithUpstream<T, T> {

    /* renamed from: b */
    final Consumer<? super T> f9732b;

    /* renamed from: c */
    final Consumer<? super Throwable> f9733c;

    /* renamed from: d */
    final InterfaceC2848a f9734d;

    /* renamed from: e */
    final InterfaceC2848a f9735e;

    public ObservableDoOnEach(ObservableSource<T> observableSource, Consumer<? super T> consumer, Consumer<? super Throwable> consumer2, InterfaceC2848a interfaceC2848a, InterfaceC2848a interfaceC2848a2) {
        super(observableSource);
        this.f9732b = consumer;
        this.f9733c = consumer2;
        this.f9734d = interfaceC2848a;
        this.f9735e = interfaceC2848a2;
    }

    @Override // io.reactivex.Observable
    /* renamed from: a */
    public void mo158a(InterfaceC2900o<? super T> interfaceC2900o) {
        this.f9731a.subscribe(new C2878a(interfaceC2900o, this.f9732b, this.f9733c, this.f9734d, this.f9735e));
    }

    /* compiled from: ObservableDoOnEach.java */
    /* renamed from: io.reactivex.internal.operators.observable.b$a */
    /* loaded from: classes2.dex */
    static final class C2878a<T> implements Disposable, InterfaceC2900o<T> {

        /* renamed from: a */
        final InterfaceC2900o<? super T> f9736a;

        /* renamed from: b */
        final Consumer<? super T> f9737b;

        /* renamed from: c */
        final Consumer<? super Throwable> f9738c;

        /* renamed from: d */
        final InterfaceC2848a f9739d;

        /* renamed from: e */
        final InterfaceC2848a f9740e;

        /* renamed from: f */
        Disposable f9741f;

        /* renamed from: g */
        boolean f9742g;

        C2878a(InterfaceC2900o<? super T> interfaceC2900o, Consumer<? super T> consumer, Consumer<? super Throwable> consumer2, InterfaceC2848a interfaceC2848a, InterfaceC2848a interfaceC2848a2) {
            this.f9736a = interfaceC2900o;
            this.f9737b = consumer;
            this.f9738c = consumer2;
            this.f9739d = interfaceC2848a;
            this.f9740e = interfaceC2848a2;
        }

        @Override // io.reactivex.InterfaceC2900o
        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.f9741f, disposable)) {
                this.f9741f = disposable;
                this.f9736a.onSubscribe(this);
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            this.f9741f.dispose();
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.f9741f.isDisposed();
        }

        @Override // io.reactivex.InterfaceC2900o
        public void onNext(T t) {
            if (this.f9742g) {
                return;
            }
            try {
                this.f9737b.accept(t);
                this.f9736a.onNext(t);
            } catch (Throwable th) {
                Exceptions.m3207b(th);
                this.f9741f.dispose();
                onError(th);
            }
        }

        @Override // io.reactivex.InterfaceC2900o
        public void onError(Throwable th) {
            if (this.f9742g) {
                RxJavaPlugins.m3233a(th);
                return;
            }
            this.f9742g = true;
            try {
                this.f9738c.accept(th);
            } catch (Throwable th2) {
                Exceptions.m3207b(th2);
                th = new CompositeException(th, th2);
            }
            this.f9736a.onError(th);
            try {
                this.f9740e.run();
            } catch (Throwable th3) {
                Exceptions.m3207b(th3);
                RxJavaPlugins.m3233a(th3);
            }
        }

        @Override // io.reactivex.InterfaceC2900o
        public void onComplete() {
            if (this.f9742g) {
                return;
            }
            try {
                this.f9739d.run();
                this.f9742g = true;
                this.f9736a.onComplete();
                try {
                    this.f9740e.run();
                } catch (Throwable th) {
                    Exceptions.m3207b(th);
                    RxJavaPlugins.m3233a(th);
                }
            } catch (Throwable th2) {
                Exceptions.m3207b(th2);
                onError(th2);
            }
        }
    }
}
