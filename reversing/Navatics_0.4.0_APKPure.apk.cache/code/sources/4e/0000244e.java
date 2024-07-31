package io.reactivex.internal.util;

/* compiled from: Pow2.java */
/* renamed from: io.reactivex.internal.util.c */
/* loaded from: classes2.dex */
public final class C2895c {
    /* renamed from: a */
    public static int m9718a(int i) {
        return 1 << (32 - Integer.numberOfLeadingZeros(i - 1));
    }
}