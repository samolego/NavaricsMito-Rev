package com.facebook.appevents.codeless.internal;

import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public final class PathComponent {

    /* renamed from: a */
    public final String f1683a;

    /* renamed from: b */
    public final int f1684b;

    /* renamed from: c */
    public final int f1685c;

    /* renamed from: d */
    public final String f1686d;

    /* renamed from: e */
    public final String f1687e;

    /* renamed from: f */
    public final String f1688f;

    /* renamed from: g */
    public final String f1689g;

    /* renamed from: h */
    public final int f1690h;

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
        this.f1683a = jSONObject.getString("class_name");
        this.f1684b = jSONObject.optInt("index", -1);
        this.f1685c = jSONObject.optInt("id");
        this.f1686d = jSONObject.optString("text");
        this.f1687e = jSONObject.optString("tag");
        this.f1688f = jSONObject.optString("description");
        this.f1689g = jSONObject.optString("hint");
        this.f1690h = jSONObject.optInt("match_bitmask");
    }
}