package hu.akarnokd.rxjava2.consumers;

import io.reactivex.CompletableObserver;
import io.reactivex.MaybeObserver;
import io.reactivex.SingleObserver;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.p096b.Consumer;
import io.reactivex.p096b.InterfaceC2848a;
import io.reactivex.p098d.RxJavaPlugins;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class DisposableAutoReleaseMultiObserver<T> extends AbstractDisposableAutoRelease implements CompletableObserver, MaybeObserver<T>, SingleObserver<T> {
    private static final long serialVersionUID = 8924480688481408726L;
    final Consumer<? super T> onSuccess;

    /* JADX INFO: Access modifiers changed from: package-private */
    public DisposableAutoReleaseMultiObserver(CompositeDisposable compositeDisposable, Consumer<? super T> consumer, Consumer<? super Throwable> consumer2, InterfaceC2848a interfaceC2848a) {
        super(compositeDisposable, consumer2, interfaceC2848a);
        this.onSuccess = consumer;
    }

    public void onSuccess(T t) {
        if (get() != DisposableHelper.DISPOSED) {
            lazySet(DisposableHelper.DISPOSED);
            try {
                this.onSuccess.accept(t);
            } catch (Throwable th) {
                Exceptions.m3207b(th);
                RxJavaPlugins.m3233a(th);
            }
        }
    }
}
