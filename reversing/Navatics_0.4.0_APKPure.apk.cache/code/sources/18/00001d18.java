package com.senseplay.mframe.tool;

import android.util.Log;

/* loaded from: classes2.dex */
public class MDebug {
    private static final boolean isDebug = MConfig.isDebug();

    /* renamed from: d */
    public static void m7021d(String str, String str2) {
        if (isDebug) {
            Log.d(str, str2);
        }
    }

    /* renamed from: d */
    public static void m7022d(String str, String str2, Throwable th) {
        if (isDebug) {
            Log.d(str, str2, th);
        }
    }

    /* renamed from: e */
    public static void m7023e(String str, String str2) {
        if (isDebug) {
            Log.e(str, str2);
        }
    }

    /* renamed from: e */
    public static void m7024e(String str, String str2, Throwable th) {
        if (isDebug) {
            Log.e(str, str2, th);
        }
    }

    /* renamed from: i */
    public static void m7025i(String str, String str2) {
        if (isDebug) {
            Log.i(str, str2);
        }
    }

    /* renamed from: i */
    public static void m7026i(String str, String str2, Throwable th) {
        if (isDebug) {
            Log.i(str, str2, th);
        }
    }

    /* renamed from: w */
    public static void m7029w(String str, String str2) {
        if (isDebug) {
            Log.w(str, str2);
        }
    }

    /* renamed from: w */
    public static void m7031w(String str, Throwable th) {
        if (isDebug) {
            Log.w(str, th);
        }
    }

    /* renamed from: w */
    public static void m7030w(String str, String str2, Throwable th) {
        if (isDebug) {
            Log.w(str, str2, th);
        }
    }

    /* renamed from: v */
    public static void m7027v(String str, String str2) {
        if (isDebug) {
            Log.v(str, str2);
        }
    }

    /* renamed from: v */
    public static void m7028v(String str, String str2, Throwable th) {
        if (isDebug) {
            Log.v(str, str2, th);
        }
    }
}