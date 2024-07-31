package com.navatics.robot.utils;

/* compiled from: TimeUtils.java */
/* renamed from: com.navatics.robot.utils.o */
/* loaded from: classes2.dex */
public class TimeUtils {
    /* renamed from: a */
    public static String getEnding(int i) {
        if (i < 1 || i > 31) {
            return null;
        }
        if (i >= 11 && i <= 13) {
            return "th";
        }
        switch (i % 10) {
            case 1:
                return "st";
            case 2:
                return "nd";
            case 3:
                return "rd";
            default:
                return "th";
        }
    }
}