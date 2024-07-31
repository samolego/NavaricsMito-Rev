package org.apache.ftpserver.p118d;

import org.apache.ftpserver.ftplet.FtpFile;
import org.apache.ftpserver.ftplet.FtpRequest;
import org.apache.ftpserver.ftplet.InterfaceC3031h;

/* renamed from: org.apache.ftpserver.d.q */
/* loaded from: classes2.dex */
public class LocalizedFileActionFtpReply extends LocalizedFtpReply implements InterfaceC3031h {

    /* renamed from: a */
    private final FtpFile f11048a;

    public LocalizedFileActionFtpReply(int i, String str, FtpFile ftpFile) {
        super(i, str);
        this.f11048a = ftpFile;
    }

    /* renamed from: a */
    public static LocalizedFileActionFtpReply m1840a(FtpIoSession ftpIoSession, FtpRequest ftpRequest, FtpServerContext ftpServerContext, int i, String str, String str2, FtpFile ftpFile) {
        return new LocalizedFileActionFtpReply(i, FtpReplyTranslator.m1866a(ftpIoSession, ftpRequest, ftpServerContext, i, str, str2), ftpFile);
    }
}
