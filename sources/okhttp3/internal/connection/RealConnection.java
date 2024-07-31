package okhttp3.internal.connection;

import java.io.IOException;
import java.lang.ref.Reference;
import java.net.ConnectException;
import java.net.Proxy;
import java.net.Socket;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocket;
import okhttp3.Address;
import okhttp3.C2993z;
import okhttp3.Call;
import okhttp3.CertificatePinner;
import okhttp3.Connection;
import okhttp3.ConnectionPool;
import okhttp3.ConnectionSpec;
import okhttp3.EventListener;
import okhttp3.Handshake;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Protocol;
import okhttp3.Response;
import okhttp3.Route;
import okhttp3.internal.C2930c;
import okhttp3.internal.C2942d;
import okhttp3.internal.Internal;
import okhttp3.internal.http2.ErrorCode;
import okhttp3.internal.http2.Http2Codec;
import okhttp3.internal.http2.Http2Connection;
import okhttp3.internal.http2.Http2Stream;
import okhttp3.internal.p104b.HttpCodec;
import okhttp3.internal.p104b.HttpHeaders;
import okhttp3.internal.p105c.Http1Codec;
import okhttp3.internal.p107e.Platform;
import okhttp3.internal.p108f.OkHostnameVerifier;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.Okio;
import okio.Source;

/* renamed from: okhttp3.internal.connection.c */
/* loaded from: classes2.dex */
public final class RealConnection extends Http2Connection.AbstractC2958b implements Connection {

    /* renamed from: a */
    public boolean f10230a;

    /* renamed from: b */
    public int f10231b;

    /* renamed from: c */
    public int f10232c = 1;

    /* renamed from: d */
    public final List<Reference<StreamAllocation>> f10233d = new ArrayList();

    /* renamed from: e */
    public long f10234e = Long.MAX_VALUE;

    /* renamed from: g */
    private final ConnectionPool f10235g;

    /* renamed from: h */
    private final Route f10236h;

    /* renamed from: i */
    private Socket f10237i;

    /* renamed from: j */
    private Socket f10238j;

    /* renamed from: k */
    private Handshake f10239k;

    /* renamed from: l */
    private Protocol f10240l;

    /* renamed from: m */
    private Http2Connection f10241m;

    /* renamed from: n */
    private BufferedSource f10242n;

    /* renamed from: o */
    private BufferedSink f10243o;

    public RealConnection(ConnectionPool connectionPool, Route route) {
        this.f10235g = connectionPool;
        this.f10236h = route;
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0090 A[Catch: IOException -> 0x00fb, TRY_LEAVE, TryCatch #3 {IOException -> 0x00fb, blocks: (B:18:0x0088, B:20:0x0090), top: B:72:0x0088 }] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x00ab  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00d0  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00e6  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00f6 A[ORIG_RETURN, RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0131  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0138  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x0145 A[EDGE_INSN: B:77:0x0145->B:61:0x0145 ?: BREAK  ] */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void m2848a(int r17, int r18, int r19, int r20, boolean r21, okhttp3.Call r22, okhttp3.EventListener r23) {
        /*
            Method dump skipped, instructions count: 347
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.connection.RealConnection.m2848a(int, int, int, int, boolean, okhttp3.e, okhttp3.p):void");
    }

    /* renamed from: a */
    private void m2847a(int i, int i2, int i3, Call call, EventListener eventListener) throws IOException {
        C2993z m2833g = m2833g();
        HttpUrl m2350a = m2833g.m2350a();
        for (int i4 = 0; i4 < 21; i4++) {
            m2846a(i, i2, call, eventListener);
            m2833g = m2845a(i2, i3, m2833g, m2350a);
            if (m2833g == null) {
                return;
            }
            C2930c.m2884a(this.f10237i);
            this.f10237i = null;
            this.f10243o = null;
            this.f10242n = null;
            eventListener.m2529a(call, this.f10236h.m2996c(), this.f10236h.m2997b(), null);
        }
    }

    /* renamed from: a */
    private void m2846a(int i, int i2, Call call, EventListener eventListener) throws IOException {
        Socket createSocket;
        Proxy m2997b = this.f10236h.m2997b();
        Address m2998a = this.f10236h.m2998a();
        if (m2997b.type() == Proxy.Type.DIRECT || m2997b.type() == Proxy.Type.HTTP) {
            createSocket = m2998a.m3048c().createSocket();
        } else {
            createSocket = new Socket(m2997b);
        }
        this.f10237i = createSocket;
        eventListener.m2530a(call, this.f10236h.m2996c(), m2997b);
        this.f10237i.setSoTimeout(i2);
        try {
            Platform.m2762c().mo2773a(this.f10237i, this.f10236h.m2996c(), i);
            try {
                this.f10242n = Okio.m2263a(Okio.m2262b(this.f10237i));
                this.f10243o = Okio.m2264a(Okio.m2265a(this.f10237i));
            } catch (NullPointerException e) {
                if ("throw with null exception".equals(e.getMessage())) {
                    throw new IOException(e);
                }
            }
        } catch (ConnectException e2) {
            ConnectException connectException = new ConnectException("Failed to connect to " + this.f10236h.m2996c());
            connectException.initCause(e2);
            throw connectException;
        }
    }

    /* renamed from: a */
    private void m2842a(ConnectionSpecSelector connectionSpecSelector, int i, Call call, EventListener eventListener) throws IOException {
        if (this.f10236h.m2998a().m3042i() == null) {
            if (this.f10236h.m2998a().m3046e().contains(Protocol.H2_PRIOR_KNOWLEDGE)) {
                this.f10238j = this.f10237i;
                this.f10240l = Protocol.H2_PRIOR_KNOWLEDGE;
                m2849a(i);
                return;
            }
            this.f10238j = this.f10237i;
            this.f10240l = Protocol.HTTP_1_1;
            return;
        }
        eventListener.m2522b(call);
        m2843a(connectionSpecSelector);
        eventListener.m2525a(call, this.f10239k);
        if (this.f10240l == Protocol.HTTP_2) {
            m2849a(i);
        }
    }

    /* renamed from: a */
    private void m2849a(int i) throws IOException {
        this.f10238j.setSoTimeout(0);
        this.f10241m = new Http2Connection.C2957a(true).m2679a(this.f10238j, this.f10236h.m2998a().m3051a().m2464f(), this.f10242n, this.f10243o).m2678a(this).m2680a(i).m2681a();
        this.f10241m.m2687c();
    }

    /* renamed from: a */
    private void m2843a(ConnectionSpecSelector connectionSpecSelector) throws IOException {
        SSLSocket sSLSocket;
        Protocol protocol;
        Address m2998a = this.f10236h.m2998a();
        try {
            try {
                sSLSocket = (SSLSocket) m2998a.m3042i().createSocket(this.f10237i, m2998a.m3051a().m2464f(), m2998a.m3051a().m2462g(), true);
                try {
                    ConnectionSpec m2852a = connectionSpecSelector.m2852a(sSLSocket);
                    if (m2852a.m2569d()) {
                        Platform.m2762c().mo2770a(sSLSocket, m2998a.m3051a().m2464f(), m2998a.m3046e());
                    }
                    sSLSocket.startHandshake();
                    SSLSession session = sSLSocket.getSession();
                    Handshake m2504a = Handshake.m2504a(session);
                    if (!m2998a.m3041j().verify(m2998a.m3051a().m2464f(), session)) {
                        X509Certificate x509Certificate = (X509Certificate) m2504a.m2503b().get(0);
                        throw new SSLPeerUnverifiedException("Hostname " + m2998a.m3051a().m2464f() + " not verified:\n    certificate: " + CertificatePinner.m2975a((Certificate) x509Certificate) + "\n    DN: " + x509Certificate.getSubjectDN().getName() + "\n    subjectAltNames: " + OkHostnameVerifier.m2755a(x509Certificate));
                    }
                    m2998a.m3040k().m2976a(m2998a.m3051a().m2464f(), m2504a.m2503b());
                    String mo2771a = m2852a.m2569d() ? Platform.m2762c().mo2771a(sSLSocket) : null;
                    this.f10238j = sSLSocket;
                    this.f10242n = Okio.m2263a(Okio.m2262b(this.f10238j));
                    this.f10243o = Okio.m2264a(Okio.m2265a(this.f10238j));
                    this.f10239k = m2504a;
                    if (mo2771a != null) {
                        protocol = Protocol.get(mo2771a);
                    } else {
                        protocol = Protocol.HTTP_1_1;
                    }
                    this.f10240l = protocol;
                    if (sSLSocket != null) {
                        Platform.m2762c().mo2764b(sSLSocket);
                    }
                } catch (AssertionError e) {
                    e = e;
                    if (!C2930c.m2896a(e)) {
                        throw e;
                    }
                    throw new IOException(e);
                } catch (Throwable th) {
                    th = th;
                    if (sSLSocket != null) {
                        Platform.m2762c().mo2764b(sSLSocket);
                    }
                    C2930c.m2884a((Socket) sSLSocket);
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                sSLSocket = null;
            }
        } catch (AssertionError e2) {
            e = e2;
        }
    }

    /* renamed from: a */
    private C2993z m2845a(int i, int i2, C2993z c2993z, HttpUrl httpUrl) throws IOException {
        String str = "CONNECT " + C2930c.m2879a(httpUrl, true) + " HTTP/1.1";
        while (true) {
            Http1Codec http1Codec = new Http1Codec(null, null, this.f10242n, this.f10243o);
            this.f10242n.mo2214a().mo2207a(i, TimeUnit.MILLISECONDS);
            this.f10243o.mo2216a().mo2207a(i2, TimeUnit.MILLISECONDS);
            http1Codec.m2863a(c2993z.m2347c(), str);
            http1Codec.mo2713b();
            Response m3020a = http1Codec.mo2714a(false).m3009a(c2993z).m3020a();
            long m2928a = HttpHeaders.m2928a(m3020a);
            if (m2928a == -1) {
                m2928a = 0;
            }
            Source m2860b = http1Codec.m2860b(m2928a);
            C2930c.m2870b(m2860b, Integer.MAX_VALUE, TimeUnit.MILLISECONDS);
            m2860b.close();
            int m3031b = m3020a.m3031b();
            if (m3031b == 200) {
                if (this.f10242n.mo2238c().mo2236f() && this.f10243o.mo2238c().mo2236f()) {
                    return null;
                }
                throw new IOException("TLS tunnel buffered too many bytes!");
            } else if (m3031b == 407) {
                C2993z mo2994a = this.f10236h.m2998a().m3047d().mo2994a(this.f10236h, m3020a);
                if (mo2994a == null) {
                    throw new IOException("Failed to authenticate with proxy");
                }
                if ("close".equalsIgnoreCase(m3020a.m3033a("Connection"))) {
                    return mo2994a;
                }
                c2993z = mo2994a;
            } else {
                throw new IOException("Unexpected response code for CONNECT: " + m3020a.m3031b());
            }
        }
    }

    /* renamed from: g */
    private C2993z m2833g() {
        return new C2993z.C2994a().m2337a(this.f10236h.m2998a().m3051a()).m2340a("Host", C2930c.m2879a(this.f10236h.m2998a().m3051a(), true)).m2340a("Proxy-Connection", "Keep-Alive").m2340a("User-Agent", C2942d.m2800a()).m2342a();
    }

    /* renamed from: a */
    public boolean m2844a(Address address, @Nullable Route route) {
        if (this.f10233d.size() >= this.f10232c || this.f10230a || !Internal.f10101a.mo2382a(this.f10236h.m2998a(), address)) {
            return false;
        }
        if (address.m3051a().m2464f().equals(m2838b().m2998a().m3051a().m2464f())) {
            return true;
        }
        if (this.f10241m != null && route != null && route.m2997b().type() == Proxy.Type.DIRECT && this.f10236h.m2997b().type() == Proxy.Type.DIRECT && this.f10236h.m2996c().equals(route.m2996c()) && route.m2998a().m3041j() == OkHostnameVerifier.f10302a && m2841a(address.m3051a())) {
            try {
                address.m3040k().m2976a(address.m3051a().m2464f(), m2835e().m2503b());
                return true;
            } catch (SSLPeerUnverifiedException unused) {
                return false;
            }
        }
        return false;
    }

    /* renamed from: a */
    public boolean m2841a(HttpUrl httpUrl) {
        if (httpUrl.m2462g() != this.f10236h.m2998a().m3051a().m2462g()) {
            return false;
        }
        if (httpUrl.m2464f().equals(this.f10236h.m2998a().m3051a().m2464f())) {
            return true;
        }
        return this.f10239k != null && OkHostnameVerifier.f10302a.m2756a(httpUrl.m2464f(), (X509Certificate) this.f10239k.m2503b().get(0));
    }

    /* renamed from: a */
    public HttpCodec m2840a(OkHttpClient okHttpClient, Interceptor.InterfaceC2987a interfaceC2987a, StreamAllocation streamAllocation) throws SocketException {
        Http2Connection http2Connection = this.f10241m;
        if (http2Connection != null) {
            return new Http2Codec(okHttpClient, interfaceC2987a, streamAllocation, http2Connection);
        }
        this.f10238j.setSoTimeout(interfaceC2987a.mo2424d());
        this.f10242n.mo2214a().mo2207a(interfaceC2987a.mo2424d(), TimeUnit.MILLISECONDS);
        this.f10243o.mo2216a().mo2207a(interfaceC2987a.mo2423e(), TimeUnit.MILLISECONDS);
        return new Http1Codec(okHttpClient, streamAllocation, this.f10242n, this.f10243o);
    }

    /* renamed from: b */
    public Route m2838b() {
        return this.f10236h;
    }

    /* renamed from: c */
    public void m2837c() {
        C2930c.m2884a(this.f10237i);
    }

    /* renamed from: d */
    public Socket m2836d() {
        return this.f10238j;
    }

    /* renamed from: a */
    public boolean m2839a(boolean z) {
        if (this.f10238j.isClosed() || this.f10238j.isInputShutdown() || this.f10238j.isOutputShutdown()) {
            return false;
        }
        Http2Connection http2Connection = this.f10241m;
        if (http2Connection != null) {
            return !http2Connection.m2684d();
        }
        if (z) {
            try {
                int soTimeout = this.f10238j.getSoTimeout();
                try {
                    this.f10238j.setSoTimeout(1);
                    return !this.f10242n.mo2236f();
                } finally {
                    this.f10238j.setSoTimeout(soTimeout);
                }
            } catch (SocketTimeoutException unused) {
            } catch (IOException unused2) {
                return false;
            }
        }
        return true;
    }

    @Override // okhttp3.internal.http2.Http2Connection.AbstractC2958b
    /* renamed from: a */
    public void mo2676a(Http2Stream http2Stream) throws IOException {
        http2Stream.m2645a(ErrorCode.REFUSED_STREAM);
    }

    @Override // okhttp3.internal.http2.Http2Connection.AbstractC2958b
    /* renamed from: a */
    public void mo2677a(Http2Connection http2Connection) {
        synchronized (this.f10235g) {
            this.f10232c = http2Connection.m2709a();
        }
    }

    /* renamed from: e */
    public Handshake m2835e() {
        return this.f10239k;
    }

    /* renamed from: f */
    public boolean m2834f() {
        return this.f10241m != null;
    }

    @Override // okhttp3.Connection
    /* renamed from: a */
    public Protocol mo2850a() {
        return this.f10240l;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Connection{");
        sb.append(this.f10236h.m2998a().m3051a().m2464f());
        sb.append(":");
        sb.append(this.f10236h.m2998a().m3051a().m2462g());
        sb.append(", proxy=");
        sb.append(this.f10236h.m2997b());
        sb.append(" hostAddress=");
        sb.append(this.f10236h.m2996c());
        sb.append(" cipherSuite=");
        Handshake handshake = this.f10239k;
        sb.append(handshake != null ? handshake.m2505a() : "none");
        sb.append(" protocol=");
        sb.append(this.f10240l);
        sb.append('}');
        return sb.toString();
    }
}
