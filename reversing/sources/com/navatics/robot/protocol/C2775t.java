package com.navatics.robot.protocol;

import java.io.DataInputStream;
import java.io.IOException;

/* renamed from: com.navatics.robot.protocol.t */
/* loaded from: classes.dex */
public class GetFrameRateReply extends ReplyMessage {

    /* renamed from: d */
    private int f6466d;

    @Override // com.navatics.robot.protocol.ReplyMessage
    /* renamed from: a */
    void mo6355a(DataInputStream dataInputStream) throws IOException {
        this.f6466d = dataInputStream.readByte();
    }

    /* renamed from: c */
    public int m6362c() {
        return this.f6466d;
    }
}
