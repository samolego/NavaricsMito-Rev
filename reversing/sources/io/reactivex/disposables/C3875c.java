package io.reactivex.disposables;

import io.reactivex.annotations.NonNull;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.p100a.ObjectHelper;
import io.reactivex.p096b.InterfaceC2848a;

/* renamed from: io.reactivex.disposables.c */
/* loaded from: classes2.dex */
public final class Disposables {
    @NonNull
    /* renamed from: a */
    public static Disposable m3220a(@NonNull Runnable runnable) {
        ObjectHelper.m3188a(runnable, "run is null");
        return new RunnableDisposable(runnable);
    }

    @NonNull
    /* renamed from: a */
    public static Disposable m3221a(@NonNull InterfaceC2848a interfaceC2848a) {
        ObjectHelper.m3188a(interfaceC2848a, "run is null");
        return new ActionDisposable(interfaceC2848a);
    }

    @NonNull
    /* renamed from: a */
    public static Disposable m3222a() {
        return EmptyDisposable.INSTANCE;
    }
}
