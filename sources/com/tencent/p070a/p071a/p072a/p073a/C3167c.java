package com.tencent.p070a.p071a.p072a.p073a;

import android.util.Log;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.tencent.a.a.a.a.c */
/* loaded from: classes2.dex */
public final class C2396c {

    /* renamed from: a */
    String f7111a = null;

    /* renamed from: b */
    String f7112b = null;

    /* renamed from: c */
    String f7113c = "0";

    /* renamed from: d */
    long f7114d = 0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public static C2396c m5573a(String str) {
        C2396c c2396c = new C2396c();
        if (C2401h.m5560a(str)) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                if (!jSONObject.isNull("ui")) {
                    c2396c.f7111a = jSONObject.getString("ui");
                }
                if (!jSONObject.isNull("mc")) {
                    c2396c.f7112b = jSONObject.getString("mc");
                }
                if (!jSONObject.isNull("mid")) {
                    c2396c.f7113c = jSONObject.getString("mid");
                }
                if (!jSONObject.isNull("ts")) {
                    c2396c.f7114d = jSONObject.getLong("ts");
                }
            } catch (JSONException e) {
                Log.w("MID", e);
            }
        }
        return c2396c;
    }

    /* renamed from: b */
    private JSONObject m5572b() {
        JSONObject jSONObject = new JSONObject();
        try {
            C2401h.m5558a(jSONObject, "ui", this.f7111a);
            C2401h.m5558a(jSONObject, "mc", this.f7112b);
            C2401h.m5558a(jSONObject, "mid", this.f7113c);
            jSONObject.put("ts", this.f7114d);
        } catch (JSONException e) {
            Log.w("MID", e);
        }
        return jSONObject;
    }

    /* renamed from: a */
    public final String m5574a() {
        return this.f7113c;
    }

    public final String toString() {
        return m5572b().toString();
    }
}
