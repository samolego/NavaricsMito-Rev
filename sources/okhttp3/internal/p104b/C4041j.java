package okhttp3.internal.p104b;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.HttpRetryException;
import java.net.ProtocolException;
import java.net.Proxy;
import java.net.SocketTimeoutException;
import java.security.cert.CertificateException;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSocketFactory;
import okhttp3.Address;
import okhttp3.C2993z;
import okhttp3.Call;
import okhttp3.CertificatePinner;
import okhttp3.EventListener;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okhttp3.Route;
import okhttp3.internal.C2930c;
import okhttp3.internal.connection.RouteException;
import okhttp3.internal.connection.StreamAllocation;
import okhttp3.internal.http2.ConnectionShutdownException;
import tv.danmaku.ijk.media.player.IjkMediaCodecInfo;

/* renamed from: okhttp3.internal.b.j */
/* loaded from: classes2.dex */
public final class RetryAndFollowUpInterceptor implements Interceptor {

    /* renamed from: a */
    private final OkHttpClient f10171a;

    /* renamed from: b */
    private final boolean f10172b;

    /* renamed from: c */
    private volatile StreamAllocation f10173c;

    /* renamed from: d */
    private Object f10174d;

    /* renamed from: e */
    private volatile boolean f10175e;

    public RetryAndFollowUpInterceptor(OkHttpClient okHttpClient, boolean z) {
        this.f10171a = okHttpClient;
        this.f10172b = z;
    }

    /* renamed from: a */
    public void m2910a() {
        this.f10175e = true;
        StreamAllocation streamAllocation = this.f10173c;
        if (streamAllocation != null) {
            streamAllocation.m2804f();
        }
    }

    /* renamed from: b */
    public boolean m2902b() {
        return this.f10175e;
    }

    /* renamed from: a */
    public void m2907a(Object obj) {
        this.f10174d = obj;
    }

    @Override // okhttp3.Interceptor
    /* renamed from: a */
    public Response mo2429a(Interceptor.InterfaceC2987a interfaceC2987a) throws IOException {
        Response m2918a;
        C2993z m2905a;
        C2993z mo2428a = interfaceC2987a.mo2428a();
        RealInterceptorChain realInterceptorChain = (RealInterceptorChain) interfaceC2987a;
        Call m2915h = realInterceptorChain.m2915h();
        EventListener m2914i = realInterceptorChain.m2914i();
        StreamAllocation streamAllocation = new StreamAllocation(this.f10171a.m2392p(), m2903a(mo2428a.m2350a()), m2915h, m2914i, this.f10174d);
        this.f10173c = streamAllocation;
        Response response = null;
        int i = 0;
        while (!this.f10175e) {
            try {
                try {
                    try {
                        m2918a = realInterceptorChain.m2918a(mo2428a, streamAllocation, null, null);
                        if (response != null) {
                            m2918a = m2918a.m3025h().m3006c(response.m3025h().m3012a((ResponseBody) null).m3020a()).m3020a();
                        }
                        try {
                            m2905a = m2905a(m2918a, streamAllocation.m2809b());
                        } catch (IOException e) {
                            streamAllocation.m2806d();
                            throw e;
                        }
                    } catch (RouteException e2) {
                        if (!m2909a(e2.getLastConnectException(), streamAllocation, false, mo2428a)) {
                            throw e2.getFirstConnectException();
                        }
                    }
                } catch (IOException e3) {
                    if (!m2909a(e3, streamAllocation, !(e3 instanceof ConnectionShutdownException), mo2428a)) {
                        throw e3;
                    }
                }
                if (m2905a == null) {
                    if (!this.f10172b) {
                        streamAllocation.m2806d();
                    }
                    return m2918a;
                }
                C2930c.m2897a(m2918a.m3026g());
                int i2 = i + 1;
                if (i2 > 20) {
                    streamAllocation.m2806d();
                    throw new ProtocolException("Too many follow-up requests: " + i2);
                } else if (m2905a.m2346d() instanceof UnrepeatableRequestBody) {
                    streamAllocation.m2806d();
                    throw new HttpRetryException("Cannot retry streamed HTTP body", m2918a.m3031b());
                } else {
                    if (!m2904a(m2918a, m2905a.m2350a())) {
                        streamAllocation.m2806d();
                        streamAllocation = new StreamAllocation(this.f10171a.m2392p(), m2903a(m2905a.m2350a()), m2915h, m2914i, this.f10174d);
                        this.f10173c = streamAllocation;
                    } else if (streamAllocation.m2818a() != null) {
                        throw new IllegalStateException("Closing the body of " + m2918a + " didn't close its backing stream. Bad interceptor?");
                    }
                    response = m2918a;
                    mo2428a = m2905a;
                    i = i2;
                }
            } catch (Throwable th) {
                streamAllocation.m2815a((IOException) null);
                streamAllocation.m2806d();
                throw th;
            }
        }
        streamAllocation.m2806d();
        throw new IOException("Canceled");
    }

    /* renamed from: a */
    private Address m2903a(HttpUrl httpUrl) {
        SSLSocketFactory sSLSocketFactory;
        HostnameVerifier hostnameVerifier;
        CertificatePinner certificatePinner;
        if (httpUrl.m2470c()) {
            SSLSocketFactory m2397k = this.f10171a.m2397k();
            hostnameVerifier = this.f10171a.m2396l();
            sSLSocketFactory = m2397k;
            certificatePinner = this.f10171a.m2395m();
        } else {
            sSLSocketFactory = null;
            hostnameVerifier = null;
            certificatePinner = null;
        }
        return new Address(httpUrl.m2464f(), httpUrl.m2462g(), this.f10171a.m2399i(), this.f10171a.m2398j(), sSLSocketFactory, hostnameVerifier, certificatePinner, this.f10171a.m2393o(), this.f10171a.m2403e(), this.f10171a.m2387u(), this.f10171a.m2386v(), this.f10171a.m2402f());
    }

    /* renamed from: a */
    private boolean m2909a(IOException iOException, StreamAllocation streamAllocation, boolean z, C2993z c2993z) {
        streamAllocation.m2815a(iOException);
        if (this.f10171a.m2389s()) {
            return !(z && (c2993z.m2346d() instanceof UnrepeatableRequestBody)) && m2908a(iOException, z) && streamAllocation.m2803g();
        }
        return false;
    }

    /* renamed from: a */
    private boolean m2908a(IOException iOException, boolean z) {
        if (iOException instanceof ProtocolException) {
            return false;
        }
        return iOException instanceof InterruptedIOException ? (iOException instanceof SocketTimeoutException) && !z : (((iOException instanceof SSLHandshakeException) && (iOException.getCause() instanceof CertificateException)) || (iOException instanceof SSLPeerUnverifiedException)) ? false : true;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* renamed from: a */
    private C2993z m2905a(Response response, Route route) throws IOException {
        String m3033a;
        HttpUrl m2469c;
        Proxy m2403e;
        if (response == null) {
            throw new IllegalStateException();
        }
        int m3031b = response.m3031b();
        String m2348b = response.m3034a().m2348b();
        switch (m3031b) {
            case IjkMediaCodecInfo.RANK_SECURE /* 300 */:
            case 301:
            case 302:
            case 303:
                break;
            case 307:
            case 308:
                if (!m2348b.equals("GET") && !m2348b.equals("HEAD")) {
                    return null;
                }
                break;
            case 401:
                return this.f10171a.m2394n().mo2994a(route, response);
            case 407:
                if (route != null) {
                    m2403e = route.m2997b();
                } else {
                    m2403e = this.f10171a.m2403e();
                }
                if (m2403e.type() != Proxy.Type.HTTP) {
                    throw new ProtocolException("Received HTTP_PROXY_AUTH (407) code while not using proxy");
                }
                return this.f10171a.m2393o().mo2994a(route, response);
            case 408:
                if (this.f10171a.m2389s() && !(response.m3034a().m2346d() instanceof UnrepeatableRequestBody)) {
                    if ((response.m3024i() == null || response.m3024i().m3031b() != 408) && m2906a(response, 0) <= 0) {
                        return response.m3034a();
                    }
                    return null;
                }
                return null;
            case 503:
                if ((response.m3024i() == null || response.m3024i().m3031b() != 503) && m2906a(response, Integer.MAX_VALUE) == 0) {
                    return response.m3034a();
                }
                return null;
            default:
                return null;
        }
        if (!this.f10171a.m2390r() || (m3033a = response.m3033a("Location")) == null || (m2469c = response.m3034a().m2350a().m2469c(m3033a)) == null) {
            return null;
        }
        if (m2469c.m2474b().equals(response.m3034a().m2350a().m2474b()) || this.f10171a.m2391q()) {
            C2993z.C2994a m2345e = response.m3034a().m2345e();
            if (HttpMethod.m2921c(m2348b)) {
                boolean m2920d = HttpMethod.m2920d(m2348b);
                if (HttpMethod.m2919e(m2348b)) {
                    m2345e.m2339a("GET", (RequestBody) null);
                } else {
                    m2345e.m2339a(m2348b, m2920d ? response.m3034a().m2346d() : null);
                }
                if (!m2920d) {
                    m2345e.m2336b("Transfer-Encoding");
                    m2345e.m2336b("Content-Length");
                    m2345e.m2336b("Content-Type");
                }
            }
            if (!m2904a(response, m2469c)) {
                m2345e.m2336b("Authorization");
            }
            return m2345e.m2337a(m2469c).m2342a();
        }
        return null;
    }

    /* renamed from: a */
    private int m2906a(Response response, int i) {
        String m3033a = response.m3033a("Retry-After");
        if (m3033a == null) {
            return i;
        }
        if (m3033a.matches("\\d+")) {
            return Integer.valueOf(m3033a).intValue();
        }
        return Integer.MAX_VALUE;
    }

    /* renamed from: a */
    private boolean m2904a(Response response, HttpUrl httpUrl) {
        HttpUrl m2350a = response.m3034a().m2350a();
        return m2350a.m2464f().equals(httpUrl.m2464f()) && m2350a.m2462g() == httpUrl.m2462g() && m2350a.m2474b().equals(httpUrl.m2474b());
    }
}
