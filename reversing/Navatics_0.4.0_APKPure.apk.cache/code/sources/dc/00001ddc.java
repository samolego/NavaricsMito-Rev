package com.senseplay.sdk.model.device;

/* loaded from: classes2.dex */
public class DeviceInfo {
    private int firmwareVersion;
    private String firmwareVersionStr;
    private int hardwareVersion;
    private String hardwareVersionStr;
    private int manufacturerID;
    private int modelID;
    public int version;
    private String category = "";
    private String serialNo = "";
    private String linkID = "";
    private String manufactureDate = "";

    public String getCategory() {
        return this.category;
    }

    public void setCategory(String str) {
        this.category = str;
    }

    public int getManufacturerID() {
        return this.manufacturerID;
    }

    public void setManufacturerID(int i) {
        this.manufacturerID = i;
    }

    public int getModelID() {
        return this.modelID;
    }

    public void setModelID(int i) {
        this.modelID = i;
    }

    public String getSerialNo() {
        return this.serialNo;
    }

    public void setSerialNo(String str) {
        this.serialNo = str;
    }

    public String getLinkID() {
        return this.linkID;
    }

    public void setLinkID(String str) {
        this.linkID = str;
    }

    public String getManufactureDate() {
        return this.manufactureDate;
    }

    public void setManufactureDate(String str) {
        this.manufactureDate = str;
    }

    public int getHardwareVersion() {
        return this.hardwareVersion;
    }

    public void setHardwareVersion(int i) {
        this.hardwareVersion = i;
    }

    public int getFirmwareVersion() {
        return this.firmwareVersion;
    }

    public void setFirmwareVersion(int i) {
        this.firmwareVersion = i;
    }

    public String getHardwareVersionStr() {
        return this.hardwareVersionStr;
    }

    public void setHardwareVersionStr(String str) {
        this.hardwareVersionStr = str;
    }

    public String getFirmwareVersionStr() {
        return this.firmwareVersionStr;
    }

    public void setFirmwareVersionStr(String str) {
        this.firmwareVersionStr = str;
    }

    public int getVersion() {
        return this.version;
    }

    public void setVersion(int i) {
        this.version = i;
    }
}