package io.reactivex.internal.util;

/* renamed from: io.reactivex.internal.util.b */
/* loaded from: classes2.dex */
public final class OpenHashSet<T> {

    /* renamed from: a */
    final float f9870a;

    /* renamed from: b */
    int f9871b;

    /* renamed from: c */
    int f9872c;

    /* renamed from: d */
    int f9873d;

    /* renamed from: e */
    T[] f9874e;

    /* renamed from: a */
    static int m3124a(int i) {
        int i2 = i * (-1640531527);
        return i2 ^ (i2 >>> 16);
    }

    public OpenHashSet() {
        this(16, 0.75f);
    }

    public OpenHashSet(int i, float f) {
        this.f9870a = f;
        int m3119a = Pow2.m3119a(i);
        this.f9871b = m3119a - 1;
        this.f9873d = (int) (f * m3119a);
        this.f9874e = (T[]) new Object[m3119a];
    }

    /* renamed from: a */
    public boolean m3122a(T t) {
        T t2;
        T[] tArr = this.f9874e;
        int i = this.f9871b;
        int m3124a = m3124a(t.hashCode()) & i;
        T t3 = tArr[m3124a];
        if (t3 != null) {
            if (t3.equals(t)) {
                return false;
            }
            do {
                m3124a = (m3124a + 1) & i;
                t2 = tArr[m3124a];
                if (t2 == null) {
                }
            } while (!t2.equals(t));
            return false;
        }
        tArr[m3124a] = t;
        int i2 = this.f9872c + 1;
        this.f9872c = i2;
        if (i2 >= this.f9873d) {
            m3125a();
        }
        return true;
    }

    /* renamed from: b */
    public boolean m3120b(T t) {
        T t2;
        T[] tArr = this.f9874e;
        int i = this.f9871b;
        int m3124a = m3124a(t.hashCode()) & i;
        T t3 = tArr[m3124a];
        if (t3 == null) {
            return false;
        }
        if (t3.equals(t)) {
            return m3123a(m3124a, tArr, i);
        }
        do {
            m3124a = (m3124a + 1) & i;
            t2 = tArr[m3124a];
            if (t2 == null) {
                return false;
            }
        } while (!t2.equals(t));
        return m3123a(m3124a, tArr, i);
    }

    /* renamed from: a */
    boolean m3123a(int i, T[] tArr, int i2) {
        int i3;
        T t;
        this.f9872c--;
        while (true) {
            int i4 = i + 1;
            while (true) {
                i3 = i4 & i2;
                t = tArr[i3];
                if (t == null) {
                    tArr[i] = null;
                    return true;
                }
                int m3124a = m3124a(t.hashCode()) & i2;
                if (i > i3) {
                    if (i >= m3124a && m3124a > i3) {
                        break;
                    }
                    i4 = i3 + 1;
                } else if (i < m3124a && m3124a <= i3) {
                    i4 = i3 + 1;
                }
            }
            tArr[i] = t;
            i = i3;
        }
    }

    /* renamed from: a */
    void m3125a() {
        T[] tArr = this.f9874e;
        int length = tArr.length;
        int i = length << 1;
        int i2 = i - 1;
        T[] tArr2 = (T[]) new Object[i];
        int i3 = this.f9872c;
        while (true) {
            int i4 = i3 - 1;
            if (i3 != 0) {
                do {
                    length--;
                } while (tArr[length] == null);
                int m3124a = m3124a(tArr[length].hashCode()) & i2;
                if (tArr2[m3124a] != null) {
                    do {
                        m3124a = (m3124a + 1) & i2;
                    } while (tArr2[m3124a] != null);
                }
                tArr2[m3124a] = tArr[length];
                i3 = i4;
            } else {
                this.f9871b = i2;
                this.f9873d = (int) (i * this.f9870a);
                this.f9874e = tArr2;
                return;
            }
        }
    }

    /* renamed from: b */
    public Object[] m3121b() {
        return this.f9874e;
    }
}
