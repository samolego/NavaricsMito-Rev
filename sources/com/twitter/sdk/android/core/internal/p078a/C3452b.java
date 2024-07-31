package com.twitter.sdk.android.core.internal.p078a;

import java.io.IOException;
import okhttp3.Interceptor;
import okhttp3.Response;

/* renamed from: com.twitter.sdk.android.core.internal.a.b */
/* loaded from: classes2.dex */
public class GuestAuthNetworkInterceptor implements Interceptor {
    @Override // okhttp3.Interceptor
    /* renamed from: a */
    public Response mo2429a(Interceptor.InterfaceC2987a interfaceC2987a) throws IOException {
        Response mo2427a = interfaceC2987a.mo2427a(interfaceC2987a.mo2428a());
        return mo2427a.m3031b() == 403 ? mo2427a.m3025h().m3019a(401).m3020a() : mo2427a;
    }
}
