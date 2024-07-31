package com.twitter.sdk.android.core.internal.p078a;

import com.twitter.sdk.android.core.GuestSession;
import com.twitter.sdk.android.core.GuestSessionProvider;
import com.twitter.sdk.android.core.internal.oauth.GuestAuthToken;
import java.io.IOException;
import okhttp3.C2993z;
import okhttp3.Interceptor;
import okhttp3.Response;

/* renamed from: com.twitter.sdk.android.core.internal.a.a */
/* loaded from: classes2.dex */
public class GuestAuthInterceptor implements Interceptor {

    /* renamed from: a */
    final GuestSessionProvider f8489a;

    public GuestAuthInterceptor(GuestSessionProvider guestSessionProvider) {
        this.f8489a = guestSessionProvider;
    }

    @Override // okhttp3.Interceptor
    /* renamed from: a */
    public Response mo2429a(Interceptor.InterfaceC2987a interfaceC2987a) throws IOException {
        C2993z mo2428a = interfaceC2987a.mo2428a();
        GuestSession m4569a = this.f8489a.m4569a();
        GuestAuthToken a = m4569a == null ? null : m4569a.m4270a();
        if (a != null) {
            C2993z.C2994a m2345e = mo2428a.m2345e();
            m4507a(m2345e, a);
            return interfaceC2987a.mo2427a(m2345e.m2342a());
        }
        return interfaceC2987a.mo2427a(mo2428a);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public static void m4507a(C2993z.C2994a c2994a, GuestAuthToken guestAuthToken) {
        c2994a.m2340a("Authorization", guestAuthToken.m4402c() + " " + guestAuthToken.m4401d());
        c2994a.m2340a("x-guest-token", guestAuthToken.m4417a());
    }
}
