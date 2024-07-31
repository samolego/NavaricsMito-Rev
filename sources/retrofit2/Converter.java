package retrofit2;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import javax.annotation.Nullable;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;

/* renamed from: retrofit2.e */
/* loaded from: classes2.dex */
public interface Converter<F, T> {

    /* compiled from: Converter.java */
    /* renamed from: retrofit2.e$a */
    /* loaded from: classes2.dex */
    public static abstract class AbstractC3172a {
        @Nullable
        /* renamed from: a */
        public Converter<ResponseBody, ?> mo152a(Type type, Annotation[] annotationArr, Retrofit retrofit) {
            return null;
        }

        @Nullable
        /* renamed from: a */
        public Converter<?, RequestBody> mo151a(Type type, Annotation[] annotationArr, Annotation[] annotationArr2, Retrofit retrofit) {
            return null;
        }

        @Nullable
        /* renamed from: b */
        public Converter<?, String> m150b(Type type, Annotation[] annotationArr, Retrofit retrofit) {
            return null;
        }
    }

    /* renamed from: a */
    T mo153a(F f) throws IOException;
}
