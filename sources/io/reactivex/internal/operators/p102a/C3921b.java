package io.reactivex.internal.operators.p102a;

import io.reactivex.Flowable;
import io.reactivex.Observable;

/* renamed from: io.reactivex.internal.operators.a.b */
/* loaded from: classes2.dex */
public final class FlowableFromObservable<T> extends Flowable<T> {

    /* renamed from: b */
    private final Observable<T> f9673b;

    public FlowableFromObservable(Observable<T> observable) {
        this.f9673b = observable;
    }
}
