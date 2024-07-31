package com.common;

/* loaded from: classes.dex */
public enum LOG_OUTPUT_LEVEL {
    LOG_LEVEL_NONE((byte) 0),
    LOG_LEVEL_CRITICAL((byte) 1),
    LOG_LEVEL_ERROR((byte) 2),
    LOG_LEVEL_WARNING((byte) 3),
    LOG_LEVEL_INFO((byte) 4);

    private byte value;

    LOG_OUTPUT_LEVEL(byte b) {
        this.value = b;
    }

    public int value() {
        return this.value;
    }
}