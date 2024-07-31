package org.mp4parser.p144a;

/* renamed from: org.mp4parser.a.i */
/* loaded from: classes2.dex */
public class Mp4Math {
    /* renamed from: a */
    public static long m715a(long j, long j2) {
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
    public static long m713b(long j, long j2) {
        return j * (j2 / m715a(j, j2));
    }

    /* renamed from: a */
    public static long m714a(long[] jArr) {
        long j = jArr[0];
        for (int i = 1; i < jArr.length; i++) {
            j = m713b(j, jArr[i]);
        }
        return j;
    }
}
