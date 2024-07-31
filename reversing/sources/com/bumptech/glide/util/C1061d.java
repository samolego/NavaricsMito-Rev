package com.bumptech.glide.util;

import android.annotation.TargetApi;
import android.os.Build;
import android.os.SystemClock;

/* renamed from: com.bumptech.glide.util.d */
/* loaded from: classes.dex */
public final class LogTime {

    /* renamed from: a */
    private static final double f1297a;

    static {
        f1297a = Build.VERSION.SDK_INT >= 17 ? 1.0d / Math.pow(10.0d, 6.0d) : 1.0d;
    }

    @TargetApi(17)
    /* renamed from: a */
    public static long m11595a() {
        if (Build.VERSION.SDK_INT >= 17) {
            return SystemClock.elapsedRealtimeNanos();
        }
        return SystemClock.uptimeMillis();
    }

    /* renamed from: a */
    public static double m11594a(long j) {
        return (m11595a() - j) * f1297a;
    }
}
