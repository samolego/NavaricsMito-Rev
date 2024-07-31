package io.reactivex.internal.operators.observable;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;

/* renamed from: io.reactivex.internal.operators.observable.a */
/* loaded from: classes2.dex */
abstract class AbstractObservableWithUpstream<T, U> extends Observable<U> {

    /* renamed from: a */
    protected final ObservableSource<T> f9731a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public AbstractObservableWithUpstream(ObservableSource<T> observableSource) {
        this.f9731a = observableSource;
    }
}
