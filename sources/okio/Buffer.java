package okio;

import com.adapt.SPM_Rc;
import com.common.AUTOMATIVE_LIGHT;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.ByteChannel;
import java.nio.charset.Charset;
import javax.annotation.Nullable;

/* renamed from: okio.c */
/* loaded from: classes2.dex */
public final class Buffer implements Cloneable, ByteChannel, BufferedSink, BufferedSource {

    /* renamed from: c */
    private static final byte[] f10673c = {SPM_Rc.VIBRATION_MODE.CYCLE_MODE, 49, 50, 51, 52, 53, 54, 55, 56, 57, 97, 98, 99, 100, 101, 102};
    @Nullable

    /* renamed from: a */
    Segment f10674a;

    /* renamed from: b */
    long f10675b;

    @Override // okio.BufferedSink, okio.BufferedSource
    /* renamed from: c */
    public Buffer mo2238c() {
        return this;
    }

    @Override // java.nio.channels.Channel, java.io.Closeable, java.lang.AutoCloseable, okio.Sink
    public void close() {
    }

    @Override // okio.BufferedSink
    /* renamed from: e */
    public Buffer mo2248w() {
        return this;
    }

    @Override // okio.BufferedSink, okio.Sink, java.io.Flushable
    public void flush() {
    }

    @Override // java.nio.channels.Channel
    public boolean isOpen() {
        return true;
    }

    /* renamed from: b */
    public long m2302b() {
        return this.f10675b;
    }

    /* renamed from: d */
    public OutputStream m2296d() {
        return new OutputStream() { // from class: okio.c.1
            @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
            public void close() {
            }

            @Override // java.io.OutputStream, java.io.Flushable
            public void flush() {
            }

            @Override // java.io.OutputStream
            public void write(int i) {
                Buffer.this.mo2251i((int) ((byte) i));
            }

            @Override // java.io.OutputStream
            public void write(byte[] bArr, int i, int i2) {
                Buffer.this.mo2254c(bArr, i, i2);
            }

            public String toString() {
                return Buffer.this + ".outputStream()";
            }
        };
    }

    @Override // okio.BufferedSource
    /* renamed from: f */
    public boolean mo2236f() {
        return this.f10675b == 0;
    }

    @Override // okio.BufferedSource
    /* renamed from: a */
    public void mo2245a(long j) throws EOFException {
        if (this.f10675b < j) {
            throw new EOFException();
        }
    }

    @Override // okio.BufferedSource
    /* renamed from: b */
    public boolean mo2239b(long j) {
        return this.f10675b >= j;
    }

    @Override // okio.BufferedSource
    /* renamed from: g */
    public InputStream mo2234g() {
        return new InputStream() { // from class: okio.c.2
            @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
            public void close() {
            }

            @Override // java.io.InputStream
            public int read() {
                if (Buffer.this.f10675b > 0) {
                    return Buffer.this.mo2232i() & 255;
                }
                return -1;
            }

            @Override // java.io.InputStream
            public int read(byte[] bArr, int i, int i2) {
                return Buffer.this.m2303a(bArr, i, i2);
            }

            @Override // java.io.InputStream
            public int available() {
                return (int) Math.min(Buffer.this.f10675b, 2147483647L);
            }

            public String toString() {
                return Buffer.this + ".inputStream()";
            }
        };
    }

    /* renamed from: a */
    public Buffer m2304a(Buffer buffer, long j, long j2) {
        if (buffer == null) {
            throw new IllegalArgumentException("out == null");
        }
        C3006s.m2204a(this.f10675b, j, j2);
        if (j2 == 0) {
            return this;
        }
        buffer.f10675b += j2;
        Segment segment = this.f10674a;
        while (j >= segment.f10705c - segment.f10704b) {
            j -= segment.f10705c - segment.f10704b;
            segment = segment.f10708f;
        }
        while (j2 > 0) {
            Segment m2224a = segment.m2224a();
            m2224a.f10704b = (int) (m2224a.f10704b + j);
            m2224a.f10705c = Math.min(m2224a.f10704b + ((int) j2), m2224a.f10705c);
            Segment segment2 = buffer.f10674a;
            if (segment2 == null) {
                m2224a.f10709g = m2224a;
                m2224a.f10708f = m2224a;
                buffer.f10674a = m2224a;
            } else {
                segment2.f10709g.m2222a(m2224a);
            }
            j2 -= m2224a.f10705c - m2224a.f10704b;
            segment = segment.f10708f;
            j = 0;
        }
        return this;
    }

    /* renamed from: h */
    public long m2289h() {
        long j = this.f10675b;
        if (j == 0) {
            return 0L;
        }
        Segment segment = this.f10674a.f10709g;
        return (segment.f10705c >= 8192 || !segment.f10707e) ? j : j - (segment.f10705c - segment.f10704b);
    }

    @Override // okio.BufferedSource
    /* renamed from: i */
    public byte mo2232i() {
        if (this.f10675b == 0) {
            throw new IllegalStateException("size == 0");
        }
        Segment segment = this.f10674a;
        int i = segment.f10704b;
        int i2 = segment.f10705c;
        int i3 = i + 1;
        byte b = segment.f10703a[i];
        this.f10675b--;
        if (i3 == i2) {
            this.f10674a = segment.m2220b();
            SegmentPool.m2217a(segment);
        } else {
            segment.f10704b = i3;
        }
        return b;
    }

    /* renamed from: c */
    public byte m2297c(long j) {
        C3006s.m2204a(this.f10675b, j, 1L);
        long j2 = this.f10675b;
        if (j2 - j > j) {
            Segment segment = this.f10674a;
            while (true) {
                long j3 = segment.f10705c - segment.f10704b;
                if (j >= j3) {
                    j -= j3;
                    segment = segment.f10708f;
                } else {
                    return segment.f10703a[segment.f10704b + ((int) j)];
                }
            }
        } else {
            long j4 = j - j2;
            Segment segment2 = this.f10674a;
            do {
                segment2 = segment2.f10709g;
                j4 += segment2.f10705c - segment2.f10704b;
            } while (j4 < 0);
            return segment2.f10703a[segment2.f10704b + ((int) j4)];
        }
    }

    @Override // okio.BufferedSource
    /* renamed from: j */
    public short mo2230j() {
        if (this.f10675b < 2) {
            throw new IllegalStateException("size < 2: " + this.f10675b);
        }
        Segment segment = this.f10674a;
        int i = segment.f10704b;
        int i2 = segment.f10705c;
        if (i2 - i < 2) {
            return (short) (((mo2232i() & 255) << 8) | (mo2232i() & 255));
        }
        byte[] bArr = segment.f10703a;
        int i3 = i + 1;
        int i4 = i3 + 1;
        int i5 = ((bArr[i] & 255) << 8) | (bArr[i3] & 255);
        this.f10675b -= 2;
        if (i4 == i2) {
            this.f10674a = segment.m2220b();
            SegmentPool.m2217a(segment);
        } else {
            segment.f10704b = i4;
        }
        return (short) i5;
    }

    @Override // okio.BufferedSource
    /* renamed from: k */
    public int mo2229k() {
        if (this.f10675b < 4) {
            throw new IllegalStateException("size < 4: " + this.f10675b);
        }
        Segment segment = this.f10674a;
        int i = segment.f10704b;
        int i2 = segment.f10705c;
        if (i2 - i < 4) {
            return ((mo2232i() & 255) << 24) | ((mo2232i() & 255) << 16) | ((mo2232i() & 255) << 8) | (mo2232i() & 255);
        }
        byte[] bArr = segment.f10703a;
        int i3 = i + 1;
        int i4 = i3 + 1;
        int i5 = ((bArr[i] & 255) << 24) | ((bArr[i3] & 255) << 16);
        int i6 = i4 + 1;
        int i7 = i5 | ((bArr[i4] & 255) << 8);
        int i8 = i6 + 1;
        int i9 = i7 | (bArr[i6] & 255);
        this.f10675b -= 4;
        if (i8 == i2) {
            this.f10674a = segment.m2220b();
            SegmentPool.m2217a(segment);
        } else {
            segment.f10704b = i8;
        }
        return i9;
    }

    @Override // okio.BufferedSource
    /* renamed from: l */
    public short mo2228l() {
        return C3006s.m2202a(mo2230j());
    }

    @Override // okio.BufferedSource
    /* renamed from: m */
    public int mo2227m() {
        return C3006s.m2205a(mo2229k());
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x0094  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x009e  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00a2  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00a6 A[EDGE_INSN: B:42:0x00a6->B:37:0x00a6 ?: BREAK  , SYNTHETIC] */
    @Override // okio.BufferedSource
    /* renamed from: n */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public long mo2226n() {
        /*
            r15 = this;
            long r0 = r15.f10675b
            r2 = 0
            int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r4 == 0) goto Lad
            r0 = 0
            r4 = r2
            r1 = 0
        Lb:
            okio.n r6 = r15.f10674a
            byte[] r7 = r6.f10703a
            int r8 = r6.f10704b
            int r9 = r6.f10705c
        L13:
            if (r8 >= r9) goto L92
            r10 = r7[r8]
            r11 = 48
            if (r10 < r11) goto L22
            r11 = 57
            if (r10 > r11) goto L22
            int r11 = r10 + (-48)
            goto L3b
        L22:
            r11 = 97
            if (r10 < r11) goto L2f
            r11 = 102(0x66, float:1.43E-43)
            if (r10 > r11) goto L2f
            int r11 = r10 + (-97)
            int r11 = r11 + 10
            goto L3b
        L2f:
            r11 = 65
            if (r10 < r11) goto L73
            r11 = 70
            if (r10 > r11) goto L73
            int r11 = r10 + (-65)
            int r11 = r11 + 10
        L3b:
            r12 = -1152921504606846976(0xf000000000000000, double:-3.105036184601418E231)
            long r12 = r12 & r4
            int r14 = (r12 > r2 ? 1 : (r12 == r2 ? 0 : -1))
            if (r14 != 0) goto L4b
            r10 = 4
            long r4 = r4 << r10
            long r10 = (long) r11
            long r4 = r4 | r10
            int r8 = r8 + 1
            int r1 = r1 + 1
            goto L13
        L4b:
            okio.c r0 = new okio.c
            r0.<init>()
            okio.c r0 = r0.mo2250l(r4)
            okio.c r0 = r0.mo2251i(r10)
            java.lang.NumberFormatException r1 = new java.lang.NumberFormatException
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "Number too large: "
            r2.append(r3)
            java.lang.String r0 = r0.m2285p()
            r2.append(r0)
            java.lang.String r0 = r2.toString()
            r1.<init>(r0)
            throw r1
        L73:
            if (r1 == 0) goto L77
            r0 = 1
            goto L92
        L77:
            java.lang.NumberFormatException r0 = new java.lang.NumberFormatException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Expected leading [0-9a-fA-F] character but was 0x"
            r1.append(r2)
            java.lang.String r2 = java.lang.Integer.toHexString(r10)
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        L92:
            if (r8 != r9) goto L9e
            okio.n r7 = r6.m2220b()
            r15.f10674a = r7
            okio.SegmentPool.m2217a(r6)
            goto La0
        L9e:
            r6.f10704b = r8
        La0:
            if (r0 != 0) goto La6
            okio.n r6 = r15.f10674a
            if (r6 != 0) goto Lb
        La6:
            long r2 = r15.f10675b
            long r0 = (long) r1
            long r2 = r2 - r0
            r15.f10675b = r2
            return r4
        Lad:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "size == 0"
            r0.<init>(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: okio.Buffer.mo2226n():long");
    }

    /* renamed from: o */
    public ByteString m2286o() {
        return new ByteString(m2283s());
    }

    @Override // okio.BufferedSource
    /* renamed from: d */
    public ByteString mo2237d(long j) throws EOFException {
        return new ByteString(mo2233h(j));
    }

    @Override // okio.BufferedSource
    /* renamed from: a */
    public long mo2241a(Sink sink) throws IOException {
        long j = this.f10675b;
        if (j > 0) {
            sink.mo2215a_(this, j);
        }
        return j;
    }

    /* renamed from: p */
    public String m2285p() {
        try {
            return m2310a(this.f10675b, C3006s.f10716a);
        } catch (EOFException e) {
            throw new AssertionError(e);
        }
    }

    /* renamed from: e */
    public String m2292e(long j) throws EOFException {
        return m2310a(j, C3006s.f10716a);
    }

    @Override // okio.BufferedSource
    /* renamed from: a */
    public String mo2242a(Charset charset) {
        try {
            return m2310a(this.f10675b, charset);
        } catch (EOFException e) {
            throw new AssertionError(e);
        }
    }

    /* renamed from: a */
    public String m2310a(long j, Charset charset) throws EOFException {
        C3006s.m2204a(this.f10675b, 0L, j);
        if (charset != null) {
            if (j > 2147483647L) {
                throw new IllegalArgumentException("byteCount > Integer.MAX_VALUE: " + j);
            } else if (j == 0) {
                return "";
            } else {
                Segment segment = this.f10674a;
                if (segment.f10704b + j > segment.f10705c) {
                    return new String(mo2233h(j), charset);
                }
                String str = new String(segment.f10703a, segment.f10704b, (int) j, charset);
                segment.f10704b = (int) (segment.f10704b + j);
                this.f10675b -= j;
                if (segment.f10704b == segment.f10705c) {
                    this.f10674a = segment.m2220b();
                    SegmentPool.m2217a(segment);
                }
                return str;
            }
        }
        throw new IllegalArgumentException("charset == null");
    }

    @Override // okio.BufferedSource
    /* renamed from: q */
    public String mo2225q() throws EOFException {
        return mo2235f(Long.MAX_VALUE);
    }

    @Override // okio.BufferedSource
    /* renamed from: f */
    public String mo2235f(long j) throws EOFException {
        if (j < 0) {
            throw new IllegalArgumentException("limit < 0: " + j);
        }
        long j2 = j != Long.MAX_VALUE ? j + 1 : Long.MAX_VALUE;
        long m2312a = m2312a((byte) 10, 0L, j2);
        if (m2312a != -1) {
            return m2290g(m2312a);
        }
        if (j2 < m2302b() && m2297c(j2 - 1) == 13 && m2297c(j2) == 10) {
            return m2290g(j2);
        }
        Buffer buffer = new Buffer();
        m2304a(buffer, 0L, Math.min(32L, m2302b()));
        throw new EOFException("\\n not found: limit=" + Math.min(m2302b(), j) + " content=" + buffer.m2286o().hex() + (char) 8230);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: g */
    public String m2290g(long j) throws EOFException {
        if (j > 0) {
            long j2 = j - 1;
            if (m2297c(j2) == 13) {
                String m2292e = m2292e(j2);
                mo2231i(2L);
                return m2292e;
            }
        }
        String m2292e2 = m2292e(j);
        mo2231i(1L);
        return m2292e2;
    }

    /* renamed from: r */
    public int m2284r() throws EOFException {
        int i;
        int i2;
        int i3;
        if (this.f10675b == 0) {
            throw new EOFException();
        }
        byte m2297c = m2297c(0L);
        if ((m2297c & AUTOMATIVE_LIGHT.OVERTURN) == 0) {
            i = m2297c & Byte.MAX_VALUE;
            i2 = 1;
            i3 = 0;
        } else if ((m2297c & 224) == 192) {
            i = m2297c & 31;
            i2 = 2;
            i3 = 128;
        } else if ((m2297c & 240) == 224) {
            i = m2297c & SPM_Rc.VIBRATION_MODE.MAX_VOLUME;
            i2 = 3;
            i3 = 2048;
        } else if ((m2297c & 248) != 240) {
            mo2231i(1L);
            return 65533;
        } else {
            i = m2297c & 7;
            i2 = 4;
            i3 = 65536;
        }
        long j = i2;
        if (this.f10675b < j) {
            throw new EOFException("size < " + i2 + ": " + this.f10675b + " (to read code point prefixed 0x" + Integer.toHexString(m2297c) + ")");
        }
        for (int i4 = 1; i4 < i2; i4++) {
            long j2 = i4;
            byte m2297c2 = m2297c(j2);
            if ((m2297c2 & AUTOMATIVE_LIGHT.FLICKER) != 128) {
                mo2231i(j2);
                return 65533;
            }
            i = (i << 6) | (m2297c2 & 63);
        }
        mo2231i(j);
        if (i > 1114111) {
            return 65533;
        }
        if ((i < 55296 || i > 57343) && i >= i3) {
            return i;
        }
        return 65533;
    }

    /* renamed from: s */
    public byte[] m2283s() {
        try {
            return mo2233h(this.f10675b);
        } catch (EOFException e) {
            throw new AssertionError(e);
        }
    }

    @Override // okio.BufferedSource
    /* renamed from: h */
    public byte[] mo2233h(long j) throws EOFException {
        C3006s.m2204a(this.f10675b, 0L, j);
        if (j > 2147483647L) {
            throw new IllegalArgumentException("byteCount > Integer.MAX_VALUE: " + j);
        }
        byte[] bArr = new byte[(int) j];
        mo2240a(bArr);
        return bArr;
    }

    @Override // okio.BufferedSource
    /* renamed from: a */
    public void mo2240a(byte[] bArr) throws EOFException {
        int i = 0;
        while (i < bArr.length) {
            int m2303a = m2303a(bArr, i, bArr.length - i);
            if (m2303a == -1) {
                throw new EOFException();
            }
            i += m2303a;
        }
    }

    /* renamed from: a */
    public int m2303a(byte[] bArr, int i, int i2) {
        C3006s.m2204a(bArr.length, i, i2);
        Segment segment = this.f10674a;
        if (segment == null) {
            return -1;
        }
        int min = Math.min(i2, segment.f10705c - segment.f10704b);
        System.arraycopy(segment.f10703a, segment.f10704b, bArr, i, min);
        segment.f10704b += min;
        this.f10675b -= min;
        if (segment.f10704b == segment.f10705c) {
            this.f10674a = segment.m2220b();
            SegmentPool.m2217a(segment);
        }
        return min;
    }

    @Override // java.nio.channels.ReadableByteChannel
    public int read(ByteBuffer byteBuffer) throws IOException {
        Segment segment = this.f10674a;
        if (segment == null) {
            return -1;
        }
        int min = Math.min(byteBuffer.remaining(), segment.f10705c - segment.f10704b);
        byteBuffer.put(segment.f10703a, segment.f10704b, min);
        segment.f10704b += min;
        this.f10675b -= min;
        if (segment.f10704b == segment.f10705c) {
            this.f10674a = segment.m2220b();
            SegmentPool.m2217a(segment);
        }
        return min;
    }

    /* renamed from: t */
    public void m2282t() {
        try {
            mo2231i(this.f10675b);
        } catch (EOFException e) {
            throw new AssertionError(e);
        }
    }

    @Override // okio.BufferedSource
    /* renamed from: i */
    public void mo2231i(long j) throws EOFException {
        Segment segment;
        while (j > 0) {
            if (this.f10674a == null) {
                throw new EOFException();
            }
            int min = (int) Math.min(j, segment.f10705c - this.f10674a.f10704b);
            long j2 = min;
            this.f10675b -= j2;
            j -= j2;
            this.f10674a.f10704b += min;
            if (this.f10674a.f10704b == this.f10674a.f10705c) {
                Segment segment2 = this.f10674a;
                this.f10674a = segment2.m2220b();
                SegmentPool.m2217a(segment2);
            }
        }
    }

    @Override // okio.BufferedSink
    /* renamed from: a */
    public Buffer mo2256b(ByteString byteString) {
        if (byteString == null) {
            throw new IllegalArgumentException("byteString == null");
        }
        byteString.write(this);
        return this;
    }

    @Override // okio.BufferedSink
    /* renamed from: a */
    public Buffer mo2257b(String str) {
        return m2307a(str, 0, str.length());
    }

    /* renamed from: a */
    public Buffer m2307a(String str, int i, int i2) {
        if (str != null) {
            if (i < 0) {
                throw new IllegalArgumentException("beginIndex < 0: " + i);
            } else if (i2 < i) {
                throw new IllegalArgumentException("endIndex < beginIndex: " + i2 + " < " + i);
            } else if (i2 > str.length()) {
                throw new IllegalArgumentException("endIndex > string.length: " + i2 + " > " + str.length());
            } else {
                while (i < i2) {
                    char charAt = str.charAt(i);
                    if (charAt < 128) {
                        Segment m2293e = m2293e(1);
                        byte[] bArr = m2293e.f10703a;
                        int i3 = m2293e.f10705c - i;
                        int min = Math.min(i2, 8192 - i3);
                        int i4 = i + 1;
                        bArr[i + i3] = (byte) charAt;
                        while (i4 < min) {
                            char charAt2 = str.charAt(i4);
                            if (charAt2 >= 128) {
                                break;
                            }
                            bArr[i4 + i3] = (byte) charAt2;
                            i4++;
                        }
                        int i5 = (i3 + i4) - m2293e.f10705c;
                        m2293e.f10705c += i5;
                        this.f10675b += i5;
                        i = i4;
                    } else if (charAt < 2048) {
                        mo2251i((charAt >> 6) | 192);
                        mo2251i((charAt & '?') | 128);
                        i++;
                    } else if (charAt < 55296 || charAt > 57343) {
                        mo2251i((charAt >> '\f') | 224);
                        mo2251i(((charAt >> 6) & 63) | 128);
                        mo2251i((charAt & '?') | 128);
                        i++;
                    } else {
                        int i6 = i + 1;
                        char charAt3 = i6 < i2 ? str.charAt(i6) : (char) 0;
                        if (charAt > 56319 || charAt3 < 56320 || charAt3 > 57343) {
                            mo2251i(63);
                            i = i6;
                        } else {
                            int i7 = (((charAt & 10239) << 10) | (9215 & charAt3)) + 65536;
                            mo2251i((i7 >> 18) | 240);
                            mo2251i(((i7 >> 12) & 63) | 128);
                            mo2251i(((i7 >> 6) & 63) | 128);
                            mo2251i((i7 & 63) | 128);
                            i += 2;
                        }
                    }
                }
                return this;
            }
        }
        throw new IllegalArgumentException("string == null");
    }

    /* renamed from: a */
    public Buffer m2311a(int i) {
        if (i < 128) {
            mo2251i(i);
        } else if (i < 2048) {
            mo2251i((i >> 6) | 192);
            mo2251i((i & 63) | 128);
        } else if (i < 65536) {
            if (i >= 55296 && i <= 57343) {
                mo2251i(63);
            } else {
                mo2251i((i >> 12) | 224);
                mo2251i(((i >> 6) & 63) | 128);
                mo2251i((i & 63) | 128);
            }
        } else if (i <= 1114111) {
            mo2251i((i >> 18) | 240);
            mo2251i(((i >> 12) & 63) | 128);
            mo2251i(((i >> 6) & 63) | 128);
            mo2251i((i & 63) | 128);
        } else {
            throw new IllegalArgumentException("Unexpected code point: " + Integer.toHexString(i));
        }
        return this;
    }

    /* renamed from: a */
    public Buffer m2306a(String str, int i, int i2, Charset charset) {
        if (str != null) {
            if (i < 0) {
                throw new IllegalAccessError("beginIndex < 0: " + i);
            } else if (i2 < i) {
                throw new IllegalArgumentException("endIndex < beginIndex: " + i2 + " < " + i);
            } else if (i2 <= str.length()) {
                if (charset == null) {
                    throw new IllegalArgumentException("charset == null");
                }
                if (charset.equals(C3006s.f10716a)) {
                    return m2307a(str, i, i2);
                }
                byte[] bytes = str.substring(i, i2).getBytes(charset);
                return mo2254c(bytes, 0, bytes.length);
            } else {
                throw new IllegalArgumentException("endIndex > string.length: " + i2 + " > " + str.length());
            }
        }
        throw new IllegalArgumentException("string == null");
    }

    @Override // okio.BufferedSink
    /* renamed from: b */
    public Buffer mo2255c(byte[] bArr) {
        if (bArr == null) {
            throw new IllegalArgumentException("source == null");
        }
        return mo2254c(bArr, 0, bArr.length);
    }

    @Override // okio.BufferedSink
    /* renamed from: b */
    public Buffer mo2254c(byte[] bArr, int i, int i2) {
        if (bArr == null) {
            throw new IllegalArgumentException("source == null");
        }
        long j = i2;
        C3006s.m2204a(bArr.length, i, j);
        int i3 = i2 + i;
        while (i < i3) {
            Segment m2293e = m2293e(1);
            int min = Math.min(i3 - i, 8192 - m2293e.f10705c);
            System.arraycopy(bArr, i, m2293e.f10703a, m2293e.f10705c, min);
            i += min;
            m2293e.f10705c += min;
        }
        this.f10675b += j;
        return this;
    }

    @Override // java.nio.channels.WritableByteChannel
    public int write(ByteBuffer byteBuffer) throws IOException {
        if (byteBuffer == null) {
            throw new IllegalArgumentException("source == null");
        }
        int remaining = byteBuffer.remaining();
        int i = remaining;
        while (i > 0) {
            Segment m2293e = m2293e(1);
            int min = Math.min(i, 8192 - m2293e.f10705c);
            byteBuffer.get(m2293e.f10703a, m2293e.f10705c, min);
            i -= min;
            m2293e.f10705c += min;
        }
        this.f10675b += remaining;
        return remaining;
    }

    @Override // okio.BufferedSink
    /* renamed from: a */
    public long mo2258a(Source source) throws IOException {
        if (source == null) {
            throw new IllegalArgumentException("source == null");
        }
        long j = 0;
        while (true) {
            long mo130a = source.mo130a(this, 8192L);
            if (mo130a == -1) {
                return j;
            }
            j += mo130a;
        }
    }

    @Override // okio.BufferedSink
    /* renamed from: b */
    public Buffer mo2251i(int i) {
        Segment m2293e = m2293e(1);
        byte[] bArr = m2293e.f10703a;
        int i2 = m2293e.f10705c;
        m2293e.f10705c = i2 + 1;
        bArr[i2] = (byte) i;
        this.f10675b++;
        return this;
    }

    @Override // okio.BufferedSink
    /* renamed from: c */
    public Buffer mo2252h(int i) {
        Segment m2293e = m2293e(2);
        byte[] bArr = m2293e.f10703a;
        int i2 = m2293e.f10705c;
        int i3 = i2 + 1;
        bArr[i2] = (byte) ((i >>> 8) & 255);
        bArr[i3] = (byte) (i & 255);
        m2293e.f10705c = i3 + 1;
        this.f10675b += 2;
        return this;
    }

    @Override // okio.BufferedSink
    /* renamed from: d */
    public Buffer mo2253g(int i) {
        Segment m2293e = m2293e(4);
        byte[] bArr = m2293e.f10703a;
        int i2 = m2293e.f10705c;
        int i3 = i2 + 1;
        bArr[i2] = (byte) ((i >>> 24) & 255);
        int i4 = i3 + 1;
        bArr[i3] = (byte) ((i >>> 16) & 255);
        int i5 = i4 + 1;
        bArr[i4] = (byte) ((i >>> 8) & 255);
        bArr[i5] = (byte) (i & 255);
        m2293e.f10705c = i5 + 1;
        this.f10675b += 4;
        return this;
    }

    @Override // okio.BufferedSink
    /* renamed from: j */
    public Buffer mo2249m(long j) {
        int i = (j > 0L ? 1 : (j == 0L ? 0 : -1));
        if (i == 0) {
            return mo2251i(48);
        }
        boolean z = false;
        int i2 = 1;
        if (i < 0) {
            j = -j;
            if (j < 0) {
                return mo2257b("-9223372036854775808");
            }
            z = true;
        }
        if (j >= 100000000) {
            i2 = j < 1000000000000L ? j < 10000000000L ? j < 1000000000 ? 9 : 10 : j < 100000000000L ? 11 : 12 : j < 1000000000000000L ? j < 10000000000000L ? 13 : j < 100000000000000L ? 14 : 15 : j < 100000000000000000L ? j < 10000000000000000L ? 16 : 17 : j < 1000000000000000000L ? 18 : 19;
        } else if (j >= 10000) {
            i2 = j < 1000000 ? j < 100000 ? 5 : 6 : j < 10000000 ? 7 : 8;
        } else if (j >= 100) {
            i2 = j < 1000 ? 3 : 4;
        } else if (j >= 10) {
            i2 = 2;
        }
        if (z) {
            i2++;
        }
        Segment m2293e = m2293e(i2);
        byte[] bArr = m2293e.f10703a;
        int i3 = m2293e.f10705c + i2;
        while (j != 0) {
            i3--;
            bArr[i3] = f10673c[(int) (j % 10)];
            j /= 10;
        }
        if (z) {
            bArr[i3 - 1] = 45;
        }
        m2293e.f10705c += i2;
        this.f10675b += i2;
        return this;
    }

    @Override // okio.BufferedSink
    /* renamed from: k */
    public Buffer mo2250l(long j) {
        if (j == 0) {
            return mo2251i(48);
        }
        int numberOfTrailingZeros = (Long.numberOfTrailingZeros(Long.highestOneBit(j)) / 4) + 1;
        Segment m2293e = m2293e(numberOfTrailingZeros);
        byte[] bArr = m2293e.f10703a;
        int i = m2293e.f10705c;
        for (int i2 = (m2293e.f10705c + numberOfTrailingZeros) - 1; i2 >= i; i2--) {
            bArr[i2] = f10673c[(int) (15 & j)];
            j >>>= 4;
        }
        m2293e.f10705c += numberOfTrailingZeros;
        this.f10675b += numberOfTrailingZeros;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: e */
    public Segment m2293e(int i) {
        if (i < 1 || i > 8192) {
            throw new IllegalArgumentException();
        }
        Segment segment = this.f10674a;
        if (segment == null) {
            this.f10674a = SegmentPool.m2218a();
            Segment segment2 = this.f10674a;
            segment2.f10709g = segment2;
            segment2.f10708f = segment2;
            return segment2;
        }
        Segment segment3 = segment.f10709g;
        return (segment3.f10705c + i > 8192 || !segment3.f10707e) ? segment3.m2222a(SegmentPool.m2218a()) : segment3;
    }

    @Override // okio.Sink
    /* renamed from: a_ */
    public void mo2215a_(Buffer buffer, long j) {
        if (buffer == null) {
            throw new IllegalArgumentException("source == null");
        }
        if (buffer == this) {
            throw new IllegalArgumentException("source == this");
        }
        C3006s.m2204a(buffer.f10675b, 0L, j);
        while (j > 0) {
            if (j < buffer.f10674a.f10705c - buffer.f10674a.f10704b) {
                Segment segment = this.f10674a;
                Segment segment2 = segment != null ? segment.f10709g : null;
                if (segment2 != null && segment2.f10707e) {
                    if ((segment2.f10705c + j) - (segment2.f10706d ? 0 : segment2.f10704b) <= 8192) {
                        buffer.f10674a.m2221a(segment2, (int) j);
                        buffer.f10675b -= j;
                        this.f10675b += j;
                        return;
                    }
                }
                buffer.f10674a = buffer.f10674a.m2223a((int) j);
            }
            Segment segment3 = buffer.f10674a;
            long j2 = segment3.f10705c - segment3.f10704b;
            buffer.f10674a = segment3.m2220b();
            Segment segment4 = this.f10674a;
            if (segment4 == null) {
                this.f10674a = segment3;
                Segment segment5 = this.f10674a;
                segment5.f10709g = segment5;
                segment5.f10708f = segment5;
            } else {
                segment4.f10709g.m2222a(segment3).m2219c();
            }
            buffer.f10675b -= j2;
            this.f10675b += j2;
            j -= j2;
        }
    }

    @Override // okio.Source
    /* renamed from: a */
    public long mo130a(Buffer buffer, long j) {
        if (buffer != null) {
            if (j < 0) {
                throw new IllegalArgumentException("byteCount < 0: " + j);
            }
            long j2 = this.f10675b;
            if (j2 == 0) {
                return -1L;
            }
            if (j > j2) {
                j = j2;
            }
            buffer.mo2215a_(this, j);
            return j;
        }
        throw new IllegalArgumentException("sink == null");
    }

    @Override // okio.BufferedSource
    /* renamed from: a */
    public long mo2247a(byte b) {
        return m2312a(b, 0L, Long.MAX_VALUE);
    }

    /* renamed from: a */
    public long m2312a(byte b, long j, long j2) {
        Segment segment;
        long j3;
        long j4 = 0;
        if (j < 0 || j2 < j) {
            throw new IllegalArgumentException(String.format("size=%s fromIndex=%s toIndex=%s", Long.valueOf(this.f10675b), Long.valueOf(j), Long.valueOf(j2)));
        }
        long j5 = this.f10675b;
        if (j2 <= j5) {
            j5 = j2;
        }
        if (j == j5 || (segment = this.f10674a) == null) {
            return -1L;
        }
        long j6 = this.f10675b;
        if (j6 - j < j) {
            while (j6 > j) {
                segment = segment.f10709g;
                j6 -= segment.f10705c - segment.f10704b;
            }
            j3 = j;
        } else {
            while (true) {
                j6 = j4;
                j4 = (segment.f10705c - segment.f10704b) + j6;
                if (j4 >= j) {
                    break;
                }
                segment = segment.f10708f;
            }
            j3 = j;
        }
        while (j6 < j5) {
            byte[] bArr = segment.f10703a;
            int min = (int) Math.min(segment.f10705c, (segment.f10704b + j5) - j6);
            for (int i = (int) ((segment.f10704b + j3) - j6); i < min; i++) {
                if (bArr[i] == b) {
                    return (i - segment.f10704b) + j6;
                }
            }
            j3 = (segment.f10705c - segment.f10704b) + j6;
            segment = segment.f10708f;
            j6 = j3;
        }
        return -1L;
    }

    @Override // okio.BufferedSource
    /* renamed from: a */
    public boolean mo2244a(long j, ByteString byteString) {
        return m2309a(j, byteString, 0, byteString.size());
    }

    /* renamed from: a */
    public boolean m2309a(long j, ByteString byteString, int i, int i2) {
        if (j < 0 || i < 0 || i2 < 0 || this.f10675b - j < i2 || byteString.size() - i < i2) {
            return false;
        }
        for (int i3 = 0; i3 < i2; i3++) {
            if (m2297c(i3 + j) != byteString.getByte(i + i3)) {
                return false;
            }
        }
        return true;
    }

    @Override // okio.Sink
    /* renamed from: a */
    public Timeout mo2216a() {
        return Timeout.f10712c;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Buffer) {
            Buffer buffer = (Buffer) obj;
            long j = this.f10675b;
            if (j != buffer.f10675b) {
                return false;
            }
            long j2 = 0;
            if (j == 0) {
                return true;
            }
            Segment segment = this.f10674a;
            Segment segment2 = buffer.f10674a;
            int i = segment.f10704b;
            int i2 = segment2.f10704b;
            while (j2 < this.f10675b) {
                long min = Math.min(segment.f10705c - i, segment2.f10705c - i2);
                int i3 = i2;
                int i4 = i;
                int i5 = 0;
                while (i5 < min) {
                    int i6 = i4 + 1;
                    int i7 = i3 + 1;
                    if (segment.f10703a[i4] != segment2.f10703a[i3]) {
                        return false;
                    }
                    i5++;
                    i4 = i6;
                    i3 = i7;
                }
                if (i4 == segment.f10705c) {
                    segment = segment.f10708f;
                    i = segment.f10704b;
                } else {
                    i = i4;
                }
                if (i3 == segment2.f10705c) {
                    segment2 = segment2.f10708f;
                    i2 = segment2.f10704b;
                } else {
                    i2 = i3;
                }
                j2 += min;
            }
            return true;
        }
        return false;
    }

    public int hashCode() {
        Segment segment = this.f10674a;
        if (segment == null) {
            return 0;
        }
        int i = 1;
        do {
            int i2 = segment.f10705c;
            for (int i3 = segment.f10704b; i3 < i2; i3++) {
                i = (i * 31) + segment.f10703a[i3];
            }
            segment = segment.f10708f;
        } while (segment != this.f10674a);
        return i;
    }

    public String toString() {
        return m2280v().toString();
    }

    /* renamed from: u */
    public Buffer clone() {
        Buffer buffer = new Buffer();
        if (this.f10675b == 0) {
            return buffer;
        }
        buffer.f10674a = this.f10674a.m2224a();
        Segment segment = buffer.f10674a;
        segment.f10709g = segment;
        segment.f10708f = segment;
        Segment segment2 = this.f10674a;
        while (true) {
            segment2 = segment2.f10708f;
            if (segment2 != this.f10674a) {
                buffer.f10674a.f10709g.m2222a(segment2.m2224a());
            } else {
                buffer.f10675b = this.f10675b;
                return buffer;
            }
        }
    }

    /* renamed from: v */
    public ByteString m2280v() {
        long j = this.f10675b;
        if (j > 2147483647L) {
            throw new IllegalArgumentException("size > Integer.MAX_VALUE: " + this.f10675b);
        }
        return m2291f((int) j);
    }

    /* renamed from: f */
    public ByteString m2291f(int i) {
        if (i == 0) {
            return ByteString.EMPTY;
        }
        return new SegmentedByteString(this, i);
    }
}
