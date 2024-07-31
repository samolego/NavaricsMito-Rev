package com.tencent.wxop.stat;

/* loaded from: classes2.dex */
public class StatSpecifyReportedInfo {

    /* renamed from: a */
    private String f7909a = null;

    /* renamed from: b */
    private String f7910b = null;

    /* renamed from: c */
    private String f7911c = null;

    /* renamed from: d */
    private boolean f7912d = false;

    /* renamed from: e */
    private boolean f7913e = false;

    public String getAppKey() {
        return this.f7909a;
    }

    public String getInstallChannel() {
        return this.f7910b;
    }

    public String getVersion() {
        return this.f7911c;
    }

    public boolean isImportant() {
        return this.f7913e;
    }

    public boolean isSendImmediately() {
        return this.f7912d;
    }

    public void setAppKey(String str) {
        this.f7909a = str;
    }

    public void setImportant(boolean z) {
        this.f7913e = z;
    }

    public void setInstallChannel(String str) {
        this.f7910b = str;
    }

    public void setSendImmediately(boolean z) {
        this.f7912d = z;
    }

    public void setVersion(String str) {
        this.f7911c = str;
    }

    public String toString() {
        return "StatSpecifyReportedInfo [appKey=" + this.f7909a + ", installChannel=" + this.f7910b + ", version=" + this.f7911c + ", sendImmediately=" + this.f7912d + ", isImportant=" + this.f7913e + "]";
    }
}
