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

/* renamed from: org.apache.ftpserver.a.a.ak */
/* loaded from: classes2.dex */
public class RMD extends AbstractCommand {

    /* renamed from: a */
    private final InterfaceC3153b f10882a = C3154c.m262a(RMD.class);

    @Override // org.apache.ftpserver.p110a.Command
    /* renamed from: a */
    public void mo1971a(FtpIoSession ftpIoSession, FtpServerContext ftpServerContext, FtpRequest ftpRequest) throws IOException, FtpException {
        FtpFile ftpFile;
        ftpIoSession.m1879r();
        String mo1748c = ftpRequest.mo1748c();
        if (mo1748c == null) {
            ftpIoSession.mo1001e(LocalizedFileActionFtpReply.m1840a(ftpIoSession, ftpRequest, ftpServerContext, 501, "RMD", null, null));
            return;
        }
        try {
            ftpFile = ftpIoSession.m1877t().mo1774a(mo1748c);
        } catch (Exception e) {
            this.f10882a.debug("Exception getting file object", (Throwable) e);
            ftpFile = null;
        }
        if (ftpFile == null) {
            ftpIoSession.mo1001e(LocalizedFileActionFtpReply.m1840a(ftpIoSession, ftpRequest, ftpServerContext, 550, "RMD.permission", mo1748c, ftpFile));
            return;
        }
        String mo1771a = ftpFile.mo1771a();
        if (!ftpFile.mo1764d()) {
            ftpIoSession.mo1001e(LocalizedFileActionFtpReply.m1840a(ftpIoSession, ftpRequest, ftpServerContext, 550, "RMD.invalid", mo1771a, ftpFile));
        } else if (ftpFile.equals(ftpIoSession.m1877t().mo1775a())) {
            ftpIoSession.mo1001e(LocalizedFileActionFtpReply.m1840a(ftpIoSession, ftpRequest, ftpServerContext, 450, "RMD.busy", mo1771a, ftpFile));
        } else if (!ftpFile.mo1754n()) {
            ftpIoSession.mo1001e(LocalizedFileActionFtpReply.m1840a(ftpIoSession, ftpRequest, ftpServerContext, 550, "RMD.permission", mo1771a, ftpFile));
        } else if (ftpFile.mo1753o()) {
            ftpIoSession.mo1001e(LocalizedFileActionFtpReply.m1840a(ftpIoSession, ftpRequest, ftpServerContext, ItemTouchHelper.Callback.DEFAULT_SWIPE_ANIMATION_DURATION, "RMD", mo1771a, ftpFile));
            String mo1717a = ftpIoSession.m1876u().mo1717a();
            this.f10882a.info("Directory remove : " + mo1717a + " - " + mo1771a);
            ((ServerFtpStatistics) ftpServerContext.mo1720c()).mo1822c(ftpIoSession, ftpFile);
        } else {
            ftpIoSession.mo1001e(LocalizedFileActionFtpReply.m1840a(ftpIoSession, ftpRequest, ftpServerContext, 450, "RMD", mo1771a, ftpFile));
        }
    }
}
