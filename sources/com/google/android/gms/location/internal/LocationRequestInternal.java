package com.google.android.gms.location.internal;

import android.os.Parcel;
import android.support.annotation.Nullable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.zzab;
import com.google.android.gms.location.LocationRequest;
import java.util.Collections;
import java.util.List;

/* loaded from: classes.dex */
public class LocationRequestInternal extends AbstractSafeParcelable {

    /* renamed from: TL */
    LocationRequest f3398TL;
    boolean agB;
    List<ClientIdentity> agN;
    boolean aig;
    boolean aih;
    @Nullable
    String mTag;
    private final int mVersionCode;
    static final List<ClientIdentity> aif = Collections.emptyList();
    public static final zzm CREATOR = new zzm();

    /* JADX INFO: Access modifiers changed from: package-private */
    public LocationRequestInternal(int i, LocationRequest locationRequest, boolean z, List<ClientIdentity> list, @Nullable String str, boolean z2, boolean z3) {
        this.mVersionCode = i;
        this.f3398TL = locationRequest;
        this.agB = z;
        this.agN = list;
        this.mTag = str;
        this.aig = z2;
        this.aih = z3;
    }

    public static LocationRequestInternal zza(@Nullable String str, LocationRequest locationRequest) {
        return new LocationRequestInternal(1, locationRequest, true, aif, str, false, false);
    }

    @Deprecated
    public static LocationRequestInternal zzb(LocationRequest locationRequest) {
        return zza(null, locationRequest);
    }

    public boolean equals(Object obj) {
        if (obj instanceof LocationRequestInternal) {
            LocationRequestInternal locationRequestInternal = (LocationRequestInternal) obj;
            return zzab.equal(this.f3398TL, locationRequestInternal.f3398TL) && this.agB == locationRequestInternal.agB && this.aig == locationRequestInternal.aig && zzab.equal(this.agN, locationRequestInternal.agN) && this.aih == locationRequestInternal.aih;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getVersionCode() {
        return this.mVersionCode;
    }

    public int hashCode() {
        return this.f3398TL.hashCode();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.f3398TL.toString());
        if (this.mTag != null) {
            sb.append(" tag=");
            sb.append(this.mTag);
        }
        sb.append(" trigger=");
        sb.append(this.agB);
        sb.append(" hideAppOps=");
        sb.append(this.aig);
        sb.append(" clients=");
        sb.append(this.agN);
        sb.append(" forceCoarseLocation=");
        sb.append(this.aih);
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzm.zza(this, parcel, i);
    }
}
