package com.bumptech.glide;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.CheckResult;
import android.support.annotation.DrawableRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RawRes;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.resource.p029d.GifDrawable;
import com.bumptech.glide.manager.ConnectivityMonitor;
import com.bumptech.glide.manager.ConnectivityMonitorFactory;
import com.bumptech.glide.manager.Lifecycle;
import com.bumptech.glide.manager.LifecycleListener;
import com.bumptech.glide.manager.RequestManagerTreeNode;
import com.bumptech.glide.manager.RequestTracker;
import com.bumptech.glide.manager.TargetTracker;
import com.bumptech.glide.request.Request;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.p031a.Target;
import com.bumptech.glide.util.C0791i;

/* renamed from: com.bumptech.glide.i */
/* loaded from: classes.dex */
public class RequestManager implements LifecycleListener {

    /* renamed from: d */
    private static final RequestOptions f530d = RequestOptions.m11672a(Bitmap.class).mo9518j();

    /* renamed from: e */
    private static final RequestOptions f531e = RequestOptions.m11672a(GifDrawable.class).mo9518j();

    /* renamed from: f */
    private static final RequestOptions f532f = RequestOptions.m11677a(DiskCacheStrategy.f897c).mo9549a(Priority.LOW).mo9532b(true);

    /* renamed from: a */
    protected final Glide f533a;

    /* renamed from: b */
    protected final Context f534b;

    /* renamed from: c */
    final Lifecycle f535c;

    /* renamed from: g */
    private final RequestTracker f536g;

    /* renamed from: h */
    private final RequestManagerTreeNode f537h;

    /* renamed from: i */
    private final TargetTracker f538i;

    /* renamed from: j */
    private final Runnable f539j;

    /* renamed from: k */
    private final Handler f540k;

    /* renamed from: l */
    private final ConnectivityMonitor f541l;

    /* renamed from: m */
    private RequestOptions f542m;

    public RequestManager(@NonNull Glide glide, @NonNull Lifecycle lifecycle, @NonNull RequestManagerTreeNode requestManagerTreeNode, @NonNull Context context) {
        this(glide, lifecycle, requestManagerTreeNode, new RequestTracker(), glide.m12512d(), context);
    }

    RequestManager(Glide glide, Lifecycle lifecycle, RequestManagerTreeNode requestManagerTreeNode, RequestTracker requestTracker, ConnectivityMonitorFactory connectivityMonitorFactory, Context context) {
        this.f538i = new TargetTracker();
        this.f539j = new Runnable() { // from class: com.bumptech.glide.i.1
            @Override // java.lang.Runnable
            public void run() {
                RequestManager.this.f535c.mo11793a(RequestManager.this);
            }
        };
        this.f540k = new Handler(Looper.getMainLooper());
        this.f533a = glide;
        this.f535c = lifecycle;
        this.f537h = requestManagerTreeNode;
        this.f536g = requestTracker;
        this.f534b = context;
        this.f541l = connectivityMonitorFactory.mo11794a(context.getApplicationContext(), new C0612a(requestTracker));
        if (C0791i.m11555d()) {
            this.f540k.post(this.f539j);
        } else {
            lifecycle.mo11793a(this);
        }
        lifecycle.mo11793a(this.f541l);
        mo8817a(glide.m12510e().m12501a());
        glide.m12520a(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: a */
    public void mo8817a(@NonNull RequestOptions requestOptions) {
        this.f542m = requestOptions.clone().mo9517k();
    }

    /* renamed from: a */
    public void m12438a() {
        C0791i.m11575a();
        this.f536g.m11768a();
    }

    /* renamed from: b */
    public void m12435b() {
        C0791i.m11575a();
        this.f536g.m11765b();
    }

    @Override // com.bumptech.glide.manager.LifecycleListener
    /* renamed from: c */
    public void mo11695c() {
        m12435b();
        this.f538i.mo11695c();
    }

    @Override // com.bumptech.glide.manager.LifecycleListener
    /* renamed from: d */
    public void mo11693d() {
        m12438a();
        this.f538i.mo11693d();
    }

    @Override // com.bumptech.glide.manager.LifecycleListener
    /* renamed from: e */
    public void mo11692e() {
        this.f538i.mo11692e();
        for (Target<?> target : this.f538i.m11761a()) {
            m12437a(target);
        }
        this.f538i.m11759b();
        this.f536g.m11763c();
        this.f535c.mo11792b(this);
        this.f535c.mo11792b(this.f541l);
        this.f540k.removeCallbacks(this.f539j);
        this.f533a.m12515b(this);
    }

    @CheckResult
    @NonNull
    /* renamed from: f */
    public RequestBuilder<Bitmap> mo8810f() {
        return mo8816a(Bitmap.class).mo8828a(f530d);
    }

    @CheckResult
    @NonNull
    /* renamed from: g */
    public RequestBuilder<Drawable> mo8809g() {
        return mo8816a(Drawable.class);
    }

    @CheckResult
    @NonNull
    /* renamed from: a */
    public RequestBuilder<Drawable> mo8814a(@Nullable String str) {
        return mo8809g().mo8825a(str);
    }

    @CheckResult
    @NonNull
    /* renamed from: a */
    public RequestBuilder<Drawable> mo8815a(@RawRes @DrawableRes @Nullable Integer num) {
        return mo8809g().mo8827a(num);
    }

    @CheckResult
    @NonNull
    /* renamed from: a */
    public <ResourceType> RequestBuilder<ResourceType> mo8816a(@NonNull Class<ResourceType> cls) {
        return new RequestBuilder<>(this.f533a, this, cls, this.f534b);
    }

    /* renamed from: a */
    public void m12437a(@Nullable final Target<?> target) {
        if (target == null) {
            return;
        }
        if (C0791i.m11557c()) {
            m12432c(target);
        } else {
            this.f540k.post(new Runnable() { // from class: com.bumptech.glide.i.2
                @Override // java.lang.Runnable
                public void run() {
                    RequestManager.this.m12437a(target);
                }
            });
        }
    }

    /* renamed from: c */
    private void m12432c(@NonNull Target<?> target) {
        if (m12434b(target) || this.f533a.m12519a(target) || target.mo11704a() == null) {
            return;
        }
        Request mo11704a = target.mo11704a();
        target.mo11701a((Request) null);
        mo11704a.mo11641c();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: b */
    public boolean m12434b(@NonNull Target<?> target) {
        Request mo11704a = target.mo11704a();
        if (mo11704a == null) {
            return true;
        }
        if (this.f536g.m11764b(mo11704a)) {
            this.f538i.m11758b(target);
            target.mo11701a((Request) null);
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public void m12436a(@NonNull Target<?> target, @NonNull Request request) {
        this.f538i.m11760a(target);
        this.f536g.m11767a(request);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: h */
    public RequestOptions m12431h() {
        return this.f542m;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @NonNull
    /* renamed from: b */
    public <T> TransitionOptions<?, T> m12433b(Class<T> cls) {
        return this.f533a.m12510e().m12499a(cls);
    }

    public String toString() {
        return super.toString() + "{tracker=" + this.f536g + ", treeNode=" + this.f537h + "}";
    }

    /* compiled from: RequestManager.java */
    /* renamed from: com.bumptech.glide.i$a */
    /* loaded from: classes.dex */
    private static class C0612a implements ConnectivityMonitor.InterfaceC0769a {

        /* renamed from: a */
        private final RequestTracker f546a;

        C0612a(@NonNull RequestTracker requestTracker) {
            this.f546a = requestTracker;
        }

        @Override // com.bumptech.glide.manager.ConnectivityMonitor.InterfaceC0769a
        /* renamed from: a */
        public void mo11798a(boolean z) {
            if (z) {
                this.f546a.m11762d();
            }
        }
    }
}
