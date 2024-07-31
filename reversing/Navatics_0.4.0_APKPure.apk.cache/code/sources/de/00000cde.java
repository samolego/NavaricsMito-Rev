package com.facebook.appevents.codeless.internal;

import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: ParameterComponent.java */
/* renamed from: com.facebook.appevents.codeless.internal.a, reason: use source file name */
/* loaded from: classes.dex */
public final class ParameterComponent {

    /* renamed from: a */
    public final String f1693a;

    /* renamed from: b */
    public final String f1694b;

    /* renamed from: c */
    public final List<PathComponent> f1695c;

    /* renamed from: d */
    public final String f1696d;

    public ParameterComponent(JSONObject jSONObject) throws JSONException {
        this.f1693a = jSONObject.getString("name");
        this.f1694b = jSONObject.optString("value");
        ArrayList arrayList = new ArrayList();
        JSONArray optJSONArray = jSONObject.optJSONArray("path");
        if (optJSONArray != null) {
            for (int i = 0; i < optJSONArray.length(); i++) {
                arrayList.add(new PathComponent(optJSONArray.getJSONObject(i)));
            }
        }
        this.f1695c = arrayList;
        this.f1696d = jSONObject.optString("path_type", "absolute");
    }
}