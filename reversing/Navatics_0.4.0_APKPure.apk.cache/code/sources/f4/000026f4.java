package org.apache.mina.filter.p124b;

import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetAddress;

/* compiled from: Subnet.java */
/* renamed from: org.apache.mina.filter.b.a, reason: use source file name */
/* loaded from: classes2.dex */
public class Subnet {

    /* renamed from: a */
    private InetAddress f11611a;

    /* renamed from: b */
    private int f11612b;

    /* renamed from: c */
    private long f11613c;

    /* renamed from: d */
    private long f11614d;

    /* renamed from: e */
    private int f11615e;

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
            this.f11611a = inetAddress;
            this.f11612b = m11912b(inetAddress);
            this.f11615e = i;
            this.f11614d = Integer.MIN_VALUE >> (i - 1);
            return;
        }
        if (i < 0 || i > 128) {
            throw new IllegalArgumentException("Mask has to be an integer between 0 and 128 for an IPV6 address");
        }
        this.f11611a = inetAddress;
        this.f11613c = m11913c(inetAddress);
        this.f11615e = i;
        this.f11614d = (-9223372036854775808) >> (i - 1);
    }

    /* renamed from: b */
    private int m11912b(InetAddress inetAddress) {
        int i = 0;
        for (byte b : inetAddress.getAddress()) {
            i = (i << 8) | (b & 255);
        }
        return i;
    }

    /* renamed from: c */
    private long m11913c(InetAddress inetAddress) {
        long j = 0;
        for (int i = 0; i < inetAddress.getAddress().length; i++) {
            j = (j << 8) | (r6[i] & 255);
        }
        return j;
    }

    /* renamed from: d */
    private long m11914d(InetAddress inetAddress) {
        if (inetAddress instanceof Inet4Address) {
            return m11912b(inetAddress) & ((int) this.f11614d);
        }
        return m11913c(inetAddress) & this.f11614d;
    }

    /* renamed from: a */
    public boolean m11915a(InetAddress inetAddress) {
        if (inetAddress.isAnyLocalAddress()) {
            return true;
        }
        return inetAddress instanceof Inet4Address ? ((int) m11914d(inetAddress)) == this.f11612b : m11914d(inetAddress) == this.f11613c;
    }

    public String toString() {
        return this.f11611a.getHostAddress() + "/" + this.f11615e;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof Subnet)) {
            return false;
        }
        Subnet subnet = (Subnet) obj;
        return subnet.f11612b == this.f11612b && subnet.f11615e == this.f11615e;
    }
}