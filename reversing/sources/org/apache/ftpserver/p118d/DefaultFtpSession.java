package org.apache.ftpserver.p118d;

import org.apache.ftpserver.ftplet.DataType;
import org.apache.ftpserver.ftplet.FtpSession;
import org.apache.ftpserver.ftplet.User;

/* renamed from: org.apache.ftpserver.d.g */
/* loaded from: classes2.dex */
public class DefaultFtpSession implements FtpSession {

    /* renamed from: a */
    private final FtpIoSession f11005a;

    public DefaultFtpSession(FtpIoSession ftpIoSession) {
        this.f11005a = ftpIoSession;
    }

    @Override // org.apache.ftpserver.ftplet.FtpSession
    /* renamed from: a */
    public User mo1746a() {
        return this.f11005a.m1876u();
    }

    @Override // org.apache.ftpserver.ftplet.FtpSession
    /* renamed from: b */
    public DataType mo1745b() {
        return this.f11005a.m1897I();
    }

    /* renamed from: a */
    public void m1931a(int i) {
        this.f11005a.m1882b(i);
    }

    /* renamed from: b */
    public void m1930b(int i) {
        this.f11005a.m1880c(i);
    }
}
