package com.yanzhenjie.sofia;

import android.app.Activity;
import android.os.Build;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/* compiled from: Utils.java */
/* renamed from: com.yanzhenjie.sofia.d */
/* loaded from: classes2.dex */
public class C2803d {
    /* renamed from: a */
    public static void m3723a(Activity activity, int i) {
        if (Build.VERSION.SDK_INT >= 21) {
            Window window = activity.getWindow();
            window.addFlags(Integer.MIN_VALUE);
            window.setStatusBarColor(i);
        }
    }

    /* renamed from: b */
    public static void m3720b(Activity activity, int i) {
        if (Build.VERSION.SDK_INT >= 21) {
            Window window = activity.getWindow();
            window.addFlags(Integer.MIN_VALUE);
            window.setNavigationBarColor(i);
        }
    }

    /* renamed from: a */
    public static void m3724a(Activity activity) {
        if (Build.VERSION.SDK_INT >= 21) {
            Window window = activity.getWindow();
            View decorView = window.getDecorView();
            decorView.setSystemUiVisibility(decorView.getSystemUiVisibility() | 1024 | 256);
            window.setStatusBarColor(0);
        }
    }

    /* renamed from: b */
    public static void m3721b(Activity activity) {
        if (Build.VERSION.SDK_INT >= 21) {
            Window window = activity.getWindow();
            View decorView = window.getDecorView();
            decorView.setSystemUiVisibility(decorView.getSystemUiVisibility() | 512 | 256);
            window.setNavigationBarColor(0);
        }
    }

    /* renamed from: a */
    public static boolean m3722a(Activity activity, boolean z) {
        if (m3718c(activity, z)) {
            m3717d(activity, z);
            return true;
        } else if (m3719b(activity, z)) {
            m3717d(activity, z);
            return true;
        } else {
            return m3717d(activity, z);
        }
    }

    /* renamed from: b */
    private static boolean m3719b(Activity activity, boolean z) {
        try {
            WindowManager.LayoutParams attributes = activity.getWindow().getAttributes();
            Field declaredField = WindowManager.LayoutParams.class.getDeclaredField("MEIZU_FLAG_DARK_STATUS_BAR_ICON");
            Field declaredField2 = WindowManager.LayoutParams.class.getDeclaredField("meizuFlags");
            declaredField.setAccessible(true);
            declaredField2.setAccessible(true);
            int i = declaredField.getInt(null);
            int i2 = declaredField2.getInt(attributes);
            declaredField2.setInt(attributes, z ? i2 | i : (~i) & i2);
            activity.getWindow().setAttributes(attributes);
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    /* renamed from: c */
    private static boolean m3718c(Activity activity, boolean z) {
        Window window = activity.getWindow();
        Class<?> cls = window.getClass();
        try {
            Class<?> cls2 = Class.forName("android.view.MiuiWindowManager$LayoutParams");
            int i = cls2.getField("EXTRA_FLAG_STATUS_BAR_DARK_MODE").getInt(cls2);
            Method method = cls.getMethod("setExtraFlags", Integer.TYPE, Integer.TYPE);
            if (z) {
                method.invoke(window, Integer.valueOf(i), Integer.valueOf(i));
            } else {
                method.invoke(window, 0, Integer.valueOf(i));
            }
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    /* renamed from: d */
    private static boolean m3717d(Activity activity, boolean z) {
        if (Build.VERSION.SDK_INT >= 23) {
            View decorView = activity.getWindow().getDecorView();
            if (z) {
                decorView.setSystemUiVisibility(decorView.getSystemUiVisibility() | 8192);
                return true;
            }
            decorView.setSystemUiVisibility(decorView.getSystemUiVisibility() & (-8193));
            return true;
        }
        return false;
    }
}
