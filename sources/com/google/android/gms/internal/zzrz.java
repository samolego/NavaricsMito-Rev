package com.google.android.gms.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.zzqc;
import com.google.android.gms.internal.zzsa;

/* loaded from: classes.dex */
public final class zzrz implements zzry {

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class zza extends zzrw {

        /* renamed from: Dj */
        private final zzqc.zzb<Status> f3352Dj;

        public zza(zzqc.zzb<Status> zzbVar) {
            this.f3352Dj = zzbVar;
        }

        @Override // com.google.android.gms.internal.zzrw, com.google.android.gms.internal.zzsc
        public void zzgw(int i) throws RemoteException {
            this.f3352Dj.setResult(new Status(i));
        }
    }

    @Override // com.google.android.gms.internal.zzry
    public PendingResult<Status> zzg(GoogleApiClient googleApiClient) {
        return googleApiClient.zzd(new zzsa.zza(googleApiClient) { // from class: com.google.android.gms.internal.zzrz.1
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.internal.zzqc.zza
            public void zza(zzsb zzsbVar) throws RemoteException {
                ((zzsd) zzsbVar.zzatx()).zza(new zza(this));
            }
        });
    }
}
