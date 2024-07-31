package com.yayandroid.locationmanager.p083b;

import android.util.Log;

/* renamed from: com.yayandroid.locationmanager.b.a */
/* loaded from: classes2.dex */
public final class LogUtils {

    /* renamed from: a */
    private static boolean f9355a = false;

    /* renamed from: a */
    public static void m3639a(boolean z) {
        f9355a = z;
    }

    /* renamed from: a */
    public static void m3640a(String str) {
        if (f9355a) {
            Log.e(m3641a(), str);
        }
    }

    /* renamed from: b */
    public static void m3638b(String str) {
        if (f9355a) {
            Log.i(m3641a(), str);
        }
    }

    /* renamed from: a */
    private static String m3641a() {
        String className = Thread.currentThread().getStackTrace()[4].getClassName();
        return className.substring(className.lastIndexOf(46) + 1);
    }
}
