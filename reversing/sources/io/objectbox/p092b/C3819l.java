package io.objectbox.p092b;

import io.objectbox.annotation.apihint.Internal;
import java.util.concurrent.ExecutorService;
import javax.annotation.Nullable;

/* renamed from: io.objectbox.b.l */
/* loaded from: classes2.dex */
public class SubscriptionBuilder<T> {

    /* renamed from: a */
    private final DataPublisher<T> f9476a;

    /* renamed from: b */
    private final Object f9477b;

    /* renamed from: c */
    private final ExecutorService f9478c;

    /* renamed from: d */
    private DataObserver<T> f9479d;

    /* renamed from: e */
    private boolean f9480e;

    /* renamed from: f */
    private boolean f9481f;

    /* renamed from: g */
    private boolean f9482g;

    /* renamed from: h */
    private DataTransformer<T, Object> f9483h;

    /* renamed from: i */
    private Scheduler f9484i;

    /* renamed from: j */
    private ErrorObserver f9485j;

    /* renamed from: k */
    private DataSubscriptionList f9486k;

    @Internal
    public SubscriptionBuilder(DataPublisher<T> dataPublisher, @Nullable Object obj, ExecutorService executorService) {
        this.f9476a = dataPublisher;
        this.f9477b = obj;
        this.f9478c = executorService;
    }

    /* renamed from: a */
    public SubscriptionBuilder<T> m3364a() {
        this.f9480e = true;
        return this;
    }

    /* renamed from: b */
    public SubscriptionBuilder<T> m3360b() {
        this.f9482g = true;
        return this;
    }

    /* renamed from: a */
    public SubscriptionBuilder<T> m3362a(Scheduler scheduler) {
        if (this.f9484i != null) {
            throw new IllegalStateException("Only one scheduler allowed");
        }
        this.f9484i = scheduler;
        return this;
    }

    /* renamed from: a */
    public DataSubscription m3363a(DataObserver<T> dataObserver) {
        WeakDataObserver weakDataObserver;
        if (this.f9480e) {
            weakDataObserver = new WeakDataObserver(dataObserver);
            dataObserver = weakDataObserver;
        } else {
            weakDataObserver = null;
        }
        this.f9479d = dataObserver;
        DataSubscriptionImpl dataSubscriptionImpl = new DataSubscriptionImpl(this.f9476a, this.f9477b, dataObserver);
        if (weakDataObserver != null) {
            weakDataObserver.m3347a(dataSubscriptionImpl);
        }
        DataSubscriptionList dataSubscriptionList = this.f9486k;
        if (dataSubscriptionList != null) {
            dataSubscriptionList.m3369a(dataSubscriptionImpl);
        }
        if (this.f9483h != null || this.f9484i != null || this.f9485j != null) {
            dataObserver = new C2826a(dataSubscriptionImpl);
        }
        if (this.f9481f) {
            if (this.f9482g) {
                throw new IllegalStateException("Illegal combination of single() and onlyChanges()");
            }
            this.f9476a.mo3277c(dataObserver, this.f9477b);
        } else {
            this.f9476a.mo3281a(dataObserver, this.f9477b);
            if (!this.f9482g) {
                this.f9476a.mo3277c(dataObserver, this.f9477b);
            }
        }
        return dataSubscriptionImpl;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: SubscriptionBuilder.java */
    /* renamed from: io.objectbox.b.l$a */
    /* loaded from: classes2.dex */
    public class C2826a implements DataObserver<T>, DelegatingObserver<T> {

        /* renamed from: b */
        private final DataSubscriptionImpl f9488b;

        /* renamed from: c */
        private SubscriptionBuilder<T>.C2826a.C2829b f9489c;

        /* renamed from: d */
        private SubscriptionBuilder<T>.C2826a.C2828a f9490d;

        public C2826a(DataSubscriptionImpl dataSubscriptionImpl) {
            this.f9488b = dataSubscriptionImpl;
            if (SubscriptionBuilder.this.f9484i != null) {
                this.f9490d = new C2828a();
                if (SubscriptionBuilder.this.f9485j != null) {
                    this.f9489c = new C2829b();
                }
            }
        }

        @Override // io.objectbox.p092b.DataObserver
        public void onData(T t) {
            if (SubscriptionBuilder.this.f9483h != null) {
                m3351b(t);
            } else {
                m3353a((C2826a) t);
            }
        }

        /* renamed from: b */
        private void m3351b(final T t) {
            SubscriptionBuilder.this.f9478c.submit(new Runnable() { // from class: io.objectbox.b.l.a.1
                /* JADX WARN: Multi-variable type inference failed */
                @Override // java.lang.Runnable
                public void run() {
                    if (C2826a.this.f9488b.mo3368b()) {
                        return;
                    }
                    try {
                        C2826a.this.m3353a((C2826a) SubscriptionBuilder.this.f9483h.m3367a(t));
                    } catch (Throwable th) {
                        C2826a.this.m3352a(th, "Transformer failed without an ErrorObserver set");
                    }
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: a */
        public void m3352a(Throwable th, String str) {
            if (SubscriptionBuilder.this.f9485j != null) {
                if (this.f9488b.mo3368b()) {
                    return;
                }
                if (SubscriptionBuilder.this.f9484i != null) {
                    SubscriptionBuilder.this.f9484i.mo3365a(this.f9489c, th);
                    return;
                } else {
                    SubscriptionBuilder.this.f9485j.m3366a(th);
                    return;
                }
            }
            RuntimeException runtimeException = new RuntimeException(str, th);
            runtimeException.printStackTrace();
            throw runtimeException;
        }

        /* renamed from: a */
        void m3353a(T t) {
            if (this.f9488b.mo3368b()) {
                return;
            }
            if (SubscriptionBuilder.this.f9484i != null) {
                SubscriptionBuilder.this.f9484i.mo3365a(this.f9490d, t);
                return;
            }
            try {
                SubscriptionBuilder.this.f9479d.onData(t);
            } catch (Error | RuntimeException e) {
                m3352a(e, "Observer failed without an ErrorObserver set");
            }
        }

        @Override // io.objectbox.p092b.DelegatingObserver
        /* renamed from: a */
        public DataObserver<T> mo3348a() {
            return SubscriptionBuilder.this.f9479d;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: SubscriptionBuilder.java */
        /* renamed from: io.objectbox.b.l$a$a */
        /* loaded from: classes2.dex */
        public class C2828a implements RunWithParam<T> {
            C2828a() {
            }

            @Override // io.objectbox.p092b.RunWithParam
            /* renamed from: a */
            public void mo3350a(T t) {
                if (C2826a.this.f9488b.mo3368b()) {
                    return;
                }
                try {
                    SubscriptionBuilder.this.f9479d.onData(t);
                } catch (Error | RuntimeException e) {
                    C2826a.this.m3352a(e, "Observer failed without an ErrorObserver set");
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: SubscriptionBuilder.java */
        /* renamed from: io.objectbox.b.l$a$b */
        /* loaded from: classes2.dex */
        public class C2829b implements RunWithParam<Throwable> {
            C2829b() {
            }

            @Override // io.objectbox.p092b.RunWithParam
            /* renamed from: a  reason: avoid collision after fix types in other method */
            public void mo3350a(Throwable th) {
                if (C2826a.this.f9488b.mo3368b()) {
                    return;
                }
                SubscriptionBuilder.this.f9485j.m3366a(th);
            }
        }
    }
}
