package com.google.android.gms.common.internal;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.p008v4.app.Fragment;
import android.util.Log;
import com.google.android.gms.internal.zzrb;

/* loaded from: classes.dex */
public abstract class zzj implements DialogInterface.OnClickListener {
    public static zzj zza(final Activity activity, final Intent intent, final int i) {
        return new zzj() { // from class: com.google.android.gms.common.internal.zzj.1
            @Override // com.google.android.gms.common.internal.zzj
            public void zzauo() {
                Intent intent2 = intent;
                if (intent2 != null) {
                    activity.startActivityForResult(intent2, i);
                }
            }
        };
    }

    public static zzj zza(@NonNull final Fragment fragment, final Intent intent, final int i) {
        return new zzj() { // from class: com.google.android.gms.common.internal.zzj.2
            @Override // com.google.android.gms.common.internal.zzj
            public void zzauo() {
                Intent intent2 = intent;
                if (intent2 != null) {
                    fragment.startActivityForResult(intent2, i);
                }
            }
        };
    }

    public static zzj zza(@NonNull final zzrb zzrbVar, final Intent intent, final int i) {
        return new zzj() { // from class: com.google.android.gms.common.internal.zzj.3
            @Override // com.google.android.gms.common.internal.zzj
            @TargetApi(11)
            public void zzauo() {
                Intent intent2 = intent;
                if (intent2 != null) {
                    zzrbVar.startActivityForResult(intent2, i);
                }
            }
        };
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        try {
            zzauo();
            dialogInterface.dismiss();
        } catch (ActivityNotFoundException e) {
            Log.e("DialogRedirect", "Can't redirect to app settings for Google Play services", e);
        }
    }

    public abstract void zzauo();
}
