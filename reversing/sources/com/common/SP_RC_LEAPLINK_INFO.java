package com.common;

/* loaded from: classes.dex */
public class SP_RC_LEAPLINK_INFO {
    public boolean Linked = false;
    public byte Snr = 0;
    public byte Ch0_Rssi = 0;
    public byte Ch1_Rssi = 0;

    public void fill(byte[] bArr) {
        this.Linked = bArr[0] != 0;
        this.Snr = bArr[1];
        this.Ch0_Rssi = bArr[2];
        this.Ch1_Rssi = bArr[3];
    }

    public String toString() {
        return "SP_RC_LEAPLINK_INFO{Linked=" + this.Linked + ", Snr=" + ((int) this.Snr) + ", Ch0_Rssi=" + ((int) this.Ch0_Rssi) + ", Ch1_Rssi=" + ((int) this.Ch1_Rssi) + '}';
    }
}
