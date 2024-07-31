package com.tencent.bugly.proguard;

import android.util.Log;
import java.util.Locale;

/* compiled from: BUGLY */
/* renamed from: com.tencent.bugly.proguard.x */
/* loaded from: classes2.dex */
public final class C2499x {

    /* renamed from: a */
    public static String f7763a = "CrashReport";

    /* renamed from: b */
    public static boolean f7764b = false;

    /* renamed from: c */
    private static String f7765c = "CrashReportInfo";

    /* renamed from: a */
    private static boolean m5092a(int i, String str, Object... objArr) {
        if (f7764b) {
            if (str == null) {
                str = "null";
            } else if (objArr != null && objArr.length != 0) {
                str = String.format(Locale.US, str, objArr);
            }
            if (i != 5) {
                switch (i) {
                    case 0:
                        Log.i(f7763a, str);
                        return true;
                    case 1:
                        Log.d(f7763a, str);
                        return true;
                    case 2:
                        Log.w(f7763a, str);
                        return true;
                    case 3:
                        Log.e(f7763a, str);
                        return true;
                    default:
                        return false;
                }
            }
            Log.i(f7765c, str);
            return true;
        }
        return false;
    }

    /* renamed from: a */
    public static boolean m5090a(String str, Object... objArr) {
        return m5092a(0, str, objArr);
    }

    /* renamed from: a */
    public static boolean m5091a(Class cls, String str, Object... objArr) {
        return m5092a(0, String.format(Locale.US, "[%s] %s", cls.getSimpleName(), str), objArr);
    }

    /* renamed from: b */
    public static boolean m5087b(String str, Object... objArr) {
        return m5092a(5, str, objArr);
    }

    /* renamed from: c */
    public static boolean m5085c(String str, Object... objArr) {
        return m5092a(1, str, objArr);
    }

    /* renamed from: b */
    public static boolean m5088b(Class cls, String str, Object... objArr) {
        return m5092a(1, String.format(Locale.US, "[%s] %s", cls.getSimpleName(), str), objArr);
    }

    /* renamed from: d */
    public static boolean m5084d(String str, Object... objArr) {
        return m5092a(2, str, objArr);
    }

    /* renamed from: a */
    public static boolean m5089a(Throwable th) {
        if (f7764b) {
            return m5092a(2, C2503z.m5039a(th), new Object[0]);
        }
        return false;
    }

    /* renamed from: e */
    public static boolean m5083e(String str, Object... objArr) {
        return m5092a(3, str, objArr);
    }

    /* renamed from: b */
    public static boolean m5086b(Throwable th) {
        if (f7764b) {
            return m5092a(3, C2503z.m5039a(th), new Object[0]);
        }
        return false;
    }
}
