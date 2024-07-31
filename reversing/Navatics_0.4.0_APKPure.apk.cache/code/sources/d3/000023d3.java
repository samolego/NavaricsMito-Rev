package io.reactivex.internal.p090b;

import io.reactivex.annotations.NonNull;
import io.reactivex.annotations.Nullable;

/* compiled from: SimpleQueue.java */
/* renamed from: io.reactivex.internal.b.e */
/* loaded from: classes2.dex */
public interface InterfaceC2855e<T> {
    void clear();

    boolean isEmpty();

    boolean offer(@NonNull T t);

    @Nullable
    T poll() throws Exception;
}