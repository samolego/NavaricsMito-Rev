package io.reactivex.internal.operators.observable;

import io.reactivex.InterfaceC2900o;
import io.reactivex.Observable;
import io.reactivex.internal.operators.observable.ObservableScalarXMap;
import io.reactivex.internal.p101b.ScalarCallable;

/* renamed from: io.reactivex.internal.operators.observable.i */
/* loaded from: classes2.dex */
public final class ObservableJust<T> extends Observable<T> implements ScalarCallable<T> {

    /* renamed from: a */
    private final T f9762a;

    public ObservableJust(T t) {
        this.f9762a = t;
    }

    @Override // io.reactivex.Observable
    /* renamed from: a */
    protected void mo158a(InterfaceC2900o<? super T> interfaceC2900o) {
        ObservableScalarXMap.ScalarDisposable scalarDisposable = new ObservableScalarXMap.ScalarDisposable(interfaceC2900o, this.f9762a);
        interfaceC2900o.onSubscribe(scalarDisposable);
        scalarDisposable.run();
    }

    @Override // io.reactivex.internal.p101b.ScalarCallable, java.util.concurrent.Callable
    public T call() {
        return this.f9762a;
    }
}
