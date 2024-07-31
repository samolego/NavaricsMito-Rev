package com.navatics.app.framework.user;

import com.google.gson.Gson;
import com.navatics.app.framework.Settings;
import org.apache.log4j.C3044k;

/* loaded from: classes.dex */
public class LastUserInfo {
    private static final C3044k logger = C3044k.m1564a(LastUserInfo.class);
    String email;
    String encryptedPwd;
    long lastUpdateTime;

    public LastUserInfo() {
    }

    public LastUserInfo(String str, String str2, long j) {
        this.email = str;
        this.encryptedPwd = str2;
        this.lastUpdateTime = j;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String str) {
        this.email = str;
    }

    public String getEncryptedPwd() {
        return this.encryptedPwd;
    }

    public void setEncryptedPwd(String str) {
        this.encryptedPwd = str;
    }

    public long getLastUpdateTime() {
        return this.lastUpdateTime;
    }

    public void setLastUpdateTime(long j) {
        this.lastUpdateTime = j;
    }

    public String toString() {
        return "LastUserInfo{email='" + this.email + "', encryptedPwd='" + this.encryptedPwd + "', lastUpdateTime=" + this.lastUpdateTime + '}';
    }

    public void save() {
        boolean m8614a = Settings.m8618a().m8614a("user.last_login_user_info", new Gson().toJson(this));
        C3044k c3044k = logger;
        c3044k.mo1511a((Object) ("LastUserInfo save done : " + m8614a));
    }
}
