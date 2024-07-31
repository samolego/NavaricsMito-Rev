package okhttp3;

import java.net.Proxy;
import java.net.ProxySelector;
import java.util.List;
import javax.annotation.Nullable;
import javax.net.SocketFactory;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSocketFactory;
import okhttp3.HttpUrl;
import okhttp3.internal.C2930c;

/* renamed from: okhttp3.a */
/* loaded from: classes2.dex */
public final class Address {

    /* renamed from: a */
    final HttpUrl f9896a;

    /* renamed from: b */
    final Dns f9897b;

    /* renamed from: c */
    final SocketFactory f9898c;

    /* renamed from: d */
    final Authenticator f9899d;

    /* renamed from: e */
    final List<Protocol> f9900e;

    /* renamed from: f */
    final List<ConnectionSpec> f9901f;

    /* renamed from: g */
    final ProxySelector f9902g;
    @Nullable

    /* renamed from: h */
    final Proxy f9903h;
    @Nullable

    /* renamed from: i */
    final SSLSocketFactory f9904i;
    @Nullable

    /* renamed from: j */
    final HostnameVerifier f9905j;
    @Nullable

    /* renamed from: k */
    final CertificatePinner f9906k;

    public Address(String str, int i, Dns dns, SocketFactory socketFactory, @Nullable SSLSocketFactory sSLSocketFactory, @Nullable HostnameVerifier hostnameVerifier, @Nullable CertificatePinner certificatePinner, Authenticator authenticator, @Nullable Proxy proxy, List<Protocol> list, List<ConnectionSpec> list2, ProxySelector proxySelector) {
        this.f9896a = new HttpUrl.C2986a().m2450a(sSLSocketFactory != null ? "https" : "http").m2437d(str).m2451a(i).m2441c();
        if (dns == null) {
            throw new NullPointerException("dns == null");
        }
        this.f9897b = dns;
        if (socketFactory == null) {
            throw new NullPointerException("socketFactory == null");
        }
        this.f9898c = socketFactory;
        if (authenticator == null) {
            throw new NullPointerException("proxyAuthenticator == null");
        }
        this.f9899d = authenticator;
        if (list == null) {
            throw new NullPointerException("protocols == null");
        }
        this.f9900e = C2930c.m2881a(list);
        if (list2 == null) {
            throw new NullPointerException("connectionSpecs == null");
        }
        this.f9901f = C2930c.m2881a(list2);
        if (proxySelector == null) {
            throw new NullPointerException("proxySelector == null");
        }
        this.f9902g = proxySelector;
        this.f9903h = proxy;
        this.f9904i = sSLSocketFactory;
        this.f9905j = hostnameVerifier;
        this.f9906k = certificatePinner;
    }

    /* renamed from: a */
    public HttpUrl m3051a() {
        return this.f9896a;
    }

    /* renamed from: b */
    public Dns m3049b() {
        return this.f9897b;
    }

    /* renamed from: c */
    public SocketFactory m3048c() {
        return this.f9898c;
    }

    /* renamed from: d */
    public Authenticator m3047d() {
        return this.f9899d;
    }

    /* renamed from: e */
    public List<Protocol> m3046e() {
        return this.f9900e;
    }

    /* renamed from: f */
    public List<ConnectionSpec> m3045f() {
        return this.f9901f;
    }

    /* renamed from: g */
    public ProxySelector m3044g() {
        return this.f9902g;
    }

    @Nullable
    /* renamed from: h */
    public Proxy m3043h() {
        return this.f9903h;
    }

    @Nullable
    /* renamed from: i */
    public SSLSocketFactory m3042i() {
        return this.f9904i;
    }

    @Nullable
    /* renamed from: j */
    public HostnameVerifier m3041j() {
        return this.f9905j;
    }

    @Nullable
    /* renamed from: k */
    public CertificatePinner m3040k() {
        return this.f9906k;
    }

    public boolean equals(@Nullable Object obj) {
        if (obj instanceof Address) {
            Address address = (Address) obj;
            if (this.f9896a.equals(address.f9896a) && m3050a(address)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        int hashCode = (((((((((((527 + this.f9896a.hashCode()) * 31) + this.f9897b.hashCode()) * 31) + this.f9899d.hashCode()) * 31) + this.f9900e.hashCode()) * 31) + this.f9901f.hashCode()) * 31) + this.f9902g.hashCode()) * 31;
        Proxy proxy = this.f9903h;
        int hashCode2 = (hashCode + (proxy != null ? proxy.hashCode() : 0)) * 31;
        SSLSocketFactory sSLSocketFactory = this.f9904i;
        int hashCode3 = (hashCode2 + (sSLSocketFactory != null ? sSLSocketFactory.hashCode() : 0)) * 31;
        HostnameVerifier hostnameVerifier = this.f9905j;
        int hashCode4 = (hashCode3 + (hostnameVerifier != null ? hostnameVerifier.hashCode() : 0)) * 31;
        CertificatePinner certificatePinner = this.f9906k;
        return hashCode4 + (certificatePinner != null ? certificatePinner.hashCode() : 0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public boolean m3050a(Address address) {
        return this.f9897b.equals(address.f9897b) && this.f9899d.equals(address.f9899d) && this.f9900e.equals(address.f9900e) && this.f9901f.equals(address.f9901f) && this.f9902g.equals(address.f9902g) && C2930c.m2895a(this.f9903h, address.f9903h) && C2930c.m2895a(this.f9904i, address.f9904i) && C2930c.m2895a(this.f9905j, address.f9905j) && C2930c.m2895a(this.f9906k, address.f9906k) && m3051a().m2462g() == address.m3051a().m2462g();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Address{");
        sb.append(this.f9896a.m2464f());
        sb.append(":");
        sb.append(this.f9896a.m2462g());
        if (this.f9903h != null) {
            sb.append(", proxy=");
            sb.append(this.f9903h);
        } else {
            sb.append(", proxySelector=");
            sb.append(this.f9902g);
        }
        sb.append("}");
        return sb.toString();
    }
}
