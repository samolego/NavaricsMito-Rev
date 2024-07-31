package org.apache.ftpserver.p110a.p111a;

import java.io.IOException;
import org.apache.ftpserver.ftplet.FtpRequest;
import org.apache.ftpserver.p110a.AbstractCommand;
import org.apache.ftpserver.p118d.FtpIoSession;
import org.apache.ftpserver.p118d.FtpServerContext;
import org.apache.ftpserver.p118d.LocalizedFtpReply;

/* renamed from: org.apache.ftpserver.a.a.ay */
/* loaded from: classes2.dex */
public class SYST extends AbstractCommand {
    @Override // org.apache.ftpserver.p110a.Command
    /* renamed from: a */
    public void mo1971a(FtpIoSession ftpIoSession, FtpServerContext ftpServerContext, FtpRequest ftpRequest) throws IOException {
        ftpIoSession.m1879r();
        String property = System.getProperty("os.name");
        ftpIoSession.mo1001e(LocalizedFtpReply.m1839a(ftpIoSession, ftpRequest, ftpServerContext, 215, "SYST", property == null ? "UNKNOWN" : property.toUpperCase().replace(' ', '-')));
    }
}
