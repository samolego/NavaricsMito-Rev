package com.navatics.app.utils;

import android.content.Context;
import android.os.Build;
import android.provider.Settings;
import android.text.TextUtils;

/* renamed from: com.navatics.app.utils.i */
/* loaded from: classes.dex */
public class LayoutUtils {
    /* renamed from: a */
    public static int m7382a(Context context) {
        if (Build.MODEL.equals("ONEPLUS A5000") || context.getResources().getIdentifier("config_showNavigationBar", "bool", "android") == 0) {
            return 0;
        }
        return context.getResources().getDimensionPixelSize(context.getResources().getIdentifier("navigation_bar_height", "dimen", "android"));
    }

    /* renamed from: b */
    public static boolean m7381b(Context context) {
        return context.getResources().getIdentifier("config_showNavigationBar", "bool", "android") > 0;
    }

    /* renamed from: c */
    public static boolean m7380c(Context context) {
        return Settings.Global.getInt(context.getContentResolver(), m7383a(), 0) != 0;
    }

    /* renamed from: a */
    public static String m7383a() {
        String str = Build.BRAND;
        return (TextUtils.isEmpty(str) || str.equalsIgnoreCase("HUAWEI")) ? "navigationbar_is_min" : str.equalsIgnoreCase("XIAOMI") ? "force_fsg_nav_bar" : (str.equalsIgnoreCase("VIVO") || str.equalsIgnoreCase("OPPO")) ? "navigation_gesture_on" : "navigationbar_is_min";
    }
}
