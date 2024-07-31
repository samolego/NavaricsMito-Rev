package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class zzi implements Parcelable.Creator<LocationSettingsRequest> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static void zza(LocationSettingsRequest locationSettingsRequest, Parcel parcel, int i) {
        int zzcr = com.google.android.gms.common.internal.safeparcel.zzb.zzcr(parcel);
        com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 1, locationSettingsRequest.zzbgq(), false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 2, locationSettingsRequest.zzbph());
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 3, locationSettingsRequest.zzbpi());
        com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 1000, locationSettingsRequest.getVersionCode());
        com.google.android.gms.common.internal.safeparcel.zzb.zzaj(parcel, zzcr);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: zznj */
    public LocationSettingsRequest createFromParcel(Parcel parcel) {
        int zzcq = com.google.android.gms.common.internal.safeparcel.zza.zzcq(parcel);
        int i = 0;
        ArrayList arrayList = null;
        boolean z = false;
        boolean z2 = false;
        while (parcel.dataPosition() < zzcq) {
            int zzcp = com.google.android.gms.common.internal.safeparcel.zza.zzcp(parcel);
            int zzgv = com.google.android.gms.common.internal.safeparcel.zza.zzgv(zzcp);
            if (zzgv != 1000) {
                switch (zzgv) {
                    case 1:
                        arrayList = com.google.android.gms.common.internal.safeparcel.zza.zzc(parcel, zzcp, LocationRequest.CREATOR);
                        continue;
                    case 2:
                        z = com.google.android.gms.common.internal.safeparcel.zza.zzc(parcel, zzcp);
                        continue;
                    case 3:
                        z2 = com.google.android.gms.common.internal.safeparcel.zza.zzc(parcel, zzcp);
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
            return new LocationSettingsRequest(i, arrayList, z, z2);
        }
        StringBuilder sb = new StringBuilder(37);
        sb.append("Overread allowed size end=");
        sb.append(zzcq);
        throw new zza.C3234zza(sb.toString(), parcel);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: zzug */
    public LocationSettingsRequest[] newArray(int i) {
        return new LocationSettingsRequest[i];
    }
}
