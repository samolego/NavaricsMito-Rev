package com.common;

/* loaded from: classes.dex */
public enum OTA_TARGET {
    OTA_RC((byte) 0),
    OTA_DEVICE((byte) 1);

    private byte value;

    OTA_TARGET(byte b) {
        this.value = b;
    }

    public int value() {
        return this.value;
    }
}