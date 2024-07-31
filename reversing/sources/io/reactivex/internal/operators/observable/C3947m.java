package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Single;

/* renamed from: io.reactivex.internal.operators.observable.m */
/* loaded from: classes2.dex */
public final class ObservableSingleSingle<T> extends Single<T> {

    /* renamed from: a */
    final ObservableSource<? extends T> f9774a;

    /* renamed from: b */
    final T f9775b;

    public ObservableSingleSingle(ObservableSource<? extends T> observableSource, T t) {
        this.f9774a = observableSource;
        this.f9775b = t;
    }
}
