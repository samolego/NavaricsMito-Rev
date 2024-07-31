package com.google.android.gms.internal;

import android.os.Bundle;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.internal.zzqc;

/* loaded from: classes.dex */
public interface zzqq {
    void begin();

    void connect();

    boolean disconnect();

    void onConnected(Bundle bundle);

    void onConnectionSuspended(int i);

    void zza(ConnectionResult connectionResult, Api<?> api, int i);

    <A extends Api.zzb, R extends Result, T extends zzqc.zza<R, A>> T zzc(T t);

    <A extends Api.zzb, T extends zzqc.zza<? extends Result, A>> T zzd(T t);
}
