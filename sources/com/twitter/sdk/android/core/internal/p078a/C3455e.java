package com.twitter.sdk.android.core.internal.p078a;

import com.twitter.sdk.android.core.GuestSessionProvider;
import com.twitter.sdk.android.core.Session;
import com.twitter.sdk.android.core.TwitterAuthConfig;
import com.twitter.sdk.android.core.TwitterAuthToken;
import okhttp3.CertificatePinner;
import okhttp3.OkHttpClient;

/* renamed from: com.twitter.sdk.android.core.internal.a.e */
/* loaded from: classes2.dex */
public class OkHttpClientHelper {
    /* renamed from: a */
    public static OkHttpClient m4492a(GuestSessionProvider guestSessionProvider) {
        return m4490a(new OkHttpClient.C2991a(), guestSessionProvider).m2372a();
    }

    /* renamed from: a */
    public static OkHttpClient m4491a(Session<? extends TwitterAuthToken> session, TwitterAuthConfig twitterAuthConfig) {
        if (session == null) {
            throw new IllegalArgumentException("Session must not be null.");
        }
        return m4489a(new OkHttpClient.C2991a(), session, twitterAuthConfig).m2372a();
    }

    /* renamed from: a */
    static OkHttpClient.C2991a m4490a(OkHttpClient.C2991a c2991a, GuestSessionProvider guestSessionProvider) {
        return c2991a.m2367a(m4493a()).m2368a(new GuestAuthenticator(guestSessionProvider)).m2366a(new GuestAuthInterceptor(guestSessionProvider)).m2365b(new GuestAuthNetworkInterceptor());
    }

    /* renamed from: a */
    static OkHttpClient.C2991a m4489a(OkHttpClient.C2991a c2991a, Session<? extends TwitterAuthToken> session, TwitterAuthConfig twitterAuthConfig) {
        return c2991a.m2367a(m4493a()).m2366a(new OAuth1aInterceptor(session, twitterAuthConfig));
    }

    /* renamed from: a */
    public static CertificatePinner m4493a() {
        return new CertificatePinner.C2920a().m2970a("*.twitter.com", "sha1/I0PRSKJViZuUfUYaeX7ATP7RcLc=").m2970a("*.twitter.com", "sha1/VRmyeKyygdftp6vBg5nDu2kEJLU=").m2970a("*.twitter.com", "sha1/Eje6RRfurSkm/cHN/r7t8t7ZFFw=").m2970a("*.twitter.com", "sha1/Wr7Fddyu87COJxlD/H8lDD32YeM=").m2970a("*.twitter.com", "sha1/GiG0lStik84Ys2XsnA6TTLOB5tQ=").m2970a("*.twitter.com", "sha1/IvGeLsbqzPxdI0b0wuj2xVTdXgc=").m2970a("*.twitter.com", "sha1/7WYxNdMb1OymFMQp4xkGn5TBJlA=").m2970a("*.twitter.com", "sha1/sYEIGhmkwJQf+uiVKMEkyZs0rMc=").m2970a("*.twitter.com", "sha1/PANDaGiVHPNpKri0Jtq6j+ki5b0=").m2970a("*.twitter.com", "sha1/u8I+KQuzKHcdrT6iTb30I70GsD0=").m2970a("*.twitter.com", "sha1/wHqYaI2J+6sFZAwRfap9ZbjKzE4=").m2970a("*.twitter.com", "sha1/cTg28gIxU0crbrplRqkQFVggBQk=").m2970a("*.twitter.com", "sha1/sBmJ5+/7Sq/LFI9YRjl2IkFQ4bo=").m2970a("*.twitter.com", "sha1/vb6nG6txV/nkddlU0rcngBqCJoI=").m2970a("*.twitter.com", "sha1/nKmNAK90Dd2BgNITRaWLjy6UONY=").m2970a("*.twitter.com", "sha1/h+hbY1PGI6MSjLD/u/VR/lmADiI=").m2970a("*.twitter.com", "sha1/Xk9ThoXdT57KX9wNRW99UbHcm3s=").m2970a("*.twitter.com", "sha1/1S4TwavjSdrotJWU73w4Q2BkZr0=").m2970a("*.twitter.com", "sha1/gzF+YoVCU9bXeDGQ7JGQVumRueM=").m2970a("*.twitter.com", "sha1/aDMOYTWFIVkpg6PI0tLhQG56s8E=").m2970a("*.twitter.com", "sha1/Vv7zwhR9TtOIN/29MFI4cgHld40=").m2971a();
    }
}
