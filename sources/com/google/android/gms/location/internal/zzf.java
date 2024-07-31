package com.google.android.gms.location.internal;

import android.app.PendingIntent;
import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.location.Geofence;
import com.google.android.gms.location.GeofencingApi;
import com.google.android.gms.location.GeofencingRequest;
import com.google.android.gms.location.LocationServices;
import java.util.List;

/* loaded from: classes.dex */
public class zzf implements GeofencingApi {

    /* loaded from: classes.dex */
    private static abstract class zza extends LocationServices.zza<Status> {
        public zza(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        @Override // com.google.android.gms.internal.zzqe
        /* renamed from: zzb */
        public Status zzc(Status status) {
            return status;
        }
    }

    @Override // com.google.android.gms.location.GeofencingApi
    public PendingResult<Status> addGeofences(GoogleApiClient googleApiClient, final GeofencingRequest geofencingRequest, final PendingIntent pendingIntent) {
        return googleApiClient.zzd(new zza(googleApiClient) { // from class: com.google.android.gms.location.internal.zzf.1
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.internal.zzqc.zza
            public void zza(zzl zzlVar) throws RemoteException {
                zzlVar.zza(geofencingRequest, pendingIntent, this);
            }
        });
    }

    @Override // com.google.android.gms.location.GeofencingApi
    @Deprecated
    public PendingResult<Status> addGeofences(GoogleApiClient googleApiClient, List<Geofence> list, PendingIntent pendingIntent) {
        GeofencingRequest.Builder builder = new GeofencingRequest.Builder();
        builder.addGeofences(list);
        builder.setInitialTrigger(5);
        return addGeofences(googleApiClient, builder.build(), pendingIntent);
    }

    @Override // com.google.android.gms.location.GeofencingApi
    public PendingResult<Status> removeGeofences(GoogleApiClient googleApiClient, final PendingIntent pendingIntent) {
        return googleApiClient.zzd(new zza(googleApiClient) { // from class: com.google.android.gms.location.internal.zzf.2
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.internal.zzqc.zza
            public void zza(zzl zzlVar) throws RemoteException {
                zzlVar.zza(pendingIntent, this);
            }
        });
    }

    @Override // com.google.android.gms.location.GeofencingApi
    public PendingResult<Status> removeGeofences(GoogleApiClient googleApiClient, final List<String> list) {
        return googleApiClient.zzd(new zza(googleApiClient) { // from class: com.google.android.gms.location.internal.zzf.3
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.internal.zzqc.zza
            public void zza(zzl zzlVar) throws RemoteException {
                zzlVar.zza(list, this);
            }
        });
    }
}
