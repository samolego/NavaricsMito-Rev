package io.reactivex;

import io.reactivex.annotations.NonNull;

/* compiled from: CompletableEmitter.java */
/* renamed from: io.reactivex.b */
/* loaded from: classes2.dex */
public interface InterfaceC2823b {
    void onComplete();

    void onError(@NonNull Throwable th);

    boolean tryOnError(@NonNull Throwable th);
}