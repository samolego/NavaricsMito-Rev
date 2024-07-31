package io.reactivex.internal.operators.observable;

import io.reactivex.InterfaceC2900o;
import io.reactivex.ObservableSource;
import io.reactivex.annotations.Nullable;
import io.reactivex.internal.observers.BasicFuseableObserver;
import io.reactivex.internal.p100a.ObjectHelper;
import io.reactivex.p096b.Function;

/* renamed from: io.reactivex.internal.operators.observable.j */
/* loaded from: classes2.dex */
public final class ObservableMap<T, U> extends AbstractObservableWithUpstream<T, U> {

    /* renamed from: b */
    final Function<? super T, ? extends U> f9763b;

    public ObservableMap(ObservableSource<T> observableSource, Function<? super T, ? extends U> function) {
        super(observableSource);
        this.f9763b = function;
    }

    @Override // io.reactivex.Observable
    /* renamed from: a */
    public void mo158a(InterfaceC2900o<? super U> interfaceC2900o) {
        this.f9731a.subscribe(new C2882a(interfaceC2900o, this.f9763b));
    }

    /* compiled from: ObservableMap.java */
    /* renamed from: io.reactivex.internal.operators.observable.j$a */
    /* loaded from: classes2.dex */
    static final class C2882a<T, U> extends BasicFuseableObserver<T, U> {

        /* renamed from: f */
        final Function<? super T, ? extends U> f9764f;

        C2882a(InterfaceC2900o<? super U> interfaceC2900o, Function<? super T, ? extends U> function) {
            super(interfaceC2900o);
            this.f9764f = function;
        }

        @Override // io.reactivex.InterfaceC2900o
        public void onNext(T t) {
            if (this.f9670d) {
                return;
            }
            if (this.f9671e != 0) {
                this.f9667a.onNext(null);
                return;
            }
            try {
                this.f9667a.onNext(ObjectHelper.m3188a(this.f9764f.apply(t), "The mapper function returned a null value."));
            } catch (Throwable th) {
                m3181a(th);
            }
        }

        @Override // io.reactivex.internal.p101b.QueueFuseable
        public int requestFusion(int i) {
            return m3182a(i);
        }

        @Override // io.reactivex.internal.p101b.SimpleQueue
        @Nullable
        public U poll() throws Exception {
            T poll = this.f9669c.poll();
            if (poll != null) {
                return (U) ObjectHelper.m3188a(this.f9764f.apply(poll), "The mapper function returned a null value.");
            }
            return null;
        }
    }
}
