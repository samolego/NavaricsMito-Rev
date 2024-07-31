package retrofit2.adapter.rxjava2;

import io.reactivex.InterfaceC2900o;
import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.p098d.RxJavaPlugins;
import retrofit2.C3204l;

/* renamed from: retrofit2.adapter.rxjava2.a */
/* loaded from: classes2.dex */
final class BodyObservable<T> extends Observable<T> {

    /* renamed from: a */
    private final Observable<C3204l<T>> f12585a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public BodyObservable(Observable<C3204l<T>> observable) {
        this.f12585a = observable;
    }

    @Override // io.reactivex.Observable
    /* renamed from: a */
    protected void mo158a(InterfaceC2900o<? super T> interfaceC2900o) {
        this.f12585a.subscribe(new C3164a(interfaceC2900o));
    }

    /* compiled from: BodyObservable.java */
    /* renamed from: retrofit2.adapter.rxjava2.a$a */
    /* loaded from: classes2.dex */
    private static class C3164a<R> implements InterfaceC2900o<C3204l<R>> {

        /* renamed from: a */
        private final InterfaceC2900o<? super R> f12586a;

        /* renamed from: b */
        private boolean f12587b;

        C3164a(InterfaceC2900o<? super R> interfaceC2900o) {
            this.f12586a = interfaceC2900o;
        }

        @Override // io.reactivex.InterfaceC2900o
        public void onSubscribe(Disposable disposable) {
            this.f12586a.onSubscribe(disposable);
        }

        @Override // io.reactivex.InterfaceC2900o
        /* renamed from: a */
        public void onNext(C3204l<R> c3204l) {
            if (c3204l.m68d()) {
                this.f12586a.onNext(c3204l.m67e());
                return;
            }
            this.f12587b = true;
            HttpException httpException = new HttpException(c3204l);
            try {
                this.f12586a.onError(httpException);
            } catch (Throwable th) {
                Exceptions.m3207b(th);
                RxJavaPlugins.m3233a(new CompositeException(httpException, th));
            }
        }

        @Override // io.reactivex.InterfaceC2900o
        public void onComplete() {
            if (this.f12587b) {
                return;
            }
            this.f12586a.onComplete();
        }

        @Override // io.reactivex.InterfaceC2900o
        public void onError(Throwable th) {
            if (!this.f12587b) {
                this.f12586a.onError(th);
                return;
            }
            AssertionError assertionError = new AssertionError("This should never happen! Report as a bug with the full stacktrace.");
            assertionError.initCause(th);
            RxJavaPlugins.m3233a(assertionError);
        }
    }
}
