package com.senseplay.sdk.log;

import android.util.Log;

/* loaded from: classes2.dex */
public class SPDebug {
    private static String debugStr = "";
    private static final boolean isDebug = true;

    public static String getDebugStr() {
        return debugStr;
    }

    public static void clearDebugStr() {
        debugStr = "";
    }

    /* renamed from: d */
    public static void m5816d(String str) {
        String str2 = debugStr;
        if (str2 != null && str2.length() > 1000) {
            debugStr = "";
        }
        debugStr += str + "\n";
        Log.w("SPDebug", str);
    }

    /* renamed from: d */
    public static void m5815d(String str, String str2) {
        Log.d(str, str2);
    }

    /* renamed from: d */
    public static void m5814d(String str, String str2, Throwable th) {
        Log.d(str, str2, th);
    }

    /* renamed from: e */
    public static void m5813e(String str, String str2) {
        Log.e(str, str2);
    }

    /* renamed from: e */
    public static void m5812e(String str, String str2, Throwable th) {
        Log.e(str, str2, th);
    }

    /* renamed from: i */
    public static void m5811i(String str, String str2) {
        Log.i(str, str2);
    }

    /* renamed from: i */
    public static void m5810i(String str, String str2, Throwable th) {
        Log.i(str, str2, th);
    }

    /* renamed from: w */
    public static void m5807w(String str, String str2) {
        Log.w(str, str2);
    }

    /* renamed from: w */
    public static void m5805w(String str, Throwable th) {
        Log.w(str, th);
    }

    /* renamed from: w */
    public static void m5806w(String str, String str2, Throwable th) {
        Log.w(str, str2, th);
    }

    /* renamed from: v */
    public static void m5809v(String str, String str2) {
        Log.v(str, str2);
    }

    /* renamed from: v */
    public static void m5808v(String str, String str2, Throwable th) {
        Log.v(str, str2, th);
    }
}
