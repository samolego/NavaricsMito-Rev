package com.stx.xhb.commontitlebar.p058a;

import android.content.Context;
import android.util.TypedValue;

/* compiled from: UIResHelper.java */
/* renamed from: com.stx.xhb.commontitlebar.a.d, reason: use source file name */
/* loaded from: classes2.dex */
public class UIResHelper {
    /* renamed from: a */
    public static float m7265a(Context context, int i) {
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(i, typedValue, true);
        return typedValue.getFloat();
    }

    /* renamed from: b */
    public static int m7266b(Context context, int i) {
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(i, typedValue, true);
        return typedValue.data;
    }

    /* renamed from: c */
    public static int m7267c(Context context, int i) {
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(i, typedValue, true);
        return TypedValue.complexToDimensionPixelSize(typedValue.data, ScreenHelper.m7259a(context));
    }
}