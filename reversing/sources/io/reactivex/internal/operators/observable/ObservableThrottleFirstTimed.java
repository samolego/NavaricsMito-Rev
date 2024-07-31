package io.reactivex.internal.operators.observable;

import io.reactivex.AbstractC2901p;
import io.reactivex.InterfaceC2900o;
import io.reactivex.ObservableSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.p097c.SerializedObserver;
import io.reactivex.p098d.RxJavaPlugins;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes2.dex */
public final class ObservableThrottleFirstTimed<T> extends AbstractObservableWithUpstream<T, T> {

    /* renamed from: b */
    final long f9725b;

    /* renamed from: c */
    final TimeUnit f9726c;

    /* renamed from: d */
    final AbstractC2901p f9727d;

    public ObservableThrottleFirstTimed(ObservableSource<T> observableSource, long j, TimeUnit timeUnit, AbstractC2901p abstractC2901p) {
        super(observableSource);
        this.f9725b = j;
        this.f9726c = timeUnit;
        this.f9727d = abstractC2901p;
    }

    @Override // io.reactivex.Observable
    /* renamed from: a */
    public void mo158a(InterfaceC2900o<? super T> interfaceC2900o) {
        this.f9731a.subscribe(new DebounceTimedObserver(new SerializedObserver(interfaceC2900o), this.f9725b, this.f9726c, this.f9727d.mo3063a()));
    }

    /* loaded from: classes2.dex */
    static final class DebounceTimedObserver<T> extends AtomicReference<Disposable> implements Disposable, InterfaceC2900o<T>, Runnable {
        private static final long serialVersionUID = 786994795061867455L;
        boolean done;
        final InterfaceC2900o<? super T> downstream;
        volatile boolean gate;
        final long timeout;
        final TimeUnit unit;
        Disposable upstream;
        final AbstractC2901p.AbstractC2904c worker;

        DebounceTimedObserver(InterfaceC2900o<? super T> interfaceC2900o, long j, TimeUnit timeUnit, AbstractC2901p.AbstractC2904c abstractC2904c) {
            this.downstream = interfaceC2900o;
            this.timeout = j;
            this.unit = timeUnit;
            this.worker = abstractC2904c;
        }

        @Override // io.reactivex.InterfaceC2900o
        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.upstream, disposable)) {
                this.upstream = disposable;
                this.downstream.onSubscribe(this);
            }
        }

        @Override // io.reactivex.InterfaceC2900o
        public void onNext(T t) {
            if (this.gate || this.done) {
                return;
            }
            this.gate = true;
            this.downstream.onNext(t);
            Disposable disposable = get();
            if (disposable != null) {
                disposable.dispose();
            }
            DisposableHelper.replace(this, this.worker.mo3056a(this, this.timeout, this.unit));
        }

        @Override // java.lang.Runnable
        public void run() {
            this.gate = false;
        }

        @Override // io.reactivex.InterfaceC2900o
        public void onError(Throwable th) {
            if (this.done) {
                RxJavaPlugins.m3233a(th);
                return;
            }
            this.done = true;
            this.downstream.onError(th);
            this.worker.dispose();
        }

        @Override // io.reactivex.InterfaceC2900o
        public void onComplete() {
            if (this.done) {
                return;
            }
            this.done = true;
            this.downstream.onComplete();
            this.worker.dispose();
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            this.upstream.dispose();
            this.worker.dispose();
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.worker.isDisposed();
        }
    }
}
