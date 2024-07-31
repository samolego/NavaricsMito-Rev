package org.apache.mina.core.p131c;

import org.apache.mina.core.session.IoSession;

/* renamed from: org.apache.mina.core.c.e */
/* loaded from: classes2.dex */
public class DefaultReadFuture extends DefaultIoFuture implements ReadFuture {

    /* renamed from: a */
    private static final Object f11338a = new Object();

    @Override // org.apache.mina.core.p131c.DefaultIoFuture
    /* renamed from: b */
    public /* synthetic */ IoFuture mo1319b(IoFutureListener ioFutureListener) {
        return m1324a((IoFutureListener<?>) ioFutureListener);
    }

    public DefaultReadFuture(IoSession ioSession) {
        super(ioSession);
    }

    @Override // org.apache.mina.core.p131c.ReadFuture
    /* renamed from: a */
    public void mo1317a() {
        m1328a(f11338a);
    }

    @Override // org.apache.mina.core.p131c.ReadFuture
    /* renamed from: b */
    public void mo1315b(Object obj) {
        if (obj == null) {
            throw new IllegalArgumentException("message");
        }
        m1328a(obj);
    }

    @Override // org.apache.mina.core.p131c.ReadFuture
    /* renamed from: a */
    public void mo1316a(Throwable th) {
        if (th == null) {
            throw new IllegalArgumentException("exception");
        }
        m1328a((Object) th);
    }

    @Override // org.apache.mina.core.p131c.DefaultIoFuture
    /* renamed from: b */
    public ReadFuture mo1318d() {
        return (ReadFuture) super.mo1318d();
    }

    /* renamed from: a */
    public ReadFuture m1324a(IoFutureListener<?> ioFutureListener) {
        return (ReadFuture) super.mo1319b(ioFutureListener);
    }
}
