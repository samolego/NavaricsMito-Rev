package io.reactivex;

import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;

/* compiled from: MaybeObserver.java */
/* renamed from: io.reactivex.i */
/* loaded from: classes2.dex */
public interface InterfaceC2848i<T> {
    void onComplete();

    void onError(@NonNull Throwable th);

    void onSubscribe(@NonNull Disposable disposable);
}