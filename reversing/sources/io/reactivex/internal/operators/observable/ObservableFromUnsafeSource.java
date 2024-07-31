package io.reactivex.internal.operators.observable;

import io.reactivex.InterfaceC2900o;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;

/* renamed from: io.reactivex.internal.operators.observable.g */
/* loaded from: classes2.dex */
public final class ObservableFromUnsafeSource<T> extends Observable<T> {

    /* renamed from: a */
    final ObservableSource<T> f9758a;

    public ObservableFromUnsafeSource(ObservableSource<T> observableSource) {
        this.f9758a = observableSource;
    }

    @Override // io.reactivex.Observable
    /* renamed from: a */
    protected void mo158a(InterfaceC2900o<? super T> interfaceC2900o) {
        this.f9758a.subscribe(interfaceC2900o);
    }
}
