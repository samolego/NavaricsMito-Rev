package com.stx.xhb.commontitlebar.p058a;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.WindowManager;

/* compiled from: ScreenHelper.java */
/* renamed from: com.stx.xhb.commontitlebar.a.a, reason: use source file name */
/* loaded from: classes2.dex */
public class ScreenHelper {

    /* renamed from: a */
    public static final float f7128a = Resources.getSystem().getDisplayMetrics().density;

    /* renamed from: b */
    public static float f7129b = 0.0f;

    /* renamed from: a */
    public static DisplayMetrics m7259a(Context context) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((WindowManager) context.getApplicationContext().getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
        return displayMetrics;
    }

    /* renamed from: b */
    public static float m7260b(Context context) {
        if (f7129b == 0.0f) {
            f7129b = m7259a(context).density;
        }
        return f7129b;
    }

    /* renamed from: a */
    public static int m7258a(Context context, int i) {
        return (int) ((m7260b(context) * i) + 0.5d);
    }

    /* renamed from: b */
    public static int m7261b(Context context, int i) {
        return (int) ((m7262c(context) * i) + 0.5d);
    }

    /* renamed from: c */
    public static float m7262c(Context context) {
        return context.getResources().getDisplayMetrics().scaledDensity;
    }
}