package org.apache.ftpserver.p110a.p111a;

import java.io.IOException;
import org.apache.ftpserver.ftplet.DefaultFtpReply;
import org.apache.ftpserver.ftplet.FtpException;
import org.apache.ftpserver.ftplet.FtpRequest;
import org.apache.ftpserver.ftplet.User;
import org.apache.ftpserver.ftplet.UserManager;
import org.apache.ftpserver.p110a.AbstractCommand;
import org.apache.ftpserver.p118d.FtpIoSession;
import org.apache.ftpserver.p118d.FtpServerContext;
import org.apache.ftpserver.p118d.LocalizedFtpReply;
import org.apache.ftpserver.p123g.p124a.TransferRateRequest;
import org.apache.ftpserver.p123g.p124a.WriteRequest;
import org.slf4j.C3154c;
import org.slf4j.InterfaceC3153b;

/* renamed from: org.apache.ftpserver.a.a.ao */
/* loaded from: classes2.dex */
public class SITE_DESCUSER extends AbstractCommand {

    /* renamed from: a */
    private final InterfaceC3153b f10886a = C3154c.m262a(SITE_DESCUSER.class);

    @Override // org.apache.ftpserver.p110a.Command
    /* renamed from: a */
    public void mo1971a(FtpIoSession ftpIoSession, FtpServerContext ftpServerContext, FtpRequest ftpRequest) throws IOException, FtpException {
        ftpIoSession.m1879r();
        if (!ftpServerContext.mo1722a().mo1718c(ftpIoSession.m1876u().mo1717a())) {
            ftpIoSession.mo1001e(LocalizedFtpReply.m1839a(ftpIoSession, ftpRequest, ftpServerContext, 530, "SITE", null));
            return;
        }
        String mo1748c = ftpRequest.mo1748c();
        int indexOf = mo1748c.indexOf(32);
        if (indexOf == -1) {
            ftpIoSession.mo1001e(LocalizedFtpReply.m1839a(ftpIoSession, ftpRequest, ftpServerContext, 503, "SITE.DESCUSER", null));
            return;
        }
        String substring = mo1748c.substring(indexOf + 1);
        UserManager a = ftpServerContext.mo1722a();
        User user = null;
        try {
            if (a.mo1693b(substring)) {
                user = a.mo1698a(substring);
            }
        } catch (FtpException e) {
            this.f10886a.debug("Exception trying to get user from user manager", (Throwable) e);
        }
        if (user == null) {
            ftpIoSession.mo1001e(LocalizedFtpReply.m1839a(ftpIoSession, ftpRequest, ftpServerContext, 501, "SITE.DESCUSER", substring));
            return;
        }
        StringBuilder sb = new StringBuilder(128);
        sb.append("\n");
        sb.append("userid          : ");
        sb.append(user.mo1717a());
        sb.append("\n");
        sb.append("userpassword    : ********\n");
        sb.append("homedirectory   : ");
        sb.append(user.mo1706e());
        sb.append("\n");
        sb.append("writepermission : ");
        sb.append(user.mo1713a(new WriteRequest()) != null);
        sb.append("\n");
        sb.append("enableflag      : ");
        sb.append(user.mo1707d());
        sb.append("\n");
        sb.append("idletime        : ");
        sb.append(user.mo1709c());
        sb.append("\n");
        TransferRateRequest transferRateRequest = (TransferRateRequest) ftpIoSession.m1876u().mo1713a(new TransferRateRequest());
        if (transferRateRequest != null) {
            sb.append("uploadrate      : ");
            sb.append(transferRateRequest.m1689b());
            sb.append("\n");
            sb.append("downloadrate    : ");
            sb.append(transferRateRequest.m1691a());
            sb.append("\n");
        } else {
            sb.append("uploadrate      : 0\n");
            sb.append("downloadrate    : 0\n");
        }
        sb.append('\n');
        ftpIoSession.mo1001e(new DefaultFtpReply(200, sb.toString()));
    }
}
