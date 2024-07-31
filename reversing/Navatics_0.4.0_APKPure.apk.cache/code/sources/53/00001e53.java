package com.senseplay.sdk.tool;

import android.support.v4.view.MotionEventCompat;
import android.support.v4.view.ViewCompat;

/* loaded from: classes2.dex */
public class HLTool {
    public static void shortToByte_LH(short s, byte[] bArr, int i) {
        bArr[i + 0] = (byte) (s & 255);
        bArr[i + 1] = (byte) ((s >> 8) & 255);
    }

    public static short byteToShort_HL(byte[] bArr, int i) {
        return (short) ((bArr[i] & 255) | ((bArr[i + 1] << 8) & MotionEventCompat.ACTION_POINTER_INDEX_MASK));
    }

    public static void intToByte_LH(int i, byte[] bArr, int i2) {
        bArr[i2 + 0] = (byte) (i & 255);
        bArr[i2 + 1] = (byte) ((i >> 8) & 255);
        bArr[i2 + 2] = (byte) ((i >> 16) & 255);
        bArr[i2 + 3] = (byte) ((i >> 24) & 255);
    }

    public static int byteToInt_HL(byte[] bArr, int i) {
        return (bArr[i + 0] & 255) | (((bArr[i + 3] & 255) << 24) & ViewCompat.MEASURED_STATE_MASK) | (((bArr[i + 2] & 255) << 16) & 16711680) | (((bArr[i + 1] & 255) << 8) & MotionEventCompat.ACTION_POINTER_INDEX_MASK);
    }
}