package org.apache.ftpserver.p118d;

import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.security.cert.Certificate;
import java.util.Date;
import java.util.UUID;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSession;
import org.apache.ftpserver.ftplet.DataType;
import org.apache.ftpserver.ftplet.FileSystemView;
import org.apache.ftpserver.ftplet.FtpFile;
import org.apache.ftpserver.ftplet.FtpReply;
import org.apache.ftpserver.ftplet.FtpSession;
import org.apache.ftpserver.ftplet.Structure;
import org.apache.ftpserver.ftplet.User;
import org.apache.ftpserver.p119e.Listener;
import org.apache.mina.core.filterchain.IoFilterChain;
import org.apache.mina.core.p131c.CloseFuture;
import org.apache.mina.core.p131c.WriteFuture;
import org.apache.mina.core.p133e.InterfaceC3064f;
import org.apache.mina.core.p133e.IoService;
import org.apache.mina.core.p133e.TransportMetadata;
import org.apache.mina.core.session.AbstractIoSession;
import org.apache.mina.core.session.IdleStatus;
import org.apache.mina.core.session.IoSession;
import org.apache.mina.core.session.IoSessionConfig;
import org.apache.mina.core.write.InterfaceC3088b;
import org.apache.mina.core.write.WriteRequestQueue;
import org.apache.mina.filter.p136c.SslFilter;
import org.slf4j.C3154c;

/* renamed from: org.apache.ftpserver.d.k */
/* loaded from: classes2.dex */
public class FtpIoSession implements IoSession {

    /* renamed from: a */
    private final IoSession f11026a;

    /* renamed from: b */
    private final FtpServerContext f11027b;

    /* renamed from: c */
    private FtpReply f11028c = null;

    @Override // org.apache.mina.core.session.IoSession
    /* renamed from: a */
    public CloseFuture mo1011a(boolean z) {
        return this.f11026a.mo1011a(z);
    }

    @Override // org.apache.mina.core.session.IoSession
    /* renamed from: a */
    public CloseFuture mo1016a() {
        return this.f11026a.mo1016a();
    }

    @Override // org.apache.mina.core.session.IoSession
    /* renamed from: a */
    public boolean mo1015a(Object obj) {
        return this.f11026a.mo1015a(obj);
    }

    @Override // org.apache.mina.core.session.IoSession
    /* renamed from: b */
    public Object mo1009b(Object obj) {
        return this.f11026a.mo1009b(obj);
    }

    @Override // org.apache.mina.core.session.IoSession
    /* renamed from: a */
    public Object mo1014a(Object obj, Object obj2) {
        return this.f11026a.mo1014a(obj, obj2);
    }

    @Override // org.apache.mina.core.session.IoSession
    /* renamed from: b */
    public CloseFuture mo1010b() {
        return this.f11026a.mo1010b();
    }

    @Override // org.apache.mina.core.session.IoSession
    /* renamed from: c */
    public IoSessionConfig mo1007c() {
        return this.f11026a.mo1007c();
    }

    @Override // org.apache.mina.core.session.IoSession
    /* renamed from: d */
    public long mo1004d() {
        return this.f11026a.mo1004d();
    }

    @Override // org.apache.mina.core.session.IoSession
    /* renamed from: e */
    public IoFilterChain mo1002e() {
        return this.f11026a.mo1002e();
    }

    @Override // org.apache.mina.core.session.IoSession
    /* renamed from: f */
    public InterfaceC3064f mo1000f() {
        return this.f11026a.mo1000f();
    }

    @Override // org.apache.mina.core.session.IoSession
    /* renamed from: g */
    public long mo999g() {
        return this.f11026a.mo999g();
    }

    @Override // org.apache.mina.core.session.IoSession
    /* renamed from: a */
    public long mo1013a(IdleStatus idleStatus) {
        return this.f11026a.mo1013a(idleStatus);
    }

    @Override // org.apache.mina.core.session.IoSession
    /* renamed from: h */
    public long mo998h() {
        return this.f11026a.mo998h();
    }

    @Override // org.apache.mina.core.session.IoSession
    /* renamed from: i */
    public long mo997i() {
        return this.f11026a.mo997i();
    }

    @Override // org.apache.mina.core.session.IoSession
    /* renamed from: j */
    public long mo996j() {
        return this.f11026a.mo996j();
    }

    @Override // org.apache.mina.core.session.IoSession
    /* renamed from: k */
    public SocketAddress mo995k() {
        return this.f11026a.mo995k();
    }

    @Override // org.apache.mina.core.session.IoSession
    /* renamed from: l */
    public SocketAddress mo994l() {
        SocketAddress mo994l = this.f11026a.mo994l();
        if (mo994l == null && mo1015a("org.apache.ftpserver.cached-remote-address")) {
            return (SocketAddress) mo1009b("org.apache.ftpserver.cached-remote-address");
        }
        mo1008b("org.apache.ftpserver.cached-remote-address", mo994l);
        return mo994l;
    }

    @Override // org.apache.mina.core.session.IoSession
    /* renamed from: m */
    public IoService mo993m() {
        return this.f11026a.mo993m();
    }

    @Override // org.apache.mina.core.session.IoSession
    /* renamed from: n */
    public TransportMetadata mo992n() {
        return this.f11026a.mo992n();
    }

    @Override // org.apache.mina.core.session.IoSession
    /* renamed from: o */
    public boolean mo991o() {
        return this.f11026a.mo991o();
    }

    @Override // org.apache.mina.core.session.IoSession
    /* renamed from: p */
    public boolean mo990p() {
        return this.f11026a.mo990p();
    }

    @Override // org.apache.mina.core.session.IoSession
    /* renamed from: q */
    public boolean mo989q() {
        return this.f11026a.mo989q();
    }

    @Override // org.apache.mina.core.session.IoSession
    /* renamed from: c */
    public Object mo1006c(Object obj) {
        return this.f11026a.mo1006c(obj);
    }

    @Override // org.apache.mina.core.session.IoSession
    /* renamed from: d */
    public Object mo1003d(Object obj) {
        return this.f11026a.mo1003d(obj);
    }

    @Override // org.apache.mina.core.session.IoSession
    /* renamed from: b */
    public Object mo1008b(Object obj, Object obj2) {
        return this.f11026a.mo1008b(obj, obj2);
    }

    @Override // org.apache.mina.core.session.IoSession
    /* renamed from: c */
    public Object mo1005c(Object obj, Object obj2) {
        return this.f11026a.mo1005c(obj, obj2);
    }

    @Override // org.apache.mina.core.session.IoSession
    /* renamed from: e */
    public WriteFuture mo1001e(Object obj) {
        WriteFuture mo1001e = this.f11026a.mo1001e(obj);
        this.f11028c = (FtpReply) obj;
        return mo1001e;
    }

    /* renamed from: r */
    public void m1879r() {
        mo1006c("org.apache.ftpserver.rename-from");
        mo1006c("org.apache.ftpserver.file-offset");
    }

    /* renamed from: s */
    public synchronized ServerDataConnectionFactory m1878s() {
        if (mo1015a("org.apache.ftpserver.data-connection")) {
            return (ServerDataConnectionFactory) mo1009b("org.apache.ftpserver.data-connection");
        }
        IODataConnectionFactory iODataConnectionFactory = new IODataConnectionFactory(this.f11027b, this);
        iODataConnectionFactory.m1846a(((InetSocketAddress) mo995k()).getAddress());
        mo1008b("org.apache.ftpserver.data-connection", iODataConnectionFactory);
        return iODataConnectionFactory;
    }

    /* renamed from: t */
    public FileSystemView m1877t() {
        return (FileSystemView) mo1009b("org.apache.ftpserver.file-system");
    }

    /* renamed from: u */
    public User m1876u() {
        return (User) mo1009b("org.apache.ftpserver.user");
    }

    /* renamed from: v */
    public boolean m1875v() {
        return mo1015a("org.apache.ftpserver.user");
    }

    /* renamed from: w */
    public Listener m1874w() {
        return (Listener) mo1009b("org.apache.ftpserver.listener");
    }

    /* renamed from: a */
    public void m1888a(Listener listener) {
        mo1008b("org.apache.ftpserver.listener", listener);
    }

    /* renamed from: x */
    public FtpSession m1873x() {
        return new DefaultFtpSession(this);
    }

    /* renamed from: y */
    public String m1872y() {
        return (String) mo1009b("org.apache.ftpserver.language");
    }

    /* renamed from: a */
    public void m1889a(String str) {
        mo1008b("org.apache.ftpserver.language", str);
    }

    /* renamed from: z */
    public String m1871z() {
        return (String) mo1009b("org.apache.ftpserver.user-argument");
    }

    /* renamed from: a */
    public void m1883a(User user) {
        mo1008b("org.apache.ftpserver.user", user);
    }

    /* renamed from: b */
    public void m1881b(String str) {
        mo1008b("org.apache.ftpserver.user-argument", str);
    }

    /* renamed from: A */
    public int m1905A() {
        return ((Integer) mo1014a("org.apache.ftpserver.max-idle-time", 0)).intValue();
    }

    /* renamed from: a */
    public void m1891a(int i) {
        mo1008b("org.apache.ftpserver.max-idle-time", Integer.valueOf(i));
        int mo1803d = m1874w().mo1803d();
        if (mo1803d <= 0 || (i > 0 && i < mo1803d)) {
            this.f11026a.mo1007c().mo973d(i);
        }
    }

    /* renamed from: B */
    public synchronized void m1904B() {
        mo1008b("org.apache.ftpserver.failed-logins", Integer.valueOf(((Integer) mo1014a("org.apache.ftpserver.failed-logins", 0)).intValue() + 1));
    }

    /* renamed from: C */
    public int m1903C() {
        return ((Integer) mo1014a("org.apache.ftpserver.failed-logins", 0)).intValue();
    }

    /* renamed from: a */
    public void m1885a(FileSystemView fileSystemView) {
        mo1008b("org.apache.ftpserver.login-time", new Date());
        mo1008b("org.apache.ftpserver.file-system", fileSystemView);
    }

    /* renamed from: D */
    public void m1902D() {
        m1901E();
        mo1006c("org.apache.ftpserver.user");
        mo1006c("org.apache.ftpserver.user-argument");
        mo1006c("org.apache.ftpserver.login-time");
        mo1006c("org.apache.ftpserver.file-system");
        mo1006c("org.apache.ftpserver.rename-from");
        mo1006c("org.apache.ftpserver.file-offset");
    }

    /* renamed from: E */
    public void m1901E() {
        ServerFtpStatistics serverFtpStatistics = (ServerFtpStatistics) this.f11027b.mo1720c();
        if (serverFtpStatistics != null) {
            serverFtpStatistics.mo1820e(this);
            C3154c.m262a(getClass()).debug("Statistics login decreased due to user logout");
            return;
        }
        C3154c.m262a(getClass()).warn("Statistics not available in session, can not decrease login  count");
    }

    /* renamed from: a */
    public void m1890a(long j) {
        mo1008b("org.apache.ftpserver.file-offset", Long.valueOf(j));
    }

    /* renamed from: a */
    public void m1884a(FtpFile ftpFile) {
        mo1008b("org.apache.ftpserver.rename-from", ftpFile);
    }

    /* renamed from: F */
    public FtpFile m1900F() {
        return (FtpFile) mo1009b("org.apache.ftpserver.rename-from");
    }

    /* renamed from: G */
    public long m1899G() {
        return ((Long) mo1014a("org.apache.ftpserver.file-offset", 0L)).longValue();
    }

    /* renamed from: a */
    public void m1886a(Structure structure) {
        mo1008b("org.apache.ftpserver.structure", structure);
    }

    /* renamed from: a */
    public void m1887a(DataType dataType) {
        mo1008b("org.apache.ftpserver.data-type", dataType);
    }

    /* renamed from: H */
    public UUID m1898H() {
        UUID uuid;
        synchronized (this.f11026a) {
            if (!this.f11026a.mo1015a("org.apache.ftpserver.session-id")) {
                this.f11026a.mo1008b("org.apache.ftpserver.session-id", UUID.randomUUID());
            }
            uuid = (UUID) this.f11026a.mo1009b("org.apache.ftpserver.session-id");
        }
        return uuid;
    }

    public FtpIoSession(IoSession ioSession, FtpServerContext ftpServerContext) {
        this.f11026a = ioSession;
        this.f11027b = ftpServerContext;
    }

    /* renamed from: I */
    public DataType m1897I() {
        return (DataType) mo1014a("org.apache.ftpserver.data-type", DataType.ASCII);
    }

    /* renamed from: J */
    public Date m1896J() {
        return (Date) mo1009b("org.apache.ftpserver.login-time");
    }

    /* renamed from: K */
    public Date m1895K() {
        return (Date) mo1009b("org.apache.ftpserver.last-access-time");
    }

    /* renamed from: L */
    public Certificate[] m1894L() {
        SSLSession m911a;
        if (!mo1002e().mo1092c(SslFilter.class) || (m911a = ((SslFilter) mo1002e().mo1097b(SslFilter.class)).m911a((IoSession) this)) == null) {
            return null;
        }
        try {
            return m911a.getPeerCertificates();
        } catch (SSLPeerUnverifiedException unused) {
            return null;
        }
    }

    /* renamed from: M */
    public void m1893M() {
        mo1008b("org.apache.ftpserver.last-access-time", new Date());
    }

    @Override // org.apache.mina.core.session.IoSession
    /* renamed from: N */
    public InterfaceC3088b mo1019N() {
        return this.f11026a.mo1019N();
    }

    /* renamed from: b */
    public void m1882b(int i) {
        IoSession ioSession = this.f11026a;
        if (ioSession instanceof AbstractIoSession) {
            ((AbstractIoSession) ioSession).m1074a(i);
            ((AbstractIoSession) this.f11026a).m1073a(i, System.currentTimeMillis());
        }
    }

    /* renamed from: c */
    public void m1880c(int i) {
        IoSession ioSession = this.f11026a;
        if (ioSession instanceof AbstractIoSession) {
            ((AbstractIoSession) ioSession).m1071a(i, System.currentTimeMillis());
        }
    }

    /* renamed from: O */
    public FtpReply m1892O() {
        return this.f11028c;
    }

    @Override // org.apache.mina.core.session.IoSession
    /* renamed from: P */
    public WriteRequestQueue mo1018P() {
        return this.f11026a.mo1018P();
    }

    @Override // org.apache.mina.core.session.IoSession
    /* renamed from: Q */
    public boolean mo1017Q() {
        return this.f11026a.mo1017Q();
    }

    @Override // org.apache.mina.core.session.IoSession
    /* renamed from: a */
    public void mo1012a(InterfaceC3088b interfaceC3088b) {
        this.f11026a.mo1012a(interfaceC3088b);
    }
}
