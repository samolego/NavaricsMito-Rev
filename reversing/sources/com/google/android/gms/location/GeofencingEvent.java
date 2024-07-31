package com.google.android.gms.location;

import android.content.Intent;
import android.location.Location;
import com.google.android.gms.location.internal.ParcelableGeofence;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public class GeofencingEvent {
    private final int ahb;
    private final List<Geofence> ahc;
    private final Location ahd;
    private final int zzcdb;

    private GeofencingEvent(int i, int i2, List<Geofence> list, Location location) {
        this.zzcdb = i;
        this.ahb = i2;
        this.ahc = list;
        this.ahd = location;
    }

    public static GeofencingEvent fromIntent(Intent intent) {
        if (intent == null) {
            return null;
        }
        return new GeofencingEvent(intent.getIntExtra("gms_error_code", -1), zzaa(intent), zzab(intent), (Location) intent.getParcelableExtra("com.google.android.location.intent.extra.triggering_location"));
    }

    private static int zzaa(Intent intent) {
        int intExtra = intent.getIntExtra("com.google.android.location.intent.extra.transition", -1);
        if (intExtra == -1) {
            return -1;
        }
        if (intExtra == 1 || intExtra == 2 || intExtra == 4) {
            return intExtra;
        }
        return -1;
    }

    private static List<Geofence> zzab(Intent intent) {
        ArrayList arrayList = (ArrayList) intent.getSerializableExtra("com.google.android.location.intent.extra.geofence_list");
        if (arrayList == null) {
            return null;
        }
        ArrayList arrayList2 = new ArrayList(arrayList.size());
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            arrayList2.add(ParcelableGeofence.zzv((byte[]) it.next()));
        }
        return arrayList2;
    }

    public int getErrorCode() {
        return this.zzcdb;
    }

    public int getGeofenceTransition() {
        return this.ahb;
    }

    public List<Geofence> getTriggeringGeofences() {
        return this.ahc;
    }

    public Location getTriggeringLocation() {
        return this.ahd;
    }

    public boolean hasError() {
        return this.zzcdb != -1;
    }
}
