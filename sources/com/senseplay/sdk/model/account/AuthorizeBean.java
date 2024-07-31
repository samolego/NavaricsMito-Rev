package com.senseplay.sdk.model.account;

import java.io.Serializable;

/* loaded from: classes2.dex */
public class AuthorizeBean implements Serializable {
    private String access_token;
    private String expires_in;
    private String openid;
    private String refresh_token;
    private String scope;
    private String token_type;
    private String uuid;

    public String getOpenid() {
        return this.openid;
    }

    public void setOpenid(String str) {
        this.openid = str;
    }

    public String getUuid() {
        return this.uuid;
    }

    public void setUuid(String str) {
        this.uuid = str;
    }

    public String getAccess_token() {
        return this.access_token;
    }

    public void setAccess_token(String str) {
        this.access_token = str;
    }

    public String getExpires_in() {
        return this.expires_in;
    }

    public void setExpires_in(String str) {
        this.expires_in = str;
    }

    public String getToken_type() {
        return this.token_type;
    }

    public void setToken_type(String str) {
        this.token_type = str;
    }

    public String getScope() {
        return this.scope;
    }

    public void setScope(String str) {
        this.scope = str;
    }

    public String getRefresh_token() {
        return this.refresh_token;
    }

    public void setRefresh_token(String str) {
        this.refresh_token = str;
    }
}
