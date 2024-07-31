package okhttp3.internal.p108f;

import java.security.cert.Certificate;
import java.util.List;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.X509TrustManager;
import okhttp3.internal.p107e.Platform;

/* renamed from: okhttp3.internal.f.c */
/* loaded from: classes2.dex */
public abstract class CertificateChainCleaner {
    /* renamed from: a */
    public abstract List<Certificate> mo2759a(List<Certificate> list, String str) throws SSLPeerUnverifiedException;

    /* renamed from: a */
    public static CertificateChainCleaner m2758a(X509TrustManager x509TrustManager) {
        return Platform.m2762c().mo2768a(x509TrustManager);
    }
}
