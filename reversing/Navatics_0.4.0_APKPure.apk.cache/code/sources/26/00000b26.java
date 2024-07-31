package com.bumptech.glide.load.engine.p020c;

import android.os.Build;
import android.os.StrictMode;
import android.util.Log;
import java.io.File;
import java.io.FilenameFilter;
import java.util.regex.Pattern;

/* compiled from: RuntimeCompat.java */
/* renamed from: com.bumptech.glide.load.engine.c.b, reason: use source file name */
/* loaded from: classes.dex */
final class RuntimeCompat {
    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public static int m873a() {
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        return Build.VERSION.SDK_INT < 17 ? Math.max(m874b(), availableProcessors) : availableProcessors;
    }

    /* renamed from: b */
    private static int m874b() {
        File[] fileArr;
        StrictMode.ThreadPolicy allowThreadDiskReads = StrictMode.allowThreadDiskReads();
        try {
            try {
                File file = new File("/sys/devices/system/cpu/");
                final Pattern compile = Pattern.compile("cpu[0-9]+");
                fileArr = file.listFiles(new FilenameFilter() { // from class: com.bumptech.glide.load.engine.c.b.1
                    @Override // java.io.FilenameFilter
                    public boolean accept(File file2, String str) {
                        return compile.matcher(str).matches();
                    }
                });
            } catch (Throwable th) {
                if (Log.isLoggable("GlideRuntimeCompat", 6)) {
                    Log.e("GlideRuntimeCompat", "Failed to calculate accurate cpu count", th);
                }
                StrictMode.setThreadPolicy(allowThreadDiskReads);
                fileArr = null;
            }
            return Math.max(1, fileArr != null ? fileArr.length : 0);
        } finally {
            StrictMode.setThreadPolicy(allowThreadDiskReads);
        }
    }
}