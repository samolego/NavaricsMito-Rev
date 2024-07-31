package hu.akarnokd.rxjava2.consumers;

import io.reactivex.Completable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.p100a.Functions;
import io.reactivex.internal.p100a.ObjectHelper;
import io.reactivex.p096b.Consumer;
import io.reactivex.p096b.InterfaceC2848a;

/* renamed from: hu.akarnokd.rxjava2.consumers.a */
/* loaded from: classes2.dex */
public final class CompletableConsumers {
    /* renamed from: a */
    public static Disposable m3494a(Completable completable, CompositeDisposable compositeDisposable, InterfaceC2848a interfaceC2848a, Consumer<? super Throwable> consumer) {
        ObjectHelper.m3188a(completable, "source is null");
        ObjectHelper.m3188a(compositeDisposable, "composite is null");
        ObjectHelper.m3188a(interfaceC2848a, "onSuccess is null");
        ObjectHelper.m3188a(consumer, "onError is null");
        DisposableAutoReleaseMultiObserver disposableAutoReleaseMultiObserver = new DisposableAutoReleaseMultiObserver(compositeDisposable, Functions.m3198b(), consumer, interfaceC2848a);
        compositeDisposable.mo3187a(disposableAutoReleaseMultiObserver);
        completable.mo3219a(disposableAutoReleaseMultiObserver);
        return disposableAutoReleaseMultiObserver;
    }
}
