package com.navatics.app.utils;

import android.graphics.PointF;
import com.github.mikephil.charting.utils.Utils;
import java.util.List;

/* renamed from: com.navatics.app.utils.j */
/* loaded from: classes.dex */
public class MathUtils {
    /* renamed from: a */
    public static double m7379a(double d) {
        return (d / 6.283185307179586d) * 360.0d;
    }

    /* renamed from: a */
    public static double m7378a(double d, int i) {
        if (d < Utils.DOUBLE_EPSILON) {
            d += 1.5707963267948966d;
        }
        return d + ((i - 1) * 1.5707963267948966d);
    }

    /* renamed from: a */
    public static int m7376a(PointF pointF, PointF pointF2) {
        if (pointF.x > pointF2.x) {
            if (pointF.y > pointF2.y) {
                return 4;
            }
            return pointF.y < pointF2.y ? 1 : -1;
        } else if (pointF.x < pointF2.x) {
            if (pointF.y > pointF2.y) {
                return 3;
            }
            return pointF.y < pointF2.y ? 2 : -1;
        } else {
            return -1;
        }
    }

    /* renamed from: b */
    public static float m7375b(PointF pointF, PointF pointF2) {
        return (float) Math.sqrt(Math.pow(pointF.x - pointF2.x, 2.0d) + Math.pow(pointF.y - pointF2.y, 2.0d));
    }

    /* renamed from: a */
    public static void m7377a(PointF pointF, float f, Double d, List<PointF> list) {
        float f2;
        if (d != null) {
            double atan = (float) Math.atan(d.doubleValue());
            double d2 = f;
            f2 = (float) (Math.sin(atan) * d2);
            f = (float) (Math.cos(atan) * d2);
        } else {
            f2 = 0.0f;
        }
        list.add(new PointF(pointF.x + f, pointF.y + f2));
        list.add(new PointF(pointF.x - f, pointF.y - f2));
    }
}
