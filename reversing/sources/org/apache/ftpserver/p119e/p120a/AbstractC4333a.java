package org.apache.ftpserver.p119e.p120a;

import java.net.InetAddress;
import java.util.List;
import org.apache.ftpserver.DataConnectionConfiguration;
import org.apache.ftpserver.ipfilter.IpFilterType;
import org.apache.ftpserver.ipfilter.RemoteIpFilter;
import org.apache.ftpserver.ipfilter.SessionFilter;
import org.apache.ftpserver.p119e.Listener;
import org.apache.ftpserver.ssl.SslConfiguration;
import org.apache.mina.filter.p135b.Subnet;

/* renamed from: org.apache.ftpserver.e.a.a */
/* loaded from: classes2.dex */
public abstract class AbstractListener implements Listener {

    /* renamed from: a */
    private final String f11058a;

    /* renamed from: b */
    private int f11059b;

    /* renamed from: c */
    private final SslConfiguration f11060c;

    /* renamed from: d */
    private final boolean f11061d;

    /* renamed from: e */
    private final int f11062e;

    /* renamed from: f */
    private final List<InetAddress> f11063f;

    /* renamed from: g */
    private final List<Subnet> f11064g;

    /* renamed from: h */
    private final SessionFilter f11065h;

    /* renamed from: i */
    private final DataConnectionConfiguration f11066i;

    @Deprecated
    public AbstractListener(String str, int i, boolean z, SslConfiguration sslConfiguration, DataConnectionConfiguration dataConnectionConfiguration, int i2, List<InetAddress> list, List<Subnet> list2) {
        this.f11059b = 21;
        this.f11058a = str;
        this.f11059b = i;
        this.f11061d = z;
        this.f11066i = dataConnectionConfiguration;
        this.f11060c = sslConfiguration;
        this.f11062e = i2;
        this.f11065h = m1806a(list, list2);
        this.f11063f = list;
        this.f11064g = list2;
    }

    public AbstractListener(String str, int i, boolean z, SslConfiguration sslConfiguration, DataConnectionConfiguration dataConnectionConfiguration, int i2, SessionFilter sessionFilter) {
        this.f11059b = 21;
        this.f11058a = str;
        this.f11059b = i;
        this.f11061d = z;
        this.f11066i = dataConnectionConfiguration;
        this.f11060c = sslConfiguration;
        this.f11062e = i2;
        this.f11065h = sessionFilter;
        this.f11063f = null;
        this.f11064g = null;
    }

    /* renamed from: a */
    private static SessionFilter m1806a(List<InetAddress> list, List<Subnet> list2) {
        if (list == null && list2 == null) {
            return null;
        }
        RemoteIpFilter remoteIpFilter = new RemoteIpFilter(IpFilterType.DENY);
        if (list2 != null) {
            remoteIpFilter.addAll(list2);
        }
        if (list != null) {
            for (InetAddress inetAddress : list) {
                remoteIpFilter.add((RemoteIpFilter) new Subnet(inetAddress, 32));
            }
        }
        return remoteIpFilter;
    }

    /* renamed from: e */
    public boolean m1802e() {
        return this.f11061d;
    }

    /* renamed from: f */
    public int m1801f() {
        return this.f11059b;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: a */
    public void m1807a(int i) {
        this.f11059b = i;
    }

    /* renamed from: g */
    public String m1800g() {
        return this.f11058a;
    }

    @Override // org.apache.ftpserver.p119e.Listener
    /* renamed from: b */
    public SslConfiguration mo1805b() {
        return this.f11060c;
    }

    @Override // org.apache.ftpserver.p119e.Listener
    /* renamed from: c */
    public DataConnectionConfiguration mo1804c() {
        return this.f11066i;
    }

    @Override // org.apache.ftpserver.p119e.Listener
    /* renamed from: d */
    public int mo1803d() {
        return this.f11062e;
    }

    /* renamed from: h */
    public SessionFilter m1799h() {
        return this.f11065h;
    }
}
