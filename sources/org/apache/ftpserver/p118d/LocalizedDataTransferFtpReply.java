package org.apache.ftpserver.p118d;

import org.apache.ftpserver.ftplet.FtpFile;
import org.apache.ftpserver.ftplet.FtpRequest;
import org.apache.ftpserver.ftplet.InterfaceC3030f;

/* renamed from: org.apache.ftpserver.d.p */
/* loaded from: classes2.dex */
public class LocalizedDataTransferFtpReply extends LocalizedFtpReply implements InterfaceC3030f {

    /* renamed from: a */
    private final FtpFile f11046a;

    /* renamed from: b */
    private final long f11047b;

    public LocalizedDataTransferFtpReply(int i, String str, FtpFile ftpFile, long j) {
        super(i, str);
        this.f11046a = ftpFile;
        this.f11047b = j;
    }

    /* renamed from: a */
    public static LocalizedDataTransferFtpReply m1842a(FtpIoSession ftpIoSession, FtpRequest ftpRequest, FtpServerContext ftpServerContext, int i, String str, String str2, FtpFile ftpFile) {
        return new LocalizedDataTransferFtpReply(i, FtpReplyTranslator.m1866a(ftpIoSession, ftpRequest, ftpServerContext, i, str, str2), ftpFile, 0L);
    }

    /* renamed from: a */
    public static LocalizedDataTransferFtpReply m1841a(FtpIoSession ftpIoSession, FtpRequest ftpRequest, FtpServerContext ftpServerContext, int i, String str, String str2, FtpFile ftpFile, long j) {
        return new LocalizedDataTransferFtpReply(i, FtpReplyTranslator.m1866a(ftpIoSession, ftpRequest, ftpServerContext, i, str, str2), ftpFile, j);
    }
}
