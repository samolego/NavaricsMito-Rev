package com.google.android.gms.common.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.zzr;

/* loaded from: classes.dex */
public class ResolveAccountResponse extends AbstractSafeParcelable {
    public static final Parcelable.Creator<ResolveAccountResponse> CREATOR = new zzae();

    /* renamed from: AW */
    IBinder f2787AW;

    /* renamed from: CX */
    private boolean f2788CX;
    final int mVersionCode;

    /* renamed from: vm */
    private ConnectionResult f2789vm;

    /* renamed from: xz */
    private boolean f2790xz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ResolveAccountResponse(int i, IBinder iBinder, ConnectionResult connectionResult, boolean z, boolean z2) {
        this.mVersionCode = i;
        this.f2787AW = iBinder;
        this.f2789vm = connectionResult;
        this.f2790xz = z;
        this.f2788CX = z2;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ResolveAccountResponse) {
            ResolveAccountResponse resolveAccountResponse = (ResolveAccountResponse) obj;
            return this.f2789vm.equals(resolveAccountResponse.f2789vm) && zzavd().equals(resolveAccountResponse.zzavd());
        }
        return false;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzae.zza(this, parcel, i);
    }

    public zzr zzavd() {
        return zzr.zza.zzdr(this.f2787AW);
    }

    public ConnectionResult zzave() {
        return this.f2789vm;
    }

    public boolean zzavf() {
        return this.f2790xz;
    }

    public boolean zzavg() {
        return this.f2788CX;
    }
}
