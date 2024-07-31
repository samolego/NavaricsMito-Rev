package com.google.android.gms.location.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.location.LocationRequest;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class zzm implements Parcelable.Creator<LocationRequestInternal> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static void zza(LocationRequestInternal locationRequestInternal, Parcel parcel, int i) {
        int zzcr = com.google.android.gms.common.internal.safeparcel.zzb.zzcr(parcel);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 1, (Parcelable) locationRequestInternal.f3398TL, i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 4, locationRequestInternal.agB);
        com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 5, locationRequestInternal.agN, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 6, locationRequestInternal.mTag, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 7, locationRequestInternal.aig);
        com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 1000, locationRequestInternal.getVersionCode());
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 8, locationRequestInternal.aih);
        com.google.android.gms.common.internal.safeparcel.zzb.zzaj(parcel, zzcr);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: zzno */
    public LocationRequestInternal createFromParcel(Parcel parcel) {
        int zzcq = com.google.android.gms.common.internal.safeparcel.zza.zzcq(parcel);
        ArrayList arrayList = LocationRequestInternal.aif;
        LocationRequest locationRequest = null;
        String str = null;
        int i = 0;
        boolean z = true;
        boolean z2 = false;
        boolean z3 = false;
        while (parcel.dataPosition() < zzcq) {
            int zzcp = com.google.android.gms.common.internal.safeparcel.zza.zzcp(parcel);
            int zzgv = com.google.android.gms.common.internal.safeparcel.zza.zzgv(zzcp);
            if (zzgv == 1) {
                locationRequest = (LocationRequest) com.google.android.gms.common.internal.safeparcel.zza.zza(parcel, zzcp, LocationRequest.CREATOR);
            } else if (zzgv != 1000) {
                switch (zzgv) {
                    case 4:
                        z = com.google.android.gms.common.internal.safeparcel.zza.zzc(parcel, zzcp);
                        continue;
                    case 5:
                        arrayList = com.google.android.gms.common.internal.safeparcel.zza.zzc(parcel, zzcp, ClientIdentity.CREATOR);
                        continue;
                    case 6:
                        str = com.google.android.gms.common.internal.safeparcel.zza.zzq(parcel, zzcp);
                        continue;
                    case 7:
                        z2 = com.google.android.gms.common.internal.safeparcel.zza.zzc(parcel, zzcp);
                        continue;
                    case 8:
                        z3 = com.google.android.gms.common.internal.safeparcel.zza.zzc(parcel, zzcp);
                        continue;
                    default:
                        com.google.android.gms.common.internal.safeparcel.zza.zzb(parcel, zzcp);
                        continue;
                }
            } else {
                i = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, zzcp);
            }
        }
        if (parcel.dataPosition() == zzcq) {
            return new LocationRequestInternal(i, locationRequest, z, arrayList, str, z2, z3);
        }
        StringBuilder sb = new StringBuilder(37);
        sb.append("Overread allowed size end=");
        sb.append(zzcq);
        throw new zza.C3234zza(sb.toString(), parcel);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: zzuo */
    public LocationRequestInternal[] newArray(int i) {
        return new LocationRequestInternal[i];
    }
}
