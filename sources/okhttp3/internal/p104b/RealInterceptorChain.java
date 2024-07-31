package okhttp3.internal.p104b;

import java.io.IOException;
import java.util.List;
import okhttp3.C2993z;
import okhttp3.Call;
import okhttp3.Connection;
import okhttp3.EventListener;
import okhttp3.Interceptor;
import okhttp3.Response;
import okhttp3.internal.connection.RealConnection;
import okhttp3.internal.connection.StreamAllocation;

/* renamed from: okhttp3.internal.b.g */
/* loaded from: classes2.dex */
public final class RealInterceptorChain implements Interceptor.InterfaceC2987a {

    /* renamed from: a */
    private final List<Interceptor> f10156a;

    /* renamed from: b */
    private final StreamAllocation f10157b;

    /* renamed from: c */
    private final HttpCodec f10158c;

    /* renamed from: d */
    private final RealConnection f10159d;

    /* renamed from: e */
    private final int f10160e;

    /* renamed from: f */
    private final C2993z f10161f;

    /* renamed from: g */
    private final Call f10162g;

    /* renamed from: h */
    private final EventListener f10163h;

    /* renamed from: i */
    private final int f10164i;

    /* renamed from: j */
    private final int f10165j;

    /* renamed from: k */
    private final int f10166k;

    /* renamed from: l */
    private int f10167l;

    public RealInterceptorChain(List<Interceptor> list, StreamAllocation streamAllocation, HttpCodec httpCodec, RealConnection realConnection, int i, C2993z c2993z, Call call, EventListener eventListener, int i2, int i3, int i4) {
        this.f10156a = list;
        this.f10159d = realConnection;
        this.f10157b = streamAllocation;
        this.f10158c = httpCodec;
        this.f10160e = i;
        this.f10161f = c2993z;
        this.f10162g = call;
        this.f10163h = eventListener;
        this.f10164i = i2;
        this.f10165j = i3;
        this.f10166k = i4;
    }

    @Override // okhttp3.Interceptor.InterfaceC2987a
    /* renamed from: b */
    public Connection mo2426b() {
        return this.f10159d;
    }

    @Override // okhttp3.Interceptor.InterfaceC2987a
    /* renamed from: c */
    public int mo2425c() {
        return this.f10164i;
    }

    @Override // okhttp3.Interceptor.InterfaceC2987a
    /* renamed from: d */
    public int mo2424d() {
        return this.f10165j;
    }

    @Override // okhttp3.Interceptor.InterfaceC2987a
    /* renamed from: e */
    public int mo2423e() {
        return this.f10166k;
    }

    /* renamed from: f */
    public StreamAllocation m2917f() {
        return this.f10157b;
    }

    /* renamed from: g */
    public HttpCodec m2916g() {
        return this.f10158c;
    }

    /* renamed from: h */
    public Call m2915h() {
        return this.f10162g;
    }

    /* renamed from: i */
    public EventListener m2914i() {
        return this.f10163h;
    }

    @Override // okhttp3.Interceptor.InterfaceC2987a
    /* renamed from: a */
    public C2993z mo2428a() {
        return this.f10161f;
    }

    @Override // okhttp3.Interceptor.InterfaceC2987a
    /* renamed from: a */
    public Response mo2427a(C2993z c2993z) throws IOException {
        return m2918a(c2993z, this.f10157b, this.f10158c, this.f10159d);
    }

    /* renamed from: a */
    public Response m2918a(C2993z c2993z, StreamAllocation streamAllocation, HttpCodec httpCodec, RealConnection realConnection) throws IOException {
        if (this.f10160e >= this.f10156a.size()) {
            throw new AssertionError();
        }
        this.f10167l++;
        if (this.f10158c != null && !this.f10159d.m2841a(c2993z.m2350a())) {
            throw new IllegalStateException("network interceptor " + this.f10156a.get(this.f10160e - 1) + " must retain the same host and port");
        } else if (this.f10158c != null && this.f10167l > 1) {
            throw new IllegalStateException("network interceptor " + this.f10156a.get(this.f10160e - 1) + " must call proceed() exactly once");
        } else {
            RealInterceptorChain realInterceptorChain = new RealInterceptorChain(this.f10156a, streamAllocation, httpCodec, realConnection, this.f10160e + 1, c2993z, this.f10162g, this.f10163h, this.f10164i, this.f10165j, this.f10166k);
            Interceptor interceptor = this.f10156a.get(this.f10160e);
            Response mo2429a = interceptor.mo2429a(realInterceptorChain);
            if (httpCodec != null && this.f10160e + 1 < this.f10156a.size() && realInterceptorChain.f10167l != 1) {
                throw new IllegalStateException("network interceptor " + interceptor + " must call proceed() exactly once");
            } else if (mo2429a == null) {
                throw new NullPointerException("interceptor " + interceptor + " returned null");
            } else if (mo2429a.m3026g() != null) {
                return mo2429a;
            } else {
                throw new IllegalStateException("interceptor " + interceptor + " returned a response with no body");
            }
        }
    }
}
