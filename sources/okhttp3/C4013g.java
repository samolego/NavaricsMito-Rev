package okhttp3;

import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import javax.annotation.Nullable;
import javax.net.ssl.SSLPeerUnverifiedException;
import okhttp3.internal.C2930c;
import okhttp3.internal.p108f.CertificateChainCleaner;
import okio.ByteString;

/* renamed from: okhttp3.g */
/* loaded from: classes2.dex */
public final class CertificatePinner {

    /* renamed from: a */
    public static final CertificatePinner f9977a = new C2920a().m2971a();

    /* renamed from: b */
    private final Set<C2921b> f9978b;
    @Nullable

    /* renamed from: c */
    private final CertificateChainCleaner f9979c;

    CertificatePinner(Set<C2921b> set, @Nullable CertificateChainCleaner certificateChainCleaner) {
        this.f9978b = set;
        this.f9979c = certificateChainCleaner;
    }

    public boolean equals(@Nullable Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof CertificatePinner) {
            CertificatePinner certificatePinner = (CertificatePinner) obj;
            if (C2930c.m2895a(this.f9979c, certificatePinner.f9979c) && this.f9978b.equals(certificatePinner.f9978b)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        CertificateChainCleaner certificateChainCleaner = this.f9979c;
        return ((certificateChainCleaner != null ? certificateChainCleaner.hashCode() : 0) * 31) + this.f9978b.hashCode();
    }

    /* renamed from: a */
    public void m2976a(String str, List<Certificate> list) throws SSLPeerUnverifiedException {
        List<C2921b> m2977a = m2977a(str);
        if (m2977a.isEmpty()) {
            return;
        }
        CertificateChainCleaner certificateChainCleaner = this.f9979c;
        if (certificateChainCleaner != null) {
            list = certificateChainCleaner.mo2759a(list, str);
        }
        int size = list.size();
        for (int i = 0; i < size; i++) {
            X509Certificate x509Certificate = (X509Certificate) list.get(i);
            int size2 = m2977a.size();
            ByteString byteString = null;
            ByteString byteString2 = null;
            for (int i2 = 0; i2 < size2; i2++) {
                C2921b c2921b = m2977a.get(i2);
                if (c2921b.f9983c.equals("sha256/")) {
                    if (byteString == null) {
                        byteString = m2972b(x509Certificate);
                    }
                    if (c2921b.f9984d.equals(byteString)) {
                        return;
                    }
                } else if (c2921b.f9983c.equals("sha1/")) {
                    if (byteString2 == null) {
                        byteString2 = m2974a(x509Certificate);
                    }
                    if (c2921b.f9984d.equals(byteString2)) {
                        return;
                    }
                } else {
                    throw new AssertionError("unsupported hashAlgorithm: " + c2921b.f9983c);
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Certificate pinning failure!");
        sb.append("\n  Peer certificate chain:");
        int size3 = list.size();
        for (int i3 = 0; i3 < size3; i3++) {
            X509Certificate x509Certificate2 = (X509Certificate) list.get(i3);
            sb.append("\n    ");
            sb.append(m2975a((Certificate) x509Certificate2));
            sb.append(": ");
            sb.append(x509Certificate2.getSubjectDN().getName());
        }
        sb.append("\n  Pinned certificates for ");
        sb.append(str);
        sb.append(":");
        int size4 = m2977a.size();
        for (int i4 = 0; i4 < size4; i4++) {
            sb.append("\n    ");
            sb.append(m2977a.get(i4));
        }
        throw new SSLPeerUnverifiedException(sb.toString());
    }

    /* renamed from: a */
    List<C2921b> m2977a(String str) {
        List<C2921b> emptyList = Collections.emptyList();
        for (C2921b c2921b : this.f9978b) {
            if (c2921b.m2969a(str)) {
                if (emptyList.isEmpty()) {
                    emptyList = new ArrayList<>();
                }
                emptyList.add(c2921b);
            }
        }
        return emptyList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public CertificatePinner m2973a(@Nullable CertificateChainCleaner certificateChainCleaner) {
        return C2930c.m2895a(this.f9979c, certificateChainCleaner) ? this : new CertificatePinner(this.f9978b, certificateChainCleaner);
    }

    /* renamed from: a */
    public static String m2975a(Certificate certificate) {
        if (!(certificate instanceof X509Certificate)) {
            throw new IllegalArgumentException("Certificate pinning requires X509 certificates");
        }
        return "sha256/" + m2972b((X509Certificate) certificate).base64();
    }

    /* renamed from: a */
    static ByteString m2974a(X509Certificate x509Certificate) {
        return ByteString.m2330of(x509Certificate.getPublicKey().getEncoded()).sha1();
    }

    /* renamed from: b */
    static ByteString m2972b(X509Certificate x509Certificate) {
        return ByteString.m2330of(x509Certificate.getPublicKey().getEncoded()).sha256();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: CertificatePinner.java */
    /* renamed from: okhttp3.g$b */
    /* loaded from: classes2.dex */
    public static final class C2921b {

        /* renamed from: a */
        final String f9981a;

        /* renamed from: b */
        final String f9982b;

        /* renamed from: c */
        final String f9983c;

        /* renamed from: d */
        final ByteString f9984d;

        C2921b(String str, String str2) {
            String m2464f;
            this.f9981a = str;
            if (str.startsWith("*.")) {
                m2464f = HttpUrl.m2463f("http://" + str.substring(2)).m2464f();
            } else {
                m2464f = HttpUrl.m2463f("http://" + str).m2464f();
            }
            this.f9982b = m2464f;
            if (str2.startsWith("sha1/")) {
                this.f9983c = "sha1/";
                this.f9984d = ByteString.decodeBase64(str2.substring(5));
            } else if (str2.startsWith("sha256/")) {
                this.f9983c = "sha256/";
                this.f9984d = ByteString.decodeBase64(str2.substring(7));
            } else {
                throw new IllegalArgumentException("pins must start with 'sha256/' or 'sha1/': " + str2);
            }
            if (this.f9984d != null) {
                return;
            }
            throw new IllegalArgumentException("pins must be base64: " + str2);
        }

        /* renamed from: a */
        boolean m2969a(String str) {
            if (this.f9981a.startsWith("*.")) {
                int indexOf = str.indexOf(46);
                if ((str.length() - indexOf) - 1 == this.f9982b.length()) {
                    String str2 = this.f9982b;
                    if (str.regionMatches(false, indexOf + 1, str2, 0, str2.length())) {
                        return true;
                    }
                }
                return false;
            }
            return str.equals(this.f9982b);
        }

        public boolean equals(Object obj) {
            if (obj instanceof C2921b) {
                C2921b c2921b = (C2921b) obj;
                if (this.f9981a.equals(c2921b.f9981a) && this.f9983c.equals(c2921b.f9983c) && this.f9984d.equals(c2921b.f9984d)) {
                    return true;
                }
            }
            return false;
        }

        public int hashCode() {
            return ((((527 + this.f9981a.hashCode()) * 31) + this.f9983c.hashCode()) * 31) + this.f9984d.hashCode();
        }

        public String toString() {
            return this.f9983c + this.f9984d.base64();
        }
    }

    /* compiled from: CertificatePinner.java */
    /* renamed from: okhttp3.g$a */
    /* loaded from: classes2.dex */
    public static final class C2920a {

        /* renamed from: a */
        private final List<C2921b> f9980a = new ArrayList();

        /* renamed from: a */
        public C2920a m2970a(String str, String... strArr) {
            if (str == null) {
                throw new NullPointerException("pattern == null");
            }
            for (String str2 : strArr) {
                this.f9980a.add(new C2921b(str, str2));
            }
            return this;
        }

        /* renamed from: a */
        public CertificatePinner m2971a() {
            return new CertificatePinner(new LinkedHashSet(this.f9980a), null);
        }
    }
}
