package com.navatics.robot.protocol;

import org.apache.log4j.C3044k;

/* renamed from: com.navatics.robot.protocol.q */
/* loaded from: classes.dex */
public class GetFirmwareVersionMessage extends OutputMessage {

    /* renamed from: d */
    private static final C3044k f6458d = C3044k.m1564a(GetFirmwareVersionMessage.class);

    /* renamed from: e */
    private static final Object f6459e = new Object();

    /* renamed from: f */
    private static int f6460f;

    /* renamed from: g */
    private static GetFirmwareVersionMessage f6461g;

    /* renamed from: h */
    private GetFirmwareVersionMessage f6462h;

    private GetFirmwareVersionMessage() {
        super(70);
    }

    /* renamed from: c */
    public static GetFirmwareVersionMessage m6367c() {
        try {
            return m6366d();
        } catch (Exception e) {
            e.printStackTrace();
            f6458d.mo1503b("obtain StatusMessage error !", e);
            return null;
        }
    }

    /* renamed from: d */
    private static GetFirmwareVersionMessage m6366d() {
        synchronized (f6459e) {
            GetFirmwareVersionMessage getFirmwareVersionMessage = f6461g;
            if (getFirmwareVersionMessage == null) {
                return new GetFirmwareVersionMessage();
            }
            f6461g = getFirmwareVersionMessage.f6462h;
            f6460f--;
            getFirmwareVersionMessage.f6462h = null;
            getFirmwareVersionMessage.m6504j();
            return getFirmwareVersionMessage;
        }
    }

    @Override // com.navatics.robot.protocol.RobotMessage
    /* renamed from: a */
    public final void mo6369a() {
        super.mo6369a();
        synchronized (f6459e) {
            if (f6460f < 10) {
                f6460f++;
                this.f6462h = f6461g;
                f6461g = this;
            }
        }
    }

    @Override // com.navatics.robot.protocol.OutputMessage
    /* renamed from: b */
    public byte[] mo6368b() {
        return new byte[]{(byte) m6503k()};
    }

    public String toString() {
        return String.format("MSG_GET_ROBOT_FIRMWARE_VERSION(0x%02x, 0x%02x)", Integer.valueOf(m6528e()), Integer.valueOf(m6503k()));
    }
}
