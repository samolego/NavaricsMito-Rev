package com.common;

/* loaded from: classes.dex */
public enum SPRC_STATUS {
    PRISTINE((byte) 0),
    ACTIVATED((byte) 1);

    private byte value;

    SPRC_STATUS(byte b) {
        this.value = b;
    }

    public int value() {
        return this.value;
    }
}