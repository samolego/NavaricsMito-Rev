package com.google.android.gms.common.internal;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

@Deprecated
/* loaded from: classes.dex */
public class ValidateAccountRequest extends AbstractSafeParcelable {
    public static final Parcelable.Creator<ValidateAccountRequest> CREATOR = new zzak();

    /* renamed from: AW */
    final IBinder f2794AW;

    /* renamed from: AX */
    private final Scope[] f2795AX;

    /* renamed from: De */
    private final int f2796De;

    /* renamed from: Df */
    private final Bundle f2797Df;

    /* renamed from: Dg */
    private final String f2798Dg;
    final int mVersionCode;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ValidateAccountRequest(int i, int i2, IBinder iBinder, Scope[] scopeArr, Bundle bundle, String str) {
        this.mVersionCode = i;
        this.f2796De = i2;
        this.f2794AW = iBinder;
        this.f2795AX = scopeArr;
        this.f2797Df = bundle;
        this.f2798Dg = str;
    }

    public String getCallingPackage() {
        return this.f2798Dg;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzak.zza(this, parcel, i);
    }

    public Scope[] zzavj() {
        return this.f2795AX;
    }

    public int zzavl() {
        return this.f2796De;
    }

    public Bundle zzavm() {
        return this.f2797Df;
    }
}
