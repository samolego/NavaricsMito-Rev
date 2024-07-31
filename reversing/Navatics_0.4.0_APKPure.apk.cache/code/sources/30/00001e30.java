package com.senseplay.sdk.model.sn;

/* loaded from: classes2.dex */
public class SNInfo {
    private String batch;
    private String batchNum;
    private String classId;
    private String manufacturerId;
    private String modelId;

    public String getManufacturerId() {
        return this.manufacturerId;
    }

    public void setManufacturerId(String str) {
        this.manufacturerId = str;
    }

    public String getClassId() {
        return this.classId;
    }

    public void setClassId(String str) {
        this.classId = str;
    }

    public String getModelId() {
        return this.modelId;
    }

    public void setModelId(String str) {
        this.modelId = str;
    }

    public String getBatch() {
        return this.batch;
    }

    public void setBatch(String str) {
        this.batch = str;
    }

    public String getBatchNum() {
        return this.batchNum;
    }

    public void setBatchNum(String str) {
        this.batchNum = str;
    }
}