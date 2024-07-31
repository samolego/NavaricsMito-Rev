package com.navatics.robot.transport;

import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import org.apache.log4j.Logger;

/* renamed from: com.navatics.robot.transport.s */
/* loaded from: classes.dex */
public class C2835s extends Thread {

    /* renamed from: a */
    private static final Logger f6572a = Logger.m1561a(C2835s.class);

    /* renamed from: b */
    private static int f6573b = 0;

    /* renamed from: c */
    private boolean f6574c;

    /* renamed from: d */
    private boolean f6575d;

    /* renamed from: e */
    private final Object f6576e;

    /* renamed from: f */
    private final Object f6577f;

    /* renamed from: g */
    private boolean f6578g;

    /* renamed from: h */
    private CopyOnWriteArrayList f6579h;

    /* renamed from: a */
    public static C2835s m6223a() {
        return new C2835s();
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private C2835s() {
        /*
            r3 = this;
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "NvSelector - "
            r0.append(r1)
            int r1 = com.navatics.robot.transport.C2835s.f6573b
            int r2 = r1 + 1
            com.navatics.robot.transport.C2835s.f6573b = r2
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            r3.<init>(r0)
            r0 = 0
            r3.f6574c = r0
            r3.f6575d = r0
            java.lang.Object r0 = new java.lang.Object
            r0.<init>()
            r3.f6576e = r0
            java.lang.Object r0 = new java.lang.Object
            r0.<init>()
            r3.f6577f = r0
            java.util.concurrent.CopyOnWriteArrayList r0 = new java.util.concurrent.CopyOnWriteArrayList
            r0.<init>()
            r3.f6579h = r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.navatics.robot.transport.C2835s.<init>():void");
    }

    /* renamed from: a */
    public void m6220a(IoChannel ioChannel, int i, InterfaceC2822i interfaceC2822i) {
        f6572a.mo1508a((Object) "selector channel register");
        this.f6579h.add(new C2836a(ioChannel, i, interfaceC2822i));
        synchronized (this.f6577f) {
            m6219b();
        }
    }

    /* renamed from: a */
    public void m6221a(IoChannel ioChannel) {
        C2836a c2836a;
        f6572a.mo1508a((Object) "selector channel unregister");
        Iterator it = this.f6579h.iterator();
        while (true) {
            if (!it.hasNext()) {
                c2836a = null;
                break;
            }
            c2836a = (C2836a) it.next();
            if (c2836a.f6580a == ioChannel) {
                break;
            }
        }
        if (c2836a != null) {
            this.f6579h.remove(c2836a);
        }
    }

    /* renamed from: a */
    private void m6222a(long j) {
        try {
            this.f6578g = true;
            if (j > 0) {
                this.f6577f.wait(j);
            } else {
                this.f6577f.wait();
            }
            this.f6578g = false;
        } catch (Exception unused) {
        }
    }

    /* renamed from: b */
    private void m6219b() {
        if (this.f6578g) {
            this.f6577f.notifyAll();
        }
    }

    public void run() {
        f6572a.mo1497c((Object) "NvSelector start.");
        while (!this.f6574c) {
            try {
                long currentTimeMillis = System.currentTimeMillis();
                if (this.f6579h.isEmpty()) {
                    synchronized (this.f6577f) {
                        if (this.f6579h.isEmpty()) {
                            m6222a(0L);
                        }
                    }
                } else {
                    Iterator it = this.f6579h.iterator();
                    while (it.hasNext()) {
                        C2836a c2836a = (C2836a) it.next();
                        if (currentTimeMillis >= c2836a.f6583d) {
                            int mo6349c = c2836a.f6580a.mo6349c();
                            if (mo6349c != 0) {
                                c2836a.f6582c.mo6069a(mo6349c, c2836a.f6580a);
                                long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
                                if (currentTimeMillis2 > 10000) {
                                    Logger logger = f6572a;
                                    logger.mo1496d("event handle time " + currentTimeMillis2);
                                }
                            }
                            c2836a.f6583d = c2836a.f6580a.m6354a() + currentTimeMillis;
                        }
                    }
                }
                long m6218c = m6218c() - currentTimeMillis;
                if (m6218c > 0) {
                    try {
                        synchronized (this.f6577f) {
                            m6222a(m6218c);
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        this.f6575d = true;
        synchronized (this.f6576e) {
            this.f6576e.notify();
        }
        f6572a.mo1497c((Object) "NvSelector has exited.");
    }

    /* renamed from: c */
    private long m6218c() {
        Iterator it = this.f6579h.iterator();
        long j = Long.MAX_VALUE;
        while (it.hasNext()) {
            C2836a c2836a = (C2836a) it.next();
            if (c2836a.f6583d < j) {
                j = c2836a.f6583d;
            }
        }
        return j;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: NvSelector.java */
    /* renamed from: com.navatics.robot.transport.s$a */
    /* loaded from: classes.dex */
    public class C2836a {

        /* renamed from: a */
        IoChannel f6580a;

        /* renamed from: b */
        int f6581b;

        /* renamed from: c */
        InterfaceC2822i f6582c;

        /* renamed from: d */
        long f6583d;

        C2836a(IoChannel ioChannel, int i, InterfaceC2822i interfaceC2822i) {
            this.f6580a = ioChannel;
            this.f6581b = i;
            this.f6582c = interfaceC2822i;
        }
    }
}
