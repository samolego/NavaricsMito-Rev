package com.google.android.gms.internal;

import android.content.Context;
import android.content.pm.PackageManager;
import android.net.http.AndroidHttpClient;
import android.os.Build;
import java.io.File;

/* loaded from: classes.dex */
public class zzac {
    public static zzl zza(Context context) {
        return zza(context, null);
    }

    public static zzl zza(Context context, zzy zzyVar) {
        File file = new File(context.getCacheDir(), "volley");
        String str = "volley/0";
        try {
            String packageName = context.getPackageName();
            int i = context.getPackageManager().getPackageInfo(packageName, 0).versionCode;
            StringBuilder sb = new StringBuilder(String.valueOf(packageName).length() + 12);
            sb.append(packageName);
            sb.append("/");
            sb.append(i);
            str = sb.toString();
        } catch (PackageManager.NameNotFoundException unused) {
        }
        if (zzyVar == null) {
            zzyVar = Build.VERSION.SDK_INT >= 9 ? new zzz() : new zzw(AndroidHttpClient.newInstance(str));
        }
        zzl zzlVar = new zzl(new zzv(file), new zzt(zzyVar));
        zzlVar.start();
        return zzlVar;
    }
}
