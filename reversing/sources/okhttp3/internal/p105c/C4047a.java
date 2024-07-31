package okhttp3.internal.p105c;

import android.support.p008v4.media.session.PlaybackStateCompat;
import java.io.EOFException;
import java.io.IOException;
import java.net.ProtocolException;
import java.util.concurrent.TimeUnit;
import okhttp3.C2984s;
import okhttp3.C2993z;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okhttp3.internal.C2930c;
import okhttp3.internal.Internal;
import okhttp3.internal.connection.RealConnection;
import okhttp3.internal.connection.StreamAllocation;
import okhttp3.internal.p104b.HttpCodec;
import okhttp3.internal.p104b.HttpHeaders;
import okhttp3.internal.p104b.RealResponseBody;
import okhttp3.internal.p104b.RequestLine;
import okhttp3.internal.p104b.StatusLine;
import okio.Buffer;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.ForwardingTimeout;
import okio.Okio;
import okio.Sink;
import okio.Source;
import okio.Timeout;

/* renamed from: okhttp3.internal.c.a */
/* loaded from: classes2.dex */
public final class Http1Codec implements HttpCodec {

    /* renamed from: a */
    final OkHttpClient f10200a;

    /* renamed from: b */
    final StreamAllocation f10201b;

    /* renamed from: c */
    final BufferedSource f10202c;

    /* renamed from: d */
    final BufferedSink f10203d;

    /* renamed from: e */
    int f10204e = 0;

    /* renamed from: f */
    private long f10205f = PlaybackStateCompat.ACTION_SET_REPEAT_MODE;

    public Http1Codec(OkHttpClient okHttpClient, StreamAllocation streamAllocation, BufferedSource bufferedSource, BufferedSink bufferedSink) {
        this.f10200a = okHttpClient;
        this.f10201b = streamAllocation;
        this.f10202c = bufferedSource;
        this.f10203d = bufferedSink;
    }

    @Override // okhttp3.internal.p104b.HttpCodec
    /* renamed from: a */
    public Sink mo2715a(C2993z c2993z, long j) {
        if ("chunked".equalsIgnoreCase(c2993z.m2349a("Transfer-Encoding"))) {
            return m2858e();
        }
        if (j != -1) {
            return m2864a(j);
        }
        throw new IllegalStateException("Cannot stream a request body without chunked encoding or a known content length!");
    }

    @Override // okhttp3.internal.p104b.HttpCodec
    /* renamed from: c */
    public void mo2711c() {
        RealConnection m2807c = this.f10201b.m2807c();
        if (m2807c != null) {
            m2807c.m2837c();
        }
    }

    @Override // okhttp3.internal.p104b.HttpCodec
    /* renamed from: a */
    public void mo2716a(C2993z c2993z) throws IOException {
        m2863a(c2993z.m2347c(), RequestLine.m2912a(c2993z, this.f10201b.m2807c().m2838b().m2997b().type()));
    }

    @Override // okhttp3.internal.p104b.HttpCodec
    /* renamed from: a */
    public ResponseBody mo2717a(Response response) throws IOException {
        this.f10201b.f10258c.m2516f(this.f10201b.f10257b);
        String m3033a = response.m3033a("Content-Type");
        if (!HttpHeaders.m2924b(response)) {
            return new RealResponseBody(m3033a, 0L, Okio.m2263a(m2860b(0L)));
        }
        if ("chunked".equalsIgnoreCase(response.m3033a("Transfer-Encoding"))) {
            return new RealResponseBody(m3033a, -1L, Okio.m2263a(m2862a(response.m3034a().m2350a())));
        }
        long m2928a = HttpHeaders.m2928a(response);
        if (m2928a != -1) {
            return new RealResponseBody(m3033a, m2928a, Okio.m2263a(m2860b(m2928a)));
        }
        return new RealResponseBody(m3033a, -1L, Okio.m2263a(m2857f()));
    }

    @Override // okhttp3.internal.p104b.HttpCodec
    /* renamed from: a */
    public void mo2719a() throws IOException {
        this.f10203d.flush();
    }

    @Override // okhttp3.internal.p104b.HttpCodec
    /* renamed from: b */
    public void mo2713b() throws IOException {
        this.f10203d.flush();
    }

    /* renamed from: a */
    public void m2863a(C2984s c2984s, String str) throws IOException {
        if (this.f10204e != 0) {
            throw new IllegalStateException("state: " + this.f10204e);
        }
        this.f10203d.mo2257b(str).mo2257b("\r\n");
        int m2502a = c2984s.m2502a();
        for (int i = 0; i < m2502a; i++) {
            this.f10203d.mo2257b(c2984s.m2501a(i)).mo2257b(": ").mo2257b(c2984s.m2496b(i)).mo2257b("\r\n");
        }
        this.f10203d.mo2257b("\r\n");
        this.f10204e = 1;
    }

    @Override // okhttp3.internal.p104b.HttpCodec
    /* renamed from: a */
    public Response.C2912a mo2714a(boolean z) throws IOException {
        int i = this.f10204e;
        if (i != 1 && i != 3) {
            throw new IllegalStateException("state: " + this.f10204e);
        }
        try {
            StatusLine m2901a = StatusLine.m2901a(m2856g());
            Response.C2912a m3010a = new Response.C2912a().m3014a(m2901a.f10176a).m3019a(m2901a.f10177b).m3017a(m2901a.f10178c).m3010a(m2859d());
            if (z && m2901a.f10177b == 100) {
                return null;
            }
            if (m2901a.f10177b == 100) {
                this.f10204e = 3;
                return m3010a;
            }
            this.f10204e = 4;
            return m3010a;
        } catch (EOFException e) {
            IOException iOException = new IOException("unexpected end of stream on " + this.f10201b);
            iOException.initCause(e);
            throw iOException;
        }
    }

    /* renamed from: g */
    private String m2856g() throws IOException {
        String mo2235f = this.f10202c.mo2235f(this.f10205f);
        this.f10205f -= mo2235f.length();
        return mo2235f;
    }

    /* renamed from: d */
    public C2984s m2859d() throws IOException {
        C2984s.C2985a c2985a = new C2984s.C2985a();
        while (true) {
            String m2856g = m2856g();
            if (m2856g.length() != 0) {
                Internal.f10101a.mo2375a(c2985a, m2856g);
            } else {
                return c2985a.m2494a();
            }
        }
    }

    /* renamed from: e */
    public Sink m2858e() {
        if (this.f10204e != 1) {
            throw new IllegalStateException("state: " + this.f10204e);
        }
        this.f10204e = 2;
        return new C2935b();
    }

    /* renamed from: a */
    public Sink m2864a(long j) {
        if (this.f10204e != 1) {
            throw new IllegalStateException("state: " + this.f10204e);
        }
        this.f10204e = 2;
        return new C2937d(j);
    }

    /* renamed from: b */
    public Source m2860b(long j) throws IOException {
        if (this.f10204e != 4) {
            throw new IllegalStateException("state: " + this.f10204e);
        }
        this.f10204e = 5;
        return new C2938e(j);
    }

    /* renamed from: a */
    public Source m2862a(HttpUrl httpUrl) throws IOException {
        if (this.f10204e != 4) {
            throw new IllegalStateException("state: " + this.f10204e);
        }
        this.f10204e = 5;
        return new C2936c(httpUrl);
    }

    /* renamed from: f */
    public Source m2857f() throws IOException {
        if (this.f10204e != 4) {
            throw new IllegalStateException("state: " + this.f10204e);
        }
        StreamAllocation streamAllocation = this.f10201b;
        if (streamAllocation == null) {
            throw new IllegalStateException("streamAllocation == null");
        }
        this.f10204e = 5;
        streamAllocation.m2805e();
        return new C2939f();
    }

    /* renamed from: a */
    void m2861a(ForwardingTimeout forwardingTimeout) {
        Timeout m2278a = forwardingTimeout.m2278a();
        forwardingTimeout.m2277a(Timeout.f10712c);
        m2278a.mo2212f();
        m2278a.mo2209j_();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Http1Codec.java */
    /* renamed from: okhttp3.internal.c.a$d */
    /* loaded from: classes2.dex */
    public final class C2937d implements Sink {

        /* renamed from: b */
        private final ForwardingTimeout f10218b;

        /* renamed from: c */
        private boolean f10219c;

        /* renamed from: d */
        private long f10220d;

        C2937d(long j) {
            this.f10218b = new ForwardingTimeout(Http1Codec.this.f10203d.mo2216a());
            this.f10220d = j;
        }

        @Override // okio.Sink
        /* renamed from: a */
        public Timeout mo2216a() {
            return this.f10218b;
        }

        @Override // okio.Sink
        /* renamed from: a_ */
        public void mo2215a_(Buffer buffer, long j) throws IOException {
            if (this.f10219c) {
                throw new IllegalStateException("closed");
            }
            C2930c.m2898a(buffer.m2302b(), 0L, j);
            if (j > this.f10220d) {
                throw new ProtocolException("expected " + this.f10220d + " bytes but received " + j);
            }
            Http1Codec.this.f10203d.mo2215a_(buffer, j);
            this.f10220d -= j;
        }

        @Override // okio.Sink, java.io.Flushable
        public void flush() throws IOException {
            if (this.f10219c) {
                return;
            }
            Http1Codec.this.f10203d.flush();
        }

        @Override // okio.Sink, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            if (this.f10219c) {
                return;
            }
            this.f10219c = true;
            if (this.f10220d > 0) {
                throw new ProtocolException("unexpected end of stream");
            }
            Http1Codec.this.m2861a(this.f10218b);
            Http1Codec.this.f10204e = 3;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Http1Codec.java */
    /* renamed from: okhttp3.internal.c.a$b */
    /* loaded from: classes2.dex */
    public final class C2935b implements Sink {

        /* renamed from: b */
        private final ForwardingTimeout f10211b;

        /* renamed from: c */
        private boolean f10212c;

        C2935b() {
            this.f10211b = new ForwardingTimeout(Http1Codec.this.f10203d.mo2216a());
        }

        @Override // okio.Sink
        /* renamed from: a */
        public Timeout mo2216a() {
            return this.f10211b;
        }

        @Override // okio.Sink
        /* renamed from: a_ */
        public void mo2215a_(Buffer buffer, long j) throws IOException {
            if (this.f10212c) {
                throw new IllegalStateException("closed");
            }
            if (j == 0) {
                return;
            }
            Http1Codec.this.f10203d.mo2250l(j);
            Http1Codec.this.f10203d.mo2257b("\r\n");
            Http1Codec.this.f10203d.mo2215a_(buffer, j);
            Http1Codec.this.f10203d.mo2257b("\r\n");
        }

        @Override // okio.Sink, java.io.Flushable
        public synchronized void flush() throws IOException {
            if (this.f10212c) {
                return;
            }
            Http1Codec.this.f10203d.flush();
        }

        @Override // okio.Sink, java.io.Closeable, java.lang.AutoCloseable
        public synchronized void close() throws IOException {
            if (this.f10212c) {
                return;
            }
            this.f10212c = true;
            Http1Codec.this.f10203d.mo2257b("0\r\n\r\n");
            Http1Codec.this.m2861a(this.f10211b);
            Http1Codec.this.f10204e = 3;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Http1Codec.java */
    /* renamed from: okhttp3.internal.c.a$a */
    /* loaded from: classes2.dex */
    public abstract class AbstractC2934a implements Source {

        /* renamed from: a */
        protected final ForwardingTimeout f10206a;

        /* renamed from: b */
        protected boolean f10207b;

        /* renamed from: c */
        protected long f10208c;

        private AbstractC2934a() {
            this.f10206a = new ForwardingTimeout(Http1Codec.this.f10202c.mo2214a());
            this.f10208c = 0L;
        }

        @Override // okio.Source
        /* renamed from: a */
        public Timeout mo2214a() {
            return this.f10206a;
        }

        @Override // okio.Source
        /* renamed from: a */
        public long mo130a(Buffer buffer, long j) throws IOException {
            try {
                long a = Http1Codec.this.f10202c.mo130a(buffer, j);
                if (a > 0) {
                    this.f10208c += a;
                }
                return a;
            } catch (IOException e) {
                m2855a(false, e);
                throw e;
            }
        }

        /* renamed from: a */
        protected final void m2855a(boolean z, IOException iOException) throws IOException {
            if (Http1Codec.this.f10204e == 6) {
                return;
            }
            if (Http1Codec.this.f10204e != 5) {
                throw new IllegalStateException("state: " + Http1Codec.this.f10204e);
            }
            Http1Codec.this.m2861a(this.f10206a);
            Http1Codec http1Codec = Http1Codec.this;
            http1Codec.f10204e = 6;
            if (http1Codec.f10201b != null) {
                Http1Codec.this.f10201b.m2811a(!z, Http1Codec.this, this.f10208c, iOException);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Http1Codec.java */
    /* renamed from: okhttp3.internal.c.a$e */
    /* loaded from: classes2.dex */
    public class C2938e extends AbstractC2934a {

        /* renamed from: f */
        private long f10222f;

        C2938e(long j) throws IOException {
            super();
            this.f10222f = j;
            if (this.f10222f == 0) {
                m2855a(true, (IOException) null);
            }
        }

        @Override // okhttp3.internal.p105c.Http1Codec.AbstractC2934a, okio.Source
        /* renamed from: a */
        public long mo130a(Buffer buffer, long j) throws IOException {
            if (j < 0) {
                throw new IllegalArgumentException("byteCount < 0: " + j);
            } else if (this.f10207b) {
                throw new IllegalStateException("closed");
            } else {
                long j2 = this.f10222f;
                if (j2 == 0) {
                    return -1L;
                }
                long mo130a = super.mo130a(buffer, Math.min(j2, j));
                if (mo130a == -1) {
                    ProtocolException protocolException = new ProtocolException("unexpected end of stream");
                    m2855a(false, (IOException) protocolException);
                    throw protocolException;
                }
                this.f10222f -= mo130a;
                if (this.f10222f == 0) {
                    m2855a(true, (IOException) null);
                }
                return mo130a;
            }
        }

        @Override // okio.Source, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            if (this.f10207b) {
                return;
            }
            if (this.f10222f != 0 && !C2930c.m2877a(this, 100, TimeUnit.MILLISECONDS)) {
                m2855a(false, (IOException) null);
            }
            this.f10207b = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Http1Codec.java */
    /* renamed from: okhttp3.internal.c.a$c */
    /* loaded from: classes2.dex */
    public class C2936c extends AbstractC2934a {

        /* renamed from: f */
        private final HttpUrl f10214f;

        /* renamed from: g */
        private long f10215g;

        /* renamed from: h */
        private boolean f10216h;

        C2936c(HttpUrl httpUrl) {
            super();
            this.f10215g = -1L;
            this.f10216h = true;
            this.f10214f = httpUrl;
        }

        @Override // okhttp3.internal.p105c.Http1Codec.AbstractC2934a, okio.Source
        /* renamed from: a */
        public long mo130a(Buffer buffer, long j) throws IOException {
            if (j < 0) {
                throw new IllegalArgumentException("byteCount < 0: " + j);
            } else if (this.f10207b) {
                throw new IllegalStateException("closed");
            } else {
                if (this.f10216h) {
                    long j2 = this.f10215g;
                    if (j2 == 0 || j2 == -1) {
                        m2854b();
                        if (!this.f10216h) {
                            return -1L;
                        }
                    }
                    long mo130a = super.mo130a(buffer, Math.min(j, this.f10215g));
                    if (mo130a == -1) {
                        ProtocolException protocolException = new ProtocolException("unexpected end of stream");
                        m2855a(false, (IOException) protocolException);
                        throw protocolException;
                    }
                    this.f10215g -= mo130a;
                    return mo130a;
                }
                return -1L;
            }
        }

        /* renamed from: b */
        private void m2854b() throws IOException {
            if (this.f10215g != -1) {
                Http1Codec.this.f10202c.mo2225q();
            }
            try {
                this.f10215g = Http1Codec.this.f10202c.mo2226n();
                String trim = Http1Codec.this.f10202c.mo2225q().trim();
                if (this.f10215g < 0 || (!trim.isEmpty() && !trim.startsWith(";"))) {
                    throw new ProtocolException("expected chunk size and optional extensions but was \"" + this.f10215g + trim + "\"");
                } else if (this.f10215g == 0) {
                    this.f10216h = false;
                    HttpHeaders.m2927a(Http1Codec.this.f10200a.m2401g(), this.f10214f, Http1Codec.this.m2859d());
                    m2855a(true, (IOException) null);
                }
            } catch (NumberFormatException e) {
                throw new ProtocolException(e.getMessage());
            }
        }

        @Override // okio.Source, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            if (this.f10207b) {
                return;
            }
            if (this.f10216h && !C2930c.m2877a(this, 100, TimeUnit.MILLISECONDS)) {
                m2855a(false, (IOException) null);
            }
            this.f10207b = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Http1Codec.java */
    /* renamed from: okhttp3.internal.c.a$f */
    /* loaded from: classes2.dex */
    public class C2939f extends AbstractC2934a {

        /* renamed from: f */
        private boolean f10224f;

        C2939f() {
            super();
        }

        @Override // okhttp3.internal.p105c.Http1Codec.AbstractC2934a, okio.Source
        /* renamed from: a */
        public long mo130a(Buffer buffer, long j) throws IOException {
            if (j < 0) {
                throw new IllegalArgumentException("byteCount < 0: " + j);
            } else if (this.f10207b) {
                throw new IllegalStateException("closed");
            } else {
                if (this.f10224f) {
                    return -1L;
                }
                long mo130a = super.mo130a(buffer, j);
                if (mo130a == -1) {
                    this.f10224f = true;
                    m2855a(true, (IOException) null);
                    return -1L;
                }
                return mo130a;
            }
        }

        @Override // okio.Source, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            if (this.f10207b) {
                return;
            }
            if (!this.f10224f) {
                m2855a(false, (IOException) null);
            }
            this.f10207b = true;
        }
    }
}
