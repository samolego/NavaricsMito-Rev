package com.navatics.robot.transport;

import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import org.apache.log4j.C3044k;

/* renamed from: com.navatics.robot.transport.s */
/* loaded from: classes.dex */
public class NvSelector extends Thread {

    /* renamed from: a */
    private static final C3044k f6572a = C3044k.m1564a(NvSelector.class);

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
    private CopyOnWriteArrayList<C2127a> f6579h;

    /* renamed from: a */
    public static NvSelector m6228a() {
        return new NvSelector();
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private NvSelector() {
        /*
            r3 = this;
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "NvSelector - "
            r0.append(r1)
            int r1 = com.navatics.robot.transport.NvSelector.f6573b
            int r2 = r1 + 1
            com.navatics.robot.transport.NvSelector.f6573b = r2
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
        throw new UnsupportedOperationException("Method not decompiled: com.navatics.robot.transport.NvSelector.<init>():void");
    }

    /* renamed from: a */
    public void m6225a(IoChannel ioChannel, int i, IoHandler ioHandler) {
        f6572a.mo1511a((Object) "selector channel register");
        this.f6579h.add(new C2127a(ioChannel, i, ioHandler));
        synchronized (this.f6577f) {
            m6224b();
        }
    }

    /* renamed from: a */
    public void m6226a(IoChannel ioChannel) {
        C2127a c2127a;
        f6572a.mo1511a((Object) "selector channel unregister");
        Iterator<C2127a> it = this.f6579h.iterator();
        while (true) {
            if (!it.hasNext()) {
                c2127a = null;
                break;
            }
            c2127a = it.next();
            if (c2127a.f6580a == ioChannel) {
                break;
            }
        }
        if (c2127a != null) {
            this.f6579h.remove(c2127a);
        }
    }

    /* renamed from: a */
    private void m6227a(long j) {
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
    private void m6224b() {
        if (this.f6578g) {
            this.f6577f.notifyAll();
        }
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        f6572a.mo1500c((Object) "NvSelector start.");
        while (!this.f6574c) {
            try {
                long currentTimeMillis = System.currentTimeMillis();
                if (this.f6579h.isEmpty()) {
                    synchronized (this.f6577f) {
                        if (this.f6579h.isEmpty()) {
                            m6227a(0L);
                        }
                    }
                } else {
                    Iterator<C2127a> it = this.f6579h.iterator();
                    while (it.hasNext()) {
                        C2127a next = it.next();
                        if (currentTimeMillis >= next.f6583d) {
                            int mo6210c = next.f6580a.mo6210c();
                            if (mo6210c != 0) {
                                next.f6582c.mo6074a(mo6210c, next.f6580a);
                                long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
                                if (currentTimeMillis2 > 10000) {
                                    C3044k c3044k = f6572a;
                                    c3044k.mo1499d("event handle time " + currentTimeMillis2);
                                }
                            }
                            next.f6583d = next.f6580a.m6352a() + currentTimeMillis;
                        }
                    }
                }
                long m6223c = m6223c() - currentTimeMillis;
                if (m6223c > 0) {
                    try {
                        synchronized (this.f6577f) {
                            m6227a(m6223c);
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
        f6572a.mo1500c((Object) "NvSelector has exited.");
    }

    /* renamed from: c */
    private long m6223c() {
        Iterator<C2127a> it = this.f6579h.iterator();
        long j = Long.MAX_VALUE;
        while (it.hasNext()) {
            C2127a next = it.next();
            if (next.f6583d < j) {
                j = next.f6583d;
            }
        }
        return j;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: NvSelector.java */
    /* renamed from: com.navatics.robot.transport.s$a */
    /* loaded from: classes.dex */
    public class C2127a {

        /* renamed from: a */
        IoChannel f6580a;

        /* renamed from: b */
        int f6581b;

        /* renamed from: c */
        IoHandler f6582c;

        /* renamed from: d */
        long f6583d;

        C2127a(IoChannel ioChannel, int i, IoHandler ioHandler) {
            this.f6580a = ioChannel;
            this.f6581b = i;
            this.f6582c = ioHandler;
        }
    }
}
