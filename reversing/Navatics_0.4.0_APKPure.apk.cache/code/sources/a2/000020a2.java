package com.tencent.wxop.stat.event;

import java.util.Properties;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.tencent.wxop.stat.event.c */
/* loaded from: classes2.dex */
public class C2452c {

    /* renamed from: a */
    public String f8143a;

    /* renamed from: b */
    public JSONArray f8144b;

    /* renamed from: c */
    public JSONObject f8145c;

    public C2452c() {
        this.f8145c = null;
    }

    public C2452c(String str, String[] strArr, Properties properties) {
        JSONObject jSONObject;
        this.f8145c = null;
        this.f8143a = str;
        if (properties != null) {
            jSONObject = new JSONObject(properties);
        } else {
            if (strArr != null) {
                this.f8144b = new JSONArray();
                for (String str2 : strArr) {
                    this.f8144b.put(str2);
                }
                return;
            }
            jSONObject = new JSONObject();
        }
        this.f8145c = jSONObject;
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        if (obj instanceof C2452c) {
            return toString().equals(((C2452c) obj).toString());
        }
        return false;
    }

    public int hashCode() {
        return toString().hashCode();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(32);
        sb.append(this.f8143a);
        sb.append(",");
        JSONArray jSONArray = this.f8144b;
        if (jSONArray != null) {
            sb.append(jSONArray.toString());
        }
        JSONObject jSONObject = this.f8145c;
        if (jSONObject != null) {
            sb.append(jSONObject.toString());
        }
        return sb.toString();
    }
}