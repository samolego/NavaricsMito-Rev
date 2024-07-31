package com.tencent.wxop.stat.common;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

/* renamed from: com.tencent.wxop.stat.common.q */
/* loaded from: classes2.dex */
public class C2574q {

    /* renamed from: a */
    private static SharedPreferences f8094a;

    /* renamed from: a */
    public static int m4797a(Context context, String str, int i) {
        return m4798a(context).getInt(C2569l.m4843a(context, StatConstants.MTA_COOPERATION_TAG + str), i);
    }

    /* renamed from: a */
    public static long m4796a(Context context, String str, long j) {
        return m4798a(context).getLong(C2569l.m4843a(context, StatConstants.MTA_COOPERATION_TAG + str), j);
    }

    /* renamed from: a */
    static synchronized SharedPreferences m4798a(Context context) {
        SharedPreferences sharedPreferences;
        synchronized (C2574q.class) {
            SharedPreferences sharedPreferences2 = context.getSharedPreferences(".mta-wxop", 0);
            f8094a = sharedPreferences2;
            if (sharedPreferences2 == null) {
                f8094a = PreferenceManager.getDefaultSharedPreferences(context);
            }
            sharedPreferences = f8094a;
        }
        return sharedPreferences;
    }

    /* renamed from: a */
    public static String m4795a(Context context, String str, String str2) {
        return m4798a(context).getString(C2569l.m4843a(context, StatConstants.MTA_COOPERATION_TAG + str), str2);
    }

    /* renamed from: b */
    public static void m4794b(Context context, String str, int i) {
        String m4843a = C2569l.m4843a(context, StatConstants.MTA_COOPERATION_TAG + str);
        SharedPreferences.Editor edit = m4798a(context).edit();
        edit.putInt(m4843a, i);
        edit.commit();
    }

    /* renamed from: b */
    public static void m4793b(Context context, String str, long j) {
        String m4843a = C2569l.m4843a(context, StatConstants.MTA_COOPERATION_TAG + str);
        SharedPreferences.Editor edit = m4798a(context).edit();
        edit.putLong(m4843a, j);
        edit.commit();
    }

    /* renamed from: b */
    public static void m4792b(Context context, String str, String str2) {
        String m4843a = C2569l.m4843a(context, StatConstants.MTA_COOPERATION_TAG + str);
        SharedPreferences.Editor edit = m4798a(context).edit();
        edit.putString(m4843a, str2);
        edit.commit();
    }
}
