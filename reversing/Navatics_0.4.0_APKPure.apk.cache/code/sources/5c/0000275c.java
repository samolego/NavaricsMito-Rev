package org.mp4parser.p133a;

/* compiled from: Mp4Math.java */
/* renamed from: org.mp4parser.a.i, reason: use source file name */
/* loaded from: classes2.dex */
public class Mp4Math {
    /* renamed from: a */
    public static long m12098a(long j, long j2) {
        while (true) {
            long j3 = j;
            j = j2;
            if (j <= 0) {
                return j3;
            }
            j2 = j3 % j;
        }
    }

    /* renamed from: b */
    public static long m12100b(long j, long j2) {
        return j * (j2 / m12098a(j, j2));
    }

    /* renamed from: a */
    public static long m12099a(long[] jArr) {
        long j = jArr[0];
        for (int i = 1; i < jArr.length; i++) {
            j = m12100b(j, jArr[i]);
        }
        return j;
    }
}