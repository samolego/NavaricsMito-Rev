package org.apache.ftpserver.p118d;

import org.apache.ftpserver.ftplet.DefaultFtpReply;
import org.apache.ftpserver.ftplet.FtpRequest;

/* renamed from: org.apache.ftpserver.d.r */
/* loaded from: classes2.dex */
public class LocalizedFtpReply extends DefaultFtpReply {
    /* renamed from: a */
    public static LocalizedFtpReply m1839a(FtpIoSession ftpIoSession, FtpRequest ftpRequest, FtpServerContext ftpServerContext, int i, String str, String str2) {
        return new LocalizedFtpReply(i, FtpReplyTranslator.m1866a(ftpIoSession, ftpRequest, ftpServerContext, i, str, str2));
    }

    public LocalizedFtpReply(int i, String str) {
        super(i, str);
    }
}
