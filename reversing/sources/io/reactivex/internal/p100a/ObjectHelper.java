package io.reactivex.internal.p100a;

import io.reactivex.p096b.BiPredicate;

/* renamed from: io.reactivex.internal.a.b */
/* loaded from: classes2.dex */
public final class ObjectHelper {

    /* renamed from: a */
    static final BiPredicate<Object, Object> f9662a = new C2874a();

    /* renamed from: a */
    public static int m3192a(int i, int i2) {
        if (i < i2) {
            return -1;
        }
        return i > i2 ? 1 : 0;
    }

    /* renamed from: a */
    public static int m3190a(long j, long j2) {
        int i = (j > j2 ? 1 : (j == j2 ? 0 : -1));
        if (i < 0) {
            return -1;
        }
        return i > 0 ? 1 : 0;
    }

    /* renamed from: a */
    public static <T> T m3188a(T t, String str) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException(str);
    }

    /* renamed from: a */
    public static boolean m3189a(Object obj, Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }

    /* renamed from: a */
    public static int m3191a(int i, String str) {
        if (i > 0) {
            return i;
        }
        throw new IllegalArgumentException(str + " > 0 required but it was " + i);
    }

    /* compiled from: ObjectHelper.java */
    /* renamed from: io.reactivex.internal.a.b$a */
    /* loaded from: classes2.dex */
    static final class C2874a implements BiPredicate<Object, Object> {
        C2874a() {
        }
    }
}
