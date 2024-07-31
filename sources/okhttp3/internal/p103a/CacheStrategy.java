package okhttp3.internal.p103a;

import java.util.Date;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;
import okhttp3.C2984s;
import okhttp3.C2993z;
import okhttp3.CacheControl;
import okhttp3.Response;
import okhttp3.internal.Internal;
import okhttp3.internal.p104b.HttpDate;
import okhttp3.internal.p104b.HttpHeaders;

/* renamed from: okhttp3.internal.a.c */
/* loaded from: classes2.dex */
public final class CacheStrategy {
    @Nullable

    /* renamed from: a */
    public final C2993z f10108a;
    @Nullable

    /* renamed from: b */
    public final Response f10109b;

    CacheStrategy(C2993z c2993z, Response response) {
        this.f10108a = c2993z;
        this.f10109b = response;
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x002e, code lost:
        if (r3.m3023j().m2989d() == false) goto L19;
     */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean m2957a(okhttp3.Response r3, okhttp3.C2993z r4) {
        /*
            int r0 = r3.m3031b()
            r1 = 0
            switch(r0) {
                case 200: goto L30;
                case 203: goto L30;
                case 204: goto L30;
                case 300: goto L30;
                case 301: goto L30;
                case 302: goto L9;
                case 307: goto L9;
                case 308: goto L30;
                case 404: goto L30;
                case 405: goto L30;
                case 410: goto L30;
                case 414: goto L30;
                case 501: goto L30;
                default: goto L8;
            }
        L8:
            goto L46
        L9:
            java.lang.String r0 = "Expires"
            java.lang.String r0 = r3.m3033a(r0)
            if (r0 != 0) goto L30
            okhttp3.d r0 = r3.m3023j()
            int r0 = r0.m2990c()
            r2 = -1
            if (r0 != r2) goto L30
            okhttp3.d r0 = r3.m3023j()
            boolean r0 = r0.m2988e()
            if (r0 != 0) goto L30
            okhttp3.d r0 = r3.m3023j()
            boolean r0 = r0.m2989d()
            if (r0 == 0) goto L46
        L30:
            okhttp3.d r3 = r3.m3023j()
            boolean r3 = r3.m2991b()
            if (r3 != 0) goto L45
            okhttp3.d r3 = r4.m2344f()
            boolean r3 = r3.m2991b()
            if (r3 != 0) goto L45
            r1 = 1
        L45:
            return r1
        L46:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.p103a.CacheStrategy.m2957a(okhttp3.ab, okhttp3.z):boolean");
    }

    /* compiled from: CacheStrategy.java */
    /* renamed from: okhttp3.internal.a.c$a */
    /* loaded from: classes2.dex */
    public static class C2924a {

        /* renamed from: a */
        final long f10110a;

        /* renamed from: b */
        final C2993z f10111b;

        /* renamed from: c */
        final Response f10112c;

        /* renamed from: d */
        private Date f10113d;

        /* renamed from: e */
        private String f10114e;

        /* renamed from: f */
        private Date f10115f;

        /* renamed from: g */
        private String f10116g;

        /* renamed from: h */
        private Date f10117h;

        /* renamed from: i */
        private long f10118i;

        /* renamed from: j */
        private long f10119j;

        /* renamed from: k */
        private String f10120k;

        /* renamed from: l */
        private int f10121l;

        public C2924a(long j, C2993z c2993z, Response response) {
            this.f10121l = -1;
            this.f10110a = j;
            this.f10111b = c2993z;
            this.f10112c = response;
            if (response != null) {
                this.f10118i = response.m3022k();
                this.f10119j = response.m3021l();
                C2984s m3027f = response.m3027f();
                int m2502a = m3027f.m2502a();
                for (int i = 0; i < m2502a; i++) {
                    String m2501a = m3027f.m2501a(i);
                    String m2496b = m3027f.m2496b(i);
                    if ("Date".equalsIgnoreCase(m2501a)) {
                        this.f10113d = HttpDate.m2934a(m2496b);
                        this.f10114e = m2496b;
                    } else if ("Expires".equalsIgnoreCase(m2501a)) {
                        this.f10117h = HttpDate.m2934a(m2496b);
                    } else if ("Last-Modified".equalsIgnoreCase(m2501a)) {
                        this.f10115f = HttpDate.m2934a(m2496b);
                        this.f10116g = m2496b;
                    } else if ("ETag".equalsIgnoreCase(m2501a)) {
                        this.f10120k = m2496b;
                    } else if ("Age".equalsIgnoreCase(m2501a)) {
                        this.f10121l = HttpHeaders.m2925b(m2496b, -1);
                    }
                }
            }
        }

        /* renamed from: a */
        public CacheStrategy m2956a() {
            CacheStrategy m2954b = m2954b();
            return (m2954b.f10108a == null || !this.f10111b.m2344f().m2984i()) ? m2954b : new CacheStrategy(null, null);
        }

        /* renamed from: b */
        private CacheStrategy m2954b() {
            String str;
            if (this.f10112c == null) {
                return new CacheStrategy(this.f10111b, null);
            }
            if (this.f10111b.m2343g() && this.f10112c.m3028e() == null) {
                return new CacheStrategy(this.f10111b, null);
            }
            if (!CacheStrategy.m2957a(this.f10112c, this.f10111b)) {
                return new CacheStrategy(this.f10111b, null);
            }
            CacheControl m2344f = this.f10111b.m2344f();
            if (m2344f.m2993a() || m2955a(this.f10111b)) {
                return new CacheStrategy(this.f10111b, null);
            }
            CacheControl m3023j = this.f10112c.m3023j();
            if (m3023j.m2983j()) {
                return new CacheStrategy(null, this.f10112c);
            }
            long m2952d = m2952d();
            long m2953c = m2953c();
            if (m2344f.m2990c() != -1) {
                m2953c = Math.min(m2953c, TimeUnit.SECONDS.toMillis(m2344f.m2990c()));
            }
            long j = 0;
            long millis = m2344f.m2985h() != -1 ? TimeUnit.SECONDS.toMillis(m2344f.m2985h()) : 0L;
            if (!m3023j.m2987f() && m2344f.m2986g() != -1) {
                j = TimeUnit.SECONDS.toMillis(m2344f.m2986g());
            }
            if (!m3023j.m2993a()) {
                long j2 = millis + m2952d;
                if (j2 < j + m2953c) {
                    Response.C2912a m3025h = this.f10112c.m3025h();
                    if (j2 >= m2953c) {
                        m3025h.m3016a("Warning", "110 HttpURLConnection \"Response is stale\"");
                    }
                    if (m2952d > 86400000 && m2951e()) {
                        m3025h.m3016a("Warning", "113 HttpURLConnection \"Heuristic expiration\"");
                    }
                    return new CacheStrategy(null, m3025h.m3020a());
                }
            }
            String str2 = this.f10120k;
            if (str2 != null) {
                str = "If-None-Match";
            } else if (this.f10115f != null) {
                str = "If-Modified-Since";
                str2 = this.f10116g;
            } else if (this.f10113d != null) {
                str = "If-Modified-Since";
                str2 = this.f10114e;
            } else {
                return new CacheStrategy(this.f10111b, null);
            }
            C2984s.C2985a m2497b = this.f10111b.m2347c().m2497b();
            Internal.f10101a.mo2374a(m2497b, str, str2);
            return new CacheStrategy(this.f10111b.m2345e().m2338a(m2497b.m2494a()).m2342a(), this.f10112c);
        }

        /* renamed from: c */
        private long m2953c() {
            long j;
            long j2;
            CacheControl m3023j = this.f10112c.m3023j();
            if (m3023j.m2990c() != -1) {
                return TimeUnit.SECONDS.toMillis(m3023j.m2990c());
            }
            if (this.f10117h != null) {
                Date date = this.f10113d;
                if (date != null) {
                    j2 = date.getTime();
                } else {
                    j2 = this.f10119j;
                }
                long time = this.f10117h.getTime() - j2;
                if (time > 0) {
                    return time;
                }
                return 0L;
            } else if (this.f10115f == null || this.f10112c.m3034a().m2350a().m2457l() != null) {
                return 0L;
            } else {
                Date date2 = this.f10113d;
                if (date2 != null) {
                    j = date2.getTime();
                } else {
                    j = this.f10118i;
                }
                long time2 = j - this.f10115f.getTime();
                if (time2 > 0) {
                    return time2 / 10;
                }
                return 0L;
            }
        }

        /* renamed from: d */
        private long m2952d() {
            Date date = this.f10113d;
            long max = date != null ? Math.max(0L, this.f10119j - date.getTime()) : 0L;
            if (this.f10121l != -1) {
                max = Math.max(max, TimeUnit.SECONDS.toMillis(this.f10121l));
            }
            long j = this.f10119j;
            return max + (j - this.f10118i) + (this.f10110a - j);
        }

        /* renamed from: e */
        private boolean m2951e() {
            return this.f10112c.m3023j().m2990c() == -1 && this.f10117h == null;
        }

        /* renamed from: a */
        private static boolean m2955a(C2993z c2993z) {
            return (c2993z.m2349a("If-Modified-Since") == null && c2993z.m2349a("If-None-Match") == null) ? false : true;
        }
    }
}
