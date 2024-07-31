package com.twitter.sdk.android.core.internal.p078a;

import com.twitter.sdk.android.core.Session;
import com.twitter.sdk.android.core.TwitterAuthConfig;
import com.twitter.sdk.android.core.TwitterAuthToken;
import com.twitter.sdk.android.core.internal.oauth.OAuth1aHeaders;
import java.io.IOException;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import okhttp3.C2993z;
import okhttp3.FormBody;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.RequestBody;
import okhttp3.Response;

/* renamed from: com.twitter.sdk.android.core.internal.a.d */
/* loaded from: classes2.dex */
public class OAuth1aInterceptor implements Interceptor {

    /* renamed from: a */
    final Session<? extends TwitterAuthToken> f8491a;

    /* renamed from: b */
    final TwitterAuthConfig f8492b;

    public OAuth1aInterceptor(Session<? extends TwitterAuthToken> session, TwitterAuthConfig twitterAuthConfig) {
        this.f8491a = session;
        this.f8492b = twitterAuthConfig;
    }

    @Override // okhttp3.Interceptor
    /* renamed from: a */
    public Response mo2429a(Interceptor.InterfaceC2987a interfaceC2987a) throws IOException {
        C2993z mo2428a = interfaceC2987a.mo2428a();
        C2993z m2342a = mo2428a.m2345e().m2337a(m4496a(mo2428a.m2350a())).m2342a();
        return interfaceC2987a.mo2427a(m2342a.m2345e().m2340a("Authorization", m4495a(m2342a)).m2342a());
    }

    /* renamed from: a */
    HttpUrl m4496a(HttpUrl httpUrl) {
        HttpUrl.C2986a m2435e = httpUrl.m2453p().m2435e(null);
        int m2456m = httpUrl.m2456m();
        for (int i = 0; i < m2456m; i++) {
            m2435e.m2442b(UrlUtils.m4484c(httpUrl.m2486a(i)), UrlUtils.m4484c(httpUrl.m2473b(i)));
        }
        return m2435e.m2441c();
    }

    /* renamed from: a */
    String m4495a(C2993z c2993z) throws IOException {
        return new OAuth1aHeaders().m4396a(this.f8492b, this.f8491a.m4270a(), null, c2993z.m2348b(), c2993z.m2350a().toString(), m4494b(c2993z));
    }

    /* renamed from: b */
    Map<String, String> m4494b(C2993z c2993z) throws IOException {
        HashMap hashMap = new HashMap();
        if ("POST".equals(c2993z.m2348b().toUpperCase(Locale.US))) {
            RequestBody m2346d = c2993z.m2346d();
            if (m2346d instanceof FormBody) {
                FormBody formBody = (FormBody) m2346d;
                for (int i = 0; i < formBody.m2513a(); i++) {
                    hashMap.put(formBody.m2512a(i), formBody.m2509c(i));
                }
            }
        }
        return hashMap;
    }
}
