package org.apache.mina.core.p133e;

import android.support.p008v4.app.NotificationCompat;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import org.apache.mina.core.filterchain.IoFilterChain;
import org.apache.mina.core.p131c.IoFuture;
import org.apache.mina.core.p131c.IoFutureListener;
import org.apache.mina.core.session.IoSession;
import org.apache.mina.util.ExceptionMonitor;

/* renamed from: org.apache.mina.core.e.k */
/* loaded from: classes2.dex */
public class IoServiceListenerSupport {

    /* renamed from: a */
    private final IoService f11401a;

    /* renamed from: f */
    private volatile long f11406f;

    /* renamed from: b */
    private final List<IoServiceListener> f11402b = new CopyOnWriteArrayList();

    /* renamed from: c */
    private final ConcurrentMap<Long, IoSession> f11403c = new ConcurrentHashMap();

    /* renamed from: d */
    private final Map<Long, IoSession> f11404d = Collections.unmodifiableMap(this.f11403c);

    /* renamed from: e */
    private final AtomicBoolean f11405e = new AtomicBoolean();

    /* renamed from: g */
    private volatile int f11407g = 0;

    /* renamed from: h */
    private AtomicLong f11408h = new AtomicLong(0);

    public IoServiceListenerSupport(IoService ioService) {
        if (ioService == null) {
            throw new IllegalArgumentException(NotificationCompat.CATEGORY_SERVICE);
        }
        this.f11401a = ioService;
    }

    /* renamed from: a */
    public void m1185a(IoServiceListener ioServiceListener) {
        if (ioServiceListener != null) {
            this.f11402b.add(ioServiceListener);
        }
    }

    /* renamed from: a */
    public long m1186a() {
        return this.f11406f;
    }

    /* renamed from: b */
    public Map<Long, IoSession> m1183b() {
        return this.f11404d;
    }

    /* renamed from: c */
    public int m1181c() {
        return this.f11403c.size();
    }

    /* renamed from: d */
    public boolean m1180d() {
        return this.f11405e.get();
    }

    /* renamed from: e */
    public void m1179e() {
        if (this.f11405e.compareAndSet(false, true)) {
            this.f11406f = System.currentTimeMillis();
            for (IoServiceListener ioServiceListener : this.f11402b) {
                try {
                    ioServiceListener.mo1190a(this.f11401a);
                } catch (Exception e) {
                    ExceptionMonitor.m808a().mo807a(e);
                }
            }
        }
    }

    /* renamed from: f */
    public void m1178f() {
        if (this.f11405e.compareAndSet(true, false)) {
            try {
                for (IoServiceListener ioServiceListener : this.f11402b) {
                    try {
                        ioServiceListener.mo1188b(this.f11401a);
                    } catch (Exception e) {
                        ExceptionMonitor.m808a().mo807a(e);
                    }
                }
            } finally {
                m1177g();
            }
        }
    }

    /* renamed from: a */
    public void m1184a(IoSession ioSession) {
        boolean z;
        if (ioSession.mo993m() instanceof IoConnector) {
            synchronized (this.f11403c) {
                z = this.f11403c.isEmpty();
            }
        } else {
            z = false;
        }
        if (this.f11403c.putIfAbsent(Long.valueOf(ioSession.mo999g()), ioSession) != null) {
            return;
        }
        if (z) {
            m1179e();
        }
        IoFilterChain mo1002e = ioSession.mo1002e();
        mo1002e.mo1093c();
        mo1002e.mo1091d();
        int size = this.f11403c.size();
        if (size > this.f11407g) {
            this.f11407g = size;
        }
        this.f11408h.incrementAndGet();
        for (IoServiceListener ioServiceListener : this.f11402b) {
            try {
                ioServiceListener.mo1189a(ioSession);
            } catch (Exception e) {
                ExceptionMonitor.m808a().mo807a(e);
            }
        }
    }

    /* renamed from: b */
    public void m1182b(IoSession ioSession) {
        boolean isEmpty;
        if (this.f11403c.remove(Long.valueOf(ioSession.mo999g())) == null) {
            return;
        }
        ioSession.mo1002e().mo1090e();
        try {
            for (IoServiceListener ioServiceListener : this.f11402b) {
                try {
                    ioServiceListener.mo1187b(ioSession);
                } catch (Exception e) {
                    ExceptionMonitor.m808a().mo807a(e);
                }
            }
            if (ioSession.mo993m() instanceof IoConnector) {
                synchronized (this.f11403c) {
                    isEmpty = this.f11403c.isEmpty();
                }
                if (isEmpty) {
                    m1178f();
                }
            }
        } catch (Throwable th) {
            if (ioSession.mo993m() instanceof IoConnector) {
                synchronized (this.f11403c) {
                    if (this.f11403c.isEmpty()) {
                        m1178f();
                    }
                }
            }
            throw th;
        }
    }

    /* renamed from: g */
    private void m1177g() {
        IoService ioService = this.f11401a;
        if ((ioService instanceof IoAcceptor) && ((IoAcceptor) ioService).mo1207l()) {
            Object obj = new Object();
            C3065a c3065a = new C3065a(obj);
            for (IoSession ioSession : this.f11403c.values()) {
                ioSession.mo1016a().mo1333a(c3065a);
            }
            try {
                synchronized (obj) {
                    while (!this.f11403c.isEmpty()) {
                        obj.wait(500L);
                    }
                }
            } catch (InterruptedException unused) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: IoServiceListenerSupport.java */
    /* renamed from: org.apache.mina.core.e.k$a */
    /* loaded from: classes2.dex */
    public static class C3065a implements IoFutureListener<IoFuture> {

        /* renamed from: b */
        private final Object f11409b;

        public C3065a(Object obj) {
            this.f11409b = obj;
        }

        @Override // org.apache.mina.core.p131c.IoFutureListener
        /* renamed from: a */
        public void mo894a(IoFuture ioFuture) {
            synchronized (this.f11409b) {
                this.f11409b.notifyAll();
            }
        }
    }
}
