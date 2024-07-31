package okhttp3;

import java.io.Closeable;
import javax.annotation.Nullable;
import okhttp3.C2984s;

/* renamed from: okhttp3.ab */
/* loaded from: classes2.dex */
public final class Response implements Closeable {

    /* renamed from: a */
    final C2993z f9915a;

    /* renamed from: b */
    final Protocol f9916b;

    /* renamed from: c */
    final int f9917c;

    /* renamed from: d */
    final String f9918d;
    @Nullable

    /* renamed from: e */
    final Handshake f9919e;

    /* renamed from: f */
    final C2984s f9920f;
    @Nullable

    /* renamed from: g */
    final ResponseBody f9921g;
    @Nullable

    /* renamed from: h */
    final Response f9922h;
    @Nullable

    /* renamed from: i */
    final Response f9923i;
    @Nullable

    /* renamed from: j */
    final Response f9924j;

    /* renamed from: k */
    final long f9925k;

    /* renamed from: l */
    final long f9926l;

    /* renamed from: m */
    private volatile CacheControl f9927m;

    Response(C2912a c2912a) {
        this.f9915a = c2912a.f9928a;
        this.f9916b = c2912a.f9929b;
        this.f9917c = c2912a.f9930c;
        this.f9918d = c2912a.f9931d;
        this.f9919e = c2912a.f9932e;
        this.f9920f = c2912a.f9933f.m2494a();
        this.f9921g = c2912a.f9934g;
        this.f9922h = c2912a.f9935h;
        this.f9923i = c2912a.f9936i;
        this.f9924j = c2912a.f9937j;
        this.f9925k = c2912a.f9938k;
        this.f9926l = c2912a.f9939l;
    }

    /* renamed from: a */
    public C2993z m3034a() {
        return this.f9915a;
    }

    /* renamed from: b */
    public int m3031b() {
        return this.f9917c;
    }

    /* renamed from: c */
    public boolean m3030c() {
        int i = this.f9917c;
        return i >= 200 && i < 300;
    }

    /* renamed from: d */
    public String m3029d() {
        return this.f9918d;
    }

    /* renamed from: e */
    public Handshake m3028e() {
        return this.f9919e;
    }

    @Nullable
    /* renamed from: a */
    public String m3033a(String str) {
        return m3032a(str, null);
    }

    @Nullable
    /* renamed from: a */
    public String m3032a(String str, @Nullable String str2) {
        String m2500a = this.f9920f.m2500a(str);
        return m2500a != null ? m2500a : str2;
    }

    /* renamed from: f */
    public C2984s m3027f() {
        return this.f9920f;
    }

    @Nullable
    /* renamed from: g */
    public ResponseBody m3026g() {
        return this.f9921g;
    }

    /* renamed from: h */
    public C2912a m3025h() {
        return new C2912a(this);
    }

    @Nullable
    /* renamed from: i */
    public Response m3024i() {
        return this.f9924j;
    }

    /* renamed from: j */
    public CacheControl m3023j() {
        CacheControl cacheControl = this.f9927m;
        if (cacheControl != null) {
            return cacheControl;
        }
        CacheControl m2992a = CacheControl.m2992a(this.f9920f);
        this.f9927m = m2992a;
        return m2992a;
    }

    /* renamed from: k */
    public long m3022k() {
        return this.f9925k;
    }

    /* renamed from: l */
    public long m3021l() {
        return this.f9926l;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        ResponseBody responseBody = this.f9921g;
        if (responseBody == null) {
            throw new IllegalStateException("response is not eligible for a body and must not be closed");
        }
        responseBody.close();
    }

    public String toString() {
        return "Response{protocol=" + this.f9916b + ", code=" + this.f9917c + ", message=" + this.f9918d + ", url=" + this.f9915a.m2350a() + '}';
    }

    /* compiled from: Response.java */
    /* renamed from: okhttp3.ab$a */
    /* loaded from: classes2.dex */
    public static class C2912a {

        /* renamed from: a */
        C2993z f9928a;

        /* renamed from: b */
        Protocol f9929b;

        /* renamed from: c */
        int f9930c;

        /* renamed from: d */
        String f9931d;
        @Nullable

        /* renamed from: e */
        Handshake f9932e;

        /* renamed from: f */
        C2984s.C2985a f9933f;

        /* renamed from: g */
        ResponseBody f9934g;

        /* renamed from: h */
        Response f9935h;

        /* renamed from: i */
        Response f9936i;

        /* renamed from: j */
        Response f9937j;

        /* renamed from: k */
        long f9938k;

        /* renamed from: l */
        long f9939l;

        public C2912a() {
            this.f9930c = -1;
            this.f9933f = new C2984s.C2985a();
        }

        C2912a(Response response) {
            this.f9930c = -1;
            this.f9928a = response.f9915a;
            this.f9929b = response.f9916b;
            this.f9930c = response.f9917c;
            this.f9931d = response.f9918d;
            this.f9932e = response.f9919e;
            this.f9933f = response.f9920f.m2497b();
            this.f9934g = response.f9921g;
            this.f9935h = response.f9922h;
            this.f9936i = response.f9923i;
            this.f9937j = response.f9924j;
            this.f9938k = response.f9925k;
            this.f9939l = response.f9926l;
        }

        /* renamed from: a */
        public C2912a m3009a(C2993z c2993z) {
            this.f9928a = c2993z;
            return this;
        }

        /* renamed from: a */
        public C2912a m3014a(Protocol protocol) {
            this.f9929b = protocol;
            return this;
        }

        /* renamed from: a */
        public C2912a m3019a(int i) {
            this.f9930c = i;
            return this;
        }

        /* renamed from: a */
        public C2912a m3017a(String str) {
            this.f9931d = str;
            return this;
        }

        /* renamed from: a */
        public C2912a m3011a(@Nullable Handshake handshake) {
            this.f9932e = handshake;
            return this;
        }

        /* renamed from: a */
        public C2912a m3016a(String str, String str2) {
            this.f9933f.m2492a(str, str2);
            return this;
        }

        /* renamed from: a */
        public C2912a m3010a(C2984s c2984s) {
            this.f9933f = c2984s.m2497b();
            return this;
        }

        /* renamed from: a */
        public C2912a m3012a(@Nullable ResponseBody responseBody) {
            this.f9934g = responseBody;
            return this;
        }

        /* renamed from: a */
        public C2912a m3013a(@Nullable Response response) {
            if (response != null) {
                m3015a("networkResponse", response);
            }
            this.f9935h = response;
            return this;
        }

        /* renamed from: b */
        public C2912a m3007b(@Nullable Response response) {
            if (response != null) {
                m3015a("cacheResponse", response);
            }
            this.f9936i = response;
            return this;
        }

        /* renamed from: a */
        private void m3015a(String str, Response response) {
            if (response.f9921g != null) {
                throw new IllegalArgumentException(str + ".body != null");
            } else if (response.f9922h != null) {
                throw new IllegalArgumentException(str + ".networkResponse != null");
            } else if (response.f9923i != null) {
                throw new IllegalArgumentException(str + ".cacheResponse != null");
            } else if (response.f9924j == null) {
            } else {
                throw new IllegalArgumentException(str + ".priorResponse != null");
            }
        }

        /* renamed from: c */
        public C2912a m3006c(@Nullable Response response) {
            if (response != null) {
                m3005d(response);
            }
            this.f9937j = response;
            return this;
        }

        /* renamed from: d */
        private void m3005d(Response response) {
            if (response.f9921g != null) {
                throw new IllegalArgumentException("priorResponse.body != null");
            }
        }

        /* renamed from: a */
        public C2912a m3018a(long j) {
            this.f9938k = j;
            return this;
        }

        /* renamed from: b */
        public C2912a m3008b(long j) {
            this.f9939l = j;
            return this;
        }

        /* renamed from: a */
        public Response m3020a() {
            if (this.f9928a == null) {
                throw new IllegalStateException("request == null");
            }
            if (this.f9929b == null) {
                throw new IllegalStateException("protocol == null");
            }
            if (this.f9930c < 0) {
                throw new IllegalStateException("code < 0: " + this.f9930c);
            } else if (this.f9931d == null) {
                throw new IllegalStateException("message == null");
            } else {
                return new Response(this);
            }
        }
    }
}
