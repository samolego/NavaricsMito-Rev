package org.apache.ftpserver.p110a.p111a.p112a;

import org.apache.ftpserver.ftplet.FtpFile;

/* renamed from: org.apache.ftpserver.a.a.a.j */
/* loaded from: classes2.dex */
public class VisibleFileFilter implements FileFilter {

    /* renamed from: a */
    private final FileFilter f10875a;

    public VisibleFileFilter() {
        this(null);
    }

    public VisibleFileFilter(FileFilter fileFilter) {
        this.f10875a = fileFilter;
    }

    @Override // org.apache.ftpserver.p110a.p111a.p112a.FileFilter
    /* renamed from: a */
    public boolean mo1982a(FtpFile ftpFile) {
        FileFilter fileFilter = this.f10875a;
        if (fileFilter == null || fileFilter.mo1982a(ftpFile)) {
            return !ftpFile.mo1766c();
        }
        return false;
    }
}
