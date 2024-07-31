package com.google.android.gms.internal;

import android.os.Looper;
import android.support.annotation.NonNull;
import java.util.Collections;
import java.util.Set;
import java.util.WeakHashMap;

/* loaded from: classes.dex */
public class zzre {

    /* renamed from: pA */
    private final Set<zzrd<?>> f3291pA = Collections.newSetFromMap(new WeakHashMap());

    public void release() {
        for (zzrd<?> zzrdVar : this.f3291pA) {
            zzrdVar.clear();
        }
        this.f3291pA.clear();
    }

    public <L> zzrd<L> zza(@NonNull L l, @NonNull Looper looper, @NonNull String str) {
        com.google.android.gms.common.internal.zzac.zzb(l, "Listener must not be null");
        com.google.android.gms.common.internal.zzac.zzb(looper, "Looper must not be null");
        com.google.android.gms.common.internal.zzac.zzb(str, "Listener type must not be null");
        zzrd<L> zzrdVar = new zzrd<>(looper, l, str);
        this.f3291pA.add(zzrdVar);
        return zzrdVar;
    }

    public <L> zzrd<L> zzb(@NonNull L l, Looper looper) {
        return zza(l, looper, "NO_TYPE");
    }
}
