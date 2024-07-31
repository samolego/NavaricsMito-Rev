package com.senseplay.sdk.model.vehicle;

import android.support.media.ExifInterface;

/* loaded from: classes2.dex */
public class VehicleGear {
    private static String[] gear = {"P", "R", "N", "D", ExifInterface.LATITUDE_SOUTH};

    public static String getGear(int i) {
        if (i >= 0) {
            String[] strArr = gear;
            return i < strArr.length ? strArr[i] : "unknown";
        }
        return "unknown";
    }

    public static int getGearIndex(String str) {
        int i = 0;
        while (true) {
            String[] strArr = gear;
            if (i >= strArr.length) {
                return 0;
            }
            if (strArr[i].equals(str)) {
                return i;
            }
            i++;
        }
    }
}
