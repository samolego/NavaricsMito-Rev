package retrofit2.p153a.p154a;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import okio.Buffer;
import retrofit2.Converter;

/* renamed from: retrofit2.a.a.b */
/* loaded from: classes2.dex */
final class GsonRequestBodyConverter<T> implements Converter<T, RequestBody> {

    /* renamed from: a */
    private static final MediaType f12579a = MediaType.m2418b("application/json; charset=UTF-8");

    /* renamed from: b */
    private static final Charset f12580b = Charset.forName("UTF-8");

    /* renamed from: c */
    private final Gson f12581c;

    /* renamed from: d */
    private final TypeAdapter<T> f12582d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public GsonRequestBodyConverter(Gson gson, TypeAdapter<T> typeAdapter) {
        this.f12581c = gson;
        this.f12582d = typeAdapter;
    }

    @Override // retrofit2.Converter
    /* renamed from: b */
    public RequestBody mo153a(T t) throws IOException {
        Buffer buffer = new Buffer();
        JsonWriter newJsonWriter = this.f12581c.newJsonWriter(new OutputStreamWriter(buffer.m2296d(), f12580b));
        this.f12582d.write(newJsonWriter, t);
        newJsonWriter.close();
        return RequestBody.m3037a(f12579a, buffer.m2286o());
    }
}
