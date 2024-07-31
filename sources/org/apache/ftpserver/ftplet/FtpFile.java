package org.apache.ftpserver.ftplet;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

/* renamed from: org.apache.ftpserver.ftplet.k */
/* loaded from: classes2.dex */
public interface FtpFile {
    /* renamed from: a */
    String mo1771a();

    /* renamed from: a */
    boolean mo1770a(long j);

    /* renamed from: a */
    boolean mo1769a(FtpFile ftpFile);

    /* renamed from: b */
    OutputStream mo1767b(long j) throws IOException;

    /* renamed from: b */
    String mo1768b();

    /* renamed from: c */
    InputStream mo1765c(long j) throws IOException;

    /* renamed from: c */
    boolean mo1766c();

    /* renamed from: d */
    boolean mo1764d();

    /* renamed from: e */
    boolean mo1763e();

    /* renamed from: f */
    boolean mo1762f();

    /* renamed from: g */
    long mo1761g();

    /* renamed from: h */
    String mo1760h();

    /* renamed from: i */
    String mo1759i();

    /* renamed from: j */
    int mo1758j();

    /* renamed from: k */
    long mo1757k();

    /* renamed from: l */
    boolean mo1756l();

    /* renamed from: m */
    boolean mo1755m();

    /* renamed from: n */
    boolean mo1754n();

    /* renamed from: o */
    boolean mo1753o();

    /* renamed from: p */
    boolean mo1752p();

    /* renamed from: q */
    List<? extends FtpFile> mo1751q();
}
