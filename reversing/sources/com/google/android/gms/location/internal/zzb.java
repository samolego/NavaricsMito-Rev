package com.google.android.gms.location.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.IBinder;
import android.os.Looper;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.internal.zzi;

/* loaded from: classes.dex */
public class zzb extends com.google.android.gms.common.internal.zzl<zzi> {
    private final String ahJ;
    protected final zzp<zzi> ahK;

    public zzb(Context context, Looper looper, GoogleApiClient.ConnectionCallbacks connectionCallbacks, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener, String str, com.google.android.gms.common.internal.zzh zzhVar) {
        super(context, looper, 23, zzhVar, connectionCallbacks, onConnectionFailedListener);
        this.ahK = new zzp<zzi>() { // from class: com.google.android.gms.location.internal.zzb.1
            @Override // com.google.android.gms.location.internal.zzp
            public void zzatw() {
                zzb.this.zzatw();
            }

            @Override // com.google.android.gms.location.internal.zzp
            /* renamed from: zzbpj */
            public zzi zzatx() throws DeadObjectException {
                return (zzi) zzb.this.zzatx();
            }
        };
        this.ahJ = str;
    }

    @Override // com.google.android.gms.common.internal.zze
    protected Bundle zzagl() {
        Bundle bundle = new Bundle();
        bundle.putString("client_name", this.ahJ);
        return bundle;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.common.internal.zze
    /* renamed from: zzgz */
    public zzi zzh(IBinder iBinder) {
        return zzi.zza.zzhc(iBinder);
    }

    @Override // com.google.android.gms.common.internal.zze
    protected String zzix() {
        return "com.google.android.location.internal.GoogleLocationManagerService.START";
    }

    @Override // com.google.android.gms.common.internal.zze
    protected String zziy() {
        return "com.google.android.gms.location.internal.IGoogleLocationManagerService";
    }
}
