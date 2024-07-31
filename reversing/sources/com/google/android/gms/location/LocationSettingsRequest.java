package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/* loaded from: classes.dex */
public final class LocationSettingsRequest extends AbstractSafeParcelable {
    public static final Parcelable.Creator<LocationSettingsRequest> CREATOR = new zzi();

    /* renamed from: TI */
    private final List<LocationRequest> f3395TI;
    private final boolean ahw;
    private final boolean ahx;
    private final int mVersionCode;

    /* loaded from: classes.dex */
    public static final class Builder {
        private final ArrayList<LocationRequest> ahy = new ArrayList<>();
        private boolean ahw = false;
        private boolean ahx = false;

        public Builder addAllLocationRequests(Collection<LocationRequest> collection) {
            this.ahy.addAll(collection);
            return this;
        }

        public Builder addLocationRequest(LocationRequest locationRequest) {
            this.ahy.add(locationRequest);
            return this;
        }

        public LocationSettingsRequest build() {
            return new LocationSettingsRequest(this.ahy, this.ahw, this.ahx);
        }

        public Builder setAlwaysShow(boolean z) {
            this.ahw = z;
            return this;
        }

        public Builder setNeedBle(boolean z) {
            this.ahx = z;
            return this;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public LocationSettingsRequest(int i, List<LocationRequest> list, boolean z, boolean z2) {
        this.mVersionCode = i;
        this.f3395TI = list;
        this.ahw = z;
        this.ahx = z2;
    }

    private LocationSettingsRequest(List<LocationRequest> list, boolean z, boolean z2) {
        this(3, list, z, z2);
    }

    public int getVersionCode() {
        return this.mVersionCode;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzi.zza(this, parcel, i);
    }

    public List<LocationRequest> zzbgq() {
        return Collections.unmodifiableList(this.f3395TI);
    }

    public boolean zzbph() {
        return this.ahw;
    }

    public boolean zzbpi() {
        return this.ahx;
    }
}
