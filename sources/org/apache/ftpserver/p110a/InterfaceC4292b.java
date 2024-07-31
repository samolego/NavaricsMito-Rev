package org.apache.ftpserver.p110a;

import java.io.IOException;
import org.apache.ftpserver.ftplet.FtpException;
import org.apache.ftpserver.ftplet.FtpRequest;
import org.apache.ftpserver.p118d.FtpIoSession;
import org.apache.ftpserver.p118d.FtpServerContext;

/* renamed from: org.apache.ftpserver.a.b */
/* loaded from: classes2.dex */
public interface Command {
    /* renamed from: a */
    void mo1971a(FtpIoSession ftpIoSession, FtpServerContext ftpServerContext, FtpRequest ftpRequest) throws IOException, FtpException;
}
