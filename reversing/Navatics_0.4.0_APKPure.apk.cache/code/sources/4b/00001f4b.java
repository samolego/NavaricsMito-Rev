package com.tencent.p060a.p061a.p062a.p063a;

import android.util.Log;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.tencent.a.a.a.a.c */
/* loaded from: classes2.dex */
public final class C2298c {

    /* renamed from: a */
    String f7149a = null;

    /* renamed from: b */
    String f7150b = null;

    /* renamed from: c */
    String f7151c = "0";

    /* renamed from: d */
    long f7152d = 0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public static C2298c m7282a(String str) {
        C2298c c2298c = new C2298c();
        if (C2303h.m7295a(str)) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                if (!jSONObject.isNull("ui")) {
                    c2298c.f7149a = jSONObject.getString("ui");
                }
                if (!jSONObject.isNull("mc")) {
                    c2298c.f7150b = jSONObject.getString("mc");
                }
                if (!jSONObject.isNull("mid")) {
                    c2298c.f7151c = jSONObject.getString("mid");
                }
                if (!jSONObject.isNull("ts")) {
                    c2298c.f7152d = jSONObject.getLong("ts");
                }
            } catch (JSONException e) {
                Log.w("MID", e);
            }
        }
        return c2298c;
    }

    /* renamed from: b */
    private JSONObject m7283b() {
        JSONObject jSONObject = new JSONObject();
        try {
            C2303h.m7293a(jSONObject, "ui", this.f7149a);
            C2303h.m7293a(jSONObject, "mc", this.f7150b);
            C2303h.m7293a(jSONObject, "mid", this.f7151c);
            jSONObject.put("ts", this.f7152d);
        } catch (JSONException e) {
            Log.w("MID", e);
        }
        return jSONObject;
    }

    /* renamed from: a */
    public final String m7284a() {
        return this.f7151c;
    }

    public final String toString() {
        return m7283b().toString();
    }
}