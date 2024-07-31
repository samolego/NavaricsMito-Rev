package com.common;

/* loaded from: classes.dex */
public enum OTA_UPDATE_STATUS {
    OTA_INIT((byte) 0),
    OTA_LAST_PKT_OK((byte) 1),
    OTA_LAST_PK_ERR((byte) 2),
    OTA_RETRANSMIT_PKT((byte) 3),
    OTA_END_PKT_SEND((byte) 4);
    
    private byte value;

    OTA_UPDATE_STATUS(byte b) {
        this.value = b;
    }

    public int value() {
        return this.value;
    }

    public static byte getValue(OTA_UPDATE_STATUS ota_update_status) {
        switch (ota_update_status) {
            case OTA_INIT:
                return (byte) 0;
            case OTA_LAST_PKT_OK:
                return (byte) 1;
            case OTA_LAST_PK_ERR:
                return (byte) 2;
            case OTA_RETRANSMIT_PKT:
                return (byte) 3;
            case OTA_END_PKT_SEND:
                return (byte) 4;
            default:
                return (byte) 1;
        }
    }
}
