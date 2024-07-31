package com.navatics.robot.protocol;

import java.io.DataInputStream;
import java.io.IOException;

/* renamed from: com.navatics.robot.protocol.v */
/* loaded from: classes.dex */
public class GetResolutionReply extends ReplyMessage {

    /* renamed from: d */
    private int f6468d;

    @Override // com.navatics.robot.protocol.ReplyMessage
    /* renamed from: a */
    void mo6355a(DataInputStream dataInputStream) throws IOException {
        this.f6468d = dataInputStream.readByte();
    }

    /* renamed from: c */
    public int m6360c() {
        return this.f6468d;
    }
}
