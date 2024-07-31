package com.tencent.wxop.stat;

import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class NetworkMonitor {

    /* renamed from: a */
    private long f7823a = 0;

    /* renamed from: b */
    private int f7824b = 0;

    /* renamed from: c */
    private String f7825c = "";

    /* renamed from: d */
    private int f7826d = 0;

    /* renamed from: e */
    private String f7827e = "";

    public String getDomain() {
        return this.f7825c;
    }

    public long getMillisecondsConsume() {
        return this.f7823a;
    }

    public int getPort() {
        return this.f7826d;
    }

    public String getRemoteIp() {
        return this.f7827e;
    }

    public int getStatusCode() {
        return this.f7824b;
    }

    public void setDomain(String str) {
        this.f7825c = str;
    }

    public void setMillisecondsConsume(long j) {
        this.f7823a = j;
    }

    public void setPort(int i) {
        this.f7826d = i;
    }

    public void setRemoteIp(String str) {
        this.f7827e = str;
    }

    public void setStatusCode(int i) {
        this.f7824b = i;
    }

    public JSONObject toJSONObject() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("tm", this.f7823a);
            jSONObject.put("st", this.f7824b);
            if (this.f7825c != null) {
                jSONObject.put("dm", this.f7825c);
            }
            jSONObject.put("pt", this.f7826d);
            if (this.f7827e != null) {
                jSONObject.put("rip", this.f7827e);
            }
            jSONObject.put("ts", System.currentTimeMillis() / 1000);
        } catch (JSONException unused) {
        }
        return jSONObject;
    }
}
