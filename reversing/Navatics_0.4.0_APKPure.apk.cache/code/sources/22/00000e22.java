package com.facebook.share.internal;

import com.facebook.share.model.CameraEffectArguments;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: CameraEffectJSONUtility.java */
/* renamed from: com.facebook.share.internal.a, reason: use source file name */
/* loaded from: classes.dex */
public class CameraEffectJSONUtility {

    /* renamed from: a */
    private static final Map<Class<?>, a> f2305a = new HashMap();

    /* compiled from: CameraEffectJSONUtility.java */
    /* renamed from: com.facebook.share.internal.a$a */
    /* loaded from: classes.dex */
    public interface a {
        /* renamed from: a */
        void mo2814a(JSONObject jSONObject, String str, Object obj) throws JSONException;
    }

    static {
        f2305a.put(String.class, new a() { // from class: com.facebook.share.internal.a.1
            @Override // com.facebook.share.internal.CameraEffectJSONUtility.a
            /* renamed from: a */
            public void mo2814a(JSONObject jSONObject, String str, Object obj) throws JSONException {
                jSONObject.put(str, obj);
            }
        });
        f2305a.put(String[].class, new a() { // from class: com.facebook.share.internal.a.2
            @Override // com.facebook.share.internal.CameraEffectJSONUtility.a
            /* renamed from: a */
            public void mo2814a(JSONObject jSONObject, String str, Object obj) throws JSONException {
                JSONArray jSONArray = new JSONArray();
                for (String str2 : (String[]) obj) {
                    jSONArray.put(str2);
                }
                jSONObject.put(str, jSONArray);
            }
        });
        f2305a.put(JSONArray.class, new a() { // from class: com.facebook.share.internal.a.3
            @Override // com.facebook.share.internal.CameraEffectJSONUtility.a
            /* renamed from: a */
            public void mo2814a(JSONObject jSONObject, String str, Object obj) throws JSONException {
                throw new IllegalArgumentException("JSONArray's are not supported in bundles.");
            }
        });
    }

    /* renamed from: a */
    public static JSONObject m2813a(CameraEffectArguments cameraEffectArguments) throws JSONException {
        if (cameraEffectArguments == null) {
            return null;
        }
        JSONObject jSONObject = new JSONObject();
        for (String str : cameraEffectArguments.m3039a()) {
            Object m3038a = cameraEffectArguments.m3038a(str);
            if (m3038a != null) {
                a aVar = f2305a.get(m3038a.getClass());
                if (aVar == null) {
                    throw new IllegalArgumentException("Unsupported type: " + m3038a.getClass());
                }
                aVar.mo2814a(jSONObject, str, m3038a);
            }
        }
        return jSONObject;
    }
}