package retrofit2.adapter.rxjava2;

import io.reactivex.InterfaceC2900o;
import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.p098d.RxJavaPlugins;
import retrofit2.C3204l;

/* renamed from: retrofit2.adapter.rxjava2.e */
/* loaded from: classes2.dex */
final class ResultObservable<T> extends Observable<C3167d<T>> {

    /* renamed from: a */
    private final Observable<C3204l<T>> f12598a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ResultObservable(Observable<C3204l<T>> observable) {
        this.f12598a = observable;
    }

    @Override // io.reactivex.Observable
    /* renamed from: a */
    protected void mo158a(InterfaceC2900o<? super C3167d<T>> interfaceC2900o) {
        this.f12598a.subscribe(new C3168a(interfaceC2900o));
    }

    /* compiled from: ResultObservable.java */
    /* renamed from: retrofit2.adapter.rxjava2.e$a */
    /* loaded from: classes2.dex */
    private static class C3168a<R> implements InterfaceC2900o<C3204l<R>> {

        /* renamed from: a */
        private final InterfaceC2900o<? super C3167d<R>> f12599a;

        C3168a(InterfaceC2900o<? super C3167d<R>> interfaceC2900o) {
            this.f12599a = interfaceC2900o;
        }

        @Override // io.reactivex.InterfaceC2900o
        public void onSubscribe(Disposable disposable) {
            this.f12599a.onSubscribe(disposable);
        }

        @Override // io.reactivex.InterfaceC2900o
        /* renamed from: a */
        public void onNext(C3204l<R> c3204l) {
            this.f12599a.onNext(C3167d.m159a(c3204l));
        }

        @Override // io.reactivex.InterfaceC2900o
        public void onError(Throwable th) {
            try {
                this.f12599a.onNext(C3167d.m160a(th));
                this.f12599a.onComplete();
            } catch (Throwable th2) {
                try {
                    this.f12599a.onError(th2);
                } catch (Throwable th3) {
                    Exceptions.m3207b(th3);
                    RxJavaPlugins.m3233a(new CompositeException(th2, th3));
                }
            }
        }

        @Override // io.reactivex.InterfaceC2900o
        public void onComplete() {
            this.f12599a.onComplete();
        }
    }
}
