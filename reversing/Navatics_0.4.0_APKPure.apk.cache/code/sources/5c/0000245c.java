package io.reactivex;

import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;

/* compiled from: SingleObserver.java */
/* renamed from: io.reactivex.r */
/* loaded from: classes2.dex */
public interface InterfaceC2904r<T> {
    void onError(@NonNull Throwable th);

    void onSubscribe(@NonNull Disposable disposable);
}