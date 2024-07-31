package com.bumptech.glide.request;

import android.support.annotation.Nullable;

/* renamed from: com.bumptech.glide.request.a */
/* loaded from: classes.dex */
public final class ErrorRequestCoordinator implements Request, RequestCoordinator {
    @Nullable

    /* renamed from: a */
    private final RequestCoordinator f1215a;

    /* renamed from: b */
    private Request f1216b;

    /* renamed from: c */
    private Request f1217c;

    public ErrorRequestCoordinator(@Nullable RequestCoordinator requestCoordinator) {
        this.f1215a = requestCoordinator;
    }

    /* renamed from: a */
    public void m11736a(Request request, Request request2) {
        this.f1216b = request;
        this.f1217c = request2;
    }

    @Override // com.bumptech.glide.request.Request
    /* renamed from: a */
    public void mo11646a() {
        if (this.f1216b.mo11639d()) {
            return;
        }
        this.f1216b.mo11646a();
    }

    @Override // com.bumptech.glide.request.Request
    /* renamed from: b */
    public void mo11643b() {
        if (!this.f1216b.mo11632h()) {
            this.f1216b.mo11643b();
        }
        if (this.f1217c.mo11639d()) {
            this.f1217c.mo11643b();
        }
    }

    @Override // com.bumptech.glide.request.Request
    /* renamed from: c */
    public void mo11641c() {
        this.f1216b.mo11641c();
        if (this.f1217c.mo11639d()) {
            this.f1217c.mo11641c();
        }
    }

    @Override // com.bumptech.glide.request.Request
    /* renamed from: d */
    public boolean mo11639d() {
        return (this.f1216b.mo11632h() ? this.f1217c : this.f1216b).mo11639d();
    }

    @Override // com.bumptech.glide.request.Request
    /* renamed from: e */
    public boolean mo11637e() {
        return (this.f1216b.mo11632h() ? this.f1217c : this.f1216b).mo11637e();
    }

    @Override // com.bumptech.glide.request.Request
    /* renamed from: f */
    public boolean mo11635f() {
        return (this.f1216b.mo11632h() ? this.f1217c : this.f1216b).mo11635f();
    }

    @Override // com.bumptech.glide.request.Request
    /* renamed from: g */
    public boolean mo11633g() {
        return (this.f1216b.mo11632h() ? this.f1217c : this.f1216b).mo11633g();
    }

    @Override // com.bumptech.glide.request.Request
    /* renamed from: h */
    public boolean mo11632h() {
        return this.f1216b.mo11632h() && this.f1217c.mo11632h();
    }

    @Override // com.bumptech.glide.request.Request
    /* renamed from: i */
    public void mo11631i() {
        this.f1216b.mo11631i();
        this.f1217c.mo11631i();
    }

    @Override // com.bumptech.glide.request.Request
    /* renamed from: a */
    public boolean mo11645a(Request request) {
        if (request instanceof ErrorRequestCoordinator) {
            ErrorRequestCoordinator errorRequestCoordinator = (ErrorRequestCoordinator) request;
            return this.f1216b.mo11645a(errorRequestCoordinator.f1216b) && this.f1217c.mo11645a(errorRequestCoordinator.f1217c);
        }
        return false;
    }

    @Override // com.bumptech.glide.request.RequestCoordinator
    /* renamed from: b */
    public boolean mo11642b(Request request) {
        return m11734k() && m11735g(request);
    }

    /* renamed from: k */
    private boolean m11734k() {
        RequestCoordinator requestCoordinator = this.f1215a;
        return requestCoordinator == null || requestCoordinator.mo11642b(this);
    }

    @Override // com.bumptech.glide.request.RequestCoordinator
    /* renamed from: c */
    public boolean mo11640c(Request request) {
        return m11732m() && m11735g(request);
    }

    @Override // com.bumptech.glide.request.RequestCoordinator
    /* renamed from: d */
    public boolean mo11638d(Request request) {
        return m11733l() && m11735g(request);
    }

    /* renamed from: l */
    private boolean m11733l() {
        RequestCoordinator requestCoordinator = this.f1215a;
        return requestCoordinator == null || requestCoordinator.mo11638d(this);
    }

    /* renamed from: m */
    private boolean m11732m() {
        RequestCoordinator requestCoordinator = this.f1215a;
        return requestCoordinator == null || requestCoordinator.mo11640c(this);
    }

    /* renamed from: g */
    private boolean m11735g(Request request) {
        return request.equals(this.f1216b) || (this.f1216b.mo11632h() && request.equals(this.f1217c));
    }

    @Override // com.bumptech.glide.request.RequestCoordinator
    /* renamed from: j */
    public boolean mo11630j() {
        return m11731n() || mo11635f();
    }

    /* renamed from: n */
    private boolean m11731n() {
        RequestCoordinator requestCoordinator = this.f1215a;
        return requestCoordinator != null && requestCoordinator.mo11630j();
    }

    @Override // com.bumptech.glide.request.RequestCoordinator
    /* renamed from: e */
    public void mo11636e(Request request) {
        RequestCoordinator requestCoordinator = this.f1215a;
        if (requestCoordinator != null) {
            requestCoordinator.mo11636e(this);
        }
    }

    @Override // com.bumptech.glide.request.RequestCoordinator
    /* renamed from: f */
    public void mo11634f(Request request) {
        if (!request.equals(this.f1217c)) {
            if (this.f1217c.mo11639d()) {
                return;
            }
            this.f1217c.mo11646a();
            return;
        }
        RequestCoordinator requestCoordinator = this.f1215a;
        if (requestCoordinator != null) {
            requestCoordinator.mo11634f(this);
        }
    }
}
