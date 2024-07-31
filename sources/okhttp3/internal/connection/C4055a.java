package okhttp3.internal.connection;

import java.io.IOException;
import okhttp3.C2993z;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Response;
import okhttp3.internal.p104b.RealInterceptorChain;

/* renamed from: okhttp3.internal.connection.a */
/* loaded from: classes2.dex */
public final class ConnectInterceptor implements Interceptor {

    /* renamed from: a */
    public final OkHttpClient f10225a;

    public ConnectInterceptor(OkHttpClient okHttpClient) {
        this.f10225a = okHttpClient;
    }

    @Override // okhttp3.Interceptor
    /* renamed from: a */
    public Response mo2429a(Interceptor.InterfaceC2987a interfaceC2987a) throws IOException {
        RealInterceptorChain realInterceptorChain = (RealInterceptorChain) interfaceC2987a;
        C2993z mo2428a = realInterceptorChain.mo2428a();
        StreamAllocation m2917f = realInterceptorChain.m2917f();
        return realInterceptorChain.m2918a(mo2428a, m2917f, m2917f.m2812a(this.f10225a, interfaceC2987a, !mo2428a.m2348b().equals("GET")), m2917f.m2807c());
    }
}
