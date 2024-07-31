package com.navatics.app.framework.user;

import com.navatics.app.framework.Navatics;
import com.navatics.app.framework.network.LoggerInterceptor;
import com.navatics.robot.utils.C2161p;
import java.io.IOException;
import java.security.SecureRandom;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.concurrent.TimeUnit;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import okhttp3.C2993z;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;

/* renamed from: com.navatics.app.framework.user.d */
/* loaded from: classes.dex */
public class UnsafeOkHttpClient {
    /* renamed from: a */
    public static OkHttpClient m7767a() {
        try {
            TrustManager[] trustManagerArr = {new X509TrustManager() { // from class: com.navatics.app.framework.user.d.1
                @Override // javax.net.ssl.X509TrustManager
                public void checkClientTrusted(X509Certificate[] x509CertificateArr, String str) throws CertificateException {
                }

                @Override // javax.net.ssl.X509TrustManager
                public void checkServerTrusted(X509Certificate[] x509CertificateArr, String str) throws CertificateException {
                }

                @Override // javax.net.ssl.X509TrustManager
                public X509Certificate[] getAcceptedIssuers() {
                    return new X509Certificate[0];
                }
            }};
            SSLContext sSLContext = SSLContext.getInstance("SSL");
            sSLContext.init(null, trustManagerArr, new SecureRandom());
            SSLSocketFactory socketFactory = sSLContext.getSocketFactory();
            HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
            httpLoggingInterceptor.m2551a(HttpLoggingInterceptor.Level.NONE);
            OkHttpClient.C2991a c2991a = new OkHttpClient.C2991a();
            c2991a.m2366a(httpLoggingInterceptor);
            new LoggerInterceptor(LoggerInterceptor.Level.RELEASE);
            c2991a.m2371a(5L, TimeUnit.SECONDS);
            c2991a.m2369a(socketFactory, (X509TrustManager) trustManagerArr[0]);
            c2991a.m2370a(new HostnameVerifier() { // from class: com.navatics.app.framework.user.d.2
                @Override // javax.net.ssl.HostnameVerifier
                public boolean verify(String str, SSLSession sSLSession) {
                    return true;
                }
            });
            c2991a.m2366a(new Interceptor() { // from class: com.navatics.app.framework.user.d.3
                @Override // okhttp3.Interceptor
                /* renamed from: a */
                public Response mo2429a(Interceptor.InterfaceC2987a interfaceC2987a) throws IOException {
                    C2993z.C2994a m2345e = interfaceC2987a.mo2428a().m2345e();
                    m2345e.m2335b("OS", "0");
                    m2345e.m2335b("version", C2161p.m5852a(Navatics.m7935e()));
                    NvUser m7806d = NvUserManager.m7828b().m7806d();
                    if (m7806d != null && m7806d.getEmail() != null) {
                        m2345e.m2335b("email", m7806d.getEmail());
                    }
                    if (m7806d != null && m7806d.getToken() != null) {
                        m2345e.m2335b("token", m7806d.getToken());
                    }
                    return interfaceC2987a.mo2427a(m2345e.m2342a());
                }
            });
            return c2991a.m2372a();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
