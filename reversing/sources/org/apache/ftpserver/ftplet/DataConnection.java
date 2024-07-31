package org.apache.ftpserver.ftplet;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/* renamed from: org.apache.ftpserver.ftplet.d */
/* loaded from: classes2.dex */
public interface DataConnection {
    /* renamed from: a */
    long mo1784a(FtpSession ftpSession, InputStream inputStream) throws IOException;

    /* renamed from: a */
    long mo1783a(FtpSession ftpSession, OutputStream outputStream) throws IOException;

    /* renamed from: a */
    void mo1782a(FtpSession ftpSession, String str) throws IOException;
}
