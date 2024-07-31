package okio;

import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: okio.m */
/* loaded from: classes2.dex */
public final class RealBufferedSource implements BufferedSource {

    /* renamed from: a */
    public final Buffer f10699a = new Buffer();

    /* renamed from: b */
    public final Source f10700b;

    /* renamed from: c */
    boolean f10701c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RealBufferedSource(Source source) {
        if (source == null) {
            throw new NullPointerException("source == null");
        }
        this.f10700b = source;
    }

    @Override // okio.BufferedSource
    /* renamed from: c */
    public Buffer mo2238c() {
        return this.f10699a;
    }

    @Override // okio.Source
    /* renamed from: a */
    public long mo130a(Buffer buffer, long j) throws IOException {
        if (buffer != null) {
            if (j < 0) {
                throw new IllegalArgumentException("byteCount < 0: " + j);
            } else if (this.f10701c) {
                throw new IllegalStateException("closed");
            } else {
                if (this.f10699a.f10675b == 0 && this.f10700b.mo130a(this.f10699a, 8192L) == -1) {
                    return -1L;
                }
                return this.f10699a.mo130a(buffer, Math.min(j, this.f10699a.f10675b));
            }
        }
        throw new IllegalArgumentException("sink == null");
    }

    @Override // okio.BufferedSource
    /* renamed from: f */
    public boolean mo2236f() throws IOException {
        if (this.f10701c) {
            throw new IllegalStateException("closed");
        }
        return this.f10699a.mo2236f() && this.f10700b.mo130a(this.f10699a, 8192L) == -1;
    }

    @Override // okio.BufferedSource
    /* renamed from: a */
    public void mo2245a(long j) throws IOException {
        if (!mo2239b(j)) {
            throw new EOFException();
        }
    }

    @Override // okio.BufferedSource
    /* renamed from: b */
    public boolean mo2239b(long j) throws IOException {
        if (j < 0) {
            throw new IllegalArgumentException("byteCount < 0: " + j);
        } else if (this.f10701c) {
            throw new IllegalStateException("closed");
        } else {
            while (this.f10699a.f10675b < j) {
                if (this.f10700b.mo130a(this.f10699a, 8192L) == -1) {
                    return false;
                }
            }
            return true;
        }
    }

    @Override // okio.BufferedSource
    /* renamed from: i */
    public byte mo2232i() throws IOException {
        mo2245a(1L);
        return this.f10699a.mo2232i();
    }

    @Override // okio.BufferedSource
    /* renamed from: d */
    public ByteString mo2237d(long j) throws IOException {
        mo2245a(j);
        return this.f10699a.mo2237d(j);
    }

    @Override // okio.BufferedSource
    /* renamed from: h */
    public byte[] mo2233h(long j) throws IOException {
        mo2245a(j);
        return this.f10699a.mo2233h(j);
    }

    @Override // okio.BufferedSource
    /* renamed from: a */
    public void mo2240a(byte[] bArr) throws IOException {
        try {
            mo2245a(bArr.length);
            this.f10699a.mo2240a(bArr);
        } catch (EOFException e) {
            int i = 0;
            while (this.f10699a.f10675b > 0) {
                Buffer buffer = this.f10699a;
                int m2303a = buffer.m2303a(bArr, i, (int) buffer.f10675b);
                if (m2303a == -1) {
                    throw new AssertionError();
                }
                i += m2303a;
            }
            throw e;
        }
    }

    @Override // java.nio.channels.ReadableByteChannel
    public int read(ByteBuffer byteBuffer) throws IOException {
        if (this.f10699a.f10675b == 0 && this.f10700b.mo130a(this.f10699a, 8192L) == -1) {
            return -1;
        }
        return this.f10699a.read(byteBuffer);
    }

    @Override // okio.BufferedSource
    /* renamed from: a */
    public long mo2241a(Sink sink) throws IOException {
        if (sink == null) {
            throw new IllegalArgumentException("sink == null");
        }
        long j = 0;
        while (this.f10700b.mo130a(this.f10699a, 8192L) != -1) {
            long m2289h = this.f10699a.m2289h();
            if (m2289h > 0) {
                j += m2289h;
                sink.mo2215a_(this.f10699a, m2289h);
            }
        }
        if (this.f10699a.m2302b() > 0) {
            long m2302b = j + this.f10699a.m2302b();
            Buffer buffer = this.f10699a;
            sink.mo2215a_(buffer, buffer.m2302b());
            return m2302b;
        }
        return j;
    }

    @Override // okio.BufferedSource
    /* renamed from: a */
    public String mo2242a(Charset charset) throws IOException {
        if (charset == null) {
            throw new IllegalArgumentException("charset == null");
        }
        this.f10699a.mo2258a(this.f10700b);
        return this.f10699a.mo2242a(charset);
    }

    @Override // okio.BufferedSource
    /* renamed from: q */
    public String mo2225q() throws IOException {
        return mo2235f(Long.MAX_VALUE);
    }

    @Override // okio.BufferedSource
    /* renamed from: f */
    public String mo2235f(long j) throws IOException {
        if (j < 0) {
            throw new IllegalArgumentException("limit < 0: " + j);
        }
        long j2 = j == Long.MAX_VALUE ? Long.MAX_VALUE : j + 1;
        long m2246a = m2246a((byte) 10, 0L, j2);
        if (m2246a != -1) {
            return this.f10699a.m2290g(m2246a);
        }
        if (j2 < Long.MAX_VALUE && mo2239b(j2) && this.f10699a.m2297c(j2 - 1) == 13 && mo2239b(1 + j2) && this.f10699a.m2297c(j2) == 10) {
            return this.f10699a.m2290g(j2);
        }
        Buffer buffer = new Buffer();
        Buffer buffer2 = this.f10699a;
        buffer2.m2304a(buffer, 0L, Math.min(32L, buffer2.m2302b()));
        throw new EOFException("\\n not found: limit=" + Math.min(this.f10699a.m2302b(), j) + " content=" + buffer.m2286o().hex() + (char) 8230);
    }

    @Override // okio.BufferedSource
    /* renamed from: j */
    public short mo2230j() throws IOException {
        mo2245a(2L);
        return this.f10699a.mo2230j();
    }

    @Override // okio.BufferedSource
    /* renamed from: l */
    public short mo2228l() throws IOException {
        mo2245a(2L);
        return this.f10699a.mo2228l();
    }

    @Override // okio.BufferedSource
    /* renamed from: k */
    public int mo2229k() throws IOException {
        mo2245a(4L);
        return this.f10699a.mo2229k();
    }

    @Override // okio.BufferedSource
    /* renamed from: m */
    public int mo2227m() throws IOException {
        mo2245a(4L);
        return this.f10699a.mo2227m();
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x0032, code lost:
        if (r1 == 0) goto L21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0049, code lost:
        throw new java.lang.NumberFormatException(java.lang.String.format("Expected leading [0-9a-fA-F] character but was %#x", java.lang.Byte.valueOf(r3)));
     */
    @Override // okio.BufferedSource
    /* renamed from: n */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public long mo2226n() throws java.io.IOException {
        /*
            r6 = this;
            r0 = 1
            r6.mo2245a(r0)
            r0 = 0
            r1 = 0
        L7:
            int r2 = r1 + 1
            long r3 = (long) r2
            boolean r3 = r6.mo2239b(r3)
            if (r3 == 0) goto L4a
            okio.c r3 = r6.f10699a
            long r4 = (long) r1
            byte r3 = r3.m2297c(r4)
            r4 = 48
            if (r3 < r4) goto L1f
            r4 = 57
            if (r3 <= r4) goto L30
        L1f:
            r4 = 97
            if (r3 < r4) goto L27
            r4 = 102(0x66, float:1.43E-43)
            if (r3 <= r4) goto L30
        L27:
            r4 = 65
            if (r3 < r4) goto L32
            r4 = 70
            if (r3 <= r4) goto L30
            goto L32
        L30:
            r1 = r2
            goto L7
        L32:
            if (r1 == 0) goto L35
            goto L4a
        L35:
            java.lang.NumberFormatException r1 = new java.lang.NumberFormatException
            r2 = 1
            java.lang.Object[] r2 = new java.lang.Object[r2]
            java.lang.Byte r3 = java.lang.Byte.valueOf(r3)
            r2[r0] = r3
            java.lang.String r0 = "Expected leading [0-9a-fA-F] character but was %#x"
            java.lang.String r0 = java.lang.String.format(r0, r2)
            r1.<init>(r0)
            throw r1
        L4a:
            okio.c r0 = r6.f10699a
            long r0 = r0.mo2226n()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: okio.RealBufferedSource.mo2226n():long");
    }

    @Override // okio.BufferedSource
    /* renamed from: i */
    public void mo2231i(long j) throws IOException {
        if (this.f10701c) {
            throw new IllegalStateException("closed");
        }
        while (j > 0) {
            if (this.f10699a.f10675b == 0 && this.f10700b.mo130a(this.f10699a, 8192L) == -1) {
                throw new EOFException();
            }
            long min = Math.min(j, this.f10699a.m2302b());
            this.f10699a.mo2231i(min);
            j -= min;
        }
    }

    @Override // okio.BufferedSource
    /* renamed from: a */
    public long mo2247a(byte b) throws IOException {
        return m2246a(b, 0L, Long.MAX_VALUE);
    }

    /* renamed from: a */
    public long m2246a(byte b, long j, long j2) throws IOException {
        if (this.f10701c) {
            throw new IllegalStateException("closed");
        }
        if (j < 0 || j2 < j) {
            throw new IllegalArgumentException(String.format("fromIndex=%s toIndex=%s", Long.valueOf(j), Long.valueOf(j2)));
        }
        while (j < j2) {
            long m2312a = this.f10699a.m2312a(b, j, j2);
            if (m2312a != -1) {
                return m2312a;
            }
            long j3 = this.f10699a.f10675b;
            if (j3 >= j2 || this.f10700b.mo130a(this.f10699a, 8192L) == -1) {
                return -1L;
            }
            j = Math.max(j, j3);
        }
        return -1L;
    }

    @Override // okio.BufferedSource
    /* renamed from: a */
    public boolean mo2244a(long j, ByteString byteString) throws IOException {
        return m2243a(j, byteString, 0, byteString.size());
    }

    /* renamed from: a */
    public boolean m2243a(long j, ByteString byteString, int i, int i2) throws IOException {
        if (this.f10701c) {
            throw new IllegalStateException("closed");
        }
        if (j < 0 || i < 0 || i2 < 0 || byteString.size() - i < i2) {
            return false;
        }
        for (int i3 = 0; i3 < i2; i3++) {
            long j2 = i3 + j;
            if (!mo2239b(1 + j2) || this.f10699a.m2297c(j2) != byteString.getByte(i + i3)) {
                return false;
            }
        }
        return true;
    }

    @Override // okio.BufferedSource
    /* renamed from: g */
    public InputStream mo2234g() {
        return new InputStream() { // from class: okio.m.1
            @Override // java.io.InputStream
            public int read() throws IOException {
                if (RealBufferedSource.this.f10701c) {
                    throw new IOException("closed");
                }
                if (RealBufferedSource.this.f10699a.f10675b == 0 && RealBufferedSource.this.f10700b.mo130a(RealBufferedSource.this.f10699a, 8192L) == -1) {
                    return -1;
                }
                return RealBufferedSource.this.f10699a.mo2232i() & 255;
            }

            @Override // java.io.InputStream
            public int read(byte[] bArr, int i, int i2) throws IOException {
                if (RealBufferedSource.this.f10701c) {
                    throw new IOException("closed");
                }
                C3006s.m2204a(bArr.length, i, i2);
                if (RealBufferedSource.this.f10699a.f10675b == 0 && RealBufferedSource.this.f10700b.mo130a(RealBufferedSource.this.f10699a, 8192L) == -1) {
                    return -1;
                }
                return RealBufferedSource.this.f10699a.m2303a(bArr, i, i2);
            }

            @Override // java.io.InputStream
            public int available() throws IOException {
                if (RealBufferedSource.this.f10701c) {
                    throw new IOException("closed");
                }
                return (int) Math.min(RealBufferedSource.this.f10699a.f10675b, 2147483647L);
            }

            @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
            public void close() throws IOException {
                RealBufferedSource.this.close();
            }

            public String toString() {
                return RealBufferedSource.this + ".inputStream()";
            }
        };
    }

    @Override // java.nio.channels.Channel
    public boolean isOpen() {
        return !this.f10701c;
    }

    @Override // java.nio.channels.Channel, java.io.Closeable, java.lang.AutoCloseable, okio.Source
    public void close() throws IOException {
        if (this.f10701c) {
            return;
        }
        this.f10701c = true;
        this.f10700b.close();
        this.f10699a.m2282t();
    }

    @Override // okio.Source
    /* renamed from: a */
    public Timeout mo2214a() {
        return this.f10700b.mo2214a();
    }

    public String toString() {
        return "buffer(" + this.f10700b + ")";
    }
}
