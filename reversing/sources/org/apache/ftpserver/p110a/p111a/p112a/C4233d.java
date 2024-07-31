package org.apache.ftpserver.p110a.p111a.p112a;

import java.util.Arrays;
import org.apache.ftpserver.ftplet.FtpFile;
import org.apache.ftpserver.util.DateUtils;

/* renamed from: org.apache.ftpserver.a.a.a.d */
/* loaded from: classes2.dex */
public class LISTFileFormater implements FileFormater {

    /* renamed from: a */
    private static final char[] f10865a = {'\r', '\n'};

    @Override // org.apache.ftpserver.p110a.p111a.p112a.FileFormater
    /* renamed from: a */
    public String mo1983a(FtpFile ftpFile) {
        return m1989d(ftpFile) + "   " + String.valueOf(ftpFile.mo1758j()) + ' ' + ftpFile.mo1760h() + ' ' + ftpFile.mo1759i() + ' ' + m1991b(ftpFile) + ' ' + m1990c(ftpFile) + ' ' + ftpFile.mo1768b() + f10865a;
    }

    /* renamed from: b */
    private String m1991b(FtpFile ftpFile) {
        String valueOf = String.valueOf(ftpFile.mo1763e() ? ftpFile.mo1761g() : 0L);
        if (valueOf.length() > 12) {
            return valueOf;
        }
        return "            ".substring(0, 12 - valueOf.length()) + valueOf;
    }

    /* renamed from: c */
    private String m1990c(FtpFile ftpFile) {
        return DateUtils.m1673a(ftpFile.mo1757k());
    }

    /* renamed from: d */
    private char[] m1989d(FtpFile ftpFile) {
        char[] cArr = new char[10];
        Arrays.fill(cArr, '-');
        cArr[0] = ftpFile.mo1764d() ? 'd' : '-';
        cArr[1] = ftpFile.mo1756l() ? 'r' : '-';
        cArr[2] = ftpFile.mo1755m() ? 'w' : '-';
        cArr[3] = ftpFile.mo1764d() ? 'x' : '-';
        return cArr;
    }
}
