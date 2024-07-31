package io.reactivex.internal.operators.p102a;

import io.reactivex.Flowable;
import io.reactivex.p096b.InterfaceC2848a;

/* renamed from: io.reactivex.internal.operators.a.c */
/* loaded from: classes2.dex */
public final class FlowableOnBackpressureBuffer<T> extends AbstractFlowableWithUpstream<T, T> {

    /* renamed from: c */
    final int f9674c;

    /* renamed from: d */
    final boolean f9675d;

    /* renamed from: e */
    final boolean f9676e;

    /* renamed from: f */
    final InterfaceC2848a f9677f;

    public FlowableOnBackpressureBuffer(Flowable<T> flowable, int i, boolean z, boolean z2, InterfaceC2848a interfaceC2848a) {
        super(flowable);
        this.f9674c = i;
        this.f9675d = z;
        this.f9676e = z2;
        this.f9677f = interfaceC2848a;
    }
}
