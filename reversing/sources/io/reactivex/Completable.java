package io.reactivex;

import io.reactivex.annotations.CheckReturnValue;
import io.reactivex.annotations.SchedulerSupport;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.observers.CallbackCompletableObserver;
import io.reactivex.internal.operators.completable.CompletableConcatIterable;
import io.reactivex.internal.operators.completable.CompletableCreate;
import io.reactivex.internal.operators.completable.CompletableObserveOn;
import io.reactivex.internal.operators.completable.CompletableSubscribeOn;
import io.reactivex.internal.p100a.ObjectHelper;
import io.reactivex.p096b.Consumer;
import io.reactivex.p096b.InterfaceC2848a;
import io.reactivex.p098d.RxJavaPlugins;

/* renamed from: io.reactivex.a */
/* loaded from: classes2.dex */
public abstract class Completable implements CompletableSource {
    /* renamed from: b */
    protected abstract void mo3174b(CompletableObserver completableObserver);

    @SchedulerSupport
    @CheckReturnValue
    /* renamed from: a */
    public static Completable m3258a(Iterable<? extends CompletableSource> iterable) {
        ObjectHelper.m3188a(iterable, "sources is null");
        return RxJavaPlugins.m3246a(new CompletableConcatIterable(iterable));
    }

    @SchedulerSupport
    @CheckReturnValue
    /* renamed from: a */
    public static Completable m3260a(CompletableOnSubscribe completableOnSubscribe) {
        ObjectHelper.m3188a(completableOnSubscribe, "source is null");
        return RxJavaPlugins.m3246a(new CompletableCreate(completableOnSubscribe));
    }

    /* renamed from: a */
    private static NullPointerException m3257a(Throwable th) {
        NullPointerException nullPointerException = new NullPointerException("Actually not, but can't pass out an exception otherwise...");
        nullPointerException.initCause(th);
        return nullPointerException;
    }

    @SchedulerSupport
    @CheckReturnValue
    /* renamed from: a */
    public final Completable m3259a(AbstractC2901p abstractC2901p) {
        ObjectHelper.m3188a(abstractC2901p, "scheduler is null");
        return RxJavaPlugins.m3246a(new CompletableObserveOn(this, abstractC2901p));
    }

    @Override // io.reactivex.CompletableSource
    @SchedulerSupport
    /* renamed from: a */
    public final void mo3219a(CompletableObserver completableObserver) {
        ObjectHelper.m3188a(completableObserver, "s is null");
        try {
            CompletableObserver m3245a = RxJavaPlugins.m3245a(this, completableObserver);
            ObjectHelper.m3188a(m3245a, "The RxJavaPlugins.onSubscribe hook returned a null CompletableObserver. Please check the handler provided to RxJavaPlugins.setOnCompletableSubscribe for invalid null returns. Further reading: https://github.com/ReactiveX/RxJava/wiki/Plugins");
            mo3174b(m3245a);
        } catch (NullPointerException e) {
            throw e;
        } catch (Throwable th) {
            Exceptions.m3207b(th);
            RxJavaPlugins.m3233a(th);
            throw m3257a(th);
        }
    }

    @SchedulerSupport
    @CheckReturnValue
    /* renamed from: a */
    public final Disposable m3261a(InterfaceC2848a interfaceC2848a, Consumer<? super Throwable> consumer) {
        ObjectHelper.m3188a(consumer, "onError is null");
        ObjectHelper.m3188a(interfaceC2848a, "onComplete is null");
        CallbackCompletableObserver callbackCompletableObserver = new CallbackCompletableObserver(consumer, interfaceC2848a);
        mo3219a(callbackCompletableObserver);
        return callbackCompletableObserver;
    }

    @SchedulerSupport
    @CheckReturnValue
    /* renamed from: b */
    public final Completable m3256b(AbstractC2901p abstractC2901p) {
        ObjectHelper.m3188a(abstractC2901p, "scheduler is null");
        return RxJavaPlugins.m3246a(new CompletableSubscribeOn(this, abstractC2901p));
    }
}
