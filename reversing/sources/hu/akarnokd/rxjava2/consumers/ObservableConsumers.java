package hu.akarnokd.rxjava2.consumers;

import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.p100a.Functions;
import io.reactivex.internal.p100a.ObjectHelper;
import io.reactivex.p096b.Consumer;
import io.reactivex.p096b.InterfaceC2848a;

/* renamed from: hu.akarnokd.rxjava2.consumers.b */
/* loaded from: classes2.dex */
public final class ObservableConsumers {
    /* renamed from: a */
    public static <T> Disposable m3493a(Observable<T> observable, CompositeDisposable compositeDisposable, Consumer<? super T> consumer) {
        ObjectHelper.m3188a(observable, "source is null");
        ObjectHelper.m3188a(compositeDisposable, "composite is null");
        ObjectHelper.m3188a(consumer, "onNext is null");
        DisposableAutoReleaseObserver disposableAutoReleaseObserver = new DisposableAutoReleaseObserver(compositeDisposable, consumer, null, Functions.f9650c);
        compositeDisposable.mo3187a(disposableAutoReleaseObserver);
        observable.subscribe(disposableAutoReleaseObserver);
        return disposableAutoReleaseObserver;
    }

    /* renamed from: a */
    public static <T> Disposable m3492a(Observable<T> observable, CompositeDisposable compositeDisposable, Consumer<? super T> consumer, Consumer<? super Throwable> consumer2, InterfaceC2848a interfaceC2848a) {
        ObjectHelper.m3188a(observable, "source is null");
        ObjectHelper.m3188a(compositeDisposable, "composite is null");
        ObjectHelper.m3188a(consumer, "onNext is null");
        ObjectHelper.m3188a(consumer2, "onError is null");
        ObjectHelper.m3188a(interfaceC2848a, "onComplete is null");
        DisposableAutoReleaseObserver disposableAutoReleaseObserver = new DisposableAutoReleaseObserver(compositeDisposable, consumer, consumer2, interfaceC2848a);
        compositeDisposable.mo3187a(disposableAutoReleaseObserver);
        observable.subscribe(disposableAutoReleaseObserver);
        return disposableAutoReleaseObserver;
    }
}
