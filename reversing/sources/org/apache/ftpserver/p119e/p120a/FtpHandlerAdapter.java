package org.apache.ftpserver.p119e.p120a;

import org.apache.ftpserver.ftplet.FtpReply;
import org.apache.ftpserver.p118d.DefaultFtpRequest;
import org.apache.ftpserver.p118d.FtpHandler;
import org.apache.ftpserver.p118d.FtpIoSession;
import org.apache.ftpserver.p118d.FtpServerContext;
import org.apache.mina.core.p133e.IoHandlerAdapter;
import org.apache.mina.core.session.IdleStatus;
import org.apache.mina.core.session.IoSession;
import org.apache.mina.filter.logging.MdcInjectionFilter;

/* renamed from: org.apache.ftpserver.e.a.b */
/* loaded from: classes2.dex */
public class FtpHandlerAdapter extends IoHandlerAdapter {

    /* renamed from: a */
    private final FtpServerContext f11067a;

    /* renamed from: b */
    private FtpHandler f11068b;

    public FtpHandlerAdapter(FtpServerContext ftpServerContext, FtpHandler ftpHandler) {
        this.f11067a = ftpServerContext;
        this.f11068b = ftpHandler;
    }

    @Override // org.apache.mina.core.p133e.IoHandlerAdapter, org.apache.mina.core.p133e.InterfaceC3064f
    /* renamed from: a */
    public void mo1203a(IoSession ioSession, Throwable th) throws Exception {
        this.f11068b.mo1912a(new FtpIoSession(ioSession, this.f11067a), th);
    }

    @Override // org.apache.mina.core.p133e.IoHandlerAdapter, org.apache.mina.core.p133e.InterfaceC3064f
    /* renamed from: a */
    public void mo1204a(IoSession ioSession, Object obj) throws Exception {
        this.f11068b.mo1910a(new FtpIoSession(ioSession, this.f11067a), new DefaultFtpRequest(obj.toString()));
    }

    @Override // org.apache.mina.core.p133e.IoHandlerAdapter, org.apache.mina.core.p133e.InterfaceC3064f
    /* renamed from: b */
    public void mo1200b(IoSession ioSession, Object obj) throws Exception {
        this.f11068b.mo1911a(new FtpIoSession(ioSession, this.f11067a), (FtpReply) obj);
    }

    @Override // org.apache.mina.core.p133e.IoHandlerAdapter, org.apache.mina.core.p133e.InterfaceC3064f
    /* renamed from: a */
    public void mo1205a(IoSession ioSession) throws Exception {
        this.f11068b.mo1906c(new FtpIoSession(ioSession, this.f11067a));
    }

    @Override // org.apache.mina.core.p133e.IoHandlerAdapter, org.apache.mina.core.p133e.InterfaceC3064f
    /* renamed from: b */
    public void mo1201b(IoSession ioSession) throws Exception {
        FtpIoSession ftpIoSession = new FtpIoSession(ioSession, this.f11067a);
        MdcInjectionFilter.m822a(ioSession, "session", ftpIoSession.m1898H().toString());
        this.f11068b.mo1913a(ftpIoSession);
    }

    @Override // org.apache.mina.core.p133e.IoHandlerAdapter, org.apache.mina.core.p133e.InterfaceC3064f
    /* renamed from: a */
    public void mo1202a(IoSession ioSession, IdleStatus idleStatus) throws Exception {
        this.f11068b.mo1909a(new FtpIoSession(ioSession, this.f11067a), idleStatus);
    }

    @Override // org.apache.mina.core.p133e.IoHandlerAdapter, org.apache.mina.core.p133e.InterfaceC3064f
    /* renamed from: c */
    public void mo1199c(IoSession ioSession) throws Exception {
        this.f11068b.mo1907b(new FtpIoSession(ioSession, this.f11067a));
    }
}
