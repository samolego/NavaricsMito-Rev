package io.reactivex;

import io.reactivex.annotations.BackpressureSupport;
import io.reactivex.annotations.CheckReturnValue;
import io.reactivex.annotations.SchedulerSupport;
import io.reactivex.internal.operators.p102a.FlowableOnBackpressureBuffer;
import io.reactivex.internal.operators.p102a.FlowableOnBackpressureDrop;
import io.reactivex.internal.operators.p102a.FlowableOnBackpressureLatest;
import io.reactivex.internal.p100a.Functions;
import io.reactivex.internal.p100a.ObjectHelper;
import io.reactivex.p098d.RxJavaPlugins;

/* renamed from: io.reactivex.g */
/* loaded from: classes2.dex */
public abstract class Flowable<T> {

    /* renamed from: a */
    static final int f9647a = Math.max(1, Integer.getInteger("rx2.buffer-size", 128).intValue());

    /* renamed from: a */
    public static int m3206a() {
        return f9647a;
    }

    @SchedulerSupport
    @BackpressureSupport
    @CheckReturnValue
    /* renamed from: b */
    public final Flowable<T> m3204b() {
        return m3205a(m3206a(), false, true);
    }

    @SchedulerSupport
    @BackpressureSupport
    @CheckReturnValue
    /* renamed from: a */
    public final Flowable<T> m3205a(int i, boolean z, boolean z2) {
        ObjectHelper.m3191a(i, "bufferSize");
        return RxJavaPlugins.m3240a(new FlowableOnBackpressureBuffer(this, i, z2, z, Functions.f9650c));
    }

    @SchedulerSupport
    @BackpressureSupport
    @CheckReturnValue
    /* renamed from: c */
    public final Flowable<T> m3203c() {
        return RxJavaPlugins.m3240a((Flowable) new FlowableOnBackpressureDrop(this));
    }

    @SchedulerSupport
    @BackpressureSupport
    @CheckReturnValue
    /* renamed from: d */
    public final Flowable<T> m3202d() {
        return RxJavaPlugins.m3240a(new FlowableOnBackpressureLatest(this));
    }
}
