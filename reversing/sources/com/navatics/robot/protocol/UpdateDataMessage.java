package com.navatics.robot.protocol;

import com.navatics.robot.utils.HexUtil;

/* renamed from: com.navatics.robot.protocol.aw */
/* loaded from: classes.dex */
public class UpdateDataMessage extends UpdateOutputMessage {

    /* renamed from: d */
    private static final Object f6342d = new Object();

    /* renamed from: e */
    private static int f6343e;

    /* renamed from: f */
    private static UpdateDataMessage f6344f;

    /* renamed from: g */
    private UpdateDataMessage f6345g;

    /* renamed from: h */
    private byte[] f6346h;

    /* renamed from: i */
    private int f6347i;

    /* renamed from: j */
    private int f6348j;

    /* renamed from: k */
    private byte[] f6349k;

    private UpdateDataMessage() {
        super(20);
    }

    /* renamed from: a */
    public static UpdateDataMessage m6472a(byte[] bArr, int i, int i2) {
        UpdateDataMessage m6471d = m6471d();
        m6471d.f6346h = bArr;
        m6471d.f6347i = i;
        m6471d.f6348j = i2;
        byte[] bArr2 = m6471d.f6349k;
        if (bArr2 == null) {
            m6471d.f6349k = new byte[m6471d.f6348j + 2];
        } else if (bArr2.length != m6471d.f6348j + 2) {
            throw new RuntimeException(UpdateDataMessage.class.getName() + ".mBuf.length " + m6471d.f6349k.length + ", expect " + (m6471d.f6348j + 2));
        }
        m6471d.f6349k[0] = (byte) m6471d.m6503k();
        System.arraycopy(m6471d.f6346h, m6471d.f6347i, m6471d.f6349k, 2, m6471d.f6348j);
        return m6471d;
    }

    /* renamed from: d */
    private static UpdateDataMessage m6471d() {
        synchronized (f6342d) {
            UpdateDataMessage updateDataMessage = f6344f;
            if (updateDataMessage == null) {
                return new UpdateDataMessage();
            }
            f6344f = updateDataMessage.f6345g;
            f6343e--;
            updateDataMessage.f6345g = null;
            updateDataMessage.m6504j();
            return updateDataMessage;
        }
    }

    @Override // com.navatics.robot.protocol.RobotMessage
    /* renamed from: a */
    public final void mo6369a() {
        super.mo6369a();
        synchronized (f6342d) {
            if (f6343e < 20) {
                f6343e++;
                this.f6345g = f6344f;
                f6344f = this;
            }
        }
    }

    @Override // com.navatics.robot.protocol.OutputMessage
    /* renamed from: b */
    public byte[] mo6368b() {
        this.f6349k[1] = (byte) m6462c();
        return this.f6349k;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("MSG_UPDATE_DATA(0xF0, ");
        StringBuilder sb2 = new StringBuilder();
        byte[] bArr = this.f6349k;
        sb2.append(new String(HexUtil.m5884a(bArr, 2, bArr.length - 2)));
        sb2.append(")");
        sb.append(String.format("0x%02x, 0x%02x, data=%s", Integer.valueOf(m6503k()), Integer.valueOf(m6462c()), sb2.toString()));
        return sb.toString();
    }
}
