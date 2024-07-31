package com.yanzhenjie.recyclerview.widget;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.annotation.ColorInt;

/* renamed from: com.yanzhenjie.recyclerview.widget.a */
/* loaded from: classes2.dex */
class ColorDrawer extends Drawer {
    public ColorDrawer(int i, int i2, int i3) {
        super(new ColorDrawable(m3739a(i)), i2, i3);
    }

    @ColorInt
    /* renamed from: a */
    public static int m3739a(@ColorInt int i) {
        return Color.alpha(i) == 0 ? i : Color.argb(255, Color.red(i), Color.green(i), Color.blue(i));
    }
}
