package io.reactivex.internal.util;

/* renamed from: io.reactivex.internal.util.c */
/* loaded from: classes2.dex */
public final class Pow2 {
    /* renamed from: a */
    public static int m3119a(int i) {
        return 1 << (32 - Integer.numberOfLeadingZeros(i - 1));
    }
}
