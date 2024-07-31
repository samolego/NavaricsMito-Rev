package org.apache.ftpserver.p110a.p111a;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.Arrays;
import java.util.List;
import org.apache.ftpserver.ftplet.FtpException;
import org.apache.ftpserver.ftplet.FtpRequest;
import org.apache.ftpserver.p110a.AbstractCommand;
import org.apache.ftpserver.p118d.FtpIoSession;
import org.apache.ftpserver.p118d.FtpServerContext;
import org.apache.ftpserver.p118d.LocalizedFtpReply;
import org.apache.ftpserver.ssl.ClientAuth;
import org.apache.ftpserver.ssl.SslConfiguration;
import org.apache.mina.filter.p136c.SslFilter;
import org.slf4j.C3154c;
import org.slf4j.InterfaceC3153b;

/* renamed from: org.apache.ftpserver.a.a.d */
/* loaded from: classes2.dex */
public class AUTH extends AbstractCommand {

    /* renamed from: b */
    private static final List<String> f10897b = Arrays.asList("SSL", "TLS", "TLS-C", "TLS-P");

    /* renamed from: a */
    private final InterfaceC3153b f10898a = C3154c.m262a(AUTH.class);

    @Override // org.apache.ftpserver.p110a.Command
    /* renamed from: a */
    public void mo1971a(FtpIoSession ftpIoSession, FtpServerContext ftpServerContext, FtpRequest ftpRequest) throws IOException, FtpException {
        ftpIoSession.m1879r();
        if (!ftpRequest.mo1747d()) {
            ftpIoSession.mo1001e(LocalizedFtpReply.m1839a(ftpIoSession, ftpRequest, ftpServerContext, 501, "AUTH", null));
        } else if (ftpIoSession.m1874w().mo1805b() == null) {
            ftpIoSession.mo1001e(LocalizedFtpReply.m1839a(ftpIoSession, ftpRequest, ftpServerContext, 431, "AUTH", null));
        } else if (ftpIoSession.mo1002e().mo1092c(SslFilter.class)) {
            ftpIoSession.mo1001e(LocalizedFtpReply.m1839a(ftpIoSession, ftpRequest, ftpServerContext, 534, "AUTH", null));
        } else {
            String upperCase = ftpRequest.mo1748c().toUpperCase();
            if (f10897b.contains(upperCase)) {
                if (upperCase.equals("TLS-C")) {
                    upperCase = "TLS";
                } else if (upperCase.equals("TLS-P")) {
                    upperCase = "SSL";
                }
                try {
                    m1975a(ftpIoSession, upperCase);
                    ftpIoSession.mo1001e(LocalizedFtpReply.m1839a(ftpIoSession, ftpRequest, ftpServerContext, 234, "AUTH." + upperCase, null));
                    return;
                } catch (FtpException e) {
                    throw e;
                } catch (Exception e2) {
                    this.f10898a.warn("AUTH.execute()", (Throwable) e2);
                    throw new FtpException("AUTH.execute()", e2);
                }
            }
            ftpIoSession.mo1001e(LocalizedFtpReply.m1839a(ftpIoSession, ftpRequest, ftpServerContext, 502, "AUTH", null));
        }
    }

    /* renamed from: a */
    private void m1975a(FtpIoSession ftpIoSession, String str) throws GeneralSecurityException, FtpException {
        SslConfiguration mo1805b = ftpIoSession.m1874w().mo1805b();
        if (mo1805b != null) {
            ftpIoSession.mo1003d(SslFilter.f11576b);
            SslFilter sslFilter = new SslFilter(mo1805b.m1676b());
            if (mo1805b.m1674d() == ClientAuth.NEED) {
                sslFilter.m910a(true);
            } else if (mo1805b.m1674d() == ClientAuth.WANT) {
                sslFilter.m904b(true);
            }
            if (mo1805b.m1675c() != null) {
                sslFilter.m909a(mo1805b.m1675c());
            }
            ftpIoSession.mo1002e().mo1102a("sslSessionFilter", sslFilter);
            if ("SSL".equals(str)) {
                ftpIoSession.m1878s().mo1833a(true);
                return;
            }
            return;
        }
        throw new FtpException("Socket factory SSL not configured");
    }
}
