package com.facebook.appevents.codeless.internal;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class EventBinding {

    /* renamed from: a */
    private final String f1666a;

    /* renamed from: b */
    private final MappingMethod f1667b;

    /* renamed from: c */
    private final ActionType f1668c;

    /* renamed from: d */
    private final String f1669d;

    /* renamed from: e */
    private final List<PathComponent> f1670e;

    /* renamed from: f */
    private final List<ParameterComponent> f1671f;

    /* renamed from: g */
    private final String f1672g;

    /* renamed from: h */
    private final String f1673h;

    /* renamed from: i */
    private final String f1674i;

    /* loaded from: classes.dex */
    public enum ActionType {
        CLICK,
        SELECTED,
        TEXT_CHANGED
    }

    /* loaded from: classes.dex */
    public enum MappingMethod {
        MANUAL,
        INFERENCE
    }

    public EventBinding(String str, MappingMethod mappingMethod, ActionType actionType, String str2, List<PathComponent> list, List<ParameterComponent> list2, String str3, String str4, String str5) {
        this.f1666a = str;
        this.f1667b = mappingMethod;
        this.f1668c = actionType;
        this.f1669d = str2;
        this.f1670e = list;
        this.f1671f = list2;
        this.f1672g = str3;
        this.f1673h = str4;
        this.f1674i = str5;
    }

    /* renamed from: a */
    public static List<EventBinding> m11123a(JSONArray jSONArray) {
        int length;
        ArrayList arrayList = new ArrayList();
        if (jSONArray != null) {
            try {
                length = jSONArray.length();
            } catch (IllegalArgumentException | JSONException unused) {
            }
        } else {
            length = 0;
        }
        for (int i = 0; i < length; i++) {
            arrayList.add(m11122a(jSONArray.getJSONObject(i)));
        }
        return arrayList;
    }

    /* renamed from: a */
    public static EventBinding m11122a(JSONObject jSONObject) throws JSONException, IllegalArgumentException {
        String string = jSONObject.getString("event_name");
        MappingMethod valueOf = MappingMethod.valueOf(jSONObject.getString("method").toUpperCase(Locale.ENGLISH));
        ActionType valueOf2 = ActionType.valueOf(jSONObject.getString("event_type").toUpperCase(Locale.ENGLISH));
        String string2 = jSONObject.getString("app_version");
        JSONArray jSONArray = jSONObject.getJSONArray("path");
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < jSONArray.length(); i++) {
            arrayList.add(new PathComponent(jSONArray.getJSONObject(i)));
        }
        String optString = jSONObject.optString("path_type", "absolute");
        JSONArray optJSONArray = jSONObject.optJSONArray("parameters");
        ArrayList arrayList2 = new ArrayList();
        if (optJSONArray != null) {
            for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                arrayList2.add(new ParameterComponent(optJSONArray.getJSONObject(i2)));
            }
        }
        return new EventBinding(string, valueOf, valueOf2, string2, arrayList, arrayList2, jSONObject.optString("component_id"), optString, jSONObject.optString("activity_name"));
    }

    /* renamed from: a */
    public List<PathComponent> m11124a() {
        return Collections.unmodifiableList(this.f1670e);
    }

    /* renamed from: b */
    public List<ParameterComponent> m11121b() {
        return Collections.unmodifiableList(this.f1671f);
    }

    /* renamed from: c */
    public String m11120c() {
        return this.f1666a;
    }

    /* renamed from: d */
    public String m11119d() {
        return this.f1674i;
    }
}
