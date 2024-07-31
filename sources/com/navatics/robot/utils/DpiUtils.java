package com.navatics.robot.utils;

import android.content.Context;

/* renamed from: com.navatics.robot.utils.f */
/* loaded from: classes2.dex */
public class DpiUtils {
    /* renamed from: a */
    public static int m5887a(Context context, float f) {
        return (int) ((f * context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    /* renamed from: b */
    public static int m5886b(Context context, float f) {
        return (int) ((f * context.getResources().getDisplayMetrics().scaledDensity) + 0.5f);
    }
}
