package okhttp3.internal.http2;

import java.io.IOException;
import java.net.ProtocolException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import okhttp3.C2984s;
import okhttp3.C2993z;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Protocol;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okhttp3.internal.C2930c;
import okhttp3.internal.Internal;
import okhttp3.internal.connection.StreamAllocation;
import okhttp3.internal.p104b.HttpCodec;
import okhttp3.internal.p104b.HttpHeaders;
import okhttp3.internal.p104b.RealResponseBody;
import okhttp3.internal.p104b.RequestLine;
import okhttp3.internal.p104b.StatusLine;
import okio.Buffer;
import okio.ByteString;
import okio.ForwardingSource;
import okio.Okio;
import okio.Sink;
import okio.Source;

/* renamed from: okhttp3.internal.http2.d */
/* loaded from: classes2.dex */
public final class Http2Codec implements HttpCodec {

    /* renamed from: b */
    private static final ByteString f10337b = ByteString.encodeUtf8("connection");

    /* renamed from: c */
    private static final ByteString f10338c = ByteString.encodeUtf8("host");

    /* renamed from: d */
    private static final ByteString f10339d = ByteString.encodeUtf8("keep-alive");

    /* renamed from: e */
    private static final ByteString f10340e = ByteString.encodeUtf8("proxy-connection");

    /* renamed from: f */
    private static final ByteString f10341f = ByteString.encodeUtf8("transfer-encoding");

    /* renamed from: g */
    private static final ByteString f10342g = ByteString.encodeUtf8("te");

    /* renamed from: h */
    private static final ByteString f10343h = ByteString.encodeUtf8("encoding");

    /* renamed from: i */
    private static final ByteString f10344i = ByteString.encodeUtf8("upgrade");

    /* renamed from: j */
    private static final List<ByteString> f10345j = C2930c.m2875a(f10337b, f10338c, f10339d, f10340e, f10342g, f10341f, f10343h, f10344i, Header.f10306c, Header.f10307d, Header.f10308e, Header.f10309f);

    /* renamed from: k */
    private static final List<ByteString> f10346k = C2930c.m2875a(f10337b, f10338c, f10339d, f10340e, f10342g, f10341f, f10343h, f10344i);

    /* renamed from: a */
    final StreamAllocation f10347a;

    /* renamed from: l */
    private final Interceptor.InterfaceC2987a f10348l;

    /* renamed from: m */
    private final Http2Connection f10349m;

    /* renamed from: n */
    private Http2Stream f10350n;

    /* renamed from: o */
    private final Protocol f10351o;

    public Http2Codec(OkHttpClient okHttpClient, Interceptor.InterfaceC2987a interfaceC2987a, StreamAllocation streamAllocation, Http2Connection http2Connection) {
        Protocol protocol;
        this.f10348l = interfaceC2987a;
        this.f10347a = streamAllocation;
        this.f10349m = http2Connection;
        if (okHttpClient.m2387u().contains(Protocol.H2_PRIOR_KNOWLEDGE)) {
            protocol = Protocol.H2_PRIOR_KNOWLEDGE;
        } else {
            protocol = Protocol.HTTP_2;
        }
        this.f10351o = protocol;
    }

    @Override // okhttp3.internal.p104b.HttpCodec
    /* renamed from: a */
    public Sink mo2715a(C2993z c2993z, long j) {
        return this.f10350n.m2634h();
    }

    @Override // okhttp3.internal.p104b.HttpCodec
    /* renamed from: a */
    public void mo2716a(C2993z c2993z) throws IOException {
        if (this.f10350n != null) {
            return;
        }
        this.f10350n = this.f10349m.m2700a(m2712b(c2993z), c2993z.m2346d() != null);
        this.f10350n.m2637e().mo2207a(this.f10348l.mo2424d(), TimeUnit.MILLISECONDS);
        this.f10350n.m2636f().mo2207a(this.f10348l.mo2423e(), TimeUnit.MILLISECONDS);
    }

    @Override // okhttp3.internal.p104b.HttpCodec
    /* renamed from: a */
    public void mo2719a() throws IOException {
        this.f10349m.m2692b();
    }

    @Override // okhttp3.internal.p104b.HttpCodec
    /* renamed from: b */
    public void mo2713b() throws IOException {
        this.f10350n.m2634h().close();
    }

    @Override // okhttp3.internal.p104b.HttpCodec
    /* renamed from: a */
    public Response.C2912a mo2714a(boolean z) throws IOException {
        Response.C2912a m2718a = m2718a(this.f10350n.m2639d(), this.f10351o);
        if (z && Internal.f10101a.mo2381a(m2718a) == 100) {
            return null;
        }
        return m2718a;
    }

    /* renamed from: b */
    public static List<Header> m2712b(C2993z c2993z) {
        C2984s m2347c = c2993z.m2347c();
        ArrayList arrayList = new ArrayList(m2347c.m2502a() + 4);
        arrayList.add(new Header(Header.f10306c, c2993z.m2348b()));
        arrayList.add(new Header(Header.f10307d, RequestLine.m2913a(c2993z.m2350a())));
        String m2349a = c2993z.m2349a("Host");
        if (m2349a != null) {
            arrayList.add(new Header(Header.f10309f, m2349a));
        }
        arrayList.add(new Header(Header.f10308e, c2993z.m2350a().m2474b()));
        int m2502a = m2347c.m2502a();
        for (int i = 0; i < m2502a; i++) {
            ByteString encodeUtf8 = ByteString.encodeUtf8(m2347c.m2501a(i).toLowerCase(Locale.US));
            if (!f10345j.contains(encodeUtf8)) {
                arrayList.add(new Header(encodeUtf8, m2347c.m2496b(i)));
            }
        }
        return arrayList;
    }

    /* renamed from: a */
    public static Response.C2912a m2718a(List<Header> list, Protocol protocol) throws IOException {
        C2984s.C2985a c2985a = new C2984s.C2985a();
        int size = list.size();
        C2984s.C2985a c2985a2 = c2985a;
        StatusLine statusLine = null;
        for (int i = 0; i < size; i++) {
            Header header = list.get(i);
            if (header == null) {
                if (statusLine != null && statusLine.f10177b == 100) {
                    c2985a2 = new C2984s.C2985a();
                    statusLine = null;
                }
            } else {
                ByteString byteString = header.f10310g;
                String utf8 = header.f10311h.utf8();
                if (byteString.equals(Header.f10305b)) {
                    statusLine = StatusLine.m2901a("HTTP/1.1 " + utf8);
                } else if (!f10346k.contains(byteString)) {
                    Internal.f10101a.mo2374a(c2985a2, byteString.utf8(), utf8);
                }
            }
        }
        if (statusLine == null) {
            throw new ProtocolException("Expected ':status' header not present");
        }
        return new Response.C2912a().m3014a(protocol).m3019a(statusLine.f10177b).m3017a(statusLine.f10178c).m3010a(c2985a2.m2494a());
    }

    @Override // okhttp3.internal.p104b.HttpCodec
    /* renamed from: a */
    public ResponseBody mo2717a(Response response) throws IOException {
        this.f10347a.f10258c.m2516f(this.f10347a.f10257b);
        return new RealResponseBody(response.m3033a("Content-Type"), HttpHeaders.m2928a(response), Okio.m2263a(new C2950a(this.f10350n.m2635g())));
    }

    @Override // okhttp3.internal.p104b.HttpCodec
    /* renamed from: c */
    public void mo2711c() {
        Http2Stream http2Stream = this.f10350n;
        if (http2Stream != null) {
            http2Stream.m2642b(ErrorCode.CANCEL);
        }
    }

    /* compiled from: Http2Codec.java */
    /* renamed from: okhttp3.internal.http2.d$a */
    /* loaded from: classes2.dex */
    class C2950a extends ForwardingSource {

        /* renamed from: a */
        boolean f10352a;

        /* renamed from: b */
        long f10353b;

        C2950a(Source source) {
            super(source);
            this.f10352a = false;
            this.f10353b = 0L;
        }

        @Override // okio.ForwardingSource, okio.Source
        /* renamed from: a */
        public long mo130a(Buffer buffer, long j) throws IOException {
            try {
                long mo130a = m2279b().mo130a(buffer, j);
                if (mo130a > 0) {
                    this.f10353b += mo130a;
                }
                return mo130a;
            } catch (IOException e) {
                m2710a(e);
                throw e;
            }
        }

        @Override // okio.ForwardingSource, okio.Source, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            super.close();
            m2710a(null);
        }

        /* renamed from: a */
        private void m2710a(IOException iOException) {
            if (this.f10352a) {
                return;
            }
            this.f10352a = true;
            Http2Codec.this.f10347a.m2811a(false, Http2Codec.this, this.f10353b, iOException);
        }
    }
}
