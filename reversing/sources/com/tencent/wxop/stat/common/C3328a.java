package com.tencent.wxop.stat.common;

import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.tencent.wxop.stat.common.a */
/* loaded from: classes2.dex */
public class C2558a {

    /* renamed from: a */
    private String f8014a;

    /* renamed from: b */
    private String f8015b;

    /* renamed from: c */
    private String f8016c;

    /* renamed from: d */
    private String f8017d;

    /* renamed from: e */
    private int f8018e;

    /* renamed from: f */
    private int f8019f;

    /* renamed from: g */
    private long f8020g;

    public C2558a() {
        this.f8014a = null;
        this.f8015b = null;
        this.f8016c = null;
        this.f8017d = "0";
        this.f8019f = 0;
        this.f8020g = 0L;
    }

    public C2558a(String str, String str2, int i) {
        this.f8014a = null;
        this.f8015b = null;
        this.f8016c = null;
        this.f8017d = "0";
        this.f8019f = 0;
        this.f8020g = 0L;
        this.f8014a = str;
        this.f8015b = str2;
        this.f8018e = i;
    }

    /* renamed from: a */
    JSONObject m4874a() {
        JSONObject jSONObject = new JSONObject();
        try {
            C2575r.m4787a(jSONObject, "ui", this.f8014a);
            C2575r.m4787a(jSONObject, "mc", this.f8015b);
            C2575r.m4787a(jSONObject, "mid", this.f8017d);
            C2575r.m4787a(jSONObject, "aid", this.f8016c);
            jSONObject.put("ts", this.f8020g);
            jSONObject.put("ver", this.f8019f);
        } catch (JSONException unused) {
        }
        return jSONObject;
    }

    /* renamed from: a */
    public void m4873a(int i) {
        this.f8018e = i;
    }

    /* renamed from: b */
    public String m4872b() {
        return this.f8014a;
    }

    /* renamed from: c */
    public String m4871c() {
        return this.f8015b;
    }

    /* renamed from: d */
    public int m4870d() {
        return this.f8018e;
    }

    public String toString() {
        return m4874a().toString();
    }
}
