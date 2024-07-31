package com.senseplay.sdk.tool;

/* loaded from: classes2.dex */
public class SPDataTool {
    public static int byteToInt(byte b) {
        return b & 255;
    }

    public static byte intToByte(int i) {
        return (byte) i;
    }

    public static byte[] intToByteArray(int i) {
        return new byte[]{(byte) ((i >> 24) & 255), (byte) ((i >> 16) & 255), (byte) ((i >> 8) & 255), (byte) (i & 255)};
    }

    public static int byteArrayToInt(byte[] bArr) {
        int i = 0;
        for (int i2 = 0; i2 < 4; i2++) {
            i += (bArr[i2] & 255) << ((3 - i2) * 8);
        }
        return i;
    }

    public static String bytes2hex02(byte[] bArr) {
        StringBuilder sb = new StringBuilder();
        for (byte b : bArr) {
            String upperCase = Integer.toHexString(b & 255).toUpperCase();
            sb.append("0x");
            if (upperCase.length() == 1) {
                upperCase = "0" + upperCase;
            }
            sb.append(upperCase);
        }
        return sb.toString();
    }

    public static String byte2hex02(byte b) {
        StringBuilder sb = new StringBuilder();
        String upperCase = Integer.toHexString(b & 255).toUpperCase();
        sb.append("0x");
        if (upperCase.length() == 1) {
            upperCase = "0" + upperCase;
        }
        sb.append(upperCase);
        return sb.toString();
    }
}
