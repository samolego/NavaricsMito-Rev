package com.senseplay.sdk.model.account;

/* loaded from: classes2.dex */
public class SPAccountInfo {
    private String avatar;
    private String client_id;
    private String nickname;
    private String openid;
    private String sex;
    private String userid;

    public String getOpenid() {
        return this.openid;
    }

    public void setOpenid(String str) {
        this.openid = str;
    }

    public String getClient_id() {
        return this.client_id;
    }

    public void setClient_id(String str) {
        this.client_id = str;
    }

    public String getUserid() {
        return this.userid;
    }

    public void setUserid(String str) {
        this.userid = str;
    }

    public String getNickname() {
        return this.nickname;
    }

    public void setNickname(String str) {
        this.nickname = str;
    }

    public String getAvatar() {
        return this.avatar;
    }

    public void setAvatar(String str) {
        this.avatar = str;
    }

    public String getSex() {
        return this.sex;
    }

    public void setSex(String str) {
        this.sex = str;
    }
}