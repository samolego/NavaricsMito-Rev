package retrofit2;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;
import okhttp3.Call;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.BuiltInConverters;
import retrofit2.CallAdapter;
import retrofit2.Converter;
import retrofit2.ServiceMethod;

/* renamed from: retrofit2.m */
/* loaded from: classes2.dex */
public final class Retrofit {

    /* renamed from: a */
    final Call.InterfaceC2918a f12682a;

    /* renamed from: b */
    final HttpUrl f12683b;

    /* renamed from: c */
    final List<Converter.AbstractC3172a> f12684c;

    /* renamed from: d */
    final List<CallAdapter.AbstractC3170a> f12685d;
    @Nullable

    /* renamed from: e */
    final Executor f12686e;

    /* renamed from: f */
    final boolean f12687f;

    /* renamed from: g */
    private final Map<Method, ServiceMethod<?, ?>> f12688g = new ConcurrentHashMap();

    Retrofit(Call.InterfaceC2918a interfaceC2918a, HttpUrl httpUrl, List<Converter.AbstractC3172a> list, List<CallAdapter.AbstractC3170a> list2, @Nullable Executor executor, boolean z) {
        this.f12682a = interfaceC2918a;
        this.f12683b = httpUrl;
        this.f12684c = list;
        this.f12685d = list2;
        this.f12686e = executor;
        this.f12687f = z;
    }

    /* renamed from: a */
    public <T> T m64a(final Class<T> cls) {
        C3208o.m26a((Class) cls);
        if (this.f12687f) {
            m56b(cls);
        }
        return (T) Proxy.newProxyInstance(cls.getClassLoader(), new Class[]{cls}, new InvocationHandler() { // from class: retrofit2.m.1

            /* renamed from: c */
            private final C3198j f12691c = C3198j.m93a();

            @Override // java.lang.reflect.InvocationHandler
            public Object invoke(Object obj, Method method, @Nullable Object[] objArr) throws Throwable {
                if (method.getDeclaringClass() == Object.class) {
                    return method.invoke(this, objArr);
                }
                if (this.f12691c.mo89a(method)) {
                    return this.f12691c.mo88a(method, cls, obj, objArr);
                }
                ServiceMethod<?, ?> m63a = Retrofit.this.m63a(method);
                return m63a.m42a(new OkHttpCall(m63a, objArr));
            }
        });
    }

    /* renamed from: b */
    private void m56b(Class<?> cls) {
        Method[] declaredMethods;
        C3198j m93a = C3198j.m93a();
        for (Method method : cls.getDeclaredMethods()) {
            if (!m93a.mo89a(method)) {
                m63a(method);
            }
        }
    }

    /* renamed from: a */
    ServiceMethod<?, ?> m63a(Method method) {
        ServiceMethod serviceMethod;
        ServiceMethod<?, ?> serviceMethod2 = this.f12688g.get(method);
        if (serviceMethod2 != null) {
            return serviceMethod2;
        }
        synchronized (this.f12688g) {
            serviceMethod = this.f12688g.get(method);
            if (serviceMethod == null) {
                serviceMethod = new ServiceMethod.C3207a(this, method).m40a();
                this.f12688g.put(method, serviceMethod);
            }
        }
        return serviceMethod;
    }

    /* renamed from: a */
    public Call.InterfaceC2918a m65a() {
        return this.f12682a;
    }

    /* renamed from: b */
    public HttpUrl m57b() {
        return this.f12683b;
    }

    /* renamed from: a */
    public CallAdapter<?, ?> m62a(Type type, Annotation[] annotationArr) {
        return m60a((CallAdapter.AbstractC3170a) null, type, annotationArr);
    }

    /* renamed from: a */
    public CallAdapter<?, ?> m60a(@Nullable CallAdapter.AbstractC3170a abstractC3170a, Type type, Annotation[] annotationArr) {
        C3208o.m25a(type, "returnType == null");
        C3208o.m25a(annotationArr, "annotations == null");
        int indexOf = this.f12685d.indexOf(abstractC3170a) + 1;
        int size = this.f12685d.size();
        for (int i = indexOf; i < size; i++) {
            CallAdapter<?, ?> mo148a = this.f12685d.get(i).mo148a(type, annotationArr, this);
            if (mo148a != null) {
                return mo148a;
            }
        }
        StringBuilder sb = new StringBuilder("Could not locate call adapter for ");
        sb.append(type);
        sb.append(".\n");
        if (abstractC3170a != null) {
            sb.append("  Skipped:");
            for (int i2 = 0; i2 < indexOf; i2++) {
                sb.append("\n   * ");
                sb.append(this.f12685d.get(i2).getClass().getName());
            }
            sb.append('\n');
        }
        sb.append("  Tried:");
        int size2 = this.f12685d.size();
        while (indexOf < size2) {
            sb.append("\n   * ");
            sb.append(this.f12685d.get(indexOf).getClass().getName());
            indexOf++;
        }
        throw new IllegalArgumentException(sb.toString());
    }

    /* renamed from: a */
    public <T> Converter<T, RequestBody> m61a(Type type, Annotation[] annotationArr, Annotation[] annotationArr2) {
        return m58a(null, type, annotationArr, annotationArr2);
    }

    /* renamed from: a */
    public <T> Converter<T, RequestBody> m58a(@Nullable Converter.AbstractC3172a abstractC3172a, Type type, Annotation[] annotationArr, Annotation[] annotationArr2) {
        C3208o.m25a(type, "type == null");
        C3208o.m25a(annotationArr, "parameterAnnotations == null");
        C3208o.m25a(annotationArr2, "methodAnnotations == null");
        int indexOf = this.f12684c.indexOf(abstractC3172a) + 1;
        int size = this.f12684c.size();
        for (int i = indexOf; i < size; i++) {
            Converter<T, RequestBody> converter = (Converter<T, RequestBody>) this.f12684c.get(i).mo151a(type, annotationArr, annotationArr2, this);
            if (converter != null) {
                return converter;
            }
        }
        StringBuilder sb = new StringBuilder("Could not locate RequestBody converter for ");
        sb.append(type);
        sb.append(".\n");
        if (abstractC3172a != null) {
            sb.append("  Skipped:");
            for (int i2 = 0; i2 < indexOf; i2++) {
                sb.append("\n   * ");
                sb.append(this.f12684c.get(i2).getClass().getName());
            }
            sb.append('\n');
        }
        sb.append("  Tried:");
        int size2 = this.f12684c.size();
        while (indexOf < size2) {
            sb.append("\n   * ");
            sb.append(this.f12684c.get(indexOf).getClass().getName());
            indexOf++;
        }
        throw new IllegalArgumentException(sb.toString());
    }

    /* renamed from: b */
    public <T> Converter<ResponseBody, T> m55b(Type type, Annotation[] annotationArr) {
        return m59a((Converter.AbstractC3172a) null, type, annotationArr);
    }

    /* renamed from: a */
    public <T> Converter<ResponseBody, T> m59a(@Nullable Converter.AbstractC3172a abstractC3172a, Type type, Annotation[] annotationArr) {
        C3208o.m25a(type, "type == null");
        C3208o.m25a(annotationArr, "annotations == null");
        int indexOf = this.f12684c.indexOf(abstractC3172a) + 1;
        int size = this.f12684c.size();
        for (int i = indexOf; i < size; i++) {
            Converter<ResponseBody, T> converter = (Converter<ResponseBody, T>) this.f12684c.get(i).mo152a(type, annotationArr, this);
            if (converter != null) {
                return converter;
            }
        }
        StringBuilder sb = new StringBuilder("Could not locate ResponseBody converter for ");
        sb.append(type);
        sb.append(".\n");
        if (abstractC3172a != null) {
            sb.append("  Skipped:");
            for (int i2 = 0; i2 < indexOf; i2++) {
                sb.append("\n   * ");
                sb.append(this.f12684c.get(i2).getClass().getName());
            }
            sb.append('\n');
        }
        sb.append("  Tried:");
        int size2 = this.f12684c.size();
        while (indexOf < size2) {
            sb.append("\n   * ");
            sb.append(this.f12684c.get(indexOf).getClass().getName());
            indexOf++;
        }
        throw new IllegalArgumentException(sb.toString());
    }

    /* renamed from: c */
    public <T> Converter<T, String> m54c(Type type, Annotation[] annotationArr) {
        C3208o.m25a(type, "type == null");
        C3208o.m25a(annotationArr, "annotations == null");
        int size = this.f12684c.size();
        for (int i = 0; i < size; i++) {
            Converter<T, String> converter = (Converter<T, String>) this.f12684c.get(i).m150b(type, annotationArr, this);
            if (converter != null) {
                return converter;
            }
        }
        return BuiltInConverters.C3162d.f12576a;
    }

    /* compiled from: Retrofit.java */
    /* renamed from: retrofit2.m$a */
    /* loaded from: classes2.dex */
    public static final class C3206a {

        /* renamed from: a */
        private final C3198j f12692a;
        @Nullable

        /* renamed from: b */
        private Call.InterfaceC2918a f12693b;

        /* renamed from: c */
        private HttpUrl f12694c;

        /* renamed from: d */
        private final List<Converter.AbstractC3172a> f12695d;

        /* renamed from: e */
        private final List<CallAdapter.AbstractC3170a> f12696e;
        @Nullable

        /* renamed from: f */
        private Executor f12697f;

        /* renamed from: g */
        private boolean f12698g;

        C3206a(C3198j c3198j) {
            this.f12695d = new ArrayList();
            this.f12696e = new ArrayList();
            this.f12692a = c3198j;
        }

        public C3206a() {
            this(C3198j.m93a());
        }

        /* renamed from: a */
        public C3206a m48a(OkHttpClient okHttpClient) {
            return m50a((Call.InterfaceC2918a) C3208o.m25a(okHttpClient, "client == null"));
        }

        /* renamed from: a */
        public C3206a m50a(Call.InterfaceC2918a interfaceC2918a) {
            this.f12693b = (Call.InterfaceC2918a) C3208o.m25a(interfaceC2918a, "factory == null");
            return this;
        }

        /* renamed from: a */
        public C3206a m52a(String str) {
            C3208o.m25a(str, "baseUrl == null");
            HttpUrl m2465e = HttpUrl.m2465e(str);
            if (m2465e == null) {
                throw new IllegalArgumentException("Illegal URL: " + str);
            }
            return m49a(m2465e);
        }

        /* renamed from: a */
        public C3206a m49a(HttpUrl httpUrl) {
            C3208o.m25a(httpUrl, "baseUrl == null");
            List<String> m2459j = httpUrl.m2459j();
            if (!"".equals(m2459j.get(m2459j.size() - 1))) {
                throw new IllegalArgumentException("baseUrl must end in /: " + httpUrl);
            }
            this.f12694c = httpUrl;
            return this;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* renamed from: a */
        public C3206a m46a(Converter.AbstractC3172a abstractC3172a) {
            this.f12695d.add(C3208o.m25a(abstractC3172a, "factory == null"));
            return this;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* renamed from: a */
        public C3206a m47a(CallAdapter.AbstractC3170a abstractC3170a) {
            this.f12696e.add(C3208o.m25a(abstractC3170a, "factory == null"));
            return this;
        }

        /* renamed from: a */
        public C3206a m51a(Executor executor) {
            this.f12697f = (Executor) C3208o.m25a(executor, "executor == null");
            return this;
        }

        /* renamed from: a */
        public Retrofit m53a() {
            if (this.f12694c == null) {
                throw new IllegalStateException("Base URL required.");
            }
            Call.InterfaceC2918a interfaceC2918a = this.f12693b;
            OkHttpClient okHttpClient = interfaceC2918a == null ? new OkHttpClient() : interfaceC2918a;
            Executor executor = this.f12697f;
            Executor mo90b = executor == null ? this.f12692a.mo90b() : executor;
            ArrayList arrayList = new ArrayList(this.f12696e);
            arrayList.add(this.f12692a.mo91a(mo90b));
            ArrayList arrayList2 = new ArrayList(this.f12695d.size() + 1);
            arrayList2.add(new BuiltInConverters());
            arrayList2.addAll(this.f12695d);
            return new Retrofit(okHttpClient, this.f12694c, Collections.unmodifiableList(arrayList2), Collections.unmodifiableList(arrayList), mo90b, this.f12698g);
        }
    }
}
