package com.stx.xhb.commontitlebar.p068a;

import android.content.Context;
import android.util.TypedValue;

/* renamed from: com.stx.xhb.commontitlebar.a.d */
/* loaded from: classes2.dex */
public class UIResHelper {
    /* renamed from: a */
    public static float m5588a(Context context, int i) {
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(i, typedValue, true);
        return typedValue.getFloat();
    }

    /* renamed from: b */
    public static int m5587b(Context context, int i) {
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(i, typedValue, true);
        return typedValue.data;
    }

    /* renamed from: c */
    public static int m5586c(Context context, int i) {
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(i, typedValue, true);
        return TypedValue.complexToDimensionPixelSize(typedValue.data, ScreenHelper.m5595a(context));
    }
}
