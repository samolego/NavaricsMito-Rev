package com.navatics.miya.p060b;

/* renamed from: com.navatics.miya.b.e */
/* loaded from: classes.dex */
public class IdentityObjectIntMap<K> {

    /* renamed from: a */
    public int f6003a;

    /* renamed from: b */
    private K[] f6004b;

    /* renamed from: c */
    private int[] f6005c;

    /* renamed from: d */
    private int f6006d;

    /* renamed from: e */
    private int f6007e;

    /* renamed from: f */
    private float f6008f;

    /* renamed from: g */
    private int f6009g;

    /* renamed from: h */
    private int f6010h;

    /* renamed from: i */
    private int f6011i;

    /* renamed from: j */
    private int f6012j;

    /* renamed from: k */
    private int f6013k;

    /* renamed from: l */
    private boolean f6014l;

    public IdentityObjectIntMap() {
        this(32, 0.8f);
    }

    public IdentityObjectIntMap(int i, float f) {
        if (i < 0) {
            throw new IllegalArgumentException("initialCapacity must be >= 0: " + i);
        } else if (this.f6006d > 1073741824) {
            throw new IllegalArgumentException("initialCapacity is too large: " + i);
        } else {
            this.f6006d = ObjectMap.m6672b(i);
            if (f <= 0.0f) {
                throw new IllegalArgumentException("loadFactor must be > 0: " + f);
            }
            this.f6008f = f;
            this.f6014l = (this.f6006d >>> 16) != 0;
            int i2 = this.f6006d;
            this.f6011i = (int) (i2 * f);
            this.f6010h = i2 - 1;
            this.f6009g = 31 - Integer.numberOfTrailingZeros(i2);
            this.f6012j = Math.max(3, ((int) Math.ceil(Math.log(this.f6006d))) * 2);
            this.f6013k = Math.max(Math.min(this.f6006d, 8), ((int) Math.sqrt(this.f6006d)) / 8);
            this.f6004b = (K[]) new Object[this.f6006d + this.f6012j];
            this.f6005c = new int[this.f6004b.length];
        }
    }

    /* renamed from: a */
    public void m6699a(K k, int i) {
        int i2;
        if (k == null) {
            throw new IllegalArgumentException("key cannot be null.");
        }
        K[] kArr = this.f6004b;
        int i3 = this.f6010h;
        int identityHashCode = System.identityHashCode(k);
        int i4 = identityHashCode & i3;
        K k2 = kArr[i4];
        if (k == k2) {
            this.f6005c[i4] = i;
            return;
        }
        int m6695c = m6695c(identityHashCode);
        K k3 = kArr[m6695c];
        if (k == k3) {
            this.f6005c[m6695c] = i;
            return;
        }
        int m6693d = m6693d(identityHashCode);
        K k4 = kArr[m6693d];
        if (k == k4) {
            this.f6005c[m6693d] = i;
            return;
        }
        K k5 = null;
        if (this.f6014l) {
            int m6691e = m6691e(identityHashCode);
            K k6 = kArr[m6691e];
            if (k == k6) {
                this.f6005c[m6691e] = i;
                return;
            } else {
                i2 = m6691e;
                k5 = k6;
            }
        } else {
            i2 = -1;
        }
        int i5 = this.f6006d;
        int i6 = this.f6007e + i5;
        while (i5 < i6) {
            if (kArr[i5] == k) {
                this.f6005c[i5] = i;
                return;
            }
            i5++;
        }
        if (k2 == null) {
            kArr[i4] = k;
            this.f6005c[i4] = i;
            int i7 = this.f6003a;
            this.f6003a = i7 + 1;
            if (i7 >= this.f6011i) {
                m6697b(this.f6006d << 1);
            }
        } else if (k3 == null) {
            kArr[m6695c] = k;
            this.f6005c[m6695c] = i;
            int i8 = this.f6003a;
            this.f6003a = i8 + 1;
            if (i8 >= this.f6011i) {
                m6697b(this.f6006d << 1);
            }
        } else if (k4 == null) {
            kArr[m6693d] = k;
            this.f6005c[m6693d] = i;
            int i9 = this.f6003a;
            this.f6003a = i9 + 1;
            if (i9 >= this.f6011i) {
                m6697b(this.f6006d << 1);
            }
        } else if (this.f6014l && k5 == null) {
            kArr[i2] = k;
            this.f6005c[i2] = i;
            int i10 = this.f6003a;
            this.f6003a = i10 + 1;
            if (i10 >= this.f6011i) {
                m6697b(this.f6006d << 1);
            }
        } else {
            m6698a(k, i, i4, k2, m6695c, k3, m6693d, k4, i2, k5);
        }
    }

    /* renamed from: c */
    private void m6694c(K k, int i) {
        K k2;
        int i2;
        int identityHashCode = System.identityHashCode(k);
        int i3 = identityHashCode & this.f6010h;
        K[] kArr = this.f6004b;
        K k3 = kArr[i3];
        if (k3 == null) {
            kArr[i3] = k;
            this.f6005c[i3] = i;
            int i4 = this.f6003a;
            this.f6003a = i4 + 1;
            if (i4 >= this.f6011i) {
                m6697b(this.f6006d << 1);
                return;
            }
            return;
        }
        int m6695c = m6695c(identityHashCode);
        K[] kArr2 = this.f6004b;
        K k4 = kArr2[m6695c];
        if (k4 == null) {
            kArr2[m6695c] = k;
            this.f6005c[m6695c] = i;
            int i5 = this.f6003a;
            this.f6003a = i5 + 1;
            if (i5 >= this.f6011i) {
                m6697b(this.f6006d << 1);
                return;
            }
            return;
        }
        int m6693d = m6693d(identityHashCode);
        K[] kArr3 = this.f6004b;
        K k5 = kArr3[m6693d];
        if (k5 == null) {
            kArr3[m6693d] = k;
            this.f6005c[m6693d] = i;
            int i6 = this.f6003a;
            this.f6003a = i6 + 1;
            if (i6 >= this.f6011i) {
                m6697b(this.f6006d << 1);
                return;
            }
            return;
        }
        if (this.f6014l) {
            int m6691e = m6691e(identityHashCode);
            K[] kArr4 = this.f6004b;
            K k6 = kArr4[m6691e];
            if (k6 == null) {
                kArr4[m6691e] = k;
                this.f6005c[m6691e] = i;
                int i7 = this.f6003a;
                this.f6003a = i7 + 1;
                if (i7 >= this.f6011i) {
                    m6697b(this.f6006d << 1);
                    return;
                }
                return;
            }
            i2 = m6691e;
            k2 = k6;
        } else {
            k2 = null;
            i2 = -1;
        }
        m6698a(k, i, i3, k3, m6695c, k4, m6693d, k5, i2, k2);
    }

    /* renamed from: a */
    private void m6698a(K k, int i, int i2, K k2, int i3, K k3, int i4, K k4, int i5, K k5) {
        K[] kArr;
        int i6;
        K k6;
        K[] kArr2 = this.f6004b;
        int[] iArr = this.f6005c;
        int i7 = this.f6010h;
        boolean z = this.f6014l;
        int i8 = this.f6013k;
        int i9 = z ? 4 : 3;
        K k7 = k;
        int i10 = i;
        int i11 = i2;
        K k8 = k2;
        int i12 = i3;
        K k9 = k3;
        int i13 = i4;
        K k10 = k4;
        int i14 = i5;
        K k11 = k5;
        int i15 = 0;
        while (true) {
            switch (ObjectMap.f6032a.nextInt(i9)) {
                case 0:
                    int i16 = iArr[i11];
                    kArr2[i11] = k7;
                    iArr[i11] = i10;
                    i10 = i16;
                    k7 = k8;
                    break;
                case 1:
                    int i17 = iArr[i12];
                    kArr2[i12] = k7;
                    iArr[i12] = i10;
                    i10 = i17;
                    k7 = k9;
                    break;
                case 2:
                    int i18 = iArr[i13];
                    kArr2[i13] = k7;
                    iArr[i13] = i10;
                    i10 = i18;
                    k7 = k10;
                    break;
                default:
                    int i19 = iArr[i14];
                    kArr2[i14] = k7;
                    iArr[i14] = i10;
                    k7 = k11;
                    i10 = i19;
                    break;
            }
            int identityHashCode = System.identityHashCode(k7);
            i11 = identityHashCode & i7;
            k8 = kArr2[i11];
            if (k8 == null) {
                kArr2[i11] = k7;
                iArr[i11] = i10;
                int i20 = this.f6003a;
                this.f6003a = i20 + 1;
                if (i20 >= this.f6011i) {
                    m6697b(this.f6006d << 1);
                    return;
                }
                return;
            }
            i12 = m6695c(identityHashCode);
            k9 = kArr2[i12];
            if (k9 == null) {
                kArr2[i12] = k7;
                iArr[i12] = i10;
                int i21 = this.f6003a;
                this.f6003a = i21 + 1;
                if (i21 >= this.f6011i) {
                    m6697b(this.f6006d << 1);
                    return;
                }
                return;
            }
            i13 = m6693d(identityHashCode);
            k10 = kArr2[i13];
            if (k10 == null) {
                kArr2[i13] = k7;
                iArr[i13] = i10;
                int i22 = this.f6003a;
                this.f6003a = i22 + 1;
                if (i22 >= this.f6011i) {
                    m6697b(this.f6006d << 1);
                    return;
                }
                return;
            }
            if (z) {
                i6 = m6691e(identityHashCode);
                k6 = kArr2[i6];
                if (k6 == null) {
                    kArr2[i6] = k7;
                    iArr[i6] = i10;
                    int i23 = this.f6003a;
                    this.f6003a = i23 + 1;
                    if (i23 >= this.f6011i) {
                        m6697b(this.f6006d << 1);
                        return;
                    }
                    return;
                }
                kArr = kArr2;
            } else {
                kArr = kArr2;
                i6 = i14;
                k6 = k11;
            }
            int i24 = i15 + 1;
            if (i24 == i8) {
                m6692d(k7, i10);
                return;
            }
            i15 = i24;
            k11 = k6;
            kArr2 = kArr;
            i14 = i6;
        }
    }

    /* renamed from: d */
    private void m6692d(K k, int i) {
        int i2 = this.f6007e;
        if (i2 == this.f6012j) {
            m6697b(this.f6006d << 1);
            m6699a(k, i);
            return;
        }
        int i3 = this.f6006d + i2;
        this.f6004b[i3] = k;
        this.f6005c[i3] = i;
        this.f6007e = i2 + 1;
        this.f6003a++;
    }

    /* renamed from: b */
    public int m6696b(K k, int i) {
        int identityHashCode = System.identityHashCode(k);
        int i2 = this.f6010h & identityHashCode;
        if (k != this.f6004b[i2]) {
            i2 = m6695c(identityHashCode);
            if (k != this.f6004b[i2]) {
                i2 = m6693d(identityHashCode);
                if (k != this.f6004b[i2]) {
                    if (this.f6014l) {
                        i2 = m6691e(identityHashCode);
                        if (k != this.f6004b[i2]) {
                            return m6690e(k, i);
                        }
                    } else {
                        return m6690e(k, i);
                    }
                }
            }
        }
        return this.f6005c[i2];
    }

    /* renamed from: e */
    private int m6690e(K k, int i) {
        K[] kArr = this.f6004b;
        int i2 = this.f6006d;
        int i3 = this.f6007e + i2;
        while (i2 < i3) {
            if (k == kArr[i2]) {
                return this.f6005c[i2];
            }
            i2++;
        }
        return i;
    }

    /* renamed from: a */
    public void m6700a(int i) {
        if (this.f6006d <= i) {
            m6701a();
            return;
        }
        this.f6003a = 0;
        m6697b(i);
    }

    /* renamed from: a */
    public void m6701a() {
        K[] kArr = this.f6004b;
        int i = this.f6006d + this.f6007e;
        while (true) {
            int i2 = i - 1;
            if (i > 0) {
                kArr[i2] = null;
                i = i2;
            } else {
                this.f6003a = 0;
                this.f6007e = 0;
                return;
            }
        }
    }

    /* renamed from: b */
    private void m6697b(int i) {
        int i2 = this.f6006d + this.f6007e;
        this.f6006d = i;
        this.f6011i = (int) (i * this.f6008f);
        this.f6010h = i - 1;
        this.f6009g = 31 - Integer.numberOfTrailingZeros(i);
        double d = i;
        this.f6012j = Math.max(3, ((int) Math.ceil(Math.log(d))) * 2);
        this.f6013k = Math.max(Math.min(i, 8), ((int) Math.sqrt(d)) / 8);
        this.f6014l = (this.f6006d >>> 16) != 0;
        K[] kArr = this.f6004b;
        int[] iArr = this.f6005c;
        int i3 = this.f6012j;
        this.f6004b = (K[]) new Object[i + i3];
        this.f6005c = new int[i + i3];
        int i4 = this.f6003a;
        this.f6003a = 0;
        this.f6007e = 0;
        if (i4 > 0) {
            for (int i5 = 0; i5 < i2; i5++) {
                K k = kArr[i5];
                if (k != null) {
                    m6694c(k, iArr[i5]);
                }
            }
        }
    }

    /* renamed from: c */
    private int m6695c(int i) {
        int i2 = i * (-1105259343);
        return (i2 ^ (i2 >>> this.f6009g)) & this.f6010h;
    }

    /* renamed from: d */
    private int m6693d(int i) {
        int i2 = i * (-1262997959);
        return (i2 ^ (i2 >>> this.f6009g)) & this.f6010h;
    }

    /* renamed from: e */
    private int m6691e(int i) {
        int i2 = i * (-825114047);
        return (i2 ^ (i2 >>> this.f6009g)) & this.f6010h;
    }

    public String toString() {
        int i;
        if (this.f6003a == 0) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder(32);
        sb.append('{');
        K[] kArr = this.f6004b;
        int[] iArr = this.f6005c;
        int length = kArr.length;
        while (true) {
            i = length - 1;
            if (length > 0) {
                K k = kArr[i];
                if (k != null) {
                    sb.append(k);
                    sb.append('=');
                    sb.append(iArr[i]);
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
                    sb.append(iArr[i2]);
                }
                i = i2;
            } else {
                sb.append('}');
                return sb.toString();
            }
        }
    }
}
