package okhttp3;

import java.lang.ref.Reference;
import java.net.Socket;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;
import okhttp3.internal.C2930c;
import okhttp3.internal.connection.RealConnection;
import okhttp3.internal.connection.RouteDatabase;
import okhttp3.internal.connection.StreamAllocation;
import okhttp3.internal.p107e.Platform;

/* renamed from: okhttp3.j */
/* loaded from: classes2.dex */
public final class ConnectionPool {

    /* renamed from: c */
    static final /* synthetic */ boolean f10480c = !ConnectionPool.class.desiredAssertionStatus();

    /* renamed from: d */
    private static final Executor f10481d = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60, TimeUnit.SECONDS, new SynchronousQueue(), C2930c.m2887a("OkHttp ConnectionPool", true));

    /* renamed from: a */
    final RouteDatabase f10482a;

    /* renamed from: b */
    boolean f10483b;

    /* renamed from: e */
    private final int f10484e;

    /* renamed from: f */
    private final long f10485f;

    /* renamed from: g */
    private final Runnable f10486g;

    /* renamed from: h */
    private final Deque<RealConnection> f10487h;

    public ConnectionPool() {
        this(5, 5L, TimeUnit.MINUTES);
    }

    public ConnectionPool(int i, long j, TimeUnit timeUnit) {
        this.f10486g = new Runnable() { // from class: okhttp3.j.1
            @Override // java.lang.Runnable
            public void run() {
                while (true) {
                    long m2581a = ConnectionPool.this.m2581a(System.nanoTime());
                    if (m2581a == -1) {
                        return;
                    }
                    if (m2581a > 0) {
                        long j2 = m2581a / 1000000;
                        long j3 = m2581a - (1000000 * j2);
                        synchronized (ConnectionPool.this) {
                            try {
                                ConnectionPool.this.wait(j2, (int) j3);
                            } catch (InterruptedException unused) {
                            }
                        }
                    }
                }
            }
        };
        this.f10487h = new ArrayDeque();
        this.f10482a = new RouteDatabase();
        this.f10484e = i;
        this.f10485f = timeUnit.toNanos(j);
        if (j > 0) {
            return;
        }
        throw new IllegalArgumentException("keepAliveDuration <= 0: " + j);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    /* renamed from: a */
    public RealConnection m2579a(Address address, StreamAllocation streamAllocation, Route route) {
        if (f10480c || Thread.holdsLock(this)) {
            for (RealConnection realConnection : this.f10487h) {
                if (realConnection.m2844a(address, route)) {
                    streamAllocation.m2813a(realConnection, true);
                    return realConnection;
                }
            }
            return null;
        }
        throw new AssertionError();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    /* renamed from: a */
    public Socket m2580a(Address address, StreamAllocation streamAllocation) {
        if (f10480c || Thread.holdsLock(this)) {
            for (RealConnection realConnection : this.f10487h) {
                if (realConnection.m2844a(address, null) && realConnection.m2834f() && realConnection != streamAllocation.m2807c()) {
                    return streamAllocation.m2814a(realConnection);
                }
            }
            return null;
        }
        throw new AssertionError();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public void m2578a(RealConnection realConnection) {
        if (!f10480c && !Thread.holdsLock(this)) {
            throw new AssertionError();
        }
        if (!this.f10483b) {
            this.f10483b = true;
            f10481d.execute(this.f10486g);
        }
        this.f10487h.add(realConnection);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: b */
    public boolean m2576b(RealConnection realConnection) {
        if (f10480c || Thread.holdsLock(this)) {
            if (realConnection.f10230a || this.f10484e == 0) {
                this.f10487h.remove(realConnection);
                return true;
            }
            notifyAll();
            return false;
        }
        throw new AssertionError();
    }

    /* renamed from: a */
    long m2581a(long j) {
        synchronized (this) {
            long j2 = Long.MIN_VALUE;
            RealConnection realConnection = null;
            int i = 0;
            int i2 = 0;
            for (RealConnection realConnection2 : this.f10487h) {
                if (m2577a(realConnection2, j) > 0) {
                    i2++;
                } else {
                    i++;
                    long j3 = j - realConnection2.f10234e;
                    if (j3 > j2) {
                        realConnection = realConnection2;
                        j2 = j3;
                    }
                }
            }
            if (j2 < this.f10485f && i <= this.f10484e) {
                if (i > 0) {
                    return this.f10485f - j2;
                } else if (i2 > 0) {
                    return this.f10485f;
                } else {
                    this.f10483b = false;
                    return -1L;
                }
            }
            this.f10487h.remove(realConnection);
            C2930c.m2884a(realConnection.m2836d());
            return 0L;
        }
    }

    /* renamed from: a */
    private int m2577a(RealConnection realConnection, long j) {
        List<Reference<StreamAllocation>> list = realConnection.f10233d;
        int i = 0;
        while (i < list.size()) {
            Reference<StreamAllocation> reference = list.get(i);
            if (reference.get() != null) {
                i++;
            } else {
                Platform.m2762c().mo2774a("A connection to " + realConnection.m2838b().m2998a().m3051a() + " was leaked. Did you forget to close a response body?", ((StreamAllocation.C2941a) reference).f10270a);
                list.remove(i);
                realConnection.f10230a = true;
                if (list.isEmpty()) {
                    realConnection.f10234e = j - this.f10485f;
                    return 0;
                }
            }
        }
        return list.size();
    }
}
