package android.arch.lifecycle;

import android.arch.lifecycle.Lifecycle;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class FullLifecycleObserverAdapter implements GenericLifecycleObserver {

    /* renamed from: a */
    private final FullLifecycleObserver f35a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public FullLifecycleObserverAdapter(FullLifecycleObserver fullLifecycleObserver) {
        this.f35a = fullLifecycleObserver;
    }

    @Override // android.arch.lifecycle.GenericLifecycleObserver
    /* renamed from: a */
    public void mo12896a(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
        switch (event) {
            case ON_CREATE:
                this.f35a.m12907a(lifecycleOwner);
                return;
            case ON_START:
                this.f35a.m12906b(lifecycleOwner);
                return;
            case ON_RESUME:
                this.f35a.m12905c(lifecycleOwner);
                return;
            case ON_PAUSE:
                this.f35a.m12904d(lifecycleOwner);
                return;
            case ON_STOP:
                this.f35a.m12903e(lifecycleOwner);
                return;
            case ON_DESTROY:
                this.f35a.m12902f(lifecycleOwner);
                return;
            case ON_ANY:
                throw new IllegalArgumentException("ON_ANY must not been send by anybody");
            default:
                return;
        }
    }
}
