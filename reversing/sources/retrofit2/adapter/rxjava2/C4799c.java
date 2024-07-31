package retrofit2.adapter.rxjava2;

import io.reactivex.InterfaceC2900o;
import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.p098d.RxJavaPlugins;
import retrofit2.C3204l;
import retrofit2.InterfaceC3169b;

/* renamed from: retrofit2.adapter.rxjava2.c */
/* loaded from: classes2.dex */
final class CallExecuteObservable<T> extends Observable<C3204l<T>> {

    /* renamed from: a */
    private final InterfaceC3169b<T> f12593a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public CallExecuteObservable(InterfaceC3169b<T> interfaceC3169b) {
        this.f12593a = interfaceC3169b;
    }

    @Override // io.reactivex.Observable
    /* renamed from: a */
    protected void mo158a(InterfaceC2900o<? super C3204l<T>> interfaceC2900o) {
        boolean z;
        InterfaceC3169b<T> mo137d = this.f12593a.mo137d();
        C3166a c3166a = new C3166a(mo137d);
        interfaceC2900o.onSubscribe(c3166a);
        try {
            C3204l<T> mo142a = mo137d.mo142a();
            if (!c3166a.isDisposed()) {
                interfaceC2900o.onNext(mo142a);
            }
            if (c3166a.isDisposed()) {
                return;
            }
            try {
                interfaceC2900o.onComplete();
            } catch (Throwable th) {
                th = th;
                z = true;
                Exceptions.m3207b(th);
                if (z) {
                    RxJavaPlugins.m3233a(th);
                } else if (c3166a.isDisposed()) {
                } else {
                    try {
                        interfaceC2900o.onError(th);
                    } catch (Throwable th2) {
                        Exceptions.m3207b(th2);
                        RxJavaPlugins.m3233a(new CompositeException(th, th2));
                    }
                }
            }
        } catch (Throwable th3) {
            th = th3;
            z = false;
        }
    }

    /* compiled from: CallExecuteObservable.java */
    /* renamed from: retrofit2.adapter.rxjava2.c$a */
    /* loaded from: classes2.dex */
    private static final class C3166a implements Disposable {

        /* renamed from: a */
        private final InterfaceC3169b<?> f12594a;

        /* renamed from: b */
        private volatile boolean f12595b;

        C3166a(InterfaceC3169b<?> interfaceC3169b) {
            this.f12594a = interfaceC3169b;
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            this.f12595b = true;
            this.f12594a.mo139b();
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.f12595b;
        }
    }
}
