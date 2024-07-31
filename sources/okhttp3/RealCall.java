package okhttp3;

import android.support.p008v4.app.NotificationCompat;
import java.io.IOException;
import java.util.ArrayList;
import okhttp3.internal.NamedRunnable;
import okhttp3.internal.connection.ConnectInterceptor;
import okhttp3.internal.p103a.CacheInterceptor;
import okhttp3.internal.p104b.BridgeInterceptor;
import okhttp3.internal.p104b.CallServerInterceptor;
import okhttp3.internal.p104b.RealInterceptorChain;
import okhttp3.internal.p104b.RetryAndFollowUpInterceptor;
import okhttp3.internal.p107e.Platform;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: okhttp3.y */
/* loaded from: classes2.dex */
public final class RealCall implements Call {

    /* renamed from: a */
    final OkHttpClient f10642a;

    /* renamed from: b */
    final RetryAndFollowUpInterceptor f10643b;

    /* renamed from: c */
    final C2993z f10644c;

    /* renamed from: d */
    final boolean f10645d;

    /* renamed from: e */
    private EventListener f10646e;

    /* renamed from: f */
    private boolean f10647f;

    private RealCall(OkHttpClient okHttpClient, C2993z c2993z, boolean z) {
        this.f10642a = okHttpClient;
        this.f10644c = c2993z;
        this.f10645d = z;
        this.f10643b = new RetryAndFollowUpInterceptor(okHttpClient, z);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public static RealCall m2362a(OkHttpClient okHttpClient, C2993z c2993z, boolean z) {
        RealCall realCall = new RealCall(okHttpClient, c2993z, z);
        realCall.f10646e = okHttpClient.m2383y().mo2514a(realCall);
        return realCall;
    }

    @Override // okhttp3.Call
    /* renamed from: a */
    public Response mo2364a() throws IOException {
        synchronized (this) {
            if (this.f10647f) {
                throw new IllegalStateException("Already Executed");
            }
            this.f10647f = true;
        }
        m2354h();
        this.f10646e.m2535a(this);
        try {
            try {
                this.f10642a.m2388t().m2542a(this);
                Response m2355g = m2355g();
                if (m2355g != null) {
                    return m2355g;
                }
                throw new IOException("Canceled");
            } catch (IOException e) {
                this.f10646e.m2533a(this, e);
                throw e;
            }
        } finally {
            this.f10642a.m2388t().m2539b(this);
        }
    }

    /* renamed from: h */
    private void m2354h() {
        this.f10643b.m2907a(Platform.m2762c().mo2775a("response.body().close()"));
    }

    @Override // okhttp3.Call
    /* renamed from: a */
    public void mo2363a(InterfaceC2919f interfaceC2919f) {
        synchronized (this) {
            if (this.f10647f) {
                throw new IllegalStateException("Already Executed");
            }
            this.f10647f = true;
        }
        m2354h();
        this.f10646e.m2535a(this);
        this.f10642a.m2388t().m2543a(new C2992a(interfaceC2919f));
    }

    @Override // okhttp3.Call
    /* renamed from: b */
    public void mo2360b() {
        this.f10643b.m2910a();
    }

    @Override // okhttp3.Call
    /* renamed from: c */
    public boolean mo2359c() {
        return this.f10643b.m2902b();
    }

    /* renamed from: d */
    public RealCall clone() {
        return m2362a(this.f10642a, this.f10644c, this.f10645d);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: RealCall.java */
    /* renamed from: okhttp3.y$a */
    /* loaded from: classes2.dex */
    public final class C2992a extends NamedRunnable {

        /* renamed from: c */
        private final InterfaceC2919f f10649c;

        C2992a(InterfaceC2919f interfaceC2919f) {
            super("OkHttp %s", RealCall.this.m2356f());
            this.f10649c = interfaceC2919f;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: a */
        public String m2353a() {
            return RealCall.this.f10644c.m2350a().m2464f();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: b */
        public RealCall m2352b() {
            return RealCall.this;
        }

        @Override // okhttp3.internal.NamedRunnable
        /* renamed from: c */
        protected void mo2351c() {
            IOException e;
            boolean z = true;
            try {
                try {
                    Response m2355g = RealCall.this.m2355g();
                    try {
                        if (RealCall.this.f10643b.m2902b()) {
                            this.f10649c.mo133a(RealCall.this, new IOException("Canceled"));
                        } else {
                            this.f10649c.mo132a(RealCall.this, m2355g);
                        }
                    } catch (IOException e2) {
                        e = e2;
                        if (!z) {
                            RealCall.this.f10646e.m2533a(RealCall.this, e);
                            this.f10649c.mo133a(RealCall.this, e);
                        } else {
                            Platform m2762c = Platform.m2762c();
                            m2762c.mo2776a(4, "Callback failure for " + RealCall.this.m2357e(), e);
                        }
                    }
                } finally {
                    RealCall.this.f10642a.m2388t().m2540b(this);
                }
            } catch (IOException e3) {
                e = e3;
                z = false;
            }
        }
    }

    /* renamed from: e */
    String m2357e() {
        StringBuilder sb = new StringBuilder();
        sb.append(mo2359c() ? "canceled " : "");
        sb.append(this.f10645d ? "web socket" : NotificationCompat.CATEGORY_CALL);
        sb.append(" to ");
        sb.append(m2356f());
        return sb.toString();
    }

    /* renamed from: f */
    String m2356f() {
        return this.f10644c.m2350a().m2454o();
    }

    /* renamed from: g */
    Response m2355g() throws IOException {
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(this.f10642a.m2385w());
        arrayList.add(this.f10643b);
        arrayList.add(new BridgeInterceptor(this.f10642a.m2401g()));
        arrayList.add(new CacheInterceptor(this.f10642a.m2400h()));
        arrayList.add(new ConnectInterceptor(this.f10642a));
        if (!this.f10645d) {
            arrayList.addAll(this.f10642a.m2384x());
        }
        arrayList.add(new CallServerInterceptor(this.f10645d));
        return new RealInterceptorChain(arrayList, null, null, null, 0, this.f10644c, this, this.f10646e, this.f10642a.m2409a(), this.f10642a.m2406b(), this.f10642a.m2405c()).mo2427a(this.f10644c);
    }
}
