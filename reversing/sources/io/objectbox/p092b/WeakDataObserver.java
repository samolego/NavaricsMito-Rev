package io.objectbox.p092b;

import io.objectbox.annotation.apihint.Internal;
import java.lang.ref.WeakReference;

@Internal
/* renamed from: io.objectbox.b.m */
/* loaded from: classes2.dex */
public class WeakDataObserver<T> implements DataObserver<T>, DelegatingObserver {

    /* renamed from: a */
    private final WeakReference<DataObserver<T>> f9495a;

    /* renamed from: b */
    private DataSubscription f9496b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public WeakDataObserver(DataObserver<T> dataObserver) {
        this.f9495a = new WeakReference<>(dataObserver);
    }

    @Override // io.objectbox.p092b.DataObserver
    public void onData(T t) {
        DataObserver<T> dataObserver = this.f9495a.get();
        if (dataObserver != null) {
            dataObserver.onData(t);
        } else {
            this.f9496b.mo3370a();
        }
    }

    @Override // io.objectbox.p092b.DelegatingObserver
    /* renamed from: a */
    public DataObserver<T> mo3348a() {
        return this.f9495a.get();
    }

    public boolean equals(Object obj) {
        if (obj instanceof WeakDataObserver) {
            DataObserver<T> dataObserver = this.f9495a.get();
            if (dataObserver == null || dataObserver != ((WeakDataObserver) obj).f9495a.get()) {
                return super.equals(obj);
            }
            return true;
        }
        return false;
    }

    public int hashCode() {
        DataObserver<T> dataObserver = this.f9495a.get();
        if (dataObserver != null) {
            return dataObserver.hashCode();
        }
        return super.hashCode();
    }

    /* renamed from: a */
    public void m3347a(DataSubscription dataSubscription) {
        this.f9496b = dataSubscription;
    }
}
