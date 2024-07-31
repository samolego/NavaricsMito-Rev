package io.reactivex.internal.schedulers;

import io.reactivex.AbstractC2901p;
import io.reactivex.annotations.NonNull;
import java.util.concurrent.ThreadFactory;

/* renamed from: io.reactivex.internal.schedulers.d */
/* loaded from: classes2.dex */
public final class NewThreadScheduler extends AbstractC2901p {

    /* renamed from: c */
    private static final RxThreadFactory f9830c = new RxThreadFactory("RxNewThreadScheduler", Math.max(1, Math.min(10, Integer.getInteger("rx2.newthread-priority", 5).intValue())));

    /* renamed from: b */
    final ThreadFactory f9831b;

    public NewThreadScheduler() {
        this(f9830c);
    }

    public NewThreadScheduler(ThreadFactory threadFactory) {
        this.f9831b = threadFactory;
    }

    @Override // io.reactivex.AbstractC2901p
    @NonNull
    /* renamed from: a */
    public AbstractC2901p.AbstractC2904c mo3063a() {
        return new NewThreadWorker(this.f9831b);
    }
}
