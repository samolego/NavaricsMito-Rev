package io.objectbox.p092b;

import java.util.List;

/* renamed from: io.objectbox.b.f */
/* loaded from: classes2.dex */
public class DataSubscriptionList implements DataSubscription {

    /* renamed from: a */
    private final List<DataSubscription> f9474a;

    /* renamed from: b */
    private boolean f9475b;

    /* renamed from: a */
    public synchronized void m3369a(DataSubscription dataSubscription) {
        this.f9474a.add(dataSubscription);
        this.f9475b = false;
    }

    @Override // io.objectbox.p092b.DataSubscription
    /* renamed from: a */
    public synchronized void mo3370a() {
        this.f9475b = true;
        for (DataSubscription dataSubscription : this.f9474a) {
            dataSubscription.mo3370a();
        }
        this.f9474a.clear();
    }

    @Override // io.objectbox.p092b.DataSubscription
    /* renamed from: b */
    public synchronized boolean mo3368b() {
        return this.f9475b;
    }
}
