package com.navatics.robot.protocol;

import com.navatics.robot.transport.NvDimension;
import com.navatics.robot.transport.NvValue;
import java.io.DataInputStream;
import java.io.IOException;

/* renamed from: com.navatics.robot.protocol.w */
/* loaded from: classes.dex */
public class GetSDCardInfoReply extends ReplyMessage {

    /* renamed from: d */
    private NvValue f6469d;

    /* renamed from: e */
    private NvValue f6470e;

    @Override // com.navatics.robot.protocol.ReplyMessage
    /* renamed from: a */
    void mo6355a(DataInputStream dataInputStream) throws IOException {
        this.f6469d = NvValue.m5977a(NvDimension.f6537a.f6548d, dataInputStream);
        this.f6470e = NvValue.m5977a(NvDimension.f6537a.f6548d, dataInputStream);
    }

    /* renamed from: c */
    public NvValue m6359c() {
        return this.f6469d;
    }

    /* renamed from: d */
    public NvValue m6358d() {
        return this.f6470e;
    }
}
