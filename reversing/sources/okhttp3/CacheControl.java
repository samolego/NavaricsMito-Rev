package okhttp3;

import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;
import okhttp3.internal.p104b.HttpHeaders;

/* renamed from: okhttp3.d */
/* loaded from: classes2.dex */
public final class CacheControl {

    /* renamed from: a */
    public static final CacheControl f9954a = new C2917a().m2981a().m2978c();

    /* renamed from: b */
    public static final CacheControl f9955b = new C2917a().m2979b().m2980a(Integer.MAX_VALUE, TimeUnit.SECONDS).m2978c();
    @Nullable

    /* renamed from: c */
    String f9956c;

    /* renamed from: d */
    private final boolean f9957d;

    /* renamed from: e */
    private final boolean f9958e;

    /* renamed from: f */
    private final int f9959f;

    /* renamed from: g */
    private final int f9960g;

    /* renamed from: h */
    private final boolean f9961h;

    /* renamed from: i */
    private final boolean f9962i;

    /* renamed from: j */
    private final boolean f9963j;

    /* renamed from: k */
    private final int f9964k;

    /* renamed from: l */
    private final int f9965l;

    /* renamed from: m */
    private final boolean f9966m;

    /* renamed from: n */
    private final boolean f9967n;

    /* renamed from: o */
    private final boolean f9968o;

    private CacheControl(boolean z, boolean z2, int i, int i2, boolean z3, boolean z4, boolean z5, int i3, int i4, boolean z6, boolean z7, boolean z8, @Nullable String str) {
        this.f9957d = z;
        this.f9958e = z2;
        this.f9959f = i;
        this.f9960g = i2;
        this.f9961h = z3;
        this.f9962i = z4;
        this.f9963j = z5;
        this.f9964k = i3;
        this.f9965l = i4;
        this.f9966m = z6;
        this.f9967n = z7;
        this.f9968o = z8;
        this.f9956c = str;
    }

    CacheControl(C2917a c2917a) {
        this.f9957d = c2917a.f9969a;
        this.f9958e = c2917a.f9970b;
        this.f9959f = c2917a.f9971c;
        this.f9960g = -1;
        this.f9961h = false;
        this.f9962i = false;
        this.f9963j = false;
        this.f9964k = c2917a.f9972d;
        this.f9965l = c2917a.f9973e;
        this.f9966m = c2917a.f9974f;
        this.f9967n = c2917a.f9975g;
        this.f9968o = c2917a.f9976h;
    }

    /* renamed from: a */
    public boolean m2993a() {
        return this.f9957d;
    }

    /* renamed from: b */
    public boolean m2991b() {
        return this.f9958e;
    }

    /* renamed from: c */
    public int m2990c() {
        return this.f9959f;
    }

    /* renamed from: d */
    public boolean m2989d() {
        return this.f9961h;
    }

    /* renamed from: e */
    public boolean m2988e() {
        return this.f9962i;
    }

    /* renamed from: f */
    public boolean m2987f() {
        return this.f9963j;
    }

    /* renamed from: g */
    public int m2986g() {
        return this.f9964k;
    }

    /* renamed from: h */
    public int m2985h() {
        return this.f9965l;
    }

    /* renamed from: i */
    public boolean m2984i() {
        return this.f9966m;
    }

    /* renamed from: j */
    public boolean m2983j() {
        return this.f9968o;
    }

    /* renamed from: a */
    public static CacheControl m2992a(C2984s c2984s) {
        int i;
        String str;
        C2984s c2984s2 = c2984s;
        int m2502a = c2984s.m2502a();
        int i2 = 0;
        boolean z = true;
        String str2 = null;
        boolean z2 = false;
        boolean z3 = false;
        int i3 = -1;
        int i4 = -1;
        boolean z4 = false;
        boolean z5 = false;
        boolean z6 = false;
        int i5 = -1;
        int i6 = -1;
        boolean z7 = false;
        boolean z8 = false;
        boolean z9 = false;
        while (i2 < m2502a) {
            String m2501a = c2984s2.m2501a(i2);
            String m2496b = c2984s2.m2496b(i2);
            if (m2501a.equalsIgnoreCase("Cache-Control")) {
                if (str2 != null) {
                    z = false;
                } else {
                    str2 = m2496b;
                }
            } else if (m2501a.equalsIgnoreCase("Pragma")) {
                z = false;
            } else {
                i2++;
                c2984s2 = c2984s;
            }
            for (int i7 = 0; i7 < m2496b.length(); i7 = i) {
                int m2929a = HttpHeaders.m2929a(m2496b, i7, "=,;");
                String trim = m2496b.substring(i7, m2929a).trim();
                if (m2929a == m2496b.length() || m2496b.charAt(m2929a) == ',' || m2496b.charAt(m2929a) == ';') {
                    i = m2929a + 1;
                    str = null;
                } else {
                    int m2930a = HttpHeaders.m2930a(m2496b, m2929a + 1);
                    if (m2930a < m2496b.length() && m2496b.charAt(m2930a) == '\"') {
                        int i8 = m2930a + 1;
                        int m2929a2 = HttpHeaders.m2929a(m2496b, i8, "\"");
                        str = m2496b.substring(i8, m2929a2);
                        i = m2929a2 + 1;
                    } else {
                        i = HttpHeaders.m2929a(m2496b, m2930a, ",;");
                        str = m2496b.substring(m2930a, i).trim();
                    }
                }
                if ("no-cache".equalsIgnoreCase(trim)) {
                    z2 = true;
                } else if ("no-store".equalsIgnoreCase(trim)) {
                    z3 = true;
                } else if ("max-age".equalsIgnoreCase(trim)) {
                    i3 = HttpHeaders.m2925b(str, -1);
                } else if ("s-maxage".equalsIgnoreCase(trim)) {
                    i4 = HttpHeaders.m2925b(str, -1);
                } else if ("private".equalsIgnoreCase(trim)) {
                    z4 = true;
                } else if ("public".equalsIgnoreCase(trim)) {
                    z5 = true;
                } else if ("must-revalidate".equalsIgnoreCase(trim)) {
                    z6 = true;
                } else if ("max-stale".equalsIgnoreCase(trim)) {
                    i5 = HttpHeaders.m2925b(str, Integer.MAX_VALUE);
                } else if ("min-fresh".equalsIgnoreCase(trim)) {
                    i6 = HttpHeaders.m2925b(str, -1);
                } else if ("only-if-cached".equalsIgnoreCase(trim)) {
                    z7 = true;
                } else if ("no-transform".equalsIgnoreCase(trim)) {
                    z8 = true;
                } else if ("immutable".equalsIgnoreCase(trim)) {
                    z9 = true;
                }
            }
            i2++;
            c2984s2 = c2984s;
        }
        return new CacheControl(z2, z3, i3, i4, z4, z5, z6, i5, i6, z7, z8, z9, !z ? null : str2);
    }

    public String toString() {
        String str = this.f9956c;
        if (str != null) {
            return str;
        }
        String m2982k = m2982k();
        this.f9956c = m2982k;
        return m2982k;
    }

    /* renamed from: k */
    private String m2982k() {
        StringBuilder sb = new StringBuilder();
        if (this.f9957d) {
            sb.append("no-cache, ");
        }
        if (this.f9958e) {
            sb.append("no-store, ");
        }
        if (this.f9959f != -1) {
            sb.append("max-age=");
            sb.append(this.f9959f);
            sb.append(", ");
        }
        if (this.f9960g != -1) {
            sb.append("s-maxage=");
            sb.append(this.f9960g);
            sb.append(", ");
        }
        if (this.f9961h) {
            sb.append("private, ");
        }
        if (this.f9962i) {
            sb.append("public, ");
        }
        if (this.f9963j) {
            sb.append("must-revalidate, ");
        }
        if (this.f9964k != -1) {
            sb.append("max-stale=");
            sb.append(this.f9964k);
            sb.append(", ");
        }
        if (this.f9965l != -1) {
            sb.append("min-fresh=");
            sb.append(this.f9965l);
            sb.append(", ");
        }
        if (this.f9966m) {
            sb.append("only-if-cached, ");
        }
        if (this.f9967n) {
            sb.append("no-transform, ");
        }
        if (this.f9968o) {
            sb.append("immutable, ");
        }
        if (sb.length() == 0) {
            return "";
        }
        sb.delete(sb.length() - 2, sb.length());
        return sb.toString();
    }

    /* compiled from: CacheControl.java */
    /* renamed from: okhttp3.d$a */
    /* loaded from: classes2.dex */
    public static final class C2917a {

        /* renamed from: a */
        boolean f9969a;

        /* renamed from: b */
        boolean f9970b;

        /* renamed from: c */
        int f9971c = -1;

        /* renamed from: d */
        int f9972d = -1;

        /* renamed from: e */
        int f9973e = -1;

        /* renamed from: f */
        boolean f9974f;

        /* renamed from: g */
        boolean f9975g;

        /* renamed from: h */
        boolean f9976h;

        /* renamed from: a */
        public C2917a m2981a() {
            this.f9969a = true;
            return this;
        }

        /* renamed from: a */
        public C2917a m2980a(int i, TimeUnit timeUnit) {
            if (i < 0) {
                throw new IllegalArgumentException("maxStale < 0: " + i);
            }
            long seconds = timeUnit.toSeconds(i);
            this.f9972d = seconds > 2147483647L ? Integer.MAX_VALUE : (int) seconds;
            return this;
        }

        /* renamed from: b */
        public C2917a m2979b() {
            this.f9974f = true;
            return this;
        }

        /* renamed from: c */
        public CacheControl m2978c() {
            return new CacheControl(this);
        }
    }
}
