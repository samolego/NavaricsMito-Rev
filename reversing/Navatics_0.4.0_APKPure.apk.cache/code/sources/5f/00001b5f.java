package com.navatics.robot.math;

import java.util.Random;

/* compiled from: MathUtils.java */
/* renamed from: com.navatics.robot.math.b */
/* loaded from: classes.dex */
public final class MathUtils {

    /* renamed from: a */
    public static Random f6212a = new Random();

    /* renamed from: a */
    public static float m6282a(float f, float f2, float f3) {
        return f < f2 ? f2 : f > f3 ? f3 : f;
    }

    /* compiled from: MathUtils.java */
    /* renamed from: com.navatics.robot.math.b$a */
    /* loaded from: classes.dex */
    private static class a {

        /* renamed from: a */
        static final float[] f6213a = new float[16384];

        static {
            for (int i = 0; i < 16384; i++) {
                f6213a[i] = (float) Math.sin(((i + 0.5f) / 16384.0f) * 6.2831855f);
            }
            for (int i2 = 0; i2 < 360; i2 += 90) {
                f6213a[((int) (45.511112f * i2)) & 16383] = (float) Math.sin(r2 * 0.017453292f);
            }
        }
    }

    /* renamed from: a */
    public static float m6280a(float f) {
        return a.f6213a[((int) (f * 2607.5945f)) & 16383];
    }

    /* renamed from: b */
    public static float m6283b(float f) {
        return a.f6213a[((int) ((f + 1.5707964f) * 2607.5945f)) & 16383];
    }

    /* renamed from: c */
    public static float m6286c(float f) {
        return a.f6213a[((int) (f * 45.511112f)) & 16383];
    }

    /* renamed from: d */
    public static float m6288d(float f) {
        return a.f6213a[((int) ((f + 90.0f) * 45.511112f)) & 16383];
    }

    /* renamed from: a */
    public static float m6281a(float f, float f2) {
        if (f2 == 0.0f) {
            if (f > 0.0f) {
                return 1.5707964f;
            }
            return f == 0.0f ? 0.0f : -1.5707964f;
        }
        float f3 = f / f2;
        if (Math.abs(f3) >= 1.0f) {
            float f4 = 1.5707964f - (f3 / ((f3 * f3) + 0.28f));
            return f < 0.0f ? f4 - 3.1415927f : f4;
        }
        float f5 = f3 / (((0.28f * f3) * f3) + 1.0f);
        if (f2 < 0.0f) {
            return f5 + (f < 0.0f ? -3.1415927f : 3.1415927f);
        }
        return f5;
    }

    /* renamed from: a */
    public static float m6279a() {
        return f6212a.nextFloat();
    }

    /* renamed from: b */
    public static float m6284b(float f, float f2) {
        return f + (f6212a.nextFloat() * (f2 - f));
    }

    /* renamed from: e */
    public static boolean m6290e(float f) {
        return Math.abs(f) <= 1.0E-6f;
    }

    /* renamed from: c */
    public static boolean m6287c(float f, float f2) {
        return Math.abs(f) <= f2;
    }

    /* renamed from: d */
    public static boolean m6289d(float f, float f2) {
        return Math.abs(f - f2) <= 1.0E-6f;
    }

    /* renamed from: b */
    public static boolean m6285b(float f, float f2, float f3) {
        return Math.abs(f - f2) <= f3;
    }
}