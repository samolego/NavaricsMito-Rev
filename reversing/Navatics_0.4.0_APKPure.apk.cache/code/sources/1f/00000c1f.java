package com.common;

/* loaded from: classes.dex */
public class SP_LEAPLINK_INFO {
    public byte Ch0_RSSI;
    public byte Ch1_RSSI;
    public byte SNR;
    public boolean isLinked = false;

    public void fill(byte[] bArr) {
        this.isLinked = 1 == (bArr[0] & 1);
        this.SNR = (byte) (bArr[1] & 255);
        this.Ch0_RSSI = (byte) (bArr[2] * (-1));
        this.Ch1_RSSI = (byte) (bArr[3] * (-1));
    }
}