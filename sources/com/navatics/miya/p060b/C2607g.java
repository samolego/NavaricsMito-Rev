package com.navatics.miya.p060b;

/* renamed from: com.navatics.miya.b.g */
/* loaded from: classes.dex */
public class IntMap<V> {

    /* renamed from: a */
    public int f6018a;

    /* renamed from: b */
    int[] f6019b;

    /* renamed from: c */
    V[] f6020c;

    /* renamed from: d */
    int f6021d;

    /* renamed from: e */
    int f6022e;

    /* renamed from: f */
    V f6023f;

    /* renamed from: g */
    boolean f6024g;

    /* renamed from: h */
    private float f6025h;

    /* renamed from: i */
    private int f6026i;

    /* renamed from: j */
    private int f6027j;

    /* renamed from: k */
    private int f6028k;

    /* renamed from: l */
    private int f6029l;

    /* renamed from: m */
    private int f6030m;

    /* renamed from: n */
    private boolean f6031n;

    public IntMap() {
        this(32, 0.8f);
    }

    public IntMap(int i, float f) {
        if (i < 0) {
            throw new IllegalArgumentException("initialCapacity must be >= 0: " + i);
        } else if (i > 1073741824) {
            throw new IllegalArgumentException("initialCapacity is too large: " + i);
        } else {
            this.f6021d = ObjectMap.m6672b(i);
            if (f <= 0.0f) {
                throw new IllegalArgumentException("loadFactor must be > 0: " + f);
            }
            this.f6025h = f;
            this.f6031n = (this.f6021d >>> 16) != 0;
            int i2 = this.f6021d;
            this.f6028k = (int) (i2 * f);
            this.f6027j = i2 - 1;
            this.f6026i = 31 - Integer.numberOfTrailingZeros(i2);
            this.f6029l = Math.max(3, ((int) Math.ceil(Math.log(this.f6021d))) * 2);
            this.f6030m = Math.max(Math.min(this.f6021d, 8), ((int) Math.sqrt(this.f6021d)) / 8);
            this.f6019b = new int[this.f6021d + this.f6029l];
            this.f6020c = (V[]) new Object[this.f6019b.length];
        }
    }

    /* renamed from: a */
    public V m6687a(int i, V v) {
        int i2;
        if (i == 0) {
            V v2 = this.f6023f;
            this.f6023f = v;
            if (!this.f6024g) {
                this.f6024g = true;
                this.f6018a++;
            }
            return v2;
        }
        int[] iArr = this.f6019b;
        int i3 = this.f6027j & i;
        int i4 = iArr[i3];
        if (i4 == i) {
            V[] vArr = this.f6020c;
            V v3 = vArr[i3];
            vArr[i3] = v;
            return v3;
        }
        int m6683c = m6683c(i);
        int i5 = iArr[m6683c];
        if (i5 == i) {
            V[] vArr2 = this.f6020c;
            V v4 = vArr2[m6683c];
            vArr2[m6683c] = v;
            return v4;
        }
        int m6681d = m6681d(i);
        int i6 = iArr[m6681d];
        if (i6 == i) {
            V[] vArr3 = this.f6020c;
            V v5 = vArr3[m6681d];
            vArr3[m6681d] = v;
            return v5;
        }
        int i7 = -1;
        if (this.f6031n) {
            int m6679e = m6679e(i);
            int i8 = iArr[m6679e];
            if (i8 == i) {
                V[] vArr4 = this.f6020c;
                V v6 = vArr4[m6679e];
                vArr4[m6679e] = v;
                return v6;
            }
            i7 = m6679e;
            i2 = i8;
        } else {
            i2 = -1;
        }
        int i9 = this.f6021d;
        int i10 = this.f6022e + i9;
        while (i9 < i10) {
            if (iArr[i9] == i) {
                V[] vArr5 = this.f6020c;
                V v7 = vArr5[i9];
                vArr5[i9] = v;
                return v7;
            }
            i9++;
        }
        if (i4 == 0) {
            iArr[i3] = i;
            this.f6020c[i3] = v;
            int i11 = this.f6018a;
            this.f6018a = i11 + 1;
            if (i11 >= this.f6028k) {
                m6685b(this.f6021d << 1);
            }
            return null;
        } else if (i5 == 0) {
            iArr[m6683c] = i;
            this.f6020c[m6683c] = v;
            int i12 = this.f6018a;
            this.f6018a = i12 + 1;
            if (i12 >= this.f6028k) {
                m6685b(this.f6021d << 1);
            }
            return null;
        } else if (i6 == 0) {
            iArr[m6681d] = i;
            this.f6020c[m6681d] = v;
            int i13 = this.f6018a;
            this.f6018a = i13 + 1;
            if (i13 >= this.f6028k) {
                m6685b(this.f6021d << 1);
            }
            return null;
        } else if (this.f6031n && i2 == 0) {
            iArr[i7] = i;
            this.f6020c[i7] = v;
            int i14 = this.f6018a;
            this.f6018a = i14 + 1;
            if (i14 >= this.f6028k) {
                m6685b(this.f6021d << 1);
            }
            return null;
        } else {
            m6686a(i, v, i3, i4, m6683c, i5, m6681d, i6, i7, i2);
            return null;
        }
    }

    /* renamed from: b */
    private void m6684b(int i, V v) {
        int i2;
        int i3;
        if (i == 0) {
            this.f6023f = v;
            this.f6024g = true;
            return;
        }
        int i4 = i & this.f6027j;
        int[] iArr = this.f6019b;
        int i5 = iArr[i4];
        if (i5 == 0) {
            iArr[i4] = i;
            this.f6020c[i4] = v;
            int i6 = this.f6018a;
            this.f6018a = i6 + 1;
            if (i6 >= this.f6028k) {
                m6685b(this.f6021d << 1);
                return;
            }
            return;
        }
        int m6683c = m6683c(i);
        int[] iArr2 = this.f6019b;
        int i7 = iArr2[m6683c];
        if (i7 == 0) {
            iArr2[m6683c] = i;
            this.f6020c[m6683c] = v;
            int i8 = this.f6018a;
            this.f6018a = i8 + 1;
            if (i8 >= this.f6028k) {
                m6685b(this.f6021d << 1);
                return;
            }
            return;
        }
        int m6681d = m6681d(i);
        int[] iArr3 = this.f6019b;
        int i9 = iArr3[m6681d];
        if (i9 == 0) {
            iArr3[m6681d] = i;
            this.f6020c[m6681d] = v;
            int i10 = this.f6018a;
            this.f6018a = i10 + 1;
            if (i10 >= this.f6028k) {
                m6685b(this.f6021d << 1);
                return;
            }
            return;
        }
        if (this.f6031n) {
            int m6679e = m6679e(i);
            int[] iArr4 = this.f6019b;
            int i11 = iArr4[m6679e];
            if (i11 == 0) {
                iArr4[m6679e] = i;
                this.f6020c[m6679e] = v;
                int i12 = this.f6018a;
                this.f6018a = i12 + 1;
                if (i12 >= this.f6028k) {
                    m6685b(this.f6021d << 1);
                    return;
                }
                return;
            }
            i2 = m6679e;
            i3 = i11;
        } else {
            i2 = -1;
            i3 = -1;
        }
        m6686a(i, v, i4, i5, m6683c, i7, m6681d, i9, i2, i3);
    }

    /* renamed from: a */
    private void m6686a(int i, V v, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9) {
        int i10;
        int[] iArr;
        int[] iArr2 = this.f6019b;
        V[] vArr = this.f6020c;
        int i11 = this.f6027j;
        boolean z = this.f6031n;
        int i12 = this.f6030m;
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
            switch (ObjectMap.f6032a.nextInt(i13)) {
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
                int i24 = this.f6018a;
                this.f6018a = i24 + 1;
                if (i24 >= this.f6028k) {
                    m6685b(this.f6021d << 1);
                    return;
                }
                return;
            }
            i17 = m6683c(i14);
            i18 = iArr2[i17];
            if (i18 == 0) {
                iArr2[i17] = i14;
                vArr[i17] = v2;
                int i25 = this.f6018a;
                this.f6018a = i25 + 1;
                if (i25 >= this.f6028k) {
                    m6685b(this.f6021d << 1);
                    return;
                }
                return;
            }
            i19 = m6681d(i14);
            i20 = iArr2[i19];
            if (i20 == 0) {
                iArr2[i19] = i14;
                vArr[i19] = v2;
                int i26 = this.f6018a;
                this.f6018a = i26 + 1;
                if (i26 >= this.f6028k) {
                    m6685b(this.f6021d << 1);
                    return;
                }
                return;
            }
            if (z) {
                int m6679e = m6679e(i14);
                int i27 = iArr2[m6679e];
                if (i27 == 0) {
                    iArr2[m6679e] = i14;
                    vArr[m6679e] = v2;
                    int i28 = this.f6018a;
                    this.f6018a = i28 + 1;
                    if (i28 >= this.f6028k) {
                        m6685b(this.f6021d << 1);
                        return;
                    }
                    return;
                }
                iArr = iArr2;
                i21 = m6679e;
                i10 = i27;
            } else {
                i10 = i22;
                iArr = iArr2;
            }
            int i29 = i23 + 1;
            if (i29 == i12) {
                m6682c(i14, v2);
                return;
            }
            i23 = i29;
            i22 = i10;
            iArr2 = iArr;
        }
    }

    /* renamed from: c */
    private void m6682c(int i, V v) {
        int i2 = this.f6022e;
        if (i2 == this.f6029l) {
            m6685b(this.f6021d << 1);
            m6687a(i, v);
            return;
        }
        int i3 = this.f6021d + i2;
        this.f6019b[i3] = i;
        this.f6020c[i3] = v;
        this.f6022e = i2 + 1;
        this.f6018a++;
    }

    /* renamed from: a */
    public V m6688a(int i) {
        if (i == 0) {
            if (this.f6024g) {
                return this.f6023f;
            }
            return null;
        }
        int i2 = this.f6027j & i;
        if (this.f6019b[i2] != i) {
            i2 = m6683c(i);
            if (this.f6019b[i2] != i) {
                i2 = m6681d(i);
                if (this.f6019b[i2] != i) {
                    if (this.f6031n) {
                        i2 = m6679e(i);
                        if (this.f6019b[i2] != i) {
                            return m6680d(i, null);
                        }
                    } else {
                        return m6680d(i, null);
                    }
                }
            }
        }
        return this.f6020c[i2];
    }

    /* renamed from: d */
    private V m6680d(int i, V v) {
        int[] iArr = this.f6019b;
        int i2 = this.f6021d;
        int i3 = this.f6022e + i2;
        while (i2 < i3) {
            if (iArr[i2] == i) {
                return this.f6020c[i2];
            }
            i2++;
        }
        return v;
    }

    /* renamed from: a */
    public void m6689a() {
        int[] iArr = this.f6019b;
        V[] vArr = this.f6020c;
        int i = this.f6021d + this.f6022e;
        while (true) {
            int i2 = i - 1;
            if (i > 0) {
                iArr[i2] = 0;
                vArr[i2] = null;
                i = i2;
            } else {
                this.f6018a = 0;
                this.f6022e = 0;
                this.f6023f = null;
                this.f6024g = false;
                return;
            }
        }
    }

    /* renamed from: b */
    private void m6685b(int i) {
        int i2 = this.f6021d + this.f6022e;
        this.f6021d = i;
        this.f6028k = (int) (i * this.f6025h);
        this.f6027j = i - 1;
        this.f6026i = 31 - Integer.numberOfTrailingZeros(i);
        double d = i;
        this.f6029l = Math.max(3, ((int) Math.ceil(Math.log(d))) * 2);
        this.f6030m = Math.max(Math.min(i, 8), ((int) Math.sqrt(d)) / 8);
        this.f6031n = (this.f6021d >>> 16) != 0;
        int[] iArr = this.f6019b;
        V[] vArr = this.f6020c;
        int i3 = this.f6029l;
        this.f6019b = new int[i + i3];
        this.f6020c = (V[]) new Object[i + i3];
        int i4 = this.f6018a;
        this.f6018a = this.f6024g ? 1 : 0;
        this.f6022e = 0;
        if (i4 > 0) {
            for (int i5 = 0; i5 < i2; i5++) {
                int i6 = iArr[i5];
                if (i6 != 0) {
                    m6684b(i6, vArr[i5]);
                }
            }
        }
    }

    /* renamed from: c */
    private int m6683c(int i) {
        int i2 = i * (-1105259343);
        return (i2 ^ (i2 >>> this.f6026i)) & this.f6027j;
    }

    /* renamed from: d */
    private int m6681d(int i) {
        int i2 = i * (-1262997959);
        return (i2 ^ (i2 >>> this.f6026i)) & this.f6027j;
    }

    /* renamed from: e */
    private int m6679e(int i) {
        int i2 = i * (-825114047);
        return (i2 ^ (i2 >>> this.f6026i)) & this.f6027j;
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0043  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0059  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:15:0x003e -> B:16:0x003f). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.String toString() {
        /*
            r7 = this;
            int r0 = r7.f6018a
            if (r0 != 0) goto L7
            java.lang.String r0 = "[]"
            return r0
        L7:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r1 = 32
            r0.<init>(r1)
            r1 = 91
            r0.append(r1)
            int[] r1 = r7.f6019b
            V[] r2 = r7.f6020c
            int r3 = r1.length
            boolean r4 = r7.f6024g
            r5 = 61
            if (r4 == 0) goto L29
            java.lang.String r4 = "0="
            r0.append(r4)
            V r4 = r7.f6023f
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
        throw new UnsupportedOperationException("Method not decompiled: com.navatics.miya.p060b.IntMap.toString():java.lang.String");
    }
}
