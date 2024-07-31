package com.facebook.share.internal;

import com.facebook.share.model.CameraEffectArguments;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.facebook.share.internal.a */
/* loaded from: classes.dex */
public class CameraEffectJSONUtility {

    /* renamed from: a */
    private static final Map<Class<?>, InterfaceC1043a> f2297a = new HashMap();

    /* compiled from: CameraEffectJSONUtility.java */
    /* renamed from: com.facebook.share.internal.a$a */
    /* loaded from: classes.dex */
    public interface InterfaceC1043a {
        /* renamed from: a */
        void mo10159a(JSONObject jSONObject, String str, Object obj) throws JSONException;
    }

    static {
        f2297a.put(String.class, new InterfaceC1043a() { // from class: com.facebook.share.internal.a.1
            @Override // com.facebook.share.internal.CameraEffectJSONUtility.InterfaceC1043a
            /* renamed from: a */
            public void mo10159a(JSONObject jSONObject, String str, Object obj) throws JSONException {
                jSONObject.put(str, obj);
            }
        });
        f2297a.put(String[].class, new InterfaceC1043a() { // from class: com.facebook.share.internal.a.2
            @Override // com.facebook.share.internal.CameraEffectJSONUtility.InterfaceC1043a
            /* renamed from: a */
            public void mo10159a(JSONObject jSONObject, String str, Object obj) throws JSONException {
                JSONArray jSONArray = new JSONArray();
                for (String str2 : (String[]) obj) {
                    jSONArray.put(str2);
                }
                jSONObject.put(str, jSONArray);
            }
        });
        f2297a.put(JSONArray.class, new InterfaceC1043a() { // from class: com.facebook.share.internal.a.3
            @Override // com.facebook.share.internal.CameraEffectJSONUtility.InterfaceC1043a
            /* renamed from: a */
            public void mo10159a(JSONObject jSONObject, String str, Object obj) throws JSONException {
                throw new IllegalArgumentException("JSONArray's are not supported in bundles.");
            }
        });
    }

    /* renamed from: a */
    public static JSONObject m10160a(CameraEffectArguments cameraEffectArguments) throws JSONException {
        if (cameraEffectArguments == null) {
            return null;
        }
        JSONObject jSONObject = new JSONObject();
        for (String str : cameraEffectArguments.m9918a()) {
            Object m9916a = cameraEffectArguments.m9916a(str);
            if (m9916a != null) {
                InterfaceC1043a interfaceC1043a = f2297a.get(m9916a.getClass());
                if (interfaceC1043a == null) {
                    throw new IllegalArgumentException("Unsupported type: " + m9916a.getClass());
                }
                interfaceC1043a.mo10159a(jSONObject, str, m9916a);
            }
        }
        return jSONObject;
    }
}
