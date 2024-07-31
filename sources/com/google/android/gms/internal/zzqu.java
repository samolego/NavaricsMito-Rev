package com.google.android.gms.internal;

import android.os.Looper;
import android.support.annotation.NonNull;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.ApiOptions;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.internal.zzqc;

/* loaded from: classes.dex */
public class zzqu<O extends Api.ApiOptions> extends zzql {

    /* renamed from: yN */
    private final com.google.android.gms.common.api.zzd<O> f3270yN;

    public zzqu(com.google.android.gms.common.api.zzd<O> zzdVar) {
        super("Method is not supported by connectionless client. APIs supporting connectionless client must not call this method.");
        this.f3270yN = zzdVar;
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public Looper getLooper() {
        return this.f3270yN.getLooper();
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public void zza(zzrp zzrpVar) {
        this.f3270yN.zzapu();
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public void zzb(zzrp zzrpVar) {
        this.f3270yN.zzapv();
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public <A extends Api.zzb, R extends Result, T extends zzqc.zza<R, A>> T zzc(@NonNull T t) {
        return (T) this.f3270yN.zza((com.google.android.gms.common.api.zzd<O>) t);
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public <A extends Api.zzb, T extends zzqc.zza<? extends Result, A>> T zzd(@NonNull T t) {
        return (T) this.f3270yN.zzb((com.google.android.gms.common.api.zzd<O>) t);
    }
}
