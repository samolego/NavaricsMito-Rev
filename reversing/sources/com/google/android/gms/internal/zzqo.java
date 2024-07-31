package com.google.android.gms.internal;

import android.os.Bundle;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.internal.zzqc;
import java.util.Collections;

/* loaded from: classes.dex */
public class zzqo implements zzqq {

    /* renamed from: xk */
    private final zzqr f3184xk;

    public zzqo(zzqr zzqrVar) {
        this.f3184xk = zzqrVar;
    }

    @Override // com.google.android.gms.internal.zzqq
    public void begin() {
        this.f3184xk.zzary();
        this.f3184xk.f3220wV.f3199xX = Collections.emptySet();
    }

    @Override // com.google.android.gms.internal.zzqq
    public void connect() {
        this.f3184xk.zzarw();
    }

    @Override // com.google.android.gms.internal.zzqq
    public boolean disconnect() {
        return true;
    }

    @Override // com.google.android.gms.internal.zzqq
    public void onConnected(Bundle bundle) {
    }

    @Override // com.google.android.gms.internal.zzqq
    public void onConnectionSuspended(int i) {
    }

    @Override // com.google.android.gms.internal.zzqq
    public void zza(ConnectionResult connectionResult, Api<?> api, int i) {
    }

    @Override // com.google.android.gms.internal.zzqq
    public <A extends Api.zzb, R extends Result, T extends zzqc.zza<R, A>> T zzc(T t) {
        this.f3184xk.f3220wV.f3192xQ.add(t);
        return t;
    }

    @Override // com.google.android.gms.internal.zzqq
    public <A extends Api.zzb, T extends zzqc.zza<? extends Result, A>> T zzd(T t) {
        throw new IllegalStateException("GoogleApiClient is not connected yet.");
    }
}
