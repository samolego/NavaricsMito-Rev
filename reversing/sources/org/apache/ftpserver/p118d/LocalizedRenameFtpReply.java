package org.apache.ftpserver.p118d;

import org.apache.ftpserver.ftplet.FtpFile;
import org.apache.ftpserver.ftplet.FtpRequest;
import org.apache.ftpserver.ftplet.InterfaceC3032r;

/* renamed from: org.apache.ftpserver.d.s */
/* loaded from: classes2.dex */
public class LocalizedRenameFtpReply extends LocalizedFtpReply implements InterfaceC3032r {

    /* renamed from: a */
    private final FtpFile f11049a;

    /* renamed from: b */
    private final FtpFile f11050b;

    public LocalizedRenameFtpReply(int i, String str, FtpFile ftpFile, FtpFile ftpFile2) {
        super(i, str);
        this.f11049a = ftpFile;
        this.f11050b = ftpFile2;
    }

    /* renamed from: a */
    public static LocalizedRenameFtpReply m1838a(FtpIoSession ftpIoSession, FtpRequest ftpRequest, FtpServerContext ftpServerContext, int i, String str, String str2, FtpFile ftpFile, FtpFile ftpFile2) {
        return new LocalizedRenameFtpReply(i, FtpReplyTranslator.m1866a(ftpIoSession, ftpRequest, ftpServerContext, i, str, str2), ftpFile, ftpFile2);
    }
}
