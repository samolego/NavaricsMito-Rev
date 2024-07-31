package com.navatics.robot.protocol;

import org.apache.log4j.C3044k;

/* renamed from: com.navatics.robot.protocol.am */
/* loaded from: classes.dex */
public class ResetMotorDriverMessage extends OutputMessage {

    /* renamed from: d */
    private static final C3044k f6272d = C3044k.m1564a(ResetMotorDriverMessage.class);

    /* renamed from: e */
    private static final Object f6273e = new Object();

    /* renamed from: f */
    private static int f6274f;

    /* renamed from: g */
    private static ResetMotorDriverMessage f6275g;

    /* renamed from: h */
    private ResetMotorDriverMessage f6276h;

    private ResetMotorDriverMessage() {
        super(33);
    }

    /* renamed from: c */
    public static ResetMotorDriverMessage m6512c() {
        try {
            return m6511d();
        } catch (Exception e) {
            e.printStackTrace();
            f6272d.mo1503b("obtain StatusMessage error !", e);
            return null;
        }
    }

    /* renamed from: d */
    private static ResetMotorDriverMessage m6511d() {
        synchronized (f6273e) {
            ResetMotorDriverMessage resetMotorDriverMessage = f6275g;
            if (resetMotorDriverMessage == null) {
                return new ResetMotorDriverMessage();
            }
            f6275g = resetMotorDriverMessage.f6276h;
            f6274f--;
            resetMotorDriverMessage.f6276h = null;
            resetMotorDriverMessage.m6504j();
            return resetMotorDriverMessage;
        }
    }

    @Override // com.navatics.robot.protocol.RobotMessage
    /* renamed from: a */
    public final void mo6369a() {
        super.mo6369a();
        synchronized (f6273e) {
            if (f6274f < 10) {
                f6274f++;
                this.f6276h = f6275g;
                f6275g = this;
            }
        }
    }

    @Override // com.navatics.robot.protocol.OutputMessage
    /* renamed from: b */
    public byte[] mo6368b() {
        return new byte[]{(byte) m6503k()};
    }

    public String toString() {
        return "MSG_RESET_MOTOR(0xF0, " + String.format("0x%02x", Integer.valueOf(m6503k())) + ")";
    }
}
