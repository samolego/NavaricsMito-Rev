package com.senseplay.sdk.model.keymap;

/* loaded from: classes2.dex */
public class PackUtil {
    public static byte[] pack(String str) {
        byte b;
        byte[] bArr = new byte[(str.length() / 2) + (str.length() % 2)];
        int i = 4;
        int i2 = 0;
        for (char c : str.toCharArray()) {
            byte b2 = (byte) c;
            if (b2 >= 48 && b2 <= 57) {
                b = (byte) (b2 - 48);
            } else if (b2 < 65 || b2 > 70) {
                if (b2 >= 97 && b2 <= 102) {
                    b = (byte) (b2 - 87);
                }
            } else {
                b = (byte) (b2 - 55);
            }
            bArr[i2] = (byte) ((b << i) | bArr[i2]);
            if (i == 0) {
                i2++;
            }
            i = (i + 4) & 7;
        }
        return bArr;
    }

    public static String unpack(byte[] bArr) {
        StringBuilder sb = new StringBuilder("");
        if (bArr == null || bArr.length <= 0) {
            return null;
        }
        for (byte b : bArr) {
            String hexString = Integer.toHexString(b & 255);
            if (hexString.length() < 2) {
                sb.append(0);
            }
            sb.append(hexString);
        }
        return sb.toString();
    }
}
