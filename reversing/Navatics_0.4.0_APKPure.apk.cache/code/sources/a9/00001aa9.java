package com.navatics.cv;

/* compiled from: Util.java */
/* renamed from: com.navatics.cv.a */
/* loaded from: classes.dex */
public class Util {

    /* renamed from: a */
    private static final char[] f5825a = "0123456789ABCDEF".toCharArray();

    /* renamed from: a */
    public static String m6007a(byte[] bArr) {
        char[] cArr = new char[bArr.length * 2];
        for (int i = 0; i < bArr.length; i++) {
            int i2 = bArr[i] & 255;
            int i3 = i * 2;
            char[] cArr2 = f5825a;
            cArr[i3] = cArr2[i2 >>> 4];
            cArr[i3 + 1] = cArr2[i2 & 15];
        }
        return new String(cArr);
    }
}