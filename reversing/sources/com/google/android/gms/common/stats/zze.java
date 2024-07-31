package com.google.android.gms.common.stats;

import android.os.SystemClock;
import android.support.p008v4.util.SimpleArrayMap;
import android.util.Log;

/* loaded from: classes.dex */
public class zze {

    /* renamed from: Ev */
    private final long f2990Ev;

    /* renamed from: Ew */
    private final int f2991Ew;

    /* renamed from: Ex */
    private final SimpleArrayMap<String, Long> f2992Ex;

    public zze() {
        this.f2990Ev = 60000L;
        this.f2991Ew = 10;
        this.f2992Ex = new SimpleArrayMap<>(10);
    }

    public zze(int i, long j) {
        this.f2990Ev = j;
        this.f2991Ew = i;
        this.f2992Ex = new SimpleArrayMap<>();
    }

    private void zze(long j, long j2) {
        for (int size = this.f2992Ex.size() - 1; size >= 0; size--) {
            if (j2 - this.f2992Ex.valueAt(size).longValue() > j) {
                this.f2992Ex.removeAt(size);
            }
        }
    }

    public Long zzif(String str) {
        Long put;
        long elapsedRealtime = SystemClock.elapsedRealtime();
        long j = this.f2990Ev;
        synchronized (this) {
            while (this.f2992Ex.size() >= this.f2991Ew) {
                zze(j, elapsedRealtime);
                j /= 2;
                int i = this.f2991Ew;
                StringBuilder sb = new StringBuilder(94);
                sb.append("The max capacity ");
                sb.append(i);
                sb.append(" is not enough. Current durationThreshold is: ");
                sb.append(j);
                Log.w("ConnectionTracker", sb.toString());
            }
            put = this.f2992Ex.put(str, Long.valueOf(elapsedRealtime));
        }
        return put;
    }

    public boolean zzig(String str) {
        boolean z;
        synchronized (this) {
            z = this.f2992Ex.remove(str) != null;
        }
        return z;
    }
}
