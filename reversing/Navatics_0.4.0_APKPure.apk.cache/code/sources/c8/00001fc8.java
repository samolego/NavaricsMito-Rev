package com.tencent.bugly.proguard;

import android.util.Log;
import java.util.Locale;

/* compiled from: BUGLY */
/* renamed from: com.tencent.bugly.proguard.x */
/* loaded from: classes2.dex */
public final class C2378x {

    /* renamed from: a */
    public static String f7801a = "CrashReport";

    /* renamed from: b */
    public static boolean f7802b = false;

    /* renamed from: c */
    private static String f7803c = "CrashReportInfo";

    /* renamed from: a */
    private static boolean m7761a(int i, String str, Object... objArr) {
        if (!f7802b) {
            return false;
        }
        if (str == null) {
            str = "null";
        } else if (objArr != null && objArr.length != 0) {
            str = String.format(Locale.US, str, objArr);
        }
        if (i != 5) {
            switch (i) {
                case 0:
                    Log.i(f7801a, str);
                    return true;
                case 1:
                    Log.d(f7801a, str);
                    return true;
                case 2:
                    Log.w(f7801a, str);
                    return true;
                case 3:
                    Log.e(f7801a, str);
                    return true;
                default:
                    return false;
            }
        }
        Log.i(f7803c, str);
        return true;
    }

    /* renamed from: a */
    public static boolean m7763a(String str, Object... objArr) {
        return m7761a(0, str, objArr);
    }

    /* renamed from: a */
    public static boolean m7762a(Class cls, String str, Object... objArr) {
        return m7761a(0, String.format(Locale.US, "[%s] %s", cls.getSimpleName(), str), objArr);
    }

    /* renamed from: b */
    public static boolean m7766b(String str, Object... objArr) {
        return m7761a(5, str, objArr);
    }

    /* renamed from: c */
    public static boolean m7768c(String str, Object... objArr) {
        return m7761a(1, str, objArr);
    }

    /* renamed from: b */
    public static boolean m7765b(Class cls, String str, Object... objArr) {
        return m7761a(1, String.format(Locale.US, "[%s] %s", cls.getSimpleName(), str), objArr);
    }

    /* renamed from: d */
    public static boolean m7769d(String str, Object... objArr) {
        return m7761a(2, str, objArr);
    }

    /* renamed from: a */
    public static boolean m7764a(Throwable th) {
        if (f7802b) {
            return m7761a(2, C2380z.m7802a(th), new Object[0]);
        }
        return false;
    }

    /* renamed from: e */
    public static boolean m7770e(String str, Object... objArr) {
        return m7761a(3, str, objArr);
    }

    /* renamed from: b */
    public static boolean m7767b(Throwable th) {
        if (f7802b) {
            return m7761a(3, C2380z.m7802a(th), new Object[0]);
        }
        return false;
    }
}