package org.apache.mina.core.p131c;

import org.apache.mina.core.session.IoSession;

/* renamed from: org.apache.mina.core.c.f */
/* loaded from: classes2.dex */
public class DefaultWriteFuture extends DefaultIoFuture implements WriteFuture {
    @Override // org.apache.mina.core.p131c.DefaultIoFuture
    /* renamed from: b */
    public /* synthetic */ IoFuture mo1319b(IoFutureListener ioFutureListener) {
        return mo961a((IoFutureListener<?>) ioFutureListener);
    }

    /* renamed from: a */
    public static WriteFuture m1322a(IoSession ioSession) {
        DefaultWriteFuture defaultWriteFuture = new DefaultWriteFuture(ioSession);
        defaultWriteFuture.mo964a();
        return defaultWriteFuture;
    }

    /* renamed from: a */
    public static WriteFuture m1321a(IoSession ioSession, Throwable th) {
        DefaultWriteFuture defaultWriteFuture = new DefaultWriteFuture(ioSession);
        defaultWriteFuture.mo962a(th);
        return defaultWriteFuture;
    }

    public DefaultWriteFuture(IoSession ioSession) {
        super(ioSession);
    }

    @Override // org.apache.mina.core.p131c.WriteFuture
    /* renamed from: a */
    public void mo964a() {
        m1328a(Boolean.TRUE);
    }

    @Override // org.apache.mina.core.p131c.WriteFuture
    /* renamed from: a */
    public void mo962a(Throwable th) {
        if (th == null) {
            throw new IllegalArgumentException("exception");
        }
        m1328a((Object) th);
    }

    @Override // org.apache.mina.core.p131c.DefaultIoFuture
    /* renamed from: b */
    public WriteFuture mo1318d() {
        return (WriteFuture) super.mo1318d();
    }

    @Override // org.apache.mina.core.p131c.WriteFuture
    /* renamed from: a */
    public WriteFuture mo961a(IoFutureListener<?> ioFutureListener) {
        return (WriteFuture) super.mo1319b(ioFutureListener);
    }
}
