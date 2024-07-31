package org.apache.ftpserver.p110a.p111a;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.UnknownHostException;
import org.apache.ftpserver.DataConnectionConfiguration;
import org.apache.ftpserver.ftplet.FtpRequest;
import org.apache.ftpserver.p110a.AbstractCommand;
import org.apache.ftpserver.p118d.FtpIoSession;
import org.apache.ftpserver.p118d.FtpServerContext;
import org.apache.ftpserver.p118d.LocalizedFtpReply;
import org.apache.ftpserver.util.IllegalInetAddressException;
import org.apache.ftpserver.util.IllegalPortException;
import org.apache.ftpserver.util.SocketAddressEncoder;
import org.slf4j.C3154c;
import org.slf4j.InterfaceC3153b;

/* renamed from: org.apache.ftpserver.a.a.ad */
/* loaded from: classes2.dex */
public class PORT extends AbstractCommand {

    /* renamed from: a */
    private final InterfaceC3153b f10878a = C3154c.m262a(PORT.class);

    @Override // org.apache.ftpserver.p110a.Command
    /* renamed from: a */
    public void mo1971a(FtpIoSession ftpIoSession, FtpServerContext ftpServerContext, FtpRequest ftpRequest) throws IOException {
        ftpIoSession.m1879r();
        if (!ftpRequest.mo1747d()) {
            ftpIoSession.mo1001e(LocalizedFtpReply.m1839a(ftpIoSession, ftpRequest, ftpServerContext, 501, "PORT", null));
            return;
        }
        DataConnectionConfiguration mo1804c = ftpIoSession.m1874w().mo1804c();
        if (!mo1804c.mo1946b()) {
            ftpIoSession.mo1001e(LocalizedFtpReply.m1839a(ftpIoSession, ftpRequest, ftpServerContext, 501, "PORT.disabled", null));
            return;
        }
        try {
            InetSocketAddress m1658a = SocketAddressEncoder.m1658a(ftpRequest.mo1748c());
            if (m1658a.getPort() == 0) {
                throw new IllegalPortException("PORT port must not be 0");
            }
            if (mo1804c.mo1945c() && (ftpIoSession.mo994l() instanceof InetSocketAddress)) {
                if (!m1658a.getAddress().equals(((InetSocketAddress) ftpIoSession.mo994l()).getAddress())) {
                    ftpIoSession.mo1001e(LocalizedFtpReply.m1839a(ftpIoSession, ftpRequest, ftpServerContext, 501, "PORT.mismatch", null));
                    return;
                }
            }
            ftpIoSession.m1878s().mo1834a(m1658a);
            ftpIoSession.mo1001e(LocalizedFtpReply.m1839a(ftpIoSession, ftpRequest, ftpServerContext, 200, "PORT", null));
        } catch (UnknownHostException e) {
            this.f10878a.debug("Unknown host", (Throwable) e);
            ftpIoSession.mo1001e(LocalizedFtpReply.m1839a(ftpIoSession, ftpRequest, ftpServerContext, 501, "PORT.host", null));
        } catch (IllegalInetAddressException unused) {
            ftpIoSession.mo1001e(LocalizedFtpReply.m1839a(ftpIoSession, ftpRequest, ftpServerContext, 501, "PORT", null));
        } catch (IllegalPortException e2) {
            InterfaceC3153b interfaceC3153b = this.f10878a;
            interfaceC3153b.debug("Invalid data port: " + ftpRequest.mo1748c(), (Throwable) e2);
            ftpIoSession.mo1001e(LocalizedFtpReply.m1839a(ftpIoSession, ftpRequest, ftpServerContext, 501, "PORT.invalid", null));
        }
    }
}
