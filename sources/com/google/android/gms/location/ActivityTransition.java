package com.google.android.gms.location;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.zzab;

/* loaded from: classes.dex */
public class ActivityTransition extends AbstractSafeParcelable {
    public static final zzb CREATOR = new zzb();

    /* renamed from: OY */
    private final int f3391OY;
    private final int agK;
    private final int mVersionCode;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ActivityTransition(int i, int i2, int i3) {
        this.mVersionCode = i;
        this.f3391OY = i2;
        this.agK = i3;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ActivityTransition) {
            ActivityTransition activityTransition = (ActivityTransition) obj;
            return this.f3391OY == activityTransition.f3391OY && this.agK == activityTransition.agK;
        }
        return false;
    }

    public int getVersionCode() {
        return this.mVersionCode;
    }

    public int hashCode() {
        return zzab.hashCode(Integer.valueOf(this.f3391OY), Integer.valueOf(this.agK));
    }

    public String toString() {
        int i = this.f3391OY;
        int i2 = this.agK;
        StringBuilder sb = new StringBuilder(75);
        sb.append("ActivityTransition [mActivityType=");
        sb.append(i);
        sb.append(", mTransitionType=");
        sb.append(i2);
        sb.append("]");
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzb.zza(this, parcel, i);
    }

    public int zzbeb() {
        return this.f3391OY;
    }

    public int zzbpc() {
        return this.agK;
    }
}
