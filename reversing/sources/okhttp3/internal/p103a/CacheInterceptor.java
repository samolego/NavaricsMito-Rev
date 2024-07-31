package okhttp3.internal.p103a;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import okhttp3.C2984s;
import okhttp3.C2993z;
import okhttp3.Interceptor;
import okhttp3.Protocol;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okhttp3.internal.C2930c;
import okhttp3.internal.Internal;
import okhttp3.internal.p103a.CacheStrategy;
import okhttp3.internal.p104b.HttpHeaders;
import okhttp3.internal.p104b.HttpMethod;
import okhttp3.internal.p104b.RealResponseBody;
import okio.Buffer;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.Okio;
import okio.Sink;
import okio.Source;
import okio.Timeout;

/* renamed from: okhttp3.internal.a.a */
/* loaded from: classes2.dex */
public final class CacheInterceptor implements Interceptor {

    /* renamed from: a */
    final InternalCache f10102a;

    public CacheInterceptor(InternalCache internalCache) {
        this.f10102a = internalCache;
    }

    @Override // okhttp3.Interceptor
    /* renamed from: a */
    public Response mo2429a(Interceptor.InterfaceC2987a interfaceC2987a) throws IOException {
        InternalCache internalCache = this.f10102a;
        Response m2937a = internalCache != null ? internalCache.m2937a(interfaceC2987a.mo2428a()) : null;
        CacheStrategy m2956a = new CacheStrategy.C2924a(System.currentTimeMillis(), interfaceC2987a.mo2428a(), m2937a).m2956a();
        C2993z c2993z = m2956a.f10108a;
        Response response = m2956a.f10109b;
        InternalCache internalCache2 = this.f10102a;
        if (internalCache2 != null) {
            internalCache2.m2938a(m2956a);
        }
        if (m2937a != null && response == null) {
            C2930c.m2897a(m2937a.m3026g());
        }
        if (c2993z == null && response == null) {
            return new Response.C2912a().m3009a(interfaceC2987a.mo2428a()).m3014a(Protocol.HTTP_1_1).m3019a(504).m3017a("Unsatisfiable Request (only-if-cached)").m3012a(C2930c.f10181c).m3018a(-1L).m3008b(System.currentTimeMillis()).m3020a();
        }
        if (c2993z == null) {
            return response.m3025h().m3007b(m2963a(response)).m3020a();
        }
        try {
            Response mo2427a = interfaceC2987a.mo2427a(c2993z);
            if (mo2427a == null && m2937a != null) {
            }
            if (response != null) {
                if (mo2427a.m3031b() == 304) {
                    Response m3020a = response.m3025h().m3010a(m2961a(response.m3027f(), mo2427a.m3027f())).m3018a(mo2427a.m3022k()).m3008b(mo2427a.m3021l()).m3007b(m2963a(response)).m3013a(m2963a(mo2427a)).m3020a();
                    mo2427a.m3026g().close();
                    this.f10102a.m2941a();
                    this.f10102a.m2939a(response, m3020a);
                    return m3020a;
                }
                C2930c.m2897a(response.m3026g());
            }
            Response m3020a2 = mo2427a.m3025h().m3007b(m2963a(response)).m3013a(m2963a(mo2427a)).m3020a();
            if (this.f10102a != null) {
                if (HttpHeaders.m2924b(m3020a2) && CacheStrategy.m2957a(m3020a2, c2993z)) {
                    return m2962a(this.f10102a.m2940a(m3020a2), m3020a2);
                }
                if (HttpMethod.m2923a(c2993z.m2348b())) {
                    try {
                        this.f10102a.m2936b(c2993z);
                    } catch (IOException unused) {
                    }
                }
            }
            return m3020a2;
        } finally {
            if (m2937a != null) {
                C2930c.m2897a(m2937a.m3026g());
            }
        }
    }

    /* renamed from: a */
    private static Response m2963a(Response response) {
        return (response == null || response.m3026g() == null) ? response : response.m3025h().m3012a((ResponseBody) null).m3020a();
    }

    /* renamed from: a */
    private Response m2962a(final CacheRequest cacheRequest, Response response) throws IOException {
        Sink m2959a;
        if (cacheRequest == null || (m2959a = cacheRequest.m2959a()) == null) {
            return response;
        }
        final BufferedSource mo127d = response.m3026g().mo127d();
        final BufferedSink m2264a = Okio.m2264a(m2959a);
        return response.m3025h().m3012a(new RealResponseBody(response.m3033a("Content-Type"), response.m3026g().mo128b(), Okio.m2263a(new Source() { // from class: okhttp3.internal.a.a.1

            /* renamed from: a */
            boolean f10103a;

            @Override // okio.Source
            /* renamed from: a */
            public long mo130a(Buffer buffer, long j) throws IOException {
                try {
                    long a = mo127d.mo130a(buffer, j);
                    if (a == -1) {
                        if (!this.f10103a) {
                            this.f10103a = true;
                            m2264a.close();
                        }
                        return -1L;
                    }
                    buffer.m2304a(m2264a.mo2238c(), buffer.m2302b() - a, a);
                    m2264a.mo2248w();
                    return a;
                } catch (IOException e) {
                    if (!this.f10103a) {
                        this.f10103a = true;
                        cacheRequest.m2958b();
                    }
                    throw e;
                }
            }

            @Override // okio.Source
            /* renamed from: a */
            public Timeout mo2214a() {
                return mo127d.mo2214a();
            }

            @Override // okio.Source, java.io.Closeable, java.lang.AutoCloseable
            public void close() throws IOException {
                if (!this.f10103a && !C2930c.m2877a(this, 100, TimeUnit.MILLISECONDS)) {
                    this.f10103a = true;
                    cacheRequest.m2958b();
                }
                mo127d.close();
            }
        }))).m3020a();
    }

    /* renamed from: a */
    private static C2984s m2961a(C2984s c2984s, C2984s c2984s2) {
        C2984s.C2985a c2985a = new C2984s.C2985a();
        int m2502a = c2984s.m2502a();
        for (int i = 0; i < m2502a; i++) {
            String m2501a = c2984s.m2501a(i);
            String m2496b = c2984s.m2496b(i);
            if ((!"Warning".equalsIgnoreCase(m2501a) || !m2496b.startsWith("1")) && (m2960b(m2501a) || !m2964a(m2501a) || c2984s2.m2500a(m2501a) == null)) {
                Internal.f10101a.mo2374a(c2985a, m2501a, m2496b);
            }
        }
        int m2502a2 = c2984s2.m2502a();
        for (int i2 = 0; i2 < m2502a2; i2++) {
            String m2501a2 = c2984s2.m2501a(i2);
            if (!m2960b(m2501a2) && m2964a(m2501a2)) {
                Internal.f10101a.mo2374a(c2985a, m2501a2, c2984s2.m2496b(i2));
            }
        }
        return c2985a.m2494a();
    }

    /* renamed from: a */
    static boolean m2964a(String str) {
        return ("Connection".equalsIgnoreCase(str) || "Keep-Alive".equalsIgnoreCase(str) || "Proxy-Authenticate".equalsIgnoreCase(str) || "Proxy-Authorization".equalsIgnoreCase(str) || "TE".equalsIgnoreCase(str) || "Trailers".equalsIgnoreCase(str) || "Transfer-Encoding".equalsIgnoreCase(str) || "Upgrade".equalsIgnoreCase(str)) ? false : true;
    }

    /* renamed from: b */
    static boolean m2960b(String str) {
        return "Content-Length".equalsIgnoreCase(str) || "Content-Encoding".equalsIgnoreCase(str) || "Content-Type".equalsIgnoreCase(str);
    }
}
