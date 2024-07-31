package okhttp3.internal.http2;

import java.io.EOFException;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.SocketTimeoutException;
import java.util.ArrayList;
import java.util.List;
import okio.AsyncTimeout;
import okio.Buffer;
import okio.BufferedSource;
import okio.Sink;
import okio.Source;
import okio.Timeout;

/* renamed from: okhttp3.internal.http2.g */
/* loaded from: classes2.dex */
public final class Http2Stream {

    /* renamed from: i */
    static final /* synthetic */ boolean f10429i = !Http2Stream.class.desiredAssertionStatus();

    /* renamed from: b */
    long f10431b;

    /* renamed from: c */
    final int f10432c;

    /* renamed from: d */
    final Http2Connection f10433d;

    /* renamed from: e */
    final C2967a f10434e;

    /* renamed from: j */
    private final List<Header> f10438j;

    /* renamed from: k */
    private List<Header> f10439k;

    /* renamed from: l */
    private boolean f10440l;

    /* renamed from: m */
    private final C2968b f10441m;

    /* renamed from: a */
    long f10430a = 0;

    /* renamed from: f */
    final C2969c f10435f = new C2969c();

    /* renamed from: g */
    final C2969c f10436g = new C2969c();

    /* renamed from: h */
    ErrorCode f10437h = null;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Http2Stream(int i, Http2Connection http2Connection, boolean z, boolean z2, List<Header> list) {
        if (http2Connection == null) {
            throw new NullPointerException("connection == null");
        }
        if (list == null) {
            throw new NullPointerException("requestHeaders == null");
        }
        this.f10432c = i;
        this.f10433d = http2Connection;
        this.f10431b = http2Connection.f10368l.m2589d();
        this.f10441m = new C2968b(http2Connection.f10367k.m2589d());
        this.f10434e = new C2967a();
        this.f10441m.f10449b = z2;
        this.f10434e.f10444b = z;
        this.f10438j = list;
    }

    /* renamed from: a */
    public int m2648a() {
        return this.f10432c;
    }

    /* renamed from: b */
    public synchronized boolean m2643b() {
        if (this.f10437h != null) {
            return false;
        }
        if ((this.f10441m.f10449b || this.f10441m.f10448a) && (this.f10434e.f10444b || this.f10434e.f10443a)) {
            if (this.f10440l) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: c */
    public boolean m2641c() {
        return this.f10433d.f10357a == ((this.f10432c & 1) == 1);
    }

    /* renamed from: d */
    public synchronized List<Header> m2639d() throws IOException {
        List<Header> list;
        if (!m2641c()) {
            throw new IllegalStateException("servers cannot read response headers");
        }
        this.f10435f.m2319c();
        while (this.f10439k == null && this.f10437h == null) {
            m2630l();
        }
        this.f10435f.m2625b();
        list = this.f10439k;
        if (list != null) {
            this.f10439k = null;
        } else {
            throw new StreamResetException(this.f10437h);
        }
        return list;
    }

    /* renamed from: e */
    public Timeout m2637e() {
        return this.f10435f;
    }

    /* renamed from: f */
    public Timeout m2636f() {
        return this.f10436g;
    }

    /* renamed from: g */
    public Source m2635g() {
        return this.f10441m;
    }

    /* renamed from: h */
    public Sink m2634h() {
        synchronized (this) {
            if (!this.f10440l && !m2641c()) {
                throw new IllegalStateException("reply before requesting the sink");
            }
        }
        return this.f10434e;
    }

    /* renamed from: a */
    public void m2645a(ErrorCode errorCode) throws IOException {
        if (m2638d(errorCode)) {
            this.f10433d.m2689b(this.f10432c, errorCode);
        }
    }

    /* renamed from: b */
    public void m2642b(ErrorCode errorCode) {
        if (m2638d(errorCode)) {
            this.f10433d.m2704a(this.f10432c, errorCode);
        }
    }

    /* renamed from: d */
    private boolean m2638d(ErrorCode errorCode) {
        if (f10429i || !Thread.holdsLock(this)) {
            synchronized (this) {
                if (this.f10437h != null) {
                    return false;
                }
                if (this.f10441m.f10449b && this.f10434e.f10444b) {
                    return false;
                }
                this.f10437h = errorCode;
                notifyAll();
                this.f10433d.m2691b(this.f10432c);
                return true;
            }
        }
        throw new AssertionError();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public void m2646a(List<Header> list) {
        boolean z;
        if (!f10429i && Thread.holdsLock(this)) {
            throw new AssertionError();
        }
        synchronized (this) {
            z = true;
            this.f10440l = true;
            if (this.f10439k == null) {
                this.f10439k = list;
                z = m2643b();
                notifyAll();
            } else {
                ArrayList arrayList = new ArrayList();
                arrayList.addAll(this.f10439k);
                arrayList.add(null);
                arrayList.addAll(list);
                this.f10439k = arrayList;
            }
        }
        if (z) {
            return;
        }
        this.f10433d.m2691b(this.f10432c);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public void m2644a(BufferedSource bufferedSource, int i) throws IOException {
        if (!f10429i && Thread.holdsLock(this)) {
            throw new AssertionError();
        }
        this.f10441m.m2627a(bufferedSource, i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: i */
    public void m2633i() {
        boolean m2643b;
        if (!f10429i && Thread.holdsLock(this)) {
            throw new AssertionError();
        }
        synchronized (this) {
            this.f10441m.f10449b = true;
            m2643b = m2643b();
            notifyAll();
        }
        if (m2643b) {
            return;
        }
        this.f10433d.m2691b(this.f10432c);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: c */
    public synchronized void m2640c(ErrorCode errorCode) {
        if (this.f10437h == null) {
            this.f10437h = errorCode;
            notifyAll();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Http2Stream.java */
    /* renamed from: okhttp3.internal.http2.g$b */
    /* loaded from: classes2.dex */
    public final class C2968b implements Source {

        /* renamed from: c */
        static final /* synthetic */ boolean f10447c = !Http2Stream.class.desiredAssertionStatus();

        /* renamed from: a */
        boolean f10448a;

        /* renamed from: b */
        boolean f10449b;

        /* renamed from: e */
        private final Buffer f10451e = new Buffer();

        /* renamed from: f */
        private final Buffer f10452f = new Buffer();

        /* renamed from: g */
        private final long f10453g;

        C2968b(long j) {
            this.f10453g = j;
        }

        @Override // okio.Source
        /* renamed from: a */
        public long mo130a(Buffer buffer, long j) throws IOException {
            ErrorCode errorCode;
            long j2;
            if (j < 0) {
                throw new IllegalArgumentException("byteCount < 0: " + j);
            }
            synchronized (Http2Stream.this) {
                m2626b();
                if (this.f10448a) {
                    throw new IOException("stream closed");
                }
                errorCode = Http2Stream.this.f10437h;
                if (this.f10452f.m2302b() > 0) {
                    j2 = this.f10452f.mo130a(buffer, Math.min(j, this.f10452f.m2302b()));
                    Http2Stream.this.f10430a += j2;
                } else {
                    j2 = -1;
                }
                if (errorCode == null && Http2Stream.this.f10430a >= Http2Stream.this.f10433d.f10367k.m2589d() / 2) {
                    Http2Stream.this.f10433d.m2707a(Http2Stream.this.f10432c, Http2Stream.this.f10430a);
                    Http2Stream.this.f10430a = 0L;
                }
            }
            if (j2 != -1) {
                m2628a(j2);
                return j2;
            } else if (errorCode == null) {
                return -1L;
            } else {
                throw new StreamResetException(errorCode);
            }
        }

        /* renamed from: a */
        private void m2628a(long j) {
            if (!f10447c && Thread.holdsLock(Http2Stream.this)) {
                throw new AssertionError();
            }
            Http2Stream.this.f10433d.m2701a(j);
        }

        /* renamed from: b */
        private void m2626b() throws IOException {
            Http2Stream.this.f10435f.m2319c();
            while (this.f10452f.m2302b() == 0 && !this.f10449b && !this.f10448a && Http2Stream.this.f10437h == null) {
                try {
                    Http2Stream.this.m2630l();
                } finally {
                    Http2Stream.this.f10435f.m2625b();
                }
            }
        }

        /* renamed from: a */
        void m2627a(BufferedSource bufferedSource, long j) throws IOException {
            boolean z;
            boolean z2;
            boolean z3;
            if (!f10447c && Thread.holdsLock(Http2Stream.this)) {
                throw new AssertionError();
            }
            while (j > 0) {
                synchronized (Http2Stream.this) {
                    z = this.f10449b;
                    z2 = true;
                    z3 = this.f10452f.m2302b() + j > this.f10453g;
                }
                if (z3) {
                    bufferedSource.mo2231i(j);
                    Http2Stream.this.m2642b(ErrorCode.FLOW_CONTROL_ERROR);
                    return;
                } else if (z) {
                    bufferedSource.mo2231i(j);
                    return;
                } else {
                    long a = bufferedSource.mo130a(this.f10451e, j);
                    if (a == -1) {
                        throw new EOFException();
                    }
                    j -= a;
                    synchronized (Http2Stream.this) {
                        if (this.f10452f.m2302b() != 0) {
                            z2 = false;
                        }
                        this.f10452f.mo2258a((Source) this.f10451e);
                        if (z2) {
                            Http2Stream.this.notifyAll();
                        }
                    }
                }
            }
        }

        @Override // okio.Source
        /* renamed from: a */
        public Timeout mo2214a() {
            return Http2Stream.this.f10435f;
        }

        @Override // okio.Source, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            long m2302b;
            synchronized (Http2Stream.this) {
                this.f10448a = true;
                m2302b = this.f10452f.m2302b();
                this.f10452f.m2282t();
                Http2Stream.this.notifyAll();
            }
            if (m2302b > 0) {
                m2628a(m2302b);
            }
            Http2Stream.this.m2632j();
        }
    }

    /* renamed from: j */
    void m2632j() throws IOException {
        boolean z;
        boolean m2643b;
        if (!f10429i && Thread.holdsLock(this)) {
            throw new AssertionError();
        }
        synchronized (this) {
            z = !this.f10441m.f10449b && this.f10441m.f10448a && (this.f10434e.f10444b || this.f10434e.f10443a);
            m2643b = m2643b();
        }
        if (z) {
            m2645a(ErrorCode.CANCEL);
        } else if (m2643b) {
        } else {
            this.f10433d.m2691b(this.f10432c);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Http2Stream.java */
    /* renamed from: okhttp3.internal.http2.g$a */
    /* loaded from: classes2.dex */
    public final class C2967a implements Sink {

        /* renamed from: c */
        static final /* synthetic */ boolean f10442c = !Http2Stream.class.desiredAssertionStatus();

        /* renamed from: a */
        boolean f10443a;

        /* renamed from: b */
        boolean f10444b;

        /* renamed from: e */
        private final Buffer f10446e = new Buffer();

        C2967a() {
        }

        @Override // okio.Sink
        /* renamed from: a_ */
        public void mo2215a_(Buffer buffer, long j) throws IOException {
            if (!f10442c && Thread.holdsLock(Http2Stream.this)) {
                throw new AssertionError();
            }
            this.f10446e.mo2215a_(buffer, j);
            while (this.f10446e.m2302b() >= 16384) {
                m2629a(false);
            }
        }

        /* renamed from: a */
        private void m2629a(boolean z) throws IOException {
            long min;
            synchronized (Http2Stream.this) {
                Http2Stream.this.f10436g.m2319c();
                while (Http2Stream.this.f10431b <= 0 && !this.f10444b && !this.f10443a && Http2Stream.this.f10437h == null) {
                    Http2Stream.this.m2630l();
                }
                Http2Stream.this.f10436g.m2625b();
                Http2Stream.this.m2631k();
                min = Math.min(Http2Stream.this.f10431b, this.f10446e.m2302b());
                Http2Stream.this.f10431b -= min;
            }
            Http2Stream.this.f10436g.m2319c();
            try {
                Http2Stream.this.f10433d.m2702a(Http2Stream.this.f10432c, z && min == this.f10446e.m2302b(), this.f10446e, min);
            } finally {
                Http2Stream.this.f10436g.m2625b();
            }
        }

        @Override // okio.Sink, java.io.Flushable
        public void flush() throws IOException {
            if (!f10442c && Thread.holdsLock(Http2Stream.this)) {
                throw new AssertionError();
            }
            synchronized (Http2Stream.this) {
                Http2Stream.this.m2631k();
            }
            while (this.f10446e.m2302b() > 0) {
                m2629a(false);
                Http2Stream.this.f10433d.m2692b();
            }
        }

        @Override // okio.Sink
        /* renamed from: a */
        public Timeout mo2216a() {
            return Http2Stream.this.f10436g;
        }

        @Override // okio.Sink, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            if (!f10442c && Thread.holdsLock(Http2Stream.this)) {
                throw new AssertionError();
            }
            synchronized (Http2Stream.this) {
                if (this.f10443a) {
                    return;
                }
                if (!Http2Stream.this.f10434e.f10444b) {
                    if (this.f10446e.m2302b() > 0) {
                        while (this.f10446e.m2302b() > 0) {
                            m2629a(true);
                        }
                    } else {
                        Http2Stream.this.f10433d.m2702a(Http2Stream.this.f10432c, true, (Buffer) null, 0L);
                    }
                }
                synchronized (Http2Stream.this) {
                    this.f10443a = true;
                }
                Http2Stream.this.f10433d.m2692b();
                Http2Stream.this.m2632j();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public void m2647a(long j) {
        this.f10431b += j;
        if (j > 0) {
            notifyAll();
        }
    }

    /* renamed from: k */
    void m2631k() throws IOException {
        if (this.f10434e.f10443a) {
            throw new IOException("stream closed");
        }
        if (this.f10434e.f10444b) {
            throw new IOException("stream finished");
        }
        ErrorCode errorCode = this.f10437h;
        if (errorCode != null) {
            throw new StreamResetException(errorCode);
        }
    }

    /* renamed from: l */
    void m2630l() throws InterruptedIOException {
        try {
            wait();
        } catch (InterruptedException unused) {
            Thread.currentThread().interrupt();
            throw new InterruptedIOException();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Http2Stream.java */
    /* renamed from: okhttp3.internal.http2.g$c */
    /* loaded from: classes2.dex */
    public class C2969c extends AsyncTimeout {
        C2969c() {
        }

        @Override // okio.AsyncTimeout
        /* renamed from: a */
        protected void mo2260a() {
            Http2Stream.this.m2642b(ErrorCode.CANCEL);
        }

        @Override // okio.AsyncTimeout
        /* renamed from: a */
        protected IOException mo2259a(IOException iOException) {
            SocketTimeoutException socketTimeoutException = new SocketTimeoutException("timeout");
            if (iOException != null) {
                socketTimeoutException.initCause(iOException);
            }
            return socketTimeoutException;
        }

        /* renamed from: b */
        public void m2625b() throws IOException {
            if (m2317g_()) {
                throw mo2259a((IOException) null);
            }
        }
    }
}
