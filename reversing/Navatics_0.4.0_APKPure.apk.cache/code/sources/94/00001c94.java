package com.navatics.robot.utils;

import android.content.Context;

/* compiled from: DpiUtils.java */
/* renamed from: com.navatics.robot.utils.f, reason: use source file name */
/* loaded from: classes2.dex */
public class DpiUtils {
    /* renamed from: a */
    public static int m6962a(Context context, float f) {
        return (int) ((f * context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    /* renamed from: b */
    public static int m6963b(Context context, float f) {
        return (int) ((f * context.getResources().getDisplayMetrics().scaledDensity) + 0.5f);
    }
}