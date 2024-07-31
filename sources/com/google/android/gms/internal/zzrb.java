package com.google.android.gms.internal;

import android.app.Activity;
import android.content.Intent;
import android.support.annotation.NonNull;

/* loaded from: classes.dex */
public interface zzrb {
    void startActivityForResult(Intent intent, int i);

    <T extends zzra> T zza(String str, Class<T> cls);

    void zza(String str, @NonNull zzra zzraVar);

    Activity zzasq();
}
