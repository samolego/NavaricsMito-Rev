package com.navatics.miya.p060b;

import java.util.Random;

/* renamed from: com.navatics.miya.b.i */
/* loaded from: classes.dex */
public class ObjectMap<K, V> {

    /* renamed from: a */
    static Random f6032a = new Random();

    /* renamed from: b */
    public int f6033b;

    /* renamed from: c */
    K[] f6034c;

    /* renamed from: d */
    V[] f6035d;

    /* renamed from: e */
    int f6036e;

    /* renamed from: f */
    int f6037f;

    /* renamed from: g */
    private float f6038g;

    /* renamed from: h */
    private int f6039h;

    /* renamed from: i */
    private int f6040i;

    /* renamed from: j */
    private int f6041j;

    /* renamed from: k */
    private int f6042k;

    /* renamed from: l */
    private int f6043l;

    /* renamed from: m */
    private boolean f6044m;

    /* renamed from: b */
    public static int m6672b(int i) {
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
        } else if (i > 1073741824) {
            throw new IllegalArgumentException("initialCapacity is too large: " + i);
        } else {
            this.f6036e = m6672b(i);
            if (f <= 0.0f) {
                throw new IllegalArgumentException("loadFactor must be > 0: " + f);
            }
            this.f6038g = f;
            this.f6044m = (this.f6036e >>> 16) != 0;
            int i2 = this.f6036e;
            this.f6041j = (int) (i2 * f);
            this.f6040i = i2 - 1;
            this.f6039h = 31 - Integer.numberOfTrailingZeros(i2);
            this.f6042k = Math.max(3, ((int) Math.ceil(Math.log(this.f6036e))) * 2);
            this.f6043l = Math.max(Math.min(this.f6036e, 8), ((int) Math.sqrt(this.f6036e)) / 8);
            this.f6034c = (K[]) new Object[this.f6036e + this.f6042k];
            this.f6035d = (V[]) new Object[this.f6034c.length];
        }
    }

    /* renamed from: a */
    public V m6674a(K k, V v) {
        if (k == null) {
            throw new IllegalArgumentException("key cannot be null.");
        }
        return m6670b(k, v);
    }

    /* renamed from: b */
    private V m6670b(K k, V v) {
        K k2;
        int i;
        K[] kArr = this.f6034c;
        int i2 = this.f6040i;
        int hashCode = k.hashCode();
        int i3 = hashCode & i2;
        K k3 = kArr[i3];
        if (k.equals(k3)) {
            V[] vArr = this.f6035d;
            V v2 = vArr[i3];
            vArr[i3] = v;
            return v2;
        }
        int m6666d = m6666d(hashCode);
        K k4 = kArr[m6666d];
        if (k.equals(k4)) {
            V[] vArr2 = this.f6035d;
            V v3 = vArr2[m6666d];
            vArr2[m6666d] = v;
            return v3;
        }
        int m6663e = m6663e(hashCode);
        K k5 = kArr[m6663e];
        if (k.equals(k5)) {
            V[] vArr3 = this.f6035d;
            V v4 = vArr3[m6663e];
            vArr3[m6663e] = v;
            return v4;
        }
        if (this.f6044m) {
            int m6662f = m6662f(hashCode);
            K k6 = kArr[m6662f];
            if (k.equals(k6)) {
                V[] vArr4 = this.f6035d;
                V v5 = vArr4[m6662f];
                vArr4[m6662f] = v;
                return v5;
            }
            i = m6662f;
            k2 = k6;
        } else {
            k2 = null;
            i = -1;
        }
        int i4 = this.f6036e;
        int i5 = this.f6037f + i4;
        while (i4 < i5) {
            if (k.equals(kArr[i4])) {
                V[] vArr5 = this.f6035d;
                V v6 = vArr5[i4];
                vArr5[i4] = v;
                return v6;
            }
            i4++;
        }
        if (k3 == null) {
            kArr[i3] = k;
            this.f6035d[i3] = v;
            int i6 = this.f6033b;
            this.f6033b = i6 + 1;
            if (i6 >= this.f6041j) {
                m6669c(this.f6036e << 1);
            }
            return null;
        } else if (k4 == null) {
            kArr[m6666d] = k;
            this.f6035d[m6666d] = v;
            int i7 = this.f6033b;
            this.f6033b = i7 + 1;
            if (i7 >= this.f6041j) {
                m6669c(this.f6036e << 1);
            }
            return null;
        } else if (k5 == null) {
            kArr[m6663e] = k;
            this.f6035d[m6663e] = v;
            int i8 = this.f6033b;
            this.f6033b = i8 + 1;
            if (i8 >= this.f6041j) {
                m6669c(this.f6036e << 1);
            }
            return null;
        } else if (this.f6044m && k2 == null) {
            kArr[i] = k;
            this.f6035d[i] = v;
            int i9 = this.f6033b;
            this.f6033b = i9 + 1;
            if (i9 >= this.f6041j) {
                m6669c(this.f6036e << 1);
            }
            return null;
        } else {
            m6673a(k, v, i3, k3, m6666d, k4, m6663e, k5, i, k2);
            return null;
        }
    }

    /* renamed from: c */
    private void m6667c(K k, V v) {
        K k2;
        int i;
        int hashCode = k.hashCode();
        int i2 = hashCode & this.f6040i;
        K[] kArr = this.f6034c;
        K k3 = kArr[i2];
        if (k3 == null) {
            kArr[i2] = k;
            this.f6035d[i2] = v;
            int i3 = this.f6033b;
            this.f6033b = i3 + 1;
            if (i3 >= this.f6041j) {
                m6669c(this.f6036e << 1);
                return;
            }
            return;
        }
        int m6666d = m6666d(hashCode);
        K[] kArr2 = this.f6034c;
        K k4 = kArr2[m6666d];
        if (k4 == null) {
            kArr2[m6666d] = k;
            this.f6035d[m6666d] = v;
            int i4 = this.f6033b;
            this.f6033b = i4 + 1;
            if (i4 >= this.f6041j) {
                m6669c(this.f6036e << 1);
                return;
            }
            return;
        }
        int m6663e = m6663e(hashCode);
        K[] kArr3 = this.f6034c;
        K k5 = kArr3[m6663e];
        if (k5 == null) {
            kArr3[m6663e] = k;
            this.f6035d[m6663e] = v;
            int i5 = this.f6033b;
            this.f6033b = i5 + 1;
            if (i5 >= this.f6041j) {
                m6669c(this.f6036e << 1);
                return;
            }
            return;
        }
        if (this.f6044m) {
            int m6662f = m6662f(hashCode);
            K[] kArr4 = this.f6034c;
            K k6 = kArr4[m6662f];
            if (k6 == null) {
                kArr4[m6662f] = k;
                this.f6035d[m6662f] = v;
                int i6 = this.f6033b;
                this.f6033b = i6 + 1;
                if (i6 >= this.f6041j) {
                    m6669c(this.f6036e << 1);
                    return;
                }
                return;
            }
            i = m6662f;
            k2 = k6;
        } else {
            k2 = null;
            i = -1;
        }
        m6673a(k, v, i2, k3, m6666d, k4, m6663e, k5, i, k2);
    }

    /* renamed from: a */
    private void m6673a(K k, V v, int i, K k2, int i2, K k3, int i3, K k4, int i4, K k5) {
        K[] kArr;
        int i5;
        K k6;
        K[] kArr2 = this.f6034c;
        V[] vArr = this.f6035d;
        int i6 = this.f6040i;
        boolean z = this.f6044m;
        int i7 = this.f6043l;
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
            switch (f6032a.nextInt(i8)) {
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
                int i14 = this.f6033b;
                this.f6033b = i14 + 1;
                if (i14 >= this.f6041j) {
                    m6669c(this.f6036e << 1);
                    return;
                }
                return;
            }
            i10 = m6666d(hashCode);
            k9 = kArr2[i10];
            if (k9 == null) {
                kArr2[i10] = k7;
                vArr[i10] = v2;
                int i15 = this.f6033b;
                this.f6033b = i15 + 1;
                if (i15 >= this.f6041j) {
                    m6669c(this.f6036e << 1);
                    return;
                }
                return;
            }
            i11 = m6663e(hashCode);
            k10 = kArr2[i11];
            if (k10 == null) {
                kArr2[i11] = k7;
                vArr[i11] = v2;
                int i16 = this.f6033b;
                this.f6033b = i16 + 1;
                if (i16 >= this.f6041j) {
                    m6669c(this.f6036e << 1);
                    return;
                }
                return;
            }
            if (z) {
                i5 = m6662f(hashCode);
                k6 = kArr2[i5];
                if (k6 == null) {
                    kArr2[i5] = k7;
                    vArr[i5] = v2;
                    int i17 = this.f6033b;
                    this.f6033b = i17 + 1;
                    if (i17 >= this.f6041j) {
                        m6669c(this.f6036e << 1);
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
                m6664d(k7, v2);
                return;
            }
            i13 = i18;
            k11 = k6;
            kArr2 = kArr;
            i12 = i5;
        }
    }

    /* renamed from: d */
    private void m6664d(K k, V v) {
        int i = this.f6037f;
        if (i == this.f6042k) {
            m6669c(this.f6036e << 1);
            m6670b(k, v);
            return;
        }
        int i2 = this.f6036e + i;
        this.f6034c[i2] = k;
        this.f6035d[i2] = v;
        this.f6037f = i + 1;
        this.f6033b++;
    }

    /* renamed from: a */
    public V m6675a(K k) {
        int hashCode = k.hashCode();
        int i = this.f6040i & hashCode;
        if (!k.equals(this.f6034c[i])) {
            i = m6666d(hashCode);
            if (!k.equals(this.f6034c[i])) {
                i = m6663e(hashCode);
                if (!k.equals(this.f6034c[i])) {
                    if (this.f6044m) {
                        i = m6662f(hashCode);
                        if (!k.equals(this.f6034c[i])) {
                            return m6668c((ObjectMap<K, V>) k);
                        }
                    } else {
                        return m6668c((ObjectMap<K, V>) k);
                    }
                }
            }
        }
        return this.f6035d[i];
    }

    /* renamed from: c */
    private V m6668c(K k) {
        K[] kArr = this.f6034c;
        int i = this.f6036e;
        int i2 = this.f6037f + i;
        while (i < i2) {
            if (k.equals(kArr[i])) {
                return this.f6035d[i];
            }
            i++;
        }
        return null;
    }

    /* renamed from: a */
    public void m6676a(int i) {
        if (this.f6036e <= i) {
            m6677a();
            return;
        }
        this.f6033b = 0;
        m6669c(i);
    }

    /* renamed from: a */
    public void m6677a() {
        K[] kArr = this.f6034c;
        V[] vArr = this.f6035d;
        int i = this.f6036e + this.f6037f;
        while (true) {
            int i2 = i - 1;
            if (i > 0) {
                kArr[i2] = null;
                vArr[i2] = null;
                i = i2;
            } else {
                this.f6033b = 0;
                this.f6037f = 0;
                return;
            }
        }
    }

    /* renamed from: b */
    public boolean m6671b(K k) {
        int hashCode = k.hashCode();
        if (k.equals(this.f6034c[this.f6040i & hashCode])) {
            return true;
        }
        if (k.equals(this.f6034c[m6666d(hashCode)])) {
            return true;
        }
        if (k.equals(this.f6034c[m6663e(hashCode)])) {
            return true;
        }
        if (this.f6044m) {
            if (k.equals(this.f6034c[m6662f(hashCode)])) {
                return true;
            }
            return m6665d((ObjectMap<K, V>) k);
        }
        return m6665d((ObjectMap<K, V>) k);
    }

    /* renamed from: d */
    private boolean m6665d(K k) {
        K[] kArr = this.f6034c;
        int i = this.f6036e;
        int i2 = this.f6037f + i;
        while (i < i2) {
            if (k.equals(kArr[i])) {
                return true;
            }
            i++;
        }
        return false;
    }

    /* renamed from: c */
    private void m6669c(int i) {
        int i2 = this.f6036e + this.f6037f;
        this.f6036e = i;
        this.f6041j = (int) (i * this.f6038g);
        this.f6040i = i - 1;
        this.f6039h = 31 - Integer.numberOfTrailingZeros(i);
        double d = i;
        this.f6042k = Math.max(3, ((int) Math.ceil(Math.log(d))) * 2);
        this.f6043l = Math.max(Math.min(i, 8), ((int) Math.sqrt(d)) / 8);
        this.f6044m = (this.f6036e >>> 16) != 0;
        K[] kArr = this.f6034c;
        V[] vArr = this.f6035d;
        int i3 = this.f6042k;
        this.f6034c = (K[]) new Object[i + i3];
        this.f6035d = (V[]) new Object[i + i3];
        int i4 = this.f6033b;
        this.f6033b = 0;
        this.f6037f = 0;
        if (i4 > 0) {
            for (int i5 = 0; i5 < i2; i5++) {
                K k = kArr[i5];
                if (k != null) {
                    m6667c(k, vArr[i5]);
                }
            }
        }
    }

    /* renamed from: d */
    private int m6666d(int i) {
        int i2 = i * (-1105259343);
        return (i2 ^ (i2 >>> this.f6039h)) & this.f6040i;
    }

    /* renamed from: e */
    private int m6663e(int i) {
        int i2 = i * (-1262997959);
        return (i2 ^ (i2 >>> this.f6039h)) & this.f6040i;
    }

    /* renamed from: f */
    private int m6662f(int i) {
        int i2 = i * (-825114047);
        return (i2 ^ (i2 >>> this.f6039h)) & this.f6040i;
    }

    public String toString() {
        int i;
        if (this.f6033b == 0) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder(32);
        sb.append('{');
        K[] kArr = this.f6034c;
        V[] vArr = this.f6035d;
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
