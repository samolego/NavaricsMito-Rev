package io.reactivex;

import io.reactivex.annotations.NonNull;

/* renamed from: io.reactivex.n */
/* loaded from: classes2.dex */
public interface ObservableTransformer<Upstream, Downstream> {
    @NonNull
    ObservableSource<Downstream> apply(@NonNull Observable<Upstream> observable);
}
