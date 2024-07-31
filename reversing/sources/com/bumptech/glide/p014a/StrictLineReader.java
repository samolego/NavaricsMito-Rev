package com.bumptech.glide.p014a;

import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;

/* renamed from: com.bumptech.glide.a.b */
/* loaded from: classes.dex */
class StrictLineReader implements Closeable {

    /* renamed from: a */
    private final InputStream f393a;

    /* renamed from: b */
    private final Charset f394b;

    /* renamed from: c */
    private byte[] f395c;

    /* renamed from: d */
    private int f396d;

    /* renamed from: e */
    private int f397e;

    public StrictLineReader(InputStream inputStream, Charset charset) {
        this(inputStream, 8192, charset);
    }

    public StrictLineReader(InputStream inputStream, int i, Charset charset) {
        if (inputStream == null || charset == null) {
            throw new NullPointerException();
        }
        if (i < 0) {
            throw new IllegalArgumentException("capacity <= 0");
        }
        if (!charset.equals(Util.f399a)) {
            throw new IllegalArgumentException("Unsupported encoding");
        }
        this.f393a = inputStream;
        this.f394b = charset;
        this.f395c = new byte[i];
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        synchronized (this.f393a) {
            if (this.f395c != null) {
                this.f395c = null;
                this.f393a.close();
            }
        }
    }

    /* renamed from: a */
    public String m12563a() throws IOException {
        int i;
        int i2;
        synchronized (this.f393a) {
            if (this.f395c == null) {
                throw new IOException("LineReader is closed");
            }
            if (this.f396d >= this.f397e) {
                m12560c();
            }
            for (int i3 = this.f396d; i3 != this.f397e; i3++) {
                if (this.f395c[i3] == 10) {
                    if (i3 != this.f396d) {
                        i2 = i3 - 1;
                        if (this.f395c[i2] == 13) {
                            String str = new String(this.f395c, this.f396d, i2 - this.f396d, this.f394b.name());
                            this.f396d = i3 + 1;
                            return str;
                        }
                    }
                    i2 = i3;
                    String str2 = new String(this.f395c, this.f396d, i2 - this.f396d, this.f394b.name());
                    this.f396d = i3 + 1;
                    return str2;
                }
            }
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream((this.f397e - this.f396d) + 80) { // from class: com.bumptech.glide.a.b.1
                @Override // java.io.ByteArrayOutputStream
                public String toString() {
                    try {
                        return new String(this.buf, 0, (this.count <= 0 || this.buf[this.count + (-1)] != 13) ? this.count : this.count - 1, StrictLineReader.this.f394b.name());
                    } catch (UnsupportedEncodingException e) {
                        throw new AssertionError(e);
                    }
                }
            };
            loop1: while (true) {
                byteArrayOutputStream.write(this.f395c, this.f396d, this.f397e - this.f396d);
                this.f397e = -1;
                m12560c();
                i = this.f396d;
                while (i != this.f397e) {
                    if (this.f395c[i] == 10) {
                        break loop1;
                    }
                    i++;
                }
            }
            if (i != this.f396d) {
                byteArrayOutputStream.write(this.f395c, this.f396d, i - this.f396d);
            }
            this.f396d = i + 1;
            return byteArrayOutputStream.toString();
        }
    }

    /* renamed from: b */
    public boolean m12561b() {
        return this.f397e == -1;
    }

    /* renamed from: c */
    private void m12560c() throws IOException {
        InputStream inputStream = this.f393a;
        byte[] bArr = this.f395c;
        int read = inputStream.read(bArr, 0, bArr.length);
        if (read == -1) {
            throw new EOFException();
        }
        this.f396d = 0;
        this.f397e = read;
    }
}
