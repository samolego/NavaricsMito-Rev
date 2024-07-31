package com.senseplay.sdk.model.keymap;

/* loaded from: classes2.dex */
public class KeyMapTool {
    public static String to16Hex(int i) {
        String hexString = Integer.toHexString(i);
        if (hexString == null || hexString.length() > 1) {
            return hexString;
        }
        return "0" + hexString;
    }

    public static String binTo16Hex(String str) {
        String hexString = Integer.toHexString(Integer.parseInt(str, 2));
        if (hexString == null || hexString.length() >= 2) {
            return hexString;
        }
        return "0" + hexString;
    }

    public static void main(String[] strArr) {
        System.out.println(to16Hex(17));
    }
}