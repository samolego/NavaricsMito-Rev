package org.apache.ftpserver.p110a.p111a;

import android.support.media.ExifInterface;
import java.io.IOException;
import org.apache.ftpserver.ftplet.FtpRequest;
import org.apache.ftpserver.p110a.AbstractCommand;
import org.apache.ftpserver.p118d.FtpIoSession;
import org.apache.ftpserver.p118d.FtpServerContext;
import org.apache.ftpserver.p118d.LocalizedFtpReply;

/* renamed from: org.apache.ftpserver.a.a.u */
/* loaded from: classes2.dex */
public class MODE extends AbstractCommand {
    @Override // org.apache.ftpserver.p110a.Command
    /* renamed from: a */
    public void mo1971a(FtpIoSession ftpIoSession, FtpServerContext ftpServerContext, FtpRequest ftpRequest) throws IOException {
        ftpIoSession.m1879r();
        if (!ftpRequest.mo1747d()) {
            ftpIoSession.mo1001e(LocalizedFtpReply.m1839a(ftpIoSession, ftpRequest, ftpServerContext, 501, "MODE", null));
            return;
        }
        char upperCase = Character.toUpperCase(ftpRequest.mo1748c().charAt(0));
        if (upperCase == 'S') {
            ftpIoSession.m1878s().mo1832b(false);
            ftpIoSession.mo1001e(LocalizedFtpReply.m1839a(ftpIoSession, ftpRequest, ftpServerContext, 200, "MODE", ExifInterface.LATITUDE_SOUTH));
        } else if (upperCase == 'Z') {
            ftpIoSession.m1878s().mo1832b(true);
            ftpIoSession.mo1001e(LocalizedFtpReply.m1839a(ftpIoSession, ftpRequest, ftpServerContext, 200, "MODE", "Z"));
        } else {
            ftpIoSession.mo1001e(LocalizedFtpReply.m1839a(ftpIoSession, ftpRequest, ftpServerContext, 504, "MODE", null));
        }
    }
}
