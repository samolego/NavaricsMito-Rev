package org.apache.ftpserver.p118d;

import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import org.apache.ftpserver.ftplet.FileSystemView;
import org.apache.ftpserver.ftplet.FtpRequest;
import org.apache.ftpserver.ftplet.FtpStatistics;
import org.apache.ftpserver.p121f.MessageResource;
import org.apache.ftpserver.util.DateUtils;

/* renamed from: org.apache.ftpserver.d.l */
/* loaded from: classes2.dex */
public class FtpReplyTranslator {
    /* renamed from: a */
    public static String m1866a(FtpIoSession ftpIoSession, FtpRequest ftpRequest, FtpServerContext ftpServerContext, int i, String str, String str2) {
        MessageResource mo1858d = ftpServerContext.mo1858d();
        String mo1787a = mo1858d != null ? mo1858d.mo1787a(i, str, ftpIoSession.m1872y()) : null;
        return m1863b(ftpIoSession, ftpRequest, ftpServerContext, i, str2, mo1787a == null ? "" : mo1787a);
    }

    /* renamed from: b */
    private static String m1863b(FtpIoSession ftpIoSession, FtpRequest ftpRequest, FtpServerContext ftpServerContext, int i, String str, String str2) {
        int indexOf;
        int i2;
        int indexOf2 = str2.indexOf(123, 0);
        if (indexOf2 == -1 || (indexOf = str2.indexOf(125, 0)) == -1 || indexOf2 > indexOf) {
            return str2;
        }
        StringBuilder sb = new StringBuilder(128);
        sb.append(str2.substring(0, indexOf2));
        while (true) {
            sb.append(m1861c(ftpIoSession, ftpRequest, ftpServerContext, i, str, str2.substring(indexOf2 + 1, indexOf)));
            i2 = indexOf + 1;
            indexOf2 = str2.indexOf(123, i2);
            if (indexOf2 == -1) {
                sb.append(str2.substring(i2));
                break;
            }
            int indexOf3 = str2.indexOf(125, i2);
            if (indexOf3 == -1 || indexOf2 > indexOf3) {
                break;
            }
            sb.append(str2.substring(i2, indexOf2));
            indexOf = indexOf3;
        }
        sb.append(str2.substring(i2));
        return sb.toString();
    }

    /* renamed from: c */
    private static String m1861c(FtpIoSession ftpIoSession, FtpRequest ftpRequest, FtpServerContext ftpServerContext, int i, String str, String str2) {
        String m1869a;
        if (str2.startsWith("output.")) {
            m1869a = m1870a(ftpIoSession, i, str, str2);
        } else if (str2.startsWith("server.")) {
            m1869a = m1865b(ftpIoSession, str2);
        } else if (str2.startsWith("request.")) {
            m1869a = m1867a(ftpIoSession, ftpRequest, str2);
        } else if (str2.startsWith("stat.")) {
            m1869a = m1859e(ftpIoSession, ftpServerContext, str2);
        } else {
            m1869a = str2.startsWith("client.") ? m1869a(ftpIoSession, str2) : null;
        }
        return m1869a == null ? "" : m1869a;
    }

    /* renamed from: a */
    private static String m1869a(FtpIoSession ftpIoSession, String str) {
        FileSystemView m1877t;
        if (str.equals("client.ip")) {
            if (ftpIoSession.mo994l() instanceof InetSocketAddress) {
                return ((InetSocketAddress) ftpIoSession.mo994l()).getAddress().getHostAddress();
            }
        } else if (str.equals("client.con.time")) {
            return DateUtils.m1671b(ftpIoSession.mo1004d());
        } else {
            if (str.equals("client.login.name")) {
                if (ftpIoSession.m1876u() != null) {
                    return ftpIoSession.m1876u().mo1717a();
                }
            } else if (str.equals("client.login.time")) {
                return DateUtils.m1671b(ftpIoSession.m1896J().getTime());
            } else {
                if (str.equals("client.access.time")) {
                    return DateUtils.m1671b(ftpIoSession.m1895K().getTime());
                }
                if (str.equals("client.home")) {
                    return ftpIoSession.m1876u().mo1706e();
                }
                if (str.equals("client.dir") && (m1877t = ftpIoSession.m1877t()) != null) {
                    try {
                        return m1877t.mo1775a().mo1771a();
                    } catch (Exception unused) {
                        return "";
                    }
                }
            }
        }
        return null;
    }

    /* renamed from: a */
    private static String m1870a(FtpIoSession ftpIoSession, int i, String str, String str2) {
        if (str2.equals("output.code")) {
            return String.valueOf(i);
        }
        if (str2.equals("output.msg")) {
            return str;
        }
        return null;
    }

    /* renamed from: a */
    private static String m1867a(FtpIoSession ftpIoSession, FtpRequest ftpRequest, String str) {
        if (ftpRequest == null) {
            return "";
        }
        if (str.equals("request.line")) {
            return ftpRequest.mo1750a();
        }
        if (str.equals("request.cmd")) {
            return ftpRequest.mo1749b();
        }
        if (str.equals("request.arg")) {
            return ftpRequest.mo1748c();
        }
        return null;
    }

    /* renamed from: b */
    private static String m1865b(FtpIoSession ftpIoSession, String str) {
        SocketAddress mo995k = ftpIoSession.mo995k();
        if (mo995k instanceof InetSocketAddress) {
            InetSocketAddress inetSocketAddress = (InetSocketAddress) mo995k;
            if (str.equals("server.ip")) {
                InetAddress address = inetSocketAddress.getAddress();
                if (address != null) {
                    return address.getHostAddress();
                }
                return null;
            } else if (str.equals("server.port")) {
                return String.valueOf(inetSocketAddress.getPort());
            } else {
                return null;
            }
        }
        return null;
    }

    /* renamed from: a */
    private static String m1868a(FtpIoSession ftpIoSession, FtpServerContext ftpServerContext, String str) {
        FtpStatistics c = ftpServerContext.mo1720c();
        if (str.equals("stat.con.total")) {
            return String.valueOf(c.mo1734i());
        }
        if (str.equals("stat.con.curr")) {
            return String.valueOf(c.mo1733j());
        }
        return null;
    }

    /* renamed from: b */
    private static String m1864b(FtpIoSession ftpIoSession, FtpServerContext ftpServerContext, String str) {
        FtpStatistics c = ftpServerContext.mo1720c();
        if (str.equals("stat.dir.create.count")) {
            return String.valueOf(c.mo1736g());
        }
        if (str.equals("stat.dir.delete.count")) {
            return String.valueOf(c.mo1735h());
        }
        return null;
    }

    /* renamed from: c */
    private static String m1862c(FtpIoSession ftpIoSession, FtpServerContext ftpServerContext, String str) {
        FtpStatistics c = ftpServerContext.mo1720c();
        if (str.equals("stat.file.upload.count")) {
            return String.valueOf(c.mo1741b());
        }
        if (str.equals("stat.file.upload.bytes")) {
            return String.valueOf(c.mo1738e());
        }
        if (str.equals("stat.file.download.count")) {
            return String.valueOf(c.mo1740c());
        }
        if (str.equals("stat.file.download.bytes")) {
            return String.valueOf(c.mo1737f());
        }
        if (str.equals("stat.file.delete.count")) {
            return String.valueOf(c.mo1739d());
        }
        return null;
    }

    /* renamed from: d */
    private static String m1860d(FtpIoSession ftpIoSession, FtpServerContext ftpServerContext, String str) {
        FtpStatistics c = ftpServerContext.mo1720c();
        if (str.equals("stat.login.total")) {
            return String.valueOf(c.mo1732k());
        }
        if (str.equals("stat.login.curr")) {
            return String.valueOf(c.mo1731l());
        }
        if (str.equals("stat.login.anon.total")) {
            return String.valueOf(c.mo1730m());
        }
        if (str.equals("stat.login.anon.curr")) {
            return String.valueOf(c.mo1729n());
        }
        return null;
    }

    /* renamed from: e */
    private static String m1859e(FtpIoSession ftpIoSession, FtpServerContext ftpServerContext, String str) {
        FtpStatistics c = ftpServerContext.mo1720c();
        if (str.equals("stat.start.time")) {
            return DateUtils.m1671b(c.mo1744a().getTime());
        }
        if (str.startsWith("stat.con")) {
            return m1868a(ftpIoSession, ftpServerContext, str);
        }
        if (str.startsWith("stat.login.")) {
            return m1860d(ftpIoSession, ftpServerContext, str);
        }
        if (str.startsWith("stat.file")) {
            return m1862c(ftpIoSession, ftpServerContext, str);
        }
        if (str.startsWith("stat.dir.")) {
            return m1864b(ftpIoSession, ftpServerContext, str);
        }
        return null;
    }
}
