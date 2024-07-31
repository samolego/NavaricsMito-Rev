package com.misc;

import android.util.Log;
import java.io.File;

/* loaded from: classes.dex */
public class util {
    public static int isOdd(int i) {
        return i & 1;
    }

    public static int HexToInt(String str) {
        return Integer.parseInt(str, 16);
    }

    public static byte HexToByte(String str) {
        return (byte) Integer.parseInt(str, 16);
    }

    public static String Byte2Hex(Byte b) {
        return String.format("%02x", b).toUpperCase();
    }

    public static String ByteArrToHex(byte[] bArr) {
        StringBuilder sb = new StringBuilder();
        for (byte b : bArr) {
            sb.append(Byte2Hex(Byte.valueOf(b)));
            sb.append(" ");
        }
        return sb.toString();
    }

    public static String ByteArrToHex(byte[] bArr, int i, int i2) {
        StringBuilder sb = new StringBuilder();
        while (i < i2) {
            sb.append(Byte2Hex(Byte.valueOf(bArr[i])));
            i++;
        }
        return sb.toString();
    }

    public static byte[] HexToByteArr(String str) {
        byte[] bArr;
        int length = str.length();
        if (isOdd(length) == 1) {
            length++;
            bArr = new byte[length / 2];
            str = "0" + str;
        } else {
            bArr = new byte[length / 2];
        }
        int i = 0;
        int i2 = 0;
        while (i < length) {
            int i3 = i + 2;
            bArr[i2] = HexToByte(str.substring(i, i3));
            i2++;
            i = i3;
        }
        return bArr;
    }

    public static String bytesToHexString(byte[] bArr) {
        StringBuilder sb = new StringBuilder("");
        if (bArr == null || bArr.length <= 0) {
            return null;
        }
        for (byte b : bArr) {
            String hexString = Integer.toHexString(b & 255);
            sb.append("0x");
            if (hexString.length() < 2) {
                sb.append(0);
            }
            sb.append(hexString);
            sb.append("-");
        }
        return sb.toString();
    }

    public static String bytesToHexString(byte[] bArr, int i) {
        StringBuilder sb = new StringBuilder("");
        if (bArr == null || i <= 0) {
            return null;
        }
        for (int i2 = 0; i2 < i; i2++) {
            String hexString = Integer.toHexString(bArr[i2] & 255);
            sb.append("0x");
            if (hexString.length() < 2) {
                sb.append(0);
            }
            sb.append(hexString);
            sb.append("-");
        }
        return sb.toString();
    }

    public static String bytes2hex02(byte[] bArr) {
        StringBuilder sb = new StringBuilder();
        for (byte b : bArr) {
            String hexString = Integer.toHexString(b & 255);
            sb.append("0x");
            if (hexString.length() == 1) {
                hexString = "0" + hexString;
            }
            sb.append(hexString);
            sb.append(",");
        }
        return sb.toString();
    }

    public static short bytes2Short(byte[] bArr) {
        return (short) (bArr[0] | ((short) (bArr[1] << 8)));
    }

    public static byte[] bytesPatch(byte[] bArr, int i) {
        if (bArr.length >= i) {
            return bArr;
        }
        byte[] bArr2 = new byte[i];
        for (int i2 = 0; i2 < i; i2++) {
            bArr2[i2] = 0;
        }
        for (int i3 = 0; i3 < bArr.length; i3++) {
            bArr2[i3] = bArr[i3];
        }
        return bArr2;
    }

    public static byte[] getValidBytes(byte[] bArr) {
        int length = bArr.length;
        int i = 0;
        while (i < length && bArr[i] != 0) {
            i++;
        }
        byte[] bArr2 = new byte[i];
        for (int i2 = 0; i2 < i; i2++) {
            bArr2[i2] = bArr[i2];
        }
        return bArr2;
    }

    public static File makeFilePath(String str, String str2) {
        File file;
        makeRootDirectory(str);
        try {
            file = new File(str + str2);
            try {
                if (!file.exists()) {
                    file.createNewFile();
                }
            } catch (Exception e) {
                e = e;
                e.printStackTrace();
                return file;
            }
        } catch (Exception e2) {
            e = e2;
            file = null;
        }
        return file;
    }

    private static void makeRootDirectory(String str) {
        try {
            File file = new File(str);
            if (file.exists()) {
                return;
            }
            file.mkdir();
        } catch (Exception e) {
            Log.i("error:", e + "");
        }
    }
}