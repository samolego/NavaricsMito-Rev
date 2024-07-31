package okhttp3.internal.p107e;

import java.security.NoSuchAlgorithmException;
import java.security.Provider;
import java.util.List;
import javax.annotation.Nullable;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import okhttp3.Protocol;
import org.conscrypt.Conscrypt;
import org.conscrypt.OpenSSLProvider;

/* renamed from: okhttp3.internal.e.b */
/* loaded from: classes2.dex */
public class ConscryptPlatform extends Platform {
    private ConscryptPlatform() {
    }

    /* renamed from: e */
    private Provider m2787e() {
        return new OpenSSLProvider();
    }

    @Override // okhttp3.internal.p107e.Platform
    /* renamed from: a */
    public void mo2770a(SSLSocket sSLSocket, String str, List<Protocol> list) {
        if (Conscrypt.isConscrypt(sSLSocket)) {
            if (str != null) {
                Conscrypt.setUseSessionTickets(sSLSocket, true);
                Conscrypt.setHostname(sSLSocket, str);
            }
            Conscrypt.setApplicationProtocols(sSLSocket, (String[]) Platform.m2772a(list).toArray(new String[0]));
            return;
        }
        super.mo2770a(sSLSocket, str, list);
    }

    @Override // okhttp3.internal.p107e.Platform
    @Nullable
    /* renamed from: a */
    public String mo2771a(SSLSocket sSLSocket) {
        if (Conscrypt.isConscrypt(sSLSocket)) {
            return Conscrypt.getApplicationProtocol(sSLSocket);
        }
        return super.mo2771a(sSLSocket);
    }

    @Override // okhttp3.internal.p107e.Platform
    /* renamed from: b */
    public SSLContext mo2767b() {
        try {
            return SSLContext.getInstance("TLS", m2787e());
        } catch (NoSuchAlgorithmException e) {
            throw new IllegalStateException("No TLS provider", e);
        }
    }

    /* renamed from: a */
    public static Platform m2788a() {
        try {
            Class.forName("org.conscrypt.ConscryptEngineSocket");
            if (Conscrypt.isAvailable()) {
                return new ConscryptPlatform();
            }
            return null;
        } catch (ClassNotFoundException unused) {
            return null;
        }
    }

    @Override // okhttp3.internal.p107e.Platform
    /* renamed from: a */
    public void mo2769a(SSLSocketFactory sSLSocketFactory) {
        if (Conscrypt.isConscrypt(sSLSocketFactory)) {
            Conscrypt.setUseEngineSocket(sSLSocketFactory, true);
        }
    }
}
