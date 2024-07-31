package android.arch.lifecycle;

import android.arch.lifecycle.Lifecycle;
import android.support.annotation.RestrictTo;

@RestrictTo({RestrictTo.Scope.LIBRARY})
/* loaded from: classes.dex */
public interface GenericLifecycleObserver extends LifecycleObserver {
    /* renamed from: a */
    void mo12896a(LifecycleOwner lifecycleOwner, Lifecycle.Event event);
}
