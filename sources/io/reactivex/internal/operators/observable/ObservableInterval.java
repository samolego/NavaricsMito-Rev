package io.reactivex.internal.operators.observable;

import io.reactivex.AbstractC2901p;
import io.reactivex.InterfaceC2900o;
import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.schedulers.TrampolineScheduler;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes2.dex */
public final class ObservableInterval extends Observable<Long> {

    /* renamed from: a */
    final AbstractC2901p f9709a;

    /* renamed from: b */
    final long f9710b;

    /* renamed from: c */
    final long f9711c;

    /* renamed from: d */
    final TimeUnit f9712d;

    public ObservableInterval(long j, long j2, TimeUnit timeUnit, AbstractC2901p abstractC2901p) {
        this.f9710b = j;
        this.f9711c = j2;
        this.f9712d = timeUnit;
        this.f9709a = abstractC2901p;
    }

    @Override // io.reactivex.Observable
    /* renamed from: a */
    public void mo158a(InterfaceC2900o<? super Long> interfaceC2900o) {
        IntervalObserver intervalObserver = new IntervalObserver(interfaceC2900o);
        interfaceC2900o.onSubscribe(intervalObserver);
        AbstractC2901p abstractC2901p = this.f9709a;
        if (abstractC2901p instanceof TrampolineScheduler) {
            AbstractC2901p.AbstractC2904c mo3063a = abstractC2901p.mo3063a();
            intervalObserver.setResource(mo3063a);
            mo3063a.m3057a(intervalObserver, this.f9710b, this.f9711c, this.f9712d);
            return;
        }
        intervalObserver.setResource(abstractC2901p.mo3061a(intervalObserver, this.f9710b, this.f9711c, this.f9712d));
    }

    /* loaded from: classes2.dex */
    static final class IntervalObserver extends AtomicReference<Disposable> implements Disposable, Runnable {
        private static final long serialVersionUID = 346773832286157679L;
        long count;
        final InterfaceC2900o<? super Long> downstream;

        IntervalObserver(InterfaceC2900o<? super Long> interfaceC2900o) {
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
            if (get() != DisposableHelper.DISPOSED) {
                InterfaceC2900o<? super Long> interfaceC2900o = this.downstream;
                long j = this.count;
                this.count = 1 + j;
                interfaceC2900o.onNext(Long.valueOf(j));
            }
        }

        public void setResource(Disposable disposable) {
            DisposableHelper.setOnce(this, disposable);
        }
    }
}
