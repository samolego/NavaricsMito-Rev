package com.bumptech.glide.load.engine;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.VisibleForTesting;
import android.support.p008v4.util.Pools;
import android.util.Log;
import com.bumptech.glide.GlideContext;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.load.engine.DecodeJob;
import com.bumptech.glide.load.engine.EngineResource;
import com.bumptech.glide.load.engine.p023b.DiskCache;
import com.bumptech.glide.load.engine.p023b.DiskCacheAdapter;
import com.bumptech.glide.load.engine.p023b.MemoryCache;
import com.bumptech.glide.load.engine.p024c.GlideExecutor;
import com.bumptech.glide.request.ResourceCallback;
import com.bumptech.glide.util.C0791i;
import com.bumptech.glide.util.LogTime;
import com.bumptech.glide.util.Preconditions;
import com.bumptech.glide.util.p033a.FactoryPools;
import com.senseplay.sdk.config.CacheConfig;
import java.util.Map;

/* renamed from: com.bumptech.glide.load.engine.i */
/* loaded from: classes.dex */
public class Engine implements MemoryCache.InterfaceC0706a, EngineJobListener, EngineResource.InterfaceC0734a {

    /* renamed from: a */
    private static final boolean f900a = Log.isLoggable("Engine", 2);

    /* renamed from: b */
    private final Jobs f901b;

    /* renamed from: c */
    private final EngineKeyFactory f902c;

    /* renamed from: d */
    private final MemoryCache f903d;

    /* renamed from: e */
    private final C0728b f904e;

    /* renamed from: f */
    private final ResourceRecycler f905f;

    /* renamed from: g */
    private final C0730c f906g;

    /* renamed from: h */
    private final C0726a f907h;

    /* renamed from: i */
    private final ActiveResources f908i;

    public Engine(MemoryCache memoryCache, DiskCache.InterfaceC0700a interfaceC0700a, GlideExecutor glideExecutor, GlideExecutor glideExecutor2, GlideExecutor glideExecutor3, GlideExecutor glideExecutor4, boolean z) {
        this(memoryCache, interfaceC0700a, glideExecutor, glideExecutor2, glideExecutor3, glideExecutor4, null, null, null, null, null, null, z);
    }

    @VisibleForTesting
    Engine(MemoryCache memoryCache, DiskCache.InterfaceC0700a interfaceC0700a, GlideExecutor glideExecutor, GlideExecutor glideExecutor2, GlideExecutor glideExecutor3, GlideExecutor glideExecutor4, Jobs jobs, EngineKeyFactory engineKeyFactory, ActiveResources activeResources, C0728b c0728b, C0726a c0726a, ResourceRecycler resourceRecycler, boolean z) {
        this.f903d = memoryCache;
        this.f906g = new C0730c(interfaceC0700a);
        ActiveResources activeResources2 = activeResources == null ? new ActiveResources(z) : activeResources;
        this.f908i = activeResources2;
        activeResources2.m12231a(this);
        this.f902c = engineKeyFactory == null ? new EngineKeyFactory() : engineKeyFactory;
        this.f901b = jobs == null ? new Jobs() : jobs;
        this.f904e = c0728b == null ? new C0728b(glideExecutor, glideExecutor2, glideExecutor3, glideExecutor4, this) : c0728b;
        this.f907h = c0726a == null ? new C0726a(this.f906g) : c0726a;
        this.f905f = resourceRecycler == null ? new ResourceRecycler() : resourceRecycler;
        memoryCache.mo12133a(this);
    }

    /* renamed from: a */
    public <R> C0731d m12076a(GlideContext glideContext, Object obj, Key key, int i, int i2, Class<?> cls, Class<R> cls2, Priority priority, DiskCacheStrategy diskCacheStrategy, Map<Class<?>, Transformation<?>> map, boolean z, boolean z2, Options options, boolean z3, boolean z4, boolean z5, boolean z6, ResourceCallback resourceCallback) {
        C0791i.m11575a();
        long m11595a = f900a ? LogTime.m11595a() : 0L;
        EngineKey m12044a = this.f902c.m12044a(obj, key, i, i2, map, cls, cls2, options);
        EngineResource<?> m12074a = m12074a(m12044a, z3);
        if (m12074a != null) {
            resourceCallback.mo11647a(m12074a, DataSource.MEMORY_CACHE);
            if (f900a) {
                m12072a("Loaded resource from active resources", m11595a, m12044a);
            }
            return null;
        }
        EngineResource<?> m12071b = m12071b(m12044a, z3);
        if (m12071b != null) {
            resourceCallback.mo11647a(m12071b, DataSource.MEMORY_CACHE);
            if (f900a) {
                m12072a("Loaded resource from cache", m11595a, m12044a);
            }
            return null;
        }
        EngineJob<?> m12036a = this.f901b.m12036a(m12044a, z6);
        if (m12036a != null) {
            m12036a.m12058a(resourceCallback);
            if (f900a) {
                m12072a("Added to existing load", m11595a, m12044a);
            }
            return new C0731d(resourceCallback, m12036a);
        }
        EngineJob<R> m12067a = this.f904e.m12067a(m12044a, z3, z4, z5, z6);
        DecodeJob<R> m12069a = this.f907h.m12069a(glideContext, obj, m12044a, key, i, i2, cls, cls2, priority, diskCacheStrategy, map, z, z2, z6, options, m12067a);
        this.f901b.m12037a((Key) m12044a, (EngineJob<?>) m12067a);
        m12067a.m12058a(resourceCallback);
        m12067a.m12055b(m12069a);
        if (f900a) {
            m12072a("Started new load", m11595a, m12044a);
        }
        return new C0731d(resourceCallback, m12067a);
    }

    /* renamed from: a */
    private static void m12072a(String str, long j, Key key) {
        Log.v("Engine", str + " in " + LogTime.m11594a(j) + "ms, key: " + key);
    }

    @Nullable
    /* renamed from: a */
    private EngineResource<?> m12074a(Key key, boolean z) {
        if (z) {
            EngineResource<?> m12229b = this.f908i.m12229b(key);
            if (m12229b != null) {
                m12229b.m12040g();
            }
            return m12229b;
        }
        return null;
    }

    /* renamed from: b */
    private EngineResource<?> m12071b(Key key, boolean z) {
        if (z) {
            EngineResource<?> m12075a = m12075a(key);
            if (m12075a != null) {
                m12075a.m12040g();
                this.f908i.m12233a(key, m12075a);
            }
            return m12075a;
        }
        return null;
    }

    /* renamed from: a */
    private EngineResource<?> m12075a(Key key) {
        Resource<?> mo12134a = this.f903d.mo12134a(key);
        if (mo12134a == null) {
            return null;
        }
        if (mo12134a instanceof EngineResource) {
            return (EngineResource) mo12134a;
        }
        return new EngineResource<>(mo12134a, true, true);
    }

    /* renamed from: a */
    public void m12073a(Resource<?> resource) {
        C0791i.m11575a();
        if (resource instanceof EngineResource) {
            ((EngineResource) resource).m12039h();
            return;
        }
        throw new IllegalArgumentException("Cannot release anything but an EngineResource");
    }

    @Override // com.bumptech.glide.load.engine.EngineJobListener
    /* renamed from: a */
    public void mo12045a(EngineJob<?> engineJob, Key key, EngineResource<?> engineResource) {
        C0791i.m11575a();
        if (engineResource != null) {
            engineResource.m12042a(key, this);
            if (engineResource.m12041b()) {
                this.f908i.m12233a(key, engineResource);
            }
        }
        this.f901b.m12034b(key, engineJob);
    }

    @Override // com.bumptech.glide.load.engine.EngineJobListener
    /* renamed from: a */
    public void mo12046a(EngineJob<?> engineJob, Key key) {
        C0791i.m11575a();
        this.f901b.m12034b(key, engineJob);
    }

    @Override // com.bumptech.glide.load.engine.p023b.MemoryCache.InterfaceC0706a
    /* renamed from: b */
    public void mo12070b(@NonNull Resource<?> resource) {
        C0791i.m11575a();
        this.f905f.m12024a(resource);
    }

    @Override // com.bumptech.glide.load.engine.EngineResource.InterfaceC0734a
    /* renamed from: a */
    public void mo12038a(Key key, EngineResource<?> engineResource) {
        C0791i.m11575a();
        this.f908i.m12234a(key);
        if (engineResource.m12041b()) {
            this.f903d.mo12132b(key, engineResource);
        } else {
            this.f905f.m12024a(engineResource);
        }
    }

    /* compiled from: Engine.java */
    /* renamed from: com.bumptech.glide.load.engine.i$d */
    /* loaded from: classes.dex */
    public static class C0731d {

        /* renamed from: a */
        private final EngineJob<?> f922a;

        /* renamed from: b */
        private final ResourceCallback f923b;

        C0731d(ResourceCallback resourceCallback, EngineJob<?> engineJob) {
            this.f923b = resourceCallback;
            this.f922a = engineJob;
        }

        /* renamed from: a */
        public void m12064a() {
            this.f922a.m12054b(this.f923b);
        }
    }

    /* compiled from: Engine.java */
    /* renamed from: com.bumptech.glide.load.engine.i$c */
    /* loaded from: classes.dex */
    private static class C0730c implements DecodeJob.InterfaceC0683d {

        /* renamed from: a */
        private final DiskCache.InterfaceC0700a f920a;

        /* renamed from: b */
        private volatile DiskCache f921b;

        C0730c(DiskCache.InterfaceC0700a interfaceC0700a) {
            this.f920a = interfaceC0700a;
        }

        @Override // com.bumptech.glide.load.engine.DecodeJob.InterfaceC0683d
        /* renamed from: a */
        public DiskCache mo12065a() {
            if (this.f921b == null) {
                synchronized (this) {
                    if (this.f921b == null) {
                        this.f921b = this.f920a.mo12144a();
                    }
                    if (this.f921b == null) {
                        this.f921b = new DiskCacheAdapter();
                    }
                }
            }
            return this.f921b;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Engine.java */
    @VisibleForTesting
    /* renamed from: com.bumptech.glide.load.engine.i$a */
    /* loaded from: classes.dex */
    public static class C0726a {

        /* renamed from: a */
        final DecodeJob.InterfaceC0683d f909a;

        /* renamed from: b */
        final Pools.Pool<DecodeJob<?>> f910b = FactoryPools.m11618a((int) CacheConfig.Post_Delayed, new FactoryPools.InterfaceC0785a<DecodeJob<?>>() { // from class: com.bumptech.glide.load.engine.i.a.1
            @Override // com.bumptech.glide.util.p033a.FactoryPools.InterfaceC0785a
            /* renamed from: a */
            public DecodeJob<?> mo11611b() {
                return new DecodeJob<>(C0726a.this.f909a, C0726a.this.f910b);
            }
        });

        /* renamed from: c */
        private int f911c;

        C0726a(DecodeJob.InterfaceC0683d interfaceC0683d) {
            this.f909a = interfaceC0683d;
        }

        /* renamed from: a */
        <R> DecodeJob<R> m12069a(GlideContext glideContext, Object obj, EngineKey engineKey, Key key, int i, int i2, Class<?> cls, Class<R> cls2, Priority priority, DiskCacheStrategy diskCacheStrategy, Map<Class<?>, Transformation<?>> map, boolean z, boolean z2, boolean z3, Options options, DecodeJob.InterfaceC0680a<R> interfaceC0680a) {
            DecodeJob decodeJob = (DecodeJob) Preconditions.m11580a(this.f910b.acquire());
            int i3 = this.f911c;
            this.f911c = i3 + 1;
            return decodeJob.m12274a(glideContext, obj, engineKey, key, i, i2, cls, cls2, priority, diskCacheStrategy, map, z, z2, z3, options, interfaceC0680a, i3);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Engine.java */
    @VisibleForTesting
    /* renamed from: com.bumptech.glide.load.engine.i$b */
    /* loaded from: classes.dex */
    public static class C0728b {

        /* renamed from: a */
        final GlideExecutor f913a;

        /* renamed from: b */
        final GlideExecutor f914b;

        /* renamed from: c */
        final GlideExecutor f915c;

        /* renamed from: d */
        final GlideExecutor f916d;

        /* renamed from: e */
        final EngineJobListener f917e;

        /* renamed from: f */
        final Pools.Pool<EngineJob<?>> f918f = FactoryPools.m11618a((int) CacheConfig.Post_Delayed, new FactoryPools.InterfaceC0785a<EngineJob<?>>() { // from class: com.bumptech.glide.load.engine.i.b.1
            @Override // com.bumptech.glide.util.p033a.FactoryPools.InterfaceC0785a
            /* renamed from: a */
            public EngineJob<?> mo11611b() {
                return new EngineJob<>(C0728b.this.f913a, C0728b.this.f914b, C0728b.this.f915c, C0728b.this.f916d, C0728b.this.f917e, C0728b.this.f918f);
            }
        });

        C0728b(GlideExecutor glideExecutor, GlideExecutor glideExecutor2, GlideExecutor glideExecutor3, GlideExecutor glideExecutor4, EngineJobListener engineJobListener) {
            this.f913a = glideExecutor;
            this.f914b = glideExecutor2;
            this.f915c = glideExecutor3;
            this.f916d = glideExecutor4;
            this.f917e = engineJobListener;
        }

        /* renamed from: a */
        <R> EngineJob<R> m12067a(Key key, boolean z, boolean z2, boolean z3, boolean z4) {
            return ((EngineJob) Preconditions.m11580a(this.f918f.acquire())).m12062a(key, z, z2, z3, z4);
        }
    }
}
