package retrofit2;

import java.io.IOException;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;
import okhttp3.Call;
import okhttp3.InterfaceC2919f;
import okhttp3.MediaType;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okio.Buffer;
import okio.BufferedSource;
import okio.ForwardingSource;
import okio.Okio;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: retrofit2.h */
/* loaded from: classes2.dex */
public final class OkHttpCall<T> implements InterfaceC3169b<T> {

    /* renamed from: a */
    private final ServiceMethod<T, ?> f12625a;
    @Nullable

    /* renamed from: b */
    private final Object[] f12626b;

    /* renamed from: c */
    private volatile boolean f12627c;
    @GuardedBy
    @Nullable

    /* renamed from: d */
    private Call f12628d;
    @GuardedBy
    @Nullable

    /* renamed from: e */
    private Throwable f12629e;
    @GuardedBy

    /* renamed from: f */
    private boolean f12630f;

    /* JADX INFO: Access modifiers changed from: package-private */
    public OkHttpCall(ServiceMethod<T, ?> serviceMethod, @Nullable Object[] objArr) {
        this.f12625a = serviceMethod;
        this.f12626b = objArr;
    }

    @Override // retrofit2.InterfaceC3169b
    /* renamed from: e */
    public OkHttpCall<T> mo137d() {
        return new OkHttpCall<>(this.f12625a, this.f12626b);
    }

    @Override // retrofit2.InterfaceC3169b
    /* renamed from: a */
    public void mo140a(final InterfaceC3171d<T> interfaceC3171d) {
        Call call;
        Throwable th;
        C3208o.m25a(interfaceC3171d, "callback == null");
        synchronized (this) {
            if (this.f12630f) {
                throw new IllegalStateException("Already executed.");
            }
            this.f12630f = true;
            call = this.f12628d;
            th = this.f12629e;
            if (call == null && th == null) {
                Call m135f = m135f();
                this.f12628d = m135f;
                call = m135f;
            }
        }
        if (th != null) {
            interfaceC3171d.mo144a(this, th);
            return;
        }
        if (this.f12627c) {
            call.mo2360b();
        }
        call.mo2363a(new InterfaceC2919f() { // from class: retrofit2.h.1
            @Override // okhttp3.InterfaceC2919f
            /* renamed from: a */
            public void mo132a(Call call2, Response response) {
                try {
                    try {
                        interfaceC3171d.mo143a(OkHttpCall.this, OkHttpCall.this.m141a(response));
                    } catch (Throwable th2) {
                        th2.printStackTrace();
                    }
                } catch (Throwable th3) {
                    m134a(th3);
                }
            }

            @Override // okhttp3.InterfaceC2919f
            /* renamed from: a */
            public void mo133a(Call call2, IOException iOException) {
                m134a(iOException);
            }

            /* renamed from: a */
            private void m134a(Throwable th2) {
                try {
                    interfaceC3171d.mo144a(OkHttpCall.this, th2);
                } catch (Throwable th3) {
                    th3.printStackTrace();
                }
            }
        });
    }

    @Override // retrofit2.InterfaceC3169b
    /* renamed from: a */
    public C3204l<T> mo142a() throws IOException {
        Call call;
        synchronized (this) {
            if (this.f12630f) {
                throw new IllegalStateException("Already executed.");
            }
            this.f12630f = true;
            if (this.f12629e != null) {
                if (this.f12629e instanceof IOException) {
                    throw ((IOException) this.f12629e);
                }
                if (this.f12629e instanceof RuntimeException) {
                    throw ((RuntimeException) this.f12629e);
                }
                throw ((Error) this.f12629e);
            }
            call = this.f12628d;
            if (call == null) {
                try {
                    call = m135f();
                    this.f12628d = call;
                } catch (IOException | Error | RuntimeException e) {
                    C3208o.m24a(e);
                    this.f12629e = e;
                    throw e;
                }
            }
        }
        if (this.f12627c) {
            call.mo2360b();
        }
        return m141a(call.mo2364a());
    }

    /* renamed from: f */
    private Call m135f() throws IOException {
        Call m41a = this.f12625a.m41a(this.f12626b);
        if (m41a != null) {
            return m41a;
        }
        throw new NullPointerException("Call.Factory returned null.");
    }

    /* renamed from: a */
    C3204l<T> m141a(Response response) throws IOException {
        ResponseBody m3026g = response.m3026g();
        Response m3020a = response.m3025h().m3012a(new C3182b(m3026g.mo129a(), m3026g.mo128b())).m3020a();
        int m3031b = m3020a.m3031b();
        if (m3031b < 200 || m3031b >= 300) {
            try {
                return C3204l.m71a(C3208o.m17a(m3026g), m3020a);
            } finally {
                m3026g.close();
            }
        } else if (m3031b == 204 || m3031b == 205) {
            m3026g.close();
            return C3204l.m72a((Object) null, m3020a);
        } else {
            C3180a c3180a = new C3180a(m3026g);
            try {
                return C3204l.m72a(this.f12625a.m43a(c3180a), m3020a);
            } catch (RuntimeException e) {
                c3180a.m131g();
                throw e;
            }
        }
    }

    @Override // retrofit2.InterfaceC3169b
    /* renamed from: b */
    public void mo139b() {
        Call call;
        this.f12627c = true;
        synchronized (this) {
            call = this.f12628d;
        }
        if (call != null) {
            call.mo2360b();
        }
    }

    @Override // retrofit2.InterfaceC3169b
    /* renamed from: c */
    public boolean mo138c() {
        boolean z = true;
        if (this.f12627c) {
            return true;
        }
        synchronized (this) {
            if (this.f12628d == null || !this.f12628d.mo2359c()) {
                z = false;
            }
        }
        return z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: OkHttpCall.java */
    /* renamed from: retrofit2.h$b */
    /* loaded from: classes2.dex */
    public static final class C3182b extends ResponseBody {

        /* renamed from: a */
        private final MediaType f12636a;

        /* renamed from: b */
        private final long f12637b;

        C3182b(MediaType mediaType, long j) {
            this.f12636a = mediaType;
            this.f12637b = j;
        }

        @Override // okhttp3.ResponseBody
        /* renamed from: a */
        public MediaType mo129a() {
            return this.f12636a;
        }

        @Override // okhttp3.ResponseBody
        /* renamed from: b */
        public long mo128b() {
            return this.f12637b;
        }

        @Override // okhttp3.ResponseBody
        /* renamed from: d */
        public BufferedSource mo127d() {
            throw new IllegalStateException("Cannot read raw response body of a converted body.");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: OkHttpCall.java */
    /* renamed from: retrofit2.h$a */
    /* loaded from: classes2.dex */
    public static final class C3180a extends ResponseBody {

        /* renamed from: a */
        IOException f12633a;

        /* renamed from: b */
        private final ResponseBody f12634b;

        C3180a(ResponseBody responseBody) {
            this.f12634b = responseBody;
        }

        @Override // okhttp3.ResponseBody
        /* renamed from: a */
        public MediaType mo129a() {
            return this.f12634b.mo129a();
        }

        @Override // okhttp3.ResponseBody
        /* renamed from: b */
        public long mo128b() {
            return this.f12634b.mo128b();
        }

        @Override // okhttp3.ResponseBody
        /* renamed from: d */
        public BufferedSource mo127d() {
            return Okio.m2263a(new ForwardingSource(this.f12634b.mo127d()) { // from class: retrofit2.h.a.1
                @Override // okio.ForwardingSource, okio.Source
                /* renamed from: a */
                public long mo130a(Buffer buffer, long j) throws IOException {
                    try {
                        return super.mo130a(buffer, j);
                    } catch (IOException e) {
                        C3180a.this.f12633a = e;
                        throw e;
                    }
                }
            });
        }

        @Override // okhttp3.ResponseBody, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            this.f12634b.close();
        }

        /* renamed from: g */
        void m131g() throws IOException {
            IOException iOException = this.f12633a;
            if (iOException != null) {
                throw iOException;
            }
        }
    }
}
