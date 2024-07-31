package com.navatics.robot.transport;

/* loaded from: classes.dex */
public class StorageInfo {
    private NvValue freeSpace;
    private NvValue totalSpace;

    public StorageInfo(NvValue nvValue, NvValue nvValue2) {
        this.totalSpace = nvValue;
        this.freeSpace = nvValue2;
    }

    public NvValue getTotalSpace() {
        return this.totalSpace;
    }

    public NvValue getFreeSpace() {
        return this.freeSpace;
    }

    public String toString() {
        return String.format("StorageInfo={totalSpace=%sGB, freeSpace=%sGB}", NvValue.m5974a(this.totalSpace.m5961f()), NvValue.m5974a(this.freeSpace.m5961f()));
    }
}
