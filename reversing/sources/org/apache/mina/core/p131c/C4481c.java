package org.apache.mina.core.p131c;

import org.apache.mina.core.session.IoSession;

/* renamed from: org.apache.mina.core.c.c */
/* loaded from: classes2.dex */
public class DefaultCloseFuture extends DefaultIoFuture implements CloseFuture {
    @Override // org.apache.mina.core.p131c.DefaultIoFuture
    /* renamed from: b */
    public /* synthetic */ IoFuture mo1319b(IoFutureListener ioFutureListener) {
        return mo1333a((IoFutureListener<?>) ioFutureListener);
    }

    public DefaultCloseFuture(IoSession ioSession) {
        super(ioSession);
    }

    @Override // org.apache.mina.core.p131c.CloseFuture
    /* renamed from: a */
    public boolean mo1334a() {
        if (mo1209f()) {
            return ((Boolean) m1325g()).booleanValue();
        }
        return false;
    }

    @Override // org.apache.mina.core.p131c.CloseFuture
    /* renamed from: b */
    public void mo1332b() {
        m1328a(Boolean.TRUE);
    }

    @Override // org.apache.mina.core.p131c.DefaultIoFuture
    /* renamed from: c */
    public CloseFuture mo1318d() {
        return (CloseFuture) super.mo1318d();
    }

    @Override // org.apache.mina.core.p131c.CloseFuture
    /* renamed from: a */
    public CloseFuture mo1333a(IoFutureListener<?> ioFutureListener) {
        return (CloseFuture) super.mo1319b(ioFutureListener);
    }
}
