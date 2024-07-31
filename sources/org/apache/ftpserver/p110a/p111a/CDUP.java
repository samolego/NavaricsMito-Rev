package org.apache.ftpserver.p110a.p111a;

import android.support.p011v7.widget.helper.ItemTouchHelper;
import java.io.IOException;
import org.apache.ftpserver.ftplet.FileSystemView;
import org.apache.ftpserver.ftplet.FtpException;
import org.apache.ftpserver.ftplet.FtpFile;
import org.apache.ftpserver.ftplet.FtpRequest;
import org.apache.ftpserver.p110a.AbstractCommand;
import org.apache.ftpserver.p118d.FtpIoSession;
import org.apache.ftpserver.p118d.FtpServerContext;
import org.apache.ftpserver.p118d.LocalizedFileActionFtpReply;
import org.slf4j.C3154c;
import org.slf4j.InterfaceC3153b;

/* renamed from: org.apache.ftpserver.a.a.e */
/* loaded from: classes2.dex */
public class CDUP extends AbstractCommand {

    /* renamed from: a */
    private final InterfaceC3153b f10899a = C3154c.m262a(CDUP.class);

    @Override // org.apache.ftpserver.p110a.Command
    /* renamed from: a */
    public void mo1971a(FtpIoSession ftpIoSession, FtpServerContext ftpServerContext, FtpRequest ftpRequest) throws IOException, FtpException {
        boolean z;
        ftpIoSession.m1879r();
        FileSystemView m1877t = ftpIoSession.m1877t();
        try {
            z = m1877t.mo1772b("..");
        } catch (Exception e) {
            this.f10899a.debug("Failed to change directory in file system", (Throwable) e);
            z = false;
        }
        FtpFile mo1775a = m1877t.mo1775a();
        if (z) {
            ftpIoSession.mo1001e(LocalizedFileActionFtpReply.m1840a(ftpIoSession, ftpRequest, ftpServerContext, ItemTouchHelper.Callback.DEFAULT_SWIPE_ANIMATION_DURATION, "CDUP", mo1775a.mo1771a(), mo1775a));
        } else {
            ftpIoSession.mo1001e(LocalizedFileActionFtpReply.m1840a(ftpIoSession, ftpRequest, ftpServerContext, 550, "CDUP", null, mo1775a));
        }
    }
}
