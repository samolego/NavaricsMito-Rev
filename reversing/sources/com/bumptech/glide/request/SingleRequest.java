package com.bumptech.glide.request;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.annotation.DrawableRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.p008v4.util.Pools;
import android.util.Log;
import com.bumptech.glide.GlideContext;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.Engine;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.resource.p027b.DrawableDecoderCompat;
import com.bumptech.glide.request.p031a.SizeReadyCallback;
import com.bumptech.glide.request.p031a.Target;
import com.bumptech.glide.request.p032b.TransitionFactory;
import com.bumptech.glide.util.C0791i;
import com.bumptech.glide.util.LogTime;
import com.bumptech.glide.util.p033a.FactoryPools;
import com.bumptech.glide.util.p033a.StateVerifier;
import com.senseplay.sdk.config.CacheConfig;

/* loaded from: classes.dex */
public final class SingleRequest<R> implements SizeReadyCallback, Request, ResourceCallback, FactoryPools.InterfaceC0787c {

    /* renamed from: a */
    private static final Pools.Pool<SingleRequest<?>> f1186a = FactoryPools.m11618a((int) CacheConfig.Post_Delayed, new FactoryPools.InterfaceC0785a<SingleRequest<?>>() { // from class: com.bumptech.glide.request.SingleRequest.1
        @Override // com.bumptech.glide.util.p033a.FactoryPools.InterfaceC0785a
        /* renamed from: a */
        public SingleRequest<?> mo11611b() {
            return new SingleRequest<>();
        }
    });

    /* renamed from: c */
    private static final boolean f1187c = Log.isLoggable("Request", 2);

    /* renamed from: A */
    private int f1188A;

    /* renamed from: B */
    private int f1189B;

    /* renamed from: b */
    private boolean f1190b;
    @Nullable

    /* renamed from: d */
    private final String f1191d;

    /* renamed from: e */
    private final StateVerifier f1192e;
    @Nullable

    /* renamed from: f */
    private RequestListener<R> f1193f;

    /* renamed from: g */
    private RequestCoordinator f1194g;

    /* renamed from: h */
    private Context f1195h;

    /* renamed from: i */
    private GlideContext f1196i;
    @Nullable

    /* renamed from: j */
    private Object f1197j;

    /* renamed from: k */
    private Class<R> f1198k;

    /* renamed from: l */
    private RequestOptions f1199l;

    /* renamed from: m */
    private int f1200m;

    /* renamed from: n */
    private int f1201n;

    /* renamed from: o */
    private Priority f1202o;

    /* renamed from: p */
    private Target<R> f1203p;

    /* renamed from: q */
    private RequestListener<R> f1204q;

    /* renamed from: r */
    private Engine f1205r;

    /* renamed from: s */
    private TransitionFactory<? super R> f1206s;

    /* renamed from: t */
    private Resource<R> f1207t;

    /* renamed from: u */
    private Engine.C0731d f1208u;

    /* renamed from: v */
    private long f1209v;

    /* renamed from: w */
    private Status f1210w;

    /* renamed from: x */
    private Drawable f1211x;

    /* renamed from: y */
    private Drawable f1212y;

    /* renamed from: z */
    private Drawable f1213z;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public enum Status {
        PENDING,
        RUNNING,
        WAITING_FOR_SIZE,
        COMPLETE,
        FAILED,
        CANCELLED,
        CLEARED,
        PAUSED
    }

    /* renamed from: a */
    public static <R> SingleRequest<R> m11755a(Context context, GlideContext glideContext, Object obj, Class<R> cls, RequestOptions requestOptions, int i, int i2, Priority priority, Target<R> target, RequestListener<R> requestListener, RequestListener<R> requestListener2, RequestCoordinator requestCoordinator, Engine engine, TransitionFactory<? super R> transitionFactory) {
        SingleRequest<?> acquire = f1186a.acquire();
        if (acquire == null) {
            acquire = new SingleRequest();
        }
        acquire.m11750b(context, glideContext, obj, cls, requestOptions, i, i2, priority, target, requestListener, requestListener2, requestCoordinator, engine, transitionFactory);
        return acquire;
    }

    SingleRequest() {
        this.f1191d = f1187c ? String.valueOf(super.hashCode()) : null;
        this.f1192e = StateVerifier.m11604a();
    }

    /* renamed from: b */
    private void m11750b(Context context, GlideContext glideContext, Object obj, Class<R> cls, RequestOptions requestOptions, int i, int i2, Priority priority, Target<R> target, RequestListener<R> requestListener, RequestListener<R> requestListener2, RequestCoordinator requestCoordinator, Engine engine, TransitionFactory<? super R> transitionFactory) {
        this.f1195h = context;
        this.f1196i = glideContext;
        this.f1197j = obj;
        this.f1198k = cls;
        this.f1199l = requestOptions;
        this.f1200m = i;
        this.f1201n = i2;
        this.f1202o = priority;
        this.f1203p = target;
        this.f1193f = requestListener;
        this.f1204q = requestListener2;
        this.f1194g = requestCoordinator;
        this.f1205r = engine;
        this.f1206s = transitionFactory;
        this.f1210w = Status.PENDING;
    }

    @Override // com.bumptech.glide.util.p033a.FactoryPools.InterfaceC0787c
    @NonNull
    /* renamed from: a_ */
    public StateVerifier mo11610a_() {
        return this.f1192e;
    }

    @Override // com.bumptech.glide.request.Request
    /* renamed from: i */
    public void mo11631i() {
        m11748k();
        this.f1195h = null;
        this.f1196i = null;
        this.f1197j = null;
        this.f1198k = null;
        this.f1199l = null;
        this.f1200m = -1;
        this.f1201n = -1;
        this.f1203p = null;
        this.f1204q = null;
        this.f1193f = null;
        this.f1194g = null;
        this.f1206s = null;
        this.f1208u = null;
        this.f1211x = null;
        this.f1212y = null;
        this.f1213z = null;
        this.f1188A = -1;
        this.f1189B = -1;
        f1186a.release(this);
    }

    @Override // com.bumptech.glide.request.Request
    /* renamed from: a */
    public void mo11646a() {
        m11748k();
        this.f1192e.mo11602b();
        this.f1209v = LogTime.m11595a();
        if (this.f1197j == null) {
            if (C0791i.m11571a(this.f1200m, this.f1201n)) {
                this.f1188A = this.f1200m;
                this.f1189B = this.f1201n;
            }
            m11754a(new GlideException("Received null model"), m11745n() == null ? 5 : 3);
        } else if (this.f1210w == Status.RUNNING) {
            throw new IllegalArgumentException("Cannot restart a running request");
        } else {
            if (this.f1210w == Status.COMPLETE) {
                mo11647a((Resource<?>) this.f1207t, DataSource.MEMORY_CACHE);
                return;
            }
            this.f1210w = Status.WAITING_FOR_SIZE;
            if (C0791i.m11571a(this.f1200m, this.f1201n)) {
                mo11723a(this.f1200m, this.f1201n);
            } else {
                this.f1203p.mo11702a((SizeReadyCallback) this);
            }
            if ((this.f1210w == Status.RUNNING || this.f1210w == Status.WAITING_FOR_SIZE) && m11741r()) {
                this.f1203p.mo11697b(m11746m());
            }
            if (f1187c) {
                m11751a("finished run method in " + LogTime.m11594a(this.f1209v));
            }
        }
    }

    /* renamed from: j */
    void m11749j() {
        m11748k();
        this.f1192e.mo11602b();
        this.f1203p.mo11696b(this);
        this.f1210w = Status.CANCELLED;
        Engine.C0731d c0731d = this.f1208u;
        if (c0731d != null) {
            c0731d.m12064a();
            this.f1208u = null;
        }
    }

    /* renamed from: k */
    private void m11748k() {
        if (this.f1190b) {
            throw new IllegalStateException("You can't start or clear loads in RequestListener or Target callbacks. If you're trying to start a fallback request when a load fails, use RequestBuilder#error(RequestBuilder). Otherwise consider posting your into() or clear() calls to the main thread using a Handler instead.");
        }
    }

    @Override // com.bumptech.glide.request.Request
    /* renamed from: c */
    public void mo11641c() {
        C0791i.m11575a();
        m11748k();
        this.f1192e.mo11602b();
        if (this.f1210w == Status.CLEARED) {
            return;
        }
        m11749j();
        Resource<R> resource = this.f1207t;
        if (resource != null) {
            m11753a((Resource<?>) resource);
        }
        if (m11742q()) {
            this.f1203p.mo11703a(m11746m());
        }
        this.f1210w = Status.CLEARED;
    }

    @Override // com.bumptech.glide.request.Request
    /* renamed from: b */
    public void mo11643b() {
        mo11641c();
        this.f1210w = Status.PAUSED;
    }

    /* renamed from: a */
    private void m11753a(Resource<?> resource) {
        this.f1205r.m12073a(resource);
        this.f1207t = null;
    }

    @Override // com.bumptech.glide.request.Request
    /* renamed from: d */
    public boolean mo11639d() {
        return this.f1210w == Status.RUNNING || this.f1210w == Status.WAITING_FOR_SIZE;
    }

    @Override // com.bumptech.glide.request.Request
    /* renamed from: e */
    public boolean mo11637e() {
        return this.f1210w == Status.COMPLETE;
    }

    @Override // com.bumptech.glide.request.Request
    /* renamed from: f */
    public boolean mo11635f() {
        return mo11637e();
    }

    @Override // com.bumptech.glide.request.Request
    /* renamed from: g */
    public boolean mo11633g() {
        return this.f1210w == Status.CANCELLED || this.f1210w == Status.CLEARED;
    }

    @Override // com.bumptech.glide.request.Request
    /* renamed from: h */
    public boolean mo11632h() {
        return this.f1210w == Status.FAILED;
    }

    /* renamed from: l */
    private Drawable m11747l() {
        if (this.f1211x == null) {
            this.f1211x = this.f1199l.m11658q();
            if (this.f1211x == null && this.f1199l.m11657r() > 0) {
                this.f1211x = m11757a(this.f1199l.m11657r());
            }
        }
        return this.f1211x;
    }

    /* renamed from: m */
    private Drawable m11746m() {
        if (this.f1212y == null) {
            this.f1212y = this.f1199l.m11655t();
            if (this.f1212y == null && this.f1199l.m11656s() > 0) {
                this.f1212y = m11757a(this.f1199l.m11656s());
            }
        }
        return this.f1212y;
    }

    /* renamed from: n */
    private Drawable m11745n() {
        if (this.f1213z == null) {
            this.f1213z = this.f1199l.m11653v();
            if (this.f1213z == null && this.f1199l.m11654u() > 0) {
                this.f1213z = m11757a(this.f1199l.m11654u());
            }
        }
        return this.f1213z;
    }

    /* renamed from: a */
    private Drawable m11757a(@DrawableRes int i) {
        return DrawableDecoderCompat.m12002a(this.f1196i, i, this.f1199l.m11652w() != null ? this.f1199l.m11652w() : this.f1195h.getTheme());
    }

    /* renamed from: o */
    private void m11744o() {
        if (m11741r()) {
            Drawable m11745n = this.f1197j == null ? m11745n() : null;
            if (m11745n == null) {
                m11745n = m11747l();
            }
            if (m11745n == null) {
                m11745n = m11746m();
            }
            this.f1203p.mo11694c(m11745n);
        }
    }

    @Override // com.bumptech.glide.request.p031a.SizeReadyCallback
    /* renamed from: a */
    public void mo11723a(int i, int i2) {
        this.f1192e.mo11602b();
        if (f1187c) {
            m11751a("Got onSizeReady in " + LogTime.m11594a(this.f1209v));
        }
        if (this.f1210w != Status.WAITING_FOR_SIZE) {
            return;
        }
        this.f1210w = Status.RUNNING;
        float m11685E = this.f1199l.m11685E();
        this.f1188A = m11756a(i, m11685E);
        this.f1189B = m11756a(i2, m11685E);
        if (f1187c) {
            m11751a("finished setup for calling load in " + LogTime.m11594a(this.f1209v));
        }
        this.f1208u = this.f1205r.m12076a(this.f1196i, this.f1197j, this.f1199l.m11650y(), this.f1188A, this.f1189B, this.f1199l.m11660o(), this.f1198k, this.f1202o, this.f1199l.m11659p(), this.f1199l.m11663l(), this.f1199l.m11662m(), this.f1199l.m11684F(), this.f1199l.m11661n(), this.f1199l.m11651x(), this.f1199l.m11683G(), this.f1199l.m11682H(), this.f1199l.m11681I(), this);
        if (this.f1210w != Status.RUNNING) {
            this.f1208u = null;
        }
        if (f1187c) {
            m11751a("finished onSizeReady in " + LogTime.m11594a(this.f1209v));
        }
    }

    /* renamed from: a */
    private static int m11756a(int i, float f) {
        return i == Integer.MIN_VALUE ? i : Math.round(f * i);
    }

    /* renamed from: p */
    private boolean m11743p() {
        RequestCoordinator requestCoordinator = this.f1194g;
        return requestCoordinator == null || requestCoordinator.mo11642b(this);
    }

    /* renamed from: q */
    private boolean m11742q() {
        RequestCoordinator requestCoordinator = this.f1194g;
        return requestCoordinator == null || requestCoordinator.mo11638d(this);
    }

    /* renamed from: r */
    private boolean m11741r() {
        RequestCoordinator requestCoordinator = this.f1194g;
        return requestCoordinator == null || requestCoordinator.mo11640c(this);
    }

    /* renamed from: s */
    private boolean m11740s() {
        RequestCoordinator requestCoordinator = this.f1194g;
        return requestCoordinator == null || !requestCoordinator.mo11630j();
    }

    /* renamed from: t */
    private void m11739t() {
        RequestCoordinator requestCoordinator = this.f1194g;
        if (requestCoordinator != null) {
            requestCoordinator.mo11636e(this);
        }
    }

    /* renamed from: u */
    private void m11738u() {
        RequestCoordinator requestCoordinator = this.f1194g;
        if (requestCoordinator != null) {
            requestCoordinator.mo11634f(this);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bumptech.glide.request.ResourceCallback
    /* renamed from: a */
    public void mo11647a(Resource<?> resource, DataSource dataSource) {
        this.f1192e.mo11602b();
        this.f1208u = null;
        if (resource == null) {
            mo11648a(new GlideException("Expected to receive a Resource<R> with an object of " + this.f1198k + " inside, but instead got null."));
            return;
        }
        Object mo11898d = resource.mo11898d();
        if (mo11898d == null || !this.f1198k.isAssignableFrom(mo11898d.getClass())) {
            m11753a(resource);
            StringBuilder sb = new StringBuilder();
            sb.append("Expected to receive an object of ");
            sb.append(this.f1198k);
            sb.append(" but instead got ");
            sb.append(mo11898d != null ? mo11898d.getClass() : "");
            sb.append("{");
            sb.append(mo11898d);
            sb.append("} inside Resource{");
            sb.append(resource);
            sb.append("}.");
            sb.append(mo11898d != null ? "" : " To indicate failure return a null Resource object, rather than a Resource object containing null data.");
            mo11648a(new GlideException(sb.toString()));
        } else if (!m11743p()) {
            m11753a(resource);
            this.f1210w = Status.COMPLETE;
        } else {
            m11752a(resource, mo11898d, dataSource);
        }
    }

    /* renamed from: a */
    private void m11752a(Resource<R> resource, R r, DataSource dataSource) {
        boolean m11740s = m11740s();
        this.f1210w = Status.COMPLETE;
        this.f1207t = resource;
        if (this.f1196i.m12495e() <= 3) {
            Log.d("Glide", "Finished loading " + r.getClass().getSimpleName() + " from " + dataSource + " for " + this.f1197j + " with size [" + this.f1188A + "x" + this.f1189B + "] in " + LogTime.m11594a(this.f1209v) + " ms");
        }
        this.f1190b = true;
        try {
            if ((this.f1204q == null || !this.f1204q.mo8723a(r, this.f1197j, this.f1203p, dataSource, m11740s)) && (this.f1193f == null || !this.f1193f.mo8723a(r, this.f1197j, this.f1203p, dataSource, m11740s))) {
                this.f1203p.mo11699a(r, this.f1206s.mo11705a(dataSource, m11740s));
            }
            this.f1190b = false;
            m11739t();
        } catch (Throwable th) {
            this.f1190b = false;
            throw th;
        }
    }

    @Override // com.bumptech.glide.request.ResourceCallback
    /* renamed from: a */
    public void mo11648a(GlideException glideException) {
        m11754a(glideException, 5);
    }

    /* renamed from: a */
    private void m11754a(GlideException glideException, int i) {
        this.f1192e.mo11602b();
        int m12495e = this.f1196i.m12495e();
        if (m12495e <= i) {
            Log.w("Glide", "Load failed for " + this.f1197j + " with size [" + this.f1188A + "x" + this.f1189B + "]", glideException);
            if (m12495e <= 4) {
                glideException.logRootCauses("Glide");
            }
        }
        this.f1208u = null;
        this.f1210w = Status.FAILED;
        this.f1190b = true;
        try {
            if ((this.f1204q == null || !this.f1204q.mo8724a(glideException, this.f1197j, this.f1203p, m11740s())) && (this.f1193f == null || !this.f1193f.mo8724a(glideException, this.f1197j, this.f1203p, m11740s()))) {
                m11744o();
            }
            this.f1190b = false;
            m11738u();
        } catch (Throwable th) {
            this.f1190b = false;
            throw th;
        }
    }

    @Override // com.bumptech.glide.request.Request
    /* renamed from: a */
    public boolean mo11645a(Request request) {
        if (request instanceof SingleRequest) {
            SingleRequest singleRequest = (SingleRequest) request;
            if (this.f1200m == singleRequest.f1200m && this.f1201n == singleRequest.f1201n && C0791i.m11558b(this.f1197j, singleRequest.f1197j) && this.f1198k.equals(singleRequest.f1198k) && this.f1199l.equals(singleRequest.f1199l) && this.f1202o == singleRequest.f1202o) {
                if (this.f1204q != null) {
                    if (singleRequest.f1204q == null) {
                        return false;
                    }
                } else if (singleRequest.f1204q != null) {
                    return false;
                }
                return true;
            }
            return false;
        }
        return false;
    }

    /* renamed from: a */
    private void m11751a(String str) {
        Log.v("Request", str + " this: " + this.f1191d);
    }
}
