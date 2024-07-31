package io.reactivex.internal.operators.observable;

import io.reactivex.InterfaceC2900o;
import io.reactivex.Observable;
import io.reactivex.annotations.Nullable;
import io.reactivex.internal.observers.BasicQueueDisposable;
import io.reactivex.internal.p100a.ObjectHelper;

/* renamed from: io.reactivex.internal.operators.observable.e */
/* loaded from: classes2.dex */
public final class ObservableFromArray<T> extends Observable<T> {

    /* renamed from: a */
    final T[] f9745a;

    public ObservableFromArray(T[] tArr) {
        this.f9745a = tArr;
    }

    @Override // io.reactivex.Observable
    /* renamed from: a */
    public void mo158a(InterfaceC2900o<? super T> interfaceC2900o) {
        C2879a c2879a = new C2879a(interfaceC2900o, this.f9745a);
        interfaceC2900o.onSubscribe(c2879a);
        if (c2879a.f9749d) {
            return;
        }
        c2879a.m3176a();
    }

    /* compiled from: ObservableFromArray.java */
    /* renamed from: io.reactivex.internal.operators.observable.e$a */
    /* loaded from: classes2.dex */
    static final class C2879a<T> extends BasicQueueDisposable<T> {

        /* renamed from: a */
        final InterfaceC2900o<? super T> f9746a;

        /* renamed from: b */
        final T[] f9747b;

        /* renamed from: c */
        int f9748c;

        /* renamed from: d */
        boolean f9749d;

        /* renamed from: e */
        volatile boolean f9750e;

        C2879a(InterfaceC2900o<? super T> interfaceC2900o, T[] tArr) {
            this.f9746a = interfaceC2900o;
            this.f9747b = tArr;
        }

        @Override // io.reactivex.internal.p101b.QueueFuseable
        public int requestFusion(int i) {
            if ((i & 1) != 0) {
                this.f9749d = true;
                return 1;
            }
            return 0;
        }

        @Override // io.reactivex.internal.p101b.SimpleQueue
        @Nullable
        public T poll() {
            int i = this.f9748c;
            T[] tArr = this.f9747b;
            if (i != tArr.length) {
                this.f9748c = i + 1;
                return (T) ObjectHelper.m3188a((Object) tArr[i], "The array element is null");
            }
            return null;
        }

        @Override // io.reactivex.internal.p101b.SimpleQueue
        public boolean isEmpty() {
            return this.f9748c == this.f9747b.length;
        }

        @Override // io.reactivex.internal.p101b.SimpleQueue
        public void clear() {
            this.f9748c = this.f9747b.length;
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            this.f9750e = true;
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.f9750e;
        }

        /* renamed from: a */
        void m3176a() {
            T[] tArr = this.f9747b;
            int length = tArr.length;
            for (int i = 0; i < length && !isDisposed(); i++) {
                T t = tArr[i];
                if (t == null) {
                    InterfaceC2900o<? super T> interfaceC2900o = this.f9746a;
                    interfaceC2900o.onError(new NullPointerException("The " + i + "th element is null"));
                    return;
                }
                this.f9746a.onNext(t);
            }
            if (isDisposed()) {
                return;
            }
            this.f9746a.onComplete();
        }
    }
}
