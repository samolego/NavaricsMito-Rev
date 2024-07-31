package okhttp3;

import java.util.Arrays;
import java.util.List;
import javax.annotation.Nullable;
import javax.net.ssl.SSLSocket;
import okhttp3.internal.C2930c;

/* renamed from: okhttp3.k */
/* loaded from: classes2.dex */
public final class ConnectionSpec {

    /* renamed from: e */
    final boolean f10495e;

    /* renamed from: f */
    final boolean f10496f;
    @Nullable

    /* renamed from: g */
    final String[] f10497g;
    @Nullable

    /* renamed from: h */
    final String[] f10498h;

    /* renamed from: i */
    private static final CipherSuite[] f10493i = {CipherSuite.f10035aX, CipherSuite.f10066bb, CipherSuite.f10036aY, CipherSuite.f10067bc, CipherSuite.f10073bi, CipherSuite.f10072bh};

    /* renamed from: j */
    private static final CipherSuite[] f10494j = {CipherSuite.f10035aX, CipherSuite.f10066bb, CipherSuite.f10036aY, CipherSuite.f10067bc, CipherSuite.f10073bi, CipherSuite.f10072bh, CipherSuite.f10020aI, CipherSuite.f10021aJ, CipherSuite.f10044ag, CipherSuite.f10045ah, CipherSuite.f9989E, CipherSuite.f9993I, CipherSuite.f10082i};

    /* renamed from: a */
    public static final ConnectionSpec f10489a = new C2974a(true).m2564a(f10493i).m2565a(TlsVersion.TLS_1_2).m2567a(true).m2568a();

    /* renamed from: b */
    public static final ConnectionSpec f10490b = new C2974a(true).m2564a(f10494j).m2565a(TlsVersion.TLS_1_2, TlsVersion.TLS_1_1, TlsVersion.TLS_1_0).m2567a(true).m2568a();

    /* renamed from: c */
    public static final ConnectionSpec f10491c = new C2974a(f10490b).m2565a(TlsVersion.TLS_1_0).m2567a(true).m2568a();

    /* renamed from: d */
    public static final ConnectionSpec f10492d = new C2974a(false).m2568a();

    ConnectionSpec(C2974a c2974a) {
        this.f10495e = c2974a.f10499a;
        this.f10497g = c2974a.f10500b;
        this.f10498h = c2974a.f10501c;
        this.f10496f = c2974a.f10502d;
    }

    /* renamed from: a */
    public boolean m2575a() {
        return this.f10495e;
    }

    @Nullable
    /* renamed from: b */
    public List<CipherSuite> m2572b() {
        String[] strArr = this.f10497g;
        if (strArr != null) {
            return CipherSuite.m2966a(strArr);
        }
        return null;
    }

    @Nullable
    /* renamed from: c */
    public List<TlsVersion> m2570c() {
        String[] strArr = this.f10498h;
        if (strArr != null) {
            return TlsVersion.forJavaNames(strArr);
        }
        return null;
    }

    /* renamed from: d */
    public boolean m2569d() {
        return this.f10496f;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public void m2573a(SSLSocket sSLSocket, boolean z) {
        ConnectionSpec m2571b = m2571b(sSLSocket, z);
        String[] strArr = m2571b.f10498h;
        if (strArr != null) {
            sSLSocket.setEnabledProtocols(strArr);
        }
        String[] strArr2 = m2571b.f10497g;
        if (strArr2 != null) {
            sSLSocket.setEnabledCipherSuites(strArr2);
        }
    }

    /* renamed from: b */
    private ConnectionSpec m2571b(SSLSocket sSLSocket, boolean z) {
        String[] enabledCipherSuites;
        String[] enabledProtocols;
        if (this.f10497g != null) {
            enabledCipherSuites = C2930c.m2882a(CipherSuite.f10011a, sSLSocket.getEnabledCipherSuites(), this.f10497g);
        } else {
            enabledCipherSuites = sSLSocket.getEnabledCipherSuites();
        }
        if (this.f10498h != null) {
            enabledProtocols = C2930c.m2882a(C2930c.f10186h, sSLSocket.getEnabledProtocols(), this.f10498h);
        } else {
            enabledProtocols = sSLSocket.getEnabledProtocols();
        }
        String[] supportedCipherSuites = sSLSocket.getSupportedCipherSuites();
        int m2883a = C2930c.m2883a(CipherSuite.f10011a, supportedCipherSuites, "TLS_FALLBACK_SCSV");
        if (z && m2883a != -1) {
            enabledCipherSuites = C2930c.m2874a(enabledCipherSuites, supportedCipherSuites[m2883a]);
        }
        return new C2974a(this).m2566a(enabledCipherSuites).m2563b(enabledProtocols).m2568a();
    }

    /* renamed from: a */
    public boolean m2574a(SSLSocket sSLSocket) {
        if (this.f10495e) {
            if (this.f10498h == null || C2930c.m2871b(C2930c.f10186h, this.f10498h, sSLSocket.getEnabledProtocols())) {
                return this.f10497g == null || C2930c.m2871b(CipherSuite.f10011a, this.f10497g, sSLSocket.getEnabledCipherSuites());
            }
            return false;
        }
        return false;
    }

    public boolean equals(@Nullable Object obj) {
        if (obj instanceof ConnectionSpec) {
            if (obj == this) {
                return true;
            }
            ConnectionSpec connectionSpec = (ConnectionSpec) obj;
            boolean z = this.f10495e;
            if (z != connectionSpec.f10495e) {
                return false;
            }
            return !z || (Arrays.equals(this.f10497g, connectionSpec.f10497g) && Arrays.equals(this.f10498h, connectionSpec.f10498h) && this.f10496f == connectionSpec.f10496f);
        }
        return false;
    }

    public int hashCode() {
        if (this.f10495e) {
            return ((((527 + Arrays.hashCode(this.f10497g)) * 31) + Arrays.hashCode(this.f10498h)) * 31) + (!this.f10496f ? 1 : 0);
        }
        return 17;
    }

    public String toString() {
        if (this.f10495e) {
            String obj = this.f10497g != null ? m2572b().toString() : "[all enabled]";
            String obj2 = this.f10498h != null ? m2570c().toString() : "[all enabled]";
            return "ConnectionSpec(cipherSuites=" + obj + ", tlsVersions=" + obj2 + ", supportsTlsExtensions=" + this.f10496f + ")";
        }
        return "ConnectionSpec()";
    }

    /* compiled from: ConnectionSpec.java */
    /* renamed from: okhttp3.k$a */
    /* loaded from: classes2.dex */
    public static final class C2974a {

        /* renamed from: a */
        boolean f10499a;
        @Nullable

        /* renamed from: b */
        String[] f10500b;
        @Nullable

        /* renamed from: c */
        String[] f10501c;

        /* renamed from: d */
        boolean f10502d;

        C2974a(boolean z) {
            this.f10499a = z;
        }

        public C2974a(ConnectionSpec connectionSpec) {
            this.f10499a = connectionSpec.f10495e;
            this.f10500b = connectionSpec.f10497g;
            this.f10501c = connectionSpec.f10498h;
            this.f10502d = connectionSpec.f10496f;
        }

        /* renamed from: a */
        public C2974a m2564a(CipherSuite... cipherSuiteArr) {
            if (!this.f10499a) {
                throw new IllegalStateException("no cipher suites for cleartext connections");
            }
            String[] strArr = new String[cipherSuiteArr.length];
            for (int i = 0; i < cipherSuiteArr.length; i++) {
                strArr[i] = cipherSuiteArr[i].f10100bk;
            }
            return m2566a(strArr);
        }

        /* renamed from: a */
        public C2974a m2566a(String... strArr) {
            if (!this.f10499a) {
                throw new IllegalStateException("no cipher suites for cleartext connections");
            }
            if (strArr.length == 0) {
                throw new IllegalArgumentException("At least one cipher suite is required");
            }
            this.f10500b = (String[]) strArr.clone();
            return this;
        }

        /* renamed from: a */
        public C2974a m2565a(TlsVersion... tlsVersionArr) {
            if (!this.f10499a) {
                throw new IllegalStateException("no TLS versions for cleartext connections");
            }
            String[] strArr = new String[tlsVersionArr.length];
            for (int i = 0; i < tlsVersionArr.length; i++) {
                strArr[i] = tlsVersionArr[i].javaName;
            }
            return m2563b(strArr);
        }

        /* renamed from: b */
        public C2974a m2563b(String... strArr) {
            if (!this.f10499a) {
                throw new IllegalStateException("no TLS versions for cleartext connections");
            }
            if (strArr.length == 0) {
                throw new IllegalArgumentException("At least one TLS version is required");
            }
            this.f10501c = (String[]) strArr.clone();
            return this;
        }

        /* renamed from: a */
        public C2974a m2567a(boolean z) {
            if (!this.f10499a) {
                throw new IllegalStateException("no TLS extensions for cleartext connections");
            }
            this.f10502d = z;
            return this;
        }

        /* renamed from: a */
        public ConnectionSpec m2568a() {
            return new ConnectionSpec(this);
        }
    }
}
