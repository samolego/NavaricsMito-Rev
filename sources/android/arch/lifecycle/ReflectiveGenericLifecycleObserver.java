package android.arch.lifecycle;

import android.arch.lifecycle.ClassesInfoCache;
import android.arch.lifecycle.Lifecycle;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ReflectiveGenericLifecycleObserver implements GenericLifecycleObserver {

    /* renamed from: a */
    private final Object f46a;

    /* renamed from: b */
    private final ClassesInfoCache.C0013a f47b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ReflectiveGenericLifecycleObserver(Object obj) {
        this.f46a = obj;
        this.f47b = ClassesInfoCache.f49a.m12892b(this.f46a.getClass());
    }

    @Override // android.arch.lifecycle.GenericLifecycleObserver
    /* renamed from: a */
    public void mo12896a(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
        this.f47b.m12890a(lifecycleOwner, event, this.f46a);
    }
}
