package com.google.android.gms.internal;

import android.content.Context;
import android.os.Looper;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;

/* loaded from: classes.dex */
public final class zzrx {

    /* renamed from: fa */
    public static final Api.zzf<zzsb> f3349fa = new Api.zzf<>();

    /* renamed from: fb */
    private static final Api.zza<zzsb, Api.ApiOptions.NoOptions> f3350fb = new Api.zza<zzsb, Api.ApiOptions.NoOptions>() { // from class: com.google.android.gms.internal.zzrx.1
        @Override // com.google.android.gms.common.api.Api.zza
        /* renamed from: zzf */
        public zzsb zza(Context context, Looper looper, com.google.android.gms.common.internal.zzh zzhVar, Api.ApiOptions.NoOptions noOptions, GoogleApiClient.ConnectionCallbacks connectionCallbacks, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
            return new zzsb(context, looper, zzhVar, connectionCallbacks, onConnectionFailedListener);
        }
    };
    public static final Api<Api.ApiOptions.NoOptions> API = new Api<>("Common.API", f3350fb, f3349fa);

    /* renamed from: Dh */
    public static final zzry f3348Dh = new zzrz();
}
