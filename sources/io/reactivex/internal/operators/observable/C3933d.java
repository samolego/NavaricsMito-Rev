package io.reactivex.internal.operators.observable;

import io.reactivex.InterfaceC2900o;
import io.reactivex.Observable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.p100a.ObjectHelper;
import java.util.concurrent.Callable;

/* renamed from: io.reactivex.internal.operators.observable.d */
/* loaded from: classes2.dex */
public final class ObservableError<T> extends Observable<T> {

    /* renamed from: a */
    final Callable<? extends Throwable> f9744a;

    public ObservableError(Callable<? extends Throwable> callable) {
        this.f9744a = callable;
    }

    @Override // io.reactivex.Observable
    /* renamed from: a */
    public void mo158a(InterfaceC2900o<? super T> interfaceC2900o) {
        try {
            th = (Throwable) ObjectHelper.m3188a(this.f9744a.call(), "Callable returned null throwable. Null values are generally not allowed in 2.x operators and sources.");
        } catch (Throwable th) {
            th = th;
            Exceptions.m3207b(th);
        }
        EmptyDisposable.error(th, interfaceC2900o);
    }
}
