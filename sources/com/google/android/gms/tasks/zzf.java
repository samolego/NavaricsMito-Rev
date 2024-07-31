package com.google.android.gms.tasks;

import android.support.annotation.NonNull;

/* loaded from: classes.dex */
interface zzf<TResult> {
    void cancel();

    void onComplete(@NonNull Task<TResult> task);
}
