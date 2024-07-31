package com.google.android.gms.common.util;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.annotation.Nullable;
import com.google.android.gms.internal.zzsi;

/* loaded from: classes.dex */
public class zzd {
    public static int zza(PackageInfo packageInfo) {
        Bundle bundle;
        if (packageInfo == null || packageInfo.applicationInfo == null || (bundle = packageInfo.applicationInfo.metaData) == null) {
            return -1;
        }
        return bundle.getInt("com.google.android.gms.version", -1);
    }

    public static boolean zzact() {
        return false;
    }

    public static int zzv(Context context, String str) {
        return zza(zzw(context, str));
    }

    @Nullable
    public static PackageInfo zzw(Context context, String str) {
        try {
            return zzsi.zzcr(context).getPackageInfo(str, 128);
        } catch (PackageManager.NameNotFoundException unused) {
            return null;
        }
    }

    @TargetApi(12)
    public static boolean zzx(Context context, String str) {
        if (zzs.zzaxl()) {
            if ("com.google.android.gms".equals(str) && zzact()) {
                return false;
            }
            try {
                return (zzsi.zzcr(context).getApplicationInfo(str, 0).flags & 2097152) != 0;
            } catch (PackageManager.NameNotFoundException unused) {
                return false;
            }
        }
        return false;
    }
}
