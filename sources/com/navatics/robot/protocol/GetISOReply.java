package com.navatics.robot.protocol;

import java.io.DataInputStream;
import java.io.IOException;

/* renamed from: com.navatics.robot.protocol.u */
/* loaded from: classes.dex */
public class GetISOReply extends ReplyMessage {

    /* renamed from: d */
    private int f6467d;

    @Override // com.navatics.robot.protocol.ReplyMessage
    /* renamed from: a */
    void mo6355a(DataInputStream dataInputStream) throws IOException {
        this.f6467d = dataInputStream.readByte();
    }

    /* renamed from: c */
    public int m6361c() {
        return this.f6467d;
    }
}
