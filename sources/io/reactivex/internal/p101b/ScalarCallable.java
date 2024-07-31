package io.reactivex.internal.p101b;

import java.util.concurrent.Callable;

/* renamed from: io.reactivex.internal.b.c */
/* loaded from: classes2.dex */
public interface ScalarCallable<T> extends Callable<T> {
    @Override // java.util.concurrent.Callable
    T call();
}
