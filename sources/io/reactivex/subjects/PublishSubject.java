package io.reactivex.subjects;

import io.reactivex.InterfaceC2900o;
import io.reactivex.annotations.CheckReturnValue;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.p100a.ObjectHelper;
import io.reactivex.p098d.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes2.dex */
public final class PublishSubject<T> extends Subject<T> {

    /* renamed from: a */
    static final PublishDisposable[] f9890a = new PublishDisposable[0];

    /* renamed from: b */
    static final PublishDisposable[] f9891b = new PublishDisposable[0];

    /* renamed from: c */
    final AtomicReference<PublishDisposable<T>[]> f9892c = new AtomicReference<>(f9891b);

    /* renamed from: d */
    Throwable f9893d;

    @CheckReturnValue
    @NonNull
    /* renamed from: f */
    public static <T> PublishSubject<T> m3052f() {
        return new PublishSubject<>();
    }

    PublishSubject() {
    }

    @Override // io.reactivex.Observable
    /* renamed from: a */
    protected void mo158a(InterfaceC2900o<? super T> interfaceC2900o) {
        PublishDisposable<T> publishDisposable = new PublishDisposable<>(interfaceC2900o, this);
        interfaceC2900o.onSubscribe(publishDisposable);
        if (m3054a((PublishDisposable) publishDisposable)) {
            if (publishDisposable.isDisposed()) {
                m3053b(publishDisposable);
                return;
            }
            return;
        }
        Throwable th = this.f9893d;
        if (th != null) {
            interfaceC2900o.onError(th);
        } else {
            interfaceC2900o.onComplete();
        }
    }

    /* renamed from: a */
    boolean m3054a(PublishDisposable<T> publishDisposable) {
        PublishDisposable<T>[] publishDisposableArr;
        PublishDisposable<T>[] publishDisposableArr2;
        do {
            publishDisposableArr = this.f9892c.get();
            if (publishDisposableArr == f9890a) {
                return false;
            }
            int length = publishDisposableArr.length;
            publishDisposableArr2 = new PublishDisposable[length + 1];
            System.arraycopy(publishDisposableArr, 0, publishDisposableArr2, 0, length);
            publishDisposableArr2[length] = publishDisposable;
        } while (!this.f9892c.compareAndSet(publishDisposableArr, publishDisposableArr2));
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: b */
    void m3053b(PublishDisposable<T> publishDisposable) {
        PublishDisposable<T>[] publishDisposableArr;
        PublishDisposable[] publishDisposableArr2;
        do {
            publishDisposableArr = this.f9892c.get();
            if (publishDisposableArr == f9890a || publishDisposableArr == f9891b) {
                return;
            }
            int length = publishDisposableArr.length;
            int i = -1;
            int i2 = 0;
            while (true) {
                if (i2 >= length) {
                    break;
                } else if (publishDisposableArr[i2] == publishDisposable) {
                    i = i2;
                    break;
                } else {
                    i2++;
                }
            }
            if (i < 0) {
                return;
            }
            if (length == 1) {
                publishDisposableArr2 = f9891b;
            } else {
                PublishDisposable[] publishDisposableArr3 = new PublishDisposable[length - 1];
                System.arraycopy(publishDisposableArr, 0, publishDisposableArr3, 0, i);
                System.arraycopy(publishDisposableArr, i + 1, publishDisposableArr3, i, (length - i) - 1);
                publishDisposableArr2 = publishDisposableArr3;
            }
        } while (!this.f9892c.compareAndSet(publishDisposableArr, publishDisposableArr2));
    }

    @Override // io.reactivex.InterfaceC2900o
    public void onSubscribe(Disposable disposable) {
        if (this.f9892c.get() == f9890a) {
            disposable.dispose();
        }
    }

    @Override // io.reactivex.InterfaceC2900o
    public void onNext(T t) {
        ObjectHelper.m3188a((Object) t, "onNext called with null. Null values are generally not allowed in 2.x operators and sources.");
        for (PublishDisposable<T> publishDisposable : this.f9892c.get()) {
            publishDisposable.onNext(t);
        }
    }

    @Override // io.reactivex.InterfaceC2900o
    public void onError(Throwable th) {
        ObjectHelper.m3188a(th, "onError called with null. Null values are generally not allowed in 2.x operators and sources.");
        PublishDisposable<T>[] publishDisposableArr = this.f9892c.get();
        PublishDisposable<T>[] publishDisposableArr2 = f9890a;
        if (publishDisposableArr == publishDisposableArr2) {
            RxJavaPlugins.m3233a(th);
            return;
        }
        this.f9893d = th;
        for (PublishDisposable<T> publishDisposable : this.f9892c.getAndSet(publishDisposableArr2)) {
            publishDisposable.onError(th);
        }
    }

    @Override // io.reactivex.InterfaceC2900o
    public void onComplete() {
        PublishDisposable<T>[] publishDisposableArr = this.f9892c.get();
        PublishDisposable<T>[] publishDisposableArr2 = f9890a;
        if (publishDisposableArr == publishDisposableArr2) {
            return;
        }
        for (PublishDisposable<T> publishDisposable : this.f9892c.getAndSet(publishDisposableArr2)) {
            publishDisposable.onComplete();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static final class PublishDisposable<T> extends AtomicBoolean implements Disposable {
        private static final long serialVersionUID = 3562861878281475070L;
        final InterfaceC2900o<? super T> downstream;
        final PublishSubject<T> parent;

        PublishDisposable(InterfaceC2900o<? super T> interfaceC2900o, PublishSubject<T> publishSubject) {
            this.downstream = interfaceC2900o;
            this.parent = publishSubject;
        }

        public void onNext(T t) {
            if (get()) {
                return;
            }
            this.downstream.onNext(t);
        }

        public void onError(Throwable th) {
            if (get()) {
                RxJavaPlugins.m3233a(th);
            } else {
                this.downstream.onError(th);
            }
        }

        public void onComplete() {
            if (get()) {
                return;
            }
            this.downstream.onComplete();
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            if (compareAndSet(false, true)) {
                this.parent.m3053b(this);
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return get();
        }
    }
}
