package com.navatics.robot.protocol;

import org.apache.log4j.C3044k;

/* renamed from: com.navatics.robot.protocol.aj */
/* loaded from: classes.dex */
public class RecordStopMessage extends OutputMessage {

    /* renamed from: d */
    private static final C3044k f6265d = C3044k.m1564a(RecordStopMessage.class);

    /* renamed from: e */
    private static final Object f6266e = new Object();

    /* renamed from: f */
    private static int f6267f;

    /* renamed from: g */
    private static RecordStopMessage f6268g;

    /* renamed from: h */
    private RecordStopMessage f6269h;

    private RecordStopMessage() {
        super(66);
    }

    /* renamed from: c */
    public static RecordStopMessage m6521c() {
        try {
            return m6520d();
        } catch (Exception e) {
            e.printStackTrace();
            f6265d.mo1503b("obtain StatusMessage error !", e);
            return null;
        }
    }

    /* renamed from: d */
    private static RecordStopMessage m6520d() {
        synchronized (f6266e) {
            RecordStopMessage recordStopMessage = f6268g;
            if (recordStopMessage == null) {
                return new RecordStopMessage();
            }
            f6268g = recordStopMessage.f6269h;
            f6267f--;
            recordStopMessage.f6269h = null;
            recordStopMessage.m6504j();
            return recordStopMessage;
        }
    }

    @Override // com.navatics.robot.protocol.RobotMessage
    /* renamed from: a */
    public final void mo6369a() {
        super.mo6369a();
        synchronized (f6266e) {
            if (f6267f < 100) {
                f6267f++;
                this.f6269h = f6268g;
                f6268g = this;
            }
        }
    }

    @Override // com.navatics.robot.protocol.OutputMessage
    /* renamed from: b */
    public byte[] mo6368b() {
        return new byte[]{(byte) m6503k()};
    }

    public String toString() {
        return String.format("MSG_STOP_RECORD(0x%02x, 0x%02x)", Integer.valueOf(m6528e()), Integer.valueOf(m6503k()));
    }
}
