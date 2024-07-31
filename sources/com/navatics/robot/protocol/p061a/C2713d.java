package com.navatics.robot.protocol.p061a;

/* renamed from: com.navatics.robot.protocol.a.d */
/* loaded from: classes.dex */
public class MCMPacket {

    /* renamed from: a */
    private C2096a f6214a;

    /* renamed from: b */
    private byte[] f6215b;

    /* renamed from: c */
    private int f6216c;

    /* renamed from: d */
    private int f6217d;

    /* renamed from: e */
    private byte[] f6218e;

    /* renamed from: a */
    public static MCMPacket m6549a(C2096a c2096a, byte[] bArr, int i, int i2) {
        if (i2 > 255) {
            throw new RuntimeException("MCMPacket exceed 255 : " + i2);
        }
        MCMPacket mCMPacket = new MCMPacket();
        mCMPacket.f6215b = bArr;
        mCMPacket.f6216c = i;
        mCMPacket.f6217d = i2;
        mCMPacket.f6214a = c2096a;
        byte[] bArr2 = mCMPacket.f6218e;
        if (bArr2 == null) {
            mCMPacket.f6218e = new byte[mCMPacket.f6217d + 2];
        } else if (bArr2.length != mCMPacket.f6217d + 2) {
            throw new RuntimeException(MCMPacket.class.getName() + ".mBuf.length " + mCMPacket.f6218e.length + ", expect " + (mCMPacket.f6217d + 2));
        }
        int m6548a = c2096a.m6548a();
        int m6547b = c2096a.m6547b();
        byte[] bArr3 = mCMPacket.f6218e;
        bArr3[0] = (byte) (((m6548a << 4) & 240) | bArr3[0]);
        bArr3[0] = (byte) (bArr3[0] | (m6547b & 15));
        bArr3[1] = (byte) c2096a.m6546c();
        System.arraycopy(mCMPacket.f6215b, mCMPacket.f6216c, mCMPacket.f6218e, 2, mCMPacket.f6217d);
        return mCMPacket;
    }

    /* renamed from: a */
    public byte[] m6550a() {
        return this.f6218e;
    }

    /* compiled from: MCMPacket.java */
    /* renamed from: com.navatics.robot.protocol.a.d$a */
    /* loaded from: classes.dex */
    public static class C2096a {

        /* renamed from: a */
        int f6219a;

        /* renamed from: b */
        int f6220b;

        /* renamed from: c */
        int f6221c;

        /* JADX INFO: Access modifiers changed from: package-private */
        public C2096a(int i, int i2, int i3) {
            this.f6219a = i;
            this.f6220b = i2;
            this.f6221c = i3;
        }

        /* renamed from: a */
        public int m6548a() {
            return this.f6219a;
        }

        /* renamed from: b */
        public int m6547b() {
            return this.f6220b;
        }

        /* renamed from: c */
        public int m6546c() {
            return this.f6221c;
        }
    }
}
