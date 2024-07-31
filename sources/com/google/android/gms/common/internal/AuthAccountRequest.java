package com.google.android.gms.common.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

/* loaded from: classes.dex */
public class AuthAccountRequest extends AbstractSafeParcelable {
    public static final Parcelable.Creator<AuthAccountRequest> CREATOR = new zzd();

    /* renamed from: AW */
    final IBinder f2767AW;

    /* renamed from: AX */
    final Scope[] f2768AX;

    /* renamed from: AY */
    Integer f2769AY;

    /* renamed from: AZ */
    Integer f2770AZ;
    final int mVersionCode;

    /* JADX INFO: Access modifiers changed from: package-private */
    public AuthAccountRequest(int i, IBinder iBinder, Scope[] scopeArr, Integer num, Integer num2) {
        this.mVersionCode = i;
        this.f2767AW = iBinder;
        this.f2768AX = scopeArr;
        this.f2769AY = num;
        this.f2770AZ = num2;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzd.zza(this, parcel, i);
    }
}
