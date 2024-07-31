package io.reactivex.internal.operators.observable;

import io.reactivex.InterfaceC2900o;
import io.reactivex.ObservableSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.p100a.ObjectHelper;
import java.util.ArrayDeque;
import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes2.dex */
public final class ObservableBuffer<T, U extends Collection<? super T>> extends AbstractObservableWithUpstream<T, U> {

    /* renamed from: b */
    final int f9686b;

    /* renamed from: c */
    final int f9687c;

    /* renamed from: d */
    final Callable<U> f9688d;

    public ObservableBuffer(ObservableSource<T> observableSource, int i, int i2, Callable<U> callable) {
        super(observableSource);
        this.f9686b = i;
        this.f9687c = i2;
        this.f9688d = callable;
    }

    @Override // io.reactivex.Observable
    /* renamed from: a */
    protected void mo158a(InterfaceC2900o<? super U> interfaceC2900o) {
        int i = this.f9687c;
        int i2 = this.f9686b;
        if (i == i2) {
            C2875a c2875a = new C2875a(interfaceC2900o, i2, this.f9688d);
            if (c2875a.m3179a()) {
                this.f9731a.subscribe(c2875a);
                return;
            }
            return;
        }
        this.f9731a.subscribe(new BufferSkipObserver(interfaceC2900o, this.f9686b, this.f9687c, this.f9688d));
    }

    /* renamed from: io.reactivex.internal.operators.observable.ObservableBuffer$a */
    /* loaded from: classes2.dex */
    static final class C2875a<T, U extends Collection<? super T>> implements Disposable, InterfaceC2900o<T> {

        /* renamed from: a */
        final InterfaceC2900o<? super U> f9689a;

        /* renamed from: b */
        final int f9690b;

        /* renamed from: c */
        final Callable<U> f9691c;

        /* renamed from: d */
        U f9692d;

        /* renamed from: e */
        int f9693e;

        /* renamed from: f */
        Disposable f9694f;

        C2875a(InterfaceC2900o<? super U> interfaceC2900o, int i, Callable<U> callable) {
            this.f9689a = interfaceC2900o;
            this.f9690b = i;
            this.f9691c = callable;
        }

        /* renamed from: a */
        boolean m3179a() {
            try {
                this.f9692d = (U) ObjectHelper.m3188a(this.f9691c.call(), "Empty buffer supplied");
                return true;
            } catch (Throwable th) {
                Exceptions.m3207b(th);
                this.f9692d = null;
                Disposable disposable = this.f9694f;
                if (disposable == null) {
                    EmptyDisposable.error(th, this.f9689a);
                    return false;
                }
                disposable.dispose();
                this.f9689a.onError(th);
                return false;
            }
        }

        @Override // io.reactivex.InterfaceC2900o
        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.f9694f, disposable)) {
                this.f9694f = disposable;
                this.f9689a.onSubscribe(this);
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            this.f9694f.dispose();
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.f9694f.isDisposed();
        }

        @Override // io.reactivex.InterfaceC2900o
        public void onNext(T t) {
            U u = this.f9692d;
            if (u != null) {
                u.add(t);
                int i = this.f9693e + 1;
                this.f9693e = i;
                if (i >= this.f9690b) {
                    this.f9689a.onNext(u);
                    this.f9693e = 0;
                    m3179a();
                }
            }
        }

        @Override // io.reactivex.InterfaceC2900o
        public void onError(Throwable th) {
            this.f9692d = null;
            this.f9689a.onError(th);
        }

        @Override // io.reactivex.InterfaceC2900o
        public void onComplete() {
            U u = this.f9692d;
            if (u != null) {
                this.f9692d = null;
                if (!u.isEmpty()) {
                    this.f9689a.onNext(u);
                }
                this.f9689a.onComplete();
            }
        }
    }

    /* loaded from: classes2.dex */
    static final class BufferSkipObserver<T, U extends Collection<? super T>> extends AtomicBoolean implements Disposable, InterfaceC2900o<T> {
        private static final long serialVersionUID = -8223395059921494546L;
        final Callable<U> bufferSupplier;
        final ArrayDeque<U> buffers = new ArrayDeque<>();
        final int count;
        final InterfaceC2900o<? super U> downstream;
        long index;
        final int skip;
        Disposable upstream;

        BufferSkipObserver(InterfaceC2900o<? super U> interfaceC2900o, int i, int i2, Callable<U> callable) {
            this.downstream = interfaceC2900o;
            this.count = i;
            this.skip = i2;
            this.bufferSupplier = callable;
        }

        @Override // io.reactivex.InterfaceC2900o
        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.upstream, disposable)) {
                this.upstream = disposable;
                this.downstream.onSubscribe(this);
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            this.upstream.dispose();
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.upstream.isDisposed();
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // io.reactivex.InterfaceC2900o
        public void onNext(T t) {
            long j = this.index;
            this.index = 1 + j;
            if (j % this.skip == 0) {
                try {
                    this.buffers.offer((Collection) ObjectHelper.m3188a(this.bufferSupplier.call(), "The bufferSupplier returned a null collection. Null values are generally not allowed in 2.x operators and sources."));
                } catch (Throwable th) {
                    this.buffers.clear();
                    this.upstream.dispose();
                    this.downstream.onError(th);
                    return;
                }
            }
            Iterator<U> it = this.buffers.iterator();
            while (it.hasNext()) {
                U next = it.next();
                next.add(t);
                if (this.count <= next.size()) {
                    it.remove();
                    this.downstream.onNext(next);
                }
            }
        }

        @Override // io.reactivex.InterfaceC2900o
        public void onError(Throwable th) {
            this.buffers.clear();
            this.downstream.onError(th);
        }

        @Override // io.reactivex.InterfaceC2900o
        public void onComplete() {
            while (!this.buffers.isEmpty()) {
                this.downstream.onNext(this.buffers.poll());
            }
            this.downstream.onComplete();
        }
    }
}
