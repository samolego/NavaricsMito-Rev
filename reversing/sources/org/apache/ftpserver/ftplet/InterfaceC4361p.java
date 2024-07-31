package org.apache.ftpserver.ftplet;

import java.io.IOException;

/* renamed from: org.apache.ftpserver.ftplet.p */
/* loaded from: classes2.dex */
public interface Ftplet {
    /* renamed from: a */
    FtpletResult mo1727a(FtpSession ftpSession) throws FtpException, IOException;

    /* renamed from: a */
    FtpletResult mo1726a(FtpSession ftpSession, FtpRequest ftpRequest) throws FtpException, IOException;

    /* renamed from: a */
    FtpletResult mo1725a(FtpSession ftpSession, FtpRequest ftpRequest, FtpReply ftpReply) throws FtpException, IOException;

    /* renamed from: a */
    void mo1728a();

    /* renamed from: a */
    void mo1724a(FtpletContext ftpletContext) throws FtpException;

    /* renamed from: b */
    FtpletResult mo1723b(FtpSession ftpSession) throws FtpException, IOException;
}
