package okhttp3.logging;

import java.io.EOFException;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.concurrent.TimeUnit;
import okhttp3.C2984s;
import okhttp3.C2993z;
import okhttp3.Connection;
import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okhttp3.internal.p104b.HttpHeaders;
import okhttp3.internal.p107e.Platform;
import okio.Buffer;
import okio.BufferedSource;
import okio.GzipSource;

/* loaded from: classes2.dex */
public final class HttpLoggingInterceptor implements Interceptor {

    /* renamed from: a */
    private static final Charset f10516a = Charset.forName("UTF-8");

    /* renamed from: b */
    private final InterfaceC2975a f10517b;

    /* renamed from: c */
    private volatile Level f10518c;

    /* loaded from: classes2.dex */
    public enum Level {
        NONE,
        BASIC,
        HEADERS,
        BODY
    }

    /* renamed from: okhttp3.logging.HttpLoggingInterceptor$a */
    /* loaded from: classes2.dex */
    public interface InterfaceC2975a {

        /* renamed from: a */
        public static final InterfaceC2975a f10520a = new InterfaceC2975a() { // from class: okhttp3.logging.HttpLoggingInterceptor.a.1
            @Override // okhttp3.logging.HttpLoggingInterceptor.InterfaceC2975a
            /* renamed from: a */
            public void mo2548a(String str) {
                Platform.m2762c().mo2776a(4, str, (Throwable) null);
            }
        };

        /* renamed from: a */
        void mo2548a(String str);
    }

    public HttpLoggingInterceptor() {
        this(InterfaceC2975a.f10520a);
    }

    public HttpLoggingInterceptor(InterfaceC2975a interfaceC2975a) {
        this.f10518c = Level.NONE;
        this.f10517b = interfaceC2975a;
    }

    /* renamed from: a */
    public HttpLoggingInterceptor m2551a(Level level) {
        if (level == null) {
            throw new NullPointerException("level == null. Use Level.NONE instead.");
        }
        this.f10518c = level;
        return this;
    }

    @Override // okhttp3.Interceptor
    /* renamed from: a */
    public Response mo2429a(Interceptor.InterfaceC2987a interfaceC2987a) throws IOException {
        Long l;
        GzipSource gzipSource;
        Level level = this.f10518c;
        C2993z mo2428a = interfaceC2987a.mo2428a();
        if (level == Level.NONE) {
            return interfaceC2987a.mo2427a(mo2428a);
        }
        boolean z = level == Level.BODY;
        boolean z2 = z || level == Level.HEADERS;
        RequestBody m2346d = mo2428a.m2346d();
        boolean z3 = m2346d != null;
        Connection mo2426b = interfaceC2987a.mo2426b();
        StringBuilder sb = new StringBuilder();
        sb.append("--> ");
        sb.append(mo2428a.m2348b());
        sb.append(' ');
        sb.append(mo2428a.m2350a());
        sb.append(mo2426b != null ? " " + mo2426b.mo2850a() : "");
        String sb2 = sb.toString();
        if (!z2 && z3) {
            sb2 = sb2 + " (" + m2346d.mo74c() + "-byte body)";
        }
        this.f10517b.mo2548a(sb2);
        if (z2) {
            if (z3) {
                if (m2346d.mo75b() != null) {
                    this.f10517b.mo2548a("Content-Type: " + m2346d.mo75b());
                }
                if (m2346d.mo74c() != -1) {
                    this.f10517b.mo2548a("Content-Length: " + m2346d.mo74c());
                }
            }
            C2984s m2347c = mo2428a.m2347c();
            int m2502a = m2347c.m2502a();
            for (int i = 0; i < m2502a; i++) {
                String m2501a = m2347c.m2501a(i);
                if (!"Content-Type".equalsIgnoreCase(m2501a) && !"Content-Length".equalsIgnoreCase(m2501a)) {
                    this.f10517b.mo2548a(m2501a + ": " + m2347c.m2496b(i));
                }
            }
            if (!z || !z3) {
                this.f10517b.mo2548a("--> END " + mo2428a.m2348b());
            } else if (m2550a(mo2428a.m2347c())) {
                this.f10517b.mo2548a("--> END " + mo2428a.m2348b() + " (encoded body omitted)");
            } else {
                Buffer buffer = new Buffer();
                m2346d.mo76a(buffer);
                Charset charset = f10516a;
                MediaType mo75b = m2346d.mo75b();
                if (mo75b != null) {
                    charset = mo75b.m2420a(f10516a);
                }
                this.f10517b.mo2548a("");
                if (m2549a(buffer)) {
                    this.f10517b.mo2548a(buffer.mo2242a(charset));
                    this.f10517b.mo2548a("--> END " + mo2428a.m2348b() + " (" + m2346d.mo74c() + "-byte body)");
                } else {
                    this.f10517b.mo2548a("--> END " + mo2428a.m2348b() + " (binary " + m2346d.mo74c() + "-byte body omitted)");
                }
            }
        }
        long nanoTime = System.nanoTime();
        try {
            Response mo2427a = interfaceC2987a.mo2427a(mo2428a);
            long millis = TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - nanoTime);
            ResponseBody m3026g = mo2427a.m3026g();
            long mo128b = m3026g.mo128b();
            String str = mo128b != -1 ? mo128b + "-byte" : "unknown-length";
            InterfaceC2975a interfaceC2975a = this.f10517b;
            StringBuilder sb3 = new StringBuilder();
            sb3.append("<-- ");
            sb3.append(mo2427a.m3031b());
            sb3.append(mo2427a.m3029d().isEmpty() ? "" : ' ' + mo2427a.m3029d());
            sb3.append(' ');
            sb3.append(mo2427a.m3034a().m2350a());
            sb3.append(" (");
            sb3.append(millis);
            sb3.append("ms");
            sb3.append(z2 ? "" : ", " + str + " body");
            sb3.append(')');
            interfaceC2975a.mo2548a(sb3.toString());
            if (z2) {
                C2984s m3027f = mo2427a.m3027f();
                int m2502a2 = m3027f.m2502a();
                for (int i2 = 0; i2 < m2502a2; i2++) {
                    this.f10517b.mo2548a(m3027f.m2501a(i2) + ": " + m3027f.m2496b(i2));
                }
                if (!z || !HttpHeaders.m2924b(mo2427a)) {
                    this.f10517b.mo2548a("<-- END HTTP");
                } else if (m2550a(mo2427a.m3027f())) {
                    this.f10517b.mo2548a("<-- END HTTP (encoded body omitted)");
                } else {
                    BufferedSource mo127d = m3026g.mo127d();
                    mo127d.mo2239b(Long.MAX_VALUE);
                    Buffer mo2238c = mo127d.mo2238c();
                    GzipSource gzipSource2 = null;
                    if ("gzip".equalsIgnoreCase(m3027f.m2500a("Content-Encoding"))) {
                        l = Long.valueOf(mo2238c.m2302b());
                        try {
                            gzipSource = new GzipSource(mo2238c.clone());
                        } catch (Throwable th) {
                            th = th;
                        }
                        try {
                            mo2238c = new Buffer();
                            mo2238c.mo2258a(gzipSource);
                            gzipSource.close();
                        } catch (Throwable th2) {
                            th = th2;
                            gzipSource2 = gzipSource;
                            if (gzipSource2 != null) {
                                gzipSource2.close();
                            }
                            throw th;
                        }
                    } else {
                        l = null;
                    }
                    Charset charset2 = f10516a;
                    MediaType mo129a = m3026g.mo129a();
                    if (mo129a != null) {
                        charset2 = mo129a.m2420a(f10516a);
                    }
                    if (!m2549a(mo2238c)) {
                        this.f10517b.mo2548a("");
                        this.f10517b.mo2548a("<-- END HTTP (binary " + mo2238c.m2302b() + "-byte body omitted)");
                        return mo2427a;
                    }
                    if (mo128b != 0) {
                        this.f10517b.mo2548a("");
                        this.f10517b.mo2548a(mo2238c.clone().mo2242a(charset2));
                    }
                    if (l != null) {
                        this.f10517b.mo2548a("<-- END HTTP (" + mo2238c.m2302b() + "-byte, " + l + "-gzipped-byte body)");
                    } else {
                        this.f10517b.mo2548a("<-- END HTTP (" + mo2238c.m2302b() + "-byte body)");
                    }
                }
            }
            return mo2427a;
        } catch (Exception e) {
            this.f10517b.mo2548a("<-- HTTP FAILED: " + e);
            throw e;
        }
    }

    /* renamed from: a */
    static boolean m2549a(Buffer buffer) {
        try {
            Buffer buffer2 = new Buffer();
            buffer.m2304a(buffer2, 0L, buffer.m2302b() < 64 ? buffer.m2302b() : 64L);
            for (int i = 0; i < 16; i++) {
                if (buffer2.mo2236f()) {
                    return true;
                }
                int m2284r = buffer2.m2284r();
                if (Character.isISOControl(m2284r) && !Character.isWhitespace(m2284r)) {
                    return false;
                }
            }
            return true;
        } catch (EOFException unused) {
            return false;
        }
    }

    /* renamed from: a */
    private boolean m2550a(C2984s c2984s) {
        String m2500a = c2984s.m2500a("Content-Encoding");
        return (m2500a == null || m2500a.equalsIgnoreCase("identity") || m2500a.equalsIgnoreCase("gzip")) ? false : true;
    }
}
