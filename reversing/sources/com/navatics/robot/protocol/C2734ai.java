package com.navatics.robot.protocol;

import org.apache.log4j.C3044k;

/* renamed from: com.navatics.robot.protocol.ai */
/* loaded from: classes.dex */
public class RecordStartMessage extends OutputMessage {

    /* renamed from: d */
    private static final C3044k f6260d = C3044k.m1564a(RecordStartMessage.class);

    /* renamed from: e */
    private static final Object f6261e = new Object();

    /* renamed from: f */
    private static int f6262f;

    /* renamed from: g */
    private static RecordStartMessage f6263g;

    /* renamed from: h */
    private RecordStartMessage f6264h;

    private RecordStartMessage() {
        super(65);
    }

    /* renamed from: c */
    public static RecordStartMessage m6523c() {
        try {
            return m6522d();
        } catch (Exception e) {
            e.printStackTrace();
            f6260d.mo1503b("obtain StatusMessage error !", e);
            return null;
        }
    }

    /* renamed from: d */
    private static RecordStartMessage m6522d() {
        synchronized (f6261e) {
            RecordStartMessage recordStartMessage = f6263g;
            if (recordStartMessage == null) {
                return new RecordStartMessage();
            }
            f6263g = recordStartMessage.f6264h;
            f6262f--;
            recordStartMessage.f6264h = null;
            recordStartMessage.m6504j();
            return recordStartMessage;
        }
    }

    @Override // com.navatics.robot.protocol.RobotMessage
    /* renamed from: a */
    public final void mo6369a() {
        super.mo6369a();
        synchronized (f6261e) {
            if (f6262f < 100) {
                f6262f++;
                this.f6264h = f6263g;
                f6263g = this;
            }
        }
    }

    @Override // com.navatics.robot.protocol.OutputMessage
    /* renamed from: b */
    public byte[] mo6368b() {
        return new byte[]{(byte) m6503k()};
    }

    public String toString() {
        return String.format("MSG_START_RECORD(0x%02x, 0x%02x)", Integer.valueOf(m6528e()), Integer.valueOf(m6503k()));
    }
}
