package com.navatics.robot.protocol;

import java.io.DataInputStream;
import java.io.IOException;

/* renamed from: com.navatics.robot.protocol.n */
/* loaded from: classes.dex */
public class GetEffectValueReply extends ReplyMessage {

    /* renamed from: d */
    private int f6452d;

    /* renamed from: e */
    private int f6453e;

    /* renamed from: f */
    private int f6454f;

    /* renamed from: g */
    private int f6455g;

    @Override // com.navatics.robot.protocol.ReplyMessage
    /* renamed from: a */
    void mo6355a(DataInputStream dataInputStream) throws IOException {
        this.f6452d = dataInputStream.readUnsignedByte();
        this.f6453e = dataInputStream.readUnsignedByte();
        this.f6454f = dataInputStream.readUnsignedByte();
        this.f6455g = dataInputStream.readUnsignedByte();
    }
}
