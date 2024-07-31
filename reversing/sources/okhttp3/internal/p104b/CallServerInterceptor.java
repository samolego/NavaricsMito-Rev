package okhttp3.internal.p104b;

import java.io.IOException;
import java.net.ProtocolException;
import okhttp3.C2993z;
import okhttp3.Interceptor;
import okhttp3.Response;
import okhttp3.internal.C2930c;
import okhttp3.internal.connection.RealConnection;
import okhttp3.internal.connection.StreamAllocation;
import okio.Buffer;
import okio.BufferedSink;
import okio.ForwardingSink;
import okio.Okio;
import okio.Sink;

/* renamed from: okhttp3.internal.b.b */
/* loaded from: classes2.dex */
public final class CallServerInterceptor implements Interceptor {

    /* renamed from: a */
    private final boolean f10150a;

    public CallServerInterceptor(boolean z) {
        this.f10150a = z;
    }

    @Override // okhttp3.Interceptor
    /* renamed from: a */
    public Response mo2429a(Interceptor.InterfaceC2987a interfaceC2987a) throws IOException {
        Response m3020a;
        RealInterceptorChain realInterceptorChain = (RealInterceptorChain) interfaceC2987a;
        HttpCodec m2916g = realInterceptorChain.m2916g();
        StreamAllocation m2917f = realInterceptorChain.m2917f();
        RealConnection realConnection = (RealConnection) realInterceptorChain.mo2426b();
        C2993z mo2428a = realInterceptorChain.mo2428a();
        long currentTimeMillis = System.currentTimeMillis();
        realInterceptorChain.m2914i().m2519c(realInterceptorChain.m2915h());
        m2916g.mo2716a(mo2428a);
        realInterceptorChain.m2914i().m2524a(realInterceptorChain.m2915h(), mo2428a);
        Response.C2912a c2912a = null;
        if (HttpMethod.m2921c(mo2428a.m2348b()) && mo2428a.m2346d() != null) {
            if ("100-continue".equalsIgnoreCase(mo2428a.m2349a("Expect"))) {
                m2916g.mo2719a();
                realInterceptorChain.m2914i().m2517e(realInterceptorChain.m2915h());
                c2912a = m2916g.mo2714a(true);
            }
            if (c2912a == null) {
                realInterceptorChain.m2914i().m2518d(realInterceptorChain.m2915h());
                C2928a c2928a = new C2928a(m2916g.mo2715a(mo2428a, mo2428a.m2346d().mo74c()));
                BufferedSink m2264a = Okio.m2264a(c2928a);
                mo2428a.m2346d().mo76a(m2264a);
                m2264a.close();
                realInterceptorChain.m2914i().m2534a(realInterceptorChain.m2915h(), c2928a.f10151a);
            } else if (!realConnection.m2834f()) {
                m2917f.m2805e();
            }
        }
        m2916g.mo2713b();
        if (c2912a == null) {
            realInterceptorChain.m2914i().m2517e(realInterceptorChain.m2915h());
            c2912a = m2916g.mo2714a(false);
        }
        Response m3020a2 = c2912a.m3009a(mo2428a).m3011a(m2917f.m2807c().m2835e()).m3018a(currentTimeMillis).m3008b(System.currentTimeMillis()).m3020a();
        int m3031b = m3020a2.m3031b();
        if (m3031b == 100) {
            m3020a2 = m2916g.mo2714a(false).m3009a(mo2428a).m3011a(m2917f.m2807c().m2835e()).m3018a(currentTimeMillis).m3008b(System.currentTimeMillis()).m3020a();
            m3031b = m3020a2.m3031b();
        }
        realInterceptorChain.m2914i().m2527a(realInterceptorChain.m2915h(), m3020a2);
        if (this.f10150a && m3031b == 101) {
            m3020a = m3020a2.m3025h().m3012a(C2930c.f10181c).m3020a();
        } else {
            m3020a = m3020a2.m3025h().m3012a(m2916g.mo2717a(m3020a2)).m3020a();
        }
        if ("close".equalsIgnoreCase(m3020a.m3034a().m2349a("Connection")) || "close".equalsIgnoreCase(m3020a.m3033a("Connection"))) {
            m2917f.m2805e();
        }
        if ((m3031b == 204 || m3031b == 205) && m3020a.m3026g().mo128b() > 0) {
            throw new ProtocolException("HTTP " + m3031b + " had non-zero Content-Length: " + m3020a.m3026g().mo128b());
        }
        return m3020a;
    }

    /* compiled from: CallServerInterceptor.java */
    /* renamed from: okhttp3.internal.b.b$a */
    /* loaded from: classes2.dex */
    static final class C2928a extends ForwardingSink {

        /* renamed from: a */
        long f10151a;

        C2928a(Sink sink) {
            super(sink);
        }

        @Override // okio.ForwardingSink, okio.Sink
        /* renamed from: a_ */
        public void mo2215a_(Buffer buffer, long j) throws IOException {
            super.mo2215a_(buffer, j);
            this.f10151a += j;
        }
    }
}
