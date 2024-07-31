package okhttp3.internal.p104b;

import java.io.IOException;
import java.util.List;
import okhttp3.C2993z;
import okhttp3.Cookie;
import okhttp3.CookieJar;
import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.internal.C2930c;
import okhttp3.internal.C2942d;
import okio.GzipSource;
import okio.Okio;

/* renamed from: okhttp3.internal.b.a */
/* loaded from: classes2.dex */
public final class BridgeInterceptor implements Interceptor {

    /* renamed from: a */
    private final CookieJar f10149a;

    public BridgeInterceptor(CookieJar cookieJar) {
        this.f10149a = cookieJar;
    }

    @Override // okhttp3.Interceptor
    /* renamed from: a */
    public Response mo2429a(Interceptor.InterfaceC2987a interfaceC2987a) throws IOException {
        C2993z mo2428a = interfaceC2987a.mo2428a();
        C2993z.C2994a m2345e = mo2428a.m2345e();
        RequestBody m2346d = mo2428a.m2346d();
        if (m2346d != null) {
            MediaType mo75b = m2346d.mo75b();
            if (mo75b != null) {
                m2345e.m2340a("Content-Type", mo75b.toString());
            }
            long mo74c = m2346d.mo74c();
            if (mo74c != -1) {
                m2345e.m2340a("Content-Length", Long.toString(mo74c));
                m2345e.m2336b("Transfer-Encoding");
            } else {
                m2345e.m2340a("Transfer-Encoding", "chunked");
                m2345e.m2336b("Content-Length");
            }
        }
        boolean z = false;
        if (mo2428a.m2349a("Host") == null) {
            m2345e.m2340a("Host", C2930c.m2879a(mo2428a.m2350a(), false));
        }
        if (mo2428a.m2349a("Connection") == null) {
            m2345e.m2340a("Connection", "Keep-Alive");
        }
        if (mo2428a.m2349a("Accept-Encoding") == null && mo2428a.m2349a("Range") == null) {
            z = true;
            m2345e.m2340a("Accept-Encoding", "gzip");
        }
        List<Cookie> mo2547a = this.f10149a.mo2547a(mo2428a.m2350a());
        if (!mo2547a.isEmpty()) {
            m2345e.m2340a("Cookie", m2935a(mo2547a));
        }
        if (mo2428a.m2349a("User-Agent") == null) {
            m2345e.m2340a("User-Agent", C2942d.m2800a());
        }
        Response mo2427a = interfaceC2987a.mo2427a(m2345e.m2342a());
        HttpHeaders.m2927a(this.f10149a, mo2428a.m2350a(), mo2427a.m3027f());
        Response.C2912a m3009a = mo2427a.m3025h().m3009a(mo2428a);
        if (z && "gzip".equalsIgnoreCase(mo2427a.m3033a("Content-Encoding")) && HttpHeaders.m2924b(mo2427a)) {
            GzipSource gzipSource = new GzipSource(mo2427a.m3026g().mo127d());
            m3009a.m3010a(mo2427a.m3027f().m2497b().m2491b("Content-Encoding").m2491b("Content-Length").m2494a());
            m3009a.m3012a(new RealResponseBody(mo2427a.m3033a("Content-Type"), -1L, Okio.m2263a(gzipSource)));
        }
        return m3009a.m3020a();
    }

    /* renamed from: a */
    private String m2935a(List<Cookie> list) {
        StringBuilder sb = new StringBuilder();
        int size = list.size();
        for (int i = 0; i < size; i++) {
            if (i > 0) {
                sb.append("; ");
            }
            Cookie cookie = list.get(i);
            sb.append(cookie.m2562a());
            sb.append('=');
            sb.append(cookie.m2553b());
        }
        return sb.toString();
    }
}
