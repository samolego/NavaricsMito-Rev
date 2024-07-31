package com.navatics.robot.utils;

/* compiled from: StringUtils.java */
/* renamed from: com.navatics.robot.utils.n */
/* loaded from: classes2.dex */
public class StringUtils {
    /* renamed from: a */
    public static boolean isEmpty(CharSequence charSequence) {
        return charSequence == null || charSequence.length() == 0;
    }

    /* renamed from: a */
    public static String m6993a(String str) {
        int lastIndexOf;
        return (str == null || str.length() <= 0 || (lastIndexOf = str.lastIndexOf(46)) <= -1 || lastIndexOf >= str.length() + (-1)) ? str : str.substring(lastIndexOf + 1);
    }
}