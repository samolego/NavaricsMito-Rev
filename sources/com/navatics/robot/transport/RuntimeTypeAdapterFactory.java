package com.navatics.robot.transport;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.JsonPrimitive;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.internal.Streams;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;
import tv.danmaku.ijk.media.player.IjkMediaMeta;

/* renamed from: com.navatics.robot.transport.z */
/* loaded from: classes.dex */
public class RuntimeTypeAdapterFactory<T> implements TypeAdapterFactory {

    /* renamed from: a */
    private final Class<?> f6723a;

    /* renamed from: b */
    private final String f6724b;

    /* renamed from: c */
    private final Map<String, Class<?>> f6725c = new LinkedHashMap();

    /* renamed from: d */
    private final Map<Class<?>, String> f6726d = new LinkedHashMap();

    /* renamed from: e */
    private final boolean f6727e;

    private RuntimeTypeAdapterFactory(Class<?> cls, String str, boolean z) {
        if (str == null || cls == null) {
            throw new NullPointerException();
        }
        this.f6723a = cls;
        this.f6724b = str;
        this.f6727e = z;
    }

    /* renamed from: a */
    public static <T> RuntimeTypeAdapterFactory<T> m5951a(Class<T> cls) {
        return new RuntimeTypeAdapterFactory<>(cls, IjkMediaMeta.IJKM_KEY_TYPE, false);
    }

    /* renamed from: a */
    public RuntimeTypeAdapterFactory<T> m5950a(Class<? extends T> cls, String str) {
        if (cls == null || str == null) {
            throw new NullPointerException();
        }
        if (this.f6726d.containsKey(cls) || this.f6725c.containsKey(str)) {
            throw new IllegalArgumentException("types and labels must be unique");
        }
        this.f6725c.put(str, cls);
        this.f6726d.put(cls, str);
        return this;
    }

    /* renamed from: b */
    public RuntimeTypeAdapterFactory<T> m5948b(Class<? extends T> cls) {
        return m5950a(cls, cls.getSimpleName());
    }

    @Override // com.google.gson.TypeAdapterFactory
    public <R> TypeAdapter<R> create(Gson gson, TypeToken<R> typeToken) {
        if (typeToken.getRawType() != this.f6723a) {
            return null;
        }
        final LinkedHashMap linkedHashMap = new LinkedHashMap();
        final LinkedHashMap linkedHashMap2 = new LinkedHashMap();
        for (Map.Entry<String, Class<?>> entry : this.f6725c.entrySet()) {
            TypeAdapter<T> delegateAdapter = gson.getDelegateAdapter(this, TypeToken.get((Class) entry.getValue()));
            linkedHashMap.put(entry.getKey(), delegateAdapter);
            linkedHashMap2.put(entry.getValue(), delegateAdapter);
        }
        return new TypeAdapter<R>() { // from class: com.navatics.robot.transport.z.1
            @Override // com.google.gson.TypeAdapter
            public R read(JsonReader jsonReader) throws IOException {
                JsonElement parse = Streams.parse(jsonReader);
                JsonElement remove = RuntimeTypeAdapterFactory.this.f6727e ? parse.getAsJsonObject().get(RuntimeTypeAdapterFactory.this.f6724b) : parse.getAsJsonObject().remove(RuntimeTypeAdapterFactory.this.f6724b);
                if (remove == null) {
                    throw new JsonParseException("cannot deserialize " + RuntimeTypeAdapterFactory.this.f6723a + " because it does not define a field named " + RuntimeTypeAdapterFactory.this.f6724b);
                }
                String asString = remove.getAsString();
                TypeAdapter typeAdapter = (TypeAdapter) linkedHashMap.get(asString);
                if (typeAdapter == null) {
                    throw new JsonParseException("cannot deserialize " + RuntimeTypeAdapterFactory.this.f6723a + " subtype named " + asString + "; did you forget to register a subtype?");
                }
                return (R) typeAdapter.fromJsonTree(parse);
            }

            @Override // com.google.gson.TypeAdapter
            public void write(JsonWriter jsonWriter, R r) throws IOException {
                Class<?> cls = r.getClass();
                String str = (String) RuntimeTypeAdapterFactory.this.f6726d.get(cls);
                TypeAdapter typeAdapter = (TypeAdapter) linkedHashMap2.get(cls);
                if (typeAdapter == null) {
                    throw new JsonParseException("cannot serialize " + cls.getName() + "; did you forget to register a subtype?");
                }
                JsonObject asJsonObject = typeAdapter.toJsonTree(r).getAsJsonObject();
                if (RuntimeTypeAdapterFactory.this.f6727e) {
                    Streams.write(asJsonObject, jsonWriter);
                    return;
                }
                JsonObject jsonObject = new JsonObject();
                if (!asJsonObject.has(RuntimeTypeAdapterFactory.this.f6724b)) {
                    jsonObject.add(RuntimeTypeAdapterFactory.this.f6724b, new JsonPrimitive(str));
                    for (Map.Entry<String, JsonElement> entry2 : asJsonObject.entrySet()) {
                        jsonObject.add(entry2.getKey(), entry2.getValue());
                    }
                    Streams.write(jsonObject, jsonWriter);
                    return;
                }
                throw new JsonParseException("cannot serialize " + cls.getName() + " because it already defines a field named " + RuntimeTypeAdapterFactory.this.f6724b);
            }
        }.nullSafe();
    }
}
