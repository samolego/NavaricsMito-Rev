package org.apache.ftpserver.p118d;

import org.apache.ftpserver.ftplet.FtpReply;
import org.apache.ftpserver.ftplet.FtpRequest;
import org.apache.ftpserver.p119e.Listener;
import org.apache.mina.core.session.IdleStatus;

/* renamed from: org.apache.ftpserver.d.j */
/* loaded from: classes2.dex */
public interface FtpHandler {
    /* renamed from: a */
    void mo1913a(FtpIoSession ftpIoSession) throws Exception;

    /* renamed from: a */
    void mo1912a(FtpIoSession ftpIoSession, Throwable th) throws Exception;

    /* renamed from: a */
    void mo1911a(FtpIoSession ftpIoSession, FtpReply ftpReply) throws Exception;

    /* renamed from: a */
    void mo1910a(FtpIoSession ftpIoSession, FtpRequest ftpRequest) throws Exception;

    /* renamed from: a */
    void mo1909a(FtpIoSession ftpIoSession, IdleStatus idleStatus) throws Exception;

    /* renamed from: a */
    void mo1908a(FtpServerContext ftpServerContext, Listener listener);

    /* renamed from: b */
    void mo1907b(FtpIoSession ftpIoSession) throws Exception;

    /* renamed from: c */
    void mo1906c(FtpIoSession ftpIoSession) throws Exception;
}
