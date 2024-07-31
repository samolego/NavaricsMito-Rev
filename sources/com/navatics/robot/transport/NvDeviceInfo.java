package com.navatics.robot.transport;

import java.util.List;
import java.util.Objects;

/* loaded from: classes.dex */
public class NvDeviceInfo {
    public static final int TYPE_BUOY = 2;
    public static final int TYPE_REMOTE = 3;
    public static final int TYPE_ROBOT = 1;
    public static final int TYPE_UNKNOWN = 0;
    private NvAddress address;
    private String firmwareVersion;
    private String firmwareVersionStr;
    private String hardwareVersion;
    private int mType;
    private String manufacturer;
    private String model;
    private String productionDate;
    private String serialNumber;
    private List<ProtoMeta> supportedProtoList;

    public NvDeviceInfo(int i, NvAddress nvAddress, String str, String str2, String str3, String str4, String str5, String str6, List<ProtoMeta> list) {
        this.mType = i;
        this.address = nvAddress;
        this.model = str;
        this.manufacturer = str2;
        this.serialNumber = str3;
        this.productionDate = str4;
        this.hardwareVersion = str5;
        this.firmwareVersion = str6;
        this.supportedProtoList = list;
    }

    public NvDeviceInfo(int i, NvAddress nvAddress, String str, String str2, String str3, String str4, String str5, String str6, String str7, List<ProtoMeta> list) {
        this.mType = i;
        this.address = nvAddress;
        this.model = str;
        this.manufacturer = str2;
        this.serialNumber = str3;
        this.productionDate = str4;
        this.hardwareVersion = str5;
        this.firmwareVersion = str6;
        this.supportedProtoList = list;
        this.firmwareVersionStr = str7;
    }

    public int getType() {
        return this.mType;
    }

    public NvAddress getAddress() {
        return this.address;
    }

    public String getModel() {
        return this.model;
    }

    public String getManufacturer() {
        return this.manufacturer;
    }

    public String getSerialNumber() {
        return this.serialNumber;
    }

    public String getProductionDate() {
        return this.productionDate;
    }

    public String getHardwareVersion() {
        return this.hardwareVersion;
    }

    public String getFirmwareVersion() {
        return this.firmwareVersion;
    }

    public String getFirmwareVersionStr() {
        return this.firmwareVersionStr;
    }

    public void setFirmwareVersionStr(String str) {
        this.firmwareVersionStr = str;
    }

    public List<ProtoMeta> getSupportedProtoList() {
        return this.supportedProtoList;
    }

    public boolean isValid() {
        return this.address.isValid();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof NvDeviceInfo) {
            NvDeviceInfo nvDeviceInfo = (NvDeviceInfo) obj;
            return Objects.equals(this.address, nvDeviceInfo.address) && Objects.equals(this.model, nvDeviceInfo.model) && Objects.equals(this.manufacturer, nvDeviceInfo.manufacturer) && Objects.equals(this.serialNumber, nvDeviceInfo.serialNumber) && Objects.equals(this.productionDate, nvDeviceInfo.productionDate) && Objects.equals(this.hardwareVersion, nvDeviceInfo.hardwareVersion) && Objects.equals(this.firmwareVersion, nvDeviceInfo.firmwareVersion) && Objects.equals(this.firmwareVersionStr, nvDeviceInfo.firmwareVersionStr);
        }
        return false;
    }

    public int hashCode() {
        return Objects.hash(this.address, this.model, this.manufacturer, this.serialNumber, this.productionDate, this.hardwareVersion, this.firmwareVersion, this.firmwareVersionStr);
    }

    public String toString() {
        return "NvDeviceInfo{address=" + this.address + ", model='" + this.model + "', manufacturer='" + this.manufacturer + "', serialNumber='" + this.serialNumber + "', productionDate='" + this.productionDate + "', hardwareVersion='" + this.hardwareVersion + "', firmwareVersion='" + this.firmwareVersion + "', firmwareVersion='" + this.firmwareVersionStr + "'}";
    }
}
