package com.google.android.gms.common.util;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;

/* loaded from: classes.dex */
public final class zzi {

    /* renamed from: EL */
    private static Boolean f3005EL;

    /* renamed from: EM */
    private static Boolean f3006EM;

    /* renamed from: EN */
    private static Boolean f3007EN;

    /* renamed from: EO */
    private static Boolean f3008EO;

    public static boolean zzb(Resources resources) {
        if (resources == null) {
            return false;
        }
        if (f3005EL == null) {
            f3005EL = Boolean.valueOf((zzs.zzaxk() && ((resources.getConfiguration().screenLayout & 15) > 3)) || zzc(resources));
        }
        return f3005EL.booleanValue();
    }

    @TargetApi(13)
    private static boolean zzc(Resources resources) {
        if (f3006EM == null) {
            Configuration configuration = resources.getConfiguration();
            f3006EM = Boolean.valueOf(zzs.zzaxm() && (configuration.screenLayout & 15) <= 3 && configuration.smallestScreenWidthDp >= 600);
        }
        return f3006EM.booleanValue();
    }

    @TargetApi(20)
    public static boolean zzcl(Context context) {
        if (f3007EN == null) {
            f3007EN = Boolean.valueOf(zzs.zzaxs() && context.getPackageManager().hasSystemFeature("android.hardware.type.watch"));
        }
        return f3007EN.booleanValue();
    }

    @TargetApi(21)
    public static boolean zzcm(Context context) {
        if (f3008EO == null) {
            f3008EO = Boolean.valueOf(zzs.zzaxu() && context.getPackageManager().hasSystemFeature("cn.google"));
        }
        return f3008EO.booleanValue();
    }
}