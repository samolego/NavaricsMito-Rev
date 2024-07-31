package org.apache.ftpserver.p110a.p111a;

import android.support.p011v7.widget.helper.ItemTouchHelper;
import java.io.IOException;
import org.apache.ftpserver.ftplet.FtpException;
import org.apache.ftpserver.ftplet.FtpFile;
import org.apache.ftpserver.ftplet.FtpRequest;
import org.apache.ftpserver.p110a.AbstractCommand;
import org.apache.ftpserver.p110a.p111a.p112a.ListArgumentParser;
import org.apache.ftpserver.p110a.p111a.p112a.MLSTFileFormater;
import org.apache.ftpserver.p118d.FtpIoSession;
import org.apache.ftpserver.p118d.FtpServerContext;
import org.apache.ftpserver.p118d.LocalizedFtpReply;
import org.slf4j.C3154c;
import org.slf4j.InterfaceC3153b;

/* renamed from: org.apache.ftpserver.a.a.t */
/* loaded from: classes2.dex */
public class MLST extends AbstractCommand {

    /* renamed from: a */
    private final InterfaceC3153b f10914a = C3154c.m262a(MLST.class);

    @Override // org.apache.ftpserver.p110a.Command
    /* renamed from: a */
    public void mo1971a(FtpIoSession ftpIoSession, FtpServerContext ftpServerContext, FtpRequest ftpRequest) throws IOException {
        ftpIoSession.m1879r();
        try {
            FtpFile mo1774a = ftpIoSession.m1877t().mo1774a(ListArgumentParser.m1985a(ftpRequest.mo1748c()).m1986b());
            if (mo1774a != null && mo1774a.mo1762f()) {
                ftpIoSession.mo1001e(LocalizedFtpReply.m1839a(ftpIoSession, ftpRequest, ftpServerContext, ItemTouchHelper.Callback.DEFAULT_SWIPE_ANIMATION_DURATION, "MLST", new MLSTFileFormater((String[]) ftpIoSession.mo1009b("MLST.types")).mo1983a(mo1774a)));
            } else {
                ftpIoSession.mo1001e(LocalizedFtpReply.m1839a(ftpIoSession, ftpRequest, ftpServerContext, 501, "MLST", null));
            }
        } catch (FtpException e) {
            this.f10914a.debug("Exception sending the file listing", (Throwable) e);
            ftpIoSession.mo1001e(LocalizedFtpReply.m1839a(ftpIoSession, ftpRequest, ftpServerContext, 501, "MLST", null));
        }
    }
}
