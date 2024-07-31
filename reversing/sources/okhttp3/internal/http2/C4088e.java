package okhttp3.internal.http2;

import java.io.Closeable;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.Socket;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import okhttp3.internal.C2930c;
import okhttp3.internal.NamedRunnable;
import okhttp3.internal.http2.Http2Reader;
import okhttp3.internal.p107e.Platform;
import okio.Buffer;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.ByteString;

/* renamed from: okhttp3.internal.http2.e */
/* loaded from: classes2.dex */
public final class Http2Connection implements Closeable {

    /* renamed from: r */
    static final /* synthetic */ boolean f10355r = !Http2Connection.class.desiredAssertionStatus();

    /* renamed from: s */
    private static final ExecutorService f10356s = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60, TimeUnit.SECONDS, new SynchronousQueue(), C2930c.m2887a("OkHttp Http2Connection", true));

    /* renamed from: a */
    final boolean f10357a;

    /* renamed from: b */
    final AbstractC2958b f10358b;

    /* renamed from: d */
    final String f10360d;

    /* renamed from: e */
    int f10361e;

    /* renamed from: f */
    int f10362f;

    /* renamed from: g */
    boolean f10363g;

    /* renamed from: h */
    final PushObserver f10364h;

    /* renamed from: j */
    long f10366j;

    /* renamed from: n */
    final Socket f10370n;

    /* renamed from: o */
    final Http2Writer f10371o;

    /* renamed from: p */
    final C2961d f10372p;

    /* renamed from: t */
    private final ScheduledExecutorService f10374t;

    /* renamed from: u */
    private final ExecutorService f10375u;

    /* renamed from: v */
    private boolean f10376v;

    /* renamed from: c */
    final Map<Integer, Http2Stream> f10359c = new LinkedHashMap();

    /* renamed from: i */
    long f10365i = 0;

    /* renamed from: k */
    C2972k f10367k = new C2972k();

    /* renamed from: l */
    final C2972k f10368l = new C2972k();

    /* renamed from: m */
    boolean f10369m = false;

    /* renamed from: q */
    final Set<Integer> f10373q = new LinkedHashSet();

    /* compiled from: Http2Connection.java */
    /* renamed from: okhttp3.internal.http2.e$b */
    /* loaded from: classes2.dex */
    public static abstract class AbstractC2958b {

        /* renamed from: f */
        public static final AbstractC2958b f10406f = new AbstractC2958b() { // from class: okhttp3.internal.http2.e.b.1
            @Override // okhttp3.internal.http2.Http2Connection.AbstractC2958b
            /* renamed from: a */
            public void mo2676a(Http2Stream http2Stream) throws IOException {
                http2Stream.m2645a(ErrorCode.REFUSED_STREAM);
            }
        };

        /* renamed from: a */
        public void mo2677a(Http2Connection http2Connection) {
        }

        /* renamed from: a */
        public abstract void mo2676a(Http2Stream http2Stream) throws IOException;
    }

    /* renamed from: c */
    boolean m2686c(int i) {
        return i != 0 && (i & 1) == 0;
    }

    Http2Connection(C2957a c2957a) {
        this.f10364h = c2957a.f10403f;
        this.f10357a = c2957a.f10404g;
        this.f10358b = c2957a.f10402e;
        this.f10362f = c2957a.f10404g ? 1 : 2;
        if (c2957a.f10404g) {
            this.f10362f += 2;
        }
        if (c2957a.f10404g) {
            this.f10367k.m2595a(7, 16777216);
        }
        this.f10360d = c2957a.f10399b;
        this.f10374t = new ScheduledThreadPoolExecutor(1, C2930c.m2887a(C2930c.m2886a("OkHttp %s Writer", this.f10360d), false));
        if (c2957a.f10405h != 0) {
            this.f10374t.scheduleAtFixedRate(new C2960c(false, 0, 0), c2957a.f10405h, c2957a.f10405h, TimeUnit.MILLISECONDS);
        }
        this.f10375u = new ThreadPoolExecutor(0, 1, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue(), C2930c.m2887a(C2930c.m2886a("OkHttp %s Push Observer", this.f10360d), true));
        this.f10368l.m2595a(7, 65535);
        this.f10368l.m2595a(5, 16384);
        this.f10366j = this.f10368l.m2589d();
        this.f10370n = c2957a.f10398a;
        this.f10371o = new Http2Writer(c2957a.f10401d, this.f10357a);
        this.f10372p = new C2961d(new Http2Reader(c2957a.f10400c, this.f10357a));
    }

    /* renamed from: a */
    synchronized Http2Stream m2708a(int i) {
        return this.f10359c.get(Integer.valueOf(i));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: b */
    public synchronized Http2Stream m2691b(int i) {
        Http2Stream remove;
        remove = this.f10359c.remove(Integer.valueOf(i));
        notifyAll();
        return remove;
    }

    /* renamed from: a */
    public synchronized int m2709a() {
        return this.f10368l.m2590c(Integer.MAX_VALUE);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public synchronized void m2701a(long j) {
        this.f10365i += j;
        if (this.f10365i >= this.f10367k.m2589d() / 2) {
            m2707a(0, this.f10365i);
            this.f10365i = 0L;
        }
    }

    /* renamed from: a */
    public Http2Stream m2700a(List<Header> list, boolean z) throws IOException {
        return m2690b(0, list, z);
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0043 A[Catch: all -> 0x0075, TryCatch #1 {, blocks: (B:4:0x0006, B:24:0x004f, B:28:0x005e, B:25:0x0055, B:27:0x0059, B:32:0x0067, B:33:0x006e, B:5:0x0007, B:7:0x000e, B:8:0x0013, B:10:0x0017, B:12:0x002b, B:14:0x0033, B:19:0x003d, B:21:0x0043, B:22:0x004c, B:34:0x006f, B:35:0x0074), top: B:42:0x0006 }] */
    /* renamed from: b */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private okhttp3.internal.http2.Http2Stream m2690b(int r11, java.util.List<okhttp3.internal.http2.Header> r12, boolean r13) throws java.io.IOException {
        /*
            r10 = this;
            r6 = r13 ^ 1
            r4 = 0
            okhttp3.internal.http2.h r7 = r10.f10371o
            monitor-enter(r7)
            monitor-enter(r10)     // Catch: java.lang.Throwable -> L78
            int r0 = r10.f10362f     // Catch: java.lang.Throwable -> L75
            r1 = 1073741823(0x3fffffff, float:1.9999999)
            if (r0 <= r1) goto L13
            okhttp3.internal.http2.ErrorCode r0 = okhttp3.internal.http2.ErrorCode.REFUSED_STREAM     // Catch: java.lang.Throwable -> L75
            r10.m2698a(r0)     // Catch: java.lang.Throwable -> L75
        L13:
            boolean r0 = r10.f10363g     // Catch: java.lang.Throwable -> L75
            if (r0 != 0) goto L6f
            int r8 = r10.f10362f     // Catch: java.lang.Throwable -> L75
            int r0 = r10.f10362f     // Catch: java.lang.Throwable -> L75
            int r0 = r0 + 2
            r10.f10362f = r0     // Catch: java.lang.Throwable -> L75
            okhttp3.internal.http2.g r9 = new okhttp3.internal.http2.g     // Catch: java.lang.Throwable -> L75
            r0 = r9
            r1 = r8
            r2 = r10
            r3 = r6
            r5 = r12
            r0.<init>(r1, r2, r3, r4, r5)     // Catch: java.lang.Throwable -> L75
            if (r13 == 0) goto L3c
            long r0 = r10.f10366j     // Catch: java.lang.Throwable -> L75
            r2 = 0
            int r13 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r13 == 0) goto L3c
            long r0 = r9.f10431b     // Catch: java.lang.Throwable -> L75
            int r13 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r13 != 0) goto L3a
            goto L3c
        L3a:
            r13 = 0
            goto L3d
        L3c:
            r13 = 1
        L3d:
            boolean r0 = r9.m2643b()     // Catch: java.lang.Throwable -> L75
            if (r0 == 0) goto L4c
            java.util.Map<java.lang.Integer, okhttp3.internal.http2.g> r0 = r10.f10359c     // Catch: java.lang.Throwable -> L75
            java.lang.Integer r1 = java.lang.Integer.valueOf(r8)     // Catch: java.lang.Throwable -> L75
            r0.put(r1, r9)     // Catch: java.lang.Throwable -> L75
        L4c:
            monitor-exit(r10)     // Catch: java.lang.Throwable -> L75
            if (r11 != 0) goto L55
            okhttp3.internal.http2.h r0 = r10.f10371o     // Catch: java.lang.Throwable -> L78
            r0.m2614a(r6, r8, r11, r12)     // Catch: java.lang.Throwable -> L78
            goto L5e
        L55:
            boolean r0 = r10.f10357a     // Catch: java.lang.Throwable -> L78
            if (r0 != 0) goto L67
            okhttp3.internal.http2.h r0 = r10.f10371o     // Catch: java.lang.Throwable -> L78
            r0.m2621a(r11, r8, r12)     // Catch: java.lang.Throwable -> L78
        L5e:
            monitor-exit(r7)     // Catch: java.lang.Throwable -> L78
            if (r13 == 0) goto L66
            okhttp3.internal.http2.h r11 = r10.f10371o
            r11.m2611b()
        L66:
            return r9
        L67:
            java.lang.IllegalArgumentException r11 = new java.lang.IllegalArgumentException     // Catch: java.lang.Throwable -> L78
            java.lang.String r12 = "client streams shouldn't have associated stream IDs"
            r11.<init>(r12)     // Catch: java.lang.Throwable -> L78
            throw r11     // Catch: java.lang.Throwable -> L78
        L6f:
            okhttp3.internal.http2.ConnectionShutdownException r11 = new okhttp3.internal.http2.ConnectionShutdownException     // Catch: java.lang.Throwable -> L75
            r11.<init>()     // Catch: java.lang.Throwable -> L75
            throw r11     // Catch: java.lang.Throwable -> L75
        L75:
            r11 = move-exception
            monitor-exit(r10)     // Catch: java.lang.Throwable -> L75
            throw r11     // Catch: java.lang.Throwable -> L78
        L78:
            r11 = move-exception
            monitor-exit(r7)     // Catch: java.lang.Throwable -> L78
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.http2.Http2Connection.m2690b(int, java.util.List, boolean):okhttp3.internal.http2.g");
    }

    /* renamed from: a */
    public void m2702a(int i, boolean z, Buffer buffer, long j) throws IOException {
        int min;
        long j2;
        if (j == 0) {
            this.f10371o.m2612a(z, i, buffer, 0);
            return;
        }
        while (j > 0) {
            synchronized (this) {
                while (this.f10366j <= 0) {
                    try {
                        if (!this.f10359c.containsKey(Integer.valueOf(i))) {
                            throw new IOException("stream closed");
                        }
                        wait();
                    } catch (InterruptedException unused) {
                        Thread.currentThread().interrupt();
                        throw new InterruptedIOException();
                    }
                }
                min = Math.min((int) Math.min(j, this.f10366j), this.f10371o.m2608c());
                j2 = min;
                this.f10366j -= j2;
            }
            j -= j2;
            this.f10371o.m2612a(z && j == 0, i, buffer, min);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public void m2704a(final int i, final ErrorCode errorCode) {
        try {
            this.f10374t.execute(new NamedRunnable("OkHttp %s stream %d", new Object[]{this.f10360d, Integer.valueOf(i)}) { // from class: okhttp3.internal.http2.e.1
                @Override // okhttp3.internal.NamedRunnable
                /* renamed from: c */
                public void mo2351c() {
                    try {
                        Http2Connection.this.m2689b(i, errorCode);
                    } catch (IOException unused) {
                        Http2Connection.this.m2682f();
                    }
                }
            });
        } catch (RejectedExecutionException unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: b */
    public void m2689b(int i, ErrorCode errorCode) throws IOException {
        this.f10371o.m2619a(i, errorCode);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public void m2707a(final int i, final long j) {
        try {
            this.f10374t.execute(new NamedRunnable("OkHttp Window Update %s stream %d", new Object[]{this.f10360d, Integer.valueOf(i)}) { // from class: okhttp3.internal.http2.e.2
                @Override // okhttp3.internal.NamedRunnable
                /* renamed from: c */
                public void mo2351c() {
                    try {
                        Http2Connection.this.f10371o.m2620a(i, j);
                    } catch (IOException unused) {
                        Http2Connection.this.m2682f();
                    }
                }
            });
        } catch (RejectedExecutionException unused) {
        }
    }

    /* compiled from: Http2Connection.java */
    /* renamed from: okhttp3.internal.http2.e$c */
    /* loaded from: classes2.dex */
    final class C2960c extends NamedRunnable {

        /* renamed from: a */
        final boolean f10407a;

        /* renamed from: c */
        final int f10408c;

        /* renamed from: d */
        final int f10409d;

        C2960c(boolean z, int i, int i2) {
            super("OkHttp %s ping %08x%08x", Http2Connection.this.f10360d, Integer.valueOf(i), Integer.valueOf(i2));
            this.f10407a = z;
            this.f10408c = i;
            this.f10409d = i2;
        }

        @Override // okhttp3.internal.NamedRunnable
        /* renamed from: c */
        public void mo2351c() {
            Http2Connection.this.m2693a(this.f10407a, this.f10408c, this.f10409d);
        }
    }

    /* renamed from: a */
    void m2693a(boolean z, int i, int i2) {
        boolean z2;
        if (!z) {
            synchronized (this) {
                z2 = this.f10376v;
                this.f10376v = true;
            }
            if (z2) {
                m2682f();
                return;
            }
        }
        try {
            this.f10371o.m2615a(z, i, i2);
        } catch (IOException unused) {
            m2682f();
        }
    }

    /* renamed from: b */
    public void m2692b() throws IOException {
        this.f10371o.m2611b();
    }

    /* renamed from: a */
    public void m2698a(ErrorCode errorCode) throws IOException {
        synchronized (this.f10371o) {
            synchronized (this) {
                if (this.f10363g) {
                    return;
                }
                this.f10363g = true;
                this.f10371o.m2618a(this.f10361e, errorCode, C2930c.f10179a);
            }
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        m2697a(ErrorCode.NO_ERROR, ErrorCode.CANCEL);
    }

    /* renamed from: a */
    void m2697a(ErrorCode errorCode, ErrorCode errorCode2) throws IOException {
        if (!f10355r && Thread.holdsLock(this)) {
            throw new AssertionError();
        }
        Http2Stream[] http2StreamArr = null;
        try {
            m2698a(errorCode);
            e = null;
        } catch (IOException e) {
            e = e;
        }
        synchronized (this) {
            if (!this.f10359c.isEmpty()) {
                http2StreamArr = (Http2Stream[]) this.f10359c.values().toArray(new Http2Stream[this.f10359c.size()]);
                this.f10359c.clear();
            }
        }
        if (http2StreamArr != null) {
            for (Http2Stream http2Stream : http2StreamArr) {
                try {
                    http2Stream.m2645a(errorCode2);
                } catch (IOException e2) {
                    if (e != null) {
                        e = e2;
                    }
                }
            }
        }
        try {
            this.f10371o.close();
        } catch (IOException e3) {
            if (e == null) {
                e = e3;
            }
        }
        try {
            this.f10370n.close();
        } catch (IOException e4) {
            e = e4;
        }
        this.f10374t.shutdown();
        this.f10375u.shutdown();
        if (e != null) {
            throw e;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: f */
    public void m2682f() {
        try {
            m2697a(ErrorCode.PROTOCOL_ERROR, ErrorCode.PROTOCOL_ERROR);
        } catch (IOException unused) {
        }
    }

    /* renamed from: c */
    public void m2687c() throws IOException {
        m2694a(true);
    }

    /* renamed from: a */
    void m2694a(boolean z) throws IOException {
        if (z) {
            this.f10371o.m2624a();
            this.f10371o.m2609b(this.f10367k);
            int m2589d = this.f10367k.m2589d();
            if (m2589d != 65535) {
                this.f10371o.m2620a(0, m2589d - 65535);
            }
        }
        new Thread(this.f10372p).start();
    }

    /* renamed from: d */
    public synchronized boolean m2684d() {
        return this.f10363g;
    }

    /* compiled from: Http2Connection.java */
    /* renamed from: okhttp3.internal.http2.e$a */
    /* loaded from: classes2.dex */
    public static class C2957a {

        /* renamed from: a */
        Socket f10398a;

        /* renamed from: b */
        String f10399b;

        /* renamed from: c */
        BufferedSource f10400c;

        /* renamed from: d */
        BufferedSink f10401d;

        /* renamed from: e */
        AbstractC2958b f10402e = AbstractC2958b.f10406f;

        /* renamed from: f */
        PushObserver f10403f = PushObserver.f10469a;

        /* renamed from: g */
        boolean f10404g;

        /* renamed from: h */
        int f10405h;

        public C2957a(boolean z) {
            this.f10404g = z;
        }

        /* renamed from: a */
        public C2957a m2679a(Socket socket, String str, BufferedSource bufferedSource, BufferedSink bufferedSink) {
            this.f10398a = socket;
            this.f10399b = str;
            this.f10400c = bufferedSource;
            this.f10401d = bufferedSink;
            return this;
        }

        /* renamed from: a */
        public C2957a m2678a(AbstractC2958b abstractC2958b) {
            this.f10402e = abstractC2958b;
            return this;
        }

        /* renamed from: a */
        public C2957a m2680a(int i) {
            this.f10405h = i;
            return this;
        }

        /* renamed from: a */
        public Http2Connection m2681a() {
            return new Http2Connection(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Http2Connection.java */
    /* renamed from: okhttp3.internal.http2.e$d */
    /* loaded from: classes2.dex */
    public class C2961d extends NamedRunnable implements Http2Reader.InterfaceC2966b {

        /* renamed from: a */
        final Http2Reader f10411a;

        @Override // okhttp3.internal.http2.Http2Reader.InterfaceC2966b
        /* renamed from: a */
        public void mo2658a() {
        }

        @Override // okhttp3.internal.http2.Http2Reader.InterfaceC2966b
        /* renamed from: a */
        public void mo2657a(int i, int i2, int i3, boolean z) {
        }

        C2961d(Http2Reader http2Reader) {
            super("OkHttp %s", Http2Connection.this.f10360d);
            this.f10411a = http2Reader;
        }

        @Override // okhttp3.internal.NamedRunnable
        /* renamed from: c */
        protected void mo2351c() {
            Http2Connection http2Connection;
            ErrorCode errorCode = ErrorCode.INTERNAL_ERROR;
            ErrorCode errorCode2 = ErrorCode.INTERNAL_ERROR;
            try {
                try {
                    try {
                        this.f10411a.m2672a(this);
                        while (this.f10411a.m2668a(false, (Http2Reader.InterfaceC2966b) this)) {
                        }
                        errorCode = ErrorCode.NO_ERROR;
                        errorCode2 = ErrorCode.CANCEL;
                        http2Connection = Http2Connection.this;
                    } catch (IOException unused) {
                        errorCode = ErrorCode.PROTOCOL_ERROR;
                        errorCode2 = ErrorCode.PROTOCOL_ERROR;
                        http2Connection = Http2Connection.this;
                    }
                    http2Connection.m2697a(errorCode, errorCode2);
                } catch (IOException unused2) {
                }
                C2930c.m2897a(this.f10411a);
            } catch (Throwable th) {
                try {
                    Http2Connection.this.m2697a(errorCode, errorCode2);
                } catch (IOException unused3) {
                }
                C2930c.m2897a(this.f10411a);
                throw th;
            }
        }

        @Override // okhttp3.internal.http2.Http2Reader.InterfaceC2966b
        /* renamed from: a */
        public void mo2650a(boolean z, int i, BufferedSource bufferedSource, int i2) throws IOException {
            if (Http2Connection.this.m2686c(i)) {
                Http2Connection.this.m2703a(i, bufferedSource, i2, z);
                return;
            }
            Http2Stream m2708a = Http2Connection.this.m2708a(i);
            if (m2708a == null) {
                Http2Connection.this.m2704a(i, ErrorCode.PROTOCOL_ERROR);
                long j = i2;
                Http2Connection.this.m2701a(j);
                bufferedSource.mo2231i(j);
                return;
            }
            m2708a.m2644a(bufferedSource, i2);
            if (z) {
                m2708a.m2633i();
            }
        }

        @Override // okhttp3.internal.http2.Http2Reader.InterfaceC2966b
        /* renamed from: a */
        public void mo2651a(boolean z, int i, int i2, List<Header> list) {
            if (Http2Connection.this.m2686c(i)) {
                Http2Connection.this.m2705a(i, list, z);
                return;
            }
            synchronized (Http2Connection.this) {
                Http2Stream m2708a = Http2Connection.this.m2708a(i);
                if (m2708a == null) {
                    if (Http2Connection.this.f10363g) {
                        return;
                    }
                    if (i <= Http2Connection.this.f10361e) {
                        return;
                    }
                    if (i % 2 == Http2Connection.this.f10362f % 2) {
                        return;
                    }
                    final Http2Stream http2Stream = new Http2Stream(i, Http2Connection.this, false, z, list);
                    Http2Connection.this.f10361e = i;
                    Http2Connection.this.f10359c.put(Integer.valueOf(i), http2Stream);
                    Http2Connection.f10356s.execute(new NamedRunnable("OkHttp %s stream %d", new Object[]{Http2Connection.this.f10360d, Integer.valueOf(i)}) { // from class: okhttp3.internal.http2.e.d.1
                        @Override // okhttp3.internal.NamedRunnable
                        /* renamed from: c */
                        public void mo2351c() {
                            try {
                                Http2Connection.this.f10358b.mo2676a(http2Stream);
                            } catch (IOException e) {
                                Platform m2762c = Platform.m2762c();
                                m2762c.mo2776a(4, "Http2Connection.Listener failure for " + Http2Connection.this.f10360d, e);
                                try {
                                    http2Stream.m2645a(ErrorCode.PROTOCOL_ERROR);
                                } catch (IOException unused) {
                                }
                            }
                        }
                    });
                    return;
                }
                m2708a.m2646a(list);
                if (z) {
                    m2708a.m2633i();
                }
            }
        }

        @Override // okhttp3.internal.http2.Http2Reader.InterfaceC2966b
        /* renamed from: a */
        public void mo2654a(int i, ErrorCode errorCode) {
            if (Http2Connection.this.m2686c(i)) {
                Http2Connection.this.m2685c(i, errorCode);
                return;
            }
            Http2Stream m2691b = Http2Connection.this.m2691b(i);
            if (m2691b != null) {
                m2691b.m2640c(errorCode);
            }
        }

        @Override // okhttp3.internal.http2.Http2Reader.InterfaceC2966b
        /* renamed from: a */
        public void mo2649a(boolean z, C2972k c2972k) {
            Http2Stream[] http2StreamArr;
            long j;
            int i;
            synchronized (Http2Connection.this) {
                int m2589d = Http2Connection.this.f10368l.m2589d();
                if (z) {
                    Http2Connection.this.f10368l.m2597a();
                }
                Http2Connection.this.f10368l.m2594a(c2972k);
                m2675a(c2972k);
                int m2589d2 = Http2Connection.this.f10368l.m2589d();
                http2StreamArr = null;
                if (m2589d2 == -1 || m2589d2 == m2589d) {
                    j = 0;
                } else {
                    j = m2589d2 - m2589d;
                    if (!Http2Connection.this.f10369m) {
                        Http2Connection.this.f10369m = true;
                    }
                    if (!Http2Connection.this.f10359c.isEmpty()) {
                        http2StreamArr = (Http2Stream[]) Http2Connection.this.f10359c.values().toArray(new Http2Stream[Http2Connection.this.f10359c.size()]);
                    }
                }
                Http2Connection.f10356s.execute(new NamedRunnable("OkHttp %s settings", Http2Connection.this.f10360d) { // from class: okhttp3.internal.http2.e.d.2
                    @Override // okhttp3.internal.NamedRunnable
                    /* renamed from: c */
                    public void mo2351c() {
                        Http2Connection.this.f10358b.mo2677a(Http2Connection.this);
                    }
                });
            }
            if (http2StreamArr == null || j == 0) {
                return;
            }
            for (Http2Stream http2Stream : http2StreamArr) {
                synchronized (http2Stream) {
                    http2Stream.m2647a(j);
                }
            }
        }

        /* renamed from: a */
        private void m2675a(final C2972k c2972k) {
            try {
                Http2Connection.this.f10374t.execute(new NamedRunnable("OkHttp %s ACK Settings", new Object[]{Http2Connection.this.f10360d}) { // from class: okhttp3.internal.http2.e.d.3
                    @Override // okhttp3.internal.NamedRunnable
                    /* renamed from: c */
                    public void mo2351c() {
                        try {
                            Http2Connection.this.f10371o.m2617a(c2972k);
                        } catch (IOException unused) {
                            Http2Connection.this.m2682f();
                        }
                    }
                });
            } catch (RejectedExecutionException unused) {
            }
        }

        @Override // okhttp3.internal.http2.Http2Reader.InterfaceC2966b
        /* renamed from: a */
        public void mo2652a(boolean z, int i, int i2) {
            if (!z) {
                try {
                    Http2Connection.this.f10374t.execute(new C2960c(true, i, i2));
                    return;
                } catch (RejectedExecutionException unused) {
                    return;
                }
            }
            synchronized (Http2Connection.this) {
                Http2Connection.this.f10376v = false;
                Http2Connection.this.notifyAll();
            }
        }

        @Override // okhttp3.internal.http2.Http2Reader.InterfaceC2966b
        /* renamed from: a */
        public void mo2653a(int i, ErrorCode errorCode, ByteString byteString) {
            Http2Stream[] http2StreamArr;
            byteString.size();
            synchronized (Http2Connection.this) {
                http2StreamArr = (Http2Stream[]) Http2Connection.this.f10359c.values().toArray(new Http2Stream[Http2Connection.this.f10359c.size()]);
                Http2Connection.this.f10363g = true;
            }
            for (Http2Stream http2Stream : http2StreamArr) {
                if (http2Stream.m2648a() > i && http2Stream.m2641c()) {
                    http2Stream.m2640c(ErrorCode.REFUSED_STREAM);
                    Http2Connection.this.m2691b(http2Stream.m2648a());
                }
            }
        }

        @Override // okhttp3.internal.http2.Http2Reader.InterfaceC2966b
        /* renamed from: a */
        public void mo2655a(int i, long j) {
            if (i == 0) {
                synchronized (Http2Connection.this) {
                    Http2Connection.this.f10366j += j;
                    Http2Connection.this.notifyAll();
                }
                return;
            }
            Http2Stream m2708a = Http2Connection.this.m2708a(i);
            if (m2708a != null) {
                synchronized (m2708a) {
                    m2708a.m2647a(j);
                }
            }
        }

        @Override // okhttp3.internal.http2.Http2Reader.InterfaceC2966b
        /* renamed from: a */
        public void mo2656a(int i, int i2, List<Header> list) {
            Http2Connection.this.m2706a(i2, list);
        }
    }

    /* renamed from: a */
    void m2706a(final int i, final List<Header> list) {
        synchronized (this) {
            if (this.f10373q.contains(Integer.valueOf(i))) {
                m2704a(i, ErrorCode.PROTOCOL_ERROR);
                return;
            }
            this.f10373q.add(Integer.valueOf(i));
            try {
                m2699a(new NamedRunnable("OkHttp %s Push Request[%s]", new Object[]{this.f10360d, Integer.valueOf(i)}) { // from class: okhttp3.internal.http2.e.3
                    @Override // okhttp3.internal.NamedRunnable
                    /* renamed from: c */
                    public void mo2351c() {
                        if (Http2Connection.this.f10364h.mo2601a(i, list)) {
                            try {
                                Http2Connection.this.f10371o.m2619a(i, ErrorCode.CANCEL);
                                synchronized (Http2Connection.this) {
                                    Http2Connection.this.f10373q.remove(Integer.valueOf(i));
                                }
                            } catch (IOException unused) {
                            }
                        }
                    }
                });
            } catch (RejectedExecutionException unused) {
            }
        }
    }

    /* renamed from: a */
    void m2705a(final int i, final List<Header> list, final boolean z) {
        try {
            m2699a(new NamedRunnable("OkHttp %s Push Headers[%s]", new Object[]{this.f10360d, Integer.valueOf(i)}) { // from class: okhttp3.internal.http2.e.4
                @Override // okhttp3.internal.NamedRunnable
                /* renamed from: c */
                public void mo2351c() {
                    boolean mo2600a = Http2Connection.this.f10364h.mo2600a(i, list, z);
                    if (mo2600a) {
                        try {
                            Http2Connection.this.f10371o.m2619a(i, ErrorCode.CANCEL);
                        } catch (IOException unused) {
                            return;
                        }
                    }
                    if (mo2600a || z) {
                        synchronized (Http2Connection.this) {
                            Http2Connection.this.f10373q.remove(Integer.valueOf(i));
                        }
                    }
                }
            });
        } catch (RejectedExecutionException unused) {
        }
    }

    /* renamed from: a */
    void m2703a(final int i, BufferedSource bufferedSource, final int i2, final boolean z) throws IOException {
        final Buffer buffer = new Buffer();
        long j = i2;
        bufferedSource.mo2245a(j);
        bufferedSource.mo130a(buffer, j);
        if (buffer.m2302b() != j) {
            throw new IOException(buffer.m2302b() + " != " + i2);
        }
        m2699a(new NamedRunnable("OkHttp %s Push Data[%s]", new Object[]{this.f10360d, Integer.valueOf(i)}) { // from class: okhttp3.internal.http2.e.5
            @Override // okhttp3.internal.NamedRunnable
            /* renamed from: c */
            public void mo2351c() {
                try {
                    boolean mo2598a = Http2Connection.this.f10364h.mo2598a(i, buffer, i2, z);
                    if (mo2598a) {
                        Http2Connection.this.f10371o.m2619a(i, ErrorCode.CANCEL);
                    }
                    if (mo2598a || z) {
                        synchronized (Http2Connection.this) {
                            Http2Connection.this.f10373q.remove(Integer.valueOf(i));
                        }
                    }
                } catch (IOException unused) {
                }
            }
        });
    }

    /* renamed from: c */
    void m2685c(final int i, final ErrorCode errorCode) {
        m2699a(new NamedRunnable("OkHttp %s Push Reset[%s]", new Object[]{this.f10360d, Integer.valueOf(i)}) { // from class: okhttp3.internal.http2.e.6
            @Override // okhttp3.internal.NamedRunnable
            /* renamed from: c */
            public void mo2351c() {
                Http2Connection.this.f10364h.mo2599a(i, errorCode);
                synchronized (Http2Connection.this) {
                    Http2Connection.this.f10373q.remove(Integer.valueOf(i));
                }
            }
        });
    }

    /* renamed from: a */
    private synchronized void m2699a(NamedRunnable namedRunnable) {
        if (!m2684d()) {
            this.f10375u.execute(namedRunnable);
        }
    }
}
