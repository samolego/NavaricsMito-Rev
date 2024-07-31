package com.google.android.gms.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import com.google.android.gms.common.Scopes;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Scope;

/* loaded from: classes.dex */
public final class zzwy {

    /* renamed from: fa */
    public static final Api.zzf<com.google.android.gms.signin.internal.zzg> f3378fa = new Api.zzf<>();
    public static final Api.zzf<com.google.android.gms.signin.internal.zzg> azY = new Api.zzf<>();

    /* renamed from: fb */
    public static final Api.zza<com.google.android.gms.signin.internal.zzg, zzxa> f3379fb = new Api.zza<com.google.android.gms.signin.internal.zzg, zzxa>() { // from class: com.google.android.gms.internal.zzwy.1
        @Override // com.google.android.gms.common.api.Api.zza
        public com.google.android.gms.signin.internal.zzg zza(Context context, Looper looper, com.google.android.gms.common.internal.zzh zzhVar, zzxa zzxaVar, GoogleApiClient.ConnectionCallbacks connectionCallbacks, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
            if (zzxaVar == null) {
                zzxaVar = zzxa.aAa;
            }
            return new com.google.android.gms.signin.internal.zzg(context, looper, true, zzhVar, zzxaVar, connectionCallbacks, onConnectionFailedListener);
        }
    };
    static final Api.zza<com.google.android.gms.signin.internal.zzg, zza> azZ = new Api.zza<com.google.android.gms.signin.internal.zzg, zza>() { // from class: com.google.android.gms.internal.zzwy.2
        @Override // com.google.android.gms.common.api.Api.zza
        public com.google.android.gms.signin.internal.zzg zza(Context context, Looper looper, com.google.android.gms.common.internal.zzh zzhVar, zza zzaVar, GoogleApiClient.ConnectionCallbacks connectionCallbacks, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
            return new com.google.android.gms.signin.internal.zzg(context, looper, false, zzhVar, zzaVar.zzccz(), connectionCallbacks, onConnectionFailedListener);
        }
    };

    /* renamed from: hd */
    public static final Scope f3380hd = new Scope(Scopes.PROFILE);

    /* renamed from: he */
    public static final Scope f3381he = new Scope("email");
    public static final Api<zzxa> API = new Api<>("SignIn.API", f3379fb, f3378fa);

    /* renamed from: Hp */
    public static final Api<zza> f3377Hp = new Api<>("SignIn.INTERNAL_API", azZ, azY);

    /* loaded from: classes.dex */
    public static class zza implements Api.ApiOptions.HasOptions {
        public Bundle zzccz() {
            return null;
        }
    }
}
