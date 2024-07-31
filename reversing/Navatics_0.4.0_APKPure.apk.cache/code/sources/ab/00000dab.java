package com.facebook.internal;

import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

/* compiled from: ProfileInformationCache.java */
/* renamed from: com.facebook.internal.u, reason: use source file name */
/* loaded from: classes.dex */
class ProfileInformationCache {

    /* renamed from: a */
    private static final ConcurrentHashMap<String, JSONObject> f2060a = new ConcurrentHashMap<>();

    /* renamed from: a */
    public static JSONObject m2422a(String str) {
        return f2060a.get(str);
    }

    /* renamed from: a */
    public static void m2423a(String str, JSONObject jSONObject) {
        f2060a.put(str, jSONObject);
    }
}