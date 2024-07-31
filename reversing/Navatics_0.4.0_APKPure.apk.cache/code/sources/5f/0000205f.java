package com.tencent.wxop.stat;

import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class NetworkMonitor {

    /* renamed from: a */
    private long f7861a = 0;

    /* renamed from: b */
    private int f7862b = 0;

    /* renamed from: c */
    private String f7863c = "";

    /* renamed from: d */
    private int f7864d = 0;

    /* renamed from: e */
    private String f7865e = "";

    public String getDomain() {
        return this.f7863c;
    }

    public long getMillisecondsConsume() {
        return this.f7861a;
    }

    public int getPort() {
        return this.f7864d;
    }

    public String getRemoteIp() {
        return this.f7865e;
    }

    public int getStatusCode() {
        return this.f7862b;
    }

    public void setDomain(String str) {
        this.f7863c = str;
    }

    public void setMillisecondsConsume(long j) {
        this.f7861a = j;
    }

    public void setPort(int i) {
        this.f7864d = i;
    }

    public void setRemoteIp(String str) {
        this.f7865e = str;
    }

    public void setStatusCode(int i) {
        this.f7862b = i;
    }

    public JSONObject toJSONObject() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("tm", this.f7861a);
            jSONObject.put("st", this.f7862b);
            if (this.f7863c != null) {
                jSONObject.put("dm", this.f7863c);
            }
            jSONObject.put("pt", this.f7864d);
            if (this.f7865e != null) {
                jSONObject.put("rip", this.f7865e);
            }
            jSONObject.put("ts", System.currentTimeMillis() / 1000);
        } catch (JSONException unused) {
        }
        return jSONObject;
    }
}