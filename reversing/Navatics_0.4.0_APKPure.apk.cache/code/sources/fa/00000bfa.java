package com.common;

import android.util.Log;

/* loaded from: classes.dex */
public class ARTOSYN_GND_STATUS {
    public boolean valid = false;
    public byte linkStatus = 0;
    public byte imgTransferStatus = 0;
    public byte gndSignalQuality = 0;
    public byte skySignalQuality = 0;
    public byte gnd_A_SignalRSSI = 0;
    public byte gnd_B_SignalRSSI = 0;
    public byte sky_A_SignalRSSI = 0;
    public byte sky_B_SignalRSSI = 0;
    public byte skyErrorRate = 0;
    public byte gndErrorRate = 0;

    public static ARTOSYN_GND_STATUS fill(byte[] bArr) {
        if (bArr.length < 11) {
            return null;
        }
        ARTOSYN_GND_STATUS artosyn_gnd_status = new ARTOSYN_GND_STATUS();
        artosyn_gnd_status.valid = bArr[0] == 0;
        artosyn_gnd_status.linkStatus = bArr[1];
        artosyn_gnd_status.imgTransferStatus = bArr[2];
        artosyn_gnd_status.gndSignalQuality = bArr[3];
        artosyn_gnd_status.skySignalQuality = bArr[4];
        artosyn_gnd_status.gnd_A_SignalRSSI = bArr[5];
        artosyn_gnd_status.gnd_B_SignalRSSI = bArr[6];
        artosyn_gnd_status.sky_A_SignalRSSI = bArr[7];
        artosyn_gnd_status.sky_B_SignalRSSI = bArr[8];
        artosyn_gnd_status.skyErrorRate = bArr[9];
        artosyn_gnd_status.gndErrorRate = bArr[10];
        return artosyn_gnd_status;
    }

    public void print() {
        Log.i("GND_STATUS", "valid:             " + this.valid);
        Log.i("GND_STATUS", "linkStatus:        " + ((int) this.linkStatus));
        Log.i("GND_STATUS", "imgTransferStatus: " + ((int) this.imgTransferStatus));
        Log.i("GND_STATUS", "gndSignalQuality:  " + ((int) this.gndSignalQuality));
        Log.i("GND_STATUS", "skySignalQuality:  " + ((int) this.skySignalQuality));
        Log.i("GND_STATUS", "gnd_A_SignalRSSI:  " + ((int) this.gnd_A_SignalRSSI));
        Log.i("GND_STATUS", "gnd_B_SignalRSSI:  " + ((int) this.gnd_B_SignalRSSI));
        Log.i("GND_STATUS", "sky_A_SignalRSSI:  " + ((int) this.sky_A_SignalRSSI));
        Log.i("GND_STATUS", "sky_B_SignalRSSI:  " + ((int) this.sky_B_SignalRSSI));
        Log.i("GND_STATUS", "skyErrorRate:      " + ((int) this.skyErrorRate));
        Log.i("GND_STATUS", "gndErrorRate:      " + ((int) this.gndErrorRate));
    }
}