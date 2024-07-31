package com.google.android.gms.location;

import android.content.Context;
import android.os.Looper;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.internal.zzac;
import com.google.android.gms.internal.zzqc;
import com.google.android.gms.location.internal.zzl;
import com.google.android.gms.location.internal.zzq;

/* loaded from: classes.dex */
public class LocationServices {

    /* renamed from: fa */
    private static final Api.zzf<zzl> f3393fa = new Api.zzf<>();

    /* renamed from: fb */
    private static final Api.zza<zzl, Api.ApiOptions.NoOptions> f3394fb = new Api.zza<zzl, Api.ApiOptions.NoOptions>() { // from class: com.google.android.gms.location.LocationServices.1
        @Override // com.google.android.gms.common.api.Api.zza
        /* renamed from: zzp */
        public zzl zza(Context context, Looper looper, com.google.android.gms.common.internal.zzh zzhVar, Api.ApiOptions.NoOptions noOptions, GoogleApiClient.ConnectionCallbacks connectionCallbacks, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
            return new zzl(context, looper, connectionCallbacks, onConnectionFailedListener, "locationServices", zzhVar);
        }
    };
    public static final Api<Api.ApiOptions.NoOptions> API = new Api<>("LocationServices.API", f3394fb, f3393fa);
    public static final FusedLocationProviderApi FusedLocationApi = new com.google.android.gms.location.internal.zzd();
    public static final GeofencingApi GeofencingApi = new com.google.android.gms.location.internal.zzf();
    public static final SettingsApi SettingsApi = new zzq();

    /* loaded from: classes.dex */
    public static abstract class zza<R extends Result> extends zzqc.zza<R, zzl> {
        public zza(GoogleApiClient googleApiClient) {
            super(LocationServices.API, googleApiClient);
        }
    }

    private LocationServices() {
    }

    public static zzl zzj(GoogleApiClient googleApiClient) {
        zzac.zzb(googleApiClient != null, "GoogleApiClient parameter is required.");
        zzl zzlVar = (zzl) googleApiClient.zza(f3393fa);
        zzac.zza(zzlVar != null, "GoogleApiClient is not configured to use the LocationServices.API Api. Pass thisinto GoogleApiClient.Builder#addApi() to use this feature.");
        return zzlVar;
    }
}
