package com.facebook.appevents.codeless.internal;

import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.facebook.appevents.codeless.internal.a */
/* loaded from: classes.dex */
public final class ParameterComponent {

    /* renamed from: a */
    public final String f1687a;

    /* renamed from: b */
    public final String f1688b;

    /* renamed from: c */
    public final List<PathComponent> f1689c;

    /* renamed from: d */
    public final String f1690d;

    public ParameterComponent(JSONObject jSONObject) throws JSONException {
        this.f1687a = jSONObject.getString("name");
        this.f1688b = jSONObject.optString("value");
        ArrayList arrayList = new ArrayList();
        JSONArray optJSONArray = jSONObject.optJSONArray("path");
        if (optJSONArray != null) {
            for (int i = 0; i < optJSONArray.length(); i++) {
                arrayList.add(new PathComponent(optJSONArray.getJSONObject(i)));
            }
        }
        this.f1689c = arrayList;
        this.f1690d = jSONObject.optString("path_type", "absolute");
    }
}
