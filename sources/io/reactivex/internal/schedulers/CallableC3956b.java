package io.reactivex.internal.schedulers;

import io.reactivex.disposables.Disposable;
import io.reactivex.internal.p100a.Functions;
import io.reactivex.p098d.RxJavaPlugins;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: io.reactivex.internal.schedulers.b */
/* loaded from: classes2.dex */
public final class InstantPeriodicTask implements Disposable, Callable<Void> {

    /* renamed from: f */
    static final FutureTask<Void> f9806f = new FutureTask<>(Functions.f9649b, null);

    /* renamed from: a */
    final Runnable f9807a;

    /* renamed from: d */
    final ExecutorService f9810d;

    /* renamed from: e */
    Thread f9811e;

    /* renamed from: c */
    final AtomicReference<Future<?>> f9809c = new AtomicReference<>();

    /* renamed from: b */
    final AtomicReference<Future<?>> f9808b = new AtomicReference<>();

    /* JADX INFO: Access modifiers changed from: package-private */
    public InstantPeriodicTask(Runnable runnable, ExecutorService executorService) {
        this.f9807a = runnable;
        this.f9810d = executorService;
    }

    @Override // java.util.concurrent.Callable
    /* renamed from: a */
    public Void call() throws Exception {
        this.f9811e = Thread.currentThread();
        try {
            this.f9807a.run();
            m3152b(this.f9810d.submit(this));
            this.f9811e = null;
        } catch (Throwable th) {
            this.f9811e = null;
            RxJavaPlugins.m3233a(th);
        }
        return null;
    }

    @Override // io.reactivex.disposables.Disposable
    public void dispose() {
        Future<?> andSet = this.f9809c.getAndSet(f9806f);
        if (andSet != null && andSet != f9806f) {
            andSet.cancel(this.f9811e != Thread.currentThread());
        }
        Future<?> andSet2 = this.f9808b.getAndSet(f9806f);
        if (andSet2 == null || andSet2 == f9806f) {
            return;
        }
        andSet2.cancel(this.f9811e != Thread.currentThread());
    }

    @Override // io.reactivex.disposables.Disposable
    public boolean isDisposed() {
        return this.f9809c.get() == f9806f;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public void m3153a(Future<?> future) {
        Future<?> future2;
        do {
            future2 = this.f9809c.get();
            if (future2 == f9806f) {
                future.cancel(this.f9811e != Thread.currentThread());
                return;
            }
        } while (!this.f9809c.compareAndSet(future2, future));
    }

    /* renamed from: b */
    void m3152b(Future<?> future) {
        Future<?> future2;
        do {
            future2 = this.f9808b.get();
            if (future2 == f9806f) {
                future.cancel(this.f9811e != Thread.currentThread());
                return;
            }
        } while (!this.f9808b.compareAndSet(future2, future));
    }
}
