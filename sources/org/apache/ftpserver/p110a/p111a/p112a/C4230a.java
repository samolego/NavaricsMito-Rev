package org.apache.ftpserver.p110a.p111a.p112a;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.apache.ftpserver.ftplet.FileSystemView;
import org.apache.ftpserver.ftplet.FtpException;
import org.apache.ftpserver.ftplet.FtpFile;

/* renamed from: org.apache.ftpserver.a.a.a.a */
/* loaded from: classes2.dex */
public class DirectoryLister {
    /* renamed from: a */
    private String m1995a(List<? extends FtpFile> list, FileFilter fileFilter, FileFormater fileFormater) {
        return m1994a(list, fileFilter, fileFormater, true) + m1994a(list, fileFilter, fileFormater, false);
    }

    /* renamed from: a */
    private String m1994a(List<? extends FtpFile> list, FileFilter fileFilter, FileFormater fileFormater, boolean z) {
        StringBuilder sb = new StringBuilder();
        for (FtpFile ftpFile : list) {
            if (ftpFile != null && (fileFilter == null || fileFilter.mo1982a(ftpFile))) {
                if (ftpFile.mo1764d() == z) {
                    sb.append(fileFormater.mo1983a(ftpFile));
                }
            }
        }
        return sb.toString();
    }

    /* renamed from: a */
    public String m1993a(ListArgument listArgument, FileSystemView fileSystemView, FileFormater fileFormater) throws IOException {
        StringBuilder sb = new StringBuilder();
        List<? extends FtpFile> m1992a = m1992a(fileSystemView, listArgument.m1986b());
        if (m1992a != null) {
            RegexFileFilter visibleFileFilter = listArgument.m1987a('a') ? null : new VisibleFileFilter();
            if (listArgument.m1988a() != null) {
                visibleFileFilter = new RegexFileFilter(listArgument.m1988a(), visibleFileFilter);
            }
            sb.append(m1995a(m1992a, visibleFileFilter, fileFormater));
        }
        return sb.toString();
    }

    /* renamed from: a */
    private List<? extends FtpFile> m1992a(FileSystemView fileSystemView, String str) {
        List<? extends FtpFile> mo1751q;
        try {
            FtpFile mo1774a = fileSystemView.mo1774a(str);
            if (mo1774a.mo1763e()) {
                mo1751q = new ArrayList<>();
                mo1751q.add(mo1774a);
            } else {
                mo1751q = mo1774a.mo1751q();
            }
            return mo1751q;
        } catch (FtpException unused) {
            return null;
        }
    }
}
