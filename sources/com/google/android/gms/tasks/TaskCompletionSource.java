package com.google.android.gms.tasks;

import android.support.annotation.NonNull;

/* loaded from: classes.dex */
public class TaskCompletionSource<TResult> {
    private final zzh<TResult> aJH = new zzh<>();

    @NonNull
    public Task<TResult> getTask() {
        return this.aJH;
    }

    public void setException(@NonNull Exception exc) {
        this.aJH.setException(exc);
    }

    public void setResult(TResult tresult) {
        this.aJH.setResult(tresult);
    }
}
