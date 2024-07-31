package com.senseplay.control.model;

/* loaded from: classes2.dex */
public class LinKInfo {
    private boolean isLink;
    private int rssi;
    private int snr;

    public boolean isLink() {
        return this.isLink;
    }

    public void setLink(boolean z) {
        this.isLink = z;
    }

    public int getSnr() {
        return this.snr;
    }

    public void setSnr(int i) {
        this.snr = i;
    }

    public int getRssi() {
        return this.rssi;
    }

    public void setRssi(int i) {
        this.rssi = i;
    }
}