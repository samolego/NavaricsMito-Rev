package com.google.android.gms.internal;

import android.os.Looper;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Status;

/* loaded from: classes.dex */
public class zzrm extends zzqe<Status> {
    @Deprecated
    public zzrm(Looper looper) {
        super(looper);
    }

    public zzrm(GoogleApiClient googleApiClient) {
        super(googleApiClient);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.zzqe
    /* renamed from: zzb */
    public Status zzc(Status status) {
        return status;
    }
}
