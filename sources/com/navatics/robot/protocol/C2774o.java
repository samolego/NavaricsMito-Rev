package com.navatics.robot.protocol;

import java.io.DataInputStream;
import java.io.IOException;

/* renamed from: com.navatics.robot.protocol.o */
/* loaded from: classes.dex */
public class GetExposureModeReply extends ReplyMessage {

    /* renamed from: d */
    private int f6456d;

    @Override // com.navatics.robot.protocol.ReplyMessage
    /* renamed from: a */
    void mo6355a(DataInputStream dataInputStream) throws IOException {
        this.f6456d = dataInputStream.readByte();
    }

    /* renamed from: c */
    public int m6371c() {
        return this.f6456d;
    }
}
