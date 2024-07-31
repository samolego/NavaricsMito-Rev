package com.google.android.gms.common.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

/* loaded from: classes.dex */
public class SignInButtonConfig extends AbstractSafeParcelable {
    public static final Parcelable.Creator<SignInButtonConfig> CREATOR = new zzaf();
    @Deprecated

    /* renamed from: AX */
    private final Scope[] f2791AX;

    /* renamed from: CY */
    private final int f2792CY;

    /* renamed from: CZ */
    private final int f2793CZ;
    final int mVersionCode;

    /* JADX INFO: Access modifiers changed from: package-private */
    public SignInButtonConfig(int i, int i2, int i3, Scope[] scopeArr) {
        this.mVersionCode = i;
        this.f2792CY = i2;
        this.f2793CZ = i3;
        this.f2791AX = scopeArr;
    }

    public SignInButtonConfig(int i, int i2, Scope[] scopeArr) {
        this(1, i, i2, null);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzaf.zza(this, parcel, i);
    }

    public int zzavh() {
        return this.f2792CY;
    }

    public int zzavi() {
        return this.f2793CZ;
    }

    @Deprecated
    public Scope[] zzavj() {
        return this.f2791AX;
    }
}
