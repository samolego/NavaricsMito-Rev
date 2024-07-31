package com.navatics.robot.utils;

import android.content.Context;

/* compiled from: Util.java */
/* renamed from: com.navatics.robot.utils.p */
/* loaded from: classes2.dex */
public class Util {
    /* renamed from: a */
    public static String getAppVersion(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
        } catch (Exception e) {
            e.printStackTrace();
            return "1.0.0";
        }
    }
}