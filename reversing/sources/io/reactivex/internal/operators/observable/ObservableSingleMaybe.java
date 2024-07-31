package io.reactivex.internal.operators.observable;

import io.reactivex.Maybe;
import io.reactivex.ObservableSource;

/* renamed from: io.reactivex.internal.operators.observable.l */
/* loaded from: classes2.dex */
public final class ObservableSingleMaybe<T> extends Maybe<T> {

    /* renamed from: a */
    final ObservableSource<T> f9773a;

    public ObservableSingleMaybe(ObservableSource<T> observableSource) {
        this.f9773a = observableSource;
    }
}
