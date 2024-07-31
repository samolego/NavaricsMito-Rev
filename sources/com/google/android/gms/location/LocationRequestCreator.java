package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;

/* loaded from: classes.dex */
public class LocationRequestCreator implements Parcelable.Creator<LocationRequest> {
    public static final int CONTENT_DESCRIPTION = 0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void zza(LocationRequest locationRequest, Parcel parcel, int i) {
        int zzcr = com.google.android.gms.common.internal.safeparcel.zzb.zzcr(parcel);
        com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 1, locationRequest.mPriority);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 2, locationRequest.ahp);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 3, locationRequest.ahq);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 4, locationRequest.f3392TN);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 5, locationRequest.agU);
        com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 6, locationRequest.ahr);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 7, locationRequest.ahs);
        com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 1000, locationRequest.getVersionCode());
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 8, locationRequest.aht);
        com.google.android.gms.common.internal.safeparcel.zzb.zzaj(parcel, zzcr);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // android.os.Parcelable.Creator
    public LocationRequest createFromParcel(Parcel parcel) {
        int zzcq = com.google.android.gms.common.internal.safeparcel.zza.zzcq(parcel);
        long j = 3600000;
        long j2 = 600000;
        long j3 = Long.MAX_VALUE;
        long j4 = 0;
        int i = 0;
        int i2 = 102;
        boolean z = false;
        int i3 = Integer.MAX_VALUE;
        float f = 0.0f;
        while (parcel.dataPosition() < zzcq) {
            int zzcp = com.google.android.gms.common.internal.safeparcel.zza.zzcp(parcel);
            int zzgv = com.google.android.gms.common.internal.safeparcel.zza.zzgv(zzcp);
            if (zzgv != 1000) {
                switch (zzgv) {
                    case 1:
                        i2 = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, zzcp);
                        continue;
                    case 2:
                        j = com.google.android.gms.common.internal.safeparcel.zza.zzi(parcel, zzcp);
                        continue;
                    case 3:
                        j2 = com.google.android.gms.common.internal.safeparcel.zza.zzi(parcel, zzcp);
                        continue;
                    case 4:
                        z = com.google.android.gms.common.internal.safeparcel.zza.zzc(parcel, zzcp);
                        continue;
                    case 5:
                        j3 = com.google.android.gms.common.internal.safeparcel.zza.zzi(parcel, zzcp);
                        continue;
                    case 6:
                        i3 = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, zzcp);
                        continue;
                    case 7:
                        f = com.google.android.gms.common.internal.safeparcel.zza.zzl(parcel, zzcp);
                        continue;
                    case 8:
                        j4 = com.google.android.gms.common.internal.safeparcel.zza.zzi(parcel, zzcp);
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
            return new LocationRequest(i, i2, j, j2, z, j3, i3, f, j4);
        }
        StringBuilder sb = new StringBuilder(37);
        sb.append("Overread allowed size end=");
        sb.append(zzcq);
        throw new zza.C3234zza(sb.toString(), parcel);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // android.os.Parcelable.Creator
    public LocationRequest[] newArray(int i) {
        return new LocationRequest[i];
    }
}
