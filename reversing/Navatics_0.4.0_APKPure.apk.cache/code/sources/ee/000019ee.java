package com.navatics.app.utils;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.WindowManager;

/* compiled from: MeasureUtil.java */
/* renamed from: com.navatics.app.utils.k, reason: use source file name */
/* loaded from: classes.dex */
public final class MeasureUtil {
    /* renamed from: a */
    public static int[] m5518a(Context context) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
        return new int[]{displayMetrics.widthPixels, displayMetrics.heightPixels};
    }

    /* renamed from: a */
    public static Bitmap m5516a(int i, int i2, Bitmap.Config config, int i3) {
        try {
            return Bitmap.createBitmap(i, i2, config);
        } catch (OutOfMemoryError e) {
            e.printStackTrace();
            if (i3 <= 0) {
                return null;
            }
            System.gc();
            return m5516a(i, i2, config, i3 - 1);
        }
    }

    /* renamed from: a */
    public static Bitmap m5517a(View view, int i, int i2) {
        if (view == null) {
            return null;
        }
        view.measure(View.MeasureSpec.makeMeasureSpec(i, 1073741824), View.MeasureSpec.makeMeasureSpec(i2, 1073741824));
        view.layout(0, 0, i, i2);
        view.buildDrawingCache();
        Bitmap drawingCache = view.getDrawingCache();
        if (drawingCache == null) {
            return null;
        }
        Bitmap createBitmap = Bitmap.createBitmap(drawingCache);
        view.destroyDrawingCache();
        return createBitmap;
    }

    /* renamed from: b */
    public static Bitmap m5519b(View view, int i, int i2) {
        Bitmap bitmap = null;
        try {
            bitmap = Bitmap.createBitmap(i, i2, Bitmap.Config.ARGB_8888);
            view.draw(new Canvas(bitmap));
            return bitmap;
        } catch (OutOfMemoryError e) {
            e.printStackTrace();
            return bitmap;
        }
    }
}