package okio;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;

/* renamed from: okio.a */
/* loaded from: classes2.dex */
public class AsyncTimeout extends Timeout {
    @Nullable

    /* renamed from: b */
    static AsyncTimeout f10662b;

    /* renamed from: e */
    private boolean f10664e;
    @Nullable

    /* renamed from: f */
    private AsyncTimeout f10665f;

    /* renamed from: g */
    private long f10666g;

    /* renamed from: a */
    private static final long f10661a = TimeUnit.SECONDS.toMillis(60);

    /* renamed from: d */
    private static final long f10663d = TimeUnit.MILLISECONDS.toNanos(f10661a);

    /* renamed from: a */
    protected void mo2260a() {
    }

    /* renamed from: c */
    public final void m2319c() {
        if (this.f10664e) {
            throw new IllegalStateException("Unbalanced enter/exit");
        }
        long h_ = mo2211h_();
        boolean i_ = mo2210i_();
        if (h_ != 0 || i_) {
            this.f10664e = true;
            m2325a(this, h_, i_);
        }
    }

    /* renamed from: a */
    private static synchronized void m2325a(AsyncTimeout asyncTimeout, long j, boolean z) {
        synchronized (AsyncTimeout.class) {
            if (f10662b == null) {
                f10662b = new AsyncTimeout();
                new C2997a().start();
            }
            long nanoTime = System.nanoTime();
            int i = (j > 0L ? 1 : (j == 0L ? 0 : -1));
            if (i != 0 && z) {
                asyncTimeout.f10666g = Math.min(j, asyncTimeout.mo2213d() - nanoTime) + nanoTime;
            } else if (i != 0) {
                asyncTimeout.f10666g = j + nanoTime;
            } else if (z) {
                asyncTimeout.f10666g = asyncTimeout.mo2213d();
            } else {
                throw new AssertionError();
            }
            long m2321b = asyncTimeout.m2321b(nanoTime);
            AsyncTimeout asyncTimeout2 = f10662b;
            while (asyncTimeout2.f10665f != null && m2321b >= asyncTimeout2.f10665f.m2321b(nanoTime)) {
                asyncTimeout2 = asyncTimeout2.f10665f;
            }
            asyncTimeout.f10665f = asyncTimeout2.f10665f;
            asyncTimeout2.f10665f = asyncTimeout;
            if (asyncTimeout2 == f10662b) {
                AsyncTimeout.class.notify();
            }
        }
    }

    /* renamed from: g_ */
    public final boolean m2317g_() {
        if (this.f10664e) {
            this.f10664e = false;
            return m2326a(this);
        }
        return false;
    }

    /* renamed from: a */
    private static synchronized boolean m2326a(AsyncTimeout asyncTimeout) {
        synchronized (AsyncTimeout.class) {
            for (AsyncTimeout asyncTimeout2 = f10662b; asyncTimeout2 != null; asyncTimeout2 = asyncTimeout2.f10665f) {
                if (asyncTimeout2.f10665f == asyncTimeout) {
                    asyncTimeout2.f10665f = asyncTimeout.f10665f;
                    asyncTimeout.f10665f = null;
                    return false;
                }
            }
            return true;
        }
    }

    /* renamed from: b */
    private long m2321b(long j) {
        return this.f10666g - j;
    }

    /* renamed from: a */
    public final Sink m2324a(final Sink sink) {
        return new Sink() { // from class: okio.a.1
            @Override // okio.Sink
            /* renamed from: a_ */
            public void mo2215a_(Buffer buffer, long j) throws IOException {
                C3006s.m2204a(buffer.f10675b, 0L, j);
                while (true) {
                    long j2 = 0;
                    if (j <= 0) {
                        return;
                    }
                    Segment segment = buffer.f10674a;
                    while (true) {
                        if (j2 >= 65536) {
                            break;
                        }
                        j2 += segment.f10705c - segment.f10704b;
                        if (j2 >= j) {
                            j2 = j;
                            break;
                        }
                        segment = segment.f10708f;
                    }
                    AsyncTimeout.this.m2319c();
                    try {
                        try {
                            sink.mo2215a_(buffer, j2);
                            j -= j2;
                            AsyncTimeout.this.m2322a(true);
                        } catch (IOException e) {
                            throw AsyncTimeout.this.m2320b(e);
                        }
                    } catch (Throwable th) {
                        AsyncTimeout.this.m2322a(false);
                        throw th;
                    }
                }
            }

            @Override // okio.Sink, java.io.Flushable
            public void flush() throws IOException {
                AsyncTimeout.this.m2319c();
                try {
                    try {
                        sink.flush();
                        AsyncTimeout.this.m2322a(true);
                    } catch (IOException e) {
                        throw AsyncTimeout.this.m2320b(e);
                    }
                } catch (Throwable th) {
                    AsyncTimeout.this.m2322a(false);
                    throw th;
                }
            }

            @Override // okio.Sink, java.io.Closeable, java.lang.AutoCloseable
            public void close() throws IOException {
                AsyncTimeout.this.m2319c();
                try {
                    try {
                        sink.close();
                        AsyncTimeout.this.m2322a(true);
                    } catch (IOException e) {
                        throw AsyncTimeout.this.m2320b(e);
                    }
                } catch (Throwable th) {
                    AsyncTimeout.this.m2322a(false);
                    throw th;
                }
            }

            @Override // okio.Sink
            /* renamed from: a */
            public Timeout mo2216a() {
                return AsyncTimeout.this;
            }

            public String toString() {
                return "AsyncTimeout.sink(" + sink + ")";
            }
        };
    }

    /* renamed from: a */
    public final Source m2323a(final Source source) {
        return new Source() { // from class: okio.a.2
            @Override // okio.Source
            /* renamed from: a */
            public long mo130a(Buffer buffer, long j) throws IOException {
                AsyncTimeout.this.m2319c();
                try {
                    try {
                        long mo130a = source.mo130a(buffer, j);
                        AsyncTimeout.this.m2322a(true);
                        return mo130a;
                    } catch (IOException e) {
                        throw AsyncTimeout.this.m2320b(e);
                    }
                } catch (Throwable th) {
                    AsyncTimeout.this.m2322a(false);
                    throw th;
                }
            }

            @Override // okio.Source, java.io.Closeable, java.lang.AutoCloseable
            public void close() throws IOException {
                try {
                    try {
                        source.close();
                        AsyncTimeout.this.m2322a(true);
                    } catch (IOException e) {
                        throw AsyncTimeout.this.m2320b(e);
                    }
                } catch (Throwable th) {
                    AsyncTimeout.this.m2322a(false);
                    throw th;
                }
            }

            @Override // okio.Source
            /* renamed from: a */
            public Timeout mo2214a() {
                return AsyncTimeout.this;
            }

            public String toString() {
                return "AsyncTimeout.source(" + source + ")";
            }
        };
    }

    /* renamed from: a */
    final void m2322a(boolean z) throws IOException {
        if (m2317g_() && z) {
            throw mo2259a((IOException) null);
        }
    }

    /* renamed from: b */
    final IOException m2320b(IOException iOException) throws IOException {
        return !m2317g_() ? iOException : mo2259a(iOException);
    }

    /* renamed from: a */
    protected IOException mo2259a(@Nullable IOException iOException) {
        InterruptedIOException interruptedIOException = new InterruptedIOException("timeout");
        if (iOException != null) {
            interruptedIOException.initCause(iOException);
        }
        return interruptedIOException;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: AsyncTimeout.java */
    /* renamed from: okio.a$a */
    /* loaded from: classes2.dex */
    public static final class C2997a extends Thread {
        C2997a() {
            super("Okio Watchdog");
            setDaemon(true);
        }

        /* JADX WARN: Code restructure failed: missing block: B:14:0x0015, code lost:
            r1.mo2260a();
         */
        @Override // java.lang.Thread, java.lang.Runnable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void run() {
            /*
                r3 = this;
            L0:
                java.lang.Class<okio.a> r0 = okio.AsyncTimeout.class
                monitor-enter(r0)     // Catch: java.lang.InterruptedException -> L0
                okio.a r1 = okio.AsyncTimeout.m2318e()     // Catch: java.lang.Throwable -> L19
                if (r1 != 0) goto Lb
                monitor-exit(r0)     // Catch: java.lang.Throwable -> L19
                goto L0
            Lb:
                okio.a r2 = okio.AsyncTimeout.f10662b     // Catch: java.lang.Throwable -> L19
                if (r1 != r2) goto L14
                r1 = 0
                okio.AsyncTimeout.f10662b = r1     // Catch: java.lang.Throwable -> L19
                monitor-exit(r0)     // Catch: java.lang.Throwable -> L19
                return
            L14:
                monitor-exit(r0)     // Catch: java.lang.Throwable -> L19
                r1.mo2260a()     // Catch: java.lang.InterruptedException -> L0
                goto L0
            L19:
                r1 = move-exception
                monitor-exit(r0)     // Catch: java.lang.Throwable -> L19
                throw r1     // Catch: java.lang.InterruptedException -> L0
            */
            throw new UnsupportedOperationException("Method not decompiled: okio.AsyncTimeout.C2997a.run():void");
        }
    }

    @Nullable
    /* renamed from: e */
    static AsyncTimeout m2318e() throws InterruptedException {
        AsyncTimeout asyncTimeout = f10662b.f10665f;
        if (asyncTimeout == null) {
            long nanoTime = System.nanoTime();
            AsyncTimeout.class.wait(f10661a);
            if (f10662b.f10665f != null || System.nanoTime() - nanoTime < f10663d) {
                return null;
            }
            return f10662b;
        }
        long m2321b = asyncTimeout.m2321b(System.nanoTime());
        if (m2321b > 0) {
            long j = m2321b / 1000000;
            AsyncTimeout.class.wait(j, (int) (m2321b - (1000000 * j)));
            return null;
        }
        f10662b.f10665f = asyncTimeout.f10665f;
        asyncTimeout.f10665f = null;
        return asyncTimeout;
    }
}
