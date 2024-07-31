package com.squareup.picasso;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;

/* compiled from: MarkableInputStream.java */
/* renamed from: com.squareup.picasso.m, reason: use source file name */
/* loaded from: classes2.dex */
final class MarkableInputStream extends InputStream {

    /* renamed from: a */
    private final InputStream f6993a;

    /* renamed from: b */
    private long f6994b;

    /* renamed from: c */
    private long f6995c;

    /* renamed from: d */
    private long f6996d;

    /* renamed from: e */
    private long f6997e;

    public MarkableInputStream(InputStream inputStream) {
        this(inputStream, 4096);
    }

    public MarkableInputStream(InputStream inputStream, int i) {
        this.f6997e = -1L;
        this.f6993a = inputStream.markSupported() ? inputStream : new BufferedInputStream(inputStream, i);
    }

    @Override // java.io.InputStream
    public void mark(int i) {
        this.f6997e = m7178a(i);
    }

    /* renamed from: a */
    public long m7178a(int i) {
        long j = this.f6994b + i;
        if (this.f6996d < j) {
            m7177b(j);
        }
        return this.f6994b;
    }

    /* renamed from: b */
    private void m7177b(long j) {
        try {
            if (this.f6995c < this.f6994b && this.f6994b <= this.f6996d) {
                this.f6993a.reset();
                this.f6993a.mark((int) (j - this.f6995c));
                m7176a(this.f6995c, this.f6994b);
            } else {
                this.f6995c = this.f6994b;
                this.f6993a.mark((int) (j - this.f6994b));
            }
            this.f6996d = j;
        } catch (IOException e) {
            throw new IllegalStateException("Unable to mark: " + e);
        }
    }

    @Override // java.io.InputStream
    public void reset() throws IOException {
        m7179a(this.f6997e);
    }

    /* renamed from: a */
    public void m7179a(long j) throws IOException {
        if (this.f6994b > this.f6996d || j < this.f6995c) {
            throw new IOException("Cannot reset");
        }
        this.f6993a.reset();
        m7176a(this.f6995c, j);
        this.f6994b = j;
    }

    /* renamed from: a */
    private void m7176a(long j, long j2) throws IOException {
        while (j < j2) {
            long skip = this.f6993a.skip(j2 - j);
            if (skip == 0) {
                if (read() == -1) {
                    return;
                } else {
                    skip = 1;
                }
            }
            j += skip;
        }
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        int read = this.f6993a.read();
        if (read != -1) {
            this.f6994b++;
        }
        return read;
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr) throws IOException {
        int read = this.f6993a.read(bArr);
        if (read != -1) {
            this.f6994b += read;
        }
        return read;
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i, int i2) throws IOException {
        int read = this.f6993a.read(bArr, i, i2);
        if (read != -1) {
            this.f6994b += read;
        }
        return read;
    }

    @Override // java.io.InputStream
    public long skip(long j) throws IOException {
        long skip = this.f6993a.skip(j);
        this.f6994b += skip;
        return skip;
    }

    @Override // java.io.InputStream
    public int available() throws IOException {
        return this.f6993a.available();
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.f6993a.close();
    }

    @Override // java.io.InputStream
    public boolean markSupported() {
        return this.f6993a.markSupported();
    }
}