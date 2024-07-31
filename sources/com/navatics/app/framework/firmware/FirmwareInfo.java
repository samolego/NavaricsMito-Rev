package com.navatics.app.framework.firmware;

import java.util.Date;
import java.util.Objects;

/* loaded from: classes.dex */
public class FirmwareInfo {
    Date createDateTime;
    String downUrl;
    String productName;
    Date publishTime;
    private String remark;
    Date uploadTime;
    String versionValue;

    public String getRemark() {
        return this.remark;
    }

    public Date getPublishTime() {
        return this.publishTime;
    }

    public void setPublishTime(Date date) {
        this.publishTime = date;
    }

    public void setRemark(String str) {
        this.remark = str;
    }

    public String getDownUrl() {
        return this.downUrl;
    }

    public void setDownUrl(String str) {
        this.downUrl = str;
    }

    public String getProductName() {
        return this.productName;
    }

    public void setProductName(String str) {
        this.productName = str;
    }

    public Date getCreateDateTime() {
        return this.createDateTime;
    }

    public void setCreateDateTime(Date date) {
        this.createDateTime = date;
    }

    public Date getUploadTime() {
        return this.uploadTime;
    }

    public void setUploadTime(Date date) {
        this.uploadTime = date;
    }

    public String getVersionValue() {
        return this.versionValue;
    }

    public void setVersionValue(String str) {
        this.versionValue = str;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        FirmwareInfo firmwareInfo = (FirmwareInfo) obj;
        return Objects.equals(this.productName, firmwareInfo.productName) && Objects.equals(this.createDateTime, firmwareInfo.createDateTime) && Objects.equals(this.uploadTime, firmwareInfo.uploadTime) && Objects.equals(this.versionValue, firmwareInfo.versionValue);
    }

    public int hashCode() {
        return Objects.hash(this.productName, this.createDateTime, this.uploadTime, this.versionValue);
    }

    public String toString() {
        return "FirmwareInfo{downUrl='" + this.downUrl + "', productName='" + this.productName + "', remark='" + this.remark + "', uploadTime=" + this.uploadTime + ", versionValue='" + this.versionValue + "'}";
    }
}
