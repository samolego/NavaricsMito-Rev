package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.zzac;
import com.google.android.gms.location.internal.ParcelableGeofence;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class GeofencingRequest extends AbstractSafeParcelable {
    public static final Parcelable.Creator<GeofencingRequest> CREATOR = new zzd();
    public static final int INITIAL_TRIGGER_DWELL = 4;
    public static final int INITIAL_TRIGGER_ENTER = 1;
    public static final int INITIAL_TRIGGER_EXIT = 2;
    private final List<ParcelableGeofence> ahe;
    private final int ahf;
    private final int mVersionCode;

    /* loaded from: classes.dex */
    public static final class Builder {
        private final List<ParcelableGeofence> ahe = new ArrayList();
        private int ahf = 5;

        public static int zzua(int i) {
            return i & 7;
        }

        public Builder addGeofence(Geofence geofence) {
            zzac.zzb(geofence, "geofence can't be null.");
            zzac.zzb(geofence instanceof ParcelableGeofence, "Geofence must be created using Geofence.Builder.");
            this.ahe.add((ParcelableGeofence) geofence);
            return this;
        }

        public Builder addGeofences(List<Geofence> list) {
            if (list != null && !list.isEmpty()) {
                for (Geofence geofence : list) {
                    if (geofence != null) {
                        addGeofence(geofence);
                    }
                }
            }
            return this;
        }

        public GeofencingRequest build() {
            zzac.zzb(!this.ahe.isEmpty(), "No geofence has been added to this request.");
            return new GeofencingRequest(this.ahe, this.ahf);
        }

        public Builder setInitialTrigger(int i) {
            this.ahf = zzua(i);
            return this;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public GeofencingRequest(int i, List<ParcelableGeofence> list, int i2) {
        this.mVersionCode = i;
        this.ahe = list;
        this.ahf = i2;
    }

    private GeofencingRequest(List<ParcelableGeofence> list, int i) {
        this(1, list, i);
    }

    public List<Geofence> getGeofences() {
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(this.ahe);
        return arrayList;
    }

    public int getInitialTrigger() {
        return this.ahf;
    }

    public int getVersionCode() {
        return this.mVersionCode;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzd.zza(this, parcel, i);
    }

    public List<ParcelableGeofence> zzbpf() {
        return this.ahe;
    }
}
