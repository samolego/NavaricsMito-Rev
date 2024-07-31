package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.WorkSource;
import com.google.android.gms.common.internal.safeparcel.zza;

/* loaded from: classes.dex */
public class zza implements Parcelable.Creator<ActivityRecognitionRequest> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static void zza(ActivityRecognitionRequest activityRecognitionRequest, Parcel parcel, int i) {
        int zzcr = com.google.android.gms.common.internal.safeparcel.zzb.zzcr(parcel);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 1, activityRecognitionRequest.getIntervalMillis());
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 2, activityRecognitionRequest.zzbox());
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 3, (Parcelable) activityRecognitionRequest.zzboy(), i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 4, activityRecognitionRequest.getTag(), false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 5, activityRecognitionRequest.zzboz(), false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 6, activityRecognitionRequest.zzbpa());
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 7, activityRecognitionRequest.getAccountName(), false);
        com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 1000, activityRecognitionRequest.getVersionCode());
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 8, activityRecognitionRequest.zzbpb());
        com.google.android.gms.common.internal.safeparcel.zzb.zzaj(parcel, zzcr);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: zznd */
    public ActivityRecognitionRequest createFromParcel(Parcel parcel) {
        int zzcq = com.google.android.gms.common.internal.safeparcel.zza.zzcq(parcel);
        long j = 0;
        long j2 = 0;
        WorkSource workSource = null;
        String str = null;
        int[] iArr = null;
        String str2 = null;
        int i = 0;
        boolean z = false;
        boolean z2 = false;
        while (parcel.dataPosition() < zzcq) {
            int zzcp = com.google.android.gms.common.internal.safeparcel.zza.zzcp(parcel);
            int zzgv = com.google.android.gms.common.internal.safeparcel.zza.zzgv(zzcp);
            if (zzgv != 1000) {
                switch (zzgv) {
                    case 1:
                        j = com.google.android.gms.common.internal.safeparcel.zza.zzi(parcel, zzcp);
                        continue;
                    case 2:
                        z = com.google.android.gms.common.internal.safeparcel.zza.zzc(parcel, zzcp);
                        continue;
                    case 3:
                        workSource = (WorkSource) com.google.android.gms.common.internal.safeparcel.zza.zza(parcel, zzcp, WorkSource.CREATOR);
                        continue;
                    case 4:
                        str = com.google.android.gms.common.internal.safeparcel.zza.zzq(parcel, zzcp);
                        continue;
                    case 5:
                        iArr = com.google.android.gms.common.internal.safeparcel.zza.zzw(parcel, zzcp);
                        continue;
                    case 6:
                        z2 = com.google.android.gms.common.internal.safeparcel.zza.zzc(parcel, zzcp);
                        continue;
                    case 7:
                        str2 = com.google.android.gms.common.internal.safeparcel.zza.zzq(parcel, zzcp);
                        continue;
                    case 8:
                        j2 = com.google.android.gms.common.internal.safeparcel.zza.zzi(parcel, zzcp);
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
            return new ActivityRecognitionRequest(i, j, z, workSource, str, iArr, z2, str2, j2);
        }
        StringBuilder sb = new StringBuilder(37);
        sb.append("Overread allowed size end=");
        sb.append(zzcq);
        throw new zza.C3234zza(sb.toString(), parcel);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: zztv */
    public ActivityRecognitionRequest[] newArray(int i) {
        return new ActivityRecognitionRequest[i];
    }
}
