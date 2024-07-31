package okhttp3;

import java.io.IOException;
import java.security.cert.Certificate;
import java.util.Collections;
import java.util.List;
import javax.annotation.Nullable;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSession;
import okhttp3.internal.C2930c;

/* renamed from: okhttp3.r */
/* loaded from: classes2.dex */
public final class Handshake {

    /* renamed from: a */
    private final TlsVersion f10538a;

    /* renamed from: b */
    private final CipherSuite f10539b;

    /* renamed from: c */
    private final List<Certificate> f10540c;

    /* renamed from: d */
    private final List<Certificate> f10541d;

    private Handshake(TlsVersion tlsVersion, CipherSuite cipherSuite, List<Certificate> list, List<Certificate> list2) {
        this.f10538a = tlsVersion;
        this.f10539b = cipherSuite;
        this.f10540c = list;
        this.f10541d = list2;
    }

    /* renamed from: a */
    public static Handshake m2504a(SSLSession sSLSession) throws IOException {
        Certificate[] certificateArr;
        List emptyList;
        List emptyList2;
        String cipherSuite = sSLSession.getCipherSuite();
        if (cipherSuite == null) {
            throw new IllegalStateException("cipherSuite == null");
        }
        if ("SSL_NULL_WITH_NULL_NULL".equals(cipherSuite)) {
            throw new IOException("cipherSuite == SSL_NULL_WITH_NULL_NULL");
        }
        CipherSuite m2968a = CipherSuite.m2968a(cipherSuite);
        String protocol = sSLSession.getProtocol();
        if (protocol == null) {
            throw new IllegalStateException("tlsVersion == null");
        }
        if ("NONE".equals(protocol)) {
            throw new IOException("tlsVersion == NONE");
        }
        TlsVersion forJavaName = TlsVersion.forJavaName(protocol);
        try {
            certificateArr = sSLSession.getPeerCertificates();
        } catch (SSLPeerUnverifiedException unused) {
            certificateArr = null;
        }
        if (certificateArr != null) {
            emptyList = C2930c.m2875a(certificateArr);
        } else {
            emptyList = Collections.emptyList();
        }
        Certificate[] localCertificates = sSLSession.getLocalCertificates();
        if (localCertificates != null) {
            emptyList2 = C2930c.m2875a(localCertificates);
        } else {
            emptyList2 = Collections.emptyList();
        }
        return new Handshake(forJavaName, m2968a, emptyList, emptyList2);
    }

    /* renamed from: a */
    public CipherSuite m2505a() {
        return this.f10539b;
    }

    /* renamed from: b */
    public List<Certificate> m2503b() {
        return this.f10540c;
    }

    public boolean equals(@Nullable Object obj) {
        if (obj instanceof Handshake) {
            Handshake handshake = (Handshake) obj;
            return this.f10538a.equals(handshake.f10538a) && this.f10539b.equals(handshake.f10539b) && this.f10540c.equals(handshake.f10540c) && this.f10541d.equals(handshake.f10541d);
        }
        return false;
    }

    public int hashCode() {
        return ((((((527 + this.f10538a.hashCode()) * 31) + this.f10539b.hashCode()) * 31) + this.f10540c.hashCode()) * 31) + this.f10541d.hashCode();
    }
}
