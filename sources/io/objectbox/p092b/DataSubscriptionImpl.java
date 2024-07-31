package io.objectbox.p092b;

import javax.annotation.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: io.objectbox.b.e */
/* loaded from: classes2.dex */
public class DataSubscriptionImpl<T> implements DataSubscription {

    /* renamed from: a */
    private volatile boolean f9470a;

    /* renamed from: b */
    private DataPublisher<T> f9471b;

    /* renamed from: c */
    private Object f9472c;

    /* renamed from: d */
    private DataObserver<T> f9473d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public DataSubscriptionImpl(DataPublisher<T> dataPublisher, @Nullable Object obj, DataObserver<T> dataObserver) {
        this.f9471b = dataPublisher;
        this.f9472c = obj;
        this.f9473d = dataObserver;
    }

    @Override // io.objectbox.p092b.DataSubscription
    /* renamed from: a */
    public synchronized void mo3370a() {
        this.f9470a = true;
        if (this.f9471b != null) {
            this.f9471b.mo3279b(this.f9473d, this.f9472c);
            this.f9471b = null;
            this.f9473d = null;
            this.f9472c = null;
        }
    }

    @Override // io.objectbox.p092b.DataSubscription
    /* renamed from: b */
    public boolean mo3368b() {
        return this.f9470a;
    }
}
