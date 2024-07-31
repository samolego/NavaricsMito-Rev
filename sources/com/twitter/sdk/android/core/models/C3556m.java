package com.twitter.sdk.android.core.models;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.util.Collections;
import java.util.Map;

/* renamed from: com.twitter.sdk.android.core.models.m */
/* loaded from: classes2.dex */
public class SafeMapAdapter implements TypeAdapterFactory {
    @Override // com.google.gson.TypeAdapterFactory
    public <T> TypeAdapter<T> create(Gson gson, final TypeToken<T> typeToken) {
        final TypeAdapter<T> delegateAdapter = gson.getDelegateAdapter(this, typeToken);
        return new TypeAdapter<T>() { // from class: com.twitter.sdk.android.core.models.m.1
            @Override // com.google.gson.TypeAdapter
            public void write(JsonWriter jsonWriter, T t) throws IOException {
                delegateAdapter.write(jsonWriter, t);
            }

            @Override // com.google.gson.TypeAdapter
            public T read(JsonReader jsonReader) throws IOException {
                T t = (T) delegateAdapter.read(jsonReader);
                if (Map.class.isAssignableFrom(typeToken.getRawType())) {
                    if (t == null) {
                        return (T) Collections.EMPTY_MAP;
                    }
                    return (T) Collections.unmodifiableMap((Map) t);
                }
                return t;
            }
        };
    }
}
