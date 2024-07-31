package com.google.android.gms.common.util;

import android.os.SystemClock;

/* loaded from: classes.dex */
public final class zzh implements zze {

    /* renamed from: EK */
    private static zzh f3004EK;

    public static synchronized zze zzaxj() {
        zzh zzhVar;
        synchronized (zzh.class) {
            if (f3004EK == null) {
                f3004EK = new zzh();
            }
            zzhVar = f3004EK;
        }
        return zzhVar;
    }

    @Override // com.google.android.gms.common.util.zze
    public long currentTimeMillis() {
        return System.currentTimeMillis();
    }

    @Override // com.google.android.gms.common.util.zze
    public long elapsedRealtime() {
        return SystemClock.elapsedRealtime();
    }

    @Override // com.google.android.gms.common.util.zze
    public long nanoTime() {
        return System.nanoTime();
    }
}