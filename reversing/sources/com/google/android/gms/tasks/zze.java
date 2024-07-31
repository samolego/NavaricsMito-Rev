package com.google.android.gms.tasks;

import android.support.annotation.NonNull;
import java.util.concurrent.Executor;

/* loaded from: classes.dex */
class zze<TResult> implements zzf<TResult> {
    private final Executor aBG;
    private OnSuccessListener<? super TResult> aJD;
    private final Object zzakd = new Object();

    public zze(@NonNull Executor executor, @NonNull OnSuccessListener<? super TResult> onSuccessListener) {
        this.aBG = executor;
        this.aJD = onSuccessListener;
    }

    @Override // com.google.android.gms.tasks.zzf
    public void cancel() {
        synchronized (this.zzakd) {
            this.aJD = null;
        }
    }

    @Override // com.google.android.gms.tasks.zzf
    public void onComplete(@NonNull final Task<TResult> task) {
        if (task.isSuccessful()) {
            synchronized (this.zzakd) {
                if (this.aJD == null) {
                    return;
                }
                this.aBG.execute(new Runnable() { // from class: com.google.android.gms.tasks.zze.1
                    /* JADX WARN: Multi-variable type inference failed */
                    @Override // java.lang.Runnable
                    public void run() {
                        synchronized (zze.this.zzakd) {
                            if (zze.this.aJD != null) {
                                zze.this.aJD.onSuccess(task.getResult());
                            }
                        }
                    }
                });
            }
        }
    }
}
