package org.apache.ftpserver.p110a.p111a.p112a;

import org.apache.ftpserver.ftplet.FtpFile;
import org.apache.ftpserver.util.RegularExpr;

/* renamed from: org.apache.ftpserver.a.a.a.i */
/* loaded from: classes2.dex */
public class RegexFileFilter implements FileFilter {

    /* renamed from: a */
    private final RegularExpr f10873a;

    /* renamed from: b */
    private final FileFilter f10874b;

    public RegexFileFilter(String str, FileFilter fileFilter) {
        this.f10873a = new RegularExpr(str);
        this.f10874b = fileFilter;
    }

    @Override // org.apache.ftpserver.p110a.p111a.p112a.FileFilter
    /* renamed from: a */
    public boolean mo1982a(FtpFile ftpFile) {
        FileFilter fileFilter = this.f10874b;
        if (fileFilter == null || fileFilter.mo1982a(ftpFile)) {
            return this.f10873a.m1660a(ftpFile.mo1768b());
        }
        return false;
    }
}
