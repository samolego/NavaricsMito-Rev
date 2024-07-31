package io.reactivex.internal.util;

/* compiled from: OpenHashSet.java */
/* renamed from: io.reactivex.internal.util.b, reason: use source file name */
/* loaded from: classes2.dex */
public final class OpenHashSet<T> {

    /* renamed from: a */
    final float f9911a;

    /* renamed from: b */
    int f9912b;

    /* renamed from: c */
    int f9913c;

    /* renamed from: d */
    int f9914d;

    /* renamed from: e */
    T[] f9915e;

    /* renamed from: a */
    static int m9712a(int i) {
        int i2 = i * (-1640531527);
        return i2 ^ (i2 >>> 16);
    }

    public OpenHashSet() {
        this(16, 0.75f);
    }

    public OpenHashSet(int i, float f) {
        this.f9911a = f;
        int m9718a = C2895c.m9718a(i);
        this.f9912b = m9718a - 1;
        this.f9914d = (int) (f * m9718a);
        this.f9915e = (T[]) new Object[m9718a];
    }

    /* renamed from: a */
    public boolean m9715a(T t) {
        T t2;
        T[] tArr = this.f9915e;
        int i = this.f9912b;
        int m9712a = m9712a(t.hashCode()) & i;
        T t3 = tArr[m9712a];
        if (t3 != null) {
            if (t3.equals(t)) {
                return false;
            }
            do {
                m9712a = (m9712a + 1) & i;
                t2 = tArr[m9712a];
                if (t2 == null) {
                }
            } while (!t2.equals(t));
            return false;
        }
        tArr[m9712a] = t;
        int i2 = this.f9913c + 1;
        this.f9913c = i2;
        if (i2 >= this.f9914d) {
            m9713a();
        }
        return true;
    }

    /* renamed from: b */
    public boolean m9716b(T t) {
        T t2;
        T[] tArr = this.f9915e;
        int i = this.f9912b;
        int m9712a = m9712a(t.hashCode()) & i;
        T t3 = tArr[m9712a];
        if (t3 == null) {
            return false;
        }
        if (t3.equals(t)) {
            return m9714a(m9712a, tArr, i);
        }
        do {
            m9712a = (m9712a + 1) & i;
            t2 = tArr[m9712a];
            if (t2 == null) {
                return false;
            }
        } while (!t2.equals(t));
        return m9714a(m9712a, tArr, i);
    }

    /* renamed from: a */
    boolean m9714a(int i, T[] tArr, int i2) {
        int i3;
        T t;
        this.f9913c--;
        while (true) {
            int i4 = i + 1;
            while (true) {
                i3 = i4 & i2;
                t = tArr[i3];
                if (t == null) {
                    tArr[i] = null;
                    return true;
                }
                int m9712a = m9712a(t.hashCode()) & i2;
                if (i > i3) {
                    if (i >= m9712a && m9712a > i3) {
                        break;
                    }
                    i4 = i3 + 1;
                } else if (i < m9712a && m9712a <= i3) {
                    i4 = i3 + 1;
                }
            }
            tArr[i] = t;
            i = i3;
        }
    }

    /* renamed from: a */
    void m9713a() {
        T[] tArr = this.f9915e;
        int length = tArr.length;
        int i = length << 1;
        int i2 = i - 1;
        T[] tArr2 = (T[]) new Object[i];
        int i3 = this.f9913c;
        while (true) {
            int i4 = i3 - 1;
            if (i3 == 0) {
                this.f9912b = i2;
                this.f9914d = (int) (i * this.f9911a);
                this.f9915e = tArr2;
                return;
            }
            do {
                length--;
            } while (tArr[length] == null);
            int m9712a = m9712a(tArr[length].hashCode()) & i2;
            if (tArr2[m9712a] == null) {
                tArr2[m9712a] = tArr[length];
                i3 = i4;
            }
            do {
                m9712a = (m9712a + 1) & i2;
            } while (tArr2[m9712a] != null);
            tArr2[m9712a] = tArr[length];
            i3 = i4;
        }
    }

    /* renamed from: b */
    public Object[] m9717b() {
        return this.f9915e;
    }
}