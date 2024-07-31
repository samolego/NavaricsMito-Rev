package com.navatics.miya.p059a;

import com.navatics.miya.MiyaException;
import java.io.IOException;
import java.io.OutputStream;

/* renamed from: com.navatics.miya.a.b */
/* loaded from: classes.dex */
public class Output extends OutputStream implements AutoCloseable {

    /* renamed from: a */
    protected int f5954a;

    /* renamed from: b */
    protected long f5955b;

    /* renamed from: c */
    protected int f5956c;

    /* renamed from: d */
    protected int f5957d;

    /* renamed from: e */
    protected byte[] f5958e;

    /* renamed from: f */
    protected OutputStream f5959f;

    /* renamed from: g */
    protected boolean f5960g = true;

    /* renamed from: a */
    public byte[] m6764a() {
        return this.f5958e;
    }

    /* renamed from: b */
    public int m6749b() {
        return this.f5956c;
    }

    /* renamed from: a */
    protected boolean m6759a(int i) throws MiyaException {
        int i2;
        int i3;
        if (this.f5957d - this.f5956c >= i) {
            return false;
        }
        flush();
        int i4 = this.f5957d;
        int i5 = this.f5956c;
        if (i4 - i5 >= i) {
            return true;
        }
        int i6 = this.f5954a;
        if (i <= i6 - i5) {
            if (i4 == 0) {
                this.f5957d = 16;
            }
            do {
                this.f5957d = Math.min(this.f5957d * 2, this.f5954a);
                i2 = this.f5957d;
                i3 = this.f5956c;
            } while (i2 - i3 < i);
            byte[] bArr = new byte[i2];
            System.arraycopy(this.f5958e, 0, bArr, 0, i3);
            this.f5958e = bArr;
            return true;
        } else if (i > i6) {
            throw new MiyaException("Buffer overflow. Max capacity: " + this.f5954a + ", required: " + i);
        } else {
            throw new MiyaException("Buffer overflow. Available: " + (this.f5954a - this.f5956c) + ", required: " + i);
        }
    }

    @Override // java.io.OutputStream, java.io.Flushable
    public void flush() throws MiyaException {
        OutputStream outputStream = this.f5959f;
        if (outputStream == null) {
            return;
        }
        try {
            outputStream.write(this.f5958e, 0, this.f5956c);
            this.f5959f.flush();
            this.f5955b += this.f5956c;
            this.f5956c = 0;
        } catch (IOException e) {
            throw new MiyaException(e);
        }
    }

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws MiyaException {
        flush();
        OutputStream outputStream = this.f5959f;
        if (outputStream != null) {
            try {
                outputStream.close();
            } catch (IOException unused) {
            }
        }
    }

    @Override // java.io.OutputStream
    public void write(int i) throws MiyaException {
        if (this.f5956c == this.f5957d) {
            m6759a(1);
        }
        byte[] bArr = this.f5958e;
        int i2 = this.f5956c;
        this.f5956c = i2 + 1;
        bArr[i2] = (byte) i;
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr) throws MiyaException {
        if (bArr == null) {
            throw new IllegalArgumentException("bytes cannot be null.");
        }
        m6750a(bArr, 0, bArr.length);
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr, int i, int i2) throws MiyaException {
        m6750a(bArr, i, i2);
    }

    /* renamed from: a */
    public void m6763a(byte b) throws MiyaException {
        if (this.f5956c == this.f5957d) {
            m6759a(1);
        }
        byte[] bArr = this.f5958e;
        int i = this.f5956c;
        this.f5956c = i + 1;
        bArr[i] = b;
    }

    /* renamed from: b */
    public void m6748b(int i) throws MiyaException {
        if (this.f5956c == this.f5957d) {
            m6759a(1);
        }
        byte[] bArr = this.f5958e;
        int i2 = this.f5956c;
        this.f5956c = i2 + 1;
        bArr[i2] = (byte) i;
    }

    /* renamed from: a */
    public void m6750a(byte[] bArr, int i, int i2) throws MiyaException {
        if (bArr == null) {
            throw new IllegalArgumentException("bytes cannot be null.");
        }
        int min = Math.min(this.f5957d - this.f5956c, i2);
        while (true) {
            System.arraycopy(bArr, i, this.f5958e, this.f5956c, min);
            this.f5956c += min;
            i2 -= min;
            if (i2 == 0) {
                return;
            }
            i += min;
            min = Math.min(this.f5957d, i2);
            m6759a(min);
        }
    }

    /* renamed from: c */
    public void m6746c(int i) throws MiyaException {
        m6759a(4);
        byte[] bArr = this.f5958e;
        int i2 = this.f5956c;
        this.f5956c = i2 + 4;
        bArr[i2] = (byte) i;
        bArr[i2 + 1] = (byte) (i >> 8);
        bArr[i2 + 2] = (byte) (i >> 16);
        bArr[i2 + 3] = (byte) (i >> 24);
    }

    /* renamed from: a */
    public int m6758a(int i, boolean z) throws MiyaException {
        if (!z) {
            i = (i >> 31) ^ (i << 1);
        }
        int i2 = i >>> 7;
        if (i2 == 0) {
            if (this.f5956c == this.f5957d) {
                m6759a(1);
            }
            byte[] bArr = this.f5958e;
            int i3 = this.f5956c;
            this.f5956c = i3 + 1;
            bArr[i3] = (byte) i;
            return 1;
        }
        int i4 = i >>> 14;
        if (i4 == 0) {
            m6759a(2);
            int i5 = this.f5956c;
            this.f5956c = i5 + 2;
            byte[] bArr2 = this.f5958e;
            bArr2[i5] = (byte) ((i & 127) | 128);
            bArr2[i5 + 1] = (byte) i2;
            return 2;
        }
        int i6 = i >>> 21;
        if (i6 == 0) {
            m6759a(3);
            int i7 = this.f5956c;
            this.f5956c = i7 + 3;
            byte[] bArr3 = this.f5958e;
            bArr3[i7] = (byte) ((i & 127) | 128);
            bArr3[i7 + 1] = (byte) (i2 | 128);
            bArr3[i7 + 2] = (byte) i4;
            return 3;
        }
        int i8 = i >>> 28;
        if (i8 == 0) {
            m6759a(4);
            int i9 = this.f5956c;
            this.f5956c = i9 + 4;
            byte[] bArr4 = this.f5958e;
            bArr4[i9] = (byte) ((i & 127) | 128);
            bArr4[i9 + 1] = (byte) (i2 | 128);
            bArr4[i9 + 2] = (byte) (i4 | 128);
            bArr4[i9 + 3] = (byte) i6;
            return 4;
        }
        m6759a(5);
        int i10 = this.f5956c;
        this.f5956c = i10 + 5;
        byte[] bArr5 = this.f5958e;
        bArr5[i10] = (byte) ((i & 127) | 128);
        bArr5[i10 + 1] = (byte) (i2 | 128);
        bArr5[i10 + 2] = (byte) (i4 | 128);
        bArr5[i10 + 3] = (byte) (i6 | 128);
        bArr5[i10 + 4] = (byte) i8;
        return 5;
    }

    /* renamed from: a */
    public int m6751a(boolean z, int i, boolean z2) throws MiyaException {
        if (!z2) {
            i = (i >> 31) ^ (i << 1);
        }
        int i2 = (z ? 128 : 0) | (i & 63);
        int i3 = i >>> 6;
        if (i3 == 0) {
            if (this.f5956c == this.f5957d) {
                m6759a(1);
            }
            byte[] bArr = this.f5958e;
            int i4 = this.f5956c;
            this.f5956c = i4 + 1;
            bArr[i4] = (byte) i2;
            return 1;
        }
        int i5 = i >>> 13;
        if (i5 == 0) {
            m6759a(2);
            int i6 = this.f5956c;
            this.f5956c = i6 + 2;
            byte[] bArr2 = this.f5958e;
            bArr2[i6] = (byte) (i2 | 64);
            bArr2[i6 + 1] = (byte) i3;
            return 2;
        }
        int i7 = i >>> 20;
        if (i7 == 0) {
            m6759a(3);
            byte[] bArr3 = this.f5958e;
            int i8 = this.f5956c;
            this.f5956c = i8 + 3;
            bArr3[i8] = (byte) (i2 | 64);
            bArr3[i8 + 1] = (byte) (i3 | 128);
            bArr3[i8 + 2] = (byte) i5;
            return 3;
        }
        int i9 = i >>> 27;
        if (i9 == 0) {
            m6759a(4);
            byte[] bArr4 = this.f5958e;
            int i10 = this.f5956c;
            this.f5956c = i10 + 4;
            bArr4[i10] = (byte) (i2 | 64);
            bArr4[i10 + 1] = (byte) (i3 | 128);
            bArr4[i10 + 2] = (byte) (i5 | 128);
            bArr4[i10 + 3] = (byte) i7;
            return 4;
        }
        m6759a(5);
        byte[] bArr5 = this.f5958e;
        int i11 = this.f5956c;
        this.f5956c = i11 + 5;
        bArr5[i11] = (byte) (i2 | 64);
        bArr5[i11 + 1] = (byte) (i3 | 128);
        bArr5[i11 + 2] = (byte) (i5 | 128);
        bArr5[i11 + 3] = (byte) (i7 | 128);
        bArr5[i11 + 4] = (byte) i9;
        return 5;
    }

    /* renamed from: a */
    public void m6757a(long j) throws MiyaException {
        m6759a(8);
        byte[] bArr = this.f5958e;
        int i = this.f5956c;
        this.f5956c = i + 8;
        bArr[i] = (byte) j;
        bArr[i + 1] = (byte) (j >>> 8);
        bArr[i + 2] = (byte) (j >>> 16);
        bArr[i + 3] = (byte) (j >>> 24);
        bArr[i + 4] = (byte) (j >>> 32);
        bArr[i + 5] = (byte) (j >>> 40);
        bArr[i + 6] = (byte) (j >>> 48);
        bArr[i + 7] = (byte) (j >>> 56);
    }

    /* renamed from: a */
    public int m6756a(long j, boolean z) throws MiyaException {
        long j2 = !z ? (j << 1) ^ (j >> 63) : j;
        long j3 = j2 >>> 7;
        if (j3 == 0) {
            if (this.f5956c == this.f5957d) {
                m6759a(1);
            }
            byte[] bArr = this.f5958e;
            int i = this.f5956c;
            this.f5956c = i + 1;
            bArr[i] = (byte) j2;
            return 1;
        }
        long j4 = j2 >>> 14;
        if (j4 == 0) {
            m6759a(2);
            int i2 = this.f5956c;
            this.f5956c = i2 + 2;
            byte[] bArr2 = this.f5958e;
            bArr2[i2] = (byte) ((j2 & 127) | 128);
            bArr2[i2 + 1] = (byte) j3;
            return 2;
        }
        long j5 = j2 >>> 21;
        if (j5 == 0) {
            m6759a(3);
            int i3 = this.f5956c;
            this.f5956c = i3 + 3;
            byte[] bArr3 = this.f5958e;
            bArr3[i3] = (byte) ((j2 & 127) | 128);
            bArr3[i3 + 1] = (byte) (j3 | 128);
            bArr3[i3 + 2] = (byte) j4;
            return 3;
        }
        long j6 = j2 >>> 28;
        if (j6 == 0) {
            m6759a(4);
            int i4 = this.f5956c;
            this.f5956c = i4 + 4;
            byte[] bArr4 = this.f5958e;
            bArr4[i4] = (byte) ((j2 & 127) | 128);
            bArr4[i4 + 1] = (byte) (j3 | 128);
            bArr4[i4 + 2] = (byte) (j4 | 128);
            bArr4[i4 + 3] = (byte) j5;
            return 4;
        }
        long j7 = j2 >>> 35;
        if (j7 == 0) {
            m6759a(5);
            int i5 = this.f5956c;
            this.f5956c = i5 + 5;
            byte[] bArr5 = this.f5958e;
            bArr5[i5] = (byte) ((j2 & 127) | 128);
            bArr5[i5 + 1] = (byte) (j3 | 128);
            bArr5[i5 + 2] = (byte) (j4 | 128);
            bArr5[i5 + 3] = (byte) (j5 | 128);
            bArr5[i5 + 4] = (byte) j6;
            return 5;
        }
        long j8 = j2 >>> 42;
        if (j8 == 0) {
            m6759a(6);
            int i6 = this.f5956c;
            this.f5956c = i6 + 6;
            byte[] bArr6 = this.f5958e;
            bArr6[i6] = (byte) ((j2 & 127) | 128);
            bArr6[i6 + 1] = (byte) (j3 | 128);
            bArr6[i6 + 2] = (byte) (j4 | 128);
            bArr6[i6 + 3] = (byte) (j5 | 128);
            bArr6[i6 + 4] = (byte) (j6 | 128);
            bArr6[i6 + 5] = (byte) j7;
            return 6;
        }
        long j9 = j2 >>> 49;
        if (j9 == 0) {
            m6759a(7);
            int i7 = this.f5956c;
            this.f5956c = i7 + 7;
            byte[] bArr7 = this.f5958e;
            bArr7[i7] = (byte) ((j2 & 127) | 128);
            bArr7[i7 + 1] = (byte) (j3 | 128);
            bArr7[i7 + 2] = (byte) (j4 | 128);
            bArr7[i7 + 3] = (byte) (j5 | 128);
            bArr7[i7 + 4] = (byte) (j6 | 128);
            bArr7[i7 + 5] = (byte) (j7 | 128);
            bArr7[i7 + 6] = (byte) j8;
            return 7;
        }
        long j10 = j2 >>> 56;
        if (j10 == 0) {
            m6759a(8);
            int i8 = this.f5956c;
            this.f5956c = i8 + 8;
            byte[] bArr8 = this.f5958e;
            bArr8[i8] = (byte) ((j2 & 127) | 128);
            bArr8[i8 + 1] = (byte) (j3 | 128);
            bArr8[i8 + 2] = (byte) (j4 | 128);
            bArr8[i8 + 3] = (byte) (j5 | 128);
            bArr8[i8 + 4] = (byte) (j6 | 128);
            bArr8[i8 + 5] = (byte) (j7 | 128);
            bArr8[i8 + 6] = (byte) (j8 | 128);
            bArr8[i8 + 7] = (byte) j9;
            return 8;
        }
        m6759a(9);
        int i9 = this.f5956c;
        this.f5956c = i9 + 9;
        byte[] bArr9 = this.f5958e;
        bArr9[i9] = (byte) ((j2 & 127) | 128);
        bArr9[i9 + 1] = (byte) (j3 | 128);
        bArr9[i9 + 2] = (byte) (j4 | 128);
        bArr9[i9 + 3] = (byte) (j5 | 128);
        bArr9[i9 + 4] = (byte) (j6 | 128);
        bArr9[i9 + 5] = (byte) (j7 | 128);
        bArr9[i9 + 6] = (byte) (j8 | 128);
        bArr9[i9 + 7] = (byte) (j9 | 128);
        bArr9[i9 + 8] = (byte) j10;
        return 9;
    }

    /* renamed from: a */
    public void m6760a(float f) throws MiyaException {
        m6759a(4);
        byte[] bArr = this.f5958e;
        int i = this.f5956c;
        this.f5956c = i + 4;
        int floatToIntBits = Float.floatToIntBits(f);
        bArr[i] = (byte) floatToIntBits;
        bArr[i + 1] = (byte) (floatToIntBits >> 8);
        bArr[i + 2] = (byte) (floatToIntBits >> 16);
        bArr[i + 3] = (byte) (floatToIntBits >> 24);
    }

    /* renamed from: a */
    public void m6761a(double d) throws MiyaException {
        m6759a(8);
        byte[] bArr = this.f5958e;
        int i = this.f5956c;
        this.f5956c = i + 8;
        long doubleToLongBits = Double.doubleToLongBits(d);
        bArr[i] = (byte) doubleToLongBits;
        bArr[i + 1] = (byte) (doubleToLongBits >>> 8);
        bArr[i + 2] = (byte) (doubleToLongBits >>> 16);
        bArr[i + 3] = (byte) (doubleToLongBits >>> 24);
        bArr[i + 4] = (byte) (doubleToLongBits >>> 32);
        bArr[i + 5] = (byte) (doubleToLongBits >>> 40);
        bArr[i + 6] = (byte) (doubleToLongBits >>> 48);
        bArr[i + 7] = (byte) (doubleToLongBits >>> 56);
    }

    /* renamed from: d */
    public void m6745d(int i) throws MiyaException {
        m6759a(2);
        int i2 = this.f5956c;
        this.f5956c = i2 + 2;
        byte[] bArr = this.f5958e;
        bArr[i2] = (byte) i;
        bArr[i2 + 1] = (byte) (i >>> 8);
    }

    /* renamed from: a */
    public void m6762a(char c) throws MiyaException {
        m6759a(2);
        int i = this.f5956c;
        this.f5956c = i + 2;
        byte[] bArr = this.f5958e;
        bArr[i] = (byte) c;
        bArr[i + 1] = (byte) (c >>> '\b');
    }

    /* renamed from: a */
    public void m6752a(boolean z) throws MiyaException {
        if (this.f5956c == this.f5957d) {
            m6759a(1);
        }
        byte[] bArr = this.f5958e;
        int i = this.f5956c;
        this.f5956c = i + 1;
        bArr[i] = z ? (byte) 1 : (byte) 0;
    }

    /* renamed from: a */
    public void m6755a(String str) throws MiyaException {
        if (str == null) {
            m6748b(128);
            return;
        }
        int length = str.length();
        if (length == 0) {
            m6748b(129);
            return;
        }
        int i = 0;
        if (length > 1 && length <= 32) {
            for (int i2 = 0; i2 < length; i2++) {
                if (str.charAt(i2) <= 127) {
                }
            }
            int i3 = this.f5957d;
            int i4 = this.f5956c;
            if (i3 - i4 < length) {
                m6754a(str, length);
            } else {
                str.getBytes(0, length, this.f5958e, i4);
                this.f5956c += length;
            }
            byte[] bArr = this.f5958e;
            int i5 = this.f5956c - 1;
            bArr[i5] = (byte) (128 | bArr[i5]);
            return;
        }
        m6751a(true, length + 1, true);
        int i6 = this.f5957d;
        int i7 = this.f5956c;
        if (i6 - i7 >= length) {
            byte[] bArr2 = this.f5958e;
            while (true) {
                char charAt = str.charAt(i);
                if (charAt <= 127) {
                    int i8 = i7 + 1;
                    bArr2[i7] = (byte) charAt;
                    i++;
                    if (i == length) {
                        this.f5956c = i8;
                        return;
                    }
                    i7 = i8;
                } else {
                    this.f5956c = i7;
                    break;
                }
            }
        }
        if (i < length) {
            m6753a(str, length, i);
        }
    }

    /* renamed from: b */
    public void m6747b(String str) throws MiyaException {
        if (str == null) {
            m6748b(128);
            return;
        }
        int length = str.length();
        switch (length) {
            case 0:
                m6748b(129);
                return;
            case 1:
                m6759a(2);
                byte[] bArr = this.f5958e;
                int i = this.f5956c;
                this.f5956c = i + 1;
                bArr[i] = -126;
                int i2 = this.f5956c;
                this.f5956c = i2 + 1;
                bArr[i2] = (byte) str.charAt(0);
                return;
            default:
                int i3 = this.f5957d;
                int i4 = this.f5956c;
                if (i3 - i4 < length) {
                    m6754a(str, length);
                } else {
                    str.getBytes(0, length, this.f5958e, i4);
                    this.f5956c += length;
                }
                byte[] bArr2 = this.f5958e;
                int i5 = this.f5956c - 1;
                bArr2[i5] = (byte) (128 | bArr2[i5]);
                return;
        }
    }

    /* renamed from: a */
    private void m6753a(String str, int i, int i2) {
        while (i2 < i) {
            int i3 = this.f5956c;
            int i4 = this.f5957d;
            if (i3 == i4) {
                m6759a(Math.min(i4, i - i2));
            }
            char charAt = str.charAt(i2);
            if (charAt <= 127) {
                byte[] bArr = this.f5958e;
                int i5 = this.f5956c;
                this.f5956c = i5 + 1;
                bArr[i5] = (byte) charAt;
            } else if (charAt > 2047) {
                byte[] bArr2 = this.f5958e;
                int i6 = this.f5956c;
                this.f5956c = i6 + 1;
                bArr2[i6] = (byte) (((charAt >> '\f') & 15) | 224);
                m6759a(2);
                byte[] bArr3 = this.f5958e;
                int i7 = this.f5956c;
                this.f5956c = i7 + 1;
                bArr3[i7] = (byte) (((charAt >> 6) & 63) | 128);
                int i8 = this.f5956c;
                this.f5956c = i8 + 1;
                bArr3[i8] = (byte) ((charAt & '?') | 128);
            } else {
                byte[] bArr4 = this.f5958e;
                int i9 = this.f5956c;
                this.f5956c = i9 + 1;
                bArr4[i9] = (byte) (((charAt >> 6) & 31) | 192);
                if (this.f5956c == this.f5957d) {
                    m6759a(1);
                }
                byte[] bArr5 = this.f5958e;
                int i10 = this.f5956c;
                this.f5956c = i10 + 1;
                bArr5[i10] = (byte) ((charAt & '?') | 128);
            }
            i2++;
        }
    }

    /* renamed from: a */
    private void m6754a(String str, int i) throws MiyaException {
        if (i == 0) {
            return;
        }
        if (this.f5956c == this.f5957d) {
            m6759a(1);
        }
        int i2 = 0;
        byte[] bArr = this.f5958e;
        int min = Math.min(i, this.f5957d - this.f5956c);
        while (i2 < i) {
            int i3 = i2 + min;
            str.getBytes(i2, i3, bArr, this.f5956c);
            this.f5956c += min;
            min = Math.min(i - i3, this.f5957d);
            if (m6759a(min)) {
                bArr = this.f5958e;
            }
            i2 = i3;
        }
    }
}
