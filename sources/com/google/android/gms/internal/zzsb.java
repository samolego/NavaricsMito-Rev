package com.google.android.gms.internal;

import android.content.Context;
import android.os.IBinder;
import android.os.Looper;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.internal.zzsd;

/* loaded from: classes.dex */
public class zzsb extends com.google.android.gms.common.internal.zzl<zzsd> {
    public zzsb(Context context, Looper looper, com.google.android.gms.common.internal.zzh zzhVar, GoogleApiClient.ConnectionCallbacks connectionCallbacks, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
        super(context, looper, 39, zzhVar, connectionCallbacks, onConnectionFailedListener);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.common.internal.zze
    /* renamed from: zzea */
    public zzsd zzh(IBinder iBinder) {
        return zzsd.zza.zzec(iBinder);
    }

    @Override // com.google.android.gms.common.internal.zze
    public String zzix() {
        return "com.google.android.gms.common.service.START";
    }

    @Override // com.google.android.gms.common.internal.zze
    protected String zziy() {
        return "com.google.android.gms.common.internal.service.ICommonService";
    }
}
