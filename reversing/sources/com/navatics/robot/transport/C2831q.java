package com.navatics.robot.transport;

import org.apache.log4j.Logger;

/* renamed from: com.navatics.robot.transport.q */
/* loaded from: classes.dex */
public class C2834q {

    /* renamed from: a */
    private static final Logger f6569a = Logger.m1561a(C2834q.class);

    /* renamed from: b */
    private static InterfaceC2817d f6570b;

    /* renamed from: c */
    private static InterfaceC2817d f6571c;

    /* renamed from: d */
    private static synchronized void m6224d() {
        synchronized (C2834q.class) {
            if (f6570b != null || f6571c != null) {
                throw new RuntimeException("wtf ??????? init twice!");
            }
            f6570b = new HandlerThreadC2789a();
            f6571c = new C2797b();
            f6570b.start();
            f6571c.start();
            try {
                f6570b.mo6288a();
                f6571c.mo6288a();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            f6569a.mo1497c((Object) "NvEventLoop init done.");
        }
    }

    /* renamed from: a */
    public static InterfaceC2817d m6227a() {
        if (f6570b == null) {
            synchronized (C2834q.class) {
                if (f6570b == null) {
                    m6224d();
                }
            }
        }
        return f6570b;
    }

    /* renamed from: b */
    public static InterfaceC2817d m6226b() {
        if (f6571c == null) {
            synchronized (C2834q.class) {
                if (f6571c == null) {
                    m6224d();
                }
            }
        }
        return f6571c;
    }

    /* renamed from: c */
    public static InterfaceC2817d m6225c() {
        return m6227a();
    }
}
