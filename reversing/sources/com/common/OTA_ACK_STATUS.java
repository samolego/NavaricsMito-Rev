package com.common;

/* loaded from: classes.dex */
public enum OTA_ACK_STATUS {
    FAIL((byte) 0),
    SUCCESS((byte) 1),
    ARQ((byte) 2);
    
    private byte value;

    OTA_ACK_STATUS(byte b) {
        this.value = b;
    }

    public int value() {
        return this.value;
    }

    public static OTA_ACK_STATUS valueT(byte b) {
        if (b == 0) {
            return FAIL;
        }
        if (1 == b) {
            return SUCCESS;
        }
        if (2 == b) {
            return ARQ;
        }
        return FAIL;
    }
}
