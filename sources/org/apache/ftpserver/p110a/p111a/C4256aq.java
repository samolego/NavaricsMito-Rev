package org.apache.ftpserver.p110a.p111a;

import java.io.IOException;
import org.apache.ftpserver.ftplet.DefaultFtpReply;
import org.apache.ftpserver.ftplet.FtpException;
import org.apache.ftpserver.ftplet.FtpRequest;
import org.apache.ftpserver.ftplet.FtpStatistics;
import org.apache.ftpserver.p110a.AbstractCommand;
import org.apache.ftpserver.p118d.FtpIoSession;
import org.apache.ftpserver.p118d.FtpServerContext;
import org.apache.ftpserver.p118d.LocalizedFtpReply;
import org.apache.ftpserver.util.DateUtils;

/* renamed from: org.apache.ftpserver.a.a.aq */
/* loaded from: classes2.dex */
public class SITE_STAT extends AbstractCommand {
    @Override // org.apache.ftpserver.p110a.Command
    /* renamed from: a */
    public void mo1971a(FtpIoSession ftpIoSession, FtpServerContext ftpServerContext, FtpRequest ftpRequest) throws IOException, FtpException {
        ftpIoSession.m1879r();
        if (!ftpServerContext.mo1722a().mo1718c(ftpIoSession.m1876u().mo1717a())) {
            ftpIoSession.mo1001e(LocalizedFtpReply.m1839a(ftpIoSession, ftpRequest, ftpServerContext, 530, "SITE", null));
            return;
        }
        FtpStatistics c = ftpServerContext.mo1720c();
        StringBuilder sb = new StringBuilder(256);
        sb.append('\n');
        sb.append("Start Time               : ");
        sb.append(DateUtils.m1671b(c.mo1744a().getTime()));
        sb.append('\n');
        sb.append("File Upload Number       : ");
        sb.append(c.mo1741b());
        sb.append('\n');
        sb.append("File Download Number     : ");
        sb.append(c.mo1740c());
        sb.append('\n');
        sb.append("File Delete Number       : ");
        sb.append(c.mo1739d());
        sb.append('\n');
        sb.append("File Upload Bytes        : ");
        sb.append(c.mo1738e());
        sb.append('\n');
        sb.append("File Download Bytes      : ");
        sb.append(c.mo1737f());
        sb.append('\n');
        sb.append("Directory Create Number  : ");
        sb.append(c.mo1736g());
        sb.append('\n');
        sb.append("Directory Remove Number  : ");
        sb.append(c.mo1735h());
        sb.append('\n');
        sb.append("Current Logins           : ");
        sb.append(c.mo1731l());
        sb.append('\n');
        sb.append("Total Logins             : ");
        sb.append(c.mo1732k());
        sb.append('\n');
        sb.append("Current Anonymous Logins : ");
        sb.append(c.mo1729n());
        sb.append('\n');
        sb.append("Total Anonymous Logins   : ");
        sb.append(c.mo1730m());
        sb.append('\n');
        sb.append("Current Connections      : ");
        sb.append(c.mo1733j());
        sb.append('\n');
        sb.append("Total Connections        : ");
        sb.append(c.mo1734i());
        sb.append('\n');
        sb.append('\n');
        ftpIoSession.mo1001e(new DefaultFtpReply(200, sb.toString()));
    }
}
