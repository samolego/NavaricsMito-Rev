package com.tencent.wxop.stat.common;

import android.content.Context;
import android.os.Build;
import android.provider.Settings;
import java.lang.reflect.Method;

/* renamed from: com.tencent.wxop.stat.common.g */
/* loaded from: classes2.dex */
public class C2564g {

    /* renamed from: c */
    private static volatile C2564g f8046c;

    /* renamed from: a */
    private int f8047a = 10;

    /* renamed from: b */
    private int f8048b;

    /* renamed from: d */
    private Context f8049d;

    /* renamed from: e */
    private boolean f8050e;

    private C2564g(Context context) {
        this.f8048b = 0;
        this.f8049d = null;
        this.f8050e = false;
        this.f8049d = context.getApplicationContext();
        try {
            this.f8050e = C2575r.m4789a(this.f8049d, "android.permission.WRITE_SETTINGS");
            if (!this.f8050e || Build.VERSION.SDK_INT < 23) {
                return;
            }
            Method declaredMethod = Settings.System.class.getDeclaredMethod("canWrite", Context.class);
            declaredMethod.setAccessible(true);
            this.f8050e = ((Boolean) declaredMethod.invoke(null, this.f8049d)).booleanValue();
        } catch (Throwable th) {
            int i = this.f8048b;
            this.f8048b = i + 1;
            if (i < this.f8047a) {
                th.printStackTrace();
            }
        }
    }

    /* renamed from: a */
    public static C2564g m4859a(Context context) {
        if (f8046c == null) {
            synchronized (C2564g.class) {
                if (f8046c == null) {
                    f8046c = new C2564g(context);
                }
            }
        }
        return f8046c;
    }

    /* renamed from: a */
    public String m4858a(String str) {
        try {
            return Settings.System.getString(this.f8049d.getContentResolver(), str);
        } catch (Throwable th) {
            int i = this.f8048b;
            this.f8048b = i + 1;
            if (i < this.f8047a) {
                th.printStackTrace();
                return null;
            }
            return null;
        }
    }

    /* renamed from: a */
    public boolean m4857a(String str, String str2) {
        if (this.f8050e) {
            try {
                return Settings.System.putString(this.f8049d.getContentResolver(), str, str2);
            } catch (Throwable th) {
                int i = this.f8048b;
                this.f8048b = i + 1;
                if (i < this.f8047a) {
                    th.printStackTrace();
                    return false;
                }
                return false;
            }
        }
        return false;
    }
}
