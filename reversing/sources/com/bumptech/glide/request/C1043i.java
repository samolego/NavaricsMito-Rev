package com.bumptech.glide.request;

import android.support.annotation.Nullable;
import android.support.annotation.VisibleForTesting;

/* renamed from: com.bumptech.glide.request.i */
/* loaded from: classes.dex */
public class ThumbnailRequestCoordinator implements Request, RequestCoordinator {
    @Nullable

    /* renamed from: a */
    private final RequestCoordinator f1276a;

    /* renamed from: b */
    private Request f1277b;

    /* renamed from: c */
    private Request f1278c;

    /* renamed from: d */
    private boolean f1279d;

    @VisibleForTesting
    ThumbnailRequestCoordinator() {
        this(null);
    }

    public ThumbnailRequestCoordinator(@Nullable RequestCoordinator requestCoordinator) {
        this.f1276a = requestCoordinator;
    }

    /* renamed from: a */
    public void m11644a(Request request, Request request2) {
        this.f1277b = request;
        this.f1278c = request2;
    }

    @Override // com.bumptech.glide.request.RequestCoordinator
    /* renamed from: b */
    public boolean mo11642b(Request request) {
        return m11629k() && (request.equals(this.f1277b) || !this.f1277b.mo11635f());
    }

    /* renamed from: k */
    private boolean m11629k() {
        RequestCoordinator requestCoordinator = this.f1276a;
        return requestCoordinator == null || requestCoordinator.mo11642b(this);
    }

    @Override // com.bumptech.glide.request.RequestCoordinator
    /* renamed from: c */
    public boolean mo11640c(Request request) {
        return m11627m() && request.equals(this.f1277b) && !mo11630j();
    }

    @Override // com.bumptech.glide.request.RequestCoordinator
    /* renamed from: d */
    public boolean mo11638d(Request request) {
        return m11628l() && request.equals(this.f1277b);
    }

    /* renamed from: l */
    private boolean m11628l() {
        RequestCoordinator requestCoordinator = this.f1276a;
        return requestCoordinator == null || requestCoordinator.mo11638d(this);
    }

    /* renamed from: m */
    private boolean m11627m() {
        RequestCoordinator requestCoordinator = this.f1276a;
        return requestCoordinator == null || requestCoordinator.mo11640c(this);
    }

    @Override // com.bumptech.glide.request.RequestCoordinator
    /* renamed from: j */
    public boolean mo11630j() {
        return m11626n() || mo11635f();
    }

    @Override // com.bumptech.glide.request.RequestCoordinator
    /* renamed from: e */
    public void mo11636e(Request request) {
        if (request.equals(this.f1278c)) {
            return;
        }
        RequestCoordinator requestCoordinator = this.f1276a;
        if (requestCoordinator != null) {
            requestCoordinator.mo11636e(this);
        }
        if (this.f1278c.mo11637e()) {
            return;
        }
        this.f1278c.mo11641c();
    }

    @Override // com.bumptech.glide.request.RequestCoordinator
    /* renamed from: f */
    public void mo11634f(Request request) {
        RequestCoordinator requestCoordinator;
        if (request.equals(this.f1277b) && (requestCoordinator = this.f1276a) != null) {
            requestCoordinator.mo11634f(this);
        }
    }

    /* renamed from: n */
    private boolean m11626n() {
        RequestCoordinator requestCoordinator = this.f1276a;
        return requestCoordinator != null && requestCoordinator.mo11630j();
    }

    @Override // com.bumptech.glide.request.Request
    /* renamed from: a */
    public void mo11646a() {
        this.f1279d = true;
        if (!this.f1277b.mo11637e() && !this.f1278c.mo11639d()) {
            this.f1278c.mo11646a();
        }
        if (!this.f1279d || this.f1277b.mo11639d()) {
            return;
        }
        this.f1277b.mo11646a();
    }

    @Override // com.bumptech.glide.request.Request
    /* renamed from: b */
    public void mo11643b() {
        this.f1279d = false;
        this.f1277b.mo11643b();
        this.f1278c.mo11643b();
    }

    @Override // com.bumptech.glide.request.Request
    /* renamed from: c */
    public void mo11641c() {
        this.f1279d = false;
        this.f1278c.mo11641c();
        this.f1277b.mo11641c();
    }

    @Override // com.bumptech.glide.request.Request
    /* renamed from: d */
    public boolean mo11639d() {
        return this.f1277b.mo11639d();
    }

    @Override // com.bumptech.glide.request.Request
    /* renamed from: e */
    public boolean mo11637e() {
        return this.f1277b.mo11637e() || this.f1278c.mo11637e();
    }

    @Override // com.bumptech.glide.request.Request
    /* renamed from: f */
    public boolean mo11635f() {
        return this.f1277b.mo11635f() || this.f1278c.mo11635f();
    }

    @Override // com.bumptech.glide.request.Request
    /* renamed from: g */
    public boolean mo11633g() {
        return this.f1277b.mo11633g();
    }

    @Override // com.bumptech.glide.request.Request
    /* renamed from: h */
    public boolean mo11632h() {
        return this.f1277b.mo11632h();
    }

    @Override // com.bumptech.glide.request.Request
    /* renamed from: i */
    public void mo11631i() {
        this.f1277b.mo11631i();
        this.f1278c.mo11631i();
    }

    @Override // com.bumptech.glide.request.Request
    /* renamed from: a */
    public boolean mo11645a(Request request) {
        if (request instanceof ThumbnailRequestCoordinator) {
            ThumbnailRequestCoordinator thumbnailRequestCoordinator = (ThumbnailRequestCoordinator) request;
            Request request2 = this.f1277b;
            if (request2 == null) {
                if (thumbnailRequestCoordinator.f1277b != null) {
                    return false;
                }
            } else if (!request2.mo11645a(thumbnailRequestCoordinator.f1277b)) {
                return false;
            }
            Request request3 = this.f1278c;
            if (request3 == null) {
                if (thumbnailRequestCoordinator.f1278c != null) {
                    return false;
                }
            } else if (!request3.mo11645a(thumbnailRequestCoordinator.f1278c)) {
                return false;
            }
            return true;
        }
        return false;
    }
}
