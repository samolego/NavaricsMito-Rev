package com.google.android.gms.common.internal;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;

/* loaded from: classes.dex */
public class zzai<T extends IInterface> extends zzl<T> {

    /* renamed from: Db */
    private final Api.zzg<T> f2804Db;

    public zzai(Context context, Looper looper, int i, GoogleApiClient.ConnectionCallbacks connectionCallbacks, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener, zzh zzhVar, Api.zzg<T> zzgVar) {
        super(context, looper, i, zzhVar, connectionCallbacks, onConnectionFailedListener);
        this.f2804Db = zzgVar;
    }

    public Api.zzg<T> zzavk() {
        return this.f2804Db;
    }

    @Override // com.google.android.gms.common.internal.zze
    protected void zzc(int i, T t) {
        this.f2804Db.zza(i, t);
    }

    @Override // com.google.android.gms.common.internal.zze
    protected T zzh(IBinder iBinder) {
        return this.f2804Db.zzh(iBinder);
    }

    @Override // com.google.android.gms.common.internal.zze
    protected String zzix() {
        return this.f2804Db.zzix();
    }

    @Override // com.google.android.gms.common.internal.zze
    protected String zziy() {
        return this.f2804Db.zziy();
    }
}
