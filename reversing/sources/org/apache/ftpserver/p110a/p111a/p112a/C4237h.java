package org.apache.ftpserver.p110a.p111a.p112a;

import org.apache.ftpserver.ftplet.FtpFile;

/* renamed from: org.apache.ftpserver.a.a.a.h */
/* loaded from: classes2.dex */
public class NLSTFileFormater implements FileFormater {

    /* renamed from: a */
    private static final char[] f10872a = {'\r', '\n'};

    @Override // org.apache.ftpserver.p110a.p111a.p112a.FileFormater
    /* renamed from: a */
    public String mo1983a(FtpFile ftpFile) {
        return ftpFile.mo1768b() + f10872a;
    }
}
