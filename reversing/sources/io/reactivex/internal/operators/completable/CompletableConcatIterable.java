package io.reactivex.internal.operators.completable;

import io.reactivex.Completable;
import io.reactivex.CompletableObserver;
import io.reactivex.CompletableSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.disposables.SequentialDisposable;
import io.reactivex.internal.p100a.ObjectHelper;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes2.dex */
public final class CompletableConcatIterable extends Completable {

    /* renamed from: a */
    final Iterable<? extends CompletableSource> f9679a;

    public CompletableConcatIterable(Iterable<? extends CompletableSource> iterable) {
        this.f9679a = iterable;
    }

    @Override // io.reactivex.Completable
    /* renamed from: b */
    public void mo3174b(CompletableObserver completableObserver) {
        try {
            ConcatInnerObserver concatInnerObserver = new ConcatInnerObserver(completableObserver, (Iterator) ObjectHelper.m3188a(this.f9679a.iterator(), "The iterator returned is null"));
            completableObserver.onSubscribe(concatInnerObserver.f9680sd);
            concatInnerObserver.next();
        } catch (Throwable th) {
            Exceptions.m3207b(th);
            EmptyDisposable.error(th, completableObserver);
        }
    }

    /* loaded from: classes2.dex */
    static final class ConcatInnerObserver extends AtomicInteger implements CompletableObserver {
        private static final long serialVersionUID = -7965400327305809232L;
        final CompletableObserver downstream;

        /* renamed from: sd */
        final SequentialDisposable f9680sd = new SequentialDisposable();
        final Iterator<? extends CompletableSource> sources;

        ConcatInnerObserver(CompletableObserver completableObserver, Iterator<? extends CompletableSource> it) {
            this.downstream = completableObserver;
            this.sources = it;
        }

        @Override // io.reactivex.CompletableObserver
        public void onSubscribe(Disposable disposable) {
            this.f9680sd.replace(disposable);
        }

        @Override // io.reactivex.CompletableObserver
        public void onError(Throwable th) {
            this.downstream.onError(th);
        }

        @Override // io.reactivex.CompletableObserver
        public void onComplete() {
            next();
        }

        void next() {
            if (!this.f9680sd.isDisposed() && getAndIncrement() == 0) {
                Iterator<? extends CompletableSource> it = this.sources;
                while (!this.f9680sd.isDisposed()) {
                    try {
                        if (!it.hasNext()) {
                            this.downstream.onComplete();
                            return;
                        }
                        try {
                            ((CompletableSource) ObjectHelper.m3188a(it.next(), "The CompletableSource returned is null")).mo3219a(this);
                            if (decrementAndGet() == 0) {
                                return;
                            }
                        } catch (Throwable th) {
                            Exceptions.m3207b(th);
                            this.downstream.onError(th);
                            return;
                        }
                    } catch (Throwable th2) {
                        Exceptions.m3207b(th2);
                        this.downstream.onError(th2);
                        return;
                    }
                }
            }
        }
    }
}
