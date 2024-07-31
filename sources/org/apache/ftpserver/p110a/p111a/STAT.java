package org.apache.ftpserver.p110a.p111a;

import java.io.IOException;
import org.apache.ftpserver.ftplet.FtpException;
import org.apache.ftpserver.ftplet.FtpFile;
import org.apache.ftpserver.ftplet.FtpRequest;
import org.apache.ftpserver.p110a.AbstractCommand;
import org.apache.ftpserver.p110a.p111a.p112a.DirectoryLister;
import org.apache.ftpserver.p110a.p111a.p112a.LISTFileFormater;
import org.apache.ftpserver.p110a.p111a.p112a.ListArgument;
import org.apache.ftpserver.p110a.p111a.p112a.ListArgumentParser;
import org.apache.ftpserver.p118d.FtpIoSession;
import org.apache.ftpserver.p118d.FtpServerContext;
import org.apache.ftpserver.p118d.LocalizedDataTransferFtpReply;
import org.apache.ftpserver.p118d.LocalizedFileActionFtpReply;
import org.apache.ftpserver.p118d.LocalizedFtpReply;

/* renamed from: org.apache.ftpserver.a.a.au */
/* loaded from: classes2.dex */
public class STAT extends AbstractCommand {

    /* renamed from: a */
    private static final LISTFileFormater f10889a = new LISTFileFormater();

    /* renamed from: b */
    private final DirectoryLister f10890b = new DirectoryLister();

    @Override // org.apache.ftpserver.p110a.Command
    /* renamed from: a */
    public void mo1971a(FtpIoSession ftpIoSession, FtpServerContext ftpServerContext, FtpRequest ftpRequest) throws IOException {
        ftpIoSession.m1879r();
        if (ftpRequest.mo1748c() != null) {
            ListArgument m1985a = ListArgumentParser.m1985a(ftpRequest.mo1748c());
            try {
                FtpFile mo1774a = ftpIoSession.m1877t().mo1774a(m1985a.m1986b());
                if (!mo1774a.mo1762f()) {
                    ftpIoSession.mo1001e(LocalizedDataTransferFtpReply.m1842a(ftpIoSession, ftpRequest, ftpServerContext, 450, "LIST", null, mo1774a));
                    return;
                }
                ftpIoSession.mo1001e(LocalizedFileActionFtpReply.m1840a(ftpIoSession, ftpRequest, ftpServerContext, mo1774a.mo1764d() ? 212 : 213, "STAT", this.f10890b.m1993a(m1985a, ftpIoSession.m1877t(), f10889a), mo1774a));
                return;
            } catch (FtpException unused) {
                ftpIoSession.mo1001e(LocalizedFileActionFtpReply.m1840a(ftpIoSession, ftpRequest, ftpServerContext, 450, "STAT", null, null));
                return;
            }
        }
        ftpIoSession.mo1001e(LocalizedFtpReply.m1839a(ftpIoSession, ftpRequest, ftpServerContext, 211, "STAT", null));
    }
}
