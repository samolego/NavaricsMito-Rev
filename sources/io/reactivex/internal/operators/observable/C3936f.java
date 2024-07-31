package io.reactivex.internal.operators.observable;

import io.reactivex.InterfaceC2900o;
import io.reactivex.Observable;
import io.reactivex.annotations.Nullable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.observers.BasicQueueDisposable;
import io.reactivex.internal.p100a.ObjectHelper;
import java.util.Iterator;

/* renamed from: io.reactivex.internal.operators.observable.f */
/* loaded from: classes2.dex */
public final class ObservableFromIterable<T> extends Observable<T> {

    /* renamed from: a */
    final Iterable<? extends T> f9751a;

    public ObservableFromIterable(Iterable<? extends T> iterable) {
        this.f9751a = iterable;
    }

    @Override // io.reactivex.Observable
    /* renamed from: a */
    public void mo158a(InterfaceC2900o<? super T> interfaceC2900o) {
        try {
            Iterator<? extends T> it = this.f9751a.iterator();
            try {
                if (!it.hasNext()) {
                    EmptyDisposable.complete(interfaceC2900o);
                    return;
                }
                C2880a c2880a = new C2880a(interfaceC2900o, it);
                interfaceC2900o.onSubscribe(c2880a);
                if (c2880a.f9755d) {
                    return;
                }
                c2880a.m3175a();
            } catch (Throwable th) {
                Exceptions.m3207b(th);
                EmptyDisposable.error(th, interfaceC2900o);
            }
        } catch (Throwable th2) {
            Exceptions.m3207b(th2);
            EmptyDisposable.error(th2, interfaceC2900o);
        }
    }

    /* compiled from: ObservableFromIterable.java */
    /* renamed from: io.reactivex.internal.operators.observable.f$a */
    /* loaded from: classes2.dex */
    static final class C2880a<T> extends BasicQueueDisposable<T> {

        /* renamed from: a */
        final InterfaceC2900o<? super T> f9752a;

        /* renamed from: b */
        final Iterator<? extends T> f9753b;

        /* renamed from: c */
        volatile boolean f9754c;

        /* renamed from: d */
        boolean f9755d;

        /* renamed from: e */
        boolean f9756e;

        /* renamed from: f */
        boolean f9757f;

        C2880a(InterfaceC2900o<? super T> interfaceC2900o, Iterator<? extends T> it) {
            this.f9752a = interfaceC2900o;
            this.f9753b = it;
        }

        /* renamed from: a */
        void m3175a() {
            while (!isDisposed()) {
                try {
                    this.f9752a.onNext(ObjectHelper.m3188a((Object) this.f9753b.next(), "The iterator returned a null value"));
                    if (isDisposed()) {
                        return;
                    }
                    try {
                        if (!this.f9753b.hasNext()) {
                            if (isDisposed()) {
                                return;
                            }
                            this.f9752a.onComplete();
                            return;
                        }
                    } catch (Throwable th) {
                        Exceptions.m3207b(th);
                        this.f9752a.onError(th);
                        return;
                    }
                } catch (Throwable th2) {
                    Exceptions.m3207b(th2);
                    this.f9752a.onError(th2);
                    return;
                }
            }
        }

        @Override // io.reactivex.internal.p101b.QueueFuseable
        public int requestFusion(int i) {
            if ((i & 1) != 0) {
                this.f9755d = true;
                return 1;
            }
            return 0;
        }

        @Override // io.reactivex.internal.p101b.SimpleQueue
        @Nullable
        public T poll() {
            if (this.f9756e) {
                return null;
            }
            if (this.f9757f) {
                if (!this.f9753b.hasNext()) {
                    this.f9756e = true;
                    return null;
                }
            } else {
                this.f9757f = true;
            }
            return (T) ObjectHelper.m3188a((Object) this.f9753b.next(), "The iterator returned a null value");
        }

        @Override // io.reactivex.internal.p101b.SimpleQueue
        public boolean isEmpty() {
            return this.f9756e;
        }

        @Override // io.reactivex.internal.p101b.SimpleQueue
        public void clear() {
            this.f9756e = true;
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            this.f9754c = true;
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.f9754c;
        }
    }
}
