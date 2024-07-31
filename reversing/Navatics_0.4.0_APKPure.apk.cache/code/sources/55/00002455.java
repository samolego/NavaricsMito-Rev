package io.reactivex;

import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;

/* compiled from: Observer.java */
/* renamed from: io.reactivex.o */
/* loaded from: classes2.dex */
public interface InterfaceC2901o<T> {
    void onComplete();

    void onError(@NonNull Throwable th);

    void onNext(@NonNull T t);

    void onSubscribe(@NonNull Disposable disposable);
}