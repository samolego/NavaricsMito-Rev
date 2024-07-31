package com.navatics.robot.protocol;

import java.io.DataInputStream;
import java.io.IOException;

/* renamed from: com.navatics.robot.protocol.x */
/* loaded from: classes.dex */
public class GetShutterSpeedReply extends ReplyMessage {

    /* renamed from: d */
    private int f6471d;

    @Override // com.navatics.robot.protocol.ReplyMessage
    /* renamed from: a */
    void mo6355a(DataInputStream dataInputStream) throws IOException {
        this.f6471d = dataInputStream.readUnsignedShort();
    }

    /* renamed from: c */
    public int m6357c() {
        return this.f6471d;
    }
}
