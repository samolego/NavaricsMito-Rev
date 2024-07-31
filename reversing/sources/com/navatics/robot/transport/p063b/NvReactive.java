package com.navatics.robot.transport.p063b;

/* renamed from: com.navatics.robot.transport.b.j */
/* loaded from: classes.dex */
public class NvReactive {
    /* renamed from: a */
    public static /* synthetic */ void m6295a(Object obj) throws Exception {
    }

    /* renamed from: b */
    public static /* synthetic */ void m6292b(Throwable th) {
    }

    /* renamed from: d */
    public static /* synthetic */ void m6290d() throws Exception {
    }

    public static /* synthetic */ void lambda$1cmpsxz3jNZ8A2nPblXDyrFLTsw() {
        m6290d();
    }

    public static /* synthetic */ void lambda$TP80APmF33BQn1us9en2l0h0Fyc(Throwable th) {
        m6292b(th);
    }

    public static /* synthetic */ void lambda$zjMCQmVV6dtje46efA9bZYw9GMk(Object obj) {
        m6295a(obj);
    }

    /* renamed from: a */
    public static <T> NvObserver<T> m6298a() {
        return new NvObserver() { // from class: com.navatics.robot.transport.b.-$$Lambda$j$zjMCQmVV6dtje46efA9bZYw9GMk
            @Override // com.navatics.robot.transport.p063b.NvObserver
            public final void onNext(Object obj) {
                NvReactive.lambda$zjMCQmVV6dtje46efA9bZYw9GMk(obj);
            }
        };
    }

    /* renamed from: b */
    public static NvAction m6293b() {
        return new NvAction() { // from class: com.navatics.robot.transport.b.-$$Lambda$j$1cmpsxz3jNZ8A2nPblXDyrFLTsw
            @Override // com.navatics.robot.transport.p063b.NvAction
            public final void run() {
                NvReactive.lambda$1cmpsxz3jNZ8A2nPblXDyrFLTsw();
            }
        };
    }

    /* renamed from: c */
    public static NvExceptionHandler m6291c() {
        return new NvExceptionHandler() { // from class: com.navatics.robot.transport.b.-$$Lambda$j$TP80APmF33BQn1us9en2l0h0Fyc
            @Override // com.navatics.robot.transport.p063b.NvExceptionHandler
            public final void onError(Throwable th) {
                NvReactive.lambda$TP80APmF33BQn1us9en2l0h0Fyc(th);
            }
        };
    }

    /* renamed from: a */
    public static <T> NvObservable<T> m6294a(final Throwable th) {
        return new NvAbstractObservable<T>() { // from class: com.navatics.robot.transport.b.j.1
            @Override // com.navatics.robot.transport.p063b.NvAbstractObservable
            /* renamed from: g */
            protected void mo6289g() {
                this.f6516l = th;
            }
        };
    }

    /* renamed from: a */
    public static <T, E> NvObservable<E> m6296a(NvObservable<T> nvObservable, NvFunction1<? super T, ? extends E> nvFunction1) {
        C2122b c2122b = new C2122b(nvObservable, nvFunction1);
        if (nvObservable.mo6310f()) {
            try {
                c2122b.onNext(nvObservable.mo6309h());
            } catch (Exception e) {
                c2122b.m6317b((Throwable) e);
            }
        }
        return c2122b;
    }

    /* renamed from: a */
    public static <T> NvObservable<T> m6297a(NvObservable<T> nvObservable, NvExceptionHandler nvExceptionHandler) {
        return new C2121a(nvObservable, nvExceptionHandler);
    }

    /* compiled from: NvReactive.java */
    /* renamed from: com.navatics.robot.transport.b.j$a */
    /* loaded from: classes.dex */
    public static class C2121a<T> extends NvAbstractObservable<T> implements NvAction, NvExceptionHandler, NvObserver<T> {

        /* renamed from: a */
        NvObservable<T> f6529a;

        /* renamed from: b */
        NvExceptionHandler f6530b;

        C2121a(NvObservable<T> nvObservable, NvExceptionHandler nvExceptionHandler) {
            this.f6529a = nvObservable;
            this.f6530b = nvExceptionHandler;
            nvObservable.mo6313a(this, this, this);
        }

        @Override // com.navatics.robot.transport.p063b.NvExceptionHandler
        public void onError(Throwable th) {
            try {
                this.f6530b.onError(th);
            } catch (Exception e) {
                e.printStackTrace();
            }
            m6317b(th);
        }

        @Override // com.navatics.robot.transport.p063b.NvObserver
        public void onNext(T t) throws Exception {
            m6321a((C2121a<T>) t);
        }

        @Override // com.navatics.robot.transport.p063b.NvAction
        public void run() throws Exception {
            m6315i();
        }
    }

    /* compiled from: NvReactive.java */
    /* renamed from: com.navatics.robot.transport.b.j$b */
    /* loaded from: classes.dex */
    public static class C2122b<T, E> extends NvAbstractObservable<E> implements NvAction, NvExceptionHandler, NvObserver<T> {

        /* renamed from: a */
        NvObservable<T> f6531a;

        /* renamed from: b */
        NvFunction1<? super T, ? extends E> f6532b;

        C2122b(NvObservable<T> nvObservable, NvFunction1<? super T, ? extends E> nvFunction1) {
            this.f6531a = nvObservable;
            this.f6532b = nvFunction1;
            nvObservable.mo6313a(this, this, this);
        }

        @Override // com.navatics.robot.transport.p063b.NvExceptionHandler
        public void onError(Throwable th) {
            m6317b(th);
        }

        @Override // com.navatics.robot.transport.p063b.NvObserver
        public void onNext(T t) throws Exception {
            m6321a((C2122b<T, E>) this.f6532b.apply(t));
        }

        @Override // com.navatics.robot.transport.p063b.NvAction
        public void run() {
            m6315i();
        }
    }
}
