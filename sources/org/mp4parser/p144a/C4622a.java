package org.mp4parser.p144a;

/* renamed from: org.mp4parser.a.a */
/* loaded from: classes2.dex */
public class CastUtils {
    /* renamed from: a */
    public static int m743a(long j) {
        if (j > 2147483647L || j < -2147483648L) {
            throw new RuntimeException("A cast to int has gone wrong. Please contact the mp4parser discussion group (" + j + ")");
        }
        return (int) j;
    }
}
