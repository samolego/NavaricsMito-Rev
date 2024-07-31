package okhttp3.internal.p107e;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;
import javax.annotation.Nullable;
import javax.net.ssl.SSLParameters;
import javax.net.ssl.SSLSocket;
import okhttp3.Protocol;
import okhttp3.internal.C2930c;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: okhttp3.internal.e.c */
/* loaded from: classes2.dex */
public final class Jdk9Platform extends Platform {

    /* renamed from: a */
    final Method f10285a;

    /* renamed from: b */
    final Method f10286b;

    Jdk9Platform(Method method, Method method2) {
        this.f10285a = method;
        this.f10286b = method2;
    }

    @Override // okhttp3.internal.p107e.Platform
    /* renamed from: a */
    public void mo2770a(SSLSocket sSLSocket, String str, List<Protocol> list) {
        try {
            SSLParameters sSLParameters = sSLSocket.getSSLParameters();
            List<String> a = m2772a(list);
            this.f10285a.invoke(sSLParameters, a.toArray(new String[a.size()]));
            sSLSocket.setSSLParameters(sSLParameters);
        } catch (IllegalAccessException | InvocationTargetException e) {
            throw C2930c.m2888a("unable to set ssl parameters", (Exception) e);
        }
    }

    @Override // okhttp3.internal.p107e.Platform
    @Nullable
    /* renamed from: a */
    public String mo2771a(SSLSocket sSLSocket) {
        try {
            String str = (String) this.f10286b.invoke(sSLSocket, new Object[0]);
            if (str != null) {
                if (str.equals("")) {
                    return null;
                }
                return str;
            }
            return null;
        } catch (IllegalAccessException | InvocationTargetException e) {
            throw C2930c.m2888a("unable to get selected protocols", (Exception) e);
        }
    }

    /* renamed from: a */
    public static Jdk9Platform m2786a() {
        try {
            return new Jdk9Platform(SSLParameters.class.getMethod("setApplicationProtocols", String[].class), SSLSocket.class.getMethod("getApplicationProtocol", new Class[0]));
        } catch (NoSuchMethodException unused) {
            return null;
        }
    }
}
