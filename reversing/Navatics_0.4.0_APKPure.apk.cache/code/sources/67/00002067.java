package com.tencent.wxop.stat;

/* loaded from: classes2.dex */
public class StatSpecifyReportedInfo {

    /* renamed from: a */
    private String f7947a = null;

    /* renamed from: b */
    private String f7948b = null;

    /* renamed from: c */
    private String f7949c = null;

    /* renamed from: d */
    private boolean f7950d = false;

    /* renamed from: e */
    private boolean f7951e = false;

    public String getAppKey() {
        return this.f7947a;
    }

    public String getInstallChannel() {
        return this.f7948b;
    }

    public String getVersion() {
        return this.f7949c;
    }

    public boolean isImportant() {
        return this.f7951e;
    }

    public boolean isSendImmediately() {
        return this.f7950d;
    }

    public void setAppKey(String str) {
        this.f7947a = str;
    }

    public void setImportant(boolean z) {
        this.f7951e = z;
    }

    public void setInstallChannel(String str) {
        this.f7948b = str;
    }

    public void setSendImmediately(boolean z) {
        this.f7950d = z;
    }

    public void setVersion(String str) {
        this.f7949c = str;
    }

    public String toString() {
        return "StatSpecifyReportedInfo [appKey=" + this.f7947a + ", installChannel=" + this.f7948b + ", version=" + this.f7949c + ", sendImmediately=" + this.f7950d + ", isImportant=" + this.f7951e + "]";
    }
}