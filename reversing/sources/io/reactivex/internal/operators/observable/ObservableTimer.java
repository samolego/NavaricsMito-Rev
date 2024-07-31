package io.reactivex.internal.operators.observable;

import io.reactivex.AbstractC2901p;
import io.reactivex.InterfaceC2900o;
import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.EmptyDisposable;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes2.dex */
public final class ObservableTimer extends Observable<Long> {

    /* renamed from: a */
    final AbstractC2901p f9728a;

    /* renamed from: b */
    final long f9729b;

    /* renamed from: c */
    final TimeUnit f9730c;

    public ObservableTimer(long j, TimeUnit timeUnit, AbstractC2901p abstractC2901p) {
        this.f9729b = j;
        this.f9730c = timeUnit;
        this.f9728a = abstractC2901p;
    }

    @Override // io.reactivex.Observable
    /* renamed from: a */
    public void mo158a(InterfaceC2900o<? super Long> interfaceC2900o) {
        TimerObserver timerObserver = new TimerObserver(interfaceC2900o);
        interfaceC2900o.onSubscribe(timerObserver);
        timerObserver.setResource(this.f9728a.mo3060a(timerObserver, this.f9729b, this.f9730c));
    }

    /* loaded from: classes2.dex */
    static final class TimerObserver extends AtomicReference<Disposable> implements Disposable, Runnable {
        private static final long serialVersionUID = -2809475196591179431L;
        final InterfaceC2900o<? super Long> downstream;

        TimerObserver(InterfaceC2900o<? super Long> interfaceC2900o) {
            this.downstream = interfaceC2900o;
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            DisposableHelper.dispose(this);
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return get() == DisposableHelper.DISPOSED;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (isDisposed()) {
                return;
            }
            this.downstream.onNext(0L);
            lazySet(EmptyDisposable.INSTANCE);
            this.downstream.onComplete();
        }

        public void setResource(Disposable disposable) {
            DisposableHelper.trySet(this, disposable);
        }
    }
}
