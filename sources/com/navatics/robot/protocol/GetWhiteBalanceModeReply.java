package com.navatics.robot.protocol;

import java.io.DataInputStream;
import java.io.IOException;

/* renamed from: com.navatics.robot.protocol.y */
/* loaded from: classes.dex */
public class GetWhiteBalanceModeReply extends ReplyMessage {

    /* renamed from: d */
    private int f6472d;

    @Override // com.navatics.robot.protocol.ReplyMessage
    /* renamed from: a */
    void mo6355a(DataInputStream dataInputStream) throws IOException {
        this.f6472d = dataInputStream.readByte();
    }

    /* renamed from: c */
    public int m6356c() {
        return this.f6472d;
    }
}
