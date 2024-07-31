package com.google.android.gms.location;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

/* loaded from: classes.dex */
public final class LocationSettingsStates extends AbstractSafeParcelable {
    public static final Parcelable.Creator<LocationSettingsStates> CREATOR = new zzk();
    private final boolean ahA;
    private final boolean ahB;
    private final boolean ahC;
    private final boolean ahD;
    private final boolean ahE;
    private final boolean ahF;
    private final int mVersionCode;

    /* JADX INFO: Access modifiers changed from: package-private */
    public LocationSettingsStates(int i, boolean z, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6) {
        this.mVersionCode = i;
        this.ahA = z;
        this.ahB = z2;
        this.ahC = z3;
        this.ahD = z4;
        this.ahE = z5;
        this.ahF = z6;
    }

    public static LocationSettingsStates fromIntent(Intent intent) {
        return (LocationSettingsStates) com.google.android.gms.common.internal.safeparcel.zzc.zza(intent, "com.google.android.gms.location.LOCATION_SETTINGS_STATES", CREATOR);
    }

    public int getVersionCode() {
        return this.mVersionCode;
    }

    public boolean isBlePresent() {
        return this.ahF;
    }

    public boolean isBleUsable() {
        return this.ahC;
    }

    public boolean isGpsPresent() {
        return this.ahD;
    }

    public boolean isGpsUsable() {
        return this.ahA;
    }

    public boolean isLocationPresent() {
        return this.ahD || this.ahE;
    }

    public boolean isLocationUsable() {
        return this.ahA || this.ahB;
    }

    public boolean isNetworkLocationPresent() {
        return this.ahE;
    }

    public boolean isNetworkLocationUsable() {
        return this.ahB;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzk.zza(this, parcel, i);
    }
}
