package com.senseplay.sdk.model.device;

/* loaded from: classes2.dex */
public class DeviceUser {
    private int code;
    private String errorMsg;
    private boolean isBind = false;
    private boolean isOwner = false;

    public int getCode() {
        return this.code;
    }

    public void setCode(int i) {
        this.code = i;
    }

    public String getErrorMsg() {
        return this.errorMsg;
    }

    public void setErrorMsg(String str) {
        this.errorMsg = str;
    }

    public boolean isBind() {
        return this.isBind;
    }

    public void setBind(boolean z) {
        this.isBind = z;
    }

    public boolean isOwner() {
        return this.isOwner;
    }

    public void setOwner(boolean z) {
        this.isOwner = z;
    }
}
