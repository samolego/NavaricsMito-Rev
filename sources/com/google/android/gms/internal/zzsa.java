package com.google.android.gms.internal;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.zzqc;

/* loaded from: classes.dex */
abstract class zzsa<R extends Result> extends zzqc.zza<R, zzsb> {

    /* loaded from: classes.dex */
    static abstract class zza extends zzsa<Status> {
        public zza(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        @Override // com.google.android.gms.internal.zzqe
        /* renamed from: zzb */
        public Status zzc(Status status) {
            return status;
        }
    }

    public zzsa(GoogleApiClient googleApiClient) {
        super(zzrx.API, googleApiClient);
    }
}
