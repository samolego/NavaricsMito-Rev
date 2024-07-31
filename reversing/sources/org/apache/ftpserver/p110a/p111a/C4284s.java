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
import org.apache.ftpserver.p110a.p111a.p112a.ListArgumentParser;
import org.apache.ftpserver.p110a.p111a.p112a.MLSTFileFormater;
import org.apache.ftpserver.p118d.FtpIoSession;
import org.apache.ftpserver.p118d.FtpServerContext;
import org.apache.ftpserver.p118d.IODataConnectionFactory;
import org.apache.ftpserver.p118d.LocalizedFtpReply;
import org.apache.ftpserver.p118d.ServerDataConnectionFactory;
import org.slf4j.C3154c;
import org.slf4j.InterfaceC3153b;

/* renamed from: org.apache.ftpserver.a.a.s */
/* loaded from: classes2.dex */
public class MLSD extends AbstractCommand {

    /* renamed from: a */
    private final InterfaceC3153b f10912a = C3154c.m262a(MLSD.class);

    /* renamed from: b */
    private final DirectoryLister f10913b = new DirectoryLister();

    @Override // org.apache.ftpserver.p110a.Command
    /* renamed from: a */
    public void mo1971a(FtpIoSession ftpIoSession, FtpServerContext ftpServerContext, FtpRequest ftpRequest) throws IOException, FtpException {
        try {
            ftpIoSession.m1879r();
            ServerDataConnectionFactory m1878s = ftpIoSession.m1878s();
            if ((m1878s instanceof IODataConnectionFactory) && ((IODataConnectionFactory) m1878s).m1845d() == null) {
                ftpIoSession.mo1001e(new DefaultFtpReply(503, "PORT or PASV must be issued first"));
                ftpIoSession.m1878s().mo1780b();
                return;
            }
            ftpIoSession.mo1001e(LocalizedFtpReply.m1839a(ftpIoSession, ftpRequest, ftpServerContext, CacheConfig.Post_Delayed, "MLSD", null));
            try {
                DataConnection a = ftpIoSession.m1878s().mo1781a();
                boolean z = true;
                try {
                    try {
                        a.mo1782a(ftpIoSession.m1873x(), this.f10913b.m1993a(ListArgumentParser.m1985a(ftpRequest.mo1748c()), ftpIoSession.m1877t(), new MLSTFileFormater((String[]) ftpIoSession.mo1009b("MLST.types"))));
                    } catch (SocketException e) {
                        this.f10912a.debug("Socket exception during data transfer", (Throwable) e);
                        ftpIoSession.mo1001e(LocalizedFtpReply.m1839a(ftpIoSession, ftpRequest, ftpServerContext, 426, "MLSD", null));
                    } catch (IOException e2) {
                        this.f10912a.debug("IOException during data transfer", (Throwable) e2);
                        ftpIoSession.mo1001e(LocalizedFtpReply.m1839a(ftpIoSession, ftpRequest, ftpServerContext, 551, "MLSD", null));
                    }
                } catch (IllegalArgumentException e3) {
                    InterfaceC3153b interfaceC3153b = this.f10912a;
                    interfaceC3153b.debug("Illegal listing syntax: " + ftpRequest.mo1748c(), (Throwable) e3);
                    ftpIoSession.mo1001e(LocalizedFtpReply.m1839a(ftpIoSession, ftpRequest, ftpServerContext, 501, "MLSD", null));
                }
                z = false;
                if (!z) {
                    ftpIoSession.mo1001e(LocalizedFtpReply.m1839a(ftpIoSession, ftpRequest, ftpServerContext, 226, "MLSD", null));
                }
                ftpIoSession.m1878s().mo1780b();
            } catch (Exception e4) {
                this.f10912a.debug("Exception getting the output data stream", (Throwable) e4);
                ftpIoSession.mo1001e(LocalizedFtpReply.m1839a(ftpIoSession, ftpRequest, ftpServerContext, 425, "MLSD", null));
                ftpIoSession.m1878s().mo1780b();
            }
        } catch (Throwable th) {
            ftpIoSession.m1878s().mo1780b();
            throw th;
        }
    }
}
