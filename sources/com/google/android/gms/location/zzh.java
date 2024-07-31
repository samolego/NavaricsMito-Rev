package com.google.android.gms.location;

import android.location.Location;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import java.util.List;

/* loaded from: classes.dex */
public class zzh implements Parcelable.Creator<LocationResult> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static void zza(LocationResult locationResult, Parcel parcel, int i) {
        int zzcr = com.google.android.gms.common.internal.safeparcel.zzb.zzcr(parcel);
        com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 1, locationResult.getLocations(), false);
        com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 1000, locationResult.getVersionCode());
        com.google.android.gms.common.internal.safeparcel.zzb.zzaj(parcel, zzcr);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: zzni */
    public LocationResult createFromParcel(Parcel parcel) {
        int zzcq = com.google.android.gms.common.internal.safeparcel.zza.zzcq(parcel);
        List<Location> list = LocationResult.ahu;
        int i = 0;
        while (parcel.dataPosition() < zzcq) {
            int zzcp = com.google.android.gms.common.internal.safeparcel.zza.zzcp(parcel);
            int zzgv = com.google.android.gms.common.internal.safeparcel.zza.zzgv(zzcp);
            if (zzgv == 1) {
                list = com.google.android.gms.common.internal.safeparcel.zza.zzc(parcel, zzcp, Location.CREATOR);
            } else if (zzgv != 1000) {
                com.google.android.gms.common.internal.safeparcel.zza.zzb(parcel, zzcp);
            } else {
                i = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, zzcp);
            }
        }
        if (parcel.dataPosition() == zzcq) {
            return new LocationResult(i, list);
        }
        StringBuilder sb = new StringBuilder(37);
        sb.append("Overread allowed size end=");
        sb.append(zzcq);
        throw new zza.C3234zza(sb.toString(), parcel);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: zzuf */
    public LocationResult[] newArray(int i) {
        return new LocationResult[i];
    }
}
