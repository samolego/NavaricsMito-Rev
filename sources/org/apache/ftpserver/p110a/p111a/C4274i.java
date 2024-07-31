package org.apache.ftpserver.p110a.p111a;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.UnknownHostException;
import org.apache.ftpserver.DataConnectionConfiguration;
import org.apache.ftpserver.ftplet.FtpRequest;
import org.apache.ftpserver.p110a.AbstractCommand;
import org.apache.ftpserver.p118d.FtpIoSession;
import org.apache.ftpserver.p118d.FtpServerContext;
import org.apache.ftpserver.p118d.LocalizedFtpReply;
import org.slf4j.C3154c;
import org.slf4j.InterfaceC3153b;

/* renamed from: org.apache.ftpserver.a.a.i */
/* loaded from: classes2.dex */
public class EPRT extends AbstractCommand {

    /* renamed from: a */
    private final InterfaceC3153b f10903a = C3154c.m262a(EPRT.class);

    @Override // org.apache.ftpserver.p110a.Command
    /* renamed from: a */
    public void mo1971a(FtpIoSession ftpIoSession, FtpServerContext ftpServerContext, FtpRequest ftpRequest) throws IOException {
        String str;
        ftpIoSession.m1879r();
        String mo1748c = ftpRequest.mo1748c();
        if (mo1748c == null) {
            ftpIoSession.mo1001e(LocalizedFtpReply.m1839a(ftpIoSession, ftpRequest, ftpServerContext, 501, "EPRT", null));
            return;
        }
        DataConnectionConfiguration mo1804c = ftpIoSession.m1874w().mo1804c();
        if (!mo1804c.mo1946b()) {
            ftpIoSession.mo1001e(LocalizedFtpReply.m1839a(ftpIoSession, ftpRequest, ftpServerContext, 501, "EPRT.disabled", null));
            return;
        }
        try {
            int indexOf = mo1748c.indexOf(mo1748c.charAt(0), 3);
            String substring = mo1748c.substring(3, indexOf);
            String substring2 = mo1748c.substring(indexOf + 1, mo1748c.length() - 1);
            try {
                InetAddress byName = InetAddress.getByName(substring);
                if (mo1804c.mo1945c() && (ftpIoSession.mo994l() instanceof InetSocketAddress) && !byName.equals(((InetSocketAddress) ftpIoSession.mo994l()).getAddress())) {
                    ftpIoSession.mo1001e(LocalizedFtpReply.m1839a(ftpIoSession, ftpRequest, ftpServerContext, 501, "EPRT.mismatch", null));
                    return;
                }
                try {
                    ftpIoSession.m1878s().mo1834a(new InetSocketAddress(byName, Integer.parseInt(substring2)));
                    ftpIoSession.mo1001e(LocalizedFtpReply.m1839a(ftpIoSession, ftpRequest, ftpServerContext, 200, "EPRT", null));
                } catch (NumberFormatException e) {
                    InterfaceC3153b interfaceC3153b = this.f10903a;
                    interfaceC3153b.debug("Invalid port: " + str, (Throwable) e);
                    ftpIoSession.mo1001e(LocalizedFtpReply.m1839a(ftpIoSession, ftpRequest, ftpServerContext, 501, "EPRT.invalid", null));
                }
            } catch (UnknownHostException e2) {
                InterfaceC3153b interfaceC3153b2 = this.f10903a;
                interfaceC3153b2.debug("Unknown host: " + substring, (Throwable) e2);
                ftpIoSession.mo1001e(LocalizedFtpReply.m1839a(ftpIoSession, ftpRequest, ftpServerContext, 501, "EPRT.host", null));
            }
        } catch (Exception e3) {
            InterfaceC3153b interfaceC3153b3 = this.f10903a;
            interfaceC3153b3.debug("Exception parsing host and port: " + mo1748c, (Throwable) e3);
            ftpIoSession.mo1001e(LocalizedFtpReply.m1839a(ftpIoSession, ftpRequest, ftpServerContext, 501, "EPRT", null));
        }
    }
}
