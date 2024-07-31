package com.navatics.robot.protocol;

import org.apache.log4j.C3044k;

/* renamed from: com.navatics.robot.protocol.l */
/* loaded from: classes.dex */
public class GetCameraModeMessage extends OutputMessage {

    /* renamed from: d */
    private static final C3044k f6446d = C3044k.m1564a(GetCameraModeMessage.class);

    /* renamed from: e */
    private static final Object f6447e = new Object();

    /* renamed from: f */
    private static int f6448f;

    /* renamed from: g */
    private static GetCameraModeMessage f6449g;

    /* renamed from: h */
    private GetCameraModeMessage f6450h;

    private GetCameraModeMessage() {
        super(69);
    }

    /* renamed from: c */
    public static GetCameraModeMessage m6374c() {
        try {
            return m6373d();
        } catch (Exception e) {
            e.printStackTrace();
            f6446d.mo1503b("obtain StatusMessage error !", e);
            return null;
        }
    }

    /* renamed from: d */
    private static GetCameraModeMessage m6373d() {
        synchronized (f6447e) {
            GetCameraModeMessage getCameraModeMessage = f6449g;
            if (getCameraModeMessage == null) {
                return new GetCameraModeMessage();
            }
            f6449g = getCameraModeMessage.f6450h;
            f6448f--;
            getCameraModeMessage.f6450h = null;
            getCameraModeMessage.m6504j();
            return getCameraModeMessage;
        }
    }

    @Override // com.navatics.robot.protocol.RobotMessage
    /* renamed from: a */
    public final void mo6369a() {
        super.mo6369a();
        synchronized (f6447e) {
            if (f6448f < 10) {
                f6448f++;
                this.f6450h = f6449g;
                f6449g = this;
            }
        }
    }

    @Override // com.navatics.robot.protocol.OutputMessage
    /* renamed from: b */
    public byte[] mo6368b() {
        return new byte[]{(byte) m6503k()};
    }

    public String toString() {
        return String.format("MSG_GET_CAMERA_MODE(0x%02x, 0x%02x)", Integer.valueOf(m6528e()), Integer.valueOf(m6503k()));
    }
}
