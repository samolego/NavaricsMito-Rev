package org.apache.mina.core.p131c;

import java.util.ArrayList;
import java.util.List;
import org.apache.mina.core.p132d.AbstractPollingIoProcessor;
import org.apache.mina.core.p133e.IoProcessor;
import org.apache.mina.core.session.IoSession;
import org.apache.mina.util.ExceptionMonitor;

/* renamed from: org.apache.mina.core.c.d */
/* loaded from: classes2.dex */
public class DefaultIoFuture implements IoFuture {

    /* renamed from: a */
    private final IoSession f11331a;

    /* renamed from: b */
    private final Object f11332b = this;

    /* renamed from: c */
    private IoFutureListener<?> f11333c;

    /* renamed from: d */
    private List<IoFutureListener<?>> f11334d;

    /* renamed from: e */
    private Object f11335e;

    /* renamed from: f */
    private boolean f11336f;

    /* renamed from: g */
    private int f11337g;

    public DefaultIoFuture(IoSession ioSession) {
        this.f11331a = ioSession;
    }

    @Override // org.apache.mina.core.p131c.IoFuture
    /* renamed from: e */
    public IoSession mo960e() {
        return this.f11331a;
    }

    /* renamed from: d */
    public IoFuture mo1318d() {
        try {
            m1329a(Long.MAX_VALUE, false);
        } catch (InterruptedException unused) {
        }
        return this;
    }

    @Override // org.apache.mina.core.p131c.IoFuture
    /* renamed from: a */
    public boolean mo963a(long j) {
        try {
            return m1329a(j, false);
        } catch (InterruptedException unused) {
            throw new InternalError();
        }
    }

    /* renamed from: a */
    private boolean m1329a(long j, boolean z) throws InterruptedException {
        long currentTimeMillis = System.currentTimeMillis() + j;
        if (currentTimeMillis < 0) {
            currentTimeMillis = Long.MAX_VALUE;
        }
        synchronized (this.f11332b) {
            if (!this.f11336f && j > 0) {
                this.f11337g++;
                while (true) {
                    try {
                        this.f11332b.wait(Math.min(j, 5000L));
                    } catch (InterruptedException e) {
                        if (z) {
                            throw e;
                        }
                    }
                    if (this.f11336f || currentTimeMillis < System.currentTimeMillis()) {
                        break;
                    }
                    m1330a();
                }
                boolean z2 = this.f11336f;
                this.f11337g--;
                if (!this.f11336f) {
                    m1330a();
                }
                return z2;
            }
            return this.f11336f;
        }
    }

    /* renamed from: a */
    private void m1330a() {
        if ((this instanceof CloseFuture) || (this instanceof WriteFuture) || (this instanceof ReadFuture) || (this instanceof ConnectFuture)) {
            StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
            for (StackTraceElement stackTraceElement : stackTrace) {
                if (AbstractPollingIoProcessor.class.getName().equals(stackTraceElement.getClassName())) {
                    new IllegalStateException("t").getStackTrace();
                    throw new IllegalStateException("DEAD LOCK: " + IoFuture.class.getSimpleName() + ".await() was invoked from an I/O processor thread.  Please use " + IoFutureListener.class.getSimpleName() + " or configure a proper thread model alternatively.");
                }
            }
            for (StackTraceElement stackTraceElement2 : stackTrace) {
                if (IoProcessor.class.isAssignableFrom(DefaultIoFuture.class.getClassLoader().loadClass(stackTraceElement2.getClassName()))) {
                    throw new IllegalStateException("DEAD LOCK: " + IoFuture.class.getSimpleName() + ".await() was invoked from an I/O processor thread.  Please use " + IoFutureListener.class.getSimpleName() + " or configure a proper thread model alternatively.");
                    break;
                }
            }
        }
    }

    /* renamed from: f */
    public boolean mo1209f() {
        boolean z;
        synchronized (this.f11332b) {
            z = this.f11336f;
        }
        return z;
    }

    /* renamed from: a */
    public boolean m1328a(Object obj) {
        synchronized (this.f11332b) {
            if (this.f11336f) {
                return false;
            }
            this.f11335e = obj;
            this.f11336f = true;
            if (this.f11337g > 0) {
                this.f11332b.notifyAll();
            }
            m1326b();
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: g */
    public Object m1325g() {
        Object obj;
        synchronized (this.f11332b) {
            obj = this.f11335e;
        }
        return obj;
    }

    /* renamed from: b */
    public IoFuture mo1319b(IoFutureListener<?> ioFutureListener) {
        if (ioFutureListener == null) {
            throw new IllegalArgumentException("listener");
        }
        synchronized (this.f11332b) {
            if (this.f11336f) {
                m1327a((IoFutureListener) ioFutureListener);
            } else if (this.f11333c == null) {
                this.f11333c = ioFutureListener;
            } else {
                if (this.f11334d == null) {
                    this.f11334d = new ArrayList(1);
                }
                this.f11334d.add(ioFutureListener);
            }
        }
        return this;
    }

    /* renamed from: b */
    private void m1326b() {
        IoFutureListener<?> ioFutureListener = this.f11333c;
        if (ioFutureListener != null) {
            m1327a((IoFutureListener) ioFutureListener);
            this.f11333c = null;
            List<IoFutureListener<?>> list = this.f11334d;
            if (list != null) {
                for (IoFutureListener<?> ioFutureListener2 : list) {
                    m1327a((IoFutureListener) ioFutureListener2);
                }
                this.f11334d = null;
            }
        }
    }

    /* renamed from: a */
    private void m1327a(IoFutureListener ioFutureListener) {
        try {
            ioFutureListener.mo894a(this);
        } catch (Exception e) {
            ExceptionMonitor.m808a().mo807a(e);
        }
    }
}
