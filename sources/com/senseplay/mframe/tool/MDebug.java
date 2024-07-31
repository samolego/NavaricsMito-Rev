package com.senseplay.mframe.tool;

import android.util.Log;

/* loaded from: classes2.dex */
public class MDebug {
    private static final boolean isDebug = MConfig.isDebug();

    /* renamed from: d */
    public static void m5827d(String str, String str2) {
        if (isDebug) {
            Log.d(str, str2);
        }
    }

    /* renamed from: d */
    public static void m5826d(String str, String str2, Throwable th) {
        if (isDebug) {
            Log.d(str, str2, th);
        }
    }

    /* renamed from: e */
    public static void m5825e(String str, String str2) {
        if (isDebug) {
            Log.e(str, str2);
        }
    }

    /* renamed from: e */
    public static void m5824e(String str, String str2, Throwable th) {
        if (isDebug) {
            Log.e(str, str2, th);
        }
    }

    /* renamed from: i */
    public static void m5823i(String str, String str2) {
        if (isDebug) {
            Log.i(str, str2);
        }
    }

    /* renamed from: i */
    public static void m5822i(String str, String str2, Throwable th) {
        if (isDebug) {
            Log.i(str, str2, th);
        }
    }

    /* renamed from: w */
    public static void m5819w(String str, String str2) {
        if (isDebug) {
            Log.w(str, str2);
        }
    }

    /* renamed from: w */
    public static void m5817w(String str, Throwable th) {
        if (isDebug) {
            Log.w(str, th);
        }
    }

    /* renamed from: w */
    public static void m5818w(String str, String str2, Throwable th) {
        if (isDebug) {
            Log.w(str, str2, th);
        }
    }

    /* renamed from: v */
    public static void m5821v(String str, String str2) {
        if (isDebug) {
            Log.v(str, str2);
        }
    }

    /* renamed from: v */
    public static void m5820v(String str, String str2, Throwable th) {
        if (isDebug) {
            Log.v(str, str2, th);
        }
    }
}
