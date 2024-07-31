package com.tencent.wxop.stat;

import com.navatics.app.framework.network.p056a.ConnectionUtils;
import com.tencent.wxop.stat.common.C2569l;
import com.tencent.wxop.stat.common.C2575r;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class StatAccount {
    public static final int CUSTOM_TYPE = 7;
    public static final int DEFAULT_TYPE = 0;
    public static final int EMAIL_TYPE = 6;
    public static final int PHONE_NUM_TYPE = 5;
    public static final int QQ_NUM_TYPE = 1;
    public static final int QQ_OPENID_TYPE = 3;
    public static final int WECHAT_ID_TYPE = 2;
    public static final int WECHAT_OPENID_TYPE = 4;

    /* renamed from: a */
    private String f7828a;

    /* renamed from: b */
    private int f7829b;

    /* renamed from: c */
    private String f7830c;

    /* renamed from: d */
    private String f7831d;

    public StatAccount(String str) {
        this.f7828a = "";
        this.f7829b = 0;
        this.f7830c = "";
        this.f7831d = "";
        this.f7828a = str;
    }

    public StatAccount(String str, int i) {
        this.f7828a = "";
        this.f7829b = 0;
        this.f7830c = "";
        this.f7831d = "";
        this.f7828a = str;
        this.f7829b = i;
    }

    public String getAccount() {
        return this.f7828a;
    }

    public int getAccountType() {
        return this.f7829b;
    }

    public String getExt() {
        return this.f7830c;
    }

    public String getExt1() {
        return this.f7831d;
    }

    public void setAccount(String str) {
        this.f7828a = str;
    }

    public void setAccountType(int i) {
        this.f7829b = i;
    }

    public void setExt(String str) {
        this.f7830c = str;
    }

    public void setExt1(String str) {
        this.f7831d = str;
    }

    public String toJsonString() {
        JSONObject jSONObject = new JSONObject();
        if (C2569l.m4832c(this.f7828a)) {
            try {
                C2575r.m4787a(jSONObject, ConnectionUtils.f4730a, this.f7828a);
                jSONObject.put("t", this.f7829b);
                C2575r.m4787a(jSONObject, "e", this.f7830c);
                C2575r.m4787a(jSONObject, "e1", this.f7831d);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return jSONObject.toString();
    }

    public String toString() {
        return "StatAccount [account=" + this.f7828a + ", accountType=" + this.f7829b + ", ext=" + this.f7830c + ", ext1=" + this.f7831d + "]";
    }
}
