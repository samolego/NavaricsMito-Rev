package com.bumptech.glide.load.engine;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.annotation.NonNull;
import android.support.annotation.VisibleForTesting;
import android.support.p008v4.util.Pools;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.engine.DecodeJob;
import com.bumptech.glide.load.engine.p024c.GlideExecutor;
import com.bumptech.glide.request.ResourceCallback;
import com.bumptech.glide.util.C0791i;
import com.bumptech.glide.util.p033a.FactoryPools;
import com.bumptech.glide.util.p033a.StateVerifier;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.bumptech.glide.load.engine.j */
/* loaded from: classes.dex */
class EngineJob<R> implements DecodeJob.InterfaceC0680a<R>, FactoryPools.InterfaceC0787c {

    /* renamed from: a */
    private static final C0732a f924a = new C0732a();

    /* renamed from: b */
    private static final Handler f925b = new Handler(Looper.getMainLooper(), new C0733b());

    /* renamed from: c */
    private final List<ResourceCallback> f926c;

    /* renamed from: d */
    private final StateVerifier f927d;

    /* renamed from: e */
    private final Pools.Pool<EngineJob<?>> f928e;

    /* renamed from: f */
    private final C0732a f929f;

    /* renamed from: g */
    private final EngineJobListener f930g;

    /* renamed from: h */
    private final GlideExecutor f931h;

    /* renamed from: i */
    private final GlideExecutor f932i;

    /* renamed from: j */
    private final GlideExecutor f933j;

    /* renamed from: k */
    private final GlideExecutor f934k;

    /* renamed from: l */
    private Key f935l;

    /* renamed from: m */
    private boolean f936m;

    /* renamed from: n */
    private boolean f937n;

    /* renamed from: o */
    private boolean f938o;

    /* renamed from: p */
    private boolean f939p;

    /* renamed from: q */
    private Resource<?> f940q;

    /* renamed from: r */
    private DataSource f941r;

    /* renamed from: s */
    private boolean f942s;

    /* renamed from: t */
    private GlideException f943t;

    /* renamed from: u */
    private boolean f944u;

    /* renamed from: v */
    private List<ResourceCallback> f945v;

    /* renamed from: w */
    private EngineResource<?> f946w;

    /* renamed from: x */
    private DecodeJob<R> f947x;

    /* renamed from: y */
    private volatile boolean f948y;

    /* JADX INFO: Access modifiers changed from: package-private */
    public EngineJob(GlideExecutor glideExecutor, GlideExecutor glideExecutor2, GlideExecutor glideExecutor3, GlideExecutor glideExecutor4, EngineJobListener engineJobListener, Pools.Pool<EngineJob<?>> pool) {
        this(glideExecutor, glideExecutor2, glideExecutor3, glideExecutor4, engineJobListener, pool, f924a);
    }

    @VisibleForTesting
    EngineJob(GlideExecutor glideExecutor, GlideExecutor glideExecutor2, GlideExecutor glideExecutor3, GlideExecutor glideExecutor4, EngineJobListener engineJobListener, Pools.Pool<EngineJob<?>> pool, C0732a c0732a) {
        this.f926c = new ArrayList(2);
        this.f927d = StateVerifier.m11604a();
        this.f931h = glideExecutor;
        this.f932i = glideExecutor2;
        this.f933j = glideExecutor3;
        this.f934k = glideExecutor4;
        this.f930g = engineJobListener;
        this.f928e = pool;
        this.f929f = c0732a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @VisibleForTesting
    /* renamed from: a */
    public EngineJob<R> m12062a(Key key, boolean z, boolean z2, boolean z3, boolean z4) {
        this.f935l = key;
        this.f936m = z;
        this.f937n = z2;
        this.f938o = z3;
        this.f939p = z4;
        return this;
    }

    /* renamed from: b */
    public void m12055b(DecodeJob<R> decodeJob) {
        GlideExecutor m12048g;
        this.f947x = decodeJob;
        if (decodeJob.m12275a()) {
            m12048g = this.f931h;
        } else {
            m12048g = m12048g();
        }
        m12048g.execute(decodeJob);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public void m12058a(ResourceCallback resourceCallback) {
        C0791i.m11575a();
        this.f927d.mo11602b();
        if (this.f942s) {
            resourceCallback.mo11647a(this.f946w, this.f941r);
        } else if (this.f944u) {
            resourceCallback.mo11648a(this.f943t);
        } else {
            this.f926c.add(resourceCallback);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: b */
    public void m12054b(ResourceCallback resourceCallback) {
        C0791i.m11575a();
        this.f927d.mo11602b();
        if (this.f942s || this.f944u) {
            m12052c(resourceCallback);
            return;
        }
        this.f926c.remove(resourceCallback);
        if (this.f926c.isEmpty()) {
            m12056b();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public boolean m12063a() {
        return this.f939p;
    }

    /* renamed from: g */
    private GlideExecutor m12048g() {
        if (this.f937n) {
            return this.f933j;
        }
        return this.f938o ? this.f934k : this.f932i;
    }

    /* renamed from: c */
    private void m12052c(ResourceCallback resourceCallback) {
        if (this.f945v == null) {
            this.f945v = new ArrayList(2);
        }
        if (this.f945v.contains(resourceCallback)) {
            return;
        }
        this.f945v.add(resourceCallback);
    }

    /* renamed from: d */
    private boolean m12051d(ResourceCallback resourceCallback) {
        List<ResourceCallback> list = this.f945v;
        return list != null && list.contains(resourceCallback);
    }

    /* renamed from: b */
    void m12056b() {
        if (this.f944u || this.f942s || this.f948y) {
            return;
        }
        this.f948y = true;
        this.f947x.m12262b();
        this.f930g.mo12046a(this, this.f935l);
    }

    /* renamed from: c */
    void m12053c() {
        this.f927d.mo11602b();
        if (this.f948y) {
            this.f940q.mo11851f();
            m12057a(false);
        } else if (this.f926c.isEmpty()) {
            throw new IllegalStateException("Received a resource without any callbacks to notify");
        } else {
            if (this.f942s) {
                throw new IllegalStateException("Already have resource");
            }
            this.f946w = this.f929f.m12047a(this.f940q, this.f936m);
            this.f942s = true;
            this.f946w.m12040g();
            this.f930g.mo12045a(this, this.f935l, this.f946w);
            int size = this.f926c.size();
            for (int i = 0; i < size; i++) {
                ResourceCallback resourceCallback = this.f926c.get(i);
                if (!m12051d(resourceCallback)) {
                    this.f946w.m12040g();
                    resourceCallback.mo11647a(this.f946w, this.f941r);
                }
            }
            this.f946w.m12039h();
            m12057a(false);
        }
    }

    /* renamed from: e */
    void m12050e() {
        this.f927d.mo11602b();
        if (!this.f948y) {
            throw new IllegalStateException("Not cancelled");
        }
        this.f930g.mo12046a(this, this.f935l);
        m12057a(false);
    }

    /* renamed from: a */
    private void m12057a(boolean z) {
        C0791i.m11575a();
        this.f926c.clear();
        this.f935l = null;
        this.f946w = null;
        this.f940q = null;
        List<ResourceCallback> list = this.f945v;
        if (list != null) {
            list.clear();
        }
        this.f944u = false;
        this.f948y = false;
        this.f942s = false;
        this.f947x.m12263a(z);
        this.f947x = null;
        this.f943t = null;
        this.f941r = null;
        this.f928e.release(this);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bumptech.glide.load.engine.DecodeJob.InterfaceC0680a
    /* renamed from: a */
    public void mo12059a(Resource<R> resource, DataSource dataSource) {
        this.f940q = resource;
        this.f941r = dataSource;
        f925b.obtainMessage(1, this).sendToTarget();
    }

    @Override // com.bumptech.glide.load.engine.DecodeJob.InterfaceC0680a
    /* renamed from: a */
    public void mo12060a(GlideException glideException) {
        this.f943t = glideException;
        f925b.obtainMessage(2, this).sendToTarget();
    }

    @Override // com.bumptech.glide.load.engine.DecodeJob.InterfaceC0680a
    /* renamed from: a */
    public void mo12061a(DecodeJob<?> decodeJob) {
        m12048g().execute(decodeJob);
    }

    /* renamed from: f */
    void m12049f() {
        this.f927d.mo11602b();
        if (this.f948y) {
            m12057a(false);
        } else if (this.f926c.isEmpty()) {
            throw new IllegalStateException("Received an exception without any callbacks to notify");
        } else {
            if (this.f944u) {
                throw new IllegalStateException("Already failed once");
            }
            this.f944u = true;
            this.f930g.mo12045a(this, this.f935l, null);
            for (ResourceCallback resourceCallback : this.f926c) {
                if (!m12051d(resourceCallback)) {
                    resourceCallback.mo11648a(this.f943t);
                }
            }
            m12057a(false);
        }
    }

    @Override // com.bumptech.glide.util.p033a.FactoryPools.InterfaceC0787c
    @NonNull
    /* renamed from: a_ */
    public StateVerifier mo11610a_() {
        return this.f927d;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: EngineJob.java */
    @VisibleForTesting
    /* renamed from: com.bumptech.glide.load.engine.j$a */
    /* loaded from: classes.dex */
    public static class C0732a {
        C0732a() {
        }

        /* renamed from: a */
        public <R> EngineResource<R> m12047a(Resource<R> resource, boolean z) {
            return new EngineResource<>(resource, z, true);
        }
    }

    /* compiled from: EngineJob.java */
    /* renamed from: com.bumptech.glide.load.engine.j$b */
    /* loaded from: classes.dex */
    private static class C0733b implements Handler.Callback {
        C0733b() {
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            EngineJob engineJob = (EngineJob) message.obj;
            switch (message.what) {
                case 1:
                    engineJob.m12053c();
                    return true;
                case 2:
                    engineJob.m12049f();
                    return true;
                case 3:
                    engineJob.m12050e();
                    return true;
                default:
                    throw new IllegalStateException("Unrecognized message: " + message.what);
            }
        }
    }
}
