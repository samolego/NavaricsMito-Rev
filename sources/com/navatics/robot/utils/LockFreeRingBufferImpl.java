package com.navatics.robot.utils;

/* renamed from: com.navatics.robot.utils.h */
/* loaded from: classes2.dex */
public class LockFreeRingBufferImpl {

    /* renamed from: a */
    private byte[] f6766a;

    /* renamed from: b */
    private int f6767b;

    /* renamed from: c */
    private volatile long f6768c;

    /* renamed from: d */
    private volatile long f6769d;

    /* renamed from: b */
    private boolean m5877b(int i) {
        return (i & (i + (-1))) == 0;
    }

    public LockFreeRingBufferImpl(int i) {
        i = ((i + (-1)) & i) != 0 ? m5880a(i) : i;
        this.f6766a = new byte[i];
        this.f6767b = i;
    }

    /* renamed from: a */
    public int m5881a() {
        return this.f6767b;
    }

    /* renamed from: a */
    public int m5879a(byte[] bArr, int i, int i2) {
        int i3;
        long j = this.f6768c;
        int min = (int) Math.min(i2, (this.f6767b + this.f6769d) - j);
        long j2 = min;
        int min2 = (int) Math.min(j2, this.f6767b - ((i3 - 1) & j));
        System.arraycopy(bArr, i, this.f6766a, (int) (j & (this.f6767b - 1)), min2);
        System.arraycopy(bArr, (i + min) - min2, this.f6766a, 0, min - min2);
        this.f6768c += j2;
        return min;
    }

    /* renamed from: b */
    public int m5876b(byte[] bArr, int i, int i2) {
        int i3;
        long j = this.f6768c;
        long j2 = this.f6769d;
        int min = (int) Math.min(i2, j - j2);
        long j3 = min;
        int min2 = (int) Math.min(j3, this.f6767b - ((i3 - 1) & j2));
        System.arraycopy(this.f6766a, (int) (j2 & (this.f6767b - 1)), bArr, i, min2);
        System.arraycopy(this.f6766a, min2, bArr, i + min2, min - min2);
        this.f6769d += j3;
        return min;
    }

    /* renamed from: b */
    public int m5878b() {
        return (int) (this.f6768c - this.f6769d);
    }

    /* renamed from: a */
    private int m5880a(int i) {
        if (m5877b(i)) {
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
