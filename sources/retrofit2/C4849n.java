package retrofit2;

import com.example.divelog.dao.entity.CommandCard;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.net.URI;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.annotation.Nullable;
import okhttp3.C2984s;
import okhttp3.Call;
import okhttp3.HttpUrl;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;
import retrofit2.ParameterHandler;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.Field;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.HEAD;
import retrofit2.http.HTTP;
import retrofit2.http.Header;
import retrofit2.http.HeaderMap;
import retrofit2.http.Headers;
import retrofit2.http.Multipart;
import retrofit2.http.OPTIONS;
import retrofit2.http.PATCH;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Part;
import retrofit2.http.PartMap;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;
import retrofit2.http.QueryName;
import retrofit2.http.Url;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: retrofit2.n */
/* loaded from: classes2.dex */
public final class ServiceMethod<R, T> {

    /* renamed from: a */
    static final Pattern f12699a = Pattern.compile("\\{([a-zA-Z][a-zA-Z0-9_-]*)\\}");

    /* renamed from: b */
    static final Pattern f12700b = Pattern.compile("[a-zA-Z][a-zA-Z0-9_-]*");

    /* renamed from: c */
    private final Call.InterfaceC2918a f12701c;

    /* renamed from: d */
    private final CallAdapter<R, T> f12702d;

    /* renamed from: e */
    private final HttpUrl f12703e;

    /* renamed from: f */
    private final Converter<ResponseBody, R> f12704f;

    /* renamed from: g */
    private final String f12705g;

    /* renamed from: h */
    private final String f12706h;

    /* renamed from: i */
    private final C2984s f12707i;

    /* renamed from: j */
    private final MediaType f12708j;

    /* renamed from: k */
    private final boolean f12709k;

    /* renamed from: l */
    private final boolean f12710l;

    /* renamed from: m */
    private final boolean f12711m;

    /* renamed from: n */
    private final ParameterHandler<?>[] f12712n;

    ServiceMethod(C3207a<R, T> c3207a) {
        this.f12701c = c3207a.f12713a.m65a();
        this.f12702d = c3207a.f12735w;
        this.f12703e = c3207a.f12713a.m57b();
        this.f12704f = c3207a.f12734v;
        this.f12705g = c3207a.f12725m;
        this.f12706h = c3207a.f12729q;
        this.f12707i = c3207a.f12730r;
        this.f12708j = c3207a.f12731s;
        this.f12709k = c3207a.f12726n;
        this.f12710l = c3207a.f12727o;
        this.f12711m = c3207a.f12728p;
        this.f12712n = c3207a.f12733u;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public Call m41a(@Nullable Object... objArr) throws IOException {
        C3202k c3202k = new C3202k(this.f12705g, this.f12703e, this.f12706h, this.f12707i, this.f12708j, this.f12709k, this.f12710l, this.f12711m);
        ParameterHandler<?>[] parameterHandlerArr = this.f12712n;
        int length = objArr != null ? objArr.length : 0;
        if (length != parameterHandlerArr.length) {
            throw new IllegalArgumentException("Argument count (" + length + ") doesn't match expected count (" + parameterHandlerArr.length + ")");
        }
        for (int i = 0; i < length; i++) {
            parameterHandlerArr[i].mo94a(c3202k, objArr[i]);
        }
        return this.f12701c.mo2407a(c3202k.m87a());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public T m42a(InterfaceC3169b<R> interfaceC3169b) {
        return this.f12702d.mo146a(interfaceC3169b);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public R m43a(ResponseBody responseBody) throws IOException {
        return this.f12704f.mo153a(responseBody);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ServiceMethod.java */
    /* renamed from: retrofit2.n$a */
    /* loaded from: classes2.dex */
    public static final class C3207a<T, R> {

        /* renamed from: a */
        final Retrofit f12713a;

        /* renamed from: b */
        final Method f12714b;

        /* renamed from: c */
        final Annotation[] f12715c;

        /* renamed from: d */
        final Annotation[][] f12716d;

        /* renamed from: e */
        final Type[] f12717e;

        /* renamed from: f */
        Type f12718f;

        /* renamed from: g */
        boolean f12719g;

        /* renamed from: h */
        boolean f12720h;

        /* renamed from: i */
        boolean f12721i;

        /* renamed from: j */
        boolean f12722j;

        /* renamed from: k */
        boolean f12723k;

        /* renamed from: l */
        boolean f12724l;

        /* renamed from: m */
        String f12725m;

        /* renamed from: n */
        boolean f12726n;

        /* renamed from: o */
        boolean f12727o;

        /* renamed from: p */
        boolean f12728p;

        /* renamed from: q */
        String f12729q;

        /* renamed from: r */
        C2984s f12730r;

        /* renamed from: s */
        MediaType f12731s;

        /* renamed from: t */
        Set<String> f12732t;

        /* renamed from: u */
        ParameterHandler<?>[] f12733u;

        /* renamed from: v */
        Converter<ResponseBody, T> f12734v;

        /* renamed from: w */
        CallAdapter<T, R> f12735w;

        /* JADX INFO: Access modifiers changed from: package-private */
        public C3207a(Retrofit retrofit, Method method) {
            this.f12713a = retrofit;
            this.f12714b = method;
            this.f12715c = method.getAnnotations();
            this.f12717e = method.getGenericParameterTypes();
            this.f12716d = method.getParameterAnnotations();
        }

        /* renamed from: a */
        public ServiceMethod m40a() {
            this.f12735w = m29b();
            this.f12718f = this.f12735w.mo147a();
            Type type = this.f12718f;
            if (type == C3204l.class || type == Response.class) {
                throw m34a("'" + C3208o.m23a(this.f12718f).getName() + "' is not a valid response body type. Did you mean ResponseBody?", new Object[0]);
            }
            this.f12734v = m28c();
            for (Annotation annotation : this.f12715c) {
                m31a(annotation);
            }
            if (this.f12725m == null) {
                throw m34a("HTTP method annotation is required (e.g., @GET, @POST, etc.).", new Object[0]);
            }
            if (!this.f12726n) {
                if (this.f12728p) {
                    throw m34a("Multipart can only be specified on HTTP methods with request body (e.g., @POST).", new Object[0]);
                }
                if (this.f12727o) {
                    throw m34a("FormUrlEncoded can only be specified on HTTP methods with request body (e.g., @POST).", new Object[0]);
                }
            }
            int length = this.f12716d.length;
            this.f12733u = new ParameterHandler[length];
            for (int i = 0; i < length; i++) {
                Type type2 = this.f12717e[i];
                if (C3208o.m11d(type2)) {
                    throw m38a(i, "Parameter type must not include a type variable or wildcard: %s", type2);
                }
                Annotation[] annotationArr = this.f12716d[i];
                if (annotationArr == null) {
                    throw m38a(i, "No Retrofit annotation found.", new Object[0]);
                }
                this.f12733u[i] = m37a(i, type2, annotationArr);
            }
            if (this.f12729q != null || this.f12724l) {
                if (!this.f12727o && !this.f12728p && !this.f12726n && this.f12721i) {
                    throw m34a("Non-body HTTP method cannot contain @Body.", new Object[0]);
                }
                if (this.f12727o && !this.f12719g) {
                    throw m34a("Form-encoded method must contain at least one @Field.", new Object[0]);
                }
                if (this.f12728p && !this.f12720h) {
                    throw m34a("Multipart method must contain at least one @Part.", new Object[0]);
                }
                return new ServiceMethod(this);
            }
            throw m34a("Missing either @%s URL or @Url parameter.", this.f12725m);
        }

        /* renamed from: b */
        private CallAdapter<T, R> m29b() {
            Type genericReturnType = this.f12714b.getGenericReturnType();
            if (C3208o.m11d(genericReturnType)) {
                throw m34a("Method return type must not include a type variable or wildcard: %s", genericReturnType);
            }
            if (genericReturnType == Void.TYPE) {
                throw m34a("Service methods cannot return void.", new Object[0]);
            }
            try {
                return (CallAdapter<T, R>) this.f12713a.m62a(genericReturnType, this.f12714b.getAnnotations());
            } catch (RuntimeException e) {
                throw m32a(e, "Unable to create call adapter for %s", genericReturnType);
            }
        }

        /* renamed from: a */
        private void m31a(Annotation annotation) {
            if (annotation instanceof DELETE) {
                m35a(CommandCard.DELETE, ((DELETE) annotation).m126a(), false);
            } else if (annotation instanceof GET) {
                m35a("GET", ((GET) annotation).m122a(), false);
            } else if (annotation instanceof HEAD) {
                m35a("HEAD", ((HEAD) annotation).m121a(), false);
                if (!Void.class.equals(this.f12718f)) {
                    throw m34a("HEAD method must use Void as response type.", new Object[0]);
                }
            } else if (annotation instanceof PATCH) {
                m35a("PATCH", ((PATCH) annotation).m114a(), true);
            } else if (annotation instanceof POST) {
                m35a("POST", ((POST) annotation).m113a(), true);
            } else if (annotation instanceof PUT) {
                m35a("PUT", ((PUT) annotation).m112a(), true);
            } else if (annotation instanceof OPTIONS) {
                m35a("OPTIONS", ((OPTIONS) annotation).m115a(), false);
            } else if (annotation instanceof HTTP) {
                HTTP http = (HTTP) annotation;
                m35a(http.m120a(), http.m119b(), http.m118c());
            } else if (annotation instanceof Headers) {
                String[] m116a = ((Headers) annotation).m116a();
                if (m116a.length == 0) {
                    throw m34a("@Headers annotation is empty.", new Object[0]);
                }
                this.f12730r = m30a(m116a);
            } else if (annotation instanceof Multipart) {
                if (this.f12727o) {
                    throw m34a("Only one encoding annotation is allowed.", new Object[0]);
                }
                this.f12728p = true;
            } else if (annotation instanceof FormUrlEncoded) {
                if (this.f12728p) {
                    throw m34a("Only one encoding annotation is allowed.", new Object[0]);
                }
                this.f12727o = true;
            }
        }

        /* renamed from: a */
        private void m35a(String str, String str2, boolean z) {
            String str3 = this.f12725m;
            if (str3 != null) {
                throw m34a("Only one HTTP method is allowed. Found: %s and %s.", str3, str);
            }
            this.f12725m = str;
            this.f12726n = z;
            if (str2.isEmpty()) {
                return;
            }
            int indexOf = str2.indexOf(63);
            if (indexOf != -1 && indexOf < str2.length() - 1) {
                String substring = str2.substring(indexOf + 1);
                if (ServiceMethod.f12699a.matcher(substring).find()) {
                    throw m34a("URL query string \"%s\" must not have replace block. For dynamic query parameters use @Query.", substring);
                }
            }
            this.f12729q = str2;
            this.f12732t = ServiceMethod.m44a(str2);
        }

        /* renamed from: a */
        private C2984s m30a(String[] strArr) {
            C2984s.C2985a c2985a = new C2984s.C2985a();
            for (String str : strArr) {
                int indexOf = str.indexOf(58);
                if (indexOf == -1 || indexOf == 0 || indexOf == str.length() - 1) {
                    throw m34a("@Headers value must be in the form \"Name: Value\". Found: \"%s\"", str);
                }
                String substring = str.substring(0, indexOf);
                String trim = str.substring(indexOf + 1).trim();
                if ("Content-Type".equalsIgnoreCase(substring)) {
                    MediaType m2418b = MediaType.m2418b(trim);
                    if (m2418b == null) {
                        throw m34a("Malformed content type: %s", trim);
                    }
                    this.f12731s = m2418b;
                } else {
                    c2985a.m2492a(substring, trim);
                }
            }
            return c2985a.m2494a();
        }

        /* renamed from: a */
        private ParameterHandler<?> m37a(int i, Type type, Annotation[] annotationArr) {
            ParameterHandler<?> parameterHandler = null;
            for (Annotation annotation : annotationArr) {
                ParameterHandler<?> m36a = m36a(i, type, annotationArr, annotation);
                if (m36a != null) {
                    if (parameterHandler != null) {
                        throw m38a(i, "Multiple Retrofit annotations found, only one allowed.", new Object[0]);
                    }
                    parameterHandler = m36a;
                }
            }
            if (parameterHandler != null) {
                return parameterHandler;
            }
            throw m38a(i, "No Retrofit annotation found.", new Object[0]);
        }

        /* renamed from: a */
        private ParameterHandler<?> m36a(int i, Type type, Annotation[] annotationArr, Annotation annotation) {
            if (annotation instanceof Url) {
                if (this.f12724l) {
                    throw m38a(i, "Multiple @Url method annotations found.", new Object[0]);
                }
                if (this.f12722j) {
                    throw m38a(i, "@Path parameters may not be used with @Url.", new Object[0]);
                }
                if (this.f12723k) {
                    throw m38a(i, "A @Url parameter must not come after a @Query", new Object[0]);
                }
                if (this.f12729q == null) {
                    this.f12724l = true;
                    if (type == HttpUrl.class || type == String.class || type == URI.class || ((type instanceof Class) && "android.net.Uri".equals(((Class) type).getName()))) {
                        return new ParameterHandler.C3197m();
                    }
                    throw m38a(i, "@Url must be okhttp3.HttpUrl, String, java.net.URI, or android.net.Uri type.", new Object[0]);
                }
                throw m38a(i, "@Url cannot be used with @%s URL", this.f12725m);
            } else if (annotation instanceof Path) {
                if (this.f12723k) {
                    throw m38a(i, "A @Path parameter must not come after a @Query.", new Object[0]);
                }
                if (this.f12724l) {
                    throw m38a(i, "@Path parameters may not be used with @Url.", new Object[0]);
                }
                if (this.f12729q != null) {
                    this.f12722j = true;
                    Path path = (Path) annotation;
                    String m108a = path.m108a();
                    m39a(i, m108a);
                    return new ParameterHandler.C3192h(m108a, this.f12713a.m54c(type, annotationArr), path.m107b());
                }
                throw m38a(i, "@Path can only be used with relative url on @%s", this.f12725m);
            } else if (annotation instanceof Query) {
                Query query = (Query) annotation;
                String m106a = query.m106a();
                boolean m105b = query.m105b();
                Class<?> m23a = C3208o.m23a(type);
                this.f12723k = true;
                if (Iterable.class.isAssignableFrom(m23a)) {
                    if (!(type instanceof ParameterizedType)) {
                        throw m38a(i, m23a.getSimpleName() + " must include generic type (e.g., " + m23a.getSimpleName() + "<String>)", new Object[0]);
                    }
                    return new ParameterHandler.C3193i(m106a, this.f12713a.m54c(C3208o.m27a(0, (ParameterizedType) type), annotationArr), m105b).m102a();
                } else if (m23a.isArray()) {
                    return new ParameterHandler.C3193i(m106a, this.f12713a.m54c(ServiceMethod.m45a(m23a.getComponentType()), annotationArr), m105b).m101b();
                } else {
                    return new ParameterHandler.C3193i(m106a, this.f12713a.m54c(type, annotationArr), m105b);
                }
            } else if (annotation instanceof QueryName) {
                boolean m103a = ((QueryName) annotation).m103a();
                Class<?> m23a2 = C3208o.m23a(type);
                this.f12723k = true;
                if (Iterable.class.isAssignableFrom(m23a2)) {
                    if (!(type instanceof ParameterizedType)) {
                        throw m38a(i, m23a2.getSimpleName() + " must include generic type (e.g., " + m23a2.getSimpleName() + "<String>)", new Object[0]);
                    }
                    return new ParameterHandler.C3195k(this.f12713a.m54c(C3208o.m27a(0, (ParameterizedType) type), annotationArr), m103a).m102a();
                } else if (m23a2.isArray()) {
                    return new ParameterHandler.C3195k(this.f12713a.m54c(ServiceMethod.m45a(m23a2.getComponentType()), annotationArr), m103a).m101b();
                } else {
                    return new ParameterHandler.C3195k(this.f12713a.m54c(type, annotationArr), m103a);
                }
            } else if (annotation instanceof QueryMap) {
                Class<?> m23a3 = C3208o.m23a(type);
                if (!Map.class.isAssignableFrom(m23a3)) {
                    throw m38a(i, "@QueryMap parameter type must be Map.", new Object[0]);
                }
                Type m13b = C3208o.m13b(type, m23a3, Map.class);
                if (!(m13b instanceof ParameterizedType)) {
                    throw m38a(i, "Map must include generic types (e.g., Map<String, String>)", new Object[0]);
                }
                ParameterizedType parameterizedType = (ParameterizedType) m13b;
                Type m27a = C3208o.m27a(0, parameterizedType);
                if (String.class != m27a) {
                    throw m38a(i, "@QueryMap keys must be of type String: " + m27a, new Object[0]);
                }
                return new ParameterHandler.C3194j(this.f12713a.m54c(C3208o.m27a(1, parameterizedType), annotationArr), ((QueryMap) annotation).m104a());
            } else if (annotation instanceof Header) {
                String m117a = ((Header) annotation).m117a();
                Class<?> m23a4 = C3208o.m23a(type);
                if (Iterable.class.isAssignableFrom(m23a4)) {
                    if (!(type instanceof ParameterizedType)) {
                        throw m38a(i, m23a4.getSimpleName() + " must include generic type (e.g., " + m23a4.getSimpleName() + "<String>)", new Object[0]);
                    }
                    return new ParameterHandler.C3188d(m117a, this.f12713a.m54c(C3208o.m27a(0, (ParameterizedType) type), annotationArr)).m102a();
                } else if (m23a4.isArray()) {
                    return new ParameterHandler.C3188d(m117a, this.f12713a.m54c(ServiceMethod.m45a(m23a4.getComponentType()), annotationArr)).m101b();
                } else {
                    return new ParameterHandler.C3188d(m117a, this.f12713a.m54c(type, annotationArr));
                }
            } else if (annotation instanceof HeaderMap) {
                Class<?> m23a5 = C3208o.m23a(type);
                if (!Map.class.isAssignableFrom(m23a5)) {
                    throw m38a(i, "@HeaderMap parameter type must be Map.", new Object[0]);
                }
                Type m13b2 = C3208o.m13b(type, m23a5, Map.class);
                if (!(m13b2 instanceof ParameterizedType)) {
                    throw m38a(i, "Map must include generic types (e.g., Map<String, String>)", new Object[0]);
                }
                ParameterizedType parameterizedType2 = (ParameterizedType) m13b2;
                Type m27a2 = C3208o.m27a(0, parameterizedType2);
                if (String.class != m27a2) {
                    throw m38a(i, "@HeaderMap keys must be of type String: " + m27a2, new Object[0]);
                }
                return new ParameterHandler.C3189e(this.f12713a.m54c(C3208o.m27a(1, parameterizedType2), annotationArr));
            } else if (annotation instanceof Field) {
                if (!this.f12727o) {
                    throw m38a(i, "@Field parameters can only be used with form encoding.", new Object[0]);
                }
                Field field = (Field) annotation;
                String m125a = field.m125a();
                boolean m124b = field.m124b();
                this.f12719g = true;
                Class<?> m23a6 = C3208o.m23a(type);
                if (Iterable.class.isAssignableFrom(m23a6)) {
                    if (!(type instanceof ParameterizedType)) {
                        throw m38a(i, m23a6.getSimpleName() + " must include generic type (e.g., " + m23a6.getSimpleName() + "<String>)", new Object[0]);
                    }
                    return new ParameterHandler.C3186b(m125a, this.f12713a.m54c(C3208o.m27a(0, (ParameterizedType) type), annotationArr), m124b).m102a();
                } else if (m23a6.isArray()) {
                    return new ParameterHandler.C3186b(m125a, this.f12713a.m54c(ServiceMethod.m45a(m23a6.getComponentType()), annotationArr), m124b).m101b();
                } else {
                    return new ParameterHandler.C3186b(m125a, this.f12713a.m54c(type, annotationArr), m124b);
                }
            } else if (annotation instanceof FieldMap) {
                if (!this.f12727o) {
                    throw m38a(i, "@FieldMap parameters can only be used with form encoding.", new Object[0]);
                }
                Class<?> m23a7 = C3208o.m23a(type);
                if (!Map.class.isAssignableFrom(m23a7)) {
                    throw m38a(i, "@FieldMap parameter type must be Map.", new Object[0]);
                }
                Type m13b3 = C3208o.m13b(type, m23a7, Map.class);
                if (!(m13b3 instanceof ParameterizedType)) {
                    throw m38a(i, "Map must include generic types (e.g., Map<String, String>)", new Object[0]);
                }
                ParameterizedType parameterizedType3 = (ParameterizedType) m13b3;
                Type m27a3 = C3208o.m27a(0, parameterizedType3);
                if (String.class != m27a3) {
                    throw m38a(i, "@FieldMap keys must be of type String: " + m27a3, new Object[0]);
                }
                Converter<T, String> m54c = this.f12713a.m54c(C3208o.m27a(1, parameterizedType3), annotationArr);
                this.f12719g = true;
                return new ParameterHandler.C3187c(m54c, ((FieldMap) annotation).m123a());
            } else if (annotation instanceof Part) {
                if (!this.f12728p) {
                    throw m38a(i, "@Part parameters can only be used with multipart encoding.", new Object[0]);
                }
                Part part = (Part) annotation;
                this.f12720h = true;
                String m111a = part.m111a();
                Class<?> m23a8 = C3208o.m23a(type);
                if (m111a.isEmpty()) {
                    if (Iterable.class.isAssignableFrom(m23a8)) {
                        if (!(type instanceof ParameterizedType)) {
                            throw m38a(i, m23a8.getSimpleName() + " must include generic type (e.g., " + m23a8.getSimpleName() + "<String>)", new Object[0]);
                        } else if (!MultipartBody.C2989b.class.isAssignableFrom(C3208o.m23a(C3208o.m27a(0, (ParameterizedType) type)))) {
                            throw m38a(i, "@Part annotation must supply a name or use MultipartBody.Part parameter type.", new Object[0]);
                        } else {
                            return ParameterHandler.C3196l.f12663a.m102a();
                        }
                    } else if (m23a8.isArray()) {
                        if (!MultipartBody.C2989b.class.isAssignableFrom(m23a8.getComponentType())) {
                            throw m38a(i, "@Part annotation must supply a name or use MultipartBody.Part parameter type.", new Object[0]);
                        }
                        return ParameterHandler.C3196l.f12663a.m101b();
                    } else if (MultipartBody.C2989b.class.isAssignableFrom(m23a8)) {
                        return ParameterHandler.C3196l.f12663a;
                    } else {
                        throw m38a(i, "@Part annotation must supply a name or use MultipartBody.Part parameter type.", new Object[0]);
                    }
                }
                C2984s m2499a = C2984s.m2499a("Content-Disposition", "form-data; name=\"" + m111a + "\"", "Content-Transfer-Encoding", part.m110b());
                if (Iterable.class.isAssignableFrom(m23a8)) {
                    if (!(type instanceof ParameterizedType)) {
                        throw m38a(i, m23a8.getSimpleName() + " must include generic type (e.g., " + m23a8.getSimpleName() + "<String>)", new Object[0]);
                    }
                    Type m27a4 = C3208o.m27a(0, (ParameterizedType) type);
                    if (MultipartBody.C2989b.class.isAssignableFrom(C3208o.m23a(m27a4))) {
                        throw m38a(i, "@Part parameters using the MultipartBody.Part must not include a part name in the annotation.", new Object[0]);
                    }
                    return new ParameterHandler.C3190f(m2499a, this.f12713a.m61a(m27a4, annotationArr, this.f12715c)).m102a();
                } else if (m23a8.isArray()) {
                    Class<?> m45a = ServiceMethod.m45a(m23a8.getComponentType());
                    if (MultipartBody.C2989b.class.isAssignableFrom(m45a)) {
                        throw m38a(i, "@Part parameters using the MultipartBody.Part must not include a part name in the annotation.", new Object[0]);
                    }
                    return new ParameterHandler.C3190f(m2499a, this.f12713a.m61a(m45a, annotationArr, this.f12715c)).m101b();
                } else if (MultipartBody.C2989b.class.isAssignableFrom(m23a8)) {
                    throw m38a(i, "@Part parameters using the MultipartBody.Part must not include a part name in the annotation.", new Object[0]);
                } else {
                    return new ParameterHandler.C3190f(m2499a, this.f12713a.m61a(type, annotationArr, this.f12715c));
                }
            } else if (annotation instanceof PartMap) {
                if (!this.f12728p) {
                    throw m38a(i, "@PartMap parameters can only be used with multipart encoding.", new Object[0]);
                }
                this.f12720h = true;
                Class<?> m23a9 = C3208o.m23a(type);
                if (!Map.class.isAssignableFrom(m23a9)) {
                    throw m38a(i, "@PartMap parameter type must be Map.", new Object[0]);
                }
                Type m13b4 = C3208o.m13b(type, m23a9, Map.class);
                if (!(m13b4 instanceof ParameterizedType)) {
                    throw m38a(i, "Map must include generic types (e.g., Map<String, String>)", new Object[0]);
                }
                ParameterizedType parameterizedType4 = (ParameterizedType) m13b4;
                Type m27a5 = C3208o.m27a(0, parameterizedType4);
                if (String.class != m27a5) {
                    throw m38a(i, "@PartMap keys must be of type String: " + m27a5, new Object[0]);
                }
                Type m27a6 = C3208o.m27a(1, parameterizedType4);
                if (MultipartBody.C2989b.class.isAssignableFrom(C3208o.m23a(m27a6))) {
                    throw m38a(i, "@PartMap values cannot be MultipartBody.Part. Use @Part List<Part> or a different value type instead.", new Object[0]);
                }
                return new ParameterHandler.C3191g(this.f12713a.m61a(m27a6, annotationArr, this.f12715c), ((PartMap) annotation).m109a());
            } else if (annotation instanceof Body) {
                if (this.f12727o || this.f12728p) {
                    throw m38a(i, "@Body parameters cannot be used with form or multi-part encoding.", new Object[0]);
                }
                if (this.f12721i) {
                    throw m38a(i, "Multiple @Body method annotations found.", new Object[0]);
                }
                try {
                    Converter<T, RequestBody> m61a = this.f12713a.m61a(type, annotationArr, this.f12715c);
                    this.f12721i = true;
                    return new ParameterHandler.C3185a(m61a);
                } catch (RuntimeException e) {
                    throw m33a(e, i, "Unable to create @Body converter for %s", type);
                }
            } else {
                return null;
            }
        }

        /* renamed from: a */
        private void m39a(int i, String str) {
            if (!ServiceMethod.f12700b.matcher(str).matches()) {
                throw m38a(i, "@Path parameter name must match %s. Found: %s", ServiceMethod.f12699a.pattern(), str);
            }
            if (!this.f12732t.contains(str)) {
                throw m38a(i, "URL \"%s\" does not contain \"{%s}\".", this.f12729q, str);
            }
        }

        /* renamed from: c */
        private Converter<ResponseBody, T> m28c() {
            try {
                return this.f12713a.m55b(this.f12718f, this.f12714b.getAnnotations());
            } catch (RuntimeException e) {
                throw m32a(e, "Unable to create converter for %s", this.f12718f);
            }
        }

        /* renamed from: a */
        private RuntimeException m34a(String str, Object... objArr) {
            return m32a((Throwable) null, str, objArr);
        }

        /* renamed from: a */
        private RuntimeException m32a(Throwable th, String str, Object... objArr) {
            String format = String.format(str, objArr);
            return new IllegalArgumentException(format + "\n    for method " + this.f12714b.getDeclaringClass().getSimpleName() + "." + this.f12714b.getName(), th);
        }

        /* renamed from: a */
        private RuntimeException m33a(Throwable th, int i, String str, Object... objArr) {
            return m32a(th, str + " (parameter #" + (i + 1) + ")", objArr);
        }

        /* renamed from: a */
        private RuntimeException m38a(int i, String str, Object... objArr) {
            return m34a(str + " (parameter #" + (i + 1) + ")", objArr);
        }
    }

    /* renamed from: a */
    static Set<String> m44a(String str) {
        Matcher matcher = f12699a.matcher(str);
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        while (matcher.find()) {
            linkedHashSet.add(matcher.group(1));
        }
        return linkedHashSet;
    }

    /* renamed from: a */
    static Class<?> m45a(Class<?> cls) {
        return Boolean.TYPE == cls ? Boolean.class : Byte.TYPE == cls ? Byte.class : Character.TYPE == cls ? Character.class : Double.TYPE == cls ? Double.class : Float.TYPE == cls ? Float.class : Integer.TYPE == cls ? Integer.class : Long.TYPE == cls ? Long.class : Short.TYPE == cls ? Short.class : cls;
    }
}
