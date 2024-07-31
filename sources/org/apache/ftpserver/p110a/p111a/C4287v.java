package org.apache.ftpserver.p110a.p111a;

import com.senseplay.sdk.config.CacheConfig;
import java.io.IOException;
import java.net.SocketException;
import org.apache.ftpserver.ftplet.DataConnection;
import org.apache.ftpserver.ftplet.DefaultFtpReply;
import org.apache.ftpserver.ftplet.FtpException;
import org.apache.ftpserver.ftplet.FtpRequest;
import org.apache.ftpserver.p110a.AbstractCommand;
import org.apache.ftpserver.p110a.p111a.p112a.DirectoryLister;
import org.apache.ftpserver.p110a.p111a.p112a.FileFormater;
import org.apache.ftpserver.p110a.p111a.p112a.LISTFileFormater;
import org.apache.ftpserver.p110a.p111a.p112a.ListArgument;
import org.apache.ftpserver.p110a.p111a.p112a.ListArgumentParser;
import org.apache.ftpserver.p110a.p111a.p112a.NLSTFileFormater;
import org.apache.ftpserver.p118d.FtpIoSession;
import org.apache.ftpserver.p118d.FtpServerContext;
import org.apache.ftpserver.p118d.IODataConnectionFactory;
import org.apache.ftpserver.p118d.LocalizedFtpReply;
import org.apache.ftpserver.p118d.ServerDataConnectionFactory;
import org.slf4j.C3154c;
import org.slf4j.InterfaceC3153b;

/* renamed from: org.apache.ftpserver.a.a.v */
/* loaded from: classes2.dex */
public class NLST extends AbstractCommand {

    /* renamed from: b */
    private static final NLSTFileFormater f10915b = new NLSTFileFormater();

    /* renamed from: c */
    private static final LISTFileFormater f10916c = new LISTFileFormater();

    /* renamed from: a */
    private final InterfaceC3153b f10917a = C3154c.m262a(NLST.class);

    /* renamed from: d */
    private final DirectoryLister f10918d = new DirectoryLister();

    @Override // org.apache.ftpserver.p110a.Command
    /* renamed from: a */
    public void mo1971a(FtpIoSession ftpIoSession, FtpServerContext ftpServerContext, FtpRequest ftpRequest) throws IOException, FtpException {
        FileFormater fileFormater;
        try {
            ftpIoSession.m1879r();
            ServerDataConnectionFactory m1878s = ftpIoSession.m1878s();
            if ((m1878s instanceof IODataConnectionFactory) && ((IODataConnectionFactory) m1878s).m1845d() == null) {
                ftpIoSession.mo1001e(new DefaultFtpReply(503, "PORT or PASV must be issued first"));
                ftpIoSession.m1878s().mo1780b();
                return;
            }
            ftpIoSession.mo1001e(LocalizedFtpReply.m1839a(ftpIoSession, ftpRequest, ftpServerContext, CacheConfig.Post_Delayed, "NLST", null));
            try {
                DataConnection a = ftpIoSession.m1878s().mo1781a();
                boolean z = true;
                try {
                    try {
                        ListArgument m1985a = ListArgumentParser.m1985a(ftpRequest.mo1748c());
                        if (m1985a.m1987a('l')) {
                            fileFormater = f10916c;
                        } else {
                            fileFormater = f10915b;
                        }
                        a.mo1782a(ftpIoSession.m1873x(), this.f10918d.m1993a(m1985a, ftpIoSession.m1877t(), fileFormater));
                    } catch (SocketException e) {
                        this.f10917a.debug("Socket exception during data transfer", (Throwable) e);
                        ftpIoSession.mo1001e(LocalizedFtpReply.m1839a(ftpIoSession, ftpRequest, ftpServerContext, 426, "NLST", null));
                    } catch (IOException e2) {
                        this.f10917a.debug("IOException during data transfer", (Throwable) e2);
                        ftpIoSession.mo1001e(LocalizedFtpReply.m1839a(ftpIoSession, ftpRequest, ftpServerContext, 551, "NLST", null));
                    }
                } catch (IllegalArgumentException e3) {
                    InterfaceC3153b interfaceC3153b = this.f10917a;
                    interfaceC3153b.debug("Illegal listing syntax: " + ftpRequest.mo1748c(), (Throwable) e3);
                    ftpIoSession.mo1001e(LocalizedFtpReply.m1839a(ftpIoSession, ftpRequest, ftpServerContext, 501, "LIST", null));
                }
                z = false;
                if (!z) {
                    ftpIoSession.mo1001e(LocalizedFtpReply.m1839a(ftpIoSession, ftpRequest, ftpServerContext, 226, "NLST", null));
                }
                ftpIoSession.m1878s().mo1780b();
            } catch (Exception e4) {
                this.f10917a.debug("Exception getting the output data stream", (Throwable) e4);
                ftpIoSession.mo1001e(LocalizedFtpReply.m1839a(ftpIoSession, ftpRequest, ftpServerContext, 425, "NLST", null));
                ftpIoSession.m1878s().mo1780b();
            }
        } catch (Throwable th) {
            ftpIoSession.m1878s().mo1780b();
            throw th;
        }
    }
}
