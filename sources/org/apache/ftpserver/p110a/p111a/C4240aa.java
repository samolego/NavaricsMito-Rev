package org.apache.ftpserver.p110a.p111a;

import java.io.IOException;
import java.net.InetSocketAddress;
import org.apache.ftpserver.ftplet.AuthenticationFailedException;
import org.apache.ftpserver.ftplet.FtpException;
import org.apache.ftpserver.ftplet.FtpRequest;
import org.apache.ftpserver.ftplet.User;
import org.apache.ftpserver.ftplet.UserManager;
import org.apache.ftpserver.p110a.AbstractCommand;
import org.apache.ftpserver.p118d.FtpIoSession;
import org.apache.ftpserver.p118d.FtpServerContext;
import org.apache.ftpserver.p118d.LocalizedFtpReply;
import org.apache.ftpserver.p118d.ServerFtpStatistics;
import org.apache.ftpserver.p123g.AnonymousAuthentication;
import org.apache.ftpserver.p123g.UsernamePasswordAuthentication;
import org.apache.ftpserver.p123g.p124a.UserMetadata;
import org.slf4j.C3154c;
import org.slf4j.InterfaceC3153b;

/* renamed from: org.apache.ftpserver.a.a.aa */
/* loaded from: classes2.dex */
public class PASS extends AbstractCommand {

    /* renamed from: a */
    private final InterfaceC3153b f10876a = C3154c.m262a(PASS.class);

    @Override // org.apache.ftpserver.p110a.Command
    /* renamed from: a */
    public void mo1971a(FtpIoSession ftpIoSession, FtpServerContext ftpServerContext, FtpRequest ftpRequest) throws IOException, FtpException {
        User user;
        boolean z;
        ServerFtpStatistics serverFtpStatistics = (ServerFtpStatistics) ftpServerContext.mo1720c();
        boolean z2 = false;
        try {
            ftpIoSession.m1879r();
            String mo1748c = ftpRequest.mo1748c();
            String m1871z = ftpIoSession.m1871z();
            if (m1871z == null && ftpIoSession.m1876u() == null) {
                ftpIoSession.mo1001e(LocalizedFtpReply.m1839a(ftpIoSession, ftpRequest, ftpServerContext, 503, "PASS", null));
                ftpIoSession.m1902D();
            } else if (ftpIoSession.m1875v()) {
                ftpIoSession.mo1001e(LocalizedFtpReply.m1839a(ftpIoSession, ftpRequest, ftpServerContext, 202, "PASS", null));
                ftpIoSession.m1902D();
            } else {
                boolean z3 = m1871z != null && m1871z.equals("anonymous");
                if (z3) {
                    int n = serverFtpStatistics.mo1729n();
                    int mo1952c = ftpServerContext.mo1853i().mo1952c();
                    if (mo1952c == 0) {
                        this.f10876a.debug("Currently {} anonymous users logged in, unlimited allowed", Integer.valueOf(n));
                    } else {
                        this.f10876a.debug("Currently {} out of {} anonymous users logged in", Integer.valueOf(n), Integer.valueOf(mo1952c));
                    }
                    if (n >= mo1952c) {
                        this.f10876a.debug("Too many anonymous users logged in, user will be disconnected");
                        ftpIoSession.mo1001e(LocalizedFtpReply.m1839a(ftpIoSession, ftpRequest, ftpServerContext, 421, "PASS.anonymous", null));
                        ftpIoSession.m1902D();
                        return;
                    }
                }
                int l = serverFtpStatistics.mo1731l();
                int mo1951d = ftpServerContext.mo1853i().mo1951d();
                if (mo1951d == 0) {
                    this.f10876a.debug("Currently {} users logged in, unlimited allowed", Integer.valueOf(l));
                } else {
                    this.f10876a.debug("Currently {} out of {} users logged in", Integer.valueOf(l), Integer.valueOf(mo1951d));
                }
                if (mo1951d != 0 && l >= mo1951d) {
                    this.f10876a.debug("Too many users logged in, user will be disconnected");
                    ftpIoSession.mo1001e(LocalizedFtpReply.m1839a(ftpIoSession, ftpRequest, ftpServerContext, 421, "PASS.login", null));
                    ftpIoSession.m1902D();
                    return;
                }
                UserManager a = ftpServerContext.mo1722a();
                try {
                    UserMetadata userMetadata = new UserMetadata();
                    if (ftpIoSession.mo994l() instanceof InetSocketAddress) {
                        userMetadata.m1687a(((InetSocketAddress) ftpIoSession.mo994l()).getAddress());
                    }
                    userMetadata.m1686a(ftpIoSession.m1894L());
                    user = a.mo1696a(z3 ? new AnonymousAuthentication(userMetadata) : new UsernamePasswordAuthentication(m1871z, mo1748c, userMetadata));
                } catch (AuthenticationFailedException unused) {
                    this.f10876a.warn("User failed to log in");
                    user = null;
                } catch (Exception e) {
                    this.f10876a.warn("PASS.execute()", (Throwable) e);
                    user = null;
                }
                User m1876u = ftpIoSession.m1876u();
                String m1871z2 = ftpIoSession.m1871z();
                int m1905A = ftpIoSession.m1905A();
                if (user == null) {
                    ftpIoSession.m1883a((User) null);
                    z = false;
                } else if (!user.mo1707d()) {
                    ftpIoSession.mo1001e(LocalizedFtpReply.m1839a(ftpIoSession, ftpRequest, ftpServerContext, 530, "PASS", null));
                    ftpIoSession.m1902D();
                    return;
                } else {
                    ftpIoSession.m1883a(user);
                    ftpIoSession.m1881b((String) null);
                    ftpIoSession.m1891a(user.mo1709c());
                    z = true;
                }
                try {
                    if (z) {
                        ftpIoSession.m1885a(ftpServerContext.mo1721b().mo1776a(user));
                        serverFtpStatistics.mo1823c(ftpIoSession);
                        ftpIoSession.mo1001e(LocalizedFtpReply.m1839a(ftpIoSession, ftpRequest, ftpServerContext, 230, "PASS", m1871z));
                        if (z3) {
                            this.f10876a.info("Anonymous login success - " + mo1748c);
                        } else {
                            this.f10876a.info("Login success - " + m1871z);
                        }
                        if (z) {
                            return;
                        }
                        ftpIoSession.m1902D();
                        return;
                    }
                    ftpIoSession.m1883a(m1876u);
                    ftpIoSession.m1881b(m1871z2);
                    ftpIoSession.m1891a(m1905A);
                    m1981a(ftpServerContext.mo1853i().mo1953b());
                    this.f10876a.warn("Login failure - " + m1871z);
                    ftpIoSession.mo1001e(LocalizedFtpReply.m1839a(ftpIoSession, ftpRequest, ftpServerContext, 530, "PASS", m1871z));
                    serverFtpStatistics.mo1821d(ftpIoSession);
                    ftpIoSession.m1904B();
                    int mo1954a = ftpServerContext.mo1853i().mo1954a();
                    if (mo1954a != 0 && ftpIoSession.m1903C() >= mo1954a) {
                        this.f10876a.warn("User exceeded the number of allowed failed logins, session will be closed");
                        ftpIoSession.mo1011a(false).mo963a(10000L);
                    }
                    if (z) {
                        return;
                    }
                    ftpIoSession.m1902D();
                } catch (Throwable th) {
                    th = th;
                    z2 = z;
                    if (!z2) {
                        ftpIoSession.m1902D();
                    }
                    throw th;
                }
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    /* renamed from: a */
    private void m1981a(int i) {
        if (i > 0) {
            InterfaceC3153b interfaceC3153b = this.f10876a;
            interfaceC3153b.debug("Waiting for " + i + " milliseconds due to login failure");
            try {
                Thread.sleep(i);
            } catch (InterruptedException unused) {
            }
        }
    }
}
