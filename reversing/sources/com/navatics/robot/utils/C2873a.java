package com.navatics.robot.utils;

/* renamed from: com.navatics.robot.utils.a */
/* loaded from: classes2.dex */
public class Base64 {

    /* renamed from: a */
    private static final char[] f6731a = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/".toCharArray();

    /* renamed from: a */
    public static String m5945a(byte[] bArr) {
        int length = bArr.length;
        StringBuffer stringBuffer = new StringBuffer((bArr.length * 3) / 2);
        int i = length - 3;
        int i2 = 0;
        int i3 = 0;
        while (i2 <= i) {
            int i4 = ((bArr[i2] & 255) << 16) | ((bArr[i2 + 1] & 255) << 8) | (bArr[i2 + 2] & 255);
            stringBuffer.append(f6731a[(i4 >> 18) & 63]);
            stringBuffer.append(f6731a[(i4 >> 12) & 63]);
            stringBuffer.append(f6731a[(i4 >> 6) & 63]);
            stringBuffer.append(f6731a[i4 & 63]);
            i2 += 3;
            int i5 = i3 + 1;
            if (i3 >= 14) {
                stringBuffer.append(" ");
                i3 = 0;
            } else {
                i3 = i5;
            }
        }
        int i6 = 0 + length;
        if (i2 == i6 - 2) {
            int i7 = ((bArr[i2 + 1] & 255) << 8) | ((bArr[i2] & 255) << 16);
            stringBuffer.append(f6731a[(i7 >> 18) & 63]);
            stringBuffer.append(f6731a[(i7 >> 12) & 63]);
            stringBuffer.append(f6731a[(i7 >> 6) & 63]);
            stringBuffer.append("=");
        } else if (i2 == i6 - 1) {
            int i8 = (bArr[i2] & 255) << 16;
            stringBuffer.append(f6731a[(i8 >> 18) & 63]);
            stringBuffer.append(f6731a[(i8 >> 12) & 63]);
            stringBuffer.append("==");
        }
        return stringBuffer.toString();
    }
}
