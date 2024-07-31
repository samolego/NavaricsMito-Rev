package com.facebook.share.internal;

import android.support.annotation.Nullable;
import com.facebook.share.model.ShareOpenGraphAction;
import com.facebook.share.model.ShareOpenGraphObject;
import com.facebook.share.model.SharePhoto;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.facebook.share.internal.h */
/* loaded from: classes.dex */
public final class OpenGraphJSONUtility {

    /* compiled from: OpenGraphJSONUtility.java */
    /* renamed from: com.facebook.share.internal.h$a */
    /* loaded from: classes.dex */
    public interface InterfaceC1078a {
        /* renamed from: a */
        JSONObject mo9931a(SharePhoto sharePhoto);
    }

    /* renamed from: a */
    public static JSONObject m10025a(ShareOpenGraphAction shareOpenGraphAction, InterfaceC1078a interfaceC1078a) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        for (String str : shareOpenGraphAction.m9806c()) {
            jSONObject.put(str, m10023a(shareOpenGraphAction.m9809a(str), interfaceC1078a));
        }
        return jSONObject;
    }

    /* renamed from: a */
    private static JSONObject m10024a(ShareOpenGraphObject shareOpenGraphObject, InterfaceC1078a interfaceC1078a) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        for (String str : shareOpenGraphObject.m9806c()) {
            jSONObject.put(str, m10023a(shareOpenGraphObject.m9809a(str), interfaceC1078a));
        }
        return jSONObject;
    }

    /* renamed from: a */
    private static JSONArray m10022a(List list, InterfaceC1078a interfaceC1078a) throws JSONException {
        JSONArray jSONArray = new JSONArray();
        for (Object obj : list) {
            jSONArray.put(m10023a(obj, interfaceC1078a));
        }
        return jSONArray;
    }

    /* renamed from: a */
    public static Object m10023a(@Nullable Object obj, InterfaceC1078a interfaceC1078a) throws JSONException {
        if (obj == null) {
            return JSONObject.NULL;
        }
        if ((obj instanceof String) || (obj instanceof Boolean) || (obj instanceof Double) || (obj instanceof Float) || (obj instanceof Integer) || (obj instanceof Long)) {
            return obj;
        }
        if (obj instanceof SharePhoto) {
            if (interfaceC1078a != null) {
                return interfaceC1078a.mo9931a((SharePhoto) obj);
            }
            return null;
        } else if (obj instanceof ShareOpenGraphObject) {
            return m10024a((ShareOpenGraphObject) obj, interfaceC1078a);
        } else {
            if (obj instanceof List) {
                return m10022a((List) obj, interfaceC1078a);
            }
            throw new IllegalArgumentException("Invalid object found for JSON serialization: " + obj.toString());
        }
    }
}
