package okhttp3.internal.p104b;

import java.util.List;
import java.util.regex.Pattern;
import okhttp3.C2984s;
import okhttp3.Cookie;
import okhttp3.CookieJar;
import okhttp3.HttpUrl;
import okhttp3.Response;

/* renamed from: okhttp3.internal.b.e */
/* loaded from: classes2.dex */
public final class HttpHeaders {

    /* renamed from: a */
    private static final Pattern f10155a = Pattern.compile(" +([^ \"=]*)=(:?\"([^\"]*)\"|([^ \"=]*)) *(:?,|$)");

    /* renamed from: a */
    public static long m2928a(Response response) {
        return m2926a(response.m3027f());
    }

    /* renamed from: a */
    public static long m2926a(C2984s c2984s) {
        return m2931a(c2984s.m2500a("Content-Length"));
    }

    /* renamed from: a */
    private static long m2931a(String str) {
        if (str == null) {
            return -1L;
        }
        try {
            return Long.parseLong(str);
        } catch (NumberFormatException unused) {
            return -1L;
        }
    }

    /* renamed from: a */
    public static void m2927a(CookieJar cookieJar, HttpUrl httpUrl, C2984s c2984s) {
        if (cookieJar == CookieJar.f10521a) {
            return;
        }
        List<Cookie> m2555a = Cookie.m2555a(httpUrl, c2984s);
        if (m2555a.isEmpty()) {
            return;
        }
        cookieJar.mo2546a(httpUrl, m2555a);
    }

    /* renamed from: b */
    public static boolean m2924b(Response response) {
        if (response.m3034a().m2348b().equals("HEAD")) {
            return false;
        }
        int m3031b = response.m3031b();
        return (((m3031b >= 100 && m3031b < 200) || m3031b == 204 || m3031b == 304) && m2928a(response) == -1 && !"chunked".equalsIgnoreCase(response.m3033a("Transfer-Encoding"))) ? false : true;
    }

    /* renamed from: a */
    public static int m2929a(String str, int i, String str2) {
        while (i < str.length() && str2.indexOf(str.charAt(i)) == -1) {
            i++;
        }
        return i;
    }

    /* renamed from: a */
    public static int m2930a(String str, int i) {
        char charAt;
        while (i < str.length() && ((charAt = str.charAt(i)) == ' ' || charAt == '\t')) {
            i++;
        }
        return i;
    }

    /* renamed from: b */
    public static int m2925b(String str, int i) {
        try {
            long parseLong = Long.parseLong(str);
            if (parseLong > 2147483647L) {
                return Integer.MAX_VALUE;
            }
            if (parseLong < 0) {
                return 0;
            }
            return (int) parseLong;
        } catch (NumberFormatException unused) {
            return i;
        }
    }
}
