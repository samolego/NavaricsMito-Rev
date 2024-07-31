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

/* renamed from: com.facebook.internal.c */
/* loaded from: classes.dex */
public class BundleJSONConverter {

    /* renamed from: a */
    private static final Map<Class<?>, InterfaceC0949a> f1938a = new HashMap();

    /* compiled from: BundleJSONConverter.java */
    /* renamed from: com.facebook.internal.c$a */
    /* loaded from: classes.dex */
    public interface InterfaceC0949a {
        /* renamed from: a */
        void mo10738a(Bundle bundle, String str, Object obj) throws JSONException;

        /* renamed from: a */
        void mo10737a(JSONObject jSONObject, String str, Object obj) throws JSONException;
    }

    static {
        f1938a.put(Boolean.class, new InterfaceC0949a() { // from class: com.facebook.internal.c.1
            @Override // com.facebook.internal.BundleJSONConverter.InterfaceC0949a
            /* renamed from: a */
            public void mo10738a(Bundle bundle, String str, Object obj) throws JSONException {
                bundle.putBoolean(str, ((Boolean) obj).booleanValue());
            }

            @Override // com.facebook.internal.BundleJSONConverter.InterfaceC0949a
            /* renamed from: a */
            public void mo10737a(JSONObject jSONObject, String str, Object obj) throws JSONException {
                jSONObject.put(str, obj);
            }
        });
        f1938a.put(Integer.class, new InterfaceC0949a() { // from class: com.facebook.internal.c.2
            @Override // com.facebook.internal.BundleJSONConverter.InterfaceC0949a
            /* renamed from: a */
            public void mo10738a(Bundle bundle, String str, Object obj) throws JSONException {
                bundle.putInt(str, ((Integer) obj).intValue());
            }

            @Override // com.facebook.internal.BundleJSONConverter.InterfaceC0949a
            /* renamed from: a */
            public void mo10737a(JSONObject jSONObject, String str, Object obj) throws JSONException {
                jSONObject.put(str, obj);
            }
        });
        f1938a.put(Long.class, new InterfaceC0949a() { // from class: com.facebook.internal.c.3
            @Override // com.facebook.internal.BundleJSONConverter.InterfaceC0949a
            /* renamed from: a */
            public void mo10738a(Bundle bundle, String str, Object obj) throws JSONException {
                bundle.putLong(str, ((Long) obj).longValue());
            }

            @Override // com.facebook.internal.BundleJSONConverter.InterfaceC0949a
            /* renamed from: a */
            public void mo10737a(JSONObject jSONObject, String str, Object obj) throws JSONException {
                jSONObject.put(str, obj);
            }
        });
        f1938a.put(Double.class, new InterfaceC0949a() { // from class: com.facebook.internal.c.4
            @Override // com.facebook.internal.BundleJSONConverter.InterfaceC0949a
            /* renamed from: a */
            public void mo10738a(Bundle bundle, String str, Object obj) throws JSONException {
                bundle.putDouble(str, ((Double) obj).doubleValue());
            }

            @Override // com.facebook.internal.BundleJSONConverter.InterfaceC0949a
            /* renamed from: a */
            public void mo10737a(JSONObject jSONObject, String str, Object obj) throws JSONException {
                jSONObject.put(str, obj);
            }
        });
        f1938a.put(String.class, new InterfaceC0949a() { // from class: com.facebook.internal.c.5
            @Override // com.facebook.internal.BundleJSONConverter.InterfaceC0949a
            /* renamed from: a */
            public void mo10738a(Bundle bundle, String str, Object obj) throws JSONException {
                bundle.putString(str, (String) obj);
            }

            @Override // com.facebook.internal.BundleJSONConverter.InterfaceC0949a
            /* renamed from: a */
            public void mo10737a(JSONObject jSONObject, String str, Object obj) throws JSONException {
                jSONObject.put(str, obj);
            }
        });
        f1938a.put(String[].class, new InterfaceC0949a() { // from class: com.facebook.internal.c.6
            @Override // com.facebook.internal.BundleJSONConverter.InterfaceC0949a
            /* renamed from: a */
            public void mo10738a(Bundle bundle, String str, Object obj) throws JSONException {
                throw new IllegalArgumentException("Unexpected type from JSON");
            }

            @Override // com.facebook.internal.BundleJSONConverter.InterfaceC0949a
            /* renamed from: a */
            public void mo10737a(JSONObject jSONObject, String str, Object obj) throws JSONException {
                JSONArray jSONArray = new JSONArray();
                for (String str2 : (String[]) obj) {
                    jSONArray.put(str2);
                }
                jSONObject.put(str, jSONArray);
            }
        });
        f1938a.put(JSONArray.class, new InterfaceC0949a() { // from class: com.facebook.internal.c.7
            @Override // com.facebook.internal.BundleJSONConverter.InterfaceC0949a
            /* renamed from: a */
            public void mo10738a(Bundle bundle, String str, Object obj) throws JSONException {
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

            @Override // com.facebook.internal.BundleJSONConverter.InterfaceC0949a
            /* renamed from: a */
            public void mo10737a(JSONObject jSONObject, String str, Object obj) throws JSONException {
                throw new IllegalArgumentException("JSONArray's are not supported in bundles.");
            }
        });
    }

    /* renamed from: a */
    public static JSONObject m10740a(Bundle bundle) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        for (String str : bundle.keySet()) {
            Object obj = bundle.get(str);
            if (obj != null) {
                if (obj instanceof List) {
                    JSONArray jSONArray = new JSONArray();
                    for (String str2 : (List) obj) {
                        jSONArray.put(str2);
                    }
                    jSONObject.put(str, jSONArray);
                } else if (obj instanceof Bundle) {
                    jSONObject.put(str, m10740a((Bundle) obj));
                } else {
                    InterfaceC0949a interfaceC0949a = f1938a.get(obj.getClass());
                    if (interfaceC0949a == null) {
                        throw new IllegalArgumentException("Unsupported type: " + obj.getClass());
                    }
                    interfaceC0949a.mo10737a(jSONObject, str, obj);
                }
            }
        }
        return jSONObject;
    }

    /* renamed from: a */
    public static Bundle m10739a(JSONObject jSONObject) throws JSONException {
        Bundle bundle = new Bundle();
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            Object obj = jSONObject.get(next);
            if (obj != null && obj != JSONObject.NULL) {
                if (obj instanceof JSONObject) {
                    bundle.putBundle(next, m10739a((JSONObject) obj));
                } else {
                    InterfaceC0949a interfaceC0949a = f1938a.get(obj.getClass());
                    if (interfaceC0949a == null) {
                        throw new IllegalArgumentException("Unsupported type: " + obj.getClass());
                    }
                    interfaceC0949a.mo10738a(bundle, next, obj);
                }
            }
        }
        return bundle;
    }
}
