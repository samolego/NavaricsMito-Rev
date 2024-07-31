package org.apache.ftpserver.util;

/* compiled from: StringUtils.java */
/* renamed from: org.apache.ftpserver.util.f */
/* loaded from: classes2.dex */
public class C3199f {
    /* renamed from: a */
    public static final String m11217a(String str, char c, boolean z, int i) {
        int length = str.length();
        if (length >= i) {
            return str;
        }
        int i2 = i - length;
        StringBuilder sb = new StringBuilder(i2);
        for (int i3 = 0; i3 < i2; i3++) {
            sb.append(c);
        }
        if (z) {
            return str + sb.toString();
        }
        return sb.toString() + str;
    }

    /* renamed from: a */
    public static final String m11218a(byte[] bArr) {
        StringBuilder sb = new StringBuilder(bArr.length << 1);
        for (byte b : bArr) {
            String hexString = Integer.toHexString(b & 255);
            if (hexString.length() == 1) {
                sb.append('0');
            }
            sb.append(hexString);
        }
        return sb.toString().toUpperCase();
    }
}