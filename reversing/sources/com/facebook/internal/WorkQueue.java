package com.facebook.internal;

import com.facebook.FacebookSdk;
import java.util.concurrent.Executor;

/* renamed from: com.facebook.internal.z */
/* loaded from: classes.dex */
public class WorkQueue {

    /* renamed from: a */
    static final /* synthetic */ boolean f2104a = !WorkQueue.class.desiredAssertionStatus();

    /* renamed from: b */
    private final Object f2105b;

    /* renamed from: c */
    private C0998b f2106c;

    /* renamed from: d */
    private final int f2107d;

    /* renamed from: e */
    private final Executor f2108e;

    /* renamed from: f */
    private C0998b f2109f;

    /* renamed from: g */
    private int f2110g;

    /* compiled from: WorkQueue.java */
    /* renamed from: com.facebook.internal.z$a */
    /* loaded from: classes.dex */
    public interface InterfaceC0997a {
    }

    public WorkQueue() {
        this(8);
    }

    public WorkQueue(int i) {
        this(i, FacebookSdk.m10871f());
    }

    public WorkQueue(int i, Executor executor) {
        this.f2105b = new Object();
        this.f2109f = null;
        this.f2110g = 0;
        this.f2107d = i;
        this.f2108e = executor;
    }

    /* renamed from: a */
    public InterfaceC0997a m10421a(Runnable runnable) {
        return m10420a(runnable, true);
    }

    /* renamed from: a */
    public InterfaceC0997a m10420a(Runnable runnable, boolean z) {
        C0998b c0998b = new C0998b(runnable);
        synchronized (this.f2105b) {
            this.f2106c = c0998b.m10416a(this.f2106c, z);
        }
        m10424a();
        return c0998b;
    }

    /* renamed from: a */
    private void m10424a() {
        m10423a((C0998b) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m10423a(C0998b c0998b) {
        C0998b c0998b2;
        synchronized (this.f2105b) {
            if (c0998b != null) {
                this.f2109f = c0998b.m10417a(this.f2109f);
                this.f2110g--;
            }
            if (this.f2110g < this.f2107d) {
                c0998b2 = this.f2106c;
                if (c0998b2 != null) {
                    this.f2106c = c0998b2.m10417a(this.f2106c);
                    this.f2109f = c0998b2.m10416a(this.f2109f, false);
                    this.f2110g++;
                    c0998b2.m10415a(true);
                }
            } else {
                c0998b2 = null;
            }
        }
        if (c0998b2 != null) {
            m10419b(c0998b2);
        }
    }

    /* renamed from: b */
    private void m10419b(final C0998b c0998b) {
        this.f2108e.execute(new Runnable() { // from class: com.facebook.internal.z.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    c0998b.m10418a().run();
                } finally {
                    WorkQueue.this.m10423a(c0998b);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: WorkQueue.java */
    /* renamed from: com.facebook.internal.z$b */
    /* loaded from: classes.dex */
    public class C0998b implements InterfaceC0997a {

        /* renamed from: a */
        static final /* synthetic */ boolean f2113a = !WorkQueue.class.desiredAssertionStatus();

        /* renamed from: c */
        private final Runnable f2115c;

        /* renamed from: d */
        private C0998b f2116d;

        /* renamed from: e */
        private C0998b f2117e;

        /* renamed from: f */
        private boolean f2118f;

        C0998b(Runnable runnable) {
            this.f2115c = runnable;
        }

        /* renamed from: a */
        Runnable m10418a() {
            return this.f2115c;
        }

        /* renamed from: a */
        void m10415a(boolean z) {
            this.f2118f = z;
        }

        /* renamed from: a */
        C0998b m10416a(C0998b c0998b, boolean z) {
            if (f2113a || this.f2116d == null) {
                if (f2113a || this.f2117e == null) {
                    if (c0998b == null) {
                        this.f2117e = this;
                        this.f2116d = this;
                        c0998b = this;
                    } else {
                        this.f2116d = c0998b;
                        this.f2117e = c0998b.f2117e;
                        C0998b c0998b2 = this.f2116d;
                        this.f2117e.f2116d = this;
                        c0998b2.f2117e = this;
                    }
                    return z ? this : c0998b;
                }
                throw new AssertionError();
            }
            throw new AssertionError();
        }

        /* renamed from: a */
        C0998b m10417a(C0998b c0998b) {
            if (f2113a || this.f2116d != null) {
                if (f2113a || this.f2117e != null) {
                    if (c0998b == this && (c0998b = this.f2116d) == this) {
                        c0998b = null;
                    }
                    C0998b c0998b2 = this.f2116d;
                    c0998b2.f2117e = this.f2117e;
                    this.f2117e.f2116d = c0998b2;
                    this.f2117e = null;
                    this.f2116d = null;
                    return c0998b;
                }
                throw new AssertionError();
            }
            throw new AssertionError();
        }
    }
}
