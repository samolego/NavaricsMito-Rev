package com.common;

/* loaded from: classes.dex */
public enum SP_BATTER_STATE {
    DISCHARGING((byte) 0),
    CHARGING((byte) 1),
    CHARGE_FULL((byte) 2),
    FAULT((byte) 3),
    UNREGISTERED((byte) -2),
    STATUS_UNKNOWN((byte) -1);

    private byte value;

    SP_BATTER_STATE(byte b) {
        this.value = b;
    }

    public int value() {
        return this.value;
    }
}