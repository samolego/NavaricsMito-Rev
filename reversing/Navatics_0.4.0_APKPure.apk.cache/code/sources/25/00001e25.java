package com.senseplay.sdk.model.robot;

/* loaded from: classes2.dex */
public class CRC16Util {
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v2 */
    /* JADX WARN: Type inference failed for: r3v4, types: [int] */
    /* JADX WARN: Type inference failed for: r3v5 */
    /* JADX WARN: Type inference failed for: r3v7 */
    public static String getCRC2(byte[] bArr) {
        int i = 0;
        byte b = 65535;
        while (i < bArr.length) {
            byte b2 = b ^ bArr[i];
            int i2 = 0;
            while (i2 < 8) {
                i2++;
                b2 = (b2 & 1) == 1 ? (b2 >> 1) ^ 40961 : b2 >> 1;
            }
            i++;
            b = b2;
        }
        return Integer.toHexString(b);
    }

    public static void main(String[] strArr) {
        System.out.println(getCRC2(new byte[]{1, 2, 3, 4, 5}));
    }
}