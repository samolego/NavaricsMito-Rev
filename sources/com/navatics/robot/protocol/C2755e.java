package com.navatics.robot.protocol;

import org.apache.log4j.C3044k;

/* renamed from: com.navatics.robot.protocol.e */
/* loaded from: classes.dex */
public class CalibratePayloadMessage extends OutputMessage {

    /* renamed from: d */
    private static final C3044k f6399d = C3044k.m1564a(CalibratePayloadMessage.class);

    /* renamed from: e */
    private static final Object f6400e = new Object();

    /* renamed from: f */
    private static int f6401f;

    /* renamed from: g */
    private static CalibratePayloadMessage f6402g;

    /* renamed from: h */
    private CalibratePayloadMessage f6403h;

    private CalibratePayloadMessage() {
        super(32);
    }

    @Override // com.navatics.robot.protocol.RobotMessage
    /* renamed from: a */
    public final void mo6369a() {
        super.mo6369a();
        synchronized (f6400e) {
            if (f6401f < 10) {
                f6401f++;
                this.f6403h = f6402g;
                f6402g = this;
            }
        }
    }

    @Override // com.navatics.robot.protocol.OutputMessage
    /* renamed from: b */
    public byte[] mo6368b() {
        return new byte[]{(byte) m6503k()};
    }

    public String toString() {
        return "MSG_CALIBRATE_PAYLOAD(0xF0, " + String.format("0x%02x", Integer.valueOf(m6503k())) + ")";
    }
}
