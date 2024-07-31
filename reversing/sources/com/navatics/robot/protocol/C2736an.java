package com.navatics.robot.protocol;

import org.apache.log4j.C3044k;

/* renamed from: com.navatics.robot.protocol.an */
/* loaded from: classes.dex */
public class RestartMessage extends OutputMessage {

    /* renamed from: d */
    private static final C3044k f6277d = C3044k.m1564a(CalibrateAccMessage.class);

    /* renamed from: e */
    private static final Object f6278e = new Object();

    /* renamed from: f */
    private static int f6279f;

    /* renamed from: g */
    private static RestartMessage f6280g;

    /* renamed from: h */
    private RestartMessage f6281h;

    private RestartMessage() {
        super(146);
    }

    /* renamed from: c */
    public static RestartMessage m6510c() {
        try {
            return m6509d();
        } catch (Exception e) {
            e.printStackTrace();
            f6277d.mo1503b("obtain StatusMessage error !", e);
            return null;
        }
    }

    /* renamed from: d */
    private static RestartMessage m6509d() {
        synchronized (f6278e) {
            RestartMessage restartMessage = f6280g;
            if (restartMessage == null) {
                return new RestartMessage();
            }
            f6280g = restartMessage.f6281h;
            f6279f--;
            restartMessage.f6281h = null;
            restartMessage.m6504j();
            return restartMessage;
        }
    }

    @Override // com.navatics.robot.protocol.RobotMessage
    /* renamed from: a */
    public final void mo6369a() {
        super.mo6369a();
        synchronized (f6278e) {
            if (f6279f < 10) {
                f6279f++;
                this.f6281h = f6280g;
                f6280g = this;
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
