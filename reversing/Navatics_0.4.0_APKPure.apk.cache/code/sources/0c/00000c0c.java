package com.common;

import com.adapt.SPM_Rc;

/* loaded from: classes.dex */
public enum SPCD_CATEGORY {
    DEVICE((byte) 0),
    VEHICLE(SPM_Rc.VIBRATION_MODE.PLAY_ONCE),
    BALANCING_WHEELS((byte) 17),
    ROBOT((byte) 18),
    DRONE((byte) 32),
    AIRPLANE((byte) 33),
    BOAT(SPM_Rc.VIBRATION_MODE.CYCLE_MODE),
    MARINE((byte) 49);

    private byte value;

    SPCD_CATEGORY(byte b) {
        this.value = b;
    }

    public int value() {
        return this.value;
    }

    public static SPCD_CATEGORY getVal(int i) {
        switch (i & 255) {
            case 0:
                return DEVICE;
            case 16:
                return VEHICLE;
            case 17:
                return BALANCING_WHEELS;
            case 18:
                return ROBOT;
            case 32:
                return DRONE;
            case 33:
                return AIRPLANE;
            case 48:
                return BOAT;
            case 49:
                return MARINE;
            default:
                return DEVICE;
        }
    }
}