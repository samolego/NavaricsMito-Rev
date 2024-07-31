package okhttp3.internal.p103a;

import java.io.Closeable;
import java.io.File;
import java.io.Flushable;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.concurrent.Executor;
import java.util.regex.Pattern;
import okhttp3.internal.p106d.FileSystem;
import okio.BufferedSink;

/* compiled from: DiskLruCache.java */
/* renamed from: okhttp3.internal.a.d */
/* loaded from: classes2.dex */
public final class C2925d implements Closeable, Flushable {

    /* renamed from: b */
    final FileSystem f10124b;

    /* renamed from: c */
    final int f10125c;

    /* renamed from: d */
    BufferedSink f10126d;

    /* renamed from: e */
    final LinkedHashMap<String, C2927b> f10127e;

    /* renamed from: f */
    int f10128f;

    /* renamed from: g */
    boolean f10129g;

    /* renamed from: h */
    boolean f10130h;

    /* renamed from: i */
    boolean f10131i;

    /* renamed from: k */
    private long f10132k;

    /* renamed from: l */
    private long f10133l;

    /* renamed from: m */
    private long f10134m;

    /* renamed from: n */
    private final Executor f10135n;

    /* renamed from: o */
    private final Runnable f10136o;

    /* renamed from: j */
    static final /* synthetic */ boolean f10123j = !C2925d.class.desiredAssertionStatus();

    /* renamed from: a */
    static final Pattern f10122a = Pattern.compile("[a-z0-9_-]{1,120}");

    /* renamed from: a */
    synchronized void m2949a(C2926a c2926a, boolean z) throws IOException {
        C2927b c2927b = c2926a.f10137a;
        if (c2927b.f10146f != c2926a) {
            throw new IllegalStateException();
        }
        if (z && !c2927b.f10145e) {
            for (int i = 0; i < this.f10125c; i++) {
                if (!c2926a.f10138b[i]) {
                    c2926a.m2943b();
                    throw new IllegalStateException("Newly created entry didn't create value for index " + i);
                } else if (!this.f10124b.mo2797b(c2927b.f10144d[i])) {
                    c2926a.m2943b();
                    return;
                }
            }
        }
        for (int i2 = 0; i2 < this.f10125c; i2++) {
            File file = c2927b.f10144d[i2];
            if (z) {
                if (this.f10124b.mo2797b(file)) {
                    File file2 = c2927b.f10143c[i2];
                    this.f10124b.mo2798a(file, file2);
                    long j = c2927b.f10142b[i2];
                    long mo2796c = this.f10124b.mo2796c(file2);
                    c2927b.f10142b[i2] = mo2796c;
                    this.f10133l = (this.f10133l - j) + mo2796c;
                }
            } else {
                this.f10124b.mo2799a(file);
            }
        }
        this.f10128f++;
        c2927b.f10146f = null;
        if (c2927b.f10145e | z) {
            c2927b.f10145e = true;
            this.f10126d.mo2257b("CLEAN").mo2251i(32);
            this.f10126d.mo2257b(c2927b.f10141a);
            c2927b.m2942a(this.f10126d);
            this.f10126d.mo2251i(10);
            if (z) {
                long j2 = this.f10134m;
                this.f10134m = 1 + j2;
                c2927b.f10147g = j2;
            }
        } else {
            this.f10127e.remove(c2927b.f10141a);
            this.f10126d.mo2257b("REMOVE").mo2251i(32);
            this.f10126d.mo2257b(c2927b.f10141a);
            this.f10126d.mo2251i(10);
        }
        this.f10126d.flush();
        if (this.f10133l > this.f10132k || m2950a()) {
            this.f10135n.execute(this.f10136o);
        }
    }

    /* renamed from: a */
    boolean m2950a() {
        int i = this.f10128f;
        return i >= 2000 && i >= this.f10127e.size();
    }

    /* renamed from: a */
    boolean m2948a(C2927b c2927b) throws IOException {
        if (c2927b.f10146f != null) {
            c2927b.f10146f.m2944a();
        }
        for (int i = 0; i < this.f10125c; i++) {
            this.f10124b.mo2799a(c2927b.f10143c[i]);
            this.f10133l -= c2927b.f10142b[i];
            c2927b.f10142b[i] = 0;
        }
        this.f10128f++;
        this.f10126d.mo2257b("REMOVE").mo2251i(32).mo2257b(c2927b.f10141a).mo2251i(10);
        this.f10127e.remove(c2927b.f10141a);
        if (m2950a()) {
            this.f10135n.execute(this.f10136o);
        }
        return true;
    }

    /* renamed from: b */
    public synchronized boolean m2947b() {
        return this.f10130h;
    }

    /* renamed from: d */
    private synchronized void m2945d() {
        if (m2947b()) {
            throw new IllegalStateException("cache is closed");
        }
    }

    @Override // java.io.Flushable
    public synchronized void flush() throws IOException {
        if (this.f10129g) {
            m2945d();
            m2946c();
            this.f10126d.flush();
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() throws IOException {
        C2927b[] c2927bArr;
        if (this.f10129g && !this.f10130h) {
            for (C2927b c2927b : (C2927b[]) this.f10127e.values().toArray(new C2927b[this.f10127e.size()])) {
                if (c2927b.f10146f != null) {
                    c2927b.f10146f.m2943b();
                }
            }
            m2946c();
            this.f10126d.close();
            this.f10126d = null;
            this.f10130h = true;
            return;
        }
        this.f10130h = true;
    }

    /* renamed from: c */
    void m2946c() throws IOException {
        while (this.f10133l > this.f10132k) {
            m2948a(this.f10127e.values().iterator().next());
        }
        this.f10131i = false;
    }

    /* compiled from: DiskLruCache.java */
    /* renamed from: okhttp3.internal.a.d$a */
    /* loaded from: classes2.dex */
    public final class C2926a {

        /* renamed from: a */
        final C2927b f10137a;

        /* renamed from: b */
        final boolean[] f10138b;

        /* renamed from: c */
        final /* synthetic */ C2925d f10139c;

        /* renamed from: d */
        private boolean f10140d;

        /* renamed from: a */
        void m2944a() {
            if (this.f10137a.f10146f == this) {
                for (int i = 0; i < this.f10139c.f10125c; i++) {
                    try {
                        this.f10139c.f10124b.mo2799a(this.f10137a.f10144d[i]);
                    } catch (IOException unused) {
                    }
                }
                this.f10137a.f10146f = null;
            }
        }

        /* renamed from: b */
        public void m2943b() throws IOException {
            synchronized (this.f10139c) {
                if (this.f10140d) {
                    throw new IllegalStateException();
                }
                if (this.f10137a.f10146f == this) {
                    this.f10139c.m2949a(this, false);
                }
                this.f10140d = true;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: DiskLruCache.java */
    /* renamed from: okhttp3.internal.a.d$b */
    /* loaded from: classes2.dex */
    public final class C2927b {

        /* renamed from: a */
        final String f10141a;

        /* renamed from: b */
        final long[] f10142b;

        /* renamed from: c */
        final File[] f10143c;

        /* renamed from: d */
        final File[] f10144d;

        /* renamed from: e */
        boolean f10145e;

        /* renamed from: f */
        C2926a f10146f;

        /* renamed from: g */
        long f10147g;

        /* renamed from: a */
        void m2942a(BufferedSink bufferedSink) throws IOException {
            for (long j : this.f10142b) {
                bufferedSink.mo2251i(32).mo2249m(j);
            }
        }
    }
}
