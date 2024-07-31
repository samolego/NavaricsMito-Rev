package com.bumptech.glide.load.resource.bitmap;

import android.support.annotation.NonNull;
import android.support.annotation.VisibleForTesting;
import com.bumptech.glide.load.engine.p018a.InterfaceC0624b;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: classes.dex */
public class RecyclableBufferedInputStream extends FilterInputStream {

    /* renamed from: a */
    private volatile byte[] f1025a;

    /* renamed from: b */
    private int f1026b;

    /* renamed from: c */
    private int f1027c;

    /* renamed from: d */
    private int f1028d;

    /* renamed from: e */
    private int f1029e;

    /* renamed from: f */
    private final InterfaceC0624b f1030f;

    @Override // java.io.FilterInputStream, java.io.InputStream
    public boolean markSupported() {
        return true;
    }

    public RecyclableBufferedInputStream(@NonNull InputStream inputStream, @NonNull InterfaceC0624b interfaceC0624b) {
        this(inputStream, interfaceC0624b, 65536);
    }

    @VisibleForTesting
    RecyclableBufferedInputStream(@NonNull InputStream inputStream, @NonNull InterfaceC0624b interfaceC0624b, int i) {
        super(inputStream);
        this.f1028d = -1;
        this.f1030f = interfaceC0624b;
        this.f1025a = (byte[]) interfaceC0624b.mo756a(i, byte[].class);
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized int available() throws IOException {
        InputStream inputStream;
        inputStream = this.in;
        if (this.f1025a == null || inputStream == null) {
            throw m982c();
        }
        return (this.f1026b - this.f1029e) + inputStream.available();
    }

    /* renamed from: c */
    private static IOException m982c() throws IOException {
        throw new IOException("BufferedInputStream is closed");
    }

    /* renamed from: a */
    public synchronized void m983a() {
        this.f1027c = this.f1025a.length;
    }

    /* renamed from: b */
    public synchronized void m984b() {
        if (this.f1025a != null) {
            this.f1030f.mo759a((InterfaceC0624b) this.f1025a);
            this.f1025a = null;
        }
    }

    @Override // java.io.FilterInputStream, java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (this.f1025a != null) {
            this.f1030f.mo759a((InterfaceC0624b) this.f1025a);
            this.f1025a = null;
        }
        InputStream inputStream = this.in;
        this.in = null;
        if (inputStream != null) {
            inputStream.close();
        }
    }

    /* renamed from: a */
    private int m981a(InputStream inputStream, byte[] bArr) throws IOException {
        int i = this.f1028d;
        if (i != -1) {
            int i2 = this.f1029e - i;
            int i3 = this.f1027c;
            if (i2 < i3) {
                if (i == 0 && i3 > bArr.length && this.f1026b == bArr.length) {
                    int length = bArr.length * 2;
                    if (length > i3) {
                        length = i3;
                    }
                    byte[] bArr2 = (byte[]) this.f1030f.mo756a(length, byte[].class);
                    System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
                    this.f1025a = bArr2;
                    this.f1030f.mo759a((InterfaceC0624b) bArr);
                    bArr = bArr2;
                } else {
                    int i4 = this.f1028d;
                    if (i4 > 0) {
                        System.arraycopy(bArr, i4, bArr, 0, bArr.length - i4);
                    }
                }
                this.f1029e -= this.f1028d;
                this.f1028d = 0;
                this.f1026b = 0;
                int i5 = this.f1029e;
                int read = inputStream.read(bArr, i5, bArr.length - i5);
                this.f1026b = read <= 0 ? this.f1029e : this.f1029e + read;
                return read;
            }
        }
        int read2 = inputStream.read(bArr);
        if (read2 > 0) {
            this.f1028d = -1;
            this.f1029e = 0;
            this.f1026b = read2;
        }
        return read2;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized void mark(int i) {
        this.f1027c = Math.max(this.f1027c, i);
        this.f1028d = this.f1029e;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized int read() throws IOException {
        byte[] bArr = this.f1025a;
        InputStream inputStream = this.in;
        if (bArr == null || inputStream == null) {
            throw m982c();
        }
        if (this.f1029e >= this.f1026b && m981a(inputStream, bArr) == -1) {
            return -1;
        }
        if (bArr != this.f1025a && (bArr = this.f1025a) == null) {
            throw m982c();
        }
        if (this.f1026b - this.f1029e <= 0) {
            return -1;
        }
        int i = this.f1029e;
        this.f1029e = i + 1;
        return bArr[i] & 255;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized int read(@NonNull byte[] bArr, int i, int i2) throws IOException {
        int i3;
        int i4;
        byte[] bArr2 = this.f1025a;
        if (bArr2 == null) {
            throw m982c();
        }
        if (i2 == 0) {
            return 0;
        }
        InputStream inputStream = this.in;
        if (inputStream == null) {
            throw m982c();
        }
        if (this.f1029e < this.f1026b) {
            int i5 = this.f1026b - this.f1029e >= i2 ? i2 : this.f1026b - this.f1029e;
            System.arraycopy(bArr2, this.f1029e, bArr, i, i5);
            this.f1029e += i5;
            if (i5 == i2 || inputStream.available() == 0) {
                return i5;
            }
            i += i5;
            i3 = i2 - i5;
        } else {
            i3 = i2;
        }
        while (true) {
            if (this.f1028d == -1 && i3 >= bArr2.length) {
                i4 = inputStream.read(bArr, i, i3);
                if (i4 == -1) {
                    return i3 != i2 ? i2 - i3 : -1;
                }
            } else {
                if (m981a(inputStream, bArr2) == -1) {
                    return i3 != i2 ? i2 - i3 : -1;
                }
                if (bArr2 != this.f1025a && (bArr2 = this.f1025a) == null) {
                    throw m982c();
                }
                i4 = this.f1026b - this.f1029e >= i3 ? i3 : this.f1026b - this.f1029e;
                System.arraycopy(bArr2, this.f1029e, bArr, i, i4);
                this.f1029e += i4;
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
        if (this.f1025a == null) {
            throw new IOException("Stream is closed");
        }
        if (-1 == this.f1028d) {
            throw new InvalidMarkException("Mark has been invalidated, pos: " + this.f1029e + " markLimit: " + this.f1027c);
        }
        this.f1029e = this.f1028d;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized long skip(long j) throws IOException {
        if (j < 1) {
            return 0L;
        }
        byte[] bArr = this.f1025a;
        if (bArr == null) {
            throw m982c();
        }
        InputStream inputStream = this.in;
        if (inputStream == null) {
            throw m982c();
        }
        if (this.f1026b - this.f1029e >= j) {
            this.f1029e = (int) (this.f1029e + j);
            return j;
        }
        long j2 = this.f1026b - this.f1029e;
        this.f1029e = this.f1026b;
        if (this.f1028d != -1 && j <= this.f1027c) {
            if (m981a(inputStream, bArr) == -1) {
                return j2;
            }
            if (this.f1026b - this.f1029e >= j - j2) {
                this.f1029e = (int) ((this.f1029e + j) - j2);
                return j;
            }
            long j3 = (j2 + this.f1026b) - this.f1029e;
            this.f1029e = this.f1026b;
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