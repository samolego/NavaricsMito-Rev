package com.google.android.gms.location;

import android.content.Intent;
import android.location.Location;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.NonNull;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public final class LocationResult extends AbstractSafeParcelable implements ReflectedParcelable {
    private final List<Location> ahv;
    private final int mVersionCode;
    static final List<Location> ahu = Collections.emptyList();
    public static final Parcelable.Creator<LocationResult> CREATOR = new zzh();

    /* JADX INFO: Access modifiers changed from: package-private */
    public LocationResult(int i, List<Location> list) {
        this.mVersionCode = i;
        this.ahv = list;
    }

    public static LocationResult create(List<Location> list) {
        if (list == null) {
            list = ahu;
        }
        return new LocationResult(2, list);
    }

    public static LocationResult extractResult(Intent intent) {
        if (hasResult(intent)) {
            return (LocationResult) intent.getExtras().getParcelable("com.google.android.gms.location.EXTRA_LOCATION_RESULT");
        }
        return null;
    }

    public static boolean hasResult(Intent intent) {
        if (intent == null) {
            return false;
        }
        return intent.hasExtra("com.google.android.gms.location.EXTRA_LOCATION_RESULT");
    }

    public boolean equals(Object obj) {
        if (obj instanceof LocationResult) {
            LocationResult locationResult = (LocationResult) obj;
            if (locationResult.ahv.size() != this.ahv.size()) {
                return false;
            }
            Iterator<Location> it = locationResult.ahv.iterator();
            Iterator<Location> it2 = this.ahv.iterator();
            while (it.hasNext()) {
                if (it2.next().getTime() != it.next().getTime()) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    public Location getLastLocation() {
        int size = this.ahv.size();
        if (size == 0) {
            return null;
        }
        return this.ahv.get(size - 1);
    }

    @NonNull
    public List<Location> getLocations() {
        return this.ahv;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getVersionCode() {
        return this.mVersionCode;
    }

    public int hashCode() {
        int i = 17;
        for (Location location : this.ahv) {
            long time = location.getTime();
            i = (i * 31) + ((int) (time ^ (time >>> 32)));
        }
        return i;
    }

    public String toString() {
        String valueOf = String.valueOf(this.ahv);
        StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 27);
        sb.append("LocationResult[locations: ");
        sb.append(valueOf);
        sb.append("]");
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzh.zza(this, parcel, i);
    }
}
