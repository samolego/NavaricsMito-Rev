package com.stx.xhb.commontitlebar.p068a;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.WindowManager;

/* renamed from: com.stx.xhb.commontitlebar.a.a */
/* loaded from: classes2.dex */
public class ScreenHelper {

    /* renamed from: a */
    public static final float f7094a = Resources.getSystem().getDisplayMetrics().density;

    /* renamed from: b */
    public static float f7095b = 0.0f;

    /* renamed from: a */
    public static DisplayMetrics m5595a(Context context) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((WindowManager) context.getApplicationContext().getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
        return displayMetrics;
    }

    /* renamed from: b */
    public static float m5593b(Context context) {
        if (f7095b == 0.0f) {
            f7095b = m5595a(context).density;
        }
        return f7095b;
    }

    /* renamed from: a */
    public static int m5594a(Context context, int i) {
        return (int) ((m5593b(context) * i) + 0.5d);
    }

    /* renamed from: b */
    public static int m5592b(Context context, int i) {
        return (int) ((m5591c(context) * i) + 0.5d);
    }

    /* renamed from: c */
    public static float m5591c(Context context) {
        return context.getResources().getDisplayMetrics().scaledDensity;
    }
}
