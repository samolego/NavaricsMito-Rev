package com.usbsearch;

/* loaded from: classes2.dex */
public class UsbTool {
    public static short hexStr2Short(String str) {
        short s;
        byte[] hexStringToBytes = hexStringToBytes(str);
        if (hexStringToBytes.length == 1) {
            s = (short) (hexStringToBytes[0] & 255);
        } else {
            s = (short) (((short) (hexStringToBytes[1] & 255)) | ((short) (((short) (hexStringToBytes[0] & 255)) << 8)));
        }
        return (short) (s & 65535);
    }

    public static byte[] hexStringToBytes(String str) {
        if (str == null || str.equals("")) {
            return null;
        }
        String upperCase = str.toUpperCase();
        int length = upperCase.length() / 2;
        char[] charArray = upperCase.toCharArray();
        byte[] bArr = new byte[length];
        for (int i = 0; i < length; i++) {
            int i2 = i * 2;
            bArr[i] = (byte) (charToByte(charArray[i2 + 1]) | (charToByte(charArray[i2]) << 4));
        }
        return bArr;
    }

    private static byte charToByte(char c) {
        return (byte) "0123456789ABCDEF".indexOf(c);
    }
}
