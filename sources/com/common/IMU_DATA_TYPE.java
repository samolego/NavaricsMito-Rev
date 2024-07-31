package com.common;

/* loaded from: classes.dex */
public enum IMU_DATA_TYPE {
    QUATERNION((byte) 0),
    EULERIAN_ANGLES((byte) 1);
    
    private byte value;

    IMU_DATA_TYPE(byte b) {
        this.value = b;
    }

    public int value() {
        return this.value;
    }
}
