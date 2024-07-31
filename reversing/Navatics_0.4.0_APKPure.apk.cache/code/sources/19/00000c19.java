package com.common;

/* loaded from: classes.dex */
public class SP_BATT_NAME implements SPRC_T {
    public static int size = 15;
    public byte[] name = new byte[15];

    @Override // com.common.SPRC_T
    public int fill(byte[] bArr, int i) {
        byte[] bArr2 = this.name;
        System.arraycopy(bArr, i, bArr2, 0, bArr2.length);
        return i;
    }
}