package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.zzr;
import java.util.Collection;

/* loaded from: classes.dex */
public class GetServiceRequest extends AbstractSafeParcelable {
    public static final Parcelable.Creator<GetServiceRequest> CREATOR = new zzk();

    /* renamed from: Ci */
    final int f2776Ci;

    /* renamed from: Cj */
    int f2777Cj;

    /* renamed from: Ck */
    String f2778Ck;

    /* renamed from: Cl */
    IBinder f2779Cl;

    /* renamed from: Cm */
    Scope[] f2780Cm;

    /* renamed from: Cn */
    Bundle f2781Cn;

    /* renamed from: Co */
    Account f2782Co;

    /* renamed from: Cp */
    long f2783Cp;
    final int version;

    public GetServiceRequest(int i) {
        this.version = 3;
        this.f2777Cj = com.google.android.gms.common.zzc.GOOGLE_PLAY_SERVICES_VERSION_CODE;
        this.f2776Ci = i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public GetServiceRequest(int i, int i2, int i3, String str, IBinder iBinder, Scope[] scopeArr, Bundle bundle, Account account, long j) {
        this.version = i;
        this.f2776Ci = i2;
        this.f2777Cj = i3;
        this.f2778Ck = str;
        if (i < 2) {
            this.f2782Co = zzdq(iBinder);
        } else {
            this.f2779Cl = iBinder;
            this.f2782Co = account;
        }
        this.f2780Cm = scopeArr;
        this.f2781Cn = bundle;
        this.f2783Cp = j;
    }

    private Account zzdq(IBinder iBinder) {
        if (iBinder != null) {
            return zza.zza(zzr.zza.zzdr(iBinder));
        }
        return null;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzk.zza(this, parcel, i);
    }

    public GetServiceRequest zzb(zzr zzrVar) {
        if (zzrVar != null) {
            this.f2779Cl = zzrVar.asBinder();
        }
        return this;
    }

    public GetServiceRequest zzd(Account account) {
        this.f2782Co = account;
        return this;
    }

    public GetServiceRequest zzf(Collection<Scope> collection) {
        this.f2780Cm = (Scope[]) collection.toArray(new Scope[collection.size()]);
        return this;
    }

    public GetServiceRequest zzht(String str) {
        this.f2778Ck = str;
        return this;
    }

    public GetServiceRequest zzo(Bundle bundle) {
        this.f2781Cn = bundle;
        return this;
    }
}
