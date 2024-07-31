package io.reactivex.internal.operators.observable;

import io.reactivex.InterfaceC2900o;
import io.reactivex.ObservableSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.p100a.ObjectHelper;
import io.reactivex.internal.p101b.QueueDisposable;
import io.reactivex.internal.p101b.SimpleQueue;
import io.reactivex.internal.queue.SpscLinkedArrayQueue;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.internal.util.ErrorMode;
import io.reactivex.p096b.Function;
import io.reactivex.p097c.SerializedObserver;
import io.reactivex.p098d.RxJavaPlugins;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes2.dex */
public final class ObservableConcatMap<T, U> extends AbstractObservableWithUpstream<T, U> {

    /* renamed from: b */
    final Function<? super T, ? extends ObservableSource<? extends U>> f9700b;

    /* renamed from: c */
    final int f9701c;

    /* renamed from: d */
    final ErrorMode f9702d;

    public ObservableConcatMap(ObservableSource<T> observableSource, Function<? super T, ? extends ObservableSource<? extends U>> function, int i, ErrorMode errorMode) {
        super(observableSource);
        this.f9700b = function;
        this.f9702d = errorMode;
        this.f9701c = Math.max(8, i);
    }

    @Override // io.reactivex.Observable
    /* renamed from: a */
    public void mo158a(InterfaceC2900o<? super U> interfaceC2900o) {
        if (ObservableScalarXMap.m3178a(this.f9731a, interfaceC2900o, this.f9700b)) {
            return;
        }
        if (this.f9702d == ErrorMode.IMMEDIATE) {
            this.f9731a.subscribe(new SourceObserver(new SerializedObserver(interfaceC2900o), this.f9700b, this.f9701c));
        } else {
            this.f9731a.subscribe(new ConcatMapDelayErrorObserver(interfaceC2900o, this.f9700b, this.f9701c, this.f9702d == ErrorMode.END));
        }
    }

    /* loaded from: classes2.dex */
    static final class SourceObserver<T, U> extends AtomicInteger implements Disposable, InterfaceC2900o<T> {
        private static final long serialVersionUID = 8828587559905699186L;
        volatile boolean active;
        final int bufferSize;
        volatile boolean disposed;
        volatile boolean done;
        final InterfaceC2900o<? super U> downstream;
        int fusionMode;
        final InnerObserver<U> inner;
        final Function<? super T, ? extends ObservableSource<? extends U>> mapper;
        SimpleQueue<T> queue;
        Disposable upstream;

        SourceObserver(InterfaceC2900o<? super U> interfaceC2900o, Function<? super T, ? extends ObservableSource<? extends U>> function, int i) {
            this.downstream = interfaceC2900o;
            this.mapper = function;
            this.bufferSize = i;
            this.inner = new InnerObserver<>(interfaceC2900o, this);
        }

        @Override // io.reactivex.InterfaceC2900o
        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.upstream, disposable)) {
                this.upstream = disposable;
                if (disposable instanceof QueueDisposable) {
                    QueueDisposable queueDisposable = (QueueDisposable) disposable;
                    int requestFusion = queueDisposable.requestFusion(3);
                    if (requestFusion == 1) {
                        this.fusionMode = requestFusion;
                        this.queue = queueDisposable;
                        this.done = true;
                        this.downstream.onSubscribe(this);
                        drain();
                        return;
                    } else if (requestFusion == 2) {
                        this.fusionMode = requestFusion;
                        this.queue = queueDisposable;
                        this.downstream.onSubscribe(this);
                        return;
                    }
                }
                this.queue = new SpscLinkedArrayQueue(this.bufferSize);
                this.downstream.onSubscribe(this);
            }
        }

        @Override // io.reactivex.InterfaceC2900o
        public void onNext(T t) {
            if (this.done) {
                return;
            }
            if (this.fusionMode == 0) {
                this.queue.offer(t);
            }
            drain();
        }

        @Override // io.reactivex.InterfaceC2900o
        public void onError(Throwable th) {
            if (this.done) {
                RxJavaPlugins.m3233a(th);
                return;
            }
            this.done = true;
            dispose();
            this.downstream.onError(th);
        }

        @Override // io.reactivex.InterfaceC2900o
        public void onComplete() {
            if (this.done) {
                return;
            }
            this.done = true;
            drain();
        }

        void innerComplete() {
            this.active = false;
            drain();
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.disposed;
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            this.disposed = true;
            this.inner.dispose();
            this.upstream.dispose();
            if (getAndIncrement() == 0) {
                this.queue.clear();
            }
        }

        void drain() {
            if (getAndIncrement() != 0) {
                return;
            }
            while (!this.disposed) {
                if (!this.active) {
                    boolean z = this.done;
                    try {
                        T poll = this.queue.poll();
                        boolean z2 = poll == null;
                        if (z && z2) {
                            this.disposed = true;
                            this.downstream.onComplete();
                            return;
                        } else if (!z2) {
                            try {
                                ObservableSource observableSource = (ObservableSource) ObjectHelper.m3188a(this.mapper.apply(poll), "The mapper returned a null ObservableSource");
                                this.active = true;
                                observableSource.subscribe(this.inner);
                            } catch (Throwable th) {
                                Exceptions.m3207b(th);
                                dispose();
                                this.queue.clear();
                                this.downstream.onError(th);
                                return;
                            }
                        }
                    } catch (Throwable th2) {
                        Exceptions.m3207b(th2);
                        dispose();
                        this.queue.clear();
                        this.downstream.onError(th2);
                        return;
                    }
                }
                if (decrementAndGet() == 0) {
                    return;
                }
            }
            this.queue.clear();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes2.dex */
        public static final class InnerObserver<U> extends AtomicReference<Disposable> implements InterfaceC2900o<U> {
            private static final long serialVersionUID = -7449079488798789337L;
            final InterfaceC2900o<? super U> downstream;
            final SourceObserver<?, ?> parent;

            InnerObserver(InterfaceC2900o<? super U> interfaceC2900o, SourceObserver<?, ?> sourceObserver) {
                this.downstream = interfaceC2900o;
                this.parent = sourceObserver;
            }

            @Override // io.reactivex.InterfaceC2900o
            public void onSubscribe(Disposable disposable) {
                DisposableHelper.set(this, disposable);
            }

            @Override // io.reactivex.InterfaceC2900o
            public void onNext(U u) {
                this.downstream.onNext(u);
            }

            @Override // io.reactivex.InterfaceC2900o
            public void onError(Throwable th) {
                this.parent.dispose();
                this.downstream.onError(th);
            }

            @Override // io.reactivex.InterfaceC2900o
            public void onComplete() {
                this.parent.innerComplete();
            }

            void dispose() {
                DisposableHelper.dispose(this);
            }
        }
    }

    /* loaded from: classes2.dex */
    static final class ConcatMapDelayErrorObserver<T, R> extends AtomicInteger implements Disposable, InterfaceC2900o<T> {
        private static final long serialVersionUID = -6951100001833242599L;
        volatile boolean active;
        final int bufferSize;
        volatile boolean cancelled;
        volatile boolean done;
        final InterfaceC2900o<? super R> downstream;
        final AtomicThrowable error = new AtomicThrowable();
        final Function<? super T, ? extends ObservableSource<? extends R>> mapper;
        final DelayErrorInnerObserver<R> observer;
        SimpleQueue<T> queue;
        int sourceMode;
        final boolean tillTheEnd;
        Disposable upstream;

        ConcatMapDelayErrorObserver(InterfaceC2900o<? super R> interfaceC2900o, Function<? super T, ? extends ObservableSource<? extends R>> function, int i, boolean z) {
            this.downstream = interfaceC2900o;
            this.mapper = function;
            this.bufferSize = i;
            this.tillTheEnd = z;
            this.observer = new DelayErrorInnerObserver<>(interfaceC2900o, this);
        }

        @Override // io.reactivex.InterfaceC2900o
        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.upstream, disposable)) {
                this.upstream = disposable;
                if (disposable instanceof QueueDisposable) {
                    QueueDisposable queueDisposable = (QueueDisposable) disposable;
                    int requestFusion = queueDisposable.requestFusion(3);
                    if (requestFusion == 1) {
                        this.sourceMode = requestFusion;
                        this.queue = queueDisposable;
                        this.done = true;
                        this.downstream.onSubscribe(this);
                        drain();
                        return;
                    } else if (requestFusion == 2) {
                        this.sourceMode = requestFusion;
                        this.queue = queueDisposable;
                        this.downstream.onSubscribe(this);
                        return;
                    }
                }
                this.queue = new SpscLinkedArrayQueue(this.bufferSize);
                this.downstream.onSubscribe(this);
            }
        }

        @Override // io.reactivex.InterfaceC2900o
        public void onNext(T t) {
            if (this.sourceMode == 0) {
                this.queue.offer(t);
            }
            drain();
        }

        @Override // io.reactivex.InterfaceC2900o
        public void onError(Throwable th) {
            if (this.error.addThrowable(th)) {
                this.done = true;
                drain();
                return;
            }
            RxJavaPlugins.m3233a(th);
        }

        @Override // io.reactivex.InterfaceC2900o
        public void onComplete() {
            this.done = true;
            drain();
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.cancelled;
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            this.cancelled = true;
            this.upstream.dispose();
            this.observer.dispose();
        }

        void drain() {
            if (getAndIncrement() != 0) {
                return;
            }
            InterfaceC2900o<? super R> interfaceC2900o = this.downstream;
            SimpleQueue<T> simpleQueue = this.queue;
            AtomicThrowable atomicThrowable = this.error;
            while (true) {
                if (!this.active) {
                    if (this.cancelled) {
                        simpleQueue.clear();
                        return;
                    } else if (!this.tillTheEnd && atomicThrowable.get() != null) {
                        simpleQueue.clear();
                        this.cancelled = true;
                        interfaceC2900o.onError(atomicThrowable.terminate());
                        return;
                    } else {
                        boolean z = this.done;
                        try {
                            T poll = simpleQueue.poll();
                            boolean z2 = poll == null;
                            if (z && z2) {
                                this.cancelled = true;
                                Throwable terminate = atomicThrowable.terminate();
                                if (terminate != null) {
                                    interfaceC2900o.onError(terminate);
                                    return;
                                } else {
                                    interfaceC2900o.onComplete();
                                    return;
                                }
                            } else if (!z2) {
                                try {
                                    ObservableSource observableSource = (ObservableSource) ObjectHelper.m3188a(this.mapper.apply(poll), "The mapper returned a null ObservableSource");
                                    if (observableSource instanceof Callable) {
                                        try {
                                            Object obj = (Object) ((Callable) observableSource).call();
                                            if (obj != 0 && !this.cancelled) {
                                                interfaceC2900o.onNext(obj);
                                            }
                                        } catch (Throwable th) {
                                            Exceptions.m3207b(th);
                                            atomicThrowable.addThrowable(th);
                                        }
                                    } else {
                                        this.active = true;
                                        observableSource.subscribe(this.observer);
                                    }
                                } catch (Throwable th2) {
                                    Exceptions.m3207b(th2);
                                    this.cancelled = true;
                                    this.upstream.dispose();
                                    simpleQueue.clear();
                                    atomicThrowable.addThrowable(th2);
                                    interfaceC2900o.onError(atomicThrowable.terminate());
                                    return;
                                }
                            }
                        } catch (Throwable th3) {
                            Exceptions.m3207b(th3);
                            this.cancelled = true;
                            this.upstream.dispose();
                            atomicThrowable.addThrowable(th3);
                            interfaceC2900o.onError(atomicThrowable.terminate());
                            return;
                        }
                    }
                }
                if (decrementAndGet() == 0) {
                    return;
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes2.dex */
        public static final class DelayErrorInnerObserver<R> extends AtomicReference<Disposable> implements InterfaceC2900o<R> {
            private static final long serialVersionUID = 2620149119579502636L;
            final InterfaceC2900o<? super R> downstream;
            final ConcatMapDelayErrorObserver<?, R> parent;

            DelayErrorInnerObserver(InterfaceC2900o<? super R> interfaceC2900o, ConcatMapDelayErrorObserver<?, R> concatMapDelayErrorObserver) {
                this.downstream = interfaceC2900o;
                this.parent = concatMapDelayErrorObserver;
            }

            @Override // io.reactivex.InterfaceC2900o
            public void onSubscribe(Disposable disposable) {
                DisposableHelper.replace(this, disposable);
            }

            @Override // io.reactivex.InterfaceC2900o
            public void onNext(R r) {
                this.downstream.onNext(r);
            }

            @Override // io.reactivex.InterfaceC2900o
            public void onError(Throwable th) {
                ConcatMapDelayErrorObserver<?, R> concatMapDelayErrorObserver = this.parent;
                if (concatMapDelayErrorObserver.error.addThrowable(th)) {
                    if (!concatMapDelayErrorObserver.tillTheEnd) {
                        concatMapDelayErrorObserver.upstream.dispose();
                    }
                    concatMapDelayErrorObserver.active = false;
                    concatMapDelayErrorObserver.drain();
                    return;
                }
                RxJavaPlugins.m3233a(th);
            }

            @Override // io.reactivex.InterfaceC2900o
            public void onComplete() {
                ConcatMapDelayErrorObserver<?, R> concatMapDelayErrorObserver = this.parent;
                concatMapDelayErrorObserver.active = false;
                concatMapDelayErrorObserver.drain();
            }

            void dispose() {
                DisposableHelper.dispose(this);
            }
        }
    }
}
