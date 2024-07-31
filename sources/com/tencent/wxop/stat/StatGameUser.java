package com.tencent.wxop.stat;

/* loaded from: classes2.dex */
public class StatGameUser implements Cloneable {

    /* renamed from: a */
    private String f7884a;

    /* renamed from: b */
    private String f7885b;

    /* renamed from: c */
    private String f7886c;

    public StatGameUser() {
        this.f7884a = "";
        this.f7885b = "";
        this.f7886c = "";
    }

    public StatGameUser(String str, String str2, String str3) {
        this.f7884a = "";
        this.f7885b = "";
        this.f7886c = "";
        this.f7885b = str;
        this.f7884a = str2;
        this.f7886c = str3;
    }

    /* renamed from: clone */
    public StatGameUser m13138clone() {
        try {
            return (StatGameUser) super.clone();
        } catch (CloneNotSupportedException unused) {
            return null;
        }
    }

    public String getAccount() {
        return this.f7885b;
    }

    public String getLevel() {
        return this.f7886c;
    }

    public String getWorldName() {
        return this.f7884a;
    }

    public void setAccount(String str) {
        this.f7885b = str;
    }

    public void setLevel(String str) {
        this.f7886c = str;
    }

    public void setWorldName(String str) {
        this.f7884a = str;
    }

    public String toString() {
        return "StatGameUser [worldName=" + this.f7884a + ", account=" + this.f7885b + ", level=" + this.f7886c + "]";
    }
}
