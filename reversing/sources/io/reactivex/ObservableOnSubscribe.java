package io.reactivex;

import io.reactivex.annotations.NonNull;

/* renamed from: io.reactivex.l */
/* loaded from: classes2.dex */
public interface ObservableOnSubscribe<T> {
    void subscribe(@NonNull ObservableEmitter<T> observableEmitter) throws Exception;
}
