package org.mp4parser.p133a;

import java.io.UnsupportedEncodingException;

/* compiled from: Utf8.java */
/* renamed from: org.mp4parser.a.k */
/* loaded from: classes2.dex */
public final class C3373k {
    /* renamed from: a */
    public static byte[] m12105a(String str) {
        if (str == null) {
            return null;
        }
        try {
            return str.getBytes("UTF-8");
        } catch (UnsupportedEncodingException e) {
            throw new Error(e);
        }
    }

    /* renamed from: a */
    public static String m12104a(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        try {
            return new String(bArr, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            throw new Error(e);
        }
    }

    /* renamed from: b */
    public static int m12106b(String str) {
        if (str == null) {
            return 0;
        }
        try {
            return str.getBytes("UTF-8").length;
        } catch (UnsupportedEncodingException unused) {
            throw new RuntimeException();
        }
    }
}