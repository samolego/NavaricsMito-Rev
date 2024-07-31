package com.navatics.robot.utils;

import java.util.Random;

/* renamed from: com.navatics.robot.utils.k */
/* loaded from: classes2.dex */
public class RandomUtils {

    /* renamed from: a */
    private static final Random f6775a = new Random();

    /* renamed from: a */
    public static int m5869a(int i, int i2) {
        C2162q.m5851a(i2 >= i, "Start value must be smaller or equal to end value.", new Object[0]);
        C2162q.m5851a(i >= 0, "Both range values must be non-negative.", new Object[0]);
        return i == i2 ? i : i + f6775a.nextInt(i2 - i);
    }
}
