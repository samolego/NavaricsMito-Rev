package com.tencent.wxop.stat.common;

/* renamed from: com.tencent.wxop.stat.common.h */
/* loaded from: classes2.dex */
public class C2565h {

    /* renamed from: a */
    static final /* synthetic */ boolean f8051a = !C2565h.class.desiredAssertionStatus();

    private C2565h() {
    }

    /* renamed from: a */
    public static byte[] m4856a(byte[] bArr, int i) {
        return m4855a(bArr, 0, bArr.length, i);
    }

    /* renamed from: a */
    public static byte[] m4855a(byte[] bArr, int i, int i2, int i3) {
        C2567j c2567j = new C2567j(i3, new byte[(i2 * 3) / 4]);
        if (c2567j.m4852a(bArr, i, i2, true)) {
            if (c2567j.f8053b == c2567j.f8052a.length) {
                return c2567j.f8052a;
            }
            byte[] bArr2 = new byte[c2567j.f8053b];
            System.arraycopy(c2567j.f8052a, 0, bArr2, 0, c2567j.f8053b);
            return bArr2;
        }
        throw new IllegalArgumentException("bad base-64");
    }

    /* renamed from: b */
    public static byte[] m4854b(byte[] bArr, int i) {
        return m4853b(bArr, 0, bArr.length, i);
    }

    /* renamed from: b */
    public static byte[] m4853b(byte[] bArr, int i, int i2, int i3) {
        C2568k c2568k = new C2568k(i3, null);
        int i4 = (i2 / 3) * 4;
        if (!c2568k.f8063d) {
            switch (i2 % 3) {
                case 1:
                    i4 += 2;
                    break;
                case 2:
                    i4 += 3;
                    break;
            }
        } else if (i2 % 3 > 0) {
            i4 += 4;
        }
        if (c2568k.f8064e && i2 > 0) {
            i4 += (((i2 - 1) / 57) + 1) * (c2568k.f8065f ? 2 : 1);
        }
        c2568k.f8052a = new byte[i4];
        c2568k.m4851a(bArr, i, i2, true);
        if (f8051a || c2568k.f8053b == i4) {
            return c2568k.f8052a;
        }
        throw new AssertionError();
    }
}
