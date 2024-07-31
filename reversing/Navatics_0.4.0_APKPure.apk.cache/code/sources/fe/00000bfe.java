package com.common;

/* loaded from: classes.dex */
public class DEV_STATUS implements SPRC_T {
    public byte ActiveState;

    /* renamed from: SN */
    public byte[] f1313SN = new byte[32];

    @Override // com.common.SPRC_T
    public int fill(byte[] bArr, int i) {
        int arryCp = SP_Util.arryCp(bArr, this.f1313SN, i);
        int i2 = arryCp + 1;
        this.ActiveState = bArr[arryCp];
        return i2;
    }
}