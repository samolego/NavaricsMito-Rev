package org.apache.ftpserver.p113b.p114a.p115a;

import java.io.File;
import java.util.StringTokenizer;
import org.apache.ftpserver.ftplet.FileSystemView;
import org.apache.ftpserver.ftplet.FtpException;
import org.apache.ftpserver.ftplet.FtpFile;
import org.apache.ftpserver.ftplet.User;
import org.slf4j.C3154c;
import org.slf4j.InterfaceC3153b;

/* renamed from: org.apache.ftpserver.b.a.a.b */
/* loaded from: classes2.dex */
public class NativeFileSystemView implements FileSystemView {

    /* renamed from: a */
    private final InterfaceC3153b f10936a = C3154c.m262a(NativeFileSystemView.class);

    /* renamed from: b */
    private String f10937b;

    /* renamed from: c */
    private String f10938c;

    /* renamed from: d */
    private final User f10939d;

    /* renamed from: e */
    private final boolean f10940e;

    @Override // org.apache.ftpserver.ftplet.FileSystemView
    /* renamed from: b */
    public void mo1773b() {
    }

    public NativeFileSystemView(User user, boolean z) throws FtpException {
        if (user == null) {
            throw new IllegalArgumentException("user can not be null");
        }
        if (user.mo1706e() == null) {
            throw new IllegalArgumentException("User home directory can not be null");
        }
        this.f10940e = z;
        String m1962c = m1962c(m1959f(user.mo1706e()));
        this.f10936a.debug("Native filesystem view created for user \"{}\" with root \"{}\"", user.mo1717a(), m1962c);
        this.f10937b = m1962c;
        this.f10939d = user;
        this.f10938c = "/";
    }

    @Override // org.apache.ftpserver.ftplet.FileSystemView
    /* renamed from: a */
    public FtpFile mo1775a() {
        if (this.f10938c.equals("/")) {
            return new NativeFtpFile("/", new File(this.f10937b), this.f10939d);
        }
        return new NativeFtpFile(this.f10938c, new File(this.f10937b, this.f10938c.substring(1)), this.f10939d);
    }

    @Override // org.apache.ftpserver.ftplet.FileSystemView
    /* renamed from: a */
    public FtpFile mo1774a(String str) {
        String m1963a = m1963a(this.f10937b, this.f10938c, str, this.f10940e);
        return new NativeFtpFile(m1963a.substring(this.f10937b.length() - 1), new File(m1963a), this.f10939d);
    }

    @Override // org.apache.ftpserver.ftplet.FileSystemView
    /* renamed from: b */
    public boolean mo1772b(String str) {
        String m1963a = m1963a(this.f10937b, this.f10938c, str, this.f10940e);
        if (new File(m1963a).isDirectory()) {
            String substring = m1963a.substring(this.f10937b.length() - 1);
            if (substring.charAt(substring.length() - 1) != '/') {
                substring = substring + '/';
            }
            this.f10938c = substring;
            return true;
        }
        return false;
    }

    /* renamed from: a */
    protected String m1963a(String str, String str2, String str3, boolean z) {
        String str4;
        int lastIndexOf;
        File[] listFiles;
        String m1962c = m1962c(m1959f(str));
        String m1959f = m1959f(str3);
        if (m1959f.charAt(0) != '/') {
            String m1964a = m1964a(str2, "/");
            str4 = m1962c + m1964a.substring(1);
        } else {
            str4 = m1962c;
        }
        String m1960e = m1960e(str4);
        StringTokenizer stringTokenizer = new StringTokenizer(m1959f, "/");
        while (stringTokenizer.hasMoreTokens()) {
            String nextToken = stringTokenizer.nextToken();
            if (!nextToken.equals(".")) {
                if (nextToken.equals("..")) {
                    if (m1960e.startsWith(m1962c) && (lastIndexOf = m1960e.lastIndexOf(47)) != -1) {
                        m1960e = m1960e.substring(0, lastIndexOf);
                    }
                } else if (nextToken.equals("~")) {
                    m1960e = m1960e(m1962c);
                } else {
                    if (z && (listFiles = new File(m1960e).listFiles(new NameEqualsFileFilter(nextToken, true))) != null && listFiles.length > 0) {
                        nextToken = listFiles[0].getName();
                    }
                    m1960e = m1960e + '/' + nextToken;
                }
            }
        }
        if (m1960e.length() + 1 == m1962c.length()) {
            m1960e = m1960e + '/';
        }
        return !m1960e.startsWith(m1962c) ? m1962c : m1960e;
    }

    /* renamed from: c */
    private String m1962c(String str) {
        if (str.charAt(str.length() - 1) != '/') {
            return str + '/';
        }
        return str;
    }

    /* renamed from: d */
    private String m1961d(String str) {
        if (str.charAt(0) != '/') {
            return '/' + str;
        }
        return str;
    }

    /* renamed from: e */
    private String m1960e(String str) {
        return str.charAt(str.length() + (-1)) == '/' ? str.substring(0, str.length() - 1) : str;
    }

    /* renamed from: f */
    private String m1959f(String str) {
        return str.replace(File.separatorChar, '/').replace('\\', '/');
    }

    /* renamed from: a */
    private String m1964a(String str, String str2) {
        if (str == null || str.trim().length() == 0) {
            str = str2;
        }
        return m1961d(m1962c(m1959f(str)));
    }
}
