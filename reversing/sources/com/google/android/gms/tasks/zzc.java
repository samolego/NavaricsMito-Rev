package com.google.android.gms.tasks;

import android.support.annotation.NonNull;
import java.util.concurrent.Executor;

/* loaded from: classes.dex */
class zzc<TResult> implements zzf<TResult> {
    private final Executor aBG;
    private OnCompleteListener<TResult> aJz;
    private final Object zzakd = new Object();

    public zzc(@NonNull Executor executor, @NonNull OnCompleteListener<TResult> onCompleteListener) {
        this.aBG = executor;
        this.aJz = onCompleteListener;
    }

    @Override // com.google.android.gms.tasks.zzf
    public void cancel() {
        synchronized (this.zzakd) {
            this.aJz = null;
        }
    }

    @Override // com.google.android.gms.tasks.zzf
    public void onComplete(@NonNull final Task<TResult> task) {
        synchronized (this.zzakd) {
            if (this.aJz == null) {
                return;
            }
            this.aBG.execute(new Runnable() { // from class: com.google.android.gms.tasks.zzc.1
                @Override // java.lang.Runnable
                public void run() {
                    synchronized (zzc.this.zzakd) {
                        if (zzc.this.aJz != null) {
                            zzc.this.aJz.onComplete(task);
                        }
                    }
                }
            });
        }
    }
}
