package retrofit2.p153a.p154a;

import com.google.gson.Gson;
import com.google.gson.JsonIOException;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import java.io.IOException;
import okhttp3.ResponseBody;
import retrofit2.Converter;

/* renamed from: retrofit2.a.a.c */
/* loaded from: classes2.dex */
final class GsonResponseBodyConverter<T> implements Converter<ResponseBody, T> {

    /* renamed from: a */
    private final Gson f12583a;

    /* renamed from: b */
    private final TypeAdapter<T> f12584b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public GsonResponseBodyConverter(Gson gson, TypeAdapter<T> typeAdapter) {
        this.f12583a = gson;
        this.f12584b = typeAdapter;
    }

    @Override // retrofit2.Converter
    /* renamed from: a  reason: avoid collision after fix types in other method */
    public T mo153a(ResponseBody responseBody) throws IOException {
        JsonReader newJsonReader = this.f12583a.newJsonReader(responseBody.m3001e());
        try {
            T read = this.f12584b.read(newJsonReader);
            if (newJsonReader.peek() == JsonToken.END_DOCUMENT) {
                return read;
            }
            throw new JsonIOException("JSON document was not fully consumed.");
        } finally {
            responseBody.close();
        }
    }
}
