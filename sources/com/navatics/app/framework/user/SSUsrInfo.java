package com.navatics.app.framework.user;

import com.navatics.app.framework.Navatics;
import io.objectbox.Box;
import io.objectbox.annotation.Entity;
import io.objectbox.annotation.InterfaceC2825Id;

@Entity
/* loaded from: classes.dex */
public class SSUsrInfo {
    public String accessToken;
    public String expiresIn;
    @InterfaceC2825Id

    /* renamed from: id */
    long f4828id;
    public String openid;
    public String refreshToken;
    public String scope;
    public String tokenType;
    public String uuid;

    public SSUsrInfo() {
    }

    public SSUsrInfo(long j, String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        this.f4828id = j;
        this.openid = str;
        this.uuid = str2;
        this.accessToken = str3;
        this.expiresIn = str4;
        this.tokenType = str5;
        this.scope = str6;
        this.refreshToken = str7;
    }

    public long getId() {
        return this.f4828id;
    }

    public void setId(long j) {
        this.f4828id = j;
    }

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

    public String getAccessToken() {
        return this.accessToken;
    }

    public void setAccessToken(String str) {
        this.accessToken = str;
    }

    public String getExpiresIn() {
        return this.expiresIn;
    }

    public void setExpiresIn(String str) {
        this.expiresIn = str;
    }

    public String getTokenType() {
        return this.tokenType;
    }

    public void setTokenType(String str) {
        this.tokenType = str;
    }

    public String getScope() {
        return this.scope;
    }

    public void setScope(String str) {
        this.scope = str;
    }

    public String getRefreshToken() {
        return this.refreshToken;
    }

    public void setRefreshToken(String str) {
        this.refreshToken = str;
    }

    public void save() {
        Navatics.m7933f().m3474d(SSUsrInfo.class).m3421b((Box) this);
    }

    public void deleteFromDb() {
        Navatics.m7933f().m3474d(SSUsrInfo.class).m3424b(this.f4828id);
    }

    public static void deleteFromDb(long j) {
        Navatics.m7933f().m3474d(SSUsrInfo.class).m3424b(j);
    }

    public String toString() {
        return "SSUsrInfo{id=" + this.f4828id + ", openid='" + this.openid + "', uuid='" + this.uuid + "', accessToken='" + this.accessToken + "', expiresIn='" + this.expiresIn + "', tokenType='" + this.tokenType + "', scope='" + this.scope + "', refreshToken='" + this.refreshToken + "'}";
    }
}
