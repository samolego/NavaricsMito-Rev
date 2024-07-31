package okhttp3.internal.p104b;

import java.net.Proxy;
import okhttp3.C2993z;
import okhttp3.HttpUrl;

/* renamed from: okhttp3.internal.b.i */
/* loaded from: classes2.dex */
public final class RequestLine {
    /* renamed from: a */
    public static String m2912a(C2993z c2993z, Proxy.Type type) {
        StringBuilder sb = new StringBuilder();
        sb.append(c2993z.m2348b());
        sb.append(' ');
        if (m2911b(c2993z, type)) {
            sb.append(c2993z.m2350a());
        } else {
            sb.append(m2913a(c2993z.m2350a()));
        }
        sb.append(" HTTP/1.1");
        return sb.toString();
    }

    /* renamed from: b */
    private static boolean m2911b(C2993z c2993z, Proxy.Type type) {
        return !c2993z.m2343g() && type == Proxy.Type.HTTP;
    }

    /* renamed from: a */
    public static String m2913a(HttpUrl httpUrl) {
        String m2461h = httpUrl.m2461h();
        String m2458k = httpUrl.m2458k();
        if (m2458k != null) {
            return m2461h + '?' + m2458k;
        }
        return m2461h;
    }
}
