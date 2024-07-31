package com.navatics.robot.protocol;

import java.io.DataInputStream;
import java.io.IOException;
import org.apache.log4j.C3044k;

/* renamed from: com.navatics.robot.protocol.aq */
/* loaded from: classes.dex */
public class StatusMessage extends InputMessage {

    /* renamed from: d */
    private static final C3044k f6292d = C3044k.m1564a(StatusMessage.class);

    /* renamed from: e */
    private static final Object f6293e = new Object();

    /* renamed from: f */
    private static int f6294f;

    /* renamed from: g */
    private static StatusMessage f6295g;

    /* renamed from: A */
    private int f6296A;

    /* renamed from: h */
    private StatusMessage f6297h;

    /* renamed from: i */
    private short f6298i;

    /* renamed from: j */
    private short f6299j;

    /* renamed from: k */
    private short f6300k;

    /* renamed from: l */
    private short f6301l;

    /* renamed from: m */
    private short f6302m;

    /* renamed from: n */
    private short f6303n;

    /* renamed from: o */
    private short f6304o;

    /* renamed from: p */
    private short f6305p;

    /* renamed from: q */
    private int f6306q;

    /* renamed from: r */
    private int f6307r;

    /* renamed from: s */
    private short f6308s;

    /* renamed from: t */
    private short f6309t;

    /* renamed from: u */
    private short f6310u;

    /* renamed from: v */
    private short f6311v;

    /* renamed from: w */
    private int f6312w;

    /* renamed from: x */
    private int f6313x;

    /* renamed from: y */
    private int f6314y;

    /* renamed from: z */
    private int f6315z;

    @Override // com.navatics.robot.protocol.InputMessage
    /* renamed from: e */
    public int mo6451e() {
        return 0;
    }

    private StatusMessage() {
        super(35);
    }

    /* renamed from: a */
    public static StatusMessage m6502a(DataInputStream dataInputStream) {
        StatusMessage statusMessage;
        try {
            statusMessage = m6481y();
            try {
                statusMessage.m6500b(dataInputStream);
            } catch (Exception e) {
                e = e;
                e.printStackTrace();
                f6292d.mo1503b("obtain StatusMessage error !", e);
                if (statusMessage != null) {
                    statusMessage.mo6369a();
                }
                return statusMessage;
            }
        } catch (Exception e2) {
            e = e2;
            statusMessage = null;
        }
        return statusMessage;
    }

    /* renamed from: y */
    private static StatusMessage m6481y() throws IOException {
        synchronized (f6293e) {
            StatusMessage statusMessage = f6295g;
            if (statusMessage == null) {
                return new StatusMessage();
            }
            f6295g = statusMessage.f6297h;
            f6294f--;
            statusMessage.f6297h = null;
            statusMessage.m6504j();
            return statusMessage;
        }
    }

    @Override // com.navatics.robot.protocol.RobotMessage
    /* renamed from: a */
    public final void mo6369a() {
        super.mo6369a();
        synchronized (f6293e) {
            if (f6294f < 20) {
                f6294f++;
                this.f6297h = f6295g;
                f6295g = this;
            }
        }
    }

    public String toString() {
        return String.format("MSG_STATUS(0x%02x, 0x%02x, %s)", Integer.valueOf(m6534g()), Integer.valueOf(m6503k()), String.format("0x%04x, 0x%04x, 0x%04x, 0x%04x, 0x%04x, 0x%04x, 0x%04x, 0x%04x, 0x%04x, 0x%04x, 0x%04x, 0x%04x, 0x%04x, 0x%04x, 0x%02x, 0x%02x, 0x%02x, 0x%02x, 0x%02x", Short.valueOf(this.f6298i), Short.valueOf(this.f6299j), Short.valueOf(this.f6300k), Short.valueOf(this.f6301l), Short.valueOf(this.f6302m), Short.valueOf(this.f6303n), Short.valueOf(this.f6304o), Short.valueOf(this.f6305p), Integer.valueOf(this.f6306q), Integer.valueOf(this.f6307r), Short.valueOf(this.f6308s), Short.valueOf(this.f6309t), Short.valueOf(this.f6310u), Short.valueOf(this.f6311v), Integer.valueOf(this.f6312w), Integer.valueOf(this.f6313x), Integer.valueOf(this.f6314y), Integer.valueOf(this.f6315z), Integer.valueOf(this.f6296A)));
    }

    /* renamed from: b */
    public short m6501b() {
        return this.f6298i;
    }

    /* renamed from: c */
    public short m6499c() {
        return this.f6299j;
    }

    /* renamed from: d */
    public short m6498d() {
        return this.f6300k;
    }

    /* renamed from: f */
    public short m6497f() {
        return this.f6301l;
    }

    /* renamed from: h */
    public short m6496h() {
        return this.f6302m;
    }

    /* renamed from: i */
    public short m6495i() {
        return this.f6303n;
    }

    /* renamed from: l */
    public short m6494l() {
        return this.f6304o;
    }

    /* renamed from: m */
    public short m6493m() {
        return this.f6305p;
    }

    /* renamed from: n */
    public int m6492n() {
        return this.f6306q;
    }

    /* renamed from: o */
    public int m6491o() {
        return this.f6307r;
    }

    /* renamed from: p */
    public int m6490p() {
        return this.f6308s;
    }

    /* renamed from: q */
    public int m6489q() {
        return this.f6309t;
    }

    /* renamed from: r */
    public int m6488r() {
        return this.f6310u;
    }

    /* renamed from: s */
    public int m6487s() {
        return this.f6311v;
    }

    /* renamed from: t */
    public int m6486t() {
        return this.f6312w;
    }

    /* renamed from: u */
    public int m6485u() {
        return this.f6313x;
    }

    /* renamed from: v */
    public int m6484v() {
        return this.f6314y;
    }

    /* renamed from: w */
    public int m6483w() {
        return this.f6315z;
    }

    /* renamed from: x */
    public int m6482x() {
        return this.f6296A;
    }

    /* renamed from: b */
    private void m6500b(DataInputStream dataInputStream) throws IOException {
        this.f6298i = dataInputStream.readShort();
        this.f6299j = dataInputStream.readShort();
        this.f6300k = dataInputStream.readShort();
        this.f6301l = dataInputStream.readShort();
        this.f6302m = dataInputStream.readShort();
        this.f6303n = dataInputStream.readShort();
        this.f6304o = dataInputStream.readShort();
        this.f6305p = dataInputStream.readShort();
        this.f6306q = dataInputStream.readUnsignedShort();
        this.f6307r = dataInputStream.readUnsignedShort();
        this.f6308s = dataInputStream.readShort();
        this.f6309t = dataInputStream.readShort();
        this.f6310u = dataInputStream.readShort();
        this.f6311v = dataInputStream.readShort();
        this.f6312w = dataInputStream.readUnsignedByte();
        this.f6313x = dataInputStream.readUnsignedByte();
        this.f6314y = dataInputStream.readUnsignedByte();
        if (this.f6314y > 100) {
            this.f6314y = 100;
        }
        this.f6315z = dataInputStream.readUnsignedByte();
        this.f6296A = dataInputStream.readUnsignedByte();
    }
}
