package com.common;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

/* loaded from: classes.dex */
public class SP_Util {
    public static int byteToInt(byte b) {
        return b & 255;
    }

    public static byte intToByte(int i) {
        return (byte) (i & 255);
    }

    public static int byteArrayToInt(byte[] bArr, int i) {
        return ((bArr[i + 3] & 255) << 24) | (bArr[i] & 255) | ((bArr[i + 1] & 255) << 8) | ((bArr[i + 2] & 255) << 16);
    }

    public static byte[] intToByteArr(int i) {
        return new byte[]{(byte) ((i >>> 0) & 255), (byte) ((i >>> 8) & 255), (byte) ((i >>> 16) & 255), (byte) ((i >>> 24) & 255)};
    }

    public static short byteArrayToShort(byte[] bArr, int i) {
        if ((bArr.length - 1) - i < 2) {
            return (short) -1;
        }
        return (short) (((bArr[i + 1] & 255) << 8) | (bArr[i] & 255));
    }

    public static int arryCp(byte[] bArr, byte[] bArr2, int i) {
        System.arraycopy(bArr, i, bArr2, 0, bArr2.length);
        return i + bArr2.length;
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

    public static String byte2str(byte[] bArr) {
        StringBuilder sb = new StringBuilder("");
        if (bArr == null || bArr.length <= 0) {
            return null;
        }
        for (int i = 0; i < bArr.length; i++) {
            int i2 = bArr[i] & 255;
            if (i % 4 == 0 && i != 0) {
                sb.append(" ");
            }
            String hexString = Integer.toHexString(i2);
            if (hexString.length() < 2) {
                sb.append(0);
            }
            sb.append(hexString);
        }
        return sb.toString();
    }

    public static String byte2str(byte[] bArr, int i) {
        StringBuilder sb = new StringBuilder("");
        if (bArr == null || bArr.length <= 0 || i <= 0) {
            return null;
        }
        int min = Math.min(i, bArr.length);
        for (int i2 = 0; i2 < min; i2++) {
            int i3 = bArr[i2] & 255;
            if (i2 % 4 == 0 && i2 != 0) {
                sb.append(" ");
            }
            String hexString = Integer.toHexString(i3);
            if (hexString.length() < 2) {
                sb.append(0);
            }
            sb.append(hexString);
        }
        return sb.toString();
    }

    public static String byte2str(byte b) {
        StringBuilder sb = new StringBuilder("");
        String hexString = Integer.toHexString(b & 255);
        if (hexString.length() < 2) {
            sb.append(0);
        }
        sb.append(hexString);
        return sb.toString();
    }

    public static boolean isFolderExists(String str) {
        File file = new File(str);
        return file.exists() || file.mkdirs();
    }

    public static String fileName() {
        return new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss").format(new Date(System.currentTimeMillis())).replace(":", "");
    }
}