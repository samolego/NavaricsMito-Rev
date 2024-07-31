package com.facebook.appevents.p040b;

import android.support.annotation.Nullable;
import android.support.annotation.RestrictTo;
import android.util.Log;
import com.facebook.FacebookSdk;
import com.facebook.appevents.AppEvent;
import com.facebook.internal.FetchedAppSettings;
import com.facebook.internal.FetchedAppSettingsManager;
import com.facebook.internal.Utility;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* renamed from: com.facebook.appevents.b.b */
/* loaded from: classes.dex */
public final class RestrictiveDataManager {

    /* renamed from: a */
    private static boolean f1554a = false;

    /* renamed from: b */
    private static final String f1555b = RestrictiveDataManager.class.getCanonicalName();

    /* renamed from: c */
    private static List<C0844a> f1556c = new ArrayList();

    /* renamed from: d */
    private static Set<String> f1557d = new HashSet();

    /* renamed from: a */
    public static synchronized void m11245a() {
        synchronized (RestrictiveDataManager.class) {
            f1554a = true;
            m11240b();
        }
    }

    /* renamed from: b */
    private static synchronized void m11240b() {
        FetchedAppSettings m10806a;
        synchronized (RestrictiveDataManager.class) {
            try {
                m10806a = FetchedAppSettingsManager.m10806a(FacebookSdk.m10865l(), false);
            } catch (Exception unused) {
            }
            if (m10806a == null) {
                return;
            }
            String m10679m = m10806a.m10679m();
            if (m10679m == null) {
                return;
            }
            if (!m10679m.isEmpty()) {
                JSONObject jSONObject = new JSONObject(m10679m);
                f1556c.clear();
                f1557d.clear();
                Iterator<String> keys = jSONObject.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    JSONObject jSONObject2 = jSONObject.getJSONObject(next);
                    if (jSONObject2 != null) {
                        if (jSONObject2.optBoolean("is_deprecated_event")) {
                            f1557d.add(next);
                        } else {
                            JSONObject optJSONObject = jSONObject2.optJSONObject("restrictive_param");
                            JSONArray optJSONArray = jSONObject2.optJSONArray("deprecated_param");
                            C0844a c0844a = new C0844a(next, new HashMap(), new ArrayList());
                            if (optJSONObject != null) {
                                c0844a.f1559b = Utility.m10516a(optJSONObject);
                            }
                            if (optJSONArray != null) {
                                c0844a.f1560c = Utility.m10517a(optJSONArray);
                            }
                            f1556c.add(c0844a);
                        }
                    }
                }
            }
        }
    }

    /* renamed from: a */
    public static void m11242a(List<AppEvent> list) {
        if (f1554a) {
            Iterator<AppEvent> it = list.iterator();
            while (it.hasNext()) {
                if (m11244a(it.next().getName())) {
                    it.remove();
                }
            }
        }
    }

    /* renamed from: a */
    public static void m11241a(Map<String, String> map, String str) {
        if (f1554a) {
            HashMap hashMap = new HashMap();
            ArrayList arrayList = new ArrayList(map.keySet());
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                String str2 = (String) it.next();
                String m11243a = m11243a(str, str2);
                if (m11243a != null) {
                    hashMap.put(str2, m11243a);
                    map.remove(str2);
                }
            }
            for (C0844a c0844a : f1556c) {
                if (c0844a.f1558a.equals(str)) {
                    Iterator it2 = arrayList.iterator();
                    while (it2.hasNext()) {
                        String str3 = (String) it2.next();
                        if (c0844a.f1560c.contains(str3)) {
                            map.remove(str3);
                        }
                    }
                }
            }
            if (hashMap.size() > 0) {
                try {
                    JSONObject jSONObject = new JSONObject();
                    for (Map.Entry entry : hashMap.entrySet()) {
                        jSONObject.put((String) entry.getKey(), entry.getValue());
                    }
                    map.put("_restrictedParams", jSONObject.toString());
                } catch (JSONException unused) {
                }
            }
        }
    }

    /* renamed from: a */
    private static boolean m11244a(String str) {
        return f1557d.contains(str);
    }

    @Nullable
    /* renamed from: a */
    private static String m11243a(String str, String str2) {
        try {
            Iterator it = new ArrayList(f1556c).iterator();
            while (it.hasNext()) {
                C0844a c0844a = (C0844a) it.next();
                if (c0844a != null && str.equals(c0844a.f1558a)) {
                    for (String str3 : c0844a.f1559b.keySet()) {
                        if (str2.equals(str3)) {
                            return c0844a.f1559b.get(str3);
                        }
                    }
                    continue;
                }
            }
            return null;
        } catch (Exception e) {
            Log.w(f1555b, "getMatchedRuleType failed", e);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: RestrictiveDataManager.java */
    /* renamed from: com.facebook.appevents.b.b$a */
    /* loaded from: classes.dex */
    public static class C0844a {

        /* renamed from: a */
        String f1558a;

        /* renamed from: b */
        Map<String, String> f1559b;

        /* renamed from: c */
        List<String> f1560c;

        C0844a(String str, Map<String, String> map, List<String> list) {
            this.f1558a = str;
            this.f1559b = map;
            this.f1560c = list;
        }
    }
}
