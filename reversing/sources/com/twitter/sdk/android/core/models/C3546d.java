package com.twitter.sdk.android.core.models;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import tv.danmaku.ijk.media.player.IjkMediaMeta;

/* renamed from: com.twitter.sdk.android.core.models.d */
/* loaded from: classes2.dex */
public class BindingValuesAdapter implements JsonDeserializer<BindingValues>, JsonSerializer<BindingValues> {
    @Override // com.google.gson.JsonSerializer
    /* renamed from: a */
    public JsonElement serialize(BindingValues bindingValues, Type type, JsonSerializationContext jsonSerializationContext) {
        return null;
    }

    @Override // com.google.gson.JsonDeserializer
    /* renamed from: a */
    public BindingValues deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        if (!jsonElement.isJsonObject()) {
            return new BindingValues();
        }
        Set<Map.Entry<String, JsonElement>> entrySet = jsonElement.getAsJsonObject().entrySet();
        HashMap hashMap = new HashMap(32);
        for (Map.Entry<String, JsonElement> entry : entrySet) {
            hashMap.put(entry.getKey(), m4250a(entry.getValue().getAsJsonObject(), jsonDeserializationContext));
        }
        return new BindingValues(hashMap);
    }

    /* renamed from: a */
    Object m4250a(JsonObject jsonObject, JsonDeserializationContext jsonDeserializationContext) {
        JsonElement jsonElement = jsonObject.get(IjkMediaMeta.IJKM_KEY_TYPE);
        if (jsonElement == null || !jsonElement.isJsonPrimitive()) {
            return null;
        }
        String asString = jsonElement.getAsString();
        char c = 65535;
        int hashCode = asString.hashCode();
        if (hashCode != -1838656495) {
            if (hashCode != 2614219) {
                if (hashCode != 69775675) {
                    if (hashCode == 782694408 && asString.equals("BOOLEAN")) {
                        c = 3;
                    }
                } else if (asString.equals("IMAGE")) {
                    c = 1;
                }
            } else if (asString.equals("USER")) {
                c = 2;
            }
        } else if (asString.equals("STRING")) {
            c = 0;
        }
        switch (c) {
            case 0:
                return jsonDeserializationContext.deserialize(jsonObject.get("string_value"), String.class);
            case 1:
                return jsonDeserializationContext.deserialize(jsonObject.get("image_value"), ImageValue.class);
            case 2:
                return jsonDeserializationContext.deserialize(jsonObject.get("user_value"), UserValue.class);
            case 3:
                return jsonDeserializationContext.deserialize(jsonObject.get("boolean_value"), Boolean.class);
            default:
                return null;
        }
    }
}
