package org.greenrobot.essentials.collections;

/* compiled from: LongHashMap.java */
/* renamed from: org.greenrobot.essentials.collections.b, reason: use source file name */
/* loaded from: classes2.dex */
public class LongHashMap<T> {

    /* renamed from: a */
    private a<T>[] f11760a;

    /* renamed from: b */
    private int f11761b;

    /* renamed from: c */
    private int f11762c;

    /* renamed from: d */
    private volatile int f11763d;

    /* compiled from: LongHashMap.java */
    /* renamed from: org.greenrobot.essentials.collections.b$a */
    /* loaded from: classes2.dex */
    public static final class a<T> {

        /* renamed from: a */
        public final long f11764a;

        /* renamed from: b */
        public T f11765b;

        /* renamed from: c */
        a<T> f11766c;

        a(long j, T t, a<T> aVar) {
            this.f11764a = j;
            this.f11765b = t;
            this.f11766c = aVar;
        }
    }

    public LongHashMap() {
        this(16);
    }

    public LongHashMap(int i) {
        this.f11761b = i;
        this.f11762c = (i * 4) / 3;
        this.f11760a = new a[i];
    }

    /* renamed from: a */
    public T m12060a(long j) {
        for (a<T> aVar = this.f11760a[((((int) j) ^ ((int) (j >>> 32))) & Integer.MAX_VALUE) % this.f11761b]; aVar != null; aVar = aVar.f11766c) {
            if (aVar.f11764a == j) {
                return aVar.f11765b;
            }
        }
        return null;
    }

    /* renamed from: a */
    public T m12061a(long j, T t) {
        int i = ((((int) j) ^ ((int) (j >>> 32))) & Integer.MAX_VALUE) % this.f11761b;
        a<T> aVar = this.f11760a[i];
        for (a<T> aVar2 = aVar; aVar2 != null; aVar2 = aVar2.f11766c) {
            if (aVar2.f11764a == j) {
                T t2 = aVar2.f11765b;
                aVar2.f11765b = t;
                return t2;
            }
        }
        this.f11760a[i] = new a<>(j, t, aVar);
        this.f11763d++;
        if (this.f11763d <= this.f11762c) {
            return null;
        }
        m12062a(this.f11761b * 2);
        return null;
    }

    /* renamed from: a */
    public long[] m12063a() {
        long[] jArr = new long[this.f11763d];
        int i = 0;
        for (a<T> aVar : this.f11760a) {
            while (aVar != null) {
                jArr[i] = aVar.f11764a;
                aVar = aVar.f11766c;
                i++;
            }
        }
        return jArr;
    }

    /* renamed from: b */
    public int m12064b() {
        return this.f11763d;
    }

    /* renamed from: a */
    public void m12062a(int i) {
        a<T>[] aVarArr = new a[i];
        int length = this.f11760a.length;
        for (int i2 = 0; i2 < length; i2++) {
            a<T> aVar = this.f11760a[i2];
            while (aVar != null) {
                long j = aVar.f11764a;
                int i3 = ((((int) (j >>> 32)) ^ ((int) j)) & Integer.MAX_VALUE) % i;
                a<T> aVar2 = aVar.f11766c;
                aVar.f11766c = aVarArr[i3];
                aVarArr[i3] = aVar;
                aVar = aVar2;
            }
        }
        this.f11760a = aVarArr;
        this.f11761b = i;
        this.f11762c = (i * 4) / 3;
    }
}