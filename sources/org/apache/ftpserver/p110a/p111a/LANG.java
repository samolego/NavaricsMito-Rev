package org.apache.ftpserver.p110a.p111a;

import java.io.IOException;
import java.util.List;
import org.apache.ftpserver.ftplet.FtpException;
import org.apache.ftpserver.ftplet.FtpRequest;
import org.apache.ftpserver.p110a.AbstractCommand;
import org.apache.ftpserver.p118d.FtpIoSession;
import org.apache.ftpserver.p118d.FtpServerContext;
import org.apache.ftpserver.p118d.LocalizedFtpReply;

/* renamed from: org.apache.ftpserver.a.a.m */
/* loaded from: classes2.dex */
public class LANG extends AbstractCommand {
    @Override // org.apache.ftpserver.p110a.Command
    /* renamed from: a */
    public void mo1971a(FtpIoSession ftpIoSession, FtpServerContext ftpServerContext, FtpRequest ftpRequest) throws IOException, FtpException {
        ftpIoSession.m1879r();
        String mo1748c = ftpRequest.mo1748c();
        if (mo1748c == null) {
            ftpIoSession.m1889a((String) null);
            ftpIoSession.mo1001e(LocalizedFtpReply.m1839a(ftpIoSession, ftpRequest, ftpServerContext, 200, "LANG", null));
            return;
        }
        String lowerCase = mo1748c.toLowerCase();
        List<String> mo1788a = ftpServerContext.mo1858d().mo1788a();
        if (mo1788a != null) {
            for (int i = 0; i < mo1788a.size(); i++) {
                if (mo1788a.get(i).equals(lowerCase)) {
                    ftpIoSession.m1889a(lowerCase);
                    ftpIoSession.mo1001e(LocalizedFtpReply.m1839a(ftpIoSession, ftpRequest, ftpServerContext, 200, "LANG", null));
                    return;
                }
            }
        }
        ftpIoSession.mo1001e(LocalizedFtpReply.m1839a(ftpIoSession, ftpRequest, ftpServerContext, 504, "LANG", null));
    }
}
