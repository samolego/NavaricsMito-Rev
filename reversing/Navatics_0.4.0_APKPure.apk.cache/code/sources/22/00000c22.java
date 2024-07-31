package com.common;

/* loaded from: classes.dex */
public class SP_REQUEST_REL {
    public byte ERR_CODE;
    public byte REL_LEN;
    public byte REL_VER;
    public Object Result;
    private byte[] buff = new byte[3];

    public void fill(byte[] bArr) {
        this.ERR_CODE = bArr[0];
        this.REL_LEN = bArr[1];
        if (bArr.length == 3) {
            this.REL_VER = bArr[2];
        }
    }

    public byte[] getBuff() {
        return this.buff;
    }
}