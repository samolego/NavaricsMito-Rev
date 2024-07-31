package org.apache.ftpserver.p110a.p111a;

import android.support.p011v7.widget.helper.ItemTouchHelper;
import java.io.IOException;
import org.apache.ftpserver.ftplet.FtpException;
import org.apache.ftpserver.ftplet.FtpFile;
import org.apache.ftpserver.ftplet.FtpRequest;
import org.apache.ftpserver.p110a.AbstractCommand;
import org.apache.ftpserver.p118d.FtpIoSession;
import org.apache.ftpserver.p118d.FtpServerContext;
import org.apache.ftpserver.p118d.LocalizedRenameFtpReply;
import org.slf4j.C3154c;
import org.slf4j.InterfaceC3153b;

/* renamed from: org.apache.ftpserver.a.a.am */
/* loaded from: classes2.dex */
public class RNTO extends AbstractCommand {

    /* renamed from: a */
    private final InterfaceC3153b f10884a = C3154c.m262a(RNTO.class);

    @Override // org.apache.ftpserver.p110a.Command
    /* renamed from: a */
    public void mo1971a(FtpIoSession ftpIoSession, FtpServerContext ftpServerContext, FtpRequest ftpRequest) throws IOException, FtpException {
        FtpFile ftpFile;
        try {
            String mo1748c = ftpRequest.mo1748c();
            if (mo1748c == null) {
                ftpIoSession.mo1001e(LocalizedRenameFtpReply.m1838a(ftpIoSession, ftpRequest, ftpServerContext, 501, "RNTO", null, null, null));
                return;
            }
            FtpFile m1900F = ftpIoSession.m1900F();
            if (m1900F == null) {
                ftpIoSession.mo1001e(LocalizedRenameFtpReply.m1838a(ftpIoSession, ftpRequest, ftpServerContext, 503, "RNTO", null, null, null));
                return;
            }
            try {
                ftpFile = ftpIoSession.m1877t().mo1774a(mo1748c);
            } catch (Exception e) {
                this.f10884a.debug("Exception getting file object", (Throwable) e);
                ftpFile = null;
            }
            if (ftpFile == null) {
                ftpIoSession.mo1001e(LocalizedRenameFtpReply.m1838a(ftpIoSession, ftpRequest, ftpServerContext, 553, "RNTO.invalid", null, m1900F, ftpFile));
                return;
            }
            String mo1771a = ftpFile.mo1771a();
            if (!ftpFile.mo1755m()) {
                ftpIoSession.mo1001e(LocalizedRenameFtpReply.m1838a(ftpIoSession, ftpRequest, ftpServerContext, 553, "RNTO.permission", null, m1900F, ftpFile));
            } else if (!m1900F.mo1762f()) {
                ftpIoSession.mo1001e(LocalizedRenameFtpReply.m1838a(ftpIoSession, ftpRequest, ftpServerContext, 553, "RNTO.missing", null, m1900F, ftpFile));
            } else {
                String mo1771a2 = m1900F.mo1771a();
                if (m1900F.mo1769a(ftpFile)) {
                    ftpIoSession.mo1001e(LocalizedRenameFtpReply.m1838a(ftpIoSession, ftpRequest, ftpServerContext, ItemTouchHelper.Callback.DEFAULT_SWIPE_ANIMATION_DURATION, "RNTO", mo1771a, m1900F, ftpFile));
                    this.f10884a.info("File rename from \"{}\" to \"{}\"", mo1771a2, ftpFile.mo1771a());
                } else {
                    ftpIoSession.mo1001e(LocalizedRenameFtpReply.m1838a(ftpIoSession, ftpRequest, ftpServerContext, 553, "RNTO", mo1771a, m1900F, ftpFile));
                }
            }
        } finally {
            ftpIoSession.m1879r();
        }
    }
}
