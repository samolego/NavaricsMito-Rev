package com.bumptech.glide.load.engine;

import android.support.annotation.NonNull;
import android.support.p008v4.util.Pools;
import com.bumptech.glide.util.Preconditions;
import com.bumptech.glide.util.p033a.FactoryPools;
import com.bumptech.glide.util.p033a.StateVerifier;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.bumptech.glide.load.engine.r */
/* loaded from: classes.dex */
public final class LockedResource<Z> implements Resource<Z>, FactoryPools.InterfaceC0787c {

    /* renamed from: a */
    private static final Pools.Pool<LockedResource<?>> f971a = FactoryPools.m11614b(20, new FactoryPools.InterfaceC0785a<LockedResource<?>>() { // from class: com.bumptech.glide.load.engine.r.1
        @Override // com.bumptech.glide.util.p033a.FactoryPools.InterfaceC0785a
        /* renamed from: a */
        public LockedResource<?> mo11611b() {
            return new LockedResource<>();
        }
    });

    /* renamed from: b */
    private final StateVerifier f972b = StateVerifier.m11604a();

    /* renamed from: c */
    private Resource<Z> f973c;

    /* renamed from: d */
    private boolean f974d;

    /* renamed from: e */
    private boolean f975e;

    /* JADX INFO: Access modifiers changed from: package-private */
    @NonNull
    /* renamed from: a */
    public static <Z> LockedResource<Z> m12030a(Resource<Z> resource) {
        LockedResource<Z> lockedResource = (LockedResource) Preconditions.m11580a(f971a.acquire());
        lockedResource.m12028b(resource);
        return lockedResource;
    }

    LockedResource() {
    }

    /* renamed from: b */
    private void m12028b(Resource<Z> resource) {
        this.f975e = false;
        this.f974d = true;
        this.f973c = resource;
    }

    /* renamed from: b */
    private void m12029b() {
        this.f973c = null;
        f971a.release(this);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public synchronized void m12031a() {
        this.f972b.mo11602b();
        if (!this.f974d) {
            throw new IllegalStateException("Already unlocked");
        }
        this.f974d = false;
        if (this.f975e) {
            mo11851f();
        }
    }

    @Override // com.bumptech.glide.load.engine.Resource
    @NonNull
    /* renamed from: c */
    public Class<Z> mo11853c() {
        return this.f973c.mo11853c();
    }

    @Override // com.bumptech.glide.load.engine.Resource
    @NonNull
    /* renamed from: d */
    public Z mo11898d() {
        return this.f973c.mo11898d();
    }

    @Override // com.bumptech.glide.load.engine.Resource
    /* renamed from: e */
    public int mo11852e() {
        return this.f973c.mo11852e();
    }

    @Override // com.bumptech.glide.load.engine.Resource
    /* renamed from: f */
    public synchronized void mo11851f() {
        this.f972b.mo11602b();
        this.f975e = true;
        if (!this.f974d) {
            this.f973c.mo11851f();
            m12029b();
        }
    }

    @Override // com.bumptech.glide.util.p033a.FactoryPools.InterfaceC0787c
    @NonNull
    /* renamed from: a_ */
    public StateVerifier mo11610a_() {
        return this.f972b;
    }
}
