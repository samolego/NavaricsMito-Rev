package com.tencent.bugly.crashreport;

import android.support.media.ExifInterface;
import android.util.Log;
import com.tencent.bugly.C2404b;
import com.tencent.bugly.proguard.C2500y;

/* compiled from: BUGLY */
/* loaded from: classes2.dex */
public class BuglyLog {
    /* renamed from: v */
    public static void m5543v(String str, String str2) {
        if (str == null) {
            str = "";
        }
        if (str2 == null) {
            str2 = "null";
        }
        if (C2404b.f7146c) {
            Log.v(str, str2);
        }
        C2500y.m5078a(ExifInterface.GPS_MEASUREMENT_INTERRUPTED, str, str2);
    }

    /* renamed from: d */
    public static void m5547d(String str, String str2) {
        if (str == null) {
            str = "";
        }
        if (str2 == null) {
            str2 = "null";
        }
        if (C2404b.f7146c) {
            Log.d(str, str2);
        }
        C2500y.m5078a("D", str, str2);
    }

    /* renamed from: i */
    public static void m5544i(String str, String str2) {
        if (str == null) {
            str = "";
        }
        if (str2 == null) {
            str2 = "null";
        }
        if (C2404b.f7146c) {
            Log.i(str, str2);
        }
        C2500y.m5078a("I", str, str2);
    }

    /* renamed from: w */
    public static void m5542w(String str, String str2) {
        if (str == null) {
            str = "";
        }
        if (str2 == null) {
            str2 = "null";
        }
        if (C2404b.f7146c) {
            Log.w(str, str2);
        }
        C2500y.m5078a(ExifInterface.LONGITUDE_WEST, str, str2);
    }

    /* renamed from: e */
    public static void m5546e(String str, String str2) {
        if (str == null) {
            str = "";
        }
        if (str2 == null) {
            str2 = "null";
        }
        if (C2404b.f7146c) {
            Log.e(str, str2);
        }
        C2500y.m5078a(ExifInterface.LONGITUDE_EAST, str, str2);
    }

    /* renamed from: e */
    public static void m5545e(String str, String str2, Throwable th) {
        if (str == null) {
            str = "";
        }
        if (str2 == null) {
            str2 = "null";
        }
        if (C2404b.f7146c) {
            Log.e(str, str2, th);
        }
        C2500y.m5077a(ExifInterface.LONGITUDE_EAST, str, th);
    }

    public static void setCache(int i) {
        C2500y.m5081a(i);
    }
}
