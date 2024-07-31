package org.apache.ftpserver;

import org.apache.ftpserver.ftplet.UserManager;
import org.apache.ftpserver.p118d.DefaultFtpServer;
import org.apache.ftpserver.p118d.DefaultFtpServerContext;
import org.apache.ftpserver.p119e.Listener;

/* renamed from: org.apache.ftpserver.f */
/* loaded from: classes2.dex */
public class FtpServerFactory {

    /* renamed from: a */
    private DefaultFtpServerContext f11089a = new DefaultFtpServerContext();

    /* renamed from: a */
    public FtpServer m1792a() {
        return new DefaultFtpServer(this.f11089a);
    }

    /* renamed from: a */
    public void m1791a(String str, Listener listener) {
        this.f11089a.m1933a(str, listener);
    }

    /* renamed from: b */
    public UserManager m1789b() {
        return this.f11089a.mo1722a();
    }

    /* renamed from: a */
    public void m1790a(ConnectionConfig connectionConfig) {
        this.f11089a.m1932a(connectionConfig);
    }
}
