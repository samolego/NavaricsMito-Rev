package org.apache.ftpserver.p118d;

import com.senseplay.sdk.constant.SPWebConstant;
import java.io.IOException;
import java.nio.charset.MalformedInputException;
import org.apache.ftpserver.ftplet.DefaultFtpReply;
import org.apache.ftpserver.ftplet.FileSystemView;
import org.apache.ftpserver.ftplet.FtpReply;
import org.apache.ftpserver.ftplet.FtpRequest;
import org.apache.ftpserver.ftplet.FtpletResult;
import org.apache.ftpserver.p110a.Command;
import org.apache.ftpserver.p116c.FtpletContainer;
import org.apache.ftpserver.p119e.Listener;
import org.apache.mina.core.session.IdleStatus;
import org.apache.mina.core.write.WriteToClosedSessionException;
import org.apache.mina.filter.codec.ProtocolDecoderException;
import org.slf4j.C3154c;
import org.slf4j.InterfaceC3153b;

/* renamed from: org.apache.ftpserver.d.c */
/* loaded from: classes2.dex */
public class DefaultFtpHandler implements FtpHandler {

    /* renamed from: b */
    private static final String[] f10981b = {"USER", "PASS", "AUTH", "QUIT", "PROT", "PBSZ"};

    /* renamed from: a */
    private final InterfaceC3153b f10982a = C3154c.m262a(DefaultFtpHandler.class);

    /* renamed from: c */
    private FtpServerContext f10983c;

    /* renamed from: d */
    private Listener f10984d;

    @Override // org.apache.ftpserver.p118d.FtpHandler
    /* renamed from: a */
    public void mo1911a(FtpIoSession ftpIoSession, FtpReply ftpReply) throws Exception {
    }

    @Override // org.apache.ftpserver.p118d.FtpHandler
    /* renamed from: a */
    public void mo1908a(FtpServerContext ftpServerContext, Listener listener) {
        this.f10983c = ftpServerContext;
        this.f10984d = listener;
    }

    @Override // org.apache.ftpserver.p118d.FtpHandler
    /* renamed from: a */
    public void mo1913a(FtpIoSession ftpIoSession) throws Exception {
        ftpIoSession.m1888a(this.f10984d);
        ServerFtpStatistics serverFtpStatistics = (ServerFtpStatistics) this.f10983c.mo1720c();
        if (serverFtpStatistics != null) {
            serverFtpStatistics.mo1829a(ftpIoSession);
        }
    }

    @Override // org.apache.ftpserver.p118d.FtpHandler
    /* renamed from: b */
    public void mo1907b(FtpIoSession ftpIoSession) throws Exception {
        FtpletResult ftpletResult;
        try {
            ftpletResult = this.f10983c.mo1857e().mo1727a(ftpIoSession.m1873x());
        } catch (Exception e) {
            this.f10982a.debug("Ftplet threw exception", (Throwable) e);
            ftpletResult = FtpletResult.DISCONNECT;
        }
        if (ftpletResult == FtpletResult.DISCONNECT) {
            this.f10982a.debug("Ftplet returned DISCONNECT, session will be closed");
            ftpIoSession.mo1011a(false).mo963a(10000L);
            return;
        }
        ftpIoSession.m1893M();
        ftpIoSession.mo1001e(LocalizedFtpReply.m1839a(ftpIoSession, null, this.f10983c, 220, null, null));
    }

    @Override // org.apache.ftpserver.p118d.FtpHandler
    /* renamed from: c */
    public void mo1906c(FtpIoSession ftpIoSession) throws Exception {
        this.f10982a.debug("Closing session");
        try {
            this.f10983c.mo1857e().mo1723b(ftpIoSession.m1873x());
        } catch (Exception e) {
            this.f10982a.warn("Ftplet threw an exception on disconnect", (Throwable) e);
        }
        try {
            ServerDataConnectionFactory m1878s = ftpIoSession.m1878s();
            if (m1878s != null) {
                m1878s.mo1780b();
            }
        } catch (Exception e2) {
            this.f10982a.warn("Data connection threw an exception on disconnect", (Throwable) e2);
        }
        FileSystemView m1877t = ftpIoSession.m1877t();
        if (m1877t != null) {
            try {
                m1877t.mo1773b();
            } catch (Exception e3) {
                this.f10982a.warn("FileSystemView threw an exception on disposal", (Throwable) e3);
            }
        }
        ServerFtpStatistics serverFtpStatistics = (ServerFtpStatistics) this.f10983c.mo1720c();
        if (serverFtpStatistics != null) {
            serverFtpStatistics.mo1820e(ftpIoSession);
            serverFtpStatistics.mo1826b(ftpIoSession);
            this.f10982a.debug("Statistics login and connection count decreased due to session close");
        } else {
            this.f10982a.warn("Statistics not available in session, can not decrease login and connection count");
        }
        this.f10982a.debug("Session closed");
    }

    @Override // org.apache.ftpserver.p118d.FtpHandler
    /* renamed from: a */
    public void mo1912a(FtpIoSession ftpIoSession, Throwable th) throws Exception {
        if ((th instanceof ProtocolDecoderException) && (th.getCause() instanceof MalformedInputException)) {
            this.f10982a.warn("Client sent command that could not be decoded: {}", ((ProtocolDecoderException) th).getHexdump());
            ftpIoSession.mo1001e(new DefaultFtpReply(501, "Invalid character in command"));
        } else if (th instanceof WriteToClosedSessionException) {
            this.f10982a.warn("Client closed connection before all replies could be sent, last reply was {}", ((WriteToClosedSessionException) th).getRequest());
            ftpIoSession.mo1011a(false).mo963a(10000L);
        } else {
            this.f10982a.error("Exception caught, closing session", th);
            ftpIoSession.mo1011a(false).mo963a(10000L);
        }
    }

    /* renamed from: a */
    private boolean m1936a(String str) {
        for (String str2 : f10981b) {
            if (str2.equals(str)) {
                return true;
            }
        }
        return false;
    }

    @Override // org.apache.ftpserver.p118d.FtpHandler
    /* renamed from: a */
    public void mo1910a(FtpIoSession ftpIoSession, FtpRequest ftpRequest) throws Exception {
        FtpletResult ftpletResult;
        FtpletResult ftpletResult2;
        try {
            ftpIoSession.m1893M();
            String mo1749b = ftpRequest.mo1749b();
            Command mo1970a = this.f10983c.mo1856f().mo1970a(mo1749b);
            if (!ftpIoSession.m1875v() && !m1936a(mo1749b)) {
                ftpIoSession.mo1001e(LocalizedFtpReply.m1839a(ftpIoSession, ftpRequest, this.f10983c, 530, SPWebConstant.Permission, null));
                return;
            }
            FtpletContainer mo1857e = this.f10983c.mo1857e();
            try {
                ftpletResult = mo1857e.mo1726a(ftpIoSession.m1873x(), ftpRequest);
            } catch (Exception e) {
                this.f10982a.debug("Ftplet container threw exception", (Throwable) e);
                ftpletResult = FtpletResult.DISCONNECT;
            }
            if (ftpletResult == FtpletResult.DISCONNECT) {
                this.f10982a.debug("Ftplet returned DISCONNECT, session will be closed");
                ftpIoSession.mo1011a(false).mo963a(10000L);
            } else if (ftpletResult != FtpletResult.SKIP) {
                if (mo1970a != null) {
                    synchronized (ftpIoSession) {
                        mo1970a.mo1971a(ftpIoSession, this.f10983c, ftpRequest);
                    }
                } else {
                    ftpIoSession.mo1001e(LocalizedFtpReply.m1839a(ftpIoSession, ftpRequest, this.f10983c, 502, "not.implemented", null));
                }
                try {
                    ftpletResult2 = mo1857e.mo1725a(ftpIoSession.m1873x(), ftpRequest, ftpIoSession.m1892O());
                } catch (Exception e2) {
                    this.f10982a.debug("Ftplet container threw exception", (Throwable) e2);
                    ftpletResult2 = FtpletResult.DISCONNECT;
                }
                if (ftpletResult2 == FtpletResult.DISCONNECT) {
                    this.f10982a.debug("Ftplet returned DISCONNECT, session will be closed");
                    ftpIoSession.mo1011a(false).mo963a(10000L);
                }
            }
        } catch (Exception e3) {
            try {
                ftpIoSession.mo1001e(LocalizedFtpReply.m1839a(ftpIoSession, ftpRequest, this.f10983c, 550, null, null));
            } catch (Exception unused) {
            }
            if (e3 instanceof IOException) {
                throw ((IOException) e3);
            }
            this.f10982a.warn("RequestHandler.service()", (Throwable) e3);
        }
    }

    @Override // org.apache.ftpserver.p118d.FtpHandler
    /* renamed from: a */
    public void mo1909a(FtpIoSession ftpIoSession, IdleStatus idleStatus) throws Exception {
        this.f10982a.info("Session idle, closing");
        ftpIoSession.mo1011a(false).mo963a(10000L);
    }
}
