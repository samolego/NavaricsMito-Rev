package com.navatics.robot.protocol.p061a;

import com.navatics.robot.protocol.InputMessage;
import com.navatics.robot.utils.HexUtil;
import java.io.DataInputStream;
import java.io.IOException;
import java.util.Locale;
import org.apache.log4j.C3044k;

/* renamed from: com.navatics.robot.protocol.a.a */
/* loaded from: classes.dex */
public class MCMInputMessage extends InputMessage {

    /* renamed from: d */
    private static final C3044k f6195d = C3044k.m1564a(MCMInputMessage.class);

    /* renamed from: e */
    private static final Object f6196e = new Object();

    /* renamed from: f */
    private static int f6197f;

    /* renamed from: g */
    private static MCMInputMessage f6198g;

    /* renamed from: h */
    private MCMInputMessage f6199h;

    /* renamed from: i */
    private byte[] f6200i;

    @Override // com.navatics.robot.protocol.InputMessage
    /* renamed from: e */
    public int mo6451e() {
        return 0;
    }

    private MCMInputMessage() {
        super(130);
    }

    /* renamed from: a */
    public static MCMInputMessage m6560a(DataInputStream dataInputStream) {
        MCMInputMessage mCMInputMessage;
        try {
            mCMInputMessage = m6557c();
            try {
                mCMInputMessage.m6558b(dataInputStream);
            } catch (Exception e) {
                e = e;
                e.printStackTrace();
                f6195d.mo1503b("obtain StatusMessage error !", e);
                if (mCMInputMessage != null) {
                    mCMInputMessage.mo6369a();
                }
                return mCMInputMessage;
            }
        } catch (Exception e2) {
            e = e2;
            mCMInputMessage = null;
        }
        return mCMInputMessage;
    }

    /* renamed from: c */
    private static MCMInputMessage m6557c() {
        synchronized (f6196e) {
            MCMInputMessage mCMInputMessage = f6198g;
            if (mCMInputMessage == null) {
                return new MCMInputMessage();
            }
            f6198g = mCMInputMessage.f6199h;
            f6197f--;
            mCMInputMessage.f6199h = null;
            mCMInputMessage.m6504j();
            return mCMInputMessage;
        }
    }

    @Override // com.navatics.robot.protocol.RobotMessage
    /* renamed from: a */
    public void mo6369a() {
        super.mo6369a();
        this.f6200i = null;
        synchronized (f6196e) {
            if (f6197f < 10) {
                f6197f++;
                this.f6199h = f6198g;
                f6198g = this;
            }
        }
    }

    /* renamed from: b */
    private void m6558b(DataInputStream dataInputStream) throws IOException {
        int available = dataInputStream.available();
        byte[] bArr = new byte[available];
        int read = dataInputStream.read(bArr);
        if (read != available) {
            throw new RuntimeException("read " + read + " bytes but expect " + available);
        }
        this.f6200i = bArr;
    }

    /* renamed from: b */
    public byte[] m6559b() {
        return this.f6200i;
    }

    public String toString() {
        return String.format(Locale.getDefault(), "MSG_MCM_RES(0x%02x, data=%s)", Integer.valueOf(m6503k()), new String(HexUtil.m5885a(this.f6200i)));
    }
}
