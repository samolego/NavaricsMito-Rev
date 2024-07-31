package com.tencent.p075mm.opensdk.utils;

/* renamed from: com.tencent.mm.opensdk.utils.Log */
/* loaded from: classes2.dex */
public class Log {
    private static ILog logImpl;

    /* renamed from: d */
    public static void m5001d(String str, String str2) {
        ILog iLog = logImpl;
        if (iLog == null) {
            android.util.Log.d(str, str2);
        } else {
            iLog.m5006d(str, str2);
        }
    }

    /* renamed from: e */
    public static void m5000e(String str, String str2) {
        ILog iLog = logImpl;
        if (iLog == null) {
            android.util.Log.e(str, str2);
        } else {
            iLog.m5005e(str, str2);
        }
    }

    /* renamed from: i */
    public static void m4999i(String str, String str2) {
        ILog iLog = logImpl;
        if (iLog == null) {
            android.util.Log.i(str, str2);
        } else {
            iLog.m5004i(str, str2);
        }
    }

    public static void setLogImpl(ILog iLog) {
        logImpl = iLog;
    }

    /* renamed from: v */
    public static void m4998v(String str, String str2) {
        ILog iLog = logImpl;
        if (iLog == null) {
            android.util.Log.v(str, str2);
        } else {
            iLog.m5003v(str, str2);
        }
    }

    /* renamed from: w */
    public static void m4997w(String str, String str2) {
        ILog iLog = logImpl;
        if (iLog == null) {
            android.util.Log.w(str, str2);
        } else {
            iLog.m5002w(str, str2);
        }
    }
}
