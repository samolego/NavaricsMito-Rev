package io.reactivex.internal.operators.observable;

import io.reactivex.AbstractC2901p;
import io.reactivex.InterfaceC2900o;
import io.reactivex.ObservableSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.p097c.SerializedObserver;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes2.dex */
public final class ObservableSampleTimed<T> extends AbstractObservableWithUpstream<T, T> {

    /* renamed from: b */
    final long f9716b;

    /* renamed from: c */
    final TimeUnit f9717c;

    /* renamed from: d */
    final AbstractC2901p f9718d;

    /* renamed from: e */
    final boolean f9719e;

    public ObservableSampleTimed(ObservableSource<T> observableSource, long j, TimeUnit timeUnit, AbstractC2901p abstractC2901p, boolean z) {
        super(observableSource);
        this.f9716b = j;
        this.f9717c = timeUnit;
        this.f9718d = abstractC2901p;
        this.f9719e = z;
    }

    @Override // io.reactivex.Observable
    /* renamed from: a */
    public void mo158a(InterfaceC2900o<? super T> interfaceC2900o) {
        SerializedObserver serializedObserver = new SerializedObserver(interfaceC2900o);
        if (this.f9719e) {
            this.f9731a.subscribe(new SampleTimedEmitLast(serializedObserver, this.f9716b, this.f9717c, this.f9718d));
        } else {
            this.f9731a.subscribe(new SampleTimedNoLast(serializedObserver, this.f9716b, this.f9717c, this.f9718d));
        }
    }

    /* loaded from: classes2.dex */
    static abstract class SampleTimedObserver<T> extends AtomicReference<T> implements Disposable, InterfaceC2900o<T>, Runnable {
        private static final long serialVersionUID = -3517602651313910099L;
        final InterfaceC2900o<? super T> downstream;
        final long period;
        final AbstractC2901p scheduler;
        final AtomicReference<Disposable> timer = new AtomicReference<>();
        final TimeUnit unit;
        Disposable upstream;

        abstract void complete();

        SampleTimedObserver(InterfaceC2900o<? super T> interfaceC2900o, long j, TimeUnit timeUnit, AbstractC2901p abstractC2901p) {
            this.downstream = interfaceC2900o;
            this.period = j;
            this.unit = timeUnit;
            this.scheduler = abstractC2901p;
        }

        @Override // io.reactivex.InterfaceC2900o
        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.upstream, disposable)) {
                this.upstream = disposable;
                this.downstream.onSubscribe(this);
                AbstractC2901p abstractC2901p = this.scheduler;
                long j = this.period;
                DisposableHelper.replace(this.timer, abstractC2901p.mo3061a(this, j, j, this.unit));
            }
        }

        @Override // io.reactivex.InterfaceC2900o
        public void onNext(T t) {
            lazySet(t);
        }

        @Override // io.reactivex.InterfaceC2900o
        public void onError(Throwable th) {
            cancelTimer();
            this.downstream.onError(th);
        }

        @Override // io.reactivex.InterfaceC2900o
        public void onComplete() {
            cancelTimer();
            complete();
        }

        void cancelTimer() {
            DisposableHelper.dispose(this.timer);
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            cancelTimer();
            this.upstream.dispose();
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.upstream.isDisposed();
        }

        void emit() {
            T andSet = getAndSet(null);
            if (andSet != null) {
                this.downstream.onNext(andSet);
            }
        }
    }

    /* loaded from: classes2.dex */
    static final class SampleTimedNoLast<T> extends SampleTimedObserver<T> {
        private static final long serialVersionUID = -7139995637533111443L;

        SampleTimedNoLast(InterfaceC2900o<? super T> interfaceC2900o, long j, TimeUnit timeUnit, AbstractC2901p abstractC2901p) {
            super(interfaceC2900o, j, timeUnit, abstractC2901p);
        }

        @Override // io.reactivex.internal.operators.observable.ObservableSampleTimed.SampleTimedObserver
        void complete() {
            this.downstream.onComplete();
        }

        @Override // java.lang.Runnable
        public void run() {
            emit();
        }
    }

    /* loaded from: classes2.dex */
    static final class SampleTimedEmitLast<T> extends SampleTimedObserver<T> {
        private static final long serialVersionUID = -7139995637533111443L;
        final AtomicInteger wip;

        SampleTimedEmitLast(InterfaceC2900o<? super T> interfaceC2900o, long j, TimeUnit timeUnit, AbstractC2901p abstractC2901p) {
            super(interfaceC2900o, j, timeUnit, abstractC2901p);
            this.wip = new AtomicInteger(1);
        }

        @Override // io.reactivex.internal.operators.observable.ObservableSampleTimed.SampleTimedObserver
        void complete() {
            emit();
            if (this.wip.decrementAndGet() == 0) {
                this.downstream.onComplete();
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.wip.incrementAndGet() == 2) {
                emit();
                if (this.wip.decrementAndGet() == 0) {
                    this.downstream.onComplete();
                }
            }
        }
    }
}
