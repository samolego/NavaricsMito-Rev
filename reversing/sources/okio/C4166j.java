package okio;

import java.io.EOFException;
import java.io.IOException;
import java.util.zip.DataFormatException;
import java.util.zip.Inflater;
import org.apache.log4j.spi.LocationInfo;

/* renamed from: okio.j */
/* loaded from: classes2.dex */
public final class InflaterSource implements Source {

    /* renamed from: a */
    private final BufferedSource f10686a;

    /* renamed from: b */
    private final Inflater f10687b;

    /* renamed from: c */
    private int f10688c;

    /* renamed from: d */
    private boolean f10689d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public InflaterSource(BufferedSource bufferedSource, Inflater inflater) {
        if (bufferedSource == null) {
            throw new IllegalArgumentException("source == null");
        }
        if (inflater == null) {
            throw new IllegalArgumentException("inflater == null");
        }
        this.f10686a = bufferedSource;
        this.f10687b = inflater;
    }

    @Override // okio.Source
    /* renamed from: a */
    public long mo130a(Buffer buffer, long j) throws IOException {
        Segment m2293e;
        int i = (j > 0L ? 1 : (j == 0L ? 0 : -1));
        if (i < 0) {
            throw new IllegalArgumentException("byteCount < 0: " + j);
        } else if (this.f10689d) {
            throw new IllegalStateException("closed");
        } else {
            if (i == 0) {
                return 0L;
            }
            while (true) {
                boolean m2272b = m2272b();
                try {
                    m2293e = buffer.m2293e(1);
                    int inflate = this.f10687b.inflate(m2293e.f10703a, m2293e.f10705c, (int) Math.min(j, 8192 - m2293e.f10705c));
                    if (inflate > 0) {
                        m2293e.f10705c += inflate;
                        long j2 = inflate;
                        buffer.f10675b += j2;
                        return j2;
                    } else if (this.f10687b.finished() || this.f10687b.needsDictionary()) {
                        break;
                    } else if (m2272b) {
                        throw new EOFException("source exhausted prematurely");
                    }
                } catch (DataFormatException e) {
                    throw new IOException(e);
                }
            }
            m2271c();
            if (m2293e.f10704b == m2293e.f10705c) {
                buffer.f10674a = m2293e.m2220b();
                SegmentPool.m2217a(m2293e);
                return -1L;
            }
            return -1L;
        }
    }

    /* renamed from: b */
    public boolean m2272b() throws IOException {
        if (this.f10687b.needsInput()) {
            m2271c();
            if (this.f10687b.getRemaining() != 0) {
                throw new IllegalStateException(LocationInfo.f11272NA);
            }
            if (this.f10686a.mo2236f()) {
                return true;
            }
            Segment segment = this.f10686a.mo2238c().f10674a;
            this.f10688c = segment.f10705c - segment.f10704b;
            this.f10687b.setInput(segment.f10703a, segment.f10704b, this.f10688c);
            return false;
        }
        return false;
    }

    /* renamed from: c */
    private void m2271c() throws IOException {
        int i = this.f10688c;
        if (i == 0) {
            return;
        }
        int remaining = i - this.f10687b.getRemaining();
        this.f10688c -= remaining;
        this.f10686a.mo2231i(remaining);
    }

    @Override // okio.Source
    /* renamed from: a */
    public Timeout mo2214a() {
        return this.f10686a.mo2214a();
    }

    @Override // okio.Source, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (this.f10689d) {
            return;
        }
        this.f10687b.end();
        this.f10689d = true;
        this.f10686a.close();
    }
}
