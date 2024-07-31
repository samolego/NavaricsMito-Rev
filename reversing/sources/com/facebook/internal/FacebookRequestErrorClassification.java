package com.facebook.internal;

import com.facebook.FacebookRequestError;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.facebook.internal.h */
/* loaded from: classes.dex */
public final class FacebookRequestErrorClassification {

    /* renamed from: g */
    private static FacebookRequestErrorClassification f1946g;

    /* renamed from: a */
    private final Map<Integer, Set<Integer>> f1947a;

    /* renamed from: b */
    private final Map<Integer, Set<Integer>> f1948b;

    /* renamed from: c */
    private final Map<Integer, Set<Integer>> f1949c;

    /* renamed from: d */
    private final String f1950d;

    /* renamed from: e */
    private final String f1951e;

    /* renamed from: f */
    private final String f1952f;

    FacebookRequestErrorClassification(Map<Integer, Set<Integer>> map, Map<Integer, Set<Integer>> map2, Map<Integer, Set<Integer>> map3, String str, String str2, String str3) {
        this.f1947a = map;
        this.f1948b = map2;
        this.f1949c = map3;
        this.f1950d = str;
        this.f1951e = str2;
        this.f1952f = str3;
    }

    /* renamed from: a */
    public String m10714a(FacebookRequestError.Category category) {
        switch (category) {
            case OTHER:
                return this.f1950d;
            case LOGIN_RECOVERABLE:
                return this.f1952f;
            case TRANSIENT:
                return this.f1951e;
            default:
                return null;
        }
    }

    /* renamed from: a */
    public FacebookRequestError.Category m10715a(int i, int i2, boolean z) {
        Set<Integer> set;
        Set<Integer> set2;
        Set<Integer> set3;
        if (z) {
            return FacebookRequestError.Category.TRANSIENT;
        }
        Map<Integer, Set<Integer>> map = this.f1947a;
        if (map != null && map.containsKey(Integer.valueOf(i)) && ((set3 = this.f1947a.get(Integer.valueOf(i))) == null || set3.contains(Integer.valueOf(i2)))) {
            return FacebookRequestError.Category.OTHER;
        }
        Map<Integer, Set<Integer>> map2 = this.f1949c;
        if (map2 != null && map2.containsKey(Integer.valueOf(i)) && ((set2 = this.f1949c.get(Integer.valueOf(i))) == null || set2.contains(Integer.valueOf(i2)))) {
            return FacebookRequestError.Category.LOGIN_RECOVERABLE;
        }
        Map<Integer, Set<Integer>> map3 = this.f1948b;
        if (map3 != null && map3.containsKey(Integer.valueOf(i)) && ((set = this.f1948b.get(Integer.valueOf(i))) == null || set.contains(Integer.valueOf(i2)))) {
            return FacebookRequestError.Category.TRANSIENT;
        }
        return FacebookRequestError.Category.OTHER;
    }

    /* renamed from: a */
    public static synchronized FacebookRequestErrorClassification m10716a() {
        FacebookRequestErrorClassification facebookRequestErrorClassification;
        synchronized (FacebookRequestErrorClassification.class) {
            if (f1946g == null) {
                f1946g = m10711b();
            }
            facebookRequestErrorClassification = f1946g;
        }
        return facebookRequestErrorClassification;
    }

    /* renamed from: b */
    private static FacebookRequestErrorClassification m10711b() {
        return new FacebookRequestErrorClassification(null, new HashMap<Integer, Set<Integer>>() { // from class: com.facebook.internal.FacebookRequestErrorClassification$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                put(2, null);
                put(4, null);
                put(9, null);
                put(17, null);
                put(341, null);
            }
        }, new HashMap<Integer, Set<Integer>>() { // from class: com.facebook.internal.FacebookRequestErrorClassification$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                put(102, null);
                put(190, null);
                put(412, null);
            }
        }, null, null, null);
    }

    /* renamed from: a */
    private static Map<Integer, Set<Integer>> m10712a(JSONObject jSONObject) {
        int optInt;
        HashSet hashSet;
        JSONArray optJSONArray = jSONObject.optJSONArray("items");
        if (optJSONArray.length() == 0) {
            return null;
        }
        HashMap hashMap = new HashMap();
        for (int i = 0; i < optJSONArray.length(); i++) {
            JSONObject optJSONObject = optJSONArray.optJSONObject(i);
            if (optJSONObject != null && (optInt = optJSONObject.optInt("code")) != 0) {
                JSONArray optJSONArray2 = optJSONObject.optJSONArray("subcodes");
                if (optJSONArray2 == null || optJSONArray2.length() <= 0) {
                    hashSet = null;
                } else {
                    hashSet = new HashSet();
                    for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                        int optInt2 = optJSONArray2.optInt(i2);
                        if (optInt2 != 0) {
                            hashSet.add(Integer.valueOf(optInt2));
                        }
                    }
                }
                hashMap.put(Integer.valueOf(optInt), hashSet);
            }
        }
        return hashMap;
    }

    /* renamed from: a */
    public static FacebookRequestErrorClassification m10713a(JSONArray jSONArray) {
        String optString;
        if (jSONArray == null) {
            return null;
        }
        Map<Integer, Set<Integer>> map = null;
        Map<Integer, Set<Integer>> map2 = null;
        Map<Integer, Set<Integer>> map3 = null;
        String str = null;
        String str2 = null;
        String str3 = null;
        for (int i = 0; i < jSONArray.length(); i++) {
            JSONObject optJSONObject = jSONArray.optJSONObject(i);
            if (optJSONObject != null && (optString = optJSONObject.optString("name")) != null) {
                if (optString.equalsIgnoreCase("other")) {
                    str = optJSONObject.optString("recovery_message", null);
                    map = m10712a(optJSONObject);
                } else if (optString.equalsIgnoreCase("transient")) {
                    str2 = optJSONObject.optString("recovery_message", null);
                    map2 = m10712a(optJSONObject);
                } else if (optString.equalsIgnoreCase("login_recoverable")) {
                    str3 = optJSONObject.optString("recovery_message", null);
                    map3 = m10712a(optJSONObject);
                }
            }
        }
        return new FacebookRequestErrorClassification(map, map2, map3, str, str2, str3);
    }
}
