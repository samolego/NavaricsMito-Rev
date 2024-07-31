package com.google.android.gms.common.util;

import android.annotation.TargetApi;
import android.content.Context;
import android.util.Log;
import java.io.File;

/* loaded from: classes.dex */
public class zzx {
    @TargetApi(21)
    public static File getNoBackupFilesDir(Context context) {
        return zzs.zzaxu() ? context.getNoBackupFilesDir() : zze(new File(context.getApplicationInfo().dataDir, "no_backup"));
    }

    private static synchronized File zze(File file) {
        synchronized (zzx.class) {
            if (file.exists() || file.mkdirs()) {
                return file;
            }
            if (file.exists()) {
                return file;
            }
            String valueOf = String.valueOf(file.getPath());
            Log.w("SupportV4Utils", valueOf.length() != 0 ? "Unable to create no-backup dir ".concat(valueOf) : new String("Unable to create no-backup dir "));
            return null;
        }
    }
}
