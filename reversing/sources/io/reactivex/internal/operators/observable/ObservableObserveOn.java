package io.reactivex.internal.operators.observable;

import io.reactivex.AbstractC2901p;
import io.reactivex.InterfaceC2900o;
import io.reactivex.ObservableSource;
import io.reactivex.annotations.Nullable;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.observers.BasicIntQueueDisposable;
import io.reactivex.internal.p101b.QueueDisposable;
import io.reactivex.internal.p101b.SimpleQueue;
import io.reactivex.internal.queue.SpscLinkedArrayQueue;
import io.reactivex.internal.schedulers.TrampolineScheduler;
import io.reactivex.p098d.RxJavaPlugins;

/* loaded from: classes2.dex */
public final class ObservableObserveOn<T> extends AbstractObservableWithUpstream<T, T> {

    /* renamed from: b */
    final AbstractC2901p f9713b;

    /* renamed from: c */
    final boolean f9714c;

    /* renamed from: d */
    final int f9715d;

    public ObservableObserveOn(ObservableSource<T> observableSource, AbstractC2901p abstractC2901p, boolean z, int i) {
        super(observableSource);
        this.f9713b = abstractC2901p;
        this.f9714c = z;
        this.f9715d = i;
    }

    @Override // io.reactivex.Observable
    /* renamed from: a */
    protected void mo158a(InterfaceC2900o<? super T> interfaceC2900o) {
        AbstractC2901p abstractC2901p = this.f9713b;
        if (abstractC2901p instanceof TrampolineScheduler) {
            this.f9731a.subscribe(interfaceC2900o);
            return;
        }
        this.f9731a.subscribe(new ObserveOnObserver(interfaceC2900o, abstractC2901p.mo3063a(), this.f9714c, this.f9715d));
    }

    /* loaded from: classes2.dex */
    static final class ObserveOnObserver<T> extends BasicIntQueueDisposable<T> implements InterfaceC2900o<T>, Runnable {
        private static final long serialVersionUID = 6576896619930983584L;
        final int bufferSize;
        final boolean delayError;
        volatile boolean disposed;
        volatile boolean done;
        final InterfaceC2900o<? super T> downstream;
        Throwable error;
        boolean outputFused;
        SimpleQueue<T> queue;
        int sourceMode;
        Disposable upstream;
        final AbstractC2901p.AbstractC2904c worker;

        ObserveOnObserver(InterfaceC2900o<? super T> interfaceC2900o, AbstractC2901p.AbstractC2904c abstractC2904c, boolean z, int i) {
            this.downstream = interfaceC2900o;
            this.worker = abstractC2904c;
            this.delayError = z;
            this.bufferSize = i;
        }

        @Override // io.reactivex.InterfaceC2900o
        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.upstream, disposable)) {
                this.upstream = disposable;
                if (disposable instanceof QueueDisposable) {
                    QueueDisposable queueDisposable = (QueueDisposable) disposable;
                    int requestFusion = queueDisposable.requestFusion(7);
                    if (requestFusion == 1) {
                        this.sourceMode = requestFusion;
                        this.queue = queueDisposable;
                        this.done = true;
                        this.downstream.onSubscribe(this);
                        schedule();
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
            if (this.done) {
                return;
            }
            if (this.sourceMode != 2) {
                this.queue.offer(t);
            }
            schedule();
        }

        @Override // io.reactivex.InterfaceC2900o
        public void onError(Throwable th) {
            if (this.done) {
                RxJavaPlugins.m3233a(th);
                return;
            }
            this.error = th;
            this.done = true;
            schedule();
        }

        @Override // io.reactivex.InterfaceC2900o
        public void onComplete() {
            if (this.done) {
                return;
            }
            this.done = true;
            schedule();
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            if (this.disposed) {
                return;
            }
            this.disposed = true;
            this.upstream.dispose();
            this.worker.dispose();
            if (getAndIncrement() == 0) {
                this.queue.clear();
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.disposed;
        }

        void schedule() {
            if (getAndIncrement() == 0) {
                this.worker.mo3058a(this);
            }
        }

        void drainNormal() {
            SimpleQueue<T> simpleQueue = this.queue;
            InterfaceC2900o<? super T> interfaceC2900o = this.downstream;
            int i = 1;
            while (!checkTerminated(this.done, simpleQueue.isEmpty(), interfaceC2900o)) {
                while (true) {
                    boolean z = this.done;
                    try {
                        Object obj = (T) simpleQueue.poll();
                        boolean z2 = obj == null;
                        if (checkTerminated(z, z2, interfaceC2900o)) {
                            return;
                        }
                        if (!z2) {
                            interfaceC2900o.onNext(obj);
                        } else {
                            i = addAndGet(-i);
                            if (i == 0) {
                                return;
                            }
                        }
                    } catch (Throwable th) {
                        Exceptions.m3207b(th);
                        this.disposed = true;
                        this.upstream.dispose();
                        simpleQueue.clear();
                        interfaceC2900o.onError(th);
                        this.worker.dispose();
                        return;
                    }
                }
            }
        }

        void drainFused() {
            int i = 1;
            while (!this.disposed) {
                boolean z = this.done;
                Throwable th = this.error;
                if (!this.delayError && z && th != null) {
                    this.disposed = true;
                    this.downstream.onError(th);
                    this.worker.dispose();
                    return;
                }
                this.downstream.onNext(null);
                if (z) {
                    this.disposed = true;
                    Throwable th2 = this.error;
                    if (th2 != null) {
                        this.downstream.onError(th2);
                    } else {
                        this.downstream.onComplete();
                    }
                    this.worker.dispose();
                    return;
                }
                i = addAndGet(-i);
                if (i == 0) {
                    return;
                }
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.outputFused) {
                drainFused();
            } else {
                drainNormal();
            }
        }

        boolean checkTerminated(boolean z, boolean z2, InterfaceC2900o<? super T> interfaceC2900o) {
            if (this.disposed) {
                this.queue.clear();
                return true;
            } else if (z) {
                Throwable th = this.error;
                if (this.delayError) {
                    if (z2) {
                        this.disposed = true;
                        if (th != null) {
                            interfaceC2900o.onError(th);
                        } else {
                            interfaceC2900o.onComplete();
                        }
                        this.worker.dispose();
                        return true;
                    }
                    return false;
                } else if (th != null) {
                    this.disposed = true;
                    this.queue.clear();
                    interfaceC2900o.onError(th);
                    this.worker.dispose();
                    return true;
                } else if (z2) {
                    this.disposed = true;
                    interfaceC2900o.onComplete();
                    this.worker.dispose();
                    return true;
                } else {
                    return false;
                }
            } else {
                return false;
            }
        }

        @Override // io.reactivex.internal.p101b.QueueFuseable
        public int requestFusion(int i) {
            if ((i & 2) != 0) {
                this.outputFused = true;
                return 2;
            }
            return 0;
        }

        @Override // io.reactivex.internal.p101b.SimpleQueue
        @Nullable
        public T poll() throws Exception {
            return this.queue.poll();
        }

        @Override // io.reactivex.internal.p101b.SimpleQueue
        public void clear() {
            this.queue.clear();
        }

        @Override // io.reactivex.internal.p101b.SimpleQueue
        public boolean isEmpty() {
            return this.queue.isEmpty();
        }
    }
}
