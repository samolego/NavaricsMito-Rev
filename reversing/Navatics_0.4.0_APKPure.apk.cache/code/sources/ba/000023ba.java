package io.reactivex;

import io.reactivex.annotations.NonNull;

/* compiled from: Emitter.java */
/* renamed from: io.reactivex.f */
/* loaded from: classes2.dex */
public interface InterfaceC2845f<T> {
    void onComplete();

    void onError(@NonNull Throwable th);

    void onNext(@NonNull T t);
}