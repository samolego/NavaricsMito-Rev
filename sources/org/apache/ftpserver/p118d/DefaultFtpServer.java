package org.apache.ftpserver.p118d;

import java.util.ArrayList;
import org.apache.ftpserver.FtpServer;
import org.apache.ftpserver.ftplet.FtpException;
import org.apache.ftpserver.p119e.Listener;
import org.slf4j.C3154c;
import org.slf4j.InterfaceC3153b;

/* renamed from: org.apache.ftpserver.d.e */
/* loaded from: classes2.dex */
public class DefaultFtpServer implements FtpServer {

    /* renamed from: b */
    private FtpServerContext f10990b;

    /* renamed from: a */
    private final InterfaceC3153b f10989a = C3154c.m262a(DefaultFtpServer.class);

    /* renamed from: c */
    private boolean f10991c = false;

    /* renamed from: d */
    private boolean f10992d = false;

    public DefaultFtpServer(FtpServerContext ftpServerContext) {
        this.f10990b = ftpServerContext;
    }

    @Override // org.apache.ftpserver.FtpServer
    /* renamed from: a */
    public void mo1809a() throws FtpException {
        if (this.f10990b == null) {
            throw new IllegalStateException("FtpServer has been stopped. Restart is not supported");
        }
        ArrayList<Listener> arrayList = new ArrayList();
        try {
            for (Listener listener : this.f10990b.mo1854h().values()) {
                listener.mo1797a(this.f10990b);
                arrayList.add(listener);
            }
            this.f10990b.mo1857e().mo1724a(this.f10990b);
            this.f10992d = true;
            this.f10989a.info("FTP server started");
        } catch (Exception e) {
            for (Listener listener2 : arrayList) {
                listener2.mo1798a();
            }
            if (e instanceof FtpException) {
                throw ((FtpException) e);
            }
            throw ((RuntimeException) e);
        }
    }

    @Override // org.apache.ftpserver.FtpServer
    /* renamed from: b */
    public void mo1808b() {
        FtpServerContext ftpServerContext = this.f10990b;
        if (ftpServerContext == null) {
            return;
        }
        for (Listener listener : ftpServerContext.mo1854h().values()) {
            listener.mo1798a();
        }
        this.f10990b.mo1857e().mo1728a();
        FtpServerContext ftpServerContext2 = this.f10990b;
        if (ftpServerContext2 != null) {
            ftpServerContext2.mo1855g();
            this.f10990b = null;
        }
        this.f10992d = false;
    }
}
