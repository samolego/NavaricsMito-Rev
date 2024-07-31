package org.greenrobot.essentials.collections;

/* renamed from: org.greenrobot.essentials.collections.b */
/* loaded from: classes2.dex */
public class LongHashMap<T> {

    /* renamed from: a */
    private C3115a<T>[] f11719a;

    /* renamed from: b */
    private int f11720b;

    /* renamed from: c */
    private int f11721c;

    /* renamed from: d */
    private volatile int f11722d;

    /* compiled from: LongHashMap.java */
    /* renamed from: org.greenrobot.essentials.collections.b$a */
    /* loaded from: classes2.dex */
    public static final class C3115a<T> {

        /* renamed from: a */
        public final long f11723a;

        /* renamed from: b */
        public T f11724b;

        /* renamed from: c */
        C3115a<T> f11725c;

        C3115a(long j, T t, C3115a<T> c3115a) {
            this.f11723a = j;
            this.f11724b = t;
            this.f11725c = c3115a;
        }
    }

    public LongHashMap() {
        this(16);
    }

    public LongHashMap(int i) {
        this.f11720b = i;
        this.f11721c = (i * 4) / 3;
        this.f11719a = new C3115a[i];
    }

    /* renamed from: a */
    public T m749a(long j) {
        for (C3115a<T> c3115a = this.f11719a[((((int) j) ^ ((int) (j >>> 32))) & Integer.MAX_VALUE) % this.f11720b]; c3115a != null; c3115a = c3115a.f11725c) {
            if (c3115a.f11723a == j) {
                return c3115a.f11724b;
            }
        }
        return null;
    }

    /* renamed from: a */
    public T m748a(long j, T t) {
        int i = ((((int) j) ^ ((int) (j >>> 32))) & Integer.MAX_VALUE) % this.f11720b;
        C3115a<T> c3115a = this.f11719a[i];
        for (C3115a<T> c3115a2 = c3115a; c3115a2 != null; c3115a2 = c3115a2.f11725c) {
            if (c3115a2.f11723a == j) {
                T t2 = c3115a2.f11724b;
                c3115a2.f11724b = t;
                return t2;
            }
        }
        this.f11719a[i] = new C3115a<>(j, t, c3115a);
        this.f11722d++;
        if (this.f11722d > this.f11721c) {
            m750a(this.f11720b * 2);
            return null;
        }
        return null;
    }

    /* renamed from: a */
    public long[] m751a() {
        C3115a<T>[] c3115aArr;
        long[] jArr = new long[this.f11722d];
        int i = 0;
        for (C3115a<T> c3115a : this.f11719a) {
            while (c3115a != null) {
                jArr[i] = c3115a.f11723a;
                c3115a = c3115a.f11725c;
                i++;
            }
        }
        return jArr;
    }

    /* renamed from: b */
    public int m747b() {
        return this.f11722d;
    }

    /* renamed from: a */
    public void m750a(int i) {
        C3115a<T>[] c3115aArr = new C3115a[i];
        int length = this.f11719a.length;
        for (int i2 = 0; i2 < length; i2++) {
            C3115a<T> c3115a = this.f11719a[i2];
            while (c3115a != null) {
                long j = c3115a.f11723a;
                int i3 = ((((int) (j >>> 32)) ^ ((int) j)) & Integer.MAX_VALUE) % i;
                C3115a<T> c3115a2 = c3115a.f11725c;
                c3115a.f11725c = c3115aArr[i3];
                c3115aArr[i3] = c3115a;
                c3115a = c3115a2;
            }
        }
        this.f11719a = c3115aArr;
        this.f11720b = i;
        this.f11721c = (i * 4) / 3;
    }
}
