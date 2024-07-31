package com.google.android.gms.common.internal;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;
import com.google.android.gms.internal.zzsi;

/* loaded from: classes.dex */
public class zzaa {

    /* renamed from: CS */
    private static String f2800CS;

    /* renamed from: CT */
    private static int f2801CT;
    private static Object zzaok = new Object();
    private static boolean zzcdp;

    public static String zzcg(Context context) {
        zzci(context);
        return f2800CS;
    }

    public static int zzch(Context context) {
        zzci(context);
        return f2801CT;
    }

    private static void zzci(Context context) {
        Bundle bundle;
        synchronized (zzaok) {
            if (zzcdp) {
                return;
            }
            zzcdp = true;
            try {
                bundle = zzsi.zzcr(context).getApplicationInfo(context.getPackageName(), 128).metaData;
            } catch (PackageManager.NameNotFoundException e) {
                Log.wtf("MetadataValueReader", "This should never happen.", e);
            }
            if (bundle == null) {
                return;
            }
            f2800CS = bundle.getString("com.google.app.id");
            f2801CT = bundle.getInt("com.google.android.gms.version");
        }
    }
}
