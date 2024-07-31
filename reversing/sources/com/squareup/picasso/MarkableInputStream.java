package com.squareup.picasso;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;

/* renamed from: com.squareup.picasso.m */
/* loaded from: classes2.dex */
final class MarkableInputStream extends InputStream {

    /* renamed from: a */
    private final InputStream f6961a;

    /* renamed from: b */
    private long f6962b;

    /* renamed from: c */
    private long f6963c;

    /* renamed from: d */
    private long f6964d;

    /* renamed from: e */
    private long f6965e;

    public MarkableInputStream(InputStream inputStream) {
        this(inputStream, 4096);
    }

    public MarkableInputStream(InputStream inputStream, int i) {
        this.f6965e = -1L;
        this.f6961a = inputStream.markSupported() ? inputStream : new BufferedInputStream(inputStream, i);
    }

    @Override // java.io.InputStream
    public void mark(int i) {
        this.f6965e = m5682a(i);
    }

    /* renamed from: a */
    public long m5682a(int i) {
        long j = this.f6962b + i;
        if (this.f6964d < j) {
            m5679b(j);
        }
        return this.f6962b;
    }

    /* renamed from: b */
    private void m5679b(long j) {
        try {
            if (this.f6963c < this.f6962b && this.f6962b <= this.f6964d) {
                this.f6961a.reset();
                this.f6961a.mark((int) (j - this.f6963c));
                m5680a(this.f6963c, this.f6962b);
            } else {
                this.f6963c = this.f6962b;
                this.f6961a.mark((int) (j - this.f6962b));
            }
            this.f6964d = j;
        } catch (IOException e) {
            throw new IllegalStateException("Unable to mark: " + e);
        }
    }

    @Override // java.io.InputStream
    public void reset() throws IOException {
        m5681a(this.f6965e);
    }

    /* renamed from: a */
    public void m5681a(long j) throws IOException {
        if (this.f6962b > this.f6964d || j < this.f6963c) {
            throw new IOException("Cannot reset");
        }
        this.f6961a.reset();
        m5680a(this.f6963c, j);
        this.f6962b = j;
    }

    /* renamed from: a */
    private void m5680a(long j, long j2) throws IOException {
        while (j < j2) {
            long skip = this.f6961a.skip(j2 - j);
            if (skip == 0) {
                if (read() == -1) {
                    return;
                }
                skip = 1;
            }
            j += skip;
        }
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        int read = this.f6961a.read();
        if (read != -1) {
            this.f6962b++;
        }
        return read;
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr) throws IOException {
        int read = this.f6961a.read(bArr);
        if (read != -1) {
            this.f6962b += read;
        }
        return read;
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i, int i2) throws IOException {
        int read = this.f6961a.read(bArr, i, i2);
        if (read != -1) {
            this.f6962b += read;
        }
        return read;
    }

    @Override // java.io.InputStream
    public long skip(long j) throws IOException {
        long skip = this.f6961a.skip(j);
        this.f6962b += skip;
        return skip;
    }

    @Override // java.io.InputStream
    public int available() throws IOException {
        return this.f6961a.available();
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.f6961a.close();
    }

    @Override // java.io.InputStream
    public boolean markSupported() {
        return this.f6961a.markSupported();
    }
}
