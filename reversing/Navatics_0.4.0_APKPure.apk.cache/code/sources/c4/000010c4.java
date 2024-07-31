package com.google.android.gms.common.util;

import android.os.Binder;
import android.os.Process;

/* loaded from: classes.dex */
public class zzt {

    /* renamed from: EY */
    private static String f3018EY;

    public static String zzaxx() {
        return zzhl(Binder.getCallingPid());
    }

    public static String zzaxy() {
        if (f3018EY == null) {
            f3018EY = zzhl(Process.myPid());
        }
        return f3018EY;
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0053 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static java.lang.String zzhl(int r5) {
        /*
            r0 = 0
            java.io.BufferedReader r1 = new java.io.BufferedReader     // Catch: java.lang.Throwable -> L3c java.io.IOException -> L3e
            java.io.FileReader r2 = new java.io.FileReader     // Catch: java.lang.Throwable -> L3c java.io.IOException -> L3e
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L3c java.io.IOException -> L3e
            r4 = 25
            r3.<init>(r4)     // Catch: java.lang.Throwable -> L3c java.io.IOException -> L3e
            java.lang.String r4 = "/proc/"
            r3.append(r4)     // Catch: java.lang.Throwable -> L3c java.io.IOException -> L3e
            r3.append(r5)     // Catch: java.lang.Throwable -> L3c java.io.IOException -> L3e
            java.lang.String r5 = "/cmdline"
            r3.append(r5)     // Catch: java.lang.Throwable -> L3c java.io.IOException -> L3e
            java.lang.String r5 = r3.toString()     // Catch: java.lang.Throwable -> L3c java.io.IOException -> L3e
            r2.<init>(r5)     // Catch: java.lang.Throwable -> L3c java.io.IOException -> L3e
            r1.<init>(r2)     // Catch: java.lang.Throwable -> L3c java.io.IOException -> L3e
            java.lang.String r5 = r1.readLine()     // Catch: java.io.IOException -> L3a java.lang.Throwable -> L4f
            java.lang.String r0 = r5.trim()     // Catch: java.io.IOException -> L3a java.lang.Throwable -> L4f
            r1.close()     // Catch: java.lang.Exception -> L2f
            goto L4e
        L2f:
            r5 = move-exception
            java.lang.String r1 = "ProcessUtils"
            java.lang.String r2 = r5.getMessage()
            android.util.Log.w(r1, r2, r5)
            goto L4e
        L3a:
            r5 = move-exception
            goto L40
        L3c:
            r5 = move-exception
            goto L51
        L3e:
            r5 = move-exception
            r1 = r0
        L40:
            java.lang.String r2 = "ProcessUtils"
            java.lang.String r3 = r5.getMessage()     // Catch: java.lang.Throwable -> L4f
            android.util.Log.e(r2, r3, r5)     // Catch: java.lang.Throwable -> L4f
            if (r1 == 0) goto L4e
            r1.close()     // Catch: java.lang.Exception -> L2f
        L4e:
            return r0
        L4f:
            r5 = move-exception
            r0 = r1
        L51:
            if (r0 == 0) goto L61
            r0.close()     // Catch: java.lang.Exception -> L57
            goto L61
        L57:
            r0 = move-exception
            java.lang.String r1 = r0.getMessage()
            java.lang.String r2 = "ProcessUtils"
            android.util.Log.w(r2, r1, r0)
        L61:
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.util.zzt.zzhl(int):java.lang.String");
    }
}