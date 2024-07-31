package com.senseplay.sdk.model.find;

/* loaded from: classes2.dex */
public class FindSetting {
    private String fid;
    private int is_find;
    private int is_lose;
    private int leave_messages;
    private int phone;
    private int type_category;

    public String getFid() {
        return this.fid;
    }

    public void setFid(String str) {
        this.fid = str;
    }

    public int getType_category() {
        return this.type_category;
    }

    public void setType_category(int i) {
        this.type_category = i;
    }

    public int getIs_find() {
        return this.is_find;
    }

    public void setIs_find(int i) {
        this.is_find = i;
    }

    public int getIs_lose() {
        return this.is_lose;
    }

    public void setIs_lose(int i) {
        this.is_lose = i;
    }

    public int getPhone() {
        return this.phone;
    }

    public void setPhone(int i) {
        this.phone = i;
    }

    public int getLeave_messages() {
        return this.leave_messages;
    }

    public void setLeave_messages(int i) {
        this.leave_messages = i;
    }
}