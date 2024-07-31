package hu.akarnokd.rxjava2.consumers;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.exceptions.OnErrorNotImplementedException;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.p096b.Consumer;
import io.reactivex.p096b.InterfaceC2848a;
import io.reactivex.p098d.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes2.dex */
abstract class AbstractDisposableAutoRelease extends AtomicReference<Disposable> implements Disposable {
    private static final long serialVersionUID = 8924480688481408726L;
    final AtomicReference<CompositeDisposable> composite;
    final InterfaceC2848a onComplete;
    final Consumer<? super Throwable> onError;

    /* JADX INFO: Access modifiers changed from: package-private */
    public AbstractDisposableAutoRelease(CompositeDisposable compositeDisposable, Consumer<? super Throwable> consumer, InterfaceC2848a interfaceC2848a) {
        this.onError = consumer;
        this.onComplete = interfaceC2848a;
        this.composite = new AtomicReference<>(compositeDisposable);
    }

    public final void onError(Throwable th) {
        if (get() != DisposableHelper.DISPOSED) {
            lazySet(DisposableHelper.DISPOSED);
            Consumer<? super Throwable> consumer = this.onError;
            if (consumer != null) {
                try {
                    consumer.accept(th);
                } catch (Throwable th2) {
                    Exceptions.m3207b(th2);
                    RxJavaPlugins.m3233a(new CompositeException(th, th2));
                }
            } else {
                RxJavaPlugins.m3233a(new OnErrorNotImplementedException(th));
            }
        } else {
            RxJavaPlugins.m3233a(th);
        }
        removeSelf();
    }

    public final void onComplete() {
        if (get() != DisposableHelper.DISPOSED) {
            lazySet(DisposableHelper.DISPOSED);
            try {
                this.onComplete.run();
            } catch (Throwable th) {
                Exceptions.m3207b(th);
                RxJavaPlugins.m3233a(th);
            }
        }
        removeSelf();
    }

    @Override // io.reactivex.disposables.Disposable
    public final void dispose() {
        DisposableHelper.dispose(this);
        removeSelf();
    }

    final void removeSelf() {
        CompositeDisposable andSet = this.composite.getAndSet(null);
        if (andSet != null) {
            andSet.mo3184c(this);
        }
    }

    @Override // io.reactivex.disposables.Disposable
    public final boolean isDisposed() {
        return DisposableHelper.isDisposed(get());
    }

    public final void onSubscribe(Disposable disposable) {
        DisposableHelper.setOnce(this, disposable);
    }

    public final boolean hasCustomOnError() {
        return this.onError != null;
    }
}
