package com.navatics.miya.util;

import java.util.Random;

/* compiled from: ObjectMap.java */
/* renamed from: com.navatics.miya.b.i, reason: use source file name */
/* loaded from: classes.dex */
public class ObjectMap<K, V> {

    /* renamed from: a */
    static Random f6057a = new Random();

    /* renamed from: b */
    public int f6058b;

    /* renamed from: c */
    K[] f6059c;

    /* renamed from: d */
    V[] f6060d;

    /* renamed from: e */
    int f6061e;

    /* renamed from: f */
    int f6062f;

    /* renamed from: g */
    private float f6063g;

    /* renamed from: h */
    private int f6064h;

    /* renamed from: i */
    private int f6065i;

    /* renamed from: j */
    private int f6066j;

    /* renamed from: k */
    private int f6067k;

    /* renamed from: l */
    private int f6068l;

    /* renamed from: m */
    private boolean f6069m;

    /* renamed from: b */
    public static int m6185b(int i) {
        if (i == 0) {
            return 1;
        }
        int i2 = i - 1;
        int i3 = i2 | (i2 >> 1);
        int i4 = i3 | (i3 >> 2);
        int i5 = i4 | (i4 >> 4);
        int i6 = i5 | (i5 >> 8);
        return (i6 | (i6 >> 16)) + 1;
    }

    public ObjectMap() {
        this(32, 0.8f);
    }

    public ObjectMap(int i, float f) {
        if (i < 0) {
            throw new IllegalArgumentException("initialCapacity must be >= 0: " + i);
        }
        if (i > 1073741824) {
            throw new IllegalArgumentException("initialCapacity is too large: " + i);
        }
        this.f6061e = m6185b(i);
        if (f <= 0.0f) {
            throw new IllegalArgumentException("loadFactor must be > 0: " + f);
        }
        this.f6063g = f;
        this.f6069m = (this.f6061e >>> 16) != 0;
        int i2 = this.f6061e;
        this.f6066j = (int) (i2 * f);
        this.f6065i = i2 - 1;
        this.f6064h = 31 - Integer.numberOfTrailingZeros(i2);
        this.f6067k = Math.max(3, ((int) Math.ceil(Math.log(this.f6061e))) * 2);
        this.f6068l = Math.max(Math.min(this.f6061e, 8), ((int) Math.sqrt(this.f6061e)) / 8);
        this.f6059c = (K[]) new Object[this.f6061e + this.f6067k];
        this.f6060d = (V[]) new Object[this.f6059c.length];
    }

    /* renamed from: a */
    public V m6196a(K k, V v) {
        if (k == null) {
            throw new IllegalArgumentException("key cannot be null.");
        }
        return m6186b(k, v);
    }

    /* renamed from: b */
    private V m6186b(K k, V v) {
        K k2;
        int i;
        Object[] objArr = this.f6059c;
        int i2 = this.f6065i;
        int hashCode = k.hashCode();
        int i3 = hashCode & i2;
        K k3 = objArr[i3];
        if (k.equals(k3)) {
            V[] vArr = this.f6060d;
            V v2 = vArr[i3];
            vArr[i3] = v;
            return v2;
        }
        int m6190d = m6190d(hashCode);
        K k4 = objArr[m6190d];
        if (k.equals(k4)) {
            V[] vArr2 = this.f6060d;
            V v3 = vArr2[m6190d];
            vArr2[m6190d] = v;
            return v3;
        }
        int m6193e = m6193e(hashCode);
        K k5 = objArr[m6193e];
        if (k.equals(k5)) {
            V[] vArr3 = this.f6060d;
            V v4 = vArr3[m6193e];
            vArr3[m6193e] = v;
            return v4;
        }
        if (this.f6069m) {
            int m6194f = m6194f(hashCode);
            Object obj = objArr[m6194f];
            if (k.equals(obj)) {
                V[] vArr4 = this.f6060d;
                V v5 = vArr4[m6194f];
                vArr4[m6194f] = v;
                return v5;
            }
            i = m6194f;
            k2 = obj;
        } else {
            k2 = null;
            i = -1;
        }
        int i4 = this.f6061e;
        int i5 = this.f6062f + i4;
        while (i4 < i5) {
            if (k.equals(objArr[i4])) {
                V[] vArr5 = this.f6060d;
                V v6 = vArr5[i4];
                vArr5[i4] = v;
                return v6;
            }
            i4++;
        }
        if (k3 == null) {
            objArr[i3] = k;
            this.f6060d[i3] = v;
            int i6 = this.f6058b;
            this.f6058b = i6 + 1;
            if (i6 >= this.f6066j) {
                m6188c(this.f6061e << 1);
            }
            return null;
        }
        if (k4 == null) {
            objArr[m6190d] = k;
            this.f6060d[m6190d] = v;
            int i7 = this.f6058b;
            this.f6058b = i7 + 1;
            if (i7 >= this.f6066j) {
                m6188c(this.f6061e << 1);
            }
            return null;
        }
        if (k5 == null) {
            objArr[m6193e] = k;
            this.f6060d[m6193e] = v;
            int i8 = this.f6058b;
            this.f6058b = i8 + 1;
            if (i8 >= this.f6066j) {
                m6188c(this.f6061e << 1);
            }
            return null;
        }
        if (this.f6069m && k2 == null) {
            objArr[i] = k;
            this.f6060d[i] = v;
            int i9 = this.f6058b;
            this.f6058b = i9 + 1;
            if (i9 >= this.f6066j) {
                m6188c(this.f6061e << 1);
            }
            return null;
        }
        m6184a(k, v, i3, k3, m6190d, k4, m6193e, k5, i, k2);
        return null;
    }

    /* renamed from: c */
    private void m6189c(K k, V v) {
        K k2;
        int i;
        int hashCode = k.hashCode();
        int i2 = hashCode & this.f6065i;
        K[] kArr = this.f6059c;
        K k3 = kArr[i2];
        if (k3 == null) {
            kArr[i2] = k;
            this.f6060d[i2] = v;
            int i3 = this.f6058b;
            this.f6058b = i3 + 1;
            if (i3 >= this.f6066j) {
                m6188c(this.f6061e << 1);
                return;
            }
            return;
        }
        int m6190d = m6190d(hashCode);
        K[] kArr2 = this.f6059c;
        K k4 = kArr2[m6190d];
        if (k4 == null) {
            kArr2[m6190d] = k;
            this.f6060d[m6190d] = v;
            int i4 = this.f6058b;
            this.f6058b = i4 + 1;
            if (i4 >= this.f6066j) {
                m6188c(this.f6061e << 1);
                return;
            }
            return;
        }
        int m6193e = m6193e(hashCode);
        K[] kArr3 = this.f6059c;
        K k5 = kArr3[m6193e];
        if (k5 == null) {
            kArr3[m6193e] = k;
            this.f6060d[m6193e] = v;
            int i5 = this.f6058b;
            this.f6058b = i5 + 1;
            if (i5 >= this.f6066j) {
                m6188c(this.f6061e << 1);
                return;
            }
            return;
        }
        if (this.f6069m) {
            int m6194f = m6194f(hashCode);
            K[] kArr4 = this.f6059c;
            K k6 = kArr4[m6194f];
            if (k6 == null) {
                kArr4[m6194f] = k;
                this.f6060d[m6194f] = v;
                int i6 = this.f6058b;
                this.f6058b = i6 + 1;
                if (i6 >= this.f6066j) {
                    m6188c(this.f6061e << 1);
                    return;
                }
                return;
            }
            i = m6194f;
            k2 = k6;
        } else {
            k2 = null;
            i = -1;
        }
        m6184a(k, v, i2, k3, m6190d, k4, m6193e, k5, i, k2);
    }

    /* renamed from: a */
    private void m6184a(K k, V v, int i, K k2, int i2, K k3, int i3, K k4, int i4, K k5) {
        K[] kArr;
        int i5;
        K k6;
        K[] kArr2 = this.f6059c;
        V[] vArr = this.f6060d;
        int i6 = this.f6065i;
        boolean z = this.f6069m;
        int i7 = this.f6068l;
        int i8 = z ? 4 : 3;
        K k7 = k;
        V v2 = v;
        int i9 = i;
        K k8 = k2;
        int i10 = i2;
        K k9 = k3;
        int i11 = i3;
        K k10 = k4;
        int i12 = i4;
        K k11 = k5;
        int i13 = 0;
        while (true) {
            switch (f6057a.nextInt(i8)) {
                case 0:
                    V v3 = vArr[i9];
                    kArr2[i9] = k7;
                    vArr[i9] = v2;
                    v2 = v3;
                    k7 = k8;
                    break;
                case 1:
                    V v4 = vArr[i10];
                    kArr2[i10] = k7;
                    vArr[i10] = v2;
                    v2 = v4;
                    k7 = k9;
                    break;
                case 2:
                    V v5 = vArr[i11];
                    kArr2[i11] = k7;
                    vArr[i11] = v2;
                    v2 = v5;
                    k7 = k10;
                    break;
                default:
                    V v6 = vArr[i12];
                    kArr2[i12] = k7;
                    vArr[i12] = v2;
                    k7 = k11;
                    v2 = v6;
                    break;
            }
            int hashCode = k7.hashCode();
            i9 = hashCode & i6;
            k8 = kArr2[i9];
            if (k8 == null) {
                kArr2[i9] = k7;
                vArr[i9] = v2;
                int i14 = this.f6058b;
                this.f6058b = i14 + 1;
                if (i14 >= this.f6066j) {
                    m6188c(this.f6061e << 1);
                    return;
                }
                return;
            }
            i10 = m6190d(hashCode);
            k9 = kArr2[i10];
            if (k9 == null) {
                kArr2[i10] = k7;
                vArr[i10] = v2;
                int i15 = this.f6058b;
                this.f6058b = i15 + 1;
                if (i15 >= this.f6066j) {
                    m6188c(this.f6061e << 1);
                    return;
                }
                return;
            }
            i11 = m6193e(hashCode);
            k10 = kArr2[i11];
            if (k10 == null) {
                kArr2[i11] = k7;
                vArr[i11] = v2;
                int i16 = this.f6058b;
                this.f6058b = i16 + 1;
                if (i16 >= this.f6066j) {
                    m6188c(this.f6061e << 1);
                    return;
                }
                return;
            }
            if (z) {
                i5 = m6194f(hashCode);
                k6 = kArr2[i5];
                if (k6 == null) {
                    kArr2[i5] = k7;
                    vArr[i5] = v2;
                    int i17 = this.f6058b;
                    this.f6058b = i17 + 1;
                    if (i17 >= this.f6066j) {
                        m6188c(this.f6061e << 1);
                        return;
                    }
                    return;
                }
                kArr = kArr2;
            } else {
                kArr = kArr2;
                i5 = i12;
                k6 = k11;
            }
            int i18 = i13 + 1;
            if (i18 == i7) {
                m6191d(k7, v2);
                return;
            }
            i13 = i18;
            k11 = k6;
            kArr2 = kArr;
            i12 = i5;
        }
    }

    /* renamed from: d */
    private void m6191d(K k, V v) {
        int i = this.f6062f;
        if (i == this.f6067k) {
            m6188c(this.f6061e << 1);
            m6186b(k, v);
            return;
        }
        int i2 = this.f6061e + i;
        this.f6059c[i2] = k;
        this.f6060d[i2] = v;
        this.f6062f = i + 1;
        this.f6058b++;
    }

    /* renamed from: a */
    public V m6195a(K k) {
        int hashCode = k.hashCode();
        int i = this.f6065i & hashCode;
        if (!k.equals(this.f6059c[i])) {
            i = m6190d(hashCode);
            if (!k.equals(this.f6059c[i])) {
                i = m6193e(hashCode);
                if (!k.equals(this.f6059c[i])) {
                    if (this.f6069m) {
                        i = m6194f(hashCode);
                        if (!k.equals(this.f6059c[i])) {
                            return m6187c((ObjectMap<K, V>) k);
                        }
                    } else {
                        return m6187c((ObjectMap<K, V>) k);
                    }
                }
            }
        }
        return this.f6060d[i];
    }

    /* renamed from: c */
    private V m6187c(K k) {
        K[] kArr = this.f6059c;
        int i = this.f6061e;
        int i2 = this.f6062f + i;
        while (i < i2) {
            if (k.equals(kArr[i])) {
                return this.f6060d[i];
            }
            i++;
        }
        return null;
    }

    /* renamed from: a */
    public void m6198a(int i) {
        if (this.f6061e <= i) {
            m6197a();
        } else {
            this.f6058b = 0;
            m6188c(i);
        }
    }

    /* renamed from: a */
    public void m6197a() {
        K[] kArr = this.f6059c;
        V[] vArr = this.f6060d;
        int i = this.f6061e + this.f6062f;
        while (true) {
            int i2 = i - 1;
            if (i > 0) {
                kArr[i2] = null;
                vArr[i2] = null;
                i = i2;
            } else {
                this.f6058b = 0;
                this.f6062f = 0;
                return;
            }
        }
    }

    /* renamed from: b */
    public boolean m6199b(K k) {
        int hashCode = k.hashCode();
        if (k.equals(this.f6059c[this.f6065i & hashCode])) {
            return true;
        }
        if (k.equals(this.f6059c[m6190d(hashCode)])) {
            return true;
        }
        if (k.equals(this.f6059c[m6193e(hashCode)])) {
            return true;
        }
        if (this.f6069m) {
            if (k.equals(this.f6059c[m6194f(hashCode)])) {
                return true;
            }
            return m6192d((ObjectMap<K, V>) k);
        }
        return m6192d((ObjectMap<K, V>) k);
    }

    /* renamed from: d */
    private boolean m6192d(K k) {
        K[] kArr = this.f6059c;
        int i = this.f6061e;
        int i2 = this.f6062f + i;
        while (i < i2) {
            if (k.equals(kArr[i])) {
                return true;
            }
            i++;
        }
        return false;
    }

    /* renamed from: c */
    private void m6188c(int i) {
        int i2 = this.f6061e + this.f6062f;
        this.f6061e = i;
        this.f6066j = (int) (i * this.f6063g);
        this.f6065i = i - 1;
        this.f6064h = 31 - Integer.numberOfTrailingZeros(i);
        double d = i;
        this.f6067k = Math.max(3, ((int) Math.ceil(Math.log(d))) * 2);
        this.f6068l = Math.max(Math.min(i, 8), ((int) Math.sqrt(d)) / 8);
        this.f6069m = (this.f6061e >>> 16) != 0;
        K[] kArr = this.f6059c;
        V[] vArr = this.f6060d;
        int i3 = this.f6067k;
        this.f6059c = (K[]) new Object[i + i3];
        this.f6060d = (V[]) new Object[i + i3];
        int i4 = this.f6058b;
        this.f6058b = 0;
        this.f6062f = 0;
        if (i4 > 0) {
            for (int i5 = 0; i5 < i2; i5++) {
                K k = kArr[i5];
                if (k != null) {
                    m6189c(k, vArr[i5]);
                }
            }
        }
    }

    /* renamed from: d */
    private int m6190d(int i) {
        int i2 = i * (-1105259343);
        return (i2 ^ (i2 >>> this.f6064h)) & this.f6065i;
    }

    /* renamed from: e */
    private int m6193e(int i) {
        int i2 = i * (-1262997959);
        return (i2 ^ (i2 >>> this.f6064h)) & this.f6065i;
    }

    /* renamed from: f */
    private int m6194f(int i) {
        int i2 = i * (-825114047);
        return (i2 ^ (i2 >>> this.f6064h)) & this.f6065i;
    }

    public String toString() {
        int i;
        if (this.f6058b == 0) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder(32);
        sb.append('{');
        K[] kArr = this.f6059c;
        V[] vArr = this.f6060d;
        int length = kArr.length;
        while (true) {
            i = length - 1;
            if (length > 0) {
                K k = kArr[i];
                if (k != null) {
                    sb.append(k);
                    sb.append('=');
                    sb.append(vArr[i]);
                    break;
                }
                length = i;
            } else {
                break;
            }
        }
        while (true) {
            int i2 = i - 1;
            if (i > 0) {
                K k2 = kArr[i2];
                if (k2 != null) {
                    sb.append(", ");
                    sb.append(k2);
                    sb.append('=');
                    sb.append(vArr[i2]);
                }
                i = i2;
            } else {
                sb.append('}');
                return sb.toString();
            }
        }
    }
}