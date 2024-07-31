package org.apache.ftpserver.p110a.p111a;

import java.io.IOException;
import java.text.ParseException;
import java.util.Date;
import org.apache.ftpserver.ftplet.FtpFile;
import org.apache.ftpserver.ftplet.FtpRequest;
import org.apache.ftpserver.p110a.AbstractCommand;
import org.apache.ftpserver.p118d.FtpIoSession;
import org.apache.ftpserver.p118d.FtpServerContext;
import org.apache.ftpserver.p118d.LocalizedFtpReply;
import org.apache.ftpserver.util.DateUtils;
import org.slf4j.C3154c;
import org.slf4j.InterfaceC3153b;

/* renamed from: org.apache.ftpserver.a.a.q */
/* loaded from: classes2.dex */
public class MFMT extends AbstractCommand {

    /* renamed from: a */
    private final InterfaceC3153b f10910a = C3154c.m262a(MFMT.class);

    @Override // org.apache.ftpserver.p110a.Command
    /* renamed from: a */
    public void mo1971a(FtpIoSession ftpIoSession, FtpServerContext ftpServerContext, FtpRequest ftpRequest) throws IOException {
        ftpIoSession.m1879r();
        String mo1748c = ftpRequest.mo1748c();
        if (mo1748c == null || mo1748c.trim().length() == 0) {
            ftpIoSession.mo1001e(LocalizedFtpReply.m1839a(ftpIoSession, ftpRequest, ftpServerContext, 501, "MFMT.invalid", null));
            return;
        }
        String[] split = mo1748c.split(" ", 2);
        if (split.length != 2) {
            ftpIoSession.mo1001e(LocalizedFtpReply.m1839a(ftpIoSession, ftpRequest, ftpServerContext, 501, "MFMT.invalid", null));
            return;
        }
        String trim = split[0].trim();
        try {
            Date m1672a = DateUtils.m1672a(trim);
            String trim2 = split[1].trim();
            FtpFile ftpFile = null;
            try {
                ftpFile = ftpIoSession.m1877t().mo1774a(trim2);
            } catch (Exception e) {
                InterfaceC3153b interfaceC3153b = this.f10910a;
                interfaceC3153b.debug("Exception getting the file object: " + trim2, (Throwable) e);
            }
            if (ftpFile != null && ftpFile.mo1762f()) {
                if (!ftpFile.mo1763e()) {
                    ftpIoSession.mo1001e(LocalizedFtpReply.m1839a(ftpIoSession, ftpRequest, ftpServerContext, 501, "MFMT.invalid", null));
                    return;
                } else if (!ftpFile.mo1770a(m1672a.getTime())) {
                    ftpIoSession.mo1001e(LocalizedFtpReply.m1839a(ftpIoSession, ftpRequest, ftpServerContext, 450, "MFMT", trim2));
                    return;
                } else {
                    ftpIoSession.mo1001e(LocalizedFtpReply.m1839a(ftpIoSession, ftpRequest, ftpServerContext, 213, "MFMT", "ModifyTime=" + trim + "; " + trim2));
                    return;
                }
            }
            ftpIoSession.mo1001e(LocalizedFtpReply.m1839a(ftpIoSession, ftpRequest, ftpServerContext, 550, "MFMT.filemissing", trim2));
        } catch (ParseException unused) {
            ftpIoSession.mo1001e(LocalizedFtpReply.m1839a(ftpIoSession, ftpRequest, ftpServerContext, 501, "MFMT.invalid", null));
        }
    }
}
