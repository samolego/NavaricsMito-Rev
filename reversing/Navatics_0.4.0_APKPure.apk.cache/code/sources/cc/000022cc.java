package com.yanzhenjie.recyclerview.widget;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.annotation.ColorInt;

/* compiled from: ColorDrawer.java */
/* renamed from: com.yanzhenjie.recyclerview.widget.a, reason: use source file name */
/* loaded from: classes2.dex */
class ColorDrawer extends C2741b {
    public ColorDrawer(int i, int i2, int i3) {
        super(new ColorDrawable(m9103a(i)), i2, i3);
    }

    @ColorInt
    /* renamed from: a */
    public static int m9103a(@ColorInt int i) {
        return Color.alpha(i) == 0 ? i : Color.argb(255, Color.red(i), Color.green(i), Color.blue(i));
    }
}