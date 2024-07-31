package com.google.android.gms.internal;

import android.os.Bundle;
import android.os.DeadObjectException;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.zzai;
import com.google.android.gms.internal.zzqc;
import com.google.android.gms.internal.zzqr;

/* loaded from: classes.dex */
public class zzqm implements zzqq {

    /* renamed from: xk */
    private final zzqr f3142xk;

    /* renamed from: xl */
    private boolean f3143xl = false;

    public zzqm(zzqr zzqrVar) {
        this.f3142xk = zzqrVar;
    }

    private <A extends Api.zzb> void zzf(zzqc.zza<? extends Result, A> zzaVar) throws DeadObjectException {
        this.f3142xk.f3220wV.f3205yc.zzb(zzaVar);
        Api.zze zzb = this.f3142xk.f3220wV.zzb((Api.zzc<?>) zzaVar.zzapp());
        if (!zzb.isConnected() && this.f3142xk.f3228yl.containsKey(zzaVar.zzapp())) {
            zzaVar.zzz(new Status(17));
            return;
        }
        boolean z = zzb instanceof zzai;
        Api.zzg zzgVar = zzb;
        if (z) {
            zzgVar = ((zzai) zzb).zzavk();
        }
        zzaVar.zzb((zzqc.zza<? extends Result, A>) zzgVar);
    }

    @Override // com.google.android.gms.internal.zzqq
    public void begin() {
    }

    @Override // com.google.android.gms.internal.zzqq
    public void connect() {
        if (this.f3143xl) {
            this.f3143xl = false;
            this.f3142xk.zza(new zzqr.zza(this) { // from class: com.google.android.gms.internal.zzqm.2
                @Override // com.google.android.gms.internal.zzqr.zza
                public void zzari() {
                    zzqm.this.f3142xk.f3232yp.zzn(null);
                }
            });
        }
    }

    @Override // com.google.android.gms.internal.zzqq
    public boolean disconnect() {
        if (this.f3143xl) {
            return false;
        }
        if (!this.f3142xk.f3220wV.zzaru()) {
            this.f3142xk.zzi(null);
            return true;
        }
        this.f3143xl = true;
        for (zzrp zzrpVar : this.f3142xk.f3220wV.f3204yb) {
            zzrpVar.zzasu();
        }
        return false;
    }

    @Override // com.google.android.gms.internal.zzqq
    public void onConnected(Bundle bundle) {
    }

    @Override // com.google.android.gms.internal.zzqq
    public void onConnectionSuspended(int i) {
        this.f3142xk.zzi(null);
        this.f3142xk.f3232yp.zzc(i, this.f3143xl);
    }

    @Override // com.google.android.gms.internal.zzqq
    public void zza(ConnectionResult connectionResult, Api<?> api, int i) {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void zzarh() {
        if (this.f3143xl) {
            this.f3143xl = false;
            this.f3142xk.f3220wV.f3205yc.release();
            disconnect();
        }
    }

    @Override // com.google.android.gms.internal.zzqq
    public <A extends Api.zzb, R extends Result, T extends zzqc.zza<R, A>> T zzc(T t) {
        return (T) zzd(t);
    }

    @Override // com.google.android.gms.internal.zzqq
    public <A extends Api.zzb, T extends zzqc.zza<? extends Result, A>> T zzd(T t) {
        try {
            zzf(t);
        } catch (DeadObjectException unused) {
            this.f3142xk.zza(new zzqr.zza(this) { // from class: com.google.android.gms.internal.zzqm.1
                @Override // com.google.android.gms.internal.zzqr.zza
                public void zzari() {
                    zzqm.this.onConnectionSuspended(1);
                }
            });
        }
        return t;
    }
}
