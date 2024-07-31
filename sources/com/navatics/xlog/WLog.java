package com.navatics.xlog;

import android.os.Build;
import android.util.Log;

/* loaded from: classes2.dex */
public class WLog {
    public static final int LEVEL_DEBUG = 1;
    public static final int LEVEL_ERROR = 4;
    public static final int LEVEL_FATAL = 5;
    public static final int LEVEL_INFO = 2;
    public static final int LEVEL_NONE = 6;
    public static final int LEVEL_VERBOSE = 0;
    public static final int LEVEL_WARNING = 3;
    private static final String SYS_INFO;
    private static final String TAG = "navatics.xlog.log";
    private static final String fileName = "navatics.log";
    private static int level = 6;
    private static LogImp logImp;
    private static ISystemInterface sSystemInterface;

    /* loaded from: classes2.dex */
    public interface LogImp {
        void appenderClose();

        void appenderFlush(boolean z);

        int getLogLevel();

        void logD(String str, String str2, String str3, int i, int i2, long j, long j2, String str4);

        void logE(String str, String str2, String str3, int i, int i2, long j, long j2, String str4);

        void logF(String str, String str2, String str3, int i, int i2, long j, long j2, String str4);

        void logI(String str, String str2, String str3, int i, int i2, long j, long j2, String str4);

        void logV(String str, String str2, String str3, int i, int i2, long j, long j2, String str4);

        void logW(String str, String str2, String str3, int i, int i2, long j, long j2, String str4);
    }

    public static void setSystemInterface(ISystemInterface iSystemInterface) {
        sSystemInterface = iSystemInterface;
    }

    public static void setLogImp(LogImp logImp2) {
        logImp = logImp2;
    }

    public static LogImp getImpl() {
        return logImp;
    }

    public static void appenderClose() {
        LogImp logImp2 = logImp;
        if (logImp2 != null) {
            logImp2.appenderClose();
        }
    }

    public static void appenderFlush(boolean z) {
        LogImp logImp2 = logImp;
        if (logImp2 != null) {
            logImp2.appenderFlush(z);
        }
    }

    public static int getLogLevel() {
        LogImp logImp2 = logImp;
        if (logImp2 != null) {
            return logImp2.getLogLevel();
        }
        return 6;
    }

    public static void setLevel(int i, boolean z) {
        level = i;
        if (z) {
            Xlog.setLogLevel(i);
        }
    }

    /* renamed from: f */
    public static void m5846f(String str, String str2) {
        m5845f(str, str2, null);
    }

    /* renamed from: e */
    public static void m5848e(String str, String str2) {
        m5847e(str, str2, null);
    }

    /* renamed from: w */
    public static void m5840w(String str, String str2) {
        m5839w(str, str2, null);
    }

    /* renamed from: i */
    public static void m5844i(String str, String str2) {
        Log.i("info-2", "new log level: ");
        m5843i(str, str2, null);
    }

    /* renamed from: d */
    public static void m5850d(String str, String str2) {
        m5849d(str, str2, null);
    }

    /* renamed from: v */
    public static void m5842v(String str, String str2) {
        m5841v(str, str2, null);
    }

    /* renamed from: f */
    public static void m5845f(String str, String str2, Object... objArr) {
        if (logImp != null) {
            if (objArr != null) {
                str2 = String.format(str2, objArr);
            }
            logImp.logF(str, "", "", 0, sSystemInterface.myPid(), sSystemInterface.myTid(), sSystemInterface.mainTid(), str2);
        }
    }

    /* renamed from: e */
    public static void m5847e(String str, String str2, Object... objArr) {
        if (logImp != null) {
            if (objArr != null) {
                str2 = String.format(str2, objArr);
            }
            logImp.logE(str, "", "", 0, sSystemInterface.myPid(), sSystemInterface.myTid(), sSystemInterface.mainTid(), str2 == null ? "" : str2);
        }
    }

    /* renamed from: w */
    public static void m5839w(String str, String str2, Object... objArr) {
        if (logImp != null) {
            if (objArr != null) {
                str2 = String.format(str2, objArr);
            }
            logImp.logW(str, "", "", 0, sSystemInterface.myPid(), sSystemInterface.myTid(), sSystemInterface.mainTid(), str2 == null ? "" : str2);
        }
    }

    /* renamed from: i */
    public static void m5843i(String str, String str2, Object... objArr) {
        if (logImp != null) {
            if (objArr != null) {
                str2 = String.format(str2, objArr);
            }
            logImp.logI(str, fileName, "", 0, sSystemInterface.myPid(), sSystemInterface.myTid(), sSystemInterface.mainTid(), str2 == null ? "" : str2);
        }
    }

    /* renamed from: d */
    public static void m5849d(String str, String str2, Object... objArr) {
        if (logImp != null) {
            if (objArr != null) {
                str2 = String.format(str2, objArr);
            }
            logImp.logD(str, "", "", 0, sSystemInterface.myPid(), sSystemInterface.myTid(), sSystemInterface.mainTid(), str2 == null ? "" : str2);
        }
    }

    /* renamed from: v */
    public static void m5841v(String str, String str2, Object... objArr) {
        if (logImp != null) {
            if (objArr != null) {
                str2 = String.format(str2, objArr);
            }
            logImp.logV(str, "", "", 0, sSystemInterface.myPid(), sSystemInterface.myTid(), sSystemInterface.mainTid(), str2 == null ? "" : str2);
        }
    }

    public static void printErrStackTrace(String str, Throwable th, String str2, Object... objArr) {
        if (logImp != null) {
            if (objArr != null) {
                str2 = String.format(str2, objArr);
            }
            if (str2 == null) {
                str2 = "";
            }
            logImp.logE(str, "", "", 0, sSystemInterface.myPid(), sSystemInterface.myTid(), sSystemInterface.mainTid(), str2 + "  " + Log.getStackTraceString(th));
        }
    }

    static {
        StringBuilder sb = new StringBuilder();
        try {
            sb.append("VERSION.RELEASE:[" + Build.VERSION.RELEASE);
            sb.append("] VERSION.CODENAME:[" + Build.VERSION.CODENAME);
            sb.append("] VERSION.INCREMENTAL:[" + Build.VERSION.INCREMENTAL);
            sb.append("] BOARD:[" + Build.BOARD);
            sb.append("] DEVICE:[" + Build.DEVICE);
            sb.append("] DISPLAY:[" + Build.DISPLAY);
            sb.append("] FINGERPRINT:[" + Build.FINGERPRINT);
            sb.append("] HOST:[" + Build.HOST);
            sb.append("] MANUFACTURER:[" + Build.MANUFACTURER);
            sb.append("] MODEL:[" + Build.MODEL);
            sb.append("] PRODUCT:[" + Build.PRODUCT);
            sb.append("] TAGS:[" + Build.TAGS);
            sb.append("] TYPE:[" + Build.TYPE);
            sb.append("] USER:[" + Build.USER + "]");
        } catch (Throwable th) {
            th.printStackTrace();
        }
        SYS_INFO = sb.toString();
    }

    public static String getSysInfo() {
        return SYS_INFO;
    }
}
