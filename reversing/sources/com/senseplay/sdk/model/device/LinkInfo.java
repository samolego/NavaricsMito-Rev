package com.senseplay.sdk.model.device;

/* loaded from: classes2.dex */
public class LinkInfo {
    private int dev_rssi0;
    private int dev_rssi1;
    private int dev_snr0;
    private int dev_snr1;
    private boolean isLinked = false;
    public int rc_rssi0;
    public int rc_rssi1;
    public int snr;

    public boolean isLinked() {
        return this.isLinked;
    }

    public void setLinked(boolean z) {
        this.isLinked = z;
    }

    public int getSnr() {
        return this.snr;
    }

    public void setSnr(int i) {
        this.snr = i;
    }

    public int getRc_rssi0() {
        return this.rc_rssi0;
    }

    public void setRc_rssi0(int i) {
        this.rc_rssi0 = i;
    }

    public int getRc_rssi1() {
        return this.rc_rssi1;
    }

    public void setRc_rssi1(int i) {
        this.rc_rssi1 = i;
    }

    public int getDev_snr0() {
        return this.dev_snr0;
    }

    public void setDev_snr0(int i) {
        this.dev_snr0 = i;
    }

    public int getDev_snr1() {
        return this.dev_snr1;
    }

    public void setDev_snr1(int i) {
        this.dev_snr1 = i;
    }

    public int getDev_rssi0() {
        return this.dev_rssi0;
    }

    public void setDev_rssi0(int i) {
        this.dev_rssi0 = i;
    }

    public int getDev_rssi1() {
        return this.dev_rssi1;
    }

    public void setDev_rssi1(int i) {
        this.dev_rssi1 = i;
    }
}
