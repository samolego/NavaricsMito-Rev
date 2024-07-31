package com.senseplay.sdk.tool;

/* loaded from: classes2.dex */
public class HexTool {
    public static String hex10To16(String str) {
        return Integer.toHexString(Integer.parseInt(str));
    }

    public static String hex10To16(String str, int i) {
        String hex10To16 = hex10To16(str);
        int length = hex10To16.length();
        String str2 = "";
        int i2 = 0;
        if (length <= 0 || i <= length) {
            while (i2 < i) {
                str2 = str2 + "0";
                i2++;
            }
            return str2;
        }
        while (i2 < i - length) {
            str2 = str2 + "0";
            i2++;
        }
        return str2 + hex10To16;
    }

    public static String stringToAscii(String str) {
        if (str == null) {
            return "";
        }
        StringBuffer stringBuffer = new StringBuffer();
        for (char c : str.toCharArray()) {
            stringBuffer.append((int) c);
        }
        return stringBuffer.toString();
    }
}
