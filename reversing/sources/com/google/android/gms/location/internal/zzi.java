package com.google.android.gms.location.internal;

import android.app.PendingIntent;
import android.location.Location;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.internal.zzqx;
import com.google.android.gms.location.ActivityRecognitionRequest;
import com.google.android.gms.location.ActivityRecognitionResult;
import com.google.android.gms.location.ActivityTransitionRequest;
import com.google.android.gms.location.GeofencingRequest;
import com.google.android.gms.location.GestureRequest;
import com.google.android.gms.location.LocationAvailability;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationSettingsRequest;
import com.google.android.gms.location.internal.zzg;
import com.google.android.gms.location.internal.zzh;
import com.google.android.gms.location.internal.zzj;
import com.google.android.gms.location.zzg;
import java.util.List;

/* loaded from: classes.dex */
public interface zzi extends IInterface {

    /* loaded from: classes.dex */
    public static abstract class zza extends Binder implements zzi {

        /* renamed from: com.google.android.gms.location.internal.zzi$zza$zza  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        private static class C3264zza implements zzi {
            private IBinder zzajf;

            C3264zza(IBinder iBinder) {
                this.zzajf = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.zzajf;
            }

            @Override // com.google.android.gms.location.internal.zzi
            public void zza(long j, boolean z, PendingIntent pendingIntent) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    obtain.writeLong(j);
                    obtain.writeInt(z ? 1 : 0);
                    if (pendingIntent != null) {
                        obtain.writeInt(1);
                        pendingIntent.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zzajf.transact(5, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.location.internal.zzi
            public void zza(PendingIntent pendingIntent, zzqx zzqxVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    if (pendingIntent != null) {
                        obtain.writeInt(1);
                        pendingIntent.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(zzqxVar != null ? zzqxVar.asBinder() : null);
                    this.zzajf.transact(73, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.location.internal.zzi
            public void zza(PendingIntent pendingIntent, zzh zzhVar, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    if (pendingIntent != null) {
                        obtain.writeInt(1);
                        pendingIntent.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(zzhVar != null ? zzhVar.asBinder() : null);
                    obtain.writeString(str);
                    this.zzajf.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.location.internal.zzi
            public void zza(Location location, int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    if (location != null) {
                        obtain.writeInt(1);
                        location.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeInt(i);
                    this.zzajf.transact(26, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.location.internal.zzi
            public void zza(zzqx zzqxVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    obtain.writeStrongBinder(zzqxVar != null ? zzqxVar.asBinder() : null);
                    this.zzajf.transact(71, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.location.internal.zzi
            public void zza(ActivityRecognitionRequest activityRecognitionRequest, PendingIntent pendingIntent, zzqx zzqxVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    if (activityRecognitionRequest != null) {
                        obtain.writeInt(1);
                        activityRecognitionRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (pendingIntent != null) {
                        obtain.writeInt(1);
                        pendingIntent.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(zzqxVar != null ? zzqxVar.asBinder() : null);
                    this.zzajf.transact(70, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.location.internal.zzi
            public void zza(ActivityTransitionRequest activityTransitionRequest, PendingIntent pendingIntent, zzqx zzqxVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    if (activityTransitionRequest != null) {
                        obtain.writeInt(1);
                        activityTransitionRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (pendingIntent != null) {
                        obtain.writeInt(1);
                        pendingIntent.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(zzqxVar != null ? zzqxVar.asBinder() : null);
                    this.zzajf.transact(72, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.location.internal.zzi
            public void zza(GeofencingRequest geofencingRequest, PendingIntent pendingIntent, zzh zzhVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    if (geofencingRequest != null) {
                        obtain.writeInt(1);
                        geofencingRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (pendingIntent != null) {
                        obtain.writeInt(1);
                        pendingIntent.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(zzhVar != null ? zzhVar.asBinder() : null);
                    this.zzajf.transact(57, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.location.internal.zzi
            public void zza(GestureRequest gestureRequest, PendingIntent pendingIntent, zzqx zzqxVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    if (gestureRequest != null) {
                        obtain.writeInt(1);
                        gestureRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (pendingIntent != null) {
                        obtain.writeInt(1);
                        pendingIntent.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(zzqxVar != null ? zzqxVar.asBinder() : null);
                    this.zzajf.transact(60, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.location.internal.zzi
            public void zza(LocationRequest locationRequest, PendingIntent pendingIntent) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    if (locationRequest != null) {
                        obtain.writeInt(1);
                        locationRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (pendingIntent != null) {
                        obtain.writeInt(1);
                        pendingIntent.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zzajf.transact(9, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.location.internal.zzi
            public void zza(LocationRequest locationRequest, com.google.android.gms.location.zzg zzgVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    if (locationRequest != null) {
                        obtain.writeInt(1);
                        locationRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(zzgVar != null ? zzgVar.asBinder() : null);
                    this.zzajf.transact(8, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.location.internal.zzi
            public void zza(LocationRequest locationRequest, com.google.android.gms.location.zzg zzgVar, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    if (locationRequest != null) {
                        obtain.writeInt(1);
                        locationRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(zzgVar != null ? zzgVar.asBinder() : null);
                    obtain.writeString(str);
                    this.zzajf.transact(20, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.location.internal.zzi
            public void zza(LocationSettingsRequest locationSettingsRequest, zzj zzjVar, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    if (locationSettingsRequest != null) {
                        obtain.writeInt(1);
                        locationSettingsRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(zzjVar != null ? zzjVar.asBinder() : null);
                    obtain.writeString(str);
                    this.zzajf.transact(63, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.location.internal.zzi
            public void zza(LocationRequestInternal locationRequestInternal, PendingIntent pendingIntent) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    if (locationRequestInternal != null) {
                        obtain.writeInt(1);
                        locationRequestInternal.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (pendingIntent != null) {
                        obtain.writeInt(1);
                        pendingIntent.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zzajf.transact(53, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.location.internal.zzi
            public void zza(LocationRequestInternal locationRequestInternal, com.google.android.gms.location.zzg zzgVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    if (locationRequestInternal != null) {
                        obtain.writeInt(1);
                        locationRequestInternal.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(zzgVar != null ? zzgVar.asBinder() : null);
                    this.zzajf.transact(52, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.location.internal.zzi
            public void zza(LocationRequestUpdateData locationRequestUpdateData) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    if (locationRequestUpdateData != null) {
                        obtain.writeInt(1);
                        locationRequestUpdateData.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zzajf.transact(59, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.location.internal.zzi
            public void zza(zzg zzgVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    obtain.writeStrongBinder(zzgVar != null ? zzgVar.asBinder() : null);
                    this.zzajf.transact(67, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.location.internal.zzi
            public void zza(zzh zzhVar, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    obtain.writeStrongBinder(zzhVar != null ? zzhVar.asBinder() : null);
                    obtain.writeString(str);
                    this.zzajf.transact(4, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.location.internal.zzi
            public void zza(com.google.android.gms.location.zzg zzgVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    obtain.writeStrongBinder(zzgVar != null ? zzgVar.asBinder() : null);
                    this.zzajf.transact(10, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.location.internal.zzi
            public void zza(List<ParcelableGeofence> list, PendingIntent pendingIntent, zzh zzhVar, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    obtain.writeTypedList(list);
                    if (pendingIntent != null) {
                        obtain.writeInt(1);
                        pendingIntent.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(zzhVar != null ? zzhVar.asBinder() : null);
                    obtain.writeString(str);
                    this.zzajf.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.location.internal.zzi
            public void zza(String[] strArr, zzh zzhVar, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    obtain.writeStringArray(strArr);
                    obtain.writeStrongBinder(zzhVar != null ? zzhVar.asBinder() : null);
                    obtain.writeString(str);
                    this.zzajf.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.location.internal.zzi
            public void zzb(PendingIntent pendingIntent) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    if (pendingIntent != null) {
                        obtain.writeInt(1);
                        pendingIntent.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zzajf.transact(6, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.location.internal.zzi
            public void zzb(PendingIntent pendingIntent, zzqx zzqxVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    if (pendingIntent != null) {
                        obtain.writeInt(1);
                        pendingIntent.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(zzqxVar != null ? zzqxVar.asBinder() : null);
                    this.zzajf.transact(65, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.location.internal.zzi
            public Location zzbpk() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    this.zzajf.transact(7, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt() != 0 ? (Location) Location.CREATOR.createFromParcel(obtain2) : null;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.location.internal.zzi
            public void zzc(PendingIntent pendingIntent) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    if (pendingIntent != null) {
                        obtain.writeInt(1);
                        pendingIntent.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zzajf.transact(11, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.location.internal.zzi
            public void zzc(PendingIntent pendingIntent, zzqx zzqxVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    if (pendingIntent != null) {
                        obtain.writeInt(1);
                        pendingIntent.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(zzqxVar != null ? zzqxVar.asBinder() : null);
                    this.zzajf.transact(66, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.location.internal.zzi
            public void zzcc(boolean z) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    obtain.writeInt(z ? 1 : 0);
                    this.zzajf.transact(12, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.location.internal.zzi
            public void zzd(PendingIntent pendingIntent, zzqx zzqxVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    if (pendingIntent != null) {
                        obtain.writeInt(1);
                        pendingIntent.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(zzqxVar != null ? zzqxVar.asBinder() : null);
                    this.zzajf.transact(61, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.location.internal.zzi
            public void zzd(Location location) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    if (location != null) {
                        obtain.writeInt(1);
                        location.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zzajf.transact(13, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.location.internal.zzi
            public void zze(PendingIntent pendingIntent, zzqx zzqxVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    if (pendingIntent != null) {
                        obtain.writeInt(1);
                        pendingIntent.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(zzqxVar != null ? zzqxVar.asBinder() : null);
                    this.zzajf.transact(68, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.location.internal.zzi
            public void zzf(PendingIntent pendingIntent, zzqx zzqxVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    if (pendingIntent != null) {
                        obtain.writeInt(1);
                        pendingIntent.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(zzqxVar != null ? zzqxVar.asBinder() : null);
                    this.zzajf.transact(69, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.location.internal.zzi
            public ActivityRecognitionResult zzkw(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    obtain.writeString(str);
                    this.zzajf.transact(64, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt() != 0 ? (ActivityRecognitionResult) ActivityRecognitionResult.CREATOR.createFromParcel(obtain2) : null;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.location.internal.zzi
            public Location zzkx(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    obtain.writeString(str);
                    this.zzajf.transact(21, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt() != 0 ? (Location) Location.CREATOR.createFromParcel(obtain2) : null;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.location.internal.zzi
            public LocationAvailability zzky(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    obtain.writeString(str);
                    this.zzajf.transact(34, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt() != 0 ? (LocationAvailability) LocationAvailability.CREATOR.createFromParcel(obtain2) : null;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public static zzi zzhc(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof zzi)) ? new C3264zza(iBinder) : (zzi) queryLocalInterface;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i == 26) {
                parcel.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                zza(parcel.readInt() != 0 ? (Location) Location.CREATOR.createFromParcel(parcel) : null, parcel.readInt());
                parcel2.writeNoException();
                return true;
            }
            if (i == 34) {
                parcel.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                LocationAvailability zzky = zzky(parcel.readString());
                parcel2.writeNoException();
                if (zzky != null) {
                    parcel2.writeInt(1);
                    zzky.writeToParcel(parcel2, 1);
                } else {
                    parcel2.writeInt(0);
                }
                return true;
            } else if (i == 57) {
                parcel.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                zza(parcel.readInt() != 0 ? GeofencingRequest.CREATOR.createFromParcel(parcel) : null, parcel.readInt() != 0 ? (PendingIntent) PendingIntent.CREATOR.createFromParcel(parcel) : null, zzh.zza.zzhb(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            } else if (i == 1598968902) {
                parcel2.writeString("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                return true;
            } else {
                switch (i) {
                    case 1:
                        parcel.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                        zza(parcel.createTypedArrayList(ParcelableGeofence.CREATOR), parcel.readInt() != 0 ? (PendingIntent) PendingIntent.CREATOR.createFromParcel(parcel) : null, zzh.zza.zzhb(parcel.readStrongBinder()), parcel.readString());
                        parcel2.writeNoException();
                        return true;
                    case 2:
                        parcel.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                        zza(parcel.readInt() != 0 ? (PendingIntent) PendingIntent.CREATOR.createFromParcel(parcel) : null, zzh.zza.zzhb(parcel.readStrongBinder()), parcel.readString());
                        parcel2.writeNoException();
                        return true;
                    case 3:
                        parcel.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                        zza(parcel.createStringArray(), zzh.zza.zzhb(parcel.readStrongBinder()), parcel.readString());
                        parcel2.writeNoException();
                        return true;
                    case 4:
                        parcel.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                        zza(zzh.zza.zzhb(parcel.readStrongBinder()), parcel.readString());
                        parcel2.writeNoException();
                        return true;
                    case 5:
                        parcel.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                        zza(parcel.readLong(), parcel.readInt() != 0, parcel.readInt() != 0 ? (PendingIntent) PendingIntent.CREATOR.createFromParcel(parcel) : null);
                        parcel2.writeNoException();
                        return true;
                    case 6:
                        parcel.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                        zzb(parcel.readInt() != 0 ? (PendingIntent) PendingIntent.CREATOR.createFromParcel(parcel) : null);
                        parcel2.writeNoException();
                        return true;
                    case 7:
                        parcel.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                        Location zzbpk = zzbpk();
                        parcel2.writeNoException();
                        if (zzbpk != null) {
                            parcel2.writeInt(1);
                            zzbpk.writeToParcel(parcel2, 1);
                        } else {
                            parcel2.writeInt(0);
                        }
                        return true;
                    case 8:
                        parcel.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                        zza(parcel.readInt() != 0 ? (LocationRequest) LocationRequest.CREATOR.createFromParcel(parcel) : null, zzg.zza.zzgy(parcel.readStrongBinder()));
                        parcel2.writeNoException();
                        return true;
                    case 9:
                        parcel.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                        zza(parcel.readInt() != 0 ? (LocationRequest) LocationRequest.CREATOR.createFromParcel(parcel) : null, parcel.readInt() != 0 ? (PendingIntent) PendingIntent.CREATOR.createFromParcel(parcel) : null);
                        parcel2.writeNoException();
                        return true;
                    case 10:
                        parcel.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                        zza(zzg.zza.zzgy(parcel.readStrongBinder()));
                        parcel2.writeNoException();
                        return true;
                    case 11:
                        parcel.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                        zzc(parcel.readInt() != 0 ? (PendingIntent) PendingIntent.CREATOR.createFromParcel(parcel) : null);
                        parcel2.writeNoException();
                        return true;
                    case 12:
                        parcel.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                        zzcc(parcel.readInt() != 0);
                        parcel2.writeNoException();
                        return true;
                    case 13:
                        parcel.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                        zzd(parcel.readInt() != 0 ? (Location) Location.CREATOR.createFromParcel(parcel) : null);
                        parcel2.writeNoException();
                        return true;
                    default:
                        switch (i) {
                            case 20:
                                parcel.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                                zza(parcel.readInt() != 0 ? (LocationRequest) LocationRequest.CREATOR.createFromParcel(parcel) : null, zzg.zza.zzgy(parcel.readStrongBinder()), parcel.readString());
                                parcel2.writeNoException();
                                return true;
                            case 21:
                                parcel.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                                Location zzkx = zzkx(parcel.readString());
                                parcel2.writeNoException();
                                if (zzkx != null) {
                                    parcel2.writeInt(1);
                                    zzkx.writeToParcel(parcel2, 1);
                                } else {
                                    parcel2.writeInt(0);
                                }
                                return true;
                            default:
                                switch (i) {
                                    case 52:
                                        parcel.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                                        zza(parcel.readInt() != 0 ? (LocationRequestInternal) LocationRequestInternal.CREATOR.createFromParcel(parcel) : null, zzg.zza.zzgy(parcel.readStrongBinder()));
                                        parcel2.writeNoException();
                                        return true;
                                    case 53:
                                        parcel.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                                        zza(parcel.readInt() != 0 ? (LocationRequestInternal) LocationRequestInternal.CREATOR.createFromParcel(parcel) : null, parcel.readInt() != 0 ? (PendingIntent) PendingIntent.CREATOR.createFromParcel(parcel) : null);
                                        parcel2.writeNoException();
                                        return true;
                                    default:
                                        switch (i) {
                                            case 59:
                                                parcel.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                                                zza(parcel.readInt() != 0 ? (LocationRequestUpdateData) LocationRequestUpdateData.CREATOR.createFromParcel(parcel) : null);
                                                parcel2.writeNoException();
                                                return true;
                                            case 60:
                                                parcel.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                                                zza(parcel.readInt() != 0 ? (GestureRequest) GestureRequest.CREATOR.createFromParcel(parcel) : null, parcel.readInt() != 0 ? (PendingIntent) PendingIntent.CREATOR.createFromParcel(parcel) : null, zzqx.zza.zzdp(parcel.readStrongBinder()));
                                                parcel2.writeNoException();
                                                return true;
                                            case 61:
                                                parcel.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                                                zzd(parcel.readInt() != 0 ? (PendingIntent) PendingIntent.CREATOR.createFromParcel(parcel) : null, zzqx.zza.zzdp(parcel.readStrongBinder()));
                                                parcel2.writeNoException();
                                                return true;
                                            default:
                                                switch (i) {
                                                    case 63:
                                                        parcel.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                                                        zza(parcel.readInt() != 0 ? LocationSettingsRequest.CREATOR.createFromParcel(parcel) : null, zzj.zza.zzhd(parcel.readStrongBinder()), parcel.readString());
                                                        parcel2.writeNoException();
                                                        return true;
                                                    case 64:
                                                        parcel.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                                                        ActivityRecognitionResult zzkw = zzkw(parcel.readString());
                                                        parcel2.writeNoException();
                                                        if (zzkw != null) {
                                                            parcel2.writeInt(1);
                                                            zzkw.writeToParcel(parcel2, 1);
                                                        } else {
                                                            parcel2.writeInt(0);
                                                        }
                                                        return true;
                                                    case 65:
                                                        parcel.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                                                        zzb(parcel.readInt() != 0 ? (PendingIntent) PendingIntent.CREATOR.createFromParcel(parcel) : null, zzqx.zza.zzdp(parcel.readStrongBinder()));
                                                        parcel2.writeNoException();
                                                        return true;
                                                    case 66:
                                                        parcel.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                                                        zzc(parcel.readInt() != 0 ? (PendingIntent) PendingIntent.CREATOR.createFromParcel(parcel) : null, zzqx.zza.zzdp(parcel.readStrongBinder()));
                                                        parcel2.writeNoException();
                                                        return true;
                                                    case 67:
                                                        parcel.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                                                        zza(zzg.zza.zzha(parcel.readStrongBinder()));
                                                        parcel2.writeNoException();
                                                        return true;
                                                    case 68:
                                                        parcel.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                                                        zze(parcel.readInt() != 0 ? (PendingIntent) PendingIntent.CREATOR.createFromParcel(parcel) : null, zzqx.zza.zzdp(parcel.readStrongBinder()));
                                                        parcel2.writeNoException();
                                                        return true;
                                                    case 69:
                                                        parcel.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                                                        zzf(parcel.readInt() != 0 ? (PendingIntent) PendingIntent.CREATOR.createFromParcel(parcel) : null, zzqx.zza.zzdp(parcel.readStrongBinder()));
                                                        parcel2.writeNoException();
                                                        return true;
                                                    case 70:
                                                        parcel.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                                                        zza(parcel.readInt() != 0 ? ActivityRecognitionRequest.CREATOR.createFromParcel(parcel) : null, parcel.readInt() != 0 ? (PendingIntent) PendingIntent.CREATOR.createFromParcel(parcel) : null, zzqx.zza.zzdp(parcel.readStrongBinder()));
                                                        parcel2.writeNoException();
                                                        return true;
                                                    case 71:
                                                        parcel.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                                                        zza(zzqx.zza.zzdp(parcel.readStrongBinder()));
                                                        parcel2.writeNoException();
                                                        return true;
                                                    case 72:
                                                        parcel.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                                                        zza(parcel.readInt() != 0 ? (ActivityTransitionRequest) ActivityTransitionRequest.CREATOR.createFromParcel(parcel) : null, parcel.readInt() != 0 ? (PendingIntent) PendingIntent.CREATOR.createFromParcel(parcel) : null, zzqx.zza.zzdp(parcel.readStrongBinder()));
                                                        parcel2.writeNoException();
                                                        return true;
                                                    case 73:
                                                        parcel.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                                                        zza(parcel.readInt() != 0 ? (PendingIntent) PendingIntent.CREATOR.createFromParcel(parcel) : null, zzqx.zza.zzdp(parcel.readStrongBinder()));
                                                        parcel2.writeNoException();
                                                        return true;
                                                    default:
                                                        return super.onTransact(i, parcel, parcel2, i2);
                                                }
                                        }
                                }
                        }
                }
            }
        }
    }

    void zza(long j, boolean z, PendingIntent pendingIntent) throws RemoteException;

    void zza(PendingIntent pendingIntent, zzqx zzqxVar) throws RemoteException;

    void zza(PendingIntent pendingIntent, zzh zzhVar, String str) throws RemoteException;

    void zza(Location location, int i) throws RemoteException;

    void zza(zzqx zzqxVar) throws RemoteException;

    void zza(ActivityRecognitionRequest activityRecognitionRequest, PendingIntent pendingIntent, zzqx zzqxVar) throws RemoteException;

    void zza(ActivityTransitionRequest activityTransitionRequest, PendingIntent pendingIntent, zzqx zzqxVar) throws RemoteException;

    void zza(GeofencingRequest geofencingRequest, PendingIntent pendingIntent, zzh zzhVar) throws RemoteException;

    void zza(GestureRequest gestureRequest, PendingIntent pendingIntent, zzqx zzqxVar) throws RemoteException;

    void zza(LocationRequest locationRequest, PendingIntent pendingIntent) throws RemoteException;

    void zza(LocationRequest locationRequest, com.google.android.gms.location.zzg zzgVar) throws RemoteException;

    void zza(LocationRequest locationRequest, com.google.android.gms.location.zzg zzgVar, String str) throws RemoteException;

    void zza(LocationSettingsRequest locationSettingsRequest, zzj zzjVar, String str) throws RemoteException;

    void zza(LocationRequestInternal locationRequestInternal, PendingIntent pendingIntent) throws RemoteException;

    void zza(LocationRequestInternal locationRequestInternal, com.google.android.gms.location.zzg zzgVar) throws RemoteException;

    void zza(LocationRequestUpdateData locationRequestUpdateData) throws RemoteException;

    void zza(zzg zzgVar) throws RemoteException;

    void zza(zzh zzhVar, String str) throws RemoteException;

    void zza(com.google.android.gms.location.zzg zzgVar) throws RemoteException;

    void zza(List<ParcelableGeofence> list, PendingIntent pendingIntent, zzh zzhVar, String str) throws RemoteException;

    void zza(String[] strArr, zzh zzhVar, String str) throws RemoteException;

    void zzb(PendingIntent pendingIntent) throws RemoteException;

    void zzb(PendingIntent pendingIntent, zzqx zzqxVar) throws RemoteException;

    Location zzbpk() throws RemoteException;

    void zzc(PendingIntent pendingIntent) throws RemoteException;

    void zzc(PendingIntent pendingIntent, zzqx zzqxVar) throws RemoteException;

    void zzcc(boolean z) throws RemoteException;

    void zzd(PendingIntent pendingIntent, zzqx zzqxVar) throws RemoteException;

    void zzd(Location location) throws RemoteException;

    void zze(PendingIntent pendingIntent, zzqx zzqxVar) throws RemoteException;

    void zzf(PendingIntent pendingIntent, zzqx zzqxVar) throws RemoteException;

    ActivityRecognitionResult zzkw(String str) throws RemoteException;

    Location zzkx(String str) throws RemoteException;

    LocationAvailability zzky(String str) throws RemoteException;
}
