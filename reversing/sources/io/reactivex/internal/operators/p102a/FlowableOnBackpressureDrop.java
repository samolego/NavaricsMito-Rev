package io.reactivex.internal.operators.p102a;

import io.reactivex.Flowable;
import io.reactivex.p096b.Consumer;

/* renamed from: io.reactivex.internal.operators.a.d */
/* loaded from: classes2.dex */
public final class FlowableOnBackpressureDrop<T> extends AbstractFlowableWithUpstream<T, T> implements Consumer<T> {

    /* renamed from: c */
    final Consumer<? super T> f9678c;

    @Override // io.reactivex.p096b.Consumer
    public void accept(T t) {
    }

    public FlowableOnBackpressureDrop(Flowable<T> flowable) {
        super(flowable);
        this.f9678c = this;
    }
}
