package org.apache.ftpserver.p119e.p120a;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.security.GeneralSecurityException;
import java.util.List;
import org.apache.ftpserver.DataConnectionConfiguration;
import org.apache.ftpserver.FtpServerConfigurationException;
import org.apache.ftpserver.ipfilter.MinaSessionFilter;
import org.apache.ftpserver.ipfilter.SessionFilter;
import org.apache.ftpserver.p118d.DefaultFtpHandler;
import org.apache.ftpserver.p118d.FtpHandler;
import org.apache.ftpserver.p118d.FtpServerContext;
import org.apache.ftpserver.ssl.ClientAuth;
import org.apache.ftpserver.ssl.SslConfiguration;
import org.apache.mina.core.session.IdleStatus;
import org.apache.mina.filter.codec.ProtocolCodecFilter;
import org.apache.mina.filter.logging.MdcInjectionFilter;
import org.apache.mina.filter.p134a.ExecutorFilter;
import org.apache.mina.filter.p135b.Subnet;
import org.apache.mina.filter.p136c.SslFilter;
import org.apache.mina.p126a.p127a.SocketAcceptor;
import org.apache.mina.p126a.p127a.p128a.NioSocketAcceptor;
import org.slf4j.C3154c;
import org.slf4j.InterfaceC3153b;

/* renamed from: org.apache.ftpserver.e.a.f */
/* loaded from: classes2.dex */
public class NioListener extends AbstractListener {

    /* renamed from: a */
    boolean f11074a;

    /* renamed from: b */
    private final InterfaceC3153b f11075b;

    /* renamed from: c */
    private SocketAcceptor f11076c;

    /* renamed from: d */
    private InetSocketAddress f11077d;

    /* renamed from: e */
    private FtpHandler f11078e;

    /* renamed from: f */
    private FtpServerContext f11079f;

    @Deprecated
    public NioListener(String str, int i, boolean z, SslConfiguration sslConfiguration, DataConnectionConfiguration dataConnectionConfiguration, int i2, List<InetAddress> list, List<Subnet> list2) {
        super(str, i, z, sslConfiguration, dataConnectionConfiguration, i2, list, list2);
        this.f11075b = C3154c.m262a(NioListener.class);
        this.f11074a = false;
        this.f11078e = new DefaultFtpHandler();
    }

    public NioListener(String str, int i, boolean z, SslConfiguration sslConfiguration, DataConnectionConfiguration dataConnectionConfiguration, int i2, SessionFilter sessionFilter) {
        super(str, i, z, sslConfiguration, dataConnectionConfiguration, i2, sessionFilter);
        this.f11075b = C3154c.m262a(NioListener.class);
        this.f11074a = false;
        this.f11078e = new DefaultFtpHandler();
    }

    @Override // org.apache.ftpserver.p119e.Listener
    /* renamed from: a */
    public synchronized void mo1797a(FtpServerContext ftpServerContext) {
        if (!m1796i()) {
            throw new IllegalStateException("Listener already started");
        }
        try {
            this.f11079f = ftpServerContext;
            this.f11076c = new NioSocketAcceptor(Runtime.getRuntime().availableProcessors());
            if (m1800g() != null) {
                this.f11077d = new InetSocketAddress(m1800g(), m1801f());
            } else {
                this.f11077d = new InetSocketAddress(m1801f());
            }
            this.f11076c.m1414a(true);
            this.f11076c.m1413h().mo981a(2048);
            this.f11076c.m1413h().mo979a(IdleStatus.f11537c, mo1803d());
            this.f11076c.m1413h().mo1407g(512);
            MdcInjectionFilter mdcInjectionFilter = new MdcInjectionFilter();
            this.f11076c.mo1195o().m1116b("mdcFilter", mdcInjectionFilter);
            SessionFilter h = m1799h();
            if (h != null) {
                this.f11076c.mo1195o().m1116b("sessionFilter", new MinaSessionFilter(h));
            }
            this.f11076c.mo1195o().m1116b("threadPool", new ExecutorFilter(ftpServerContext.mo1852j()));
            this.f11076c.mo1195o().m1116b("codec", new ProtocolCodecFilter(new FtpServerProtocolCodecFactory()));
            this.f11076c.mo1195o().m1116b("mdcFilter2", mdcInjectionFilter);
            this.f11076c.mo1195o().m1116b("logger", new FtpLoggingFilter());
            if (m1802e()) {
                SslConfiguration b = mo1805b();
                try {
                    SslFilter sslFilter = new SslFilter(b.m1676b());
                    if (b.m1674d() == ClientAuth.NEED) {
                        sslFilter.m910a(true);
                    } else if (b.m1674d() == ClientAuth.WANT) {
                        sslFilter.m904b(true);
                    }
                    if (b.m1675c() != null) {
                        sslFilter.m909a(b.m1675c());
                    }
                    this.f11076c.mo1195o().m1118a("sslFilter", sslFilter);
                } catch (GeneralSecurityException unused) {
                    throw new FtpServerConfigurationException("SSL could not be initialized, check configuration");
                }
            }
            this.f11078e.mo1908a(ftpServerContext, this);
            this.f11076c.mo1197a(new FtpHandlerAdapter(ftpServerContext, this.f11078e));
            try {
                this.f11076c.mo1208b(this.f11077d);
                m1795j();
            } catch (IOException e) {
                throw new FtpServerConfigurationException("Failed to bind to address " + this.f11077d + ", check configuration", e);
            }
        } catch (RuntimeException e2) {
            mo1798a();
            throw e2;
        }
    }

    /* renamed from: j */
    private void m1795j() {
        m1807a(this.f11076c.mo1412k_().getPort());
    }

    @Override // org.apache.ftpserver.p119e.Listener
    /* renamed from: a */
    public synchronized void mo1798a() {
        if (this.f11076c != null) {
            this.f11076c.mo1206m();
            this.f11076c.mo1194r();
            this.f11076c = null;
        }
        this.f11079f = null;
    }

    /* renamed from: i */
    public boolean m1796i() {
        return this.f11076c == null;
    }
}
