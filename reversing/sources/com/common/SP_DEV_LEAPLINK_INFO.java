package com.common;

/* loaded from: classes.dex */
public class SP_DEV_LEAPLINK_INFO {
    public byte CH0_PER;
    public byte CH0_RSSI;
    public byte CH0_SNR;
    public byte CH1_PER;
    public byte CH1_RSSI;
    public byte CH1_SNR;

    public void fill(byte[] bArr) {
        this.CH0_RSSI = bArr[0];
        this.CH1_RSSI = bArr[1];
        this.CH0_SNR = bArr[2];
        this.CH1_SNR = bArr[3];
        this.CH0_PER = bArr[4];
        this.CH1_PER = bArr[5];
    }

    public String toString() {
        return "SP_DEV_LEAPLINK_INFO{CH0_RSSI=" + ((int) this.CH0_RSSI) + ", CH1_RSSI=" + ((int) this.CH1_RSSI) + ", CH0_SNR=" + ((int) this.CH0_SNR) + ", CH1_SNR=" + ((int) this.CH1_SNR) + ", CH0_PER=" + ((int) this.CH0_PER) + ", CH1_PER=" + ((int) this.CH1_PER) + '}';
    }
}
