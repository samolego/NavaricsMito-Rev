package com.bumptech.glide.load.resource.bitmap;

import android.support.annotation.NonNull;
import android.support.annotation.VisibleForTesting;
import com.bumptech.glide.load.engine.p022a.ArrayPool;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: classes.dex */
public class RecyclableBufferedInputStream extends FilterInputStream {

    /* renamed from: a */
    private volatile byte[] f1021a;

    /* renamed from: b */
    private int f1022b;

    /* renamed from: c */
    private int f1023c;

    /* renamed from: d */
    private int f1024d;

    /* renamed from: e */
    private int f1025e;

    /* renamed from: f */
    private final ArrayPool f1026f;

    @Override // java.io.FilterInputStream, java.io.InputStream
    public boolean markSupported() {
        return true;
    }

    public RecyclableBufferedInputStream(@NonNull InputStream inputStream, @NonNull ArrayPool arrayPool) {
        this(inputStream, arrayPool, 65536);
    }

    @VisibleForTesting
    RecyclableBufferedInputStream(@NonNull InputStream inputStream, @NonNull ArrayPool arrayPool, int i) {
        super(inputStream);
        this.f1024d = -1;
        this.f1026f = arrayPool;
        this.f1021a = (byte[]) arrayPool.mo12200a(i, byte[].class);
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized int available() throws IOException {
        InputStream inputStream;
        inputStream = this.in;
        if (this.f1021a == null || inputStream == null) {
            throw m11984c();
        }
        return (this.f1022b - this.f1025e) + inputStream.available();
    }

    /* renamed from: c */
    private static IOException m11984c() throws IOException {
        throw new IOException("BufferedInputStream is closed");
    }

    /* renamed from: a */
    public synchronized void m11987a() {
        this.f1023c = this.f1021a.length;
    }

    /* renamed from: b */
    public synchronized void m11985b() {
        if (this.f1021a != null) {
            this.f1026f.mo12195a((ArrayPool) this.f1021a);
            this.f1021a = null;
        }
    }

    @Override // java.io.FilterInputStream, java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (this.f1021a != null) {
            this.f1026f.mo12195a((ArrayPool) this.f1021a);
            this.f1021a = null;
        }
        InputStream inputStream = this.in;
        this.in = null;
        if (inputStream != null) {
            inputStream.close();
        }
    }

    /* renamed from: a */
    private int m11986a(InputStream inputStream, byte[] bArr) throws IOException {
        int i = this.f1024d;
        if (i != -1) {
            int i2 = this.f1025e - i;
            int i3 = this.f1023c;
            if (i2 < i3) {
                if (i == 0 && i3 > bArr.length && this.f1022b == bArr.length) {
                    int length = bArr.length * 2;
                    if (length > i3) {
                        length = i3;
                    }
                    byte[] bArr2 = (byte[]) this.f1026f.mo12200a(length, byte[].class);
                    System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
                    this.f1021a = bArr2;
                    this.f1026f.mo12195a((ArrayPool) bArr);
                    bArr = bArr2;
                } else {
                    int i4 = this.f1024d;
                    if (i4 > 0) {
                        System.arraycopy(bArr, i4, bArr, 0, bArr.length - i4);
                    }
                }
                this.f1025e -= this.f1024d;
                this.f1024d = 0;
                this.f1022b = 0;
                int i5 = this.f1025e;
                int read = inputStream.read(bArr, i5, bArr.length - i5);
                this.f1022b = read <= 0 ? this.f1025e : this.f1025e + read;
                return read;
            }
        }
        int read2 = inputStream.read(bArr);
        if (read2 > 0) {
            this.f1024d = -1;
            this.f1025e = 0;
            this.f1022b = read2;
        }
        return read2;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized void mark(int i) {
        this.f1023c = Math.max(this.f1023c, i);
        this.f1024d = this.f1025e;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized int read() throws IOException {
        byte[] bArr = this.f1021a;
        InputStream inputStream = this.in;
        if (bArr == null || inputStream == null) {
            throw m11984c();
        }
        if (this.f1025e < this.f1022b || m11986a(inputStream, bArr) != -1) {
            if (bArr != this.f1021a && (bArr = this.f1021a) == null) {
                throw m11984c();
            }
            if (this.f1022b - this.f1025e > 0) {
                int i = this.f1025e;
                this.f1025e = i + 1;
                return bArr[i] & 255;
            }
            return -1;
        }
        return -1;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized int read(@NonNull byte[] bArr, int i, int i2) throws IOException {
        int i3;
        int i4;
        byte[] bArr2 = this.f1021a;
        if (bArr2 == null) {
            throw m11984c();
        }
        if (i2 == 0) {
            return 0;
        }
        InputStream inputStream = this.in;
        if (inputStream == null) {
            throw m11984c();
        }
        if (this.f1025e < this.f1022b) {
            int i5 = this.f1022b - this.f1025e >= i2 ? i2 : this.f1022b - this.f1025e;
            System.arraycopy(bArr2, this.f1025e, bArr, i, i5);
            this.f1025e += i5;
            if (i5 == i2 || inputStream.available() == 0) {
                return i5;
            }
            i += i5;
            i3 = i2 - i5;
        } else {
            i3 = i2;
        }
        while (true) {
            if (this.f1024d == -1 && i3 >= bArr2.length) {
                i4 = inputStream.read(bArr, i, i3);
                if (i4 == -1) {
                    return i3 != i2 ? i2 - i3 : -1;
                }
            } else if (m11986a(inputStream, bArr2) == -1) {
                return i3 != i2 ? i2 - i3 : -1;
            } else {
                if (bArr2 != this.f1021a && (bArr2 = this.f1021a) == null) {
                    throw m11984c();
                }
                i4 = this.f1022b - this.f1025e >= i3 ? i3 : this.f1022b - this.f1025e;
                System.arraycopy(bArr2, this.f1025e, bArr, i, i4);
                this.f1025e += i4;
            }
            i3 -= i4;
            if (i3 == 0) {
                return i2;
            }
            if (inputStream.available() == 0) {
                return i2 - i3;
            }
            i += i4;
        }
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized void reset() throws IOException {
        if (this.f1021a == null) {
            throw new IOException("Stream is closed");
        }
        if (-1 == this.f1024d) {
            throw new InvalidMarkException("Mark has been invalidated, pos: " + this.f1025e + " markLimit: " + this.f1023c);
        }
        this.f1025e = this.f1024d;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized long skip(long j) throws IOException {
        if (j < 1) {
            return 0L;
        }
        byte[] bArr = this.f1021a;
        if (bArr == null) {
            throw m11984c();
        }
        InputStream inputStream = this.in;
        if (inputStream == null) {
            throw m11984c();
        }
        if (this.f1022b - this.f1025e >= j) {
            this.f1025e = (int) (this.f1025e + j);
            return j;
        }
        long j2 = this.f1022b - this.f1025e;
        this.f1025e = this.f1022b;
        if (this.f1024d != -1 && j <= this.f1023c) {
            if (m11986a(inputStream, bArr) == -1) {
                return j2;
            }
            if (this.f1022b - this.f1025e >= j - j2) {
                this.f1025e = (int) ((this.f1025e + j) - j2);
                return j;
            }
            long j3 = (j2 + this.f1022b) - this.f1025e;
            this.f1025e = this.f1022b;
            return j3;
        }
        return j2 + inputStream.skip(j - j2);
    }

    /* loaded from: classes.dex */
    static class InvalidMarkException extends IOException {
        private static final long serialVersionUID = -4338378848813561757L;

        InvalidMarkException(String str) {
            super(str);
        }
    }
}
