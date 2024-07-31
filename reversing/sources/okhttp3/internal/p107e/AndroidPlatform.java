package okhttp3.internal.p107e;

import android.os.Build;
import android.util.Log;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.security.NoSuchAlgorithmException;
import java.security.Security;
import java.security.cert.Certificate;
import java.security.cert.TrustAnchor;
import java.security.cert.X509Certificate;
import java.util.List;
import javax.annotation.Nullable;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.X509TrustManager;
import okhttp3.Protocol;
import okhttp3.internal.C2930c;
import okhttp3.internal.p108f.CertificateChainCleaner;
import okhttp3.internal.p108f.TrustRootIndex;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: okhttp3.internal.e.a */
/* loaded from: classes2.dex */
public class AndroidPlatform extends Platform {

    /* renamed from: a */
    private final Class<?> f10272a;

    /* renamed from: b */
    private final OptionalMethod<Socket> f10273b;

    /* renamed from: c */
    private final OptionalMethod<Socket> f10274c;

    /* renamed from: d */
    private final OptionalMethod<Socket> f10275d;

    /* renamed from: e */
    private final OptionalMethod<Socket> f10276e;

    /* renamed from: f */
    private final C2946c f10277f = C2946c.m2791a();

    AndroidPlatform(Class<?> cls, OptionalMethod<Socket> optionalMethod, OptionalMethod<Socket> optionalMethod2, OptionalMethod<Socket> optionalMethod3, OptionalMethod<Socket> optionalMethod4) {
        this.f10272a = cls;
        this.f10273b = optionalMethod;
        this.f10274c = optionalMethod2;
        this.f10275d = optionalMethod3;
        this.f10276e = optionalMethod4;
    }

    @Override // okhttp3.internal.p107e.Platform
    /* renamed from: a */
    public void mo2773a(Socket socket, InetSocketAddress inetSocketAddress, int i) throws IOException {
        try {
            socket.connect(inetSocketAddress, i);
        } catch (AssertionError e) {
            if (!C2930c.m2896a(e)) {
                throw e;
            }
            throw new IOException(e);
        } catch (ClassCastException e2) {
            if (Build.VERSION.SDK_INT == 26) {
                IOException iOException = new IOException("Exception in connect");
                iOException.initCause(e2);
                throw iOException;
            }
            throw e2;
        } catch (SecurityException e3) {
            IOException iOException2 = new IOException("Exception in connect");
            iOException2.initCause(e3);
            throw iOException2;
        }
    }

    @Override // okhttp3.internal.p107e.Platform
    /* renamed from: a */
    public void mo2770a(SSLSocket sSLSocket, String str, List<Protocol> list) {
        if (str != null) {
            this.f10273b.m2780b(sSLSocket, true);
            this.f10274c.m2780b(sSLSocket, str);
        }
        OptionalMethod<Socket> optionalMethod = this.f10276e;
        if (optionalMethod == null || !optionalMethod.m2782a((OptionalMethod<Socket>) sSLSocket)) {
            return;
        }
        this.f10276e.m2778d(sSLSocket, m2765b(list));
    }

    @Override // okhttp3.internal.p107e.Platform
    @Nullable
    /* renamed from: a */
    public String mo2771a(SSLSocket sSLSocket) {
        byte[] bArr;
        OptionalMethod<Socket> optionalMethod = this.f10275d;
        if (optionalMethod == null || !optionalMethod.m2782a((OptionalMethod<Socket>) sSLSocket) || (bArr = (byte[]) this.f10275d.m2778d(sSLSocket, new Object[0])) == null) {
            return null;
        }
        return new String(bArr, C2930c.f10183e);
    }

    @Override // okhttp3.internal.p107e.Platform
    /* renamed from: a */
    public void mo2776a(int i, String str, Throwable th) {
        int min;
        int i2 = i != 5 ? 3 : 5;
        if (th != null) {
            str = str + '\n' + Log.getStackTraceString(th);
        }
        int i3 = 0;
        int length = str.length();
        while (i3 < length) {
            int indexOf = str.indexOf(10, i3);
            if (indexOf == -1) {
                indexOf = length;
            }
            while (true) {
                min = Math.min(indexOf, i3 + 4000);
                Log.println(i2, "OkHttp", str.substring(i3, min));
                if (min >= indexOf) {
                    break;
                }
                i3 = min;
            }
            i3 = min + 1;
        }
    }

    @Override // okhttp3.internal.p107e.Platform
    /* renamed from: a */
    public Object mo2775a(String str) {
        return this.f10277f.m2789a(str);
    }

    @Override // okhttp3.internal.p107e.Platform
    /* renamed from: a */
    public void mo2774a(String str, Object obj) {
        if (this.f10277f.m2790a(obj)) {
            return;
        }
        mo2776a(5, str, (Throwable) null);
    }

    @Override // okhttp3.internal.p107e.Platform
    /* renamed from: b */
    public boolean mo2766b(String str) {
        try {
            Class<?> cls = Class.forName("android.security.NetworkSecurityPolicy");
            return m2794a(str, cls, cls.getMethod("getInstance", new Class[0]).invoke(null, new Object[0]));
        } catch (ClassNotFoundException | NoSuchMethodException unused) {
            return super.mo2766b(str);
        } catch (IllegalAccessException e) {
            e = e;
            throw C2930c.m2888a("unable to determine cleartext support", e);
        } catch (IllegalArgumentException e2) {
            e = e2;
            throw C2930c.m2888a("unable to determine cleartext support", e);
        } catch (InvocationTargetException e3) {
            e = e3;
            throw C2930c.m2888a("unable to determine cleartext support", e);
        }
    }

    /* renamed from: a */
    private boolean m2794a(String str, Class<?> cls, Object obj) throws InvocationTargetException, IllegalAccessException {
        try {
            return ((Boolean) cls.getMethod("isCleartextTrafficPermitted", String.class).invoke(obj, str)).booleanValue();
        } catch (NoSuchMethodException unused) {
            return m2793b(str, cls, obj);
        }
    }

    /* renamed from: b */
    private boolean m2793b(String str, Class<?> cls, Object obj) throws InvocationTargetException, IllegalAccessException {
        try {
            return ((Boolean) cls.getMethod("isCleartextTrafficPermitted", new Class[0]).invoke(obj, new Object[0])).booleanValue();
        } catch (NoSuchMethodException unused) {
            return super.mo2766b(str);
        }
    }

    /* renamed from: e */
    private static boolean m2792e() {
        if (Security.getProvider("GMSCore_OpenSSL") != null) {
            return true;
        }
        try {
            Class.forName("android.net.Network");
            return true;
        } catch (ClassNotFoundException unused) {
            return false;
        }
    }

    @Override // okhttp3.internal.p107e.Platform
    /* renamed from: a */
    public CertificateChainCleaner mo2768a(X509TrustManager x509TrustManager) {
        try {
            Class<?> cls = Class.forName("android.net.http.X509TrustManagerExtensions");
            return new C2944a(cls.getConstructor(X509TrustManager.class).newInstance(x509TrustManager), cls.getMethod("checkServerTrusted", X509Certificate[].class, String.class, String.class));
        } catch (Exception unused) {
            return super.mo2768a(x509TrustManager);
        }
    }

    /* renamed from: a */
    public static Platform m2795a() {
        Class<?> cls;
        OptionalMethod optionalMethod;
        OptionalMethod optionalMethod2;
        try {
            try {
                cls = Class.forName("com.android.org.conscrypt.SSLParametersImpl");
            } catch (ClassNotFoundException unused) {
                cls = Class.forName("org.apache.harmony.xnet.provider.jsse.SSLParametersImpl");
            }
            OptionalMethod optionalMethod3 = new OptionalMethod(null, "setUseSessionTickets", Boolean.TYPE);
            OptionalMethod optionalMethod4 = new OptionalMethod(null, "setHostname", String.class);
            if (m2792e()) {
                OptionalMethod optionalMethod5 = new OptionalMethod(byte[].class, "getAlpnSelectedProtocol", new Class[0]);
                optionalMethod2 = new OptionalMethod(null, "setAlpnProtocols", byte[].class);
                optionalMethod = optionalMethod5;
            } else {
                optionalMethod = null;
                optionalMethod2 = null;
            }
            return new AndroidPlatform(cls, optionalMethod3, optionalMethod4, optionalMethod, optionalMethod2);
        } catch (ClassNotFoundException unused2) {
            return null;
        }
    }

    @Override // okhttp3.internal.p107e.Platform
    /* renamed from: b */
    public TrustRootIndex mo2763b(X509TrustManager x509TrustManager) {
        try {
            Method declaredMethod = x509TrustManager.getClass().getDeclaredMethod("findTrustAnchorByIssuerAndSignature", X509Certificate.class);
            declaredMethod.setAccessible(true);
            return new C2945b(x509TrustManager, declaredMethod);
        } catch (NoSuchMethodException unused) {
            return super.mo2763b(x509TrustManager);
        }
    }

    /* compiled from: AndroidPlatform.java */
    /* renamed from: okhttp3.internal.e.a$a */
    /* loaded from: classes2.dex */
    static final class C2944a extends CertificateChainCleaner {

        /* renamed from: a */
        private final Object f10278a;

        /* renamed from: b */
        private final Method f10279b;

        public int hashCode() {
            return 0;
        }

        C2944a(Object obj, Method method) {
            this.f10278a = obj;
            this.f10279b = method;
        }

        @Override // okhttp3.internal.p108f.CertificateChainCleaner
        /* renamed from: a */
        public List<Certificate> mo2759a(List<Certificate> list, String str) throws SSLPeerUnverifiedException {
            try {
                return (List) this.f10279b.invoke(this.f10278a, (X509Certificate[]) list.toArray(new X509Certificate[list.size()]), "RSA", str);
            } catch (IllegalAccessException e) {
                throw new AssertionError(e);
            } catch (InvocationTargetException e2) {
                SSLPeerUnverifiedException sSLPeerUnverifiedException = new SSLPeerUnverifiedException(e2.getMessage());
                sSLPeerUnverifiedException.initCause(e2);
                throw sSLPeerUnverifiedException;
            }
        }

        public boolean equals(Object obj) {
            return obj instanceof C2944a;
        }
    }

    /* compiled from: AndroidPlatform.java */
    /* renamed from: okhttp3.internal.e.a$c */
    /* loaded from: classes2.dex */
    static final class C2946c {

        /* renamed from: a */
        private final Method f10282a;

        /* renamed from: b */
        private final Method f10283b;

        /* renamed from: c */
        private final Method f10284c;

        C2946c(Method method, Method method2, Method method3) {
            this.f10282a = method;
            this.f10283b = method2;
            this.f10284c = method3;
        }

        /* renamed from: a */
        Object m2789a(String str) {
            Method method = this.f10282a;
            if (method != null) {
                try {
                    Object invoke = method.invoke(null, new Object[0]);
                    this.f10283b.invoke(invoke, str);
                    return invoke;
                } catch (Exception unused) {
                }
            }
            return null;
        }

        /* renamed from: a */
        boolean m2790a(Object obj) {
            if (obj != null) {
                try {
                    this.f10284c.invoke(obj, new Object[0]);
                    return true;
                } catch (Exception unused) {
                    return false;
                }
            }
            return false;
        }

        /* renamed from: a */
        static C2946c m2791a() {
            Method method;
            Method method2;
            Method method3 = null;
            try {
                Class<?> cls = Class.forName("dalvik.system.CloseGuard");
                Method method4 = cls.getMethod("get", new Class[0]);
                method2 = cls.getMethod("open", String.class);
                method = cls.getMethod("warnIfOpen", new Class[0]);
                method3 = method4;
            } catch (Exception unused) {
                method = null;
                method2 = null;
            }
            return new C2946c(method3, method2, method);
        }
    }

    /* compiled from: AndroidPlatform.java */
    /* renamed from: okhttp3.internal.e.a$b */
    /* loaded from: classes2.dex */
    static final class C2945b implements TrustRootIndex {

        /* renamed from: a */
        private final X509TrustManager f10280a;

        /* renamed from: b */
        private final Method f10281b;

        C2945b(X509TrustManager x509TrustManager, Method method) {
            this.f10281b = method;
            this.f10280a = x509TrustManager;
        }

        @Override // okhttp3.internal.p108f.TrustRootIndex
        /* renamed from: a */
        public X509Certificate mo2751a(X509Certificate x509Certificate) {
            try {
                TrustAnchor trustAnchor = (TrustAnchor) this.f10281b.invoke(this.f10280a, x509Certificate);
                if (trustAnchor != null) {
                    return trustAnchor.getTrustedCert();
                }
                return null;
            } catch (IllegalAccessException e) {
                throw C2930c.m2888a("unable to get issues and signature", (Exception) e);
            } catch (InvocationTargetException unused) {
                return null;
            }
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (obj instanceof C2945b) {
                C2945b c2945b = (C2945b) obj;
                return this.f10280a.equals(c2945b.f10280a) && this.f10281b.equals(c2945b.f10281b);
            }
            return false;
        }

        public int hashCode() {
            return this.f10280a.hashCode() + (this.f10281b.hashCode() * 31);
        }
    }

    @Override // okhttp3.internal.p107e.Platform
    /* renamed from: b */
    public SSLContext mo2767b() {
        if (Build.VERSION.SDK_INT >= 16 && Build.VERSION.SDK_INT < 22) {
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
}
