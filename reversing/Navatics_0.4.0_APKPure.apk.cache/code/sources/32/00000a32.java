package com.bumptech.glide.p010a;

import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;

/* compiled from: StrictLineReader.java */
/* renamed from: com.bumptech.glide.a.b, reason: use source file name */
/* loaded from: classes.dex */
class StrictLineReader implements Closeable {

    /* renamed from: a */
    private final InputStream f397a;

    /* renamed from: b */
    private final Charset f398b;

    /* renamed from: c */
    private byte[] f399c;

    /* renamed from: d */
    private int f400d;

    /* renamed from: e */
    private int f401e;

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
        if (!charset.equals(C0532c.f403a)) {
            throw new IllegalArgumentException("Unsupported encoding");
        }
        this.f397a = inputStream;
        this.f398b = charset;
        this.f399c = new byte[i];
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        synchronized (this.f397a) {
            if (this.f399c != null) {
                this.f399c = null;
                this.f397a.close();
            }
        }
    }

    /* renamed from: a */
    public String m402a() throws IOException {
        int i;
        int i2;
        synchronized (this.f397a) {
            if (this.f399c == null) {
                throw new IOException("LineReader is closed");
            }
            if (this.f400d >= this.f401e) {
                m401c();
            }
            for (int i3 = this.f400d; i3 != this.f401e; i3++) {
                if (this.f399c[i3] == 10) {
                    if (i3 != this.f400d) {
                        i2 = i3 - 1;
                        if (this.f399c[i2] == 13) {
                            String str = new String(this.f399c, this.f400d, i2 - this.f400d, this.f398b.name());
                            this.f400d = i3 + 1;
                            return str;
                        }
                    }
                    i2 = i3;
                    String str2 = new String(this.f399c, this.f400d, i2 - this.f400d, this.f398b.name());
                    this.f400d = i3 + 1;
                    return str2;
                }
            }
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream((this.f401e - this.f400d) + 80) { // from class: com.bumptech.glide.a.b.1
                @Override // java.io.ByteArrayOutputStream
                public String toString() {
                    try {
                        return new String(this.buf, 0, (this.count <= 0 || this.buf[this.count + (-1)] != 13) ? this.count : this.count - 1, StrictLineReader.this.f398b.name());
                    } catch (UnsupportedEncodingException e) {
                        throw new AssertionError(e);
                    }
                }
            };
            loop1: while (true) {
                byteArrayOutputStream.write(this.f399c, this.f400d, this.f401e - this.f400d);
                this.f401e = -1;
                m401c();
                i = this.f400d;
                while (i != this.f401e) {
                    if (this.f399c[i] == 10) {
                        break loop1;
                    }
                    i++;
                }
            }
            if (i != this.f400d) {
                byteArrayOutputStream.write(this.f399c, this.f400d, i - this.f400d);
            }
            this.f400d = i + 1;
            return byteArrayOutputStream.toString();
        }
    }

    /* renamed from: b */
    public boolean m403b() {
        return this.f401e == -1;
    }

    /* renamed from: c */
    private void m401c() throws IOException {
        InputStream inputStream = this.f397a;
        byte[] bArr = this.f399c;
        int read = inputStream.read(bArr, 0, bArr.length);
        if (read == -1) {
            throw new EOFException();
        }
        this.f400d = 0;
        this.f401e = read;
    }
}