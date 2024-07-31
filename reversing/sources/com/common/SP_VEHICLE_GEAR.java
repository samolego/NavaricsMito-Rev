package com.common;

/* loaded from: classes.dex */
public enum SP_VEHICLE_GEAR {
    P((byte) 0),
    R((byte) 1),
    N((byte) 2),
    D((byte) 3),
    S((byte) 4),
    UNKNOWN((byte) 5);
    
    private byte value;

    SP_VEHICLE_GEAR(byte b) {
        this.value = b;
    }

    public int value() {
        return this.value;
    }

    public SP_VEHICLE_GEAR fill(byte b) {
        if (b < 0 || b > 4) {
            return UNKNOWN;
        }
        switch (b) {
            case 0:
                return P;
            case 1:
                return R;
            case 2:
                return N;
            case 3:
                return D;
            case 4:
                return S;
            default:
                return UNKNOWN;
        }
    }
}
