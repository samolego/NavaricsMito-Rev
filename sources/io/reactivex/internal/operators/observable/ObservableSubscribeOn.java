package io.reactivex.internal.operators.observable;

import io.reactivex.AbstractC2901p;
import io.reactivex.InterfaceC2900o;
import io.reactivex.ObservableSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes2.dex */
public final class ObservableSubscribeOn<T> extends AbstractObservableWithUpstream<T, T> {

    /* renamed from: b */
    final AbstractC2901p f9722b;

    public ObservableSubscribeOn(ObservableSource<T> observableSource, AbstractC2901p abstractC2901p) {
        super(observableSource);
        this.f9722b = abstractC2901p;
    }

    @Override // io.reactivex.Observable
    /* renamed from: a */
    public void mo158a(InterfaceC2900o<? super T> interfaceC2900o) {
        SubscribeOnObserver subscribeOnObserver = new SubscribeOnObserver(interfaceC2900o);
        interfaceC2900o.onSubscribe(subscribeOnObserver);
        subscribeOnObserver.setDisposable(this.f9722b.mo3062a(new RunnableC2877a(subscribeOnObserver)));
    }

    /* loaded from: classes2.dex */
    static final class SubscribeOnObserver<T> extends AtomicReference<Disposable> implements Disposable, InterfaceC2900o<T> {
        private static final long serialVersionUID = 8094547886072529208L;
        final InterfaceC2900o<? super T> downstream;
        final AtomicReference<Disposable> upstream = new AtomicReference<>();

        SubscribeOnObserver(InterfaceC2900o<? super T> interfaceC2900o) {
            this.downstream = interfaceC2900o;
        }

        @Override // io.reactivex.InterfaceC2900o
        public void onSubscribe(Disposable disposable) {
            DisposableHelper.setOnce(this.upstream, disposable);
        }

        @Override // io.reactivex.InterfaceC2900o
        public void onNext(T t) {
            this.downstream.onNext(t);
        }

        @Override // io.reactivex.InterfaceC2900o
        public void onError(Throwable th) {
            this.downstream.onError(th);
        }

        @Override // io.reactivex.InterfaceC2900o
        public void onComplete() {
            this.downstream.onComplete();
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            DisposableHelper.dispose(this.upstream);
            DisposableHelper.dispose(this);
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return DisposableHelper.isDisposed(get());
        }

        void setDisposable(Disposable disposable) {
            DisposableHelper.setOnce(this, disposable);
        }
    }

    /* renamed from: io.reactivex.internal.operators.observable.ObservableSubscribeOn$a */
    /* loaded from: classes2.dex */
    final class RunnableC2877a implements Runnable {

        /* renamed from: b */
        private final SubscribeOnObserver<T> f9724b;

        RunnableC2877a(SubscribeOnObserver<T> subscribeOnObserver) {
            this.f9724b = subscribeOnObserver;
        }

        @Override // java.lang.Runnable
        public void run() {
            ObservableSubscribeOn.this.f9731a.subscribe(this.f9724b);
        }
    }
}
