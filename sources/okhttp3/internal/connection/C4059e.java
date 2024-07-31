package okhttp3.internal.connection;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.SocketAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;
import okhttp3.Address;
import okhttp3.Call;
import okhttp3.EventListener;
import okhttp3.HttpUrl;
import okhttp3.Route;
import okhttp3.internal.C2930c;

/* renamed from: okhttp3.internal.connection.e */
/* loaded from: classes2.dex */
public final class RouteSelector {

    /* renamed from: a */
    private final Address f10245a;

    /* renamed from: b */
    private final RouteDatabase f10246b;

    /* renamed from: c */
    private final Call f10247c;

    /* renamed from: d */
    private final EventListener f10248d;

    /* renamed from: f */
    private int f10250f;

    /* renamed from: e */
    private List<Proxy> f10249e = Collections.emptyList();

    /* renamed from: g */
    private List<InetSocketAddress> f10251g = Collections.emptyList();

    /* renamed from: h */
    private final List<Route> f10252h = new ArrayList();

    public RouteSelector(Address address, RouteDatabase routeDatabase, Call call, EventListener eventListener) {
        this.f10245a = address;
        this.f10246b = routeDatabase;
        this.f10247c = call;
        this.f10248d = eventListener;
        m2825a(address.m3051a(), address.m3043h());
    }

    /* renamed from: a */
    public boolean m2829a() {
        return m2823c() || !this.f10252h.isEmpty();
    }

    /* renamed from: b */
    public C2940a m2824b() throws IOException {
        if (!m2829a()) {
            throw new NoSuchElementException();
        }
        ArrayList arrayList = new ArrayList();
        while (m2823c()) {
            Proxy m2822d = m2822d();
            int size = this.f10251g.size();
            for (int i = 0; i < size; i++) {
                Route route = new Route(this.f10245a, m2822d, this.f10251g.get(i));
                if (this.f10246b.m2830c(route)) {
                    this.f10252h.add(route);
                } else {
                    arrayList.add(route);
                }
            }
            if (!arrayList.isEmpty()) {
                break;
            }
        }
        if (arrayList.isEmpty()) {
            arrayList.addAll(this.f10252h);
            this.f10252h.clear();
        }
        return new C2940a(arrayList);
    }

    /* renamed from: a */
    public void m2826a(Route route, IOException iOException) {
        if (route.m2997b().type() != Proxy.Type.DIRECT && this.f10245a.m3044g() != null) {
            this.f10245a.m3044g().connectFailed(this.f10245a.m3051a().m2487a(), route.m2997b().address(), iOException);
        }
        this.f10246b.m2832a(route);
    }

    /* renamed from: a */
    private void m2825a(HttpUrl httpUrl, Proxy proxy) {
        if (proxy != null) {
            this.f10249e = Collections.singletonList(proxy);
        } else {
            List<Proxy> select = this.f10245a.m3044g().select(httpUrl.m2487a());
            this.f10249e = (select == null || select.isEmpty()) ? C2930c.m2875a(Proxy.NO_PROXY) : C2930c.m2881a(select);
        }
        this.f10250f = 0;
    }

    /* renamed from: c */
    private boolean m2823c() {
        return this.f10250f < this.f10249e.size();
    }

    /* renamed from: d */
    private Proxy m2822d() throws IOException {
        if (!m2823c()) {
            throw new SocketException("No route to " + this.f10245a.m3051a().m2464f() + "; exhausted proxy configurations: " + this.f10249e);
        }
        List<Proxy> list = this.f10249e;
        int i = this.f10250f;
        this.f10250f = i + 1;
        Proxy proxy = list.get(i);
        m2827a(proxy);
        return proxy;
    }

    /* renamed from: a */
    private void m2827a(Proxy proxy) throws IOException {
        String m2464f;
        int m2462g;
        this.f10251g = new ArrayList();
        if (proxy.type() == Proxy.Type.DIRECT || proxy.type() == Proxy.Type.SOCKS) {
            m2464f = this.f10245a.m3051a().m2464f();
            m2462g = this.f10245a.m3051a().m2462g();
        } else {
            SocketAddress address = proxy.address();
            if (!(address instanceof InetSocketAddress)) {
                throw new IllegalArgumentException("Proxy.address() is not an InetSocketAddress: " + address.getClass());
            }
            InetSocketAddress inetSocketAddress = (InetSocketAddress) address;
            m2464f = m2828a(inetSocketAddress);
            m2462g = inetSocketAddress.getPort();
        }
        if (m2462g < 1 || m2462g > 65535) {
            throw new SocketException("No route to " + m2464f + ":" + m2462g + "; port is out of range");
        } else if (proxy.type() == Proxy.Type.SOCKS) {
            this.f10251g.add(InetSocketAddress.createUnresolved(m2464f, m2462g));
        } else {
            this.f10248d.m2532a(this.f10247c, m2464f);
            List<InetAddress> mo2536a = this.f10245a.m3049b().mo2536a(m2464f);
            if (mo2536a.isEmpty()) {
                throw new UnknownHostException(this.f10245a.m3049b() + " returned no addresses for " + m2464f);
            }
            this.f10248d.m2531a(this.f10247c, m2464f, mo2536a);
            int size = mo2536a.size();
            for (int i = 0; i < size; i++) {
                this.f10251g.add(new InetSocketAddress(mo2536a.get(i), m2462g));
            }
        }
    }

    /* renamed from: a */
    static String m2828a(InetSocketAddress inetSocketAddress) {
        InetAddress address = inetSocketAddress.getAddress();
        if (address == null) {
            return inetSocketAddress.getHostName();
        }
        return address.getHostAddress();
    }

    /* compiled from: RouteSelector.java */
    /* renamed from: okhttp3.internal.connection.e$a */
    /* loaded from: classes2.dex */
    public static final class C2940a {

        /* renamed from: a */
        private final List<Route> f10253a;

        /* renamed from: b */
        private int f10254b = 0;

        C2940a(List<Route> list) {
            this.f10253a = list;
        }

        /* renamed from: a */
        public boolean m2821a() {
            return this.f10254b < this.f10253a.size();
        }

        /* renamed from: b */
        public Route m2820b() {
            if (!m2821a()) {
                throw new NoSuchElementException();
            }
            List<Route> list = this.f10253a;
            int i = this.f10254b;
            this.f10254b = i + 1;
            return list.get(i);
        }

        /* renamed from: c */
        public List<Route> m2819c() {
            return new ArrayList(this.f10253a);
        }
    }
}
