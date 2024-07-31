package com.navatics.robot.protocol;

import org.apache.log4j.C3044k;

/* renamed from: com.navatics.robot.protocol.bc */
/* loaded from: classes.dex */
public class UpdateStartMessage extends UpdateOutputMessage {

    /* renamed from: d */
    private static final C3044k f6383d = C3044k.m1564a(UpdateStartMessage.class);

    /* renamed from: e */
    private static final Object f6384e = new Object();

    /* renamed from: f */
    private static int f6385f;

    /* renamed from: g */
    private static UpdateStartMessage f6386g;

    /* renamed from: h */
    private UpdateStartMessage f6387h;

    /* renamed from: i */
    private byte[] f6388i;

    private UpdateStartMessage() {
        super(19);
        this.f6388i = new byte[2];
    }

    /* renamed from: d */
    public static UpdateStartMessage m6450d() {
        UpdateStartMessage updateStartMessage;
        try {
            updateStartMessage = m6449f();
        } catch (Exception e) {
            e = e;
            updateStartMessage = null;
        }
        try {
            updateStartMessage.f6388i[0] = (byte) updateStartMessage.m6503k();
        } catch (Exception e2) {
            e = e2;
            e.printStackTrace();
            f6383d.mo1503b("obtain StatusMessage error !", e);
            return updateStartMessage;
        }
        return updateStartMessage;
    }

    /* renamed from: f */
    private static UpdateStartMessage m6449f() {
        synchronized (f6384e) {
            UpdateStartMessage updateStartMessage = f6386g;
            if (updateStartMessage == null) {
                return new UpdateStartMessage();
            }
            f6386g = updateStartMessage.f6387h;
            f6385f--;
            updateStartMessage.f6387h = null;
            updateStartMessage.m6504j();
            return updateStartMessage;
        }
    }

    @Override // com.navatics.robot.protocol.RobotMessage
    /* renamed from: a */
    public final void mo6369a() {
        super.mo6369a();
        synchronized (f6384e) {
            if (f6385f < 100) {
                f6385f++;
                this.f6387h = f6386g;
                f6386g = this;
            }
        }
    }

    @Override // com.navatics.robot.protocol.OutputMessage
    /* renamed from: b */
    public byte[] mo6368b() {
        this.f6388i[1] = (byte) m6462c();
        return this.f6388i;
    }

    public String toString() {
        return String.format("MSG_UPDATE_START(0x%02x, 0x%02x, 0x%02x)", Integer.valueOf(m6528e()), Integer.valueOf(m6503k()), Integer.valueOf(m6462c()));
    }
}
