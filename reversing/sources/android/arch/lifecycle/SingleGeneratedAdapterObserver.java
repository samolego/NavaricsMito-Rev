package android.arch.lifecycle;

import android.arch.lifecycle.Lifecycle;
import android.support.annotation.RestrictTo;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes.dex */
public class SingleGeneratedAdapterObserver implements GenericLifecycleObserver {

    /* renamed from: a */
    private final GeneratedAdapter f48a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public SingleGeneratedAdapterObserver(GeneratedAdapter generatedAdapter) {
        this.f48a = generatedAdapter;
    }

    @Override // android.arch.lifecycle.GenericLifecycleObserver
    /* renamed from: a */
    public void mo12896a(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
        this.f48a.m12887a(lifecycleOwner, event, false, null);
        this.f48a.m12887a(lifecycleOwner, event, true, null);
    }
}
