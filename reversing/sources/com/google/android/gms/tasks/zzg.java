package com.google.android.gms.tasks;

import android.support.annotation.NonNull;
import java.util.ArrayDeque;
import java.util.Queue;

/* loaded from: classes.dex */
class zzg<TResult> {
    private Queue<zzf<TResult>> aJF;
    private boolean aJG;
    private final Object zzakd = new Object();

    public void zza(@NonNull Task<TResult> task) {
        zzf<TResult> poll;
        synchronized (this.zzakd) {
            if (this.aJF != null && !this.aJG) {
                this.aJG = true;
                while (true) {
                    synchronized (this.zzakd) {
                        poll = this.aJF.poll();
                        if (poll == null) {
                            this.aJG = false;
                            return;
                        }
                    }
                    poll.onComplete(task);
                }
            }
        }
    }

    public void zza(@NonNull zzf<TResult> zzfVar) {
        synchronized (this.zzakd) {
            if (this.aJF == null) {
                this.aJF = new ArrayDeque();
            }
            this.aJF.add(zzfVar);
        }
    }
}
