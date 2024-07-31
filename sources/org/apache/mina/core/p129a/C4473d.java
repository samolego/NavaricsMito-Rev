package org.apache.mina.core.p129a;

import com.adapt.SPM_Rc;

/* renamed from: org.apache.mina.core.a.d */
/* loaded from: classes2.dex */
class IoBufferHexDumper {

    /* renamed from: a */
    private static final byte[] f11322a;

    /* renamed from: b */
    private static final byte[] f11323b;

    static {
        byte[] bArr = {SPM_Rc.VIBRATION_MODE.CYCLE_MODE, 49, 50, 51, 52, 53, 54, 55, 56, 57, 65, 66, 67, 68, 69, 70};
        byte[] bArr2 = new byte[256];
        byte[] bArr3 = new byte[256];
        for (int i = 0; i < 256; i++) {
            bArr2[i] = bArr[i >>> 4];
            bArr3[i] = bArr[i & 15];
        }
        f11322a = bArr2;
        f11323b = bArr3;
    }

    /* renamed from: a */
    public static String m1351a(AbstractC3054b abstractC3054b, int i) {
        if (i == 0) {
            throw new IllegalArgumentException("lengthLimit: " + i + " (expected: 1+)");
        }
        boolean z = abstractC3054b.mo1357l() > i;
        if (!z) {
            i = abstractC3054b.mo1357l();
        }
        if (i == 0) {
            return "empty";
        }
        StringBuilder sb = new StringBuilder((i * 3) + 3);
        int mo1366f = abstractC3054b.mo1366f();
        int mo1355n = abstractC3054b.mo1355n() & 255;
        sb.append((char) f11322a[mo1355n]);
        sb.append((char) f11323b[mo1355n]);
        for (int i2 = i - 1; i2 > 0; i2--) {
            sb.append(' ');
            int mo1355n2 = abstractC3054b.mo1355n() & 255;
            sb.append((char) f11322a[mo1355n2]);
            sb.append((char) f11323b[mo1355n2]);
        }
        abstractC3054b.mo1369d(mo1366f);
        if (z) {
            sb.append("...");
        }
        return sb.toString();
    }
}
