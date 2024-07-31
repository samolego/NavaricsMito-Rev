package com.google.android.gms.common.util;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.PowerManager;
import android.os.SystemClock;

/* loaded from: classes.dex */
public final class zzj {

    /* renamed from: EQ */
    private static long f3010EQ;

    /* renamed from: EP */
    private static IntentFilter f3009EP = new IntentFilter("android.intent.action.BATTERY_CHANGED");

    /* renamed from: ER */
    private static float f3011ER = Float.NaN;

    @TargetApi(20)
    public static boolean zzb(PowerManager powerManager) {
        return zzs.zzaxs() ? powerManager.isInteractive() : powerManager.isScreenOn();
    }

    @TargetApi(20)
    public static int zzcn(Context context) {
        if (context == null || context.getApplicationContext() == null) {
            return -1;
        }
        Intent registerReceiver = context.getApplicationContext().registerReceiver(null, f3009EP);
        int i = ((registerReceiver == null ? 0 : registerReceiver.getIntExtra("plugged", 0)) & 7) != 0 ? 1 : 0;
        PowerManager powerManager = (PowerManager) context.getSystemService("power");
        if (powerManager == null) {
            return -1;
        }
        return ((zzb(powerManager) ? 1 : 0) << 1) | i;
    }

    public static synchronized float zzco(Context context) {
        synchronized (zzj.class) {
            if (SystemClock.elapsedRealtime() - f3010EQ < 60000 && !Float.isNaN(f3011ER)) {
                return f3011ER;
            }
            if (context.getApplicationContext().registerReceiver(null, f3009EP) != null) {
                f3011ER = r6.getIntExtra("level", -1) / r6.getIntExtra("scale", -1);
            }
            f3010EQ = SystemClock.elapsedRealtime();
            return f3011ER;
        }
    }
}