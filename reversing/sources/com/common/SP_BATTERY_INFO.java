package com.common;

/* loaded from: classes.dex */
public class SP_BATTERY_INFO implements SPRC_T {
    public short Capacity;
    public byte NumCells;

    @Override // com.common.SPRC_T
    public int fill(byte[] bArr, int i) {
        int i2 = i + 1;
        this.NumCells = bArr[i];
        int i3 = i2 + 1;
        this.Capacity = bArr[i2];
        this.Capacity = (short) (this.Capacity << 8);
        int i4 = i3 + 1;
        this.Capacity = (short) (bArr[i3] | this.Capacity);
        return i4;
    }
}
