package com.navatics.robot.protocol;

import java.io.DataInputStream;
import java.io.IOException;

/* renamed from: com.navatics.robot.protocol.z */
/* loaded from: classes.dex */
public class GetWhiteBalanceValueReply extends ReplyMessage {

    /* renamed from: d */
    private int f6473d;

    /* renamed from: e */
    private int f6474e;

    @Override // com.navatics.robot.protocol.ReplyMessage
    /* renamed from: a */
    void mo6355a(DataInputStream dataInputStream) throws IOException {
        this.f6473d = dataInputStream.readUnsignedByte();
        this.f6474e = dataInputStream.readUnsignedByte();
    }

    /* renamed from: c */
    public int m6354c() {
        return this.f6473d;
    }

    /* renamed from: d */
    public int m6353d() {
        return this.f6474e;
    }
}
