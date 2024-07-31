package com.google.android.gms.internal;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;

/* loaded from: classes.dex */
public class zzqf implements GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener {

    /* renamed from: tv */
    public final Api<?> f3120tv;

    /* renamed from: wT */
    private final int f3121wT;

    /* renamed from: wU */
    private zzqg f3122wU;

    public zzqf(Api<?> api, int i) {
        this.f3120tv = api;
        this.f3121wT = i;
    }

    private void zzaqx() {
        com.google.android.gms.common.internal.zzac.zzb(this.f3122wU, "Callbacks must be attached to a ClientConnectionHelper instance before connecting the client.");
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks
    public void onConnected(@Nullable Bundle bundle) {
        zzaqx();
        this.f3122wU.onConnected(bundle);
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {
        zzaqx();
        this.f3122wU.zza(connectionResult, this.f3120tv, this.f3121wT);
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks
    public void onConnectionSuspended(int i) {
        zzaqx();
        this.f3122wU.onConnectionSuspended(i);
    }

    public void zza(zzqg zzqgVar) {
        this.f3122wU = zzqgVar;
    }
}
