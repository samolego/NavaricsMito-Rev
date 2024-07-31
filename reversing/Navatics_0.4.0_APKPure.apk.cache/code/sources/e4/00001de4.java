package com.senseplay.sdk.model.dfm;

import android.util.Log;

/* loaded from: classes2.dex */
public class DFMTool {
    private static String getHex(int i) {
        return i == 0 ? "00" : 1 == i ? "01" : 2 == i ? "10" : "00";
    }

    public static DFMFlag readFlag(int i) {
        DFMFlag dFMFlag = new DFMFlag();
        Log.w("DFMTool", " value: " + i);
        String numToHex32 = numToHex32(i);
        Log.w("DFMTool", " temp: " + numToHex32);
        dFMFlag.setDFM_RF_POWER_FLAG(getFlag(numToHex32, 6, 2));
        dFMFlag.setDFM_RF_RSSI_FLAG(getFlag(numToHex32, 4, 2));
        dFMFlag.setDFM_PCBA_CIT_FLAG(getFlag(numToHex32, 2, 2));
        dFMFlag.setDFM_LCD2_FLAG(getFlag(numToHex32, 0, 2));
        return dFMFlag;
    }

    public static int writeFlag(int i, DFMEnum dFMEnum, int i2) {
        DFMFlag readFlag = readFlag(i);
        if (DFMEnum.DFM_RF_POWER_FLAG == dFMEnum) {
            readFlag.setDFM_RF_POWER_FLAG(i2);
        } else if (DFMEnum.DFM_RF_RSSI_FLAG == dFMEnum) {
            readFlag.setDFM_RF_RSSI_FLAG(i2);
        } else if (DFMEnum.DFM_PCBA_CIT_FLAG == dFMEnum) {
            readFlag.setDFM_PCBA_CIT_FLAG(i2);
        } else if (DFMEnum.DFM_LCD2_FLAG == dFMEnum) {
            readFlag.setDFM_LCD2_FLAG(i2);
        }
        String str = getHex(readFlag.getDFM_LCD2_FLAG()) + getHex(readFlag.getDFM_PCBA_CIT_FLAG()) + getHex(readFlag.getDFM_RF_RSSI_FLAG()) + getHex(readFlag.getDFM_RF_POWER_FLAG());
        Log.w("DFMTool", " hex: " + str);
        int parseInt = Integer.parseInt(str, 2);
        Log.w("DFMTool", " val: " + parseInt);
        return parseInt;
    }

    private static int getFlag(String str, int i, int i2) {
        return getValue(subString(str, i, i2));
    }

    private static String subString(String str, int i, int i2) {
        return (str == null || "".equals(str) || i >= str.length() || i < 0) ? "00" : str.substring(i, i2 + i);
    }

    private static int getValue(String str) {
        if ("00".equals(str)) {
            return 0;
        }
        if ("01".equals(str)) {
            return 1;
        }
        return "10".equals(str) ? 2 : -1;
    }

    private static String numToHex32(int i) {
        try {
            String binaryString = Integer.toBinaryString(i);
            if (binaryString != null && !"".equals(binaryString)) {
                System.out.println("val=" + binaryString);
                return binaryString.length() > 8 ? binaryString.substring(binaryString.length() - 8) : String.format("%08d", Integer.valueOf(Integer.parseInt(binaryString)));
            }
            return "00000000";
        } catch (Exception e) {
            e.printStackTrace();
            return "00000000";
        }
    }

    public static int byteArrayToInt(byte[] bArr, int i) {
        if (bArr == null) {
            return 0;
        }
        return ((bArr[i + 3] & 255) << 24) | (bArr[i] & 255) | ((bArr[i + 1] & 255) << 8) | ((bArr[i + 2] & 255) << 16);
    }
}