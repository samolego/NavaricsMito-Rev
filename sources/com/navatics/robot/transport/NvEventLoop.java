package com.navatics.robot.transport;

import org.apache.log4j.C3044k;

/* renamed from: com.navatics.robot.transport.q */
/* loaded from: classes.dex */
public class NvEventLoop {

    /* renamed from: a */
    private static final C3044k f6569a = C3044k.m1564a(NvEventLoop.class);

    /* renamed from: b */
    private static IEventLooper f6570b;

    /* renamed from: c */
    private static IEventLooper f6571c;

    /* renamed from: d */
    private static synchronized void m6229d() {
        synchronized (NvEventLoop.class) {
            if (f6570b != null || f6571c != null) {
                throw new RuntimeException("wtf ??????? init twice!");
            }
            f6570b = new AndroidHandlerThreadLooper();
            f6571c = new AndroidMainThreadLooper();
            f6570b.start();
            f6571c.start();
            try {
                f6570b.mo6288a();
                f6571c.mo6288a();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            f6569a.mo1500c((Object) "NvEventLoop init done.");
        }
    }

    /* renamed from: a */
    public static IEventLooper m6232a() {
        if (f6570b == null) {
            synchronized (NvEventLoop.class) {
                if (f6570b == null) {
                    m6229d();
                }
            }
        }
        return f6570b;
    }

    /* renamed from: b */
    public static IEventLooper m6231b() {
        if (f6571c == null) {
            synchronized (NvEventLoop.class) {
                if (f6571c == null) {
                    m6229d();
                }
            }
        }
        return f6571c;
    }

    /* renamed from: c */
    public static IEventLooper m6230c() {
        return m6232a();
    }
}
