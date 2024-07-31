package com.navatics.robot.utils;

/* renamed from: com.navatics.robot.utils.d */
/* loaded from: classes2.dex */
public class CircularByteBuffer {

    /* renamed from: a */
    private final byte[] f6759a;

    /* renamed from: b */
    private final int f6760b;

    /* renamed from: c */
    private int f6761c;

    /* renamed from: d */
    private int f6762d;

    /* renamed from: e */
    private int f6763e;

    public CircularByteBuffer() {
        this(8192);
    }

    public CircularByteBuffer(int i) {
        this.f6760b = i;
        this.f6759a = new byte[this.f6760b];
    }

    /* renamed from: a */
    public synchronized int m5894a() {
        if (this.f6761c == 0) {
            return -1;
        }
        byte b = this.f6759a[this.f6762d];
        this.f6762d = (this.f6762d + 1) % this.f6760b;
        this.f6761c--;
        return b;
    }

    /* renamed from: a */
    public synchronized int m5891a(byte[] bArr, int i, int i2) {
        if (this.f6761c == 0) {
            return 0;
        }
        int min = Math.min((this.f6762d < this.f6763e ? this.f6763e : this.f6760b) - this.f6762d, i2);
        System.arraycopy(this.f6759a, this.f6762d, bArr, i, min);
        this.f6762d += min;
        if (this.f6762d == this.f6760b) {
            int min2 = Math.min(i2 - min, this.f6763e);
            if (min2 > 0) {
                System.arraycopy(this.f6759a, 0, bArr, i + min, min2);
                this.f6762d = min2;
                min += min2;
            } else {
                this.f6762d = 0;
            }
        }
        this.f6761c -= min;
        return min;
    }

    /* renamed from: a */
    public synchronized boolean m5893a(byte b) {
        if (this.f6761c == this.f6760b) {
            return false;
        }
        this.f6759a[this.f6763e] = b;
        this.f6763e = (this.f6763e + 1) % this.f6760b;
        this.f6761c++;
        return true;
    }

    /* renamed from: b */
    public synchronized int m5889b(byte[] bArr, int i, int i2) {
        if (this.f6761c == this.f6760b) {
            return 0;
        }
        int min = Math.min((this.f6763e < this.f6762d ? this.f6762d : this.f6760b) - this.f6763e, i2);
        System.arraycopy(bArr, i, this.f6759a, this.f6763e, min);
        this.f6763e += min;
        if (this.f6763e == this.f6760b) {
            int min2 = Math.min(i2 - min, this.f6762d);
            if (min2 > 0) {
                System.arraycopy(bArr, i + min, this.f6759a, 0, min2);
                this.f6763e = min2;
                min += min2;
            } else {
                this.f6763e = 0;
            }
        }
        this.f6761c += min;
        return min;
    }

    /* renamed from: a */
    public synchronized int m5892a(int i) {
        if (i > this.f6761c) {
            i = this.f6761c;
        }
        this.f6762d = (this.f6762d + i) % this.f6760b;
        this.f6761c -= i;
        return i;
    }

    /* renamed from: b */
    public synchronized int m5890b() {
        return this.f6761c;
    }
}
