package org.apache.ftpserver.p110a.p111a;

import android.support.p011v7.widget.helper.ItemTouchHelper;
import java.io.IOException;
import org.apache.ftpserver.ftplet.FtpException;
import org.apache.ftpserver.ftplet.FtpFile;
import org.apache.ftpserver.ftplet.FtpRequest;
import org.apache.ftpserver.p110a.AbstractCommand;
import org.apache.ftpserver.p118d.FtpIoSession;
import org.apache.ftpserver.p118d.FtpServerContext;
import org.apache.ftpserver.p118d.LocalizedFileActionFtpReply;
import org.apache.ftpserver.p118d.ServerFtpStatistics;
import org.slf4j.C3154c;
import org.slf4j.InterfaceC3153b;

/* renamed from: org.apache.ftpserver.a.a.g */
/* loaded from: classes2.dex */
public class DELE extends AbstractCommand {

    /* renamed from: a */
    private final InterfaceC3153b f10901a = C3154c.m262a(DELE.class);

    @Override // org.apache.ftpserver.p110a.Command
    /* renamed from: a */
    public void mo1971a(FtpIoSession ftpIoSession, FtpServerContext ftpServerContext, FtpRequest ftpRequest) throws IOException, FtpException {
        FtpFile ftpFile;
        ftpIoSession.m1879r();
        String mo1748c = ftpRequest.mo1748c();
        if (mo1748c == null) {
            ftpIoSession.mo1001e(LocalizedFileActionFtpReply.m1840a(ftpIoSession, ftpRequest, ftpServerContext, 501, "DELE", null, null));
            return;
        }
        try {
            ftpFile = ftpIoSession.m1877t().mo1774a(mo1748c);
        } catch (Exception e) {
            InterfaceC3153b interfaceC3153b = this.f10901a;
            interfaceC3153b.debug("Could not get file " + mo1748c, (Throwable) e);
            ftpFile = null;
        }
        if (ftpFile == null) {
            ftpIoSession.mo1001e(LocalizedFileActionFtpReply.m1840a(ftpIoSession, ftpRequest, ftpServerContext, 550, "DELE.invalid", mo1748c, null));
            return;
        }
        String mo1771a = ftpFile.mo1771a();
        if (ftpFile.mo1764d()) {
            ftpIoSession.mo1001e(LocalizedFileActionFtpReply.m1840a(ftpIoSession, ftpRequest, ftpServerContext, 550, "DELE.invalid", mo1771a, ftpFile));
        } else if (!ftpFile.mo1754n()) {
            ftpIoSession.mo1001e(LocalizedFileActionFtpReply.m1840a(ftpIoSession, ftpRequest, ftpServerContext, 450, "DELE.permission", mo1771a, ftpFile));
        } else if (ftpFile.mo1753o()) {
            ftpIoSession.mo1001e(LocalizedFileActionFtpReply.m1840a(ftpIoSession, ftpRequest, ftpServerContext, ItemTouchHelper.Callback.DEFAULT_SWIPE_ANIMATION_DURATION, "DELE", mo1771a, ftpFile));
            String mo1717a = ftpIoSession.m1876u().mo1717a();
            InterfaceC3153b interfaceC3153b2 = this.f10901a;
            interfaceC3153b2.info("File delete : " + mo1717a + " - " + mo1771a);
            ((ServerFtpStatistics) ftpServerContext.mo1720c()).mo1828a(ftpIoSession, ftpFile);
        } else {
            ftpIoSession.mo1001e(LocalizedFileActionFtpReply.m1840a(ftpIoSession, ftpRequest, ftpServerContext, 450, "DELE", mo1771a, ftpFile));
        }
    }
}
