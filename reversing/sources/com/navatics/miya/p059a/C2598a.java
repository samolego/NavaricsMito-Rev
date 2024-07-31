package com.navatics.miya.p059a;

import com.common.AUTOMATIVE_LIGHT;
import com.navatics.miya.MiyaException;
import java.io.IOException;
import java.io.InputStream;

/* renamed from: com.navatics.miya.a.a */
/* loaded from: classes.dex */
public class Input extends InputStream implements AutoCloseable {

    /* renamed from: a */
    protected byte[] f5946a;

    /* renamed from: b */
    protected int f5947b;

    /* renamed from: c */
    protected int f5948c;

    /* renamed from: d */
    protected int f5949d;

    /* renamed from: e */
    protected long f5950e;

    /* renamed from: f */
    protected char[] f5951f;

    /* renamed from: g */
    protected InputStream f5952g;

    /* renamed from: h */
    protected boolean f5953h;

    public Input() {
        this.f5951f = new char[32];
        this.f5953h = true;
    }

    public Input(int i) {
        this.f5951f = new char[32];
        this.f5953h = true;
        this.f5948c = i;
        this.f5946a = new byte[i];
    }

    public Input(InputStream inputStream) {
        this(4096);
        if (inputStream == null) {
            throw new IllegalArgumentException("inputStream cannot be null.");
        }
        this.f5952g = inputStream;
    }

    @Override // java.io.InputStream
    public void reset() {
        this.f5947b = 0;
        this.f5950e = 0L;
    }

    /* renamed from: a */
    public void m6778a(int i) throws MiyaException {
        int min = Math.min(this.f5949d - this.f5947b, i);
        while (true) {
            this.f5947b += min;
            i -= min;
            if (i == 0) {
                return;
            }
            min = Math.min(i, this.f5948c);
            m6773b(min);
        }
    }

    /* renamed from: a */
    protected int m6775a(byte[] bArr, int i, int i2) throws MiyaException {
        InputStream inputStream = this.f5952g;
        if (inputStream == null) {
            return -1;
        }
        try {
            return inputStream.read(bArr, i, i2);
        } catch (IOException e) {
            throw new MiyaException(e);
        }
    }

    /* renamed from: b */
    protected int m6773b(int i) throws MiyaException {
        int i2 = this.f5949d;
        int i3 = i2 - this.f5947b;
        if (i3 >= i) {
            return i3;
        }
        int i4 = this.f5948c;
        if (i > i4) {
            throw new MiyaException("Buffer too small: capacity: " + this.f5948c + ", required: " + i);
        }
        if (i3 > 0) {
            int m6775a = m6775a(this.f5946a, i2, i4 - i2);
            if (m6775a == -1) {
                throw new MiyaException("Buffer underflow.");
            }
            i3 += m6775a;
            if (i3 >= i) {
                this.f5949d += m6775a;
                return i3;
            }
        }
        byte[] bArr = this.f5946a;
        System.arraycopy(bArr, this.f5947b, bArr, 0, i3);
        this.f5950e += this.f5947b;
        this.f5947b = 0;
        while (true) {
            int m6775a2 = m6775a(this.f5946a, i3, this.f5948c - i3);
            if (m6775a2 != -1) {
                i3 += m6775a2;
                if (i3 >= i) {
                    break;
                }
            } else if (i3 >= i) {
                break;
            } else {
                throw new MiyaException("Buffer underflow.");
            }
        }
        this.f5949d = i3;
        return i3;
    }

    /* renamed from: c */
    protected int m6770c(int i) throws MiyaException {
        int i2 = this.f5949d - this.f5947b;
        if (i2 >= i) {
            return i;
        }
        int min = Math.min(i, this.f5948c);
        byte[] bArr = this.f5946a;
        int i3 = this.f5949d;
        int m6775a = m6775a(bArr, i3, this.f5948c - i3);
        if (m6775a == -1) {
            if (i2 == 0) {
                return -1;
            }
            return Math.min(i2, min);
        }
        int i4 = i2 + m6775a;
        if (i4 >= min) {
            this.f5949d += m6775a;
            return min;
        }
        byte[] bArr2 = this.f5946a;
        System.arraycopy(bArr2, this.f5947b, bArr2, 0, i4);
        this.f5950e += this.f5947b;
        this.f5947b = 0;
        do {
            int m6775a2 = m6775a(this.f5946a, i4, this.f5948c - i4);
            if (m6775a2 == -1) {
                break;
            }
            i4 += m6775a2;
        } while (i4 < min);
        this.f5949d = i4;
        if (i4 == 0) {
            return -1;
        }
        return Math.min(i4, min);
    }

    @Override // java.io.InputStream
    public int available() throws IOException {
        int i = this.f5949d - this.f5947b;
        InputStream inputStream = this.f5952g;
        return i + (inputStream != null ? inputStream.available() : 0);
    }

    @Override // java.io.InputStream
    public int read() throws MiyaException {
        if (m6770c(1) <= 0) {
            return -1;
        }
        byte[] bArr = this.f5946a;
        int i = this.f5947b;
        this.f5947b = i + 1;
        return bArr[i] & 255;
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr) throws MiyaException {
        return read(bArr, 0, bArr.length);
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i, int i2) throws MiyaException {
        if (bArr == null) {
            throw new IllegalArgumentException("bytes cannot be null.");
        }
        int min = Math.min(this.f5949d - this.f5947b, i2);
        int i3 = i2;
        while (true) {
            System.arraycopy(this.f5946a, this.f5947b, bArr, i, min);
            this.f5947b += min;
            i3 -= min;
            if (i3 != 0) {
                i += min;
                min = m6770c(i3);
                if (min != -1) {
                    if (this.f5947b == this.f5949d) {
                        break;
                    }
                } else if (i2 == i3) {
                    return -1;
                }
            } else {
                break;
            }
        }
        return i2 - i3;
    }

    @Override // java.io.InputStream
    public long skip(long j) throws MiyaException {
        long j2 = j;
        while (j2 > 0) {
            int min = (int) Math.min(2147483639L, j2);
            m6778a(min);
            j2 -= min;
        }
        return j;
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws MiyaException {
        InputStream inputStream = this.f5952g;
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (IOException unused) {
            }
        }
    }

    /* renamed from: a */
    public byte m6779a() throws MiyaException {
        if (this.f5947b == this.f5949d) {
            m6773b(1);
        }
        byte[] bArr = this.f5946a;
        int i = this.f5947b;
        this.f5947b = i + 1;
        return bArr[i];
    }

    /* renamed from: b */
    public int m6774b() throws MiyaException {
        if (this.f5947b == this.f5949d) {
            m6773b(1);
        }
        byte[] bArr = this.f5946a;
        int i = this.f5947b;
        this.f5947b = i + 1;
        return bArr[i] & 255;
    }

    /* renamed from: c */
    public boolean m6771c() {
        if (this.f5947b == this.f5949d) {
            m6773b(1);
        }
        return (this.f5946a[this.f5947b] & AUTOMATIVE_LIGHT.OVERTURN) != 0;
    }

    /* renamed from: a */
    public int m6776a(boolean z) {
        int i;
        if (m6773b(1) < 5) {
            return m6772b(z);
        }
        byte[] bArr = this.f5946a;
        int i2 = this.f5947b;
        this.f5947b = i2 + 1;
        byte b = bArr[i2];
        int i3 = b & 63;
        if ((b & AUTOMATIVE_LIGHT.TRUN_ON) != 0) {
            int i4 = this.f5947b;
            int i5 = i4 + 1;
            byte b2 = bArr[i4];
            i3 |= (b2 & Byte.MAX_VALUE) << 6;
            if ((b2 & AUTOMATIVE_LIGHT.OVERTURN) != 0) {
                i = i5 + 1;
                byte b3 = bArr[i5];
                i3 |= (b3 & Byte.MAX_VALUE) << 13;
                if ((b3 & AUTOMATIVE_LIGHT.OVERTURN) != 0) {
                    int i6 = i + 1;
                    byte b4 = bArr[i];
                    i3 |= (b4 & Byte.MAX_VALUE) << 20;
                    if ((b4 & AUTOMATIVE_LIGHT.OVERTURN) != 0) {
                        i = i6 + 1;
                        i3 = ((bArr[i6] & Byte.MAX_VALUE) << 27) | i3;
                    } else {
                        i = i6;
                    }
                }
            } else {
                i = i5;
            }
            this.f5947b = i;
        }
        return z ? i3 : (i3 >>> 1) ^ (-(i3 & 1));
    }

    /* renamed from: b */
    private int m6772b(boolean z) {
        byte[] bArr = this.f5946a;
        int i = this.f5947b;
        this.f5947b = i + 1;
        byte b = bArr[i];
        int i2 = b & 63;
        if ((b & AUTOMATIVE_LIGHT.TRUN_ON) != 0) {
            if (this.f5947b == this.f5949d) {
                m6773b(1);
            }
            byte[] bArr2 = this.f5946a;
            int i3 = this.f5947b;
            this.f5947b = i3 + 1;
            byte b2 = bArr2[i3];
            i2 |= (b2 & Byte.MAX_VALUE) << 6;
            if ((b2 & AUTOMATIVE_LIGHT.OVERTURN) != 0) {
                if (this.f5947b == this.f5949d) {
                    m6773b(1);
                }
                int i4 = this.f5947b;
                this.f5947b = i4 + 1;
                byte b3 = bArr2[i4];
                i2 |= (b3 & Byte.MAX_VALUE) << 13;
                if ((b3 & AUTOMATIVE_LIGHT.OVERTURN) != 0) {
                    if (this.f5947b == this.f5949d) {
                        m6773b(1);
                    }
                    int i5 = this.f5947b;
                    this.f5947b = i5 + 1;
                    byte b4 = bArr2[i5];
                    i2 |= (b4 & Byte.MAX_VALUE) << 20;
                    if ((b4 & AUTOMATIVE_LIGHT.OVERTURN) != 0) {
                        if (this.f5947b == this.f5949d) {
                            m6773b(1);
                        }
                        int i6 = this.f5947b;
                        this.f5947b = i6 + 1;
                        i2 |= (bArr2[i6] & Byte.MAX_VALUE) << 27;
                    }
                }
            }
        }
        return z ? i2 : (i2 >>> 1) ^ (-(i2 & 1));
    }

    /* renamed from: d */
    public int m6769d() throws MiyaException {
        m6773b(2);
        int i = this.f5947b;
        this.f5947b = i + 2;
        byte[] bArr = this.f5946a;
        return ((bArr[i + 1] & 255) << 8) | (bArr[i] & 255);
    }

    /* renamed from: e */
    public String m6767e() {
        if (m6771c()) {
            int m6776a = m6776a(true);
            switch (m6776a) {
                case 0:
                    return null;
                case 1:
                    return "";
                default:
                    int i = m6776a - 1;
                    m6768d(i);
                    return new String(this.f5951f, 0, i);
            }
        }
        return m6765f();
    }

    /* renamed from: d */
    private void m6768d(int i) {
        if (this.f5951f.length < i) {
            this.f5951f = new char[i];
        }
        byte[] bArr = this.f5946a;
        char[] cArr = this.f5951f;
        int i2 = 0;
        int min = Math.min(m6773b(1), i);
        int i3 = this.f5947b;
        while (true) {
            if (i2 >= min) {
                break;
            }
            int i4 = i3 + 1;
            byte b = bArr[i3];
            if (b < 0) {
                i3 = i4 - 1;
                break;
            }
            cArr[i2] = (char) b;
            i3 = i4;
            i2++;
        }
        this.f5947b = i3;
        if (i2 < i) {
            m6777a(i, i2);
        }
    }

    /* renamed from: a */
    private void m6777a(int i, int i2) {
        char[] cArr = this.f5951f;
        byte[] bArr = this.f5946a;
        while (i2 < i) {
            if (this.f5947b == this.f5949d) {
                m6773b(1);
            }
            int i3 = this.f5947b;
            this.f5947b = i3 + 1;
            int i4 = bArr[i3] & 255;
            int i5 = i4 >> 4;
            switch (i5) {
                case 0:
                case 1:
                case 2:
                case 3:
                case 4:
                case 5:
                case 6:
                case 7:
                    cArr[i2] = (char) i4;
                    break;
                default:
                    switch (i5) {
                        case 12:
                        case 13:
                            if (this.f5947b == this.f5949d) {
                                m6773b(1);
                            }
                            int i6 = this.f5947b;
                            this.f5947b = i6 + 1;
                            cArr[i2] = (char) (((i4 & 31) << 6) | (bArr[i6] & 63));
                            continue;
                        case 14:
                            m6773b(2);
                            int i7 = this.f5947b;
                            this.f5947b = i7 + 2;
                            cArr[i2] = (char) (((i4 & 15) << 12) | ((bArr[i7] & 63) << 6) | (bArr[i7 + 1] & 63));
                            continue;
                    }
            }
            i2++;
        }
    }

    /* renamed from: f */
    private String m6765f() {
        char[] cArr = this.f5951f;
        byte[] bArr = this.f5946a;
        int i = this.f5947b;
        int min = Math.min(cArr.length, this.f5949d - i);
        int i2 = i;
        int i3 = 0;
        while (i3 < min) {
            byte b = bArr[i2];
            if ((b & AUTOMATIVE_LIGHT.OVERTURN) == 128) {
                this.f5947b = i2 + 1;
                cArr[i3] = (char) (b & Byte.MAX_VALUE);
                return new String(cArr, 0, i3 + 1);
            }
            cArr[i3] = (char) b;
            i3++;
            i2++;
        }
        this.f5947b = i2;
        return m6766e(i3);
    }

    /* renamed from: e */
    private String m6766e(int i) {
        char[] cArr = this.f5951f;
        byte[] bArr = this.f5946a;
        while (true) {
            if (this.f5947b == this.f5949d) {
                m6773b(1);
            }
            int i2 = this.f5947b;
            this.f5947b = i2 + 1;
            byte b = bArr[i2];
            if (i == cArr.length) {
                char[] cArr2 = new char[i * 2];
                System.arraycopy(cArr, 0, cArr2, 0, i);
                this.f5951f = cArr2;
                cArr = cArr2;
            }
            if ((b & AUTOMATIVE_LIGHT.OVERTURN) == 128) {
                cArr[i] = (char) (b & Byte.MAX_VALUE);
                return new String(cArr, 0, i + 1);
            }
            cArr[i] = (char) b;
            i++;
        }
    }
}
