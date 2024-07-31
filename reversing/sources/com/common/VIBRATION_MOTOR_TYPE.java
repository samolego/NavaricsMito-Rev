package com.common;

/* loaded from: classes.dex */
public enum VIBRATION_MOTOR_TYPE {
    VIBRATION_MOTOR_FILE_DRIVE((byte) 1),
    VIBRATION_MOTOR_WAVEFORM_DRIVE((byte) 2);
    
    private byte value;

    VIBRATION_MOTOR_TYPE(byte b) {
        this.value = b;
    }

    public int value() {
        return this.value;
    }
}
