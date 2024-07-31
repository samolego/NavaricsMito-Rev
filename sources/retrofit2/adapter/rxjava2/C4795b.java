package retrofit2.adapter.rxjava2;

import io.reactivex.InterfaceC2900o;
import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.p098d.RxJavaPlugins;
import retrofit2.C3204l;
import retrofit2.InterfaceC3169b;
import retrofit2.InterfaceC3171d;

/* renamed from: retrofit2.adapter.rxjava2.b */
/* loaded from: classes2.dex */
final class CallEnqueueObservable<T> extends Observable<C3204l<T>> {

    /* renamed from: a */
    private final InterfaceC3169b<T> f12588a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public CallEnqueueObservable(InterfaceC3169b<T> interfaceC3169b) {
        this.f12588a = interfaceC3169b;
    }

    @Override // io.reactivex.Observable
    /* renamed from: a */
    protected void mo158a(InterfaceC2900o<? super C3204l<T>> interfaceC2900o) {
        InterfaceC3169b<T> mo137d = this.f12588a.mo137d();
        C3165a c3165a = new C3165a(mo137d, interfaceC2900o);
        interfaceC2900o.onSubscribe(c3165a);
        mo137d.mo140a(c3165a);
    }

    /* compiled from: CallEnqueueObservable.java */
    /* renamed from: retrofit2.adapter.rxjava2.b$a */
    /* loaded from: classes2.dex */
    private static final class C3165a<T> implements Disposable, InterfaceC3171d<T> {

        /* renamed from: a */
        boolean f12589a = false;

        /* renamed from: b */
        private final InterfaceC3169b<?> f12590b;

        /* renamed from: c */
        private final InterfaceC2900o<? super C3204l<T>> f12591c;

        /* renamed from: d */
        private volatile boolean f12592d;

        C3165a(InterfaceC3169b<?> interfaceC3169b, InterfaceC2900o<? super C3204l<T>> interfaceC2900o) {
            this.f12590b = interfaceC3169b;
            this.f12591c = interfaceC2900o;
        }

        @Override // retrofit2.InterfaceC3171d
        /* renamed from: a */
        public void mo143a(InterfaceC3169b<T> interfaceC3169b, C3204l<T> c3204l) {
            if (this.f12592d) {
                return;
            }
            try {
                this.f12591c.onNext(c3204l);
                if (this.f12592d) {
                    return;
                }
                this.f12589a = true;
                this.f12591c.onComplete();
            } catch (Throwable th) {
                if (this.f12589a) {
                    RxJavaPlugins.m3233a(th);
                } else if (this.f12592d) {
                } else {
                    try {
                        this.f12591c.onError(th);
                    } catch (Throwable th2) {
                        Exceptions.m3207b(th2);
                        RxJavaPlugins.m3233a(new CompositeException(th, th2));
                    }
                }
            }
        }

        @Override // retrofit2.InterfaceC3171d
        /* renamed from: a */
        public void mo144a(InterfaceC3169b<T> interfaceC3169b, Throwable th) {
            if (interfaceC3169b.mo138c()) {
                return;
            }
            try {
                this.f12591c.onError(th);
            } catch (Throwable th2) {
                Exceptions.m3207b(th2);
                RxJavaPlugins.m3233a(new CompositeException(th, th2));
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            this.f12592d = true;
            this.f12590b.mo139b();
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.f12592d;
        }
    }
}
