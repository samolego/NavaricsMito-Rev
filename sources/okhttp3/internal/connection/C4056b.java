package okhttp3.internal.connection;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.ProtocolException;
import java.net.UnknownServiceException;
import java.security.cert.CertificateException;
import java.util.Arrays;
import java.util.List;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLProtocolException;
import javax.net.ssl.SSLSocket;
import okhttp3.ConnectionSpec;
import okhttp3.internal.Internal;

/* renamed from: okhttp3.internal.connection.b */
/* loaded from: classes2.dex */
public final class ConnectionSpecSelector {

    /* renamed from: a */
    private final List<ConnectionSpec> f10226a;

    /* renamed from: b */
    private int f10227b = 0;

    /* renamed from: c */
    private boolean f10228c;

    /* renamed from: d */
    private boolean f10229d;

    public ConnectionSpecSelector(List<ConnectionSpec> list) {
        this.f10226a = list;
    }

    /* renamed from: a */
    public ConnectionSpec m2852a(SSLSocket sSLSocket) throws IOException {
        ConnectionSpec connectionSpec;
        int i = this.f10227b;
        int size = this.f10226a.size();
        while (true) {
            if (i >= size) {
                connectionSpec = null;
                break;
            }
            connectionSpec = this.f10226a.get(i);
            if (connectionSpec.m2574a(sSLSocket)) {
                this.f10227b = i + 1;
                break;
            }
            i++;
        }
        if (connectionSpec == null) {
            throw new UnknownServiceException("Unable to find acceptable protocols. isFallback=" + this.f10229d + ", modes=" + this.f10226a + ", supported protocols=" + Arrays.toString(sSLSocket.getEnabledProtocols()));
        }
        this.f10228c = m2851b(sSLSocket);
        Internal.f10101a.mo2376a(connectionSpec, sSLSocket, this.f10229d);
        return connectionSpec;
    }

    /* renamed from: a */
    public boolean m2853a(IOException iOException) {
        this.f10229d = true;
        if (!this.f10228c || (iOException instanceof ProtocolException) || (iOException instanceof InterruptedIOException)) {
            return false;
        }
        boolean z = iOException instanceof SSLHandshakeException;
        if ((z && (iOException.getCause() instanceof CertificateException)) || (iOException instanceof SSLPeerUnverifiedException)) {
            return false;
        }
        return z || (iOException instanceof SSLProtocolException);
    }

    /* renamed from: b */
    private boolean m2851b(SSLSocket sSLSocket) {
        for (int i = this.f10227b; i < this.f10226a.size(); i++) {
            if (this.f10226a.get(i).m2574a(sSLSocket)) {
                return true;
            }
        }
        return false;
    }
}
