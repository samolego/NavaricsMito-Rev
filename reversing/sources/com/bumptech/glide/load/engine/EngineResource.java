package com.bumptech.glide.load.engine;

import android.os.Looper;
import android.support.annotation.NonNull;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.util.Preconditions;

/* renamed from: com.bumptech.glide.load.engine.n */
/* loaded from: classes.dex */
class EngineResource<Z> implements Resource<Z> {

    /* renamed from: a */
    private final boolean f958a;

    /* renamed from: b */
    private final boolean f959b;

    /* renamed from: c */
    private InterfaceC0734a f960c;

    /* renamed from: d */
    private Key f961d;

    /* renamed from: e */
    private int f962e;

    /* renamed from: f */
    private boolean f963f;

    /* renamed from: g */
    private final Resource<Z> f964g;

    /* compiled from: EngineResource.java */
    /* renamed from: com.bumptech.glide.load.engine.n$a */
    /* loaded from: classes.dex */
    interface InterfaceC0734a {
        /* renamed from: a */
        void mo12038a(Key key, EngineResource<?> engineResource);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public EngineResource(Resource<Z> resource, boolean z, boolean z2) {
        this.f964g = (Resource) Preconditions.m11580a(resource);
        this.f958a = z;
        this.f959b = z2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public void m12042a(Key key, InterfaceC0734a interfaceC0734a) {
        this.f961d = key;
        this.f960c = interfaceC0734a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public Resource<Z> m12043a() {
        return this.f964g;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: b */
    public boolean m12041b() {
        return this.f958a;
    }

    @Override // com.bumptech.glide.load.engine.Resource
    @NonNull
    /* renamed from: c */
    public Class<Z> mo11853c() {
        return this.f964g.mo11853c();
    }

    @Override // com.bumptech.glide.load.engine.Resource
    @NonNull
    /* renamed from: d */
    public Z mo11898d() {
        return this.f964g.mo11898d();
    }

    @Override // com.bumptech.glide.load.engine.Resource
    /* renamed from: e */
    public int mo11852e() {
        return this.f964g.mo11852e();
    }

    @Override // com.bumptech.glide.load.engine.Resource
    /* renamed from: f */
    public void mo11851f() {
        if (this.f962e > 0) {
            throw new IllegalStateException("Cannot recycle a resource while it is still acquired");
        }
        if (this.f963f) {
            throw new IllegalStateException("Cannot recycle a resource that has already been recycled");
        }
        this.f963f = true;
        if (this.f959b) {
            this.f964g.mo11851f();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: g */
    public void m12040g() {
        if (this.f963f) {
            throw new IllegalStateException("Cannot acquire a recycled resource");
        }
        if (!Looper.getMainLooper().equals(Looper.myLooper())) {
            throw new IllegalThreadStateException("Must call acquire on the main thread");
        }
        this.f962e++;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: h */
    public void m12039h() {
        if (this.f962e <= 0) {
            throw new IllegalStateException("Cannot release a recycled or not yet acquired resource");
        }
        if (!Looper.getMainLooper().equals(Looper.myLooper())) {
            throw new IllegalThreadStateException("Must call release on the main thread");
        }
        int i = this.f962e - 1;
        this.f962e = i;
        if (i == 0) {
            this.f960c.mo12038a(this.f961d, this);
        }
    }

    public String toString() {
        return "EngineResource{isCacheable=" + this.f958a + ", listener=" + this.f960c + ", key=" + this.f961d + ", acquired=" + this.f962e + ", isRecycled=" + this.f963f + ", resource=" + this.f964g + '}';
    }
}
