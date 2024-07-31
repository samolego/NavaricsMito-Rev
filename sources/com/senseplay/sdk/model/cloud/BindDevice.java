package com.senseplay.sdk.model.cloud;

/* loaded from: classes2.dex */
public class BindDevice {
    private String access_code;
    private String alias;
    private String did;

    /* renamed from: sn */
    private String f6832sn;
    private String type;
    private String uuid;

    public String getUuid() {
        return this.uuid;
    }

    public void setUuid(String str) {
        this.uuid = str;
    }

    public String getSn() {
        return this.f6832sn;
    }

    public void setSn(String str) {
        this.f6832sn = str;
    }

    public String getDid() {
        return this.did;
    }

    public void setDid(String str) {
        this.did = str;
    }

    public String getAccess_code() {
        return this.access_code;
    }

    public void setAccess_code(String str) {
        this.access_code = str;
    }

    public String getType() {
        return this.type;
    }

    public void setType(String str) {
        this.type = str;
    }

    public String getAlias() {
        return this.alias;
    }

    public void setAlias(String str) {
        this.alias = str;
    }
}
