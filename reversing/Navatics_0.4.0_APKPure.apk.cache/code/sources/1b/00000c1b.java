package com.common;

/* loaded from: classes.dex */
public class SP_DATE implements SPRC_T {
    public byte Day;
    public byte Month;
    public short Year;

    @Override // com.common.SPRC_T
    public int fill(byte[] bArr, int i) {
        this.Year = SP_Util.byteArrayToShort(bArr, i);
        int i2 = i + 2;
        int i3 = i2 + 1;
        this.Month = bArr[i2];
        int i4 = i3 + 1;
        this.Day = bArr[i3];
        return i4;
    }

    public String toString() {
        return "Year: " + ((int) this.Year) + " Month: " + ((int) this.Month) + " Day: " + ((int) this.Day);
    }
}