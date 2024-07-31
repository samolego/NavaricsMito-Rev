package com.navatics.robot.transport.p063b;

import com.navatics.robot.transport.SerialExecutor;

/* renamed from: com.navatics.robot.transport.b.i */
/* loaded from: classes.dex */
public abstract class NvObserverExecutor {

    /* renamed from: a */
    private static NvObserverExecutor f6525a;

    /* renamed from: b */
    private static NvObserverExecutor f6526b;

    /* renamed from: c */
    private static NvObserverExecutor f6527c;

    /* compiled from: NvObserverExecutor.java */
    /* renamed from: com.navatics.robot.transport.b.i$a */
    /* loaded from: classes.dex */
    public interface InterfaceC2117a {
        /* renamed from: a */
        void mo6301a();

        /* renamed from: a */
        void mo6300a(Throwable th);
    }

    /* compiled from: NvObserverExecutor.java */
    /* renamed from: com.navatics.robot.transport.b.i$b */
    /* loaded from: classes.dex */
    public interface InterfaceC2118b {
        /* renamed from: a */
        void mo6299a();
    }

    /* compiled from: NvObserverExecutor.java */
    /* renamed from: com.navatics.robot.transport.b.i$c */
    /* loaded from: classes.dex */
    public interface InterfaceC2119c {
        void onFinish();
    }

    /* renamed from: a */
    public abstract void mo6307a(NvAction nvAction, NvExceptionHandler nvExceptionHandler, InterfaceC2118b interfaceC2118b);

    /* renamed from: a */
    public abstract void mo6306a(NvExceptionHandler nvExceptionHandler, Throwable th, InterfaceC2119c interfaceC2119c);

    /* renamed from: a */
    public abstract <T> void mo6305a(NvObserver<T> nvObserver, T t, InterfaceC2117a interfaceC2117a) throws Exception;

    /* renamed from: a */
    public abstract void mo6304a(Runnable runnable);

    /* renamed from: a */
    public static NvObserverExecutor m6308a() {
        if (f6525a == null) {
            synchronized (NvObserverExecutor.class) {
                if (f6525a == null) {
                    f6525a = new DefaultObserverExecutor();
                }
            }
        }
        return f6525a;
    }

    /* renamed from: b */
    public static NvObserverExecutor m6303b() {
        if (f6526b == null) {
            synchronized (NvObserverExecutor.class) {
                if (f6526b == null) {
                    f6526b = new AndroidMainThreadExecutor();
                }
            }
        }
        return f6526b;
    }

    /* renamed from: c */
    public static NvObserverExecutor m6302c() {
        if (f6527c == null) {
            synchronized (NvObserverExecutor.class) {
                if (f6527c == null) {
                    f6527c = new SerialExecutor();
                }
            }
        }
        return f6527c;
    }
}
