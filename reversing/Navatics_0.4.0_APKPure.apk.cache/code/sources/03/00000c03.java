package com.common;

import com.adapt.SPM_Rc;

/* loaded from: classes.dex */
public enum LOG_OUTPUT_PORT {
    LOG_PORT_UART((byte) 1),
    LOG_PORT_USB_0((byte) 2),
    LOG_PORT_USB_1((byte) 4),
    LOG_PORT_RF(SPM_Rc.VIBRATION_MODE.PLAY_ONCE),
    LOG_PORT_FLASH((byte) 32),
    LOG_PORRT_USB_UART((byte) 3);

    private byte value;

    LOG_OUTPUT_PORT(byte b) {
        this.value = b;
    }

    public int value() {
        return this.value;
    }
}