package okhttp3.internal.p107e;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.security.NoSuchAlgorithmException;
import java.security.Security;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Nullable;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;
import okhttp3.OkHttpClient;
import okhttp3.Protocol;
import okhttp3.internal.p108f.BasicCertificateChainCleaner;
import okhttp3.internal.p108f.BasicTrustRootIndex;
import okhttp3.internal.p108f.CertificateChainCleaner;
import okhttp3.internal.p108f.TrustRootIndex;
import okio.Buffer;

/* renamed from: okhttp3.internal.e.f */
/* loaded from: classes2.dex */
public class Platform {

    /* renamed from: a */
    private static final Platform f10298a = m2777a();

    /* renamed from: b */
    private static final Logger f10299b = Logger.getLogger(OkHttpClient.class.getName());

    @Nullable
    /* renamed from: a */
    public String mo2771a(SSLSocket sSLSocket) {
        return null;
    }

    /* renamed from: a */
    public void mo2770a(SSLSocket sSLSocket, String str, List<Protocol> list) {
    }

    /* renamed from: a */
    public void mo2769a(SSLSocketFactory sSLSocketFactory) {
    }

    /* renamed from: b */
    public void mo2764b(SSLSocket sSLSocket) {
    }

    /* renamed from: b */
    public boolean mo2766b(String str) {
        return true;
    }

    /* renamed from: c */
    public static Platform m2762c() {
        return f10298a;
    }

    /* renamed from: a */
    public void mo2773a(Socket socket, InetSocketAddress inetSocketAddress, int i) throws IOException {
        socket.connect(inetSocketAddress, i);
    }

    /* renamed from: a */
    public void mo2776a(int i, String str, Throwable th) {
        f10299b.log(i == 5 ? Level.WARNING : Level.INFO, str, th);
    }

    /* renamed from: a */
    public Object mo2775a(String str) {
        if (f10299b.isLoggable(Level.FINE)) {
            return new Throwable(str);
        }
        return null;
    }

    /* renamed from: a */
    public void mo2774a(String str, Object obj) {
        if (obj == null) {
            str = str + " To see where this was allocated, set the OkHttpClient logger level to FINE: Logger.getLogger(OkHttpClient.class.getName()).setLevel(Level.FINE);";
        }
        mo2776a(5, str, (Throwable) obj);
    }

    /* renamed from: a */
    public static List<String> m2772a(List<Protocol> list) {
        ArrayList arrayList = new ArrayList(list.size());
        int size = list.size();
        for (int i = 0; i < size; i++) {
            Protocol protocol = list.get(i);
            if (protocol != Protocol.HTTP_1_0) {
                arrayList.add(protocol.toString());
            }
        }
        return arrayList;
    }

    /* renamed from: a */
    public CertificateChainCleaner mo2768a(X509TrustManager x509TrustManager) {
        return new BasicCertificateChainCleaner(mo2763b(x509TrustManager));
    }

    /* renamed from: d */
    public static boolean m2761d() {
        if ("conscrypt".equals(System.getProperty("okhttp.platform"))) {
            return true;
        }
        return "Conscrypt".equals(Security.getProviders()[0].getName());
    }

    /* renamed from: a */
    private static Platform m2777a() {
        Platform m2788a;
        Platform m2795a = AndroidPlatform.m2795a();
        if (m2795a != null) {
            return m2795a;
        }
        if (!m2761d() || (m2788a = ConscryptPlatform.m2788a()) == null) {
            Jdk9Platform m2786a = Jdk9Platform.m2786a();
            if (m2786a != null) {
                return m2786a;
            }
            Platform m2785a = JdkWithJettyBootPlatform.m2785a();
            return m2785a != null ? m2785a : new Platform();
        }
        return m2788a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: b */
    public static byte[] m2765b(List<Protocol> list) {
        Buffer buffer = new Buffer();
        int size = list.size();
        for (int i = 0; i < size; i++) {
            Protocol protocol = list.get(i);
            if (protocol != Protocol.HTTP_1_0) {
                buffer.mo2251i(protocol.toString().length());
                buffer.mo2257b(protocol.toString());
            }
        }
        return buffer.m2283s();
    }

    /* renamed from: b */
    public SSLContext mo2767b() {
        if ("1.7".equals(System.getProperty("java.specification.version"))) {
            try {
                return SSLContext.getInstance("TLSv1.2");
            } catch (NoSuchAlgorithmException unused) {
            }
        }
        try {
            return SSLContext.getInstance("TLS");
        } catch (NoSuchAlgorithmException e) {
            throw new IllegalStateException("No TLS provider", e);
        }
    }

    /* renamed from: b */
    public TrustRootIndex mo2763b(X509TrustManager x509TrustManager) {
        return new BasicTrustRootIndex(x509TrustManager.getAcceptedIssuers());
    }
}
