package com.tencent.wxop.stat.event;

import java.util.Properties;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.tencent.wxop.stat.event.c */
/* loaded from: classes2.dex */
public class C2580c {

    /* renamed from: a */
    public String f8105a;

    /* renamed from: b */
    public JSONArray f8106b;

    /* renamed from: c */
    public JSONObject f8107c;

    public C2580c() {
        this.f8107c = null;
    }

    public C2580c(String str, String[] strArr, Properties properties) {
        JSONObject jSONObject;
        this.f8107c = null;
        this.f8105a = str;
        if (properties != null) {
            jSONObject = new JSONObject(properties);
        } else if (strArr != null) {
            this.f8106b = new JSONArray();
            for (String str2 : strArr) {
                this.f8106b.put(str2);
            }
            return;
        } else {
            jSONObject = new JSONObject();
        }
        this.f8107c = jSONObject;
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        if (obj instanceof C2580c) {
            return toString().equals(((C2580c) obj).toString());
        }
        return false;
    }

    public int hashCode() {
        return toString().hashCode();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(32);
        sb.append(this.f8105a);
        sb.append(",");
        JSONArray jSONArray = this.f8106b;
        if (jSONArray != null) {
            sb.append(jSONArray.toString());
        }
        JSONObject jSONObject = this.f8107c;
        if (jSONObject != null) {
            sb.append(jSONObject.toString());
        }
        return sb.toString();
    }
}
