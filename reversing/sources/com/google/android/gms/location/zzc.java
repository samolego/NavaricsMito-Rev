package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.location.internal.ClientIdentity;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class zzc implements Parcelable.Creator<ActivityTransitionRequest> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static void zza(ActivityTransitionRequest activityTransitionRequest, Parcel parcel, int i) {
        int zzcr = com.google.android.gms.common.internal.safeparcel.zzb.zzcr(parcel);
        com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 1, activityTransitionRequest.zzbpd(), false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 2, activityTransitionRequest.getTag(), false);
        com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 3, activityTransitionRequest.zzbpe(), false);
        com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 1000, activityTransitionRequest.getVersionCode());
        com.google.android.gms.common.internal.safeparcel.zzb.zzaj(parcel, zzcr);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: zznf */
    public ActivityTransitionRequest createFromParcel(Parcel parcel) {
        int zzcq = com.google.android.gms.common.internal.safeparcel.zza.zzcq(parcel);
        ArrayList arrayList = null;
        int i = 0;
        String str = null;
        ArrayList arrayList2 = null;
        while (parcel.dataPosition() < zzcq) {
            int zzcp = com.google.android.gms.common.internal.safeparcel.zza.zzcp(parcel);
            int zzgv = com.google.android.gms.common.internal.safeparcel.zza.zzgv(zzcp);
            if (zzgv != 1000) {
                switch (zzgv) {
                    case 1:
                        arrayList = com.google.android.gms.common.internal.safeparcel.zza.zzc(parcel, zzcp, ActivityTransition.CREATOR);
                        continue;
                    case 2:
                        str = com.google.android.gms.common.internal.safeparcel.zza.zzq(parcel, zzcp);
                        continue;
                    case 3:
                        arrayList2 = com.google.android.gms.common.internal.safeparcel.zza.zzc(parcel, zzcp, ClientIdentity.CREATOR);
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
            return new ActivityTransitionRequest(i, arrayList, str, arrayList2);
        }
        StringBuilder sb = new StringBuilder(37);
        sb.append("Overread allowed size end=");
        sb.append(zzcq);
        throw new zza.C3234zza(sb.toString(), parcel);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: zztx */
    public ActivityTransitionRequest[] newArray(int i) {
        return new ActivityTransitionRequest[i];
    }
}
