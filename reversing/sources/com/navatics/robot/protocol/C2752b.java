package com.navatics.robot.protocol;

import org.apache.log4j.C3044k;

/* renamed from: com.navatics.robot.protocol.b */
/* loaded from: classes.dex */
public class CalibrateAccMessage extends OutputMessage {

    /* renamed from: d */
    private static final C3044k f6364d = C3044k.m1564a(CalibrateAccMessage.class);

    /* renamed from: e */
    private static final Object f6365e = new Object();

    /* renamed from: f */
    private static int f6366f;

    /* renamed from: g */
    private static CalibrateAccMessage f6367g;

    /* renamed from: h */
    private CalibrateAccMessage f6368h;

    private CalibrateAccMessage() {
        super(18);
    }

    @Override // com.navatics.robot.protocol.RobotMessage
    /* renamed from: a */
    public final void mo6369a() {
        super.mo6369a();
        synchronized (f6365e) {
            if (f6366f < 10) {
                f6366f++;
                this.f6368h = f6367g;
                f6367g = this;
            }
        }
    }

    @Override // com.navatics.robot.protocol.OutputMessage
    /* renamed from: b */
    public byte[] mo6368b() {
        return new byte[]{(byte) m6503k()};
    }

    public String toString() {
        return "MSG_CALIBRATE_ACC(0xF0, " + String.format("0x%02x", Integer.valueOf(m6503k())) + ")";
    }
}
