package com.navatics.robot.protocol;

import java.io.DataInputStream;
import java.io.IOException;

/* renamed from: com.navatics.robot.protocol.p */
/* loaded from: classes.dex */
public class GetExposureTargetReply extends ReplyMessage {

    /* renamed from: d */
    private int f6457d;

    @Override // com.navatics.robot.protocol.ReplyMessage
    /* renamed from: a */
    void mo6355a(DataInputStream dataInputStream) throws IOException {
        this.f6457d = dataInputStream.readUnsignedByte();
    }

    /* renamed from: c */
    public int m6370c() {
        return this.f6457d;
    }
}
