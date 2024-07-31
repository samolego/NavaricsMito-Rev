package com.stx.xhb.commontitlebar.p068a;

import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.support.annotation.ColorInt;

/* renamed from: com.stx.xhb.commontitlebar.a.c */
/* loaded from: classes2.dex */
public class UIDrawableHelper {
    /* renamed from: a */
    public static LayerDrawable m5589a(@ColorInt int i, @ColorInt int i2, int i3, boolean z) {
        ShapeDrawable shapeDrawable = new ShapeDrawable();
        shapeDrawable.getPaint().setStyle(Paint.Style.FILL);
        shapeDrawable.getPaint().setColor(i);
        ShapeDrawable shapeDrawable2 = new ShapeDrawable();
        shapeDrawable2.getPaint().setStyle(Paint.Style.FILL);
        shapeDrawable2.getPaint().setColor(i2);
        LayerDrawable layerDrawable = new LayerDrawable(new Drawable[]{shapeDrawable, shapeDrawable2});
        layerDrawable.setLayerInset(1, 0, z ? i3 : 0, 0, z ? 0 : i3);
        return layerDrawable;
    }
}
