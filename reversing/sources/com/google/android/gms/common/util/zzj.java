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
    private static long f3002EQ;

    /* renamed from: EP */
    private static IntentFilter f3001EP = new IntentFilter("android.intent.action.BATTERY_CHANGED");

    /* renamed from: ER */
    private static float f3003ER = Float.NaN;

    @TargetApi(20)
    public static boolean zzb(PowerManager powerManager) {
        return zzs.zzaxs() ? powerManager.isInteractive() : powerManager.isScreenOn();
    }

    @TargetApi(20)
    public static int zzcn(Context context) {
        if (context == null || context.getApplicationContext() == null) {
            return -1;
        }
        Intent registerReceiver = context.getApplicationContext().registerReceiver(null, f3001EP);
        int i = ((registerReceiver == null ? 0 : registerReceiver.getIntExtra("plugged", 0)) & 7) != 0 ? 1 : 0;
        PowerManager powerManager = (PowerManager) context.getSystemService("power");
        if (powerManager == null) {
            return -1;
        }
        return ((zzb(powerManager) ? 1 : 0) << 1) | i;
    }

    public static synchronized float zzco(Context context) {
        synchronized (zzj.class) {
            if (SystemClock.elapsedRealtime() - f3002EQ < 60000 && !Float.isNaN(f3003ER)) {
                return f3003ER;
            }
            Intent registerReceiver = context.getApplicationContext().registerReceiver(null, f3001EP);
            if (registerReceiver != null) {
                f3003ER = registerReceiver.getIntExtra("level", -1) / registerReceiver.getIntExtra("scale", -1);
            }
            f3002EQ = SystemClock.elapsedRealtime();
            return f3003ER;
        }
    }
}
