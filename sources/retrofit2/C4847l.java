package retrofit2;

import javax.annotation.Nullable;
import okhttp3.C2984s;
import okhttp3.Response;
import okhttp3.ResponseBody;

/* compiled from: Response.java */
/* renamed from: retrofit2.l */
/* loaded from: classes2.dex */
public final class C3204l<T> {

    /* renamed from: a */
    private final Response f12679a;
    @Nullable

    /* renamed from: b */
    private final T f12680b;
    @Nullable

    /* renamed from: c */
    private final ResponseBody f12681c;

    /* renamed from: a */
    public static <T> C3204l<T> m72a(@Nullable T t, Response response) {
        C3208o.m25a(response, "rawResponse == null");
        if (!response.m3030c()) {
            throw new IllegalArgumentException("rawResponse must be successful response");
        }
        return new C3204l<>(response, t, null);
    }

    /* renamed from: a */
    public static <T> C3204l<T> m71a(ResponseBody responseBody, Response response) {
        C3208o.m25a(responseBody, "body == null");
        C3208o.m25a(response, "rawResponse == null");
        if (response.m3030c()) {
            throw new IllegalArgumentException("rawResponse should not be successful response");
        }
        return new C3204l<>(response, null, responseBody);
    }

    private C3204l(Response response, @Nullable T t, @Nullable ResponseBody responseBody) {
        this.f12679a = response;
        this.f12680b = t;
        this.f12681c = responseBody;
    }

    /* renamed from: a */
    public int m73a() {
        return this.f12679a.m3031b();
    }

    /* renamed from: b */
    public String m70b() {
        return this.f12679a.m3029d();
    }

    /* renamed from: c */
    public C2984s m69c() {
        return this.f12679a.m3027f();
    }

    /* renamed from: d */
    public boolean m68d() {
        return this.f12679a.m3030c();
    }

    @Nullable
    /* renamed from: e */
    public T m67e() {
        return this.f12680b;
    }

    @Nullable
    /* renamed from: f */
    public ResponseBody m66f() {
        return this.f12681c;
    }

    public String toString() {
        return this.f12679a.toString();
    }
}
