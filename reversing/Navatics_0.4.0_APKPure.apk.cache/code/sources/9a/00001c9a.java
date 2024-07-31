package com.navatics.robot.utils;

import java.util.Random;

/* compiled from: RandomUtils.java */
/* renamed from: com.navatics.robot.utils.k, reason: use source file name */
/* loaded from: classes2.dex */
public class RandomUtils {

    /* renamed from: a */
    private static final Random f6806a = new Random();

    /* renamed from: a */
    public static int m6980a(int i, int i2) {
        Validate.assertTrue(i2 >= i, "Start value must be smaller or equal to end value.", new Object[0]);
        Validate.assertTrue(i >= 0, "Both range values must be non-negative.", new Object[0]);
        return i == i2 ? i : i + f6806a.nextInt(i2 - i);
    }
}