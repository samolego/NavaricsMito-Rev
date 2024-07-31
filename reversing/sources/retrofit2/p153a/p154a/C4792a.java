package retrofit2.p153a.p154a;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Converter;
import retrofit2.Retrofit;

/* renamed from: retrofit2.a.a.a */
/* loaded from: classes2.dex */
public final class GsonConverterFactory extends Converter.AbstractC3172a {

    /* renamed from: a */
    private final Gson f12578a;

    /* renamed from: a */
    public static GsonConverterFactory m169a() {
        return m168a(new Gson());
    }

    /* renamed from: a */
    public static GsonConverterFactory m168a(Gson gson) {
        if (gson == null) {
            throw new NullPointerException("gson == null");
        }
        return new GsonConverterFactory(gson);
    }

    private GsonConverterFactory(Gson gson) {
        this.f12578a = gson;
    }

    @Override // retrofit2.Converter.AbstractC3172a
    /* renamed from: a */
    public Converter<ResponseBody, ?> mo152a(Type type, Annotation[] annotationArr, Retrofit retrofit) {
        return new GsonResponseBodyConverter(this.f12578a, this.f12578a.getAdapter(TypeToken.get(type)));
    }

    @Override // retrofit2.Converter.AbstractC3172a
    /* renamed from: a */
    public Converter<?, RequestBody> mo151a(Type type, Annotation[] annotationArr, Annotation[] annotationArr2, Retrofit retrofit) {
        return new GsonRequestBodyConverter(this.f12578a, this.f12578a.getAdapter(TypeToken.get(type)));
    }
}
