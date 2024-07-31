package com.tencent.mm.opensdk.utils;

/* loaded from: classes2.dex */
public class Log {
    private static ILog logImpl;

    /* renamed from: d */
    public static void m7852d(String str, String str2) {
        ILog iLog = logImpl;
        if (iLog == null) {
            android.util.Log.d(str, str2);
        } else {
            iLog.m7847d(str, str2);
        }
    }

    /* renamed from: e */
    public static void m7853e(String str, String str2) {
        ILog iLog = logImpl;
        if (iLog == null) {
            android.util.Log.e(str, str2);
        } else {
            iLog.m7848e(str, str2);
        }
    }

    /* renamed from: i */
    public static void m7854i(String str, String str2) {
        ILog iLog = logImpl;
        if (iLog == null) {
            android.util.Log.i(str, str2);
        } else {
            iLog.m7849i(str, str2);
        }
    }

    public static void setLogImpl(ILog iLog) {
        logImpl = iLog;
    }

    /* renamed from: v */
    public static void m7855v(String str, String str2) {
        ILog iLog = logImpl;
        if (iLog == null) {
            android.util.Log.v(str, str2);
        } else {
            iLog.m7850v(str, str2);
        }
    }

    /* renamed from: w */
    public static void m7856w(String str, String str2) {
        ILog iLog = logImpl;
        if (iLog == null) {
            android.util.Log.w(str, str2);
        } else {
            iLog.m7851w(str, str2);
        }
    }
}