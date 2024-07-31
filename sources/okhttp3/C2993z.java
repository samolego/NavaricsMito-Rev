package okhttp3;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.annotation.Nullable;
import okhttp3.C2984s;
import okhttp3.internal.C2930c;
import okhttp3.internal.p104b.HttpMethod;

/* compiled from: Request.java */
/* renamed from: okhttp3.z */
/* loaded from: classes2.dex */
public final class C2993z {

    /* renamed from: a */
    final HttpUrl f10650a;

    /* renamed from: b */
    final String f10651b;

    /* renamed from: c */
    final C2984s f10652c;
    @Nullable

    /* renamed from: d */
    final RequestBody f10653d;

    /* renamed from: e */
    final Map<Class<?>, Object> f10654e;

    /* renamed from: f */
    private volatile CacheControl f10655f;

    C2993z(C2994a c2994a) {
        this.f10650a = c2994a.f10656a;
        this.f10651b = c2994a.f10657b;
        this.f10652c = c2994a.f10658c.m2494a();
        this.f10653d = c2994a.f10659d;
        this.f10654e = C2930c.m2880a(c2994a.f10660e);
    }

    /* renamed from: a */
    public HttpUrl m2350a() {
        return this.f10650a;
    }

    /* renamed from: b */
    public String m2348b() {
        return this.f10651b;
    }

    /* renamed from: c */
    public C2984s m2347c() {
        return this.f10652c;
    }

    @Nullable
    /* renamed from: a */
    public String m2349a(String str) {
        return this.f10652c.m2500a(str);
    }

    @Nullable
    /* renamed from: d */
    public RequestBody m2346d() {
        return this.f10653d;
    }

    /* renamed from: e */
    public C2994a m2345e() {
        return new C2994a(this);
    }

    /* renamed from: f */
    public CacheControl m2344f() {
        CacheControl cacheControl = this.f10655f;
        if (cacheControl != null) {
            return cacheControl;
        }
        CacheControl m2992a = CacheControl.m2992a(this.f10652c);
        this.f10655f = m2992a;
        return m2992a;
    }

    /* renamed from: g */
    public boolean m2343g() {
        return this.f10650a.m2470c();
    }

    public String toString() {
        return "Request{method=" + this.f10651b + ", url=" + this.f10650a + ", tags=" + this.f10654e + '}';
    }

    /* compiled from: Request.java */
    /* renamed from: okhttp3.z$a */
    /* loaded from: classes2.dex */
    public static class C2994a {

        /* renamed from: a */
        HttpUrl f10656a;

        /* renamed from: b */
        String f10657b;

        /* renamed from: c */
        C2984s.C2985a f10658c;

        /* renamed from: d */
        RequestBody f10659d;

        /* renamed from: e */
        Map<Class<?>, Object> f10660e;

        public C2994a() {
            this.f10660e = Collections.emptyMap();
            this.f10657b = "GET";
            this.f10658c = new C2984s.C2985a();
        }

        C2994a(C2993z c2993z) {
            Map<Class<?>, Object> linkedHashMap;
            this.f10660e = Collections.emptyMap();
            this.f10656a = c2993z.f10650a;
            this.f10657b = c2993z.f10651b;
            this.f10659d = c2993z.f10653d;
            if (c2993z.f10654e.isEmpty()) {
                linkedHashMap = Collections.emptyMap();
            } else {
                linkedHashMap = new LinkedHashMap<>(c2993z.f10654e);
            }
            this.f10660e = linkedHashMap;
            this.f10658c = c2993z.f10652c.m2497b();
        }

        /* renamed from: a */
        public C2994a m2337a(HttpUrl httpUrl) {
            if (httpUrl == null) {
                throw new NullPointerException("url == null");
            }
            this.f10656a = httpUrl;
            return this;
        }

        /* renamed from: a */
        public C2994a m2341a(String str) {
            if (str == null) {
                throw new NullPointerException("url == null");
            }
            if (str.regionMatches(true, 0, "ws:", 0, 3)) {
                str = "http:" + str.substring(3);
            } else if (str.regionMatches(true, 0, "wss:", 0, 4)) {
                str = "https:" + str.substring(4);
            }
            return m2337a(HttpUrl.m2463f(str));
        }

        /* renamed from: a */
        public C2994a m2340a(String str, String str2) {
            this.f10658c.m2489c(str, str2);
            return this;
        }

        /* renamed from: b */
        public C2994a m2335b(String str, String str2) {
            this.f10658c.m2492a(str, str2);
            return this;
        }

        /* renamed from: b */
        public C2994a m2336b(String str) {
            this.f10658c.m2491b(str);
            return this;
        }

        /* renamed from: a */
        public C2994a m2338a(C2984s c2984s) {
            this.f10658c = c2984s.m2497b();
            return this;
        }

        /* renamed from: a */
        public C2994a m2339a(String str, @Nullable RequestBody requestBody) {
            if (str == null) {
                throw new NullPointerException("method == null");
            }
            if (str.length() == 0) {
                throw new IllegalArgumentException("method.length() == 0");
            }
            if (requestBody != null && !HttpMethod.m2921c(str)) {
                throw new IllegalArgumentException("method " + str + " must not have a request body.");
            } else if (requestBody == null && HttpMethod.m2922b(str)) {
                throw new IllegalArgumentException("method " + str + " must have a request body.");
            } else {
                this.f10657b = str;
                this.f10659d = requestBody;
                return this;
            }
        }

        /* renamed from: a */
        public C2993z m2342a() {
            if (this.f10656a == null) {
                throw new IllegalStateException("url == null");
            }
            return new C2993z(this);
        }
    }
}
