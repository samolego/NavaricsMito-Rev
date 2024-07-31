package org.mp4parser.p144a;

import java.io.UnsupportedEncodingException;

/* renamed from: org.mp4parser.a.k */
/* loaded from: classes2.dex */
public final class Utf8 {
    /* renamed from: a */
    public static byte[] m709a(String str) {
        if (str != null) {
            try {
                return str.getBytes("UTF-8");
            } catch (UnsupportedEncodingException e) {
                throw new Error(e);
            }
        }
        return null;
    }

    /* renamed from: a */
    public static String m708a(byte[] bArr) {
        if (bArr != null) {
            try {
                return new String(bArr, "UTF-8");
            } catch (UnsupportedEncodingException e) {
                throw new Error(e);
            }
        }
        return null;
    }

    /* renamed from: b */
    public static int m707b(String str) {
        if (str != null) {
            try {
                return str.getBytes("UTF-8").length;
            } catch (UnsupportedEncodingException unused) {
                throw new RuntimeException();
            }
        }
        return 0;
    }
}
