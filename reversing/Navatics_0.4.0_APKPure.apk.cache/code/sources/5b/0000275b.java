package org.mp4parser.p133a;

/* compiled from: Mp4Arrays.java */
/* renamed from: org.mp4parser.a.h, reason: use source file name */
/* loaded from: classes2.dex */
public final class Mp4Arrays {
    /* renamed from: a */
    public static long[] m12097a(long[] jArr, long... jArr2) {
        if (jArr == null) {
            jArr = new long[0];
        }
        if (jArr2 == null) {
            jArr2 = new long[0];
        }
        long[] jArr3 = new long[jArr.length + jArr2.length];
        System.arraycopy(jArr, 0, jArr3, 0, jArr.length);
        System.arraycopy(jArr2, 0, jArr3, jArr.length, jArr2.length);
        return jArr3;
    }
}