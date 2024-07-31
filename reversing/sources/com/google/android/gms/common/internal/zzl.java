package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.content.Context;
import android.os.Bundle;
import android.os.IInterface;
import android.os.Looper;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.zze;
import com.google.android.gms.common.internal.zzm;
import java.util.Set;

/* loaded from: classes.dex */
public abstract class zzl<T extends IInterface> extends zze<T> implements Api.zze, zzm.zza {

    /* renamed from: ec */
    private final Account f2877ec;

    /* renamed from: hm */
    private final Set<Scope> f2878hm;

    /* renamed from: xB */
    private final zzh f2879xB;

    /* JADX INFO: Access modifiers changed from: protected */
    public zzl(Context context, Looper looper, int i, zzh zzhVar, GoogleApiClient.ConnectionCallbacks connectionCallbacks, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
        this(context, looper, zzn.zzcf(context), GoogleApiAvailability.getInstance(), i, zzhVar, (GoogleApiClient.ConnectionCallbacks) zzac.zzy(connectionCallbacks), (GoogleApiClient.OnConnectionFailedListener) zzac.zzy(onConnectionFailedListener));
    }

    protected zzl(Context context, Looper looper, zzn zznVar, GoogleApiAvailability googleApiAvailability, int i, zzh zzhVar, GoogleApiClient.ConnectionCallbacks connectionCallbacks, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
        super(context, looper, zznVar, googleApiAvailability, i, zza(connectionCallbacks), zza(onConnectionFailedListener), zzhVar.zzauk());
        this.f2879xB = zzhVar;
        this.f2877ec = zzhVar.getAccount();
        this.f2878hm = zzb(zzhVar.zzauh());
    }

    @Nullable
    private static zze.zzb zza(final GoogleApiClient.ConnectionCallbacks connectionCallbacks) {
        if (connectionCallbacks == null) {
            return null;
        }
        return new zze.zzb() { // from class: com.google.android.gms.common.internal.zzl.1
            @Override // com.google.android.gms.common.internal.zze.zzb
            public void onConnected(@Nullable Bundle bundle) {
                GoogleApiClient.ConnectionCallbacks.this.onConnected(bundle);
            }

            @Override // com.google.android.gms.common.internal.zze.zzb
            public void onConnectionSuspended(int i) {
                GoogleApiClient.ConnectionCallbacks.this.onConnectionSuspended(i);
            }
        };
    }

    @Nullable
    private static zze.zzc zza(final GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
        if (onConnectionFailedListener == null) {
            return null;
        }
        return new zze.zzc() { // from class: com.google.android.gms.common.internal.zzl.2
            @Override // com.google.android.gms.common.internal.zze.zzc
            public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {
                GoogleApiClient.OnConnectionFailedListener.this.onConnectionFailed(connectionResult);
            }
        };
    }

    private Set<Scope> zzb(@NonNull Set<Scope> set) {
        Set<Scope> zzc = zzc(set);
        for (Scope scope : zzc) {
            if (!set.contains(scope)) {
                throw new IllegalStateException("Expanding scopes is not permitted, use implied scopes instead");
            }
        }
        return zzc;
    }

    @Override // com.google.android.gms.common.internal.zze
    public final Account getAccount() {
        return this.f2877ec;
    }

    @Override // com.google.android.gms.common.internal.zze
    protected final Set<Scope> zzatz() {
        return this.f2878hm;
    }

    protected final zzh zzaus() {
        return this.f2879xB;
    }

    @NonNull
    protected Set<Scope> zzc(@NonNull Set<Scope> set) {
        return set;
    }
}
