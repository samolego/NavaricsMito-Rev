package okhttp3;

import com.senseplay.sdk.tool.IniEditor;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.annotation.Nullable;
import okhttp3.internal.C2930c;
import okio.Buffer;
import org.slf4j.Marker;

/* renamed from: okhttp3.t */
/* loaded from: classes2.dex */
public final class HttpUrl {

    /* renamed from: d */
    private static final char[] f10544d = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    /* renamed from: a */
    final String f10545a;

    /* renamed from: b */
    final String f10546b;

    /* renamed from: c */
    final int f10547c;

    /* renamed from: e */
    private final String f10548e;

    /* renamed from: f */
    private final String f10549f;

    /* renamed from: g */
    private final List<String> f10550g;
    @Nullable

    /* renamed from: h */
    private final List<String> f10551h;
    @Nullable

    /* renamed from: i */
    private final String f10552i;

    /* renamed from: j */
    private final String f10553j;

    HttpUrl(C2986a c2986a) {
        this.f10545a = c2986a.f10554a;
        this.f10548e = m2479a(c2986a.f10555b, false);
        this.f10549f = m2479a(c2986a.f10556c, false);
        this.f10546b = c2986a.f10557d;
        this.f10547c = c2986a.m2452a();
        this.f10550g = m2477a(c2986a.f10559f, false);
        this.f10551h = c2986a.f10560g != null ? m2477a(c2986a.f10560g, true) : null;
        this.f10552i = c2986a.f10561h != null ? m2479a(c2986a.f10561h, false) : null;
        this.f10553j = c2986a.toString();
    }

    /* renamed from: a */
    public URI m2487a() {
        String c2986a = m2453p().m2445b().toString();
        try {
            return new URI(c2986a);
        } catch (URISyntaxException e) {
            try {
                return URI.create(c2986a.replaceAll("[\\u0000-\\u001F\\u007F-\\u009F\\p{javaWhitespace}]", ""));
            } catch (Exception unused) {
                throw new RuntimeException(e);
            }
        }
    }

    /* renamed from: b */
    public String m2474b() {
        return this.f10545a;
    }

    /* renamed from: c */
    public boolean m2470c() {
        return this.f10545a.equals("https");
    }

    /* renamed from: d */
    public String m2468d() {
        if (this.f10548e.isEmpty()) {
            return "";
        }
        int length = this.f10545a.length() + 3;
        String str = this.f10553j;
        return this.f10553j.substring(length, C2930c.m2891a(str, length, str.length(), ":@"));
    }

    /* renamed from: e */
    public String m2466e() {
        if (this.f10549f.isEmpty()) {
            return "";
        }
        int indexOf = this.f10553j.indexOf(64);
        return this.f10553j.substring(this.f10553j.indexOf(58, this.f10545a.length() + 3) + 1, indexOf);
    }

    /* renamed from: f */
    public String m2464f() {
        return this.f10546b;
    }

    /* renamed from: g */
    public int m2462g() {
        return this.f10547c;
    }

    /* renamed from: a */
    public static int m2485a(String str) {
        if (str.equals("http")) {
            return 80;
        }
        return str.equals("https") ? 443 : -1;
    }

    /* renamed from: h */
    public String m2461h() {
        int indexOf = this.f10553j.indexOf(47, this.f10545a.length() + 3);
        String str = this.f10553j;
        return this.f10553j.substring(indexOf, C2930c.m2891a(str, indexOf, str.length(), "?#"));
    }

    /* renamed from: a */
    static void m2478a(StringBuilder sb, List<String> list) {
        int size = list.size();
        for (int i = 0; i < size; i++) {
            sb.append('/');
            sb.append(list.get(i));
        }
    }

    /* renamed from: i */
    public List<String> m2460i() {
        int indexOf = this.f10553j.indexOf(47, this.f10545a.length() + 3);
        String str = this.f10553j;
        int m2891a = C2930c.m2891a(str, indexOf, str.length(), "?#");
        ArrayList arrayList = new ArrayList();
        while (indexOf < m2891a) {
            int i = indexOf + 1;
            int m2892a = C2930c.m2892a(this.f10553j, i, m2891a, '/');
            arrayList.add(this.f10553j.substring(i, m2892a));
            indexOf = m2892a;
        }
        return arrayList;
    }

    /* renamed from: j */
    public List<String> m2459j() {
        return this.f10550g;
    }

    @Nullable
    /* renamed from: k */
    public String m2458k() {
        if (this.f10551h == null) {
            return null;
        }
        int indexOf = this.f10553j.indexOf(63) + 1;
        String str = this.f10553j;
        return this.f10553j.substring(indexOf, C2930c.m2892a(str, indexOf, str.length(), '#'));
    }

    /* renamed from: b */
    static void m2471b(StringBuilder sb, List<String> list) {
        int size = list.size();
        for (int i = 0; i < size; i += 2) {
            String str = list.get(i);
            String str2 = list.get(i + 1);
            if (i > 0) {
                sb.append('&');
            }
            sb.append(str);
            if (str2 != null) {
                sb.append('=');
                sb.append(str2);
            }
        }
    }

    /* renamed from: b */
    static List<String> m2472b(String str) {
        ArrayList arrayList = new ArrayList();
        int i = 0;
        while (i <= str.length()) {
            int indexOf = str.indexOf(38, i);
            if (indexOf == -1) {
                indexOf = str.length();
            }
            int indexOf2 = str.indexOf(61, i);
            if (indexOf2 == -1 || indexOf2 > indexOf) {
                arrayList.add(str.substring(i, indexOf));
                arrayList.add(null);
            } else {
                arrayList.add(str.substring(i, indexOf2));
                arrayList.add(str.substring(indexOf2 + 1, indexOf));
            }
            i = indexOf + 1;
        }
        return arrayList;
    }

    @Nullable
    /* renamed from: l */
    public String m2457l() {
        if (this.f10551h == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        m2471b(sb, this.f10551h);
        return sb.toString();
    }

    /* renamed from: m */
    public int m2456m() {
        List<String> list = this.f10551h;
        if (list != null) {
            return list.size() / 2;
        }
        return 0;
    }

    /* renamed from: a */
    public String m2486a(int i) {
        List<String> list = this.f10551h;
        if (list == null) {
            throw new IndexOutOfBoundsException();
        }
        return list.get(i * 2);
    }

    /* renamed from: b */
    public String m2473b(int i) {
        List<String> list = this.f10551h;
        if (list == null) {
            throw new IndexOutOfBoundsException();
        }
        return list.get((i * 2) + 1);
    }

    @Nullable
    /* renamed from: n */
    public String m2455n() {
        if (this.f10552i == null) {
            return null;
        }
        return this.f10553j.substring(this.f10553j.indexOf(35) + 1);
    }

    /* renamed from: o */
    public String m2454o() {
        return m2467d("/...").m2444b("").m2440c("").m2441c().toString();
    }

    @Nullable
    /* renamed from: c */
    public HttpUrl m2469c(String str) {
        C2986a m2467d = m2467d(str);
        if (m2467d != null) {
            return m2467d.m2441c();
        }
        return null;
    }

    /* renamed from: p */
    public C2986a m2453p() {
        C2986a c2986a = new C2986a();
        c2986a.f10554a = this.f10545a;
        c2986a.f10555b = m2468d();
        c2986a.f10556c = m2466e();
        c2986a.f10557d = this.f10546b;
        c2986a.f10558e = this.f10547c != m2485a(this.f10545a) ? this.f10547c : -1;
        c2986a.f10559f.clear();
        c2986a.f10559f.addAll(m2460i());
        c2986a.m2433f(m2458k());
        c2986a.f10561h = m2455n();
        return c2986a;
    }

    @Nullable
    /* renamed from: d */
    public C2986a m2467d(String str) {
        try {
            return new C2986a().m2446a(this, str);
        } catch (IllegalArgumentException unused) {
            return null;
        }
    }

    @Nullable
    /* renamed from: e */
    public static HttpUrl m2465e(String str) {
        try {
            return m2463f(str);
        } catch (IllegalArgumentException unused) {
            return null;
        }
    }

    /* renamed from: f */
    public static HttpUrl m2463f(String str) {
        return new C2986a().m2446a((HttpUrl) null, str).m2441c();
    }

    public boolean equals(@Nullable Object obj) {
        return (obj instanceof HttpUrl) && ((HttpUrl) obj).f10553j.equals(this.f10553j);
    }

    public int hashCode() {
        return this.f10553j.hashCode();
    }

    public String toString() {
        return this.f10553j;
    }

    /* compiled from: HttpUrl.java */
    /* renamed from: okhttp3.t$a */
    /* loaded from: classes2.dex */
    public static final class C2986a {
        @Nullable

        /* renamed from: a */
        String f10554a;
        @Nullable

        /* renamed from: d */
        String f10557d;
        @Nullable

        /* renamed from: g */
        List<String> f10560g;
        @Nullable

        /* renamed from: h */
        String f10561h;

        /* renamed from: b */
        String f10555b = "";

        /* renamed from: c */
        String f10556c = "";

        /* renamed from: e */
        int f10558e = -1;

        /* renamed from: f */
        final List<String> f10559f = new ArrayList();

        public C2986a() {
            this.f10559f.add("");
        }

        /* renamed from: a */
        public C2986a m2450a(String str) {
            if (str == null) {
                throw new NullPointerException("scheme == null");
            }
            if (str.equalsIgnoreCase("http")) {
                this.f10554a = "http";
            } else if (str.equalsIgnoreCase("https")) {
                this.f10554a = "https";
            } else {
                throw new IllegalArgumentException("unexpected scheme: " + str);
            }
            return this;
        }

        /* renamed from: b */
        public C2986a m2444b(String str) {
            if (str == null) {
                throw new NullPointerException("username == null");
            }
            this.f10555b = HttpUrl.m2481a(str, " \"':;<=>@[]^`{}|/\\?#", false, false, false, true);
            return this;
        }

        /* renamed from: c */
        public C2986a m2440c(String str) {
            if (str == null) {
                throw new NullPointerException("password == null");
            }
            this.f10556c = HttpUrl.m2481a(str, " \"':;<=>@[]^`{}|/\\?#", false, false, false, true);
            return this;
        }

        /* renamed from: d */
        public C2986a m2437d(String str) {
            if (str == null) {
                throw new NullPointerException("host == null");
            }
            String m2434e = m2434e(str, 0, str.length());
            if (m2434e == null) {
                throw new IllegalArgumentException("unexpected host: " + str);
            }
            this.f10557d = m2434e;
            return this;
        }

        /* renamed from: a */
        public C2986a m2451a(int i) {
            if (i <= 0 || i > 65535) {
                throw new IllegalArgumentException("unexpected port: " + i);
            }
            this.f10558e = i;
            return this;
        }

        /* renamed from: a */
        int m2452a() {
            int i = this.f10558e;
            return i != -1 ? i : HttpUrl.m2485a(this.f10554a);
        }

        /* renamed from: e */
        public C2986a m2435e(@Nullable String str) {
            this.f10560g = str != null ? HttpUrl.m2472b(HttpUrl.m2481a(str, " \"'<>#", false, false, true, true)) : null;
            return this;
        }

        /* renamed from: f */
        public C2986a m2433f(@Nullable String str) {
            this.f10560g = str != null ? HttpUrl.m2472b(HttpUrl.m2481a(str, " \"'<>#", true, false, true, true)) : null;
            return this;
        }

        /* renamed from: a */
        public C2986a m2447a(String str, @Nullable String str2) {
            if (str == null) {
                throw new NullPointerException("name == null");
            }
            if (this.f10560g == null) {
                this.f10560g = new ArrayList();
            }
            this.f10560g.add(HttpUrl.m2481a(str, " !\"#$&'(),/:;<=>?@[]\\^`{|}~", false, false, true, true));
            this.f10560g.add(str2 != null ? HttpUrl.m2481a(str2, " !\"#$&'(),/:;<=>?@[]\\^`{|}~", false, false, true, true) : null);
            return this;
        }

        /* renamed from: b */
        public C2986a m2442b(String str, @Nullable String str2) {
            if (str == null) {
                throw new NullPointerException("encodedName == null");
            }
            if (this.f10560g == null) {
                this.f10560g = new ArrayList();
            }
            this.f10560g.add(HttpUrl.m2481a(str, " \"'<>#&=", true, false, true, true));
            this.f10560g.add(str2 != null ? HttpUrl.m2481a(str2, " \"'<>#&=", true, false, true, true) : null);
            return this;
        }

        /* renamed from: b */
        C2986a m2445b() {
            int size = this.f10559f.size();
            for (int i = 0; i < size; i++) {
                this.f10559f.set(i, HttpUrl.m2481a(this.f10559f.get(i), "[]", true, true, false, true));
            }
            List<String> list = this.f10560g;
            if (list != null) {
                int size2 = list.size();
                for (int i2 = 0; i2 < size2; i2++) {
                    String str = this.f10560g.get(i2);
                    if (str != null) {
                        this.f10560g.set(i2, HttpUrl.m2481a(str, "\\^`{|}", true, true, true, true));
                    }
                }
            }
            String str2 = this.f10561h;
            if (str2 != null) {
                this.f10561h = HttpUrl.m2481a(str2, " \"#<>\\^`{|}", true, true, false, false);
            }
            return this;
        }

        /* renamed from: c */
        public HttpUrl m2441c() {
            if (this.f10554a == null) {
                throw new IllegalStateException("scheme == null");
            }
            if (this.f10557d == null) {
                throw new IllegalStateException("host == null");
            }
            return new HttpUrl(this);
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append(this.f10554a);
            sb.append("://");
            if (!this.f10555b.isEmpty() || !this.f10556c.isEmpty()) {
                sb.append(this.f10555b);
                if (!this.f10556c.isEmpty()) {
                    sb.append(':');
                    sb.append(this.f10556c);
                }
                sb.append('@');
            }
            if (this.f10557d.indexOf(58) != -1) {
                sb.append(IniEditor.Section.HEADER_START);
                sb.append(this.f10557d);
                sb.append(IniEditor.Section.HEADER_END);
            } else {
                sb.append(this.f10557d);
            }
            int m2452a = m2452a();
            if (m2452a != HttpUrl.m2485a(this.f10554a)) {
                sb.append(':');
                sb.append(m2452a);
            }
            HttpUrl.m2478a(sb, this.f10559f);
            if (this.f10560g != null) {
                sb.append('?');
                HttpUrl.m2471b(sb, this.f10560g);
            }
            if (this.f10561h != null) {
                sb.append('#');
                sb.append(this.f10561h);
            }
            return sb.toString();
        }

        /* renamed from: a */
        C2986a m2446a(@Nullable HttpUrl httpUrl, String str) {
            int m2443b;
            int m2891a;
            int i;
            int m2893a = C2930c.m2893a(str, 0, str.length());
            int m2872b = C2930c.m2872b(str, m2893a, str.length());
            if (m2443b(str, m2893a, m2872b) != -1) {
                if (str.regionMatches(true, m2893a, "https:", 0, 6)) {
                    this.f10554a = "https";
                    m2893a += 6;
                } else if (str.regionMatches(true, m2893a, "http:", 0, 5)) {
                    this.f10554a = "http";
                    m2893a += 5;
                } else {
                    throw new IllegalArgumentException("Expected URL scheme 'http' or 'https' but was '" + str.substring(0, m2443b) + "'");
                }
            } else if (httpUrl != null) {
                this.f10554a = httpUrl.f10545a;
            } else {
                throw new IllegalArgumentException("Expected URL scheme 'http' or 'https' but no colon was found");
            }
            int m2439c = m2439c(str, m2893a, m2872b);
            char c = '#';
            if (m2439c >= 2 || httpUrl == null || !httpUrl.f10545a.equals(this.f10554a)) {
                int i2 = m2893a + m2439c;
                boolean z = false;
                boolean z2 = false;
                while (true) {
                    m2891a = C2930c.m2891a(str, i2, m2872b, "@/\\?#");
                    char charAt = m2891a != m2872b ? str.charAt(m2891a) : (char) 65535;
                    if (charAt != 65535 && charAt != c && charAt != '/' && charAt != '\\') {
                        switch (charAt) {
                            case '@':
                                if (!z) {
                                    int m2892a = C2930c.m2892a(str, i2, m2891a, ':');
                                    i = m2891a;
                                    String m2483a = HttpUrl.m2483a(str, i2, m2892a, " \"':;<=>@[]^`{}|/\\?#", true, false, false, true, null);
                                    if (z2) {
                                        m2483a = this.f10555b + "%40" + m2483a;
                                    }
                                    this.f10555b = m2483a;
                                    if (m2892a != i) {
                                        this.f10556c = HttpUrl.m2483a(str, m2892a + 1, i, " \"':;<=>@[]^`{}|/\\?#", true, false, false, true, null);
                                        z = true;
                                    }
                                    z2 = true;
                                } else {
                                    i = m2891a;
                                    this.f10556c += "%40" + HttpUrl.m2483a(str, i2, i, " \"':;<=>@[]^`{}|/\\?#", true, false, false, true, null);
                                }
                                i2 = i + 1;
                                break;
                        }
                        c = '#';
                    }
                }
                int m2436d = m2436d(str, i2, m2891a);
                int i3 = m2436d + 1;
                if (i3 < m2891a) {
                    this.f10557d = m2434e(str, i2, m2436d);
                    this.f10558e = m2432f(str, i3, m2891a);
                    if (this.f10558e == -1) {
                        throw new IllegalArgumentException("Invalid URL port: \"" + str.substring(i3, m2891a) + '\"');
                    }
                } else {
                    this.f10557d = m2434e(str, i2, m2436d);
                    this.f10558e = HttpUrl.m2485a(this.f10554a);
                }
                if (this.f10557d == null) {
                    throw new IllegalArgumentException("Invalid URL host: \"" + str.substring(i2, m2436d) + '\"');
                }
                m2893a = m2891a;
            } else {
                this.f10555b = httpUrl.m2468d();
                this.f10556c = httpUrl.m2466e();
                this.f10557d = httpUrl.f10546b;
                this.f10558e = httpUrl.f10547c;
                this.f10559f.clear();
                this.f10559f.addAll(httpUrl.m2460i());
                if (m2893a == m2872b || str.charAt(m2893a) == '#') {
                    m2433f(httpUrl.m2458k());
                }
            }
            int m2891a2 = C2930c.m2891a(str, m2893a, m2872b, "?#");
            m2449a(str, m2893a, m2891a2);
            if (m2891a2 < m2872b && str.charAt(m2891a2) == '?') {
                int m2892a2 = C2930c.m2892a(str, m2891a2, m2872b, '#');
                this.f10560g = HttpUrl.m2472b(HttpUrl.m2483a(str, m2891a2 + 1, m2892a2, " \"'<>#", true, false, true, true, null));
                m2891a2 = m2892a2;
            }
            if (m2891a2 < m2872b && str.charAt(m2891a2) == '#') {
                this.f10561h = HttpUrl.m2483a(str, 1 + m2891a2, m2872b, "", true, false, false, false, null);
            }
            return this;
        }

        /* renamed from: a */
        private void m2449a(String str, int i, int i2) {
            if (i == i2) {
                return;
            }
            char charAt = str.charAt(i);
            if (charAt == '/' || charAt == '\\') {
                this.f10559f.clear();
                this.f10559f.add("");
                i++;
            } else {
                List<String> list = this.f10559f;
                list.set(list.size() - 1, "");
            }
            int i3 = i;
            while (i3 < i2) {
                int m2891a = C2930c.m2891a(str, i3, i2, "/\\");
                boolean z = m2891a < i2;
                m2448a(str, i3, m2891a, z, true);
                if (z) {
                    m2891a++;
                }
                i3 = m2891a;
            }
        }

        /* renamed from: a */
        private void m2448a(String str, int i, int i2, boolean z, boolean z2) {
            String m2483a = HttpUrl.m2483a(str, i, i2, " \"<>^`{}|/\\?#", z2, false, false, true, null);
            if (m2431g(m2483a)) {
                return;
            }
            if (m2430h(m2483a)) {
                m2438d();
                return;
            }
            List<String> list = this.f10559f;
            if (list.get(list.size() - 1).isEmpty()) {
                List<String> list2 = this.f10559f;
                list2.set(list2.size() - 1, m2483a);
            } else {
                this.f10559f.add(m2483a);
            }
            if (z) {
                this.f10559f.add("");
            }
        }

        /* renamed from: g */
        private boolean m2431g(String str) {
            return str.equals(".") || str.equalsIgnoreCase("%2e");
        }

        /* renamed from: h */
        private boolean m2430h(String str) {
            return str.equals("..") || str.equalsIgnoreCase("%2e.") || str.equalsIgnoreCase(".%2e") || str.equalsIgnoreCase("%2e%2e");
        }

        /* renamed from: d */
        private void m2438d() {
            List<String> list = this.f10559f;
            if (list.remove(list.size() - 1).isEmpty() && !this.f10559f.isEmpty()) {
                List<String> list2 = this.f10559f;
                list2.set(list2.size() - 1, "");
                return;
            }
            this.f10559f.add("");
        }

        /* renamed from: b */
        private static int m2443b(String str, int i, int i2) {
            if (i2 - i < 2) {
                return -1;
            }
            char charAt = str.charAt(i);
            if ((charAt < 'a' || charAt > 'z') && (charAt < 'A' || charAt > 'Z')) {
                return -1;
            }
            while (true) {
                i++;
                if (i >= i2) {
                    return -1;
                }
                char charAt2 = str.charAt(i);
                if (charAt2 < 'a' || charAt2 > 'z') {
                    if (charAt2 < 'A' || charAt2 > 'Z') {
                        if (charAt2 < '0' || charAt2 > '9') {
                            if (charAt2 != '+' && charAt2 != '-' && charAt2 != '.') {
                                if (charAt2 == ':') {
                                    return i;
                                }
                                return -1;
                            }
                        }
                    }
                }
            }
        }

        /* renamed from: c */
        private static int m2439c(String str, int i, int i2) {
            int i3 = 0;
            while (i < i2) {
                char charAt = str.charAt(i);
                if (charAt != '\\' && charAt != '/') {
                    break;
                }
                i3++;
                i++;
            }
            return i3;
        }

        /* renamed from: d */
        private static int m2436d(String str, int i, int i2) {
            while (i < i2) {
                char charAt = str.charAt(i);
                if (charAt == ':') {
                    return i;
                }
                if (charAt == '[') {
                    do {
                        i++;
                        if (i < i2) {
                        }
                    } while (str.charAt(i) != ']');
                }
                i++;
            }
            return i2;
        }

        /* renamed from: e */
        private static String m2434e(String str, int i, int i2) {
            return C2930c.m2894a(HttpUrl.m2482a(str, i, i2, false));
        }

        /* renamed from: f */
        private static int m2432f(String str, int i, int i2) {
            try {
                int parseInt = Integer.parseInt(HttpUrl.m2483a(str, i, i2, "", false, false, false, true, null));
                if (parseInt <= 0 || parseInt > 65535) {
                    return -1;
                }
                return parseInt;
            } catch (NumberFormatException unused) {
                return -1;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public static String m2479a(String str, boolean z) {
        return m2482a(str, 0, str.length(), z);
    }

    /* renamed from: a */
    private List<String> m2477a(List<String> list, boolean z) {
        int size = list.size();
        ArrayList arrayList = new ArrayList(size);
        for (int i = 0; i < size; i++) {
            String str = list.get(i);
            arrayList.add(str != null ? m2479a(str, z) : null);
        }
        return Collections.unmodifiableList(arrayList);
    }

    /* renamed from: a */
    static String m2482a(String str, int i, int i2, boolean z) {
        for (int i3 = i; i3 < i2; i3++) {
            char charAt = str.charAt(i3);
            if (charAt == '%' || (charAt == '+' && z)) {
                Buffer buffer = new Buffer();
                buffer.m2307a(str, i, i3);
                m2475a(buffer, str, i3, i2, z);
                return buffer.m2285p();
            }
        }
        return str.substring(i, i2);
    }

    /* renamed from: a */
    static void m2475a(Buffer buffer, String str, int i, int i2, boolean z) {
        int i3;
        while (i < i2) {
            int codePointAt = str.codePointAt(i);
            if (codePointAt == 37 && (i3 = i + 2) < i2) {
                int m2899a = C2930c.m2899a(str.charAt(i + 1));
                int m2899a2 = C2930c.m2899a(str.charAt(i3));
                if (m2899a != -1 && m2899a2 != -1) {
                    buffer.mo2251i((m2899a << 4) + m2899a2);
                    i = i3;
                }
                buffer.m2311a(codePointAt);
            } else {
                if (codePointAt == 43 && z) {
                    buffer.mo2251i(32);
                }
                buffer.m2311a(codePointAt);
            }
            i += Character.charCount(codePointAt);
        }
    }

    /* renamed from: a */
    static boolean m2484a(String str, int i, int i2) {
        int i3 = i + 2;
        return i3 < i2 && str.charAt(i) == '%' && C2930c.m2899a(str.charAt(i + 1)) != -1 && C2930c.m2899a(str.charAt(i3)) != -1;
    }

    /* renamed from: a */
    static String m2483a(String str, int i, int i2, String str2, boolean z, boolean z2, boolean z3, boolean z4, Charset charset) {
        int i3 = i;
        while (i3 < i2) {
            int codePointAt = str.codePointAt(i3);
            if (codePointAt >= 32 && codePointAt != 127 && (codePointAt < 128 || !z4)) {
                if (str2.indexOf(codePointAt) == -1 && ((codePointAt != 37 || (z && (!z2 || m2484a(str, i3, i2)))) && (codePointAt != 43 || !z3))) {
                    i3 += Character.charCount(codePointAt);
                }
            }
            Buffer buffer = new Buffer();
            buffer.m2307a(str, i, i3);
            m2476a(buffer, str, i3, i2, str2, z, z2, z3, z4, charset);
            return buffer.m2285p();
        }
        return str.substring(i, i2);
    }

    /* renamed from: a */
    static void m2476a(Buffer buffer, String str, int i, int i2, String str2, boolean z, boolean z2, boolean z3, boolean z4, Charset charset) {
        Buffer buffer2 = null;
        while (i < i2) {
            int codePointAt = str.codePointAt(i);
            if (!z || (codePointAt != 9 && codePointAt != 10 && codePointAt != 12 && codePointAt != 13)) {
                if (codePointAt == 43 && z3) {
                    buffer.mo2257b(z ? Marker.ANY_NON_NULL_MARKER : "%2B");
                } else if (codePointAt < 32 || codePointAt == 127 || ((codePointAt >= 128 && z4) || str2.indexOf(codePointAt) != -1 || (codePointAt == 37 && (!z || (z2 && !m2484a(str, i, i2)))))) {
                    if (buffer2 == null) {
                        buffer2 = new Buffer();
                    }
                    if (charset == null || charset.equals(C2930c.f10183e)) {
                        buffer2.m2311a(codePointAt);
                    } else {
                        buffer2.m2306a(str, i, Character.charCount(codePointAt) + i, charset);
                    }
                    while (!buffer2.mo2236f()) {
                        int mo2232i = buffer2.mo2232i() & 255;
                        buffer.mo2251i(37);
                        buffer.mo2251i((int) f10544d[(mo2232i >> 4) & 15]);
                        buffer.mo2251i((int) f10544d[mo2232i & 15]);
                    }
                } else {
                    buffer.m2311a(codePointAt);
                }
            }
            i += Character.charCount(codePointAt);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public static String m2480a(String str, String str2, boolean z, boolean z2, boolean z3, boolean z4, Charset charset) {
        return m2483a(str, 0, str.length(), str2, z, z2, z3, z4, charset);
    }

    /* renamed from: a */
    static String m2481a(String str, String str2, boolean z, boolean z2, boolean z3, boolean z4) {
        return m2483a(str, 0, str.length(), str2, z, z2, z3, z4, null);
    }
}
