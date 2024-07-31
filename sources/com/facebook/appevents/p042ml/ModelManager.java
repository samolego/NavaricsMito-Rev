package com.facebook.appevents.p042ml;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.RestrictTo;
import android.text.TextUtils;
import com.facebook.AccessToken;
import com.facebook.FacebookSdk;
import com.facebook.GraphRequest;
import com.facebook.appevents.p040b.AddressFilterManager;
import com.facebook.appevents.p041c.SuggestedEventsManager;
import com.facebook.internal.FeatureManager;
import com.facebook.internal.Utility;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Locale;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@RestrictTo({RestrictTo.Scope.LIBRARY})
/* renamed from: com.facebook.appevents.ml.b */
/* loaded from: classes.dex */
public final class ModelManager {

    /* renamed from: b */
    private static SharedPreferences f1805b;

    /* renamed from: a */
    private static final ConcurrentMap<String, C0889a> f1804a = new ConcurrentHashMap();

    /* renamed from: c */
    private static final String[] f1806c = {"version_id", "asset_uri", "use_case", "thresholds", "rules_uri"};

    /* renamed from: d */
    static /* synthetic */ JSONObject m10926d() {
        return m10920i();
    }

    /* renamed from: a */
    public static void m10935a() {
        m10930b();
    }

    /* renamed from: b */
    public static void m10930b() {
        f1805b = FacebookSdk.m10869h().getSharedPreferences("com.facebook.internal.MODEL_STORE", 0);
        m10921h();
    }

    /* renamed from: h */
    private static void m10921h() {
        Utility.m10531a(new Runnable() { // from class: com.facebook.appevents.ml.b.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    JSONObject m10926d = ModelManager.m10926d();
                    if (m10926d != null) {
                        ModelManager.f1805b.edit().putString("models", m10926d.toString()).apply();
                    } else {
                        m10926d = new JSONObject(ModelManager.f1805b.getString("models", ""));
                    }
                    ModelManager.m10929b(m10926d);
                    ModelManager.m10919j();
                    ModelManager.m10928c();
                } catch (Exception unused) {
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public static void m10929b(JSONObject jSONObject) {
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            try {
                String next = keys.next();
                C0889a m10925d = m10925d(jSONObject.getJSONObject(next));
                if (m10925d != null) {
                    f1804a.put(next, m10925d);
                }
            } catch (JSONException unused) {
                return;
            }
        }
    }

    /* renamed from: c */
    private static JSONObject m10927c(JSONObject jSONObject) {
        JSONObject jSONObject2 = new JSONObject();
        try {
            JSONArray jSONArray = jSONObject.getJSONArray("data");
            for (int i = 0; i < jSONArray.length(); i++) {
                JSONObject jSONObject3 = jSONArray.getJSONObject(i);
                JSONObject jSONObject4 = new JSONObject();
                jSONObject4.put("version_id", jSONObject3.getString("version_id"));
                jSONObject4.put("use_case", jSONObject3.getString("use_case"));
                jSONObject4.put("thresholds", jSONObject3.getJSONArray("thresholds"));
                jSONObject4.put("asset_uri", jSONObject3.getString("asset_uri"));
                if (jSONObject3.has("rules_uri")) {
                    jSONObject4.put("rules_uri", jSONObject3.getString("rules_uri"));
                }
                jSONObject2.put(jSONObject3.getString("use_case"), jSONObject4);
            }
            return jSONObject2;
        } catch (JSONException unused) {
            return new JSONObject();
        }
    }

    @Nullable
    /* renamed from: i */
    private static JSONObject m10920i() {
        ArrayList arrayList = new ArrayList(Arrays.asList(f1806c));
        Bundle bundle = new Bundle();
        bundle.putString("fields", TextUtils.join(",", arrayList));
        GraphRequest m11395a = GraphRequest.m11395a((AccessToken) null, String.format("%s/model_asset", FacebookSdk.m10865l()), (GraphRequest.InterfaceC0829b) null);
        m11395a.m11373a(true);
        m11395a.m11397a(bundle);
        JSONObject m10824b = m11395a.m11349i().m10824b();
        if (m10824b == null) {
            return null;
        }
        return m10927c(m10824b);
    }

    @Nullable
    /* renamed from: d */
    private static C0889a m10925d(JSONObject jSONObject) {
        try {
            return new C0889a(jSONObject.getString("use_case"), Integer.parseInt(jSONObject.getString("version_id")), jSONObject.getString("asset_uri"), jSONObject.optString("rules_uri", null), m10932a(jSONObject.getJSONArray("thresholds")));
        } catch (JSONException unused) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: j */
    public static void m10919j() {
        if (f1804a.containsKey("SUGGEST_EVENT")) {
            Locale m10509b = Utility.m10509b();
            if (m10509b == null || m10509b.getLanguage().contains("en")) {
                FeatureManager.m10812a(FeatureManager.Feature.SuggestedEvents, new FeatureManager.InterfaceC0926a() { // from class: com.facebook.appevents.ml.b.2
                    @Override // com.facebook.internal.FeatureManager.InterfaceC0926a
                    /* renamed from: a */
                    public void mo10784a(boolean z) {
                        if (z) {
                            ((C0889a) ModelManager.f1804a.get("SUGGEST_EVENT")).m10946a(new Runnable() { // from class: com.facebook.appevents.ml.b.2.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    SuggestedEventsManager.m11203a();
                                }
                            });
                        }
                    }
                });
            }
        }
    }

    /* renamed from: c */
    public static void m10928c() {
        if (f1804a.containsKey("DATA_DETECTION_ADDRESS")) {
            FeatureManager.m10812a(FeatureManager.Feature.PIIFiltering, new FeatureManager.InterfaceC0926a() { // from class: com.facebook.appevents.ml.b.3
                @Override // com.facebook.internal.FeatureManager.InterfaceC0926a
                /* renamed from: a */
                public void mo10784a(boolean z) {
                    if (z) {
                        ((C0889a) ModelManager.f1804a.get("DATA_DETECTION_ADDRESS")).m10946a(new Runnable() { // from class: com.facebook.appevents.ml.b.3.1
                            @Override // java.lang.Runnable
                            public void run() {
                                AddressFilterManager.m11248a();
                            }
                        });
                    }
                }
            });
        }
    }

    /* renamed from: a */
    private static float[] m10932a(JSONArray jSONArray) {
        float[] fArr = new float[jSONArray.length()];
        for (int i = 0; i < jSONArray.length(); i++) {
            try {
                fArr[i] = Float.parseFloat(jSONArray.getString(i));
            } catch (JSONException unused) {
            }
        }
        return fArr;
    }

    @Nullable
    /* renamed from: a */
    public static String m10933a(String str, float[] fArr, String str2) {
        if (f1804a.containsKey(str)) {
            return f1804a.get(str).m10944a(fArr, str2);
        }
        return null;
    }

    @Nullable
    /* renamed from: a */
    public static File m10934a(String str) {
        if (f1804a.containsKey(str)) {
            return f1804a.get(str).m10949a();
        }
        return null;
    }
}
