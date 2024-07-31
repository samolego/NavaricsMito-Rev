package org.apache.ftpserver.p110a.p111a;

import java.io.IOException;
import org.apache.ftpserver.ftplet.FtpRequest;
import org.apache.ftpserver.ftplet.Structure;
import org.apache.ftpserver.p110a.AbstractCommand;
import org.apache.ftpserver.p118d.FtpIoSession;
import org.apache.ftpserver.p118d.FtpServerContext;
import org.apache.ftpserver.p118d.LocalizedFtpReply;
import org.slf4j.C3154c;
import org.slf4j.InterfaceC3153b;

/* renamed from: org.apache.ftpserver.a.a.ax */
/* loaded from: classes2.dex */
public class STRU extends AbstractCommand {

    /* renamed from: a */
    private final InterfaceC3153b f10893a = C3154c.m262a(STRU.class);

    @Override // org.apache.ftpserver.p110a.Command
    /* renamed from: a */
    public void mo1971a(FtpIoSession ftpIoSession, FtpServerContext ftpServerContext, FtpRequest ftpRequest) throws IOException {
        ftpIoSession.m1879r();
        if (!ftpRequest.mo1747d()) {
            ftpIoSession.mo1001e(LocalizedFtpReply.m1839a(ftpIoSession, ftpRequest, ftpServerContext, 501, "STRU", null));
            return;
        }
        try {
            ftpIoSession.m1886a(Structure.parseArgument(ftpRequest.mo1748c().charAt(0)));
            ftpIoSession.mo1001e(LocalizedFtpReply.m1839a(ftpIoSession, ftpRequest, ftpServerContext, 200, "STRU", null));
        } catch (IllegalArgumentException e) {
            InterfaceC3153b interfaceC3153b = this.f10893a;
            interfaceC3153b.debug("Illegal structure argument: " + ftpRequest.mo1748c(), (Throwable) e);
            ftpIoSession.mo1001e(LocalizedFtpReply.m1839a(ftpIoSession, ftpRequest, ftpServerContext, 504, "STRU", null));
        }
    }
}
