package okhttp3.internal.p108f;

import java.security.cert.CertificateParsingException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLSession;
import okhttp3.internal.C2930c;
import org.slf4j.Marker;

/* renamed from: okhttp3.internal.f.d */
/* loaded from: classes2.dex */
public final class OkHostnameVerifier implements HostnameVerifier {

    /* renamed from: a */
    public static final OkHostnameVerifier f10302a = new OkHostnameVerifier();

    private OkHostnameVerifier() {
    }

    @Override // javax.net.ssl.HostnameVerifier
    public boolean verify(String str, SSLSession sSLSession) {
        try {
            return m2756a(str, (X509Certificate) sSLSession.getPeerCertificates()[0]);
        } catch (SSLException unused) {
            return false;
        }
    }

    /* renamed from: a */
    public boolean m2756a(String str, X509Certificate x509Certificate) {
        if (C2930c.m2869c(str)) {
            return m2753b(str, x509Certificate);
        }
        return m2752c(str, x509Certificate);
    }

    /* renamed from: b */
    private boolean m2753b(String str, X509Certificate x509Certificate) {
        List<String> m2754a = m2754a(x509Certificate, 7);
        int size = m2754a.size();
        for (int i = 0; i < size; i++) {
            if (str.equalsIgnoreCase(m2754a.get(i))) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: c */
    private boolean m2752c(String str, X509Certificate x509Certificate) {
        String lowerCase = str.toLowerCase(Locale.US);
        for (String str2 : m2754a(x509Certificate, 2)) {
            if (m2757a(lowerCase, str2)) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: a */
    public static List<String> m2755a(X509Certificate x509Certificate) {
        List<String> m2754a = m2754a(x509Certificate, 7);
        List<String> m2754a2 = m2754a(x509Certificate, 2);
        ArrayList arrayList = new ArrayList(m2754a.size() + m2754a2.size());
        arrayList.addAll(m2754a);
        arrayList.addAll(m2754a2);
        return arrayList;
    }

    /* renamed from: a */
    private static List<String> m2754a(X509Certificate x509Certificate, int i) {
        Integer num;
        String str;
        ArrayList arrayList = new ArrayList();
        try {
            Collection<List<?>> subjectAlternativeNames = x509Certificate.getSubjectAlternativeNames();
            if (subjectAlternativeNames == null) {
                return Collections.emptyList();
            }
            for (List<?> list : subjectAlternativeNames) {
                if (list != null && list.size() >= 2 && (num = (Integer) list.get(0)) != null && num.intValue() == i && (str = (String) list.get(1)) != null) {
                    arrayList.add(str);
                }
            }
            return arrayList;
        } catch (CertificateParsingException unused) {
            return Collections.emptyList();
        }
    }

    /* renamed from: a */
    public boolean m2757a(String str, String str2) {
        if (str == null || str.length() == 0 || str.startsWith(".") || str.endsWith("..") || str2 == null || str2.length() == 0 || str2.startsWith(".") || str2.endsWith("..")) {
            return false;
        }
        if (!str.endsWith(".")) {
            str = str + '.';
        }
        if (!str2.endsWith(".")) {
            str2 = str2 + '.';
        }
        String lowerCase = str2.toLowerCase(Locale.US);
        if (!lowerCase.contains(Marker.ANY_MARKER)) {
            return str.equals(lowerCase);
        }
        if (!lowerCase.startsWith("*.") || lowerCase.indexOf(42, 1) != -1 || str.length() < lowerCase.length() || "*.".equals(lowerCase)) {
            return false;
        }
        String substring = lowerCase.substring(1);
        if (str.endsWith(substring)) {
            int length = str.length() - substring.length();
            return length <= 0 || str.lastIndexOf(46, length - 1) == -1;
        }
        return false;
    }
}
