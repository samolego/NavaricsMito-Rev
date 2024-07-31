package com.google.android.gms.common.internal;

import android.support.annotation.NonNull;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Status;

/* loaded from: classes.dex */
public class zzb {
    @NonNull
    public static com.google.android.gms.common.api.zza zzae(@NonNull Status status) {
        return status.hasResolution() ? new com.google.android.gms.common.api.zze(status) : new com.google.android.gms.common.api.zza(status);
    }

    @NonNull
    public static com.google.android.gms.common.api.zza zzl(@NonNull ConnectionResult connectionResult) {
        return zzae(new Status(connectionResult.getErrorCode(), connectionResult.getErrorMessage(), connectionResult.getResolution()));
    }
}
