package com.facebook.internal;

import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

/* renamed from: com.facebook.internal.u */
/* loaded from: classes.dex */
class ProfileInformationCache {

    /* renamed from: a */
    private static final ConcurrentHashMap<String, JSONObject> f2053a = new ConcurrentHashMap<>();

    /* renamed from: a */
    public static JSONObject m10558a(String str) {
        return f2053a.get(str);
    }

    /* renamed from: a */
    public static void m10557a(String str, JSONObject jSONObject) {
        f2053a.put(str, jSONObject);
    }
}
