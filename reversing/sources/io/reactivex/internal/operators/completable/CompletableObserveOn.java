package io.reactivex.internal.operators.completable;

import io.reactivex.AbstractC2901p;
import io.reactivex.Completable;
import io.reactivex.CompletableObserver;
import io.reactivex.CompletableSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes2.dex */
public final class CompletableObserveOn extends Completable {

    /* renamed from: a */
    final CompletableSource f9682a;

    /* renamed from: b */
    final AbstractC2901p f9683b;

    public CompletableObserveOn(CompletableSource completableSource, AbstractC2901p abstractC2901p) {
        this.f9682a = completableSource;
        this.f9683b = abstractC2901p;
    }

    @Override // io.reactivex.Completable
    /* renamed from: b */
    protected void mo3174b(CompletableObserver completableObserver) {
        this.f9682a.mo3219a(new ObserveOnCompletableObserver(completableObserver, this.f9683b));
    }

    /* loaded from: classes2.dex */
    static final class ObserveOnCompletableObserver extends AtomicReference<Disposable> implements CompletableObserver, Disposable, Runnable {
        private static final long serialVersionUID = 8571289934935992137L;
        final CompletableObserver downstream;
        Throwable error;
        final AbstractC2901p scheduler;

        ObserveOnCompletableObserver(CompletableObserver completableObserver, AbstractC2901p abstractC2901p) {
            this.downstream = completableObserver;
            this.scheduler = abstractC2901p;
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            DisposableHelper.dispose(this);
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return DisposableHelper.isDisposed(get());
        }

        @Override // io.reactivex.CompletableObserver
        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.setOnce(this, disposable)) {
                this.downstream.onSubscribe(this);
            }
        }

        @Override // io.reactivex.CompletableObserver
        public void onError(Throwable th) {
            this.error = th;
            DisposableHelper.replace(this, this.scheduler.mo3062a(this));
        }

        @Override // io.reactivex.CompletableObserver
        public void onComplete() {
            DisposableHelper.replace(this, this.scheduler.mo3062a(this));
        }

        @Override // java.lang.Runnable
        public void run() {
            Throwable th = this.error;
            if (th != null) {
                this.error = null;
                this.downstream.onError(th);
                return;
            }
            this.downstream.onComplete();
        }
    }
}
