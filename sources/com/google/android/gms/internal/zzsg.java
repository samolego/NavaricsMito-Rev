package com.google.android.gms.internal;

import android.os.Process;

/* loaded from: classes.dex */
class zzsg implements Runnable {
    private final int mPriority;
    private final Runnable zzw;

    public zzsg(Runnable runnable, int i) {
        this.zzw = runnable;
        this.mPriority = i;
    }

    @Override // java.lang.Runnable
    public void run() {
        Process.setThreadPriority(this.mPriority);
        this.zzw.run();
    }
}
