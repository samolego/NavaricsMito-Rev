package com.google.android.gms.common.stats;

import android.content.Context;
import android.content.Intent;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.common.stats.zzc;
import com.google.android.gms.common.util.zzj;
import java.util.List;

/* loaded from: classes.dex */
public class zzh {

    /* renamed from: EH */
    private static zzh f2993EH = new zzh();

    /* renamed from: EI */
    private static Boolean f2994EI = null;
    private static String TAG = "WakeLockTracker";

    public static zzh zzaxf() {
        return f2993EH;
    }

    private static boolean zzcj(Context context) {
        if (f2994EI == null) {
            f2994EI = Boolean.valueOf(zzck(context));
        }
        return f2994EI.booleanValue();
    }

    private static boolean zzck(Context context) {
        try {
            if (com.google.android.gms.common.util.zzd.zzact()) {
                return zzc.zzb.f2980Eh.get().intValue() != zzd.LOG_LEVEL_OFF;
            }
            return false;
        } catch (SecurityException unused) {
            return false;
        }
    }

    public void zza(Context context, String str, int i, String str2, String str3, String str4, int i2, List<String> list) {
        zza(context, str, i, str2, str3, str4, i2, list, 0L);
    }

    public void zza(Context context, String str, int i, String str2, String str3, String str4, int i2, List<String> list, long j) {
        if (zzcj(context)) {
            if (TextUtils.isEmpty(str)) {
                String str5 = TAG;
                String valueOf = String.valueOf(str);
                Log.e(str5, valueOf.length() != 0 ? "missing wakeLock key. ".concat(valueOf) : new String("missing wakeLock key. "));
                return;
            }
            long currentTimeMillis = System.currentTimeMillis();
            if (7 == i || 8 == i || 10 == i || 11 == i) {
                try {
                    context.startService(new Intent().setComponent(zzd.f2982En).putExtra("com.google.android.gms.common.stats.EXTRA_LOG_EVENT", new WakeLockEvent(currentTimeMillis, i, str2, i2, zzf.zzz(list), str, SystemClock.elapsedRealtime(), zzj.zzcn(context), str3, zzf.zzih(context.getPackageName()), zzj.zzco(context), j, str4)));
                } catch (Exception e) {
                    Log.wtf(TAG, e);
                }
            }
        }
    }
}
