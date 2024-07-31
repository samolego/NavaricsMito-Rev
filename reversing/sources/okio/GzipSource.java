package okio;

import java.io.EOFException;
import java.io.IOException;
import java.util.zip.CRC32;
import java.util.zip.Inflater;

/* renamed from: okio.i */
/* loaded from: classes2.dex */
public final class GzipSource implements Source {

    /* renamed from: b */
    private final BufferedSource f10682b;

    /* renamed from: c */
    private final Inflater f10683c;

    /* renamed from: d */
    private final InflaterSource f10684d;

    /* renamed from: a */
    private int f10681a = 0;

    /* renamed from: e */
    private final CRC32 f10685e = new CRC32();

    public GzipSource(Source source) {
        if (source == null) {
            throw new IllegalArgumentException("source == null");
        }
        this.f10683c = new Inflater(true);
        this.f10682b = Okio.m2263a(source);
        this.f10684d = new InflaterSource(this.f10682b, this.f10683c);
    }

    @Override // okio.Source
    /* renamed from: a */
    public long mo130a(Buffer buffer, long j) throws IOException {
        int i = (j > 0L ? 1 : (j == 0L ? 0 : -1));
        if (i < 0) {
            throw new IllegalArgumentException("byteCount < 0: " + j);
        } else if (i == 0) {
            return 0L;
        } else {
            if (this.f10681a == 0) {
                m2274b();
                this.f10681a = 1;
            }
            if (this.f10681a == 1) {
                long j2 = buffer.f10675b;
                long mo130a = this.f10684d.mo130a(buffer, j);
                if (mo130a != -1) {
                    m2275a(buffer, j2, mo130a);
                    return mo130a;
                }
                this.f10681a = 2;
            }
            if (this.f10681a == 2) {
                m2273c();
                this.f10681a = 3;
                if (!this.f10682b.mo2236f()) {
                    throw new IOException("gzip finished without exhausting source");
                }
            }
            return -1L;
        }
    }

    /* renamed from: b */
    private void m2274b() throws IOException {
        this.f10682b.mo2245a(10L);
        byte m2297c = this.f10682b.mo2238c().m2297c(3L);
        boolean z = ((m2297c >> 1) & 1) == 1;
        if (z) {
            m2275a(this.f10682b.mo2238c(), 0L, 10L);
        }
        m2276a("ID1ID2", 8075, this.f10682b.mo2230j());
        this.f10682b.mo2231i(8L);
        if (((m2297c >> 2) & 1) == 1) {
            this.f10682b.mo2245a(2L);
            if (z) {
                m2275a(this.f10682b.mo2238c(), 0L, 2L);
            }
            long mo2228l = this.f10682b.mo2238c().mo2228l();
            this.f10682b.mo2245a(mo2228l);
            if (z) {
                m2275a(this.f10682b.mo2238c(), 0L, mo2228l);
            }
            this.f10682b.mo2231i(mo2228l);
        }
        if (((m2297c >> 3) & 1) == 1) {
            long mo2247a = this.f10682b.mo2247a((byte) 0);
            if (mo2247a == -1) {
                throw new EOFException();
            }
            if (z) {
                m2275a(this.f10682b.mo2238c(), 0L, mo2247a + 1);
            }
            this.f10682b.mo2231i(mo2247a + 1);
        }
        if (((m2297c >> 4) & 1) == 1) {
            long mo2247a2 = this.f10682b.mo2247a((byte) 0);
            if (mo2247a2 == -1) {
                throw new EOFException();
            }
            if (z) {
                m2275a(this.f10682b.mo2238c(), 0L, mo2247a2 + 1);
            }
            this.f10682b.mo2231i(mo2247a2 + 1);
        }
        if (z) {
            m2276a("FHCRC", this.f10682b.mo2228l(), (short) this.f10685e.getValue());
            this.f10685e.reset();
        }
    }

    /* renamed from: c */
    private void m2273c() throws IOException {
        m2276a("CRC", this.f10682b.mo2227m(), (int) this.f10685e.getValue());
        m2276a("ISIZE", this.f10682b.mo2227m(), (int) this.f10683c.getBytesWritten());
    }

    @Override // okio.Source
    /* renamed from: a */
    public Timeout mo2214a() {
        return this.f10682b.mo2214a();
    }

    @Override // okio.Source, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.f10684d.close();
    }

    /* renamed from: a */
    private void m2275a(Buffer buffer, long j, long j2) {
        int i;
        Segment segment = buffer.f10674a;
        while (j >= segment.f10705c - segment.f10704b) {
            j -= segment.f10705c - segment.f10704b;
            segment = segment.f10708f;
        }
        while (j2 > 0) {
            int min = (int) Math.min(segment.f10705c - i, j2);
            this.f10685e.update(segment.f10703a, (int) (segment.f10704b + j), min);
            j2 -= min;
            segment = segment.f10708f;
            j = 0;
        }
    }

    /* renamed from: a */
    private void m2276a(String str, int i, int i2) throws IOException {
        if (i2 != i) {
            throw new IOException(String.format("%s: actual 0x%08x != expected 0x%08x", str, Integer.valueOf(i2), Integer.valueOf(i)));
        }
    }
}
