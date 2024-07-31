package io.reactivex;

import io.reactivex.annotations.NonNull;

/* renamed from: io.reactivex.b */
/* loaded from: classes2.dex */
public interface CompletableEmitter {
    void onComplete();

    void onError(@NonNull Throwable th);

    boolean tryOnError(@NonNull Throwable th);
}
