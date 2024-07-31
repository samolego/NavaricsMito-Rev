package okhttp3.internal.connection;

import java.io.IOException;
import java.lang.ref.WeakReference;
import java.net.Socket;
import java.util.List;
import okhttp3.Address;
import okhttp3.Call;
import okhttp3.ConnectionPool;
import okhttp3.EventListener;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Route;
import okhttp3.internal.C2930c;
import okhttp3.internal.Internal;
import okhttp3.internal.connection.RouteSelector;
import okhttp3.internal.http2.ConnectionShutdownException;
import okhttp3.internal.http2.ErrorCode;
import okhttp3.internal.http2.StreamResetException;
import okhttp3.internal.p104b.HttpCodec;

/* renamed from: okhttp3.internal.connection.f */
/* loaded from: classes2.dex */
public final class StreamAllocation {

    /* renamed from: d */
    static final /* synthetic */ boolean f10255d = !StreamAllocation.class.desiredAssertionStatus();

    /* renamed from: a */
    public final Address f10256a;

    /* renamed from: b */
    public final Call f10257b;

    /* renamed from: c */
    public final EventListener f10258c;

    /* renamed from: e */
    private RouteSelector.C2940a f10259e;

    /* renamed from: f */
    private Route f10260f;

    /* renamed from: g */
    private final ConnectionPool f10261g;

    /* renamed from: h */
    private final Object f10262h;

    /* renamed from: i */
    private final RouteSelector f10263i;

    /* renamed from: j */
    private int f10264j;

    /* renamed from: k */
    private RealConnection f10265k;

    /* renamed from: l */
    private boolean f10266l;

    /* renamed from: m */
    private boolean f10267m;

    /* renamed from: n */
    private boolean f10268n;

    /* renamed from: o */
    private HttpCodec f10269o;

    public StreamAllocation(ConnectionPool connectionPool, Address address, Call call, EventListener eventListener, Object obj) {
        this.f10261g = connectionPool;
        this.f10256a = address;
        this.f10257b = call;
        this.f10258c = eventListener;
        this.f10263i = new RouteSelector(address, m2801i(), call, eventListener);
        this.f10262h = obj;
    }

    /* renamed from: a */
    public HttpCodec m2812a(OkHttpClient okHttpClient, Interceptor.InterfaceC2987a interfaceC2987a, boolean z) {
        try {
            HttpCodec m2840a = m2816a(interfaceC2987a.mo2425c(), interfaceC2987a.mo2424d(), interfaceC2987a.mo2423e(), okHttpClient.m2404d(), okHttpClient.m2389s(), z).m2840a(okHttpClient, interfaceC2987a, this);
            synchronized (this.f10261g) {
                this.f10269o = m2840a;
            }
            return m2840a;
        } catch (IOException e) {
            throw new RouteException(e);
        }
    }

    /* renamed from: a */
    private RealConnection m2816a(int i, int i2, int i3, int i4, boolean z, boolean z2) throws IOException {
        while (true) {
            RealConnection m2817a = m2817a(i, i2, i3, i4, z);
            synchronized (this.f10261g) {
                if (m2817a.f10231b == 0) {
                    return m2817a;
                }
                if (m2817a.m2839a(z2)) {
                    return m2817a;
                }
                m2805e();
            }
        }
    }

    /* renamed from: a */
    private RealConnection m2817a(int i, int i2, int i3, int i4, boolean z) throws IOException {
        Socket m2802h;
        Socket socket;
        RealConnection realConnection;
        RealConnection realConnection2;
        RealConnection realConnection3;
        Route route;
        boolean z2;
        boolean z3;
        RouteSelector.C2940a c2940a;
        synchronized (this.f10261g) {
            if (this.f10267m) {
                throw new IllegalStateException("released");
            }
            if (this.f10269o != null) {
                throw new IllegalStateException("codec != null");
            }
            if (this.f10268n) {
                throw new IOException("Canceled");
            }
            RealConnection realConnection4 = this.f10265k;
            m2802h = m2802h();
            socket = null;
            if (this.f10265k != null) {
                realConnection2 = this.f10265k;
                realConnection = null;
            } else {
                realConnection = realConnection4;
                realConnection2 = null;
            }
            if (!this.f10266l) {
                realConnection = null;
            }
            if (realConnection2 == null) {
                Internal.f10101a.mo2378a(this.f10261g, this.f10256a, this, null);
                if (this.f10265k != null) {
                    realConnection3 = this.f10265k;
                    route = null;
                    z2 = true;
                } else {
                    route = this.f10260f;
                    realConnection3 = realConnection2;
                    z2 = false;
                }
            } else {
                realConnection3 = realConnection2;
                route = null;
                z2 = false;
            }
        }
        C2930c.m2884a(m2802h);
        if (realConnection != null) {
            this.f10258c.m2520b(this.f10257b, realConnection);
        }
        if (z2) {
            this.f10258c.m2526a(this.f10257b, realConnection3);
        }
        if (realConnection3 != null) {
            return realConnection3;
        }
        if (route != null || ((c2940a = this.f10259e) != null && c2940a.m2821a())) {
            z3 = false;
        } else {
            this.f10259e = this.f10263i.m2824b();
            z3 = true;
        }
        synchronized (this.f10261g) {
            if (this.f10268n) {
                throw new IOException("Canceled");
            }
            if (z3) {
                List<Route> m2819c = this.f10259e.m2819c();
                int size = m2819c.size();
                int i5 = 0;
                while (true) {
                    if (i5 >= size) {
                        break;
                    }
                    Route route2 = m2819c.get(i5);
                    Internal.f10101a.mo2378a(this.f10261g, this.f10256a, this, route2);
                    if (this.f10265k != null) {
                        realConnection3 = this.f10265k;
                        this.f10260f = route2;
                        z2 = true;
                        break;
                    }
                    i5++;
                }
            }
            if (!z2) {
                if (route == null) {
                    route = this.f10259e.m2820b();
                }
                this.f10260f = route;
                this.f10264j = 0;
                realConnection3 = new RealConnection(this.f10261g, route);
                m2813a(realConnection3, false);
            }
        }
        if (z2) {
            this.f10258c.m2526a(this.f10257b, realConnection3);
            return realConnection3;
        }
        realConnection3.m2848a(i, i2, i3, i4, z, this.f10257b, this.f10258c);
        m2801i().m2831b(realConnection3.m2838b());
        synchronized (this.f10261g) {
            this.f10266l = true;
            Internal.f10101a.mo2373b(this.f10261g, realConnection3);
            if (realConnection3.m2834f()) {
                socket = Internal.f10101a.mo2379a(this.f10261g, this.f10256a, this);
                realConnection3 = this.f10265k;
            }
        }
        C2930c.m2884a(socket);
        this.f10258c.m2526a(this.f10257b, realConnection3);
        return realConnection3;
    }

    /* renamed from: h */
    private Socket m2802h() {
        if (f10255d || Thread.holdsLock(this.f10261g)) {
            RealConnection realConnection = this.f10265k;
            if (realConnection == null || !realConnection.f10230a) {
                return null;
            }
            return m2810a(false, false, true);
        }
        throw new AssertionError();
    }

    /* renamed from: a */
    public void m2811a(boolean z, HttpCodec httpCodec, long j, IOException iOException) {
        RealConnection realConnection;
        Socket m2810a;
        boolean z2;
        this.f10258c.m2521b(this.f10257b, j);
        synchronized (this.f10261g) {
            if (httpCodec != null) {
                if (httpCodec == this.f10269o) {
                    if (!z) {
                        this.f10265k.f10231b++;
                    }
                    realConnection = this.f10265k;
                    m2810a = m2810a(z, false, true);
                    if (this.f10265k != null) {
                        realConnection = null;
                    }
                    z2 = this.f10267m;
                }
            }
            throw new IllegalStateException("expected " + this.f10269o + " but was " + httpCodec);
        }
        C2930c.m2884a(m2810a);
        if (realConnection != null) {
            this.f10258c.m2520b(this.f10257b, realConnection);
        }
        if (iOException != null) {
            this.f10258c.m2533a(this.f10257b, iOException);
        } else if (z2) {
            this.f10258c.m2515g(this.f10257b);
        }
    }

    /* renamed from: a */
    public HttpCodec m2818a() {
        HttpCodec httpCodec;
        synchronized (this.f10261g) {
            httpCodec = this.f10269o;
        }
        return httpCodec;
    }

    /* renamed from: i */
    private RouteDatabase m2801i() {
        return Internal.f10101a.mo2380a(this.f10261g);
    }

    /* renamed from: b */
    public Route m2809b() {
        return this.f10260f;
    }

    /* renamed from: c */
    public synchronized RealConnection m2807c() {
        return this.f10265k;
    }

    /* renamed from: d */
    public void m2806d() {
        RealConnection realConnection;
        Socket m2810a;
        synchronized (this.f10261g) {
            realConnection = this.f10265k;
            m2810a = m2810a(false, true, false);
            if (this.f10265k != null) {
                realConnection = null;
            }
        }
        C2930c.m2884a(m2810a);
        if (realConnection != null) {
            this.f10258c.m2520b(this.f10257b, realConnection);
            this.f10258c.m2515g(this.f10257b);
        }
    }

    /* renamed from: e */
    public void m2805e() {
        RealConnection realConnection;
        Socket m2810a;
        synchronized (this.f10261g) {
            realConnection = this.f10265k;
            m2810a = m2810a(true, false, false);
            if (this.f10265k != null) {
                realConnection = null;
            }
        }
        C2930c.m2884a(m2810a);
        if (realConnection != null) {
            this.f10258c.m2520b(this.f10257b, realConnection);
        }
    }

    /* renamed from: a */
    private Socket m2810a(boolean z, boolean z2, boolean z3) {
        Socket socket;
        if (f10255d || Thread.holdsLock(this.f10261g)) {
            if (z3) {
                this.f10269o = null;
            }
            if (z2) {
                this.f10267m = true;
            }
            RealConnection realConnection = this.f10265k;
            if (realConnection != null) {
                if (z) {
                    realConnection.f10230a = true;
                }
                if (this.f10269o == null && (this.f10267m || this.f10265k.f10230a)) {
                    m2808b(this.f10265k);
                    if (this.f10265k.f10233d.isEmpty()) {
                        this.f10265k.f10234e = System.nanoTime();
                        if (Internal.f10101a.mo2377a(this.f10261g, this.f10265k)) {
                            socket = this.f10265k.m2836d();
                            this.f10265k = null;
                            return socket;
                        }
                    }
                    socket = null;
                    this.f10265k = null;
                    return socket;
                }
            }
            return null;
        }
        throw new AssertionError();
    }

    /* renamed from: f */
    public void m2804f() {
        HttpCodec httpCodec;
        RealConnection realConnection;
        synchronized (this.f10261g) {
            this.f10268n = true;
            httpCodec = this.f10269o;
            realConnection = this.f10265k;
        }
        if (httpCodec != null) {
            httpCodec.mo2711c();
        } else if (realConnection != null) {
            realConnection.m2837c();
        }
    }

    /* renamed from: a */
    public void m2815a(IOException iOException) {
        boolean z;
        RealConnection realConnection;
        Socket m2810a;
        synchronized (this.f10261g) {
            if (iOException instanceof StreamResetException) {
                ErrorCode errorCode = ((StreamResetException) iOException).errorCode;
                if (errorCode == ErrorCode.REFUSED_STREAM) {
                    this.f10264j++;
                    if (this.f10264j > 1) {
                        this.f10260f = null;
                        z = true;
                    }
                    z = false;
                } else {
                    if (errorCode != ErrorCode.CANCEL) {
                        this.f10260f = null;
                        z = true;
                    }
                    z = false;
                }
            } else if (this.f10265k == null || (this.f10265k.m2834f() && !(iOException instanceof ConnectionShutdownException))) {
                z = false;
            } else {
                if (this.f10265k.f10231b == 0) {
                    if (this.f10260f != null && iOException != null) {
                        this.f10263i.m2826a(this.f10260f, iOException);
                    }
                    this.f10260f = null;
                }
                z = true;
            }
            realConnection = this.f10265k;
            m2810a = m2810a(z, false, true);
            if (this.f10265k != null || !this.f10266l) {
                realConnection = null;
            }
        }
        C2930c.m2884a(m2810a);
        if (realConnection != null) {
            this.f10258c.m2520b(this.f10257b, realConnection);
        }
    }

    /* renamed from: a */
    public void m2813a(RealConnection realConnection, boolean z) {
        if (!f10255d && !Thread.holdsLock(this.f10261g)) {
            throw new AssertionError();
        }
        if (this.f10265k != null) {
            throw new IllegalStateException();
        }
        this.f10265k = realConnection;
        this.f10266l = z;
        realConnection.f10233d.add(new C2941a(this, this.f10262h));
    }

    /* renamed from: b */
    private void m2808b(RealConnection realConnection) {
        int size = realConnection.f10233d.size();
        for (int i = 0; i < size; i++) {
            if (realConnection.f10233d.get(i).get() == this) {
                realConnection.f10233d.remove(i);
                return;
            }
        }
        throw new IllegalStateException();
    }

    /* renamed from: a */
    public Socket m2814a(RealConnection realConnection) {
        if (f10255d || Thread.holdsLock(this.f10261g)) {
            if (this.f10269o != null || this.f10265k.f10233d.size() != 1) {
                throw new IllegalStateException();
            }
            Socket m2810a = m2810a(true, false, false);
            this.f10265k = realConnection;
            realConnection.f10233d.add(this.f10265k.f10233d.get(0));
            return m2810a;
        }
        throw new AssertionError();
    }

    /* renamed from: g */
    public boolean m2803g() {
        RouteSelector.C2940a c2940a;
        return this.f10260f != null || ((c2940a = this.f10259e) != null && c2940a.m2821a()) || this.f10263i.m2829a();
    }

    public String toString() {
        RealConnection m2807c = m2807c();
        return m2807c != null ? m2807c.toString() : this.f10256a.toString();
    }

    /* compiled from: StreamAllocation.java */
    /* renamed from: okhttp3.internal.connection.f$a */
    /* loaded from: classes2.dex */
    public static final class C2941a extends WeakReference<StreamAllocation> {

        /* renamed from: a */
        public final Object f10270a;

        C2941a(StreamAllocation streamAllocation, Object obj) {
            super(streamAllocation);
            this.f10270a = obj;
        }
    }
}
