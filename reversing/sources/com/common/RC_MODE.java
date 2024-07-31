package com.common;

/* loaded from: classes.dex */
public enum RC_MODE {
    RC_IDL((byte) 0),
    RC_SEARCHING((byte) 1),
    RC_SEARCH_TIMEOUT((byte) 2),
    RC_LINKING((byte) 3),
    RC_LINKED((byte) 4),
    RC_LIBK_TIMEOUT((byte) 5),
    RC_ERR((byte) -1);
    
    private byte value;

    RC_MODE(byte b) {
        this.value = b;
    }

    public int value() {
        return this.value;
    }
}
