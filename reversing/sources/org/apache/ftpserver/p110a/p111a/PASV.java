package org.apache.ftpserver.p110a.p111a;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.UnknownHostException;
import org.apache.ftpserver.DataConnectionException;
import org.apache.ftpserver.ftplet.FtpException;
import org.apache.ftpserver.ftplet.FtpRequest;
import org.apache.ftpserver.p110a.AbstractCommand;
import org.apache.ftpserver.p118d.FtpIoSession;
import org.apache.ftpserver.p118d.FtpServerContext;
import org.apache.ftpserver.p118d.LocalizedFtpReply;
import org.apache.ftpserver.p118d.ServerDataConnectionFactory;
import org.apache.ftpserver.util.SocketAddressEncoder;
import org.slf4j.C3154c;
import org.slf4j.InterfaceC3153b;

/* renamed from: org.apache.ftpserver.a.a.ab */
/* loaded from: classes2.dex */
public class PASV extends AbstractCommand {

    /* renamed from: a */
    private final InterfaceC3153b f10877a = C3154c.m262a(PASV.class);

    @Override // org.apache.ftpserver.p110a.Command
    /* renamed from: a */
    public void mo1971a(FtpIoSession ftpIoSession, FtpServerContext ftpServerContext, FtpRequest ftpRequest) throws IOException, FtpException {
        InetAddress address;
        ftpIoSession.m1879r();
        ServerDataConnectionFactory m1878s = ftpIoSession.m1878s();
        String m1979a = m1979a(ftpIoSession);
        try {
            InetSocketAddress mo1831c = m1878s.mo1831c();
            if (m1979a != null) {
                address = m1980a(m1979a);
            } else {
                address = mo1831c.getAddress();
            }
            ftpIoSession.mo1001e(LocalizedFtpReply.m1839a(ftpIoSession, ftpRequest, ftpServerContext, 227, "PASV", SocketAddressEncoder.m1657a(new InetSocketAddress(address, mo1831c.getPort()))));
        } catch (DataConnectionException e) {
            this.f10877a.warn("Failed to open passive data connection", (Throwable) e);
            ftpIoSession.mo1001e(LocalizedFtpReply.m1839a(ftpIoSession, ftpRequest, ftpServerContext, 425, "PASV", null));
        }
    }

    /* renamed from: a */
    private InetAddress m1980a(String str) throws DataConnectionException {
        try {
            return InetAddress.getByName(str);
        } catch (UnknownHostException e) {
            throw new DataConnectionException(e.getLocalizedMessage(), e);
        }
    }

    /* renamed from: a */
    protected String m1979a(FtpIoSession ftpIoSession) {
        return ftpIoSession.m1874w().mo1804c().mo1941g();
    }
}
