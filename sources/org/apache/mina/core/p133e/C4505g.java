package org.apache.mina.core.p133e;

import org.apache.mina.core.session.IdleStatus;
import org.apache.mina.core.session.IoSession;
import org.slf4j.C3154c;
import org.slf4j.InterfaceC3153b;

/* renamed from: org.apache.mina.core.e.g */
/* loaded from: classes2.dex */
public class IoHandlerAdapter implements InterfaceC3064f {

    /* renamed from: a */
    private static final InterfaceC3153b f11400a = C3154c.m262a(IoHandlerAdapter.class);

    @Override // org.apache.mina.core.p133e.InterfaceC3064f
    /* renamed from: a */
    public void mo1205a(IoSession ioSession) throws Exception {
    }

    @Override // org.apache.mina.core.p133e.InterfaceC3064f
    /* renamed from: a */
    public void mo1204a(IoSession ioSession, Object obj) throws Exception {
    }

    @Override // org.apache.mina.core.p133e.InterfaceC3064f
    /* renamed from: a */
    public void mo1202a(IoSession ioSession, IdleStatus idleStatus) throws Exception {
    }

    @Override // org.apache.mina.core.p133e.InterfaceC3064f
    /* renamed from: b */
    public void mo1201b(IoSession ioSession) throws Exception {
    }

    @Override // org.apache.mina.core.p133e.InterfaceC3064f
    /* renamed from: b */
    public void mo1200b(IoSession ioSession, Object obj) throws Exception {
    }

    @Override // org.apache.mina.core.p133e.InterfaceC3064f
    /* renamed from: c */
    public void mo1199c(IoSession ioSession) throws Exception {
    }

    @Override // org.apache.mina.core.p133e.InterfaceC3064f
    /* renamed from: a */
    public void mo1203a(IoSession ioSession, Throwable th) throws Exception {
        if (f11400a.isWarnEnabled()) {
            InterfaceC3153b interfaceC3153b = f11400a;
            interfaceC3153b.warn("EXCEPTION, please implement " + getClass().getName() + ".exceptionCaught() for proper handling:", th);
        }
    }

    @Override // org.apache.mina.core.p133e.InterfaceC3064f
    /* renamed from: d */
    public void mo1198d(IoSession ioSession) throws Exception {
        ioSession.mo1016a();
    }
}
