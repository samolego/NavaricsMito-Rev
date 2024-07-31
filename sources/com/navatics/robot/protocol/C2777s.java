package com.navatics.robot.protocol;

import java.io.DataInputStream;
import java.io.IOException;

/* renamed from: com.navatics.robot.protocol.s */
/* loaded from: classes.dex */
public class GetFirmwareVersionReply extends ReplyMessage {

    /* renamed from: d */
    private int f6463d;

    /* renamed from: e */
    private int f6464e;

    /* renamed from: f */
    private int f6465f;

    @Override // com.navatics.robot.protocol.ReplyMessage
    /* renamed from: a */
    void mo6355a(DataInputStream dataInputStream) throws IOException {
        this.f6463d = dataInputStream.readUnsignedByte();
        this.f6464e = dataInputStream.readUnsignedByte();
        this.f6465f = dataInputStream.readUnsignedByte();
    }

    /* renamed from: c */
    public int m6365c() {
        return this.f6463d;
    }

    /* renamed from: d */
    public int m6364d() {
        return this.f6464e;
    }

    /* renamed from: f */
    public int m6363f() {
        return this.f6465f;
    }
}
