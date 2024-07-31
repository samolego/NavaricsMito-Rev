package com.facebook.appevents.codeless.internal;

import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public final class PathComponent {

    /* renamed from: a */
    public final String f1677a;

    /* renamed from: b */
    public final int f1678b;

    /* renamed from: c */
    public final int f1679c;

    /* renamed from: d */
    public final String f1680d;

    /* renamed from: e */
    public final String f1681e;

    /* renamed from: f */
    public final String f1682f;

    /* renamed from: g */
    public final String f1683g;

    /* renamed from: h */
    public final int f1684h;

    /* loaded from: classes.dex */
    public enum MatchBitmaskType {
        ID(1),
        TEXT(2),
        TAG(4),
        DESCRIPTION(8),
        HINT(16);
        
        private final int value;

        MatchBitmaskType(int i) {
            this.value = i;
        }

        public int getValue() {
            return this.value;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public PathComponent(JSONObject jSONObject) throws JSONException {
        this.f1677a = jSONObject.getString("class_name");
        this.f1678b = jSONObject.optInt("index", -1);
        this.f1679c = jSONObject.optInt("id");
        this.f1680d = jSONObject.optString("text");
        this.f1681e = jSONObject.optString("tag");
        this.f1682f = jSONObject.optString("description");
        this.f1683g = jSONObject.optString("hint");
        this.f1684h = jSONObject.optInt("match_bitmask");
    }
}
