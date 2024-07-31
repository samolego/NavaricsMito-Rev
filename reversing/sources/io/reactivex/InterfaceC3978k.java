package io.reactivex;

import io.reactivex.annotations.Nullable;
import io.reactivex.disposables.Disposable;
import io.reactivex.p096b.Cancellable;

/* renamed from: io.reactivex.k */
/* loaded from: classes2.dex */
public interface ObservableEmitter<T> extends Emitter<T> {
    boolean isDisposed();

    void setCancellable(@Nullable Cancellable cancellable);

    void setDisposable(@Nullable Disposable disposable);
}
