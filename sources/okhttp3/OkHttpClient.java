package okhttp3;

import java.net.Proxy;
import java.net.ProxySelector;
import java.net.Socket;
import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;
import javax.net.SocketFactory;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import okhttp3.C2984s;
import okhttp3.Call;
import okhttp3.EventListener;
import okhttp3.Response;
import okhttp3.internal.C2930c;
import okhttp3.internal.Internal;
import okhttp3.internal.connection.RealConnection;
import okhttp3.internal.connection.RouteDatabase;
import okhttp3.internal.connection.StreamAllocation;
import okhttp3.internal.p103a.InternalCache;
import okhttp3.internal.p107e.Platform;
import okhttp3.internal.p108f.CertificateChainCleaner;
import okhttp3.internal.p108f.OkHostnameVerifier;
import org.apache.log4j.Priority;

/* renamed from: okhttp3.x */
/* loaded from: classes2.dex */
public class OkHttpClient implements Cloneable, Call.InterfaceC2918a {

    /* renamed from: a */
    static final List<Protocol> f10586a = C2930c.m2875a(Protocol.HTTP_2, Protocol.HTTP_1_1);

    /* renamed from: b */
    static final List<ConnectionSpec> f10587b = C2930c.m2875a(ConnectionSpec.f10490b, ConnectionSpec.f10492d);

    /* renamed from: A */
    final int f10588A;

    /* renamed from: B */
    final int f10589B;

    /* renamed from: C */
    final int f10590C;

    /* renamed from: c */
    final C2978n f10591c;
    @Nullable

    /* renamed from: d */
    final Proxy f10592d;

    /* renamed from: e */
    final List<Protocol> f10593e;

    /* renamed from: f */
    final List<ConnectionSpec> f10594f;

    /* renamed from: g */
    final List<Interceptor> f10595g;

    /* renamed from: h */
    final List<Interceptor> f10596h;

    /* renamed from: i */
    final EventListener.InterfaceC2982a f10597i;

    /* renamed from: j */
    final ProxySelector f10598j;

    /* renamed from: k */
    final CookieJar f10599k;
    @Nullable

    /* renamed from: l */
    final C2916c f10600l;
    @Nullable

    /* renamed from: m */
    final InternalCache f10601m;

    /* renamed from: n */
    final SocketFactory f10602n;
    @Nullable

    /* renamed from: o */
    final SSLSocketFactory f10603o;
    @Nullable

    /* renamed from: p */
    final CertificateChainCleaner f10604p;

    /* renamed from: q */
    final HostnameVerifier f10605q;

    /* renamed from: r */
    final CertificatePinner f10606r;

    /* renamed from: s */
    final Authenticator f10607s;

    /* renamed from: t */
    final Authenticator f10608t;

    /* renamed from: u */
    final ConnectionPool f10609u;

    /* renamed from: v */
    final Dns f10610v;

    /* renamed from: w */
    final boolean f10611w;

    /* renamed from: x */
    final boolean f10612x;

    /* renamed from: y */
    final boolean f10613y;

    /* renamed from: z */
    final int f10614z;

    static {
        Internal.f10101a = new Internal() { // from class: okhttp3.x.1
            @Override // okhttp3.internal.Internal
            /* renamed from: a */
            public void mo2375a(C2984s.C2985a c2985a, String str) {
                c2985a.m2493a(str);
            }

            @Override // okhttp3.internal.Internal
            /* renamed from: a */
            public void mo2374a(C2984s.C2985a c2985a, String str, String str2) {
                c2985a.m2490b(str, str2);
            }

            @Override // okhttp3.internal.Internal
            /* renamed from: a */
            public boolean mo2377a(ConnectionPool connectionPool, RealConnection realConnection) {
                return connectionPool.m2576b(realConnection);
            }

            @Override // okhttp3.internal.Internal
            /* renamed from: a */
            public RealConnection mo2378a(ConnectionPool connectionPool, Address address, StreamAllocation streamAllocation, Route route) {
                return connectionPool.m2579a(address, streamAllocation, route);
            }

            @Override // okhttp3.internal.Internal
            /* renamed from: a */
            public boolean mo2382a(Address address, Address address2) {
                return address.m3050a(address2);
            }

            @Override // okhttp3.internal.Internal
            /* renamed from: a */
            public Socket mo2379a(ConnectionPool connectionPool, Address address, StreamAllocation streamAllocation) {
                return connectionPool.m2580a(address, streamAllocation);
            }

            @Override // okhttp3.internal.Internal
            /* renamed from: b */
            public void mo2373b(ConnectionPool connectionPool, RealConnection realConnection) {
                connectionPool.m2578a(realConnection);
            }

            @Override // okhttp3.internal.Internal
            /* renamed from: a */
            public RouteDatabase mo2380a(ConnectionPool connectionPool) {
                return connectionPool.f10482a;
            }

            @Override // okhttp3.internal.Internal
            /* renamed from: a */
            public int mo2381a(Response.C2912a c2912a) {
                return c2912a.f9930c;
            }

            @Override // okhttp3.internal.Internal
            /* renamed from: a */
            public void mo2376a(ConnectionSpec connectionSpec, SSLSocket sSLSocket, boolean z) {
                connectionSpec.m2573a(sSLSocket, z);
            }
        };
    }

    public OkHttpClient() {
        this(new C2991a());
    }

    OkHttpClient(C2991a c2991a) {
        this.f10591c = c2991a.f10616a;
        this.f10592d = c2991a.f10617b;
        this.f10593e = c2991a.f10618c;
        this.f10594f = c2991a.f10619d;
        this.f10595g = C2930c.m2881a(c2991a.f10620e);
        this.f10596h = C2930c.m2881a(c2991a.f10621f);
        this.f10597i = c2991a.f10622g;
        this.f10598j = c2991a.f10623h;
        this.f10599k = c2991a.f10624i;
        this.f10600l = c2991a.f10625j;
        this.f10601m = c2991a.f10626k;
        this.f10602n = c2991a.f10627l;
        boolean z = false;
        for (ConnectionSpec connectionSpec : this.f10594f) {
            z = z || connectionSpec.m2575a();
        }
        if (c2991a.f10628m != null || !z) {
            this.f10603o = c2991a.f10628m;
            this.f10604p = c2991a.f10629n;
        } else {
            X509TrustManager m2900a = C2930c.m2900a();
            this.f10603o = m2408a(m2900a);
            this.f10604p = CertificateChainCleaner.m2758a(m2900a);
        }
        if (this.f10603o != null) {
            Platform.m2762c().mo2769a(this.f10603o);
        }
        this.f10605q = c2991a.f10630o;
        this.f10606r = c2991a.f10631p.m2973a(this.f10604p);
        this.f10607s = c2991a.f10632q;
        this.f10608t = c2991a.f10633r;
        this.f10609u = c2991a.f10634s;
        this.f10610v = c2991a.f10635t;
        this.f10611w = c2991a.f10636u;
        this.f10612x = c2991a.f10637v;
        this.f10613y = c2991a.f10638w;
        this.f10614z = c2991a.f10639x;
        this.f10588A = c2991a.f10640y;
        this.f10589B = c2991a.f10641z;
        this.f10590C = c2991a.f10615A;
        if (this.f10595g.contains(null)) {
            throw new IllegalStateException("Null interceptor: " + this.f10595g);
        } else if (this.f10596h.contains(null)) {
            throw new IllegalStateException("Null network interceptor: " + this.f10596h);
        }
    }

    /* renamed from: a */
    private static SSLSocketFactory m2408a(X509TrustManager x509TrustManager) {
        try {
            SSLContext mo2767b = Platform.m2762c().mo2767b();
            mo2767b.init(null, new TrustManager[]{x509TrustManager}, null);
            return mo2767b.getSocketFactory();
        } catch (GeneralSecurityException e) {
            throw C2930c.m2888a("No System TLS", (Exception) e);
        }
    }

    /* renamed from: a */
    public int m2409a() {
        return this.f10614z;
    }

    /* renamed from: b */
    public int m2406b() {
        return this.f10588A;
    }

    /* renamed from: c */
    public int m2405c() {
        return this.f10589B;
    }

    /* renamed from: d */
    public int m2404d() {
        return this.f10590C;
    }

    /* renamed from: e */
    public Proxy m2403e() {
        return this.f10592d;
    }

    /* renamed from: f */
    public ProxySelector m2402f() {
        return this.f10598j;
    }

    /* renamed from: g */
    public CookieJar m2401g() {
        return this.f10599k;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: h */
    public InternalCache m2400h() {
        C2916c c2916c = this.f10600l;
        return c2916c != null ? c2916c.f9952a : this.f10601m;
    }

    /* renamed from: i */
    public Dns m2399i() {
        return this.f10610v;
    }

    /* renamed from: j */
    public SocketFactory m2398j() {
        return this.f10602n;
    }

    /* renamed from: k */
    public SSLSocketFactory m2397k() {
        return this.f10603o;
    }

    /* renamed from: l */
    public HostnameVerifier m2396l() {
        return this.f10605q;
    }

    /* renamed from: m */
    public CertificatePinner m2395m() {
        return this.f10606r;
    }

    /* renamed from: n */
    public Authenticator m2394n() {
        return this.f10608t;
    }

    /* renamed from: o */
    public Authenticator m2393o() {
        return this.f10607s;
    }

    /* renamed from: p */
    public ConnectionPool m2392p() {
        return this.f10609u;
    }

    /* renamed from: q */
    public boolean m2391q() {
        return this.f10611w;
    }

    /* renamed from: r */
    public boolean m2390r() {
        return this.f10612x;
    }

    /* renamed from: s */
    public boolean m2389s() {
        return this.f10613y;
    }

    /* renamed from: t */
    public C2978n m2388t() {
        return this.f10591c;
    }

    /* renamed from: u */
    public List<Protocol> m2387u() {
        return this.f10593e;
    }

    /* renamed from: v */
    public List<ConnectionSpec> m2386v() {
        return this.f10594f;
    }

    /* renamed from: w */
    public List<Interceptor> m2385w() {
        return this.f10595g;
    }

    /* renamed from: x */
    public List<Interceptor> m2384x() {
        return this.f10596h;
    }

    /* renamed from: y */
    public EventListener.InterfaceC2982a m2383y() {
        return this.f10597i;
    }

    @Override // okhttp3.Call.InterfaceC2918a
    /* renamed from: a */
    public Call mo2407a(C2993z c2993z) {
        return RealCall.m2362a(this, c2993z, false);
    }

    /* compiled from: OkHttpClient.java */
    /* renamed from: okhttp3.x$a */
    /* loaded from: classes2.dex */
    public static final class C2991a {
        @Nullable

        /* renamed from: b */
        Proxy f10617b;
        @Nullable

        /* renamed from: j */
        C2916c f10625j;
        @Nullable

        /* renamed from: k */
        InternalCache f10626k;
        @Nullable

        /* renamed from: m */
        SSLSocketFactory f10628m;
        @Nullable

        /* renamed from: n */
        CertificateChainCleaner f10629n;

        /* renamed from: e */
        final List<Interceptor> f10620e = new ArrayList();

        /* renamed from: f */
        final List<Interceptor> f10621f = new ArrayList();

        /* renamed from: a */
        C2978n f10616a = new C2978n();

        /* renamed from: c */
        List<Protocol> f10618c = OkHttpClient.f10586a;

        /* renamed from: d */
        List<ConnectionSpec> f10619d = OkHttpClient.f10587b;

        /* renamed from: g */
        EventListener.InterfaceC2982a f10622g = EventListener.m2523a(EventListener.f10530a);

        /* renamed from: h */
        ProxySelector f10623h = ProxySelector.getDefault();

        /* renamed from: i */
        CookieJar f10624i = CookieJar.f10521a;

        /* renamed from: l */
        SocketFactory f10627l = SocketFactory.getDefault();

        /* renamed from: o */
        HostnameVerifier f10630o = OkHostnameVerifier.f10302a;

        /* renamed from: p */
        CertificatePinner f10631p = CertificatePinner.f9977a;

        /* renamed from: q */
        Authenticator f10632q = Authenticator.f9951b;

        /* renamed from: r */
        Authenticator f10633r = Authenticator.f9951b;

        /* renamed from: s */
        ConnectionPool f10634s = new ConnectionPool();

        /* renamed from: t */
        Dns f10635t = Dns.f10529a;

        /* renamed from: u */
        boolean f10636u = true;

        /* renamed from: v */
        boolean f10637v = true;

        /* renamed from: w */
        boolean f10638w = true;

        /* renamed from: x */
        int f10639x = Priority.DEBUG_INT;

        /* renamed from: y */
        int f10640y = Priority.DEBUG_INT;

        /* renamed from: z */
        int f10641z = Priority.DEBUG_INT;

        /* renamed from: A */
        int f10615A = 0;

        /* renamed from: a */
        public C2991a m2371a(long j, TimeUnit timeUnit) {
            this.f10639x = C2930c.m2889a("timeout", j, timeUnit);
            return this;
        }

        /* renamed from: a */
        public C2991a m2369a(SSLSocketFactory sSLSocketFactory, X509TrustManager x509TrustManager) {
            if (sSLSocketFactory != null) {
                if (x509TrustManager == null) {
                    throw new NullPointerException("trustManager == null");
                }
                this.f10628m = sSLSocketFactory;
                this.f10629n = CertificateChainCleaner.m2758a(x509TrustManager);
                return this;
            }
            throw new NullPointerException("sslSocketFactory == null");
        }

        /* renamed from: a */
        public C2991a m2370a(HostnameVerifier hostnameVerifier) {
            if (hostnameVerifier == null) {
                throw new NullPointerException("hostnameVerifier == null");
            }
            this.f10630o = hostnameVerifier;
            return this;
        }

        /* renamed from: a */
        public C2991a m2367a(CertificatePinner certificatePinner) {
            if (certificatePinner == null) {
                throw new NullPointerException("certificatePinner == null");
            }
            this.f10631p = certificatePinner;
            return this;
        }

        /* renamed from: a */
        public C2991a m2368a(Authenticator authenticator) {
            if (authenticator == null) {
                throw new NullPointerException("authenticator == null");
            }
            this.f10633r = authenticator;
            return this;
        }

        /* renamed from: a */
        public C2991a m2366a(Interceptor interceptor) {
            if (interceptor == null) {
                throw new IllegalArgumentException("interceptor == null");
            }
            this.f10620e.add(interceptor);
            return this;
        }

        /* renamed from: b */
        public C2991a m2365b(Interceptor interceptor) {
            if (interceptor == null) {
                throw new IllegalArgumentException("interceptor == null");
            }
            this.f10621f.add(interceptor);
            return this;
        }

        /* renamed from: a */
        public OkHttpClient m2372a() {
            return new OkHttpClient(this);
        }
    }
}
