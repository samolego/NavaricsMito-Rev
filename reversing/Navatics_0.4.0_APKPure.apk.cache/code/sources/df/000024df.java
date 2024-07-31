package okhttp3.internal.p097f;

import java.security.cert.X509Certificate;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import javax.security.auth.x500.X500Principal;

/* compiled from: BasicTrustRootIndex.java */
/* renamed from: okhttp3.internal.f.b, reason: use source file name */
/* loaded from: classes2.dex */
public final class BasicTrustRootIndex implements InterfaceC2958e {

    /* renamed from: a */
    private final Map<X500Principal, Set<X509Certificate>> f10342a = new LinkedHashMap();

    public BasicTrustRootIndex(X509Certificate... x509CertificateArr) {
        for (X509Certificate x509Certificate : x509CertificateArr) {
            X500Principal subjectX500Principal = x509Certificate.getSubjectX500Principal();
            Set<X509Certificate> set = this.f10342a.get(subjectX500Principal);
            if (set == null) {
                set = new LinkedHashSet<>(1);
                this.f10342a.put(subjectX500Principal, set);
            }
            set.add(x509Certificate);
        }
    }

    @Override // okhttp3.internal.p097f.InterfaceC2958e
    /* renamed from: a */
    public X509Certificate mo10090a(X509Certificate x509Certificate) {
        Set<X509Certificate> set = this.f10342a.get(x509Certificate.getIssuerX500Principal());
        if (set == null) {
            return null;
        }
        for (X509Certificate x509Certificate2 : set) {
            try {
                x509Certificate.verify(x509Certificate2.getPublicKey());
                return x509Certificate2;
            } catch (Exception unused) {
            }
        }
        return null;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        return (obj instanceof BasicTrustRootIndex) && ((BasicTrustRootIndex) obj).f10342a.equals(this.f10342a);
    }

    public int hashCode() {
        return this.f10342a.hashCode();
    }
}