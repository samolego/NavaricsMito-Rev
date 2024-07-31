package com.google.android.gms.signin.internal;

import android.accounts.Account;
import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Looper;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.auth.api.signin.internal.zzk;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.internal.ResolveAccountRequest;
import com.google.android.gms.common.internal.zzac;
import com.google.android.gms.common.internal.zze;
import com.google.android.gms.common.internal.zzl;
import com.google.android.gms.common.internal.zzr;
import com.google.android.gms.internal.zzwz;
import com.google.android.gms.internal.zzxa;
import com.google.android.gms.signin.internal.zze;

/* loaded from: classes.dex */
public class zzg extends zzl<zze> implements zzwz {

    /* renamed from: Ca */
    private Integer f3408Ca;
    private final boolean aAk;
    private final Bundle aAl;

    /* renamed from: xB */
    private final com.google.android.gms.common.internal.zzh f3409xB;

    public zzg(Context context, Looper looper, boolean z, com.google.android.gms.common.internal.zzh zzhVar, Bundle bundle, GoogleApiClient.ConnectionCallbacks connectionCallbacks, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
        super(context, looper, 44, zzhVar, connectionCallbacks, onConnectionFailedListener);
        this.aAk = z;
        this.f3409xB = zzhVar;
        this.aAl = bundle;
        this.f3408Ca = zzhVar.zzaun();
    }

    public zzg(Context context, Looper looper, boolean z, com.google.android.gms.common.internal.zzh zzhVar, zzxa zzxaVar, GoogleApiClient.ConnectionCallbacks connectionCallbacks, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
        this(context, looper, z, zzhVar, zza(zzhVar), connectionCallbacks, onConnectionFailedListener);
    }

    public static Bundle zza(com.google.android.gms.common.internal.zzh zzhVar) {
        zzxa zzaum = zzhVar.zzaum();
        Integer zzaun = zzhVar.zzaun();
        Bundle bundle = new Bundle();
        bundle.putParcelable("com.google.android.gms.signin.internal.clientRequestedAccount", zzhVar.getAccount());
        if (zzaun != null) {
            bundle.putInt("com.google.android.gms.common.internal.ClientSettings.sessionId", zzaun.intValue());
        }
        if (zzaum != null) {
            bundle.putBoolean("com.google.android.gms.signin.internal.offlineAccessRequested", zzaum.zzcdb());
            bundle.putBoolean("com.google.android.gms.signin.internal.idTokenRequested", zzaum.zzahk());
            bundle.putString("com.google.android.gms.signin.internal.serverClientId", zzaum.zzahn());
            bundle.putBoolean("com.google.android.gms.signin.internal.usePromptModeForAuthCode", true);
            bundle.putBoolean("com.google.android.gms.signin.internal.forceCodeForRefreshToken", zzaum.zzahm());
            bundle.putString("com.google.android.gms.signin.internal.hostedDomain", zzaum.zzaho());
            bundle.putBoolean("com.google.android.gms.signin.internal.waitForAccessTokenRefresh", zzaum.zzcdc());
            if (zzaum.zzcdd() != null) {
                bundle.putLong("com.google.android.gms.signin.internal.authApiSignInModuleVersion", zzaum.zzcdd().longValue());
            }
            if (zzaum.zzcde() != null) {
                bundle.putLong("com.google.android.gms.signin.internal.realClientLibraryVersion", zzaum.zzcde().longValue());
            }
        }
        return bundle;
    }

    private ResolveAccountRequest zzcdj() {
        Account zzatv = this.f3409xB.zzatv();
        return new ResolveAccountRequest(zzatv, this.f3408Ca.intValue(), "<<default account>>".equals(zzatv.name) ? zzk.zzbd(getContext()).zzaic() : null);
    }

    @Override // com.google.android.gms.internal.zzwz
    public void connect() {
        zza(new zze.zzi());
    }

    @Override // com.google.android.gms.internal.zzwz
    public void zza(zzr zzrVar, boolean z) {
        try {
            ((zze) zzatx()).zza(zzrVar, this.f3408Ca.intValue(), z);
        } catch (RemoteException unused) {
            Log.w("SignInClientImpl", "Remote service probably died when saveDefaultAccount is called");
        }
    }

    @Override // com.google.android.gms.internal.zzwz
    public void zza(zzd zzdVar) {
        zzac.zzb(zzdVar, "Expecting a valid ISignInCallbacks");
        try {
            ((zze) zzatx()).zza(new SignInRequest(zzcdj()), zzdVar);
        } catch (RemoteException e) {
            Log.w("SignInClientImpl", "Remote service probably died when signIn is called");
            try {
                zzdVar.zzb(new SignInResponse(8));
            } catch (RemoteException unused) {
                Log.wtf("SignInClientImpl", "ISignInCallbacks#onSignInComplete should be executed from the same process, unexpected RemoteException.", e);
            }
        }
    }

    @Override // com.google.android.gms.common.internal.zze
    protected Bundle zzagl() {
        if (!getContext().getPackageName().equals(this.f3409xB.zzauj())) {
            this.aAl.putString("com.google.android.gms.signin.internal.realClientPackageName", this.f3409xB.zzauj());
        }
        return this.aAl;
    }

    @Override // com.google.android.gms.common.internal.zze, com.google.android.gms.common.api.Api.zze
    public boolean zzahd() {
        return this.aAk;
    }

    @Override // com.google.android.gms.internal.zzwz
    public void zzcda() {
        try {
            ((zze) zzatx()).zzaaf(this.f3408Ca.intValue());
        } catch (RemoteException unused) {
            Log.w("SignInClientImpl", "Remote service probably died when clearAccountFromSessionStore is called");
        }
    }

    @Override // com.google.android.gms.common.internal.zze
    protected String zzix() {
        return "com.google.android.gms.signin.service.START";
    }

    @Override // com.google.android.gms.common.internal.zze
    protected String zziy() {
        return "com.google.android.gms.signin.internal.ISignInService";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.common.internal.zze
    /* renamed from: zzlc */
    public zze zzh(IBinder iBinder) {
        return zze.zza.zzlb(iBinder);
    }
}
