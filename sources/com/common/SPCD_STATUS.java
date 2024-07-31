package com.common;

/* loaded from: classes.dex */
public enum SPCD_STATUS {
    CD_PRISTINE((byte) 0),
    CD_ACTIVATED((byte) 1),
    CD_LOST((byte) 2);
    
    private byte value;

    SPCD_STATUS(byte b) {
        this.value = b;
    }

    public int value() {
        return this.value;
    }
}
