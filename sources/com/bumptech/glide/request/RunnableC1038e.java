package com.bumptech.glide.request;

import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.VisibleForTesting;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.p031a.SizeReadyCallback;
import com.bumptech.glide.request.p031a.Target;
import com.bumptech.glide.request.p032b.Transition;
import com.bumptech.glide.util.C0791i;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* renamed from: com.bumptech.glide.request.e */
/* loaded from: classes.dex */
public class RequestFutureTarget<R> implements FutureTarget<R>, RequestListener<R>, Runnable {

    /* renamed from: a */
    private static final C0779a f1237a = new C0779a();

    /* renamed from: b */
    private final Handler f1238b;

    /* renamed from: c */
    private final int f1239c;

    /* renamed from: d */
    private final int f1240d;

    /* renamed from: e */
    private final boolean f1241e;

    /* renamed from: f */
    private final C0779a f1242f;
    @Nullable

    /* renamed from: g */
    private R f1243g;
    @Nullable

    /* renamed from: h */
    private Request f1244h;

    /* renamed from: i */
    private boolean f1245i;

    /* renamed from: j */
    private boolean f1246j;

    /* renamed from: k */
    private boolean f1247k;
    @Nullable

    /* renamed from: l */
    private GlideException f1248l;

    @Override // com.bumptech.glide.request.p031a.Target
    /* renamed from: a */
    public void mo11703a(@Nullable Drawable drawable) {
    }

    @Override // com.bumptech.glide.request.p031a.Target
    /* renamed from: b */
    public void mo11697b(@Nullable Drawable drawable) {
    }

    @Override // com.bumptech.glide.request.p031a.Target
    /* renamed from: b */
    public void mo11696b(@NonNull SizeReadyCallback sizeReadyCallback) {
    }

    @Override // com.bumptech.glide.manager.LifecycleListener
    /* renamed from: c */
    public void mo11695c() {
    }

    @Override // com.bumptech.glide.manager.LifecycleListener
    /* renamed from: d */
    public void mo11693d() {
    }

    @Override // com.bumptech.glide.manager.LifecycleListener
    /* renamed from: e */
    public void mo11692e() {
    }

    public RequestFutureTarget(Handler handler, int i, int i2) {
        this(handler, i, i2, true, f1237a);
    }

    RequestFutureTarget(Handler handler, int i, int i2, boolean z, C0779a c0779a) {
        this.f1238b = handler;
        this.f1239c = i;
        this.f1240d = i2;
        this.f1241e = z;
        this.f1242f = c0779a;
    }

    @Override // java.util.concurrent.Future
    public synchronized boolean cancel(boolean z) {
        if (isDone()) {
            return false;
        }
        this.f1245i = true;
        this.f1242f.m11691a(this);
        if (z) {
            m11698b();
        }
        return true;
    }

    @Override // java.util.concurrent.Future
    public synchronized boolean isCancelled() {
        return this.f1245i;
    }

    @Override // java.util.concurrent.Future
    public synchronized boolean isDone() {
        boolean z;
        if (!this.f1245i && !this.f1246j) {
            z = this.f1247k;
        }
        return z;
    }

    @Override // java.util.concurrent.Future
    public R get() throws InterruptedException, ExecutionException {
        try {
            return m11700a((Long) null);
        } catch (TimeoutException e) {
            throw new AssertionError(e);
        }
    }

    @Override // java.util.concurrent.Future
    public R get(long j, @NonNull TimeUnit timeUnit) throws InterruptedException, ExecutionException, TimeoutException {
        return m11700a(Long.valueOf(timeUnit.toMillis(j)));
    }

    @Override // com.bumptech.glide.request.p031a.Target
    /* renamed from: a */
    public void mo11702a(@NonNull SizeReadyCallback sizeReadyCallback) {
        sizeReadyCallback.mo11723a(this.f1239c, this.f1240d);
    }

    @Override // com.bumptech.glide.request.p031a.Target
    /* renamed from: a */
    public void mo11701a(@Nullable Request request) {
        this.f1244h = request;
    }

    @Override // com.bumptech.glide.request.p031a.Target
    @Nullable
    /* renamed from: a */
    public Request mo11704a() {
        return this.f1244h;
    }

    @Override // com.bumptech.glide.request.p031a.Target
    /* renamed from: c */
    public synchronized void mo11694c(@Nullable Drawable drawable) {
    }

    @Override // com.bumptech.glide.request.p031a.Target
    /* renamed from: a */
    public synchronized void mo11699a(@NonNull R r, @Nullable Transition<? super R> transition) {
    }

    /* renamed from: a */
    private synchronized R m11700a(Long l) throws ExecutionException, InterruptedException, TimeoutException {
        if (this.f1241e && !isDone()) {
            C0791i.m11561b();
        }
        if (this.f1245i) {
            throw new CancellationException();
        }
        if (this.f1247k) {
            throw new ExecutionException(this.f1248l);
        }
        if (this.f1246j) {
            return this.f1243g;
        }
        if (l == null) {
            this.f1242f.m11690a(this, 0L);
        } else if (l.longValue() > 0) {
            long currentTimeMillis = System.currentTimeMillis();
            long longValue = l.longValue() + currentTimeMillis;
            while (!isDone() && currentTimeMillis < longValue) {
                this.f1242f.m11690a(this, longValue - currentTimeMillis);
                currentTimeMillis = System.currentTimeMillis();
            }
        }
        if (Thread.interrupted()) {
            throw new InterruptedException();
        }
        if (this.f1247k) {
            throw new ExecutionException(this.f1248l);
        }
        if (this.f1245i) {
            throw new CancellationException();
        }
        if (!this.f1246j) {
            throw new TimeoutException();
        }
        return this.f1243g;
    }

    @Override // java.lang.Runnable
    public void run() {
        Request request = this.f1244h;
        if (request != null) {
            request.mo11641c();
            this.f1244h = null;
        }
    }

    /* renamed from: b */
    private void m11698b() {
        this.f1238b.post(this);
    }

    @Override // com.bumptech.glide.request.RequestListener
    /* renamed from: a */
    public synchronized boolean mo8724a(@Nullable GlideException glideException, Object obj, Target<R> target, boolean z) {
        this.f1247k = true;
        this.f1248l = glideException;
        this.f1242f.m11691a(this);
        return false;
    }

    @Override // com.bumptech.glide.request.RequestListener
    /* renamed from: a */
    public synchronized boolean mo8723a(R r, Object obj, Target<R> target, DataSource dataSource, boolean z) {
        this.f1246j = true;
        this.f1243g = r;
        this.f1242f.m11691a(this);
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: RequestFutureTarget.java */
    @VisibleForTesting
    /* renamed from: com.bumptech.glide.request.e$a */
    /* loaded from: classes.dex */
    public static class C0779a {
        C0779a() {
        }

        /* renamed from: a */
        void m11690a(Object obj, long j) throws InterruptedException {
            obj.wait(j);
        }

        /* renamed from: a */
        void m11691a(Object obj) {
            obj.notifyAll();
        }
    }
}
