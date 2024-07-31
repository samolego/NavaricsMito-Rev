package okhttp3;

import java.net.InetSocketAddress;
import java.net.Proxy;
import javax.annotation.Nullable;

/* compiled from: Route.java */
/* renamed from: okhttp3.ad */
/* loaded from: classes2.dex */
public final class C2910ad {

    /* renamed from: a */
    final C2906a f9989a;

    /* renamed from: b */
    final Proxy f9990b;

    /* renamed from: c */
    final InetSocketAddress f9991c;

    public C2910ad(C2906a c2906a, Proxy proxy, InetSocketAddress inetSocketAddress) {
        if (c2906a == null) {
            throw new NullPointerException("address == null");
        }
        if (proxy == null) {
            throw new NullPointerException("proxy == null");
        }
        if (inetSocketAddress == null) {
            throw new NullPointerException("inetSocketAddress == null");
        }
        this.f9989a = c2906a;
        this.f9990b = proxy;
        this.f9991c = inetSocketAddress;
    }

    /* renamed from: a */
    public C2906a m9838a() {
        return this.f9989a;
    }

    /* renamed from: b */
    public Proxy m9839b() {
        return this.f9990b;
    }

    /* renamed from: c */
    public InetSocketAddress m9840c() {
        return this.f9991c;
    }

    /* renamed from: d */
    public boolean m9841d() {
        return this.f9989a.f9945i != null && this.f9990b.type() == Proxy.Type.HTTP;
    }

    public boolean equals(@Nullable Object obj) {
        if (obj instanceof C2910ad) {
            C2910ad c2910ad = (C2910ad) obj;
            if (c2910ad.f9989a.equals(this.f9989a) && c2910ad.f9990b.equals(this.f9990b) && c2910ad.f9991c.equals(this.f9991c)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return ((((527 + this.f9989a.hashCode()) * 31) + this.f9990b.hashCode()) * 31) + this.f9991c.hashCode();
    }

    public String toString() {
        return "Route{" + this.f9991c + "}";
    }
}