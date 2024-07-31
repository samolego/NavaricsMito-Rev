package org.apache.ftpserver.p118d;

import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import org.apache.ftpserver.DataConnectionConfiguration;
import org.apache.ftpserver.DataConnectionException;
import org.apache.ftpserver.ftplet.DataConnection;
import org.apache.ftpserver.ftplet.FtpException;
import org.apache.ftpserver.ssl.ClientAuth;
import org.apache.ftpserver.ssl.SslConfiguration;
import org.slf4j.C3154c;
import org.slf4j.InterfaceC3153b;

/* renamed from: org.apache.ftpserver.d.o */
/* loaded from: classes2.dex */
public class IODataConnectionFactory implements ServerDataConnectionFactory {

    /* renamed from: a */
    ServerSocket f11034a;

    /* renamed from: b */
    InetAddress f11035b;

    /* renamed from: f */
    boolean f11039f;

    /* renamed from: g */
    InetAddress f11040g;

    /* renamed from: h */
    FtpIoSession f11041h;

    /* renamed from: j */
    private FtpServerContext f11043j;

    /* renamed from: k */
    private Socket f11044k;

    /* renamed from: i */
    private final InterfaceC3153b f11042i = C3154c.m262a(IODataConnectionFactory.class);

    /* renamed from: c */
    int f11036c = 0;

    /* renamed from: d */
    long f11037d = 0;

    /* renamed from: e */
    boolean f11038e = false;

    /* renamed from: l */
    private boolean f11045l = false;

    public IODataConnectionFactory(FtpServerContext ftpServerContext, FtpIoSession ftpIoSession) {
        this.f11039f = false;
        this.f11041h = ftpIoSession;
        this.f11043j = ftpServerContext;
        if (ftpIoSession == null || ftpIoSession.m1874w() == null || !ftpIoSession.m1874w().mo1804c().mo1937k()) {
            return;
        }
        this.f11039f = true;
    }

    @Override // org.apache.ftpserver.ftplet.DataConnectionFactory
    /* renamed from: b */
    public synchronized void mo1780b() {
        DataConnectionConfiguration mo1804c;
        if (this.f11044k != null) {
            try {
                this.f11044k.close();
            } catch (Exception e) {
                this.f11042i.warn("FtpDataConnection.closeDataSocket()", (Throwable) e);
            }
            this.f11044k = null;
        }
        if (this.f11034a != null) {
            try {
                this.f11034a.close();
            } catch (Exception e2) {
                this.f11042i.warn("FtpDataConnection.closeDataSocket()", (Throwable) e2);
            }
            if (this.f11041h != null && (mo1804c = this.f11041h.m1874w().mo1804c()) != null) {
                mo1804c.mo1947a(this.f11036c);
            }
            this.f11034a = null;
        }
        this.f11037d = 0L;
    }

    @Override // org.apache.ftpserver.p118d.ServerDataConnectionFactory
    /* renamed from: a */
    public synchronized void mo1834a(InetSocketAddress inetSocketAddress) {
        mo1780b();
        this.f11038e = false;
        this.f11035b = inetSocketAddress.getAddress();
        this.f11036c = inetSocketAddress.getPort();
        this.f11037d = System.currentTimeMillis();
    }

    /* renamed from: f */
    private SslConfiguration m1844f() {
        SslConfiguration mo1938j = this.f11041h.m1874w().mo1804c().mo1938j();
        return mo1938j == null ? this.f11041h.m1874w().mo1805b() : mo1938j;
    }

    @Override // org.apache.ftpserver.p118d.ServerDataConnectionFactory
    /* renamed from: c */
    public synchronized InetSocketAddress mo1831c() throws DataConnectionException {
        this.f11042i.debug("Initiating passive data connection");
        mo1780b();
        int mo1939i = this.f11041h.m1874w().mo1804c().mo1939i();
        if (mo1939i == -1) {
            this.f11034a = null;
            throw new DataConnectionException("Cannot find an available passive port.");
        }
        try {
            DataConnectionConfiguration mo1804c = this.f11041h.m1874w().mo1804c();
            if (mo1804c.mo1942f() == null) {
                this.f11035b = this.f11040g;
            } else {
                this.f11035b = m1847a(mo1804c.mo1942f());
            }
            if (this.f11039f) {
                this.f11042i.debug("Opening SSL passive data connection on address \"{}\" and port {}", this.f11035b, Integer.valueOf(mo1939i));
                if (m1844f() == null) {
                    throw new DataConnectionException("Data connection SSL required but not configured.");
                }
                this.f11034a = new ServerSocket(mo1939i, 0, this.f11035b);
                this.f11042i.debug("SSL Passive data connection created on address \"{}\" and port {}", this.f11035b, Integer.valueOf(mo1939i));
            } else {
                this.f11042i.debug("Opening passive data connection on address \"{}\" and port {}", this.f11035b, Integer.valueOf(mo1939i));
                this.f11034a = new ServerSocket(mo1939i, 0, this.f11035b);
                this.f11042i.debug("Passive data connection created on address \"{}\" and port {}", this.f11035b, Integer.valueOf(mo1939i));
            }
            this.f11036c = this.f11034a.getLocalPort();
            this.f11034a.setSoTimeout(mo1804c.mo1948a() * 1000);
            this.f11038e = true;
            this.f11037d = System.currentTimeMillis();
        } catch (Exception e) {
            mo1780b();
            throw new DataConnectionException("Failed to initate passive data connection: " + e.getMessage(), e);
        }
        return new InetSocketAddress(this.f11035b, this.f11036c);
    }

    /* renamed from: d */
    public InetAddress m1845d() {
        return this.f11035b;
    }

    @Override // org.apache.ftpserver.ftplet.DataConnectionFactory
    /* renamed from: a */
    public DataConnection mo1781a() throws Exception {
        return new IODataConnection(m1843g(), this.f11041h, this);
    }

    /* renamed from: g */
    private synchronized Socket m1843g() throws Exception {
        this.f11044k = null;
        DataConnectionConfiguration mo1804c = this.f11041h.m1874w().mo1804c();
        try {
            if (!this.f11038e) {
                if (this.f11039f) {
                    this.f11042i.debug("Opening secure active data connection");
                    SslConfiguration m1844f = m1844f();
                    if (m1844f == null) {
                        throw new FtpException("Data connection SSL not configured");
                    }
                    SSLSocket sSLSocket = (SSLSocket) m1844f.m1677a().createSocket();
                    sSLSocket.setUseClientMode(false);
                    if (m1844f.m1675c() != null) {
                        sSLSocket.setEnabledCipherSuites(m1844f.m1675c());
                    }
                    this.f11044k = sSLSocket;
                } else {
                    this.f11042i.debug("Opening active data connection");
                    this.f11044k = new Socket();
                }
                this.f11044k.setReuseAddress(true);
                InetAddress m1847a = m1847a(mo1804c.mo1944d());
                if (m1847a == null) {
                    m1847a = ((InetSocketAddress) this.f11041h.mo995k()).getAddress();
                }
                InetSocketAddress inetSocketAddress = new InetSocketAddress(m1847a, mo1804c.mo1943e());
                this.f11042i.debug("Binding active data connection to {}", inetSocketAddress);
                this.f11044k.bind(inetSocketAddress);
                this.f11044k.connect(new InetSocketAddress(this.f11035b, this.f11036c));
            } else {
                if (this.f11039f) {
                    this.f11042i.debug("Opening secure passive data connection");
                    SslConfiguration m1844f2 = m1844f();
                    if (m1844f2 == null) {
                        throw new FtpException("Data connection SSL not configured");
                    }
                    SSLSocketFactory m1677a = m1844f2.m1677a();
                    Socket accept = this.f11034a.accept();
                    SSLSocket sSLSocket2 = (SSLSocket) m1677a.createSocket(accept, accept.getInetAddress().getHostAddress(), accept.getPort(), true);
                    sSLSocket2.setUseClientMode(false);
                    if (m1844f2.m1674d() == ClientAuth.NEED) {
                        sSLSocket2.setNeedClientAuth(true);
                    } else if (m1844f2.m1674d() == ClientAuth.WANT) {
                        sSLSocket2.setWantClientAuth(true);
                    }
                    if (m1844f2.m1675c() != null) {
                        sSLSocket2.setEnabledCipherSuites(m1844f2.m1675c());
                    }
                    this.f11044k = sSLSocket2;
                } else {
                    this.f11042i.debug("Opening passive data connection");
                    this.f11044k = this.f11034a.accept();
                }
                if (mo1804c.mo1940h()) {
                    InetAddress address = ((InetSocketAddress) this.f11041h.mo994l()).getAddress();
                    InetAddress inetAddress = this.f11044k.getInetAddress();
                    if (!inetAddress.equals(address)) {
                        InterfaceC3153b interfaceC3153b = this.f11042i;
                        interfaceC3153b.warn("Passive IP Check failed. Closing data connection from " + inetAddress + " as it does not match the expected address " + address);
                        mo1780b();
                        return null;
                    }
                }
                this.f11044k.setSoTimeout(this.f11041h.m1874w().mo1804c().mo1948a() * 1000);
                this.f11042i.debug("Passive data connection opened");
            }
            this.f11044k.setSoTimeout(mo1804c.mo1948a() * 1000);
            if (this.f11044k instanceof SSLSocket) {
                ((SSLSocket) this.f11044k).startHandshake();
            }
            return this.f11044k;
        } catch (Exception e) {
            mo1780b();
            this.f11042i.warn("FtpDataConnection.getDataSocket()", (Throwable) e);
            throw e;
        }
    }

    /* renamed from: a */
    private InetAddress m1847a(String str) throws DataConnectionException {
        if (str == null) {
            return null;
        }
        try {
            return InetAddress.getByName(str);
        } catch (UnknownHostException e) {
            throw new DataConnectionException("Failed to resolve address", e);
        }
    }

    @Override // org.apache.ftpserver.p118d.ServerDataConnectionFactory
    /* renamed from: a */
    public void mo1833a(boolean z) {
        this.f11039f = z;
    }

    @Override // org.apache.ftpserver.p118d.ServerDataConnectionFactory
    /* renamed from: e */
    public boolean mo1830e() {
        return this.f11045l;
    }

    @Override // org.apache.ftpserver.p118d.ServerDataConnectionFactory
    /* renamed from: b */
    public void mo1832b(boolean z) {
        this.f11045l = z;
    }

    /* renamed from: a */
    public void m1846a(InetAddress inetAddress) {
        this.f11040g = inetAddress;
    }
}
