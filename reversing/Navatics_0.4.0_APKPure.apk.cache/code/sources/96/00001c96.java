package com.navatics.robot.utils;

/* compiled from: LockFreeRingBufferImpl.java */
/* renamed from: com.navatics.robot.utils.h, reason: use source file name */
/* loaded from: classes2.dex */
public class LockFreeRingBufferImpl {

    /* renamed from: a */
    private byte[] f6797a;

    /* renamed from: b */
    private int f6798b;

    /* renamed from: c */
    private volatile long f6799c;

    /* renamed from: d */
    private volatile long f6800d;

    /* renamed from: b */
    private boolean m6969b(int i) {
        return (i & (i + (-1))) == 0;
    }

    public LockFreeRingBufferImpl(int i) {
        i = ((i + (-1)) & i) != 0 ? m6968a(i) : i;
        this.f6797a = new byte[i];
        this.f6798b = i;
    }

    /* renamed from: a */
    public int m6970a() {
        return this.f6798b;
    }

    /* renamed from: a */
    public int m6971a(byte[] bArr, int i, int i2) {
        long j = this.f6799c;
        int min = (int) Math.min(i2, (this.f6798b + this.f6800d) - j);
        long j2 = min;
        int min2 = (int) Math.min(j2, this.f6798b - ((r4 - 1) & j));
        System.arraycopy(bArr, i, this.f6797a, (int) (j & (this.f6798b - 1)), min2);
        System.arraycopy(bArr, (i + min) - min2, this.f6797a, 0, min - min2);
        this.f6799c += j2;
        return min;
    }

    /* renamed from: b */
    public int m6973b(byte[] bArr, int i, int i2) {
        long j = this.f6799c;
        long j2 = this.f6800d;
        int min = (int) Math.min(i2, j - j2);
        long j3 = min;
        int min2 = (int) Math.min(j3, this.f6798b - ((r4 - 1) & j2));
        System.arraycopy(this.f6797a, (int) (j2 & (this.f6798b - 1)), bArr, i, min2);
        System.arraycopy(this.f6797a, min2, bArr, i + min2, min - min2);
        this.f6800d += j3;
        return min;
    }

    /* renamed from: b */
    public int m6972b() {
        return (int) (this.f6799c - this.f6800d);
    }

    /* renamed from: a */
    private int m6968a(int i) {
        if (m6969b(i)) {
            return i;
        }
        int i2 = i | (i >> 1);
        int i3 = i2 | (i2 >> 2);
        int i4 = i3 | (i3 >> 4);
        int i5 = i4 | (i4 >> 8);
        int i6 = i5 | (i5 >> 16);
        int i7 = i6 | (i6 >> 24);
        return i7 - (i7 >> 1);
    }
}