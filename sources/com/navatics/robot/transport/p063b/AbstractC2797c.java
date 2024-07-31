package com.navatics.robot.transport.p063b;

import com.navatics.robot.transport.p063b.NvObserverExecutor;
import org.apache.log4j.C3044k;

/* renamed from: com.navatics.robot.transport.b.c */
/* loaded from: classes.dex */
public abstract class NvAbstractObservable<T> implements NvObservable<T> {

    /* renamed from: a */
    private static final C3044k f6510a = C3044k.m1564a(NvAbstractObservable.class);

    /* renamed from: g */
    T f6511g;

    /* renamed from: h */
    NvObserver<T> f6512h;

    /* renamed from: j */
    NvObserverExecutor f6514j;

    /* renamed from: l */
    Throwable f6516l;

    /* renamed from: m */
    transient boolean f6517m;

    /* renamed from: n */
    boolean f6518n;

    /* renamed from: o */
    NvAbstractObservable<T>.C2115a f6519o = new C2115a();

    /* renamed from: p */
    NvAbstractObservable<T>.C2116b f6520p = new C2116b();

    /* renamed from: q */
    int f6521q = 0;

    /* renamed from: r */
    int f6522r = 0;

    /* renamed from: i */
    NvAction f6513i = NvReactive.m6293b();

    /* renamed from: k */
    NvExceptionHandler f6515k = NvReactive.m6291c();

    public static /* synthetic */ void lambda$k4Qq9znDozalbB6BGyvzuJbrq5U(NvAbstractObservable nvAbstractObservable, Object obj) {
        nvAbstractObservable.m6316c(obj);
    }

    /* renamed from: lambda$rf7Hk1XPR35n4ve-tZTYcH-NZnQ */
    public static /* synthetic */ void m13122lambda$rf7Hk1XPR35n4vetZTYcHNZnQ(NvAbstractObservable nvAbstractObservable) {
        nvAbstractObservable.m6319b();
    }

    /* renamed from: g */
    protected void mo6289g() {
    }

    /* compiled from: NvAbstractObservable.java */
    /* renamed from: com.navatics.robot.transport.b.c$a */
    /* loaded from: classes.dex */
    public class C2115a implements NvObserverExecutor.InterfaceC2117a {
        C2115a() {
            NvAbstractObservable.this = r1;
        }

        @Override // com.navatics.robot.transport.p063b.NvObserverExecutor.InterfaceC2117a
        /* renamed from: a */
        public void mo6301a() {
            synchronized (NvAbstractObservable.this) {
                NvAbstractObservable.this.f6522r++;
                NvAbstractObservable.this.notifyAll();
            }
        }

        @Override // com.navatics.robot.transport.p063b.NvObserverExecutor.InterfaceC2117a
        /* renamed from: a */
        public void mo6300a(Throwable th) {
            NvAbstractObservable.this.m6317b(th);
        }
    }

    /* compiled from: NvAbstractObservable.java */
    /* renamed from: com.navatics.robot.transport.b.c$b */
    /* loaded from: classes.dex */
    public class C2116b implements NvObserverExecutor.InterfaceC2118b {
        C2116b() {
            NvAbstractObservable.this = r1;
        }

        @Override // com.navatics.robot.transport.p063b.NvObserverExecutor.InterfaceC2118b
        /* renamed from: a */
        public void mo6299a() {
            NvAbstractObservable.this.m6326a();
        }
    }

    public NvAbstractObservable() {
        mo6289g();
    }

    /* renamed from: a */
    public <E> NvObservable<E> m6323a(NvFunction1<? super T, ? extends E> nvFunction1) {
        return NvReactive.m6296a(this, nvFunction1);
    }

    @Override // com.navatics.robot.transport.p063b.NvObservable
    /* renamed from: a */
    public NvObservable<T> mo6314a(NvExceptionHandler nvExceptionHandler) {
        return NvReactive.m6297a(this, nvExceptionHandler);
    }

    @Override // com.navatics.robot.transport.p063b.NvObservable
    /* renamed from: a */
    public NvObservable<T> mo6311a(NvObserverExecutor nvObserverExecutor) {
        this.f6514j = nvObserverExecutor;
        return this;
    }

    /* renamed from: a */
    public void m6324a(NvAction nvAction) {
        m6322a(NvReactive.m6298a(), nvAction);
    }

    /* renamed from: a */
    public void m6322a(NvObserver<T> nvObserver, NvAction nvAction) {
        mo6313a(nvObserver, nvAction, (NvExceptionHandler) null);
    }

    @Override // com.navatics.robot.transport.p063b.NvObservable
    /* renamed from: a */
    public void mo6312a(NvObserver<T> nvObserver, NvExceptionHandler nvExceptionHandler) {
        mo6313a(nvObserver, NvReactive.m6293b(), nvExceptionHandler);
    }

    @Override // com.navatics.robot.transport.p063b.NvObservable
    /* renamed from: a */
    public void mo6313a(NvObserver<T> nvObserver, NvAction nvAction, NvExceptionHandler nvExceptionHandler) {
        if (this.f6512h != null) {
            return;
        }
        this.f6512h = nvObserver;
        if (nvAction != null) {
            this.f6513i = nvAction;
        }
        if (nvExceptionHandler != null) {
            this.f6515k = nvExceptionHandler;
        }
        Throwable th = this.f6516l;
        if (th != null) {
            m6320a(th, true, true);
        } else {
            T t = this.f6511g;
            if (t != null) {
                try {
                    nvObserver.onNext(t);
                } catch (Exception e) {
                    m6320a((Throwable) e, false, false);
                    return;
                }
            }
        }
        synchronized (this) {
            if (this.f6518n && this.f6516l == null) {
                try {
                    this.f6513i.run();
                } catch (Exception e2) {
                    m6320a((Throwable) e2, true, false);
                }
            }
        }
    }

    /* renamed from: a */
    public void m6321a(T t) {
        if (this.f6517m) {
            return;
        }
        synchronized (this) {
            if (!this.f6518n && this.f6511g == null) {
                this.f6511g = t;
                this.f6521q++;
                NvObserver<T> nvObserver = this.f6512h;
                if (nvObserver != null) {
                    try {
                        if (this.f6514j == null) {
                            NvObserverExecutor.m6308a().mo6305a((NvObserver<NvObserver<T>>) this.f6512h, (NvObserver<T>) t, (NvObserverExecutor.InterfaceC2117a) this.f6519o);
                        } else {
                            this.f6514j.mo6305a((NvObserver<NvObserver<T>>) nvObserver, (NvObserver<T>) t, (NvObserverExecutor.InterfaceC2117a) this.f6519o);
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                        m6317b((Throwable) e);
                    }
                }
            }
        }
    }

    @Override // com.navatics.robot.transport.p063b.NvObservable
    /* renamed from: h */
    public T mo6309h() {
        return this.f6511g;
    }

    @Override // com.navatics.robot.transport.p063b.NvObservable
    /* renamed from: f */
    public boolean mo6310f() {
        return this.f6518n;
    }

    /* renamed from: b */
    public void m6317b(Throwable th) {
        m6320a(th, false, false);
    }

    /* renamed from: a */
    private void m6320a(Throwable th, boolean z, boolean z2) {
        if (this.f6517m) {
            C3044k c3044k = f6510a;
            c3044k.mo1511a((Object) ("clz : " + getClass().getSimpleName() + " already cleanUp"));
            return;
        }
        synchronized (this) {
            if (this.f6518n && !z) {
                C3044k c3044k2 = f6510a;
                c3044k2.mo1504b((Object) ("already finish or already has a error : finish true error " + this.f6516l));
            } else if (this.f6516l != null && !z2) {
                C3044k c3044k3 = f6510a;
                c3044k3.mo1504b((Object) ("already has a error : " + this.f6516l + " error " + this.f6516l));
            } else {
                this.f6516l = th;
                if (th == null) {
                    throw new RuntimeException("notifyErrorInternal with null exception ?!");
                }
                NvObserverExecutor nvObserverExecutor = this.f6514j;
                if (nvObserverExecutor == null) {
                    NvObserverExecutor.m6308a().mo6306a(this.f6515k, this.f6516l, new NvObserverExecutor.InterfaceC2119c() { // from class: com.navatics.robot.transport.b.-$$Lambda$c$S1TOLGjmqkiV9K8NX7kyGp3RL_k
                        @Override // com.navatics.robot.transport.p063b.NvObserverExecutor.InterfaceC2119c
                        public final void onFinish() {
                            NvAbstractObservable.this.m6326a();
                        }
                    });
                } else {
                    nvObserverExecutor.mo6306a(this.f6515k, this.f6516l, new NvObserverExecutor.InterfaceC2119c() { // from class: com.navatics.robot.transport.b.-$$Lambda$c$S1TOLGjmqkiV9K8NX7kyGp3RL_k
                        @Override // com.navatics.robot.transport.p063b.NvObserverExecutor.InterfaceC2119c
                        public final void onFinish() {
                            NvAbstractObservable.this.m6326a();
                        }
                    });
                }
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: c */
    public /* synthetic */ void m6316c(Object obj) {
        m6321a((NvAbstractObservable<T>) obj);
    }

    /* renamed from: b */
    public void m6318b(final T t) {
        NvObserverExecutor.m6302c().mo6304a(new Runnable() { // from class: com.navatics.robot.transport.b.-$$Lambda$c$k4Qq9znDozalbB6BGyvzuJbrq5U
            @Override // java.lang.Runnable
            public final void run() {
                NvAbstractObservable.lambda$k4Qq9znDozalbB6BGyvzuJbrq5U(NvAbstractObservable.this, t);
            }
        });
    }

    /* renamed from: i */
    public void m6315i() {
        if (this.f6518n || this.f6516l != null || this.f6512h == null) {
            return;
        }
        NvObserverExecutor.m6302c().mo6304a(new Runnable() { // from class: com.navatics.robot.transport.b.-$$Lambda$c$rf7Hk1XPR35n4ve-tZTYcH-NZnQ
            @Override // java.lang.Runnable
            public final void run() {
                NvAbstractObservable.m13122lambda$rf7Hk1XPR35n4vetZTYcHNZnQ(NvAbstractObservable.this);
            }
        });
    }

    /* renamed from: b */
    public /* synthetic */ void m6319b() {
        synchronized (this) {
            if (this.f6518n) {
                return;
            }
            while (this.f6521q > 0 && this.f6521q > this.f6522r) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            this.f6518n = true;
            try {
                if (this.f6514j == null) {
                    NvObserverExecutor.m6308a().mo6307a(this.f6513i, this.f6515k, this.f6520p);
                } else {
                    this.f6514j.mo6307a(this.f6513i, this.f6515k, this.f6520p);
                }
            } catch (Exception e2) {
                m6320a((Throwable) e2, true, false);
            }
        }
    }

    /* renamed from: a */
    public synchronized void m6326a() {
        this.f6512h = null;
        this.f6515k = null;
        this.f6511g = null;
        this.f6516l = null;
        this.f6514j = null;
        this.f6517m = true;
    }
}
