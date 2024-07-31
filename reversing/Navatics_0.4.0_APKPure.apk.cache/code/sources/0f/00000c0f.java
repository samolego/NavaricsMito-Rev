package com.common;

/* loaded from: classes.dex */
public enum SPRC_CATEGORY {
    ONE_HAND((byte) 0),
    TWO_HANDS((byte) 1),
    SINGLE_SCREEN((byte) 2),
    DUAL_SCREEN((byte) 3);

    private byte value;

    SPRC_CATEGORY(byte b) {
        this.value = b;
    }

    public int value() {
        return this.value;
    }

    public static SPRC_CATEGORY getVal(int i) {
        switch (i) {
            case 0:
                return ONE_HAND;
            case 1:
                return TWO_HANDS;
            case 2:
                return SINGLE_SCREEN;
            case 3:
                return DUAL_SCREEN;
            default:
                return TWO_HANDS;
        }
    }
}