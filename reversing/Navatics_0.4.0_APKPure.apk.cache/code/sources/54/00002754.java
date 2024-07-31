package org.mp4parser.p133a;

/* compiled from: CastUtils.java */
/* renamed from: org.mp4parser.a.a, reason: use source file name */
/* loaded from: classes2.dex */
public class CastUtils {
    /* renamed from: a */
    public static int m12070a(long j) {
        if (j <= 2147483647L && j >= -2147483648L) {
            return (int) j;
        }
        throw new RuntimeException("A cast to int has gone wrong. Please contact the mp4parser discussion group (" + j + ")");
    }
}