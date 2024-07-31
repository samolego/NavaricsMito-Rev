package com.google.android.gms.tasks;

import android.support.annotation.NonNull;
import java.util.concurrent.Executor;

/* loaded from: classes.dex */
class zzd<TResult> implements zzf<TResult> {
    private final Executor aBG;
    private OnFailureListener aJB;
    private final Object zzakd = new Object();

    public zzd(@NonNull Executor executor, @NonNull OnFailureListener onFailureListener) {
        this.aBG = executor;
        this.aJB = onFailureListener;
    }

    @Override // com.google.android.gms.tasks.zzf
    public void cancel() {
        synchronized (this.zzakd) {
            this.aJB = null;
        }
    }

    @Override // com.google.android.gms.tasks.zzf
    public void onComplete(@NonNull final Task<TResult> task) {
        if (task.isSuccessful()) {
            return;
        }
        synchronized (this.zzakd) {
            if (this.aJB == null) {
                return;
            }
            this.aBG.execute(new Runnable() { // from class: com.google.android.gms.tasks.zzd.1
                @Override // java.lang.Runnable
                public void run() {
                    synchronized (zzd.this.zzakd) {
                        if (zzd.this.aJB != null) {
                            zzd.this.aJB.onFailure(task.getException());
                        }
                    }
                }
            });
        }
    }
}
