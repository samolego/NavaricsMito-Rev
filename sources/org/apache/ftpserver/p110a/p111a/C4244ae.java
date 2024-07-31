package org.apache.ftpserver.p110a.p111a;

import java.io.IOException;
import org.apache.ftpserver.ftplet.FtpException;
import org.apache.ftpserver.ftplet.FtpRequest;
import org.apache.ftpserver.p110a.AbstractCommand;
import org.apache.ftpserver.p118d.FtpIoSession;
import org.apache.ftpserver.p118d.FtpServerContext;
import org.apache.ftpserver.p118d.LocalizedFtpReply;
import org.apache.ftpserver.p118d.ServerDataConnectionFactory;
import org.apache.ftpserver.ssl.SslConfiguration;

/* renamed from: org.apache.ftpserver.a.a.ae */
/* loaded from: classes2.dex */
public class PROT extends AbstractCommand {
    /* renamed from: a */
    private SslConfiguration m1978a(FtpIoSession ftpIoSession) {
        SslConfiguration mo1938j = ftpIoSession.m1874w().mo1804c().mo1938j();
        return mo1938j == null ? ftpIoSession.m1874w().mo1805b() : mo1938j;
    }

    @Override // org.apache.ftpserver.p110a.Command
    /* renamed from: a */
    public void mo1971a(FtpIoSession ftpIoSession, FtpServerContext ftpServerContext, FtpRequest ftpRequest) throws IOException, FtpException {
        ftpIoSession.m1879r();
        String mo1748c = ftpRequest.mo1748c();
        if (mo1748c == null) {
            ftpIoSession.mo1001e(LocalizedFtpReply.m1839a(ftpIoSession, ftpRequest, ftpServerContext, 501, "PROT", null));
            return;
        }
        String upperCase = mo1748c.toUpperCase();
        ServerDataConnectionFactory m1878s = ftpIoSession.m1878s();
        if (upperCase.equals("C")) {
            m1878s.mo1833a(false);
            ftpIoSession.mo1001e(LocalizedFtpReply.m1839a(ftpIoSession, ftpRequest, ftpServerContext, 200, "PROT", null));
        } else if (upperCase.equals("P")) {
            if (m1978a(ftpIoSession) == null) {
                ftpIoSession.mo1001e(LocalizedFtpReply.m1839a(ftpIoSession, ftpRequest, ftpServerContext, 431, "PROT", null));
                return;
            }
            m1878s.mo1833a(true);
            ftpIoSession.mo1001e(LocalizedFtpReply.m1839a(ftpIoSession, ftpRequest, ftpServerContext, 200, "PROT", null));
        } else {
            ftpIoSession.mo1001e(LocalizedFtpReply.m1839a(ftpIoSession, ftpRequest, ftpServerContext, 504, "PROT", null));
        }
    }
}
