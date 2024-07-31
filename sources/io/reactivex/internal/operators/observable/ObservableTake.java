package io.reactivex.internal.operators.observable;

import io.reactivex.InterfaceC2900o;
import io.reactivex.ObservableSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.p098d.RxJavaPlugins;

/* renamed from: io.reactivex.internal.operators.observable.n */
/* loaded from: classes2.dex */
public final class ObservableTake<T> extends AbstractObservableWithUpstream<T, T> {

    /* renamed from: b */
    final long f9776b;

    public ObservableTake(ObservableSource<T> observableSource, long j) {
        super(observableSource);
        this.f9776b = j;
    }

    @Override // io.reactivex.Observable
    /* renamed from: a */
    protected void mo158a(InterfaceC2900o<? super T> interfaceC2900o) {
        this.f9731a.subscribe(new C2884a(interfaceC2900o, this.f9776b));
    }

    /* compiled from: ObservableTake.java */
    /* renamed from: io.reactivex.internal.operators.observable.n$a */
    /* loaded from: classes2.dex */
    static final class C2884a<T> implements Disposable, InterfaceC2900o<T> {

        /* renamed from: a */
        final InterfaceC2900o<? super T> f9777a;

        /* renamed from: b */
        boolean f9778b;

        /* renamed from: c */
        Disposable f9779c;

        /* renamed from: d */
        long f9780d;

        C2884a(InterfaceC2900o<? super T> interfaceC2900o, long j) {
            this.f9777a = interfaceC2900o;
            this.f9780d = j;
        }

        @Override // io.reactivex.InterfaceC2900o
        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.f9779c, disposable)) {
                this.f9779c = disposable;
                if (this.f9780d == 0) {
                    this.f9778b = true;
                    disposable.dispose();
                    EmptyDisposable.complete(this.f9777a);
                    return;
                }
                this.f9777a.onSubscribe(this);
            }
        }

        @Override // io.reactivex.InterfaceC2900o
        public void onNext(T t) {
            if (this.f9778b) {
                return;
            }
            long j = this.f9780d;
            this.f9780d = j - 1;
            if (j > 0) {
                boolean z = this.f9780d == 0;
                this.f9777a.onNext(t);
                if (z) {
                    onComplete();
                }
            }
        }

        @Override // io.reactivex.InterfaceC2900o
        public void onError(Throwable th) {
            if (this.f9778b) {
                RxJavaPlugins.m3233a(th);
                return;
            }
            this.f9778b = true;
            this.f9779c.dispose();
            this.f9777a.onError(th);
        }

        @Override // io.reactivex.InterfaceC2900o
        public void onComplete() {
            if (this.f9778b) {
                return;
            }
            this.f9778b = true;
            this.f9779c.dispose();
            this.f9777a.onComplete();
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            this.f9779c.dispose();
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.f9779c.isDisposed();
        }
    }
}
