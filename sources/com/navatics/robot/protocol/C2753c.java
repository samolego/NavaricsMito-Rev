package com.navatics.robot.protocol;

import org.apache.log4j.C3044k;

/* renamed from: com.navatics.robot.protocol.c */
/* loaded from: classes.dex */
public class CalibrateCompassMessage extends OutputMessage {

    /* renamed from: d */
    private static final C3044k f6389d = C3044k.m1564a(CalibrateCompassMessage.class);

    /* renamed from: e */
    private static final Object f6390e = new Object();

    /* renamed from: f */
    private static int f6391f;

    /* renamed from: g */
    private static CalibrateCompassMessage f6392g;

    /* renamed from: h */
    private CalibrateCompassMessage f6393h;

    private CalibrateCompassMessage() {
        super(17);
    }

    /* renamed from: c */
    public static CalibrateCompassMessage m6448c() {
        try {
            return m6447d();
        } catch (Exception e) {
            e.printStackTrace();
            f6389d.mo1503b("obtain StatusMessage error !", e);
            return null;
        }
    }

    /* renamed from: d */
    private static CalibrateCompassMessage m6447d() {
        synchronized (f6390e) {
            CalibrateCompassMessage calibrateCompassMessage = f6392g;
            if (calibrateCompassMessage == null) {
                return new CalibrateCompassMessage();
            }
            f6392g = calibrateCompassMessage.f6393h;
            f6391f--;
            calibrateCompassMessage.f6393h = null;
            calibrateCompassMessage.m6504j();
            return calibrateCompassMessage;
        }
    }

    @Override // com.navatics.robot.protocol.RobotMessage
    /* renamed from: a */
    public final void mo6369a() {
        super.mo6369a();
        synchronized (f6390e) {
            if (f6391f < 10) {
                f6391f++;
                this.f6393h = f6392g;
                f6392g = this;
            }
        }
    }

    @Override // com.navatics.robot.protocol.OutputMessage
    /* renamed from: b */
    public byte[] mo6368b() {
        return new byte[]{(byte) m6503k()};
    }

    public String toString() {
        return "MSG_CALIBRATE_COMPASS(0xF0, " + String.format("0x%02x", Integer.valueOf(m6503k())) + ")";
    }
}
