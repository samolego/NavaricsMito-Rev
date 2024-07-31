package com.navatics.miya.io;

import com.common.AUTOMATIVE_LIGHT;
import com.navatics.miya.MiyaException;
import java.io.IOException;
import java.io.InputStream;

/* compiled from: Input.java */
/* renamed from: com.navatics.miya.a.a */
/* loaded from: classes.dex */
public class Input extends InputStream implements AutoCloseable {

    /* renamed from: a */
    protected byte[] f5971a;

    /* renamed from: b */
    protected int f5972b;

    /* renamed from: c */
    protected int f5973c;

    /* renamed from: d */
    protected int f5974d;

    /* renamed from: e */
    protected long f5975e;

    /* renamed from: f */
    protected char[] f5976f;

    /* renamed from: g */
    protected InputStream f5977g;

    /* renamed from: h */
    protected boolean f5978h;

    public Input() {
        this.f5976f = new char[32];
        this.f5978h = true;
    }

    public Input(int i) {
        this.f5976f = new char[32];
        this.f5978h = true;
        this.f5973c = i;
        this.f5971a = new byte[i];
    }

    public Input(InputStream inputStream) {
        this(4096);
        if (inputStream == null) {
            throw new IllegalArgumentException("inputStream cannot be null.");
        }
        this.f5977g = inputStream;
    }

    @Override // java.io.InputStream
    public void reset() {
        this.f5972b = 0;
        this.f5975e = 0L;
    }

    /* renamed from: a */
    public void m6097a(int i) throws MiyaException {
        int min = Math.min(this.f5974d - this.f5972b, i);
        while (true) {
            this.f5972b += min;
            i -= min;
            if (i == 0) {
                return;
            }
            min = Math.min(i, this.f5973c);
            m6099b(min);
        }
    }

    /* renamed from: a */
    protected int m6096a(byte[] bArr, int i, int i2) throws MiyaException {
        InputStream inputStream = this.f5977g;
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
    protected int m6099b(int i) throws MiyaException {
        int i2 = this.f5974d;
        int i3 = i2 - this.f5972b;
        if (i3 >= i) {
            return i3;
        }
        int i4 = this.f5973c;
        if (i > i4) {
            throw new MiyaException("Buffer too small: capacity: " + this.f5973c + ", required: " + i);
        }
        if (i3 > 0) {
            int m6096a = m6096a(this.f5971a, i2, i4 - i2);
            if (m6096a == -1) {
                throw new MiyaException("Buffer underflow.");
            }
            i3 += m6096a;
            if (i3 >= i) {
                this.f5974d += m6096a;
                return i3;
            }
        }
        byte[] bArr = this.f5971a;
        System.arraycopy(bArr, this.f5972b, bArr, 0, i3);
        this.f5975e += this.f5972b;
        this.f5972b = 0;
        while (true) {
            int m6096a2 = m6096a(this.f5971a, i3, this.f5973c - i3);
            if (m6096a2 != -1) {
                i3 += m6096a2;
                if (i3 >= i) {
                    break;
                }
            } else if (i3 < i) {
                throw new MiyaException("Buffer underflow.");
            }
        }
        this.f5974d = i3;
        return i3;
    }

    /* renamed from: c */
    protected int m6100c(int i) throws MiyaException {
        int i2 = this.f5974d - this.f5972b;
        if (i2 >= i) {
            return i;
        }
        int min = Math.min(i, this.f5973c);
        byte[] bArr = this.f5971a;
        int i3 = this.f5974d;
        int m6096a = m6096a(bArr, i3, this.f5973c - i3);
        if (m6096a == -1) {
            if (i2 == 0) {
                return -1;
            }
            return Math.min(i2, min);
        }
        int i4 = i2 + m6096a;
        if (i4 >= min) {
            this.f5974d += m6096a;
            return min;
        }
        byte[] bArr2 = this.f5971a;
        System.arraycopy(bArr2, this.f5972b, bArr2, 0, i4);
        this.f5975e += this.f5972b;
        this.f5972b = 0;
        do {
            int m6096a2 = m6096a(this.f5971a, i4, this.f5973c - i4);
            if (m6096a2 == -1) {
                break;
            }
            i4 += m6096a2;
        } while (i4 < min);
        this.f5974d = i4;
        if (i4 == 0) {
            return -1;
        }
        return Math.min(i4, min);
    }

    @Override // java.io.InputStream
    public int available() throws IOException {
        int i = this.f5974d - this.f5972b;
        InputStream inputStream = this.f5977g;
        return i + (inputStream != null ? inputStream.available() : 0);
    }

    @Override // java.io.InputStream
    public int read() throws MiyaException {
        if (m6100c(1) <= 0) {
            return -1;
        }
        byte[] bArr = this.f5971a;
        int i = this.f5972b;
        this.f5972b = i + 1;
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
        int min = Math.min(this.f5974d - this.f5972b, i2);
        int i3 = i2;
        while (true) {
            System.arraycopy(this.f5971a, this.f5972b, bArr, i, min);
            this.f5972b += min;
            i3 -= min;
            if (i3 == 0) {
                break;
            }
            i += min;
            min = m6100c(i3);
            if (min == -1) {
                if (i2 == i3) {
                    return -1;
                }
            } else if (this.f5972b == this.f5974d) {
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
            m6097a(min);
            j2 -= min;
        }
        return j;
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws MiyaException {
        InputStream inputStream = this.f5977g;
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (IOException unused) {
            }
        }
    }

    /* renamed from: a */
    public byte m6094a() throws MiyaException {
        if (this.f5972b == this.f5974d) {
            m6099b(1);
        }
        byte[] bArr = this.f5971a;
        int i = this.f5972b;
        this.f5972b = i + 1;
        return bArr[i];
    }

    /* renamed from: b */
    public int m6098b() throws MiyaException {
        if (this.f5972b == this.f5974d) {
            m6099b(1);
        }
        byte[] bArr = this.f5971a;
        int i = this.f5972b;
        this.f5972b = i + 1;
        return bArr[i] & 255;
    }

    /* renamed from: c */
    public boolean m6101c() {
        if (this.f5972b == this.f5974d) {
            m6099b(1);
        }
        return (this.f5971a[this.f5972b] & AUTOMATIVE_LIGHT.OVERTURN) != 0;
    }

    /* renamed from: a */
    public int m6095a(boolean z) {
        int i;
        if (m6099b(1) < 5) {
            return m6090b(z);
        }
        byte[] bArr = this.f5971a;
        int i2 = this.f5972b;
        this.f5972b = i2 + 1;
        byte b = bArr[i2];
        int i3 = b & 63;
        if ((b & AUTOMATIVE_LIGHT.TRUN_ON) != 0) {
            int i4 = this.f5972b;
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
            this.f5972b = i;
        }
        return z ? i3 : (i3 >>> 1) ^ (-(i3 & 1));
    }

    /* renamed from: b */
    private int m6090b(boolean z) {
        byte[] bArr = this.f5971a;
        int i = this.f5972b;
        this.f5972b = i + 1;
        byte b = bArr[i];
        int i2 = b & 63;
        if ((b & AUTOMATIVE_LIGHT.TRUN_ON) != 0) {
            if (this.f5972b == this.f5974d) {
                m6099b(1);
            }
            byte[] bArr2 = this.f5971a;
            int i3 = this.f5972b;
            this.f5972b = i3 + 1;
            byte b2 = bArr2[i3];
            i2 |= (b2 & Byte.MAX_VALUE) << 6;
            if ((b2 & AUTOMATIVE_LIGHT.OVERTURN) != 0) {
                if (this.f5972b == this.f5974d) {
                    m6099b(1);
                }
                int i4 = this.f5972b;
                this.f5972b = i4 + 1;
                byte b3 = bArr2[i4];
                i2 |= (b3 & Byte.MAX_VALUE) << 13;
                if ((b3 & AUTOMATIVE_LIGHT.OVERTURN) != 0) {
                    if (this.f5972b == this.f5974d) {
                        m6099b(1);
                    }
                    int i5 = this.f5972b;
                    this.f5972b = i5 + 1;
                    byte b4 = bArr2[i5];
                    i2 |= (b4 & Byte.MAX_VALUE) << 20;
                    if ((b4 & AUTOMATIVE_LIGHT.OVERTURN) != 0) {
                        if (this.f5972b == this.f5974d) {
                            m6099b(1);
                        }
                        int i6 = this.f5972b;
                        this.f5972b = i6 + 1;
                        i2 |= (bArr2[i6] & Byte.MAX_VALUE) << 27;
                    }
                }
            }
        }
        return z ? i2 : (i2 >>> 1) ^ (-(i2 & 1));
    }

    /* renamed from: d */
    public int m6102d() throws MiyaException {
        m6099b(2);
        int i = this.f5972b;
        this.f5972b = i + 2;
        byte[] bArr = this.f5971a;
        return ((bArr[i + 1] & 255) << 8) | (bArr[i] & 255);
    }

    /* renamed from: e */
    public String m6103e() {
        if (!m6101c()) {
            return m6093f();
        }
        int m6095a = m6095a(true);
        switch (m6095a) {
            case 0:
                return null;
            case 1:
                return "";
            default:
                int i = m6095a - 1;
                m6091d(i);
                return new String(this.f5976f, 0, i);
        }
    }

    /* renamed from: d */
    private void m6091d(int i) {
        if (this.f5976f.length < i) {
            this.f5976f = new char[i];
        }
        byte[] bArr = this.f5971a;
        char[] cArr = this.f5976f;
        int i2 = 0;
        int min = Math.min(m6099b(1), i);
        int i3 = this.f5972b;
        while (true) {
            if (i2 >= min) {
                break;
            }
            int i4 = i3 + 1;
            byte b = bArr[i3];
            if (b < 0) {
                i3 = i4 - 1;
                break;
            } else {
                cArr[i2] = (char) b;
                i3 = i4;
                i2++;
            }
        }
        this.f5972b = i3;
        if (i2 < i) {
            m6089a(i, i2);
        }
    }

    /* renamed from: a */
    private void m6089a(int i, int i2) {
        char[] cArr = this.f5976f;
        byte[] bArr = this.f5971a;
        while (i2 < i) {
            if (this.f5972b == this.f5974d) {
                m6099b(1);
            }
            int i3 = this.f5972b;
            this.f5972b = i3 + 1;
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
                            if (this.f5972b == this.f5974d) {
                                m6099b(1);
                            }
                            int i6 = this.f5972b;
                            this.f5972b = i6 + 1;
                            cArr[i2] = (char) (((i4 & 31) << 6) | (bArr[i6] & 63));
                            break;
                        case 14:
                            m6099b(2);
                            int i7 = this.f5972b;
                            this.f5972b = i7 + 2;
                            cArr[i2] = (char) (((i4 & 15) << 12) | ((bArr[i7] & 63) << 6) | (bArr[i7 + 1] & 63));
                            break;
                    }
            }
            i2++;
        }
    }

    /* renamed from: f */
    private String m6093f() {
        char[] cArr = this.f5976f;
        byte[] bArr = this.f5971a;
        int i = this.f5972b;
        int min = Math.min(cArr.length, this.f5974d - i);
        int i2 = i;
        int i3 = 0;
        while (i3 < min) {
            byte b = bArr[i2];
            if ((b & AUTOMATIVE_LIGHT.OVERTURN) == 128) {
                this.f5972b = i2 + 1;
                cArr[i3] = (char) (b & Byte.MAX_VALUE);
                return new String(cArr, 0, i3 + 1);
            }
            cArr[i3] = (char) b;
            i3++;
            i2++;
        }
        this.f5972b = i2;
        return m6092e(i3);
    }

    /* renamed from: e */
    private String m6092e(int i) {
        char[] cArr = this.f5976f;
        byte[] bArr = this.f5971a;
        while (true) {
            if (this.f5972b == this.f5974d) {
                m6099b(1);
            }
            int i2 = this.f5972b;
            this.f5972b = i2 + 1;
            byte b = bArr[i2];
            if (i == cArr.length) {
                char[] cArr2 = new char[i * 2];
                System.arraycopy(cArr, 0, cArr2, 0, i);
                this.f5976f = cArr2;
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