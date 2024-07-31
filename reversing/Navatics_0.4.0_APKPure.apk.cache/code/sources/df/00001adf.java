package com.navatics.miya.util;

/* compiled from: IntMap.java */
/* renamed from: com.navatics.miya.b.g, reason: use source file name */
/* loaded from: classes.dex */
public class IntMap<V> {

    /* renamed from: a */
    public int f6043a;

    /* renamed from: b */
    int[] f6044b;

    /* renamed from: c */
    V[] f6045c;

    /* renamed from: d */
    int f6046d;

    /* renamed from: e */
    int f6047e;

    /* renamed from: f */
    V f6048f;

    /* renamed from: g */
    boolean f6049g;

    /* renamed from: h */
    private float f6050h;

    /* renamed from: i */
    private int f6051i;

    /* renamed from: j */
    private int f6052j;

    /* renamed from: k */
    private int f6053k;

    /* renamed from: l */
    private int f6054l;

    /* renamed from: m */
    private int f6055m;

    /* renamed from: n */
    private boolean f6056n;

    public IntMap() {
        this(32, 0.8f);
    }

    public IntMap(int i, float f) {
        if (i < 0) {
            throw new IllegalArgumentException("initialCapacity must be >= 0: " + i);
        }
        if (i > 1073741824) {
            throw new IllegalArgumentException("initialCapacity is too large: " + i);
        }
        this.f6046d = ObjectMap.m6185b(i);
        if (f <= 0.0f) {
            throw new IllegalArgumentException("loadFactor must be > 0: " + f);
        }
        this.f6050h = f;
        this.f6056n = (this.f6046d >>> 16) != 0;
        int i2 = this.f6046d;
        this.f6053k = (int) (i2 * f);
        this.f6052j = i2 - 1;
        this.f6051i = 31 - Integer.numberOfTrailingZeros(i2);
        this.f6054l = Math.max(3, ((int) Math.ceil(Math.log(this.f6046d))) * 2);
        this.f6055m = Math.max(Math.min(this.f6046d, 8), ((int) Math.sqrt(this.f6046d)) / 8);
        this.f6044b = new int[this.f6046d + this.f6054l];
        this.f6045c = (V[]) new Object[this.f6044b.length];
    }

    /* renamed from: a */
    public V m6181a(int i, V v) {
        int i2;
        if (i == 0) {
            V v2 = this.f6048f;
            this.f6048f = v;
            if (!this.f6049g) {
                this.f6049g = true;
                this.f6043a++;
            }
            return v2;
        }
        int[] iArr = this.f6044b;
        int i3 = this.f6052j & i;
        int i4 = iArr[i3];
        if (i4 == i) {
            V[] vArr = this.f6045c;
            V v3 = vArr[i3];
            vArr[i3] = v;
            return v3;
        }
        int m6175c = m6175c(i);
        int i5 = iArr[m6175c];
        if (i5 == i) {
            V[] vArr2 = this.f6045c;
            V v4 = vArr2[m6175c];
            vArr2[m6175c] = v;
            return v4;
        }
        int m6177d = m6177d(i);
        int i6 = iArr[m6177d];
        if (i6 == i) {
            V[] vArr3 = this.f6045c;
            V v5 = vArr3[m6177d];
            vArr3[m6177d] = v;
            return v5;
        }
        int i7 = -1;
        if (this.f6056n) {
            int m6179e = m6179e(i);
            int i8 = iArr[m6179e];
            if (i8 == i) {
                V[] vArr4 = this.f6045c;
                V v6 = vArr4[m6179e];
                vArr4[m6179e] = v;
                return v6;
            }
            i7 = m6179e;
            i2 = i8;
        } else {
            i2 = -1;
        }
        int i9 = this.f6046d;
        int i10 = this.f6047e + i9;
        while (i9 < i10) {
            if (iArr[i9] == i) {
                V[] vArr5 = this.f6045c;
                V v7 = vArr5[i9];
                vArr5[i9] = v;
                return v7;
            }
            i9++;
        }
        if (i4 == 0) {
            iArr[i3] = i;
            this.f6045c[i3] = v;
            int i11 = this.f6043a;
            this.f6043a = i11 + 1;
            if (i11 >= this.f6053k) {
                m6173b(this.f6046d << 1);
            }
            return null;
        }
        if (i5 == 0) {
            iArr[m6175c] = i;
            this.f6045c[m6175c] = v;
            int i12 = this.f6043a;
            this.f6043a = i12 + 1;
            if (i12 >= this.f6053k) {
                m6173b(this.f6046d << 1);
            }
            return null;
        }
        if (i6 == 0) {
            iArr[m6177d] = i;
            this.f6045c[m6177d] = v;
            int i13 = this.f6043a;
            this.f6043a = i13 + 1;
            if (i13 >= this.f6053k) {
                m6173b(this.f6046d << 1);
            }
            return null;
        }
        if (this.f6056n && i2 == 0) {
            iArr[i7] = i;
            this.f6045c[i7] = v;
            int i14 = this.f6043a;
            this.f6043a = i14 + 1;
            if (i14 >= this.f6053k) {
                m6173b(this.f6046d << 1);
            }
            return null;
        }
        m6172a(i, v, i3, i4, m6175c, i5, m6177d, i6, i7, i2);
        return null;
    }

    /* renamed from: b */
    private void m6174b(int i, V v) {
        int i2;
        int i3;
        if (i == 0) {
            this.f6048f = v;
            this.f6049g = true;
            return;
        }
        int i4 = i & this.f6052j;
        int[] iArr = this.f6044b;
        int i5 = iArr[i4];
        if (i5 == 0) {
            iArr[i4] = i;
            this.f6045c[i4] = v;
            int i6 = this.f6043a;
            this.f6043a = i6 + 1;
            if (i6 >= this.f6053k) {
                m6173b(this.f6046d << 1);
                return;
            }
            return;
        }
        int m6175c = m6175c(i);
        int[] iArr2 = this.f6044b;
        int i7 = iArr2[m6175c];
        if (i7 == 0) {
            iArr2[m6175c] = i;
            this.f6045c[m6175c] = v;
            int i8 = this.f6043a;
            this.f6043a = i8 + 1;
            if (i8 >= this.f6053k) {
                m6173b(this.f6046d << 1);
                return;
            }
            return;
        }
        int m6177d = m6177d(i);
        int[] iArr3 = this.f6044b;
        int i9 = iArr3[m6177d];
        if (i9 == 0) {
            iArr3[m6177d] = i;
            this.f6045c[m6177d] = v;
            int i10 = this.f6043a;
            this.f6043a = i10 + 1;
            if (i10 >= this.f6053k) {
                m6173b(this.f6046d << 1);
                return;
            }
            return;
        }
        if (this.f6056n) {
            int m6179e = m6179e(i);
            int[] iArr4 = this.f6044b;
            int i11 = iArr4[m6179e];
            if (i11 == 0) {
                iArr4[m6179e] = i;
                this.f6045c[m6179e] = v;
                int i12 = this.f6043a;
                this.f6043a = i12 + 1;
                if (i12 >= this.f6053k) {
                    m6173b(this.f6046d << 1);
                    return;
                }
                return;
            }
            i2 = m6179e;
            i3 = i11;
        } else {
            i2 = -1;
            i3 = -1;
        }
        m6172a(i, v, i4, i5, m6175c, i7, m6177d, i9, i2, i3);
    }

    /* renamed from: a */
    private void m6172a(int i, V v, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9) {
        int i10;
        int[] iArr;
        int[] iArr2 = this.f6044b;
        V[] vArr = this.f6045c;
        int i11 = this.f6052j;
        boolean z = this.f6056n;
        int i12 = this.f6055m;
        int i13 = z ? 4 : 3;
        int i14 = i;
        V v2 = v;
        int i15 = i2;
        int i16 = i3;
        int i17 = i4;
        int i18 = i5;
        int i19 = i6;
        int i20 = i7;
        int i21 = i8;
        int i22 = i9;
        int i23 = 0;
        while (true) {
            switch (ObjectMap.f6057a.nextInt(i13)) {
                case 0:
                    V v3 = vArr[i15];
                    iArr2[i15] = i14;
                    vArr[i15] = v2;
                    v2 = v3;
                    i14 = i16;
                    break;
                case 1:
                    V v4 = vArr[i17];
                    iArr2[i17] = i14;
                    vArr[i17] = v2;
                    v2 = v4;
                    i14 = i18;
                    break;
                case 2:
                    V v5 = vArr[i19];
                    iArr2[i19] = i14;
                    vArr[i19] = v2;
                    v2 = v5;
                    i14 = i20;
                    break;
                default:
                    V v6 = vArr[i21];
                    iArr2[i21] = i14;
                    vArr[i21] = v2;
                    i14 = i22;
                    v2 = v6;
                    break;
            }
            i15 = i14 & i11;
            i16 = iArr2[i15];
            if (i16 == 0) {
                iArr2[i15] = i14;
                vArr[i15] = v2;
                int i24 = this.f6043a;
                this.f6043a = i24 + 1;
                if (i24 >= this.f6053k) {
                    m6173b(this.f6046d << 1);
                    return;
                }
                return;
            }
            i17 = m6175c(i14);
            i18 = iArr2[i17];
            if (i18 == 0) {
                iArr2[i17] = i14;
                vArr[i17] = v2;
                int i25 = this.f6043a;
                this.f6043a = i25 + 1;
                if (i25 >= this.f6053k) {
                    m6173b(this.f6046d << 1);
                    return;
                }
                return;
            }
            i19 = m6177d(i14);
            i20 = iArr2[i19];
            if (i20 == 0) {
                iArr2[i19] = i14;
                vArr[i19] = v2;
                int i26 = this.f6043a;
                this.f6043a = i26 + 1;
                if (i26 >= this.f6053k) {
                    m6173b(this.f6046d << 1);
                    return;
                }
                return;
            }
            if (z) {
                int m6179e = m6179e(i14);
                int i27 = iArr2[m6179e];
                if (i27 == 0) {
                    iArr2[m6179e] = i14;
                    vArr[m6179e] = v2;
                    int i28 = this.f6043a;
                    this.f6043a = i28 + 1;
                    if (i28 >= this.f6053k) {
                        m6173b(this.f6046d << 1);
                        return;
                    }
                    return;
                }
                iArr = iArr2;
                i21 = m6179e;
                i10 = i27;
            } else {
                i10 = i22;
                iArr = iArr2;
            }
            int i29 = i23 + 1;
            if (i29 == i12) {
                m6176c(i14, v2);
                return;
            } else {
                i23 = i29;
                i22 = i10;
                iArr2 = iArr;
            }
        }
    }

    /* renamed from: c */
    private void m6176c(int i, V v) {
        int i2 = this.f6047e;
        if (i2 == this.f6054l) {
            m6173b(this.f6046d << 1);
            m6181a(i, v);
            return;
        }
        int i3 = this.f6046d + i2;
        this.f6044b[i3] = i;
        this.f6045c[i3] = v;
        this.f6047e = i2 + 1;
        this.f6043a++;
    }

    /* renamed from: a */
    public V m6180a(int i) {
        if (i == 0) {
            if (this.f6049g) {
                return this.f6048f;
            }
            return null;
        }
        int i2 = this.f6052j & i;
        if (this.f6044b[i2] != i) {
            i2 = m6175c(i);
            if (this.f6044b[i2] != i) {
                i2 = m6177d(i);
                if (this.f6044b[i2] != i) {
                    if (this.f6056n) {
                        i2 = m6179e(i);
                        if (this.f6044b[i2] != i) {
                            return m6178d(i, null);
                        }
                    } else {
                        return m6178d(i, null);
                    }
                }
            }
        }
        return this.f6045c[i2];
    }

    /* renamed from: d */
    private V m6178d(int i, V v) {
        int[] iArr = this.f6044b;
        int i2 = this.f6046d;
        int i3 = this.f6047e + i2;
        while (i2 < i3) {
            if (iArr[i2] == i) {
                return this.f6045c[i2];
            }
            i2++;
        }
        return v;
    }

    /* renamed from: a */
    public void m6182a() {
        int[] iArr = this.f6044b;
        V[] vArr = this.f6045c;
        int i = this.f6046d + this.f6047e;
        while (true) {
            int i2 = i - 1;
            if (i > 0) {
                iArr[i2] = 0;
                vArr[i2] = null;
                i = i2;
            } else {
                this.f6043a = 0;
                this.f6047e = 0;
                this.f6048f = null;
                this.f6049g = false;
                return;
            }
        }
    }

    /* renamed from: b */
    private void m6173b(int i) {
        int i2 = this.f6046d + this.f6047e;
        this.f6046d = i;
        this.f6053k = (int) (i * this.f6050h);
        this.f6052j = i - 1;
        this.f6051i = 31 - Integer.numberOfTrailingZeros(i);
        double d = i;
        this.f6054l = Math.max(3, ((int) Math.ceil(Math.log(d))) * 2);
        this.f6055m = Math.max(Math.min(i, 8), ((int) Math.sqrt(d)) / 8);
        this.f6056n = (this.f6046d >>> 16) != 0;
        int[] iArr = this.f6044b;
        V[] vArr = this.f6045c;
        int i3 = this.f6054l;
        this.f6044b = new int[i + i3];
        this.f6045c = (V[]) new Object[i + i3];
        int i4 = this.f6043a;
        this.f6043a = this.f6049g ? 1 : 0;
        this.f6047e = 0;
        if (i4 > 0) {
            for (int i5 = 0; i5 < i2; i5++) {
                int i6 = iArr[i5];
                if (i6 != 0) {
                    m6174b(i6, vArr[i5]);
                }
            }
        }
    }

    /* renamed from: c */
    private int m6175c(int i) {
        int i2 = i * (-1105259343);
        return (i2 ^ (i2 >>> this.f6051i)) & this.f6052j;
    }

    /* renamed from: d */
    private int m6177d(int i) {
        int i2 = i * (-1262997959);
        return (i2 ^ (i2 >>> this.f6051i)) & this.f6052j;
    }

    /* renamed from: e */
    private int m6179e(int i) {
        int i2 = i * (-825114047);
        return (i2 ^ (i2 >>> this.f6051i)) & this.f6052j;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0043  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0059  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:14:0x003e -> B:9:0x003f). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.String toString() {
        /*
            r7 = this;
            int r0 = r7.f6043a
            if (r0 != 0) goto L7
            java.lang.String r0 = "[]"
            return r0
        L7:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r1 = 32
            r0.<init>(r1)
            r1 = 91
            r0.append(r1)
            int[] r1 = r7.f6044b
            V[] r2 = r7.f6045c
            int r3 = r1.length
            boolean r4 = r7.f6049g
            r5 = 61
            if (r4 == 0) goto L29
            java.lang.String r4 = "0="
            r0.append(r4)
            V r4 = r7.f6048f
            r0.append(r4)
            goto L3f
        L29:
            int r4 = r3 + (-1)
            if (r3 <= 0) goto L3e
            r3 = r1[r4]
            if (r3 != 0) goto L33
            r3 = r4
            goto L29
        L33:
            r0.append(r3)
            r0.append(r5)
            r3 = r2[r4]
            r0.append(r3)
        L3e:
            r3 = r4
        L3f:
            int r4 = r3 + (-1)
            if (r3 <= 0) goto L59
            r3 = r1[r4]
            if (r3 != 0) goto L48
            goto L3e
        L48:
            java.lang.String r6 = ", "
            r0.append(r6)
            r0.append(r3)
            r0.append(r5)
            r3 = r2[r4]
            r0.append(r3)
            goto L3e
        L59:
            r1 = 93
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.navatics.miya.util.IntMap.toString():java.lang.String");
    }
}