package com.navatics.robot.protocol.p061a;

import com.navatics.robot.protocol.OutputMessage;
import com.navatics.robot.protocol.UpdateDataMessage;
import com.navatics.robot.utils.HexUtil;
import org.apache.log4j.C3044k;

/* renamed from: com.navatics.robot.protocol.a.c */
/* loaded from: classes.dex */
public class MCMOutputMessage extends OutputMessage {

    /* renamed from: d */
    private static final C3044k f6205d = C3044k.m1564a(MCMOutputMessage.class);

    /* renamed from: e */
    private static final Object f6206e = new Object();

    /* renamed from: f */
    private static int f6207f;

    /* renamed from: g */
    private static MCMOutputMessage f6208g;

    /* renamed from: h */
    private MCMOutputMessage f6209h;

    /* renamed from: i */
    private byte[] f6210i;

    /* renamed from: j */
    private int f6211j;

    /* renamed from: k */
    private int f6212k;

    /* renamed from: l */
    private byte[] f6213l;

    private MCMOutputMessage() {
        super(129);
    }

    /* renamed from: a */
    public static MCMOutputMessage m6552a(byte[] bArr, int i, int i2) {
        MCMOutputMessage m6551c = m6551c();
        m6551c.f6210i = bArr;
        m6551c.f6211j = i;
        m6551c.f6212k = i2;
        byte[] bArr2 = m6551c.f6213l;
        if (bArr2 == null) {
            m6551c.f6213l = new byte[m6551c.f6212k + 1];
        } else if (bArr2.length != m6551c.f6212k + 1) {
            throw new RuntimeException(UpdateDataMessage.class.getName() + ".mBuf.length " + m6551c.f6213l.length + ", expect " + (m6551c.f6212k + 1));
        }
        m6551c.f6213l[0] = (byte) m6551c.m6503k();
        System.arraycopy(m6551c.f6210i, m6551c.f6211j, m6551c.f6213l, 1, m6551c.f6212k);
        return m6551c;
    }

    /* renamed from: c */
    private static MCMOutputMessage m6551c() {
        synchronized (f6206e) {
            MCMOutputMessage mCMOutputMessage = f6208g;
            if (mCMOutputMessage == null) {
                return new MCMOutputMessage();
            }
            f6208g = mCMOutputMessage.f6209h;
            f6207f--;
            mCMOutputMessage.f6209h = null;
            mCMOutputMessage.m6504j();
            return mCMOutputMessage;
        }
    }

    @Override // com.navatics.robot.protocol.RobotMessage
    /* renamed from: a */
    public final void mo6369a() {
        super.mo6369a();
        synchronized (f6206e) {
            if (f6207f < 10) {
                f6207f++;
                this.f6209h = f6208g;
                f6208g = this;
            }
        }
    }

    @Override // com.navatics.robot.protocol.OutputMessage
    /* renamed from: b */
    public byte[] mo6368b() {
        return this.f6213l;
    }

    public String toString() {
        return "MSG_MCM_REQ(0xF0, " + String.format("0x%02x, data=%s", Integer.valueOf(m6503k()), new String(HexUtil.m5884a(this.f6213l, 1, this.f6212k))) + ")";
    }
}
