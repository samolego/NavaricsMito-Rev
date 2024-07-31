package com.facebook.internal;

import android.os.Bundle;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: BundleJSONConverter.java */
/* renamed from: com.facebook.internal.c, reason: use source file name */
/* loaded from: classes.dex */
public class BundleJSONConverter {

    /* renamed from: a */
    private static final Map<Class<?>, a> f1945a = new HashMap();

    /* compiled from: BundleJSONConverter.java */
    /* renamed from: com.facebook.internal.c$a */
    /* loaded from: classes.dex */
    public interface a {
        /* renamed from: a */
        void mo2229a(Bundle bundle, String str, Object obj) throws JSONException;

        /* renamed from: a */
        void mo2230a(JSONObject jSONObject, String str, Object obj) throws JSONException;
    }

    static {
        f1945a.put(Boolean.class, new a() { // from class: com.facebook.internal.c.1
            @Override // com.facebook.internal.BundleJSONConverter.a
            /* renamed from: a */
            public void mo2229a(Bundle bundle, String str, Object obj) throws JSONException {
                bundle.putBoolean(str, ((Boolean) obj).booleanValue());
            }

            @Override // com.facebook.internal.BundleJSONConverter.a
            /* renamed from: a */
            public void mo2230a(JSONObject jSONObject, String str, Object obj) throws JSONException {
                jSONObject.put(str, obj);
            }
        });
        f1945a.put(Integer.class, new a() { // from class: com.facebook.internal.c.2
            @Override // com.facebook.internal.BundleJSONConverter.a
            /* renamed from: a */
            public void mo2229a(Bundle bundle, String str, Object obj) throws JSONException {
                bundle.putInt(str, ((Integer) obj).intValue());
            }

            @Override // com.facebook.internal.BundleJSONConverter.a
            /* renamed from: a */
            public void mo2230a(JSONObject jSONObject, String str, Object obj) throws JSONException {
                jSONObject.put(str, obj);
            }
        });
        f1945a.put(Long.class, new a() { // from class: com.facebook.internal.c.3
            @Override // com.facebook.internal.BundleJSONConverter.a
            /* renamed from: a */
            public void mo2229a(Bundle bundle, String str, Object obj) throws JSONException {
                bundle.putLong(str, ((Long) obj).longValue());
            }

            @Override // com.facebook.internal.BundleJSONConverter.a
            /* renamed from: a */
            public void mo2230a(JSONObject jSONObject, String str, Object obj) throws JSONException {
                jSONObject.put(str, obj);
            }
        });
        f1945a.put(Double.class, new a() { // from class: com.facebook.internal.c.4
            @Override // com.facebook.internal.BundleJSONConverter.a
            /* renamed from: a */
            public void mo2229a(Bundle bundle, String str, Object obj) throws JSONException {
                bundle.putDouble(str, ((Double) obj).doubleValue());
            }

            @Override // com.facebook.internal.BundleJSONConverter.a
            /* renamed from: a */
            public void mo2230a(JSONObject jSONObject, String str, Object obj) throws JSONException {
                jSONObject.put(str, obj);
            }
        });
        f1945a.put(String.class, new a() { // from class: com.facebook.internal.c.5
            @Override // com.facebook.internal.BundleJSONConverter.a
            /* renamed from: a */
            public void mo2229a(Bundle bundle, String str, Object obj) throws JSONException {
                bundle.putString(str, (String) obj);
            }

            @Override // com.facebook.internal.BundleJSONConverter.a
            /* renamed from: a */
            public void mo2230a(JSONObject jSONObject, String str, Object obj) throws JSONException {
                jSONObject.put(str, obj);
            }
        });
        f1945a.put(String[].class, new a() { // from class: com.facebook.internal.c.6
            @Override // com.facebook.internal.BundleJSONConverter.a
            /* renamed from: a */
            public void mo2229a(Bundle bundle, String str, Object obj) throws JSONException {
                throw new IllegalArgumentException("Unexpected type from JSON");
            }

            @Override // com.facebook.internal.BundleJSONConverter.a
            /* renamed from: a */
            public void mo2230a(JSONObject jSONObject, String str, Object obj) throws JSONException {
                JSONArray jSONArray = new JSONArray();
                for (String str2 : (String[]) obj) {
                    jSONArray.put(str2);
                }
                jSONObject.put(str, jSONArray);
            }
        });
        f1945a.put(JSONArray.class, new a() { // from class: com.facebook.internal.c.7
            @Override // com.facebook.internal.BundleJSONConverter.a
            /* renamed from: a */
            public void mo2229a(Bundle bundle, String str, Object obj) throws JSONException {
                JSONArray jSONArray = (JSONArray) obj;
                ArrayList<String> arrayList = new ArrayList<>();
                if (jSONArray.length() == 0) {
                    bundle.putStringArrayList(str, arrayList);
                    return;
                }
                for (int i = 0; i < jSONArray.length(); i++) {
                    Object obj2 = jSONArray.get(i);
                    if (obj2 instanceof String) {
                        arrayList.add((String) obj2);
                    } else {
                        throw new IllegalArgumentException("Unexpected type in an array: " + obj2.getClass());
                    }
                }
                bundle.putStringArrayList(str, arrayList);
            }

            @Override // com.facebook.internal.BundleJSONConverter.a
            /* renamed from: a */
            public void mo2230a(JSONObject jSONObject, String str, Object obj) throws JSONException {
                throw new IllegalArgumentException("JSONArray's are not supported in bundles.");
            }
        });
    }

    /* renamed from: a */
    public static JSONObject m2228a(Bundle bundle) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        for (String str : bundle.keySet()) {
            Object obj = bundle.get(str);
            if (obj != null) {
                if (obj instanceof List) {
                    JSONArray jSONArray = new JSONArray();
                    Iterator it = ((List) obj).iterator();
                    while (it.hasNext()) {
                        jSONArray.put((String) it.next());
                    }
                    jSONObject.put(str, jSONArray);
                } else if (obj instanceof Bundle) {
                    jSONObject.put(str, m2228a((Bundle) obj));
                } else {
                    a aVar = f1945a.get(obj.getClass());
                    if (aVar == null) {
                        throw new IllegalArgumentException("Unsupported type: " + obj.getClass());
                    }
                    aVar.mo2230a(jSONObject, str, obj);
                }
            }
        }
        return jSONObject;
    }

    /* renamed from: a */
    public static Bundle m2227a(JSONObject jSONObject) throws JSONException {
        Bundle bundle = new Bundle();
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            Object obj = jSONObject.get(next);
            if (obj != null && obj != JSONObject.NULL) {
                if (obj instanceof JSONObject) {
                    bundle.putBundle(next, m2227a((JSONObject) obj));
                } else {
                    a aVar = f1945a.get(obj.getClass());
                    if (aVar == null) {
                        throw new IllegalArgumentException("Unsupported type: " + obj.getClass());
                    }
                    aVar.mo2229a(bundle, next, obj);
                }
            }
        }
        return bundle;
    }
}