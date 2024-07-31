package com.google.android.gms.internal;

import android.os.DeadObjectException;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.zzb;
import com.google.android.gms.internal.zzrd;
import com.google.android.gms.tasks.TaskCompletionSource;

/* loaded from: classes.dex */
public abstract class zzrh<A extends Api.zzb> {
    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void zza(A a, TaskCompletionSource<Void> taskCompletionSource) throws DeadObjectException;

    public zzrd.zzb<?> zzasr() {
        zzrd zzrdVar = null;
        return zzrdVar.zzasr();
    }
}
