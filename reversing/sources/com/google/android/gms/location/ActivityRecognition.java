package com.google.android.gms.location;

import android.content.Context;
import android.os.Looper;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.internal.zzqc;
import com.google.android.gms.location.internal.zzl;

/* loaded from: classes.dex */
public class ActivityRecognition {
    public static final String CLIENT_NAME = "activity_recognition";

    /* renamed from: fa */
    private static final Api.zzf<zzl> f3388fa = new Api.zzf<>();

    /* renamed from: fb */
    private static final Api.zza<zzl, Api.ApiOptions.NoOptions> f3389fb = new Api.zza<zzl, Api.ApiOptions.NoOptions>() { // from class: com.google.android.gms.location.ActivityRecognition.1
        @Override // com.google.android.gms.common.api.Api.zza
        /* renamed from: zzp */
        public zzl zza(Context context, Looper looper, com.google.android.gms.common.internal.zzh zzhVar, Api.ApiOptions.NoOptions noOptions, GoogleApiClient.ConnectionCallbacks connectionCallbacks, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
            return new zzl(context, looper, connectionCallbacks, onConnectionFailedListener, ActivityRecognition.CLIENT_NAME);
        }
    };
    public static final Api<Api.ApiOptions.NoOptions> API = new Api<>("ActivityRecognition.API", f3389fb, f3388fa);
    public static final ActivityRecognitionApi ActivityRecognitionApi = new com.google.android.gms.location.internal.zza();

    /* loaded from: classes.dex */
    public static abstract class zza<R extends Result> extends zzqc.zza<R, zzl> {
        public zza(GoogleApiClient googleApiClient) {
            super(ActivityRecognition.API, googleApiClient);
        }
    }

    private ActivityRecognition() {
    }
}
