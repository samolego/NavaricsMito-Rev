package com.twitter.sdk.android.core.internal.p078a;

import com.twitter.sdk.android.core.GuestSession;
import com.twitter.sdk.android.core.GuestSessionProvider;
import com.twitter.sdk.android.core.internal.oauth.GuestAuthToken;
import java.io.IOException;
import okhttp3.Authenticator;
import okhttp3.C2984s;
import okhttp3.C2993z;
import okhttp3.Response;
import okhttp3.Route;

/* renamed from: com.twitter.sdk.android.core.internal.a.c */
/* loaded from: classes2.dex */
public class GuestAuthenticator implements Authenticator {

    /* renamed from: a */
    final GuestSessionProvider f8490a;

    public GuestAuthenticator(GuestSessionProvider guestSessionProvider) {
        this.f8490a = guestSessionProvider;
    }

    @Override // okhttp3.Authenticator
    /* renamed from: a */
    public C2993z mo2994a(Route route, Response response) throws IOException {
        return m4500a(response);
    }

    /* renamed from: a */
    C2993z m4500a(Response response) {
        if (m4497c(response)) {
            GuestSession m4568a = this.f8490a.m4568a(m4498b(response));
            GuestAuthToken a = m4568a == null ? null : m4568a.m4270a();
            if (a != null) {
                return m4499a(response.m3034a(), a);
            }
        }
        return null;
    }

    /* renamed from: b */
    GuestSession m4498b(Response response) {
        C2984s m2347c = response.m3034a().m2347c();
        String m2500a = m2347c.m2500a("Authorization");
        String m2500a2 = m2347c.m2500a("x-guest-token");
        if (m2500a == null || m2500a2 == null) {
            return null;
        }
        return new GuestSession(new GuestAuthToken("bearer", m2500a.replace("bearer ", ""), m2500a2));
    }

    /* renamed from: a */
    C2993z m4499a(C2993z c2993z, GuestAuthToken guestAuthToken) {
        C2993z.C2994a m2345e = c2993z.m2345e();
        GuestAuthInterceptor.m4507a(m2345e, guestAuthToken);
        return m2345e.m2342a();
    }

    /* renamed from: c */
    boolean m4497c(Response response) {
        int i = 1;
        while (true) {
            response = response.m3024i();
            if (response == null) {
                break;
            }
            i++;
        }
        return i < 2;
    }
}
