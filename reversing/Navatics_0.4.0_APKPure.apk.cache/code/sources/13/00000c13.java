package com.common;

/* loaded from: classes.dex */
public class SP_ACK {
    public byte commandCode;
    public byte orgCommandID;
    public int paramLen;
    public byte[] parameters;
    public byte result;
    public byte version;

    public void fill(byte[] bArr) {
        this.commandCode = bArr[0];
        this.orgCommandID = bArr[1];
        this.version = bArr[2];
        this.result = bArr[3];
        this.paramLen = bArr[4] & 255;
        this.parameters = new byte[this.paramLen];
        for (int i = 0; i < this.paramLen; i++) {
            this.parameters[i] = bArr[5 + i];
        }
    }
}