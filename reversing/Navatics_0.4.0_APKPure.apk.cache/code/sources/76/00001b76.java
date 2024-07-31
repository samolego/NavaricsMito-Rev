package com.navatics.robot.protocol.p054a;

/* compiled from: MCMPacket.java */
/* renamed from: com.navatics.robot.protocol.a.d, reason: use source file name */
/* loaded from: classes.dex */
public class MCMPacket {

    /* renamed from: a */
    private a f6242a;

    /* renamed from: b */
    private byte[] f6243b;

    /* renamed from: c */
    private int f6244c;

    /* renamed from: d */
    private int f6245d;

    /* renamed from: e */
    private byte[] f6246e;

    /* renamed from: a */
    public static MCMPacket m6312a(a aVar, byte[] bArr, int i, int i2) {
        if (i2 > 255) {
            throw new RuntimeException("MCMPacket exceed 255 : " + i2);
        }
        MCMPacket mCMPacket = new MCMPacket();
        mCMPacket.f6243b = bArr;
        mCMPacket.f6244c = i;
        mCMPacket.f6245d = i2;
        mCMPacket.f6242a = aVar;
        byte[] bArr2 = mCMPacket.f6246e;
        if (bArr2 == null) {
            mCMPacket.f6246e = new byte[mCMPacket.f6245d + 2];
        } else if (bArr2.length != mCMPacket.f6245d + 2) {
            throw new RuntimeException(MCMPacket.class.getName() + ".mBuf.length " + mCMPacket.f6246e.length + ", expect " + (mCMPacket.f6245d + 2));
        }
        int m6314a = aVar.m6314a();
        int m6315b = aVar.m6315b();
        byte[] bArr3 = mCMPacket.f6246e;
        bArr3[0] = (byte) (((m6314a << 4) & 240) | bArr3[0]);
        bArr3[0] = (byte) (bArr3[0] | (m6315b & 15));
        bArr3[1] = (byte) aVar.m6316c();
        System.arraycopy(mCMPacket.f6243b, mCMPacket.f6244c, mCMPacket.f6246e, 2, mCMPacket.f6245d);
        return mCMPacket;
    }

    /* renamed from: a */
    public byte[] m6313a() {
        return this.f6246e;
    }

    /* compiled from: MCMPacket.java */
    /* renamed from: com.navatics.robot.protocol.a.d$a */
    /* loaded from: classes.dex */
    public static class a {

        /* renamed from: a */
        int f6247a;

        /* renamed from: b */
        int f6248b;

        /* renamed from: c */
        int f6249c;

        /* JADX INFO: Access modifiers changed from: package-private */
        public a(int i, int i2, int i3) {
            this.f6247a = i;
            this.f6248b = i2;
            this.f6249c = i3;
        }

        /* renamed from: a */
        public int m6314a() {
            return this.f6247a;
        }

        /* renamed from: b */
        public int m6315b() {
            return this.f6248b;
        }

        /* renamed from: c */
        public int m6316c() {
            return this.f6249c;
        }
    }
}