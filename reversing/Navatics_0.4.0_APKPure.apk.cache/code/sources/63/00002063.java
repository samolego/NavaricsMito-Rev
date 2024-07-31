package com.tencent.wxop.stat;

/* loaded from: classes2.dex */
public class StatGameUser implements Cloneable {

    /* renamed from: a */
    private String f7922a;

    /* renamed from: b */
    private String f7923b;

    /* renamed from: c */
    private String f7924c;

    public StatGameUser() {
        this.f7922a = "";
        this.f7923b = "";
        this.f7924c = "";
    }

    public StatGameUser(String str, String str2, String str3) {
        this.f7922a = "";
        this.f7923b = "";
        this.f7924c = "";
        this.f7923b = str;
        this.f7922a = str2;
        this.f7924c = str3;
    }

    /* renamed from: clone, reason: merged with bridge method [inline-methods] */
    public StatGameUser m12980clone() {
        try {
            return (StatGameUser) super.clone();
        } catch (CloneNotSupportedException unused) {
            return null;
        }
    }

    public String getAccount() {
        return this.f7923b;
    }

    public String getLevel() {
        return this.f7924c;
    }

    public String getWorldName() {
        return this.f7922a;
    }

    public void setAccount(String str) {
        this.f7923b = str;
    }

    public void setLevel(String str) {
        this.f7924c = str;
    }

    public void setWorldName(String str) {
        this.f7922a = str;
    }

    public String toString() {
        return "StatGameUser [worldName=" + this.f7922a + ", account=" + this.f7923b + ", level=" + this.f7924c + "]";
    }
}