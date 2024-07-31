package org.apache.ftpserver.p110a.p111a;

import java.io.IOException;
import org.apache.ftpserver.ftplet.FtpRequest;
import org.apache.ftpserver.p110a.AbstractCommand;
import org.apache.ftpserver.p118d.FtpIoSession;
import org.apache.ftpserver.p118d.FtpServerContext;
import org.apache.ftpserver.p118d.LocalizedFtpReply;
import org.slf4j.C3154c;
import org.slf4j.InterfaceC3153b;

/* renamed from: org.apache.ftpserver.a.a.ai */
/* loaded from: classes2.dex */
public class REST extends AbstractCommand {

    /* renamed from: a */
    private final InterfaceC3153b f10880a = C3154c.m262a(REST.class);

    @Override // org.apache.ftpserver.p110a.Command
    /* renamed from: a */
    public void mo1971a(FtpIoSession ftpIoSession, FtpServerContext ftpServerContext, FtpRequest ftpRequest) throws IOException {
        long j;
        String mo1748c = ftpRequest.mo1748c();
        if (mo1748c == null) {
            ftpIoSession.mo1001e(LocalizedFtpReply.m1839a(ftpIoSession, ftpRequest, ftpServerContext, 501, "REST", null));
            return;
        }
        ftpIoSession.m1879r();
        long j2 = 0;
        try {
            j = Long.parseLong(mo1748c);
            if (j < 0) {
                ftpIoSession.mo1001e(LocalizedFtpReply.m1839a(ftpIoSession, ftpRequest, ftpServerContext, 501, "REST.negetive", null));
            } else {
                try {
                    ftpIoSession.mo1001e(LocalizedFtpReply.m1839a(ftpIoSession, ftpRequest, ftpServerContext, 350, "REST", null));
                    j2 = j;
                } catch (NumberFormatException e) {
                    e = e;
                    this.f10880a.debug("Invalid restart position: " + mo1748c, (Throwable) e);
                    ftpIoSession.mo1001e(LocalizedFtpReply.m1839a(ftpIoSession, ftpRequest, ftpServerContext, 501, "REST.invalid", null));
                    ftpIoSession.m1890a(j);
                }
            }
            j = j2;
        } catch (NumberFormatException e2) {
            e = e2;
            j = 0;
        }
        ftpIoSession.m1890a(j);
    }
}
