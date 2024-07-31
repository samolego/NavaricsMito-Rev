package io.reactivex.internal.observers;

import io.reactivex.InterfaceC2900o;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.p101b.QueueDisposable;
import io.reactivex.p098d.RxJavaPlugins;

/* renamed from: io.reactivex.internal.observers.a */
/* loaded from: classes2.dex */
public abstract class BasicFuseableObserver<T, R> implements QueueDisposable<R>, InterfaceC2900o<T> {

    /* renamed from: a */
    protected final InterfaceC2900o<? super R> f9667a;

    /* renamed from: b */
    protected Disposable f9668b;

    /* renamed from: c */
    protected QueueDisposable<T> f9669c;

    /* renamed from: d */
    protected boolean f9670d;

    /* renamed from: e */
    protected int f9671e;

    /* renamed from: a */
    protected boolean m3183a() {
        return true;
    }

    /* renamed from: b */
    protected void m3180b() {
    }

    public BasicFuseableObserver(InterfaceC2900o<? super R> interfaceC2900o) {
        this.f9667a = interfaceC2900o;
    }

    @Override // io.reactivex.InterfaceC2900o
    public final void onSubscribe(Disposable disposable) {
        if (DisposableHelper.validate(this.f9668b, disposable)) {
            this.f9668b = disposable;
            if (disposable instanceof QueueDisposable) {
                this.f9669c = (QueueDisposable) disposable;
            }
            if (m3183a()) {
                this.f9667a.onSubscribe(this);
                m3180b();
            }
        }
    }

    @Override // io.reactivex.InterfaceC2900o
    public void onError(Throwable th) {
        if (this.f9670d) {
            RxJavaPlugins.m3233a(th);
            return;
        }
        this.f9670d = true;
        this.f9667a.onError(th);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: a */
    public final void m3181a(Throwable th) {
        Exceptions.m3207b(th);
        this.f9668b.dispose();
        onError(th);
    }

    @Override // io.reactivex.InterfaceC2900o
    public void onComplete() {
        if (this.f9670d) {
            return;
        }
        this.f9670d = true;
        this.f9667a.onComplete();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: a */
    public final int m3182a(int i) {
        QueueDisposable<T> queueDisposable = this.f9669c;
        if (queueDisposable == null || (i & 4) != 0) {
            return 0;
        }
        int requestFusion = queueDisposable.requestFusion(i);
        if (requestFusion != 0) {
            this.f9671e = requestFusion;
        }
        return requestFusion;
    }

    @Override // io.reactivex.disposables.Disposable
    public void dispose() {
        this.f9668b.dispose();
    }

    @Override // io.reactivex.disposables.Disposable
    public boolean isDisposed() {
        return this.f9668b.isDisposed();
    }

    @Override // io.reactivex.internal.p101b.SimpleQueue
    public boolean isEmpty() {
        return this.f9669c.isEmpty();
    }

    @Override // io.reactivex.internal.p101b.SimpleQueue
    public void clear() {
        this.f9669c.clear();
    }

    @Override // io.reactivex.internal.p101b.SimpleQueue
    public final boolean offer(R r) {
        throw new UnsupportedOperationException("Should not be called!");
    }
}
