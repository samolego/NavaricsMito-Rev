package io.reactivex.internal.operators.observable;

import io.reactivex.InterfaceC2900o;
import io.reactivex.Observable;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.p101b.ScalarCallable;

/* renamed from: io.reactivex.internal.operators.observable.c */
/* loaded from: classes2.dex */
public final class ObservableEmpty extends Observable<Object> implements ScalarCallable<Object> {

    /* renamed from: a */
    public static final Observable<Object> f9743a = new ObservableEmpty();

    @Override // io.reactivex.internal.p101b.ScalarCallable, java.util.concurrent.Callable
    public Object call() {
        return null;
    }

    private ObservableEmpty() {
    }

    @Override // io.reactivex.Observable
    /* renamed from: a */
    protected void mo158a(InterfaceC2900o<? super Object> interfaceC2900o) {
        EmptyDisposable.complete(interfaceC2900o);
    }
}
