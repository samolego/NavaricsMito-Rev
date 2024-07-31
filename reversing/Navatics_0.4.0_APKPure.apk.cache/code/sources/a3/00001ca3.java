package com.navatics.robot.utils;

/* compiled from: Validate.java */
/* renamed from: com.navatics.robot.utils.q */
/* loaded from: classes2.dex */
public class Validate {
    /* renamed from: a */
    public static void assertTrue(boolean bool, String str, Object... objArr) {
        if (!bool) {
            throw new IllegalArgumentException(String.format(str, objArr));
        }
    }
}