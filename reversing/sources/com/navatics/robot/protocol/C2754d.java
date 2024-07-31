package com.navatics.robot.protocol;

import org.apache.log4j.C3044k;

/* renamed from: com.navatics.robot.protocol.d */
/* loaded from: classes.dex */
public class CalibrateGyroMessage extends OutputMessage {

    /* renamed from: d */
    private static final C3044k f6394d = C3044k.m1564a(CalibrateGyroMessage.class);

    /* renamed from: e */
    private static final Object f6395e = new Object();

    /* renamed from: f */
    private static int f6396f;

    /* renamed from: g */
    private static CalibrateGyroMessage f6397g;

    /* renamed from: h */
    private CalibrateGyroMessage f6398h;

    private CalibrateGyroMessage() {
        super(16);
    }

    /* renamed from: c */
    public static CalibrateGyroMessage m6446c() {
        try {
            return m6445d();
        } catch (Exception e) {
            e.printStackTrace();
            f6394d.mo1503b("obtain StatusMessage error !", e);
            return null;
        }
    }

    /* renamed from: d */
    private static CalibrateGyroMessage m6445d() {
        synchronized (f6395e) {
            CalibrateGyroMessage calibrateGyroMessage = f6397g;
            if (calibrateGyroMessage == null) {
                return new CalibrateGyroMessage();
            }
            f6397g = calibrateGyroMessage.f6398h;
            f6396f--;
            calibrateGyroMessage.f6398h = null;
            calibrateGyroMessage.m6504j();
            return calibrateGyroMessage;
        }
    }

    @Override // com.navatics.robot.protocol.RobotMessage
    /* renamed from: a */
    public final void mo6369a() {
        super.mo6369a();
        synchronized (f6395e) {
            if (f6396f < 10) {
                f6396f++;
                this.f6398h = f6397g;
                f6397g = this;
            }
        }
    }

    @Override // com.navatics.robot.protocol.OutputMessage
    /* renamed from: b */
    public byte[] mo6368b() {
        return new byte[]{(byte) m6503k()};
    }

    public String toString() {
        return "MSG_CALIBRATE_GYRO(0xF0, " + String.format("0x%02x", Integer.valueOf(m6503k())) + ")";
    }
}
