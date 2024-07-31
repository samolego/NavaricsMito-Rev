package com.google.android.gms.location.internal;

import android.app.PendingIntent;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;

/* loaded from: classes.dex */
public class zzn implements Parcelable.Creator<LocationRequestUpdateData> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static void zza(LocationRequestUpdateData locationRequestUpdateData, Parcel parcel, int i) {
        int zzcr = com.google.android.gms.common.internal.safeparcel.zzb.zzcr(parcel);
        com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 1, locationRequestUpdateData.aii);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 2, (Parcelable) locationRequestUpdateData.aij, i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 3, locationRequestUpdateData.zzbpn(), false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 4, (Parcelable) locationRequestUpdateData.mPendingIntent, i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 5, locationRequestUpdateData.zzbpo(), false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 6, locationRequestUpdateData.zzbpp(), false);
        com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 1000, locationRequestUpdateData.getVersionCode());
        com.google.android.gms.common.internal.safeparcel.zzb.zzaj(parcel, zzcr);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: zznp */
    public LocationRequestUpdateData createFromParcel(Parcel parcel) {
        int zzcq = com.google.android.gms.common.internal.safeparcel.zza.zzcq(parcel);
        LocationRequestInternal locationRequestInternal = null;
        IBinder iBinder = null;
        PendingIntent pendingIntent = null;
        IBinder iBinder2 = null;
        IBinder iBinder3 = null;
        int i = 0;
        int i2 = 1;
        while (parcel.dataPosition() < zzcq) {
            int zzcp = com.google.android.gms.common.internal.safeparcel.zza.zzcp(parcel);
            int zzgv = com.google.android.gms.common.internal.safeparcel.zza.zzgv(zzcp);
            if (zzgv != 1000) {
                switch (zzgv) {
                    case 1:
                        i2 = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, zzcp);
                        continue;
                    case 2:
                        locationRequestInternal = (LocationRequestInternal) com.google.android.gms.common.internal.safeparcel.zza.zza(parcel, zzcp, LocationRequestInternal.CREATOR);
                        continue;
                    case 3:
                        iBinder = com.google.android.gms.common.internal.safeparcel.zza.zzr(parcel, zzcp);
                        continue;
                    case 4:
                        pendingIntent = (PendingIntent) com.google.android.gms.common.internal.safeparcel.zza.zza(parcel, zzcp, PendingIntent.CREATOR);
                        continue;
                    case 5:
                        iBinder2 = com.google.android.gms.common.internal.safeparcel.zza.zzr(parcel, zzcp);
                        continue;
                    case 6:
                        iBinder3 = com.google.android.gms.common.internal.safeparcel.zza.zzr(parcel, zzcp);
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
            return new LocationRequestUpdateData(i, i2, locationRequestInternal, iBinder, pendingIntent, iBinder2, iBinder3);
        }
        StringBuilder sb = new StringBuilder(37);
        sb.append("Overread allowed size end=");
        sb.append(zzcq);
        throw new zza.C3234zza(sb.toString(), parcel);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: zzup */
    public LocationRequestUpdateData[] newArray(int i) {
        return new LocationRequestUpdateData[i];
    }
}
