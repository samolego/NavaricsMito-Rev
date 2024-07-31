package com.google.android.gms.location.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;

/* loaded from: classes.dex */
public class zzo implements Parcelable.Creator<ParcelableGeofence> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static void zza(ParcelableGeofence parcelableGeofence, Parcel parcel, int i) {
        int zzcr = com.google.android.gms.common.internal.safeparcel.zzb.zzcr(parcel);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 1, parcelableGeofence.getRequestId(), false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 2, parcelableGeofence.getExpirationTime());
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 3, parcelableGeofence.zzbpq());
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 4, parcelableGeofence.getLatitude());
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 5, parcelableGeofence.getLongitude());
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 6, parcelableGeofence.getRadius());
        com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 7, parcelableGeofence.zzbpr());
        com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 1000, parcelableGeofence.getVersionCode());
        com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 8, parcelableGeofence.zzbps());
        com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 9, parcelableGeofence.zzbpt());
        com.google.android.gms.common.internal.safeparcel.zzb.zzaj(parcel, zzcr);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: zznq */
    public ParcelableGeofence createFromParcel(Parcel parcel) {
        int zzcq = com.google.android.gms.common.internal.safeparcel.zza.zzcq(parcel);
        double d = 0.0d;
        double d2 = 0.0d;
        String str = null;
        long j = 0;
        int i = 0;
        int i2 = 0;
        short s = 0;
        float f = 0.0f;
        int i3 = 0;
        int i4 = -1;
        while (parcel.dataPosition() < zzcq) {
            int zzcp = com.google.android.gms.common.internal.safeparcel.zza.zzcp(parcel);
            int zzgv = com.google.android.gms.common.internal.safeparcel.zza.zzgv(zzcp);
            if (zzgv != 1000) {
                switch (zzgv) {
                    case 1:
                        str = com.google.android.gms.common.internal.safeparcel.zza.zzq(parcel, zzcp);
                        continue;
                    case 2:
                        j = com.google.android.gms.common.internal.safeparcel.zza.zzi(parcel, zzcp);
                        continue;
                    case 3:
                        s = com.google.android.gms.common.internal.safeparcel.zza.zzf(parcel, zzcp);
                        continue;
                    case 4:
                        d = com.google.android.gms.common.internal.safeparcel.zza.zzn(parcel, zzcp);
                        continue;
                    case 5:
                        d2 = com.google.android.gms.common.internal.safeparcel.zza.zzn(parcel, zzcp);
                        continue;
                    case 6:
                        f = com.google.android.gms.common.internal.safeparcel.zza.zzl(parcel, zzcp);
                        continue;
                    case 7:
                        i2 = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, zzcp);
                        continue;
                    case 8:
                        i3 = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, zzcp);
                        continue;
                    case 9:
                        i4 = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, zzcp);
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
            return new ParcelableGeofence(i, str, i2, s, d, d2, f, j, i3, i4);
        }
        StringBuilder sb = new StringBuilder(37);
        sb.append("Overread allowed size end=");
        sb.append(zzcq);
        throw new zza.C3234zza(sb.toString(), parcel);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: zzus */
    public ParcelableGeofence[] newArray(int i) {
        return new ParcelableGeofence[i];
    }
}
