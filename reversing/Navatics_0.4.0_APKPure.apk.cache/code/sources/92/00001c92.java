package com.navatics.robot.utils;

/* compiled from: CircularByteBuffer.java */
/* renamed from: com.navatics.robot.utils.d, reason: use source file name */
/* loaded from: classes2.dex */
public class CircularByteBuffer {

    /* renamed from: a */
    private final byte[] f6790a;

    /* renamed from: b */
    private final int f6791b;

    /* renamed from: c */
    private int f6792c;

    /* renamed from: d */
    private int f6793d;

    /* renamed from: e */
    private int f6794e;

    public CircularByteBuffer() {
        this(8192);
    }

    public CircularByteBuffer(int i) {
        this.f6791b = i;
        this.f6790a = new byte[this.f6791b];
    }

    /* renamed from: a */
    public synchronized int m6955a() {
        if (this.f6792c == 0) {
            return -1;
        }
        byte b = this.f6790a[this.f6793d];
        this.f6793d = (this.f6793d + 1) % this.f6791b;
        this.f6792c--;
        return b;
    }

    /* renamed from: a */
    public synchronized int m6957a(byte[] bArr, int i, int i2) {
        if (this.f6792c == 0) {
            return 0;
        }
        int min = Math.min((this.f6793d < this.f6794e ? this.f6794e : this.f6791b) - this.f6793d, i2);
        System.arraycopy(this.f6790a, this.f6793d, bArr, i, min);
        this.f6793d += min;
        if (this.f6793d == this.f6791b) {
            int min2 = Math.min(i2 - min, this.f6794e);
            if (min2 > 0) {
                System.arraycopy(this.f6790a, 0, bArr, i + min, min2);
                this.f6793d = min2;
                min += min2;
            } else {
                this.f6793d = 0;
            }
        }
        this.f6792c -= min;
        return min;
    }

    /* renamed from: a */
    public synchronized boolean m6958a(byte b) {
        if (this.f6792c == this.f6791b) {
            return false;
        }
        this.f6790a[this.f6794e] = b;
        this.f6794e = (this.f6794e + 1) % this.f6791b;
        this.f6792c++;
        return true;
    }

    /* renamed from: b */
    public synchronized int m6960b(byte[] bArr, int i, int i2) {
        if (this.f6792c == this.f6791b) {
            return 0;
        }
        int min = Math.min((this.f6794e < this.f6793d ? this.f6793d : this.f6791b) - this.f6794e, i2);
        System.arraycopy(bArr, i, this.f6790a, this.f6794e, min);
        this.f6794e += min;
        if (this.f6794e == this.f6791b) {
            int min2 = Math.min(i2 - min, this.f6793d);
            if (min2 > 0) {
                System.arraycopy(bArr, i + min, this.f6790a, 0, min2);
                this.f6794e = min2;
                min += min2;
            } else {
                this.f6794e = 0;
            }
        }
        this.f6792c += min;
        return min;
    }

    /* renamed from: a */
    public synchronized int m6956a(int i) {
        if (i > this.f6792c) {
            i = this.f6792c;
        }
        this.f6793d = (this.f6793d + i) % this.f6791b;
        this.f6792c -= i;
        return i;
    }

    /* renamed from: b */
    public synchronized int m6959b() {
        return this.f6792c;
    }
}