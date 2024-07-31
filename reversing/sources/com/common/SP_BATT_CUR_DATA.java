package com.common;

/* loaded from: classes.dex */
public class SP_BATT_CUR_DATA implements SPRC_T {
    public static int size = 6;
    public short current;
    public short temperature;
    public short voltage;

    @Override // com.common.SPRC_T
    public int fill(byte[] bArr, int i) {
        this.current = SP_Util.byteArrayToShort(bArr, i);
        int i2 = i + 2;
        this.voltage = SP_Util.byteArrayToShort(bArr, i2);
        int i3 = i2 + 2;
        this.temperature = SP_Util.byteArrayToShort(bArr, i3);
        return i3 + 2;
    }
}
