package io.reactivex.internal.operators.observable;

import io.reactivex.Completable;
import io.reactivex.CompletableObserver;
import io.reactivex.InterfaceC2900o;
import io.reactivex.ObservableSource;
import io.reactivex.disposables.Disposable;

/* renamed from: io.reactivex.internal.operators.observable.h */
/* loaded from: classes2.dex */
public final class ObservableIgnoreElementsCompletable<T> extends Completable {

    /* renamed from: a */
    final ObservableSource<T> f9759a;

    public ObservableIgnoreElementsCompletable(ObservableSource<T> observableSource) {
        this.f9759a = observableSource;
    }

    @Override // io.reactivex.Completable
    /* renamed from: b */
    public void mo3174b(CompletableObserver completableObserver) {
        this.f9759a.subscribe(new C2881a(completableObserver));
    }

    /* compiled from: ObservableIgnoreElementsCompletable.java */
    /* renamed from: io.reactivex.internal.operators.observable.h$a */
    /* loaded from: classes2.dex */
    static final class C2881a<T> implements Disposable, InterfaceC2900o<T> {

        /* renamed from: a */
        final CompletableObserver f9760a;

        /* renamed from: b */
        Disposable f9761b;

        @Override // io.reactivex.InterfaceC2900o
        public void onNext(T t) {
        }

        C2881a(CompletableObserver completableObserver) {
            this.f9760a = completableObserver;
        }

        @Override // io.reactivex.InterfaceC2900o
        public void onSubscribe(Disposable disposable) {
            this.f9761b = disposable;
            this.f9760a.onSubscribe(this);
        }

        @Override // io.reactivex.InterfaceC2900o
        public void onError(Throwable th) {
            this.f9760a.onError(th);
        }

        @Override // io.reactivex.InterfaceC2900o
        public void onComplete() {
            this.f9760a.onComplete();
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            this.f9761b.dispose();
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.f9761b.isDisposed();
        }
    }
}
