package com.google.android.gms.location.internal;

import android.app.PendingIntent;
import android.os.IBinder;
import android.os.Parcel;
import android.support.annotation.Nullable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.location.internal.zzg;
import com.google.android.gms.location.zzf;
import com.google.android.gms.location.zzg;

/* loaded from: classes.dex */
public class LocationRequestUpdateData extends AbstractSafeParcelable {
    public static final zzn CREATOR = new zzn();
    int aii;
    LocationRequestInternal aij;
    com.google.android.gms.location.zzg aik;
    com.google.android.gms.location.zzf ail;
    zzg aim;
    PendingIntent mPendingIntent;
    private final int mVersionCode;

    /* JADX INFO: Access modifiers changed from: package-private */
    public LocationRequestUpdateData(int i, int i2, LocationRequestInternal locationRequestInternal, IBinder iBinder, PendingIntent pendingIntent, IBinder iBinder2, IBinder iBinder3) {
        this.mVersionCode = i;
        this.aii = i2;
        this.aij = locationRequestInternal;
        this.aik = iBinder == null ? null : zzg.zza.zzgy(iBinder);
        this.mPendingIntent = pendingIntent;
        this.ail = iBinder2 == null ? null : zzf.zza.zzgx(iBinder2);
        this.aim = iBinder3 != null ? zzg.zza.zzha(iBinder3) : null;
    }

    public static LocationRequestUpdateData zza(LocationRequestInternal locationRequestInternal, PendingIntent pendingIntent, @Nullable zzg zzgVar) {
        return new LocationRequestUpdateData(1, 1, locationRequestInternal, null, pendingIntent, null, zzgVar != null ? zzgVar.asBinder() : null);
    }

    public static LocationRequestUpdateData zza(LocationRequestInternal locationRequestInternal, com.google.android.gms.location.zzf zzfVar, @Nullable zzg zzgVar) {
        return new LocationRequestUpdateData(1, 1, locationRequestInternal, null, null, zzfVar.asBinder(), zzgVar != null ? zzgVar.asBinder() : null);
    }

    public static LocationRequestUpdateData zza(LocationRequestInternal locationRequestInternal, com.google.android.gms.location.zzg zzgVar, @Nullable zzg zzgVar2) {
        return new LocationRequestUpdateData(1, 1, locationRequestInternal, zzgVar.asBinder(), null, null, zzgVar2 != null ? zzgVar2.asBinder() : null);
    }

    public static LocationRequestUpdateData zza(com.google.android.gms.location.zzf zzfVar, @Nullable zzg zzgVar) {
        return new LocationRequestUpdateData(1, 2, null, null, null, zzfVar.asBinder(), zzgVar != null ? zzgVar.asBinder() : null);
    }

    public static LocationRequestUpdateData zza(com.google.android.gms.location.zzg zzgVar, @Nullable zzg zzgVar2) {
        return new LocationRequestUpdateData(1, 2, null, zzgVar.asBinder(), null, null, zzgVar2 != null ? zzgVar2.asBinder() : null);
    }

    public static LocationRequestUpdateData zzb(PendingIntent pendingIntent, @Nullable zzg zzgVar) {
        return new LocationRequestUpdateData(1, 2, null, null, pendingIntent, null, zzgVar != null ? zzgVar.asBinder() : null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getVersionCode() {
        return this.mVersionCode;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzn.zza(this, parcel, i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public IBinder zzbpn() {
        com.google.android.gms.location.zzg zzgVar = this.aik;
        if (zzgVar == null) {
            return null;
        }
        return zzgVar.asBinder();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public IBinder zzbpo() {
        com.google.android.gms.location.zzf zzfVar = this.ail;
        if (zzfVar == null) {
            return null;
        }
        return zzfVar.asBinder();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public IBinder zzbpp() {
        zzg zzgVar = this.aim;
        if (zzgVar == null) {
            return null;
        }
        return zzgVar.asBinder();
    }
}
