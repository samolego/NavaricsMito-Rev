package com.navatics.robot.math;

import java.util.Random;

/* compiled from: MathUtils.java */
/* renamed from: com.navatics.robot.math.b */
/* loaded from: classes.dex */
public final class C2090b {

    /* renamed from: a */
    public static Random f6185a = new Random();

    /* renamed from: a */
    public static float m6577a(float f, float f2, float f3) {
        return f < f2 ? f2 : f > f3 ? f3 : f;
    }

    /* compiled from: MathUtils.java */
    /* renamed from: com.navatics.robot.math.b$a */
    /* loaded from: classes.dex */
    private static class C2091a {

        /* renamed from: a */
        static final float[] f6186a = new float[16384];

        static {
            float f;
            for (int i = 0; i < 16384; i++) {
                f6186a[i] = (float) Math.sin(((i + 0.5f) / 16384.0f) * 6.2831855f);
            }
            for (int i2 = 0; i2 < 360; i2 += 90) {
                f6186a[((int) (45.511112f * i2)) & 16383] = (float) Math.sin(f * 0.017453292f);
            }
        }
    }

    /* renamed from: a */
    public static float m6579a(float f) {
        return C2091a.f6186a[((int) (f * 2607.5945f)) & 16383];
    }

    /* renamed from: b */
    public static float m6576b(float f) {
        return C2091a.f6186a[((int) ((f + 1.5707964f) * 2607.5945f)) & 16383];
    }

    /* renamed from: c */
    public static float m6573c(float f) {
        return C2091a.f6186a[((int) (f * 45.511112f)) & 16383];
    }

    /* renamed from: d */
    public static float m6571d(float f) {
        return C2091a.f6186a[((int) ((f + 90.0f) * 45.511112f)) & 16383];
    }

    /* renamed from: a */
    public static float m6578a(float f, float f2) {
        if (f2 == 0.0f) {
            int i = (f > 0.0f ? 1 : (f == 0.0f ? 0 : -1));
            if (i > 0) {
                return 1.5707964f;
            }
            return i == 0 ? 0.0f : -1.5707964f;
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
    public static float m6580a() {
        return f6185a.nextFloat();
    }

    /* renamed from: b */
    public static float m6575b(float f, float f2) {
        return f + (f6185a.nextFloat() * (f2 - f));
    }

    /* renamed from: e */
    public static boolean m6569e(float f) {
        return Math.abs(f) <= 1.0E-6f;
    }

    /* renamed from: c */
    public static boolean m6572c(float f, float f2) {
        return Math.abs(f) <= f2;
    }

    /* renamed from: d */
    public static boolean m6570d(float f, float f2) {
        return Math.abs(f - f2) <= 1.0E-6f;
    }

    /* renamed from: b */
    public static boolean m6574b(float f, float f2, float f3) {
        return Math.abs(f - f2) <= f3;
    }
}
