package org.apache.ftpserver.p110a.p111a;

import com.senseplay.sdk.config.CacheConfig;
import java.io.IOException;
import java.net.SocketException;
import org.apache.ftpserver.ftplet.DataConnection;
import org.apache.ftpserver.ftplet.DefaultFtpReply;
import org.apache.ftpserver.ftplet.FtpException;
import org.apache.ftpserver.ftplet.FtpFile;
import org.apache.ftpserver.ftplet.FtpRequest;
import org.apache.ftpserver.p110a.AbstractCommand;
import org.apache.ftpserver.p110a.p111a.p112a.DirectoryLister;
import org.apache.ftpserver.p110a.p111a.p112a.LISTFileFormater;
import org.apache.ftpserver.p110a.p111a.p112a.ListArgument;
import org.apache.ftpserver.p110a.p111a.p112a.ListArgumentParser;
import org.apache.ftpserver.p118d.FtpIoSession;
import org.apache.ftpserver.p118d.FtpServerContext;
import org.apache.ftpserver.p118d.IODataConnectionFactory;
import org.apache.ftpserver.p118d.LocalizedDataTransferFtpReply;
import org.apache.ftpserver.p118d.LocalizedFtpReply;
import org.apache.ftpserver.p118d.ServerDataConnectionFactory;
import org.slf4j.C3154c;
import org.slf4j.InterfaceC3153b;

/* renamed from: org.apache.ftpserver.a.a.n */
/* loaded from: classes2.dex */
public class LIST extends AbstractCommand {

    /* renamed from: b */
    private static final LISTFileFormater f10904b = new LISTFileFormater();

    /* renamed from: a */
    private final InterfaceC3153b f10905a = C3154c.m262a(LIST.class);

    /* renamed from: c */
    private final DirectoryLister f10906c = new DirectoryLister();

    @Override // org.apache.ftpserver.p110a.Command
    /* renamed from: a */
    public void mo1971a(FtpIoSession ftpIoSession, FtpServerContext ftpServerContext, FtpRequest ftpRequest) throws IOException, FtpException {
        try {
            ftpIoSession.m1879r();
            ListArgument m1985a = ListArgumentParser.m1985a(ftpRequest.mo1748c());
            FtpFile mo1774a = ftpIoSession.m1877t().mo1774a(m1985a.m1986b());
            if (!mo1774a.mo1762f()) {
                this.f10905a.debug("Listing on a non-existing file");
                ftpIoSession.mo1001e(LocalizedDataTransferFtpReply.m1842a(ftpIoSession, ftpRequest, ftpServerContext, 450, "LIST", null, mo1774a));
                ftpIoSession.m1878s().mo1780b();
                return;
            }
            ServerDataConnectionFactory m1878s = ftpIoSession.m1878s();
            if ((m1878s instanceof IODataConnectionFactory) && ((IODataConnectionFactory) m1878s).m1845d() == null) {
                ftpIoSession.mo1001e(new DefaultFtpReply(503, "PORT or PASV must be issued first"));
                ftpIoSession.m1878s().mo1780b();
                return;
            }
            ftpIoSession.mo1001e(LocalizedFtpReply.m1839a(ftpIoSession, ftpRequest, ftpServerContext, CacheConfig.Post_Delayed, "LIST", null));
            try {
                DataConnection a = ftpIoSession.m1878s().mo1781a();
                String m1993a = this.f10906c.m1993a(m1985a, ftpIoSession.m1877t(), f10904b);
                boolean z = true;
                try {
                    try {
                        a.mo1782a(ftpIoSession.m1873x(), m1993a);
                    } catch (IOException e) {
                        this.f10905a.debug("IOException during list transfer", (Throwable) e);
                        ftpIoSession.mo1001e(LocalizedDataTransferFtpReply.m1842a(ftpIoSession, ftpRequest, ftpServerContext, 551, "LIST", null, mo1774a));
                    } catch (IllegalArgumentException e2) {
                        InterfaceC3153b interfaceC3153b = this.f10905a;
                        interfaceC3153b.debug("Illegal list syntax: " + ftpRequest.mo1748c(), (Throwable) e2);
                        ftpIoSession.mo1001e(LocalizedDataTransferFtpReply.m1842a(ftpIoSession, ftpRequest, ftpServerContext, 501, "LIST", null, mo1774a));
                    }
                    z = false;
                } catch (SocketException e3) {
                    this.f10905a.debug("Socket exception during list transfer", (Throwable) e3);
                    ftpIoSession.mo1001e(LocalizedDataTransferFtpReply.m1842a(ftpIoSession, ftpRequest, ftpServerContext, 426, "LIST", null, mo1774a));
                }
                if (!z) {
                    ftpIoSession.mo1001e(LocalizedDataTransferFtpReply.m1841a(ftpIoSession, ftpRequest, ftpServerContext, 226, "LIST", null, mo1774a, m1993a.length()));
                }
                ftpIoSession.m1878s().mo1780b();
            } catch (Exception e4) {
                this.f10905a.debug("Exception getting the output data stream", (Throwable) e4);
                ftpIoSession.mo1001e(LocalizedDataTransferFtpReply.m1842a(ftpIoSession, ftpRequest, ftpServerContext, 425, "LIST", null, mo1774a));
                ftpIoSession.m1878s().mo1780b();
            }
        } catch (Throwable th) {
            ftpIoSession.m1878s().mo1780b();
            throw th;
        }
    }
}
