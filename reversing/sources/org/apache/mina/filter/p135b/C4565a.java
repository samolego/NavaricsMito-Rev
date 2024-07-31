package org.apache.mina.filter.p135b;

import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetAddress;

/* renamed from: org.apache.mina.filter.b.a */
/* loaded from: classes2.dex */
public class Subnet {

    /* renamed from: a */
    private InetAddress f11570a;

    /* renamed from: b */
    private int f11571b;

    /* renamed from: c */
    private long f11572c;

    /* renamed from: d */
    private long f11573d;

    /* renamed from: e */
    private int f11574e;

    public Subnet(InetAddress inetAddress, int i) {
        if (inetAddress == null) {
            throw new IllegalArgumentException("Subnet address can not be null");
        }
        boolean z = inetAddress instanceof Inet4Address;
        if (!z && !(inetAddress instanceof Inet6Address)) {
            throw new IllegalArgumentException("Only IPv4 and IPV6 supported");
        }
        if (z) {
            if (i < 0 || i > 32) {
                throw new IllegalArgumentException("Mask has to be an integer between 0 and 32 for an IPV4 address");
            }
            this.f11570a = inetAddress;
            this.f11571b = m917b(inetAddress);
            this.f11574e = i;
            this.f11573d = Integer.MIN_VALUE >> (i - 1);
        } else if (i < 0 || i > 128) {
            throw new IllegalArgumentException("Mask has to be an integer between 0 and 128 for an IPV6 address");
        } else {
            this.f11570a = inetAddress;
            this.f11572c = m916c(inetAddress);
            this.f11574e = i;
            this.f11573d = (-9223372036854775808) >> (i - 1);
        }
    }

    /* renamed from: b */
    private int m917b(InetAddress inetAddress) {
        int i = 0;
        for (byte b : inetAddress.getAddress()) {
            i = (i << 8) | (b & 255);
        }
        return i;
    }

    /* renamed from: c */
    private long m916c(InetAddress inetAddress) {
        long j = 0;
        for (byte b : inetAddress.getAddress()) {
            j = (j << 8) | (b & 255);
        }
        return j;
    }

    /* renamed from: d */
    private long m915d(InetAddress inetAddress) {
        if (inetAddress instanceof Inet4Address) {
            return m917b(inetAddress) & ((int) this.f11573d);
        }
        return m916c(inetAddress) & this.f11573d;
    }

    /* renamed from: a */
    public boolean m918a(InetAddress inetAddress) {
        if (inetAddress.isAnyLocalAddress()) {
            return true;
        }
        return inetAddress instanceof Inet4Address ? ((int) m915d(inetAddress)) == this.f11571b : m915d(inetAddress) == this.f11572c;
    }

    public String toString() {
        return this.f11570a.getHostAddress() + "/" + this.f11574e;
    }

    public boolean equals(Object obj) {
        if (obj instanceof Subnet) {
            Subnet subnet = (Subnet) obj;
            return subnet.f11571b == this.f11571b && subnet.f11574e == this.f11574e;
        }
        return false;
    }
}
