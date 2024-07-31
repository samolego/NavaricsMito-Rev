package com.navatics.robot.protocol;

import com.navatics.robot.utils.HexUtil;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import org.apache.log4j.C3044k;

/* renamed from: com.navatics.robot.protocol.av */
/* loaded from: classes.dex */
public class UpdateCRCMessage extends UpdateOutputMessage {

    /* renamed from: d */
    private static C3044k f6335d = C3044k.m1564a(UpdateCRCMessage.class);

    /* renamed from: e */
    private static final Object f6336e = new Object();

    /* renamed from: f */
    private static int f6337f;

    /* renamed from: g */
    private static UpdateCRCMessage f6338g;

    /* renamed from: h */
    private UpdateCRCMessage f6339h;

    /* renamed from: i */
    private int f6340i;

    /* renamed from: j */
    private byte[] f6341j;

    private UpdateCRCMessage() {
        super(21);
        this.f6340i = -1;
        this.f6341j = new byte[6];
    }

    /* renamed from: a */
    public static UpdateCRCMessage m6475a(int i) {
        UpdateCRCMessage m6474d = m6474d();
        m6474d.f6340i = i;
        byte[] m6473d = m6474d.m6473d(i);
        m6474d.f6341j[0] = (byte) m6474d.m6503k();
        byte[] bArr = m6474d.f6341j;
        bArr[2] = m6473d[3];
        bArr[3] = m6473d[2];
        bArr[4] = m6473d[1];
        bArr[5] = m6473d[0];
        return m6474d;
    }

    /* renamed from: d */
    private static UpdateCRCMessage m6474d() {
        synchronized (f6336e) {
            UpdateCRCMessage updateCRCMessage = f6338g;
            if (updateCRCMessage == null) {
                return new UpdateCRCMessage();
            }
            f6338g = updateCRCMessage.f6339h;
            f6337f--;
            updateCRCMessage.f6339h = null;
            updateCRCMessage.m6504j();
            return updateCRCMessage;
        }
    }

    @Override // com.navatics.robot.protocol.RobotMessage
    /* renamed from: a */
    public final void mo6369a() {
        super.mo6369a();
        this.f6340i = -1;
        synchronized (f6336e) {
            if (f6337f < 20) {
                f6337f++;
                this.f6339h = f6338g;
                f6338g = this;
            }
        }
    }

    @Override // com.navatics.robot.protocol.OutputMessage
    /* renamed from: b */
    public byte[] mo6368b() {
        this.f6341j[1] = (byte) m6462c();
        return this.f6341j;
    }

    /* renamed from: d */
    private byte[] m6473d(int i) {
        return ByteBuffer.allocate(4).order(ByteOrder.BIG_ENDIAN).putInt(i).array();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("MSG_UPDATE_CRC(0xF0, ");
        byte[] bArr = this.f6341j;
        sb.append(String.format("0x%02x, 0x%02x, 0x%s", Integer.valueOf(m6503k()), Integer.valueOf(m6462c()), new String(HexUtil.m5884a(bArr, 2, bArr.length - 2))));
        sb.append(")");
        return sb.toString();
    }

    @Override // com.navatics.robot.protocol.UpdateOutputMessage
    /* renamed from: b */
    public UpdateOutputMessage mo6463b(int i) {
        return super.mo6463b(i);
    }
}
