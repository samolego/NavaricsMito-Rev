package io.reactivex.internal.operators.p102a;

import io.reactivex.Flowable;
import io.reactivex.internal.p100a.ObjectHelper;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: io.reactivex.internal.operators.a.a */
/* loaded from: classes2.dex */
public abstract class AbstractFlowableWithUpstream<T, R> extends Flowable<R> {

    /* renamed from: b */
    protected final Flowable<T> f9672b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public AbstractFlowableWithUpstream(Flowable<T> flowable) {
        this.f9672b = (Flowable) ObjectHelper.m3188a(flowable, "source is null");
    }
}
