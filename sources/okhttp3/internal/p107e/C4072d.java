package okhttp3.internal.p107e;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.List;
import javax.annotation.Nullable;
import javax.net.ssl.SSLSocket;
import okhttp3.Protocol;
import okhttp3.internal.C2930c;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: okhttp3.internal.e.d */
/* loaded from: classes2.dex */
public class JdkWithJettyBootPlatform extends Platform {

    /* renamed from: a */
    private final Method f10287a;

    /* renamed from: b */
    private final Method f10288b;

    /* renamed from: c */
    private final Method f10289c;

    /* renamed from: d */
    private final Class<?> f10290d;

    /* renamed from: e */
    private final Class<?> f10291e;

    JdkWithJettyBootPlatform(Method method, Method method2, Method method3, Class<?> cls, Class<?> cls2) {
        this.f10287a = method;
        this.f10288b = method2;
        this.f10289c = method3;
        this.f10290d = cls;
        this.f10291e = cls2;
    }

    @Override // okhttp3.internal.p107e.Platform
    /* renamed from: a */
    public void mo2770a(SSLSocket sSLSocket, String str, List<Protocol> list) {
        try {
            this.f10287a.invoke(null, sSLSocket, Proxy.newProxyInstance(Platform.class.getClassLoader(), new Class[]{this.f10290d, this.f10291e}, new C2947a(m2772a(list))));
        } catch (IllegalAccessException | InvocationTargetException e) {
            throw C2930c.m2888a("unable to set alpn", (Exception) e);
        }
    }

    @Override // okhttp3.internal.p107e.Platform
    /* renamed from: b */
    public void mo2764b(SSLSocket sSLSocket) {
        try {
            this.f10289c.invoke(null, sSLSocket);
        } catch (IllegalAccessException | InvocationTargetException e) {
            throw C2930c.m2888a("unable to remove alpn", (Exception) e);
        }
    }

    @Override // okhttp3.internal.p107e.Platform
    @Nullable
    /* renamed from: a */
    public String mo2771a(SSLSocket sSLSocket) {
        try {
            C2947a c2947a = (C2947a) Proxy.getInvocationHandler(this.f10288b.invoke(null, sSLSocket));
            if (!c2947a.f10292a && c2947a.f10293b == null) {
                Platform.m2762c().mo2776a(4, "ALPN callback dropped: HTTP/2 is disabled. Is alpn-boot on the boot class path?", (Throwable) null);
                return null;
            } else if (c2947a.f10292a) {
                return null;
            } else {
                return c2947a.f10293b;
            }
        } catch (IllegalAccessException | InvocationTargetException e) {
            throw C2930c.m2888a("unable to get selected protocol", (Exception) e);
        }
    }

    /* renamed from: a */
    public static Platform m2785a() {
        try {
            Class<?> cls = Class.forName("org.eclipse.jetty.alpn.ALPN");
            Class<?> cls2 = Class.forName("org.eclipse.jetty.alpn.ALPN$Provider");
            Class<?> cls3 = Class.forName("org.eclipse.jetty.alpn.ALPN$ClientProvider");
            return new JdkWithJettyBootPlatform(cls.getMethod("put", SSLSocket.class, cls2), cls.getMethod("get", SSLSocket.class), cls.getMethod("remove", SSLSocket.class), cls3, Class.forName("org.eclipse.jetty.alpn.ALPN$ServerProvider"));
        } catch (ClassNotFoundException | NoSuchMethodException unused) {
            return null;
        }
    }

    /* compiled from: JdkWithJettyBootPlatform.java */
    /* renamed from: okhttp3.internal.e.d$a */
    /* loaded from: classes2.dex */
    private static class C2947a implements InvocationHandler {

        /* renamed from: a */
        boolean f10292a;

        /* renamed from: b */
        String f10293b;

        /* renamed from: c */
        private final List<String> f10294c;

        C2947a(List<String> list) {
            this.f10294c = list;
        }

        @Override // java.lang.reflect.InvocationHandler
        public Object invoke(Object obj, Method method, Object[] objArr) throws Throwable {
            String name = method.getName();
            Class<?> returnType = method.getReturnType();
            if (objArr == null) {
                objArr = C2930c.f10180b;
            }
            if (name.equals("supports") && Boolean.TYPE == returnType) {
                return true;
            }
            if (name.equals("unsupported") && Void.TYPE == returnType) {
                this.f10292a = true;
                return null;
            } else if (name.equals("protocols") && objArr.length == 0) {
                return this.f10294c;
            } else {
                if ((name.equals("selectProtocol") || name.equals("select")) && String.class == returnType && objArr.length == 1 && (objArr[0] instanceof List)) {
                    List list = (List) objArr[0];
                    int size = list.size();
                    for (int i = 0; i < size; i++) {
                        if (this.f10294c.contains(list.get(i))) {
                            String str = (String) list.get(i);
                            this.f10293b = str;
                            return str;
                        }
                    }
                    String str2 = this.f10294c.get(0);
                    this.f10293b = str2;
                    return str2;
                } else if ((name.equals("protocolSelected") || name.equals("selected")) && objArr.length == 1) {
                    this.f10293b = (String) objArr[0];
                    return null;
                } else {
                    return method.invoke(this, objArr);
                }
            }
        }
    }
}
