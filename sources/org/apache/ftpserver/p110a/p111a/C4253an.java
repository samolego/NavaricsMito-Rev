package org.apache.ftpserver.p110a.p111a;

import java.io.IOException;
import org.apache.ftpserver.ftplet.FtpException;
import org.apache.ftpserver.ftplet.FtpRequest;
import org.apache.ftpserver.p110a.AbstractCommand;
import org.apache.ftpserver.p110a.Command;
import org.apache.ftpserver.p118d.FtpIoSession;
import org.apache.ftpserver.p118d.FtpServerContext;
import org.apache.ftpserver.p118d.LocalizedFtpReply;
import org.slf4j.C3154c;
import org.slf4j.InterfaceC3153b;

/* renamed from: org.apache.ftpserver.a.a.an */
/* loaded from: classes2.dex */
public class SITE extends AbstractCommand {

    /* renamed from: a */
    private final InterfaceC3153b f10885a = C3154c.m262a(SITE.class);

    @Override // org.apache.ftpserver.p110a.Command
    /* renamed from: a */
    public void mo1971a(FtpIoSession ftpIoSession, FtpServerContext ftpServerContext, FtpRequest ftpRequest) throws IOException, FtpException {
        String str;
        String mo1748c = ftpRequest.mo1748c();
        if (mo1748c != null) {
            int indexOf = mo1748c.indexOf(32);
            if (indexOf != -1) {
                mo1748c = mo1748c.substring(0, indexOf);
            }
            str = mo1748c.toUpperCase();
        } else {
            str = mo1748c;
        }
        if (str == null) {
            ftpIoSession.m1879r();
            ftpIoSession.mo1001e(LocalizedFtpReply.m1839a(ftpIoSession, ftpRequest, ftpServerContext, 200, "SITE", null));
            return;
        }
        Command mo1970a = ftpServerContext.mo1856f().mo1970a("SITE_" + str);
        try {
            if (mo1970a != null) {
                mo1970a.mo1971a(ftpIoSession, ftpServerContext, ftpRequest);
            } else {
                ftpIoSession.m1879r();
                ftpIoSession.mo1001e(LocalizedFtpReply.m1839a(ftpIoSession, ftpRequest, ftpServerContext, 502, "SITE", str));
            }
        } catch (Exception e) {
            this.f10885a.warn("SITE.execute()", (Throwable) e);
            ftpIoSession.m1879r();
            ftpIoSession.mo1001e(LocalizedFtpReply.m1839a(ftpIoSession, ftpRequest, ftpServerContext, 500, "SITE", null));
        }
    }
}
