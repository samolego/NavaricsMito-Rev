package org.apache.ftpserver.p110a.p111a;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.apache.ftpserver.ftplet.DefaultFtpReply;
import org.apache.ftpserver.ftplet.FtpException;
import org.apache.ftpserver.ftplet.FtpRequest;
import org.apache.ftpserver.p110a.AbstractCommand;
import org.apache.ftpserver.p118d.FtpIoSession;
import org.apache.ftpserver.p118d.FtpServerContext;

/* renamed from: org.apache.ftpserver.a.a.as */
/* loaded from: classes2.dex */
public class SITE_ZONE extends AbstractCommand {

    /* renamed from: a */
    private static final SimpleDateFormat f10887a = new SimpleDateFormat("Z");

    @Override // org.apache.ftpserver.p110a.Command
    /* renamed from: a */
    public void mo1971a(FtpIoSession ftpIoSession, FtpServerContext ftpServerContext, FtpRequest ftpRequest) throws IOException, FtpException {
        ftpIoSession.m1879r();
        ftpIoSession.mo1001e(new DefaultFtpReply(200, f10887a.format(new Date())));
    }
}
