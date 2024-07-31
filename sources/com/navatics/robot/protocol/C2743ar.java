package com.navatics.robot.protocol;

import java.io.DataInputStream;
import java.io.IOException;

/* renamed from: com.navatics.robot.protocol.ar */
/* loaded from: classes.dex */
public class StatusResponse extends ReplyMessage {

    /* renamed from: d */
    private int f6316d;

    @Override // com.navatics.robot.protocol.ReplyMessage
    /* renamed from: a */
    void mo6355a(DataInputStream dataInputStream) throws IOException {
        this.f6316d = dataInputStream.readByte();
    }

    @Override // com.navatics.robot.protocol.ReplyMessage
    /* renamed from: b */
    public void mo6375b() {
        super.mo6375b();
        this.f6316d = 0;
    }
}
