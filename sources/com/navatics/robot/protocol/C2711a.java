package com.navatics.robot.protocol;

import java.io.DataInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.Locale;
import org.apache.log4j.C3044k;

/* renamed from: com.navatics.robot.protocol.a */
/* loaded from: classes.dex */
public class BuoyStatusMessage extends InputMessage {

    /* renamed from: d */
    private static final C3044k f6187d = C3044k.m1564a(BuoyStatusMessage.class);

    /* renamed from: e */
    private static final Object f6188e = new Object();

    /* renamed from: f */
    private static int f6189f;

    /* renamed from: g */
    private static BuoyStatusMessage f6190g;

    /* renamed from: h */
    private BuoyStatusMessage f6191h;

    /* renamed from: i */
    private float f6192i;

    /* renamed from: j */
    private float f6193j;

    /* renamed from: k */
    private int f6194k;

    @Override // com.navatics.robot.protocol.InputMessage
    /* renamed from: e */
    public int mo6451e() {
        return 0;
    }

    private BuoyStatusMessage() {
        super(36);
    }

    /* renamed from: a */
    public static BuoyStatusMessage m6566a(DataInputStream dataInputStream) {
        BuoyStatusMessage buoyStatusMessage;
        try {
            buoyStatusMessage = m6561f();
            try {
                buoyStatusMessage.m6564b(dataInputStream);
            } catch (Exception e) {
                e = e;
                e.printStackTrace();
                f6187d.mo1503b("obtain BuoyStatusMessage error !", e);
                if (buoyStatusMessage != null) {
                    buoyStatusMessage.mo6369a();
                }
                return buoyStatusMessage;
            }
        } catch (Exception e2) {
            e = e2;
            buoyStatusMessage = null;
        }
        return buoyStatusMessage;
    }

    /* renamed from: f */
    private static BuoyStatusMessage m6561f() {
        synchronized (f6188e) {
            BuoyStatusMessage buoyStatusMessage = f6190g;
            if (buoyStatusMessage == null) {
                return new BuoyStatusMessage();
            }
            f6190g = buoyStatusMessage.f6191h;
            f6189f--;
            buoyStatusMessage.f6191h = null;
            buoyStatusMessage.m6504j();
            return buoyStatusMessage;
        }
    }

    @Override // com.navatics.robot.protocol.RobotMessage
    /* renamed from: a */
    public void mo6369a() {
        super.mo6369a();
        synchronized (f6188e) {
            if (f6189f < 100) {
                f6189f++;
                this.f6191h = f6190g;
                f6190g = this;
            }
        }
    }

    /* renamed from: b */
    public float m6565b() {
        return this.f6192i;
    }

    /* renamed from: c */
    public float m6563c() {
        return this.f6193j;
    }

    /* renamed from: d */
    public int m6562d() {
        return this.f6194k;
    }

    /* renamed from: b */
    private void m6564b(DataInputStream dataInputStream) throws IOException {
        byte[] bArr = new byte[4];
        byte[] bArr2 = new byte[4];
        if (dataInputStream.read(bArr) != bArr.length) {
            throw new IOException("wrong message format when reading longitude");
        }
        this.f6192i = ByteBuffer.wrap(bArr).getFloat();
        if (dataInputStream.read(bArr2) != bArr2.length) {
            throw new IOException("wrong message format when reading latitude");
        }
        this.f6193j = ByteBuffer.wrap(bArr2).getFloat();
        this.f6194k = dataInputStream.readUnsignedByte() & 127;
    }

    public String toString() {
        return String.format(Locale.getDefault(), "MSG_BUOY_STATUS(0x%02x, battery=%d)", Integer.valueOf(m6534g()), Integer.valueOf(m6503k()), Integer.valueOf(this.f6194k));
    }
}
