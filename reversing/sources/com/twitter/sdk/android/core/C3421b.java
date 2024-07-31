package com.twitter.sdk.android.core;

import com.google.gson.Gson;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import com.twitter.sdk.android.core.internal.oauth.GuestAuthToken;
import com.twitter.sdk.android.core.internal.oauth.OAuth2Token;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.twitter.sdk.android.core.b */
/* loaded from: classes2.dex */
public class AuthTokenAdapter implements JsonDeserializer<AuthToken>, JsonSerializer<AuthToken> {

    /* renamed from: a */
    static final Map<String, Class<? extends AuthToken>> f8437a = new HashMap();

    /* renamed from: b */
    private final Gson f8438b = new Gson();

    static {
        f8437a.put("oauth1a", TwitterAuthToken.class);
        f8437a.put("oauth2", OAuth2Token.class);
        f8437a.put("guest", GuestAuthToken.class);
    }

    @Override // com.google.gson.JsonSerializer
    /* renamed from: a */
    public JsonElement serialize(AuthToken authToken, Type type, JsonSerializationContext jsonSerializationContext) {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("auth_type", m4574a(authToken.getClass()));
        jsonObject.add("auth_token", this.f8438b.toJsonTree(authToken));
        return jsonObject;
    }

    @Override // com.google.gson.JsonDeserializer
    /* renamed from: a */
    public AuthToken deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        JsonObject asJsonObject = jsonElement.getAsJsonObject();
        String asString = asJsonObject.getAsJsonPrimitive("auth_type").getAsString();
        return (AuthToken) this.f8438b.fromJson(asJsonObject.get("auth_token"), (Class<Object>) f8437a.get(asString));
    }

    /* renamed from: a */
    static String m4574a(Class<? extends AuthToken> cls) {
        for (Map.Entry<String, Class<? extends AuthToken>> entry : f8437a.entrySet()) {
            if (entry.getValue().equals(cls)) {
                return entry.getKey();
            }
        }
        return "";
    }
}
