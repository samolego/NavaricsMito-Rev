package retrofit2;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Converter;
import retrofit2.http.Streaming;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: retrofit2.a */
/* loaded from: classes2.dex */
public final class BuiltInConverters extends Converter.AbstractC3172a {
    @Override // retrofit2.Converter.AbstractC3172a
    /* renamed from: a */
    public Converter<ResponseBody, ?> mo152a(Type type, Annotation[] annotationArr, Retrofit retrofit) {
        if (type == ResponseBody.class) {
            if (C3208o.m15a(annotationArr, (Class<? extends Annotation>) Streaming.class)) {
                return C3161c.f12575a;
            }
            return C3159a.f12573a;
        } else if (type == Void.class) {
            return C3163e.f12577a;
        } else {
            return null;
        }
    }

    @Override // retrofit2.Converter.AbstractC3172a
    /* renamed from: a */
    public Converter<?, RequestBody> mo151a(Type type, Annotation[] annotationArr, Annotation[] annotationArr2, Retrofit retrofit) {
        if (RequestBody.class.isAssignableFrom(C3208o.m23a(type))) {
            return C3160b.f12574a;
        }
        return null;
    }

    /* compiled from: BuiltInConverters.java */
    /* renamed from: retrofit2.a$e */
    /* loaded from: classes2.dex */
    static final class C3163e implements Converter<ResponseBody, Void> {

        /* renamed from: a */
        static final C3163e f12577a = new C3163e();

        C3163e() {
        }

        @Override // retrofit2.Converter
        /* renamed from: a  reason: avoid collision after fix types in other method */
        public Void mo153a(ResponseBody responseBody) {
            responseBody.close();
            return null;
        }
    }

    /* compiled from: BuiltInConverters.java */
    /* renamed from: retrofit2.a$b */
    /* loaded from: classes2.dex */
    static final class C3160b implements Converter<RequestBody, RequestBody> {

        /* renamed from: a */
        static final C3160b f12574a = new C3160b();

        @Override // retrofit2.Converter
        /* renamed from: a  reason: avoid collision after fix types in other method */
        public RequestBody mo153a(RequestBody requestBody) {
            return requestBody;
        }

        C3160b() {
        }
    }

    /* compiled from: BuiltInConverters.java */
    /* renamed from: retrofit2.a$c */
    /* loaded from: classes2.dex */
    static final class C3161c implements Converter<ResponseBody, ResponseBody> {

        /* renamed from: a */
        static final C3161c f12575a = new C3161c();

        @Override // retrofit2.Converter
        /* renamed from: a  reason: avoid collision after fix types in other method */
        public ResponseBody mo153a(ResponseBody responseBody) {
            return responseBody;
        }

        C3161c() {
        }
    }

    /* compiled from: BuiltInConverters.java */
    /* renamed from: retrofit2.a$a */
    /* loaded from: classes2.dex */
    static final class C3159a implements Converter<ResponseBody, ResponseBody> {

        /* renamed from: a */
        static final C3159a f12573a = new C3159a();

        C3159a() {
        }

        @Override // retrofit2.Converter
        /* renamed from: a  reason: avoid collision after fix types in other method */
        public ResponseBody mo153a(ResponseBody responseBody) throws IOException {
            try {
                return C3208o.m17a(responseBody);
            } finally {
                responseBody.close();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: BuiltInConverters.java */
    /* renamed from: retrofit2.a$d */
    /* loaded from: classes2.dex */
    public static final class C3162d implements Converter<Object, String> {

        /* renamed from: a */
        static final C3162d f12576a = new C3162d();

        C3162d() {
        }

        @Override // retrofit2.Converter
        /* renamed from: b */
        public String mo153a(Object obj) {
            return obj.toString();
        }
    }
}
