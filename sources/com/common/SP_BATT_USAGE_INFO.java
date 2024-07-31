package com.common;

/* loaded from: classes.dex */
public class SP_BATT_USAGE_INFO implements SPRC_T {
    public static int size = 6;
    public short cycleCount;
    public short fullCapacity;
    public short residueCapacity;

    @Override // com.common.SPRC_T
    public int fill(byte[] bArr, int i) {
        this.fullCapacity = SP_Util.byteArrayToShort(bArr, i);
        int i2 = i + 2;
        this.residueCapacity = SP_Util.byteArrayToShort(bArr, i2);
        int i3 = i2 + 2;
        this.cycleCount = SP_Util.byteArrayToShort(bArr, i3);
        return i3 + 2;
    }
}
