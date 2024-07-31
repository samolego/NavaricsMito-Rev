package io.reactivex.internal.observers;

import io.reactivex.InterfaceC2900o;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.p100a.Functions;
import io.reactivex.p096b.Consumer;
import io.reactivex.p096b.InterfaceC2848a;
import io.reactivex.p098d.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes2.dex */
public final class LambdaObserver<T> extends AtomicReference<Disposable> implements Disposable, InterfaceC2900o<T> {
    private static final long serialVersionUID = -7251123623727029452L;
    final InterfaceC2848a onComplete;
    final Consumer<? super Throwable> onError;
    final Consumer<? super T> onNext;
    final Consumer<? super Disposable> onSubscribe;

    public LambdaObserver(Consumer<? super T> consumer, Consumer<? super Throwable> consumer2, InterfaceC2848a interfaceC2848a, Consumer<? super Disposable> consumer3) {
        this.onNext = consumer;
        this.onError = consumer2;
        this.onComplete = interfaceC2848a;
        this.onSubscribe = consumer3;
    }

    @Override // io.reactivex.InterfaceC2900o
    public void onSubscribe(Disposable disposable) {
        if (DisposableHelper.setOnce(this, disposable)) {
            try {
                this.onSubscribe.accept(this);
            } catch (Throwable th) {
                Exceptions.m3207b(th);
                disposable.dispose();
                onError(th);
            }
        }
    }

    @Override // io.reactivex.InterfaceC2900o
    public void onNext(T t) {
        if (isDisposed()) {
            return;
        }
        try {
            this.onNext.accept(t);
        } catch (Throwable th) {
            Exceptions.m3207b(th);
            get().dispose();
            onError(th);
        }
    }

    @Override // io.reactivex.InterfaceC2900o
    public void onError(Throwable th) {
        if (!isDisposed()) {
            lazySet(DisposableHelper.DISPOSED);
            try {
                this.onError.accept(th);
                return;
            } catch (Throwable th2) {
                Exceptions.m3207b(th2);
                RxJavaPlugins.m3233a(new CompositeException(th, th2));
                return;
            }
        }
        RxJavaPlugins.m3233a(th);
    }

    @Override // io.reactivex.InterfaceC2900o
    public void onComplete() {
        if (isDisposed()) {
            return;
        }
        lazySet(DisposableHelper.DISPOSED);
        try {
            this.onComplete.run();
        } catch (Throwable th) {
            Exceptions.m3207b(th);
            RxJavaPlugins.m3233a(th);
        }
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
        return this.onError != Functions.f9653f;
    }
}
