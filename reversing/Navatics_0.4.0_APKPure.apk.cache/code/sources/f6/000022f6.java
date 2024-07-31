package com.yayandroid.locationmanager.p072b;

import android.util.Log;

/* compiled from: LogUtils.java */
/* renamed from: com.yayandroid.locationmanager.b.a, reason: use source file name */
/* loaded from: classes2.dex */
public final class LogUtils {

    /* renamed from: a */
    private static boolean f9396a = false;

    /* renamed from: a */
    public static void m9205a(boolean z) {
        f9396a = z;
    }

    /* renamed from: a */
    public static void m9204a(String str) {
        if (f9396a) {
            Log.e(m9203a(), str);
        }
    }

    /* renamed from: b */
    public static void m9206b(String str) {
        if (f9396a) {
            Log.i(m9203a(), str);
        }
    }

    /* renamed from: a */
    private static String m9203a() {
        String className = Thread.currentThread().getStackTrace()[4].getClassName();
        return className.substring(className.lastIndexOf(46) + 1);
    }
}