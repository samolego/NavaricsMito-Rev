package com.google.android.gms.location.internal;

import android.app.PendingIntent;
import android.content.Context;
import android.location.Location;
import android.os.Looper;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.zzac;
import com.google.android.gms.internal.zzqc;
import com.google.android.gms.location.GeofencingRequest;
import com.google.android.gms.location.LocationAvailability;
import com.google.android.gms.location.LocationCallback;
import com.google.android.gms.location.LocationListener;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationSettingsRequest;
import com.google.android.gms.location.LocationSettingsResult;
import com.google.android.gms.location.LocationStatusCodes;
import com.google.android.gms.location.internal.zzh;
import com.google.android.gms.location.internal.zzj;
import java.util.List;

/* loaded from: classes.dex */
public class zzl extends com.google.android.gms.location.internal.zzb {
    private final zzk aid;

    /* loaded from: classes.dex */
    private static final class zza extends zzh.zza {
        private zzqc.zzb<Status> aie;

        public zza(zzqc.zzb<Status> zzbVar) {
            this.aie = zzbVar;
        }

        @Override // com.google.android.gms.location.internal.zzh
        public void zza(int i, PendingIntent pendingIntent) {
            Log.wtf("LocationClientImpl", "Unexpected call to onRemoveGeofencesByPendingIntentResult");
        }

        @Override // com.google.android.gms.location.internal.zzh
        public void zza(int i, String[] strArr) {
            if (this.aie == null) {
                Log.wtf("LocationClientImpl", "onAddGeofenceResult called multiple times");
                return;
            }
            this.aie.setResult(LocationStatusCodes.zzuk(LocationStatusCodes.zzuj(i)));
            this.aie = null;
        }

        @Override // com.google.android.gms.location.internal.zzh
        public void zzb(int i, String[] strArr) {
            Log.wtf("LocationClientImpl", "Unexpected call to onRemoveGeofencesByRequestIdsResult");
        }
    }

    /* loaded from: classes.dex */
    private static final class zzb extends zzh.zza {
        private zzqc.zzb<Status> aie;

        public zzb(zzqc.zzb<Status> zzbVar) {
            this.aie = zzbVar;
        }

        private void zzun(int i) {
            if (this.aie == null) {
                Log.wtf("LocationClientImpl", "onRemoveGeofencesResult called multiple times");
                return;
            }
            this.aie.setResult(LocationStatusCodes.zzuk(LocationStatusCodes.zzuj(i)));
            this.aie = null;
        }

        @Override // com.google.android.gms.location.internal.zzh
        public void zza(int i, PendingIntent pendingIntent) {
            zzun(i);
        }

        @Override // com.google.android.gms.location.internal.zzh
        public void zza(int i, String[] strArr) {
            Log.wtf("LocationClientImpl", "Unexpected call to onAddGeofencesResult");
        }

        @Override // com.google.android.gms.location.internal.zzh
        public void zzb(int i, String[] strArr) {
            zzun(i);
        }
    }

    /* loaded from: classes.dex */
    private static final class zzc extends zzj.zza {
        private zzqc.zzb<LocationSettingsResult> aie;

        public zzc(zzqc.zzb<LocationSettingsResult> zzbVar) {
            zzac.zzb(zzbVar != null, "listener can't be null.");
            this.aie = zzbVar;
        }

        @Override // com.google.android.gms.location.internal.zzj
        public void zza(LocationSettingsResult locationSettingsResult) throws RemoteException {
            this.aie.setResult(locationSettingsResult);
            this.aie = null;
        }
    }

    public zzl(Context context, Looper looper, GoogleApiClient.ConnectionCallbacks connectionCallbacks, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener, String str) {
        this(context, looper, connectionCallbacks, onConnectionFailedListener, str, com.google.android.gms.common.internal.zzh.zzcd(context));
    }

    public zzl(Context context, Looper looper, GoogleApiClient.ConnectionCallbacks connectionCallbacks, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener, String str, com.google.android.gms.common.internal.zzh zzhVar) {
        super(context, looper, connectionCallbacks, onConnectionFailedListener, str, zzhVar);
        this.aid = new zzk(context, this.ahK);
    }

    @Override // com.google.android.gms.common.internal.zze, com.google.android.gms.common.api.Api.zze
    public void disconnect() {
        synchronized (this.aid) {
            if (isConnected()) {
                try {
                    this.aid.removeAllListeners();
                    this.aid.zzbpm();
                } catch (Exception e) {
                    Log.e("LocationClientImpl", "Client disconnected before listeners could be cleaned up", e);
                }
            }
            super.disconnect();
        }
    }

    public Location getLastLocation() {
        return this.aid.getLastLocation();
    }

    public void zza(long j, PendingIntent pendingIntent) throws RemoteException {
        zzatw();
        zzac.zzy(pendingIntent);
        zzac.zzb(j >= 0, "detectionIntervalMillis must be >= 0");
        ((zzi) zzatx()).zza(j, true, pendingIntent);
    }

    public void zza(PendingIntent pendingIntent, zzqc.zzb<Status> zzbVar) throws RemoteException {
        zzatw();
        zzac.zzb(pendingIntent, "PendingIntent must be specified.");
        zzac.zzb(zzbVar, "ResultHolder not provided.");
        ((zzi) zzatx()).zza(pendingIntent, new zzb(zzbVar), getContext().getPackageName());
    }

    public void zza(PendingIntent pendingIntent, zzg zzgVar) throws RemoteException {
        this.aid.zza(pendingIntent, zzgVar);
    }

    public void zza(GeofencingRequest geofencingRequest, PendingIntent pendingIntent, zzqc.zzb<Status> zzbVar) throws RemoteException {
        zzatw();
        zzac.zzb(geofencingRequest, "geofencingRequest can't be null.");
        zzac.zzb(pendingIntent, "PendingIntent must be specified.");
        zzac.zzb(zzbVar, "ResultHolder not provided.");
        ((zzi) zzatx()).zza(geofencingRequest, pendingIntent, new zza(zzbVar));
    }

    public void zza(LocationCallback locationCallback, zzg zzgVar) throws RemoteException {
        this.aid.zza(locationCallback, zzgVar);
    }

    public void zza(LocationListener locationListener, zzg zzgVar) throws RemoteException {
        this.aid.zza(locationListener, zzgVar);
    }

    public void zza(LocationRequest locationRequest, PendingIntent pendingIntent, zzg zzgVar) throws RemoteException {
        this.aid.zza(locationRequest, pendingIntent, zzgVar);
    }

    public void zza(LocationRequest locationRequest, LocationListener locationListener, Looper looper, zzg zzgVar) throws RemoteException {
        synchronized (this.aid) {
            this.aid.zza(locationRequest, locationListener, looper, zzgVar);
        }
    }

    public void zza(LocationSettingsRequest locationSettingsRequest, zzqc.zzb<LocationSettingsResult> zzbVar, String str) throws RemoteException {
        zzatw();
        zzac.zzb(locationSettingsRequest != null, "locationSettingsRequest can't be null nor empty.");
        zzac.zzb(zzbVar != null, "listener can't be null.");
        ((zzi) zzatx()).zza(locationSettingsRequest, new zzc(zzbVar), str);
    }

    public void zza(LocationRequestInternal locationRequestInternal, LocationCallback locationCallback, Looper looper, zzg zzgVar) throws RemoteException {
        synchronized (this.aid) {
            this.aid.zza(locationRequestInternal, locationCallback, looper, zzgVar);
        }
    }

    public void zza(zzg zzgVar) throws RemoteException {
        this.aid.zza(zzgVar);
    }

    public void zza(List<String> list, zzqc.zzb<Status> zzbVar) throws RemoteException {
        zzatw();
        zzac.zzb(list != null && list.size() > 0, "geofenceRequestIds can't be null nor empty.");
        zzac.zzb(zzbVar, "ResultHolder not provided.");
        ((zzi) zzatx()).zza((String[]) list.toArray(new String[0]), new zzb(zzbVar), getContext().getPackageName());
    }

    public void zzb(PendingIntent pendingIntent) throws RemoteException {
        zzatw();
        zzac.zzy(pendingIntent);
        ((zzi) zzatx()).zzb(pendingIntent);
    }

    public LocationAvailability zzbpl() {
        return this.aid.zzbpl();
    }

    public void zzcc(boolean z) throws RemoteException {
        this.aid.zzcc(z);
    }

    public void zzd(Location location) throws RemoteException {
        this.aid.zzd(location);
    }
}
