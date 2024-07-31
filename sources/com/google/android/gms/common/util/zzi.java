package com.google.android.gms.common.util;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;

/* loaded from: classes.dex */
public final class zzi {

    /* renamed from: EL */
    private static Boolean f2997EL;

    /* renamed from: EM */
    private static Boolean f2998EM;

    /* renamed from: EN */
    private static Boolean f2999EN;

    /* renamed from: EO */
    private static Boolean f3000EO;

    public static boolean zzb(Resources resources) {
        if (resources == null) {
            return false;
        }
        if (f2997EL == null) {
            f2997EL = Boolean.valueOf((zzs.zzaxk() && ((resources.getConfiguration().screenLayout & 15) > 3)) || zzc(resources));
        }
        return f2997EL.booleanValue();
    }

    @TargetApi(13)
    private static boolean zzc(Resources resources) {
        if (f2998EM == null) {
            Configuration configuration = resources.getConfiguration();
            f2998EM = Boolean.valueOf(zzs.zzaxm() && (configuration.screenLayout & 15) <= 3 && configuration.smallestScreenWidthDp >= 600);
        }
        return f2998EM.booleanValue();
    }

    @TargetApi(20)
    public static boolean zzcl(Context context) {
        if (f2999EN == null) {
            f2999EN = Boolean.valueOf(zzs.zzaxs() && context.getPackageManager().hasSystemFeature("android.hardware.type.watch"));
        }
        return f2999EN.booleanValue();
    }

    @TargetApi(21)
    public static boolean zzcm(Context context) {
        if (f3000EO == null) {
            f3000EO = Boolean.valueOf(zzs.zzaxu() && context.getPackageManager().hasSystemFeature("cn.google"));
        }
        return f3000EO.booleanValue();
    }
}
