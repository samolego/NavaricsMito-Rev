package io.reactivex.internal.observers;

import io.reactivex.CompletableObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.exceptions.OnErrorNotImplementedException;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.p096b.Consumer;
import io.reactivex.p096b.InterfaceC2848a;
import io.reactivex.p098d.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes2.dex */
public final class CallbackCompletableObserver extends AtomicReference<Disposable> implements Consumer<Throwable>, CompletableObserver, Disposable {
    private static final long serialVersionUID = -4361286194466301354L;
    final InterfaceC2848a onComplete;
    final Consumer<? super Throwable> onError;

    public CallbackCompletableObserver(InterfaceC2848a interfaceC2848a) {
        this.onError = this;
        this.onComplete = interfaceC2848a;
    }

    public CallbackCompletableObserver(Consumer<? super Throwable> consumer, InterfaceC2848a interfaceC2848a) {
        this.onError = consumer;
        this.onComplete = interfaceC2848a;
    }

    @Override // io.reactivex.p096b.Consumer
    public void accept(Throwable th) {
        RxJavaPlugins.m3233a(new OnErrorNotImplementedException(th));
    }

    @Override // io.reactivex.CompletableObserver
    public void onComplete() {
        try {
            this.onComplete.run();
        } catch (Throwable th) {
            Exceptions.m3207b(th);
            RxJavaPlugins.m3233a(th);
        }
        lazySet(DisposableHelper.DISPOSED);
    }

    @Override // io.reactivex.CompletableObserver
    public void onError(Throwable th) {
        try {
            this.onError.accept(th);
        } catch (Throwable th2) {
            Exceptions.m3207b(th2);
            RxJavaPlugins.m3233a(th2);
        }
        lazySet(DisposableHelper.DISPOSED);
    }

    @Override // io.reactivex.CompletableObserver
    public void onSubscribe(Disposable disposable) {
        DisposableHelper.setOnce(this, disposable);
    }

    @Override // io.reactivex.disposables.Disposable
    public void dispose() {
        DisposableHelper.dispose(this);
    }

    @Override // io.reactivex.disposables.Disposable
    public boolean isDisposed() {
        return get() == DisposableHelper.DISPOSED;
    }

    public boolean hasCustomOnError() {
        return this.onError != this;
    }
}
