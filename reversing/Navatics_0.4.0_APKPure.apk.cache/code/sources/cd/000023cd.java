package io.reactivex.internal.p089a;

import io.reactivex.p085b.InterfaceC2826c;

/* compiled from: ObjectHelper.java */
/* renamed from: io.reactivex.internal.a.b, reason: use source file name */
/* loaded from: classes2.dex */
public final class ObjectHelper {

    /* renamed from: a */
    static final InterfaceC2826c<Object, Object> f9703a = new a();

    /* renamed from: a */
    public static int m9644a(int i, int i2) {
        if (i < i2) {
            return -1;
        }
        return i > i2 ? 1 : 0;
    }

    /* renamed from: a */
    public static int m9646a(long j, long j2) {
        if (j < j2) {
            return -1;
        }
        return j > j2 ? 1 : 0;
    }

    /* renamed from: a */
    public static <T> T m9647a(T t, String str) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException(str);
    }

    /* renamed from: a */
    public static boolean m9648a(Object obj, Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }

    /* renamed from: a */
    public static int m9645a(int i, String str) {
        if (i > 0) {
            return i;
        }
        throw new IllegalArgumentException(str + " > 0 required but it was " + i);
    }

    /* compiled from: ObjectHelper.java */
    /* renamed from: io.reactivex.internal.a.b$a */
    /* loaded from: classes2.dex */
    static final class a implements InterfaceC2826c<Object, Object> {
        a() {
        }
    }
}