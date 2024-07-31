package io.reactivex.internal.observers;

import io.reactivex.internal.p101b.QueueDisposable;

/* renamed from: io.reactivex.internal.observers.b */
/* loaded from: classes2.dex */
public abstract class BasicQueueDisposable<T> implements QueueDisposable<T> {
    @Override // io.reactivex.internal.p101b.SimpleQueue
    public final boolean offer(T t) {
        throw new UnsupportedOperationException("Should not be called");
    }
}
