package okhttp3;

import java.net.InetSocketAddress;
import java.net.Proxy;
import javax.annotation.Nullable;

/* renamed from: okhttp3.ad */
/* loaded from: classes2.dex */
public final class Route {

    /* renamed from: a */
    final Address f9948a;

    /* renamed from: b */
    final Proxy f9949b;

    /* renamed from: c */
    final InetSocketAddress f9950c;

    public Route(Address address, Proxy proxy, InetSocketAddress inetSocketAddress) {
        if (address == null) {
            throw new NullPointerException("address == null");
        }
        if (proxy == null) {
            throw new NullPointerException("proxy == null");
        }
        if (inetSocketAddress == null) {
            throw new NullPointerException("inetSocketAddress == null");
        }
        this.f9948a = address;
        this.f9949b = proxy;
        this.f9950c = inetSocketAddress;
    }

    /* renamed from: a */
    public Address m2998a() {
        return this.f9948a;
    }

    /* renamed from: b */
    public Proxy m2997b() {
        return this.f9949b;
    }

    /* renamed from: c */
    public InetSocketAddress m2996c() {
        return this.f9950c;
    }

    /* renamed from: d */
    public boolean m2995d() {
        return this.f9948a.f9904i != null && this.f9949b.type() == Proxy.Type.HTTP;
    }

    public boolean equals(@Nullable Object obj) {
        if (obj instanceof Route) {
            Route route = (Route) obj;
            if (route.f9948a.equals(this.f9948a) && route.f9949b.equals(this.f9949b) && route.f9950c.equals(this.f9950c)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return ((((527 + this.f9948a.hashCode()) * 31) + this.f9949b.hashCode()) * 31) + this.f9950c.hashCode();
    }

    public String toString() {
        return "Route{" + this.f9950c + "}";
    }
}
