package hu.akarnokd.rxjava2.consumers;

import io.reactivex.InterfaceC2900o;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.p096b.Consumer;
import io.reactivex.p096b.InterfaceC2848a;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class DisposableAutoReleaseObserver<T> extends AbstractDisposableAutoRelease implements InterfaceC2900o<T> {
    private static final long serialVersionUID = 8924480688481408726L;
    final Consumer<? super T> onNext;

    /* JADX INFO: Access modifiers changed from: package-private */
    public DisposableAutoReleaseObserver(CompositeDisposable compositeDisposable, Consumer<? super T> consumer, Consumer<? super Throwable> consumer2, InterfaceC2848a interfaceC2848a) {
        super(compositeDisposable, consumer2, interfaceC2848a);
        this.onNext = consumer;
    }

    @Override // io.reactivex.InterfaceC2900o
    public void onNext(T t) {
        if (get() != DisposableHelper.DISPOSED) {
            try {
                this.onNext.accept(t);
            } catch (Throwable th) {
                Exceptions.m3207b(th);
                ((Disposable) get()).dispose();
                onError(th);
            }
        }
    }
}
