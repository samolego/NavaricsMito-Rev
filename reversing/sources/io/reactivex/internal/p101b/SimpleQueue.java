package io.reactivex.internal.p101b;

import io.reactivex.annotations.NonNull;
import io.reactivex.annotations.Nullable;

/* renamed from: io.reactivex.internal.b.e */
/* loaded from: classes2.dex */
public interface SimpleQueue<T> {
    void clear();

    boolean isEmpty();

    boolean offer(@NonNull T t);

    @Nullable
    T poll() throws Exception;
}
