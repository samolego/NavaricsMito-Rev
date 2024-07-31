package org.apache.ftpserver.p110a.p111a;

import java.io.IOException;
import java.net.InetSocketAddress;
import org.apache.ftpserver.ftplet.FtpException;
import org.apache.ftpserver.ftplet.FtpRequest;
import org.apache.ftpserver.ftplet.User;
import org.apache.ftpserver.p110a.AbstractCommand;
import org.apache.ftpserver.p118d.FtpIoSession;
import org.apache.ftpserver.p118d.FtpServerContext;
import org.apache.ftpserver.p118d.LocalizedFtpReply;
import org.apache.ftpserver.p118d.ServerFtpStatistics;
import org.apache.ftpserver.p123g.p124a.ConcurrentLoginRequest;
import org.apache.mina.filter.logging.MdcInjectionFilter;
import org.slf4j.C3154c;
import org.slf4j.InterfaceC3153b;

/* renamed from: org.apache.ftpserver.a.a.ba */
/* loaded from: classes2.dex */
public class USER extends AbstractCommand {

    /* renamed from: a */
    private final InterfaceC3153b f10895a = C3154c.m262a(USER.class);

    @Override // org.apache.ftpserver.p110a.Command
    /* renamed from: a */
    public void mo1971a(FtpIoSession ftpIoSession, FtpServerContext ftpServerContext, FtpRequest ftpRequest) throws IOException, FtpException {
        ServerFtpStatistics serverFtpStatistics = (ServerFtpStatistics) ftpServerContext.mo1720c();
        boolean z = true;
        try {
            ftpIoSession.m1879r();
            String mo1748c = ftpRequest.mo1748c();
            if (mo1748c == null) {
                ftpIoSession.mo1001e(LocalizedFtpReply.m1839a(ftpIoSession, ftpRequest, ftpServerContext, 501, "USER", null));
                this.f10895a.debug("User failed to login, session will be closed");
                ftpIoSession.mo1011a(false).mo963a(10000L);
                return;
            }
            MdcInjectionFilter.m822a(ftpIoSession, "userName", mo1748c);
            User m1876u = ftpIoSession.m1876u();
            if (ftpIoSession.m1875v()) {
                if (mo1748c.equals(m1876u.mo1717a())) {
                    ftpIoSession.mo1001e(LocalizedFtpReply.m1839a(ftpIoSession, ftpRequest, ftpServerContext, 230, "USER", null));
                } else {
                    ftpIoSession.mo1001e(LocalizedFtpReply.m1839a(ftpIoSession, ftpRequest, ftpServerContext, 530, "USER.invalid", null));
                    z = false;
                }
                if (z) {
                    return;
                }
                this.f10895a.debug("User failed to login, session will be closed");
                ftpIoSession.mo1011a(false).mo963a(10000L);
                return;
            }
            boolean equals = mo1748c.equals("anonymous");
            if (equals && !ftpServerContext.mo1853i().mo1950e()) {
                ftpIoSession.mo1001e(LocalizedFtpReply.m1839a(ftpIoSession, ftpRequest, ftpServerContext, 530, "USER.anonymous", null));
                this.f10895a.debug("User failed to login, session will be closed");
                ftpIoSession.mo1011a(false).mo963a(10000L);
                return;
            }
            int n = serverFtpStatistics.mo1729n();
            int mo1952c = ftpServerContext.mo1853i().mo1952c();
            if (mo1952c == 0) {
                this.f10895a.debug("Currently {} anonymous users logged in, unlimited allowed", Integer.valueOf(n));
            } else {
                this.f10895a.debug("Currently {} out of {} anonymous users logged in", Integer.valueOf(n), Integer.valueOf(mo1952c));
            }
            if (equals && n >= mo1952c) {
                this.f10895a.debug("Too many anonymous users logged in, user will be disconnected");
                ftpIoSession.mo1001e(LocalizedFtpReply.m1839a(ftpIoSession, ftpRequest, ftpServerContext, 421, "USER.anonymous", null));
                this.f10895a.debug("User failed to login, session will be closed");
                ftpIoSession.mo1011a(false).mo963a(10000L);
                return;
            }
            int l = serverFtpStatistics.mo1731l();
            int mo1951d = ftpServerContext.mo1853i().mo1951d();
            if (mo1951d == 0) {
                this.f10895a.debug("Currently {} users logged in, unlimited allowed", Integer.valueOf(l));
            } else {
                this.f10895a.debug("Currently {} out of {} users logged in", Integer.valueOf(l), Integer.valueOf(mo1951d));
            }
            if (mo1951d != 0 && l >= mo1951d) {
                this.f10895a.debug("Too many users logged in, user will be disconnected");
                ftpIoSession.mo1001e(LocalizedFtpReply.m1839a(ftpIoSession, ftpRequest, ftpServerContext, 421, "USER.login", null));
                this.f10895a.debug("User failed to login, session will be closed");
                ftpIoSession.mo1011a(false).mo963a(10000L);
                return;
            }
            User mo1698a = ftpServerContext.mo1722a().mo1698a(mo1748c);
            if (mo1698a != null) {
                if (mo1698a.mo1713a(new ConcurrentLoginRequest(serverFtpStatistics.mo1743a(mo1698a) + 1, serverFtpStatistics.mo1742a(mo1698a, ftpIoSession.mo994l() instanceof InetSocketAddress ? ((InetSocketAddress) ftpIoSession.mo994l()).getAddress() : null) + 1)) == null) {
                    this.f10895a.debug("User logged in too many sessions, user will be disconnected");
                    ftpIoSession.mo1001e(LocalizedFtpReply.m1839a(ftpIoSession, ftpRequest, ftpServerContext, 421, "USER.login", null));
                    this.f10895a.debug("User failed to login, session will be closed");
                    ftpIoSession.mo1011a(false).mo963a(10000L);
                    return;
                }
            }
            try {
                ftpIoSession.m1881b(mo1748c);
                if (equals) {
                    ftpIoSession.mo1001e(LocalizedFtpReply.m1839a(ftpIoSession, ftpRequest, ftpServerContext, 331, "USER.anonymous", mo1748c));
                } else {
                    ftpIoSession.mo1001e(LocalizedFtpReply.m1839a(ftpIoSession, ftpRequest, ftpServerContext, 331, "USER", mo1748c));
                }
            } catch (Throwable th) {
                th = th;
                if (!z) {
                    this.f10895a.debug("User failed to login, session will be closed");
                    ftpIoSession.mo1011a(false).mo963a(10000L);
                }
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            z = false;
        }
    }
}
