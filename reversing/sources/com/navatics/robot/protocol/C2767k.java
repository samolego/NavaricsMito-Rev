package com.navatics.robot.protocol;

import java.io.DataInputStream;
import java.io.IOException;

/* renamed from: com.navatics.robot.protocol.k */
/* loaded from: classes.dex */
public class ErrorResponse extends ReplyMessage {

    /* renamed from: d */
    private int f6445d;

    @Override // com.navatics.robot.protocol.ReplyMessage
    /* renamed from: a */
    void mo6355a(DataInputStream dataInputStream) throws IOException {
    }

    /* renamed from: a */
    public static ErrorResponse m6376a(int i) {
        ErrorResponse i2 = m6516i();
        if (i2 == null) {
            throw new RuntimeException("getErrorResponseFromPool failed.");
        }
        i2.f6445d = i;
        return i2;
    }

    @Override // com.navatics.robot.protocol.ReplyMessage
    /* renamed from: b */
    public void mo6375b() {
        super.mo6375b();
        this.f6445d = 0;
    }
}
