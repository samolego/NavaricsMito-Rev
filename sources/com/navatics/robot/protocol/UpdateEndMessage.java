package com.navatics.robot.protocol;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import org.apache.log4j.C3044k;

/* renamed from: com.navatics.robot.protocol.ax */
/* loaded from: classes.dex */
public class UpdateEndMessage extends UpdateOutputMessage {

    /* renamed from: d */
    private static final C3044k f6350d = C3044k.m1564a(UpdateEndMessage.class);

    /* renamed from: e */
    private static final Object f6351e = new Object();

    /* renamed from: f */
    private static int f6352f;

    /* renamed from: g */
    private static UpdateEndMessage f6353g;

    /* renamed from: h */
    private UpdateEndMessage f6354h;

    /* renamed from: i */
    private int f6355i;

    /* renamed from: j */
    private byte[] f6356j;

    private UpdateEndMessage() {
        super(22);
        this.f6356j = new byte[3];
    }

    /* renamed from: a */
    public static UpdateEndMessage m6470a(int i) {
        UpdateEndMessage updateEndMessage;
        try {
            updateEndMessage = m6469d();
            try {
                updateEndMessage.f6355i = i;
                byte[] m6468d = updateEndMessage.m6468d(i);
                updateEndMessage.f6356j[0] = (byte) updateEndMessage.m6503k();
                System.arraycopy(m6468d, 2, updateEndMessage.f6356j, 1, 2);
            } catch (Exception e) {
                e = e;
                e.printStackTrace();
                f6350d.mo1503b("obtain StatusMessage error !", e);
                return updateEndMessage;
            }
        } catch (Exception e2) {
            e = e2;
            updateEndMessage = null;
        }
        return updateEndMessage;
    }

    /* renamed from: d */
    private static UpdateEndMessage m6469d() {
        synchronized (f6351e) {
            UpdateEndMessage updateEndMessage = f6353g;
            if (updateEndMessage == null) {
                return new UpdateEndMessage();
            }
            f6353g = updateEndMessage.f6354h;
            f6352f--;
            updateEndMessage.f6354h = null;
            updateEndMessage.m6504j();
            return updateEndMessage;
        }
    }

    @Override // com.navatics.robot.protocol.RobotMessage
    /* renamed from: a */
    public final void mo6369a() {
        super.mo6369a();
        synchronized (f6351e) {
            if (f6352f < 100) {
                f6352f++;
                this.f6354h = f6353g;
                f6353g = this;
            }
        }
    }

    @Override // com.navatics.robot.protocol.OutputMessage
    /* renamed from: b */
    public byte[] mo6368b() {
        return this.f6356j;
    }

    /* renamed from: d */
    private byte[] m6468d(int i) {
        return ByteBuffer.allocate(4).order(ByteOrder.BIG_ENDIAN).putInt(i).array();
    }

    public String toString() {
        return "MSG_UPDATE_DATA_END(0xF0, " + String.format("0x%02x", Integer.valueOf(m6503k())) + ")";
    }
}
