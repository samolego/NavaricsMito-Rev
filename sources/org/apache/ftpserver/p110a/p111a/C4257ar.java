package org.apache.ftpserver.p110a.p111a;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.util.Map;
import org.apache.ftpserver.ftplet.DefaultFtpReply;
import org.apache.ftpserver.ftplet.FtpException;
import org.apache.ftpserver.ftplet.FtpRequest;
import org.apache.ftpserver.p110a.AbstractCommand;
import org.apache.ftpserver.p118d.FtpIoSession;
import org.apache.ftpserver.p118d.FtpServerContext;
import org.apache.ftpserver.p118d.LocalizedFtpReply;
import org.apache.ftpserver.util.C3035f;
import org.apache.ftpserver.util.DateUtils;
import org.apache.mina.core.session.IoSession;

/* renamed from: org.apache.ftpserver.a.a.ar */
/* loaded from: classes2.dex */
public class SITE_WHO extends AbstractCommand {
    @Override // org.apache.ftpserver.p110a.Command
    /* renamed from: a */
    public void mo1971a(FtpIoSession ftpIoSession, FtpServerContext ftpServerContext, FtpRequest ftpRequest) throws IOException, FtpException {
        ftpIoSession.m1879r();
        if (!ftpServerContext.mo1722a().mo1718c(ftpIoSession.m1876u().mo1717a())) {
            ftpIoSession.mo1001e(LocalizedFtpReply.m1839a(ftpIoSession, ftpRequest, ftpServerContext, 530, "SITE", null));
            return;
        }
        StringBuilder sb = new StringBuilder();
        Map<Long, IoSession> mo1193s = ftpIoSession.mo993m().mo1193s();
        sb.append('\n');
        for (IoSession ioSession : mo1193s.values()) {
            FtpIoSession ftpIoSession2 = new FtpIoSession(ioSession, ftpServerContext);
            if (ftpIoSession2.m1875v()) {
                sb.append(C3035f.m1655a(ftpIoSession2.m1876u().mo1717a(), ' ', true, 16));
                if (ftpIoSession2.mo994l() instanceof InetSocketAddress) {
                    sb.append(C3035f.m1655a(((InetSocketAddress) ftpIoSession2.mo994l()).getAddress().getHostAddress(), ' ', true, 16));
                }
                sb.append(C3035f.m1655a(DateUtils.m1671b(ftpIoSession2.m1896J().getTime()), ' ', true, 20));
                sb.append(C3035f.m1655a(DateUtils.m1671b(ftpIoSession2.m1895K().getTime()), ' ', true, 20));
                sb.append('\n');
            }
        }
        sb.append('\n');
        ftpIoSession.mo1001e(new DefaultFtpReply(200, sb.toString()));
    }
}
