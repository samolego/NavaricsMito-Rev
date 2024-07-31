package io.reactivex.p097c;

import io.reactivex.InterfaceC2900o;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.util.AppendOnlyLinkedArrayList;
import io.reactivex.internal.util.NotificationLite;
import io.reactivex.p098d.RxJavaPlugins;

/* renamed from: io.reactivex.c.a */
/* loaded from: classes2.dex */
public final class SerializedObserver<T> implements Disposable, InterfaceC2900o<T> {

    /* renamed from: a */
    final InterfaceC2900o<? super T> f9612a;

    /* renamed from: b */
    final boolean f9613b;

    /* renamed from: c */
    Disposable f9614c;

    /* renamed from: d */
    boolean f9615d;

    /* renamed from: e */
    AppendOnlyLinkedArrayList<Object> f9616e;

    /* renamed from: f */
    volatile boolean f9617f;

    public SerializedObserver(@NonNull InterfaceC2900o<? super T> interfaceC2900o) {
        this(interfaceC2900o, false);
    }

    public SerializedObserver(@NonNull InterfaceC2900o<? super T> interfaceC2900o, boolean z) {
        this.f9612a = interfaceC2900o;
        this.f9613b = z;
    }

    @Override // io.reactivex.InterfaceC2900o
    public void onSubscribe(@NonNull Disposable disposable) {
        if (DisposableHelper.validate(this.f9614c, disposable)) {
            this.f9614c = disposable;
            this.f9612a.onSubscribe(this);
        }
    }

    @Override // io.reactivex.disposables.Disposable
    public void dispose() {
        this.f9614c.dispose();
    }

    @Override // io.reactivex.disposables.Disposable
    public boolean isDisposed() {
        return this.f9614c.isDisposed();
    }

    @Override // io.reactivex.InterfaceC2900o
    public void onNext(@NonNull T t) {
        if (this.f9617f) {
            return;
        }
        if (t == null) {
            this.f9614c.dispose();
            onError(new NullPointerException("onNext called with null. Null values are generally not allowed in 2.x operators and sources."));
            return;
        }
        synchronized (this) {
            if (this.f9617f) {
                return;
            }
            if (this.f9615d) {
                AppendOnlyLinkedArrayList<Object> appendOnlyLinkedArrayList = this.f9616e;
                if (appendOnlyLinkedArrayList == null) {
                    appendOnlyLinkedArrayList = new AppendOnlyLinkedArrayList<>(4);
                    this.f9616e = appendOnlyLinkedArrayList;
                }
                appendOnlyLinkedArrayList.m3127a((AppendOnlyLinkedArrayList<Object>) NotificationLite.next(t));
                return;
            }
            this.f9615d = true;
            this.f9612a.onNext(t);
            m3247a();
        }
    }

    @Override // io.reactivex.InterfaceC2900o
    public void onError(@NonNull Throwable th) {
        if (this.f9617f) {
            RxJavaPlugins.m3233a(th);
            return;
        }
        synchronized (this) {
            boolean z = true;
            if (!this.f9617f) {
                if (this.f9615d) {
                    this.f9617f = true;
                    AppendOnlyLinkedArrayList<Object> appendOnlyLinkedArrayList = this.f9616e;
                    if (appendOnlyLinkedArrayList == null) {
                        appendOnlyLinkedArrayList = new AppendOnlyLinkedArrayList<>(4);
                        this.f9616e = appendOnlyLinkedArrayList;
                    }
                    Object error = NotificationLite.error(th);
                    if (this.f9613b) {
                        appendOnlyLinkedArrayList.m3127a((AppendOnlyLinkedArrayList<Object>) error);
                    } else {
                        appendOnlyLinkedArrayList.m3126b(error);
                    }
                    return;
                }
                this.f9617f = true;
                this.f9615d = true;
                z = false;
            }
            if (z) {
                RxJavaPlugins.m3233a(th);
            } else {
                this.f9612a.onError(th);
            }
        }
    }

    @Override // io.reactivex.InterfaceC2900o
    public void onComplete() {
        if (this.f9617f) {
            return;
        }
        synchronized (this) {
            if (this.f9617f) {
                return;
            }
            if (this.f9615d) {
                AppendOnlyLinkedArrayList<Object> appendOnlyLinkedArrayList = this.f9616e;
                if (appendOnlyLinkedArrayList == null) {
                    appendOnlyLinkedArrayList = new AppendOnlyLinkedArrayList<>(4);
                    this.f9616e = appendOnlyLinkedArrayList;
                }
                appendOnlyLinkedArrayList.m3127a((AppendOnlyLinkedArrayList<Object>) NotificationLite.complete());
                return;
            }
            this.f9617f = true;
            this.f9615d = true;
            this.f9612a.onComplete();
        }
    }

    /* renamed from: a */
    void m3247a() {
        AppendOnlyLinkedArrayList<Object> appendOnlyLinkedArrayList;
        do {
            synchronized (this) {
                appendOnlyLinkedArrayList = this.f9616e;
                if (appendOnlyLinkedArrayList == null) {
                    this.f9615d = false;
                    return;
                }
                this.f9616e = null;
            }
        } while (!appendOnlyLinkedArrayList.m3128a((InterfaceC2900o<? super T>) this.f9612a));
    }
}
